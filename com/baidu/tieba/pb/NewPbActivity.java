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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.mobstat.StatService;
import com.baidu.tbadk.gif.GifView;
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
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.a, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.view.cj, com.baidu.tieba.voice.af {
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static final Pattern e = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern f = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern g = Pattern.compile("[?|&]kw=[^&]+");
    private String C;
    private String D;
    private VoiceManager h;
    private AlertDialog k;
    private boolean d = false;
    private int i = 0;
    private com.baidu.tieba.view.dialog.a j = null;
    HashMap<MediaType, String> a = null;
    private String l = null;
    private com.baidu.adp.lib.d.b<TextView> m = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<TbImageView> n = UserIconBox.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> o = new com.baidu.adp.lib.d.b<>(new ak(this), 8, 0);
    private com.baidu.adp.lib.d.b<View> p = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private com.baidu.adp.lib.d.b<LinearLayout> q = new com.baidu.adp.lib.d.b<>(new bh(this), 15, 0);
    private com.baidu.adp.lib.d.b<GifView> r = new com.baidu.adp.lib.d.b<>(new br(this), 20, 0);
    private Handler s = new Handler(new bs(this));
    private com.baidu.tieba.model.bm t = null;
    private com.baidu.tieba.model.bg u = null;
    private com.baidu.tieba.model.bs v = null;
    private com.baidu.tieba.model.av w = null;
    private com.baidu.tieba.model.bp x = null;
    private com.baidu.tieba.model.ad y = null;
    private cs z = null;
    private boolean A = false;
    private boolean B = false;
    private View.OnClickListener E = new al(this);
    private com.baidu.tieba.model.bn F = new an(this);
    private com.baidu.tieba.model.bi G = new ao(this);
    private View.OnClickListener H = new ap(this);
    private View.OnClickListener I = new aq(this);
    private View.OnClickListener J = new ar(this);
    private int K = 0;
    private AbsListView.OnScrollListener L = new as(this);
    private AbsListView.OnScrollListener M = new at(this);
    private com.baidu.tieba.model.br N = new au(this);
    private com.baidu.tieba.model.bt O = new av(this);
    private com.baidu.adp.a.g P = new ax(this);
    private by Q = new ay(this);
    private com.baidu.adp.widget.ListView.b R = new az(this);
    private com.baidu.adp.widget.ListView.r S = new ba(this);
    private com.baidu.adp.widget.ListView.t T = new bb(this);
    private DialogInterface.OnClickListener U = new bc(this);
    private com.baidu.adp.a.g V = new bd(this);
    private dx W = new bj(this);
    private int X = 0;
    private com.baidu.tbadk.widget.richText.r Y = new bk(this);
    private com.baidu.tbadk.widget.richText.q Z = new bl(this);
    private com.baidu.tbadk.imageManager.c aa = new bm(this);
    com.baidu.tieba.data.as b = null;
    private DialogInterface.OnClickListener ab = new bn(this);
    private View.OnLongClickListener ac = new bo(this);
    private com.baidu.tieba.view.bf ad = new bp(this);
    private List<com.baidu.tbadk.widget.b> ae = new ArrayList();

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
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

    public static void a(Activity activity, com.baidu.tieba.data.bb bbVar, String str, String str2, int i, boolean z, boolean z2, boolean z3) {
        if (bbVar != null) {
            Intent intent = new Intent(activity, NewPbActivity.class);
            intent.putExtra("thread_id", bbVar.a());
            intent.putExtra("is_good", bbVar.g());
            intent.putExtra("is_top", bbVar.f());
            intent.putExtra("thread_time", bbVar.e());
            intent.putExtra("st_type", str2);
            intent.putExtra("from_frs", true);
            intent.putExtra("squence", z);
            intent.putExtra("host_only", z2);
            intent.putExtra("is_ad", z3);
            intent.putExtra("forum_name", str);
            activity.startActivityForResult(intent, i);
        }
    }

    private void m() {
        this.z.C();
        this.z.d();
    }

    private void n() {
        this.z.D();
        this.z.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.t.b(bundle);
        if (this.t.i()) {
            this.x.b(bundle);
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
        o();
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

    public cs b() {
        return this.z;
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
        if (this.z != null) {
            this.z.X();
        }
        if (this.ae != null) {
            this.ae.clear();
        }
        if (!this.t.i()) {
            PbEditorCacheModel.a(this.t.b(), this.z.J(), null);
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
        NoNetworkView a = this.z.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.h != null) {
            this.h.c(this);
        }
        if (!this.t.i()) {
            PbEditorCacheModel.a(this.t.b(), new bt(this));
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
        this.t.cancelLoadData();
        this.v.cancelLoadData();
        this.w.cancelLoadData();
        this.u.cancelLoadData();
        this.x.cancelLoadData();
        this.y.cancelLoadData();
        this.z.Y();
        super.onDestroy();
        if (this.h != null) {
            this.h.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.z.a(i);
        if (this.z.a() != null) {
            this.z.a().a(i);
        }
    }

    private void o() {
        this.z = new cs(this, this.E);
        this.z.a(new bu(this));
        this.z.a(this.L);
        this.z.b(this.M);
        this.z.a(this.H);
        this.z.b(this.I);
        this.z.c(this.J);
        this.z.a(this.S);
        this.z.a(this.T);
        this.z.a(this.U);
        this.z.a(this.R);
        this.z.g(com.baidu.tieba.e.a.a().f());
        this.z.h(com.baidu.tieba.e.a.a().d());
        this.z.a(this.Y);
        this.z.a(this.Z);
        this.z.a(this.ac);
        this.z.a(this.W);
        this.z.a(this.ad);
        this.z.a(this.Q);
        p();
    }

    private void p() {
        this.j = new com.baidu.tieba.view.dialog.a(this);
        this.j.a(new Object[]{getString(R.string.call_phone), getString(R.string.sms_phone), getString(R.string.search_in_baidu)}, new bv(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    private void a(Bundle bundle) {
        this.t = new com.baidu.tieba.model.bm(this);
        this.t.a(this.F);
        this.u = new com.baidu.tieba.model.bg();
        this.u.a(this.G);
        this.v = new com.baidu.tieba.model.bs();
        this.v.a(this.O);
        this.w = new com.baidu.tieba.model.av();
        this.w.setLoadDataCallBack(this.V);
        this.x = new com.baidu.tieba.model.bp(this);
        this.x.a(this.N);
        this.y = new com.baidu.tieba.model.ad();
        this.y.setLoadDataCallBack(this.P);
        if (bundle != null) {
            this.t.a(bundle);
        } else {
            this.t.a(getIntent());
        }
        if (!this.t.i()) {
            this.t.o();
            this.z.p();
        } else {
            if (bundle != null) {
                this.x.a(bundle);
            } else {
                this.x.a(getIntent());
            }
            this.D = this.x.b();
            String c2 = this.x.c();
            if (c2 != null && (("mention".equals(this.x.c()) || c2.equals("person_post_reply")) && this.D != null)) {
                this.z.B();
            } else {
                this.z.v();
            }
            this.x.j();
        }
        this.z.a(new bw(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.as asVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (asVar = (com.baidu.tieba.data.as) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(asVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.ao l;
        String str = null;
        if (this.t != null && (l = this.t.l()) != null && l.c() != null) {
            str = l.c().getName();
        }
        if (com.baidu.tieba.f.a.a(str, bool)) {
            n();
        } else {
            m();
        }
    }

    public void j() {
        if (this.z.a() != null) {
            this.z.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.t.i()) {
                antiData.setBlock_forum_name(this.t.l().c().getName());
                antiData.setBlock_forum_id(this.t.l().c().getId());
                antiData.setUser_name(this.t.l().h().getName());
                antiData.setUser_id(this.t.l().h().getId());
            } else {
                antiData.setBlock_forum_name(this.x.e().h().getName());
                antiData.setBlock_forum_id(this.x.e().h().getId());
                antiData.setUser_name(TiebaApplication.G());
                antiData.setUser_id(TiebaApplication.A());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.z.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.af afVar) {
        boolean z;
        int i = 0;
        this.z.a(0, afVar.a, afVar.b, true);
        if (afVar.a) {
            if (afVar.c == 1) {
                ArrayList<com.baidu.tieba.data.as> e2 = this.t.l().e();
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
                this.z.a(this.t.l());
            } else if (afVar.c == 0) {
                q();
            } else if (afVar.c == 2) {
                ArrayList<com.baidu.tieba.data.as> e3 = this.t.l().e();
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
                    this.z.a(this.t.l());
                }
                if (this.z.y()) {
                    ArrayList<com.baidu.tieba.data.as> c2 = this.x.e().c();
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
                    this.z.a(this.x.e(), this.t.l().l());
                    if (!z2) {
                        String b = this.x.b();
                        while (i < size2) {
                            if (!b.equals(e3.get(i).d())) {
                                i++;
                            } else {
                                e3.get(i).c();
                                this.z.a(this.t.l());
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
        this.z.a(1, ahVar.a, ahVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aj ajVar) {
        this.z.a(this.y.getLoadDataMode(), ajVar.a, ajVar.b, false);
        this.z.a(ajVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aj ajVar) {
        this.z.a(this.y.getLoadDataMode(), ajVar.a, ajVar.b, true);
        if (ajVar.a) {
            this.B = true;
            if (i == 2) {
                this.t.l().d().b(1);
                this.t.a(1);
            } else if (i == 3) {
                this.t.l().d().b(0);
                this.t.a(0);
            } else if (i == 4) {
                this.t.l().d().a(1);
                this.t.b(1);
            } else if (i == 5) {
                this.t.l().d().a(0);
                this.t.b(0);
            }
            this.z.a(this.t.l(), true);
        }
    }

    private void q() {
        if (this.t.e()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.t.b());
            setResult(-1, intent);
        }
        u();
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        if (this.t.e()) {
            Intent intent = new Intent();
            if (this.B) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.t.b());
                intent.putExtra("top_data", this.t.h());
                intent.putExtra("good_data", this.t.g());
            }
            setResult(-1, intent);
        }
        u();
        super.closeActivity();
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.z.f(this.t.i())) {
                    w();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
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
                    s();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005);
                    return;
                case 11027:
                    a(this.z.L());
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
                            this.z.G();
                            this.v.a(false);
                            return;
                        }
                        this.w.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    r();
                    String a = AtListActivity.a(intent);
                    if (a != null) {
                        this.z.b(a);
                        return;
                    }
                    return;
                case 12005:
                    r();
                    new Handler().postDelayed(new be(this), 200L);
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.z.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    this.v.a((WriteData) null);
                    this.v.a(false);
                    this.z.a(true);
                    if (this.z.y()) {
                        if (this.x.i()) {
                        }
                        return;
                    }
                    if (this.t.n()) {
                        this.z.p();
                    }
                    if (this.t != null && this.t.b() != null) {
                        PbEditorCacheModel.a(this.t.b(), "", null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    r();
                    if (intent != null) {
                        this.w.a(intent.getStringExtra("file_name"));
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
        if (this.A) {
            this.A = false;
            new Handler().postDelayed(new bf(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        MarkData f2 = this.t.f(this.z.H());
        if (f2 != null) {
            this.z.p();
            this.u.a(f2);
            if (!this.u.a()) {
                this.u.d();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this, "pb_collect", "pbclick", 1);
                    return;
                }
                return;
            }
            this.u.e();
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "pb_cancel_collect", "pbclick", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VoiceManager.VoiceModel f2;
        if (this.v.a() == null) {
            if (!this.t.i()) {
                this.v.a(this.t.a(str));
            } else {
                this.v.a(this.x.f());
            }
        }
        if (this.v.a() != null) {
            if (str == null) {
                this.v.a().setContent(this.z.J());
                f2 = this.z.b();
                this.z.c();
            } else {
                this.v.a().setContent(this.z.K());
                f2 = this.z.f();
                this.z.g();
            }
            if (f2 != null) {
                if (f2.getId() != null) {
                    this.v.a().setVoice(f2.getId());
                    this.v.a().setVoiceDuringTime(f2.duration);
                } else {
                    this.v.a().setVoice(null);
                    this.v.a().setVoiceDuringTime(-1);
                }
            } else {
                this.v.a().setVoice(null);
                this.v.a().setVoiceDuringTime(-1);
            }
            if (this.v.b()) {
                this.z.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.baidu.tieba.data.ao l = this.t.l();
        this.t.c(true);
        l.a(this.u.c());
        this.z.a(l);
    }

    private void u() {
        if (this.t != null) {
            if (this.t.t()) {
                MarkData u = this.t.u();
                if (u != null && this.t.f()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", u);
                    setResult(-1, intent);
                }
            } else if (this.t.l() != null && this.t.l().e() != null && this.t.l().e().size() > 0 && this.t.f()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView c() {
        if (this.z == null) {
            return null;
        }
        return this.z.O();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int d() {
        if (this.z == null) {
            return 0;
        }
        return this.z.P();
    }

    @Override // com.baidu.tieba.view.cj
    public int a() {
        if (this.z == null) {
            return 0;
        }
        return this.z.Q();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.o;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.m;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> g() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> h() {
        return this.p;
    }

    @Override // com.baidu.tieba.view.cj
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.n;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
        PersonInfoActivity.a(this, str, (String) null);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com")) {
            Matcher matcher = e.matcher(lowerCase);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    a(this, group.substring(group.lastIndexOf("/") + 1), (String) null, (String) null);
                    return;
                } catch (Exception e2) {
                    com.baidu.tieba.util.bo.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher2 = f.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    a(this, group2.substring(group2.lastIndexOf("=") + 1), (String) null, (String) null);
                    return;
                } catch (Exception e3) {
                    com.baidu.tieba.util.bo.b(getClass().getName(), "onClick", e3.toString());
                }
            }
            Matcher matcher3 = g.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    FrsActivity.a(this, group3.substring(group3.lastIndexOf("=") + 1), "pb");
                    return;
                } catch (Exception e4) {
                    com.baidu.tieba.util.bo.b(getClass().getName(), "onClick", e4.toString());
                }
            }
        }
        UtilHelper.c(this, str);
    }

    private DialogInterface v() {
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

    @Override // com.baidu.tbadk.widget.richText.j
    public void c(Context context, String str) {
        UtilHelper.c(this, str);
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "pb_video", "pbclick", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void e(Context context, String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            v();
        }
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "baidu_video", "click", 1);
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        GifView gifView = (GifView) this.z.O().findViewWithTag(str);
        if (gifView != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (dVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.h.e.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        GifView gifView;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        View af = this.z.af();
        if (af != null && (gifView = (GifView) af.findViewWithTag(str)) != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (dVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.h.e.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.as asVar) {
        boolean z = false;
        if (asVar.d() != null && asVar.d().equals(this.t.k())) {
            z = true;
        }
        MarkData b = this.t.b(asVar);
        if (b != null && a(11009)) {
            this.u.a(b);
            this.z.p();
            if (!z) {
                this.u.d();
            } else {
                this.u.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.t == null || this.t.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ao l = this.t.l();
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
                        this.X = i4;
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
        com.baidu.tbadk.widget.richText.g c2 = cVar.c();
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
            sb.append(com.baidu.tieba.util.bm.d(c2.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.C = str;
            com.baidu.tieba.ap.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.j.c(1).setVisibility(8);
            } else {
                this.j.c(1).setVisibility(0);
            }
            this.j.b();
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
        if (!this.z.y() || (af = this.z.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.h != null) {
            this.h.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.t.s()) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "pb_share", "pbclick", 1);
            }
            com.baidu.tieba.data.ao l = this.t.l();
            String name = l.c().getName();
            String c2 = l.d().c();
            String str = "http://tieba.baidu.com/p/" + this.t.b() + "?share=9105";
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
            bVar.a(y());
            bVar.a(z(), new bq(this, str));
            bVar.a();
        }
    }

    private HashMap<MediaType, String> y() {
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

    private View z() {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.btn_copy_pb_url, (ViewGroup) null);
        if (TiebaApplication.g().an() == 1) {
            textView.setBackgroundResource(R.drawable.btn_blue_square_1);
            textView.setTextColor(getResources().getColor(R.color.share_copy_pb_url_1));
        } else {
            textView.setBackgroundResource(R.drawable.btn_blue_square);
            textView.setTextColor(getResources().getColor(R.color.share_copy_pb_url));
        }
        return textView;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> i() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.ae.remove(bVar);
        }
    }

    public void k() {
        while (this.ae.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.ae.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
