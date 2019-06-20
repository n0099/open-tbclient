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
import com.baidu.tieba.R;
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
    private static int bRj = 2097152;
    private final com.baidu.tbadk.core.util.a.a bRd;
    private com.baidu.tieba.recapp.download.http.c iAc = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bRd = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aB((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bAM : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bRd.aiB().aiE().bUd != null) {
            this.bRd.aiB().aiE().bUd.clear();
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
    public ArrayList<BasicNameValuePair> ahd() {
        return this.bRd.aiB().aiE().bUd;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bRd.aiB().aiE().bUd == null) {
                this.bRd.aiB().aiE().bUd = new ArrayList<>();
            }
            int b = b(this.bRd.aiB().aiE().bUd, basicNameValuePair.getName());
            int size = this.bRd.aiB().aiE().bUd.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bRd.aiB().aiE().bUd.get(b).getName())) {
                    this.bRd.aiB().aiE().bUd.set(b, basicNameValuePair);
                } else {
                    this.bRd.aiB().aiE().bUd.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bRd.aiB().aiE().bUd.add(b, basicNameValuePair);
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
        if (this.bRd.aiB().aiE().bUe == null) {
            this.bRd.aiB().aiE().bUe = new HashMap<>();
        }
        this.bRd.aiB().aiE().bUe.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ia() {
        this.iAc.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ie() {
        if (this.iAc != null) {
            this.iAc.ie();
        }
    }

    private LinkedList<BasicNameValuePair> ahL() {
        if (this.bRd != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bRd.aiB().aiE().bUi)) {
                linkedList.add(new BasicNameValuePair("sid", this.bRd.aiB().aiE().bUi));
            }
            if (!TextUtils.isEmpty(this.bRd.aiB().aiE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bRd.aiB().aiE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nG(String str) {
        this.bRd.aiC().bTH = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bRd.aiC().bTH = errorData.getError_code();
                if (this.bRd.aiC().bTH == -1) {
                    this.bRd.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bRd.aiC().bTH != 0) {
                    this.bRd.aiC().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bRd.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
    public String ahe() {
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
            if (this.bRd.aiB().aiE().bUd == null || i2 >= this.bRd.aiB().aiE().bUd.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRd.aiB().aiE().bUd.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRd.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iAc.isCanceled()) {
                return null;
            }
            if (this.iAc.b(this.bRd.aiB().aiE().mUrl, this.bRd.aiB().aiE().bUd, this.bRd.aiB().aiE().bUf, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cfb = this.iAc.cfb();
            if (cfb == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cfd = cfb.cfd();
            if (cfb == null || cfb.im() == null || cfb.im().size() > 0) {
            }
            this.bRd.aiC().AK = cfd.responseCode;
            this.bRd.aiC().mHeader = cfd.AM;
            if (this.bRd.aiC().AK != 200) {
                if (this.bRd.aiD().bTJ != null && !TextUtils.isEmpty(this.bRd.aiD().bTJ.At)) {
                    this.bRd.aiC().bTI = this.bRd.aiD().bTJ.At;
                } else {
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
                }
                TiebaStatic.net(this.bRd);
                return null;
            } else if (this.iAc.isCanceled()) {
                return null;
            } else {
                str = new String(cfd.AN, "utf-8");
                try {
                    if (this.bRd.aiB().aiE().mIsBaiduServer && this.bRd.aiB().aiE().bUg) {
                        nG(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRd.aiD().bTJ.Ao;
                    aVar.mTime = this.bRd.aiD().bTJ.Ar;
                    aVar.bRy = this.bRd.aiD().bTJ.Aq;
                    aVar.bRx = 1;
                    aa.a(aVar);
                    aa.bRw.set(this.bRd.aiD().bTJ.Aq);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRd.aiC().AK = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bRd.aiC().AK = -12;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bRd.aiC().AK = -13;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bRd.aiC().AK = -15;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRd);
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

    /* JADX WARN: Removed duplicated region for block: B:118:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0396 -> B:94:0x0397). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] ahf() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bRd.aiB().aiE().bUd != null && this.bRd.aiB().aiE().bUd.size() > 0 && !this.bRd.aiB().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bRd.aiB().aiE().mUrl);
                if (this.bRd.aiB().aiE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bRd.aiB().aiE().mUrl.endsWith("?") && !this.bRd.aiB().aiE().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bRd.aiB().aiE().bUd.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bRd.aiB().aiE().bUd.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.bRd.aiB().aiE().bUd.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bRd.aiB().aiE().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bRd.aiB().aiE().bUf || this.bRd.aiB().aiE().mIsBDImage) && !this.bRd.aiB().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            iVar = null;
        } catch (SocketException e3) {
            e = e3;
            iVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            iVar = null;
        } catch (Exception e5) {
            e = e5;
            iVar = null;
        }
        if (this.iAc.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iAc.b(str, z, 5, 100, -1, -1, ahL());
        com.baidu.tieba.recapp.download.http.g cfb = this.iAc.cfb();
        if (cfb == null) {
            return null;
        }
        iVar = cfb.cfd();
        if (cfb != null) {
            try {
                if (cfb.im() == null || cfb.im().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bRd.aiC().AK = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRd);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRd);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -12;
                TiebaStatic.net(this.bRd);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ != null ? this.bRd.aiD().bTJ.Aq : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRd.aiC().AK = -13;
                TiebaStatic.net(this.bRd);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bRd.aiC().AK = iVar.responseCode;
        if (this.bRd.aiC().AK != 200) {
            this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bRd.aiD().bTJ != null && !TextUtils.isEmpty(this.bRd.aiD().bTJ.At)) {
                this.bRd.aiC().bTI = this.bRd.aiD().bTJ.At;
            } else {
                this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
            }
            TiebaStatic.net(this.bRd);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bRj) {
                    this.bRd.aiC().AK = -11;
                    TiebaStatic.net(this.bRd);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.asp().kz(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bRd.aiB().aiE().mUrl + "], size:" + i2);
                            this.bRd.aiC().AK = -16;
                            TiebaStatic.net(this.bRd);
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
        aVar.aVH = this.bRd.aiD().bTJ.Ao;
        aVar.mTime = new Date().getTime() - j;
        aVar.bRy = this.bRd.aiD().bTJ.Aq;
        aVar.bRx = 2;
        aa.a(aVar);
        aa.bRw.set(this.bRd.aiD().bTJ.Aq);
        TiebaStatic.net(this.bRd);
        bArr = iVar == null ? iVar.AN : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ahg() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ahf = ahf();
        if (ahf == null || this.bRd.aiC().AK != 200) {
            return null;
        }
        try {
            this.bRd.aiB().aiE().bUh = TextUtils.isEmpty(this.bRd.aiB().aiE().bUh) ? HTTP.UTF_8 : this.bRd.aiB().aiE().bUh;
            str = new String(ahf, 0, ahf.length, this.bRd.aiB().aiE().bUh);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nG(str);
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
    public String ahh() {
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
            if (this.bRd.aiB().aiE().bUd == null || i2 >= this.bRd.aiB().aiE().bUd.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRd.aiB().aiE().bUd.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRd.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iAc.isCanceled()) {
                return null;
            }
            if (this.iAc.b(this.bRd.aiB().aiE().mUrl, this.bRd.aiB().aiE().bUd, this.bRd.aiB().aiE().bUf, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cfb = this.iAc.cfb();
            if (cfb == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cfd = cfb.cfd();
            if (cfb == null || cfb.im() == null || cfb.im().size() > 0) {
            }
            this.bRd.aiC().AK = cfd.responseCode;
            this.bRd.aiC().mHeader = cfd.AM;
            if (this.bRd.aiC().AK != 200) {
                if (this.bRd.aiD().bTJ != null && !TextUtils.isEmpty(this.bRd.aiD().bTJ.At)) {
                    this.bRd.aiC().bTI = this.bRd.aiD().bTJ.At;
                } else {
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq);
                }
                TiebaStatic.net(this.bRd);
                return null;
            } else if (this.iAc.isCanceled()) {
                return null;
            } else {
                str = new String(cfd.AN, "utf-8");
                try {
                    if (this.bRd.aiB().aiE().mIsBaiduServer && this.bRd.aiB().aiE().bUg) {
                        nG(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRd.aiD().bTJ.Ao;
                    aVar.mTime = this.bRd.aiD().bTJ.Ar;
                    aVar.bRy = this.bRd.aiD().bTJ.Aq;
                    aVar.bRx = 1;
                    aa.a(aVar);
                    aa.bRw.set(this.bRd.aiD().bTJ.Aq);
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRd.aiC().bTI = String.valueOf(this.bRd.aiC().AK) + "|retryCount:" + (this.bRd.aiD().bTJ == null ? -1 : this.bRd.aiD().bTJ.Aq) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRd.aiC().AK = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bRd.aiC().AK = -12;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bRd.aiC().AK = -13;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bRd.aiC().AK = -15;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRd.aiC().AK = -10;
                    this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRd);
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
            if (this.iAc.isCanceled()) {
                return false;
            }
            return this.iAc.a(this.bRd.aiB().aiE().mUrl, (z ? new File(str) : m.nf(str)).getAbsolutePath(), false, i2, i3, -1, -1, ahL(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bRl = 0;
                int bRm = 0;
                int bRn = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.bRl = i5 / 50;
                    }
                    this.bRm += i4 - this.bRn;
                    this.bRn = i4;
                    if (handler != null) {
                        if (this.bRm > this.bRl || i4 == i5) {
                            this.bRm = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bRd.aiC().AK = -10;
            this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bRd.aiC().AK = -15;
            this.bRd.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bRd);
        }
    }
}
