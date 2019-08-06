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
    private static int bSp = 2097152;
    private final com.baidu.tbadk.core.util.a.a bSj;
    private com.baidu.tieba.recapp.download.http.c iHy = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bSj = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aC((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bBJ : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bSj.ajG().ajJ().bVk != null) {
            this.bSj.ajG().ajJ().bVk.clear();
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
    public ArrayList<BasicNameValuePair> aih() {
        return this.bSj.ajG().ajJ().bVk;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bSj.ajG().ajJ().bVk == null) {
                this.bSj.ajG().ajJ().bVk = new ArrayList<>();
            }
            int b = b(this.bSj.ajG().ajJ().bVk, basicNameValuePair.getName());
            int size = this.bSj.ajG().ajJ().bVk.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bSj.ajG().ajJ().bVk.get(b).getName())) {
                    this.bSj.ajG().ajJ().bVk.set(b, basicNameValuePair);
                } else {
                    this.bSj.ajG().ajJ().bVk.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bSj.ajG().ajJ().bVk.add(b, basicNameValuePair);
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
        if (this.bSj.ajG().ajJ().bVl == null) {
            this.bSj.ajG().ajJ().bVl = new HashMap<>();
        }
        this.bSj.ajG().ajJ().bVl.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ik() {
        this.iHy.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void in() {
        if (this.iHy != null) {
            this.iHy.in();
        }
    }

    private LinkedList<BasicNameValuePair> aiP() {
        if (this.bSj != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bSj.ajG().ajJ().bVp)) {
                linkedList.add(new BasicNameValuePair("sid", this.bSj.ajG().ajJ().bVp));
            }
            if (!TextUtils.isEmpty(this.bSj.ajG().ajJ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bSj.ajG().ajJ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nS(String str) {
        this.bSj.ajH().bUO = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bSj.ajH().bUO = errorData.getError_code();
                if (this.bSj.ajH().bUO == -1) {
                    this.bSj.ajH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bSj.ajH().bUO != 0) {
                    this.bSj.ajH().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bSj.ajH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
    public String aii() {
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
            if (this.bSj.ajG().ajJ().bVk == null || i2 >= this.bSj.ajG().ajJ().bVk.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSj.ajG().ajJ().bVk.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSj.ajG().ajJ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iHy.isCanceled()) {
                return null;
            }
            if (this.iHy.b(this.bSj.ajG().ajJ().mUrl, this.bSj.ajG().ajJ().bVk, this.bSj.ajG().ajJ().bVm, 5, -1, aiP()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cik = this.iHy.cik();
            if (cik == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cim = cik.cim();
            if (cik == null || cik.iw() == null || cik.iw().size() > 0) {
            }
            this.bSj.ajH().AR = cim.responseCode;
            this.bSj.ajH().mHeader = cim.AT;
            if (this.bSj.ajH().AR != 200) {
                if (this.bSj.ajI().bUQ != null && !TextUtils.isEmpty(this.bSj.ajI().bUQ.Az)) {
                    this.bSj.ajH().bUP = this.bSj.ajI().bUQ.Az;
                } else {
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
                }
                TiebaStatic.net(this.bSj);
                return null;
            } else if (this.iHy.isCanceled()) {
                return null;
            } else {
                str = new String(cim.AU, "utf-8");
                try {
                    if (this.bSj.ajG().ajJ().mIsBaiduServer && this.bSj.ajG().ajJ().bVn) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSj.ajI().bUQ.Au;
                    aVar.mTime = this.bSj.ajI().bUQ.Ax;
                    aVar.bSE = this.bSj.ajI().bUQ.Aw;
                    aVar.bSD = 1;
                    aa.a(aVar);
                    aa.bSC.set(this.bSj.ajI().bUQ.Aw);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSj.ajH().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSj.ajH().AR = -12;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSj.ajH().AR = -13;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSj.ajH().AR = -15;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSj);
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
    public byte[] aij() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bSj.ajG().ajJ().bVk != null && this.bSj.ajG().ajJ().bVk.size() > 0 && !this.bSj.ajG().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bSj.ajG().ajJ().mUrl);
                if (this.bSj.ajG().ajJ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bSj.ajG().ajJ().mUrl.endsWith("?") && !this.bSj.ajG().ajJ().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bSj.ajG().ajJ().bVk.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bSj.ajG().ajJ().bVk.get(i).getName());
                    sb.append("=");
                    sb.append(aq.bi(this.bSj.ajG().ajJ().bVk.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bSj.ajG().ajJ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bSj.ajG().ajJ().bVm || this.bSj.ajG().ajJ().mIsBDImage) && !this.bSj.ajG().mIsFromCDN) {
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
        if (this.iHy.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iHy.b(str, z, 5, 100, -1, -1, aiP());
        com.baidu.tieba.recapp.download.http.g cik = this.iHy.cik();
        if (cik == null) {
            return null;
        }
        iVar = cik.cim();
        if (cik != null) {
            try {
                if (cik.iw() == null || cik.iw().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bSj.ajH().AR = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSj);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSj);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -12;
                TiebaStatic.net(this.bSj);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ != null ? this.bSj.ajI().bUQ.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSj.ajH().AR = -13;
                TiebaStatic.net(this.bSj);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bSj.ajH().AR = iVar.responseCode;
        if (this.bSj.ajH().AR != 200) {
            this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bSj.ajI().bUQ != null && !TextUtils.isEmpty(this.bSj.ajI().bUQ.Az)) {
                this.bSj.ajH().bUP = this.bSj.ajI().bUQ.Az;
            } else {
                this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
            }
            TiebaStatic.net(this.bSj);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bSp) {
                    this.bSj.ajH().AR = -11;
                    TiebaStatic.net(this.bSj);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aty().kG(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bSj.ajG().ajJ().mUrl + "], size:" + i2);
                            this.bSj.ajH().AR = -16;
                            TiebaStatic.net(this.bSj);
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
        aVar.aWr = this.bSj.ajI().bUQ.Au;
        aVar.mTime = new Date().getTime() - j;
        aVar.bSE = this.bSj.ajI().bUQ.Aw;
        aVar.bSD = 2;
        aa.a(aVar);
        aa.bSC.set(this.bSj.ajI().bUQ.Aw);
        TiebaStatic.net(this.bSj);
        bArr = iVar == null ? iVar.AU : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aik() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] aij = aij();
        if (aij == null || this.bSj.ajH().AR != 200) {
            return null;
        }
        try {
            this.bSj.ajG().ajJ().bVo = TextUtils.isEmpty(this.bSj.ajG().ajJ().bVo) ? HTTP.UTF_8 : this.bSj.ajG().ajJ().bVo;
            str = new String(aij, 0, aij.length, this.bSj.ajG().ajJ().bVo);
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
    public String ail() {
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
            if (this.bSj.ajG().ajJ().bVk == null || i2 >= this.bSj.ajG().ajJ().bVk.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSj.ajG().ajJ().bVk.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSj.ajG().ajJ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iHy.isCanceled()) {
                return null;
            }
            if (this.iHy.b(this.bSj.ajG().ajJ().mUrl, this.bSj.ajG().ajJ().bVk, this.bSj.ajG().ajJ().bVm, 5, -1, aiP()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cik = this.iHy.cik();
            if (cik == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cim = cik.cim();
            if (cik == null || cik.iw() == null || cik.iw().size() > 0) {
            }
            this.bSj.ajH().AR = cim.responseCode;
            this.bSj.ajH().mHeader = cim.AT;
            if (this.bSj.ajH().AR != 200) {
                if (this.bSj.ajI().bUQ != null && !TextUtils.isEmpty(this.bSj.ajI().bUQ.Az)) {
                    this.bSj.ajH().bUP = this.bSj.ajI().bUQ.Az;
                } else {
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw);
                }
                TiebaStatic.net(this.bSj);
                return null;
            } else if (this.iHy.isCanceled()) {
                return null;
            } else {
                str = new String(cim.AU, "utf-8");
                try {
                    if (this.bSj.ajG().ajJ().mIsBaiduServer && this.bSj.ajG().ajJ().bVn) {
                        nS(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWr = this.bSj.ajI().bUQ.Au;
                    aVar.mTime = this.bSj.ajI().bUQ.Ax;
                    aVar.bSE = this.bSj.ajI().bUQ.Aw;
                    aVar.bSD = 1;
                    aa.a(aVar);
                    aa.bSC.set(this.bSj.ajI().bUQ.Aw);
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSj.ajH().bUP = String.valueOf(this.bSj.ajH().AR) + "|retryCount:" + (this.bSj.ajI().bUQ == null ? -1 : this.bSj.ajI().bUQ.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSj.ajH().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSj.ajH().AR = -12;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSj.ajH().AR = -13;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSj.ajH().AR = -15;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSj);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSj.ajH().AR = -10;
                    this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSj);
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
            if (this.iHy.isCanceled()) {
                return false;
            }
            return this.iHy.a(this.bSj.ajG().ajJ().mUrl, (z ? new File(str) : m.nr(str)).getAbsolutePath(), false, i2, i3, -1, -1, aiP(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bSr = 0;
                int bSs = 0;
                int bSt = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bSr = i5 / 50;
                    }
                    this.bSs += i4 - this.bSt;
                    this.bSt = i4;
                    if (handler != null) {
                        if (this.bSs > this.bSr || i4 == i5) {
                            this.bSs = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bSj.ajH().AR = -10;
            this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bSj.ajH().AR = -15;
            this.bSj.ajH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bSj);
        }
    }
}
