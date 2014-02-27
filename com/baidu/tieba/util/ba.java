package com.baidu.tieba.util;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class ba {
    private an a = null;
    private an b = null;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private String g = "other";
    private String h = null;
    private boolean i = false;
    private final bj j = new bj();
    private bl k = null;
    private int l = 0;

    private void r() {
        bf.a();
        this.a = bf.a(this.j);
        this.b = null;
        this.c = false;
        this.e = true;
        this.d = true;
        this.j.n = this.a.o();
        this.h = com.baidu.adp.lib.stats.o.a();
        this.j.m = this.h;
    }

    public ba() {
        r();
    }

    public final void a(boolean z) {
        this.d = false;
    }

    public final void b(boolean z) {
        this.a.c(false);
    }

    public final void c(boolean z) {
        this.e = z;
    }

    public final String a() {
        return this.h;
    }

    public ba(String str) {
        r();
        this.a.b(str);
    }

    public ba(Context context, String str) {
        r();
        this.a.a(context);
        this.a.b(str);
    }

    public final void a(String str) {
        this.a.b(str);
    }

    public final void a(Context context) {
        this.a.a(context);
    }

    private Context s() {
        return this.a.l();
    }

    public final void a(ArrayList<BasicNameValuePair> arrayList) {
        this.a.a(arrayList);
    }

    public final void a(String str, String str2) {
        this.a.a(str, str2);
    }

    public final void a(BasicNameValuePair basicNameValuePair) {
        this.a.a(basicNameValuePair);
    }

    public final void a(String str, byte[] bArr) {
        this.a.a(str, bArr);
    }

    public final void d(boolean z) {
        this.a.d(z);
    }

    private void t() {
        String x = TiebaApplication.x();
        if (x != null && this.d) {
            this.a.a("BDUSS", x);
        }
    }

    private void u() {
        String x = TiebaApplication.x();
        BasicNameValuePair basicNameValuePair = new BasicNameValuePair("BDUSS", x);
        TiebaApplication.g();
        BasicNameValuePair basicNameValuePair2 = new BasicNameValuePair("tbs", TiebaApplication.D());
        com.baidu.adp.lib.util.e.a("NetWork", "modSessionData", "== BDUSS:" + x);
        StringBuilder sb = new StringBuilder("== TBS:");
        TiebaApplication.g();
        com.baidu.adp.lib.util.e.a("NetWork", "modSessionData", sb.append(TiebaApplication.D()).toString());
        if (x != null) {
            ArrayList<BasicNameValuePair> m = this.a.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                BasicNameValuePair basicNameValuePair3 = m.get(i);
                if (basicNameValuePair3.getName().equals("BDUSS")) {
                    m.set(i, basicNameValuePair);
                } else if (basicNameValuePair3.getName().equals("tbs")) {
                    m.set(i, basicNameValuePair2);
                }
            }
        }
    }

    public final int b() {
        return this.a.n();
    }

    private void v() {
        this.a.a("_client_type", "2");
        if (!TiebaApplication.g().aZ()) {
            this.a.a("apid", "sw");
        }
        this.a.a("_client_version", com.baidu.tieba.data.i.u());
        if (TiebaApplication.g().k() != null) {
            this.a.a("_phone_imei", TiebaApplication.g().k());
        }
        String E = TiebaApplication.E();
        if (E != null) {
            this.a.a("_client_id", E);
        }
        String t = TiebaApplication.t();
        if (t != null && t.length() > 0) {
            this.a.a("from", t);
        }
        String o = this.a.o();
        if (o != null) {
            if ("3".equalsIgnoreCase(o)) {
                if (TiebaApplication.g().aI() == 1) {
                    com.baidu.adp.lib.network.e.a();
                    com.baidu.adp.lib.network.b.b = "ka=open";
                } else {
                    com.baidu.adp.lib.network.e.a();
                    com.baidu.adp.lib.network.b.b = "";
                }
            } else if (TiebaApplication.g().aJ() == 1) {
                com.baidu.adp.lib.network.e.a();
                com.baidu.adp.lib.network.b.b = "ka=open";
            } else {
                com.baidu.adp.lib.network.e.a();
                com.baidu.adp.lib.network.b.b = "";
            }
        }
        if (this.c) {
            an anVar = this.a;
            TiebaApplication.g();
            anVar.a("tbs", TiebaApplication.D());
        }
        String j = TiebaApplication.g().j();
        if (j != null) {
            this.a.a(SocialConstants.PARAM_CUID, j);
        }
        this.a.a("timestamp", Long.toString(System.currentTimeMillis()));
        this.a.a("model", Build.MODEL);
    }

    private void w() {
        if (this.k == null) {
            this.k = bk.a();
        }
        if (this.k != null) {
            this.a.a("stTime", String.valueOf(this.k.b));
            this.a.a("stSize", String.valueOf(this.k.c));
            this.a.a("stTimesNum", String.valueOf(this.k.d));
            this.a.a("stMode", String.valueOf(this.k.e));
            this.a.a("stMethod", String.valueOf(this.k.a));
        }
        this.l = bk.a(0);
        if (this.l == 0 && this.k != null) {
            this.l = this.k.d;
        }
        this.a.a("stErrorNums", String.valueOf(this.l));
    }

    public final boolean c() {
        return this.a.p();
    }

    public final boolean d() {
        return this.a.q();
    }

    public final int e() {
        return this.a.k();
    }

    public final int f() {
        return this.a.A();
    }

    public final String g() {
        return this.a.B();
    }

    public final String h() {
        return this.a.o();
    }

    public final String i() {
        return this.a.r();
    }

    public final void j() {
        if (this.a != null) {
            this.a.s();
        }
        if (this.b != null) {
            this.b.s();
        }
    }

    private com.baidu.tieba.model.at a(String str, String str2, boolean z) {
        String u;
        try {
            com.baidu.adp.lib.util.e.a(getClass().toString(), "login", "=== need auto login");
            TiebaApplication.a((AccountData) null, s());
            StringBuilder sb = new StringBuilder(32);
            sb.append(com.baidu.tieba.data.i.a);
            sb.append("c/s/login");
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("un", str));
            arrayList.add(new BasicNameValuePair("passwd", str2));
            arrayList.add(new BasicNameValuePair("isphone", SocialConstants.FALSE));
            arrayList.add(new BasicNameValuePair("channel_id", TiebaApplication.g().aQ()));
            arrayList.add(new BasicNameValuePair("channel_uid", TiebaApplication.g().aP()));
            if (this.b == null) {
                bf.a();
                this.b = bf.a(new bj());
            } else {
                this.b.s();
            }
            this.b.b(sb.toString());
            this.b.a(arrayList);
            this.b.a((Boolean) true);
            this.b.a(this.a.l());
            u = this.b.u();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().toString(), "login", e.getMessage());
        }
        if (this.b.p() && u != null) {
            com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
            atVar.a(u);
            String userId = atVar.a().getUserId();
            if (userId == null || userId.length() <= 0) {
                this.b.c(this.b.l().getString(R.string.neterror));
                return null;
            }
            AccountData accountData = new AccountData();
            accountData.setAccount(atVar.a().getUserName());
            if (atVar.a().getPassword() != null) {
                accountData.setPassword(atVar.a().getPassword());
            } else {
                accountData.setPassword(str2);
            }
            accountData.setID(atVar.a().getUserId());
            accountData.setBDUSS(atVar.a().getBDUSS());
            accountData.setPortrait(atVar.a().getPortrait());
            accountData.setIsActive(1);
            if (atVar.b() != null) {
                accountData.setTbs(atVar.b().getTbs());
            }
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, s());
            return atVar;
        }
        if (this.b.q()) {
            switch (this.b.k()) {
                case 1:
                case 2:
                case 5:
                    Message obtainMessage = TiebaApplication.g().c.obtainMessage(1);
                    Bundle bundle = new Bundle();
                    bundle.putString("account", str);
                    obtainMessage.setData(bundle);
                    TiebaApplication.g().c.sendMessage(obtainMessage);
                    this.b.v();
                    break;
            }
            return null;
        }
        return null;
    }

    public final byte[] k() {
        if (!this.f) {
            v();
        }
        return this.a.w();
    }

    private String a(int i) {
        String y;
        switch (i) {
            case 1:
                v();
                w();
                y = this.a.x();
                break;
            case 2:
                t();
                v();
                w();
                y = this.a.u();
                break;
            case 3:
                t();
                v();
                StringBuffer stringBuffer = new StringBuffer(1024);
                ArrayList<BasicNameValuePair> m = this.a.m();
                for (int i2 = 0; m != null && i2 < m.size(); i2++) {
                    BasicNameValuePair basicNameValuePair = m.get(i2);
                    if (basicNameValuePair != null) {
                        String name = basicNameValuePair.getName();
                        String value = basicNameValuePair.getValue();
                        stringBuffer.append(String.valueOf(name) + "=");
                        stringBuffer.append(value);
                    }
                }
                stringBuffer.append("tiebaclient!!!");
                this.a.a("sign", com.baidu.adp.lib.util.g.a(stringBuffer.toString()));
                y = this.a.y();
                break;
            default:
                return null;
        }
        if (y == null && bf.a == 1 && this.a.A() != 404) {
            if (!this.a.t()) {
                this.a = new NetWorkCore(this.j);
                switch (i) {
                    case 1:
                        v();
                        w();
                        y = this.a.x();
                        break;
                    case 2:
                        t();
                        v();
                        w();
                        y = this.a.u();
                        break;
                    case 3:
                        t();
                        v();
                        y = this.a.y();
                        break;
                    default:
                        return null;
                }
                if (y != null && this.a.p()) {
                    bf.b();
                }
            } else {
                com.baidu.adp.lib.util.e.e("手动取消网络请求");
            }
        }
        if (!this.a.q()) {
            bk.a(this.k);
            bk.b(this.l);
            return y;
        } else if (this.a.p()) {
            return y;
        } else {
            if (this.a.k() == 1 && this.e) {
                this.a.v();
                AccountData y2 = TiebaApplication.y();
                if (y2 == null) {
                    y2 = DatabaseService.l();
                }
                if (y2 == null) {
                    TiebaApplication.g().c.sendMessage(TiebaApplication.g().c.obtainMessage(1));
                    return null;
                } else if (a(y2.getAccount(), y2.getPassword(), true) == null) {
                    if (this.b != null) {
                        this.a.c(this.b.r());
                        return null;
                    }
                    return null;
                } else {
                    u();
                    switch (i) {
                        case 1:
                            y = this.a.x();
                            break;
                        case 2:
                            y = this.a.u();
                            break;
                        case 3:
                            y = this.a.y();
                            break;
                        default:
                            y = null;
                            break;
                    }
                }
            }
            return y;
        }
    }

    public final String l() {
        return a(2);
    }

    public final String m() {
        return a(3);
    }

    public final String b(String str) {
        byte[] bArr;
        com.baidu.adp.lib.util.e.e("NetWork", "uploadImage", "upload image");
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
        return m();
    }

    public final boolean n() {
        return this.a.z();
    }

    public final boolean a(String str, Handler handler, int i) {
        return a(str, handler, i, 5, 100);
    }

    public final boolean a(String str, Handler handler, int i, int i2, int i3) {
        t();
        return this.a.a(str, handler, i, i2, i3);
    }

    public final void e(boolean z) {
        this.c = true;
    }

    public final void f(boolean z) {
        this.f = z;
        this.a.a(z);
    }

    public final boolean o() {
        return this.a.a();
    }

    public final void a(String str, int i) {
        this.g = str;
        this.a.a(str);
        this.a.b(true);
        this.a.a(i);
        this.i = true;
    }

    public final long p() {
        if (this.a != null) {
            return this.a.c();
        }
        return 0L;
    }

    public final long q() {
        if (this.a != null) {
            return this.a.g();
        }
        return 0L;
    }
}
