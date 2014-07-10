package com.baidu.tieba.pb.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.BaobaoSdkDelegate;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.frs.Cdo;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity implements View.OnTouchListener, com.baidu.tbadk.core.view.w, com.baidu.tbadk.core.voice.aa, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.n {
    private static final String e = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/135_1";
    private String I;
    private String J;
    private VoiceManager g;
    private AlertDialog j;
    private String o;
    private boolean f = false;
    private int h = 0;
    private com.baidu.tbadk.core.dialog.e i = null;
    SparseArray<String> a = null;
    private long k = -1;
    private WriteImagesInfo l = new WriteImagesInfo();
    private WriteImagesInfo m = new WriteImagesInfo();
    private WriteData n = new WriteData();
    private String p = null;
    private final com.baidu.adp.lib.d.b<TextView> q = TbRichTextView.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> r = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<ImageView> s = new com.baidu.adp.lib.d.b<>(new c(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> t = new com.baidu.adp.lib.d.b<>(new n(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> u = new com.baidu.adp.lib.d.b<>(new y(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> v = new com.baidu.adp.lib.d.b<>(new aj(this), 20, 0);
    private final Handler w = new Handler(new as(this));
    private bm x = null;
    private com.baidu.tieba.model.ah y = null;
    private com.baidu.tieba.model.aq z = null;
    private com.baidu.tieba.model.ab A = null;
    private com.baidu.tieba.pb.sub.f B = null;
    private com.baidu.tieba.model.t C = null;
    private bt D = null;
    private boolean E = false;
    private boolean F = false;
    private com.baidu.tbadk.core.view.i G = null;
    private bs H = null;
    private boolean K = false;
    private boolean L = false;
    private Cdo M = new Cdo(new aw(this));
    private long N = 0;
    private boolean O = true;
    private final View.OnClickListener P = new ax(this);
    private final bn Q = new az(this);
    private final com.baidu.tieba.model.aj R = new d(this);
    private final View.OnClickListener S = new e(this);
    private final View.OnClickListener T = new f(this);
    private final View.OnClickListener U = new g(this);
    private final AbsListView.OnScrollListener V = new h(this);
    private final AbsListView.OnScrollListener W = new i(this);
    private final com.baidu.tieba.pb.sub.h X = new j(this);
    private final com.baidu.tieba.model.ar Y = new k(this);
    private final com.baidu.adp.base.h Z = new l(this);
    private final bb aa = new m(this);
    private final com.baidu.adp.widget.ListView.d ab = new o(this);
    private final com.baidu.adp.widget.ListView.x ac = new p(this);
    private final com.baidu.adp.widget.ListView.z ad = new q(this);
    private final DialogInterface.OnClickListener ae = new r(this);
    private final com.baidu.adp.base.h af = new s(this);
    private AlertDialog ag = null;
    private final cv ah = new t(this);
    private int ai = 0;
    private final com.baidu.tbadk.widget.richText.s aj = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.r ak = new v(this);
    com.baidu.tieba.data.am c = null;
    private final DialogInterface.OnClickListener al = new w(this);
    private final View.OnLongClickListener am = new x(this);
    private final com.baidu.tbadk.core.view.m an = new z(this);
    com.baidu.tbadk.coreExtra.share.d d = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new av());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        p();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void p() {
        com.baidu.tbadk.core.util.bq.a().a(new aa());
    }

    private void q() {
        this.D.I();
        this.D.g();
    }

    private void r() {
        this.D.J();
        this.D.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!this.L && this.O) {
            this.L = true;
            com.baidu.tbadk.core.data.m c = this.x.r().c();
            if (c != null) {
                int isLike = c.o() == null ? 0 : c.o().getIsLike();
                if (this.M != null) {
                    this.M.a(c.I(), c.p(), isLike, "pb");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String sb;
        String sb2;
        com.baidu.tbadk.core.data.m c = this.x.r().c();
        if (i == 1) {
            PraiseData o = c.o();
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
                    c.a(praiseData);
                } else {
                    c.o().getUser().add(0, metaData);
                    c.o().setNum(c.o().getNum() + 1);
                    c.o().setIsLike(i);
                }
            }
            if (c.o().getNum() < 1) {
                sb2 = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
            } else {
                sb2 = new StringBuilder(String.valueOf(c.o().getNum())).toString();
            }
            this.D.a(sb2, true);
        } else {
            c.o().setIsLike(i);
            c.o().setNum(c.o().getNum() - 1);
            ArrayList<MetaData> user = c.o().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                        c.o().getUser().remove(next);
                        break;
                    }
                }
            }
            if (c.o().getNum() < 1) {
                sb = getResources().getString(com.baidu.tieba.y.frs_item_praise_text);
            } else {
                sb = new StringBuilder(String.valueOf(c.o().getNum())).toString();
            }
            this.D.a(sb, false);
        }
        if (this.x.i()) {
            this.D.m().notifyDataSetChanged();
        } else {
            this.D.b(this.x.r());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.x.b(bundle);
        if (this.x.o()) {
            this.B.b(bundle);
        }
        if (this.g != null) {
            this.g.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.l);
        bundle.putString("photo_name", this.o);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.k = System.currentTimeMillis();
        }
        this.h = 0;
        t();
        this.g = new VoiceManager();
        this.g.onCreate(this);
        a(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.g != null) {
            this.g.onStart(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.f = true;
        super.onPause();
        BdListView a = a();
        this.h = CompatibleUtile.getInstance().getViewLayer(a);
        if (this.h == 1) {
            CompatibleUtile.getInstance().noneViewGpu(a);
        }
        if (this.g != null) {
            this.g.onPause(this);
        }
        if (this.D != null) {
            this.D.ab();
        }
        if (!this.x.o()) {
            WriteData a2 = this.z.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.x.g());
                a2.setWriteImagesInfo(this.l);
            }
            a2.setContent(this.D.N());
            if (this.n != null && this.n.getIsBaobao()) {
                a2.setBaobaoContent(this.n.getBaobaoContent());
                a2.setBaobaoImagesInfo(this.m);
                a2.setIsBaobao(true);
            }
            com.baidu.tieba.util.m.b(this.x.g(), a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.f = false;
        super.onResume();
        if (this.h == 1) {
            CompatibleUtile.getInstance().closeViewGpu(a());
        }
        NoNetworkView a = this.D.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.a(false);
        }
        if (this.g != null) {
            this.g.onResume(this);
        }
        this.D.h.u();
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.bm.c(writeData.getContent()) && com.baidu.tbadk.core.util.bm.c(this.D.N())) {
                this.D.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.l.size() == 0) {
                this.l.copyFrom(writeData.getWriteImagesInfo());
                this.D.a(this.l, true);
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.m.copyFrom(writeData.getBaobaoImagesInfo());
                this.n.setIsBaobao(writeData.getIsBaobao());
                this.n.setBaobaoContent(writeData.getBaobaoContent());
                this.D.a(this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.g != null) {
            this.g.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.x.cancelLoadData();
        this.x.u();
        this.z.cancelLoadData();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.B.g();
        this.C.cancelLoadData();
        this.D.ac();
        super.onDestroy();
        if (this.g != null) {
            this.g.onDestory(this);
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
        this.D = new bt(this, this.P);
        this.H = new bs(this, this.P);
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
        this.D.g(com.baidu.tbadk.core.h.a().f());
        this.D.h(com.baidu.tbadk.core.h.a().d());
        this.D.a(this.aj);
        this.D.a(this.ak);
        this.D.a(this.am);
        this.D.a(this.ah);
        this.D.a(this.an);
        this.D.a(this.aa);
    }

    private void u() {
        if (this.i == null) {
            this.i = new com.baidu.tbadk.core.dialog.e(this);
            this.i.a(new Object[]{getString(com.baidu.tieba.y.call_phone), getString(com.baidu.tieba.y.sms_phone), getString(com.baidu.tieba.y.search_in_baidu)}, new ac(this)).a(com.baidu.tbadk.core.dialog.g.a).b(80).a();
        }
    }

    private void a(Bundle bundle) {
        this.x = new bm(this);
        this.x.a(this.Q);
        this.y = new com.baidu.tieba.model.ah();
        this.y.a(this.R);
        this.z = new com.baidu.tieba.model.aq();
        this.z.a(this.Y);
        this.A = new com.baidu.tieba.model.ab();
        this.A.setLoadDataCallBack(this.af);
        this.B = new com.baidu.tieba.pb.sub.f(this);
        this.B.a(this.X);
        this.C = new com.baidu.tieba.model.t();
        this.C.setLoadDataCallBack(this.Z);
        if (bundle != null) {
            this.x.a(bundle);
        } else {
            this.x.a(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.x.d(true);
        }
        bq.a().a(this.x.e(), this.x.k());
        if (!this.x.o()) {
            this.x.v();
            this.D.u();
        } else {
            if (bundle != null) {
                this.B.a(bundle);
            } else {
                this.B.a(getIntent());
            }
            this.J = this.B.b();
            String c = this.B.c();
            if (c != null && (("mention".equals(this.B.c()) || c.equals("person_post_reply")) && this.J != null)) {
                this.D.H();
            } else {
                this.D.B();
            }
            this.B.k();
        }
        this.D.a(new ad(this));
        if (bundle != null) {
            this.l = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.o = bundle.getString("photo_name");
        }
        this.l.setMaxImagesAllowed(10);
        if (!this.x.o()) {
            com.baidu.tieba.util.m.a(this.x.g(), this);
        }
        this.M.setUniqueId(getUniqueId());
        this.M.a();
    }

    public void k() {
        this.D.a(this.x.i(), this.y.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.am amVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (amVar = (com.baidu.tieba.data.am) sparseArray.get(com.baidu.tieba.v.tag_clip_board)) != null) {
            a(amVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.ai r;
        String str = null;
        if (this.x != null && (r = this.x.r()) != null && r.b() != null) {
            str = r.b().getName();
        }
        if (com.baidu.tieba.d.b.a(str, bool)) {
            r();
        } else {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.d.b.a(str, bool)) {
            r();
        } else {
            q();
        }
    }

    public void l() {
        if (this.D.a() != null) {
            this.D.a().a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.x.o()) {
                antiData.setBlock_forum_name(this.x.r().b().getName());
                antiData.setBlock_forum_id(this.x.r().b().getId());
                antiData.setUser_name(this.x.r().g().getUserName());
                antiData.setUser_id(this.x.r().g().getUserId());
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
    public void a(com.baidu.tieba.model.v vVar) {
        int i = 0;
        this.D.a(0, vVar.a, vVar.b, true);
        if (vVar.a) {
            if (vVar.c == 1) {
                ArrayList<com.baidu.tieba.data.am> d = this.x.r().d();
                int size = d.size();
                while (true) {
                    if (i < size) {
                        if (!vVar.d.equals(d.get(i).l())) {
                            i++;
                        } else {
                            d.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.D.a(this.x.r());
            } else if (vVar.c == 0) {
                v();
            } else if (vVar.c == 2) {
                ArrayList<com.baidu.tieba.data.am> d2 = this.x.r().d();
                int size2 = d2.size();
                boolean z = false;
                for (int i2 = 0; i2 < size2 && !z; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < d2.get(i2).i().size()) {
                            if (!vVar.d.equals(d2.get(i2).i().get(i3).l())) {
                                i3++;
                            } else {
                                d2.get(i2).i().remove(i3);
                                d2.get(i2).j();
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    AdditionData m = this.x.r().m();
                    com.baidu.tieba.data.am amVar = d2.get(i2);
                    ArrayList<com.baidu.tieba.data.am> k = amVar.k();
                    int size3 = k.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size3) {
                            if (!vVar.d.equals(d2.get(i2).k().get(i4).l())) {
                                i4++;
                            } else {
                                k.remove(i4);
                                m.decreaseAlreadyCount();
                                if (amVar.v() > k.size()) {
                                    amVar.d(k.size());
                                }
                                if (k.size() > 0) {
                                    com.baidu.tieba.data.am amVar2 = k.get(k.size() - 1);
                                    m.setLastAdditionTime(amVar2.n() / 1000);
                                    com.baidu.tbadk.widget.richText.a p = amVar2.p();
                                    String str = "";
                                    if (p != null) {
                                        str = p.toString();
                                    }
                                    m.setLastAdditionContent(str);
                                } else {
                                    com.baidu.tbadk.widget.richText.a p2 = amVar.p();
                                    String str2 = "";
                                    if (p2 != null) {
                                        str2 = p2.toString();
                                    }
                                    m.setLastAdditionContent(str2);
                                }
                                G();
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    this.D.a(this.x.r());
                }
                if (this.D.E()) {
                    ArrayList<com.baidu.tieba.data.am> c = this.B.e().c();
                    int size4 = c.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 < size4) {
                            if (!vVar.d.equals(c.get(i5).l())) {
                                i5++;
                            } else {
                                c.remove(i5);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.D.a(this.B.e(), this.x.r().k());
                    if (!z) {
                        String b = this.B.b();
                        while (i < size2) {
                            if (!b.equals(d2.get(i).l())) {
                                i++;
                            } else {
                                d2.get(i).j();
                                this.D.a(this.x.r());
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
        this.D.a(1, xVar.a, xVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.z zVar) {
        this.D.a(this.C.getLoadDataMode(), zVar.a, zVar.b, false);
        this.D.a(zVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.z zVar) {
        this.D.a(this.C.getLoadDataMode(), zVar.a, zVar.b, true);
        if (zVar.a) {
            this.F = true;
            if (i == 2) {
                this.x.r().c().d(1);
                this.x.a(1);
            } else if (i == 3) {
                this.x.r().c().d(0);
                this.x.a(0);
            } else if (i == 4) {
                this.x.r().c().c(1);
                this.x.b(1);
            } else if (i == 5) {
                this.x.r().c().c(0);
                this.x.b(0);
            }
            this.D.a(this.x.r(), this.x.i(), true);
        }
    }

    private void v() {
        if (this.x.j()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.x.g());
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
        this.D.ad();
        if (this.x != null && this.x.j()) {
            Intent intent = new Intent();
            if (this.F) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.x.g());
                intent.putExtra("top_data", this.x.n());
                intent.putExtra("good_data", this.x.l());
            }
            if (this.K) {
                intent.putExtra("praise_changed", true);
                intent.putExtra("praise_changed_tid", this.x.g());
                PraiseData o = this.x.r().c().o();
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
            if (this.x != null && this.D != null && this.D.S() != null) {
                com.baidu.tieba.data.ai r = this.x.r();
                if (r != null && r.g() != null) {
                    r.g().setBimg_url(TbadkApplication.m252getInst().getDefaultBubble());
                }
                bq.a().a(this.x.r(), this.D.S().onSaveInstanceState(), this.x.i(), this.x.h());
            } else {
                bq.a().f();
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
                if (this.D.f(this.x.o())) {
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
        int size2;
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this, 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.d(this, 12005, true)));
                    return;
                case 11027:
                    a(this.D.P());
                    return;
                case 12001:
                    b(intent);
                    if (this.l != null && this.l.size() - 1 > -1 && this.l.getChosedFiles() != null && (size2 = this.l.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bx(this, 12012, this.l, size)));
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
                            this.D.K();
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
                    this.n.setIsBaobao(false);
                    this.n.setBaobaoContent(null);
                    this.m.clear();
                    this.z.a((WriteData) null);
                    this.z.a(false);
                    this.D.a(true);
                    if (this.D.E()) {
                        this.B.j();
                    } else {
                        if (this.x != null && this.x.t()) {
                            this.D.u();
                        }
                        if (this.x != null && this.x.g() != null && !this.x.o()) {
                            com.baidu.tieba.util.m.b(this.x.g(), (WriteData) null);
                        }
                    }
                    this.D.a(this.l, true);
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
                case 12013:
                    d(intent);
                    return;
                case 13008:
                    AdditionData m = this.x.r().m();
                    int totalCount = m.getTotalCount();
                    int alreadyCount = m.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.y.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.j.a((Context) this, format);
                    bq.a().f();
                    this.w.postDelayed(new af(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.x != null) {
                        int intExtra = intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0);
                        String stringExtra = intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME);
                        int intExtra2 = intent.getIntExtra("group_author_id", 0);
                        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
                        String[] a4 = this.x.r().a(this);
                        com.baidu.tieba.data.am c = this.D.c();
                        String str = "";
                        if (c != null) {
                            str = c.l();
                            String d = c.d(this);
                            if (!com.baidu.adp.lib.util.i.b(d)) {
                                a4[1] = d;
                            }
                        }
                        String I = this.x.r().c().I();
                        if (I != null && I.equals(str)) {
                            str = "";
                        }
                        shareFromPBMsgData.setContent(a4[1]);
                        shareFromPBMsgData.setImageUrl(a4[0]);
                        shareFromPBMsgData.setForumName(this.x.r().b().getName());
                        shareFromPBMsgData.setPostId(str);
                        shareFromPBMsgData.setThreadId(this.x.r().c().p());
                        shareFromPBMsgData.setTitle(this.x.r().c().r());
                        a(shareFromPBMsgData, intExtra, stringExtra, intExtra2);
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
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
                    this.l.setLastAlbumId(intent.getStringExtra("last_album_id"));
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

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        BdLog.e("分享的标题：" + this.x.r().c().r());
        aVar.a(this.x.r().c().r());
        cw cwVar = new cw(this);
        cwVar.setData(shareFromPBMsgData);
        aVar.a(cwVar);
        aVar.a(com.baidu.tieba.y.share, new ag(this, i, str, i2, cwVar, shareFromPBMsgData));
        aVar.b(com.baidu.tieba.y.alert_no_button, new ah(this, cwVar));
        aVar.a(false);
        aVar.a().b();
        if (!com.baidu.adp.lib.util.i.b(shareFromPBMsgData.getImageUrl())) {
            cwVar.a(shareFromPBMsgData.getImageUrl(), this.x.r().l() == 1);
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.o;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.h.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.h.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e2 = com.baidu.tbadk.core.util.h.e(a, b);
                    if (a != e2) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.z.a(TbConfig.LOCAL_CAMERA_DIR, this.o, e2, 100);
                    e2.recycle();
                }
            } catch (Exception e3) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.l.addChooseFile(imageFileInfo);
            this.l.updateQuality();
            this.D.a(this.l, true);
        }
        if (this.l.getChosedFiles() != null && this.l.getChosedFiles().size() > 0) {
            this.D.h.b(23);
        }
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.l.parseJson(stringExtra);
                this.l.updateQuality();
                if (this.l.getChosedFiles() != null) {
                    this.D.a(this.l, z);
                }
            }
            if (this.l.getChosedFiles() != null && this.l.getChosedFiles().size() > 0) {
                this.D.h.b(23);
            }
        }
    }

    private void d(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(BaobaoSdkDelegate.KEY_BITMAPPATH);
            String stringExtra2 = intent.getStringExtra(BaobaoSdkDelegate.KEY_CONTENT);
            if (stringExtra != null && stringExtra2 != null) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(stringExtra);
                this.m.clear();
                this.m.addChooseFile(imageFileInfo);
                this.D.a(this.m);
                if (this.m.getChosedFiles() != null && this.m.getChosedFiles().size() > 0) {
                    this.D.h.b(50);
                    this.n.setIsBaobao(true);
                    this.n.setBaobaoContent(stringExtra2);
                    this.n.setBaobaoImagesInfo(this.m);
                    return;
                }
                this.n.setIsBaobao(false);
                this.n.setBaobaoContent("");
                this.n.setBaobaoImagesInfo(this.m);
            }
        }
    }

    private void x() {
        new ai(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.ag == null) {
            String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.operation));
            builder.setItems(strArr, new ak(this));
            this.ag = builder.create();
            this.ag.setCanceledOnTouchOutside(true);
        }
    }

    private void y() {
        if (this.E) {
            this.E = false;
            new Handler().postDelayed(new al(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        MarkData f = this.x.f(this.D.L());
        if (f != null) {
            this.D.u();
            this.y.a(f);
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
        VoiceData.VoiceModel j;
        if (this.z.a() == null) {
            if (!this.x.o()) {
                this.z.a(this.x.a(str));
            } else {
                this.z.a(this.B.f());
            }
        }
        if (this.z.a() != null) {
            if (!this.x.o()) {
                this.z.a().setWriteImagesInfo(this.l);
                this.z.a(this.l.size() > 0);
                if (this.n.getIsBaobao()) {
                    this.z.a().setIsBaobao(true);
                    this.z.a().setBaobaoContent(this.n.getBaobaoContent());
                    this.z.a().setBaobaoImagesInfo(this.m);
                } else {
                    this.z.a().setIsBaobao(false);
                }
            }
            if (str == null) {
                this.z.a().setContent(this.D.N());
                j = this.D.e();
                this.D.f();
            } else {
                this.z.a().setContent(this.D.O());
                j = this.D.j();
                this.D.k();
            }
            if (j != null) {
                if (j.getId() != null) {
                    this.z.a().setVoice(j.getId());
                    this.z.a().setVoiceDuringTime(j.duration);
                } else {
                    this.z.a().setVoice(null);
                    this.z.a().setVoiceDuringTime(-1);
                }
            } else {
                this.z.a().setVoice(null);
                this.z.a().setVoiceDuringTime(-1);
            }
            if (!this.z.c()) {
                showToast(com.baidu.tieba.y.write_img_limit);
            } else if (this.z.b()) {
                this.D.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.baidu.tieba.data.ai r = this.x.r();
        this.x.c(true);
        r.a(this.y.c());
        this.D.a(r);
    }

    private boolean B() {
        if (this.x == null) {
            return true;
        }
        if (this.x.B()) {
            MarkData C = this.x.C();
            if (C == null || !this.x.k()) {
                return true;
            }
            MarkData f = this.x.f(this.D.L());
            if (f == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", C);
                setResult(-1, intent);
                w();
                return true;
            } else if (f.getPostId() == null || f.getPostId().equals(C.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", C);
                setResult(-1, intent2);
                w();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.b(String.format(getString(com.baidu.tieba.y.alert_update_mark), Integer.valueOf(f.getFloor())));
                aVar.a(com.baidu.tieba.y.alert_yes_btn, new am(this, f, C));
                aVar.b(com.baidu.tieba.y.alert_no_button, new an(this, C));
                aVar.a();
                aVar.b();
                return false;
            }
        } else if (this.x.r() == null || this.x.r().d() == null || this.x.r().d().size() <= 0 || !this.x.k()) {
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
        return this.D.S();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int e() {
        if (this.D == null) {
            return 0;
        }
        return this.D.T();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.D == null) {
            return 0;
        }
        return this.D.U();
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
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(this, str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        com.baidu.tbadk.core.util.bq.a().a(context, new String[]{str});
    }

    private DialogInterface C() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.y.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.y.install), new ao(this));
            builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new ap(this));
            builder.setCancelable(true);
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(false);
        }
        this.j.show();
        return this.j;
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
        } catch (ActivityNotFoundException e2) {
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
    public void a(com.baidu.tieba.data.am amVar) {
        boolean z = false;
        if (amVar.l() != null && amVar.l().equals(this.x.q())) {
            z = true;
        }
        MarkData b = this.x.b(amVar);
        if (b != null && b(11009)) {
            this.y.a(b);
            this.D.u();
            if (!z) {
                this.y.d();
            } else {
                this.y.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.x == null || this.x.r() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ai r = this.x.r();
        com.baidu.tbadk.widget.richText.a a = a(r.d(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.am> d = r.d();
            int size = d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(d.get(i2).k(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.am> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a p = arrayList.get(i2).p();
            if (p != null && (a = p.a()) != null) {
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
                continue;
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
            sb.append(com.baidu.tbadk.core.util.bm.d(c.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.I = str;
            if (this.i == null) {
                u();
            }
            com.baidu.tbadk.core.f.a(this, "pb_show_phonedialog");
            if (str2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                this.i.c(1).setVisibility(8);
            } else {
                this.i.c(1).setVisibility(0);
            }
            this.i.b();
        }
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public VoiceManager d() {
        return this.g;
    }

    @Override // com.baidu.tbadk.core.voice.aa
    public com.baidu.tbadk.core.voice.y a(VoiceData.VoiceModel voiceModel) {
        View af;
        View findViewWithTag;
        if (!this.D.E() || (af = this.D.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.y) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.g != null) {
            this.g.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        if (this.x.A()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ai r = this.x.r();
            String name = r.b().getName();
            String r2 = r.c().r();
            String str = "http://tieba.baidu.com/p/" + this.x.g() + "?share=9105&fr=share";
            String[] a = r.a(this);
            String str2 = a[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.y.share_content_tpl), r2, name, a[1]);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.a = r2;
            hVar.b = format;
            hVar.c = str;
            if (parse != null) {
                hVar.d = parse;
            }
            this.d = new com.baidu.tbadk.coreExtra.share.d(this);
            this.d.a(hVar, true);
            this.d.a(F());
            this.d.b(true);
            this.d.a(new aq(this, hVar));
            this.d.a((String) null, (Drawable) null, new ar(this));
            this.d.a();
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

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> j() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.data.ai r = this.x.r();
        if (r != null) {
            boolean isIfAddition = r.f().isIfAddition();
            AdditionData m = r.m();
            boolean z3 = m == null ? false : isIfAddition;
            if (z3) {
                z = m.getAlreadyCount() != m.getTotalCount();
                if (!TextUtils.isEmpty(m.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            bt btVar = this.D;
            if (!z3 || !z) {
                z2 = false;
            }
            btVar.j(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.D.d() == view) {
            com.baidu.tbadk.core.data.m c = this.x.r().c();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = c.o() == null || c.o().getIsLike() == 0;
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
            new Handler().postDelayed(new at(this), 200L);
        }
    }

    private void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale3));
            new Handler().postDelayed(new au(this), 600L);
        }
    }

    private void b(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.p.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return a();
    }
}
