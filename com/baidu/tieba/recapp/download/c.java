package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.q;
import com.baidu.tieba.e;
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
    private static int arW = 2097152;
    private final com.baidu.tbadk.core.util.a.a arQ;
    private com.baidu.tieba.recapp.download.http.c gwn = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public c(com.baidu.tbadk.core.util.a.a aVar) {
        this.arQ = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aR((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.adq : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void p(ArrayList<BasicNameValuePair> arrayList) {
        if (this.arQ.AP().AS().auP != null) {
            this.arQ.AP().AS().auP.clear();
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
    public ArrayList<BasicNameValuePair> zs() {
        return this.arQ.AP().AS().auP;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.arQ.AP().AS().auP == null) {
                this.arQ.AP().AS().auP = new ArrayList<>();
            }
            int b = b(this.arQ.AP().AS().auP, basicNameValuePair.getName());
            int size = this.arQ.AP().AS().auP.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.arQ.AP().AS().auP.get(b).getName())) {
                    this.arQ.AP().AS().auP.set(b, basicNameValuePair);
                } else {
                    this.arQ.AP().AS().auP.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.arQ.AP().AS().auP.add(b, basicNameValuePair);
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
        if (this.arQ.AP().AS().auQ == null) {
            this.arQ.AP().AS().auQ = new HashMap<>();
        }
        this.arQ.AP().AS().auQ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void iT() {
        this.gwn.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void iW() {
        if (this.gwn != null) {
            this.gwn.iW();
        }
    }

    private LinkedList<BasicNameValuePair> Aa() {
        if (this.arQ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.arQ.AP().AS().auU)) {
                linkedList.add(new BasicNameValuePair("sid", this.arQ.AP().AS().auU));
            }
            if (!TextUtils.isEmpty(this.arQ.AP().AS().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.arQ.AP().AS().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void eU(String str) {
        this.arQ.AQ().aut = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.arQ.AQ().aut = errorData.getError_code();
                if (this.arQ.AQ().aut == -1) {
                    this.arQ.AQ().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
                } else if (this.arQ.AQ().aut != 0) {
                    this.arQ.AQ().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.arQ.AQ().mErrorString = this.mContext.getString(e.j.error_unkown_try_again);
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
    public String zt() {
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
            if (this.arQ.AP().AS().auP == null || i2 >= this.arQ.AP().AS().auP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.arQ.AP().AS().auP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.arQ.AP().AS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            u("sign", s.bD(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gwn.isCanceled()) {
                return null;
            }
            if (this.gwn.b(this.arQ.AP().AS().mUrl, this.arQ.AP().AS().auP, this.arQ.AP().AS().auR, 5, -1, Aa()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bqk = this.gwn.bqk();
            if (bqk == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bqm = bqk.bqm();
            if (bqk == null || bqk.je() == null || bqk.je().size() > 0) {
            }
            this.arQ.AQ().Cq = bqm.responseCode;
            this.arQ.AQ().mHeader = bqm.Cr;
            if (this.arQ.AQ().Cq != 200) {
                if (this.arQ.AR().auv != null && !TextUtils.isEmpty(this.arQ.AR().auv.BZ)) {
                    this.arQ.AQ().auu = this.arQ.AR().auv.BZ;
                } else {
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
                }
                TiebaStatic.net(this.arQ);
                return null;
            } else if (this.gwn.isCanceled()) {
                return null;
            } else {
                str = new String(bqm.Cs, IoUtils.UTF_8);
                try {
                    if (this.arQ.AP().AS().mIsBaiduServer && this.arQ.AP().AS().auS) {
                        eU(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.kQ());
                    aVar.asm = this.arQ.AR().auv.BU;
                    aVar.mTime = this.arQ.AR().auv.BX;
                    aVar.asn = this.arQ.AR().auv.BW;
                    aVar.asl = 1;
                    aa.a(aVar);
                    aa.ask.set(this.arQ.AR().auv.BW);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.arQ.AQ().Cq = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.arQ.AQ().Cq = -15;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.arQ.AQ().Cq = -12;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.arQ.AQ().Cq = -13;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.arQ);
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
    public byte[] zu() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.arQ.AP().AS().auP != null && this.arQ.AP().AS().auP.size() > 0 && !this.arQ.AP().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.arQ.AP().AS().mUrl);
                if (this.arQ.AP().AS().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.arQ.AP().AS().mUrl.endsWith("?") && !this.arQ.AP().AS().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.arQ.AP().AS().auP.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.arQ.AP().AS().auP.get(i).getName());
                    sb.append("=");
                    sb.append(ao.by(this.arQ.AP().AS().auP.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.arQ.AP().AS().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.arQ.AP().AS().auR || this.arQ.AP().AS().mIsBDImage) && !this.arQ.AP().mIsFromCDN) {
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
        if (this.gwn.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.gwn.b(str, z, 5, 100, -1, -1, Aa());
        com.baidu.tieba.recapp.download.http.g bqk = this.gwn.bqk();
        if (bqk == null) {
            return null;
        }
        iVar = bqk.bqm();
        if (bqk != null) {
            try {
                if (bqk.je() == null || bqk.je().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.arQ.AQ().Cq = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -12;
                TiebaStatic.net(this.arQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -13;
                TiebaStatic.net(this.arQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.arQ);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv != null ? this.arQ.AR().auv.BW : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.arQ.AQ().Cq = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.arQ);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.arQ.AQ().Cq = iVar.responseCode;
        if (this.arQ.AQ().Cq != 200) {
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
            if (this.arQ.AR().auv != null && !TextUtils.isEmpty(this.arQ.AR().auv.BZ)) {
                this.arQ.AQ().auu = this.arQ.AR().auv.BZ;
            } else {
                this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
            }
            TiebaStatic.net(this.arQ);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > arW) {
                    this.arQ.AQ().Cq = -11;
                    TiebaStatic.net(this.arQ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.Kg().fp(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.arQ.AP().AS().mUrl + "], size:" + i2);
                            this.arQ.AQ().Cq = -16;
                            TiebaStatic.net(this.arQ);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.kQ());
        aVar.asm = this.arQ.AR().auv.BU;
        aVar.mTime = new Date().getTime() - j;
        aVar.asn = this.arQ.AR().auv.BW;
        aVar.asl = 2;
        aa.a(aVar);
        aa.ask.set(this.arQ.AR().auv.BW);
        TiebaStatic.net(this.arQ);
        bArr = iVar == null ? iVar.Cs : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String zv() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] zu = zu();
        if (zu == null || this.arQ.AQ().Cq != 200) {
            return null;
        }
        try {
            this.arQ.AP().AS().auT = TextUtils.isEmpty(this.arQ.AP().AS().auT) ? "UTF-8" : this.arQ.AP().AS().auT;
            str = new String(zu, 0, zu.length, this.arQ.AP().AS().auT);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            eU(str);
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
    public String zw() {
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
            if (this.arQ.AP().AS().auP == null || i2 >= this.arQ.AP().AS().auP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.arQ.AP().AS().auP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.arQ.AP().AS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            u("sign", s.bD(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.gwn.isCanceled()) {
                return null;
            }
            if (this.gwn.b(this.arQ.AP().AS().mUrl, this.arQ.AP().AS().auP, this.arQ.AP().AS().auR, 5, -1, Aa()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g bqk = this.gwn.bqk();
            if (bqk == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i bqm = bqk.bqm();
            if (bqk == null || bqk.je() == null || bqk.je().size() > 0) {
            }
            this.arQ.AQ().Cq = bqm.responseCode;
            this.arQ.AQ().mHeader = bqm.Cr;
            if (this.arQ.AQ().Cq != 200) {
                if (this.arQ.AR().auv != null && !TextUtils.isEmpty(this.arQ.AR().auv.BZ)) {
                    this.arQ.AQ().auu = this.arQ.AR().auv.BZ;
                } else {
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW);
                }
                TiebaStatic.net(this.arQ);
                return null;
            } else if (this.gwn.isCanceled()) {
                return null;
            } else {
                str = new String(bqm.Cs, IoUtils.UTF_8);
                try {
                    if (this.arQ.AP().AS().mIsBaiduServer && this.arQ.AP().AS().auS) {
                        eU(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.kQ());
                    aVar.asm = this.arQ.AR().auv.BU;
                    aVar.mTime = this.arQ.AR().auv.BX;
                    aVar.asn = this.arQ.AR().auv.BW;
                    aVar.asl = 1;
                    aa.a(aVar);
                    aa.ask.set(this.arQ.AR().auv.BW);
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    this.arQ.AQ().auu = String.valueOf(this.arQ.AQ().Cq) + "|retryCount:" + (this.arQ.AR().auv == null ? -1 : this.arQ.AR().auv.BW) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.arQ.AQ().Cq = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.arQ.AQ().Cq = -15;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.arQ.AQ().Cq = -12;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.arQ.AQ().Cq = -13;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.arQ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.arQ.AQ().Cq = -10;
                    this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.arQ);
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
            if (this.gwn.isCanceled()) {
                return false;
            }
            return this.gwn.a(this.arQ.AP().AS().mUrl, (z ? new File(str) : l.et(str)).getAbsolutePath(), false, i2, i3, -1, -1, Aa(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.c.1
                int arY = 0;
                int arZ = 0;
                int asa = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.arY = i5 / 50;
                    }
                    this.arZ += i4 - this.asa;
                    this.asa = i4;
                    if (handler != null) {
                        if (this.arZ > this.arY || i4 == i5) {
                            this.arZ = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.arQ.AQ().Cq = -10;
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.arQ.AQ().Cq = -15;
            this.arQ.AQ().mErrorString = this.mContext.getResources().getString(e.j.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.arQ);
        }
    }
}
