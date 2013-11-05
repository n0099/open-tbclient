package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.AudioIcon;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.richText.h, com.baidu.tieba.voice.ag {
    private static final Pattern d = Pattern.compile("(tieba.baidu.com/p/){1}\\d+");
    private static final Pattern e = Pattern.compile("(tieba.baidu.com/f\\?kz=){1}\\d+");
    private VoiceManager f;
    private AlertDialog x;
    private String y;
    private MediaDownloadHelper b = null;
    private boolean c = false;
    private String g = null;
    private com.baidu.adp.lib.d.b<TextView> j = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> k = new com.baidu.adp.lib.d.b<>(new al(this), 8, 0);
    private com.baidu.adp.lib.d.b<View> l = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private com.baidu.adp.lib.d.b<LinearLayout> m = new com.baidu.adp.lib.d.b<>(new bg(this), 8, 0);
    private Handler n = new Handler(new bh(this));
    private com.baidu.tieba.model.bl o = null;
    private com.baidu.tieba.model.bf p = null;
    private com.baidu.tieba.model.br q = null;
    private com.baidu.tieba.model.ay r = null;
    private com.baidu.tieba.model.bo s = null;
    private com.baidu.tieba.model.ad t = null;
    private bt u = null;
    private boolean v = false;
    private boolean w = false;
    private View.OnClickListener z = new bl(this);
    private com.baidu.tieba.model.bm A = new bm(this);
    private com.baidu.tieba.model.bh B = new am(this);
    private View.OnClickListener C = new an(this);
    private AbsListView.OnScrollListener D = new ao(this);
    private AbsListView.OnScrollListener E = new ap(this);
    private com.baidu.tieba.model.bq F = new aq(this);
    private com.baidu.tieba.model.bs G = new ar(this);
    private com.baidu.adp.a.g H = new as(this);
    private bn I = new at(this);
    private com.baidu.adp.widget.ListView.b J = new au(this);
    private com.baidu.adp.widget.ListView.r K = new av(this);
    private com.baidu.adp.widget.ListView.s L = new ax(this);
    private DialogInterface.OnClickListener M = new ay(this);
    private com.baidu.adp.a.g N = new az(this);
    private db O = new bb(this);
    private int P = 0;
    private com.baidu.tbadk.widget.richText.m Q = new bc(this);

    /* renamed from: a  reason: collision with root package name */
    com.baidu.tieba.data.as f2033a = null;
    private DialogInterface.OnClickListener R = new bd(this);
    private View.OnLongClickListener S = new be(this);
    private com.baidu.tieba.view.az T = new bf(this);

    @Override // com.baidu.tieba.j
    public boolean g() {
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

    public static void a(Activity activity, com.baidu.tieba.data.bf bfVar, String str, int i, boolean z, boolean z2, boolean z3) {
        if (bfVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bfVar.a());
            intent.putExtra("is_good", bfVar.f());
            intent.putExtra("is_top", bfVar.e());
            intent.putExtra("thread_time", bfVar.d());
            intent.putExtra("st_type", str);
            intent.putExtra("from_frs", true);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            activity.startActivityForResult(intent, i);
        }
    }

    private void o() {
        AudioIcon f = this.u.f();
        this.u.J();
        if (f != null) {
            f.b();
        }
    }

    private void p() {
        AudioIcon f = this.u.f();
        this.u.K();
        if (f != null) {
            f.c();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.o.b(bundle);
        if (this.o.h()) {
            this.s.b(bundle);
        }
        if (this.f != null) {
            this.f.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        q();
        this.f = new VoiceManager();
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
        NetworkInfo activeNetworkInfo;
        this.c = false;
        super.onResume();
        NoNetworkView a2 = this.u.a();
        if (a2 != null && a2.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a2.setVisible(false);
        }
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
        this.o.cancelLoadData();
        this.q.cancelLoadData();
        this.r.cancelLoadData();
        this.p.cancelLoadData();
        this.s.cancelLoadData();
        this.t.cancelLoadData();
        this.u.ab();
        super.onDestroy();
        if (this.f != null) {
            this.f.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        this.u.b(i);
        if (this.u.a() != null) {
            this.u.a().a(i);
        }
    }

    private void q() {
        this.u = new bt(this, this.z);
        this.u.a(this.D);
        this.u.b(this.E);
        this.u.a(this.C);
        this.u.a(this.K);
        this.u.a(this.L);
        this.u.a(this.M);
        this.u.a(this.J);
        this.u.e(TiebaApplication.g().an());
        this.u.f(TiebaApplication.g().B());
        this.u.a(this.Q);
        this.u.a(this.S);
        this.u.a(this.O);
        this.u.a(this.T);
        this.u.a(this.I);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new bk(this)).setNeutralButton(getString(R.string.sms_phone), new bj(this)).setNegativeButton(getString(R.string.cancel), new bi(this));
        this.x = builder.create();
    }

    private void a(Bundle bundle) {
        this.o = new com.baidu.tieba.model.bl(this);
        this.o.a(this.A);
        this.p = new com.baidu.tieba.model.bf();
        this.p.a(this.B);
        this.q = new com.baidu.tieba.model.br();
        this.q.a(this.G);
        this.r = new com.baidu.tieba.model.ay();
        this.r.setLoadDataCallBack(this.N);
        this.s = new com.baidu.tieba.model.bo(this);
        this.s.a(this.F);
        this.t = new com.baidu.tieba.model.ad();
        this.t.setLoadDataCallBack(this.H);
        if (bundle != null) {
            this.o.a(bundle);
        } else {
            this.o.a(getIntent());
        }
        if (!this.o.h()) {
            this.o.n();
            this.u.x();
            return;
        }
        if (bundle != null) {
            this.s.a(bundle);
        } else {
            this.s.a(getIntent());
        }
        this.u.C();
        this.s.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.ao k;
        String str = null;
        if (this.o != null && (k = this.o.k()) != null && k.b() != null) {
            str = k.b().getName();
        }
        if (com.baidu.tieba.c.a.a(str, bool)) {
            p();
        } else {
            o();
        }
    }

    public void n() {
        if (this.u.a() != null) {
            this.u.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.af afVar) {
        boolean z;
        int i = 0;
        this.u.a(0, afVar.f1890a, afVar.b, true);
        if (afVar.f1890a) {
            if (afVar.c == 1) {
                ArrayList<com.baidu.tieba.data.as> d2 = this.o.k().d();
                int size = d2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!afVar.d.equals(d2.get(i).d())) {
                        i++;
                    } else {
                        d2.remove(i);
                        break;
                    }
                }
                this.u.a(this.o.k());
            } else if (afVar.c == 0) {
                r();
            } else if (afVar.c == 2) {
                ArrayList<com.baidu.tieba.data.as> d3 = this.o.k().d();
                int size2 = d3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= d3.get(i2).a().size()) {
                            z = z2;
                            break;
                        } else if (!afVar.d.equals(d3.get(i2).a().get(i3).d())) {
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
                    this.u.a(this.o.k());
                }
                if (this.u.E()) {
                    ArrayList<com.baidu.tieba.data.as> b = this.s.c().b();
                    int size3 = b.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!afVar.d.equals(b.get(i4).d())) {
                            i4++;
                        } else {
                            b.remove(i4);
                            break;
                        }
                    }
                    this.u.a(this.s.c(), this.o.k().j());
                    if (!z2) {
                        String a2 = this.s.a();
                        while (i < size2) {
                            if (!a2.equals(d3.get(i).d())) {
                                i++;
                            } else {
                                d3.get(i).c();
                                this.u.a(this.o.k());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ah ahVar) {
        this.u.a(1, ahVar.f1892a, ahVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aj ajVar) {
        this.u.a(this.t.getLoadDataMode(), ajVar.f1894a, ajVar.b, false);
        this.u.a(ajVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aj ajVar) {
        this.u.a(this.t.getLoadDataMode(), ajVar.f1894a, ajVar.b, true);
        if (ajVar.f1894a) {
            this.w = true;
            if (i == 2) {
                this.o.k().c().b(1);
                this.o.a(1);
            } else if (i == 3) {
                this.o.k().c().b(0);
                this.o.a(0);
            } else if (i == 4) {
                this.o.k().c().a(1);
                this.o.b(1);
            } else if (i == 5) {
                this.o.k().c().a(0);
                this.o.b(0);
            }
            this.u.a(this.o.k(), true);
        }
    }

    private void r() {
        if (this.o.d()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.o.a());
            setResult(-1, intent);
        }
        v();
        super.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void h() {
        if (this.o.d()) {
            Intent intent = new Intent();
            if (this.w) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.o.a());
                intent.putExtra("top_data", this.o.g());
                intent.putExtra("good_data", this.o.f());
            }
            setResult(-1, intent);
        }
        v();
        super.h();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.u.d(this.o.h())) {
                    w();
                    return true;
                }
                h();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
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
                    t();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    View t = this.u.t();
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
                        s();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.u.H();
                            this.q.a(false);
                            return;
                        }
                        this.r.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    s();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.u.b(a2);
                        return;
                    }
                    return;
                case 12005:
                    s();
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.u.c(a3);
                        return;
                    }
                    return;
                case 12006:
                    this.q.a((WriteData) null);
                    this.q.a(false);
                    this.u.a(true);
                    if (this.u.E()) {
                        if (this.s.f()) {
                        }
                        return;
                    } else if (this.o.m()) {
                        this.u.x();
                        return;
                    } else {
                        return;
                    }
                case 12009:
                case 12010:
                    s();
                    if (intent != null) {
                        this.r.a(intent.getStringExtra("file_name"));
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
                s();
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

    private void s() {
        if (this.v) {
            this.v = false;
            new Handler().postDelayed(new ba(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        MarkData f = this.o.f(this.u.P());
        if (f != null) {
            this.u.x();
            this.p.a(f);
            if (!this.p.a()) {
                this.p.c();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.p.d();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        VoiceManager.VoiceModel voiceModel;
        if (this.q.a() == null) {
            if (!this.o.h()) {
                this.q.a(this.o.a(str));
            } else {
                this.q.a(this.s.d());
            }
        }
        if (this.q.a() != null) {
            if (str == null) {
                this.q.a().setContent(this.u.R());
                voiceModel = this.u.c() != null ? this.u.c().getVoiceModel() : null;
                if (this.u.c() != null) {
                    this.u.c().c();
                }
            } else {
                this.q.a().setContent(this.u.S());
                voiceModel = this.u.g() != null ? this.u.g().getVoiceModel() : null;
                if (this.u.g() != null) {
                    this.u.g().c();
                }
            }
            if (voiceModel != null) {
                if (voiceModel != null && voiceModel.getId() != null) {
                    this.q.a().setVoice(voiceModel.getId());
                    this.q.a().setVoiceDuringTime(voiceModel.duration);
                } else {
                    this.q.a().setVoice(null);
                    this.q.a().setVoiceDuringTime(-1);
                }
            } else {
                this.q.a().setVoice(null);
                this.q.a().setVoiceDuringTime(-1);
            }
            if (this.q.b()) {
                this.u.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.baidu.tieba.data.ao k = this.o.k();
        this.o.c(true);
        k.a(this.p.b());
        this.u.a(k);
    }

    private void v() {
        if (this.o != null) {
            if (this.o.s()) {
                MarkData t = this.o.t();
                if (t != null && this.o.e()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", t);
                    setResult(-1, intent);
                }
            } else if (this.o.k() != null && this.o.k().d() != null && this.o.k().d().size() > 0 && this.o.e()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView a() {
        if (this.u == null) {
            return null;
        }
        return this.u.U();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int b() {
        if (this.u == null) {
            return 0;
        }
        return this.u.V();
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> c() {
        return this.k;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> d() {
        return this.j;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> e() {
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
                com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e2.toString());
            }
        }
        Matcher matcher2 = e.matcher(str);
        if (matcher2.find()) {
            try {
                String group2 = matcher2.group();
                a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                return;
            } catch (Exception e3) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e3.toString());
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
        if (this.o == null || this.o.k() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ao k = this.o.k();
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
                        this.P = i4;
                        return h;
                    } else if (i3 > i) {
                        break;
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
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.e c = cVar.c();
        if (c != null) {
            if (c.a() * c.b() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (c.a() * c.b()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c.b() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c.a())));
            } else {
                float b = c.b() / c.a();
                double sqrt2 = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / b);
                sb.append("width=");
                sb.append(String.valueOf((int) (b * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.bc.d(c.d()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.y = str;
            this.x.setMessage(this.y);
            this.x.show();
            com.baidu.tieba.ag.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.x.getButton(-3).setVisibility(8);
            } else {
                this.x.getButton(-3).setVisibility(0);
            }
            Button button = this.x.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.x.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.x.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.voice.ag
    public VoiceManager g_() {
        return this.f;
    }

    @Override // com.baidu.tieba.voice.ag
    public com.baidu.tieba.voice.ae a(VoiceManager.VoiceModel voiceModel) {
        View ai;
        View findViewWithTag;
        if (!this.u.E() || (ai = this.u.ai()) == null || (findViewWithTag = ai.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ae) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.f != null) {
            this.f.g();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> f() {
        return this.m;
    }
}
