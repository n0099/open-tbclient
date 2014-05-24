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
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.channelrtc.medialivesender.LiveSenderControl;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity implements View.OnTouchListener, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.z, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.n {
    private static final String d = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/135_1";
    private static final Pattern f = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern g = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern h = Pattern.compile("[?|&]kw=[^&]+");
    private String I;
    private String J;
    private AlertDialog ag;
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
    private final Handler w = new Handler(new ar(this));
    private bj x = null;
    private com.baidu.tieba.model.ai y = null;
    private com.baidu.tieba.model.ar z = null;
    private com.baidu.tieba.model.ac A = null;
    private com.baidu.tieba.pb.sub.f B = null;
    private com.baidu.tieba.model.v C = null;
    private bq D = null;
    private boolean E = false;
    private boolean F = false;
    private com.baidu.tbadk.core.view.i G = null;
    private bp H = null;
    private boolean K = false;
    private boolean L = false;
    private dn M = new dn(new at(this));
    private long N = 0;
    private boolean O = true;
    private final View.OnClickListener P = new au(this);
    private final bk Q = new aw(this);
    private final com.baidu.tieba.model.ak R = new d(this);
    private final View.OnClickListener S = new e(this);
    private final View.OnClickListener T = new f(this);
    private final View.OnClickListener U = new g(this);
    private final AbsListView.OnScrollListener V = new h(this);
    private final AbsListView.OnScrollListener W = new i(this);
    private final com.baidu.tieba.pb.sub.h X = new j(this);
    private final com.baidu.tieba.model.as Y = new k(this);
    private final com.baidu.adp.base.e Z = new l(this);
    private final ay aa = new m(this);
    private final com.baidu.adp.widget.ListView.d ab = new o(this);
    private final com.baidu.adp.widget.ListView.x ac = new p(this);
    private final com.baidu.adp.widget.ListView.z ad = new q(this);
    private final DialogInterface.OnClickListener ae = new r(this);
    private final com.baidu.adp.base.e af = new s(this);
    private final cw ah = new t(this);
    private int ai = 0;
    private final com.baidu.tbadk.widget.richText.s aj = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.r ak = new v(this);
    com.baidu.tieba.data.ai c = null;
    private final DialogInterface.OnClickListener al = new w(this);
    private final View.OnLongClickListener am = new x(this);
    private final com.baidu.tbadk.core.view.m an = new z(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006001, new as());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        p();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void p() {
        com.baidu.tbadk.core.util.bi.a().a(new aa());
    }

    private void q() {
        this.D.H();
        this.D.f();
    }

    private void r() {
        this.D.I();
        this.D.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!this.L && this.O) {
            this.L = true;
            com.baidu.tbadk.core.data.n d2 = this.x.p().d();
            if (d2 != null) {
                this.M.a(d2.I(), d2.p(), d2.o() == null ? 0 : d2.o().getIsLike(), "pb");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String sb;
        String sb2;
        com.baidu.tbadk.core.data.n d2 = this.x.p().d();
        if (i == 1) {
            PraiseData o = d2.o();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (o == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    d2.a(praiseData);
                } else {
                    d2.o().getUser().add(0, metaData);
                    d2.o().setNum(d2.o().getNum() + 1);
                    d2.o().setIsLike(i);
                }
            }
            if (d2.o().getNum() < 1) {
                sb2 = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
            } else {
                sb2 = new StringBuilder(String.valueOf(d2.o().getNum())).toString();
            }
            this.D.a(sb2, true);
        } else {
            d2.o().setIsLike(i);
            d2.o().setNum(d2.o().getNum() - 1);
            ArrayList<MetaData> user = d2.o().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                        d2.o().getUser().remove(next);
                        break;
                    }
                }
            }
            if (d2.o().getNum() < 1) {
                sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
            } else {
                sb = new StringBuilder(String.valueOf(d2.o().getNum())).toString();
            }
            this.D.a(sb, false);
        }
        if (this.x.h()) {
            this.D.l().notifyDataSetChanged();
        } else {
            this.D.b(this.x.p());
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
            this.i.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.n);
        bundle.putString("photo_name", this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.m = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.m = System.currentTimeMillis();
        }
        this.j = 0;
        t();
        this.i = new VoiceManager();
        this.i.onCreate(this);
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.i != null) {
            this.i.onStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.e = true;
        super.onPause();
        BdListView a = a();
        this.j = CompatibleUtile.getInstance().getViewLayer(a);
        if (this.j == 1) {
            CompatibleUtile.getInstance().noneViewGpu(a);
        }
        if (this.i != null) {
            this.i.onPause(this);
        }
        if (this.D != null) {
            this.D.aa();
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
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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
            this.i.onResume(this);
        }
        this.D.j.t();
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.be.c(writeData.getContent()) && com.baidu.tbadk.core.util.be.c(this.D.M())) {
                this.D.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.n.size() == 0) {
                this.n.copyFrom(writeData.getWriteImagesInfo());
                this.D.a(this.n, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.i != null) {
            this.i.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.x.cancelLoadData();
        this.z.cancelLoadData();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.C.cancelLoadData();
        this.D.ab();
        super.onDestroy();
        if (this.i != null) {
            this.i.onDestory(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.D.a(i);
        this.G.a(this, i, getResources().getDrawable(com.baidu.tieba.u.bg_collect), getResources().getDrawable(com.baidu.tieba.u.bg_collect_1));
        if (this.D.a() != null) {
            this.D.a().a(i);
        }
    }

    private void t() {
        this.D = new bq(this, this.P);
        this.H = new bp(this, this.P);
        this.G = new com.baidu.tbadk.core.view.i(this, this.H.b(), getResources().getDrawable(com.baidu.tieba.u.bg_collect), null);
        this.D.a(new ab(this));
        this.D.a(this.V);
        this.D.b(this.W);
        this.D.a(this.S);
        this.D.b(this.T);
        this.D.c(this.U);
        this.D.a(this.ac);
        this.D.a(this.ad);
        this.D.a(this.ae);
        this.D.a(this.ab);
        this.D.g(com.baidu.tbadk.core.g.a().f());
        this.D.h(com.baidu.tbadk.core.g.a().d());
        this.D.a(this.aj);
        this.D.a(this.ak);
        this.D.a(this.am);
        this.D.a(this.ah);
        this.D.a(this.an);
        this.D.a(this.aa);
        u();
        m();
    }

    private void u() {
        this.k = new com.baidu.tbadk.core.dialog.d(this);
        this.k.a(new Object[]{getString(com.baidu.tieba.y.call_phone), getString(com.baidu.tieba.y.sms_phone), getString(com.baidu.tieba.y.search_in_baidu)}, new ac(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
    }

    private void a(Bundle bundle) {
        this.x = new bj(this);
        this.x.a(this.Q);
        this.y = new com.baidu.tieba.model.ai();
        this.y.a(this.R);
        this.z = new com.baidu.tieba.model.ar();
        this.z.a(this.Y);
        this.A = new com.baidu.tieba.model.ac();
        this.A.setLoadDataCallBack(this.af);
        this.B = new com.baidu.tieba.pb.sub.f(this);
        this.B.a(this.X);
        this.C = new com.baidu.tieba.model.v();
        this.C.setLoadDataCallBack(this.Z);
        if (bundle != null) {
            this.x.a(bundle);
        } else {
            this.x.a(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.x.d(true);
        }
        bn.a().a(this.x.e(), this.x.j());
        if (!this.x.m()) {
            this.x.s();
            this.D.t();
        } else {
            if (bundle != null) {
                this.B.a(bundle);
            } else {
                this.B.a(getIntent());
            }
            this.J = this.B.b();
            String c = this.B.c();
            if (c != null && (("mention".equals(this.B.c()) || c.equals("person_post_reply")) && this.J != null)) {
                this.D.G();
            } else {
                this.D.A();
            }
            this.B.j();
        }
        this.D.a(new ad(this));
        if (bundle != null) {
            this.n = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.o = bundle.getString("photo_name");
        }
        this.n.setMaxImagesAllowed(10);
        if (!this.x.m()) {
            com.baidu.tieba.util.m.a(this.x.f(), this);
        }
        this.M.setUniqueId(getUniqueId());
        this.M.a();
    }

    public void k() {
        this.D.a(this.x.h(), this.y.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ai aiVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (aiVar = (com.baidu.tieba.data.ai) sparseArray.get(com.baidu.tieba.v.tag_clip_board)) != null) {
            a(aiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.af p;
        String str = null;
        if (this.x != null && (p = this.x.p()) != null && p.c() != null) {
            str = p.c().getName();
        }
        if (com.baidu.tieba.c.a.a(str, bool)) {
            r();
        } else {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.c.a.a(str, bool)) {
            r();
        } else {
            q();
        }
    }

    public void l() {
        if (this.D.a() != null) {
            this.D.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.x.m()) {
                antiData.setBlock_forum_name(this.x.p().c().getName());
                antiData.setBlock_forum_id(this.x.p().c().getId());
                antiData.setUser_name(this.x.p().h().getUserName());
                antiData.setUser_id(this.x.p().h().getUserId());
            } else {
                antiData.setBlock_forum_name(this.B.e().h().getName());
                antiData.setBlock_forum_id(this.B.e().h().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.D.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.x xVar) {
        int i = 0;
        this.D.a(0, xVar.a, xVar.b, true);
        if (xVar.a) {
            if (xVar.c == 1) {
                ArrayList<com.baidu.tieba.data.ai> e = this.x.p().e();
                int size = e.size();
                while (true) {
                    if (i < size) {
                        if (!xVar.d.equals(e.get(i).l())) {
                            i++;
                        } else {
                            e.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.D.a(this.x.p());
            } else if (xVar.c == 0) {
                v();
            } else if (xVar.c == 2) {
                ArrayList<com.baidu.tieba.data.ai> e2 = this.x.p().e();
                int size2 = e2.size();
                boolean z = false;
                for (int i2 = 0; i2 < size2 && !z; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < e2.get(i2).i().size()) {
                            if (!xVar.d.equals(e2.get(i2).i().get(i3).l())) {
                                i3++;
                            } else {
                                e2.get(i2).i().remove(i3);
                                e2.get(i2).j();
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    AdditionData n = this.x.p().n();
                    com.baidu.tieba.data.ai aiVar = e2.get(i2);
                    ArrayList<com.baidu.tieba.data.ai> k = aiVar.k();
                    int size3 = k.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size3) {
                            if (!xVar.d.equals(e2.get(i2).k().get(i4).l())) {
                                i4++;
                            } else {
                                k.remove(i4);
                                n.decreaseAlreadyCount();
                                if (aiVar.v() > k.size()) {
                                    aiVar.d(k.size());
                                }
                                if (k.size() > 0) {
                                    com.baidu.tieba.data.ai aiVar2 = k.get(k.size() - 1);
                                    n.setLastAdditionTime(aiVar2.n() / 1000);
                                    com.baidu.tbadk.widget.richText.a p = aiVar2.p();
                                    String str = "";
                                    if (p != null) {
                                        str = p.toString();
                                    }
                                    n.setLastAdditionContent(str);
                                } else {
                                    com.baidu.tbadk.widget.richText.a p2 = aiVar.p();
                                    String str2 = "";
                                    if (p2 != null) {
                                        str2 = p2.toString();
                                    }
                                    n.setLastAdditionContent(str2);
                                }
                                H();
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    this.D.a(this.x.p());
                }
                if (this.D.D()) {
                    ArrayList<com.baidu.tieba.data.ai> c = this.B.e().c();
                    int size4 = c.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 < size4) {
                            if (!xVar.d.equals(c.get(i5).l())) {
                                i5++;
                            } else {
                                c.remove(i5);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.D.a(this.B.e(), this.x.p().l());
                    if (!z) {
                        String b = this.B.b();
                        while (i < size2) {
                            if (!b.equals(e2.get(i).l())) {
                                i++;
                            } else {
                                e2.get(i).j();
                                this.D.a(this.x.p());
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
        this.D.a(1, zVar.a, zVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ab abVar) {
        this.D.a(this.C.getLoadDataMode(), abVar.a, abVar.b, false);
        this.D.a(abVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.ab abVar) {
        this.D.a(this.C.getLoadDataMode(), abVar.a, abVar.b, true);
        if (abVar.a) {
            this.F = true;
            if (i == 2) {
                this.x.p().d().d(1);
                this.x.a(1);
            } else if (i == 3) {
                this.x.p().d().d(0);
                this.x.a(0);
            } else if (i == 4) {
                this.x.p().d().c(1);
                this.x.b(1);
            } else if (i == 5) {
                this.x.p().d().c(0);
                this.x.b(0);
            }
            this.D.a(this.x.p(), this.x.h(), true);
        }
    }

    private void v() {
        if (this.x.i()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.x.f());
            setResult(-1, intent);
        }
        if (B()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        int isLike;
        if (this.M != null) {
            this.M.setLoadDataCallBack(null);
            this.M = null;
        }
        this.D.ac();
        if (this.x != null && this.x.i()) {
            Intent intent = new Intent();
            if (this.F) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.x.f());
                intent.putExtra("top_data", this.x.l());
                intent.putExtra("good_data", this.x.k());
            }
            if (this.K) {
                intent.putExtra("praise_changed", true);
                intent.putExtra("praise_changed_tid", this.x.f());
                PraiseData o = this.x.p().d().o();
                if (o == null) {
                    isLike = 0;
                } else {
                    isLike = o.getIsLike();
                }
                intent.putExtra("praise_like_num", isLike);
            }
            setResult(-1, intent);
        }
        if (B()) {
            if (this.x != null && this.D != null && this.D.R() != null) {
                com.baidu.tieba.data.af p = this.x.p();
                if (p != null && p.h() != null) {
                    p.h().setBimg_url(TbadkApplication.m252getInst().getDefaultBubble());
                }
                bn.a().a(this.x.p(), this.D.R().onSaveInstanceState(), this.x.h(), this.x.g());
            } else {
                bn.a().f();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.G != null) {
                    this.G.dismiss();
                }
                if (this.D.f(this.x.m())) {
                    D();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.y.login_to_use), true, i);
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
                    a((String) null);
                    return;
                case 11009:
                    z();
                    return;
                case LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025 /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this, 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this, 12005, true)));
                    return;
                case 11027:
                    a(this.D.O());
                    return;
                case 12001:
                    b(intent);
                    int size2 = this.n.size() - 1;
                    if (size2 > -1 && this.n != null && this.n.getChosedFiles() != null && (size = this.n.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bk(this, 12012, this.n, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        y();
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
                    y();
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.D.b(a);
                        return;
                    }
                    return;
                case 12005:
                    y();
                    new Handler().postDelayed(new ae(this), 200L);
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
                    y();
                    if (i == 12010) {
                        b(intent);
                        return;
                    }
                    return;
                case 12012:
                    c(intent);
                    return;
                case 13008:
                    AdditionData n = this.x.p().n();
                    int totalCount = n.getTotalCount();
                    int alreadyCount = n.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.k.a((Context) this, format);
                    bn.a().f();
                    this.w.postDelayed(new af(this), 1000L);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                x();
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
                y();
                return;
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.o;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.g.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.k.a(this, com.baidu.adp.lib.util.k.b(this)), com.baidu.adp.lib.util.k.a(this, com.baidu.adp.lib.util.k.c(this)));
                    Bitmap e = com.baidu.tbadk.core.util.g.e(a, b);
                    if (a != e) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.x.a(TbConfig.LOCAL_CAMERA_DIR, this.o, e, 100);
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

    private void c(Intent intent) {
        a(intent, false);
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

    private void x() {
        new ag(this).execute(new Void[0]);
    }

    protected void m() {
        String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new ah(this));
        if (this.ag == null) {
            this.ag = builder.create();
            this.ag.setCanceledOnTouchOutside(true);
        }
    }

    private void y() {
        if (this.E) {
            this.E = false;
            new Handler().postDelayed(new ai(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        MarkData f2 = this.x.f(this.D.K());
        if (f2 != null) {
            this.D.t();
            this.y.a(f2);
            if (!this.y.a()) {
                this.y.d();
                TiebaStatic.eventStat(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.y.e();
            TiebaStatic.eventStat(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.baidu.tieba.data.af p = this.x.p();
        this.x.c(true);
        p.a(this.y.c());
        this.D.a(p);
    }

    private boolean B() {
        if (this.x == null) {
            return true;
        }
        if (this.x.x()) {
            MarkData y = this.x.y();
            if (y == null || !this.x.j()) {
                return true;
            }
            MarkData f2 = this.x.f(this.D.K());
            if (f2 == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", y);
                setResult(-1, intent);
                w();
                return true;
            } else if (f2.getPostId() == null || f2.getPostId().equals(y.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", y);
                setResult(-1, intent2);
                w();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.a(String.format(getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(f2.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new ak(this, f2, y));
                aVar.b(com.baidu.tieba.y.alert_no_button, new al(this, y));
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.w
    /* renamed from: n */
    public BdListView a() {
        if (this.D == null) {
            return null;
        }
        return this.D.R();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int e() {
        if (this.D == null) {
            return 0;
        }
        return this.D.S();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.D == null) {
            return 0;
        }
        return this.D.T();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> f() {
        return this.s;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> g() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> h() {
        return this.v;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> i() {
        return this.t;
    }

    @Override // com.baidu.tbadk.core.view.w
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.at(this, str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.contains("tieba.baidu.com")) {
            Matcher matcher = f.matcher(lowerCase);
            if (matcher.find()) {
                try {
                    String group = matcher.group();
                    sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(this).a(group.substring(group.lastIndexOf("/") + 1), null, null)));
                    return;
                } catch (Exception e) {
                    BdLog.e(getClass().getName(), "onClick", e.toString());
                }
            }
            Matcher matcher2 = g.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(this).a(group2.substring(group2.lastIndexOf("=") + 1), null, null)));
                    return;
                } catch (Exception e2) {
                    BdLog.e(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher3 = h.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    sendMessage(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(this).a(group3.substring(group3.lastIndexOf("=") + 1), "pb")));
                    return;
                } catch (Exception e3) {
                    BdLog.e(getClass().getName(), "onClick", e3.toString());
                }
            }
        }
        com.baidu.tbadk.browser.a.a(this, str);
    }

    private DialogInterface C() {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.y.install), new am(this));
            builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new an(this));
            builder.setCancelable(true);
            this.l = builder.create();
            this.l.setCanceledOnTouchOutside(false);
        }
        this.l.show();
        return this.l;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void c(Context context, String str) {
        com.baidu.tbadk.browser.a.a(this, str);
        TiebaStatic.eventStat(this, "pb_video", "pbclick", 1, new Object[0]);
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
        } catch (ActivityNotFoundException e) {
            C();
        }
        TiebaStatic.eventStat(this, "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList) {
        int i3;
        int i4;
        if (aVar == aVar2) {
            this.b = true;
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
                    if ((c < 80 || b < 80 || b * c < 10000) || !aVar.a().get(i6).c().d()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        arrayList.add(a(aVar.a().get(i6)));
                        if (!this.b) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.ai aiVar) {
        boolean z = false;
        if (aiVar.l() != null && aiVar.l().equals(this.x.o())) {
            z = true;
        }
        MarkData b = this.x.b(aiVar);
        if (b != null && b(11009)) {
            this.y.a(b);
            this.D.t();
            if (!z) {
                this.y.d();
            } else {
                this.y.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.x == null || this.x.p() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.af p = this.x.p();
        com.baidu.tbadk.widget.richText.a a = a(p.e(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.ai> e = p.e();
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(e.get(i2).k(), str, i);
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
            com.baidu.tbadk.widget.richText.a p = arrayList.get(i2).p();
            ArrayList<com.baidu.tbadk.widget.richText.c> a = p.a();
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
                        this.ai = i4;
                        return p;
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
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g c = cVar.c();
        if (c != null) {
            if (!StringUtils.isNull(c.a())) {
                return c.a();
            }
            if (c.b() * c.c() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (c.b() * c.c()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c.c() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c.b())));
            } else {
                float c2 = c.c() / c.b();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / c2);
                sb.append("width=");
                sb.append(String.valueOf((int) (c2 * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.be.d(c.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.I = str;
            com.baidu.tbadk.core.f.a(this, "pb_show_phonedialog");
            if (str2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                this.k.c(1).setVisibility(8);
            } else {
                this.k.c(1).setVisibility(0);
            }
            this.k.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.z
    public VoiceManager d() {
        return this.i;
    }

    @Override // com.baidu.tbadk.core.voice.z
    public com.baidu.tbadk.core.voice.x a(VoiceData.VoiceModel voiceModel) {
        View af;
        View findViewWithTag;
        if (!this.D.D() || (af = this.D.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.x) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.i != null) {
            this.i.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.x.w()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.af p = this.x.p();
            String name = p.c().getName();
            String r = p.d().r();
            String str = "http://tieba.baidu.com/p/" + this.x.f() + "?share=9105";
            String[] b = p.b();
            String str2 = b[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), r, name, b[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.a = r;
            fVar.b = format;
            fVar.c = str;
            if (parse != null) {
                fVar.d = parse;
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(fVar, true);
            dVar.a(F());
            dVar.a(G(), new ao(this, str));
            dVar.a();
        }
    }

    private SparseArray<String> F() {
        if (this.a == null) {
            this.a = new SparseArray<>(7);
            this.a.put(2, "pb_wx_timeline");
            this.a.put(3, "pb_wx_friend");
            this.a.put(4, "pb_qq_zone");
            this.a.put(5, "pb_tencent_weibo");
            this.a.put(6, "pb_sina_weibo");
            this.a.put(7, "pb_renren");
        }
        return this.a;
    }

    private View G() {
        TextView textView = (TextView) getLayoutInflater().inflate(com.baidu.tieba.w.btn_copy_pb_url, (ViewGroup) null);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            textView.setBackgroundResource(com.baidu.tieba.u.btn_blue_square_1);
            textView.setTextColor(getResources().getColor(com.baidu.tieba.s.share_copy_pb_url_1));
        } else {
            textView.setBackgroundResource(com.baidu.tieba.u.btn_blue_square);
            textView.setTextColor(getResources().getColor(com.baidu.tieba.s.share_copy_pb_url));
        }
        return textView;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> j() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.baidu.tieba.data.af p = this.x.p();
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
            com.baidu.tbadk.core.data.n d2 = this.x.p().d();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = d2.o() == null || d2.o().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.N > 1000) {
                        this.O = true;
                        b(childAt);
                    } else {
                        this.O = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        b(childAt, this.O);
                    } else {
                        a(childAt, this.O);
                    }
                } else if (motionEvent.getAction() == 2) {
                    a(childAt, this.O);
                } else if (motionEvent.getAction() == 3) {
                    a(childAt, this.O);
                }
            }
        }
        return false;
    }

    private void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale2));
            new Handler().postDelayed(new ap(this), 200L);
        }
    }

    private void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new aq(this), 600L);
        }
    }

    private void b(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale1));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.g
    public void onPreLoad(BdListView bdListView) {
        if (bdListView != null && this.x != null && this.x.p() != null && bdListView.equals(a())) {
            com.baidu.tbadk.core.util.ay.a(bdListView, getUniqueId(), this.x.p().m() == 1 ? 17 : 18);
        }
    }
}
