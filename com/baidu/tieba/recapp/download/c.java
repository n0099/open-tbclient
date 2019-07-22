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
import com.baidu.tbadk.core.util.aq;
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
    private static int bSj = 2097152;
    private final com.baidu.tbadk.core.util.a.a bSd;
    private com.baidu.tieba.recapp.download.http.c iGu = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bSd = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aC((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bBJ : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bSd.ajE().ajH().bVe != null) {
            this.bSd.ajE().ajH().bVe.clear();
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
    public ArrayList<BasicNameValuePair> aif() {
        return this.bSd.ajE().ajH().bVe;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bSd.ajE().ajH().bVe == null) {
                this.bSd.ajE().ajH().bVe = new ArrayList<>();
            }
            int b = b(this.bSd.ajE().ajH().bVe, basicNameValuePair.getName());
            int size = this.bSd.ajE().ajH().bVe.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bSd.ajE().ajH().bVe.get(b).getName())) {
                    this.bSd.ajE().ajH().bVe.set(b, basicNameValuePair);
                } else {
                    this.bSd.ajE().ajH().bVe.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bSd.ajE().ajH().bVe.add(b, basicNameValuePair);
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
        if (this.bSd.ajE().ajH().bVf == null) {
            this.bSd.ajE().ajH().bVf = new HashMap<>();
        }
        this.bSd.ajE().ajH().bVf.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ik() {
        this.iGu.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void in() {
        if (this.iGu != null) {
            this.iGu.in();
        }
    }

    private LinkedList<BasicNameValuePair> aiN() {
        if (this.bSd != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bSd.ajE().ajH().bVj)) {
                linkedList.add(new BasicNameValuePair("sid", this.bSd.ajE().ajH().bVj));
            }
            if (!TextUtils.isEmpty(this.bSd.ajE().ajH().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bSd.ajE().ajH().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nS(String str) {
        this.bSd.ajF().bUI = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bSd.ajF().bUI = errorData.getError_code();
                if (this.bSd.ajF().bUI == -1) {
                    this.bSd.ajF().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bSd.ajF().bUI != 0) {
                    this.bSd.ajF().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bSd.ajF().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
    public String aig() {
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
            if (this.bSd.ajE().ajH().bVe == null || i2 >= this.bSd.ajE().ajH().bVe.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSd.ajE().ajH().bVe.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSd.ajE().ajH().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iGu.isCanceled()) {
                return null;
            }
            if (this.iGu.b(this.bSd.ajE().ajH().mUrl, this.bSd.ajE().ajH().bVe, this.bSd.ajE().ajH().bVg, 5, -1, aiN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g chS = this.iGu.chS();
            if (chS == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i chU = chS.chU();
            if (chS == null || chS.iw() == null || chS.iw().size() > 0) {
            }
            this.bSd.ajF().AR = chU.responseCode;
            this.bSd.ajF().mHeader = chU.AT;
            if (this.bSd.ajF().AR != 200) {
                if (this.bSd.ajG().bUK != null && !TextUtils.isEmpty(this.bSd.ajG().bUK.Az)) {
                    this.bSd.ajF().bUJ = this.bSd.ajG().bUK.Az;
                } else {
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
                }
                TiebaStatic.net(this.bSd);
                return null;
            } else if (this.iGu.isCanceled()) {
                return null;
            } else {
                str = new String(chU.AU, "utf-8");
                try {
                    if (this.bSd.ajE().ajH().mIsBaiduServer && this.bSd.ajE().ajH().bVh) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSd.ajG().bUK.Au;
                    aVar.mTime = this.bSd.ajG().bUK.Ax;
                    aVar.bSy = this.bSd.ajG().bUK.Aw;
                    aVar.bSx = 1;
                    aa.a(aVar);
                    aa.bSw.set(this.bSd.ajG().bUK.Aw);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSd.ajF().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSd.ajF().AR = -12;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSd.ajF().AR = -13;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSd.ajF().AR = -15;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSd);
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
    public byte[] aih() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bSd.ajE().ajH().bVe != null && this.bSd.ajE().ajH().bVe.size() > 0 && !this.bSd.ajE().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bSd.ajE().ajH().mUrl);
                if (this.bSd.ajE().ajH().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bSd.ajE().ajH().mUrl.endsWith("?") && !this.bSd.ajE().ajH().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bSd.ajE().ajH().bVe.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bSd.ajE().ajH().bVe.get(i).getName());
                    sb.append("=");
                    sb.append(aq.bi(this.bSd.ajE().ajH().bVe.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bSd.ajE().ajH().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bSd.ajE().ajH().bVg || this.bSd.ajE().ajH().mIsBDImage) && !this.bSd.ajE().mIsFromCDN) {
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
        if (this.iGu.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iGu.b(str, z, 5, 100, -1, -1, aiN());
        com.baidu.tieba.recapp.download.http.g chS = this.iGu.chS();
        if (chS == null) {
            return null;
        }
        iVar = chS.chU();
        if (chS != null) {
            try {
                if (chS.iw() == null || chS.iw().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bSd.ajF().AR = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSd);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSd);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -12;
                TiebaStatic.net(this.bSd);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK != null ? this.bSd.ajG().bUK.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSd.ajF().AR = -13;
                TiebaStatic.net(this.bSd);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bSd.ajF().AR = iVar.responseCode;
        if (this.bSd.ajF().AR != 200) {
            this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bSd.ajG().bUK != null && !TextUtils.isEmpty(this.bSd.ajG().bUK.Az)) {
                this.bSd.ajF().bUJ = this.bSd.ajG().bUK.Az;
            } else {
                this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
            }
            TiebaStatic.net(this.bSd);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bSj) {
                    this.bSd.ajF().AR = -11;
                    TiebaStatic.net(this.bSd);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.atw().kF(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bSd.ajE().ajH().mUrl + "], size:" + i2);
                            this.bSd.ajF().AR = -16;
                            TiebaStatic.net(this.bSd);
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
        aVar.aWr = this.bSd.ajG().bUK.Au;
        aVar.mTime = new Date().getTime() - j;
        aVar.bSy = this.bSd.ajG().bUK.Aw;
        aVar.bSx = 2;
        aa.a(aVar);
        aa.bSw.set(this.bSd.ajG().bUK.Aw);
        TiebaStatic.net(this.bSd);
        bArr = iVar == null ? iVar.AU : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aii() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] aih = aih();
        if (aih == null || this.bSd.ajF().AR != 200) {
            return null;
        }
        try {
            this.bSd.ajE().ajH().bVi = TextUtils.isEmpty(this.bSd.ajE().ajH().bVi) ? HTTP.UTF_8 : this.bSd.ajE().ajH().bVi;
            str = new String(aih, 0, aih.length, this.bSd.ajE().ajH().bVi);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nS(str);
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
    public String aij() {
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
            if (this.bSd.ajE().ajH().bVe == null || i2 >= this.bSd.ajE().ajH().bVe.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSd.ajE().ajH().bVe.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSd.ajE().ajH().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iGu.isCanceled()) {
                return null;
            }
            if (this.iGu.b(this.bSd.ajE().ajH().mUrl, this.bSd.ajE().ajH().bVe, this.bSd.ajE().ajH().bVg, 5, -1, aiN()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g chS = this.iGu.chS();
            if (chS == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i chU = chS.chU();
            if (chS == null || chS.iw() == null || chS.iw().size() > 0) {
            }
            this.bSd.ajF().AR = chU.responseCode;
            this.bSd.ajF().mHeader = chU.AT;
            if (this.bSd.ajF().AR != 200) {
                if (this.bSd.ajG().bUK != null && !TextUtils.isEmpty(this.bSd.ajG().bUK.Az)) {
                    this.bSd.ajF().bUJ = this.bSd.ajG().bUK.Az;
                } else {
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw);
                }
                TiebaStatic.net(this.bSd);
                return null;
            } else if (this.iGu.isCanceled()) {
                return null;
            } else {
                str = new String(chU.AU, "utf-8");
                try {
                    if (this.bSd.ajE().ajH().mIsBaiduServer && this.bSd.ajE().ajH().bVh) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSd.ajG().bUK.Au;
                    aVar.mTime = this.bSd.ajG().bUK.Ax;
                    aVar.bSy = this.bSd.ajG().bUK.Aw;
                    aVar.bSx = 1;
                    aa.a(aVar);
                    aa.bSw.set(this.bSd.ajG().bUK.Aw);
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSd.ajF().bUJ = String.valueOf(this.bSd.ajF().AR) + "|retryCount:" + (this.bSd.ajG().bUK == null ? -1 : this.bSd.ajG().bUK.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSd.ajF().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSd.ajF().AR = -12;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSd.ajF().AR = -13;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSd.ajF().AR = -15;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSd);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSd.ajF().AR = -10;
                    this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSd);
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
            if (this.iGu.isCanceled()) {
                return false;
            }
            return this.iGu.a(this.bSd.ajE().ajH().mUrl, (z ? new File(str) : m.nr(str)).getAbsolutePath(), false, i2, i3, -1, -1, aiN(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bSl = 0;
                int bSm = 0;
                int bSn = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bSl = i5 / 50;
                    }
                    this.bSm += i4 - this.bSn;
                    this.bSn = i4;
                    if (handler != null) {
                        if (this.bSm > this.bSl || i4 == i5) {
                            this.bSm = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bSd.ajF().AR = -10;
            this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bSd.ajF().AR = -15;
            this.bSd.ajF().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bSd);
        }
    }
}
