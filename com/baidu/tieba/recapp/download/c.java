package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.q;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import com.baidu.webkit.internal.ABTestConstants;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes3.dex */
public class c implements q {
    private static int awJ = 2097152;
    private final com.baidu.tbadk.core.util.a.a awD;
    private com.baidu.tieba.recapp.download.http.c gDO = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.awD = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.aio : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.awD.CW().CZ().azA != null) {
            this.awD.CW().CZ().azA.clear();
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
    public ArrayList<BasicNameValuePair> Bz() {
        return this.awD.CW().CZ().azA;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.awD.CW().CZ().azA == null) {
                this.awD.CW().CZ().azA = new ArrayList<>();
            }
            int b = b(this.awD.CW().CZ().azA, basicNameValuePair.getName());
            int size = this.awD.CW().CZ().azA.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.awD.CW().CZ().azA.get(b).getName())) {
                    this.awD.CW().CZ().azA.set(b, basicNameValuePair);
                } else {
                    this.awD.CW().CZ().azA.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.awD.CW().CZ().azA.add(b, basicNameValuePair);
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
        if (this.awD.CW().CZ().azB == null) {
            this.awD.CW().CZ().azB = new HashMap<>();
        }
        this.awD.CW().CZ().azB.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ji() {
        this.gDO.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jl() {
        if (this.gDO != null) {
            this.gDO.jl();
        }
    }

    private LinkedList<BasicNameValuePair> Ch() {
        if (this.awD != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.awD.CW().CZ().azF)) {
                linkedList.add(new BasicNameValuePair("sid", this.awD.CW().CZ().azF));
            }
            if (!TextUtils.isEmpty(this.awD.CW().CZ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.awD.CW().CZ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void fi(String str) {
        this.awD.CX().aze = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.awD.CX().aze = errorData.getError_code();
                if (this.awD.CX().aze == -1) {
                    this.awD.CX().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.awD.CX().aze != 0) {
                    this.awD.CX().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.awD.CX().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
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
    public String BA() {
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
            if (this.awD.CW().CZ().azA == null || i2 >= this.awD.CW().CZ().azA.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.awD.CW().CZ().azA.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.awD.CW().CZ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gDO.isCanceled()) {
                return null;
            }
            if (this.gDO.b(this.awD.CW().CZ().mUrl, this.awD.CW().CZ().azA, this.awD.CW().CZ().azC, 5, -1, Ch()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g btz = this.gDO.btz();
            if (btz == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i btB = btz.btB();
            if (btz == null || btz.jt() == null || btz.jt().size() > 0) {
            }
            this.awD.CX().Da = btB.responseCode;
            this.awD.CX().mHeader = btB.Db;
            if (this.awD.CX().Da != 200) {
                if (this.awD.CY().azg != null && !TextUtils.isEmpty(this.awD.CY().azg.CH)) {
                    this.awD.CX().azf = this.awD.CY().azg.CH;
                } else {
                    this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE);
                }
                TiebaStatic.net(this.awD);
                return null;
            } else if (this.gDO.isCanceled()) {
                return null;
            } else {
                str = new String(btB.Dc, IoUtils.UTF_8);
                try {
                    if (this.awD.CW().CZ().mIsBaiduServer && this.awD.CW().CZ().azD) {
                        fi(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.ld());
                    aVar.mSize = this.awD.CY().azg.CC;
                    aVar.mTime = this.awD.CY().azg.CF;
                    aVar.awY = this.awD.CY().azg.CE;
                    aVar.awX = 1;
                    aa.a(aVar);
                    aa.awW.set(this.awD.CY().azg.CE);
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.awD.CX().Da = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.awD.CX().Da = -15;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.awD.CX().Da = -12;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.awD.CX().Da = -13;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.awD.CX().Da = -10;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.awD.CX().Da = -10;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.awD);
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
    public byte[] BB() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.awD.CW().CZ().azA != null && this.awD.CW().CZ().azA.size() > 0 && !this.awD.CW().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.awD.CW().CZ().mUrl);
                if (this.awD.CW().CZ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.awD.CW().CZ().mUrl.endsWith("?") && !this.awD.CW().CZ().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.awD.CW().CZ().azA.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.awD.CW().CZ().azA.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.awD.CW().CZ().azA.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.awD.CW().CZ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.awD.CW().CZ().azC || this.awD.CW().CZ().mIsBDImage) && !this.awD.CW().mIsFromCDN) {
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
        if (this.gDO.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gDO.b(str, z, 5, 100, -1, -1, Ch());
        com.baidu.tieba.recapp.download.http.g btz = this.gDO.btz();
        if (btz == null) {
            return null;
        }
        iVar = btz.btB();
        if (btz != null) {
            try {
                if (btz.jt() == null || btz.jt().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.awD.CX().Da = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg != null ? this.awD.CY().azg.CE : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.awD.CX().Da = -12;
                TiebaStatic.net(this.awD);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg != null ? this.awD.CY().azg.CE : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.awD.CX().Da = -13;
                TiebaStatic.net(this.awD);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg != null ? this.awD.CY().azg.CE : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.awD.CX().Da = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.awD);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg != null ? this.awD.CY().azg.CE : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.awD.CX().Da = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.awD);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.awD.CX().Da = iVar.responseCode;
        if (this.awD.CX().Da != 200) {
            this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.awD.CY().azg != null && !TextUtils.isEmpty(this.awD.CY().azg.CH)) {
                this.awD.CX().azf = this.awD.CY().azg.CH;
            } else {
                this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE);
            }
            TiebaStatic.net(this.awD);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > awJ) {
                    this.awD.CX().Da = -11;
                    TiebaStatic.net(this.awD);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Me().fy(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.awD.CW().CZ().mUrl + "], size:" + i2);
                            this.awD.CX().Da = -16;
                            TiebaStatic.net(this.awD);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.ld());
        aVar.mSize = this.awD.CY().azg.CC;
        aVar.mTime = new Date().getTime() - j;
        aVar.awY = this.awD.CY().azg.CE;
        aVar.awX = 2;
        aa.a(aVar);
        aa.awW.set(this.awD.CY().azg.CE);
        TiebaStatic.net(this.awD);
        bArr = iVar == null ? iVar.Dc : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BC() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BB = BB();
        if (BB == null || this.awD.CX().Da != 200) {
            return null;
        }
        try {
            this.awD.CW().CZ().azE = TextUtils.isEmpty(this.awD.CW().CZ().azE) ? "UTF-8" : this.awD.CW().CZ().azE;
            str = new String(BB, 0, BB.length, this.awD.CW().CZ().azE);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            fi(str);
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
    public String BD() {
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
            if (this.awD.CW().CZ().azA == null || i2 >= this.awD.CW().CZ().azA.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.awD.CW().CZ().azA.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.awD.CW().CZ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gDO.isCanceled()) {
                return null;
            }
            if (this.gDO.b(this.awD.CW().CZ().mUrl, this.awD.CW().CZ().azA, this.awD.CW().CZ().azC, 5, -1, Ch()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g btz = this.gDO.btz();
            if (btz == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i btB = btz.btB();
            if (btz == null || btz.jt() == null || btz.jt().size() > 0) {
            }
            this.awD.CX().Da = btB.responseCode;
            this.awD.CX().mHeader = btB.Db;
            if (this.awD.CX().Da != 200) {
                if (this.awD.CY().azg != null && !TextUtils.isEmpty(this.awD.CY().azg.CH)) {
                    this.awD.CX().azf = this.awD.CY().azg.CH;
                } else {
                    this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE);
                }
                TiebaStatic.net(this.awD);
                return null;
            } else if (this.gDO.isCanceled()) {
                return null;
            } else {
                str = new String(btB.Dc, IoUtils.UTF_8);
                try {
                    if (this.awD.CW().CZ().mIsBaiduServer && this.awD.CW().CZ().azD) {
                        fi(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.ld());
                    aVar.mSize = this.awD.CY().azg.CC;
                    aVar.mTime = this.awD.CY().azg.CF;
                    aVar.awY = this.awD.CY().azg.CE;
                    aVar.awX = 1;
                    aa.a(aVar);
                    aa.awW.set(this.awD.CY().azg.CE);
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.awD.CX().azf = String.valueOf(this.awD.CX().Da) + "|retryCount:" + (this.awD.CY().azg == null ? -1 : this.awD.CY().azg.CE) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.awD.CX().Da = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.awD.CX().Da = -15;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.awD.CX().Da = -12;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.awD.CX().Da = -13;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.awD.CX().Da = -10;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.awD);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.awD.CX().Da = -10;
                    this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.awD);
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
            if (this.gDO.isCanceled()) {
                return false;
            }
            return this.gDO.a(this.awD.CW().CZ().mUrl, (z ? new File(str) : l.eJ(str)).getAbsolutePath(), false, i2, i3, -1, -1, Ch(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int awL = 0;
                int awM = 0;
                int awN = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.awL = i5 / 50;
                    }
                    this.awM += i4 - this.awN;
                    this.awN = i4;
                    if (handler != null) {
                        if (this.awM > this.awL || i4 == i5) {
                            this.awM = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.awD.CX().Da = -10;
            this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.awD.CX().Da = -15;
            this.awD.CX().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.awD);
        }
    }
}
