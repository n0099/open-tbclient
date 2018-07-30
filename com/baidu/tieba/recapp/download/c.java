package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.r;
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
public class c implements r {
    private static int apx = 2097152;
    private final com.baidu.tbadk.core.util.a.a aps;
    private com.baidu.tieba.recapp.download.http.c goS = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.aps = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.aps.zM().zP().asq != null) {
            this.aps.zM().zP().asq.clear();
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

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> yp() {
        return this.aps.zM().zP().asq;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.aps.zM().zP().asq == null) {
                this.aps.zM().zP().asq = new ArrayList<>();
            }
            int c = c(this.aps.zM().zP().asq, basicNameValuePair.getName());
            int size = this.aps.zM().zP().asq.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.aps.zM().zP().asq.get(c).getName())) {
                    this.aps.zM().zP().asq.set(c, basicNameValuePair);
                } else {
                    this.aps.zM().zP().asq.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.aps.zM().zP().asq.add(c, basicNameValuePair);
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

    @Override // com.baidu.tbadk.core.util.r
    public void d(String str, byte[] bArr) {
        if (this.aps.zM().zP().asr == null) {
            this.aps.zM().zP().asr = new HashMap<>();
        }
        this.aps.zM().zP().asr.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hN() {
        this.goS.cancel();
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hQ() {
        if (this.goS != null) {
            this.goS.hQ();
        }
    }

    private LinkedList<BasicNameValuePair> yX() {
        if (this.aps != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.aps.zM().zP().asv)) {
                linkedList.add(new BasicNameValuePair("sid", this.aps.zM().zP().asv));
            }
            if (!TextUtils.isEmpty(this.aps.zM().zP().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.aps.zM().zP().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void eC(String str) {
        this.aps.zN().arU = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.aps.zN().arU = errorData.getError_code();
                if (this.aps.zN().arU == -1) {
                    this.aps.zN().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
                } else if (this.aps.zN().arU != 0) {
                    this.aps.zN().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.aps.zN().mErrorString = this.mContext.getString(d.j.error_unkown_try_again);
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

    @Override // com.baidu.tbadk.core.util.r
    public String yq() {
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
            if (this.aps.zM().zP().asq == null || i2 >= this.aps.zM().zP().asq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aps.zM().zP().asq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aps.zM().zP().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.goS.isCanceled()) {
                return null;
            }
            if (this.goS.b(this.aps.zM().zP().mUrl, this.aps.zM().zP().asq, this.aps.zM().zP().ass, 5, -1, yX()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bnC = this.goS.bnC();
            if (bnC == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bnE = bnC.bnE();
            if (bnC == null || bnC.hY() == null || bnC.hY().size() > 0) {
            }
            this.aps.zN().zU = bnE.responseCode;
            this.aps.zN().mHeader = bnE.zV;
            if (this.aps.zN().zU != 200) {
                if (this.aps.zO().arW != null && !TextUtils.isEmpty(this.aps.zO().arW.zD)) {
                    this.aps.zN().arV = this.aps.zO().arW.zD;
                } else {
                    this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA);
                }
                TiebaStatic.net(this.aps);
                return null;
            } else if (this.goS.isCanceled()) {
                return null;
            } else {
                str = new String(bnE.zW, IoUtils.UTF_8);
                try {
                    if (this.aps.zM().zP().mIsBaiduServer && this.aps.zM().zP().ast) {
                        eC(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jK());
                    aVar.apN = this.aps.zO().arW.zy;
                    aVar.mTime = this.aps.zO().arW.zB;
                    aVar.apO = this.aps.zO().arW.zA;
                    aVar.apM = 1;
                    ab.a(aVar);
                    ab.apL.set(this.aps.zO().arW.zA);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aps.zN().zU = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aps.zN().zU = -15;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aps.zN().zU = -12;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aps.zN().zU = -13;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aps.zN().zU = -10;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aps.zN().zU = -10;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aps);
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
    @Override // com.baidu.tbadk.core.util.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] yr() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.aps.zM().zP().asq != null && this.aps.zM().zP().asq.size() > 0 && !this.aps.zM().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.aps.zM().zP().mUrl);
                if (this.aps.zM().zP().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.aps.zM().zP().mUrl.endsWith("?") && !this.aps.zM().zP().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.aps.zM().zP().asq.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.aps.zM().zP().asq.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.aps.zM().zP().asq.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.aps.zM().zP().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.aps.zM().zP().ass || this.aps.zM().zP().mIsBDImage) && !this.aps.zM().mIsFromCDN) {
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
        if (this.goS.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.goS.b(str, z, 5, 100, -1, -1, yX());
        com.baidu.tieba.recapp.download.http.g bnC = this.goS.bnC();
        if (bnC == null) {
            return null;
        }
        iVar = bnC.bnE();
        if (bnC != null) {
            try {
                if (bnC.hY() == null || bnC.hY().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.aps.zN().zU = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW != null ? this.aps.zO().arW.zA : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zN().zU = -12;
                TiebaStatic.net(this.aps);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW != null ? this.aps.zO().arW.zA : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zN().zU = -13;
                TiebaStatic.net(this.aps);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW != null ? this.aps.zO().arW.zA : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zN().zU = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aps);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW != null ? this.aps.zO().arW.zA : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.aps.zN().zU = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.aps);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.aps.zN().zU = iVar.responseCode;
        if (this.aps.zN().zU != 200) {
            this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
            if (this.aps.zO().arW != null && !TextUtils.isEmpty(this.aps.zO().arW.zD)) {
                this.aps.zN().arV = this.aps.zO().arW.zD;
            } else {
                this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA);
            }
            TiebaStatic.net(this.aps);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > apx) {
                    this.aps.zN().zU = -11;
                    TiebaStatic.net(this.aps);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.IQ().fe(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.aps.zM().zP().mUrl + "], size:" + i2);
                            this.aps.zN().zU = -16;
                            TiebaStatic.net(this.aps);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ab.a aVar = new ab.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.jK());
        aVar.apN = this.aps.zO().arW.zy;
        aVar.mTime = new Date().getTime() - j;
        aVar.apO = this.aps.zO().arW.zA;
        aVar.apM = 2;
        ab.a(aVar);
        ab.apL.set(this.aps.zO().arW.zA);
        TiebaStatic.net(this.aps);
        bArr = iVar == null ? iVar.zW : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.r
    public String ys() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] yr = yr();
        if (yr == null || this.aps.zN().zU != 200) {
            return null;
        }
        try {
            this.aps.zM().zP().asu = TextUtils.isEmpty(this.aps.zM().zP().asu) ? "UTF-8" : this.aps.zM().zP().asu;
            str = new String(yr, 0, yr.length, this.aps.zM().zP().asu);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eC(str);
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

    @Override // com.baidu.tbadk.core.util.r
    public String yt() {
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
            if (this.aps.zM().zP().asq == null || i2 >= this.aps.zM().zP().asq.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.aps.zM().zP().asq.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.aps.zM().zP().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.goS.isCanceled()) {
                return null;
            }
            if (this.goS.b(this.aps.zM().zP().mUrl, this.aps.zM().zP().asq, this.aps.zM().zP().ass, 5, -1, yX()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bnC = this.goS.bnC();
            if (bnC == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bnE = bnC.bnE();
            if (bnC == null || bnC.hY() == null || bnC.hY().size() > 0) {
            }
            this.aps.zN().zU = bnE.responseCode;
            this.aps.zN().mHeader = bnE.zV;
            if (this.aps.zN().zU != 200) {
                if (this.aps.zO().arW != null && !TextUtils.isEmpty(this.aps.zO().arW.zD)) {
                    this.aps.zN().arV = this.aps.zO().arW.zD;
                } else {
                    this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA);
                }
                TiebaStatic.net(this.aps);
                return null;
            } else if (this.goS.isCanceled()) {
                return null;
            } else {
                str = new String(bnE.zW, IoUtils.UTF_8);
                try {
                    if (this.aps.zM().zP().mIsBaiduServer && this.aps.zM().zP().ast) {
                        eC(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jK());
                    aVar.apN = this.aps.zO().arW.zy;
                    aVar.mTime = this.aps.zO().arW.zB;
                    aVar.apO = this.aps.zO().arW.zA;
                    aVar.apM = 1;
                    ab.a(aVar);
                    ab.apL.set(this.aps.zO().arW.zA);
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    this.aps.zN().arV = String.valueOf(this.aps.zN().zU) + "|retryCount:" + (this.aps.zO().arW == null ? -1 : this.aps.zO().arW.zA) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.aps.zN().zU = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.aps.zN().zU = -15;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.aps.zN().zU = -12;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.aps.zN().zU = -13;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.aps.zN().zU = -10;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.aps);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.aps.zN().zU = -10;
                    this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.aps);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [794=5] */
    @Override // com.baidu.tbadk.core.util.r
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.goS.isCanceled()) {
                return false;
            }
            return this.goS.a(this.aps.zM().zP().mUrl, (z ? new File(str) : l.eb(str)).getAbsolutePath(), false, i2, i3, -1, -1, yX(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int apz = 0;
                int apA = 0;
                int apB = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.apz = i5 / 50;
                    }
                    this.apA += i4 - this.apB;
                    this.apB = i4;
                    if (handler != null) {
                        if (this.apA > this.apz || i4 == i5) {
                            this.apA = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.aps.zN().zU = -10;
            this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.aps.zN().zU = -15;
            this.aps.zN().mErrorString = this.mContext.getResources().getString(d.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.aps);
        }
    }
}
