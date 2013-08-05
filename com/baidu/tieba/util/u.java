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
public class u {

    /* renamed from: a  reason: collision with root package name */
    private NetWorkCore f1775a = null;
    private NetWorkCore b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private y f = null;
    private int g = 0;

    private void o() {
        this.f1775a = new NetWorkCore();
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public u() {
        o();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f1775a.a(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public u(String str) {
        o();
        this.f1775a.a(str);
    }

    public u(Context context, String str) {
        o();
        this.f1775a.b(context);
        this.f1775a.a(str);
    }

    public void a(String str) {
        this.f1775a.a(str);
    }

    public String a() {
        return this.f1775a.m();
    }

    public void a(Context context) {
        this.f1775a.b(context);
    }

    public Context b() {
        return this.f1775a.z();
    }

    public void a(ArrayList arrayList) {
        this.f1775a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f1775a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f1775a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f1775a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f1775a.b(z);
    }

    private void p() {
        String G = TiebaApplication.G();
        if (G != null && this.d) {
            this.f1775a.a("BDUSS", G);
        }
    }

    private void q() {
        String G = TiebaApplication.G();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", G);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.f().P());
        aj.a("NetWork", "modSessionData", "== BDUSS:" + G);
        aj.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.f().P());
        if (G != null) {
            ArrayList A = this.f1775a.A();
            int size = A.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = (BasicNameValuePair) A.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    A.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.n()) {
                    A.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int c() {
        return this.f1775a.w();
    }

    private void r() {
        this.f1775a.a("_client_type", "2");
        this.f1775a.a("_client_version", com.baidu.tieba.data.g.i());
        if (TiebaApplication.f().p() != null) {
            this.f1775a.a("_phone_imei", TiebaApplication.f().p());
        }
        String Q = TiebaApplication.Q();
        if (Q != null) {
            this.f1775a.a("_client_id", Q);
        }
        String A = TiebaApplication.A();
        if (A != null && A.length() > 0) {
            this.f1775a.a("from", A);
        }
        String i = this.f1775a.i();
        if (i != null) {
            this.f1775a.a("net_type", i);
        }
        if (this.c) {
            this.f1775a.a("tbs", TiebaApplication.f().P());
        }
        String o = TiebaApplication.f().o();
        if (o != null) {
            this.f1775a.a("cuid", o);
        }
        this.f1775a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f1775a.a("model", Build.MODEL);
    }

    private void s() {
        if (this.f == null) {
            this.f = NetWorkCore.h();
        }
        if (this.f != null) {
            this.f1775a.a("stTime", String.valueOf(this.f.b));
            this.f1775a.a("stSize", String.valueOf(this.f.c));
            this.f1775a.a("stTimesNum", String.valueOf(this.f.d));
            this.f1775a.a("stMode", String.valueOf(this.f.e));
            this.f1775a.a("stMethod", String.valueOf(this.f.f1778a));
        }
        this.g = NetWorkCore.a(0);
        this.f1775a.a("stErrorNums", String.valueOf(this.g));
    }

    public boolean d() {
        return this.f1775a.n();
    }

    public boolean e() {
        return this.f1775a.o();
    }

    public int f() {
        return this.f1775a.p();
    }

    public String g() {
        return this.f1775a.i();
    }

    public String h() {
        return this.f1775a.q();
    }

    public void i() {
        if (this.f1775a != null) {
            this.f1775a.s();
        }
        if (this.b != null) {
            this.b.s();
        }
    }

    public com.baidu.tieba.model.at a(String str, String str2, boolean z) {
        String v;
        try {
            aj.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.g.f1013a);
            sb.append("c/s/login");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.f().bj()));
            if (this.b == null) {
                this.b = new NetWorkCore();
            } else {
                this.b.s();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.b(this.f1775a.z());
            v = this.b.v();
        } catch (Exception e) {
            aj.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.n() && v != null) {
            com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
            atVar.a(v);
            String id = atVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.b(this.b.z().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(atVar.a().getName());
            if (atVar.a().getPassword() != null) {
                accountData.setPassword(atVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(atVar.a().getId());
            accountData.setBDUSS(atVar.a().getBDUSS());
            accountData.setIsActive(1);
            if (atVar.b() != null) {
                accountData.setTbs(atVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, b());
            com.baidu.tieba.account.a.a().b();
            return atVar;
        }
        if (this.b.o()) {
            switch (this.b.p()) {
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
                    this.b.r();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] j() {
        r();
        return this.f1775a.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        TiebaApplication.a((AccountData) null, b());
        TiebaApplication.f().c.sendMessage(TiebaApplication.f().c.obtainMessage(1));
    }

    private String a(int i) {
        String x;
        switch (i) {
            case 1:
                r();
                s();
                x = this.f1775a.u();
                break;
            case 2:
                p();
                r();
                s();
                x = this.f1775a.v();
                break;
            case 3:
                p();
                r();
                x = this.f1775a.x();
                break;
            default:
                return null;
        }
        if (!this.f1775a.o()) {
            NetWorkCore.a(this.f);
            NetWorkCore.b(this.g);
            return x;
        } else if (this.f1775a.n()) {
            return x;
        } else {
            if (this.f1775a.p() == 1 && this.e) {
                this.f1775a.r();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.f()).backgroundReLogin(TiebaApplication.I(), TiebaApplication.G(), new v(this), new w(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.c(TiebaApplication.I(), backgroundReLogin);
                        TiebaApplication.h(backgroundReLogin);
                        x = b(i);
                    } else {
                        x = null;
                    }
                } else {
                    AccountData H = TiebaApplication.H();
                    if (H == null) {
                        H = DatabaseService.p();
                    }
                    if (H == null) {
                        TiebaApplication.f().c.sendMessage(TiebaApplication.f().c.obtainMessage(1));
                        return null;
                    } else if (a(H.getAccount(), H.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f1775a.b(this.b.q());
                            return null;
                        }
                        return null;
                    } else {
                        x = b(i);
                    }
                }
            }
            return x;
        }
    }

    private String b(int i) {
        q();
        switch (i) {
            case 1:
                return this.f1775a.u();
            case 2:
                return this.f1775a.v();
            case 3:
                return this.f1775a.x();
            default:
                return null;
        }
    }

    public String k() {
        return a(2);
    }

    public String l() {
        return a(1);
    }

    public String m() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        aj.e("NetWork", "uploadImage", "upload image");
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
        return m();
    }

    public boolean n() {
        return this.f1775a.y();
    }

    public Boolean a(String str, Handler handler, int i) {
        p();
        return this.f1775a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }
}
