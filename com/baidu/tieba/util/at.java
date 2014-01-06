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
public class at {
    private ai a = null;
    private ai b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private String g = "other";
    private String h = null;
    private final bh i = new bh();
    private bj j = null;
    private int k = 0;

    private void q() {
        this.a = bc.a().a(this.i);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
        this.i.n = this.a.n();
        this.h = com.baidu.adp.lib.g.c.a();
        this.i.m = this.h;
    }

    public at() {
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

    public at(String str) {
        q();
        this.a.b(str);
    }

    public at(Context context, String str) {
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
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.g().K());
        bo.a("NetWork", "modSessionData", "== BDUSS:" + E);
        bo.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.g().K());
        if (E != null) {
            ArrayList<BasicNameValuePair> l = this.a.l();
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
        return this.a.m();
    }

    private void t() {
        this.a.a("_client_type", "2");
        this.a.a("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.g().p() != null) {
            this.a.a("_phone_imei", TiebaApplication.g().p());
        }
        String L = TiebaApplication.L();
        if (L != null) {
            this.a.a("_client_id", L);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.a.a("from", y);
        }
        String n = this.a.n();
        if (n != null) {
            if ("3".equalsIgnoreCase(n)) {
                if (TiebaApplication.g().aV() == 1) {
                    com.baidu.adp.lib.network.d.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.d.a().a("");
                }
            } else if (TiebaApplication.g().aW() == 1) {
                com.baidu.adp.lib.network.d.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.d.a().a("");
            }
        }
        if (this.c) {
            this.a.a("tbs", TiebaApplication.g().K());
        }
        String o = TiebaApplication.g().o();
        if (o != null) {
            this.a.a(SocialConstants.PARAM_CUID, o);
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.a.a("model", Build.MODEL);
    }

    private void u() {
        if (this.j == null) {
            this.j = bi.a();
        }
        if (this.j != null) {
            this.a.a("stTime", String.valueOf(this.j.b));
            this.a.a("stSize", String.valueOf(this.j.c));
            this.a.a("stTimesNum", String.valueOf(this.j.d));
            this.a.a("stMode", String.valueOf(this.j.e));
            this.a.a("stMethod", String.valueOf(this.j.a));
        }
        this.k = bi.a(0);
        if (this.k == 0 && this.j != null) {
            this.k = this.j.d;
        }
        this.a.a("stErrorNums", String.valueOf(this.k));
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
            bo.a(getClass().toString(), "login", "=== need auto login");
            TiebaApplication.a((AccountData) null, a());
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().bc()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().bb()));
            if (this.b == null) {
                this.b = bc.a().a(new bh());
            } else {
                this.b.r();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.a.k());
            s = this.b.s();
        } catch (Exception e) {
            bo.b(getClass().toString(), "login", e.getMessage());
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
        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
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
        if (w == null && bc.a == 1) {
            this.a = new NetWorkCore(this.i);
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
                bc.b();
            }
        }
        if (!this.a.p()) {
            bi.a(this.j);
            bi.b(this.k);
            return w;
        } else if (this.a.o()) {
            return w;
        } else {
            if (this.a.j() == 1 && this.e) {
                this.a.t();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.g()).backgroundReLogin(TiebaApplication.G(), TiebaApplication.E(), new au(this), new av(this));
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
                        TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
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
        bo.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = aa.h(str);
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

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        r();
        return this.a.a(str, handler, i, i2, i3);
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
        this.a.a(str);
        this.a.b(true);
        this.a.a(i);
    }
}
