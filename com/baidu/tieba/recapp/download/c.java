package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.k;
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
/* loaded from: classes3.dex */
public class c implements q {
    private static int ahq = 2097152;
    private final com.baidu.tbadk.core.util.a.a ahl;
    private com.baidu.tieba.recapp.download.http.c fXw = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.ahl = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void l(ArrayList<BasicNameValuePair> arrayList) {
        if (this.ahl.wi().wl().akc != null) {
            this.ahl.wi().wl().akc.clear();
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
    public ArrayList<BasicNameValuePair> uK() {
        return this.ahl.wi().wl().akc;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ahl.wi().wl().akc == null) {
                this.ahl.wi().wl().akc = new ArrayList<>();
            }
            int c = c(this.ahl.wi().wl().akc, basicNameValuePair.getName());
            int size = this.ahl.wi().wl().akc.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.ahl.wi().wl().akc.get(c).getName())) {
                    this.ahl.wi().wl().akc.set(c, basicNameValuePair);
                } else {
                    this.ahl.wi().wl().akc.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.ahl.wi().wl().akc.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        if (this.ahl.wi().wl().akd == null) {
            this.ahl.wi().wl().akd = new HashMap<>();
        }
        this.ahl.wi().wl().akd.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void eW() {
        this.fXw.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void eY() {
        if (this.fXw != null) {
            this.fXw.eY();
        }
    }

    private LinkedList<BasicNameValuePair> vs() {
        if (this.ahl != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ahl.wi().wl().akh)) {
                linkedList.add(new BasicNameValuePair("sid", this.ahl.wi().wl().akh));
            }
            if (!TextUtils.isEmpty(this.ahl.wi().wl().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ahl.wi().wl().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void eb(String str) {
        this.ahl.wj().ajG = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ahl.wj().ajG = errorData.getError_code();
                if (this.ahl.wj().ajG == -1) {
                    this.ahl.wj().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
                } else if (this.ahl.wj().ajG != 0) {
                    this.ahl.wj().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ahl.wj().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
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
    public String uL() {
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
            if (this.ahl.wi().wl().akc == null || i2 >= this.ahl.wi().wl().akc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ahl.wi().wl().akc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ahl.wi().wl().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.aX(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.fXw.isCanceled()) {
                return null;
            }
            if (this.fXw.b(this.ahl.wi().wl().mUrl, this.ahl.wi().wl().akc, this.ahl.wi().wl().ake, 5, -1, vs()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bjz = this.fXw.bjz();
            if (bjz == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bjB = bjz.bjB();
            if (bjz == null || bjz.fg() == null || bjz.fg().size() > 0) {
            }
            this.ahl.wj().tX = bjB.responseCode;
            this.ahl.wj().mHeader = bjB.tY;
            if (this.ahl.wj().tX != 200) {
                if (this.ahl.wk().ajI != null && !TextUtils.isEmpty(this.ahl.wk().ajI.tG)) {
                    this.ahl.wj().ajH = this.ahl.wk().ajI.tG;
                } else {
                    this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD);
                }
                TiebaStatic.net(this.ahl);
                return null;
            } else if (this.fXw.isCanceled()) {
                return null;
            } else {
                str = new String(bjB.tZ, "utf-8");
                try {
                    if (this.ahl.wi().wl().mIsBaiduServer && this.ahl.wi().wl().akf) {
                        eb(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.gV());
                    aVar.ahG = this.ahl.wk().ajI.tB;
                    aVar.mTime = this.ahl.wk().ajI.tE;
                    aVar.ahH = this.ahl.wk().ajI.tD;
                    aVar.ahF = 1;
                    aa.a(aVar);
                    aa.ahE.set(this.ahl.wk().ajI.tD);
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ahl.wj().tX = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ahl.wj().tX = -15;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ahl.wj().tX = -12;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ahl.wj().tX = -13;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ahl.wj().tX = -10;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ahl.wj().tX = -10;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ahl);
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
    public byte[] uM() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.ahl.wi().wl().akc != null && this.ahl.wi().wl().akc.size() > 0 && !this.ahl.wi().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ahl.wi().wl().mUrl);
                if (this.ahl.wi().wl().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ahl.wi().wl().mUrl.endsWith("?") && !this.ahl.wi().wl().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ahl.wi().wl().akc.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ahl.wi().wl().akc.get(i).getName());
                    sb.append("=");
                    sb.append(an.aS(this.ahl.wi().wl().akc.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ahl.wi().wl().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.ahl.wi().wl().ake || this.ahl.wi().wl().mIsBDImage) && !this.ahl.wi().mIsFromCDN) {
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
        if (this.fXw.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.fXw.b(str, z, 5, 100, -1, -1, vs());
        com.baidu.tieba.recapp.download.http.g bjz = this.fXw.bjz();
        if (bjz == null) {
            return null;
        }
        iVar = bjz.bjB();
        if (bjz != null) {
            try {
                if (bjz.fg() == null || bjz.fg().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ahl.wj().tX = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI != null ? this.ahl.wk().ajI.tD : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wj().tX = -12;
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI != null ? this.ahl.wk().ajI.tD : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wj().tX = -13;
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI != null ? this.ahl.wk().ajI.tD : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wj().tX = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI != null ? this.ahl.wk().ajI.tD : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wj().tX = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.ahl.wj().tX = iVar.responseCode;
        if (this.ahl.wj().tX != 200) {
            this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
            if (this.ahl.wk().ajI != null && !TextUtils.isEmpty(this.ahl.wk().ajI.tG)) {
                this.ahl.wj().ajH = this.ahl.wk().ajI.tG;
            } else {
                this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD);
            }
            TiebaStatic.net(this.ahl);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ahq) {
                    this.ahl.wj().tX = -11;
                    TiebaStatic.net(this.ahl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Fa().eY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ahl.wi().wl().mUrl + "], size:" + i2);
                            this.ahl.wj().tX = -16;
                            TiebaStatic.net(this.ahl);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.gV());
        aVar.ahG = this.ahl.wk().ajI.tB;
        aVar.mTime = new Date().getTime() - j;
        aVar.ahH = this.ahl.wk().ajI.tD;
        aVar.ahF = 2;
        aa.a(aVar);
        aa.ahE.set(this.ahl.wk().ajI.tD);
        TiebaStatic.net(this.ahl);
        bArr = iVar == null ? iVar.tZ : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String uN() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uM = uM();
        if (uM == null || this.ahl.wj().tX != 200) {
            return null;
        }
        try {
            this.ahl.wi().wl().akg = TextUtils.isEmpty(this.ahl.wi().wl().akg) ? "UTF-8" : this.ahl.wi().wl().akg;
            str = new String(uM, 0, uM.length, this.ahl.wi().wl().akg);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eb(str);
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
    public String uO() {
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
            if (this.ahl.wi().wl().akc == null || i2 >= this.ahl.wi().wl().akc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ahl.wi().wl().akc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ahl.wi().wl().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.aX(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.fXw.isCanceled()) {
                return null;
            }
            if (this.fXw.b(this.ahl.wi().wl().mUrl, this.ahl.wi().wl().akc, this.ahl.wi().wl().ake, 5, -1, vs()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bjz = this.fXw.bjz();
            if (bjz == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bjB = bjz.bjB();
            if (bjz == null || bjz.fg() == null || bjz.fg().size() > 0) {
            }
            this.ahl.wj().tX = bjB.responseCode;
            this.ahl.wj().mHeader = bjB.tY;
            if (this.ahl.wj().tX != 200) {
                if (this.ahl.wk().ajI != null && !TextUtils.isEmpty(this.ahl.wk().ajI.tG)) {
                    this.ahl.wj().ajH = this.ahl.wk().ajI.tG;
                } else {
                    this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD);
                }
                TiebaStatic.net(this.ahl);
                return null;
            } else if (this.fXw.isCanceled()) {
                return null;
            } else {
                str = new String(bjB.tZ, "utf-8");
                try {
                    if (this.ahl.wi().wl().mIsBaiduServer && this.ahl.wi().wl().akf) {
                        eb(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.gV());
                    aVar.ahG = this.ahl.wk().ajI.tB;
                    aVar.mTime = this.ahl.wk().ajI.tE;
                    aVar.ahH = this.ahl.wk().ajI.tD;
                    aVar.ahF = 1;
                    aa.a(aVar);
                    aa.ahE.set(this.ahl.wk().ajI.tD);
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.ahl.wj().ajH = String.valueOf(this.ahl.wj().tX) + "|retryCount:" + (this.ahl.wk().ajI == null ? -1 : this.ahl.wk().ajI.tD) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ahl.wj().tX = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ahl.wj().tX = -15;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ahl.wj().tX = -12;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ahl.wj().tX = -13;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ahl.wj().tX = -10;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ahl.wj().tX = -10;
                    this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.ahl);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [795=5] */
    @Override // com.baidu.tbadk.core.util.q
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.fXw.isCanceled()) {
                return false;
            }
            return this.fXw.a(this.ahl.wi().wl().mUrl, (z ? new File(str) : k.dB(str)).getAbsolutePath(), false, i2, i3, -1, -1, vs(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int ahs = 0;
                int aht = 0;
                int ahu = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.ahs = i5 / 50;
                    }
                    this.aht += i4 - this.ahu;
                    this.ahu = i4;
                    if (handler != null) {
                        if (this.aht > this.ahs || i4 == i5) {
                            this.aht = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.ahl.wj().tX = -10;
            this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ahl.wj().tX = -15;
            this.ahl.wj().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ahl);
        }
    }
}
