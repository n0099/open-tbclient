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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.cloudsdk.social.share.ShareContent;
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
public class NewPbActivity extends com.baidu.tieba.j implements com.baidu.tbadk.widget.a, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.view.cz, com.baidu.tieba.voice.af {
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static final Pattern e = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern f = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern g = Pattern.compile("[?|&]kw=[^&]+");
    private String D;
    private String E;
    private VoiceManager h;
    private AlertDialog k;
    private boolean d = false;
    private int i = 0;
    private com.baidu.tieba.view.dialog.d j = null;
    HashMap<MediaType, String> a = null;
    private long l = -1;
    private String m = null;
    private com.baidu.adp.lib.d.b<TextView> n = TbRichTextView.a(this, 8);
    private com.baidu.adp.lib.d.b<TbImageView> o = UserIconBox.a(this, 8);
    private com.baidu.adp.lib.d.b<ImageView> p = new com.baidu.adp.lib.d.b<>(new ak(this), 8, 0);
    private com.baidu.adp.lib.d.b<View> q = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private com.baidu.adp.lib.d.b<LinearLayout> r = new com.baidu.adp.lib.d.b<>(new bh(this), 15, 0);
    private com.baidu.adp.lib.d.b<GifView> s = new com.baidu.adp.lib.d.b<>(new br(this), 20, 0);
    private Handler t = new Handler(new bs(this));
    private com.baidu.tieba.model.bm u = null;
    private com.baidu.tieba.model.bg v = null;
    private com.baidu.tieba.model.bs w = null;
    private com.baidu.tieba.model.av x = null;
    private com.baidu.tieba.model.bp y = null;
    private com.baidu.tieba.model.ad z = null;
    private cr A = null;
    private boolean B = false;
    private boolean C = false;
    private View.OnClickListener F = new al(this);
    private com.baidu.tieba.model.bn G = new an(this);
    private com.baidu.tieba.model.bi H = new ao(this);
    private View.OnClickListener I = new ap(this);
    private View.OnClickListener J = new aq(this);
    private View.OnClickListener K = new ar(this);
    private int L = 0;
    private AbsListView.OnScrollListener M = new as(this);
    private AbsListView.OnScrollListener N = new at(this);
    private com.baidu.tieba.model.br O = new au(this);
    private com.baidu.tieba.model.bt P = new av(this);
    private com.baidu.adp.a.g Q = new ax(this);
    private by R = new ay(this);
    private com.baidu.adp.widget.ListView.b S = new az(this);
    private com.baidu.adp.widget.ListView.r T = new ba(this);
    private com.baidu.adp.widget.ListView.t U = new bb(this);
    private DialogInterface.OnClickListener V = new bc(this);
    private com.baidu.adp.a.g W = new bd(this);
    private dv X = new bj(this);
    private int Y = 0;
    private com.baidu.tbadk.widget.richText.r Z = new bk(this);
    private com.baidu.tbadk.widget.richText.q aa = new bl(this);
    private com.baidu.tbadk.imageManager.c ab = new bm(this);
    com.baidu.tieba.data.as b = null;
    private DialogInterface.OnClickListener ac = new bn(this);
    private View.OnLongClickListener ad = new bo(this);
    private com.baidu.tieba.view.br ae = new bp(this);
    private List<com.baidu.tbadk.widget.b> af = new ArrayList();

    @Override // com.baidu.tieba.j
    public boolean getGpuSwitch() {
        return TiebaApplication.h().u();
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (str != null) {
            Intent intent = new Intent(context, NewPbActivity.class);
            intent.putExtra("thread_id", str);
            intent.putExtra("post_id", str2);
            intent.putExtra("st_type", str3);
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            activity.startActivityForResult(intent, i);
        }
    }

    private void m() {
        this.A.C();
        this.A.d();
    }

