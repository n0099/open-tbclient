package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
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
    private static int bJv = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJp;
    private com.baidu.tieba.recapp.download.http.c ihA = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bJp = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.btF : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJp.adF().adI().bMo != null) {
            this.bJp.adF().adI().bMo.clear();
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
        return this.bJp.adF().adI().bMo;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJp.adF().adI().bMo == null) {
                this.bJp.adF().adI().bMo = new ArrayList<>();
            }
            int b = b(this.bJp.adF().adI().bMo, basicNameValuePair.getName());
            int size = this.bJp.adF().adI().bMo.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJp.adF().adI().bMo.get(b).getName())) {
                    this.bJp.adF().adI().bMo.set(b, basicNameValuePair);
                } else {
                    this.bJp.adF().adI().bMo.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJp.adF().adI().bMo.add(b, basicNameValuePair);
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
        if (this.bJp.adF().adI().bMp == null) {
            this.bJp.adF().adI().bMp = new HashMap<>();
        }
        this.bJp.adF().adI().bMp.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.ihA.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.ihA != null) {
            this.ihA.jl();
        }
    }

    private LinkedList<BasicNameValuePair> acQ() {
        if (this.bJp != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJp.adF().adI().bMt)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJp.adF().adI().bMt));
            }
            if (!TextUtils.isEmpty(this.bJp.adF().adI().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJp.adF().adI().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void my(String str) {
        this.bJp.adG().bLS = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJp.adG().bLS = errorData.getError_code();
                if (this.bJp.adG().bLS == -1) {
                    this.bJp.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJp.adG().bLS != 0) {
                    this.bJp.adG().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJp.adG().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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
            if (this.bJp.adF().adI().bMo == null || i2 >= this.bJp.adF().adI().bMo.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJp.adF().adI().bMo.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJp.adF().adI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihA.isCanceled()) {
                return null;
            }
            if (this.ihA.b(this.bJp.adF().adI().mUrl, this.bJp.adF().adI().bMo, this.bJp.adF().adI().bMq, 5, -1, acQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWY = this.ihA.bWY();
            if (bWY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bXa = bWY.bXa();
            if (bWY == null || bWY.jt() == null || bWY.jt().size() > 0) {
            }
            this.bJp.adG().Dd = bXa.responseCode;
            this.bJp.adG().mHeader = bXa.De;
            if (this.bJp.adG().Dd != 200) {
                if (this.bJp.adH().bLU != null && !TextUtils.isEmpty(this.bJp.adH().bLU.CK)) {
                    this.bJp.adG().bLT = this.bJp.adH().bLU.CK;
                } else {
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
                }
                TiebaStatic.net(this.bJp);
                return null;
            } else if (this.ihA.isCanceled()) {
                return null;
            } else {
                str = new String(bXa.Df, "utf-8");
                try {
                    if (this.bJp.adF().adI().mIsBaiduServer && this.bJp.adF().adI().bMr) {
                        my(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSO = this.bJp.adH().bLU.CF;
                    aVar.mTime = this.bJp.adH().bLU.CI;
                    aVar.bJK = this.bJp.adH().bLU.CH;
                    aVar.bJJ = 1;
                    aa.a(aVar);
                    aa.bJI.set(this.bJp.adH().bLU.CH);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJp.adG().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJp.adG().Dd = -15;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJp.adG().Dd = -12;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJp.adG().Dd = -13;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJp);
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
            if (this.bJp.adF().adI().bMo != null && this.bJp.adF().adI().bMo.size() > 0 && !this.bJp.adF().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJp.adF().adI().mUrl);
                if (this.bJp.adF().adI().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJp.adF().adI().mUrl.endsWith("?") && !this.bJp.adF().adI().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJp.adF().adI().bMo.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJp.adF().adI().bMo.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJp.adF().adI().bMo.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJp.adF().adI().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJp.adF().adI().bMq || this.bJp.adF().adI().mIsBDImage) && !this.bJp.adF().mIsFromCDN) {
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
        if (this.ihA.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ihA.b(str, z, 5, 100, -1, -1, acQ());
        com.baidu.tieba.recapp.download.http.g bWY = this.ihA.bWY();
        if (bWY == null) {
            return null;
        }
        iVar = bWY.bXa();
        if (bWY != null) {
            try {
                if (bWY.jt() == null || bWY.jt().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJp.adG().Dd = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -12;
                TiebaStatic.net(this.bJp);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -13;
                TiebaStatic.net(this.bJp);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJp);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU != null ? this.bJp.adH().bLU.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJp.adG().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJp);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bJp.adG().Dd = iVar.responseCode;
        if (this.bJp.adG().Dd != 200) {
            this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJp.adH().bLU != null && !TextUtils.isEmpty(this.bJp.adH().bLU.CK)) {
                this.bJp.adG().bLT = this.bJp.adH().bLU.CK;
            } else {
                this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
            }
            TiebaStatic.net(this.bJp);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJv) {
                    this.bJp.adG().Dd = -11;
                    TiebaStatic.net(this.bJp);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anp().jM(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJp.adF().adI().mUrl + "], size:" + i2);
                            this.bJp.adG().Dd = -16;
                            TiebaStatic.net(this.bJp);
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
        aVar.aSO = this.bJp.adH().bLU.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJK = this.bJp.adH().bLU.CH;
        aVar.bJJ = 2;
        aa.a(aVar);
        aa.bJI.set(this.bJp.adH().bLU.CH);
        TiebaStatic.net(this.bJp);
        bArr = iVar == null ? iVar.Df : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String acl() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ack = ack();
        if (ack == null || this.bJp.adG().Dd != 200) {
            return null;
        }
        try {
            this.bJp.adF().adI().bMs = TextUtils.isEmpty(this.bJp.adF().adI().bMs) ? HTTP.UTF_8 : this.bJp.adF().adI().bMs;
            str = new String(ack, 0, ack.length, this.bJp.adF().adI().bMs);
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
            if (this.bJp.adF().adI().bMo == null || i2 >= this.bJp.adF().adI().bMo.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJp.adF().adI().bMo.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJp.adF().adI().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihA.isCanceled()) {
                return null;
            }
            if (this.ihA.b(this.bJp.adF().adI().mUrl, this.bJp.adF().adI().bMo, this.bJp.adF().adI().bMq, 5, -1, acQ()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWY = this.ihA.bWY();
            if (bWY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bXa = bWY.bXa();
            if (bWY == null || bWY.jt() == null || bWY.jt().size() > 0) {
            }
            this.bJp.adG().Dd = bXa.responseCode;
            this.bJp.adG().mHeader = bXa.De;
            if (this.bJp.adG().Dd != 200) {
                if (this.bJp.adH().bLU != null && !TextUtils.isEmpty(this.bJp.adH().bLU.CK)) {
                    this.bJp.adG().bLT = this.bJp.adH().bLU.CK;
                } else {
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH);
                }
                TiebaStatic.net(this.bJp);
                return null;
            } else if (this.ihA.isCanceled()) {
                return null;
            } else {
                str = new String(bXa.Df, "utf-8");
                try {
                    if (this.bJp.adF().adI().mIsBaiduServer && this.bJp.adF().adI().bMr) {
                        my(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSO = this.bJp.adH().bLU.CF;
                    aVar.mTime = this.bJp.adH().bLU.CI;
                    aVar.bJK = this.bJp.adH().bLU.CH;
                    aVar.bJJ = 1;
                    aa.a(aVar);
                    aa.bJI.set(this.bJp.adH().bLU.CH);
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJp.adG().bLT = String.valueOf(this.bJp.adG().Dd) + "|retryCount:" + (this.bJp.adH().bLU == null ? -1 : this.bJp.adH().bLU.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJp.adG().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJp.adG().Dd = -15;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJp.adG().Dd = -12;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJp.adG().Dd = -13;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJp);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJp.adG().Dd = -10;
                    this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJp);
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
            if (this.ihA.isCanceled()) {
                return false;
            }
            return this.ihA.a(this.bJp.adF().adI().mUrl, (z ? new File(str) : m.lX(str)).getAbsolutePath(), false, i2, i3, -1, -1, acQ(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bJx = 0;
                int bJy = 0;
                int bJz = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bJx = i5 / 50;
                    }
                    this.bJy += i4 - this.bJz;
                    this.bJz = i4;
                    if (handler != null) {
                        if (this.bJy > this.bJx || i4 == i5) {
                            this.bJy = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bJp.adG().Dd = -10;
            this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bJp.adG().Dd = -15;
            this.bJp.adG().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bJp);
        }
    }
}
