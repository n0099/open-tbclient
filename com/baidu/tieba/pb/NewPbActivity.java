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
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.g implements com.baidu.tbadk.widget.richText.h {
    private static final Pattern d = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern e = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private AlertDialog t;
    private String u;
    private MediaDownloadHelper b = null;
    private boolean c = false;
    private com.baidu.adp.lib.b.b f = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.b.b g = new com.baidu.adp.lib.b.b(new al(this), 8, 0);
    private Handler j = new Handler(new aw(this));
    private com.baidu.tieba.model.bb k = null;
    private com.baidu.tieba.model.au l = null;
    private com.baidu.tieba.model.bh m = null;
    private com.baidu.tieba.model.ao n = null;
    private com.baidu.tieba.model.be o = null;
    private com.baidu.tieba.model.t p = null;
    private bo q = null;
    private boolean r = false;
    private boolean s = false;
    private View.OnClickListener v = new bd(this);
    private com.baidu.tieba.model.bc w = new be(this);
    private com.baidu.tieba.model.aw x = new bf(this);
    private View.OnClickListener y = new bg(this);
    private AbsListView.OnScrollListener z = new bh(this);
    private AbsListView.OnScrollListener A = new bi(this);
    private com.baidu.tieba.model.bg B = new bj(this);
    private com.baidu.tieba.model.bi C = new am(this);
    private com.baidu.adp.a.e D = new an(this);
    private com.baidu.adp.widget.ListView.b E = new ao(this);
    private com.baidu.adp.widget.ListView.r F = new ap(this);
    private com.baidu.adp.widget.ListView.s G = new aq(this);
    private DialogInterface.OnClickListener H = new ar(this);
    private com.baidu.adp.a.e I = new as(this);
    private cu J = new at(this);
    private int K = 0;
    private com.baidu.tbadk.widget.richText.m L = new au(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.as f1474a = null;
    private DialogInterface.OnClickListener M = new av(this);
    private View.OnLongClickListener N = new ax(this);
    private com.baidu.tieba.view.ax O = new ay(this);

    @Override // com.baidu.tieba.g
    public boolean e() {
        return TiebaApplication.g().w();
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

    public static void a(Activity activity, com.baidu.tieba.data.bh bhVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (bhVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bhVar.a());
            intent.putExtra("is_good", bhVar.f());
            intent.putExtra("is_top", bhVar.e());
            intent.putExtra("thread_time", bhVar.d());
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
        this.k.b(bundle);
        if (this.k.h()) {
            this.o.b(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        l();
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        this.c = true;
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        this.c = false;
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
        this.k.cancelLoadData();
        this.m.cancelLoadData();
        this.n.cancelLoadData();
        this.l.cancelLoadData();
        this.o.cancelLoadData();
        this.p.cancelLoadData();
        this.q.O();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.q.b(i);
        if (this.q.a() != null) {
            this.q.a().a(i);
        }
    }

    private void l() {
        this.q = new bo(this, this.v);
        this.q.a(this.z);
        this.q.b(this.A);
        this.q.a(this.y);
        this.q.a(this.F);
        this.q.a(this.G);
        this.q.a(this.H);
        this.q.a(this.E);
        this.q.e(TiebaApplication.g().aj());
        this.q.f(TiebaApplication.g().C());
        this.q.a(this.L);
        this.q.a(this.N);
        this.q.a(this.J);
        this.q.a(this.O);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new az(this)).setNeutralButton(getString(R.string.sms_phone), new ba(this)).setNegativeButton(getString(R.string.cancel), new bb(this));
        this.t = builder.create();
    }

    private void a(Bundle bundle) {
        this.k = new com.baidu.tieba.model.bb(this);
        this.k.a(this.w);
        this.l = new com.baidu.tieba.model.au();
        this.l.a(this.x);
        this.m = new com.baidu.tieba.model.bh();
        this.m.a(this.C);
        this.n = new com.baidu.tieba.model.ao();
        this.n.setLoadDataCallBack(this.I);
        this.o = new com.baidu.tieba.model.be(this);
        this.o.a(this.B);
        this.p = new com.baidu.tieba.model.t();
        this.p.setLoadDataCallBack(this.D);
        if (bundle != null) {
            this.k.a(bundle);
        } else {
            this.k.a(getIntent());
        }
        if (!this.k.h()) {
            this.k.n();
            this.q.n();
            return;
        }
        if (bundle != null) {
            this.o.a(bundle);
        } else {
            this.o.a(getIntent());
        }
        this.q.s();
        this.o.g();
    }

    public void k() {
        if (this.q.a() != null) {
            this.q.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.v vVar) {
        boolean z;
        int i = 0;
        this.q.a(0, vVar.f1419a, vVar.b, true);
        if (vVar.f1419a) {
            if (vVar.c == 1) {
                ArrayList d2 = this.k.k().d();
                int size = d2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!vVar.d.equals(((com.baidu.tieba.data.as) d2.get(i)).d())) {
                        i++;
                    } else {
                        d2.remove(i);
                        break;
                    }
                }
                this.q.a(this.k.k());
            } else if (vVar.c == 0) {
                m();
            } else if (vVar.c == 2) {
                ArrayList d3 = this.k.k().d();
                int size2 = d3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ((com.baidu.tieba.data.as) d3.get(i2)).a().size()) {
                            z = z2;
                            break;
                        } else if (!vVar.d.equals(((com.baidu.tieba.data.as) ((com.baidu.tieba.data.as) d3.get(i2)).a().get(i3)).d())) {
                            i3++;
                        } else {
                            ((com.baidu.tieba.data.as) d3.get(i2)).a().remove(i3);
                            ((com.baidu.tieba.data.as) d3.get(i2)).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.q.a(this.k.k());
                }
                if (this.q.u()) {
                    ArrayList b = this.o.c().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!vVar.d.equals(((com.baidu.tieba.data.as) b.get(i4)).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.q.a(this.o.c(), this.k.k().j());
                    if (!z2) {
                        String a2 = this.o.a();
                        while (i < size2) {
                            if (!a2.equals(((com.baidu.tieba.data.as) d3.get(i)).d())) {
                                i++;
                            } else {
                                ((com.baidu.tieba.data.as) d3.get(i)).c();
                                this.q.a(this.k.k());
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
        this.q.a(1, xVar.f1421a, xVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.z zVar) {
        this.q.a(this.p.getLoadDataMode(), zVar.f1423a, zVar.b, false);
        this.q.a(zVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.z zVar) {
        this.q.a(this.p.getLoadDataMode(), zVar.f1423a, zVar.b, true);
        if (zVar.f1423a) {
            this.s = true;
            if (i == 2) {
                this.k.k().c().b(1);
                this.k.a(1);
            } else if (i == 3) {
                this.k.k().c().b(0);
                this.k.a(0);
            } else if (i == 4) {
                this.k.k().c().a(1);
                this.k.b(1);
            } else if (i == 5) {
                this.k.k().c().a(0);
                this.k.b(0);
            }
            this.q.a(this.k.k(), true);
        }
    }

    private void m() {
        if (this.k.d()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.k.a());
            setResult(-1, intent);
        }
        q();
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void f() {
        if (this.k.d()) {
            Intent intent = new Intent();
            if (this.s) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.k.a());
                intent.putExtra("top_data", this.k.g());
                intent.putExtra("good_data", this.k.f());
            }
            setResult(-1, intent);
        }
        q();
        super.f();
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.q.d(this.k.h())) {
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
                    o();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    View j = this.q.j();
                    if (j != null) {
                        c((String) j.getTag());
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
                        n();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.q.x();
                            this.m.a(false);
                            return;
                        }
                        this.n.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    n();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.q.b(a2);
                        return;
                    }
                    return;
                case 12005:
                    n();
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.q.c(a3);
                        return;
                    }
                    return;
                case 12006:
                    this.m.a((WriteData) null);
                    this.m.a(false);
                    this.q.a(true);
                    if (this.q.u()) {
                        this.o.f();
                        return;
                    } else if (this.k.m()) {
                        this.q.n();
                        return;
                    } else {
                        return;
                    }
                case 12009:
                case 12010:
                    n();
                    if (intent != null) {
                        this.n.a(intent.getStringExtra("file_name"));
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
                n();
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

    private void n() {
        if (this.r) {
            this.r = false;
            new Handler().postDelayed(new bc(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        MarkData f = this.k.f(this.q.C());
        if (f != null) {
            this.q.n();
            this.l.a(f);
            if (!this.l.a()) {
                this.l.c();
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.l.d();
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.m.a() == null) {
            if (!this.k.h()) {
                this.m.a(this.k.a(str));
            } else {
                this.m.a(this.o.d());
            }
        }
        if (this.m.a() != null) {
            if (str == null) {
                this.m.a().setContent(this.q.E());
            } else {
                this.m.a().setContent(this.q.F());
            }
            if (this.m.b()) {
                this.q.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.baidu.tieba.data.ao k = this.k.k();
        this.k.c(true);
        k.a(this.l.b());
        this.q.a(k);
    }

    private void q() {
        if (this.k != null) {
            if (this.k.s()) {
                MarkData t = this.k.t();
                if (t != null && this.k.e()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", t);
                    setResult(-1, intent);
                }
            } else if (this.k.k() != null && this.k.k().d() != null && this.k.k().d().size() > 0 && this.k.e()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        if (this.q == null) {
            return null;
        }
        return this.q.H();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        if (this.q == null) {
            return 0;
        }
        return this.q.I();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.b.b c() {
        return this.g;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.b.b d() {
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
                com.baidu.tieba.util.aq.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        Matcher matcher2 = e.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e3) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onClick", e3.toString());
            }
        }
        UtilHelper.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        UtilHelper.c(this, str);
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str) {
        if (this.b == null) {
            this.b = new MediaDownloadHelper(this);
        }
        this.b.a(str);
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this, "baidu_video", "click", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.k == null || this.k.k() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ao k = this.k.k();
        for (int i2 = 0; i2 < k.d().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = ((com.baidu.tieba.data.as) k.d().get(i2)).h();
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
                        this.K = i4;
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
        com.baidu.tbadk.widget.richText.e c = cVar.c();
        if (c != null) {
            if (c.a() * c.b() > com.baidu.tieba.data.g.i() * com.baidu.tieba.data.g.i()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.g.i() * com.baidu.tieba.data.g.i()) / (c.a() * c.b()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c.b() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c.a())));
            } else {
                float b = c.b() / c.a();
                double sqrt2 = Math.sqrt((com.baidu.tieba.data.g.i() * com.baidu.tieba.data.g.i()) / b);
                sb.append("width=");
                sb.append(String.valueOf((int) (b * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.ap.d(c.d()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.u = str;
            this.t.setMessage(this.u);
            this.t.show();
            StatService.onEvent(this, "pb_show_phonedialog", "show");
            if (str2.equals("2")) {
                this.t.getButton(-3).setVisibility(8);
            } else {
                this.t.getButton(-3).setVisibility(0);
            }
            Button button = this.t.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.t.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.t.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }
}
