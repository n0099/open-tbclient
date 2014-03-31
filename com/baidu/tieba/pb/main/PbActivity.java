package com.baidu.tieba.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class PbActivity extends com.baidu.tbadk.a implements View.OnTouchListener, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.z, com.baidu.tbadk.widget.j, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.n {
    private static final String d = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/135_1";
    private static final Pattern f = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern g = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern h = Pattern.compile("[?|&]kw=[^&]+");
    private String I;
    private String J;
    private AlertDialog af;
    private VoiceManager i;
    private AlertDialog l;
    private String o;
    private boolean e = false;
    private int j = 0;
    private com.baidu.tbadk.core.dialog.d k = null;
    SparseArray<String> a = null;
    private long m = -1;
    private WriteImagesInfo n = new WriteImagesInfo();
    private String p = null;
    private final com.baidu.adp.lib.d.b<TextView> q = TbRichTextView.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> r = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<ImageView> s = new com.baidu.adp.lib.d.b<>(new c(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> t = new com.baidu.adp.lib.d.b<>(new n(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> u = new com.baidu.adp.lib.d.b<>(new y(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> v = new com.baidu.adp.lib.d.b<>(new aj(this), 20, 0);
    private final Handler w = new Handler(new aq(this));
    private bd x = null;
    private com.baidu.tieba.model.ai y = null;
    private com.baidu.tieba.model.ar z = null;
    private com.baidu.tieba.model.ac A = null;
    private com.baidu.tieba.pb.sub.f B = null;
    private com.baidu.tieba.model.v C = null;
    private bk D = null;
    private boolean E = false;
    private boolean F = false;
    private com.baidu.tbadk.core.view.i G = null;
    private bj H = null;
    private boolean K = false;
    private dc L = new dc(new as(this));
    private long M = 0;
    private final View.OnClickListener N = new at(this);
    private final be O = new av(this);
    private final com.baidu.tieba.model.ak P = new d(this);
    private final View.OnClickListener Q = new e(this);
    private final View.OnClickListener R = new f(this);
    private final View.OnClickListener S = new g(this);
    private int T = 0;
    private final AbsListView.OnScrollListener U = new h(this);
    private final AbsListView.OnScrollListener V = new i(this);
    private final com.baidu.tieba.pb.sub.h W = new j(this);
    private final com.baidu.tieba.model.as X = new k(this);
    private final com.baidu.adp.a.h Y = new l(this);
    private final ax Z = new m(this);
    private final com.baidu.adp.widget.ListView.d aa = new o(this);
    private final com.baidu.adp.widget.ListView.t ab = new p(this);
    private final com.baidu.adp.widget.ListView.v ac = new q(this);
    private final DialogInterface.OnClickListener ad = new r(this);
    private final com.baidu.adp.a.h ae = new s(this);
    private final cr ag = new t(this);
    private int ah = 0;
    private final com.baidu.tbadk.widget.richText.r ai = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.q aj = new v(this);
    private final com.baidu.tbadk.imageManager.d ak = new w(this);
    com.baidu.tieba.data.ai c = null;
    private final DialogInterface.OnClickListener al = new x(this);
    private final View.OnLongClickListener am = new z(this);
    private final com.baidu.tbadk.core.view.m an = new aa(this);
    private final List<com.baidu.tbadk.widget.k> ao = new ArrayList();

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new ar());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        com.baidu.tbadk.core.util.bg.a().a(new ab());
    }

    @Override // com.baidu.tbadk.a
    public boolean getGpuSwitch() {
        return TbadkApplication.j().ax();
    }

    private void p() {
        this.D.H();
        this.D.f();
    }

    private void q() {
        this.D.I();
        this.D.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(PbActivity pbActivity) {
        if (pbActivity.K) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - pbActivity.M > 1000) {
            pbActivity.M = currentTimeMillis;
            pbActivity.K = true;
            com.baidu.tieba.data.ae p = pbActivity.x.p();
            dc dcVar = pbActivity.L;
            dc.a(p.d().C(), p.d().l(), p.d().k().getIsLike(), "pb");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, int i) {
        com.baidu.tbadk.core.data.o d2 = pbActivity.x.p().d();
        if (i == 1) {
            PraiseData k = d2.k();
            AccountData N = TbadkApplication.N();
            if (N != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(N.getAccount());
                metaData.setPortrait(N.getPortrait());
                metaData.setUserId(N.getID());
                if (k == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    d2.a(praiseData);
                } else {
                    d2.k().getUser().add(0, metaData);
                    d2.k().setNum(d2.k().getNum() + 1);
                    d2.k().setIsLike(i);
                }
            }
            pbActivity.D.a(d2.k().getNum() < 1 ? pbActivity.getResources().getString(com.baidu.tieba.a.k.frs_item_praise_text) : new StringBuilder(String.valueOf(d2.k().getNum())).toString(), true);
        } else {
            d2.k().setIsLike(i);
            d2.k().setNum(d2.k().getNum() - 1);
            ArrayList<MetaData> user = d2.k().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.N().getID())) {
                        d2.k().getUser().remove(next);
                        break;
                    }
                }
            }
            pbActivity.D.a(d2.k().getNum() < 1 ? pbActivity.getResources().getString(com.baidu.tieba.a.k.frs_item_praise_text) : new StringBuilder(String.valueOf(d2.k().getNum())).toString(), false);
        }
        if (pbActivity.x.h()) {
            pbActivity.D.l().notifyDataSetChanged();
        } else {
            pbActivity.D.b(pbActivity.x.p());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.x.b(bundle);
        if (this.x.m()) {
            this.B.b(bundle);
        }
        if (this.i != null) {
            VoiceManager voiceManager = this.i;
            VoiceManager.i();
        }
        bundle.putSerializable("write_images", this.n);
        bundle.putString("photo_name", this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        bh bhVar;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.m = System.currentTimeMillis();
        }
        this.j = 0;
        this.D = new bk(this, this.N);
        this.H = new bj(this, this.N);
        this.G = new com.baidu.tbadk.core.view.i(this, this.H.d(), getResources().getDrawable(com.baidu.tieba.a.g.bg_collect), null);
        this.D.a(new ac(this));
        this.D.a(this.U);
        this.D.b(this.V);
        this.D.a(this.Q);
        this.D.b(this.R);
        this.D.c(this.S);
        this.D.a(this.ab);
        this.D.a(this.ac);
        this.D.a(this.ad);
        this.D.a(this.aa);
        this.D.g(com.baidu.tbadk.core.h.a().f());
        this.D.h(com.baidu.tbadk.core.h.a().d());
        this.D.a(this.ai);
        this.D.a(this.aj);
        this.D.a(this.am);
        this.D.a(this.ag);
        this.D.a(this.an);
        this.D.a(this.Z);
        this.k = new com.baidu.tbadk.core.dialog.d(this);
        this.k.a(new Object[]{getString(com.baidu.tieba.a.k.call_phone), getString(com.baidu.tieba.a.k.sms_phone), getString(com.baidu.tieba.a.k.search_in_baidu)}, new ad(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
        String[] strArr = {getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new ai(this));
        if (this.af == null) {
            this.af = builder.create();
            this.af.setCanceledOnTouchOutside(true);
        }
        this.i = new VoiceManager();
        this.i.a((Activity) this);
        this.x = new bd(this);
        this.x.a(this.O);
        this.y = new com.baidu.tieba.model.ai();
        this.y.a(this.P);
        this.z = new com.baidu.tieba.model.ar();
        this.z.a(this.X);
        this.A = new com.baidu.tieba.model.ac();
        this.A.setLoadDataCallBack(this.ae);
        this.B = new com.baidu.tieba.pb.sub.f(this);
        this.B.a(this.W);
        this.C = new com.baidu.tieba.model.v();
        this.C.setLoadDataCallBack(this.Y);
        if (bundle != null) {
            this.x.a(bundle);
        } else {
            this.x.a(getIntent());
        }
        bhVar = bi.a;
        bhVar.a(this.x.e(), this.x.j());
        if (this.x.m()) {
            if (bundle != null) {
                this.B.a(bundle);
            } else {
                this.B.a(getIntent());
            }
            this.J = this.B.b();
            String c = this.B.c();
            if (c == null || (!("mention".equals(this.B.c()) || c.equals("person_post_reply")) || this.J == null)) {
                this.D.A();
            } else {
                this.D.G();
            }
            this.B.j();
        } else {
            this.x.s();
            this.D.t();
        }
        this.D.a(new ae(this));
        if (bundle != null) {
            this.n = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.o = bundle.getString("photo_name");
        }
        this.n.setMaxImagesAllowed(10);
        if (!this.x.m()) {
            com.baidu.tieba.util.m.a(this.x.f(), this);
        }
        this.L.setUniqueId(getUniqueId());
        this.L.a();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.i != null) {
            VoiceManager voiceManager = this.i;
            VoiceManager.g();
        }
    }

    public final bk k() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        this.e = true;
        super.onPause();
        ListView a = a();
        this.j = CompatibleUtile.getInstance().getViewLayer(a);
        if (this.j == 1) {
            CompatibleUtile.getInstance().noneViewGpu(a);
        }
        if (this.i != null) {
            this.i.c(this);
        }
        if (this.D != null) {
            this.D.Z();
        }
        if (this.ao != null) {
            this.ao.clear();
        }
        if (!this.x.m()) {
            WriteData a2 = this.z.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.x.f());
                a2.setWriteImagesInfo(this.n);
            }
            a2.setContent(this.D.M());
            com.baidu.tieba.util.m.b(this.x.f(), a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.e = false;
        super.onResume();
        if (this.j == 1) {
            CompatibleUtile.getInstance().closeViewGpu(a());
        }
        NoNetworkView a = this.D.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.i != null) {
            this.i.b(this);
        }
        this.D.j.s();
        this.D.ah();
    }

    @Override // com.baidu.tieba.util.n
    public final void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bc.c(writeData.getContent()) && com.baidu.tbadk.core.util.bc.c(this.D.M())) {
                this.D.a(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.n.size() == 0) {
                this.n.copyFrom(writeData.getWriteImagesInfo());
                this.D.a(this.n, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.i != null) {
            this.i.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.x.cancelLoadData();
        this.z.cancelLoadData();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.C.cancelLoadData();
        this.D.aa();
        super.onDestroy();
        if (this.i != null) {
            this.i.d(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.D.a(i);
        this.G.a(this, i, getResources().getDrawable(com.baidu.tieba.a.g.bg_collect), getResources().getDrawable(com.baidu.tieba.a.g.bg_collect_1));
        if (this.D.a() != null) {
            this.D.a().a(i);
        }
    }

    public final void l() {
        this.D.a(this.x.h(), this.y.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ai aiVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null || (aiVar = (com.baidu.tieba.data.ai) sparseArray.get(com.baidu.tieba.a.h.tag_clip_board)) == null) {
            return;
        }
        pbActivity.a(aiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, Boolean bool) {
        com.baidu.tieba.data.ae p;
        String str = null;
        if (pbActivity.x != null && (p = pbActivity.x.p()) != null && p.c() != null) {
            str = p.c().getName();
        }
        if (com.baidu.tieba.d.a.a(str, bool)) {
            pbActivity.q();
        } else {
            pbActivity.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, String str, Boolean bool) {
        if (com.baidu.tieba.d.a.a(str, bool)) {
            pbActivity.q();
        } else {
            pbActivity.p();
        }
    }

    public final void m() {
        if (this.D.a() != null) {
            this.D.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, AntiData antiData, String str) {
        if (!AntiHelper.a(antiData) && !AntiHelper.b(antiData) && !AntiHelper.c(antiData) && !AntiHelper.d(antiData)) {
            pbActivity.D.b(str);
            return;
        }
        if (pbActivity.x.m()) {
            antiData.setBlock_forum_name(pbActivity.B.e().g().getName());
            antiData.setBlock_forum_id(pbActivity.B.e().g().getId());
            antiData.setUser_name(TbadkApplication.O());
            antiData.setUser_id(TbadkApplication.E());
        } else {
            antiData.setBlock_forum_name(pbActivity.x.p().c().getName());
            antiData.setBlock_forum_id(pbActivity.x.p().c().getId());
            antiData.setUser_name(pbActivity.x.p().h().getUserName());
            antiData.setUser_id(pbActivity.x.p().h().getUserId());
        }
        AntiHelper.a(pbActivity, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, com.baidu.tieba.model.x xVar) {
        int i = 0;
        pbActivity.D.a(xVar.a, xVar.b, true);
        if (xVar.a) {
            if (xVar.c == 1) {
                ArrayList<com.baidu.tieba.data.ai> e = pbActivity.x.p().e();
                int size = e.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (xVar.d.equals(e.get(i).d())) {
                        e.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
                pbActivity.D.a(pbActivity.x.p());
            } else if (xVar.c == 0) {
                if (pbActivity.x.i()) {
                    Intent intent = new Intent();
                    intent.putExtra("type", 0);
                    intent.putExtra("tid", pbActivity.x.f());
                    pbActivity.setResult(-1, intent);
                }
                if (pbActivity.u()) {
                    super.closeActivity();
                }
            } else if (xVar.c == 2) {
                ArrayList<com.baidu.tieba.data.ai> e2 = pbActivity.x.p().e();
                int size2 = e2.size();
                boolean z = false;
                for (int i2 = 0; i2 < size2 && !z; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e2.get(i2).a().size()) {
                            break;
                        } else if (xVar.d.equals(e2.get(i2).a().get(i3).d())) {
                            e2.get(i2).a().remove(i3);
                            e2.get(i2).b();
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    AdditionData n = pbActivity.x.p().n();
                    com.baidu.tieba.data.ai aiVar = e2.get(i2);
                    ArrayList<com.baidu.tieba.data.ai> c = aiVar.c();
                    int size3 = c.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size3) {
                            if (xVar.d.equals(e2.get(i2).c().get(i4).d())) {
                                c.remove(i4);
                                n.decreaseAlreadyCount();
                                if (aiVar.n() > c.size()) {
                                    aiVar.c(c.size());
                                }
                                if (c.size() > 0) {
                                    com.baidu.tieba.data.ai aiVar2 = c.get(c.size() - 1);
                                    n.setLastAdditionTime(aiVar2.f() / 1000);
                                    com.baidu.tbadk.widget.richText.a h2 = aiVar2.h();
                                    n.setLastAdditionContent(h2 != null ? h2.toString() : "");
                                }
                                pbActivity.w();
                                z = true;
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                if (z) {
                    pbActivity.D.a(pbActivity.x.p());
                }
                if (pbActivity.D.D()) {
                    ArrayList<com.baidu.tieba.data.ai> c2 = pbActivity.B.e().c();
                    int size4 = c2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size4) {
                            break;
                        } else if (xVar.d.equals(c2.get(i5).d())) {
                            c2.remove(i5);
                            break;
                        } else {
                            i5++;
                        }
                    }
                    pbActivity.D.a(pbActivity.B.e(), pbActivity.x.p().l());
                    if (z) {
                        return;
                    }
                    String b = pbActivity.B.b();
                    while (i < size2) {
                        if (b.equals(e2.get(i).d())) {
                            e2.get(i).b();
                            pbActivity.D.a(pbActivity.x.p());
                            return;
                        }
                        i++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, com.baidu.tieba.model.ab abVar) {
        bk bkVar = pbActivity.D;
        pbActivity.C.getLoadDataMode();
        bkVar.a(abVar.a, abVar.b, false);
        pbActivity.D.a(abVar.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, int i, com.baidu.tieba.model.ab abVar) {
        bk bkVar = pbActivity.D;
        pbActivity.C.getLoadDataMode();
        bkVar.a(abVar.a, abVar.b, true);
        if (abVar.a) {
            pbActivity.F = true;
            if (i == 2) {
                pbActivity.x.p().d().d(1);
                pbActivity.x.a(1);
            } else if (i == 3) {
                pbActivity.x.p().d().d(0);
                pbActivity.x.a(0);
            } else if (i == 4) {
                pbActivity.x.p().d().c(1);
                pbActivity.x.b(1);
            } else if (i == 5) {
                pbActivity.x.p().d().c(0);
                pbActivity.x.b(0);
            }
            pbActivity.D.a(pbActivity.x.p(), pbActivity.x.h(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void closeActivity() {
        bh bhVar;
        bh bhVar2;
        if (this.L != null) {
            this.L.setLoadDataCallBack(null);
            this.L = null;
        }
        if (this.x != null && this.x.i()) {
            Intent intent = new Intent();
            if (this.F) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.x.f());
                intent.putExtra("top_data", this.x.l());
                intent.putExtra("good_data", this.x.k());
            }
            setResult(-1, intent);
        }
        if (u()) {
            if (this.x == null || this.D == null || this.D.R() == null) {
                bhVar = bi.a;
                bhVar.f();
            } else {
                bhVar2 = bi.a;
                bhVar2.a(this.x.p(), this.D.R().onSaveInstanceState(), this.x.h(), this.x.g());
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.D.f(this.x.m())) {
                    v();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i) {
        String E = TbadkApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.a.k.login_to_use), true, i);
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String format;
        int size;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 11001:
                    d((String) null);
                    return;
                case 11009:
                    t();
                    return;
                case 11025:
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this, 12004, true)));
                    return;
                case 11026:
                    com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.c(this, 12005, true)));
                    return;
                case 11027:
                    d(this.D.O());
                    return;
                case 12001:
                    r();
                    int size2 = this.n.size() - 1;
                    if (size2 >= 0 && this.n != null && this.n.getChosedFiles() != null && (size = this.n.getChosedFiles().size()) > 0 && size2 >= 0 && size2 < size) {
                        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ax(this, 12012, this.n, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent, true);
                    return;
                case 12003:
                    if (intent != null) {
                        s();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.D.J();
                            this.z.a(false);
                            return;
                        }
                        this.A.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    s();
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.D.b(a);
                        return;
                    }
                    return;
                case 12005:
                    s();
                    new Handler().postDelayed(new af(this), 200L);
                    ArrayList<String> a2 = com.baidu.tieba.util.i.a(intent);
                    if (a2 != null) {
                        this.D.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.z.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.z.a((WriteData) null);
                    this.z.a(false);
                    this.D.a(true);
                    if (this.D.D()) {
                        this.B.i();
                    } else {
                        if (this.x.r()) {
                            this.D.t();
                        }
                        if (this.x != null && this.x.f() != null && !this.x.m()) {
                            com.baidu.tieba.util.m.b(this.x.f(), (WriteData) null);
                        }
                    }
                    this.D.a(this.n, true);
                    return;
                case 12009:
                case 12010:
                    s();
                    if (i == 12010) {
                        r();
                        return;
                    }
                    return;
                case 12012:
                    a(intent, false);
                    return;
                case 13008:
                    AdditionData n = this.x.p().n();
                    int totalCount = n.getTotalCount();
                    int alreadyCount = n.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.a.k.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.a.k.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.i.a((Context) this, format);
                    this.w.postDelayed(new ag(this), 1000L);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                new ah(this).execute(new Void[0]);
                return;
            case 12002:
                if (intent != null && intent.hasExtra("last_album_id")) {
                    this.n.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    return;
                }
                return;
            case 12003:
            case 12004:
            case 12005:
            case 12006:
            case 12007:
            case 12008:
            default:
                return;
            case 12009:
            case 12010:
                s();
                return;
        }
    }

    private void r() {
        String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tbadk.core.data.n.f() + "/cameras/" + this.o;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.g.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.b(this)), com.baidu.adp.lib.util.i.a(this, com.baidu.adp.lib.util.i.c(this)));
                    Bitmap e = com.baidu.tbadk.core.util.g.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.w.a("cameras", this.o, e, 100);
                    e.recycle();
                }
            } catch (Exception e2) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.n.addChooseFile(imageFileInfo);
            this.n.updateQuality();
            this.D.a(this.n, true);
        }
        if (this.n.getChosedFiles() != null && this.n.getChosedFiles().size() > 0) {
            this.D.j.b(23);
        }
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.n.parseJson(stringExtra);
                this.n.updateQuality();
                if (this.n.getChosedFiles() != null) {
                    this.D.a(this.n, z);
                }
            }
            if (this.n.getChosedFiles() != null && this.n.getChosedFiles().size() > 0) {
                this.D.j.b(23);
            }
        }
    }

    private void s() {
        if (this.E) {
            this.E = false;
            new Handler().postDelayed(new ak(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        MarkData f2 = this.x.f(this.D.K());
        if (f2 != null) {
            this.D.t();
            this.y.a(f2);
            if (!this.y.a()) {
                this.y.d();
                TiebaStatic.a(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.y.e();
            TiebaStatic.a(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        VoiceData.VoiceModel i;
        if (this.z.a() == null) {
            if (!this.x.m()) {
                WriteData a = this.x.a(str);
                a.setWriteImagesInfo(this.n);
                this.z.a(this.n.size() > 0);
                this.z.a(a);
            } else {
                this.z.a(this.B.f());
            }
        }
        if (this.z.a() != null) {
            if (str == null) {
                this.z.a().setContent(this.D.M());
                i = this.D.d();
                this.D.e();
            } else {
                this.z.a().setContent(this.D.N());
                i = this.D.i();
                this.D.j();
            }
            if (i != null) {
                if (i.getId() != null) {
                    this.z.a().setVoice(i.getId());
                    this.z.a().setVoiceDuringTime(i.duration);
                } else {
                    this.z.a().setVoice(null);
                    this.z.a().setVoiceDuringTime(-1);
                }
            } else {
                this.z.a().setVoice(null);
                this.z.a().setVoiceDuringTime(-1);
            }
            if (this.z.b()) {
                this.D.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(PbActivity pbActivity) {
        com.baidu.tieba.data.ae p = pbActivity.x.p();
        pbActivity.x.c(true);
        p.a(pbActivity.y.c());
        pbActivity.D.a(p);
    }

    private boolean u() {
        if (this.x == null) {
            return true;
        }
        if (this.x.w()) {
            MarkData x = this.x.x();
            if (x == null || !this.x.j()) {
                return true;
            }
            MarkData f2 = this.x.f(this.D.K());
            if (f2 == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", x);
                setResult(-1, intent);
                super.closeActivity();
                return true;
            } else if (f2.getPostId() == null || f2.getPostId().equals(x.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", x);
                setResult(-1, intent2);
                super.closeActivity();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.a(String.format(getString(com.baidu.tieba.a.k.alert_update_mark), Integer.valueOf(f2.getFloor())));
                aVar.a(com.baidu.tieba.a.k.alert_yes_btn, new al(this, f2, x));
                aVar.b(com.baidu.tieba.a.k.alert_no_button, new am(this, x));
                aVar.a();
                aVar.b();
                return false;
            }
        } else if (this.x.p() == null || this.x.p().e() == null || this.x.p().e().size() <= 0 || !this.x.j()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.view.w
    public final ListView a() {
        if (this.D == null) {
            return null;
        }
        return this.D.R();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final int e() {
        if (this.D == null) {
            return 0;
        }
        bk bkVar = this.D;
        return bk.S();
    }

    @Override // com.baidu.tbadk.core.view.w
    public final int b() {
        if (this.D == null) {
            return 0;
        }
        bk bkVar = this.D;
        return bk.T();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<ImageView> f() {
        return this.s;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<TextView> g() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<GifView> h() {
        return this.v;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<View> i() {
        return this.t;
    }

    @Override // com.baidu.tbadk.core.view.w
    public final com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(String str) {
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001003, new com.baidu.tbadk.core.b.ag(this, str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(Context context, String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com")) {
            Matcher matcher = f.matcher(lowerCase);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(this).a(group.substring(group.lastIndexOf("/") + 1), null, null)));
                    return;
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e.toString());
                }
            }
            Matcher matcher2 = g.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    sendMessage(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(this).a(group2.substring(group2.lastIndexOf("=") + 1), null, null)));
                    return;
                } catch (Exception e2) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher3 = h.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this).a(group3.substring(group3.lastIndexOf("=") + 1), "pb")));
                    return;
                } catch (Exception e3) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e3.toString());
                }
            }
        }
        com.baidu.tbadk.browser.a.a(this, str);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void b(String str) {
        com.baidu.tbadk.browser.a.a(this, str);
        TiebaStatic.a(this, "pb_video", "pbclick", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void c(String str) {
        Intent intent = new Intent("com.baidu.search.video");
        intent.setClassName("com.baidu.video", "com.baidu.video.ui.ThirdInvokeActivtiy");
        intent.putExtra("bdhdurl", str);
        intent.putExtra("refer", "http://tieba.baidu.com/p/");
        intent.putExtra("title", "test");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            if (this.l == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(com.baidu.tieba.a.k.download_baidu_video_dialog));
                builder.setPositiveButton(getString(com.baidu.tieba.a.k.install), new an(this));
                builder.setNegativeButton(getString(com.baidu.tieba.a.k.cancel), new ao(this));
                builder.setCancelable(true);
                this.l = builder.create();
                this.l.setCanceledOnTouchOutside(false);
            }
            this.l.show();
            AlertDialog alertDialog = this.l;
        }
        TiebaStatic.a(this, "baidu_video", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(PbActivity pbActivity, com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList arrayList) {
        int i3;
        int i4;
        if (aVar == aVar2) {
            pbActivity.b = true;
        }
        if (aVar != null) {
            int size = aVar.a().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.a().get(i6) != null && aVar.a().get(i6).a() == 8) {
                    i5++;
                    int c = aVar.a().get(i6).c().c();
                    int b = aVar.a().get(i6).c().b();
                    if (!(c < 80 || b < 80 || b * c < 10000) && aVar.a().get(i6).c().d()) {
                        arrayList.add(a(aVar.a().get(i6)));
                        if (!pbActivity.b) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
                    } else if (aVar == aVar2 && i5 <= i2) {
                        i4 = i7 - 1;
                        i3 = i5;
                    }
                    i6++;
                    i7 = i4;
                    i5 = i3;
                }
                i3 = i5;
                i4 = i7;
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(PbActivity pbActivity, com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        GifView gifView = (GifView) pbActivity.D.R().findViewWithTag(str);
        if (gifView == null || (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) == null) {
            return;
        }
        if (bVar != null) {
            tbRichTextEmotionINfo.j = false;
        } else {
            tbRichTextEmotionINfo.j = true;
        }
        gifView.setGif(bVar);
        gifView.setIsLoading(false);
        gifView.setTag(null);
        com.baidu.adp.lib.util.f.e("PbActivity", "imageLoaded", "gif loaded");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(PbActivity pbActivity, com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        GifView gifView;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        View af = pbActivity.D.af();
        if (af == null || (gifView = (GifView) af.findViewWithTag(str)) == null || (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) == null) {
            return;
        }
        if (bVar != null) {
            tbRichTextEmotionINfo.j = false;
        } else {
            tbRichTextEmotionINfo.j = true;
        }
        gifView.setGif(bVar);
        gifView.setIsLoading(false);
        gifView.setTag(null);
        com.baidu.adp.lib.util.f.e("PbActivity", "imageLoaded", "gif loaded");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.baidu.tieba.data.ai aiVar) {
        boolean z = false;
        if (aiVar.d() != null && aiVar.d().equals(this.x.o())) {
            z = true;
        }
        MarkData b = this.x.b(aiVar);
        if (b != null && a(11009)) {
            this.y.a(b);
            this.D.t();
            if (!z) {
                this.y.d();
            } else {
                this.y.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.baidu.tbadk.widget.richText.a a(PbActivity pbActivity, String str, int i) {
        if (pbActivity.x == null || pbActivity.x.p() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ae p = pbActivity.x.p();
        com.baidu.tbadk.widget.richText.a a = pbActivity.a(p.e(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.ai> e = p.e();
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = pbActivity.a(e.get(i2).c(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.ai> arrayList, String str, int i) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a h2 = arrayList.get(i2).h();
            ArrayList<com.baidu.tbadk.widget.richText.c> a = h2.a();
            int size = a.size();
            int i3 = -1;
            int i4 = 0;
            while (i4 < size) {
                if (a.get(i4) != null && a.get(i4).a() == 8) {
                    i3++;
                    if (a.get(i4).c().f().equals(str)) {
                        int c = a.get(i4).c().c();
                        int b = a.get(i4).c().b();
                        if (c < 80 || b < 80 || b * c < 10000) {
                            return null;
                        }
                        this.ah = i4;
                        return h2;
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
    public static String a(com.baidu.tbadk.widget.richText.c cVar) {
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g c = cVar.c();
        if (c != null) {
            if (!com.baidu.adp.lib.util.n.a(c.a())) {
                return c.a();
            }
            if (c.b() * c.c() > com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) {
                double sqrt = Math.sqrt((com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) / (c.b() * c.c()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c.c() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c.b())));
            } else {
                float c2 = c.c() / c.b();
                double sqrt2 = Math.sqrt((com.baidu.tbadk.core.data.n.u() * com.baidu.tbadk.core.data.n.u()) / c2);
                sb.append("width=");
                sb.append(String.valueOf((int) (c2 * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.bc.d(c.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.I = str;
            com.baidu.tbadk.core.g.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.k.c(1).setVisibility(8);
            } else {
                this.k.c(1).setVisibility(0);
            }
            this.k.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final VoiceManager d() {
        return this.i;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public final com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        View af;
        View findViewWithTag;
        if (!this.D.D() || (af = this.D.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.x) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.i != null) {
            this.i.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(PbActivity pbActivity) {
        if (pbActivity.x.v()) {
            TiebaStatic.a(pbActivity, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ae p = pbActivity.x.p();
            String name = p.c().getName();
            String n = p.d().n();
            String str = "http://tieba.baidu.com/p/" + pbActivity.x.f() + "?share=9105";
            String[] b = p.b();
            String str2 = b[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(pbActivity.getResources().getString(com.baidu.tieba.a.k.share_content_tpl), n, name, b[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.a = n;
            fVar.b = format;
            fVar.c = str;
            if (parse != null) {
                fVar.d = parse;
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(pbActivity);
            dVar.a(fVar, true);
            if (pbActivity.a == null) {
                pbActivity.a = new SparseArray<>(7);
                pbActivity.a.put(2, "pb_wx_timeline");
                pbActivity.a.put(3, "pb_wx_friend");
                pbActivity.a.put(4, "pb_qq_zone");
                pbActivity.a.put(5, "pb_tencent_weibo");
                pbActivity.a.put(6, "pb_sina_weibo");
                pbActivity.a.put(7, "pb_renren");
            }
            dVar.a(pbActivity.a);
            TextView textView = (TextView) pbActivity.getLayoutInflater().inflate(com.baidu.tieba.a.i.btn_copy_pb_url, (ViewGroup) null);
            if (TbadkApplication.j().l() == 1) {
                textView.setBackgroundResource(com.baidu.tieba.a.g.btn_blue_square_1);
                textView.setTextColor(pbActivity.getResources().getColor(com.baidu.tieba.a.e.share_copy_pb_url_1));
            } else {
                textView.setBackgroundResource(com.baidu.tieba.a.g.btn_blue_square);
                textView.setTextColor(pbActivity.getResources().getColor(com.baidu.tieba.a.e.share_copy_pb_url));
            }
            dVar.a(textView, new ap(pbActivity, str));
            dVar.a();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public final com.baidu.adp.lib.d.b<LinearLayout> j() {
        return this.u;
    }

    @Override // com.baidu.tbadk.widget.j
    public final void a(com.baidu.tbadk.widget.k kVar) {
        if (kVar != null) {
            this.ao.remove(kVar);
        }
    }

    public final void n() {
        while (this.ao.size() > 0) {
            com.baidu.tbadk.widget.k remove = this.ao.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.tieba.data.ae p = this.x.p();
        if (p != null) {
            boolean isIfAddition = p.g().isIfAddition();
            AdditionData n = p.n();
            if (n == null) {
                isIfAddition = false;
            }
            if (isIfAddition) {
                r0 = n.getAlreadyCount() == n.getTotalCount();
                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                    r0 = true;
                }
            }
            this.D.b(isIfAddition, r0);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.D.c() == view) {
            com.baidu.tbadk.core.data.o d2 = this.x.p().d();
            if (d2.k() == null || d2.k().getIsLike() == 0) {
                View childAt = ((ViewGroup) view).getChildAt(0);
                if (motionEvent.getAction() == 0) {
                    childAt.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.a.b.praise_animation_scale1));
                } else if (motionEvent.getAction() == 1) {
                    childAt.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.a.b.praise_animation_scale3));
                } else if (motionEvent.getAction() == 2) {
                    childAt.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.a.b.praise_animation_scale2));
                } else if (motionEvent.getAction() == 3) {
                    childAt.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.a.b.praise_animation_scale2));
                }
            }
        }
        return false;
    }
}
