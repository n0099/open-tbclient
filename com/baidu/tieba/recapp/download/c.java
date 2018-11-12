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
    private static int axw = 2097152;
    private final com.baidu.tbadk.core.util.a.a axq;
    private com.baidu.tieba.recapp.download.http.c gFp = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.axq = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.ajb : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.axq.Dd().Dg().aAp != null) {
            this.axq.Dd().Dg().aAp.clear();
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
    public ArrayList<BasicNameValuePair> BG() {
        return this.axq.Dd().Dg().aAp;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.axq.Dd().Dg().aAp == null) {
                this.axq.Dd().Dg().aAp = new ArrayList<>();
            }
            int b = b(this.axq.Dd().Dg().aAp, basicNameValuePair.getName());
            int size = this.axq.Dd().Dg().aAp.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.axq.Dd().Dg().aAp.get(b).getName())) {
                    this.axq.Dd().Dg().aAp.set(b, basicNameValuePair);
                } else {
                    this.axq.Dd().Dg().aAp.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.axq.Dd().Dg().aAp.add(b, basicNameValuePair);
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
        if (this.axq.Dd().Dg().aAq == null) {
            this.axq.Dd().Dg().aAq = new HashMap<>();
        }
        this.axq.Dd().Dg().aAq.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jg() {
        this.gFp.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jj() {
        if (this.gFp != null) {
            this.gFp.jj();
        }
    }

    private LinkedList<BasicNameValuePair> Co() {
        if (this.axq != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.axq.Dd().Dg().aAu)) {
                linkedList.add(new BasicNameValuePair("sid", this.axq.Dd().Dg().aAu));
            }
            if (!TextUtils.isEmpty(this.axq.Dd().Dg().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.axq.Dd().Dg().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void fi(String str) {
        this.axq.De().azT = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.axq.De().azT = errorData.getError_code();
                if (this.axq.De().azT == -1) {
                    this.axq.De().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.axq.De().azT != 0) {
                    this.axq.De().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.axq.De().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
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
    public String BH() {
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
            if (this.axq.Dd().Dg().aAp == null || i2 >= this.axq.Dd().Dg().aAp.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.axq.Dd().Dg().aAp.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.axq.Dd().Dg().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gFp.isCanceled()) {
                return null;
            }
            if (this.gFp.b(this.axq.Dd().Dg().mUrl, this.axq.Dd().Dg().aAp, this.axq.Dd().Dg().aAr, 5, -1, Co()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bsV = this.gFp.bsV();
            if (bsV == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bsX = bsV.bsX();
            if (bsV == null || bsV.jr() == null || bsV.jr().size() > 0) {
            }
            this.axq.De().De = bsX.responseCode;
            this.axq.De().mHeader = bsX.Df;
            if (this.axq.De().De != 200) {
                if (this.axq.Df().azV != null && !TextUtils.isEmpty(this.axq.Df().azV.CL)) {
                    this.axq.De().azU = this.axq.Df().azV.CL;
                } else {
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
                }
                TiebaStatic.net(this.axq);
                return null;
            } else if (this.gFp.isCanceled()) {
                return null;
            } else {
                str = new String(bsX.Dg, IoUtils.UTF_8);
                try {
                    if (this.axq.Dd().Dg().mIsBaiduServer && this.axq.Dd().Dg().aAs) {
                        fi(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.lb());
                    aVar.mSize = this.axq.Df().azV.CG;
                    aVar.mTime = this.axq.Df().azV.CJ;
                    aVar.axL = this.axq.Df().azV.CI;
                    aVar.axK = 1;
                    aa.a(aVar);
                    aa.axJ.set(this.axq.Df().azV.CI);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.axq.De().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.axq.De().De = -15;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.axq.De().De = -12;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.axq.De().De = -13;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.axq);
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
    public byte[] BI() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.axq.Dd().Dg().aAp != null && this.axq.Dd().Dg().aAp.size() > 0 && !this.axq.Dd().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.axq.Dd().Dg().mUrl);
                if (this.axq.Dd().Dg().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.axq.Dd().Dg().mUrl.endsWith("?") && !this.axq.Dd().Dg().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.axq.Dd().Dg().aAp.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.axq.Dd().Dg().aAp.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.axq.Dd().Dg().aAp.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.axq.Dd().Dg().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.axq.Dd().Dg().aAr || this.axq.Dd().Dg().mIsBDImage) && !this.axq.Dd().mIsFromCDN) {
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
        if (this.gFp.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gFp.b(str, z, 5, 100, -1, -1, Co());
        com.baidu.tieba.recapp.download.http.g bsV = this.gFp.bsV();
        if (bsV == null) {
            return null;
        }
        iVar = bsV.bsX();
        if (bsV != null) {
            try {
                if (bsV.jr() == null || bsV.jr().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.axq.De().De = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -12;
                TiebaStatic.net(this.axq);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -13;
                TiebaStatic.net(this.axq);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.axq);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV != null ? this.axq.Df().azV.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.axq.De().De = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.axq);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.axq.De().De = iVar.responseCode;
        if (this.axq.De().De != 200) {
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.axq.Df().azV != null && !TextUtils.isEmpty(this.axq.Df().azV.CL)) {
                this.axq.De().azU = this.axq.Df().azV.CL;
            } else {
                this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
            }
            TiebaStatic.net(this.axq);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > axw) {
                    this.axq.De().De = -11;
                    TiebaStatic.net(this.axq);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mq().fM(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.axq.Dd().Dg().mUrl + "], size:" + i2);
                            this.axq.De().De = -16;
                            TiebaStatic.net(this.axq);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.lb());
        aVar.mSize = this.axq.Df().azV.CG;
        aVar.mTime = new Date().getTime() - j;
        aVar.axL = this.axq.Df().azV.CI;
        aVar.axK = 2;
        aa.a(aVar);
        aa.axJ.set(this.axq.Df().azV.CI);
        TiebaStatic.net(this.axq);
        bArr = iVar == null ? iVar.Dg : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String BJ() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] BI = BI();
        if (BI == null || this.axq.De().De != 200) {
            return null;
        }
        try {
            this.axq.Dd().Dg().aAt = TextUtils.isEmpty(this.axq.Dd().Dg().aAt) ? "UTF-8" : this.axq.Dd().Dg().aAt;
            str = new String(BI, 0, BI.length, this.axq.Dd().Dg().aAt);
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
    public String BK() {
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
            if (this.axq.Dd().Dg().aAp == null || i2 >= this.axq.Dd().Dg().aAp.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.axq.Dd().Dg().aAp.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.axq.Dd().Dg().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gFp.isCanceled()) {
                return null;
            }
            if (this.gFp.b(this.axq.Dd().Dg().mUrl, this.axq.Dd().Dg().aAp, this.axq.Dd().Dg().aAr, 5, -1, Co()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bsV = this.gFp.bsV();
            if (bsV == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bsX = bsV.bsX();
            if (bsV == null || bsV.jr() == null || bsV.jr().size() > 0) {
            }
            this.axq.De().De = bsX.responseCode;
            this.axq.De().mHeader = bsX.Df;
            if (this.axq.De().De != 200) {
                if (this.axq.Df().azV != null && !TextUtils.isEmpty(this.axq.Df().azV.CL)) {
                    this.axq.De().azU = this.axq.Df().azV.CL;
                } else {
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI);
                }
                TiebaStatic.net(this.axq);
                return null;
            } else if (this.gFp.isCanceled()) {
                return null;
            } else {
                str = new String(bsX.Dg, IoUtils.UTF_8);
                try {
                    if (this.axq.Dd().Dg().mIsBaiduServer && this.axq.Dd().Dg().aAs) {
                        fi(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.lb());
                    aVar.mSize = this.axq.Df().azV.CG;
                    aVar.mTime = this.axq.Df().azV.CJ;
                    aVar.axL = this.axq.Df().azV.CI;
                    aVar.axK = 1;
                    aa.a(aVar);
                    aa.axJ.set(this.axq.Df().azV.CI);
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.axq.De().azU = String.valueOf(this.axq.De().De) + "|retryCount:" + (this.axq.Df().azV == null ? -1 : this.axq.Df().azV.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.axq.De().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.axq.De().De = -15;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.axq.De().De = -12;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.axq.De().De = -13;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.axq);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.axq.De().De = -10;
                    this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.axq);
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
            if (this.gFp.isCanceled()) {
                return false;
            }
            return this.gFp.a(this.axq.Dd().Dg().mUrl, (z ? new File(str) : l.eJ(str)).getAbsolutePath(), false, i2, i3, -1, -1, Co(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int axy = 0;
                int axz = 0;
                int axA = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.axy = i5 / 50;
                    }
                    this.axz += i4 - this.axA;
                    this.axA = i4;
                    if (handler != null) {
                        if (this.axz > this.axy || i4 == i5) {
                            this.axz = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.axq.De().De = -10;
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.axq.De().De = -15;
            this.axq.De().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.axq);
        }
    }
}
