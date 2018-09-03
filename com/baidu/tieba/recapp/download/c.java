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
import com.baidu.tieba.f;
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
    private static int apy = 2097152;
    private final com.baidu.tbadk.core.util.a.a apt;
    private com.baidu.tieba.recapp.download.http.c goV = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.apt = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Override // com.baidu.tbadk.core.util.r
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.apt.zK().zN().asr != null) {
            this.apt.zK().zN().asr.clear();
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
    public ArrayList<BasicNameValuePair> yn() {
        return this.apt.zK().zN().asr;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.apt.zK().zN().asr == null) {
                this.apt.zK().zN().asr = new ArrayList<>();
            }
            int b = b(this.apt.zK().zN().asr, basicNameValuePair.getName());
            int size = this.apt.zK().zN().asr.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.apt.zK().zN().asr.get(b).getName())) {
                    this.apt.zK().zN().asr.set(b, basicNameValuePair);
                } else {
                    this.apt.zK().zN().asr.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.apt.zK().zN().asr.add(b, basicNameValuePair);
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

    @Override // com.baidu.tbadk.core.util.r
    public void d(String str, byte[] bArr) {
        if (this.apt.zK().zN().ass == null) {
            this.apt.zK().zN().ass = new HashMap<>();
        }
        this.apt.zK().zN().ass.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hN() {
        this.goV.cancel();
    }

    @Override // com.baidu.tbadk.core.util.r
    public void hQ() {
        if (this.goV != null) {
            this.goV.hQ();
        }
    }

    private LinkedList<BasicNameValuePair> yV() {
        if (this.apt != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.apt.zK().zN().asw)) {
                linkedList.add(new BasicNameValuePair("sid", this.apt.zK().zN().asw));
            }
            if (!TextUtils.isEmpty(this.apt.zK().zN().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.apt.zK().zN().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void eC(String str) {
        this.apt.zL().arV = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.apt.zL().arV = errorData.getError_code();
                if (this.apt.zL().arV == -1) {
                    this.apt.zL().mErrorString = this.mContext.getString(f.j.error_unkown_try_again);
                } else if (this.apt.zL().arV != 0) {
                    this.apt.zL().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.apt.zL().mErrorString = this.mContext.getString(f.j.error_unkown_try_again);
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
    public String yo() {
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
            if (this.apt.zK().zN().asr == null || i2 >= this.apt.zK().zN().asr.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.apt.zK().zN().asr.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.apt.zK().zN().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.goV.isCanceled()) {
                return null;
            }
            if (this.goV.b(this.apt.zK().zN().mUrl, this.apt.zK().zN().asr, this.apt.zK().zN().ast, 5, -1, yV()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bnD = this.goV.bnD();
            if (bnD == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bnF = bnD.bnF();
            if (bnD == null || bnD.hY() == null || bnD.hY().size() > 0) {
            }
            this.apt.zL().zV = bnF.responseCode;
            this.apt.zL().mHeader = bnF.zW;
            if (this.apt.zL().zV != 200) {
                if (this.apt.zM().arX != null && !TextUtils.isEmpty(this.apt.zM().arX.zE)) {
                    this.apt.zL().arW = this.apt.zM().arX.zE;
                } else {
                    this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB);
                }
                TiebaStatic.net(this.apt);
                return null;
            } else if (this.goV.isCanceled()) {
                return null;
            } else {
                str = new String(bnF.zX, IoUtils.UTF_8);
                try {
                    if (this.apt.zK().zN().mIsBaiduServer && this.apt.zK().zN().asu) {
                        eC(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jK());
                    aVar.apO = this.apt.zM().arX.zz;
                    aVar.mTime = this.apt.zM().arX.zC;
                    aVar.apP = this.apt.zM().arX.zB;
                    aVar.apN = 1;
                    ab.a(aVar);
                    ab.apM.set(this.apt.zM().arX.zB);
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.apt.zL().zV = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.apt.zL().zV = -15;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.apt.zL().zV = -12;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.apt.zL().zV = -13;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.apt.zL().zV = -10;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.apt.zL().zV = -10;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.apt);
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
    public byte[] yp() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.apt.zK().zN().asr != null && this.apt.zK().zN().asr.size() > 0 && !this.apt.zK().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.apt.zK().zN().mUrl);
                if (this.apt.zK().zN().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.apt.zK().zN().mUrl.endsWith("?") && !this.apt.zK().zN().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.apt.zK().zN().asr.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.apt.zK().zN().asr.get(i).getName());
                    sb.append("=");
                    sb.append(ap.bh(this.apt.zK().zN().asr.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.apt.zK().zN().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.apt.zK().zN().ast || this.apt.zK().zN().mIsBDImage) && !this.apt.zK().mIsFromCDN) {
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
        if (this.goV.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.goV.b(str, z, 5, 100, -1, -1, yV());
        com.baidu.tieba.recapp.download.http.g bnD = this.goV.bnD();
        if (bnD == null) {
            return null;
        }
        iVar = bnD.bnF();
        if (bnD != null) {
            try {
                if (bnD.hY() == null || bnD.hY().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.apt.zL().zV = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX != null ? this.apt.zM().arX.zB : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apt.zL().zV = -12;
                TiebaStatic.net(this.apt);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX != null ? this.apt.zM().arX.zB : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apt.zL().zV = -13;
                TiebaStatic.net(this.apt);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror) + " detailException:" + e.getMessage();
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX != null ? this.apt.zM().arX.zB : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apt.zL().zV = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.apt);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.memoryerror);
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX != null ? this.apt.zM().arX.zB : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.apt.zL().zV = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.apt);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.apt.zL().zV = iVar.responseCode;
        if (this.apt.zL().zV != 200) {
            this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
            if (this.apt.zM().arX != null && !TextUtils.isEmpty(this.apt.zM().arX.zE)) {
                this.apt.zL().arW = this.apt.zM().arX.zE;
            } else {
                this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB);
            }
            TiebaStatic.net(this.apt);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > apy) {
                    this.apt.zL().zV = -11;
                    TiebaStatic.net(this.apt);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.IQ().fd(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.apt.zK().zN().mUrl + "], size:" + i2);
                            this.apt.zL().zV = -16;
                            TiebaStatic.net(this.apt);
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
        aVar.apO = this.apt.zM().arX.zz;
        aVar.mTime = new Date().getTime() - j;
        aVar.apP = this.apt.zM().arX.zB;
        aVar.apN = 2;
        ab.a(aVar);
        ab.apM.set(this.apt.zM().arX.zB);
        TiebaStatic.net(this.apt);
        bArr = iVar == null ? iVar.zX : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.r
    public String yq() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] yp = yp();
        if (yp == null || this.apt.zL().zV != 200) {
            return null;
        }
        try {
            this.apt.zK().zN().asv = TextUtils.isEmpty(this.apt.zK().zN().asv) ? "UTF-8" : this.apt.zK().zN().asv;
            str = new String(yp, 0, yp.length, this.apt.zK().zN().asv);
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
    public String yr() {
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
            if (this.apt.zK().zN().asr == null || i2 >= this.apt.zK().zN().asr.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.apt.zK().zN().asr.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.apt.zK().zN().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bm(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.goV.isCanceled()) {
                return null;
            }
            if (this.goV.b(this.apt.zK().zN().mUrl, this.apt.zK().zN().asr, this.apt.zK().zN().ast, 5, -1, yV()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bnD = this.goV.bnD();
            if (bnD == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bnF = bnD.bnF();
            if (bnD == null || bnD.hY() == null || bnD.hY().size() > 0) {
            }
            this.apt.zL().zV = bnF.responseCode;
            this.apt.zL().mHeader = bnF.zW;
            if (this.apt.zL().zV != 200) {
                if (this.apt.zM().arX != null && !TextUtils.isEmpty(this.apt.zM().arX.zE)) {
                    this.apt.zL().arW = this.apt.zM().arX.zE;
                } else {
                    this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB);
                }
                TiebaStatic.net(this.apt);
                return null;
            } else if (this.goV.isCanceled()) {
                return null;
            } else {
                str = new String(bnF.zX, IoUtils.UTF_8);
                try {
                    if (this.apt.zK().zN().mIsBaiduServer && this.apt.zK().zN().asu) {
                        eC(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.jK());
                    aVar.apO = this.apt.zM().arX.zz;
                    aVar.mTime = this.apt.zM().arX.zC;
                    aVar.apP = this.apt.zM().arX.zB;
                    aVar.apN = 1;
                    ab.a(aVar);
                    ab.apM.set(this.apt.zM().arX.zB);
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    this.apt.zL().arW = String.valueOf(this.apt.zL().zV) + "|retryCount:" + (this.apt.zM().arX == null ? -1 : this.apt.zM().arX.zB) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.apt.zL().zV = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.apt.zL().zV = -15;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.apt.zL().zV = -12;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.apt.zL().zV = -13;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.apt.zL().zV = -10;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.apt);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.apt.zL().zV = -10;
                    this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.apt);
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
            if (this.goV.isCanceled()) {
                return false;
            }
            return this.goV.a(this.apt.zK().zN().mUrl, (z ? new File(str) : l.eb(str)).getAbsolutePath(), false, i2, i3, -1, -1, yV(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int apA = 0;
                int apB = 0;
                int apC = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void m(int i4, int i5) {
                    if (i5 > 0) {
                        this.apA = i5 / 50;
                    }
                    this.apB += i4 - this.apC;
                    this.apC = i4;
                    if (handler != null) {
                        if (this.apB > this.apA || i4 == i5) {
                            this.apB = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.apt.zL().zV = -10;
            this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.apt.zL().zV = -15;
            this.apt.zL().mErrorString = this.mContext.getResources().getString(f.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.apt);
        }
    }
}
