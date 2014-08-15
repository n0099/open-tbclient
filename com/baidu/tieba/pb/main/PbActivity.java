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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.frs.dr;
import com.baidu.tieba.pb.history.RequestPbHistoryWriteMessage;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity implements View.OnTouchListener, com.baidu.tbadk.core.view.aa, com.baidu.tbadk.core.voice.aa, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.n {
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
    private final com.baidu.adp.lib.d.b<ImageView> s = new com.baidu.adp.lib.d.b<>(new b(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> t = new com.baidu.adp.lib.d.b<>(new m(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> u = new com.baidu.adp.lib.d.b<>(new x(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> v = new com.baidu.adp.lib.d.b<>(new ai(this), 20, 0);
    private final Handler w = new Handler(new at(this));
    private bl x = null;
    private com.baidu.tieba.model.ai y = null;
    private com.baidu.tieba.model.ar z = null;
    private com.baidu.tieba.model.ac A = null;
    private com.baidu.tieba.pb.sub.e B = null;
    private com.baidu.tieba.model.u C = null;
    private bs D = null;
    private boolean E = false;
    private boolean F = false;
    private com.baidu.tbadk.core.view.m G = null;
    private br H = null;
    private com.baidu.adp.framework.listener.a K = new ay(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
    private boolean L = false;
    private boolean M = false;
    private dr N = new dr(new ba(this));
    private long O = 0;
    private boolean P = true;
    private final View.OnClickListener Q = new bb(this);
    private final bn R = new c(this);
    private final com.baidu.tieba.model.ak S = new d(this);
    private final View.OnClickListener T = new e(this);
    private final View.OnClickListener U = new f(this);
    private final View.OnClickListener V = new g(this);
    private final AbsListView.OnScrollListener W = new h(this);
    private final AbsListView.OnScrollListener X = new i(this);
    private final com.baidu.tieba.pb.sub.g Y = new j(this);
    private final com.baidu.tieba.model.as Z = new k(this);
    private final com.baidu.adp.base.h aa = new l(this);
    private final be ab = new n(this);
    private final com.baidu.adp.widget.ListView.d ac = new o(this);
    private final com.baidu.adp.widget.ListView.x ad = new p(this);
    private final com.baidu.adp.widget.ListView.z ae = new q(this);
    private final DialogInterface.OnClickListener af = new r(this);
    private final com.baidu.adp.base.h ag = new s(this);
    private AlertDialog ah = null;
    private final cu ai = new t(this);
    private int aj = 0;
    private final com.baidu.tbadk.widget.richText.s ak = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.r al = new v(this);
    com.baidu.tieba.data.an c = null;
    private final DialogInterface.OnClickListener am = new w(this);
    private final View.OnLongClickListener an = new y(this);
    private final com.baidu.tbadk.core.view.q ao = new z(this);
    private View.OnClickListener ap = new aa(this);
    com.baidu.tbadk.coreExtra.share.d d = null;

    static {
        p();
        q();
        CustomMessageTask customMessageTask = new CustomMessageTask(2004001, new az());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        r();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void p() {
        com.baidu.tieba.ah.a(302001, pbPageSocketResponseMessage.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PAGE_HTTP_CMD, com.baidu.tieba.ah.a("c/f/pb/page", 302001));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(pbPageHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void q() {
        com.baidu.tieba.ah.a(2004003, cv.class);
    }

    private static void r() {
        com.baidu.tbadk.core.util.bg.a().a(new ab());
    }

    private void s() {
        this.D.I();
        this.D.g();
    }

    private void t() {
        this.D.J();
        this.D.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.baidu.tieba.data.aj r;
        com.baidu.tbadk.core.data.n d;
        if (!this.M && this.P) {
            this.M = true;
            if (this.x != null && (r = this.x.r()) != null && (d = r.d()) != null) {
                int isLike = d.g() == null ? 0 : d.g().getIsLike();
                if (this.N != null) {
                    this.N.a(d.A(), d.h(), isLike, "pb");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        com.baidu.tbadk.core.data.n d;
        String sb;
        String sb2;
        if (this.x != null && this.x.r() != null && (d = this.x.r().d()) != null) {
            if (i == 1) {
                PraiseData g = d.g();
                AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (g == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        d.a(praiseData);
                    } else {
                        d.g().getUser().add(0, metaData);
                        d.g().setNum(d.g().getNum() + 1);
                        d.g().setIsLike(i);
                    }
                }
                if (d.g() != null) {
                    if (d.g().getNum() < 1) {
                        sb2 = getResources().getString(com.baidu.tieba.x.frs_item_praise_text);
                    } else {
                        sb2 = new StringBuilder(String.valueOf(d.g().getNum())).toString();
                    }
                    this.D.a(sb2, true);
                }
            } else if (d.g() != null) {
                d.g().setIsLike(i);
                d.g().setNum(d.g().getNum() - 1);
                ArrayList<MetaData> user = d.g().getUser();
                if (user != null) {
                    Iterator<MetaData> it = user.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        MetaData next = it.next();
                        if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                            d.g().getUser().remove(next);
                            break;
                        }
                    }
                }
                if (d.g().getNum() < 1) {
                    sb = getResources().getString(com.baidu.tieba.x.frs_item_praise_text);
                } else {
                    sb = new StringBuilder(String.valueOf(d.g().getNum())).toString();
                }
                this.D.a(sb, false);
            }
            if (this.x.i()) {
                this.D.m().notifyDataSetChanged();
            } else {
                this.D.b(this.x.r());
            }
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
        registerListener(this.K);
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.k = System.currentTimeMillis();
        }
        this.h = 0;
        v();
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
            if (!com.baidu.tbadk.core.util.ba.c(writeData.getContent()) && com.baidu.tbadk.core.util.ba.c(this.D.N())) {
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
                this.n.setBaobaoImagesInfo(this.m);
                this.D.a(this.m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.x != null && this.x.r() != null && this.x.r().c() != null && this.x.r().d() != null) {
            com.baidu.tbadk.distribute.a.a().a(this, "pb", this.x.r().c().getId(), com.baidu.adp.lib.e.b.a(this.x.r().d().h(), 0L));
        }
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
        this.G.a(this, i, getResources().getDrawable(com.baidu.tieba.t.bg_collect), getResources().getDrawable(com.baidu.tieba.t.bg_collect_1));
        if (this.D.a() != null) {
            this.D.a().a(i);
        }
    }

    private void v() {
        this.D = new bs(this, this.Q);
        this.H = new br(this, this.Q);
        this.G = new com.baidu.tbadk.core.view.m(this, this.H.b(), getResources().getDrawable(com.baidu.tieba.t.bg_collect), null);
        this.D.a(new ac(this));
        this.D.a(this.W);
        this.D.b(this.X);
        this.D.a(this.T);
        this.D.b(this.U);
        this.D.c(this.V);
        this.D.a(this.ad);
        this.D.a(this.ae);
        this.D.a(this.af);
        this.D.a(this.ac);
        this.D.g(com.baidu.tbadk.core.h.a().f());
        this.D.h(com.baidu.tbadk.core.h.a().d());
        this.D.a(this.ak);
        this.D.a(this.al);
        this.D.a(this.an);
        this.D.a(this.ai);
        this.D.a(this.ao);
        this.D.a(this.ab);
    }

    private void w() {
        if (this.i == null) {
            this.i = new com.baidu.tbadk.core.dialog.e(this);
            this.i.a(new Object[]{getString(com.baidu.tieba.x.call_phone), getString(com.baidu.tieba.x.sms_phone), getString(com.baidu.tieba.x.search_in_baidu)}, new ad(this)).a(com.baidu.tbadk.core.dialog.g.a).b(80).a();
        }
    }

    private void a(Bundle bundle) {
        this.x = new bl(this);
        this.x.a(this.R);
        this.y = new com.baidu.tieba.model.ai();
        this.y.a(this.S);
        this.z = new com.baidu.tieba.model.ar();
        this.z.a(this.Z);
        this.A = new com.baidu.tieba.model.ac();
        this.A.setLoadDataCallBack(this.ag);
        this.B = new com.baidu.tieba.pb.sub.e(this);
        this.B.a(this.Y);
        this.C = new com.baidu.tieba.model.u();
        this.C.setLoadDataCallBack(this.aa);
        if (bundle != null) {
            this.x.a(bundle);
        } else {
            this.x.a(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.x.d(true);
        }
        bp.a().a(this.x.e(), this.x.k());
        if (!this.x.o()) {
            this.D.u();
            this.x.v();
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
            this.B.m();
        }
        this.D.a(new ae(this));
        if (bundle != null) {
            this.l = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.o = bundle.getString("photo_name");
        }
        this.l.setMaxImagesAllowed(10);
        if (!this.x.o()) {
            com.baidu.tieba.util.m.a(this.x.g(), this);
        }
        this.N.setUniqueId(getUniqueId());
        this.N.a();
    }

    public void k() {
        this.D.a(this.x.i(), this.y.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.an anVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (anVar = (com.baidu.tieba.data.an) sparseArray.get(com.baidu.tieba.u.tag_clip_board)) != null) {
            a(anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.aj r;
        String str = null;
        if (this.x != null && (r = this.x.r()) != null && r.c() != null) {
            str = r.c().getName();
        }
        if (com.baidu.tieba.e.b.a(str, bool)) {
            t();
        } else {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.e.b.a(str, bool)) {
            t();
        } else {
            s();
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
                antiData.setBlock_forum_name(this.x.r().c().getName());
                antiData.setBlock_forum_id(this.x.r().c().getId());
                antiData.setUser_name(this.x.r().h().getUserName());
                antiData.setUser_id(this.x.r().h().getUserId());
            } else {
                antiData.setBlock_forum_name(this.B.e().i().getName());
                antiData.setBlock_forum_id(this.B.e().i().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.D.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.w wVar) {
        int i = 0;
        if (wVar != null) {
            this.D.a(0, wVar.a, wVar.b, true);
            if (wVar.a) {
                if (wVar.c == 1) {
                    ArrayList<com.baidu.tieba.data.an> e2 = this.x.r().e();
                    int size = e2.size();
                    while (true) {
                        if (i < size) {
                            if (!wVar.d.equals(e2.get(i).d())) {
                                i++;
                            } else {
                                e2.remove(i);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.D.a(this.x.r());
                } else if (wVar.c == 0) {
                    x();
                } else if (wVar.c == 2) {
                    ArrayList<com.baidu.tieba.data.an> e3 = this.x.r().e();
                    int size2 = e3.size();
                    boolean z = false;
                    for (int i2 = 0; i2 < size2 && !z; i2++) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < e3.get(i2).n_().size()) {
                                if (!wVar.d.equals(e3.get(i2).n_().get(i3).d())) {
                                    i3++;
                                } else {
                                    e3.get(i2).n_().remove(i3);
                                    e3.get(i2).b();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData n = this.x.r().n();
                        com.baidu.tieba.data.an anVar = e3.get(i2);
                        ArrayList<com.baidu.tieba.data.an> c = anVar.c();
                        int size3 = c.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 < size3) {
                                if (!wVar.d.equals(e3.get(i2).c().get(i4).d())) {
                                    i4++;
                                } else {
                                    c.remove(i4);
                                    n.decreaseAlreadyCount();
                                    if (anVar.n() > c.size()) {
                                        anVar.c(c.size());
                                    }
                                    if (c.size() > 0) {
                                        com.baidu.tieba.data.an anVar2 = c.get(c.size() - 1);
                                        n.setLastAdditionTime(anVar2.o_() / 1000);
                                        com.baidu.tbadk.widget.richText.a h = anVar2.h();
                                        String str = "";
                                        if (h != null) {
                                            str = h.toString();
                                        }
                                        n.setLastAdditionContent(str);
                                    } else {
                                        com.baidu.tbadk.widget.richText.a h2 = anVar.h();
                                        String str2 = "";
                                        if (h2 != null) {
                                            str2 = h2.toString();
                                        }
                                        n.setLastAdditionContent(str2);
                                    }
                                    J();
                                    z = true;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.D.a(this.x.r());
                    }
                    if (this.D.E()) {
                        this.B.c(wVar.d);
                        this.D.a(this.B.e(), this.x.r().l());
                        if (!z) {
                            String b = this.B.b();
                            while (i < size2) {
                                if (!b.equals(e3.get(i).d())) {
                                    i++;
                                } else {
                                    e3.get(i).b();
                                    this.D.a(this.x.r());
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.y yVar) {
        this.D.a(1, yVar.a, yVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aa aaVar) {
        this.D.a(this.C.getLoadDataMode(), aaVar.a, aaVar.b, false);
        this.D.a(aaVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.aa aaVar) {
        if (aaVar != null) {
            this.D.a(this.C.getLoadDataMode(), aaVar.a, aaVar.b, true);
            if (aaVar.a) {
                this.F = true;
                if (i == 2) {
                    this.x.r().d().c(1);
                    this.x.a(1);
                } else if (i == 3) {
                    this.x.r().d().c(0);
                    this.x.a(0);
                } else if (i == 4) {
                    this.x.r().d().b(1);
                    this.x.b(1);
                } else if (i == 5) {
                    this.x.r().d().b(0);
                    this.x.b(0);
                }
                this.D.a(this.x.r(), this.x.i(), true);
            }
        }
    }

    private void x() {
        if (this.x.j()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.x.g());
            setResult(-1, intent);
        }
        if (E()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        int isLike;
        this.D.ad();
        if (this.x != null && this.x.r() != null) {
            RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = new RequestPbHistoryWriteMessage();
            com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
            akVar.a(this.x.r().d().h());
            akVar.c(this.x.r().c().getName());
            akVar.b(this.x.r().d().j());
            ArrayList<com.baidu.tieba.data.an> e2 = this.x.r().e();
            int L = this.D.L();
            if (e2 != null && L >= 0 && L < e2.size()) {
                akVar.d(e2.get(L).d());
            }
            akVar.a(this.x.h());
            akVar.b(this.x.i());
            requestPbHistoryWriteMessage.setData(akVar);
            MessageManager.getInstance().sendMessage(requestPbHistoryWriteMessage);
        }
        if (this.x != null && this.x.j()) {
            Intent intent = new Intent();
            if (this.F) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.x.g());
                intent.putExtra("top_data", this.x.n());
                intent.putExtra("good_data", this.x.l());
            }
            if (this.L) {
                intent.putExtra("praise_changed", true);
                intent.putExtra("praise_changed_tid", this.x.g());
                PraiseData g = this.x.r().d().g();
                if (g == null) {
                    isLike = 0;
                } else {
                    isLike = g.getIsLike();
                }
                intent.putExtra("praise_like_num", isLike);
            }
            setResult(-1, intent);
        }
        if (E()) {
            if (this.x != null && this.D != null && this.D.S() != null) {
                com.baidu.tieba.data.aj r = this.x.r();
                if (r != null && r.h() != null) {
                    r.h().setBimg_url(TbadkApplication.m252getInst().getDefaultBubble());
                }
                bp.a().a(this.x.r(), this.D.S().onSaveInstanceState(), this.x.i(), this.x.h());
            } else {
                bp.a().f();
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
                    G();
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
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, i);
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
                    C();
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
                    c(intent);
                    if (this.l != null && this.l.size() - 1 > -1 && this.l.getChosedFiles() != null && (size2 = this.l.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.cg(this, 12012, this.l, size)));
                        return;
                    }
                    return;
                case 12002:
                    b(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        B();
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
                    B();
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.D.b(a);
                        return;
                    }
                    return;
                case 12005:
                    B();
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
                    this.n.setIsBaobao(false);
                    this.n.setBaobaoContent(null);
                    this.m.clear();
                    this.z.a((WriteData) null);
                    this.z.a(false);
                    this.D.a(true);
                    if (this.D.E()) {
                        this.B.k();
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
                    B();
                    if (i == 12010) {
                        c(intent);
                        return;
                    }
                    return;
                case 12012:
                    d(intent);
                    return;
                case 12013:
                    e(intent);
                    return;
                case 13008:
                    AdditionData n = this.x.r().n();
                    int totalCount = n.getTotalCount();
                    int alreadyCount = n.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.x.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.x.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.j.a((Context) this, format);
                    bp.a().f();
                    this.w.postDelayed(new ag(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.x != null) {
                        a(z(), intent.getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0), intent.getStringExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME), intent.getIntExtra("group_author_id", 0));
                        return;
                    }
                    return;
                case 23004:
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                    return;
                case 23007:
                    a(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                A();
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
                B();
                return;
        }
    }

    private ShareFromPBMsgData z() {
        ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
        String[] a = this.x.r().a(this);
        com.baidu.tieba.data.an c = this.D.c();
        String str = "";
        if (c != null) {
            str = c.d();
            String d = c.d(this);
            if (!com.baidu.adp.lib.util.i.c(d)) {
                a[1] = d;
            }
        }
        String A = this.x.r().d().A();
        if (A != null && A.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(a[1]);
        shareFromPBMsgData.setImageUrl(a[0]);
        shareFromPBMsgData.setForumName(this.x.r().c().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.x.r().d().h());
        shareFromPBMsgData.setTitle(this.x.r().d().j());
        return shareFromPBMsgData;
    }

    private void a(Intent intent) {
        a(z(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.x != null && this.x.r() != null && this.x.r().d() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(this.x.r().d().j());
            cw cwVar = new cw(this);
            cwVar.setData(shareFromPBMsgData);
            aVar.a(cwVar);
            aVar.a(com.baidu.tieba.x.share, new ah(this, j, str, str2, cwVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.x.alert_no_button, new aj(this, cwVar));
            aVar.a(false);
            aVar.a().b();
            if (!com.baidu.adp.lib.util.i.c(shareFromPBMsgData.getImageUrl())) {
                cwVar.a(shareFromPBMsgData.getImageUrl(), this.x.r().m() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i, String str, int i2) {
        if (this.x != null && this.x.r() != null && this.x.r().d() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(this.x.r().d().j());
            cw cwVar = new cw(this);
            cwVar.setData(shareFromPBMsgData);
            aVar.a(cwVar);
            aVar.a(com.baidu.tieba.x.share, new ak(this, i, str, i2, cwVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.x.alert_no_button, new al(this, cwVar));
            aVar.a(false);
            aVar.a().b();
            if (!com.baidu.adp.lib.util.i.c(shareFromPBMsgData.getImageUrl())) {
                cwVar.a(shareFromPBMsgData.getImageUrl(), this.x.r().m() == 1);
            }
        }
    }

    private void b(Intent intent) {
        a(intent, true);
    }

    private void c(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.o;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.d.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e2 = com.baidu.tbadk.core.util.d.e(a, b);
                    if (a != e2) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.o, e2, 100);
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

    private void d(Intent intent) {
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

    private void e(Intent intent) {
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

    private void A() {
        new am(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.ah == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new an(this));
            this.ah = builder.create();
            this.ah.setCanceledOnTouchOutside(true);
        }
    }

    private void B() {
        if (this.E) {
            this.E = false;
            new Handler().postDelayed(new ao(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        MarkData h = this.x.h(this.D.L());
        if (h != null) {
            this.D.u();
            this.y.a(h);
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
                showToast(com.baidu.tieba.x.write_img_limit);
            } else if (this.z.b()) {
                this.D.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.baidu.tieba.data.aj r = this.x.r();
        this.x.c(true);
        r.a(this.y.c());
        this.D.a(r);
    }

    private boolean E() {
        if (this.x == null) {
            return true;
        }
        if (this.x.B()) {
            MarkData C = this.x.C();
            if (C == null || !this.x.k()) {
                return true;
            }
            MarkData h = this.x.h(this.D.L());
            if (h == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", C);
                setResult(-1, intent);
                y();
                return true;
            } else if (h.getPostId() == null || h.getPostId().equals(C.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", C);
                setResult(-1, intent2);
                y();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.b(String.format(getString(com.baidu.tieba.x.alert_update_mark), Integer.valueOf(h.getFloor())));
                aVar.a(com.baidu.tieba.x.alert_yes_btn, new ap(this, h, C));
                aVar.b(com.baidu.tieba.x.alert_no_button, new aq(this, C));
                aVar.a();
                aVar.b();
                return false;
            }
        } else if (this.x.r() == null || this.x.r().e() == null || this.x.r().e().size() <= 0 || !this.x.k()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.aa
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

    @Override // com.baidu.tbadk.core.view.aa
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

    @Override // com.baidu.tbadk.core.view.aa
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bg(this, str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        com.baidu.tbadk.core.util.bg.a().a(context, new String[]{str});
    }

    private DialogInterface F() {
        if (this.j == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.x.install), new ar(this));
            builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new as(this));
            builder.setCancelable(true);
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.e.d.a(this.j, this);
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
            F();
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
    public void a(com.baidu.tieba.data.an anVar) {
        if (anVar != null) {
            boolean z = false;
            if (anVar.d() != null && anVar.d().equals(this.x.q())) {
                z = true;
            }
            MarkData b = this.x.b(anVar);
            if (b != null && b(11009)) {
                this.D.u();
                this.y.a(b);
                if (!z) {
                    this.y.d();
                } else {
                    this.y.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.x == null || this.x.r() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.aj r = this.x.r();
        com.baidu.tbadk.widget.richText.a a = a(r.e(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.an> e2 = r.e();
            int size = e2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(e2.get(i2).c(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.an> arrayList, String str, int i) {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = arrayList.get(i2).h();
            if (h != null && (a = h.a()) != null) {
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
                            this.aj = i4;
                            return h;
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
        if (cVar == null) {
            return null;
        }
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
            sb.append(com.baidu.tbadk.core.util.ba.d(c.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.I = str;
            if (this.i == null) {
                w();
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
    public void G() {
        if (this.g != null) {
            this.g.stopPlay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        if (this.x.A()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.aj r = this.x.r();
            String name = r.c().getName();
            String j = r.d().j();
            String str = "http://tieba.baidu.com/p/" + this.x.g() + "?share=9105&fr=share";
            String[] a = r.a(this);
            String str2 = a[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.x.share_content_tpl), j, name, a[1]);
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.a = j;
            hVar.b = format;
            hVar.c = str;
            if (parse != null) {
                hVar.d = parse;
            }
            this.d = new com.baidu.tbadk.coreExtra.share.d(this);
            this.d.a(hVar, true);
            this.d.a(I());
            this.d.c(true);
            this.d.a(this.ap);
            this.d.b(new au(this, hVar));
            this.d.a((String) null, (Drawable) null, new av(this));
            this.d.a();
        }
    }

    private SparseArray<String> I() {
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
    public void J() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.data.aj r = this.x.r();
        if (r != null) {
            boolean isIfAddition = r.g().isIfAddition();
            AdditionData n = r.n();
            boolean z3 = n == null ? false : isIfAddition;
            if (z3) {
                z = n.getAlreadyCount() != n.getTotalCount();
                if (!TextUtils.isEmpty(n.getWarnMsg())) {
                    z = false;
                }
            } else {
                z = true;
            }
            bs bsVar = this.D;
            if (!z3 || !z) {
                z2 = false;
            }
            bsVar.j(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.D.d() == view) {
            com.baidu.tbadk.core.data.n d = this.x.r().d();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = d.g() == null || d.g().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.O > 1000) {
                        this.P = true;
                        b(childAt);
                    } else {
                        this.P = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        b(childAt, this.P);
                    } else {
                        a(childAt, this.P);
                    }
                } else if (motionEvent.getAction() == 2) {
                    a(childAt, this.P);
                } else if (motionEvent.getAction() == 3) {
                    a(childAt, this.P);
                }
            }
        }
        return false;
    }

    private void a(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.o.praise_animation_scale2));
            new Handler().postDelayed(new aw(this), 200L);
        }
    }

    private void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.o.praise_animation_scale3));
            new Handler().postDelayed(new ax(this), 600L);
        }
    }

    private void b(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.o.praise_animation_scale1));
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public BdListView onGetPreLoadListView() {
        return a();
    }
}
