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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.UserPhotoLayout;
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
import com.baidu.tieba.frs.dm;
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
    private String J;
    private String K;
    private AlertDialog ai;
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
    private final com.baidu.adp.lib.d.b<HeadImageView> s = UserPhotoLayout.a(this, 6);
    private final com.baidu.adp.lib.d.b<ImageView> t = new com.baidu.adp.lib.d.b<>(new c(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> u = new com.baidu.adp.lib.d.b<>(new n(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> v = new com.baidu.adp.lib.d.b<>(new y(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> w = new com.baidu.adp.lib.d.b<>(new aj(this), 20, 0);
    private final Handler x = new Handler(new ar(this));
    private bc y = null;
    private com.baidu.tieba.model.ai z = null;
    private com.baidu.tieba.model.ar A = null;
    private com.baidu.tieba.model.ac B = null;
    private com.baidu.tieba.pb.sub.f C = null;
    private com.baidu.tieba.model.v D = null;
    private bj E = null;
    private boolean F = false;
    private boolean G = false;
    private com.baidu.tbadk.core.view.i H = null;
    private bi I = null;
    private boolean L = false;
    private boolean M = false;
    private dm N = new dm(new at(this));
    private long O = 0;
    private boolean P = true;
    private final View.OnClickListener Q = new au(this);
    private final bd R = new aw(this);
    private final com.baidu.tieba.model.ak S = new d(this);
    private final View.OnClickListener T = new e(this);
    private final View.OnClickListener U = new f(this);
    private final View.OnClickListener V = new g(this);
    private int W = 0;
    private final AbsListView.OnScrollListener X = new h(this);
    private final AbsListView.OnScrollListener Y = new i(this);
    private final com.baidu.tieba.pb.sub.h Z = new j(this);
    private final com.baidu.tieba.model.as aa = new k(this);
    private final com.baidu.adp.base.g ab = new l(this);
    private final ay ac = new m(this);
    private final com.baidu.adp.widget.ListView.d ad = new o(this);
    private final com.baidu.adp.widget.ListView.u ae = new p(this);
    private final com.baidu.adp.widget.ListView.w af = new q(this);
    private final DialogInterface.OnClickListener ag = new r(this);
    private final com.baidu.adp.base.g ah = new s(this);
    private final cp aj = new t(this);
    private int ak = 0;
    private final com.baidu.tbadk.widget.richText.s al = new u(this);
    boolean b = false;
    private final com.baidu.tbadk.widget.richText.r am = new v(this);
    com.baidu.tieba.data.ah c = null;
    private final DialogInterface.OnClickListener an = new w(this);
    private final View.OnLongClickListener ao = new x(this);
    private final com.baidu.tbadk.core.view.m ap = new z(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2006001, new as());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        o();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        return TbadkApplication.m252getInst().isGpuOpen();
    }

    private static void o() {
        com.baidu.tbadk.core.util.bi.a().a(new aa());
    }

    private void p() {
        this.E.H();
        this.E.f();
    }

    private void q() {
        this.E.I();
        this.E.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (!this.M && this.P) {
            this.M = true;
            com.baidu.tieba.data.ae p = this.y.p();
            this.N.a(p.d().D(), p.d().k(), p.d().j().getIsLike(), "pb");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String sb;
        String sb2;
        com.baidu.tbadk.core.data.o d2 = this.y.p().d();
        if (i == 1) {
            PraiseData j = d2.j();
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (j == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    d2.a(praiseData);
                } else {
                    d2.j().getUser().add(0, metaData);
                    d2.j().setNum(d2.j().getNum() + 1);
                    d2.j().setIsLike(i);
                }
            }
            if (d2.j().getNum() < 1) {
                sb2 = getResources().getString(com.baidu.tieba.u.frs_item_praise_text);
            } else {
                sb2 = new StringBuilder(String.valueOf(d2.j().getNum())).toString();
            }
            this.E.a(sb2, true);
        } else {
            d2.j().setIsLike(i);
            d2.j().setNum(d2.j().getNum() - 1);
            ArrayList<MetaData> user = d2.j().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkApplication.getCurrentAccountObj().getID())) {
                        d2.j().getUser().remove(next);
                        break;
                    }
                }
            }
            if (d2.j().getNum() < 1) {
                sb = getResources().getString(com.baidu.tieba.u.frs_item_praise_text);
            } else {
                sb = new StringBuilder(String.valueOf(d2.j().getNum())).toString();
            }
            this.E.a(sb, false);
        }
        if (this.y.h()) {
            this.E.l().notifyDataSetChanged();
        } else {
            this.E.b(this.y.p());
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.y.b(bundle);
        if (this.y.m()) {
            this.C.b(bundle);
        }
        if (this.i != null) {
            this.i.e(this);
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
        s();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.e = true;
        super.onPause();
        ListView a = a();
        this.j = CompatibleUtile.getInstance().getViewLayer(a);
        if (this.j == 1) {
            CompatibleUtile.getInstance().noneViewGpu(a);
        }
        if (this.i != null) {
            this.i.d(this);
        }
        if (this.E != null) {
            this.E.aa();
        }
        if (!this.y.m()) {
            WriteData a2 = this.A.a();
            if (a2 == null) {
                a2 = new WriteData(1);
                a2.setThreadId(this.y.f());
                a2.setWriteImagesInfo(this.n);
            }
            a2.setContent(this.E.M());
            com.baidu.tieba.util.m.b(this.y.f(), a2);
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
        NoNetworkView a = this.E.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.i != null) {
            this.i.c(this);
        }
        this.E.j.t();
    }

    @Override // com.baidu.tieba.util.n
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tbadk.core.util.be.c(writeData.getContent()) && com.baidu.tbadk.core.util.be.c(this.E.M())) {
                this.E.c(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.n.size() == 0) {
                this.n.copyFrom(writeData.getWriteImagesInfo());
                this.E.a(this.n, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.i != null) {
            this.i.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.y.cancelLoadData();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.C.cancelLoadData();
        this.D.cancelLoadData();
        this.E.ab();
        super.onDestroy();
        if (this.i != null) {
            this.i.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.E.a(i);
        this.H.a(this, i, getResources().getDrawable(com.baidu.tieba.q.bg_collect), getResources().getDrawable(com.baidu.tieba.q.bg_collect_1));
        if (this.E.a() != null) {
            this.E.a().a(i);
        }
    }

    private void s() {
        this.E = new bj(this, this.Q);
        this.I = new bi(this, this.Q);
        this.H = new com.baidu.tbadk.core.view.i(this, this.I.b(), getResources().getDrawable(com.baidu.tieba.q.bg_collect), null);
        this.E.a(new ab(this));
        this.E.a(this.X);
        this.E.b(this.Y);
        this.E.a(this.T);
        this.E.b(this.U);
        this.E.c(this.V);
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
        t();
        m();
    }

    private void t() {
        this.k = new com.baidu.tbadk.core.dialog.d(this);
        this.k.a(new Object[]{getString(com.baidu.tieba.u.call_phone), getString(com.baidu.tieba.u.sms_phone), getString(com.baidu.tieba.u.search_in_baidu)}, new ac(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
    }

    private void a(Bundle bundle) {
        this.y = new bc(this);
        this.y.a(this.R);
        this.z = new com.baidu.tieba.model.ai();
        this.z.a(this.S);
        this.A = new com.baidu.tieba.model.ar();
        this.A.a(this.aa);
        this.B = new com.baidu.tieba.model.ac();
        this.B.setLoadDataCallBack(this.ah);
        this.C = new com.baidu.tieba.pb.sub.f(this);
        this.C.a(this.Z);
        this.D = new com.baidu.tieba.model.v();
        this.D.setLoadDataCallBack(this.ab);
        if (bundle != null) {
            this.y.a(bundle);
        } else {
            this.y.a(getIntent());
        }
        bg.a().a(this.y.e(), this.y.j());
        if (!this.y.m()) {
            this.y.s();
            this.E.t();
        } else {
            if (bundle != null) {
                this.C.a(bundle);
            } else {
                this.C.a(getIntent());
            }
            this.K = this.C.b();
            String c = this.C.c();
            if (c != null && (("mention".equals(this.C.c()) || c.equals("person_post_reply")) && this.K != null)) {
                this.E.G();
            } else {
                this.E.A();
            }
            this.C.j();
        }
        this.E.a(new ad(this));
        if (bundle != null) {
            this.n = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.o = bundle.getString("photo_name");
        }
        this.n.setMaxImagesAllowed(10);
        if (!this.y.m()) {
            com.baidu.tieba.util.m.a(this.y.f(), this);
        }
        this.N.setUniqueId(getUniqueId());
        this.N.a();
    }

    public void k() {
        this.E.a(this.y.h(), this.z.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.ah ahVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (ahVar = (com.baidu.tieba.data.ah) sparseArray.get(com.baidu.tieba.r.tag_clip_board)) != null) {
            a(ahVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.ae p;
        String str = null;
        if (this.y != null && (p = this.y.p()) != null && p.c() != null) {
            str = p.c().getName();
        }
        if (com.baidu.tieba.c.a.a(str, bool)) {
            q();
        } else {
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.c.a.a(str, bool)) {
            q();
        } else {
            p();
        }
    }

    public void l() {
        if (this.E.a() != null) {
            this.E.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.y.m()) {
                antiData.setBlock_forum_name(this.y.p().c().getName());
                antiData.setBlock_forum_id(this.y.p().c().getId());
                antiData.setUser_name(this.y.p().h().getUserName());
                antiData.setUser_id(this.y.p().h().getUserId());
            } else {
                antiData.setBlock_forum_name(this.C.e().h().getName());
                antiData.setBlock_forum_id(this.C.e().h().getId());
                antiData.setUser_name(TbadkApplication.getCurrentAccountName());
                antiData.setUser_id(TbadkApplication.getCurrentAccount());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.E.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.x xVar) {
        int i = 0;
        this.E.a(0, xVar.a, xVar.b, true);
        if (xVar.a) {
            if (xVar.c == 1) {
                ArrayList<com.baidu.tieba.data.ah> e = this.y.p().e();
                int size = e.size();
                while (true) {
                    if (i < size) {
                        if (!xVar.d.equals(e.get(i).d())) {
                            i++;
                        } else {
                            e.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.E.a(this.y.p());
            } else if (xVar.c == 0) {
                u();
            } else if (xVar.c == 2) {
                ArrayList<com.baidu.tieba.data.ah> e2 = this.y.p().e();
                int size2 = e2.size();
                boolean z = false;
                for (int i2 = 0; i2 < size2 && !z; i2++) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < e2.get(i2).a().size()) {
                            if (!xVar.d.equals(e2.get(i2).a().get(i3).d())) {
                                i3++;
                            } else {
                                e2.get(i2).a().remove(i3);
                                e2.get(i2).b();
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    AdditionData n = this.y.p().n();
                    com.baidu.tieba.data.ah ahVar = e2.get(i2);
                    ArrayList<com.baidu.tieba.data.ah> c = ahVar.c();
                    int size3 = c.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 < size3) {
                            if (!xVar.d.equals(e2.get(i2).c().get(i4).d())) {
                                i4++;
                            } else {
                                c.remove(i4);
                                n.decreaseAlreadyCount();
                                if (ahVar.n() > c.size()) {
                                    ahVar.c(c.size());
                                }
                                if (c.size() > 0) {
                                    com.baidu.tieba.data.ah ahVar2 = c.get(c.size() - 1);
                                    n.setLastAdditionTime(ahVar2.f() / 1000);
                                    com.baidu.tbadk.widget.richText.a h2 = ahVar2.h();
                                    String str = "";
                                    if (h2 != null) {
                                        str = h2.toString();
                                    }
                                    n.setLastAdditionContent(str);
                                } else {
                                    com.baidu.tbadk.widget.richText.a h3 = ahVar.h();
                                    String str2 = "";
                                    if (h3 != null) {
                                        str2 = h3.toString();
                                    }
                                    n.setLastAdditionContent(str2);
                                }
                                G();
                                z = true;
                            }
                        }
                    }
                }
                if (z) {
                    this.E.a(this.y.p());
                }
                if (this.E.D()) {
                    ArrayList<com.baidu.tieba.data.ah> c2 = this.C.e().c();
                    int size4 = c2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 < size4) {
                            if (!xVar.d.equals(c2.get(i5).d())) {
                                i5++;
                            } else {
                                c2.remove(i5);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    this.E.a(this.C.e(), this.y.p().l());
                    if (!z) {
                        String b = this.C.b();
                        while (i < size2) {
                            if (!b.equals(e2.get(i).d())) {
                                i++;
                            } else {
                                e2.get(i).b();
                                this.E.a(this.y.p());
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
        this.E.a(1, zVar.a, zVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.ab abVar) {
        this.E.a(this.D.getLoadDataMode(), abVar.a, abVar.b, false);
        this.E.a(abVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.ab abVar) {
        this.E.a(this.D.getLoadDataMode(), abVar.a, abVar.b, true);
        if (abVar.a) {
            this.G = true;
            if (i == 2) {
                this.y.p().d().d(1);
                this.y.a(1);
            } else if (i == 3) {
                this.y.p().d().d(0);
                this.y.a(0);
            } else if (i == 4) {
                this.y.p().d().c(1);
                this.y.b(1);
            } else if (i == 5) {
                this.y.p().d().c(0);
                this.y.b(0);
            }
            this.E.a(this.y.p(), this.y.h(), true);
        }
    }

    private void u() {
        if (this.y.i()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.y.f());
            setResult(-1, intent);
        }
        if (A()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        int isLike;
        if (this.N != null) {
            this.N.setLoadDataCallBack(null);
            this.N = null;
        }
        this.E.ac();
        if (this.y != null && this.y.i()) {
            Intent intent = new Intent();
            if (this.G) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.y.f());
                intent.putExtra("top_data", this.y.l());
                intent.putExtra("good_data", this.y.k());
            }
            if (this.L) {
                intent.putExtra("praise_changed", true);
                intent.putExtra("praise_changed_tid", this.y.f());
                PraiseData j = this.y.p().d().j();
                if (j == null) {
                    isLike = 0;
                } else {
                    isLike = j.getIsLike();
                }
                intent.putExtra("praise_like_num", isLike);
            }
            setResult(-1, intent);
        }
        if (A()) {
            if (this.y != null && this.E != null && this.E.R() != null) {
                com.baidu.tieba.data.ae p = this.y.p();
                if (p != null && p.h() != null) {
                    p.h().setBimg_url(TbadkApplication.m252getInst().getDefaultBubble());
                }
                bg.a().a(this.y.p(), this.E.R().onSaveInstanceState(), this.y.h(), this.y.g());
            } else {
                bg.a().f();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.H != null) {
                    this.H.dismiss();
                }
                if (this.E.f(this.y.m())) {
                    C();
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
            LoginActivity.a((Activity) this, getString(com.baidu.tieba.u.login_to_use), true, i);
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
                    y();
                    return;
                case LiveSenderControl.LiveSenderSampleRate.SAMPLINGRATE_11_025 /* 11025 */:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this, 12004, true)));
                    return;
                case 11026:
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.c(this, 12005, true)));
                    return;
                case 11027:
                    a(this.E.O());
                    return;
                case 12001:
                    b(intent);
                    int size2 = this.n.size() - 1;
                    if (size2 > -1 && this.n != null && this.n.getChosedFiles() != null && (size = this.n.getChosedFiles().size()) >= 1 && size2 >= 0 && size2 < size) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.bj(this, 12012, this.n, size2)));
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        x();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.E.J();
                            this.A.a(false);
                            return;
                        }
                        this.B.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    x();
                    ArrayList<String> a = com.baidu.tieba.util.i.a(intent);
                    if (a != null) {
                        this.E.b(a);
                        return;
                    }
                    return;
                case 12005:
                    x();
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
                    this.A.a((WriteData) null);
                    this.A.a(false);
                    this.E.a(true);
                    if (this.E.D()) {
                        this.C.i();
                    } else {
                        if (this.y.r()) {
                            this.E.t();
                        }
                        if (this.y != null && this.y.f() != null && !this.y.m()) {
                            com.baidu.tieba.util.m.b(this.y.f(), (WriteData) null);
                        }
                    }
                    this.E.a(this.n, true);
                    return;
                case 12009:
                case 12010:
                    x();
                    if (i == 12010) {
                        b(intent);
                        return;
                    }
                    return;
                case 12012:
                    c(intent);
                    return;
                case 13008:
                    AdditionData n = this.y.p().n();
                    int totalCount = n.getTotalCount();
                    int alreadyCount = n.getAlreadyCount() + 1;
                    if (totalCount != alreadyCount) {
                        format = String.format(getString(com.baidu.tieba.u.write_addition_success), Integer.valueOf(totalCount - alreadyCount));
                    } else {
                        format = String.format(getString(com.baidu.tieba.u.write_addition_success1), new Object[0]);
                    }
                    com.baidu.adp.lib.util.h.a((Context) this, format);
                    this.x.postDelayed(new af(this), 1000L);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                w();
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
                x();
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
                    Bitmap a = com.baidu.tbadk.core.util.g.a(str, com.baidu.adp.lib.util.h.a(this, com.baidu.adp.lib.util.h.b(this)), com.baidu.adp.lib.util.h.a(this, com.baidu.adp.lib.util.h.c(this)));
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
            this.E.a(this.n, true);
        }
        if (this.n.getChosedFiles() != null && this.n.getChosedFiles().size() > 0) {
            this.E.j.b(23);
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
                    this.E.a(this.n, z);
                }
            }
            if (this.n.getChosedFiles() != null && this.n.getChosedFiles().size() > 0) {
                this.E.j.b(23);
            }
        }
    }

    private void w() {
        new ag(this).execute(new Void[0]);
    }

    protected void m() {
        String[] strArr = {getString(com.baidu.tieba.u.take_photo), getString(com.baidu.tieba.u.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.u.operation));
        builder.setItems(strArr, new ah(this));
        if (this.ai == null) {
            this.ai = builder.create();
            this.ai.setCanceledOnTouchOutside(true);
        }
    }

    private void x() {
        if (this.F) {
            this.F = false;
            new Handler().postDelayed(new ai(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        MarkData f2 = this.y.f(this.E.K());
        if (f2 != null) {
            this.E.t();
            this.z.a(f2);
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
    public void a(String str) {
        VoiceData.VoiceModel i;
        if (this.A.a() == null) {
            if (!this.y.m()) {
                WriteData a = this.y.a(str);
                a.setWriteImagesInfo(this.n);
                this.A.a(this.n.size() > 0);
                this.A.a(a);
            } else {
                this.A.a(this.C.f());
            }
        }
        if (this.A.a() != null) {
            if (str == null) {
                this.A.a().setContent(this.E.M());
                i = this.E.d();
                this.E.e();
            } else {
                this.A.a().setContent(this.E.N());
                i = this.E.i();
                this.E.j();
            }
            if (i != null) {
                if (i.getId() != null) {
                    this.A.a().setVoice(i.getId());
                    this.A.a().setVoiceDuringTime(i.duration);
                } else {
                    this.A.a().setVoice(null);
                    this.A.a().setVoiceDuringTime(-1);
                }
            } else {
                this.A.a().setVoice(null);
                this.A.a().setVoiceDuringTime(-1);
            }
            if (this.A.b()) {
                this.E.u();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        com.baidu.tieba.data.ae p = this.y.p();
        this.y.c(true);
        p.a(this.z.c());
        this.E.a(p);
    }

    private boolean A() {
        if (this.y == null) {
            return true;
        }
        if (this.y.x()) {
            MarkData y = this.y.y();
            if (y == null || !this.y.j()) {
                return true;
            }
            MarkData f2 = this.y.f(this.E.K());
            if (f2 == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", y);
                setResult(-1, intent);
                v();
                return true;
            } else if (f2.getPostId() == null || f2.getPostId().equals(y.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", y);
                setResult(-1, intent2);
                v();
                return true;
            } else {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
                aVar.a(String.format(getString(com.baidu.tieba.u.alert_update_mark), Integer.valueOf(f2.getFloor())));
                aVar.a(com.baidu.tieba.u.alert_yes_btn, new ak(this, f2, y));
                aVar.b(com.baidu.tieba.u.alert_no_button, new al(this, y));
                aVar.a();
                aVar.b();
                return false;
            }
        } else if (this.y.p() == null || this.y.p().e() == null || this.y.p().e().size() <= 0 || !this.y.j()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.view.w
    public ListView a() {
        if (this.E == null) {
            return null;
        }
        return this.E.R();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int e() {
        if (this.E == null) {
            return 0;
        }
        return this.E.S();
    }

    @Override // com.baidu.tbadk.core.view.w
    public int c_() {
        if (this.E == null) {
            return 0;
        }
        return this.E.T();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> f() {
        return this.t;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> g() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> h() {
        return this.w;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> i() {
        return this.u;
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

    private DialogInterface B() {
        if (this.l == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(com.baidu.tieba.u.download_baidu_video_dialog));
            builder.setPositiveButton(getString(com.baidu.tieba.u.install), new am(this));
            builder.setNegativeButton(getString(com.baidu.tieba.u.cancel), new an(this));
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
            B();
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
    public void a(com.baidu.tieba.data.ah ahVar) {
        boolean z = false;
        if (ahVar.d() != null && ahVar.d().equals(this.y.o())) {
            z = true;
        }
        MarkData b = this.y.b(ahVar);
        if (b != null && b(11009)) {
            this.z.a(b);
            this.E.t();
            if (!z) {
                this.z.d();
            } else {
                this.z.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.y == null || this.y.p() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.ae p = this.y.p();
        com.baidu.tbadk.widget.richText.a a = a(p.e(), str, i);
        if (a == null) {
            ArrayList<com.baidu.tieba.data.ah> e = p.e();
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                a = a(e.get(i2).c(), str, i);
                if (a != null) {
                    return a;
                }
            }
            return a;
        }
        return a;
    }

    private com.baidu.tbadk.widget.richText.a a(ArrayList<com.baidu.tieba.data.ah> arrayList, String str, int i) {
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
                        this.ak = i4;
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
            this.J = str;
            com.baidu.tbadk.core.g.a(this, "pb_show_phonedialog");
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
        View ag;
        View findViewWithTag;
        if (!this.E.D() || (ag = this.E.ag()) == null || (findViewWithTag = ag.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tbadk.core.voice.x) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.i != null) {
            this.i.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.y.w()) {
            TiebaStatic.eventStat(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.ae p = this.y.p();
            String name = p.c().getName();
            String m = p.d().m();
            String str = "http://tieba.baidu.com/p/" + this.y.f() + "?share=9105";
            String[] b = p.b();
            String str2 = b[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(com.baidu.tieba.u.share_content_tpl), m, name, b[1]);
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.a = m;
            fVar.b = format;
            fVar.c = str;
            if (parse != null) {
                fVar.d = parse;
            }
            com.baidu.tbadk.coreExtra.share.d dVar = new com.baidu.tbadk.coreExtra.share.d(this);
            dVar.a(fVar, true);
            dVar.a(E());
            dVar.a(F(), new ao(this, str));
            dVar.a();
        }
    }

    private SparseArray<String> E() {
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

    private View F() {
        TextView textView = (TextView) getLayoutInflater().inflate(com.baidu.tieba.s.btn_copy_pb_url, (ViewGroup) null);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            textView.setBackgroundResource(com.baidu.tieba.q.btn_blue_square_1);
            textView.setTextColor(getResources().getColor(com.baidu.tieba.o.share_copy_pb_url_1));
        } else {
            textView.setBackgroundResource(com.baidu.tieba.q.btn_blue_square);
            textView.setTextColor(getResources().getColor(com.baidu.tieba.o.share_copy_pb_url));
        }
        return textView;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<LinearLayout> j() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.baidu.tieba.data.ae p = this.y.p();
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
            this.E.b(isIfAddition, r0);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.E.c() == view) {
            com.baidu.tbadk.core.data.o d2 = this.y.p().d();
            View childAt = ((ViewGroup) view).getChildAt(0);
            if (childAt != null) {
                boolean z = d2.j() == null || d2.j().getIsLike() == 0;
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
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.l.praise_animation_scale2));
            new Handler().postDelayed(new ap(this), 200L);
        }
    }

    private void b(View view, boolean z) {
        if (z) {
            view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.l.praise_animation_scale3));
            new Handler().postDelayed(new aq(this), 600L);
        }
    }

    private void b(View view) {
        view.setAnimation(AnimationUtils.loadAnimation(this, com.baidu.tieba.l.praise_animation_scale1));
    }
}
