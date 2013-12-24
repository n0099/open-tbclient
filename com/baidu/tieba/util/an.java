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
import com.baidu.zeus.NotificationProxy;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class an {
    private ag a = null;
    private ag b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private String g = "other";
    private boolean h = false;
    private String i = null;
    private final ax j = new ax();
    private az k = null;
    private int l = 0;

    private void q() {
        this.a = aw.a().a(this.j);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
        this.j.n = this.a.n();
        this.i = com.baidu.adp.lib.g.c.a();
        this.j.m = this.i;
    }

    public an() {
        q();
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void b(boolean z) {
        this.a.c(z);
    }

    public void c(boolean z) {
        this.e = z;
    }

    public an(String str) {
        q();
        this.a.b(str);
    }

    public an(Context context, String str) {
        q();
        this.a.a(context);
        this.a.b(str);
    }

    public void a(String str) {
        this.a.b(str);
    }

    public void a(Context context) {
        this.a.a(context);
    }

    public Context a() {
        return this.a.k();
    }

    public void a(ArrayList<BasicNameValuePair> arrayList) {
        this.a.a(arrayList);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public void a(BasicNameValuePair basicNameValuePair) {
        this.a.a(basicNameValuePair);
    }

    public void a(String str, byte[] bArr) {
        this.a.a(str, bArr);
    }

    public void d(boolean z) {
        this.a.d(z);
    }

    private void r() {
        String E = TiebaApplication.E();
        if (E != null && this.d) {
            this.a.a("BDUSS", E);
        }
    }

    private void s() {
        String E = TiebaApplication.E();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", E);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.h().K());
        be.a("NetWork", "modSessionData", "== BDUSS:" + E);
        be.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.h().K());
        if (E != null) {
            ArrayList<BasicNameValuePair> l = this.a.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = l.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    l.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.o()) {
                    l.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int b() {
        return this.a.m();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t() {
        String str;
        String L;
        String z;
        String n;
        String p;
        String[] split;
        this.a.a("_client_type", "2");
        String j = com.baidu.tieba.data.h.j();
        if (!bc.c(j)) {
            if (j.split("\\.").length == 4) {
                str = split[0] + "." + split[1] + "." + split[2];
                this.a.a("new_four_version", j);
                this.a.a("_client_version", str);
                if (TiebaApplication.h().q() != null) {
                    this.a.a("_phone_imei", TiebaApplication.h().q());
                }
                L = TiebaApplication.L();
                if (L != null) {
                    this.a.a("_client_id", L);
                }
                z = TiebaApplication.z();
                if (z != null && z.length() > 0) {
                    this.a.a("from", z);
                }
                n = this.a.n();
                if (n != null) {
                    if ("3".equalsIgnoreCase(n)) {
                        if (TiebaApplication.h().aV() == 1) {
                            com.baidu.adp.lib.network.d.a().a("ka=open");
                        } else {
                            com.baidu.adp.lib.network.d.a().a("");
                        }
                    } else if (TiebaApplication.h().aW() == 1) {
                        com.baidu.adp.lib.network.d.a().a("ka=open");
                    } else {
                        com.baidu.adp.lib.network.d.a().a("");
                    }
                }
                if (this.c) {
                    this.a.a("tbs", TiebaApplication.h().K());
                }
                p = TiebaApplication.h().p();
                if (p != null) {
                    this.a.a(SocialConstants.PARAM_CUID, p);
                }
                this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
                this.a.a("model", Build.MODEL);
            }
        }
        str = j;
        this.a.a("_client_version", str);
        if (TiebaApplication.h().q() != null) {
        }
        L = TiebaApplication.L();
        if (L != null) {
        }
        z = TiebaApplication.z();
        if (z != null) {
            this.a.a("from", z);
        }
        n = this.a.n();
        if (n != null) {
        }
        if (this.c) {
        }
        p = TiebaApplication.h().p();
        if (p != null) {
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.a.a("model", Build.MODEL);
    }

    private void u() {
        if (this.k == null) {
            this.k = ay.a();
        }
        if (this.k != null) {
            this.a.a("stTime", String.valueOf(this.k.b));
            this.a.a("stSize", String.valueOf(this.k.c));
            this.a.a("stTimesNum", String.valueOf(this.k.d));
            this.a.a("stMode", String.valueOf(this.k.e));
            this.a.a("stMethod", String.valueOf(this.k.a));
        }
        this.l = ay.a(0);
        if (this.l == 0 && this.k != null) {
            this.l = this.k.d;
        }
        this.a.a("stErrorNums", String.valueOf(this.l));
    }

    public boolean c() {
        return this.a.o();
    }

    public boolean d() {
        return this.a.p();
    }

    public int e() {
        return this.a.j();
    }

    public int f() {
        return this.a.y();
    }

    public String g() {
        return this.a.z();
    }

    public String h() {
        return this.a.n();
    }

    public String i() {
        return this.a.q();
    }

    public void j() {
        if (this.a != null) {
            this.a.r();
        }
        if (this.b != null) {
            this.b.r();
        }
    }

    public com.baidu.tieba.model.be a(String str, String str2, boolean z) {
        String s;
        try {
            be.a(getClass().toString(), "login", "=== need auto login");
            TiebaApplication.a((AccountData) null, a());
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.h().bc()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.h().bb()));
            if (this.b == null) {
                this.b = aw.a().a(new ax());
            } else {
                this.b.r();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.a.k());
            s = this.b.s();
        } catch (Exception e) {
            be.b(getClass().toString(), "login", e.getMessage());
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
            com.baidu.tieba.account.l.a().b();
            return beVar;
        }
        if (this.b.p()) {
            switch (this.b.j()) {
                case 1:
                case 2:
                case 5:
                    if (z) {
                        Message obtainMessage = TiebaApplication.h().c.obtainMessage(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("account", str);
                        obtainMessage.setData(bundle);
                        TiebaApplication.h().c.sendMessage(obtainMessage);
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
        return this.a.u();
    }

    private void v() {
        StringBuffer stringBuffer = new StringBuffer((int) NotificationProxy.MAX_URL_LENGTH);
        ArrayList<BasicNameValuePair> l = this.a.l();
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
        this.a.a("sign", com.baidu.adp.lib.h.f.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        TiebaApplication.a((AccountData) null, a());
        TiebaApplication.h().c.sendMessage(TiebaApplication.h().c.obtainMessage(1));
    }

    private String a(int i) {
        String w;
        switch (i) {
            case 1:
                t();
                u();
                w = this.a.v();
                break;
            case 2:
                r();
                t();
                u();
                w = this.a.s();
                break;
            case 3:
                r();
                t();
                v();
                w = this.a.w();
                break;
            default:
                return null;
        }
        if (w == null && aw.a == 1) {
            this.a = new NetWorkCore(this.j);
            switch (i) {
                case 1:
                    t();
                    u();
                    w = this.a.v();
                    break;
                case 2:
                    r();
                    t();
                    u();
                    w = this.a.s();
                    break;
                case 3:
                    r();
                    t();
                    w = this.a.w();
                    break;
                default:
                    return null;
            }
            if (w != null && this.a.o()) {
                aw.b();
            }
        }
        if (!this.a.p()) {
            ay.a(this.k);
            ay.b(this.l);
            return w;
        } else if (this.a.o()) {
            return w;
        } else {
            if (this.a.j() == 1 && this.e) {
                this.a.t();
                if (TiebaApplication.o()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.h()).backgroundReLogin(TiebaApplication.G(), TiebaApplication.E(), new ao(this), new ap(this));
                    if (backgroundReLogin != null) {
                        DatabaseService.b(TiebaApplication.G(), backgroundReLogin);
                        TiebaApplication.l(backgroundReLogin);
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
                        TiebaApplication.h().c.sendMessage(TiebaApplication.h().c.obtainMessage(1));
                        return null;
                    } else if (a(F.getAccount(), F.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.a.c(this.b.q());
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
                return this.a.v();
            case 2:
                return this.a.s();
            case 3:
                return this.a.w();
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
        be.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = y.h(str);
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
        return this.a.x();
    }

    public Boolean a(String str, Handler handler, int i) {
        r();
        return this.a.a(str, handler, i);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.a.a(z);
    }

    public boolean p() {
        return this.a.a();
    }

    public void a(String str, int i) {
        this.g = str;
        this.h = true;
        this.a.a(str);
        this.a.b(true);
        this.a.a(i);
    }
}
