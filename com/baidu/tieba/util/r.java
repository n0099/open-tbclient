package com.baidu.tieba.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.al;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private NetWorkCore f1467a = null;
    private NetWorkCore b = null;
    private boolean c = false;
    private boolean d = true;
    private v e = null;
    private int f = 0;

    private void m() {
        this.f1467a = new NetWorkCore();
        this.b = null;
        this.c = false;
        this.d = true;
    }

    public r() {
        m();
    }

    public void a(boolean z) {
        this.f1467a.a(z);
    }

    public void b(boolean z) {
        this.d = z;
    }

    public r(String str) {
        m();
        this.f1467a.a(str);
    }

    public r(Context context, String str) {
        m();
        this.f1467a.b(context);
        this.f1467a.a(str);
    }

    public void a(String str) {
        this.f1467a.a(str);
    }

    public String a() {
        return this.f1467a.f();
    }

    public void a(Context context) {
        this.f1467a.b(context);
    }

    public void a(ArrayList arrayList) {
        this.f1467a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f1467a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f1467a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f1467a.a(str, bArr);
    }

    public void c(boolean z) {
        this.f1467a.b(z);
    }

    private void n() {
        String F = TiebaApplication.F();
        if (F != null) {
            this.f1467a.a("BDUSS", F);
        }
    }

    private void o() {
        String F = TiebaApplication.F();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", F);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.f().O());
        z.a("NetWork", "modSessionData", "== BDUSS:" + F);
        z.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.f().O());
        if (F != null) {
            ArrayList t = this.f1467a.t();
            int size = t.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) t.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    t.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.n()) {
                    t.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.f1467a.p();
    }

    private void p() {
        this.f1467a.a("_client_type", "2");
        this.f1467a.a("_client_version", com.baidu.tieba.data.g.i());
        if (TiebaApplication.f().p() != null) {
            this.f1467a.a("_phone_imei", TiebaApplication.f().p());
        }
        String P = TiebaApplication.P();
        if (P != null) {
            this.f1467a.a("_client_id", P);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.f1467a.a("from", y);
        }
        String b = this.f1467a.b();
        if (b != null) {
            this.f1467a.a("net_type", b);
        }
        if (this.c) {
            this.f1467a.a("tbs", TiebaApplication.f().O());
        }
        String o = TiebaApplication.f().o();
        if (o != null) {
            this.f1467a.a("cuid", o);
        }
        this.f1467a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f1467a.a("model", Build.MODEL);
    }

    private void q() {
        if (this.e == null) {
            this.e = NetWorkCore.a();
        }
        if (this.e != null) {
            this.f1467a.a("stTime", String.valueOf(this.e.b));
            this.f1467a.a("stSize", String.valueOf(this.e.c));
            this.f1467a.a("stTimesNum", String.valueOf(this.e.d));
            this.f1467a.a("stMode", String.valueOf(this.e.e));
            this.f1467a.a("stMethod", String.valueOf(this.e.f1470a));
        }
        this.f = NetWorkCore.a(0);
        this.f1467a.a("stErrorNums", String.valueOf(this.f));
    }

    public boolean c() {
        return this.f1467a.g();
    }

    public boolean d() {
        return this.f1467a.h();
    }

    public int e() {
        return this.f1467a.i();
    }

    public String f() {
        return this.f1467a.b();
    }

    public String g() {
        return this.f1467a.j();
    }

    public void h() {
        if (this.f1467a != null) {
            this.f1467a.l();
        }
        if (this.b != null) {
            this.b.l();
        }
    }

    public al a(String str, String str2, boolean z) {
        String o;
        try {
            z.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.g.f787a);
            sb.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            if (this.b == null) {
                this.b = new NetWorkCore();
            } else {
                this.b.l();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.b(this.f1467a.s());
            o = this.b.o();
        } catch (Exception e) {
            z.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.g() && o != null) {
            al alVar = new al();
            alVar.a(o);
            String id = alVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.b(this.b.s().getString(R.string.neterror));
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
        if (this.b.h()) {
            switch (this.b.i()) {
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
                    this.b.k();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] i() {
        p();
        return this.f1467a.m();
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
                q = this.f1467a.n();
                break;
            case 2:
                n();
                p();
                q();
                q = this.f1467a.o();
                break;
            case 3:
                n();
                p();
                q = this.f1467a.q();
                break;
            default:
                return null;
        }
        if (!this.f1467a.h()) {
            NetWorkCore.a(this.e);
            NetWorkCore.b(this.f);
            return q;
        } else if (this.f1467a.g()) {
            return q;
        } else {
            if (this.f1467a.i() == 1 && this.d) {
                this.f1467a.k();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.f()).backgroundReLogin(TiebaApplication.H(), TiebaApplication.F(), new s(this), new t(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.c(TiebaApplication.H(), backgroundReLogin);
                        TiebaApplication.h(backgroundReLogin);
                        q = b(i);
                    } else {
                        q = null;
                    }
                } else {
                    AccountData G = TiebaApplication.G();
                    if (G == null) {
                        G = DatabaseService.p();
                    }
                    if (G == null) {
                        TiebaApplication.f().c.sendMessage(TiebaApplication.f().c.obtainMessage(1));
                        return null;
                    } else if (a(G.getAccount(), G.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f1467a.b(this.b.j());
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
                return this.f1467a.n();
            case 2:
                return this.f1467a.o();
            case 3:
                return this.f1467a.q();
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
        z.e("NetWork", "uploadImage", "upload image");
        byte[] bArr = null;
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
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        a("pic", bArr);
        return k();
    }

    public boolean l() {
        return this.f1467a.r();
    }

    public Boolean a(String str, Handler handler, int i) {
        n();
        return this.f1467a.a(str, handler, i);
    }

    public void d(boolean z) {
        this.c = z;
    }
}
