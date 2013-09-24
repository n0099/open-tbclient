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
public class z {

    /* renamed from: a  reason: collision with root package name */
    private s f1932a = null;
    private s b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private final ah g = new ah();
    private aj h = null;
    private int i = 0;

    private void o() {
        this.f1932a = ag.a().a(this.g);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public z() {
        o();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f1932a.b(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public z(String str) {
        o();
        this.f1932a.a(str);
    }

    public z(Context context, String str) {
        o();
        this.f1932a.a(context);
        this.f1932a.a(str);
    }

    public void a(String str) {
        this.f1932a.a(str);
    }

    public void a(Context context) {
        this.f1932a.a(context);
    }

    public Context a() {
        return this.f1932a.k();
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.f1932a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f1932a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f1932a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f1932a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f1932a.c(z);
    }

    private void p() {
        String E = TiebaApplication.E();
        if (E != null && this.d) {
            this.f1932a.a("BDUSS", E);
        }
    }

    private void q() {
        String E = TiebaApplication.E();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", E);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().N());
        av.a("NetWork", "modSessionData", "== BDUSS:" + E);
        av.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().N());
        if (E != null) {
            ArrayList<BasicNameValuePair> l = this.f1932a.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = l.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    l.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.n()) {
                    l.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.f1932a.m();
    }

    private void r() {
        this.f1932a.a("_client_type", "2");
        this.f1932a.a("_client_version", com.baidu.tieba.data.g.j());
        if (TiebaApplication.g().p() != null) {
            this.f1932a.a("_phone_imei", TiebaApplication.g().p());
        }
        String O = TiebaApplication.O();
        if (O != null) {
            this.f1932a.a("_client_id", O);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.f1932a.a("from", y);
        }
        String n = this.f1932a.n();
        if (n != null) {
            this.f1932a.a("net_type", n);
            if ("3".equalsIgnoreCase(n)) {
                if (TiebaApplication.g().aS() == 1) {
                    com.baidu.adp.lib.network.d.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.d.a().a("");
                }
            } else if (TiebaApplication.g().aT() == 1) {
                com.baidu.adp.lib.network.d.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.d.a().a("");
            }
        }
        if (this.c) {
            this.f1932a.a("tbs", TiebaApplication.g().N());
        }
        String o = TiebaApplication.g().o();
        if (o != null) {
            this.f1932a.a("cuid", o);
        }
        this.f1932a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f1932a.a("model", Build.MODEL);
    }

    private void s() {
        if (this.h == null) {
            this.h = ai.a();
        }
        if (this.h != null) {
            this.f1932a.a("stTime", String.valueOf(this.h.b));
            this.f1932a.a("stSize", String.valueOf(this.h.c));
            this.f1932a.a("stTimesNum", String.valueOf(this.h.d));
            this.f1932a.a("stMode", String.valueOf(this.h.e));
            this.f1932a.a("stMethod", String.valueOf(this.h.f1899a));
        }
        this.i = ai.a(0);
        if (this.i == 0 && this.h != null) {
            this.i = this.h.d;
        }
        this.f1932a.a("stErrorNums", String.valueOf(this.i));
    }

    public boolean c() {
        return this.f1932a.o();
    }

    public boolean d() {
        return this.f1932a.p();
    }

    public int e() {
        return this.f1932a.j();
    }

    public String f() {
        return this.f1932a.n();
    }

    public String g() {
        return this.f1932a.q();
    }

    public void h() {
        if (this.f1932a != null) {
            this.f1932a.r();
        }
        if (this.b != null) {
            this.b.r();
        }
    }

    public com.baidu.tieba.model.au a(String str, String str2, boolean z) {
        String s;
        try {
            av.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.g.f1032a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", "0"));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().aW()));
            if (this.b == null) {
                this.b = ag.a().a(new ah());
            } else {
                this.b.r();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.f1932a.k());
            s = this.b.s();
        } catch (Exception e) {
            av.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.o() && s != null) {
            com.baidu.tieba.model.au auVar = new com.baidu.tieba.model.au();
            auVar.a(s);
            String id = auVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.b(this.b.k().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(auVar.a().getName());
            if (auVar.a().getPassword() != null) {
                accountData.setPassword(auVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(auVar.a().getId());
            accountData.setBDUSS(auVar.a().getBDUSS());
            accountData.setIsActive(1);
            if (auVar.b() != null) {
                accountData.setTbs(auVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, a());
            com.baidu.tieba.account.a.a().b();
            return auVar;
        }
        if (this.b.p()) {
            switch (this.b.j()) {
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
                    this.b.t();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] i() {
        if (!this.f) {
            r();
        }
        return this.f1932a.u();
    }

    private void t() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> l = this.f1932a.l();
        for (int i = 0; l != null && i < l.size(); i++) {
            BasicNameValuePair basicNameValuePair = l.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(String.valueOf(name) + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.f1932a.a("sign", com.baidu.adp.lib.f.e.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        TiebaApplication.a((AccountData) null, a());
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
    }

    private String a(int i) {
        String w;
        switch (i) {
            case 1:
                r();
                s();
                w = this.f1932a.v();
                break;
            case 2:
                p();
                r();
                s();
                w = this.f1932a.s();
                break;
            case 3:
                p();
                r();
                t();
                w = this.f1932a.w();
                break;
            default:
                return null;
        }
        if (w == null && ag.f1896a == 1) {
            this.f1932a = new NetWorkCore(this.g);
            switch (i) {
                case 1:
                    r();
                    s();
                    w = this.f1932a.v();
                    break;
                case 2:
                    p();
                    r();
                    s();
                    w = this.f1932a.s();
                    break;
                case 3:
                    p();
                    r();
                    w = this.f1932a.w();
                    break;
                default:
                    return null;
            }
            if (w != null && this.f1932a.o()) {
                ag.b();
            }
        }
        if (!this.f1932a.p()) {
            ai.a(this.h);
            ai.b(this.i);
            return w;
        } else if (this.f1932a.o()) {
            return w;
        } else {
            if (this.f1932a.j() == 1 && this.e) {
                this.f1932a.t();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.G(), TiebaApplication.E(), new aa(this), new ab(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.G(), backgroundReLogin);
                        TiebaApplication.k(backgroundReLogin);
                        w = b(i);
                    } else {
                        w = null;
                    }
                } else {
                    AccountData F = TiebaApplication.F();
                    if (F == null) {
                        F = DatabaseService.n();
                    }
                    if (F == null) {
                        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
                        return null;
                    } else if (a(F.getAccount(), F.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f1932a.b(this.b.q());
                            return null;
                        }
                        return null;
                    } else {
                        w = b(i);
                    }
                }
            }
            return w;
        }
    }

    private String b(int i) {
        q();
        switch (i) {
            case 1:
                return this.f1932a.v();
            case 2:
                return this.f1932a.s();
            case 3:
                return this.f1932a.w();
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
        av.e("NetWork", "uploadImage", "upload image");
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
        return this.f1932a.x();
    }

    public Boolean a(String str, Handler handler, int i) {
        p();
        return this.f1932a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.f1932a.a(z);
    }

    public boolean n() {
        return this.f1932a.a();
    }
}
