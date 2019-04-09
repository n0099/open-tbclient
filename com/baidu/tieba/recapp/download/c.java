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
    private static int bJy = 2097152;
    private final com.baidu.tbadk.core.util.a.a bJs;
    private com.baidu.tieba.recapp.download.http.c ihn = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bJs = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.btJ : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void r(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bJs.adC().adF().bMr != null) {
            this.bJs.adC().adF().bMr.clear();
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
        return this.bJs.adC().adF().bMr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bJs.adC().adF().bMr == null) {
                this.bJs.adC().adF().bMr = new ArrayList<>();
            }
            int b = b(this.bJs.adC().adF().bMr, basicNameValuePair.getName());
            int size = this.bJs.adC().adF().bMr.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bJs.adC().adF().bMr.get(b).getName())) {
                    this.bJs.adC().adF().bMr.set(b, basicNameValuePair);
                } else {
                    this.bJs.adC().adF().bMr.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bJs.adC().adF().bMr.add(b, basicNameValuePair);
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
        if (this.bJs.adC().adF().bMs == null) {
            this.bJs.adC().adF().bMs = new HashMap<>();
        }
        this.bJs.adC().adF().bMs.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.ihn.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.ihn != null) {
            this.ihn.jl();
        }
    }

    private LinkedList<BasicNameValuePair> acN() {
        if (this.bJs != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bJs.adC().adF().bMw)) {
                linkedList.add(new BasicNameValuePair("sid", this.bJs.adC().adF().bMw));
            }
            if (!TextUtils.isEmpty(this.bJs.adC().adF().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bJs.adC().adF().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void mz(String str) {
        this.bJs.adD().bLV = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bJs.adD().bLV = errorData.getError_code();
                if (this.bJs.adD().bLV == -1) {
                    this.bJs.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.bJs.adD().bLV != 0) {
                    this.bJs.adD().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bJs.adD().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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
            if (this.bJs.adC().adF().bMr == null || i2 >= this.bJs.adC().adF().bMr.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJs.adC().adF().bMr.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJs.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihn.isCanceled()) {
                return null;
            }
            if (this.ihn.b(this.bJs.adC().adF().mUrl, this.bJs.adC().adF().bMr, this.bJs.adC().adF().bMt, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWU = this.ihn.bWU();
            if (bWU == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWW = bWU.bWW();
            if (bWU == null || bWU.jt() == null || bWU.jt().size() > 0) {
            }
            this.bJs.adD().Dd = bWW.responseCode;
            this.bJs.adD().mHeader = bWW.De;
            if (this.bJs.adD().Dd != 200) {
                if (this.bJs.adE().bLX != null && !TextUtils.isEmpty(this.bJs.adE().bLX.CK)) {
                    this.bJs.adD().bLW = this.bJs.adE().bLX.CK;
                } else {
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
                }
                TiebaStatic.net(this.bJs);
                return null;
            } else if (this.ihn.isCanceled()) {
                return null;
            } else {
                str = new String(bWW.Df, "utf-8");
                try {
                    if (this.bJs.adC().adF().mIsBaiduServer && this.bJs.adC().adF().bMu) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSS = this.bJs.adE().bLX.CF;
                    aVar.mTime = this.bJs.adE().bLX.CI;
                    aVar.bJN = this.bJs.adE().bLX.CH;
                    aVar.bJM = 1;
                    aa.a(aVar);
                    aa.bJL.set(this.bJs.adE().bLX.CH);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJs.adD().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJs.adD().Dd = -15;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJs.adD().Dd = -12;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJs.adD().Dd = -13;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJs);
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
            if (this.bJs.adC().adF().bMr != null && this.bJs.adC().adF().bMr.size() > 0 && !this.bJs.adC().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bJs.adC().adF().mUrl);
                if (this.bJs.adC().adF().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bJs.adC().adF().mUrl.endsWith("?") && !this.bJs.adC().adF().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bJs.adC().adF().bMr.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bJs.adC().adF().bMr.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bx(this.bJs.adC().adF().bMr.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bJs.adC().adF().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bJs.adC().adF().bMt || this.bJs.adC().adF().mIsBDImage) && !this.bJs.adC().mIsFromCDN) {
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
        if (this.ihn.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ihn.b(str, z, 5, 100, -1, -1, acN());
        com.baidu.tieba.recapp.download.http.g bWU = this.ihn.bWU();
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
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bJs.adD().Dd = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -12;
                TiebaStatic.net(this.bJs);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -13;
                TiebaStatic.net(this.bJs);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJs);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX != null ? this.bJs.adE().bLX.CH : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bJs.adD().Dd = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bJs);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bJs.adD().Dd = iVar.responseCode;
        if (this.bJs.adD().Dd != 200) {
            this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.bJs.adE().bLX != null && !TextUtils.isEmpty(this.bJs.adE().bLX.CK)) {
                this.bJs.adD().bLW = this.bJs.adE().bLX.CK;
            } else {
                this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
            }
            TiebaStatic.net(this.bJs);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bJy) {
                    this.bJs.adD().Dd = -11;
                    TiebaStatic.net(this.bJs);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.anm().jL(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bJs.adC().adF().mUrl + "], size:" + i2);
                            this.bJs.adD().Dd = -16;
                            TiebaStatic.net(this.bJs);
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
        aVar.aSS = this.bJs.adE().bLX.CF;
        aVar.mTime = new Date().getTime() - j;
        aVar.bJN = this.bJs.adE().bLX.CH;
        aVar.bJM = 2;
        aa.a(aVar);
        aa.bJL.set(this.bJs.adE().bLX.CH);
        TiebaStatic.net(this.bJs);
        bArr = iVar == null ? iVar.Df : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aci() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ach = ach();
        if (ach == null || this.bJs.adD().Dd != 200) {
            return null;
        }
        try {
            this.bJs.adC().adF().bMv = TextUtils.isEmpty(this.bJs.adC().adF().bMv) ? HTTP.UTF_8 : this.bJs.adC().adF().bMv;
            str = new String(ach, 0, ach.length, this.bJs.adC().adF().bMv);
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
            if (this.bJs.adC().adF().bMr == null || i2 >= this.bJs.adC().adF().bMr.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bJs.adC().adF().bMr.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bJs.adC().adF().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ihn.isCanceled()) {
                return null;
            }
            if (this.ihn.b(this.bJs.adC().adF().mUrl, this.bJs.adC().adF().bMr, this.bJs.adC().adF().bMt, 5, -1, acN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bWU = this.ihn.bWU();
            if (bWU == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bWW = bWU.bWW();
            if (bWU == null || bWU.jt() == null || bWU.jt().size() > 0) {
            }
            this.bJs.adD().Dd = bWW.responseCode;
            this.bJs.adD().mHeader = bWW.De;
            if (this.bJs.adD().Dd != 200) {
                if (this.bJs.adE().bLX != null && !TextUtils.isEmpty(this.bJs.adE().bLX.CK)) {
                    this.bJs.adD().bLW = this.bJs.adE().bLX.CK;
                } else {
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH);
                }
                TiebaStatic.net(this.bJs);
                return null;
            } else if (this.ihn.isCanceled()) {
                return null;
            } else {
                str = new String(bWW.Df, "utf-8");
                try {
                    if (this.bJs.adC().adF().mIsBaiduServer && this.bJs.adC().adF().bMu) {
                        mz(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aSS = this.bJs.adE().bLX.CF;
                    aVar.mTime = this.bJs.adE().bLX.CI;
                    aVar.bJN = this.bJs.adE().bLX.CH;
                    aVar.bJM = 1;
                    aa.a(aVar);
                    aa.bJL.set(this.bJs.adE().bLX.CH);
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.bJs.adD().bLW = String.valueOf(this.bJs.adD().Dd) + "|retryCount:" + (this.bJs.adE().bLX == null ? -1 : this.bJs.adE().bLX.CH) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bJs.adD().Dd = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.bJs.adD().Dd = -15;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.bJs.adD().Dd = -12;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.bJs.adD().Dd = -13;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bJs);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bJs.adD().Dd = -10;
                    this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bJs);
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
            if (this.ihn.isCanceled()) {
                return false;
            }
            return this.ihn.a(this.bJs.adC().adF().mUrl, (z ? new File(str) : m.lY(str)).getAbsolutePath(), false, i2, i3, -1, -1, acN(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bJA = 0;
                int bJB = 0;
                int bJC = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bJA = i5 / 50;
                    }
                    this.bJB += i4 - this.bJC;
                    this.bJC = i4;
                    if (handler != null) {
                        if (this.bJB > this.bJA || i4 == i5) {
                            this.bJB = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bJs.adD().Dd = -10;
            this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bJs.adD().Dd = -15;
            this.bJs.adD().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bJs);
        }
    }
}
