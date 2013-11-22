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
public class ap {

    /* renamed from: a  reason: collision with root package name */
    private ai f2469a = null;
    private ai b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private String g = "other";
    private boolean h = false;
    private final az i = new az();
    private bb j = null;
    private int k = 0;

    private void q() {
        this.f2469a = ay.a().a(this.i);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public ap() {
        q();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f2469a.c(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public ap(String str) {
        q();
        this.f2469a.b(str);
    }

    public ap(Context context, String str) {
        q();
        this.f2469a.a(context);
        this.f2469a.b(str);
    }

    public void a(String str) {
        this.f2469a.b(str);
    }

    public void a(Context context) {
        this.f2469a.a(context);
    }

    public Context a() {
        return this.f2469a.k();
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.f2469a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f2469a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f2469a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f2469a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f2469a.d(z);
    }

    private void r() {
        String D = TiebaApplication.D();
        if (D != null && this.d) {
            this.f2469a.a("BDUSS", D);
        }
    }

    private void s() {
        String D = TiebaApplication.D();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", D);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().M());
        bg.a("NetWork", "modSessionData", "== BDUSS:" + D);
        bg.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().M());
        if (D != null) {
            ArrayList<BasicNameValuePair> l = this.f2469a.l();
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
        return this.f2469a.m();
    }

    private void t() {
        this.f2469a.a("_client_type", "2");
        this.f2469a.a("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.g().p() != null) {
            this.f2469a.a("_phone_imei", TiebaApplication.g().p());
        }
        String N = TiebaApplication.N();
        if (N != null) {
            this.f2469a.a("_client_id", N);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.f2469a.a("from", y);
        }
        String n = this.f2469a.n();
        if (n != null) {
            this.f2469a.a("net_type", n);
            if ("3".equalsIgnoreCase(n)) {
                if (TiebaApplication.g().aU() == 1) {
                    com.baidu.adp.lib.network.d.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.d.a().a("");
                }
            } else if (TiebaApplication.g().aV() == 1) {
                com.baidu.adp.lib.network.d.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.d.a().a("");
            }
        }
        if (this.c) {
            this.f2469a.a("tbs", TiebaApplication.g().M());
        }
        String o = TiebaApplication.g().o();
        if (o != null) {
            this.f2469a.a(SocialConstants.PARAM_CUID, o);
        }
        this.f2469a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f2469a.a("model", Build.MODEL);
    }

    private void u() {
        if (this.j == null) {
            this.j = ba.a();
        }
        if (this.j != null) {
            this.f2469a.a("stTime", String.valueOf(this.j.b));
            this.f2469a.a("stSize", String.valueOf(this.j.c));
            this.f2469a.a("stTimesNum", String.valueOf(this.j.d));
            this.f2469a.a("stMode", String.valueOf(this.j.e));
            this.f2469a.a("stMethod", String.valueOf(this.j.f2480a));
        }
        this.k = ba.a(0);
        if (this.k == 0 && this.j != null) {
            this.k = this.j.d;
        }
        this.f2469a.a("stErrorNums", String.valueOf(this.k));
    }

    public boolean c() {
        return this.f2469a.o();
    }

    public boolean d() {
        return this.f2469a.p();
    }

    public int e() {
        return this.f2469a.j();
    }

    public int f() {
        return this.f2469a.y();
    }

    public String g() {
        return this.f2469a.z();
    }

    public String h() {
        return this.f2469a.n();
    }

    public String i() {
        return this.f2469a.q();
    }

    public void j() {
        if (this.f2469a != null) {
            this.f2469a.r();
        }
        if (this.b != null) {
            this.b.r();
        }
    }

    public com.baidu.tieba.model.be a(String str, String str2, boolean z) {
        String s;
        try {
            bg.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.f1201a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().bb()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().ba()));
            if (this.b == null) {
                this.b = ay.a().a(new az());
            } else {
                this.b.r();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.f2469a.k());
            s = this.b.s();
        } catch (Exception e) {
            bg.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.o() && s != null) {
            com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
            beVar.a(s);
            String id = beVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.c(this.b.k().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(beVar.a().getName());
            if (beVar.a().getPassword() != null) {
                accountData.setPassword(beVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(beVar.a().getId());
            accountData.setBDUSS(beVar.a().getBDUSS());
            accountData.setPortrait(beVar.a().getPortrait());
            accountData.setIsActive(1);
            if (beVar.b() != null) {
                accountData.setTbs(beVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, a());
            com.baidu.tieba.account.a.a().b();
            return beVar;
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

    public byte[] k() {
        if (!this.f) {
            t();
        }
        return this.f2469a.u();
    }

    private void v() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> l = this.f2469a.l();
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
        this.f2469a.a("sign", com.baidu.adp.lib.h.e.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        TiebaApplication.a((AccountData) null, a());
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
    }

    private String a(int i) {
        String w;
        switch (i) {
            case 1:
                t();
                u();
                w = this.f2469a.v();
                break;
            case 2:
                r();
                t();
                u();
                w = this.f2469a.s();
                break;
            case 3:
                r();
                t();
                v();
                w = this.f2469a.w();
                break;
            default:
                return null;
        }
        if (w == null && ay.f2477a == 1) {
            this.f2469a = new NetWorkCore(this.i);
            switch (i) {
                case 1:
                    t();
                    u();
                    w = this.f2469a.v();
                    break;
                case 2:
                    r();
                    t();
                    u();
                    w = this.f2469a.s();
                    break;
                case 3:
                    r();
                    t();
                    w = this.f2469a.w();
                    break;
                default:
                    return null;
            }
            if (w != null && this.f2469a.o()) {
                ay.b();
            }
        }
        if (!this.f2469a.p()) {
            ba.a(this.j);
            ba.b(this.k);
            return w;
        } else if (this.f2469a.o()) {
            return w;
        } else {
            if (this.f2469a.j() == 1 && this.e) {
                this.f2469a.t();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.F(), TiebaApplication.D(), new aq(this), new ar(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.F(), backgroundReLogin);
                        TiebaApplication.k(backgroundReLogin);
                        w = b(i);
                    } else {
                        w = null;
                    }
                } else {
                    AccountData E = TiebaApplication.E();
                    if (E == null) {
                        E = DatabaseService.n();
                    }
                    if (E == null) {
                        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
                        return null;
                    } else if (a(E.getAccount(), E.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.f2469a.c(this.b.q());
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
        s();
        switch (i) {
            case 1:
                return this.f2469a.v();
            case 2:
                return this.f2469a.s();
            case 3:
                return this.f2469a.w();
            default:
                return null;
        }
    }

    public String l() {
        return a(2);
    }

    public String m() {
        return a(1);
    }

    public String n() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        bg.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = af.h(str);
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
        return n();
    }

    public boolean o() {
        return this.f2469a.x();
    }

    public Boolean a(String str, Handler handler, int i) {
        r();
        return this.f2469a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.f2469a.a(z);
    }

    public boolean p() {
        return this.f2469a.a();
    }

    public void a(String str, int i) {
        this.g = str;
        this.h = true;
        this.f2469a.a(str);
        this.f2469a.b(true);
        this.f2469a.a(i);
    }
}
