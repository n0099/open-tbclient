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
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.media.MediaDownloadHelper;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.g implements com.baidu.tbadk.widget.richText.h {
    private static final Pattern c = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern d = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private MediaDownloadHelper b = null;
    private com.baidu.adp.lib.a.b e = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.a.b f = new com.baidu.adp.lib.a.b(new al(this), 8, 0);
    private Handler g = new Handler(new aw(this));
    private com.baidu.tieba.model.ax j = null;
    private com.baidu.tieba.model.am k = null;
    private com.baidu.tieba.model.bd l = null;
    private com.baidu.tieba.model.ag m = null;
    private com.baidu.tieba.model.ba n = null;
    private com.baidu.tieba.model.o o = null;
    private bk p = null;
    private boolean q = false;
    private boolean r = false;
    private View.OnClickListener s = new az(this);
    private com.baidu.tieba.model.ay t = new ba(this);
    private com.baidu.tieba.model.ao u = new bb(this);
    private View.OnClickListener v = new bc(this);
    private AbsListView.OnScrollListener w = new bd(this);
    private AbsListView.OnScrollListener x = new be(this);
    private com.baidu.tieba.model.bc y = new bf(this);
    private com.baidu.tieba.model.be z = new am(this);
    private com.baidu.adp.a.e A = new an(this);
    private com.baidu.adp.widget.ListView.b B = new ao(this);
    private com.baidu.adp.widget.ListView.r C = new ap(this);
    private com.baidu.adp.widget.ListView.s D = new aq(this);
    private DialogInterface.OnClickListener E = new ar(this);
    private com.baidu.adp.a.e F = new as(this);
    private cq G = new at(this);
    private int H = 0;
    private com.baidu.tbadk.widget.richText.m I = new au(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.an f1189a = null;
    private DialogInterface.OnClickListener J = new av(this);
    private View.OnLongClickListener K = new ax(this);

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.f().w();
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

    public static void a(Activity activity, MarkData markData, String str) {
        if (markData != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", markData.getThreadId());
            intent.putExtra("post_id", markData.getPostId());
            intent.putExtra("host_only", markData.getHostMode());
            intent.putExtra("squence", markData.getSequence());
            intent.putExtra("st_type", str);
            intent.putExtra("from_mark", true);
            activity.startActivityForResult(intent, 1700001);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.data.ba baVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (baVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", baVar.a());
            intent.putExtra("is_good", baVar.f());
            intent.putExtra("is_top", baVar.e());
            intent.putExtra("thread_time", baVar.d());
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
        if (this.j.h()) {
            this.n.b(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
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
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        this.j.cancelLoadData();
        this.l.cancelLoadData();
        this.m.cancelLoadData();
        this.k.cancelLoadData();
        this.n.cancelLoadData();
        this.o.cancelLoadData();
        this.p.N();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
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
        this.p.e(TiebaApplication.f().ap());
        this.p.f(TiebaApplication.f().A());
        this.p.a(this.I);
        this.p.a(this.K);
        this.p.a(this.G);
    }

    private void a(Bundle bundle) {
        this.j = new com.baidu.tieba.model.ax(this);
        this.j.a(this.t);
        this.k = new com.baidu.tieba.model.am();
        this.k.a(this.u);
        this.l = new com.baidu.tieba.model.bd();
        this.l.a(this.z);
        this.m = new com.baidu.tieba.model.ag();
        this.m.setLoadDataCallBack(this.F);
        this.n = new com.baidu.tieba.model.ba(this);
        this.n.a(this.y);
        this.o = new com.baidu.tieba.model.o();
        this.o.setLoadDataCallBack(this.A);
        if (bundle != null) {
            this.j.a(bundle);
        } else {
            this.j.a(getIntent());
        }
        if (!this.j.h()) {
            this.j.m();
            this.p.m();
            return;
        }
        if (bundle != null) {
            this.n.a(bundle);
        } else {
            this.n.a(getIntent());
        }
        this.p.r();
        this.n.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.q qVar) {
        boolean z;
        int i = 0;
        this.p.a(0, qVar.f1061a, qVar.b, true);
        if (qVar.f1061a) {
            if (qVar.c == 1) {
                ArrayList d2 = this.j.j().d();
                int size = d2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!qVar.d.equals(((com.baidu.tieba.data.an) d2.get(i)).d())) {
                        i++;
                    } else {
                        d2.remove(i);
                        break;
                    }
                }
                this.p.a(this.j.j());
            } else if (qVar.c == 0) {
                n();
            } else if (qVar.c == 2) {
                ArrayList d3 = this.j.j().d();
                int size2 = d3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ((com.baidu.tieba.data.an) d3.get(i2)).a().size()) {
                            z = z2;
                            break;
                        } else if (!qVar.d.equals(((com.baidu.tieba.data.an) ((com.baidu.tieba.data.an) d3.get(i2)).a().get(i3)).d())) {
                            i3++;
                        } else {
                            ((com.baidu.tieba.data.an) d3.get(i2)).a().remove(i3);
                            ((com.baidu.tieba.data.an) d3.get(i2)).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.p.a(this.j.j());
                }
                if (this.p.t()) {
                    ArrayList b = this.n.c().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!qVar.d.equals(((com.baidu.tieba.data.an) b.get(i4)).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.p.a(this.n.c(), this.j.j().l());
                    if (!z2) {
                        String a2 = this.n.a();
                        while (i < size2) {
                            if (!a2.equals(((com.baidu.tieba.data.an) d3.get(i)).d())) {
                                i++;
                            } else {
                                ((com.baidu.tieba.data.an) d3.get(i)).c();
                                this.p.a(this.j.j());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.s sVar) {
        this.p.a(1, sVar.f1063a, sVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.u uVar) {
        this.p.a(this.o.getLoadDataMode(), uVar.f1065a, uVar.b, false);
        this.p.a(uVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.u uVar) {
        this.p.a(this.o.getLoadDataMode(), uVar.f1065a, uVar.b, true);
        if (uVar.f1065a) {
            this.r = true;
            if (i == 2) {
                this.j.j().b().b(1);
                this.j.a(1);
            } else if (i == 3) {
                this.j.j().b().b(0);
                this.j.a(0);
            } else if (i == 4) {
                this.j.j().b().a(1);
                this.j.b(1);
            } else if (i == 5) {
                this.j.j().b().a(0);
                this.j.b(0);
            }
            this.p.a(this.j.j(), true);
        }
    }

    private void n() {
        if (this.j.d()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.j.a());
            setResult(-1, intent);
        }
        r();
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void f() {
        if (this.j.d()) {
            Intent intent = new Intent();
            if (this.r) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.j.a());
                intent.putExtra("top_data", this.j.g());
                intent.putExtra("good_data", this.j.f());
            }
            setResult(-1, intent);
        }
        r();
        super.f();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.p.d(this.j.h())) {
                    return true;
                }
                f();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
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
                        this.m.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 1200004:
                    o();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.p.b(a2);
                        return;
                    }
                    return;
                case 1200005:
                    o();
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.p.c(a3);
                        return;
                    }
                    return;
                case 1200006:
                    this.l.a((WriteData) null);
                    this.l.a(false);
                    if (this.p.t()) {
                        this.n.f();
                        return;
                    } else if (this.j.l()) {
                        this.p.m();
                        return;
                    } else {
                        return;
                    }
                case 1200009:
                case 1200010:
                    o();
                    if (intent != null) {
                        this.m.a(intent.getStringExtra("file_name"));
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
        MarkData f = this.j.f(this.p.B());
        if (f != null) {
            this.p.m();
            this.k.a(f);
            if (!this.k.a()) {
                this.k.c();
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.k.d();
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.l.a() == null) {
            if (!this.j.h()) {
                this.l.a(this.j.a(str));
            } else {
                this.l.a(this.n.d());
            }
        }
        if (this.l.a() != null) {
            if (str == null) {
                this.l.a().setContent(this.p.D());
            } else {
                this.l.a().setContent(this.p.E());
            }
            if (this.l.b()) {
                this.p.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.baidu.tieba.data.aj j = this.j.j();
        this.j.c(true);
        j.a(this.k.b());
        this.p.a(j);
    }

    private void r() {
        if (this.j != null && !this.j.r() && this.j.e()) {
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
    public com.baidu.adp.lib.a.b c() {
        return this.f;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.a.b d() {
        return this.e;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, null);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void b(Context context, String str) {
        Matcher matcher = c.matcher(str);
        if (matcher.find()) {
            try {
                String group = matcher.group();
                a(this, group.substring(group.lastIndexOf("/") + 1), null, null);
                return;
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onClick", e.toString());
            }
        }
        Matcher matcher2 = d.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e2) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        com.baidu.tieba.util.ab.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        com.baidu.tieba.util.ab.c(this, str);
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str) {
        if (this.b == null) {
            this.b = new MediaDownloadHelper(this);
        }
        this.b.a(str);
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this, "baidu_video", "click", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.j == null || this.j.j() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.aj j = this.j.j();
        for (int i2 = 0; i2 < j.d().size(); i2++) {
            com.baidu.tbadk.widget.richText.a i3 = ((com.baidu.tieba.data.an) j.d().get(i2)).i();
            ArrayList a2 = i3.a();
            int size = a2.size();
            int i4 = -1;
            int i5 = 0;
            while (i5 < size) {
                if (a2.get(i5) != null && ((com.baidu.tbadk.widget.richText.c) a2.get(i5)).a() == 8) {
                    i4++;
                    if (((com.baidu.tbadk.widget.richText.c) a2.get(i5)).c().d().equals(str)) {
                        int b = ((com.baidu.tbadk.widget.richText.c) a2.get(i5)).c().b();
                        int a3 = ((com.baidu.tbadk.widget.richText.c) a2.get(i5)).c().a();
                        if (b < 80 || a3 < 80 || a3 * b < 10000) {
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
        com.baidu.tbadk.widget.richText.e c2 = cVar.c();
        if (c2 != null) {
            if (c2.a() * c2.b() > com.baidu.tieba.data.g.h() * com.baidu.tieba.data.g.h()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.g.h() * com.baidu.tieba.data.g.h()) / (c2.a() * c2.b()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c2.b() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c2.a())));
            } else {
                float b = c2.b() / c2.a();
                double sqrt2 = Math.sqrt((com.baidu.tieba.data.g.h() * com.baidu.tieba.data.g.h()) / b);
                sb.append("width=");
                sb.append(String.valueOf((int) (b * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.y.d(c2.d()));
            return sb.toString();
        }
        return null;
    }
}
