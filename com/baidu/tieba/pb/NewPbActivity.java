package com.baidu.tieba.pb;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
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
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.img.WriteImagesInfo;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.NoNetworkView;
import com.baidu.tieba.view.UserIconBox;
import com.baidu.tieba.voice.VoiceManager;
import com.baidu.tieba.write.AtListActivity;
import com.baidu.tieba.write.WriteMultiImgsActivity;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"DefaultLocale"})
/* loaded from: classes.dex */
public class NewPbActivity extends com.baidu.tieba.f implements com.baidu.tbadk.widget.a, com.baidu.tbadk.widget.richText.j, com.baidu.tieba.view.df, com.baidu.tieba.voice.af, com.baidu.tieba.write.ag {
    private static final String c = String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/topic_page/135_1";
    private static final Pattern e = Pattern.compile("(/p/){1}\\d+");
    private static final Pattern f = Pattern.compile("[?|&]kz=[^&]+");
    private static final Pattern g = Pattern.compile("[?|&]kw=[^&]+");
    private String F;
    private String G;
    private AlertDialog Z;
    private VoiceManager h;
    private AlertDialog k;
    private String n;
    private boolean d = false;
    private int i = 0;
    private com.baidu.tieba.view.dialog.d j = null;
    SparseArray<String> a = null;
    private long l = -1;
    private WriteImagesInfo m = new WriteImagesInfo();
    private String o = null;
    private final com.baidu.adp.lib.d.b<TextView> p = TbRichTextView.a(this, 8);
    private final com.baidu.adp.lib.d.b<TbImageView> q = UserIconBox.a(this, 8);
    private final com.baidu.adp.lib.d.b<ImageView> r = new com.baidu.adp.lib.d.b<>(new al(this), 8, 0);
    private final com.baidu.adp.lib.d.b<View> s = new com.baidu.adp.lib.d.b<>(new aw(this), 8, 0);
    private final com.baidu.adp.lib.d.b<LinearLayout> t = new com.baidu.adp.lib.d.b<>(new bh(this), 15, 0);
    private final com.baidu.adp.lib.d.b<GifView> u = new com.baidu.adp.lib.d.b<>(new bs(this), 20, 0);
    private final Handler v = new Handler(new bv(this));
    private com.baidu.tieba.model.bb w = null;
    private com.baidu.tieba.model.av x = null;
    private com.baidu.tieba.model.bk y = null;
    private com.baidu.tieba.model.ap z = null;
    private com.baidu.tieba.model.be A = null;
    private com.baidu.tieba.model.s B = null;
    private cu C = null;
    private boolean D = false;
    private boolean E = false;
    private final View.OnClickListener H = new bw(this);
    private final com.baidu.tieba.model.bc I = new by(this);
    private final com.baidu.tieba.model.ax J = new bz(this);
    private final View.OnClickListener K = new ca(this);
    private final View.OnClickListener L = new am(this);
    private final View.OnClickListener M = new an(this);
    private int N = 0;
    private final AbsListView.OnScrollListener O = new ao(this);
    private final AbsListView.OnScrollListener P = new ap(this);
    private final com.baidu.tieba.model.bg Q = new aq(this);
    private final com.baidu.tieba.model.bl R = new ar(this);
    private final com.baidu.adp.a.g S = new as(this);
    private final cc T = new at(this);
    private final com.baidu.adp.widget.ListView.b U = new au(this);
    private final com.baidu.adp.widget.ListView.r V = new av(this);
    private final com.baidu.adp.widget.ListView.t W = new ax(this);
    private final DialogInterface.OnClickListener X = new ay(this);
    private final com.baidu.adp.a.g Y = new az(this);
    private final dy aa = new ba(this);
    private int ab = 0;
    private final com.baidu.tbadk.widget.richText.r ac = new bb(this);
    private final com.baidu.tbadk.widget.richText.q ad = new bc(this);
    private final com.baidu.tbadk.imageManager.d ae = new bd(this);
    com.baidu.tieba.data.aq b = null;
    private final DialogInterface.OnClickListener af = new be(this);
    private final View.OnLongClickListener ag = new bf(this);
    private final com.baidu.tieba.view.by ah = new bg(this);
    private final List<com.baidu.tbadk.widget.b> ai = new ArrayList();

