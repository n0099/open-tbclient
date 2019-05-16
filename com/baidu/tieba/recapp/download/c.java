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
    private static int bRi = 2097152;
    private final com.baidu.tbadk.core.util.a.a bRc;
    private com.baidu.tieba.recapp.download.http.c izZ = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.bRc = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aB((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bAM : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bRc.aiB().aiE().bUc != null) {
            this.bRc.aiB().aiE().bUc.clear();
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
        return this.bRc.aiB().aiE().bUc;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bRc.aiB().aiE().bUc == null) {
                this.bRc.aiB().aiE().bUc = new ArrayList<>();
            }
            int b = b(this.bRc.aiB().aiE().bUc, basicNameValuePair.getName());
            int size = this.bRc.aiB().aiE().bUc.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bRc.aiB().aiE().bUc.get(b).getName())) {
                    this.bRc.aiB().aiE().bUc.set(b, basicNameValuePair);
                } else {
                    this.bRc.aiB().aiE().bUc.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bRc.aiB().aiE().bUc.add(b, basicNameValuePair);
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
        if (this.bRc.aiB().aiE().bUd == null) {
            this.bRc.aiB().aiE().bUd = new HashMap<>();
        }
        this.bRc.aiB().aiE().bUd.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ia() {
        this.izZ.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ie() {
        if (this.izZ != null) {
            this.izZ.ie();
        }
    }

    private LinkedList<BasicNameValuePair> ahL() {
        if (this.bRc != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bRc.aiB().aiE().bUh)) {
                linkedList.add(new BasicNameValuePair("sid", this.bRc.aiB().aiE().bUh));
            }
            if (!TextUtils.isEmpty(this.bRc.aiB().aiE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bRc.aiB().aiE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nH(String str) {
        this.bRc.aiC().bTG = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bRc.aiC().bTG = errorData.getError_code();
                if (this.bRc.aiC().bTG == -1) {
                    this.bRc.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bRc.aiC().bTG != 0) {
                    this.bRc.aiC().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bRc.aiC().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.bRc.aiB().aiE().bUc == null || i2 >= this.bRc.aiB().aiE().bUc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRc.aiB().aiE().bUc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRc.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.izZ.isCanceled()) {
                return null;
            }
            if (this.izZ.b(this.bRc.aiB().aiE().mUrl, this.bRc.aiB().aiE().bUc, this.bRc.aiB().aiE().bUe, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g ceY = this.izZ.ceY();
            if (ceY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cfa = ceY.cfa();
            if (ceY == null || ceY.im() == null || ceY.im().size() > 0) {
            }
            this.bRc.aiC().AM = cfa.responseCode;
            this.bRc.aiC().mHeader = cfa.AN;
            if (this.bRc.aiC().AM != 200) {
                if (this.bRc.aiD().bTI != null && !TextUtils.isEmpty(this.bRc.aiD().bTI.Au)) {
                    this.bRc.aiC().bTH = this.bRc.aiD().bTI.Au;
                } else {
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
                }
                TiebaStatic.net(this.bRc);
                return null;
            } else if (this.izZ.isCanceled()) {
                return null;
            } else {
                str = new String(cfa.AO, "utf-8");
                try {
                    if (this.bRc.aiB().aiE().mIsBaiduServer && this.bRc.aiB().aiE().bUf) {
                        nH(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRc.aiD().bTI.Ap;
                    aVar.mTime = this.bRc.aiD().bTI.As;
                    aVar.bRx = this.bRc.aiD().bTI.Ar;
                    aVar.bRw = 1;
                    aa.a(aVar);
                    aa.bRv.set(this.bRc.aiD().bTI.Ar);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRc.aiC().AM = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bRc.aiC().AM = -12;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bRc.aiC().AM = -13;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bRc.aiC().AM = -15;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRc);
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
            if (this.bRc.aiB().aiE().bUc != null && this.bRc.aiB().aiE().bUc.size() > 0 && !this.bRc.aiB().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bRc.aiB().aiE().mUrl);
                if (this.bRc.aiB().aiE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bRc.aiB().aiE().mUrl.endsWith("?") && !this.bRc.aiB().aiE().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bRc.aiB().aiE().bUc.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bRc.aiB().aiE().bUc.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.bRc.aiB().aiE().bUc.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bRc.aiB().aiE().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bRc.aiB().aiE().bUe || this.bRc.aiB().aiE().mIsBDImage) && !this.bRc.aiB().mIsFromCDN) {
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
        if (this.izZ.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.izZ.b(str, z, 5, 100, -1, -1, ahL());
        com.baidu.tieba.recapp.download.http.g ceY = this.izZ.ceY();
        if (ceY == null) {
            return null;
        }
        iVar = ceY.cfa();
        if (ceY != null) {
            try {
                if (ceY.im() == null || ceY.im().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bRc.aiC().AM = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRc);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bRc);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -12;
                TiebaStatic.net(this.bRc);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI != null ? this.bRc.aiD().bTI.Ar : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bRc.aiC().AM = -13;
                TiebaStatic.net(this.bRc);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bRc.aiC().AM = iVar.responseCode;
        if (this.bRc.aiC().AM != 200) {
            this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bRc.aiD().bTI != null && !TextUtils.isEmpty(this.bRc.aiD().bTI.Au)) {
                this.bRc.aiC().bTH = this.bRc.aiD().bTI.Au;
            } else {
                this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
            }
            TiebaStatic.net(this.bRc);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bRi) {
                    this.bRc.aiC().AM = -11;
                    TiebaStatic.net(this.bRc);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.asp().kz(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bRc.aiB().aiE().mUrl + "], size:" + i2);
                            this.bRc.aiC().AM = -16;
                            TiebaStatic.net(this.bRc);
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
        aVar.aVH = this.bRc.aiD().bTI.Ap;
        aVar.mTime = new Date().getTime() - j;
        aVar.bRx = this.bRc.aiD().bTI.Ar;
        aVar.bRw = 2;
        aa.a(aVar);
        aa.bRv.set(this.bRc.aiD().bTI.Ar);
        TiebaStatic.net(this.bRc);
        bArr = iVar == null ? iVar.AO : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String ahg() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ahf = ahf();
        if (ahf == null || this.bRc.aiC().AM != 200) {
            return null;
        }
        try {
            this.bRc.aiB().aiE().bUg = TextUtils.isEmpty(this.bRc.aiB().aiE().bUg) ? HTTP.UTF_8 : this.bRc.aiB().aiE().bUg;
            str = new String(ahf, 0, ahf.length, this.bRc.aiB().aiE().bUg);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nH(str);
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
            if (this.bRc.aiB().aiE().bUc == null || i2 >= this.bRc.aiB().aiE().bUc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bRc.aiB().aiE().bUc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bRc.aiB().aiE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.izZ.isCanceled()) {
                return null;
            }
            if (this.izZ.b(this.bRc.aiB().aiE().mUrl, this.bRc.aiB().aiE().bUc, this.bRc.aiB().aiE().bUe, 5, -1, ahL()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g ceY = this.izZ.ceY();
            if (ceY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cfa = ceY.cfa();
            if (ceY == null || ceY.im() == null || ceY.im().size() > 0) {
            }
            this.bRc.aiC().AM = cfa.responseCode;
            this.bRc.aiC().mHeader = cfa.AN;
            if (this.bRc.aiC().AM != 200) {
                if (this.bRc.aiD().bTI != null && !TextUtils.isEmpty(this.bRc.aiD().bTI.Au)) {
                    this.bRc.aiC().bTH = this.bRc.aiD().bTI.Au;
                } else {
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar);
                }
                TiebaStatic.net(this.bRc);
                return null;
            } else if (this.izZ.isCanceled()) {
                return null;
            } else {
                str = new String(cfa.AO, "utf-8");
                try {
                    if (this.bRc.aiB().aiE().mIsBaiduServer && this.bRc.aiB().aiE().bUf) {
                        nH(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aVH = this.bRc.aiD().bTI.Ap;
                    aVar.mTime = this.bRc.aiD().bTI.As;
                    aVar.bRx = this.bRc.aiD().bTI.Ar;
                    aVar.bRw = 1;
                    aa.a(aVar);
                    aa.bRv.set(this.bRc.aiD().bTI.Ar);
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bRc.aiC().bTH = String.valueOf(this.bRc.aiC().AM) + "|retryCount:" + (this.bRc.aiD().bTI == null ? -1 : this.bRc.aiD().bTI.Ar) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bRc.aiC().AM = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bRc.aiC().AM = -12;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bRc.aiC().AM = -13;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bRc.aiC().AM = -15;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bRc);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bRc.aiC().AM = -10;
                    this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bRc);
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
            if (this.izZ.isCanceled()) {
                return false;
            }
            return this.izZ.a(this.bRc.aiB().aiE().mUrl, (z ? new File(str) : m.ng(str)).getAbsolutePath(), false, i2, i3, -1, -1, ahL(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int bRk = 0;
                int bRl = 0;
                int bRm = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.bRk = i5 / 50;
                    }
                    this.bRl += i4 - this.bRm;
                    this.bRm = i4;
                    if (handler != null) {
                        if (this.bRl > this.bRk || i4 == i5) {
                            this.bRl = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bRc.aiC().AM = -10;
            this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bRc.aiC().AM = -15;
            this.bRc.aiC().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bRc);
        }
    }
}