    private void n() {
        this.A.D();
        this.A.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.u.b(bundle);
        if (this.u.i()) {
            this.y.b(bundle);
        }
        if (this.h != null) {
            this.h.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
        }
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

    public cr b() {
        return this.A;
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
        if (this.A != null) {
            this.A.X();
        }
        if (this.af != null) {
            this.af.clear();
        }
        if (!this.u.i()) {
            PbEditorCacheModel.a(this.u.b(), this.A.J(), null);
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
        NoNetworkView a = this.A.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.h != null) {
            this.h.c(this);
        }
        if (!this.u.i()) {
            PbEditorCacheModel.a(this.u.b(), new bt(this));
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
        this.u.cancelLoadData();
        this.w.cancelLoadData();
        this.x.cancelLoadData();
        this.v.cancelLoadData();
        this.y.cancelLoadData();
        this.z.cancelLoadData();
        this.A.Y();
        super.onDestroy();
        if (this.h != null) {
            this.h.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.A.a(i);
        if (this.A.a() != null) {
            this.A.a().a(i);
        }
    }

    private void o() {
        this.A = new cr(this, this.F);
        this.A.a(new bu(this));
        this.A.a(this.M);
        this.A.b(this.N);
        this.A.a(this.I);
        this.A.b(this.J);
        this.A.c(this.K);
        this.A.a(this.T);
        this.A.a(this.U);
        this.A.a(this.V);
        this.A.a(this.S);
        this.A.g(com.baidu.tieba.e.a.a().f());
        this.A.h(com.baidu.tieba.e.a.a().d());
        this.A.a(this.Z);
        this.A.a(this.aa);
        this.A.a(this.ad);
        this.A.a(this.X);
        this.A.a(this.ae);
        this.A.a(this.R);
        p();
    }

    private void p() {
        this.j = new com.baidu.tieba.view.dialog.d(this);
        this.j.a(new Object[]{getString(R.string.call_phone), getString(R.string.sms_phone), getString(R.string.search_in_baidu)}, new bv(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    private void a(Bundle bundle) {
        this.u = new com.baidu.tieba.model.bm(this);
        this.u.a(this.G);
        this.v = new com.baidu.tieba.model.bg();
        this.v.a(this.H);
        this.w = new com.baidu.tieba.model.bs();
        this.w.a(this.P);
        this.x = new com.baidu.tieba.model.av();
        this.x.setLoadDataCallBack(this.W);
        this.y = new com.baidu.tieba.model.bp(this);
        this.y.a(this.O);
        this.z = new com.baidu.tieba.model.ad();
        this.z.setLoadDataCallBack(this.Q);
        if (bundle != null) {
            this.u.a(bundle);
        } else {
            this.u.a(getIntent());
        }
        if (!this.u.i()) {
            this.u.o();
            this.A.p();
        } else {
            if (bundle != null) {
                this.y.a(bundle);
            } else {
                this.y.a(getIntent());
            }
            this.E = this.y.b();
            String c2 = this.y.c();
            if (c2 != null && (("mention".equals(this.y.c()) || c2.equals("person_post_reply")) && this.E != null)) {
                this.A.B();
            } else {
                this.A.v();
            }
            this.y.j();
        }
        this.A.a(new bw(this));
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
        if (this.u != null && (l = this.u.l()) != null && l.c() != null) {
            str = l.c().getName();
        }
        if (com.baidu.tieba.f.a.a(str, bool)) {
            n();
        } else {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.f.a.a(str, bool)) {
            n();
        } else {
            m();
        }
    }

    public void j() {
        if (this.A.a() != null) {
            this.A.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.u.i()) {
                antiData.setBlock_forum_name(this.u.l().c().getName());
                antiData.setBlock_forum_id(this.u.l().c().getId());
                antiData.setUser_name(this.u.l().h().getName());
                antiData.setUser_id(this.u.l().h().getId());
            } else {
                antiData.setBlock_forum_name(this.y.e().h().getName());
                antiData.setBlock_forum_id(this.y.e().h().getId());
                antiData.setUser_name(TiebaApplication.F());
                antiData.setUser_id(TiebaApplication.A());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.A.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.af afVar) {
        boolean z;
        int i = 0;
        this.A.a(0, afVar.a, afVar.b, true);
        if (afVar.a) {
            if (afVar.c == 1) {
                ArrayList<com.baidu.tieba.data.as> e2 = this.u.l().e();
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
                this.A.a(this.u.l());
            } else if (afVar.c == 0) {
                q();
            } else if (afVar.c == 2) {
                ArrayList<com.baidu.tieba.data.as> e3 = this.u.l().e();
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
                    this.A.a(this.u.l());
                }
                if (this.A.y()) {
                    ArrayList<com.baidu.tieba.data.as> c2 = this.y.e().c();
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
                    this.A.a(this.y.e(), this.u.l().l());
                    if (!z2) {
                        String b = this.y.b();
                        while (i < size2) {
                            if (!b.equals(e3.get(i).d())) {
                                i++;
                            } else {
                                e3.get(i).c();
                                this.A.a(this.u.l());
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
        this.A.a(1, ahVar.a, ahVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aj ajVar) {
        this.A.a(this.z.getLoadDataMode(), ajVar.a, ajVar.b, false);
        this.A.a(ajVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aj ajVar) {
        this.A.a(this.z.getLoadDataMode(), ajVar.a, ajVar.b, true);
        if (ajVar.a) {
            this.C = true;
            if (i == 2) {
                this.u.l().d().b(1);
                this.u.a(1);
            } else if (i == 3) {
                this.u.l().d().b(0);
                this.u.a(0);
            } else if (i == 4) {
                this.u.l().d().a(1);
                this.u.b(1);
            } else if (i == 5) {
                this.u.l().d().a(0);
                this.u.b(0);
            }
            this.A.a(this.u.l(), true);
        }
    }

    private void q() {
        if (this.u.e()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.u.b());
            setResult(-1, intent);
        }
        u();
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void closeActivity() {
        if (this.u.e()) {
            Intent intent = new Intent();
            if (this.C) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.u.b());
                intent.putExtra("top_data", this.u.h());
                intent.putExtra("good_data", this.u.g());
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
                if (this.A.f(this.u.i())) {
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
                    a(this.A.L());
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
                            this.A.G();
                            this.w.a(false);
                            return;
                        }
                        this.x.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    r();
                    String a = AtListActivity.a(intent);
                    if (a != null) {
                        this.A.b(a);
                        return;
                    }
                    return;
                case 12005:
                    r();
                    new Handler().postDelayed(new be(this), 200L);
                    String a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.A.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    this.w.a((WriteData) null);
                    this.w.a(false);
                    this.A.a(true);
                    if (this.A.y()) {
                        if (this.y.i()) {
                        }
                        return;
                    }
                    if (this.u.n()) {
                        this.A.p();
                    }
                    if (this.u != null && this.u.b() != null) {
                        PbEditorCacheModel.a(this.u.b(), "", null);
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    r();
                    if (intent != null) {
                        this.x.a(intent.getStringExtra("file_name"));
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
        if (this.B) {
            this.B = false;
            new Handler().postDelayed(new bf(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        MarkData f2 = this.u.f(this.A.H());
        if (f2 != null) {
            this.A.p();
            this.v.a(f2);
            if (!this.v.a()) {
                this.v.d();
                com.baidu.tieba.util.by.a(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.v.e();
            com.baidu.tieba.util.by.a(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VoiceManager.VoiceModel f2;
        if (this.w.a() == null) {
            if (!this.u.i()) {
                this.w.a(this.u.a(str));
            } else {
                this.w.a(this.y.f());
            }
        }
        if (this.w.a() != null) {
            if (str == null) {
                this.w.a().setContent(this.A.J());
                f2 = this.A.b();
                this.A.c();
            } else {
                this.w.a().setContent(this.A.K());
                f2 = this.A.f();
                this.A.g();
            }
            if (f2 != null) {
                if (f2.getId() != null) {
                    this.w.a().setVoice(f2.getId());
                    this.w.a().setVoiceDuringTime(f2.duration);
                } else {
                    this.w.a().setVoice(null);
                    this.w.a().setVoiceDuringTime(-1);
                }
            } else {
                this.w.a().setVoice(null);
                this.w.a().setVoiceDuringTime(-1);
            }
            if (this.w.b()) {
                this.A.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        com.baidu.tieba.data.ao l = this.u.l();
        this.u.c(true);
        l.a(this.v.c());
        this.A.a(l);
    }

    private void u() {
        if (this.u != null) {
            if (this.u.t()) {
                MarkData u = this.u.u();
                if (u != null && this.u.f()) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", u);
                    setResult(-1, intent);
                }
            } else if (this.u.l() != null && this.u.l().e() != null && this.u.l().e().size() > 0 && this.u.f()) {
                setResult(1);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView c() {
        if (this.A == null) {
            return null;
        }
        return this.A.O();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int d() {
        if (this.A == null) {
            return 0;
        }
        return this.A.P();
    }

    @Override // com.baidu.tieba.view.cz
    public int a() {
        if (this.A == null) {
            return 0;
        }
        return this.A.Q();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.p;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.n;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> g() {
        return this.s;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> h() {
        return this.q;
    }

    @Override // com.baidu.tieba.view.cz
    public com.baidu.adp.lib.d.b<TbImageView> G() {
        return this.o;
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
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher2 = f.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    a(this, group2.substring(group2.lastIndexOf("=") + 1), (String) null, (String) null);
                    return;
                } catch (Exception e3) {
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "onClick", e3.toString());
                }
            }
            Matcher matcher3 = g.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    FrsActivity.a(this, group3.substring(group3.lastIndexOf("=") + 1), "pb");
                    return;
                } catch (Exception e4) {
                    com.baidu.adp.lib.g.e.b(getClass().getName(), "onClick", e4.toString());
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
        com.baidu.tieba.util.by.a(this, "pb_video", "pbclick", 1, new Object[0]);
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
        com.baidu.tieba.util.by.a(this, "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        GifView gifView = (GifView) this.A.O().findViewWithTag(str);
        if (gifView != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (dVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.g.e.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        GifView gifView;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        View af = this.A.af();
        if (af != null && (gifView = (GifView) af.findViewWithTag(str)) != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (dVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(dVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.g.e.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.as asVar) {
        boolean z = false;
        if (asVar.d() != null && asVar.d().equals(this.u.k())) {
            z = true;
        }
        MarkData b = this.u.b(asVar);
        if (b != null && a(11009)) {
            this.v.a(b);
            this.A.p();
            if (!z) {
                this.v.d();
            } else {
                this.v.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.u == null || this.u.l() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ao l = this.u.l();
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
                        this.Y = i4;
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
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.g c2 = cVar.c();
        if (c2 != null) {
            if (!com.baidu.adp.lib.g.m.a(c2.a())) {
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
            sb.append(com.baidu.tieba.util.bu.d(c2.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.D = str;
            com.baidu.tieba.as.a(this, "pb_show_phonedialog");
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
        if (!this.A.y() || (af = this.A.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
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
        if (this.u.s()) {
            com.baidu.tieba.util.by.a(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ao l = this.u.l();
            String name = l.c().getName();
            String c2 = l.d().c();
            String str = "http://tieba.baidu.com/p/" + this.u.b() + "?share=9105";
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
        if (TiebaApplication.h().al() == 1) {
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
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.af.remove(bVar);
        }
    }

    public void k() {
        while (this.af.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.af.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
