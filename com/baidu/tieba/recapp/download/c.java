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
    private static int bJx = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJr;
    private com.baidu.tieba.recapp.download.http.c ihm = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bJr = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.btI : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJr.adC().adF().bMq != null) {
            this.bJr.adC().adF().bMq.clear();
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
    public ArrayList<BasicNameValuePair> acf() {
        return this.bJr.adC().adF().bMq;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJr.adC().adF().bMq == null) {
                this.bJr.adC().adF().bMq = new ArrayList<>();
            }
            int b = b(this.bJr.adC().adF().bMq, basicNameValuePair.getName());
            int size = this.bJr.adC().adF().bMq.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJr.adC().adF().bMq.get(b).getName())) {
                    this.bJr.adC().adF().bMq.set(b, basicNameValuePair);
                } else {
                    this.bJr.adC().adF().bMq.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJr.adC().adF().bMq.add(b, basicNameValuePair);
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
        if (this.bJr.adC().adF().bMr == null) {
            this.bJr.adC().adF().bMr = new HashMap<>();
        }
        this.bJr.adC().adF().bMr.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.ihm.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.ihm != null) {
            this.ihm.jl();
        }
    }

    private LinkedList<BasicNameValuePair> acN() {
        if (this.bJr != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJr.adC().adF().bMv)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJr.adC().adF().bMv));
            }
            if (!TextUtils.isEmpty(this.bJr.adC().adF().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJr.adC().adF().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void mz(String str) {
        this.bJr.adD().bLU = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJr.adD().bLU = errorData.getError_code();
                if (this.bJr.adD().bLU == -1) {
                    this.bJr.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJr.adD().bLU != 0) {
                    this.bJr.adD().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJr.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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
    public String acg() {
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
            if (this.bJr.adC().adF().bMq == null || i2 >= this.bJr.adC().adF().bMq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJr.adC().adF().bMq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJr.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihm.isCanceled()) {
                return null;
            }
            if (this.ihm.b(this.bJr.adC().adF().mUrl, this.bJr.adC().adF().bMq, this.bJr.adC().adF().bMs, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWU = this.ihm.bWU();
            if (bWU == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWW = bWU.bWW();
            if (bWU == null || bWU.jt() == null || bWU.jt().size() > 0) {
            }
            this.bJr.adD().Dd = bWW.responseCode;
            this.bJr.adD().mHeader = bWW.De;
            if (this.bJr.adD().Dd != 200) {
                if (this.bJr.adE().bLW != null && !TextUtils.isEmpty(this.bJr.adE().bLW.CK)) {
                    this.bJr.adD().bLV = this.bJr.adE().bLW.CK;
                } else {
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
                }
                TiebaStatic.net(this.bJr);
                return null;
            } else if (this.ihm.isCanceled()) {
                return null;
            } else {
                str = new String(bWW.Df, "utf-8");
                try {
                    if (this.bJr.adC().adF().mIsBaiduServer && this.bJr.adC().adF().bMt) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSR = this.bJr.adE().bLW.CF;
                    aVar.mTime = this.bJr.adE().bLW.CI;
                    aVar.bJM = this.bJr.adE().bLW.CH;
                    aVar.bJL = 1;
                    aa.a(aVar);
                    aa.bJK.set(this.bJr.adE().bLW.CH);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJr.adD().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJr.adD().Dd = -15;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJr.adD().Dd = -12;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJr.adD().Dd = -13;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJr);
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
    public byte[] ach() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bJr.adC().adF().bMq != null && this.bJr.adC().adF().bMq.size() > 0 && !this.bJr.adC().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJr.adC().adF().mUrl);
                if (this.bJr.adC().adF().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJr.adC().adF().mUrl.endsWith("?") && !this.bJr.adC().adF().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJr.adC().adF().bMq.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJr.adC().adF().bMq.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJr.adC().adF().bMq.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJr.adC().adF().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJr.adC().adF().bMs || this.bJr.adC().adF().mIsBDImage) && !this.bJr.adC().mIsFromCDN) {
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
        if (this.ihm.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ihm.b(str, z, 5, 100, -1, -1, acN());
        com.baidu.tieba.recapp.download.http.g bWU = this.ihm.bWU();
        if (bWU == null) {
            return null;
        }
        iVar = bWU.bWW();
        if (bWU != null) {
            try {
                if (bWU.jt() == null || bWU.jt().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJr.adD().Dd = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -12;
                TiebaStatic.net(this.bJr);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -13;
                TiebaStatic.net(this.bJr);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJr);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW != null ? this.bJr.adE().bLW.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJr.adD().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJr);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bJr.adD().Dd = iVar.responseCode;
        if (this.bJr.adD().Dd != 200) {
            this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJr.adE().bLW != null && !TextUtils.isEmpty(this.bJr.adE().bLW.CK)) {
                this.bJr.adD().bLV = this.bJr.adE().bLW.CK;
            } else {
                this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
            }
            TiebaStatic.net(this.bJr);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJx) {
                    this.bJr.adD().Dd = -11;
                    TiebaStatic.net(this.bJr);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anm().jL(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJr.adC().adF().mUrl + "], size:" + i2);
                            this.bJr.adD().Dd = -16;
                            TiebaStatic.net(this.bJr);
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
        aVar.aSR = this.bJr.adE().bLW.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJM = this.bJr.adE().bLW.CH;
        aVar.bJL = 2;
        aa.a(aVar);
        aa.bJK.set(this.bJr.adE().bLW.CH);
        TiebaStatic.net(this.bJr);
        bArr = iVar == null ? iVar.Df : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aci() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ach = ach();
        if (ach == null || this.bJr.adD().Dd != 200) {
            return null;
        }
        try {
            this.bJr.adC().adF().bMu = TextUtils.isEmpty(this.bJr.adC().adF().bMu) ? HTTP.UTF_8 : this.bJr.adC().adF().bMu;
            str = new String(ach, 0, ach.length, this.bJr.adC().adF().bMu);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            mz(str);
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
            if (this.bJr.adC().adF().bMq == null || i2 >= this.bJr.adC().adF().bMq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJr.adC().adF().bMq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJr.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihm.isCanceled()) {
                return null;
            }
            if (this.ihm.b(this.bJr.adC().adF().mUrl, this.bJr.adC().adF().bMq, this.bJr.adC().adF().bMs, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWU = this.ihm.bWU();
            if (bWU == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWW = bWU.bWW();
            if (bWU == null || bWU.jt() == null || bWU.jt().size() > 0) {
            }
            this.bJr.adD().Dd = bWW.responseCode;
            this.bJr.adD().mHeader = bWW.De;
            if (this.bJr.adD().Dd != 200) {
                if (this.bJr.adE().bLW != null && !TextUtils.isEmpty(this.bJr.adE().bLW.CK)) {
                    this.bJr.adD().bLV = this.bJr.adE().bLW.CK;
                } else {
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH);
                }
                TiebaStatic.net(this.bJr);
                return null;
            } else if (this.ihm.isCanceled()) {
                return null;
            } else {
                str = new String(bWW.Df, "utf-8");
                try {
                    if (this.bJr.adC().adF().mIsBaiduServer && this.bJr.adC().adF().bMt) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSR = this.bJr.adE().bLW.CF;
                    aVar.mTime = this.bJr.adE().bLW.CI;
                    aVar.bJM = this.bJr.adE().bLW.CH;
                    aVar.bJL = 1;
                    aa.a(aVar);
                    aa.bJK.set(this.bJr.adE().bLW.CH);
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJr.adD().bLV = String.valueOf(this.bJr.adD().Dd) + "|retryCount:" + (this.bJr.adE().bLW == null ? -1 : this.bJr.adE().bLW.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJr.adD().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJr.adD().Dd = -15;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJr.adD().Dd = -12;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJr.adD().Dd = -13;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJr);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJr.adD().Dd = -10;
                    this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJr);
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
            if (this.ihm.isCanceled()) {
                return false;
            }
            return this.ihm.a(this.bJr.adC().adF().mUrl, (z ? new File(str) : m.lY(str)).getAbsolutePath(), false, i2, i3, -1, -1, acN(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bJz = 0;
                int bJA = 0;
                int bJB = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bJz = i5 / 50;
                    }
                    this.bJA += i4 - this.bJB;
                    this.bJB = i4;
                    if (handler != null) {
                        if (this.bJA > this.bJz || i4 == i5) {
                            this.bJA = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bJr.adD().Dd = -10;
            this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bJr.adD().Dd = -15;
            this.bJr.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bJr);
        }
    }
}
