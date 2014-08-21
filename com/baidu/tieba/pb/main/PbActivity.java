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
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.pb.history.RequestPbHistoryWriteMessage;
import com.baidu.tieba.util.AntiHelper;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class PbActivity extends BaseActivity implements View.OnTouchListener, com.baidu.tbadk.core.view.ab, com.baidu.tbadk.core.voice.aa, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.util.n {
    private static final String e = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/135_1";
    private static String i = "tbgametype";
    private String J;
    private String K;
    private VoiceManager g;
    private AlertDialog k;
    private String p;
    private boolean f = false;
    private int h = 0;
    private com.baidu.tbadk.core.dialog.e j = null;
    SparseArray<String> a = null;
    private long l = -1;
    private WriteImagesInfo m = new WriteImagesInfo();
    private WriteImagesInfo n = new WriteImagesInfo();
    private WriteData o = new WriteData();
    private String q = null;
    private final com.baidu.adp.lib.d.b<TextView> r = TbRichTextView.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> s = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<ImageView> t = new com.baidu.adp.lib.d.b<>(new b(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> u = new com.baidu.adp.lib.d.b<>(new m(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> v = new com.baidu.adp.lib.d.b<>(new x(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> w = new com.baidu.adp.lib.d.b<>(new ai(this), 20, 0);
    private final Handler x = new Handler(new at(this));
    private bl y = null;
    private com.baidu.tieba.model.ai z = null;
    private com.baidu.tieba.model.ar A = null;
    private com.baidu.tieba.model.ac B = null;
    private com.baidu.tieba.pb.sub.e C = null;
    private com.baidu.tieba.model.u D = null;
    private bs E = null;
    private boolean F = false;
    private boolean G = false;
    private com.baidu.tbadk.core.view.n H = null;
    private br I = null;
    private com.baidu.adp.framework.listener.a L = new ay(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
    private boolean M = false;
    private boolean N = false;
    private dt O = new dt(new ba(this));
    private long P = 0;
    private boolean Q = true;
    private final View.OnClickListener R = new bb(this);
    private final bn S = new c(this);
    private final com.baidu.tieba.model.ak T = new d(this);
    private final View.OnClickListener U = new e(this);
    private final View.OnClickListener V = new f(this);
    private final View.OnClickListener W = new g(this);
    private final AbsListView.OnScrollListener X = new h(this);
    private final AbsListView.OnScrollListener Y = new i(this);
    private final com.baidu.tieba.pb.sub.g Z = new j(this);
    private final com.baidu.tieba.model.as aa = new k(this);
    private final com.baidu.adp.base.h ab = new l(this);
    private final be ac = new n(this);
    private final com.baidu.adp.widget.ListView.d ad = new o(this);
    private final com.baidu.adp.widget.ListView.x ae = new p(this);
    private final com.baidu.adp.widget.ListView.z af = new q(this);
    private final DialogInterface.OnClickListener ag = new r(this);
    private final com.baidu.adp.base.h ah = new s(this);
    private AlertDialog ai = null;
    private final cu aj = new t(this);
    private int ak = 0;
    private final com.baidu.tbadk.widget.richText.s al = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.r am = new v(this);
    com.baidu.tieba.data.an c = null;
    private final DialogInterface.OnClickListener an = new w(this);
    private final View.OnLongClickListener ao = new y(this);
    private final com.baidu.tbadk.core.view.r ap = new z(this);
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
        com.baidu.tbadk.core.util.bg.a().a(new aa());
    }

    private void s() {
        this.E.I();
        this.E.g();
    }

    private void t() {
        this.E.J();
        this.E.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        com.baidu.tieba.data.aj r;
        com.baidu.tbadk.core.data.n d;
        if (!this.N && this.Q) {
            this.N = true;
            if (this.y != null && (r = this.y.r()) != null && (d = r.d()) != null) {
                int isLike = d.g() == null ? 0 : d.g().getIsLike();
                if (this.O != null) {
                    this.O.a(d.A(), d.h(), isLike, "pb");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.baidu.tbadk.core.data.n d;
        String sb;
        String sb2;
        if (this.y != null && this.y.r() != null && (d = this.y.r().d()) != null) {
            if (i2 == 1) {
                PraiseData g = d.g();
                AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
                if (currentAccountObj != null) {
                    MetaData metaData = new MetaData();
                    metaData.setName_show(currentAccountObj.getAccount());
                    metaData.setPortrait(currentAccountObj.getPortrait());
                    metaData.setUserId(currentAccountObj.getID());
                    if (g == null) {
                        PraiseData praiseData = new PraiseData();
                        praiseData.setIsLike(i2);
                        praiseData.setNum(1L);
                        praiseData.getUser().add(0, metaData);
                        d.a(praiseData);
                    } else {
                        d.g().getUser().add(0, metaData);
                        d.g().setNum(d.g().getNum() + 1);
                        d.g().setIsLike(i2);
                    }
                }
                if (d.g() != null) {
                    if (d.g().getNum() < 1) {
                        sb2 = getResources().getString(com.baidu.tieba.x.frs_item_praise_text);
                    } else {
                        sb2 = new StringBuilder(String.valueOf(d.g().getNum())).toString();
                    }
                    this.E.a(sb2, true);
                }
            } else if (d.g() != null) {
                d.g().setIsLike(i2);
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
                this.E.a(sb, false);
            }
            if (this.y.i()) {
                this.E.m().notifyDataSetChanged();
            } else {
                this.E.b(this.y.r());
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.y.b(bundle);
        if (this.y.o()) {
            this.C.b(bundle);
        }
        if (this.g != null) {
            this.g.onSaveInstanceState(this);
        }
        bundle.putSerializable("write_images", this.m);
        bundle.putString("photo_name", this.p);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.L);
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
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
        if (this.E != null) {
            this.E.ab();
        }
        if (!this.y.o()) {
            WriteData a2 = this.A.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.y.g());
                a2.setWriteImagesInfo(this.m);
            }
            a2.setContent(this.E.N());
            if (this.o != null && this.o.getIsBaobao()) {
                a2.setBaobaoContent(this.o.getBaobaoContent());
                a2.setBaobaoImagesInfo(this.n);
                a2.setIsBaobao(true);
            }
            com.baidu.tieba.util.m.b(this.y.g(), a2);
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
        NoNetworkView a = this.E.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.a(false);
        }
        if (this.g != null) {
            this.g.onResume(this);
        }
        this.E.h.u();
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.ba.c(writeData.getContent()) && com.baidu.tbadk.core.util.ba.c(this.E.N())) {
                this.E.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.m.size() == 0) {
                this.m.copyFrom(writeData.getWriteImagesInfo());
                this.E.a(this.m, true);
            }
            if (TbadkApplication.m252getInst().isBaobaoShouldOpen() && writeData.getIsBaobao() && writeData.getBaobaoImagesInfo() != null && writeData.getBaobaoImagesInfo().size() > 0) {
                this.n.copyFrom(writeData.getBaobaoImagesInfo());
                this.o.setIsBaobao(writeData.getIsBaobao());
                this.o.setBaobaoContent(writeData.getBaobaoContent());
                this.o.setBaobaoImagesInfo(this.n);
                this.E.a(this.n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.y != null && this.y.r() != null && this.y.r().c() != null && this.y.r().d() != null) {
            com.baidu.tbadk.distribute.a.a().a(this, "pb", this.y.r().c().getId(), com.baidu.adp.lib.e.c.a(this.y.r().d().h(), 0L));
        }
        if (this.g != null) {
            this.g.onStop(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.y.cancelLoadData();
        this.y.u();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.C.cancelLoadData();
        this.C.g();
        this.D.cancelLoadData();
        this.E.ac();
        super.onDestroy();
        if (this.g != null) {
            this.g.onDestory(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.E.a(i2);
        this.H.a(this, i2, getResources().getDrawable(com.baidu.tieba.t.bg_collect), getResources().getDrawable(com.baidu.tieba.t.bg_collect_1));
        if (this.E.a() != null) {
            this.E.a().a(i2);
        }
    }

    private void v() {
        this.E = new bs(this, this.R);
        this.I = new br(this, this.R);
        this.H = new com.baidu.tbadk.core.view.n(this, this.I.b(), getResources().getDrawable(com.baidu.tieba.t.bg_collect), null);
        this.E.a(new ab(this));
        this.E.a(this.X);
        this.E.b(this.Y);
        this.E.a(this.U);
        this.E.b(this.V);
        this.E.c(this.W);
        this.E.a(this.ae);
        this.E.a(this.af);
        this.E.a(this.ag);
        this.E.a(this.ad);
        this.E.g(com.baidu.tbadk.core.h.a().f());
        this.E.h(com.baidu.tbadk.core.h.a().d());
        this.E.a(this.al);
        this.E.a(this.am);
        this.E.a(this.ao);
        this.E.a(this.aj);
        this.E.a(this.ap);
        this.E.a(this.ac);
    }

    private void w() {
        if (this.j == null) {
            this.j = new com.baidu.tbadk.core.dialog.e(this);
            this.j.a(new Object[]{getString(com.baidu.tieba.x.call_phone), getString(com.baidu.tieba.x.sms_phone), getString(com.baidu.tieba.x.search_in_baidu)}, new ac(this)).a(com.baidu.tbadk.core.dialog.g.a).b(80).a();
        }
    }

    private void a(Bundle bundle) {
        this.y = new bl(this);
        this.y.a(this.S);
        this.z = new com.baidu.tieba.model.ai();
        this.z.a(this.T);
        this.A = new com.baidu.tieba.model.ar();
        this.A.a(this.aa);
        this.B = new com.baidu.tieba.model.ac();
        this.B.setLoadDataCallBack(this.ah);
        this.C = new com.baidu.tieba.pb.sub.e(this);
        this.C.a(this.Z);
        this.D = new com.baidu.tieba.model.u();
        this.D.setLoadDataCallBack(this.ab);
        if (bundle != null) {
            this.y.a(bundle);
        } else {
            this.y.a(getIntent());
        }
        if (getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.REQUEST_CODE, -1) == 18003) {
            this.y.d(true);
        }
        bp.a().a(this.y.e(), this.y.k());
        if (!this.y.o()) {
            this.E.u();
            this.y.v();
        } else {
            if (bundle != null) {
                this.C.a(bundle);
            } else {
                this.C.a(getIntent());
            }
            this.K = this.C.b();
            String c = this.C.c();
            if (c != null && (("mention".equals(this.C.c()) || c.equals("person_post_reply")) && this.K != null)) {
                this.E.H();
            } else {
                this.E.B();
            }
            this.C.m();
        }
        this.E.a(new ad(this));
        if (bundle != null) {
            this.m = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.p = bundle.getString("photo_name");
        }
        this.m.setMaxImagesAllowed(10);
        if (!this.y.o()) {
            com.baidu.tieba.util.m.a(this.y.g(), this);
        }
        this.O.setUniqueId(getUniqueId());
        this.O.a();
    }

    public void k() {
        this.E.a(this.y.i(), this.z.a());
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
        if (this.y != null && (r = this.y.r()) != null && r.c() != null) {
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
        if (this.E.a() != null) {
            this.E.a().a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.y.o()) {
                antiData.setBlock_forum_name(this.y.r().c().getName());
                antiData.setBlock_forum_id(this.y.r().c().getId());
                antiData.setUser_name(this.y.r().h().getUserName());
                antiData.setUser_id(this.y.r().h().getUserId());
            } else {
                antiData.setBlock_forum_name(this.C.e().i().getName());
                antiData.setBlock_forum_id(this.C.e().i().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.E.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.w wVar) {
        int i2 = 0;
        if (wVar != null) {
            this.E.a(0, wVar.a, wVar.b, true);
            if (wVar.a) {
                if (wVar.c == 1) {
                    ArrayList<com.baidu.tieba.data.an> e2 = this.y.r().e();
                    int size = e2.size();
                    while (true) {
                        if (i2 < size) {
                            if (!wVar.d.equals(e2.get(i2).d())) {
                                i2++;
                            } else {
                                e2.remove(i2);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.E.a(this.y.r());
                } else if (wVar.c == 0) {
                    x();
                } else if (wVar.c == 2) {
                    ArrayList<com.baidu.tieba.data.an> e3 = this.y.r().e();
                    int size2 = e3.size();
                    boolean z = false;
                    for (int i3 = 0; i3 < size2 && !z; i3++) {
                        int i4 = 0;
                        while (true) {
                            if (i4 < e3.get(i3).n_().size()) {
                                if (!wVar.d.equals(e3.get(i3).n_().get(i4).d())) {
                                    i4++;
                                } else {
                                    e3.get(i3).n_().remove(i4);
                                    e3.get(i3).b();
                                    z = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        AdditionData n = this.y.r().n();
                        com.baidu.tieba.data.an anVar = e3.get(i3);
                        ArrayList<com.baidu.tieba.data.an> c = anVar.c();
                        int size3 = c.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 < size3) {
                                if (!wVar.d.equals(e3.get(i3).c().get(i5).d())) {
                                    i5++;
                                } else {
                                    c.remove(i5);
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
                        this.E.a(this.y.r());
                    }
                    if (this.E.E()) {
                        this.C.c(wVar.d);
                        this.E.a(this.C.e(), this.y.r().l());
                        if (!z) {
                            String b = this.C.b();
                            while (i2 < size2) {
                                if (!b.equals(e3.get(i2).d())) {
                                    i2++;
                                } else {
                                    e3.get(i2).b();
                                    this.E.a(this.y.r());
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
        this.E.a(1, yVar.a, yVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.aa aaVar) {
        this.E.a(this.D.getLoadDataMode(), aaVar.a, aaVar.b, false);
        this.E.a(aaVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, com.baidu.tieba.model.aa aaVar) {
        if (aaVar != null) {
            this.E.a(this.D.getLoadDataMode(), aaVar.a, aaVar.b, true);
            if (aaVar.a) {
                this.G = true;
                if (i2 == 2) {
                    this.y.r().d().c(1);
                    this.y.a(1);
                } else if (i2 == 3) {
                    this.y.r().d().c(0);
                    this.y.a(0);
                } else if (i2 == 4) {
                    this.y.r().d().b(1);
                    this.y.b(1);
                } else if (i2 == 5) {
                    this.y.r().d().b(0);
                    this.y.b(0);
                }
                this.E.a(this.y.r(), this.y.i(), true);
            }
        }
    }

    private void x() {
        if (this.y.j()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.y.g());
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
        this.E.ad();
        if (this.y != null && this.y.r() != null) {
            RequestPbHistoryWriteMessage requestPbHistoryWriteMessage = new RequestPbHistoryWriteMessage();
            com.baidu.tieba.data.ak akVar = new com.baidu.tieba.data.ak();
            akVar.a(this.y.r().d().h());
            akVar.c(this.y.r().c().getName());
            akVar.b(this.y.r().d().j());
            ArrayList<com.baidu.tieba.data.an> e2 = this.y.r().e();
            int L = this.E.L();
            if (e2 != null && L >= 0 && L < e2.size()) {
                akVar.d(e2.get(L).d());
            }
            akVar.a(this.y.h());
            akVar.b(this.y.i());
            requestPbHistoryWriteMessage.setData(akVar);
            MessageManager.getInstance().sendMessage(requestPbHistoryWriteMessage);
        }
        if (this.y != null && this.y.j()) {
            Intent intent = new Intent();
            if (this.G) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.y.g());
                intent.putExtra("top_data", this.y.n());
                intent.putExtra("good_data", this.y.l());
            }
            if (this.M) {
                intent.putExtra("praise_changed", true);
                intent.putExtra("praise_changed_tid", this.y.g());
                PraiseData g = this.y.r().d().g();
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
            if (this.y != null && this.E != null && this.E.S() != null) {
                com.baidu.tieba.data.aj r = this.y.r();
                if (r != null && r.h() != null) {
                    r.h().setBimg_url(TbadkApplication.m252getInst().getDefaultBubble());
                }
                bp.a().a(this.y.r(), this.E.S().onSaveInstanceState(), this.y.i(), this.y.h());
            } else {
                bp.a().f();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        switch (i2) {
            case 4:
                if (this.H != null) {
                    com.baidu.adp.lib.e.e.a(this.H, this);
                }
                if (this.E.f(this.y.o())) {
                    G();
                    return true;
                }
                closeActivity();
                break;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(int i2) {
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.x.login_to_use), true, i2);
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        String format;
        int size;
        int size2;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            switch (i2) {
                case 11001:
                    b((String) null);
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
                    b(this.E.P());
                    return;
                case 12001:
                    c(intent);
                    if (this.m != null && this.m.size() - 1 > -1 && this.m.getChosedFiles() != null && (size2 = this.m.getChosedFiles().size()) >= 1 && size >= 0 && size < size2) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ch(this, 12012, this.m, size)));
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
                            this.E.K();
                            this.A.a(false);
                            return;
                        }
                        this.B.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    B();
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.E.b(a);
                        return;
                    }
                    return;
                case 12005:
                    B();
                    new Handler().postDelayed(new ae(this), 200L);
                    ArrayList<String> a2 = com.baidu.tieba.util.i.a(intent);
                    if (a2 != null) {
                        this.E.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.A.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.o.setIsBaobao(false);
                    this.o.setBaobaoContent(null);
                    this.n.clear();
                    this.A.a((WriteData) null);
                    this.A.a(false);
                    this.E.a(true);
                    if (this.E.E()) {
                        this.C.k();
                    } else {
                        if (this.y != null && this.y.t()) {
                            this.E.u();
                        }
                        if (this.y != null && this.y.g() != null && !this.y.o()) {
                            com.baidu.tieba.util.m.b(this.y.g(), (WriteData) null);
                        }
                    }
                    this.E.a(this.m, true);
                    return;
                case 12009:
                case 12010:
                    B();
                    if (i2 == 12010) {
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
                    AdditionData n = this.y.r().n();
                    int totalCount = n.getTotalCount();
                    int alreadyCount = n.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.x.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.x.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.j.a((Context) this, format);
                    bp.a().f();
                    this.x.postDelayed(new af(this), 1000L);
                    return;
                case 23003:
                    if (intent != null && this.y != null) {
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
        switch (i2) {
            case 12001:
                A();
                return;
            case 12002:
                if (intent != null && intent.hasExtra("last_album_id")) {
                    this.m.setLastAlbumId(intent.getStringExtra("last_album_id"));
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
        String[] a = this.y.r().a(this);
        com.baidu.tieba.data.an c = this.E.c();
        String str = "";
        if (c != null) {
            str = c.d();
            String d = c.d(this);
            if (!com.baidu.adp.lib.util.i.c(d)) {
                a[1] = d;
            }
        }
        String A = this.y.r().d().A();
        if (A != null && A.equals(str)) {
            str = "";
        }
        shareFromPBMsgData.setContent(a[1]);
        shareFromPBMsgData.setImageUrl(a[0]);
        shareFromPBMsgData.setForumName(this.y.r().c().getName());
        shareFromPBMsgData.setPostId(str);
        shareFromPBMsgData.setThreadId(this.y.r().d().h());
        shareFromPBMsgData.setTitle(this.y.r().d().j());
        return shareFromPBMsgData;
    }

    private void a(Intent intent) {
        a(z(), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, long j, String str, String str2) {
        if (this.y != null && this.y.r() != null && this.y.r().d() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(this.y.r().d().j());
            cw cwVar = new cw(this);
            cwVar.setData(shareFromPBMsgData);
            aVar.a(cwVar);
            aVar.a(com.baidu.tieba.x.share, new ag(this, j, str, str2, cwVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.x.alert_no_button, new ah(this, cwVar));
            aVar.a(false);
            aVar.a().c();
            if (!com.baidu.adp.lib.util.i.c(shareFromPBMsgData.getImageUrl())) {
                cwVar.a(shareFromPBMsgData.getImageUrl(), this.y.r().m() == 1);
            }
        }
    }

    private void a(ShareFromPBMsgData shareFromPBMsgData, int i2, String str, int i3) {
        if (this.y != null && this.y.r() != null && this.y.r().d() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
            aVar.a(this.y.r().d().j());
            cw cwVar = new cw(this);
            cwVar.setData(shareFromPBMsgData);
            aVar.a(cwVar);
            aVar.a(com.baidu.tieba.x.share, new aj(this, i2, str, i3, cwVar, shareFromPBMsgData));
            aVar.b(com.baidu.tieba.x.alert_no_button, new ak(this, cwVar));
            aVar.a(false);
            aVar.a().c();
            if (!com.baidu.adp.lib.util.i.c(shareFromPBMsgData.getImageUrl())) {
                cwVar.a(shareFromPBMsgData.getImageUrl(), this.y.r().m() == 1);
            }
        }
    }

    private void b(Intent intent) {
        a(intent, true);
    }

    private void c(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.p;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tbadk.core.util.d.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(str, com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.b(this)), com.baidu.adp.lib.util.j.a(this, com.baidu.adp.lib.util.j.c(this)));
                    Bitmap e2 = com.baidu.tbadk.core.util.d.e(a, b);
                    if (a != e2) {
                        a.recycle();
                    }
                    com.baidu.tbadk.core.util.s.a(TbConfig.LOCAL_CAMERA_DIR, this.p, e2, 100);
                    e2.recycle();
                }
            } catch (Exception e3) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.m.addChooseFile(imageFileInfo);
            this.m.updateQuality();
            this.E.a(this.m, true);
        }
        if (this.m.getChosedFiles() != null && this.m.getChosedFiles().size() > 0) {
            this.E.h.b(23);
        }
    }

    private void d(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.m.parseJson(stringExtra);
                this.m.updateQuality();
                if (this.m.getChosedFiles() != null) {
                    this.E.a(this.m, z);
                }
            }
            if (this.m.getChosedFiles() != null && this.m.getChosedFiles().size() > 0) {
                this.E.h.b(23);
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
                this.n.clear();
                this.n.addChooseFile(imageFileInfo);
                this.E.a(this.n);
                if (this.n.getChosedFiles() != null && this.n.getChosedFiles().size() > 0) {
                    this.E.h.b(50);
                    this.o.setIsBaobao(true);
                    this.o.setBaobaoContent(stringExtra2);
                    this.o.setBaobaoImagesInfo(this.n);
                    return;
                }
                this.o.setIsBaobao(false);
                this.o.setBaobaoContent("");
                this.o.setBaobaoImagesInfo(this.n);
            }
        }
    }

    private void A() {
        new al(this).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        if (this.ai == null) {
            String[] strArr = {getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.operation));
            builder.setItems(strArr, new am(this));
            this.ai = builder.create();
            this.ai.setCanceledOnTouchOutside(true);
        }
    }

    private void B() {
        if (this.F) {
            this.F = false;
            new Handler().postDelayed(new an(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        MarkData h = this.y.h(this.E.L());
        if (h != null) {
            this.E.u();
            this.z.a(h);
            if (!this.z.a()) {
                this.z.d();
                TiebaStatic.eventStat(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.z.e();
            TiebaStatic.eventStat(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        VoiceData.VoiceModel j;
        if (this.A.a() == null) {
            if (!this.y.o()) {
                this.A.a(this.y.a(str));
            } else {
                this.A.a(this.C.f());
            }
        }
        if (this.A.a() != null) {
            if (!this.y.o()) {
                this.A.a().setWriteImagesInfo(this.m);
                this.A.a(this.m.size() > 0);
                if (this.o.getIsBaobao()) {
                    this.A.a().setIsBaobao(true);
                    this.A.a().setBaobaoContent(this.o.getBaobaoContent());
                    this.A.a().setBaobaoImagesInfo(this.n);
                } else {
                    this.A.a().setIsBaobao(false);
                }
            }
            if (str == null) {
                this.A.a().setContent(this.E.N());
                j = this.E.e();
                this.E.f();
            } else {
                this.A.a().setContent(this.E.O());
                j = this.E.j();
                this.E.k();
            }
            if (j != null) {
                if (j.getId() != null) {
                    this.A.a().setVoice(j.getId());
                    this.A.a().setVoiceDuringTime(j.duration);
                } else {
                    this.A.a().setVoice(null);
                    this.A.a().setVoiceDuringTime(-1);
                }
            } else {
                this.A.a().setVoice(null);
                this.A.a().setVoiceDuringTime(-1);
            }
            if (!this.A.c()) {
                showToast(com.baidu.tieba.x.write_img_limit);
            } else if (this.A.b()) {
                this.E.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        com.baidu.tieba.data.aj r = this.y.r();
        this.y.c(true);
        r.a(this.z.c());
        this.E.a(r);
    }

    private boolean E() {
        if (this.y == null) {
            return true;
        }
        if (this.y.B()) {
            MarkData C = this.y.C();
            if (C == null || !this.y.k()) {
                return true;
            }
            MarkData h = this.y.h(this.E.L());
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
                aVar.a(com.baidu.tieba.x.alert_yes_btn, new ao(this, h, C));
                aVar.b(com.baidu.tieba.x.alert_no_button, new ap(this, C));
                aVar.a();
                aVar.c();
                return false;
            }
        } else if (this.y.r() == null || this.y.r().e() == null || this.y.r().e().size() <= 0 || !this.y.k()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.ab
    /* renamed from: n */
    public BdListView a() {
        if (this.E == null) {
            return null;
        }
        return this.E.S();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int e() {
        if (this.E == null) {
            return 0;
        }
        return this.E.T();
    }

    @Override // com.baidu.tbadk.core.view.ab
    public int c_() {
        if (this.E == null) {
            return 0;
        }
        return this.E.U();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> f() {
        return this.t;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> g() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> h() {
        return this.w;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> i() {
        return this.u;
    }

    @Override // com.baidu.tbadk.core.view.ab
    public com.baidu.adp.lib.d.b<TbImageView> c() {
        return this.s;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bh(this, str, null)));
    }

    public boolean a(String str) {
        Map<String, String> a;
        if (!TextUtils.isEmpty(str) && (a = com.baidu.tbadk.core.util.bg.a(com.baidu.tbadk.core.util.bg.b(str))) != null) {
            String str2 = a.get(i);
            return !TextUtils.isEmpty(str2) && str2.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void b(Context context, String str) {
        if (a(str)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.x(context, "", str, "", true)));
        } else {
            com.baidu.tbadk.core.util.bg.a().a(context, new String[]{str});
        }
    }

    private DialogInterface F() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.x.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.x.install), new aq(this));
            builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new ar(this));
            builder.setCancelable(true);
            this.k = builder.create();
            this.k.setCanceledOnTouchOutside(false);
        }
        com.baidu.adp.lib.e.e.a(this.k, this);
        return this.k;
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
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i2, int i3, ArrayList<String> arrayList) {
        int i4;
        int i5;
        if (aVar == aVar2) {
            this.b = true;
        }
        if (aVar != null) {
            int size = aVar.a().size();
            int i6 = -1;
            int i7 = 0;
            int i8 = i2;
            while (i7 < size) {
                if (aVar.a().get(i7) != null && aVar.a().get(i7).a() == 8) {
                    i6++;
                    int c = aVar.a().get(i7).c().c();
                    int b = aVar.a().get(i7).c().b();
                    if ((c < 80 || b < 80 || b * c < 10000) || !aVar.a().get(i7).c().d()) {
                        if (aVar == aVar2 && i6 <= i3) {
                            i5 = i8 - 1;
                            i4 = i6;
                        }
                    } else {
                        arrayList.add(a(aVar.a().get(i7)));
                        if (!this.b) {
                            i5 = i8 + 1;
                            i4 = i6;
                        }
                    }
                    i7++;
                    i8 = i5;
                    i6 = i4;
                }
                i4 = i6;
                i5 = i8;
                i7++;
                i8 = i5;
                i6 = i4;
            }
            return i8;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.an anVar) {
        if (anVar != null) {
            boolean z = false;
            if (anVar.d() != null && anVar.d().equals(this.y.q())) {
                z = true;
            }
            MarkData b = this.y.b(anVar);
            if (b != null && b(11009)) {
                this.E.u();
                this.z.a(b);
                if (!z) {
                    this.z.d();
                } else {
                    this.z.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i2) {
        if (this.y == null || this.y.r() == null || str == null || i2 < 0) {
            return null;
        }
        com.baidu.tieba.data.aj r = this.y.r();
        com.baidu.tbadk.widget.richText.a a = a(r.e(), str, i2);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.an> e2 = r.e();
            int size = e2.size();
            for (int i3 = 0; i3 < size; i3++) {
                a = a(e2.get(i3).c(), str, i2);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.an> arrayList, String str, int i2) {
        ArrayList<com.baidu.tbadk.widget.richText.c> a;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.baidu.tbadk.widget.richText.a h = arrayList.get(i3).h();
            if (h != null && (a = h.a()) != null) {
                int size = a.size();
                int i4 = -1;
                int i5 = 0;
                while (i5 < size) {
                    if (a.get(i5) != null && a.get(i5).a() == 8) {
                        i4++;
                        if (a.get(i5).c().f().equals(str)) {
                            int c = a.get(i5).c().c();
                            int b = a.get(i5).c().b();
                            if (c < 80 || b < 80 || b * c < 10000) {
                                return null;
                            }
                            this.ak = i5;
                            return h;
                        } else if (i4 <= i2) {
                        }
                    }
                    i5++;
                    i4 = i4;
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
            this.J = str;
            if (this.j == null) {
                w();
            }
            com.baidu.tbadk.core.f.a(this, "pb_show_phonedialog");
            if (str2.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT)) {
                this.j.c(1).setVisibility(8);
            } else {
                this.j.c(1).setVisibility(0);
            }
            this.j.b();
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
        if (!this.E.E() || (af = this.E.af()) == null || (findViewWithTag = af.findViewWithTag(voiceModel)) == null) {
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
        if (this.y.A()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.aj r = this.y.r();
            String name = r.c().getName();
            String j = r.d().j();
            String str = "http://tieba.baidu.com/p/" + this.y.g() + "?share=9105&fr=share";
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
            this.d.a(true);
            TextView b = this.d.b(com.baidu.tieba.x.share_tieba_qunzu, com.baidu.tieba.t.icon_unite_share_qunzu);
            this.d.a(b);
            TextView b2 = this.d.b(com.baidu.tieba.x.forum_friend, com.baidu.tieba.t.icon_unite_share_baf);
            this.d.a(b2);
            b2.setOnClickListener(new as(this));
            b.setOnClickListener(new au(this));
            this.d.a(new av(this, hVar));
            this.d.c();
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
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        boolean z;
        boolean z2 = true;
        com.baidu.tieba.data.aj r = this.y.r();
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
            bs bsVar = this.E;
            if (!z3 || !z) {
                z2 = false;
            }
            bsVar.j(z2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.E.d() == view) {
            com.baidu.tbadk.core.data.n d = this.y.r().d();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = d.g() == null || d.g().getIsLike() == 0;
                if (motionEvent.getAction() == 0) {
                    if (System.currentTimeMillis() - this.P > 1000) {
                        this.Q = true;
                        b(childAt);
                    } else {
                        this.Q = false;
                    }
                } else if (motionEvent.getAction() == 1) {
                    if (z) {
                        b(childAt, this.Q);
                    } else {
                        a(childAt, this.Q);
                    }
                } else if (motionEvent.getAction() == 2) {
                    a(childAt, this.Q);
                } else if (motionEvent.getAction() == 3) {
                    a(childAt, this.Q);
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
