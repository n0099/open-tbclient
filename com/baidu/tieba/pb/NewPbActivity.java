package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
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
    private AlertDialog s;
    private String t;
    private MediaDownloadHelper b = null;
    private com.baidu.adp.lib.a.b e = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.a.b f = new com.baidu.adp.lib.a.b(new al(this), 8, 0);
    private Handler g = new Handler(new aw(this));
    private com.baidu.tieba.model.bc j = null;
    private com.baidu.tieba.model.av k = null;
    private com.baidu.tieba.model.bi l = null;
    private com.baidu.tieba.model.ao m = null;
    private com.baidu.tieba.model.bf n = null;
    private com.baidu.tieba.model.t o = null;
    private bn p = null;
    private boolean q = false;
    private boolean r = false;
    private View.OnClickListener u = new bc(this);
    private com.baidu.tieba.model.bd v = new bd(this);
    private com.baidu.tieba.model.ax w = new be(this);
    private View.OnClickListener x = new bf(this);
    private AbsListView.OnScrollListener y = new bg(this);
    private AbsListView.OnScrollListener z = new bh(this);
    private com.baidu.tieba.model.bh A = new bi(this);
    private com.baidu.tieba.model.bj B = new am(this);
    private com.baidu.adp.a.e C = new an(this);
    private com.baidu.adp.widget.ListView.b D = new ao(this);
    private com.baidu.adp.widget.ListView.r E = new ap(this);
    private com.baidu.adp.widget.ListView.s F = new aq(this);
    private DialogInterface.OnClickListener G = new ar(this);
    private com.baidu.adp.a.e H = new as(this);
    private ct I = new at(this);
    private int J = 0;
    private com.baidu.tbadk.widget.richText.m K = new au(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.aw f1439a = null;
    private DialogInterface.OnClickListener L = new av(this);
    private View.OnLongClickListener M = new ax(this);

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
            activity.startActivityForResult(intent, 17001);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.data.bm bmVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (bmVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bmVar.a());
            intent.putExtra("is_good", bmVar.f());
            intent.putExtra("is_top", bmVar.e());
            intent.putExtra("thread_time", bmVar.d());
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
        k();
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

    private void k() {
        this.p = new bn(this, this.u);
        this.p.a(this.y);
        this.p.b(this.z);
        this.p.a(this.x);
        this.p.a(this.E);
        this.p.a(this.F);
        this.p.a(this.G);
        this.p.a(this.D);
        this.p.e(TiebaApplication.f().aq());
        this.p.f(TiebaApplication.f().C());
        this.p.a(this.K);
        this.p.a(this.M);
        this.p.a(this.I);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new ay(this)).setNeutralButton(getString(R.string.sms_phone), new az(this)).setNegativeButton(getString(R.string.cancel), new ba(this));
        this.s = builder.create();
    }

    private void a(Bundle bundle) {
        this.j = new com.baidu.tieba.model.bc(this);
        this.j.a(this.v);
        this.k = new com.baidu.tieba.model.av();
        this.k.a(this.w);
        this.l = new com.baidu.tieba.model.bi();
        this.l.a(this.B);
        this.m = new com.baidu.tieba.model.ao();
        this.m.setLoadDataCallBack(this.H);
        this.n = new com.baidu.tieba.model.bf(this);
        this.n.a(this.A);
        this.o = new com.baidu.tieba.model.t();
        this.o.setLoadDataCallBack(this.C);
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
    public void a(com.baidu.tieba.model.v vVar) {
        boolean z;
        int i = 0;
        this.p.a(0, vVar.f1384a, vVar.b, true);
        if (vVar.f1384a) {
            if (vVar.c == 1) {
                ArrayList c2 = this.j.j().c();
                int size = c2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!vVar.d.equals(((com.baidu.tieba.data.aw) c2.get(i)).d())) {
                        i++;
                    } else {
                        c2.remove(i);
                        break;
                    }
                }
                this.p.a(this.j.j());
            } else if (vVar.c == 0) {
                l();
            } else if (vVar.c == 2) {
                ArrayList c3 = this.j.j().c();
                int size2 = c3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ((com.baidu.tieba.data.aw) c3.get(i2)).a().size()) {
                            z = z2;
                            break;
                        } else if (!vVar.d.equals(((com.baidu.tieba.data.aw) ((com.baidu.tieba.data.aw) c3.get(i2)).a().get(i3)).d())) {
                            i3++;
                        } else {
                            ((com.baidu.tieba.data.aw) c3.get(i2)).a().remove(i3);
                            ((com.baidu.tieba.data.aw) c3.get(i2)).c();
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
                        } else if (!vVar.d.equals(((com.baidu.tieba.data.aw) b.get(i4)).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.p.a(this.n.c(), this.j.j().i());
                    if (!z2) {
                        String a2 = this.n.a();
                        while (i < size2) {
                            if (!a2.equals(((com.baidu.tieba.data.aw) c3.get(i)).d())) {
                                i++;
                            } else {
                                ((com.baidu.tieba.data.aw) c3.get(i)).c();
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
    public void a(com.baidu.tieba.model.x xVar) {
        this.p.a(1, xVar.f1386a, xVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.z zVar) {
        this.p.a(this.o.getLoadDataMode(), zVar.f1388a, zVar.b, false);
        this.p.a(zVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.z zVar) {
        this.p.a(this.o.getLoadDataMode(), zVar.f1388a, zVar.b, true);
        if (zVar.f1388a) {
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

    private void l() {
        if (this.j.d()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.j.a());
            setResult(-1, intent);
        }
        p();
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
        p();
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
                case 11001:
                    c((String) null);
                    return;
                case 11009:
                    n();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    View i3 = this.p.i();
                    if (i3 != null) {
                        c((String) i3.getTag());
                        return;
                    }
                    return;
                case 12001:
                    WriteImageActivity.a(this, 12001, 12010, null);
                    return;
                case 12002:
                    if (intent != null && intent.getData() != null) {
                        WriteImageActivity.a(this, 12002, 12009, intent.getData());
                        return;
                    }
                    return;
                case 12003:
                    if (intent != null) {
                        m();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.p.w();
                            this.l.a(false);
                            return;
                        }
                        this.m.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    m();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.p.b(a2);
                        return;
                    }
                    return;
                case 12005:
                    m();
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.p.c(a3);
                        return;
                    }
                    return;
                case 12006:
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
                case 12009:
                case 12010:
                    m();
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
            case 12001:
            case 12002:
            case 12003:
            case 12009:
            case 12010:
                m();
                return;
            case 12004:
            case 12005:
            case 12006:
            case 12007:
            case 12008:
            default:
                return;
        }
    }

    private void m() {
        if (this.q) {
            this.q = false;
            new Handler().postDelayed(new bb(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
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
    public void o() {
        com.baidu.tieba.data.as j = this.j.j();
        this.j.c(true);
        j.a(this.k.b());
        this.p.a(j);
    }

    private void p() {
        if (this.j != null && !this.j.r() && this.j.j() != null && this.j.j().c() != null && this.j.j().c().size() > 0 && this.j.e()) {
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
                com.baidu.tieba.util.aj.b(getClass().getName(), "onClick", e.toString());
            }
        }
        Matcher matcher2 = d.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e2) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        com.baidu.tieba.util.am.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        com.baidu.tieba.util.am.c(this, str);
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
        com.baidu.tieba.data.as j = this.j.j();
        for (int i2 = 0; i2 < j.c().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = ((com.baidu.tieba.data.aw) j.c().get(i2)).h();
            ArrayList a2 = h.a();
            int size = a2.size();
            int i3 = -1;
            int i4 = 0;
            while (i4 < size) {
                if (a2.get(i4) != null && ((com.baidu.tbadk.widget.richText.c) a2.get(i4)).a() == 8) {
                    i3++;
                    if (((com.baidu.tbadk.widget.richText.c) a2.get(i4)).c().d().equals(str)) {
                        int b = ((com.baidu.tbadk.widget.richText.c) a2.get(i4)).c().b();
                        int a3 = ((com.baidu.tbadk.widget.richText.c) a2.get(i4)).c().a();
                        if (b < 80 || a3 < 80 || a3 * b < 10000) {
                            return null;
                        }
                        this.J = i4;
                        return h;
                    } else if (i3 <= i) {
                    }
                }
                i4++;
                i3 = i3;
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
            sb.append(com.baidu.tieba.util.ai.d(c2.d()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.t = str;
            this.s.setMessage(this.t);
            this.s.show();
            StatService.onEvent(this, "pb_show_phonedialog", "show");
            if (str2.equals("2")) {
                this.s.getButton(-3).setVisibility(8);
            } else {
                this.s.getButton(-3).setVisibility(0);
            }
            Button button = this.s.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.s.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.s.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }
}
