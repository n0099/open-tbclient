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
    private static int aBz = 2097152;
    private final com.baidu.tbadk.core.util.a.a aBt;
    private com.baidu.tieba.recapp.download.http.c gQb = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.aBt = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.amX : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aBt.Eu().Ex().aEt != null) {
            this.aBt.Eu().Ex().aEt.clear();
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
    public ArrayList<BasicNameValuePair> CX() {
        return this.aBt.Eu().Ex().aEt;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void x(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aBt.Eu().Ex().aEt == null) {
                this.aBt.Eu().Ex().aEt = new ArrayList<>();
            }
            int b = b(this.aBt.Eu().Ex().aEt, basicNameValuePair.getName());
            int size = this.aBt.Eu().Ex().aEt.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.aBt.Eu().Ex().aEt.get(b).getName())) {
                    this.aBt.Eu().Ex().aEt.set(b, basicNameValuePair);
                } else {
                    this.aBt.Eu().Ex().aEt.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.aBt.Eu().Ex().aEt.add(b, basicNameValuePair);
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
        if (this.aBt.Eu().Ex().aEu == null) {
            this.aBt.Eu().Ex().aEu = new HashMap<>();
        }
        this.aBt.Eu().Ex().aEu.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jg() {
        this.gQb.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void jj() {
        if (this.gQb != null) {
            this.gQb.jj();
        }
    }

    private LinkedList<BasicNameValuePair> DF() {
        if (this.aBt != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aBt.Eu().Ex().aEy)) {
                linkedList.add(new BasicNameValuePair("sid", this.aBt.Eu().Ex().aEy));
            }
            if (!TextUtils.isEmpty(this.aBt.Eu().Ex().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aBt.Eu().Ex().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void fN(String str) {
        this.aBt.Ev().aDX = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aBt.Ev().aDX = errorData.getError_code();
                if (this.aBt.Ev().aDX == -1) {
                    this.aBt.Ev().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.aBt.Ev().aDX != 0) {
                    this.aBt.Ev().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aBt.Ev().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
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
    public String CY() {
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
            if (this.aBt.Eu().Ex().aEt == null || i2 >= this.aBt.Eu().Ex().aEt.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aBt.Eu().Ex().aEt.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aBt.Eu().Ex().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gQb.isCanceled()) {
                return null;
            }
            if (this.gQb.b(this.aBt.Eu().Ex().mUrl, this.aBt.Eu().Ex().aEt, this.aBt.Eu().Ex().aEv, 5, -1, DF()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bwi = this.gQb.bwi();
            if (bwi == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bwk = bwi.bwk();
            if (bwi == null || bwi.jr() == null || bwi.jr().size() > 0) {
            }
            this.aBt.Ev().De = bwk.responseCode;
            this.aBt.Ev().mHeader = bwk.Df;
            if (this.aBt.Ev().De != 200) {
                if (this.aBt.Ew().aDZ != null && !TextUtils.isEmpty(this.aBt.Ew().aDZ.CL)) {
                    this.aBt.Ev().aDY = this.aBt.Ew().aDZ.CL;
                } else {
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
                }
                TiebaStatic.net(this.aBt);
                return null;
            } else if (this.gQb.isCanceled()) {
                return null;
            } else {
                str = new String(bwk.Dg, IoUtils.UTF_8);
                try {
                    if (this.aBt.Eu().Ex().mIsBaiduServer && this.aBt.Eu().Ex().aEw) {
                        fN(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.aBt.Ew().aDZ.CG;
                    aVar.mTime = this.aBt.Ew().aDZ.CJ;
                    aVar.aBO = this.aBt.Ew().aDZ.CI;
                    aVar.aBN = 1;
                    aa.a(aVar);
                    aa.aBM.set(this.aBt.Ew().aDZ.CI);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aBt.Ev().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aBt.Ev().De = -15;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aBt.Ev().De = -12;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aBt.Ev().De = -13;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aBt);
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
    public byte[] CZ() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aBt.Eu().Ex().aEt != null && this.aBt.Eu().Ex().aEt.size() > 0 && !this.aBt.Eu().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aBt.Eu().Ex().mUrl);
                if (this.aBt.Eu().Ex().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aBt.Eu().Ex().mUrl.endsWith("?") && !this.aBt.Eu().Ex().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.aBt.Eu().Ex().aEt.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.aBt.Eu().Ex().aEt.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ao.bx(this.aBt.Eu().Ex().aEt.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aBt.Eu().Ex().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aBt.Eu().Ex().aEv || this.aBt.Eu().Ex().mIsBDImage) && !this.aBt.Eu().mIsFromCDN) {
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
        if (this.gQb.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gQb.b(str, z, 5, 100, -1, -1, DF());
        com.baidu.tieba.recapp.download.http.g bwi = this.gQb.bwi();
        if (bwi == null) {
            return null;
        }
        iVar = bwi.bwk();
        if (bwi != null) {
            try {
                if (bwi.jr() == null || bwi.jr().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aBt.Ev().De = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -12;
                TiebaStatic.net(this.aBt);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -13;
                TiebaStatic.net(this.aBt);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aBt);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ != null ? this.aBt.Ew().aDZ.CI : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aBt.Ev().De = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aBt);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.aBt.Ev().De = iVar.responseCode;
        if (this.aBt.Ev().De != 200) {
            this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.aBt.Ew().aDZ != null && !TextUtils.isEmpty(this.aBt.Ew().aDZ.CL)) {
                this.aBt.Ev().aDY = this.aBt.Ew().aDZ.CL;
            } else {
                this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
            }
            TiebaStatic.net(this.aBt);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aBz) {
                    this.aBt.Ev().De = -11;
                    TiebaStatic.net(this.aBt);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.NM().gb(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aBt.Eu().Ex().mUrl + "], size:" + i2);
                            this.aBt.Ev().De = -16;
                            TiebaStatic.net(this.aBt);
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
        aVar.mSize = this.aBt.Ew().aDZ.CG;
        aVar.mTime = new Date().getTime() - j;
        aVar.aBO = this.aBt.Ew().aDZ.CI;
        aVar.aBN = 2;
        aa.a(aVar);
        aa.aBM.set(this.aBt.Ew().aDZ.CI);
        TiebaStatic.net(this.aBt);
        bArr = iVar == null ? iVar.Dg : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Da() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] CZ = CZ();
        if (CZ == null || this.aBt.Ev().De != 200) {
            return null;
        }
        try {
            this.aBt.Eu().Ex().aEx = TextUtils.isEmpty(this.aBt.Eu().Ex().aEx) ? "UTF-8" : this.aBt.Eu().Ex().aEx;
            str = new String(CZ, 0, CZ.length, this.aBt.Eu().Ex().aEx);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            fN(str);
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
    public String Db() {
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
            if (this.aBt.Eu().Ex().aEt == null || i2 >= this.aBt.Eu().Ex().aEt.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aBt.Eu().Ex().aEt.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aBt.Eu().Ex().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            x("sign", s.bC(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gQb.isCanceled()) {
                return null;
            }
            if (this.gQb.b(this.aBt.Eu().Ex().mUrl, this.aBt.Eu().Ex().aEt, this.aBt.Eu().Ex().aEv, 5, -1, DF()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bwi = this.gQb.bwi();
            if (bwi == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bwk = bwi.bwk();
            if (bwi == null || bwi.jr() == null || bwi.jr().size() > 0) {
            }
            this.aBt.Ev().De = bwk.responseCode;
            this.aBt.Ev().mHeader = bwk.Df;
            if (this.aBt.Ev().De != 200) {
                if (this.aBt.Ew().aDZ != null && !TextUtils.isEmpty(this.aBt.Ew().aDZ.CL)) {
                    this.aBt.Ev().aDY = this.aBt.Ew().aDZ.CL;
                } else {
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI);
                }
                TiebaStatic.net(this.aBt);
                return null;
            } else if (this.gQb.isCanceled()) {
                return null;
            } else {
                str = new String(bwk.Dg, IoUtils.UTF_8);
                try {
                    if (this.aBt.Eu().Ex().mIsBaiduServer && this.aBt.Eu().Ex().aEw) {
                        fN(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.aBt.Ew().aDZ.CG;
                    aVar.mTime = this.aBt.Ew().aDZ.CJ;
                    aVar.aBO = this.aBt.Ew().aDZ.CI;
                    aVar.aBN = 1;
                    aa.a(aVar);
                    aa.aBM.set(this.aBt.Ew().aDZ.CI);
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.aBt.Ev().aDY = String.valueOf(this.aBt.Ev().De) + "|retryCount:" + (this.aBt.Ew().aDZ == null ? -1 : this.aBt.Ew().aDZ.CI) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aBt.Ev().De = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aBt.Ev().De = -15;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aBt.Ev().De = -12;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aBt.Ev().De = -13;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aBt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aBt.Ev().De = -10;
                    this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aBt);
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
            if (this.gQb.isCanceled()) {
                return false;
            }
            return this.gQb.a(this.aBt.Eu().Ex().mUrl, (z ? new File(str) : l.fk(str)).getAbsolutePath(), false, i2, i3, -1, -1, DF(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int aBB = 0;
                int aBC = 0;
                int aBD = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.aBB = i5 / 50;
                    }
                    this.aBC += i4 - this.aBD;
                    this.aBD = i4;
                    if (handler != null) {
                        if (this.aBC > this.aBB || i4 == i5) {
                            this.aBC = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aBt.Ev().De = -10;
            this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aBt.Ev().De = -15;
            this.aBt.Ev().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aBt);
        }
    }
}
