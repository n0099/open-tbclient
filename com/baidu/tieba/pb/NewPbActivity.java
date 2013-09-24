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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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
import com.baidu.tieba.write.AudioIcon;
import com.baidu.tieba.write.WriteImageActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.richText.h, com.baidu.tieba.voice.ae {
    private static final Pattern d = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern e = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private com.baidu.tieba.voice.r f;
    private AlertDialog w;
    private String x;
    private MediaDownloadHelper b = null;
    private boolean c = false;
    private String g = null;
    private com.baidu.adp.lib.b.b<TextView> j = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.b.b<ImageView> k = new com.baidu.adp.lib.b.b<>(new al(this), 8, 0);
    private com.baidu.adp.lib.b.b<View> l = new com.baidu.adp.lib.b.b<>(new aw(this), 8, 0);
    private Handler m = new Handler(new bf(this));
    private com.baidu.tieba.model.bd n = null;
    private com.baidu.tieba.model.aw o = null;
    private com.baidu.tieba.model.bj p = null;
    private com.baidu.tieba.model.aq q = null;
    private com.baidu.tieba.model.bg r = null;
    private com.baidu.tieba.model.v s = null;
    private br t = null;
    private boolean u = false;
    private boolean v = false;
    private View.OnClickListener y = new bg(this);
    private com.baidu.tieba.model.be z = new bh(this);
    private com.baidu.tieba.model.ay A = new bi(this);
    private View.OnClickListener B = new bj(this);
    private AbsListView.OnScrollListener C = new bk(this);
    private AbsListView.OnScrollListener D = new bl(this);
    private com.baidu.tieba.model.bi E = new am(this);
    private com.baidu.tieba.model.bk F = new an(this);
    private com.baidu.adp.a.e G = new ao(this);
    private bm H = new ap(this);
    private com.baidu.adp.widget.ListView.b I = new aq(this);
    private com.baidu.adp.widget.ListView.r J = new ar(this);
    private com.baidu.adp.widget.ListView.s K = new as(this);
    private DialogInterface.OnClickListener L = new at(this);
    private com.baidu.adp.a.e M = new au(this);
    private cz N = new av(this);
    private int O = 0;
    private com.baidu.tbadk.widget.richText.m P = new ax(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.as f1516a = null;
    private DialogInterface.OnClickListener Q = new ay(this);
    private View.OnLongClickListener R = new az(this);
    private com.baidu.tieba.view.az S = new ba(this);

    @Override // com.baidu.tieba.j
    public boolean f() {
        return TiebaApplication.g().u();
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

    private void n() {
        AudioIcon f = this.t.f();
        this.t.J();
        if (f != null) {
            f.b();
        }
    }

    private void o() {
        AudioIcon f = this.t.f();
        this.t.K();
        if (f != null) {
            f.c();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.n.b(bundle);
        if (this.n.h()) {
            this.r.b(bundle);
        }
        if (this.f != null) {
            this.f.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p();
        this.f = new com.baidu.tieba.voice.r();
        this.f.a((Activity) this);
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f != null) {
            this.f.b((Activity) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        this.c = true;
        super.onPause();
        if (this.f != null) {
            this.f.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        this.c = false;
        super.onResume();
        if (this.f != null) {
            this.f.c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.n.cancelLoadData();
        this.p.cancelLoadData();
        this.q.cancelLoadData();
        this.o.cancelLoadData();
        this.r.cancelLoadData();
        this.s.cancelLoadData();
        this.t.ab();
        super.onDestroy();
        if (this.f != null) {
            this.f.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.t.b(i);
        if (this.t.a() != null) {
            this.t.a().a(i);
        }
    }

    private void p() {
        this.t = new br(this, this.y);
        this.t.a(this.C);
        this.t.b(this.D);
        this.t.a(this.B);
        this.t.a(this.J);
        this.t.a(this.K);
        this.t.a(this.L);
        this.t.a(this.I);
        this.t.e(TiebaApplication.g().al());
        this.t.f(TiebaApplication.g().B());
        this.t.a(this.P);
        this.t.a(this.R);
        this.t.a(this.N);
        this.t.a(this.S);
        this.t.a(this.H);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new bb(this)).setNeutralButton(getString(R.string.sms_phone), new bc(this)).setNegativeButton(getString(R.string.cancel), new bd(this));
        this.w = builder.create();
    }

    private void a(Bundle bundle) {
        this.n = new com.baidu.tieba.model.bd(this);
        this.n.a(this.z);
        this.o = new com.baidu.tieba.model.aw();
        this.o.a(this.A);
        this.p = new com.baidu.tieba.model.bj();
        this.p.a(this.F);
        this.q = new com.baidu.tieba.model.aq();
        this.q.setLoadDataCallBack(this.M);
        this.r = new com.baidu.tieba.model.bg(this);
        this.r.a(this.E);
        this.s = new com.baidu.tieba.model.v();
        this.s.setLoadDataCallBack(this.G);
        if (bundle != null) {
            this.n.a(bundle);
        } else {
            this.n.a(getIntent());
        }
        if (!this.n.h()) {
            this.n.n();
            this.t.x();
            return;
        }
        if (bundle != null) {
            this.r.a(bundle);
        } else {
            this.r.a(getIntent());
        }
        this.t.C();
        this.r.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.ao k;
        String str = null;
        if (this.n != null && (k = this.n.k()) != null && k.b() != null) {
            str = k.b().b();
        }
        if (com.baidu.tieba.c.a.a(str, bool)) {
            o();
        } else {
            n();
        }
    }

    public void m() {
        if (this.t.a() != null) {
            this.t.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.x xVar) {
        boolean z;
        int i = 0;
        this.t.a(0, xVar.f1460a, xVar.b, true);
        if (xVar.f1460a) {
            if (xVar.c == 1) {
                ArrayList<com.baidu.tieba.data.as> d2 = this.n.k().d();
                int size = d2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!xVar.d.equals(d2.get(i).d())) {
                        i++;
                    } else {
                        d2.remove(i);
                        break;
                    }
                }
                this.t.a(this.n.k());
            } else if (xVar.c == 0) {
                q();
            } else if (xVar.c == 2) {
                ArrayList<com.baidu.tieba.data.as> d3 = this.n.k().d();
                int size2 = d3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= d3.get(i2).a().size()) {
                            z = z2;
                            break;
                        } else if (!xVar.d.equals(d3.get(i2).a().get(i3).d())) {
                            i3++;
                        } else {
                            d3.get(i2).a().remove(i3);
                            d3.get(i2).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.t.a(this.n.k());
                }
                if (this.t.E()) {
                    ArrayList<com.baidu.tieba.data.as> b = this.r.c().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!xVar.d.equals(b.get(i4).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.t.a(this.r.c(), this.n.k().j());
                    if (!z2) {
                        String a2 = this.r.a();
                        while (i < size2) {
                            if (!a2.equals(d3.get(i).d())) {
                                i++;
                            } else {
                                d3.get(i).c();
                                this.t.a(this.n.k());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.z zVar) {
        this.t.a(1, zVar.f1462a, zVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ab abVar) {
        this.t.a(this.s.getLoadDataMode(), abVar.f1389a, abVar.b, false);
        this.t.a(abVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.ab abVar) {
        this.t.a(this.s.getLoadDataMode(), abVar.f1389a, abVar.b, true);
        if (abVar.f1389a) {
            this.v = true;
            if (i == 2) {
                this.n.k().c().b(1);
                this.n.a(1);
            } else if (i == 3) {
                this.n.k().c().b(0);
                this.n.a(0);
            } else if (i == 4) {
                this.n.k().c().a(1);
                this.n.b(1);
            } else if (i == 5) {
                this.n.k().c().a(0);
                this.n.b(0);
            }
            this.t.a(this.n.k(), true);
        }
    }

    private void q() {
        if (this.n.d()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.n.a());
            setResult(-1, intent);
        }
        u();
        super.g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void g() {
        if (this.n.d()) {
            Intent intent = new Intent();
            if (this.v) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.n.a());
                intent.putExtra("top_data", this.n.g());
                intent.putExtra("good_data", this.n.f());
            }
            setResult(-1, intent);
        }
        u();
        super.g();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.t.d(this.n.h())) {
                    v();
                    return true;
                }
                g();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
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
                case 11001:
                    c((String) null);
                    return;
                case 11009:
                    s();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    View t = this.t.t();
                    if (t != null) {
                        c((String) t.getTag());
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
                        r();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.t.H();
                            this.p.a(false);
                            return;
                        }
                        this.q.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    r();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.t.b(a2);
                        return;
                    }
                    return;
                case 12005:
                    r();
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.t.c(a3);
                        return;
                    }
                    return;
                case 12006:
                    this.p.a((WriteData) null);
                    this.p.a(false);
                    this.t.a(true);
                    if (this.t.E()) {
                        this.r.f();
                        return;
                    } else if (this.n.m()) {
                        this.t.x();
                        return;
                    } else {
                        return;
                    }
                case 12009:
                case 12010:
                    r();
                    if (intent != null) {
                        this.q.a(intent.getStringExtra("file_name"));
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
                r();
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

    private void r() {
        if (this.u) {
            this.u = false;
            new Handler().postDelayed(new be(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        MarkData f = this.n.f(this.t.P());
        if (f != null) {
            this.t.x();
            this.o.a(f);
            if (!this.o.a()) {
                this.o.c();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.o.d();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        com.baidu.tieba.voice.ai voiceModel;
        if (this.p.a() == null) {
            if (!this.n.h()) {
                this.p.a(this.n.a(str));
            } else {
                this.p.a(this.r.d());
            }
        }
        if (this.p.a() != null) {
            if (str == null) {
                this.p.a().setContent(this.t.R());
                voiceModel = this.t.c() != null ? this.t.c().getVoiceModel() : null;
                if (this.t.c() != null) {
                    this.t.c().d();
                }
            } else {
                this.p.a().setContent(this.t.S());
                voiceModel = this.t.g() != null ? this.t.g().getVoiceModel() : null;
                if (this.t.g() != null) {
                    this.t.g().d();
                }
            }
            if (voiceModel != null && voiceModel != null && voiceModel.a() != null) {
                this.p.a().setVoice(voiceModel.a());
                this.p.a().setVoiceDuringTime(voiceModel.d);
            }
            if (this.p.b()) {
                this.t.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.baidu.tieba.data.ao k = this.n.k();
        this.n.c(true);
        k.a(this.o.b());
        this.t.a(k);
    }

    private void u() {
        if (this.n != null) {
            if (this.n.s()) {
                MarkData t = this.n.t();
                if (t != null && this.n.e()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", t);
                    setResult(-1, intent);
                }
            } else if (this.n.k() != null && this.n.k().d() != null && this.n.k().d().size() > 0 && this.n.e()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        if (this.t == null) {
            return null;
        }
        return this.t.U();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        if (this.t == null) {
            return 0;
        }
        return this.t.V();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.b.b<ImageView> c() {
        return this.k;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.b.b<TextView> d() {
        return this.j;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.b.b<View> e() {
        return this.l;
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
                com.baidu.tieba.util.av.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        Matcher matcher2 = e.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e3) {
                com.baidu.tieba.util.av.b(getClass().getName(), "onClick", e3.toString());
            }
        }
        UtilHelper.c(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void c(Context context, String str) {
        UtilHelper.c(this, str);
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str) {
        if (this.b == null) {
            this.b = new MediaDownloadHelper(this);
        }
        this.b.a(str);
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "baidu_video", "click", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.n == null || this.n.k() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ao k = this.n.k();
        for (int i2 = 0; i2 < k.d().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = k.d().get(i2).h();
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = h.a();
            int size = a2.size();
            int i3 = -1;
            int i4 = 0;
            while (i4 < size) {
                if (a2.get(i4) != null && a2.get(i4).a() == 8) {
                    i3++;
                    if (a2.get(i4).c().e().equals(str)) {
                        int b = a2.get(i4).c().b();
                        int a3 = a2.get(i4).c().a();
                        if (b < 80 || a3 < 80 || a3 * b < 10000) {
                            return null;
                        }
                        this.O = i4;
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
            sb.append(com.baidu.tieba.util.at.d(c.d()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.x = str;
            this.w.setMessage(this.x);
            this.w.show();
            com.baidu.tieba.ad.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.w.getButton(-3).setVisibility(8);
            } else {
                this.w.getButton(-3).setVisibility(0);
            }
            Button button = this.w.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.w.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.w.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ae
    public com.baidu.tieba.voice.r c_() {
        return this.f;
    }

    @Override // com.baidu.tieba.voice.ae
    public com.baidu.tieba.voice.ac a(com.baidu.tieba.voice.ai aiVar) {
        View ai;
        View findViewWithTag;
        if (!this.t.E() || (ai = this.t.ai()) == null || (findViewWithTag = ai.findViewWithTag(aiVar)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ac) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f != null) {
            this.f.e();
        }
    }
}
