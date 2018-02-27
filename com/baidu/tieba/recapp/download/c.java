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
import com.baidu.tbadk.core.util.am;
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
    private static int aVU = 2097152;
    private final com.baidu.tbadk.core.util.a.a aVP;
    private com.baidu.tieba.recapp.download.http.c gCt = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.aVP = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aVP.Dv().Dy().aYx != null) {
            this.aVP.Dv().Dy().aYx.clear();
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
    public ArrayList<BasicNameValuePair> BZ() {
        return this.aVP.Dv().Dy().aYx;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aVP.Dv().Dy().aYx == null) {
                this.aVP.Dv().Dy().aYx = new ArrayList<>();
            }
            int c = c(this.aVP.Dv().Dy().aYx, basicNameValuePair.getName());
            int size = this.aVP.Dv().Dy().aYx.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aVP.Dv().Dy().aYx.get(c).getName())) {
                    this.aVP.Dv().Dy().aYx.set(c, basicNameValuePair);
                } else {
                    this.aVP.Dv().Dy().aYx.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aVP.Dv().Dy().aYx.add(c, basicNameValuePair);
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
        if (this.aVP.Dv().Dy().aYy == null) {
            this.aVP.Dv().Dy().aYy = new HashMap<>();
        }
        this.aVP.Dv().Dy().aYy.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mS() {
        this.gCt.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mV() {
        if (this.gCt != null) {
            this.gCt.mV();
        }
    }

    private LinkedList<BasicNameValuePair> CH() {
        if (this.aVP != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aVP.Dv().Dy().aYC)) {
                linkedList.add(new BasicNameValuePair("sid", this.aVP.Dv().Dy().aYC));
            }
            if (!TextUtils.isEmpty(this.aVP.Dv().Dy().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aVP.Dv().Dy().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void ej(String str) {
        this.aVP.Dw().aYb = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aVP.Dw().aYb = errorData.getError_code();
                if (this.aVP.Dw().aYb == -1) {
                    this.aVP.Dw().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aVP.Dw().aYb != 0) {
                    this.aVP.Dw().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aVP.Dw().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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
    public String Ca() {
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
            if (this.aVP.Dv().Dy().aYx == null || i2 >= this.aVP.Dv().Dy().aYx.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aVP.Dv().Dy().aYx.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aVP.Dv().Dy().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gCt.isCanceled()) {
                return null;
            }
            if (this.gCt.b(this.aVP.Dv().Dy().mUrl, this.aVP.Dv().Dy().aYx, this.aVP.Dv().Dy().aYz, 5, -1, CH()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bos = this.gCt.bos();
            if (bos == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bou = bos.bou();
            if (bos == null || bos.nd() == null || bos.nd().size() > 0) {
            }
            this.aVP.Dw().ajw = bou.responseCode;
            this.aVP.Dw().mHeader = bou.ajx;
            if (this.aVP.Dw().ajw != 200) {
                if (this.aVP.Dx().aYd != null && !TextUtils.isEmpty(this.aVP.Dx().aYd.ajf)) {
                    this.aVP.Dw().aYc = this.aVP.Dx().aYd.ajf;
                } else {
                    this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc);
                }
                TiebaStatic.net(this.aVP);
                return null;
            } else if (this.gCt.isCanceled()) {
                return null;
            } else {
                str = new String(bou.ajy, "utf-8");
                try {
                    if (this.aVP.Dv().Dy().mIsBaiduServer && this.aVP.Dv().Dy().aYA) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWk = this.aVP.Dx().aYd.aja;
                    aVar.mTime = this.aVP.Dx().aYd.ajd;
                    aVar.aWl = this.aVP.Dx().aYd.ajc;
                    aVar.aWj = 1;
                    aa.a(aVar);
                    aa.aWi.set(this.aVP.Dx().aYd.ajc);
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aVP.Dw().ajw = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aVP.Dw().ajw = -15;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aVP.Dw().ajw = -12;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aVP.Dw().ajw = -13;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aVP.Dw().ajw = -10;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aVP.Dw().ajw = -10;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aVP);
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
    public byte[] Cb() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aVP.Dv().Dy().aYx != null && this.aVP.Dv().Dy().aYx.size() > 0 && !this.aVP.Dv().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aVP.Dv().Dy().mUrl);
                if (this.aVP.Dv().Dy().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aVP.Dv().Dy().mUrl.endsWith("?") && !this.aVP.Dv().Dy().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aVP.Dv().Dy().aYx.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aVP.Dv().Dy().aYx.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aVP.Dv().Dy().aYx.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aVP.Dv().Dy().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aVP.Dv().Dy().aYz || this.aVP.Dv().Dy().mIsBDImage) && !this.aVP.Dv().mIsFromCDN) {
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
        if (this.gCt.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gCt.b(str, z, 5, 100, -1, -1, CH());
        com.baidu.tieba.recapp.download.http.g bos = this.gCt.bos();
        if (bos == null) {
            return null;
        }
        iVar = bos.bou();
        if (bos != null) {
            try {
                if (bos.nd() == null || bos.nd().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aVP.Dw().ajw = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd != null ? this.aVP.Dx().aYd.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVP.Dw().ajw = -12;
                TiebaStatic.net(this.aVP);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd != null ? this.aVP.Dx().aYd.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVP.Dw().ajw = -13;
                TiebaStatic.net(this.aVP);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd != null ? this.aVP.Dx().aYd.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVP.Dw().ajw = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aVP);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd != null ? this.aVP.Dx().aYd.ajc : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aVP.Dw().ajw = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aVP);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.aVP.Dw().ajw = iVar.responseCode;
        if (this.aVP.Dw().ajw != 200) {
            this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aVP.Dx().aYd != null && !TextUtils.isEmpty(this.aVP.Dx().aYd.ajf)) {
                this.aVP.Dw().aYc = this.aVP.Dx().aYd.ajf;
            } else {
                this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc);
            }
            TiebaStatic.net(this.aVP);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aVU) {
                    this.aVP.Dw().ajw = -11;
                    TiebaStatic.net(this.aVP);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mw().hY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aVP.Dv().Dy().mUrl + "], size:" + i2);
                            this.aVP.Dw().ajw = -16;
                            TiebaStatic.net(this.aVP);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
        aVar.aWk = this.aVP.Dx().aYd.aja;
        aVar.mTime = new Date().getTime() - j;
        aVar.aWl = this.aVP.Dx().aYd.ajc;
        aVar.aWj = 2;
        aa.a(aVar);
        aa.aWi.set(this.aVP.Dx().aYd.ajc);
        TiebaStatic.net(this.aVP);
        bArr = iVar == null ? iVar.ajy : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Cc() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] Cb = Cb();
        if (Cb == null || this.aVP.Dw().ajw != 200) {
            return null;
        }
        try {
            this.aVP.Dv().Dy().aYB = TextUtils.isEmpty(this.aVP.Dv().Dy().aYB) ? "UTF-8" : this.aVP.Dv().Dy().aYB;
            str = new String(Cb, 0, Cb.length, this.aVP.Dv().Dy().aYB);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            ej(str);
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
    public String Cd() {
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
            if (this.aVP.Dv().Dy().aYx == null || i2 >= this.aVP.Dv().Dy().aYx.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aVP.Dv().Dy().aYx.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aVP.Dv().Dy().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gCt.isCanceled()) {
                return null;
            }
            if (this.gCt.b(this.aVP.Dv().Dy().mUrl, this.aVP.Dv().Dy().aYx, this.aVP.Dv().Dy().aYz, 5, -1, CH()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bos = this.gCt.bos();
            if (bos == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bou = bos.bou();
            if (bos == null || bos.nd() == null || bos.nd().size() > 0) {
            }
            this.aVP.Dw().ajw = bou.responseCode;
            this.aVP.Dw().mHeader = bou.ajx;
            if (this.aVP.Dw().ajw != 200) {
                if (this.aVP.Dx().aYd != null && !TextUtils.isEmpty(this.aVP.Dx().aYd.ajf)) {
                    this.aVP.Dw().aYc = this.aVP.Dx().aYd.ajf;
                } else {
                    this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc);
                }
                TiebaStatic.net(this.aVP);
                return null;
            } else if (this.gCt.isCanceled()) {
                return null;
            } else {
                str = new String(bou.ajy, "utf-8");
                try {
                    if (this.aVP.Dv().Dy().mIsBaiduServer && this.aVP.Dv().Dy().aYA) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWk = this.aVP.Dx().aYd.aja;
                    aVar.mTime = this.aVP.Dx().aYd.ajd;
                    aVar.aWl = this.aVP.Dx().aYd.ajc;
                    aVar.aWj = 1;
                    aa.a(aVar);
                    aa.aWi.set(this.aVP.Dx().aYd.ajc);
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aVP.Dw().aYc = String.valueOf(this.aVP.Dw().ajw) + "|retryCount:" + (this.aVP.Dx().aYd == null ? -1 : this.aVP.Dx().aYd.ajc) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aVP.Dw().ajw = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aVP.Dw().ajw = -15;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aVP.Dw().ajw = -12;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aVP.Dw().ajw = -13;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aVP.Dw().ajw = -10;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aVP);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aVP.Dw().ajw = -10;
                    this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aVP);
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
            if (this.gCt.isCanceled()) {
                return false;
            }
            return this.gCt.a(this.aVP.Dv().Dy().mUrl, (z ? new File(str) : k.dJ(str)).getAbsolutePath(), false, i2, i3, -1, -1, CH(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int aVW = 0;
                int aVX = 0;
                int aVY = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aVW = i5 / 50;
                    }
                    this.aVX += i4 - this.aVY;
                    this.aVY = i4;
                    if (handler != null) {
                        if (this.aVX > this.aVW || i4 == i5) {
                            this.aVX = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aVP.Dw().ajw = -10;
            this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aVP.Dw().ajw = -15;
            this.aVP.Dw().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aVP);
        }
    }
}
