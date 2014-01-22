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
public class ax {
    private al a = null;
    private al b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private String g = "other";
    private String h = null;
    private boolean i = false;
    private final bl j = new bl();
    private bn k = null;
    private int l = 0;

    private void r() {
        this.a = bg.a().a(this.j);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
        this.j.n = this.a.o();
        this.h = com.baidu.adp.lib.stats.s.a();
        this.j.m = this.h;
    }

    public ax() {
        r();
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

    public String a() {
        return this.h;
    }

    public ax(String str) {
        r();
        this.a.b(str);
    }

    public ax(Context context, String str) {
        r();
        this.a.a(context);
        this.a.b(str);
    }

    public void a(String str) {
        this.a.b(str);
    }

    public void a(Context context) {
        this.a.a(context);
    }

    public Context b() {
        return this.a.l();
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

    private void s() {
        String D = TiebaApplication.D();
        if (D != null && this.d) {
            this.a.a("BDUSS", D);
        }
    }

    private void t() {
        String D = TiebaApplication.D();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", D);
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.h().J());
        com.baidu.adp.lib.g.e.a("NetWork", "modSessionData", "== BDUSS:" + D);
        com.baidu.adp.lib.g.e.a("NetWork", "modSessionData", "== TBS:" + TiebaApplication.h().J());
        if (D != null) {
            ArrayList<BasicNameValuePair> m = this.a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = m.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    m.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs") && !TiebaApplication.n()) {
                    m.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public int c() {
        return this.a.n();
    }

    private void u() {
        this.a.a("_client_type", "2");
        if (!TiebaApplication.h().bk()) {
            this.a.a("apid", "sw");
        }
        this.a.a("_client_version", com.baidu.tieba.data.h.j());
        if (TiebaApplication.h().p() != null) {
            this.a.a("_phone_imei", TiebaApplication.h().p());
        }
        String K = TiebaApplication.K();
        if (K != null) {
            this.a.a("_client_id", K);
        }
        String y = TiebaApplication.y();
        if (y != null && y.length() > 0) {
            this.a.a("from", y);
        }
        String o = this.a.o();
        if (o != null) {
            if ("3".equalsIgnoreCase(o)) {
                if (TiebaApplication.h().aT() == 1) {
                    com.baidu.adp.lib.network.e.a().a("ka=open");
                } else {
                    com.baidu.adp.lib.network.e.a().a("");
                }
            } else if (TiebaApplication.h().aU() == 1) {
                com.baidu.adp.lib.network.e.a().a("ka=open");
            } else {
                com.baidu.adp.lib.network.e.a().a("");
            }
        }
        if (this.c) {
            this.a.a("tbs", TiebaApplication.h().J());
        }
        String o2 = TiebaApplication.h().o();
        if (o2 != null) {
            this.a.a(SocialConstants.PARAM_CUID, o2);
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.a.a("model", Build.MODEL);
    }

    private void v() {
        if (this.k == null) {
            this.k = bm.a();
        }
        if (this.k != null) {
            this.a.a("stTime", String.valueOf(this.k.b));
            this.a.a("stSize", String.valueOf(this.k.c));
            this.a.a("stTimesNum", String.valueOf(this.k.d));
            this.a.a("stMode", String.valueOf(this.k.e));
            this.a.a("stMethod", String.valueOf(this.k.a));
        }
        this.l = bm.a(0);
        if (this.l == 0 && this.k != null) {
            this.l = this.k.d;
        }
        this.a.a("stErrorNums", String.valueOf(this.l));
    }

    public boolean d() {
        return this.a.p();
    }

    public boolean e() {
        return this.a.q();
    }

    public int f() {
        return this.a.k();
    }

    public int g() {
        return this.a.A();
    }

    public String h() {
        return this.a.B();
    }

    public String i() {
        return this.a.o();
    }

    public String j() {
        return this.a.r();
    }

    public void k() {
        if (this.a != null) {
            this.a.s();
        }
        if (this.b != null) {
            this.b.s();
        }
    }

    public com.baidu.tieba.model.be a(String str, String str2, boolean z) {
        String u;
        try {
            com.baidu.adp.lib.g.e.a(getClass().toString(), "login", "=== need auto login");
            TiebaApplication.a((AccountData) null, b());
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.h.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.h().bb()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.h().ba()));
            if (this.b == null) {
                this.b = bg.a().a(new bl());
            } else {
                this.b.s();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.a.l());
            u = this.b.u();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.p() && u != null) {
            com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
            beVar.a(u);
            String id = beVar.a().getId();
            if (id == null || id.length() <= 0) {
                this.b.c(this.b.l().getString(R.string.neterror));
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
            TiebaApplication.a(accountData, b());
            return beVar;
        }
        if (this.b.q()) {
            switch (this.b.k()) {
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
                    this.b.v();
                    break;
            }
            return null;
        }
        return null;
    }

    public byte[] l() {
        if (!this.f) {
            u();
        }
        return this.a.w();
    }

    private void w() {
        StringBuffer stringBuffer = new StringBuffer(1024);
        ArrayList<BasicNameValuePair> m = this.a.m();
        for (int i = 0; m != null && i < m.size(); i++) {
            BasicNameValuePair basicNameValuePair = m.get(i);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                stringBuffer.append(name + "=");
                stringBuffer.append(value);
            }
        }
        stringBuffer.append("tiebaclient!!!");
        this.a.a("sign", com.baidu.adp.lib.g.f.a(stringBuffer.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        TiebaApplication.h().c.sendMessage(TiebaApplication.h().c.obtainMessage(1));
    }

    private String a(int i) {
        String y;
        switch (i) {
            case 1:
                u();
                v();
                y = this.a.x();
                break;
            case 2:
                s();
                u();
                v();
                y = this.a.u();
                break;
            case 3:
                s();
                u();
                w();
                y = this.a.y();
                break;
            default:
                return null;
        }
        if (y == null && bg.a == 1) {
            if (!this.a.t()) {
                this.a = new NetWorkCore(this.j);
                switch (i) {
                    case 1:
                        u();
                        v();
                        y = this.a.x();
                        break;
                    case 2:
                        s();
                        u();
                        v();
                        y = this.a.u();
                        break;
                    case 3:
                        s();
                        u();
                        y = this.a.y();
                        break;
                    default:
                        return null;
                }
                if (y != null && this.a.p()) {
                    bg.b();
                }
            } else {
                com.baidu.adp.lib.g.e.d("手动取消网络请求");
            }
        }
        if (!this.a.q()) {
            bm.a(this.k);
            bm.b(this.l);
            return y;
        } else if (this.a.p()) {
            return y;
        } else {
            if (this.a.k() == 1 && this.e) {
                this.a.v();
                if (TiebaApplication.n()) {
                    String backgroundReLogin = BaiduAccount.get(TiebaApplication.h()).backgroundReLogin(TiebaApplication.F(), TiebaApplication.D(), new ay(this), new az(this));
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
                        TiebaApplication.h().c.sendMessage(TiebaApplication.h().c.obtainMessage(1));
                        return null;
                    } else if (a(E.getAccount(), E.getPassword(), true) == null) {
                        if (this.b != null) {
                            this.a.c(this.b.r());
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
        t();
        switch (i) {
            case 1:
                return this.a.x();
            case 2:
                return this.a.u();
            case 3:
                return this.a.y();
            default:
                return null;
        }
    }

    public String m() {
        return a(2);
    }

    public String n() {
        return a(1);
    }

    public String o() {
        return a(3);
    }

    public String b(String str) {
        byte[] bArr;
        com.baidu.adp.lib.g.e.e("NetWork", "uploadImage", "upload image");
        try {
            InputStream h = ad.h(str);
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
        return o();
    }

    public boolean p() {
        return this.a.z();
    }

    public boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public boolean a(String str, Handler handler, int i, int i2, int i3) {
        s();
        return this.a.a(str, handler, i, i2, i3);
    }

    public void e(boolean z) {
        this.c = z;
    }

    public void f(boolean z) {
        this.f = z;
        this.a.a(z);
    }

    public boolean q() {
        return this.a.a();
    }

    public void a(String str, int i) {
        this.g = str;
        this.a.a(str);
        this.a.b(true);
        this.a.a(i);
        this.i = true;
    }
}
