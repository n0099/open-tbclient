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
    private com.baidu.tieba.recapp.download.http.c fYz = new com.baidu.tieba.recapp.download.http.c();
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
        if (this.ahl.wh().wk().akc != null) {
            this.ahl.wh().wk().akc.clear();
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
    public ArrayList<BasicNameValuePair> uJ() {
        return this.ahl.wh().wk().akc;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.ahl.wh().wk().akc == null) {
                this.ahl.wh().wk().akc = new ArrayList<>();
            }
            int c = c(this.ahl.wh().wk().akc, basicNameValuePair.getName());
            int size = this.ahl.wh().wk().akc.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.ahl.wh().wk().akc.get(c).getName())) {
                    this.ahl.wh().wk().akc.set(c, basicNameValuePair);
                } else {
                    this.ahl.wh().wk().akc.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.ahl.wh().wk().akc.add(c, basicNameValuePair);
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
        if (this.ahl.wh().wk().akd == null) {
            this.ahl.wh().wk().akd = new HashMap<>();
        }
        this.ahl.wh().wk().akd.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void eW() {
        this.fYz.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void eY() {
        if (this.fYz != null) {
            this.fYz.eY();
        }
    }

    private LinkedList<BasicNameValuePair> vr() {
        if (this.ahl != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.ahl.wh().wk().akh)) {
                linkedList.add(new BasicNameValuePair("sid", this.ahl.wh().wk().akh));
            }
            if (!TextUtils.isEmpty(this.ahl.wh().wk().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.ahl.wh().wk().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void eb(String str) {
        this.ahl.wi().ajG = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.ahl.wi().ajG = errorData.getError_code();
                if (this.ahl.wi().ajG == -1) {
                    this.ahl.wi().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
                } else if (this.ahl.wi().ajG != 0) {
                    this.ahl.wi().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.ahl.wi().mErrorString = this.mContext.getString(d.k.error_unkown_try_again);
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
    public String uK() {
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
            if (this.ahl.wh().wk().akc == null || i2 >= this.ahl.wh().wk().akc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ahl.wh().wk().akc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ahl.wh().wk().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.aX(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.fYz.isCanceled()) {
                return null;
            }
            if (this.fYz.b(this.ahl.wh().wk().mUrl, this.ahl.wh().wk().akc, this.ahl.wh().wk().ake, 5, -1, vr()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bjy = this.fYz.bjy();
            if (bjy == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bjA = bjy.bjA();
            if (bjy == null || bjy.fg() == null || bjy.fg().size() > 0) {
            }
            this.ahl.wi().tW = bjA.responseCode;
            this.ahl.wi().mHeader = bjA.tX;
            if (this.ahl.wi().tW != 200) {
                if (this.ahl.wj().ajI != null && !TextUtils.isEmpty(this.ahl.wj().ajI.tF)) {
                    this.ahl.wi().ajH = this.ahl.wj().ajI.tF;
                } else {
                    this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC);
                }
                TiebaStatic.net(this.ahl);
                return null;
            } else if (this.fYz.isCanceled()) {
                return null;
            } else {
                str = new String(bjA.tY, "utf-8");
                try {
                    if (this.ahl.wh().wk().mIsBaiduServer && this.ahl.wh().wk().akf) {
                        eb(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.gV());
                    aVar.ahG = this.ahl.wj().ajI.tA;
                    aVar.mTime = this.ahl.wj().ajI.tD;
                    aVar.ahH = this.ahl.wj().ajI.tC;
                    aVar.ahF = 1;
                    aa.a(aVar);
                    aa.ahE.set(this.ahl.wj().ajI.tC);
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ahl.wi().tW = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ahl.wi().tW = -15;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ahl.wi().tW = -12;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ahl.wi().tW = -13;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ahl.wi().tW = -10;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ahl.wi().tW = -10;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
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
    public byte[] uL() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.ahl.wh().wk().akc != null && this.ahl.wh().wk().akc.size() > 0 && !this.ahl.wh().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.ahl.wh().wk().mUrl);
                if (this.ahl.wh().wk().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.ahl.wh().wk().mUrl.endsWith("?") && !this.ahl.wh().wk().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.ahl.wh().wk().akc.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.ahl.wh().wk().akc.get(i).getName());
                    sb.append("=");
                    sb.append(an.aS(this.ahl.wh().wk().akc.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.ahl.wh().wk().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.ahl.wh().wk().ake || this.ahl.wh().wk().mIsBDImage) && !this.ahl.wh().mIsFromCDN) {
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
        if (this.fYz.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.fYz.b(str, z, 5, 100, -1, -1, vr());
        com.baidu.tieba.recapp.download.http.g bjy = this.fYz.bjy();
        if (bjy == null) {
            return null;
        }
        iVar = bjy.bjA();
        if (bjy != null) {
            try {
                if (bjy.fg() == null || bjy.fg().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.ahl.wi().tW = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI != null ? this.ahl.wj().ajI.tC : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wi().tW = -12;
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI != null ? this.ahl.wj().ajI.tC : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wi().tW = -13;
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI != null ? this.ahl.wj().ajI.tC : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wi().tW = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.ahl);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI != null ? this.ahl.wj().ajI.tC : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.ahl.wi().tW = -15;
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
        this.ahl.wi().tW = iVar.responseCode;
        if (this.ahl.wi().tW != 200) {
            this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
            if (this.ahl.wj().ajI != null && !TextUtils.isEmpty(this.ahl.wj().ajI.tF)) {
                this.ahl.wi().ajH = this.ahl.wj().ajI.tF;
            } else {
                this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC);
            }
            TiebaStatic.net(this.ahl);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ahq) {
                    this.ahl.wi().tW = -11;
                    TiebaStatic.net(this.ahl);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.EY().eY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.ahl.wh().wk().mUrl + "], size:" + i2);
                            this.ahl.wi().tW = -16;
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
        aVar.ahG = this.ahl.wj().ajI.tA;
        aVar.mTime = new Date().getTime() - j;
        aVar.ahH = this.ahl.wj().ajI.tC;
        aVar.ahF = 2;
        aa.a(aVar);
        aa.ahE.set(this.ahl.wj().ajI.tC);
        TiebaStatic.net(this.ahl);
        bArr = iVar == null ? iVar.tY : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String uM() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] uL = uL();
        if (uL == null || this.ahl.wi().tW != 200) {
            return null;
        }
        try {
            this.ahl.wh().wk().akg = TextUtils.isEmpty(this.ahl.wh().wk().akg) ? "UTF-8" : this.ahl.wh().wk().akg;
            str = new String(uL, 0, uL.length, this.ahl.wh().wk().akg);
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
    public String uN() {
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
            if (this.ahl.wh().wk().akc == null || i2 >= this.ahl.wh().wk().akc.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.ahl.wh().wk().akc.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.ahl.wh().wk().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.aX(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.fYz.isCanceled()) {
                return null;
            }
            if (this.fYz.b(this.ahl.wh().wk().mUrl, this.ahl.wh().wk().akc, this.ahl.wh().wk().ake, 5, -1, vr()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bjy = this.fYz.bjy();
            if (bjy == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bjA = bjy.bjA();
            if (bjy == null || bjy.fg() == null || bjy.fg().size() > 0) {
            }
            this.ahl.wi().tW = bjA.responseCode;
            this.ahl.wi().mHeader = bjA.tX;
            if (this.ahl.wi().tW != 200) {
                if (this.ahl.wj().ajI != null && !TextUtils.isEmpty(this.ahl.wj().ajI.tF)) {
                    this.ahl.wi().ajH = this.ahl.wj().ajI.tF;
                } else {
                    this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC);
                }
                TiebaStatic.net(this.ahl);
                return null;
            } else if (this.fYz.isCanceled()) {
                return null;
            } else {
                str = new String(bjA.tY, "utf-8");
                try {
                    if (this.ahl.wh().wk().mIsBaiduServer && this.ahl.wh().wk().akf) {
                        eb(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.gV());
                    aVar.ahG = this.ahl.wj().ajI.tA;
                    aVar.mTime = this.ahl.wj().ajI.tD;
                    aVar.ahH = this.ahl.wj().ajI.tC;
                    aVar.ahF = 1;
                    aa.a(aVar);
                    aa.ahE.set(this.ahl.wj().ajI.tC);
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    this.ahl.wi().ajH = String.valueOf(this.ahl.wi().tW) + "|retryCount:" + (this.ahl.wj().ajI == null ? -1 : this.ahl.wj().ajI.tC) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.ahl.wi().tW = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.ahl.wi().tW = -15;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.ahl.wi().tW = -12;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.ahl.wi().tW = -13;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.ahl.wi().tW = -10;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.ahl);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.ahl.wi().tW = -10;
                    this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror);
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
            if (this.fYz.isCanceled()) {
                return false;
            }
            return this.fYz.a(this.ahl.wh().wk().mUrl, (z ? new File(str) : k.dB(str)).getAbsolutePath(), false, i2, i3, -1, -1, vr(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
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
            this.ahl.wi().tW = -10;
            this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.ahl.wi().tW = -15;
            this.ahl.wi().mErrorString = this.mContext.getResources().getString(d.k.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.ahl);
        }
    }
}