    @Override // com.baidu.tieba.f
    public boolean getGpuSwitch() {
        return TiebaApplication.g().u();
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
            intent.putExtra("TibaStatic.StartTime", System.currentTimeMillis());
            activity.startActivityForResult(intent, i);
        }
    }

    private void n() {
        this.C.D();
        this.C.d();
    }

    private void o() {
        this.C.E();
        this.C.e();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.w.b(bundle);
        if (this.w.j()) {
            this.A.b(bundle);
        }
        if (this.h != null) {
            this.h.e(this);
        }
        bundle.putSerializable("write_images", this.m);
        bundle.putString("photo_name", this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.l = intent.getLongExtra("TibaStatic.StartTime", -1L);
        } else {
            this.l = System.currentTimeMillis();
        }
        this.i = 0;
        p();
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

    public cu b() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
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
        if (this.C != null) {
            this.C.W();
        }
        if (this.ai != null) {
            this.ai.clear();
        }
        if (!this.w.j()) {
            WriteData a = this.y.a();
            if (a == null) {
                a = new WriteData(1);
                a.setThreadId(this.w.c());
                a.setWriteImagesInfo(this.m);
            }
            a.setContent(this.C.I());
            com.baidu.tieba.write.af.b(this.w.c(), a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.d = false;
        super.onResume();
        if (this.i == 1) {
            CompatibleUtile.getInstance().closeViewGpu(c());
        }
        NoNetworkView a = this.C.a();
        if (a != null && a.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            a.setVisible(false);
        }
        if (this.h != null) {
            this.h.c(this);
        }
        this.C.ag();
    }

    @Override // com.baidu.tieba.write.ag
    public void a(WriteData writeData) {
        if (writeData != null) {
            if (!com.baidu.tieba.util.bs.c(writeData.getContent()) && com.baidu.tieba.util.bs.c(this.C.I())) {
                this.C.b(writeData.getContent());
            }
            if (writeData.getWriteImagesInfo() != null && this.m.size() == 0) {
                this.m.copyFrom(writeData.getWriteImagesInfo());
                this.C.a(this.m, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.f(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        this.w.cancelLoadData();
        this.y.cancelLoadData();
        this.z.cancelLoadData();
        this.A.cancelLoadData();
        this.B.cancelLoadData();
        this.C.X();
        super.onDestroy();
        if (this.h != null) {
            this.h.g(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.C.a(i);
        if (this.C.a() != null) {
            this.C.a().a(i);
        }
    }

    private void p() {
        this.C = new cu(this, this.H);
        this.C.a(new bi(this));
        this.C.a(this.O);
        this.C.b(this.P);
        this.C.a(this.K);
        this.C.b(this.L);
        this.C.c(this.M);
        this.C.a(this.V);
        this.C.a(this.W);
        this.C.a(this.X);
        this.C.a(this.U);
        this.C.g(com.baidu.tieba.h.a.a().f());
        this.C.h(com.baidu.tieba.h.a.a().d());
        this.C.a(this.ac);
        this.C.a(this.ad);
        this.C.a(this.ag);
        this.C.a(this.aa);
        this.C.a(this.ah);
        this.C.a(this.T);
        q();
        k();
    }

    private void q() {
        this.j = new com.baidu.tieba.view.dialog.d(this);
        this.j.a(new Object[]{getString(R.string.call_phone), getString(R.string.sms_phone), getString(R.string.search_in_baidu)}, new bj(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    private void a(Bundle bundle) {
        this.w = new com.baidu.tieba.model.bb(this);
        this.w.a(this.I);
        this.x = new com.baidu.tieba.model.av();
        this.x.a(this.J);
        this.y = new com.baidu.tieba.model.bk();
        this.y.a(this.R);
        this.z = new com.baidu.tieba.model.ap();
        this.z.setLoadDataCallBack(this.Y);
        this.A = new com.baidu.tieba.model.be(this);
        this.A.a(this.Q);
        this.B = new com.baidu.tieba.model.s();
        this.B.setLoadDataCallBack(this.S);
        if (bundle != null) {
            this.w.a(bundle);
        } else {
            this.w.a(getIntent());
        }
        cs.a().a(this.w.a(), this.w.g());
        if (!this.w.j()) {
            this.w.p();
            this.C.q();
        } else {
            if (bundle != null) {
                this.A.a(bundle);
            } else {
                this.A.a(getIntent());
            }
            this.G = this.A.b();
            String c2 = this.A.c();
            if (c2 != null && (("mention".equals(this.A.c()) || c2.equals("person_post_reply")) && this.G != null)) {
                this.C.C();
            } else {
                this.C.w();
            }
            this.A.j();
        }
        this.C.a(new bk(this));
        if (bundle != null) {
            this.m = (WriteImagesInfo) bundle.getSerializable("write_images");
            this.n = bundle.getString("photo_name");
        }
        this.m.setMaxImagesAllowed(10);
        if (!this.w.j()) {
            com.baidu.tieba.write.af.a(this.w.c(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        SparseArray sparseArray;
        com.baidu.tieba.data.aq aqVar;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (aqVar = (com.baidu.tieba.data.aq) sparseArray.get(R.id.tag_clip_board)) != null) {
            a(aqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Boolean bool) {
        com.baidu.tieba.data.am m;
        String str = null;
        if (this.w != null && (m = this.w.m()) != null && m.c() != null) {
            str = m.c().getName();
        }
        if (com.baidu.tieba.i.a.a(str, bool)) {
            o();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Boolean bool) {
        if (com.baidu.tieba.i.a.a(str, bool)) {
            o();
        } else {
            n();
        }
    }

    public void j() {
        if (this.C.a() != null) {
            this.C.a().setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, String str) {
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            if (!this.w.j()) {
                antiData.setBlock_forum_name(this.w.m().c().getName());
                antiData.setBlock_forum_id(this.w.m().c().getId());
                antiData.setUser_name(this.w.m().h().getUserName());
                antiData.setUser_id(this.w.m().h().getUserId());
            } else {
                antiData.setBlock_forum_name(this.A.e().h().getName());
                antiData.setBlock_forum_id(this.A.e().h().getId());
                antiData.setUser_name(TiebaApplication.F());
                antiData.setUser_id(TiebaApplication.A());
            }
            AntiHelper.a(this, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.PB);
            return;
        }
        this.C.c(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.u uVar) {
        boolean z;
        int i = 0;
        this.C.a(0, uVar.a, uVar.b, true);
        if (uVar.a) {
            if (uVar.c == 1) {
                ArrayList<com.baidu.tieba.data.aq> e2 = this.w.m().e();
                int size = e2.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (!uVar.d.equals(e2.get(i).d())) {
                        i++;
                    } else {
                        e2.remove(i);
                        break;
                    }
                }
                this.C.a(this.w.m());
            } else if (uVar.c == 0) {
                r();
            } else if (uVar.c == 2) {
                ArrayList<com.baidu.tieba.data.aq> e3 = this.w.m().e();
                int size2 = e3.size();
                int i2 = 0;
                boolean z2 = false;
                while (i2 < size2 && !z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= e3.get(i2).a().size()) {
                            z = z2;
                            break;
                        } else if (!uVar.d.equals(e3.get(i2).a().get(i3).d())) {
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
                    this.C.a(this.w.m());
                }
                if (this.C.z()) {
                    ArrayList<com.baidu.tieba.data.aq> c2 = this.A.e().c();
                    int size3 = c2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            break;
                        } else if (!uVar.d.equals(c2.get(i4).d())) {
                            i4++;
                        } else {
                            c2.remove(i4);
                            break;
                        }
                    }
                    this.C.a(this.A.e(), this.w.m().l());
                    if (!z2) {
                        String b = this.A.b();
                        while (i < size2) {
                            if (!b.equals(e3.get(i).d())) {
                                i++;
                            } else {
                                e3.get(i).c();
                                this.C.a(this.w.m());
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.w wVar) {
        this.C.a(1, wVar.a, wVar.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.y yVar) {
        this.C.a(this.B.getLoadDataMode(), yVar.a, yVar.b, false);
        this.C.a(yVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.baidu.tieba.model.y yVar) {
        this.C.a(this.B.getLoadDataMode(), yVar.a, yVar.b, true);
        if (yVar.a) {
            this.E = true;
            if (i == 2) {
                this.w.m().d().b(1);
                this.w.a(1);
            } else if (i == 3) {
                this.w.m().d().b(0);
                this.w.a(0);
            } else if (i == 4) {
                this.w.m().d().a(1);
                this.w.b(1);
            } else if (i == 5) {
                this.w.m().d().a(0);
                this.w.b(0);
            }
            this.C.a(this.w.m(), true);
        }
    }

    private void r() {
        if (this.w.f()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", this.w.c());
            setResult(-1, intent);
        }
        if (x()) {
            super.closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        super.closeActivity();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void closeActivity() {
        if (this.w.f()) {
            Intent intent = new Intent();
            if (this.E) {
                intent.putExtra("type", 2);
                intent.putExtra("tid", this.w.c());
                intent.putExtra("top_data", this.w.i());
                intent.putExtra("good_data", this.w.h());
            }
            setResult(-1, intent);
        }
        if (x()) {
            if (this.w != null && this.C != null && this.C.N() != null) {
                cs.a().a(this.w.m(), this.C.N().onSaveInstanceState(), this.w.e(), this.w.d());
            } else {
                cs.a().f();
            }
            super.closeActivity();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (this.C.f(this.w.j())) {
                    z();
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
                    v();
                    return;
                case 11025:
                    AtListActivity.a(this, 12004, true);
                    return;
                case 11026:
                    AtListActivity.a(this, 12005, true);
                    return;
                case 11027:
                    a(this.C.K());
                    return;
                case 12001:
                    b(intent);
                    int size = this.m.size() - 1;
                    if (size > -1) {
                        WriteMultiImgsActivity.a(this, 12012, this.m, size);
                        return;
                    }
                    return;
                case 12002:
                    a(intent);
                    return;
                case 12003:
                    if (intent != null) {
                        u();
                        if (intent.getBooleanExtra("delete", false)) {
                            this.C.F();
                            this.y.a(false);
                            return;
                        }
                        this.z.a(intent.getStringExtra("file_name"));
                        return;
                    }
                    return;
                case 12004:
                    u();
                    ArrayList<String> a = AtListActivity.a(intent);
                    if (a != null) {
                        this.C.b(a);
                        return;
                    }
                    return;
                case 12005:
                    u();
                    new Handler().postDelayed(new bl(this), 200L);
                    ArrayList<String> a2 = AtListActivity.a(intent);
                    if (a2 != null) {
                        this.C.c(a2);
                        return;
                    }
                    return;
                case 12006:
                    WriteData a3 = this.y.a();
                    if (a3 != null) {
                        a3.deleteUploadedTempImages();
                    }
                    this.y.a((WriteData) null);
                    this.y.a(false);
                    this.C.a(true);
                    if (this.C.z()) {
                        this.A.i();
                    } else {
                        if (this.w.o()) {
                            this.C.q();
                        }
                        if (this.w != null && this.w.c() != null && !this.w.j()) {
                            com.baidu.tieba.write.af.b(this.w.c(), (WriteData) null);
                        }
                    }
                    this.C.a(this.m, true);
                    return;
                case 12009:
                case 12010:
                    u();
                    if (i == 12010) {
                        b(intent);
                        return;
                    }
                    return;
                case 12012:
                    c(intent);
                    return;
                default:
                    return;
            }
        }
        switch (i) {
            case 12001:
                t();
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
                u();
                return;
        }
    }

    private void a(Intent intent) {
        a(intent, true);
    }

    private void b(Intent intent) {
        String str = Environment.getExternalStorageDirectory() + "/" + com.baidu.tieba.data.i.k() + "/cameras/" + this.n;
        if (!TextUtils.isEmpty(str)) {
            try {
                int b = com.baidu.tieba.util.n.b(str);
                if (b != 0) {
                    Bitmap a = com.baidu.tieba.util.n.a(str, BdUtilHelper.a(this, BdUtilHelper.b(this)), BdUtilHelper.a(this, BdUtilHelper.c(this)));
                    Bitmap e2 = com.baidu.tieba.util.n.e(a, b);
                    if (a != e2) {
                        a.recycle();
                    }
                    com.baidu.tieba.util.af.a("cameras", this.n, e2, 100);
                    e2.recycle();
                }
            } catch (Exception e3) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.m.addChooseFile(imageFileInfo);
            this.m.updateQuality();
            this.C.a(this.m, true);
        }
        if (this.m.getChosedFiles() != null && this.m.getChosedFiles().size() > 0) {
            this.C.f.b(23);
        }
    }

    private void c(Intent intent) {
        a(intent, false);
    }

    private void a(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.m.parseJson(stringExtra);
                this.m.updateQuality();
                if (this.m.getChosedFiles() != null) {
                    this.C.a(this.m, z);
                }
            }
            if (this.m.getChosedFiles() != null && this.m.getChosedFiles().size() > 0) {
                this.C.f.b(23);
            }
        }
    }

    private void t() {
        new bm(this).execute(new Void[0]);
    }

    protected void k() {
        String[] strArr = {getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new bn(this));
        if (this.Z == null) {
            this.Z = builder.create();
            this.Z.setCanceledOnTouchOutside(true);
        }
    }

    private void u() {
        if (this.D) {
            this.D = false;
            new Handler().postDelayed(new bo(this), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        MarkData f2 = this.w.f(this.C.G());
        if (f2 != null) {
            this.C.q();
            this.x.a(f2);
            if (!this.x.a()) {
                this.x.d();
                com.baidu.tieba.util.cb.a(this, "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.x.e();
            com.baidu.tieba.util.cb.a(this, "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        VoiceManager.VoiceModel f2;
        if (this.y.a() == null) {
            if (!this.w.j()) {
                WriteData a = this.w.a(str);
                a.setWriteImagesInfo(this.m);
                this.y.a(this.m.size() > 0);
                this.y.a(a);
            } else {
                this.y.a(this.A.f());
            }
        }
        if (this.y.a() != null) {
            if (str == null) {
                this.y.a().setContent(this.C.I());
                f2 = this.C.b();
                this.C.c();
            } else {
                this.y.a().setContent(this.C.J());
                f2 = this.C.f();
                this.C.g();
            }
            if (f2 != null) {
                if (f2.getId() != null) {
                    this.y.a().setVoice(f2.getId());
                    this.y.a().setVoiceDuringTime(f2.duration);
                } else {
                    this.y.a().setVoice(null);
                    this.y.a().setVoiceDuringTime(-1);
                }
            } else {
                this.y.a().setVoice(null);
                this.y.a().setVoiceDuringTime(-1);
            }
            if (this.y.b()) {
                this.C.r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.baidu.tieba.data.am m = this.w.m();
        this.w.c(true);
        m.a(this.x.c());
        this.C.a(m);
    }

    private boolean x() {
        if (this.w == null) {
            return true;
        }
        if (this.w.u()) {
            MarkData v = this.w.v();
            if (v == null || !this.w.g()) {
                return true;
            }
            MarkData f2 = this.w.f(this.C.G());
            if (f2 == null) {
                Intent intent = new Intent();
                intent.putExtra("mark", v);
                setResult(-1, intent);
                s();
                return true;
            } else if (f2.getPostId() == null || f2.getPostId().equals(v.getPostId())) {
                Intent intent2 = new Intent();
                intent2.putExtra("mark", v);
                setResult(-1, intent2);
                s();
                return true;
            } else {
                com.baidu.tieba.view.dialog.a aVar = new com.baidu.tieba.view.dialog.a(this);
                aVar.a(String.format(getString(R.string.alert_update_mark), Integer.valueOf(f2.getFloor())));
                aVar.a(R.string.alert_yes_btn, new bp(this, f2, v));
                aVar.b(R.string.alert_no_button, new bq(this, v));
                aVar.a();
                aVar.b();
                return false;
            }
        } else if (this.w.m() == null || this.w.m().e() == null || this.w.m().e().size() <= 0 || !this.w.g()) {
            return true;
        } else {
            setResult(1);
            return true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public ListView c() {
        if (this.C == null) {
            return null;
        }
        return this.C.N();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public int d() {
        if (this.C == null) {
            return 0;
        }
        return this.C.O();
    }

    @Override // com.baidu.tieba.view.df
    public int a() {
        if (this.C == null) {
            return 0;
        }
        return this.C.P();
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<ImageView> e() {
        return this.r;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<TextView> f() {
        return this.p;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<GifView> g() {
        return this.u;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public com.baidu.adp.lib.d.b<View> c_() {
        return this.s;
    }

    @Override // com.baidu.tieba.view.df
    public com.baidu.adp.lib.d.b<TbImageView> g_() {
        return this.q;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str) {
        com.baidu.tieba.person.cm.a(this, str, null);
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
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e2.toString());
                }
            }
            Matcher matcher2 = f.matcher(lowerCase);
            if (matcher2.find()) {
                try {
                    String group2 = matcher2.group();
                    a(this, group2.substring(group2.lastIndexOf("=") + 1), (String) null, (String) null);
                    return;
                } catch (Exception e3) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e3.toString());
                }
            }
            Matcher matcher3 = g.matcher(lowerCase);
            if (matcher3.find()) {
                try {
                    String group3 = matcher3.group();
                    FrsActivity.a(this, group3.substring(group3.lastIndexOf("=") + 1), "pb");
                    return;
                } catch (Exception e4) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "onClick", e4.toString());
                }
            }
        }
        UtilHelper.c(this, str);
    }

    private DialogInterface y() {
        if (this.k == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.download_baidu_video_dialog));
            builder.setPositiveButton(getString(R.string.install), new br(this));
            builder.setNegativeButton(getString(R.string.cancel), new bt(this));
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
        com.baidu.tieba.util.cb.a(this, "pb_video", "pbclick", 1, new Object[0]);
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
            y();
        }
        com.baidu.tieba.util.cb.a(this, "baidu_video", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void d(Context context, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        GifView gifView = (GifView) this.C.N().findViewWithTag(str);
        if (gifView != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (bVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(bVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.util.f.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        GifView gifView;
        com.baidu.tbadk.widget.richText.e tbRichTextEmotionINfo;
        View ae = this.C.ae();
        if (ae != null && (gifView = (GifView) ae.findViewWithTag(str)) != null && (tbRichTextEmotionINfo = gifView.getTbRichTextEmotionINfo()) != null) {
            if (bVar != null) {
                tbRichTextEmotionINfo.j = false;
            } else {
                tbRichTextEmotionINfo.j = true;
            }
            gifView.setGif(bVar);
            gifView.setIsLoading(false);
            gifView.setTag(null);
            com.baidu.adp.lib.util.f.e("NewPbActivity", "imageLoaded", "gif loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.data.aq aqVar) {
        boolean z = false;
        if (aqVar.d() != null && aqVar.d().equals(this.w.l())) {
            z = true;
        }
        MarkData b = this.w.b(aqVar);
        if (b != null && a(11009)) {
            this.x.a(b);
            this.C.q();
            if (!z) {
                this.x.d();
            } else {
                this.x.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a a(String str, int i) {
        if (this.w == null || this.w.m() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.data.am m = this.w.m();
        for (int i2 = 0; i2 < m.e().size(); i2++) {
            com.baidu.tbadk.widget.richText.a h = m.e().get(i2).h();
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
                        this.ab = i4;
                        return h;
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
        StringBuilder sb = new StringBuilder((int) SocialAPIErrorCodes.ERROR_AUTHORIZATION_CANCELED);
        com.baidu.tbadk.widget.richText.g c2 = cVar.c();
        if (c2 != null) {
            if (!com.baidu.adp.lib.util.m.a(c2.a())) {
                return c2.a();
            }
            if (c2.b() * c2.c() > com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t()) {
                double sqrt = Math.sqrt((com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t()) / (c2.b() * c2.c()));
                sb.append("width=");
                sb.append(String.valueOf((int) (c2.c() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * c2.b())));
            } else {
                float c3 = c2.c() / c2.b();
                double sqrt2 = Math.sqrt((com.baidu.tieba.data.i.t() * com.baidu.tieba.data.i.t()) / c3);
                sb.append("width=");
                sb.append(String.valueOf((int) (c3 * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tieba.util.bs.d(c2.e()));
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.j
    public void a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.F = str;
            com.baidu.tieba.ai.a(this, "pb_show_phonedialog");
            if (str2.equals("2")) {
                this.j.c(1).setVisibility(8);
            } else {
                this.j.c(1).setVisibility(0);
            }
            this.j.b();
        }
    }

    @Override // com.baidu.tieba.voice.af
    public VoiceManager h() {
        return this.h;
    }

    @Override // com.baidu.tieba.voice.af
    public com.baidu.tieba.voice.ad a(VoiceManager.VoiceModel voiceModel) {
        View ae;
        View findViewWithTag;
        if (!this.C.z() || (ae = this.C.ae()) == null || (findViewWithTag = ae.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (com.baidu.tieba.voice.ad) findViewWithTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (this.h != null) {
            this.h.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (this.w.t()) {
            com.baidu.tieba.util.cb.a(this, "pb_share", "pbclick", 1, new Object[0]);
            com.baidu.tieba.data.am m = this.w.m();
            String name = m.c().getName();
            String c2 = m.d().c();
            String str = "http://tieba.baidu.com/p/" + this.w.c() + "?share=9105";
            String[] b = m.b();
            String str2 = b[0];
            Uri parse = str2 == null ? null : Uri.parse(str2);
            String format = MessageFormat.format(getResources().getString(R.string.share_content_tpl), c2, name, b[1]);
            com.baidu.tieba.widget.share.f fVar = new com.baidu.tieba.widget.share.f();
            fVar.a = c2;
            fVar.b = format;
            fVar.c = str;
            if (parse != null) {
                fVar.d = parse;
            }
            com.baidu.tieba.widget.share.d dVar = new com.baidu.tieba.widget.share.d(this);
            dVar.a(fVar, true);
            dVar.a(B());
            dVar.a(C(), new bu(this, str));
            dVar.a();
        }
    }

    private SparseArray<String> B() {
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

    private View C() {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.btn_copy_pb_url, (ViewGroup) null);
        if (TiebaApplication.g().al() == 1) {
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
        return this.t;
    }

    @Override // com.baidu.tbadk.widget.a
    public void a(com.baidu.tbadk.widget.b bVar) {
        if (bVar != null) {
            this.ai.remove(bVar);
        }
    }

    public void l() {
        while (this.ai.size() > 0) {
            com.baidu.tbadk.widget.b remove = this.ai.remove(0);
            if (remove != null) {
                remove.invalidate();
            }
        }
    }
}
