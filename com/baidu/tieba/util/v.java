package com.baidu.tieba.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private s f1810a = null;
    private s b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private final ad f = new ad();
    private af g = null;
    private int h = 0;

    private void n() {
        this.f1810a = ac.a().a(this.f);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public v() {
        n();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f1810a.a(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public v(String str) {
        n();
        this.f1810a.a(str);
    }

    public v(Context context, String str) {
        n();
        this.f1810a.a(context);
        this.f1810a.a(str);
    }

    public void a(String str) {
        this.f1810a.a(str);
    }

    public void a(Context context) {
        this.f1810a.a(context);
    }

    public Context a() {
        return this.f1810a.j();
    }

    public void a(ArrayList arrayList) {
        this.f1810a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f1810a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f1810a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f1810a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f1810a.b(z);
    }

    private void o() {
        String G = TiebaApplication.G();
        if (G != null && this.d) {
            this.f1810a.a("BDUSS", G);
        }
    }

    private void p() {
        String G = TiebaApplication.G();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", G);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().P());
        aq.a("NetWork", "modSessionData", "== BDUSS:" + G);
        aq.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().P());
        if (G != null) {
            ArrayList k = this.f1810a.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) k.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    k.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.p()) {
                    k.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.f1810a.l();
    }

    private void q() {
        this.f1810a.a("_client_type", "2");
        this.f1810a.a("_client_version", com.baidu.tieba.data.g.j());
        if (TiebaApplication.g().r() != null) {
            this.f1810a.a("_phone_imei", TiebaApplication.g().r());
        }
        String Q = TiebaApplication.Q();
        if (Q != null) {
            this.f1810a.a("_client_id", Q);
        }
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.f1810a.a("from", A);
        }
        String m = this.f1810a.m();
        if (m != null) {
            this.f1810a.a("net_type", m);
        }
        if (this.c) {
            this.f1810a.a("tbs", TiebaApplication.g().P());
        }
        String q = TiebaApplication.g().q();
        if (q != null) {
            this.f1810a.a("cuid", q);
        }
        this.f1810a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f1810a.a("model", Build.MODEL);
    }

    private void r() {
        if (this.g == null) {
            this.g = ae.a();
        }
        if (this.g != null) {
            this.f1810a.a("stTime", String.valueOf(this.g.b));
            this.f1810a.a("stSize", String.valueOf(this.g.c));
            this.f1810a.a("stTimesNum", String.valueOf(this.g.d));
            this.f1810a.a("stMode", String.valueOf(this.g.e));
            this.f1810a.a("stMethod", String.valueOf(this.g.f1780a));
        }
        this.h = ae.a(0);
        if (this.h == 0 && this.g != null) {
            this.h = this.g.d;
        }
        this.f1810a.a("stErrorNums", String.valueOf(this.h));
    }

    public boolean c() {
        return this.f1810a.n();
    }

    public boolean d() {
        return this.f1810a.o();
    }

    public int e() {
        return this.f1810a.i();
    }

    public String f() {
        return this.f1810a.m();
    }

    public String g() {
        return this.f1810a.p();
    }

    public void h() {
        if (this.f1810a != null) {
            this.f1810a.q();
        }
        if (this.b != null) {
            this.b.q();
        }
    }

    public com.baidu.tieba.model.as a(String str, String str2, boolean z) {
        String r;
        try {
            aq.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.g.f1014a);
            sb.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().aY()));
            if (this.b == null) {
                this.b = ac.a().a(new ad());
            } else {
                this.b.q();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.f1810a.j());
            r = this.b.r();
        } catch (Exception e) {
            aq.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.n() && r != null) {
            com.baidu.tieba.model.as asVar = new com.baidu.tieba.model.as();
            asVar.a(r);
            String id = asVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.b(this.b.j().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(asVar.a().getName());
            if (asVar.a().getPassword() != null) {
                accountData.setPassword(asVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(asVar.a().getId());
            accountData.setBDUSS(asVar.a().getBDUSS());
            accountData.setIsActive(1);
            if (asVar.b() != null) {
                accountData.setTbs(asVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, a());
            com.baidu.tieba.account.a.a().b();
            return asVar;
        }
        if (this.b.o()) {
            switch (this.b.i()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.g().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.g().c.sendMessage(obtainMessage);
                    }
                    this.b.s();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] i() {
        q();
        return this.f1810a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        TiebaApplication.a((AccountData) null, a());
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
    }

    private String a(int i) {
        String v;
        switch (i) {
            case 1:
                q();
                r();
                v = this.f1810a.u();
                break;
            case 2:
                o();
                q();
                r();
                v = this.f1810a.r();
                break;
            case 3:
                o();
                q();
                v = this.f1810a.v();
                break;
            default:
                return null;
        }
        if (v == null && ac.f1777a == 1) {
            this.f1810a = new NetWorkCore(this.f);
            switch (i) {
                case 1:
                    q();
                    r();
                    v = this.f1810a.u();
                    break;
                case 2:
                    o();
                    q();
                    r();
                    v = this.f1810a.r();
                    break;
                case 3:
                    o();
                    q();
                    v = this.f1810a.v();
                    break;
                default:
                    return null;
            }
            if (v != null) {
                ac.b();
            }
        }
        if (!this.f1810a.o()) {
            ae.a(this.g);
            ae.b(this.h);
            return v;
        } else if (this.f1810a.n()) {
            return v;
        } else {
            if (this.f1810a.i() == 1 && this.e) {
                this.f1810a.s();
                if (TiebaApplication.p()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.I(), TiebaApplication.G(), new w(this), new x(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.I(), backgroundReLogin);
                        TiebaApplication.k(backgroundReLogin);
                        v = b(i);
                    } else {
                        v = null;
                    }
                } else {
                    AccountData H = TiebaApplication.H();
                    if (H == null) {
                        H = DatabaseService.n();
                    }
                    if (H == null) {
                        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
                        return null;
                    } else if (a(H.getAccount(), H.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f1810a.b(this.b.p());
                            return null;
                        }
                        return null;
                    } else {
                        v = b(i);
                    }
                }
            }
            return v;
        }
    }

    private String b(int i) {
        p();
        switch (i) {
            case 1:
                return this.f1810a.u();
            case 2:
                return this.f1810a.r();
            case 3:
                return this.f1810a.v();
            default:
                return null;
        }
    }

    public String j() {
        return a(2);
    }

    public String k() {
        return a(1);
    }

    public String l() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        aq.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream g = p.g(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = g.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        a("pic", bArr);
        return l();
    }

    public boolean m() {
        return this.f1810a.w();
    }

    public Boolean a(String str, Handler handler, int i) {
        o();
        return this.f1810a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }
}
