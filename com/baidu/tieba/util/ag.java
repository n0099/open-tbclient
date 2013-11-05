package com.baidu.tieba.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private z f2418a = null;
    private z b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private final aq g = new aq();
    private as h = null;
    private int i = 0;

    private void o() {
        this.f2418a = ap.a().a(this.g);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public ag() {
        o();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f2418a.b(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public ag(String str) {
        o();
        this.f2418a.a(str);
    }

    public ag(Context context, String str) {
        o();
        this.f2418a.a(context);
        this.f2418a.a(str);
    }

    public void a(String str) {
        this.f2418a.a(str);
    }

    public void a(Context context) {
        this.f2418a.a(context);
    }

    public Context a() {
        return this.f2418a.k();
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.f2418a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f2418a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f2418a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f2418a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f2418a.c(z);
    }

    private void p() {
        String F = TiebaApplication.F();
        if (F != null && this.d) {
            this.f2418a.a("BDUSS", F);
        }
    }

    private void q() {
        String F = TiebaApplication.F();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", F);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().O());
        be.a("NetWork", "modSessionData", "== BDUSS:" + F);
        be.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().O());
        if (F != null) {
            ArrayList<BasicNameValuePair> l = this.f2418a.l();
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
        return this.f2418a.m();
    }

    private void r() {
        this.f2418a.a("_client_type", "2");
        this.f2418a.a("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.g().p() != null) {
            this.f2418a.a("_phone_imei", TiebaApplication.g().p());
        }
        String P = TiebaApplication.P();
        if (P != null) {
            this.f2418a.a("_client_id", P);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.f2418a.a("from", y);
        }
        String n = this.f2418a.n();
        if (n != null) {
            this.f2418a.a("net_type", n);
            if ("3".equalsIgnoreCase(n)) {
                if (TiebaApplication.g().aX() == 1) {
                    com.baidu.adp.lib.network.d.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.d.a().a("");
                }
            } else if (TiebaApplication.g().aY() == 1) {
                com.baidu.adp.lib.network.d.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.d.a().a("");
            }
        }
        if (this.c) {
            this.f2418a.a("tbs", TiebaApplication.g().O());
        }
        String o = TiebaApplication.g().o();
        if (o != null) {
            this.f2418a.a(SocialConstants.PARAM_CUID, o);
        }
        this.f2418a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f2418a.a("model", Build.MODEL);
    }

    private void s() {
        if (this.h == null) {
            this.h = ar.a();
        }
        if (this.h != null) {
            this.f2418a.a("stTime", String.valueOf(this.h.b));
            this.f2418a.a("stSize", String.valueOf(this.h.c));
            this.f2418a.a("stTimesNum", String.valueOf(this.h.d));
            this.f2418a.a("stMode", String.valueOf(this.h.e));
            this.f2418a.a("stMethod", String.valueOf(this.h.f2429a));
        }
        this.i = ar.a(0);
        if (this.i == 0 && this.h != null) {
            this.i = this.h.d;
        }
        this.f2418a.a("stErrorNums", String.valueOf(this.i));
    }

    public boolean c() {
        return this.f2418a.o();
    }

    public boolean d() {
        return this.f2418a.p();
    }

    public int e() {
        return this.f2418a.j();
    }

    public String f() {
        return this.f2418a.n();
    }

    public String g() {
        return this.f2418a.q();
    }

    public void h() {
        if (this.f2418a != null) {
            this.f2418a.r();
        }
        if (this.b != null) {
            this.b.r();
        }
    }

    public com.baidu.tieba.model.bd a(String str, String str2, boolean z) {
        String s;
        try {
            be.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.f1165a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().bg()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().bf()));
            if (this.b == null) {
                this.b = ap.a().a(new aq());
            } else {
                this.b.r();
            }
            this.b.a(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.f2418a.k());
            s = this.b.s();
        } catch (Exception e) {
            be.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.o() && s != null) {
            com.baidu.tieba.model.bd bdVar = new com.baidu.tieba.model.bd();
            bdVar.a(s);
            String id = bdVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.b(this.b.k().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(bdVar.a().getName());
            if (bdVar.a().getPassword() != null) {
                accountData.setPassword(bdVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(bdVar.a().getId());
            accountData.setBDUSS(bdVar.a().getBDUSS());
            accountData.setPortrait(bdVar.a().getPortrait());
            accountData.setIsActive(1);
            if (bdVar.b() != null) {
                accountData.setTbs(bdVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, a());
            com.baidu.tieba.account.a.a().b();
            return bdVar;
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
        return this.f2418a.u();
    }

    private void t() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> l = this.f2418a.l();
        for (int i = 0; l != null && i < l.size(); i++) {
            BasicNameValuePair basicNameValuePair = l.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.f2418a.a("sign", com.baidu.adp.lib.h.e.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
    }

    private String a(int i) {
        String w;
        switch (i) {
            case 1:
                r();
                s();
                w = this.f2418a.v();
                break;
            case 2:
                p();
                r();
                s();
                w = this.f2418a.s();
                break;
            case 3:
                p();
                r();
                t();
                w = this.f2418a.w();
                break;
            default:
                return null;
        }
        if (w == null && ap.f2426a == 1) {
            this.f2418a = new NetWorkCore(this.g);
            switch (i) {
                case 1:
                    r();
                    s();
                    w = this.f2418a.v();
                    break;
                case 2:
                    p();
                    r();
                    s();
                    w = this.f2418a.s();
                    break;
                case 3:
                    p();
                    r();
                    w = this.f2418a.w();
                    break;
                default:
                    return null;
            }
            if (w != null && this.f2418a.o()) {
                ap.b();
            }
        }
        if (!this.f2418a.p()) {
            ar.a(this.h);
            ar.b(this.i);
            return w;
        } else if (this.f2418a.o()) {
            return w;
        } else {
            if (this.f2418a.j() == 1 && this.e) {
                this.f2418a.t();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.H(), TiebaApplication.F(), new ah(this), new ai(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.H(), backgroundReLogin);
                        TiebaApplication.k(backgroundReLogin);
                        w = b(i);
                    } else {
                        w = null;
                    }
                } else {
                    AccountData G = TiebaApplication.G();
                    if (G == null) {
                        G = DatabaseService.n();
                    }
                    if (G == null) {
                        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
                        return null;
                    } else if (a(G.getAccount(), G.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f2418a.b(this.b.q());
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
                return this.f2418a.v();
            case 2:
                return this.f2418a.s();
            case 3:
                return this.f2418a.w();
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
        be.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = w.h(str);
            byte[] bArr2 = new byte[5120];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
            while (true) {
                int read = h.read(bArr2);
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
        return this.f2418a.x();
    }

    public Boolean a(String str, Handler handler, int i) {
        p();
        return this.f2418a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.f2418a.a(z);
    }

    public boolean n() {
        return this.f2418a.a();
    }
}
