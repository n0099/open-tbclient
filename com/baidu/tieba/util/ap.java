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
    private ai f2486a = null;
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

    private void o() {
        this.f2486a = ay.a().a(this.i);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
    }

    public ap() {
        o();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.f2486a.c(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public ap(String str) {
        o();
        this.f2486a.b(str);
    }

    public ap(Context context, String str) {
        o();
        this.f2486a.a(context);
        this.f2486a.b(str);
    }

    public void a(String str) {
        this.f2486a.b(str);
    }

    public void a(Context context) {
        this.f2486a.a(context);
    }

    public Context a() {
        return this.f2486a.m();
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.f2486a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.f2486a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.f2486a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.f2486a.a(str, bArr);
    }

    public void d(boolean z) {
        this.f2486a.d(z);
    }

    private void p() {
        String D = TiebaApplication.D();
        if (D != null && this.d) {
            this.f2486a.a("BDUSS", D);
        }
    }

    private void q() {
        String D = TiebaApplication.D();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", D);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().M());
        bg.a("NetWork", "modSessionData", "== BDUSS:" + D);
        bg.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().M());
        if (D != null) {
            ArrayList<BasicNameValuePair> n = this.f2486a.n();
            int size = n.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = n.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    n.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.n()) {
                    n.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.f2486a.o();
    }

    private void r() {
        this.f2486a.a("_client_type", "2");
        this.f2486a.a("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.g().p() != null) {
            this.f2486a.a("_phone_imei", TiebaApplication.g().p());
        }
        String N = TiebaApplication.N();
        if (N != null) {
            this.f2486a.a("_client_id", N);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.f2486a.a("from", y);
        }
        String p = this.f2486a.p();
        if (p != null) {
            this.f2486a.a("net_type", p);
            if ("3".equalsIgnoreCase(p)) {
                if (TiebaApplication.g().aT() == 1) {
                    com.baidu.adp.lib.network.d.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.d.a().a("");
                }
            } else if (TiebaApplication.g().aU() == 1) {
                com.baidu.adp.lib.network.d.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.d.a().a("");
            }
        }
        if (this.c) {
            this.f2486a.a("tbs", TiebaApplication.g().M());
        }
        String o = TiebaApplication.g().o();
        if (o != null) {
            this.f2486a.a(SocialConstants.PARAM_CUID, o);
        }
        this.f2486a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.f2486a.a("model", Build.MODEL);
    }

    private void s() {
        if (this.j == null) {
            this.j = ba.a();
        }
        if (this.j != null) {
            this.f2486a.a("stTime", String.valueOf(this.j.b));
            this.f2486a.a("stSize", String.valueOf(this.j.c));
            this.f2486a.a("stTimesNum", String.valueOf(this.j.d));
            this.f2486a.a("stMode", String.valueOf(this.j.e));
            this.f2486a.a("stMethod", String.valueOf(this.j.f2497a));
        }
        this.k = ba.a(0);
        if (this.k == 0 && this.j != null) {
            this.k = this.j.d;
        }
        this.f2486a.a("stErrorNums", String.valueOf(this.k));
    }

    public boolean c() {
        return this.f2486a.q();
    }

    public boolean d() {
        return this.f2486a.r();
    }

    public int e() {
        return this.f2486a.l();
    }

    public String f() {
        return this.f2486a.p();
    }

    public String g() {
        return this.f2486a.s();
    }

    public void h() {
        if (this.f2486a != null) {
            this.f2486a.t();
        }
        if (this.b != null) {
            this.b.t();
        }
    }

    public com.baidu.tieba.model.be a(String str, String str2, boolean z) {
        String u;
        try {
            bg.a(getClass().toString(), "login", "=== need auto login");
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.f1196a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().ba()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().aZ()));
            if (this.b == null) {
                this.b = ay.a().a(new az());
            } else {
                this.b.t();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.f2486a.m());
            u = this.b.u();
        } catch (Exception e) {
            bg.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.q() && u != null) {
            com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
            beVar.a(u);
            String id = beVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.c(this.b.m().getString(R.string.neterror));
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
        if (this.b.r()) {
            switch (this.b.l()) {
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
                    this.b.v();
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
        return this.f2486a.w();
    }

    private void t() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> n = this.f2486a.n();
        for (int i = 0; n != null && i < n.size(); i++) {
            BasicNameValuePair basicNameValuePair = n.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.f2486a.a("sign", com.baidu.adp.lib.h.e.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        TiebaApplication.a((AccountData) null, a());
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
    }

    private String a(int i) {
        String y;
        switch (i) {
            case 1:
                r();
                s();
                y = this.f2486a.x();
                break;
            case 2:
                p();
                r();
                s();
                y = this.f2486a.u();
                break;
            case 3:
                p();
                r();
                t();
                y = this.f2486a.y();
                break;
            default:
                return null;
        }
        if (y == null && ay.f2494a == 1) {
            this.f2486a = new NetWorkCore(this.i);
            switch (i) {
                case 1:
                    r();
                    s();
                    y = this.f2486a.x();
                    break;
                case 2:
                    p();
                    r();
                    s();
                    y = this.f2486a.u();
                    break;
                case 3:
                    p();
                    r();
                    y = this.f2486a.y();
                    break;
                default:
                    return null;
            }
            if (y != null && this.f2486a.q()) {
                ay.b();
            }
        }
        if (!this.f2486a.r()) {
            ba.a(this.j);
            ba.b(this.k);
            return y;
        } else if (this.f2486a.q()) {
            return y;
        } else {
            if (this.f2486a.l() == 1 && this.e) {
                this.f2486a.v();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.F(), TiebaApplication.D(), new aq(this), new ar(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.F(), backgroundReLogin);
                        TiebaApplication.k(backgroundReLogin);
                        y = b(i);
                    } else {
                        y = null;
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
                            this.f2486a.c(this.b.s());
                            return null;
                        }
                        return null;
                    } else {
                        y = b(i);
                    }
                }
            }
            return y;
        }
    }

    private String b(int i) {
        q();
        switch (i) {
            case 1:
                return this.f2486a.x();
            case 2:
                return this.f2486a.u();
            case 3:
                return this.f2486a.y();
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
        return l();
    }

    public boolean m() {
        return this.f2486a.z();
    }

    public Boolean a(String str, Handler handler, int i) {
        p();
        return this.f2486a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.f2486a.a(z);
    }

    public boolean n() {
        return this.f2486a.a();
    }

    public void a(String str, int i) {
        this.g = str;
        this.h = true;
        this.f2486a.a(str);
        this.f2486a.b(true);
        this.f2486a.a(i);
    }
}
