package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.e implements com.baidu.tbadk.widget.richText.h {
    private static final Pattern e = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern f = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private com.baidu.tieba.media.e d = null;
    private com.baidu.adp.lib.c.b g = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.c.b h = new com.baidu.adp.lib.c.b(new al(this), 8, 0);
    private Handler i = new Handler(new aw(this));
    private com.baidu.tieba.c.ax j = null;
    private com.baidu.tieba.c.ak k = null;
    private com.baidu.tieba.c.bd l = null;
    private com.baidu.tieba.c.ad m = null;
    private com.baidu.tieba.c.ba n = null;
    private com.baidu.tieba.c.l o = null;
    private bk p = null;
    private boolean q = false;
    private boolean r = false;
    private View.OnClickListener s = new az(this);
    private com.baidu.tieba.c.ay t = new ba(this);
    private com.baidu.tieba.c.am u = new bb(this);
    private View.OnClickListener v = new bc(this);
    private AbsListView.OnScrollListener w = new bd(this);
    private AbsListView.OnScrollListener x = new be(this);
    private com.baidu.tieba.c.bc y = new bf(this);
    private com.baidu.tieba.c.be z = new am(this);
    private com.baidu.adp.a.e A = new an(this);
    private com.baidu.adp.widget.ListView.b B = new ao(this);
    private com.baidu.adp.widget.ListView.r C = new ap(this);
    private com.baidu.adp.widget.ListView.s D = new aq(this);
    private DialogInterface.OnClickListener E = new ar(this);
    private com.baidu.adp.a.e F = new as(this);
    private cq G = new at(this);
    private int H = 0;
    private com.baidu.tbadk.widget.richText.m I = new au(this);
    com.baidu.tieba.a.ar c = null;
    private DialogInterface.OnClickListener J = new av(this);
    private View.OnLongClickListener K = new ax(this);

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.e().s();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (str != null) {
            Intent intent = new Intent(context, NewPbActivity.class);
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void a(Context context, String str, String str2, String str3, long j) {
        if (str != null) {
            Intent intent = new Intent(context, NewPbActivity.class);
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_pv", true);
            intent.putExtra("msg_id", j);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (str != null) {
            Intent intent = new Intent(context, NewPbActivity.class);
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("is_sub_pb", true);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.a.af afVar, String str) {
        if (afVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", afVar.i());
            intent.putExtra("post_id", afVar.g());
            intent.putExtra("host_only", afVar.f());
            intent.putExtra("squence", afVar.e());
            intent.putExtra("st_type", str);
            intent.putExtra("from_mark", true);
            activity.startActivityForResult(intent, 1700001);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.a.bc bcVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (bcVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bcVar.a());
            intent.putExtra("is_good", bcVar.f());
            intent.putExtra("is_top", bcVar.e());
            intent.putExtra("thread_time", bcVar.d());
            intent.putExtra("st_type", str);
            intent.putExtra("from_frs", true);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            activity.startActivityForResult(intent, i);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.j.b(bundle);
        if (this.j.k()) {
            this.n.b(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m();
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.j.q();
        this.l.f();
        this.m.e();
        this.k.h();
        this.n.h();
        this.o.d();
        this.p.N();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.p.b(i);
    }

    private void m() {
        this.p = new bk(this, this.s);
        this.p.a(this.w);
        this.p.b(this.x);
        this.p.a(this.v);
        this.p.a(this.C);
        this.p.a(this.D);
        this.p.a(this.E);
        this.p.a(this.B);
        this.p.d(TiebaApplication.e().ao());
        this.p.e(TiebaApplication.e().y());
        this.p.a(this.I);
        this.p.a(this.K);
        this.p.a(this.G);
    }

    private void a(Bundle bundle) {
        this.j = new com.baidu.tieba.c.ax(this);
        this.j.a(this.t);
        this.k = new com.baidu.tieba.c.ak();
        this.k.a(this.u);
        this.l = new com.baidu.tieba.c.bd();
        this.l.a(this.z);
        this.m = new com.baidu.tieba.c.ad();
        this.m.a(this.F);
        this.n = new com.baidu.tieba.c.ba(this);
        this.n.a(this.y);
        this.o = new com.baidu.tieba.c.l();
        this.o.a(this.A);
        if (bundle != null) {
            this.j.a(bundle);
        } else {
            this.j.a(getIntent());
        }
        if (!this.j.k()) {
            this.j.r();
            this.p.m();
            return;
        }
        if (bundle != null) {
            this.n.a(bundle);
        } else {
            this.n.a(getIntent());
        }
        this.p.r();
        this.n.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.n nVar) {
        boolean z;
        int i = 0;
        this.p.a(0, nVar.a, nVar.b, true);
        if (nVar.a) {
            if (nVar.c == 1) {
                ArrayList d = this.j.m().d();
                int size = d.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!nVar.d.equals(((com.baidu.tieba.a.ar) d.get(i)).d())) {
                        i++;
                    } else {
                        d.remove(i);
                        break;
                    }
                }
                this.p.a(this.j.m());
            } else if (nVar.c == 0) {
                n();
            } else if (nVar.c == 2) {
                ArrayList d2 = this.j.m().d();
                int size2 = d2.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ((com.baidu.tieba.a.ar) d2.get(i2)).a().size()) {
                            z = z2;
                            break;
                        } else if (!nVar.d.equals(((com.baidu.tieba.a.ar) ((com.baidu.tieba.a.ar) d2.get(i2)).a().get(i3)).d())) {
                            i3++;
                        } else {
                            ((com.baidu.tieba.a.ar) d2.get(i2)).a().remove(i3);
                            ((com.baidu.tieba.a.ar) d2.get(i2)).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.p.a(this.j.m());
                }
                if (this.p.t()) {
                    ArrayList b = this.n.f().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!nVar.d.equals(((com.baidu.tieba.a.ar) b.get(i4)).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.p.a(this.n.f(), this.j.m().l());
                    if (!z2) {
                        String d3 = this.n.d();
                        while (i < size2) {
                            if (!d3.equals(((com.baidu.tieba.a.ar) d2.get(i)).d())) {
                                i++;
                            } else {
                                ((com.baidu.tieba.a.ar) d2.get(i)).c();
                                this.p.a(this.j.m());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.p pVar) {
        this.p.a(1, pVar.a, pVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.r rVar) {
        this.p.a(this.o.a(), rVar.a, rVar.b, false);
        this.p.a(rVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.c.r rVar) {
        this.p.a(this.o.a(), rVar.a, rVar.b, true);
        if (rVar.a) {
            this.r = true;
            if (i == 2) {
                this.j.m().b().b(1);
                this.j.b(1);
            } else if (i == 3) {
                this.j.m().b().b(0);
                this.j.b(0);
            } else if (i == 4) {
                this.j.m().b().a(1);
                this.j.c(1);
            } else if (i == 5) {
                this.j.m().b().a(0);
                this.j.c(0);
            }
            this.p.a(this.j.m(), true);
        }
    }

    private void n() {
        if (this.j.g()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.j.d());
            setResult(-1, intent);
        }
        r();
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void f() {
        if (this.j.g()) {
            Intent intent = new Intent();
            if (this.r) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.j.d());
                intent.putExtra("top_data", this.j.j());
                intent.putExtra("good_data", this.j.i());
            }
            setResult(-1, intent);
        }
        r();
        super.f();
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.p.c(this.j.k())) {
                    return true;
                }
                f();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(int i) {
        String C = TiebaApplication.C();
        if (C == null || C.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_to_use), true, i);
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1100001:
                    c((String) null);
                    return;
                case 1100009:
                    p();
                    return;
                case 1100025:
                    AtListActivity.a(this, 1200004);
                    return;
                case 1100026:
                    AtListActivity.a(this, 1200005);
                    return;
                case 1100027:
                    View i3 = this.p.i();
                    if (i3 != null) {
                        c((String) i3.getTag());
                        return;
                    }
                    return;
                case 1200001:
                    WriteImageActivity.a(this, 1200001, 1200010, null);
                    return;
                case 1200002:
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 1200002, 1200009, intent.getData());
                        return;
                    }
                    return;
                case 1200003:
                    if (intent != null) {
                        o();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.p.w();
                            this.l.a(false);
                            return;
                        }
                        this.m.b(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 1200004:
                    o();
                    String a = AtListActivity.a(intent);
                    if (a != null) {
                        this.p.b(a);
                        return;
                    }
                    return;
                case 1200005:
                    o();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.p.c(a2);
                        return;
                    }
                    return;
                case 1200006:
                    this.l.a((com.baidu.tieba.a.bi) null);
                    this.l.a(false);
                    if (this.p.t()) {
                        this.n.j();
                        return;
                    } else if (this.j.o()) {
                        this.p.m();
                        return;
                    } else {
                        return;
                    }
                case 1200009:
                case 1200010:
                    o();
                    if (intent != null) {
                        this.m.b(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 1200001:
            case 1200002:
            case 1200003:
            case 1200009:
            case 1200010:
                o();
                return;
            case 1200004:
            case 1200005:
            case 1200006:
            case 1200007:
            case 1200008:
            default:
                return;
        }
    }

    private void o() {
        if (this.q) {
            this.q = false;
            new Handler().postDelayed(new ay(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.baidu.tieba.a.af g = this.j.g(this.p.B());
        if (g != null) {
            this.p.m();
            this.k.a(g);
            if (!this.k.d()) {
                this.k.f();
                if (TiebaApplication.e().p()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.k.g();
            if (TiebaApplication.e().p()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.l.d() == null) {
            if (!this.j.k()) {
                this.l.a(this.j.b(str));
            } else {
                this.l.a(this.n.g());
            }
        }
        if (this.l.d() != null) {
            if (str == null) {
                this.l.d().b(this.p.D());
            } else {
                this.l.d().b(this.p.E());
            }
            if (this.l.e()) {
                this.p.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.baidu.tieba.a.am m = this.j.m();
        this.j.c(true);
        m.a(this.k.e());
        this.p.a(m);
    }

    private void r() {
        if (this.j != null && !this.j.w() && this.j.h()) {
            setResult(1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        if (this.p == null) {
            return null;
        }
        return this.p.G();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        if (this.p == null) {
            return 0;
        }
        return this.p.H();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b c() {
        return this.h;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b d() {
        return this.g;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                a(this, group.substring(group.lastIndexOf("/") + 1), null, null);
                return;
            } catch (Exception e2) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        Matcher matcher2 = f.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e3) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e3.toString());
            }
        }
        com.baidu.tieba.d.ag.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        com.baidu.tieba.d.ag.c(this, str);
        if (TiebaApplication.e().p()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str) {
        if (this.d == null) {
            this.d = new com.baidu.tieba.media.e(this);
        }
        this.d.a(str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.j == null || this.j.m() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.a.am m = this.j.m();
        for (int i2 = 0; i2 < m.d().size(); i2++) {
            com.baidu.tbadk.widget.richText.a i3 = ((com.baidu.tieba.a.ar) m.d().get(i2)).i();
            ArrayList a = i3.a();
            int size = a.size();
            int i4 = -1;
            int i5 = 0;
            while (i5 < size) {
                if (a.get(i5) != null && ((com.baidu.tbadk.widget.richText.c) a.get(i5)).a() == 8) {
                    i4++;
                    if (((com.baidu.tbadk.widget.richText.c) a.get(i5)).c().d().equals(str)) {
                        int b = ((com.baidu.tbadk.widget.richText.c) a.get(i5)).c().b();
                        int a2 = ((com.baidu.tbadk.widget.richText.c) a.get(i5)).c().a();
                        if (b < 80 || a2 < 80 || a2 * b < 10000) {
                            return null;
                        }
                        this.H = i5;
                        return i3;
                    } else if (i4 <= i) {
                    }
                }
                i5++;
                i4 = i4;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.baidu.tbadk.widget.richText.c cVar) {
        StringBuilder sb = new StringBuilder((int) WebChromeClient.STRING_DLG_BTN_SET);
        com.baidu.tbadk.widget.richText.e c = cVar.c();
        if (c != null) {
            if (c.a() * c.b() > com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) {
                double sqrt = Math.sqrt((com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) / (c.a() * c.b()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c.b() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c.a())));
            } else {
                float b = c.b() / c.a();
                double sqrt2 = Math.sqrt((com.baidu.tieba.a.i.h() * com.baidu.tieba.a.i.h()) / b);
                sb.append("width=");
                sb.append(String.valueOf((int) (b * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.d.ad.d(c.d()));
            return sb.toString();
        }
        return null;
    }
}
