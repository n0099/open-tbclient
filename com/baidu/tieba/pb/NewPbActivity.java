package com.baidu.tieba.pb;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.media.MediaDownloadHelper;
import com.baidu.tieba.person.PersonInfoActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.a, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.view.bx, com.baidu.tieba.voice.af {
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static final Pattern f = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern g = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern h = Pattern.compile("[?|&]kw=[^&]+");
    private AlertDialog B;
    private String C;
    private String D;
    private VoiceManager i;
    private AlertDialog k;
    private MediaDownloadHelper d = null;
    private boolean e = false;
    private int j = 0;

    /* renamed from: a  reason: collision with root package name */
    HashMap<MediaType, String> f2139a = null;
    private String l = null;
    private com.baidu.adp.lib.d.b<TextView> m = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<TbImageView> n = UserIconBox.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> o = new com.baidu.adp.lib.d.b<>(new ak(this), 8, 0);
    private com.baidu.adp.lib.d.b<View> p = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private com.baidu.adp.lib.d.b<LinearLayout> q = new com.baidu.adp.lib.d.b<>(new bh(this), 8, 0);
    private Handler r = new Handler(new bp(this));
    private com.baidu.tieba.model.bm s = null;
    private com.baidu.tieba.model.bg t = null;
    private com.baidu.tieba.model.bs u = null;
    private com.baidu.tieba.model.av v = null;
    private com.baidu.tieba.model.bp w = null;
    private com.baidu.tieba.model.ad x = null;
    private cr y = null;
    private boolean z = false;
    private boolean A = false;
    private View.OnClickListener E = new am(this);
    private com.baidu.tieba.model.bn F = new ao(this);
    private com.baidu.tieba.model.bi G = new ap(this);
    private View.OnClickListener H = new aq(this);
    private View.OnClickListener I = new ar(this);
    private int J = 0;
    private AbsListView.OnScrollListener K = new as(this);
    private AbsListView.OnScrollListener L = new at(this);
    private com.baidu.tieba.model.br M = new au(this);
    private com.baidu.tieba.model.bt N = new av(this);
    private com.baidu.adp.a.g O = new ax(this);
    private bw P = new ay(this);
    private com.baidu.adp.widget.ListView.b Q = new az(this);
    private com.baidu.adp.widget.ListView.r R = new ba(this);
    private com.baidu.adp.widget.ListView.t S = new bb(this);
    private DialogInterface.OnClickListener T = new bc(this);
    private com.baidu.adp.a.g U = new bd(this);
    private dx V = new bj(this);
    private int W = 0;
    private com.baidu.tbadk.widget.richText.o X = new bk(this);
    com.baidu.tieba.data.ar b = null;
    private DialogInterface.OnClickListener Y = new bl(this);
    private View.OnLongClickListener Z = new bm(this);
    private com.baidu.tieba.view.ba aa = new bn(this);
    private List<com.baidu.tbadk.widget.b> ab = new ArrayList();

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.h().v();
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

    public static void a(Activity activity, com.baidu.tieba.data.az azVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (azVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", azVar.a());
            intent.putExtra("is_good", azVar.g());
            intent.putExtra("is_top", azVar.f());
            intent.putExtra("thread_time", azVar.e());
            intent.putExtra("st_type", str2);
            intent.putExtra("from_frs", true);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("forum_name", str);
            activity.startActivityForResult(intent, i);
        }
    }

    private void l() {
        this.y.B();
        this.y.d();
    }

    private void m() {
        this.y.C();
        this.y.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.s.b(bundle);
        if (this.s.i()) {
            this.w.b(bundle);
        }
        if (this.i != null) {
            this.i.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = 0;
        n();
        this.i = new VoiceManager();
        this.i.a((Activity) this);
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.i != null) {
            this.i.b((Activity) this);
        }
    }

    public cr b() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        this.e = true;
        super.onPause();
        ListView c2 = c();
        this.j = CompatibleUtile.getInstance().getViewLayer(c2);
        if (this.j == 1) {
            CompatibleUtile.getInstance().noneViewGpu(c2);
        }
        if (this.i != null) {
            this.i.d(this);
        }
        if (this.y != null) {
            this.y.X();
        }
        if (this.ab != null) {
            this.ab.clear();
        }
        if (!this.s.i()) {
            PbEditorCacheModel.a(this.s.b(), this.y.J(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.e = false;
        super.onResume();
        if (this.j == 1) {
            CompatibleUtile.getInstance().closeViewGpu(c());
        }
        NoNetworkView a2 = this.y.a();
        if (a2 != null && a2.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a2.setVisible(false);
        }
        if (this.i != null) {
            this.i.c(this);
        }
        if (!this.s.i()) {
            PbEditorCacheModel.a(this.s.b(), new bq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.i != null) {
            this.i.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.s.cancelLoadData();
        this.u.cancelLoadData();
        this.v.cancelLoadData();
        this.t.cancelLoadData();
        this.w.cancelLoadData();
        this.x.cancelLoadData();
        this.y.Y();
        super.onDestroy();
        if (this.i != null) {
            this.i.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.y.b(i);
        if (this.y.a() != null) {
            this.y.a().a(i);
        }
    }

    private void n() {
        this.y = new cr(this, this.E);
        this.y.a(new br(this));
        this.y.a(this.K);
        this.y.b(this.L);
        this.y.a(this.H);
        this.y.b(this.I);
        this.y.a(this.R);
        this.y.a(this.S);
        this.y.a(this.T);
        this.y.a(this.Q);
        this.y.h(com.baidu.tieba.d.a.a().f());
        this.y.i(com.baidu.tieba.d.a.a().d());
        this.y.a(this.X);
        this.y.a(this.Z);
        this.y.a(this.V);
        this.y.a(this.aa);
        this.y.a(this.P);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new bu(this)).setNeutralButton(getString(R.string.sms_phone), new bt(this)).setNegativeButton(getString(R.string.cancel), new bs(this));
        this.B = builder.create();
    }

    private void a(Bundle bundle) {
        this.s = new com.baidu.tieba.model.bm(this);
        this.s.a(this.F);
        this.t = new com.baidu.tieba.model.bg();
        this.t.a(this.G);
        this.u = new com.baidu.tieba.model.bs();
        this.u.a(this.N);
        this.v = new com.baidu.tieba.model.av();
        this.v.setLoadDataCallBack(this.U);
        this.w = new com.baidu.tieba.model.bp(this);
        this.w.a(this.M);
        this.x = new com.baidu.tieba.model.ad();
        this.x.setLoadDataCallBack(this.O);
        if (bundle != null) {
            this.s.a(bundle);
        } else {
            this.s.a(getIntent());
        }
        if (!this.s.i()) {
            this.s.o();
            this.y.o();
        } else {
            if (bundle != null) {
                this.w.a(bundle);
            } else {
                this.w.a(getIntent());
            }
            this.D = this.w.b();
            String c2 = this.w.c();
            if (c2 != null && (("mention".equals(this.w.c()) || c2.equals("person_post_reply")) && this.D != null)) {
                this.y.A();
            } else {
                this.y.u();
            }
            this.w.j();
        }
        this.y.a(new al(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ar arVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (arVar = (com.baidu.tieba.data.ar) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(arVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.an l;
        String str = null;
        if (this.s != null && (l = this.s.l()) != null && l.c() != null) {
            str = l.c().getName();
        }
        if (com.baidu.tieba.e.a.a(str, bool)) {
            m();
        } else {
            l();
        }
    }

    public void i() {
        if (this.y.a() != null) {
            this.y.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.s.i()) {
                antiData.setBlock_forum_name(this.s.l().c().getName());
                antiData.setBlock_forum_id(this.s.l().c().getId());
                antiData.setUser_name(this.s.l().h().getName());
                antiData.setUser_id(this.s.l().h().getId());
            } else {
                antiData.setBlock_forum_name(this.w.e().h().getName());
                antiData.setBlock_forum_id(this.w.e().h().getId());
                antiData.setUser_name(TiebaApplication.G());
                antiData.setUser_id(TiebaApplication.B());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.y.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.af afVar) {
        boolean z;
        int i = 0;
        this.y.a(0, afVar.f1980a, afVar.b, true);
        if (afVar.f1980a) {
            if (afVar.c == 1) {
                ArrayList<com.baidu.tieba.data.ar> e = this.s.l().e();
                int size = e.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!afVar.d.equals(e.get(i).d())) {
                        i++;
                    } else {
                        e.remove(i);
                        break;
                    }
                }
                this.y.a(this.s.l());
            } else if (afVar.c == 0) {
                o();
            } else if (afVar.c == 2) {
                ArrayList<com.baidu.tieba.data.ar> e2 = this.s.l().e();
                int size2 = e2.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e2.get(i2).a().size()) {
                            z = z2;
                            break;
                        } else if (!afVar.d.equals(e2.get(i2).a().get(i3).d())) {
                            i3++;
                        } else {
                            e2.get(i2).a().remove(i3);
                            e2.get(i2).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.y.a(this.s.l());
                }
                if (this.y.x()) {
                    ArrayList<com.baidu.tieba.data.ar> c2 = this.w.e().c();
                    int size3 = c2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!afVar.d.equals(c2.get(i4).d())) {
                            i4++;
                        } else {
                            c2.remove(i4);
                            break;
                        }
                    }
                    this.y.a(this.w.e(), this.s.l().l());
                    if (!z2) {
                        String b = this.w.b();
                        while (i < size2) {
                            if (!b.equals(e2.get(i).d())) {
                                i++;
                            } else {
                                e2.get(i).c();
                                this.y.a(this.s.l());
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
        this.y.a(1, ahVar.f1982a, ahVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aj ajVar) {
        this.y.a(this.x.getLoadDataMode(), ajVar.f1984a, ajVar.b, false);
        this.y.a(ajVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aj ajVar) {
        this.y.a(this.x.getLoadDataMode(), ajVar.f1984a, ajVar.b, true);
        if (ajVar.f1984a) {
            this.A = true;
            if (i == 2) {
                this.s.l().d().b(1);
                this.s.a(1);
            } else if (i == 3) {
                this.s.l().d().b(0);
                this.s.a(0);
            } else if (i == 4) {
                this.s.l().d().a(1);
                this.s.b(1);
            } else if (i == 5) {
                this.s.l().d().a(0);
                this.s.b(0);
            }
            this.y.a(this.s.l(), true);
        }
    }

    private void o() {
        if (this.s.e()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.s.b());
            setResult(-1, intent);
        }
        s();
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        if (this.s.e()) {
            Intent intent = new Intent();
            if (this.A) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.s.b());
                intent.putExtra("top_data", this.s.h());
                intent.putExtra("good_data", this.s.g());
            }
            setResult(-1, intent);
        }
        s();
        super.closeActivity();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.y.g(this.s.i())) {
                    u();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        String B = TiebaApplication.B();
        if (B == null || B.length() <= 0) {
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
                    a((String) null);
                    return;
                case 11009:
                    q();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    a(this.y.L());
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
                        p();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.y.G();
                            this.u.a(false);
                            return;
                        }
                        this.v.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    p();
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.y.b(a2);
                        return;
                    }
                    return;
                case 12005:
                    p();
                    new Handler().postDelayed(new be(this), 200L);
                    String a3 = AtListActivity.a(intent);
                    if (a3 != null) {
                        this.y.c(a3);
                        return;
                    }
                    return;
                case 12006:
                    this.u.a((WriteData) null);
                    this.u.a(false);
                    this.y.a(true);
                    if (this.y.x()) {
                        if (this.w.i()) {
                        }
                        return;
                    }
                    if (this.s.n()) {
                        this.y.o();
                    }
                    if (this.s != null && this.s.b() != null) {
                        PbEditorCacheModel.a(this.s.b(), "", null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    p();
                    if (intent != null) {
                        this.v.a(intent.getStringExtra("file_name"));
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
                p();
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

    private void p() {
        if (this.z) {
            this.z = false;
            new Handler().postDelayed(new bf(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        MarkData f2 = this.s.f(this.y.H());
        if (f2 != null) {
            this.y.o();
            this.t.a(f2);
            if (!this.t.a()) {
                this.t.d();
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.t.e();
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VoiceManager.VoiceModel f2;
        if (this.u.a() == null) {
            if (!this.s.i()) {
                this.u.a(this.s.a(str));
            } else {
                this.u.a(this.w.f());
            }
        }
        if (this.u.a() != null) {
            if (str == null) {
                this.u.a().setContent(this.y.J());
                f2 = this.y.b();
                this.y.c();
            } else {
                this.u.a().setContent(this.y.K());
                f2 = this.y.f();
                this.y.g();
            }
            if (f2 != null) {
                if (f2 != null && f2.getId() != null) {
                    this.u.a().setVoice(f2.getId());
                    this.u.a().setVoiceDuringTime(f2.duration);
                } else {
                    this.u.a().setVoice(null);
                    this.u.a().setVoiceDuringTime(-1);
                }
            } else {
                this.u.a().setVoice(null);
                this.u.a().setVoiceDuringTime(-1);
            }
            if (this.u.b()) {
                this.y.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.baidu.tieba.data.an l = this.s.l();
        this.s.c(true);
        l.a(this.t.c());
        this.y.a(l);
    }

    private void s() {
        if (this.s != null) {
            if (this.s.t()) {
                MarkData u = this.s.u();
                if (u != null && this.s.f()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", u);
                    setResult(-1, intent);
                }
            } else if (this.s.l() != null && this.s.l().e() != null && this.s.l().e().size() > 0 && this.s.f()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView c() {
        if (this.y == null) {
            return null;
        }
        return this.y.O();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int d() {
        if (this.y == null) {
            return 0;
        }
        return this.y.P();
    }

    @Override // com.baidu.tieba.view.bx
    public int a() {
        if (this.y == null) {
            return 0;
        }
        return this.y.Q();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.o;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.m;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> g() {
        return this.p;
    }

    @Override // com.baidu.tieba.view.bx
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.n;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, (String) null);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void b(Context context, String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com")) {
            Matcher matcher = f.matcher(lowerCase);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    a(this, group.substring(group.lastIndexOf("/") + 1), null, null);
                    return;
                } catch (Exception e) {
                    com.baidu.tieba.util.bd.b(getClass().getName(), "onClick", e.toString());
                }
            }
            Matcher matcher2 = g.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                    return;
                } catch (Exception e2) {
                    com.baidu.tieba.util.bd.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher3 = h.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    FrsActivity.a(this, group3.substring(group3.lastIndexOf("=") + 1), "pb");
                    return;
                } catch (Exception e3) {
                    com.baidu.tieba.util.bd.b(getClass().getName(), "onClick", e3.toString());
                }
            }
        }
        UtilHelper.b(this, str);
    }

    private DialogInterface t() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.download_baidu_video_dialog));
            builder.setPositiveButton(getString(R.string.install), new bg(this));
            builder.setNegativeButton(getString(R.string.cancel), new bi(this));
            builder.setCancelable(true);
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(false);
        }
        this.k.show();
        return this.k;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void c(Context context, String str) {
        UtilHelper.b(this, str);
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void e(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            t();
        }
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this, "baidu_video", "click", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.ar arVar) {
        boolean z = false;
        if (arVar.d() != null && arVar.d().equals(this.s.k())) {
            z = true;
        }
        MarkData b = this.s.b(arVar);
        if (b != null && a(11009)) {
            this.t.a(b);
            this.y.o();
            if (!z) {
                this.t.d();
            } else {
                this.t.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.s == null || this.s.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.an l = this.s.l();
        for (int i2 = 0; i2 < l.e().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h2 = l.e().get(i2).h();
            ArrayList<com.baidu.tbadk.widget.richText.c> a2 = h2.a();
            int size = a2.size();
            int i3 = -1;
            int i4 = 0;
            while (i4 < size) {
                if (a2.get(i4) != null && a2.get(i4).a() == 8) {
                    i3++;
                    if (a2.get(i4).c().f().equals(str)) {
                        int c2 = a2.get(i4).c().c();
                        int b = a2.get(i4).c().b();
                        if (c2 < 80 || b < 80 || b * c2 < 10000) {
                            return null;
                        }
                        this.W = i4;
                        return h2;
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
        com.baidu.tbadk.widget.richText.f c2 = cVar.c();
        if (c2 != null) {
            if (!com.baidu.adp.lib.h.l.a(c2.a())) {
                return c2.a();
            }
            if (c2.b() * c2.c() > com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / (c2.b() * c2.c()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c2.c() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c2.b())));
            } else {
                float c3 = c2.c() / c2.b();
                double sqrt2 = Math.sqrt((com.baidu.tieba.data.h.i() * com.baidu.tieba.data.h.i()) / c3);
                sb.append("width=");
                sb.append(String.valueOf((int) (c3 * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.bb.d(c2.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.C = str;
            this.B.setMessage(this.C);
            this.B.show();
            com.baidu.tieba.ap.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.B.getButton(-3).setVisibility(8);
            } else {
                this.B.getButton(-3).setVisibility(0);
            }
            Button button = this.B.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.B.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.B.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        return this.i;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        View af;
        View findViewWithTag;
        if (!this.y.x() || (af = this.y.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.i != null) {
            this.i.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.s.s()) {
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this, "pb_share", "pbclick", 1);
            }
            com.baidu.tieba.data.an l = this.s.l();
            String name = l.c().getName();
            String c2 = l.d().c();
            String str = "http://tieba.baidu.com/p/" + this.s.b() + "?share=9105";
            String[] b = l.b();
            String str2 = b[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), c2, name, b[1]);
            ShareContent shareContent = new ShareContent();
            shareContent.setTitle(c2);
            shareContent.setContent(format);
            shareContent.setLinkUrl(str);
            if (parse != null) {
                shareContent.setImageUri(parse);
            }
            com.baidu.tieba.widget.share.b bVar = new com.baidu.tieba.widget.share.b(this);
            bVar.a(shareContent, true);
            bVar.a(w());
            bVar.a(x(), new bo(this, str));
            bVar.a();
        }
    }

    private HashMap<MediaType, String> w() {
        if (this.f2139a == null) {
            this.f2139a = new HashMap<>(6);
            this.f2139a.put(MediaType.WEIXIN_TIMELINE, "pb_wx_timeline");
            this.f2139a.put(MediaType.WEIXIN_FRIEND, "pb_wx_friend");
            this.f2139a.put(MediaType.QZONE, "pb_qq_zone");
            this.f2139a.put(MediaType.QQWEIBO, "pb_tencent_weibo");
            this.f2139a.put(MediaType.SINAWEIBO, "pb_sina_weibo");
            this.f2139a.put(MediaType.RENREN, "pb_renren");
        }
        return this.f2139a;
    }

    private View x() {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.btn_copy_pb_url, (ViewGroup) null);
        if (TiebaApplication.h().an() == 1) {
            textView.setBackgroundResource(R.drawable.btn_blue_square_1);
            textView.setTextColor(getResources().getColor(R.color.share_copy_pb_url_1));
        } else {
            textView.setBackgroundResource(R.drawable.btn_blue_square);
            textView.setTextColor(getResources().getColor(R.color.share_copy_pb_url));
        }
        return textView;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> h() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.ab.remove(bVar);
        }
    }

    public void j() {
        while (this.ab.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.ab.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
