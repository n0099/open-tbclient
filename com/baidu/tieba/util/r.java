package com.baidu.tieba.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.al;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class r {
    public String a;
    public String b;
    private NetWorkCore c = null;
    private NetWorkCore d = null;
    private boolean e = false;
    private boolean f = true;
    private v g = null;
    private int h = 0;

    private void m() {
        this.c = new NetWorkCore();
        this.d = null;
        this.e = false;
        this.f = true;
    }

    public r() {
        m();
    }

    public void a(boolean z) {
        this.c.a(z);
    }

    public void b(boolean z) {
        this.f = z;
    }

    public r(String str) {
        m();
        this.c.a(str);
    }

    public r(Context context, String str) {
        m();
        this.c.b(context);
        this.c.a(str);
    }

    public void a(String str) {
        this.c.a(str);
    }

    public String a() {
        return this.c.f();
    }

    public void a(Context context) {
        this.c.b(context);
    }

    public void a(ArrayList arrayList) {
        this.c.a(arrayList);
    }

    public void a(String str, String str2) {
        this.c.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.c.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.c.a(str, bArr);
    }

    public void c(boolean z) {
        this.c.b(z);
    }

    private void n() {
        String E = this.a == null ? TiebaApplication.E() : this.a;
        if (E != null) {
            this.c.a("BDUSS", E);
        }
    }

    private void o() {
        String E = this.a == null ? TiebaApplication.E() : this.a;
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", E);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", this.b == null ? TiebaApplication.f().N() : this.b);
        z.a("NetWork", "modSessionData", "== BDUSS:" + E);
        z.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.f().N());
        if (E != null) {
            ArrayList t = this.c.t();
            int size = t.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) t.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    t.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.m()) {
                    t.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.c.p();
    }

    private void p() {
        this.c.a("_client_type", "2");
        this.c.a("_client_version", com.baidu.tieba.data.g.i());
        if (TiebaApplication.f().o() != null) {
            this.c.a("_phone_imei", TiebaApplication.f().o());
        }
        String O = TiebaApplication.O();
        if (O != null) {
            this.c.a("_client_id", O);
        }
        String x = TiebaApplication.x();
        if (x != null && x.length() > 0) {
            this.c.a("from", x);
        }
        String b = this.c.b();
        if (b != null) {
            this.c.a("net_type", b);
        }
        if (this.e) {
            this.c.a("tbs", this.b == null ? TiebaApplication.f().N() : this.b);
        }
        String n = TiebaApplication.f().n();
        if (n != null) {
            this.c.a("cuid", n);
        }
        this.c.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.c.a("model", Build.MODEL);
    }

    private void q() {
        if (this.g == null) {
            this.g = NetWorkCore.a();
        }
        if (this.g != null) {
            this.c.a("stTime", String.valueOf(this.g.b));
            this.c.a("stSize", String.valueOf(this.g.c));
            this.c.a("stTimesNum", String.valueOf(this.g.d));
            this.c.a("stMode", String.valueOf(this.g.e));
            this.c.a("stMethod", String.valueOf(this.g.a));
        }
        this.h = NetWorkCore.a(0);
        this.c.a("stErrorNums", String.valueOf(this.h));
    }

    public boolean c() {
        return this.c.g();
    }

    public boolean d() {
        return this.c.h();
    }

    public int e() {
        return this.c.i();
    }

    public String f() {
        return this.c.b();
    }

    public String g() {
        return this.c.j();
    }

    public void h() {
        if (this.c != null) {
            this.c.l();
        }
        if (this.d != null) {
            this.d.l();
        }
    }

    public al a(String str, String str2, boolean z) {
        String o;
        try {
            z.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.g.a);
            sb.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            if (this.d == null) {
                this.d = new NetWorkCore();
            } else {
                this.d.l();
            }
            this.d.a(sb.toString());
            this.d.a(arrayList);
            this.d.a((Boolean) true);
            this.d.b(this.c.s());
            o = this.d.o();
        } catch (Exception e) {
            z.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.d.g() && o != null) {
            al alVar = new al();
            alVar.a(o);
            String id = alVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.d.b(this.d.s().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(alVar.a().getName());
            if (alVar.a().getPassword() != null) {
                accountData.setPassword(alVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(alVar.a().getId());
            accountData.setBDUSS(alVar.a().getBDUSS());
            accountData.setIsActive(1);
            if (alVar.b() != null) {
                accountData.setTbs(alVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.b(accountData);
            com.baidu.tieba.account.a.a().b();
            return alVar;
        }
        if (this.d.h()) {
            switch (this.d.i()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.f().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.f().c.sendMessage(obtainMessage);
                    }
                    this.d.k();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] i() {
        p();
        return this.c.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        TiebaApplication.a((AccountData) null);
        TiebaApplication.f().c.sendMessage(TiebaApplication.f().c.obtainMessage(1));
    }

    private String a(int i) {
        String q;
        switch (i) {
            case 1:
                p();
                q();
                q = this.c.n();
                break;
            case 2:
                n();
                p();
                q();
                q = this.c.o();
                break;
            case 3:
                n();
                p();
                q = this.c.q();
                break;
            default:
                return null;
        }
        if (!this.c.h()) {
            NetWorkCore.a(this.g);
            NetWorkCore.b(this.h);
            return q;
        } else if (this.c.g()) {
            return q;
        } else {
            if (this.c.i() == 1 && this.f) {
                this.c.k();
                if (TiebaApplication.m()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.f()).backgroundReLogin(TiebaApplication.G(), this.a == null ? TiebaApplication.E() : this.a, new s(this), new t(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.c(TiebaApplication.G(), backgroundReLogin);
                        TiebaApplication.i(backgroundReLogin);
                        q = b(i);
                    } else {
                        q = null;
                    }
                } else {
                    AccountData F = TiebaApplication.F();
                    if (F == null) {
                        F = DatabaseService.p();
                    }
                    if (F == null) {
                        TiebaApplication.f().c.sendMessage(TiebaApplication.f().c.obtainMessage(1));
                        return null;
                    } else if (a(F.getAccount(), F.getPassword(), true) == null) {
                        if (this.d != null) {
                            this.c.b(this.d.j());
                            return null;
                        }
                        return null;
                    } else {
                        q = b(i);
                    }
                }
            }
            return q;
        }
    }

    private String b(int i) {
        o();
        switch (i) {
            case 1:
                return this.c.n();
            case 2:
                return this.c.o();
            case 3:
                return this.c.q();
            default:
                return null;
        }
    }

    public String j() {
        return a(2);
    }

    public String k() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        z.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream g = m.g(str);
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
        return k();
    }

    public boolean l() {
        return this.c.r();
    }

    public Boolean a(String str, Handler handler, int i) {
        n();
        return this.c.a(str, handler, i);
    }

    public void d(boolean z) {
        this.e = z;
    }
}
