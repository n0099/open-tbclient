package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.q;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c implements q {
    private static int bJu = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJo;
    private com.baidu.tieba.recapp.download.http.c ihG = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bJo = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.btD : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJo.adF().adI().bMn != null) {
            this.bJo.adF().adI().bMn.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> aci() {
        return this.bJo.adF().adI().bMn;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJo.adF().adI().bMn == null) {
                this.bJo.adF().adI().bMn = new ArrayList<>();
            }
            int b = b(this.bJo.adF().adI().bMn, basicNameValuePair.getName());
            int size = this.bJo.adF().adI().bMn.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJo.adF().adI().bMn.get(b).getName())) {
                    this.bJo.adF().adI().bMn.set(b, basicNameValuePair);
                } else {
                    this.bJo.adF().adI().bMn.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJo.adF().adI().bMn.add(b, basicNameValuePair);
            }
        }
    }

    private int b(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void d(String str, byte[] bArr) {
        if (this.bJo.adF().adI().bMo == null) {
            this.bJo.adF().adI().bMo = new HashMap<>();
        }
        this.bJo.adF().adI().bMo.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.ihG.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.ihG != null) {
            this.ihG.jl();
        }
    }

    private LinkedList<BasicNameValuePair> acQ() {
        if (this.bJo != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJo.adF().adI().bMs)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJo.adF().adI().bMs));
            }
            if (!TextUtils.isEmpty(this.bJo.adF().adI().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJo.adF().adI().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void my(String str) {
        this.bJo.adG().bLR = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJo.adG().bLR = errorData.getError_code();
                if (this.bJo.adG().bLR == -1) {
                    this.bJo.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJo.adG().bLR != 0) {
                    this.bJo.adG().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJo.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
            }
        }
    }

    private int getMode(int i) {
        switch (i) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String acj() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.bJo.adF().adI().bMn == null || i2 >= this.bJo.adF().adI().bMn.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJo.adF().adI().bMn.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJo.adF().adI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x(SapiUtils.KEY_QR_LOGIN_SIGN, s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihG.isCanceled()) {
                return null;
            }
            if (this.ihG.b(this.bJo.adF().adI().mUrl, this.bJo.adF().adI().bMn, this.bJo.adF().adI().bMp, 5, -1, acQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWW = this.ihG.bWW();
            if (bWW == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWY = bWW.bWY();
            if (bWW == null || bWW.jt() == null || bWW.jt().size() > 0) {
            }
            this.bJo.adG().Dd = bWY.responseCode;
            this.bJo.adG().mHeader = bWY.De;
            if (this.bJo.adG().Dd != 200) {
                if (this.bJo.adH().bLT != null && !TextUtils.isEmpty(this.bJo.adH().bLT.CK)) {
                    this.bJo.adG().bLS = this.bJo.adH().bLT.CK;
                } else {
                    this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH);
                }
                TiebaStatic.net(this.bJo);
                return null;
            } else if (this.ihG.isCanceled()) {
                return null;
            } else {
                str = new String(bWY.Df, "utf-8");
                try {
                    if (this.bJo.adF().adI().mIsBaiduServer && this.bJo.adF().adI().bMq) {
                        my(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSN = this.bJo.adH().bLT.CF;
                    aVar.mTime = this.bJo.adH().bLT.CI;
                    aVar.bJJ = this.bJo.adH().bLT.CH;
                    aVar.bJI = 1;
                    aa.a(aVar);
                    aa.bJH.set(this.bJo.adH().bLT.CH);
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJo.adG().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJo.adG().Dd = -15;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJo.adG().Dd = -12;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJo.adG().Dd = -13;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJo.adG().Dd = -10;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJo.adG().Dd = -10;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0396 -> B:94:0x0397). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ack() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bJo.adF().adI().bMn != null && this.bJo.adF().adI().bMn.size() > 0 && !this.bJo.adF().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJo.adF().adI().mUrl);
                if (this.bJo.adF().adI().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJo.adF().adI().mUrl.endsWith("?") && !this.bJo.adF().adI().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJo.adF().adI().bMn.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJo.adF().adI().bMn.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJo.adF().adI().bMn.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJo.adF().adI().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJo.adF().adI().bMp || this.bJo.adF().adI().mIsBDImage) && !this.bJo.adF().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar2 = null;
        } catch (SocketException e2) {
            e = e2;
            iVar = null;
        } catch (SocketTimeoutException e3) {
            e = e3;
            iVar = null;
        } catch (Exception e4) {
            e = e4;
            iVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            iVar = null;
        }
        if (this.ihG.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ihG.b(str, z, 5, 100, -1, -1, acQ());
        com.baidu.tieba.recapp.download.http.g bWW = this.ihG.bWW();
        if (bWW == null) {
            return null;
        }
        iVar = bWW.bWY();
        if (bWW != null) {
            try {
                if (bWW.jt() == null || bWW.jt().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJo.adG().Dd = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT != null ? this.bJo.adH().bLT.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJo.adG().Dd = -12;
                TiebaStatic.net(this.bJo);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT != null ? this.bJo.adH().bLT.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJo.adG().Dd = -13;
                TiebaStatic.net(this.bJo);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT != null ? this.bJo.adH().bLT.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJo.adG().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJo);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT != null ? this.bJo.adH().bLT.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJo.adG().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJo);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bJo.adG().Dd = iVar.responseCode;
        if (this.bJo.adG().Dd != 200) {
            this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJo.adH().bLT != null && !TextUtils.isEmpty(this.bJo.adH().bLT.CK)) {
                this.bJo.adG().bLS = this.bJo.adH().bLT.CK;
            } else {
                this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH);
            }
            TiebaStatic.net(this.bJo);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJu) {
                    this.bJo.adG().Dd = -11;
                    TiebaStatic.net(this.bJo);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anq().jM(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJo.adF().adI().mUrl + "], size:" + i2);
                            this.bJo.adG().Dd = -16;
                            TiebaStatic.net(this.bJo);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.aSN = this.bJo.adH().bLT.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJJ = this.bJo.adH().bLT.CH;
        aVar.bJI = 2;
        aa.a(aVar);
        aa.bJH.set(this.bJo.adH().bLT.CH);
        TiebaStatic.net(this.bJo);
        bArr = iVar == null ? iVar.Df : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String acl() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ack = ack();
        if (ack == null || this.bJo.adG().Dd != 200) {
            return null;
        }
        try {
            this.bJo.adF().adI().bMr = TextUtils.isEmpty(this.bJo.adF().adI().bMr) ? HTTP.UTF_8 : this.bJo.adF().adI().bMr;
            str = new String(ack, 0, ack.length, this.bJo.adF().adI().bMr);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            my(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(e2.getMessage());
            return str;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public String acm() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.bJo.adF().adI().bMn == null || i2 >= this.bJo.adF().adI().bMn.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJo.adF().adI().bMn.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJo.adF().adI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x(SapiUtils.KEY_QR_LOGIN_SIGN, s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihG.isCanceled()) {
                return null;
            }
            if (this.ihG.b(this.bJo.adF().adI().mUrl, this.bJo.adF().adI().bMn, this.bJo.adF().adI().bMp, 5, -1, acQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWW = this.ihG.bWW();
            if (bWW == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWY = bWW.bWY();
            if (bWW == null || bWW.jt() == null || bWW.jt().size() > 0) {
            }
            this.bJo.adG().Dd = bWY.responseCode;
            this.bJo.adG().mHeader = bWY.De;
            if (this.bJo.adG().Dd != 200) {
                if (this.bJo.adH().bLT != null && !TextUtils.isEmpty(this.bJo.adH().bLT.CK)) {
                    this.bJo.adG().bLS = this.bJo.adH().bLT.CK;
                } else {
                    this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH);
                }
                TiebaStatic.net(this.bJo);
                return null;
            } else if (this.ihG.isCanceled()) {
                return null;
            } else {
                str = new String(bWY.Df, "utf-8");
                try {
                    if (this.bJo.adF().adI().mIsBaiduServer && this.bJo.adF().adI().bMq) {
                        my(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSN = this.bJo.adH().bLT.CF;
                    aVar.mTime = this.bJo.adH().bLT.CI;
                    aVar.bJJ = this.bJo.adH().bLT.CH;
                    aVar.bJI = 1;
                    aa.a(aVar);
                    aa.bJH.set(this.bJo.adH().bLT.CH);
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJo.adG().bLS = String.valueOf(this.bJo.adG().Dd) + "|retryCount:" + (this.bJo.adH().bLT == null ? -1 : this.bJo.adH().bLT.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJo.adG().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJo.adG().Dd = -15;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJo.adG().Dd = -12;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJo.adG().Dd = -13;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJo.adG().Dd = -10;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJo.adG().Dd = -10;
                    this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJo);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.ihG.isCanceled()) {
                return false;
            }
            return this.ihG.a(this.bJo.adF().adI().mUrl, (z ? new File(str) : m.lX(str)).getAbsolutePath(), false, i2, i3, -1, -1, acQ(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bJw = 0;
                int bJx = 0;
                int bJy = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bJw = i5 / 50;
                    }
                    this.bJx += i4 - this.bJy;
                    this.bJy = i4;
                    if (handler != null) {
                        if (this.bJx > this.bJw || i4 == i5) {
                            this.bJx = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bJo.adG().Dd = -10;
            this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bJo.adG().Dd = -15;
            this.bJo.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bJo);
        }
    }
}
