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
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.a, com.baidu.tbadk.widget.richText.i, com.baidu.tieba.view.cd, com.baidu.tieba.voice.af {
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static final Pattern e = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern f = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern g = Pattern.compile("[?|&]kw=[^&]+");
    private AlertDialog A;
    private String B;
    private String C;
    private VoiceManager h;
    private AlertDialog j;
    private boolean d = false;
    private int i = 0;
    HashMap<MediaType, String> a = null;
    private String k = null;
    private com.baidu.adp.lib.d.b<TextView> l = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<TbImageView> m = UserIconBox.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> n = new com.baidu.adp.lib.d.b<>(new ak(this), 8, 0);
    private com.baidu.adp.lib.d.b<View> o = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private com.baidu.adp.lib.d.b<LinearLayout> p = new com.baidu.adp.lib.d.b<>(new bh(this), 8, 0);
    private Handler q = new Handler(new bp(this));
    private com.baidu.tieba.model.bm r = null;
    private com.baidu.tieba.model.bg s = null;
    private com.baidu.tieba.model.bs t = null;
    private com.baidu.tieba.model.av u = null;
    private com.baidu.tieba.model.bp v = null;
    private com.baidu.tieba.model.ad w = null;
    private cr x = null;
    private boolean y = false;
    private boolean z = false;
    private View.OnClickListener D = new am(this);
    private com.baidu.tieba.model.bn E = new ao(this);
    private com.baidu.tieba.model.bi F = new ap(this);
    private View.OnClickListener G = new aq(this);
    private View.OnClickListener H = new ar(this);
    private int I = 0;
    private AbsListView.OnScrollListener J = new as(this);
    private AbsListView.OnScrollListener K = new at(this);
    private com.baidu.tieba.model.br L = new au(this);
    private com.baidu.tieba.model.bt M = new av(this);
    private com.baidu.adp.a.g N = new ax(this);
    private bw O = new ay(this);
    private com.baidu.adp.widget.ListView.b P = new az(this);
    private com.baidu.adp.widget.ListView.r Q = new ba(this);
    private com.baidu.adp.widget.ListView.t R = new bb(this);
    private DialogInterface.OnClickListener S = new bc(this);
    private com.baidu.adp.a.g T = new bd(this);
    private dx U = new bj(this);
    private int V = 0;
    private com.baidu.tbadk.widget.richText.o W = new bk(this);
    com.baidu.tieba.data.ar b = null;
    private DialogInterface.OnClickListener X = new bl(this);
    private View.OnLongClickListener Y = new bm(this);
    private com.baidu.tieba.view.az Z = new bn(this);
    private List<com.baidu.tbadk.widget.b> aa = new ArrayList();

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
        this.x.B();
        this.x.d();
    }

    private void m() {
        this.x.C();
        this.x.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.r.b(bundle);
        if (this.r.i()) {
            this.v.b(bundle);
        }
        if (this.h != null) {
            this.h.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = 0;
        n();
        this.h = new VoiceManager();
        this.h.a((Activity) this);
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.h != null) {
            this.h.b((Activity) this);
        }
    }

    public cr b() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        this.d = true;
        super.onPause();
        ListView c2 = c();
        this.i = CompatibleUtile.getInstance().getViewLayer(c2);
        if (this.i == 1) {
            CompatibleUtile.getInstance().noneViewGpu(c2);
        }
        if (this.h != null) {
            this.h.d(this);
        }
        if (this.x != null) {
            this.x.X();
        }
        if (this.aa != null) {
            this.aa.clear();
        }
        if (!this.r.i()) {
            PbEditorCacheModel.a(this.r.b(), this.x.J(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.d = false;
        super.onResume();
        if (this.i == 1) {
            CompatibleUtile.getInstance().closeViewGpu(c());
        }
        NoNetworkView a = this.x.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.h != null) {
            this.h.c(this);
        }
        if (!this.r.i()) {
            PbEditorCacheModel.a(this.r.b(), new bq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        this.r.cancelLoadData();
        this.t.cancelLoadData();
        this.u.cancelLoadData();
        this.s.cancelLoadData();
        this.v.cancelLoadData();
        this.w.cancelLoadData();
        this.x.Y();
        super.onDestroy();
        if (this.h != null) {
            this.h.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.x.b(i);
        if (this.x.a() != null) {
            this.x.a().a(i);
        }
    }

    private void n() {
        this.x = new cr(this, this.D);
        this.x.a(new br(this));
        this.x.a(this.J);
        this.x.b(this.K);
        this.x.a(this.G);
        this.x.b(this.H);
        this.x.a(this.Q);
        this.x.a(this.R);
        this.x.a(this.S);
        this.x.a(this.P);
        this.x.h(com.baidu.tieba.d.a.a().f());
        this.x.i(com.baidu.tieba.d.a.a().d());
        this.x.a(this.W);
        this.x.a(this.Y);
        this.x.a(this.U);
        this.x.a(this.Z);
        this.x.a(this.O);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("").setCancelable(false).setPositiveButton(getString(R.string.call_phone), new bu(this)).setNeutralButton(getString(R.string.sms_phone), new bt(this)).setNegativeButton(getString(R.string.cancel), new bs(this));
        this.A = builder.create();
    }

    private void a(Bundle bundle) {
        this.r = new com.baidu.tieba.model.bm(this);
        this.r.a(this.E);
        this.s = new com.baidu.tieba.model.bg();
        this.s.a(this.F);
        this.t = new com.baidu.tieba.model.bs();
        this.t.a(this.M);
        this.u = new com.baidu.tieba.model.av();
        this.u.setLoadDataCallBack(this.T);
        this.v = new com.baidu.tieba.model.bp(this);
        this.v.a(this.L);
        this.w = new com.baidu.tieba.model.ad();
        this.w.setLoadDataCallBack(this.N);
        if (bundle != null) {
            this.r.a(bundle);
        } else {
            this.r.a(getIntent());
        }
        if (!this.r.i()) {
            this.r.o();
            this.x.o();
        } else {
            if (bundle != null) {
                this.v.a(bundle);
            } else {
                this.v.a(getIntent());
            }
            this.C = this.v.b();
            String c2 = this.v.c();
            if (c2 != null && (("mention".equals(this.v.c()) || c2.equals("person_post_reply")) && this.C != null)) {
                this.x.A();
            } else {
                this.x.u();
            }
            this.v.j();
        }
        this.x.a(new al(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ar arVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
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
        if (this.r != null && (l = this.r.l()) != null && l.c() != null) {
            str = l.c().getName();
        }
        if (com.baidu.tieba.e.a.a(str, bool)) {
            m();
        } else {
            l();
        }
    }

    public void i() {
        if (this.x.a() != null) {
            this.x.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.r.i()) {
                antiData.setBlock_forum_name(this.r.l().c().getName());
                antiData.setBlock_forum_id(this.r.l().c().getId());
                antiData.setUser_name(this.r.l().h().getName());
                antiData.setUser_id(this.r.l().h().getId());
            } else {
                antiData.setBlock_forum_name(this.v.e().h().getName());
                antiData.setBlock_forum_id(this.v.e().h().getId());
                antiData.setUser_name(TiebaApplication.G());
                antiData.setUser_id(TiebaApplication.B());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.x.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.af afVar) {
        boolean z;
        int i = 0;
        this.x.a(0, afVar.a, afVar.b, true);
        if (afVar.a) {
            if (afVar.c == 1) {
                ArrayList<com.baidu.tieba.data.ar> e2 = this.r.l().e();
                int size = e2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!afVar.d.equals(e2.get(i).d())) {
                        i++;
                    } else {
                        e2.remove(i);
                        break;
                    }
                }
                this.x.a(this.r.l());
            } else if (afVar.c == 0) {
                o();
            } else if (afVar.c == 2) {
                ArrayList<com.baidu.tieba.data.ar> e3 = this.r.l().e();
                int size2 = e3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e3.get(i2).a().size()) {
                            z = z2;
                            break;
                        } else if (!afVar.d.equals(e3.get(i2).a().get(i3).d())) {
                            i3++;
                        } else {
                            e3.get(i2).a().remove(i3);
                            e3.get(i2).c();
                            z = true;
                            break;
                        }
                    }
                    i2++;
                    z2 = z;
                }
                if (z2) {
                    this.x.a(this.r.l());
                }
                if (this.x.x()) {
                    ArrayList<com.baidu.tieba.data.ar> c2 = this.v.e().c();
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
                    this.x.a(this.v.e(), this.r.l().l());
                    if (!z2) {
                        String b = this.v.b();
                        while (i < size2) {
                            if (!b.equals(e3.get(i).d())) {
                                i++;
                            } else {
                                e3.get(i).c();
                                this.x.a(this.r.l());
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
        this.x.a(1, ahVar.a, ahVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aj ajVar) {
        this.x.a(this.w.getLoadDataMode(), ajVar.a, ajVar.b, false);
        this.x.a(ajVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aj ajVar) {
        this.x.a(this.w.getLoadDataMode(), ajVar.a, ajVar.b, true);
        if (ajVar.a) {
            this.z = true;
            if (i == 2) {
                this.r.l().d().b(1);
                this.r.a(1);
            } else if (i == 3) {
                this.r.l().d().b(0);
                this.r.a(0);
            } else if (i == 4) {
                this.r.l().d().a(1);
                this.r.b(1);
            } else if (i == 5) {
                this.r.l().d().a(0);
                this.r.b(0);
            }
            this.x.a(this.r.l(), true);
        }
    }

    private void o() {
        if (this.r.e()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.r.b());
            setResult(-1, intent);
        }
        s();
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        if (this.r.e()) {
            Intent intent = new Intent();
            if (this.z) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.r.b());
                intent.putExtra("top_data", this.r.h());
                intent.putExtra("good_data", this.r.g());
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
                if (this.x.g(this.r.i())) {
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
                    a(this.x.L());
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
                            this.x.G();
                            this.t.a(false);
                            return;
                        }
                        this.u.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    p();
                    String a = AtListActivity.a(intent);
                    if (a != null) {
                        this.x.b(a);
                        return;
                    }
                    return;
                case 12005:
                    p();
                    new Handler().postDelayed(new be(this), 200L);
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.x.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    this.t.a((WriteData) null);
                    this.t.a(false);
                    this.x.a(true);
                    if (this.x.x()) {
                        if (this.v.i()) {
                        }
                        return;
                    }
                    if (this.r.n()) {
                        this.x.o();
                    }
                    if (this.r != null && this.r.b() != null) {
                        PbEditorCacheModel.a(this.r.b(), "", null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    p();
                    if (intent != null) {
                        this.u.a(intent.getStringExtra("file_name"));
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
        if (this.y) {
            this.y = false;
            new Handler().postDelayed(new bf(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        MarkData f2 = this.r.f(this.x.H());
        if (f2 != null) {
            this.x.o();
            this.s.a(f2);
            if (!this.s.a()) {
                this.s.d();
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.s.e();
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VoiceManager.VoiceModel f2;
        if (this.t.a() == null) {
            if (!this.r.i()) {
                this.t.a(this.r.a(str));
            } else {
                this.t.a(this.v.f());
            }
        }
        if (this.t.a() != null) {
            if (str == null) {
                this.t.a().setContent(this.x.J());
                f2 = this.x.b();
                this.x.c();
            } else {
                this.t.a().setContent(this.x.K());
                f2 = this.x.f();
                this.x.g();
            }
            if (f2 != null) {
                if (f2.getId() != null) {
                    this.t.a().setVoice(f2.getId());
                    this.t.a().setVoiceDuringTime(f2.duration);
                } else {
                    this.t.a().setVoice(null);
                    this.t.a().setVoiceDuringTime(-1);
                }
            } else {
                this.t.a().setVoice(null);
                this.t.a().setVoiceDuringTime(-1);
            }
            if (this.t.b()) {
                this.x.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.baidu.tieba.data.an l = this.r.l();
        this.r.c(true);
        l.a(this.s.c());
        this.x.a(l);
    }

    private void s() {
        if (this.r != null) {
            if (this.r.t()) {
                MarkData u = this.r.u();
                if (u != null && this.r.f()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", u);
                    setResult(-1, intent);
                }
            } else if (this.r.l() != null && this.r.l().e() != null && this.r.l().e().size() > 0 && this.r.f()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView c() {
        if (this.x == null) {
            return null;
        }
        return this.x.O();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int d() {
        if (this.x == null) {
            return 0;
        }
        return this.x.P();
    }

    @Override // com.baidu.tieba.view.cd
    public int a() {
        if (this.x == null) {
            return 0;
        }
        return this.x.Q();
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.n;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.l;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> g() {
        return this.o;
    }

    @Override // com.baidu.tieba.view.cd
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.m;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, (String) null);
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void b(Context context, String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com")) {
            Matcher matcher = e.matcher(lowerCase);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    a(this, group.substring(group.lastIndexOf("/") + 1), null, null);
                    return;
                } catch (Exception e2) {
                    com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher2 = f.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    a(this, group2.substring(group2.lastIndexOf("=") + 1), null, null);
                    return;
                } catch (Exception e3) {
                    com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e3.toString());
                }
            }
            Matcher matcher3 = g.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    FrsActivity.a(this, group3.substring(group3.lastIndexOf("=") + 1), "pb");
                    return;
                } catch (Exception e4) {
                    com.baidu.tieba.util.be.b(getClass().getName(), "onClick", e4.toString());
                }
            }
        }
        UtilHelper.b(this, str);
    }

    private DialogInterface t() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.download_baidu_video_dialog));
            builder.setPositiveButton(getString(R.string.install), new bg(this));
            builder.setNegativeButton(getString(R.string.cancel), new bi(this));
            builder.setCancelable(true);
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(false);
        }
        this.j.show();
        return this.j;
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
        } catch (ActivityNotFoundException e2) {
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
        if (arVar.d() != null && arVar.d().equals(this.r.k())) {
            z = true;
        }
        MarkData b = this.r.b(arVar);
        if (b != null && a(11009)) {
            this.s.a(b);
            this.x.o();
            if (!z) {
                this.s.d();
            } else {
                this.s.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.r == null || this.r.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.an l = this.r.l();
        for (int i2 = 0; i2 < l.e().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = l.e().get(i2).h();
            ArrayList<com.baidu.tbadk.widget.richText.c> a = h.a();
            int size = a.size();
            int i3 = -1;
            int i4 = 0;
            while (i4 < size) {
                if (a.get(i4) != null && a.get(i4).a() == 8) {
                    i3++;
                    if (a.get(i4).c().f().equals(str)) {
                        int c2 = a.get(i4).c().c();
                        int b = a.get(i4).c().b();
                        if (c2 < 80 || b < 80 || b * c2 < 10000) {
                            return null;
                        }
                        this.V = i4;
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
        com.baidu.tbadk.widget.richText.f c2 = cVar.c();
        if (c2 != null) {
            if (!com.baidu.adp.lib.h.m.a(c2.a())) {
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
            sb.append(com.baidu.tieba.util.bc.d(c2.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.B = str;
            this.A.setMessage(this.B);
            this.A.show();
            com.baidu.tieba.ao.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.A.getButton(-3).setVisibility(8);
            } else {
                this.A.getButton(-3).setVisibility(0);
            }
            Button button = this.A.getButton(-3);
            if (button != null) {
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                layoutParams.width = -2;
                button.setLayoutParams(layoutParams);
            }
            Button button2 = this.A.getButton(-2);
            if (button2 != null) {
                ViewGroup.LayoutParams layoutParams2 = button2.getLayoutParams();
                layoutParams2.width = -2;
                button2.setLayoutParams(layoutParams2);
            }
            Button button3 = this.A.getButton(-1);
            if (button3 != null) {
                ViewGroup.LayoutParams layoutParams3 = button3.getLayoutParams();
                layoutParams3.width = -2;
                button3.setLayoutParams(layoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager d_() {
        return this.h;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        View af;
        View findViewWithTag;
        if (!this.x.x() || (af = this.x.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.h != null) {
            this.h.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.r.s()) {
            if (TiebaApplication.h().t()) {
                StatService.onEvent(this, "pb_share", "pbclick", 1);
            }
            com.baidu.tieba.data.an l = this.r.l();
            String name = l.c().getName();
            String c2 = l.d().c();
            String str = "http://tieba.baidu.com/p/" + this.r.b() + "?share=9105";
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
        if (this.a == null) {
            this.a = new HashMap<>(6);
            this.a.put(MediaType.WEIXIN_TIMELINE, "pb_wx_timeline");
            this.a.put(MediaType.WEIXIN_FRIEND, "pb_wx_friend");
            this.a.put(MediaType.QZONE, "pb_qq_zone");
            this.a.put(MediaType.QQWEIBO, "pb_tencent_weibo");
            this.a.put(MediaType.SINAWEIBO, "pb_sina_weibo");
            this.a.put(MediaType.RENREN, "pb_renren");
        }
        return this.a;
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
        return this.p;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.aa.remove(bVar);
        }
    }

    public void j() {
        while (this.aa.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.aa.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
