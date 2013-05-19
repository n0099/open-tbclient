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
    private static final Pattern d = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern e = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private com.baidu.adp.lib.c.b f = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.c.b g = new com.baidu.adp.lib.c.b(new al(this), 8, 0);
    private Handler h = new Handler(new aw(this));
    private com.baidu.tieba.c.au i = null;
    private com.baidu.tieba.c.ah j = null;
    private com.baidu.tieba.c.ba k = null;
    private com.baidu.tieba.c.aa l = null;
    private com.baidu.tieba.c.ax m = null;
    private com.baidu.tieba.c.i n = null;
    private bl o = null;
    private boolean p = false;
    private boolean q = false;
    private View.OnClickListener r = new az(this);
    private com.baidu.tieba.c.av s = new ba(this);
    private com.baidu.tieba.c.aj t = new bb(this);
    private View.OnClickListener u = new bc(this);
    private AbsListView.OnScrollListener v = new bd(this);
    private AbsListView.OnScrollListener w = new be(this);
    private com.baidu.tieba.c.az x = new bf(this);
    private com.baidu.tieba.c.bb y = new am(this);
    private com.baidu.adp.a.e z = new an(this);
    private com.baidu.adp.widget.ListView.b A = new ao(this);
    private com.baidu.adp.widget.ListView.r B = new ap(this);
    private com.baidu.adp.widget.ListView.s C = new aq(this);
    private DialogInterface.OnClickListener D = new ar(this);
    private com.baidu.adp.a.e E = new as(this);
    private cq F = new at(this);
    private com.baidu.tbadk.widget.richText.m G = new au(this);
    com.baidu.tieba.a.aq c = null;
    private DialogInterface.OnClickListener H = new av(this);
    private View.OnLongClickListener I = new ax(this);

    @Override // com.baidu.tieba.e
    public boolean e() {
        return TiebaApplication.d().q();
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
            intent.putExtra("thread_id", afVar.j());
            intent.putExtra("post_id", afVar.h());
            intent.putExtra("host_only", afVar.g());
            intent.putExtra("squence", afVar.f());
            intent.putExtra("st_type", str);
            intent.putExtra("from_mark", true);
            activity.startActivityForResult(intent, 1700001);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.a.bb bbVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (bbVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bbVar.a());
            intent.putExtra("is_good", bbVar.f());
            intent.putExtra("is_top", bbVar.e());
            intent.putExtra("thread_time", bbVar.d());
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
        this.i.b(bundle);
        if (this.i.k()) {
            this.m.b(bundle);
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
        this.i.p();
        this.k.f();
        this.l.e();
        this.j.g();
        this.m.h();
        this.n.d();
        this.o.M();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.o.b(i);
    }

    private void m() {
        this.o = new bl(this, this.r);
        this.o.a(this.v);
        this.o.b(this.w);
        this.o.a(this.u);
        this.o.a(this.B);
        this.o.a(this.C);
        this.o.b(this.D);
        this.o.a(this.A);
        this.o.d(TiebaApplication.d().af());
        this.o.e(TiebaApplication.d().w());
        this.o.a(this.G);
        this.o.a(this.I);
        this.o.a(this.F);
    }

    private void a(Bundle bundle) {
        this.i = new com.baidu.tieba.c.au(this);
        this.i.a(this.s);
        this.j = new com.baidu.tieba.c.ah();
        this.j.a(this.t);
        this.k = new com.baidu.tieba.c.ba();
        this.k.a(this.y);
        this.l = new com.baidu.tieba.c.aa();
        this.l.a(this.E);
        this.m = new com.baidu.tieba.c.ax(this);
        this.m.a(this.x);
        this.n = new com.baidu.tieba.c.i();
        this.n.a(this.z);
        if (bundle != null) {
            this.i.a(bundle);
        } else {
            this.i.a(getIntent());
        }
        if (!this.i.k()) {
            this.i.q();
            this.o.m();
            return;
        }
        if (bundle != null) {
            this.m.a(bundle);
        } else {
            this.m.a(getIntent());
        }
        this.o.r();
        this.m.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.k kVar) {
        boolean z;
        int i = 0;
        this.o.a(0, kVar.a, kVar.b, true);
        if (kVar.a) {
            if (kVar.c == 1) {
                ArrayList d2 = this.i.l().d();
                int size = d2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!kVar.d.equals(((com.baidu.tieba.a.aq) d2.get(i)).d())) {
                        i++;
                    } else {
                        d2.remove(i);
                        break;
                    }
                }
                this.o.a(this.i.l());
            } else if (kVar.c == 0) {
                n();
            } else if (kVar.c == 2) {
                ArrayList d3 = this.i.l().d();
                int size2 = d3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ((com.baidu.tieba.a.aq) d3.get(i2)).a().size()) {
                            z = z2;
                            break;
                        } else if (!kVar.d.equals(((com.baidu.tieba.a.aq) ((com.baidu.tieba.a.aq) d3.get(i2)).a().get(i3)).d())) {
                            i3++;
                        } else {
                            ((com.baidu.tieba.a.aq) d3.get(i2)).a().remove(i3);
                            ((com.baidu.tieba.a.aq) d3.get(i2)).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.o.a(this.i.l());
                }
                if (this.o.t()) {
                    ArrayList b = this.m.f().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!kVar.d.equals(((com.baidu.tieba.a.aq) b.get(i4)).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.o.a(this.m.f(), this.i.l().l());
                    if (!z2) {
                        String d4 = this.m.d();
                        while (i < size2) {
                            if (!d4.equals(((com.baidu.tieba.a.aq) d3.get(i)).d())) {
                                i++;
                            } else {
                                ((com.baidu.tieba.a.aq) d3.get(i)).c();
                                this.o.a(this.i.l());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.m mVar) {
        this.o.a(1, mVar.a, mVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.c.o oVar) {
        this.o.a(this.n.a(), oVar.a, oVar.b, false);
        this.o.a(oVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.c.o oVar) {
        this.o.a(this.n.a(), oVar.a, oVar.b, true);
        if (oVar.a) {
            this.q = true;
            if (i == 2) {
                this.i.l().b().b(1);
                this.i.b(1);
            } else if (i == 3) {
                this.i.l().b().b(0);
                this.i.b(0);
            } else if (i == 4) {
                this.i.l().b().a(1);
                this.i.c(1);
            } else if (i == 5) {
                this.i.l().b().a(0);
                this.i.c(0);
            }
            this.o.a(this.i.l(), true);
        }
    }

    private void n() {
        if (this.i.g()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.i.d());
            setResult(-1, intent);
        }
        r();
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void f() {
        if (this.i.g()) {
            Intent intent = new Intent();
            if (this.q) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.i.d());
                intent.putExtra("top_data", this.i.j());
                intent.putExtra("good_data", this.i.i());
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
                if (this.o.c(this.i.k())) {
                    return true;
                }
                f();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(int i) {
        String z = TiebaApplication.z();
        if (z == null || z.length() <= 0) {
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
                    View i3 = this.o.i();
                    if (i3 != null) {
                        c((String) i3.getTag(R.id.tag_post_id));
                        return;
                    }
                    return;
                case 1200001:
                    WriteImageActivity.a(this, 1200001, 12000010, null);
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
                            this.o.w();
                            this.k.a(false);
                            return;
                        }
                        this.l.b(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 1200004:
                    o();
                    String a = AtListActivity.a(intent);
                    if (a != null) {
                        this.o.b(a);
                        return;
                    }
                    return;
                case 1200005:
                    o();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.o.c(a2);
                        return;
                    }
                    return;
                case 1200006:
                    this.k.a((com.baidu.tieba.a.bh) null);
                    if (this.o.t()) {
                        this.m.j();
                        return;
                    } else if (this.i.n()) {
                        this.o.m();
                        return;
                    } else {
                        return;
                    }
                case 1200009:
                case 12000010:
                    o();
                    if (intent != null) {
                        this.l.b(intent.getStringExtra("file_name"));
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
            case 12000010:
                o();
                return;
            default:
                return;
        }
    }

    private void o() {
        if (this.p) {
            this.p = false;
            new Handler().postDelayed(new ay(this), 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.baidu.tieba.a.af g = this.i.g(this.o.A());
        if (g != null) {
            this.o.m();
            this.j.a(g);
            if (!this.j.d()) {
                this.j.e();
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.j.f();
            if (TiebaApplication.d().n()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.k.d() == null) {
            if (!this.i.k()) {
                this.k.a(this.i.b(str));
            } else {
                this.k.a(this.m.g());
            }
        }
        if (this.k.d() != null) {
            if (str == null) {
                this.k.d().b(this.o.C());
            } else {
                this.k.d().b(this.o.D());
            }
            if (this.k.e()) {
                this.o.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.baidu.tieba.a.al l = this.i.l();
        int A = this.o.A();
        if (l.d() != null && l.d().size() > 0) {
            if (A < 0) {
                A = 0;
            }
            if (A > l.d().size() - 1) {
                A = l.d().size() - 1;
            }
            l.a(((com.baidu.tieba.a.aq) l.d().get(A)).d());
        }
        this.o.a(l);
    }

    private void r() {
        if (this.i != null) {
            if (this.i.v()) {
                com.baidu.tieba.a.af g = this.i.g(this.o.A());
                if (g != null) {
                    q();
                    a(getString(R.string.mark_remind).replace("%d", String.valueOf(g.d())));
                    new bg(g).start();
                    if (this.i.h()) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", g);
                        setResult(-1, intent);
                    }
                }
            } else if (this.i.h()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        if (this.o == null) {
            return null;
        }
        return this.o.F();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        if (this.o == null) {
            return 0;
        }
        return this.o.G();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b c() {
        return this.g;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.c.b d() {
        return this.f;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        Matcher matcher = d.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                a(this, group.substring(group.lastIndexOf("/") + 1), null, null);
                return;
            } catch (Exception e2) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        Matcher matcher2 = e.matcher(str);
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
        if (TiebaApplication.d().n()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.a.k a(String str, int i) {
        if (this.i == null || this.i.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.a.al l = this.i.l();
        for (int i2 = 0; i2 < l.d().size(); i2++) {
            ArrayList i3 = ((com.baidu.tieba.a.aq) l.d().get(i2)).i();
            int size = i3.size();
            int i4 = -1;
            int i5 = 0;
            while (i5 < size) {
                if (i3.get(i5) != null && ((com.baidu.tieba.a.k) i3.get(i5)).a() == 3) {
                    i4++;
                    if (((com.baidu.tieba.a.k) i3.get(i5)).f().equals(str)) {
                        if (((com.baidu.tieba.a.k) i3.get(i5)).b() >= 50 || ((com.baidu.tieba.a.k) i3.get(i5)).c() >= 50) {
                            return (com.baidu.tieba.a.k) i3.get(i5);
                        }
                        return null;
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
    public ArrayList b(String str, int i) {
        if (this.i == null || this.i.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.a.al l = this.i.l();
        for (int i2 = 0; i2 < l.d().size(); i2++) {
            ArrayList i3 = ((com.baidu.tieba.a.aq) l.d().get(i2)).i();
            int size = i3.size();
            int i4 = -1;
            int i5 = 0;
            while (i5 < size) {
                if (i3.get(i5) != null && ((com.baidu.tieba.a.k) i3.get(i5)).a() == 3) {
                    i4++;
                    if (((com.baidu.tieba.a.k) i3.get(i5)).f().equals(str)) {
                        if (((com.baidu.tieba.a.k) i3.get(i5)).b() >= 50 || ((com.baidu.tieba.a.k) i3.get(i5)).c() >= 50) {
                            return ((com.baidu.tieba.a.aq) l.d().get(i2)).j();
                        }
                        return null;
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
    public String a(com.baidu.tieba.a.k kVar) {
        StringBuilder sb = new StringBuilder((int) WebChromeClient.STRING_DLG_BTN_SET);
        if (kVar.c() * kVar.b() > com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) {
            double sqrt = Math.sqrt((com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) / (kVar.c() * kVar.b()));
            sb.append("width=");
            sb.append(String.valueOf((int) (kVar.b() * sqrt)));
            sb.append("&height=");
            sb.append(String.valueOf((int) (sqrt * kVar.c())));
        } else {
            float b = kVar.b() / kVar.c();
            double sqrt2 = Math.sqrt((com.baidu.tieba.a.i.g() * com.baidu.tieba.a.i.g()) / b);
            sb.append("width=");
            sb.append(String.valueOf((int) (b * sqrt2)));
            sb.append("&height=");
            sb.append(String.valueOf((int) sqrt2));
        }
        sb.append("&src=");
        sb.append(com.baidu.tieba.d.ad.d(kVar.f()));
        return sb.toString();
    }
}
