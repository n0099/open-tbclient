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
    private static int aWg = 2097152;
    private final com.baidu.tbadk.core.util.a.a aWb;
    private com.baidu.tieba.recapp.download.http.c gCI = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.aWb = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public void m(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aWb.Dw().Dz().aYJ != null) {
            this.aWb.Dw().Dz().aYJ.clear();
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
    public ArrayList<BasicNameValuePair> Ca() {
        return this.aWb.Dw().Dz().aYJ;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void n(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aWb.Dw().Dz().aYJ == null) {
                this.aWb.Dw().Dz().aYJ = new ArrayList<>();
            }
            int c = c(this.aWb.Dw().Dz().aYJ, basicNameValuePair.getName());
            int size = this.aWb.Dw().Dz().aYJ.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aWb.Dw().Dz().aYJ.get(c).getName())) {
                    this.aWb.Dw().Dz().aYJ.set(c, basicNameValuePair);
                } else {
                    this.aWb.Dw().Dz().aYJ.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aWb.Dw().Dz().aYJ.add(c, basicNameValuePair);
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
        if (this.aWb.Dw().Dz().aYK == null) {
            this.aWb.Dw().Dz().aYK = new HashMap<>();
        }
        this.aWb.Dw().Dz().aYK.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mS() {
        this.gCI.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void mV() {
        if (this.gCI != null) {
            this.gCI.mV();
        }
    }

    private LinkedList<BasicNameValuePair> CI() {
        if (this.aWb != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aWb.Dw().Dz().aYO)) {
                linkedList.add(new BasicNameValuePair("sid", this.aWb.Dw().Dz().aYO));
            }
            if (!TextUtils.isEmpty(this.aWb.Dw().Dz().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aWb.Dw().Dz().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void ej(String str) {
        this.aWb.Dx().aYn = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aWb.Dx().aYn = errorData.getError_code();
                if (this.aWb.Dx().aYn == -1) {
                    this.aWb.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aWb.Dx().aYn != 0) {
                    this.aWb.Dx().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aWb.Dx().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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
    public String Cb() {
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
            if (this.aWb.Dw().Dz().aYJ == null || i2 >= this.aWb.Dw().Dz().aYJ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aWb.Dw().Dz().aYJ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aWb.Dw().Dz().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gCI.isCanceled()) {
                return null;
            }
            if (this.gCI.b(this.aWb.Dw().Dz().mUrl, this.aWb.Dw().Dz().aYJ, this.aWb.Dw().Dz().aYL, 5, -1, CI()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bot = this.gCI.bot();
            if (bot == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bov = bot.bov();
            if (bot == null || bot.nd() == null || bot.nd().size() > 0) {
            }
            this.aWb.Dx().ajC = bov.responseCode;
            this.aWb.Dx().mHeader = bov.ajD;
            if (this.aWb.Dx().ajC != 200) {
                if (this.aWb.Dy().aYp != null && !TextUtils.isEmpty(this.aWb.Dy().aYp.ajl)) {
                    this.aWb.Dx().aYo = this.aWb.Dy().aYp.ajl;
                } else {
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
                }
                TiebaStatic.net(this.aWb);
                return null;
            } else if (this.gCI.isCanceled()) {
                return null;
            } else {
                str = new String(bov.ajE, "utf-8");
                try {
                    if (this.aWb.Dw().Dz().mIsBaiduServer && this.aWb.Dw().Dz().aYM) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWw = this.aWb.Dy().aYp.ajg;
                    aVar.mTime = this.aWb.Dy().aYp.ajj;
                    aVar.aWx = this.aWb.Dy().aYp.aji;
                    aVar.aWv = 1;
                    aa.a(aVar);
                    aa.aWu.set(this.aWb.Dy().aYp.aji);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aWb.Dx().ajC = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aWb.Dx().ajC = -15;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aWb.Dx().ajC = -12;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aWb.Dx().ajC = -13;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aWb);
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
    public byte[] Cc() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aWb.Dw().Dz().aYJ != null && this.aWb.Dw().Dz().aYJ.size() > 0 && !this.aWb.Dw().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aWb.Dw().Dz().mUrl);
                if (this.aWb.Dw().Dz().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aWb.Dw().Dz().mUrl.endsWith("?") && !this.aWb.Dw().Dz().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aWb.Dw().Dz().aYJ.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aWb.Dw().Dz().aYJ.get(i).getName());
                    sb.append("=");
                    sb.append(am.aV(this.aWb.Dw().Dz().aYJ.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aWb.Dw().Dz().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aWb.Dw().Dz().aYL || this.aWb.Dw().Dz().mIsBDImage) && !this.aWb.Dw().mIsFromCDN) {
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
        if (this.gCI.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gCI.b(str, z, 5, 100, -1, -1, CI());
        com.baidu.tieba.recapp.download.http.g bot = this.gCI.bot();
        if (bot == null) {
            return null;
        }
        iVar = bot.bov();
        if (bot != null) {
            try {
                if (bot.nd() == null || bot.nd().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aWb.Dx().ajC = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -12;
                TiebaStatic.net(this.aWb);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -13;
                TiebaStatic.net(this.aWb);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aWb);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp != null ? this.aWb.Dy().aYp.aji : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aWb.Dx().ajC = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aWb);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.aWb.Dx().ajC = iVar.responseCode;
        if (this.aWb.Dx().ajC != 200) {
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aWb.Dy().aYp != null && !TextUtils.isEmpty(this.aWb.Dy().aYp.ajl)) {
                this.aWb.Dx().aYo = this.aWb.Dy().aYp.ajl;
            } else {
                this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
            }
            TiebaStatic.net(this.aWb);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > aWg) {
                    this.aWb.Dx().ajC = -11;
                    TiebaStatic.net(this.aWb);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Mx().hY(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aWb.Dw().Dz().mUrl + "], size:" + i2);
                            this.aWb.Dx().ajC = -16;
                            TiebaStatic.net(this.aWb);
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
        aVar.aWw = this.aWb.Dy().aYp.ajg;
        aVar.mTime = new Date().getTime() - j;
        aVar.aWx = this.aWb.Dy().aYp.aji;
        aVar.aWv = 2;
        aa.a(aVar);
        aa.aWu.set(this.aWb.Dy().aYp.aji);
        TiebaStatic.net(this.aWb);
        bArr = iVar == null ? iVar.ajE : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String Cd() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] Cc = Cc();
        if (Cc == null || this.aWb.Dx().ajC != 200) {
            return null;
        }
        try {
            this.aWb.Dw().Dz().aYN = TextUtils.isEmpty(this.aWb.Dw().Dz().aYN) ? "UTF-8" : this.aWb.Dw().Dz().aYN;
            str = new String(Cc, 0, Cc.length, this.aWb.Dw().Dz().aYN);
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
    public String Ce() {
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
            if (this.aWb.Dw().Dz().aYJ == null || i2 >= this.aWb.Dw().Dz().aYJ.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aWb.Dw().Dz().aYJ.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aWb.Dw().Dz().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            n("sign", s.ba(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gCI.isCanceled()) {
                return null;
            }
            if (this.gCI.b(this.aWb.Dw().Dz().mUrl, this.aWb.Dw().Dz().aYJ, this.aWb.Dw().Dz().aYL, 5, -1, CI()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bot = this.gCI.bot();
            if (bot == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bov = bot.bov();
            if (bot == null || bot.nd() == null || bot.nd().size() > 0) {
            }
            this.aWb.Dx().ajC = bov.responseCode;
            this.aWb.Dx().mHeader = bov.ajD;
            if (this.aWb.Dx().ajC != 200) {
                if (this.aWb.Dy().aYp != null && !TextUtils.isEmpty(this.aWb.Dy().aYp.ajl)) {
                    this.aWb.Dx().aYo = this.aWb.Dy().aYp.ajl;
                } else {
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji);
                }
                TiebaStatic.net(this.aWb);
                return null;
            } else if (this.gCI.isCanceled()) {
                return null;
            } else {
                str = new String(bov.ajE, "utf-8");
                try {
                    if (this.aWb.Dw().Dz().mIsBaiduServer && this.aWb.Dw().Dz().aYM) {
                        ej(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.oP());
                    aVar.aWw = this.aWb.Dy().aYp.ajg;
                    aVar.mTime = this.aWb.Dy().aYp.ajj;
                    aVar.aWx = this.aWb.Dy().aYp.aji;
                    aVar.aWv = 1;
                    aa.a(aVar);
                    aa.aWu.set(this.aWb.Dy().aYp.aji);
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aWb.Dx().aYo = String.valueOf(this.aWb.Dx().ajC) + "|retryCount:" + (this.aWb.Dy().aYp == null ? -1 : this.aWb.Dy().aYp.aji) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aWb.Dx().ajC = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aWb.Dx().ajC = -15;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aWb.Dx().ajC = -12;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aWb.Dx().ajC = -13;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aWb);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aWb.Dx().ajC = -10;
                    this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aWb);
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
            if (this.gCI.isCanceled()) {
                return false;
            }
            return this.gCI.a(this.aWb.Dw().Dz().mUrl, (z ? new File(str) : k.dJ(str)).getAbsolutePath(), false, i2, i3, -1, -1, CI(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int aWi = 0;
                int aWj = 0;
                int aWk = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void an(int i4, int i5) {
                    if (i5 > 0) {
                        this.aWi = i5 / 50;
                    }
                    this.aWj += i4 - this.aWk;
                    this.aWk = i4;
                    if (handler != null) {
                        if (this.aWj > this.aWi || i4 == i5) {
                            this.aWj = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aWb.Dx().ajC = -10;
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aWb.Dx().ajC = -15;
            this.aWb.Dx().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aWb);
        }
    }
}
