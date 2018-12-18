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
    private static int aAW = 2097152;
    private final com.baidu.tbadk.core.util.a.a aAQ;
    private com.baidu.tieba.recapp.download.http.c gMf = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.aAQ = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.amD : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aAQ.Eh().Ek().aDP != null) {
            this.aAQ.Eh().Ek().aDP.clear();
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
    public ArrayList<BasicNameValuePair> CK() {
        return this.aAQ.Eh().Ek().aDP;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aAQ.Eh().Ek().aDP == null) {
                this.aAQ.Eh().Ek().aDP = new ArrayList<>();
            }
            int b = b(this.aAQ.Eh().Ek().aDP, basicNameValuePair.getName());
            int size = this.aAQ.Eh().Ek().aDP.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.aAQ.Eh().Ek().aDP.get(b).getName())) {
                    this.aAQ.Eh().Ek().aDP.set(b, basicNameValuePair);
                } else {
                    this.aAQ.Eh().Ek().aDP.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.aAQ.Eh().Ek().aDP.add(b, basicNameValuePair);
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
        if (this.aAQ.Eh().Ek().aDQ == null) {
            this.aAQ.Eh().Ek().aDQ = new HashMap<>();
        }
        this.aAQ.Eh().Ek().aDQ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jg() {
        this.gMf.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jj() {
        if (this.gMf != null) {
            this.gMf.jj();
        }
    }

    private LinkedList<BasicNameValuePair> Ds() {
        if (this.aAQ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aAQ.Eh().Ek().aDU)) {
                linkedList.add(new BasicNameValuePair("sid", this.aAQ.Eh().Ek().aDU));
            }
            if (!TextUtils.isEmpty(this.aAQ.Eh().Ek().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aAQ.Eh().Ek().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void fA(String str) {
        this.aAQ.Ei().aDt = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aAQ.Ei().aDt = errorData.getError_code();
                if (this.aAQ.Ei().aDt == -1) {
                    this.aAQ.Ei().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.aAQ.Ei().aDt != 0) {
                    this.aAQ.Ei().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aAQ.Ei().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
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
    public String CL() {
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
            if (this.aAQ.Eh().Ek().aDP == null || i2 >= this.aAQ.Eh().Ek().aDP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aAQ.Eh().Ek().aDP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aAQ.Eh().Ek().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gMf.isCanceled()) {
                return null;
            }
            if (this.gMf.b(this.aAQ.Eh().Ek().mUrl, this.aAQ.Eh().Ek().aDP, this.aAQ.Eh().Ek().aDR, 5, -1, Ds()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g buN = this.gMf.buN();
            if (buN == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i buP = buN.buP();
            if (buN == null || buN.jr() == null || buN.jr().size() > 0) {
            }
            this.aAQ.Ei().De = buP.responseCode;
            this.aAQ.Ei().mHeader = buP.Df;
            if (this.aAQ.Ei().De != 200) {
                if (this.aAQ.Ej().aDv != null && !TextUtils.isEmpty(this.aAQ.Ej().aDv.CL)) {
                    this.aAQ.Ei().aDu = this.aAQ.Ej().aDv.CL;
                } else {
                    this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI);
                }
                TiebaStatic.net(this.aAQ);
                return null;
            } else if (this.gMf.isCanceled()) {
                return null;
            } else {
                str = new String(buP.Dg, IoUtils.UTF_8);
                try {
                    if (this.aAQ.Eh().Ek().mIsBaiduServer && this.aAQ.Eh().Ek().aDS) {
                        fA(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.aAQ.Ej().aDv.CG;
                    aVar.mTime = this.aAQ.Ej().aDv.CJ;
                    aVar.aBl = this.aAQ.Ej().aDv.CI;
                    aVar.aBk = 1;
                    aa.a(aVar);
                    aa.aBj.set(this.aAQ.Ej().aDv.CI);
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aAQ.Ei().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aAQ.Ei().De = -15;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aAQ.Ei().De = -12;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aAQ.Ei().De = -13;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aAQ.Ei().De = -10;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aAQ.Ei().De = -10;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aAQ);
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
    public byte[] CM() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aAQ.Eh().Ek().aDP != null && this.aAQ.Eh().Ek().aDP.size() > 0 && !this.aAQ.Eh().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aAQ.Eh().Ek().mUrl);
                if (this.aAQ.Eh().Ek().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aAQ.Eh().Ek().mUrl.endsWith("?") && !this.aAQ.Eh().Ek().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.aAQ.Eh().Ek().aDP.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.aAQ.Eh().Ek().aDP.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.aAQ.Eh().Ek().aDP.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aAQ.Eh().Ek().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aAQ.Eh().Ek().aDR || this.aAQ.Eh().Ek().mIsBDImage) && !this.aAQ.Eh().mIsFromCDN) {
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
        if (this.gMf.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gMf.b(str, z, 5, 100, -1, -1, Ds());
        com.baidu.tieba.recapp.download.http.g buN = this.gMf.buN();
        if (buN == null) {
            return null;
        }
        iVar = buN.buP();
        if (buN != null) {
            try {
                if (buN.jr() == null || buN.jr().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aAQ.Ei().De = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv != null ? this.aAQ.Ej().aDv.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aAQ.Ei().De = -12;
                TiebaStatic.net(this.aAQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv != null ? this.aAQ.Ej().aDv.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aAQ.Ei().De = -13;
                TiebaStatic.net(this.aAQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv != null ? this.aAQ.Ej().aDv.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aAQ.Ei().De = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aAQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv != null ? this.aAQ.Ej().aDv.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aAQ.Ei().De = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aAQ);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.aAQ.Ei().De = iVar.responseCode;
        if (this.aAQ.Ei().De != 200) {
            this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.aAQ.Ej().aDv != null && !TextUtils.isEmpty(this.aAQ.Ej().aDv.CL)) {
                this.aAQ.Ei().aDu = this.aAQ.Ej().aDv.CL;
            } else {
                this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI);
            }
            TiebaStatic.net(this.aAQ);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aAW) {
                    this.aAQ.Ei().De = -11;
                    TiebaStatic.net(this.aAQ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Nu().ga(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aAQ.Eh().Ek().mUrl + "], size:" + i2);
                            this.aAQ.Ei().De = -16;
                            TiebaStatic.net(this.aAQ);
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
        aVar.mSize = this.aAQ.Ej().aDv.CG;
        aVar.mTime = new Date().getTime() - j;
        aVar.aBl = this.aAQ.Ej().aDv.CI;
        aVar.aBk = 2;
        aa.a(aVar);
        aa.aBj.set(this.aAQ.Ej().aDv.CI);
        TiebaStatic.net(this.aAQ);
        bArr = iVar == null ? iVar.Dg : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String CN() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] CM = CM();
        if (CM == null || this.aAQ.Ei().De != 200) {
            return null;
        }
        try {
            this.aAQ.Eh().Ek().aDT = TextUtils.isEmpty(this.aAQ.Eh().Ek().aDT) ? "UTF-8" : this.aAQ.Eh().Ek().aDT;
            str = new String(CM, 0, CM.length, this.aAQ.Eh().Ek().aDT);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            fA(str);
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
    public String CO() {
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
            if (this.aAQ.Eh().Ek().aDP == null || i2 >= this.aAQ.Eh().Ek().aDP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aAQ.Eh().Ek().aDP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aAQ.Eh().Ek().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gMf.isCanceled()) {
                return null;
            }
            if (this.gMf.b(this.aAQ.Eh().Ek().mUrl, this.aAQ.Eh().Ek().aDP, this.aAQ.Eh().Ek().aDR, 5, -1, Ds()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g buN = this.gMf.buN();
            if (buN == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i buP = buN.buP();
            if (buN == null || buN.jr() == null || buN.jr().size() > 0) {
            }
            this.aAQ.Ei().De = buP.responseCode;
            this.aAQ.Ei().mHeader = buP.Df;
            if (this.aAQ.Ei().De != 200) {
                if (this.aAQ.Ej().aDv != null && !TextUtils.isEmpty(this.aAQ.Ej().aDv.CL)) {
                    this.aAQ.Ei().aDu = this.aAQ.Ej().aDv.CL;
                } else {
                    this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI);
                }
                TiebaStatic.net(this.aAQ);
                return null;
            } else if (this.gMf.isCanceled()) {
                return null;
            } else {
                str = new String(buP.Dg, IoUtils.UTF_8);
                try {
                    if (this.aAQ.Eh().Ek().mIsBaiduServer && this.aAQ.Eh().Ek().aDS) {
                        fA(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.aAQ.Ej().aDv.CG;
                    aVar.mTime = this.aAQ.Ej().aDv.CJ;
                    aVar.aBl = this.aAQ.Ej().aDv.CI;
                    aVar.aBk = 1;
                    aa.a(aVar);
                    aa.aBj.set(this.aAQ.Ej().aDv.CI);
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aAQ.Ei().aDu = String.valueOf(this.aAQ.Ei().De) + "|retryCount:" + (this.aAQ.Ej().aDv == null ? -1 : this.aAQ.Ej().aDv.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aAQ.Ei().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aAQ.Ei().De = -15;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aAQ.Ei().De = -12;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aAQ.Ei().De = -13;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aAQ.Ei().De = -10;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aAQ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aAQ.Ei().De = -10;
                    this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aAQ);
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
            if (this.gMf.isCanceled()) {
                return false;
            }
            return this.gMf.a(this.aAQ.Eh().Ek().mUrl, (z ? new File(str) : l.fb(str)).getAbsolutePath(), false, i2, i3, -1, -1, Ds(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int aAY = 0;
                int aAZ = 0;
                int aBa = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.aAY = i5 / 50;
                    }
                    this.aAZ += i4 - this.aBa;
                    this.aBa = i4;
                    if (handler != null) {
                        if (this.aAZ > this.aAY || i4 == i5) {
                            this.aAZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aAQ.Ei().De = -10;
            this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aAQ.Ei().De = -15;
            this.aAQ.Ei().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aAQ);
        }
    }
}
