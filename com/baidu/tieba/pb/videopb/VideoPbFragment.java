package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.emotion.PbSearchEmotionActivity;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.android.material.appbar.AppBarLayout;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.i0.b1.m.f;
import d.a.i0.h.a;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.w1;
import d.a.i0.r.s.a;
import d.a.j0.d2.p.c;
import d.a.j0.f0.b;
import d.a.j0.q0.f2.a.c;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes3.dex */
public class VideoPbFragment extends BaseFragment implements d.a.i0.b1.m.h, VoiceManager.j, d.a.j0.d2.o.i, TbRichTextView.r, d.a.j0.d2.o.h {
    public static int N1 = 0;
    public static int O1 = 1;
    public static int P1 = 0;
    public static int Q1 = 0;
    public static int R1 = 3;
    public static int S1 = 4;
    public static int T1 = 6;
    public static final int U1 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    public static final int V1 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    public static final b.InterfaceC1250b W1 = new q();
    public d.a.j0.d2.o.p.a A;
    public ObjectAnimator A1;
    public View B;
    public ReplyPrivacyCheckController B0;
    public ObjectAnimator B1;
    public View C;
    public d.a.j0.q0.f2.a.c C0;
    public View D;
    public d.a.j0.q0.f2.a.c D0;
    public MaskView E;
    public d.a.j0.d2.k.e.u0 E0;
    public TextView G;
    public TextView H;
    public ImageView I;
    public TBSpecificationBtn J;
    public TbImageView K;
    public PermissionJudgePolicy K0;
    public View L;
    public d.a.i0.w.w.g L0;
    public ValueAnimator M;
    public d.a.i0.w.w.e M0;
    public ValueAnimator N;
    public EditorTools N0;
    public FallingView O;
    public d.a.j0.d2.k.e.u O0;
    public TbImageView P;
    public PbFakeFloorModel P0;
    public d.a.j0.f0.b Q0;
    public View R;
    public d.a.j0.d2.o.n.a S;
    public int S0;
    public d.a.i0.r.f0.c T;
    public d.a.j0.d2.k.e.a1.f.a V;
    public EmotionImageData W;
    public VoiceManager Z;
    public d.a.i0.s.c.f Z0;
    public d.a.c.e.k.b<GifView> a0;
    public RightFloatLayerView a1;
    public d.a.c.e.k.b<TextView> b0;
    public d.a.c.e.k.b<ImageView> c0;
    public d.a.c.e.k.b<View> d0;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f20144e;
    public d.a.c.e.k.b<LinearLayout> e0;
    public d.a.c.e.k.b<RelativeLayout> f0;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f20146g;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f20147h;
    public LinearLayout h0;

    /* renamed from: i  reason: collision with root package name */
    public CustomViewPager f20148i;
    public View i0;
    public VideoPbFragmentAdapter j;
    public View k;
    public LinearLayout k0;
    public View l;
    public HeadImageView l0;
    public AppBarLayout m;
    public VideoContainerLayout n;
    public ImageView n0;
    public d.a.j0.d2.o.r.a o;
    public ImageView o0;
    public d.a.j0.d2.o.l p;
    public ImageView p0;
    public NavigationBar q;
    public d.a.j0.d2.p.h q0;
    public View r;
    public TextView r0;
    public View s;
    public TextView s0;
    public float s1;
    public View t;
    public float t1;
    public ImageView u;
    public String u0;
    public boolean u1;
    public View v;
    public ImageView w;
    public d.a.j0.w.a x;
    public GestureDetector x1;
    public View z;

    /* renamed from: f  reason: collision with root package name */
    public long f20145f = 0;
    public boolean y = false;
    public View.OnClickListener F = new k();
    public boolean Q = false;
    public d.a.i0.h.a U = null;
    public d.a.i0.s.e.a X = null;
    public ForumManageModel Y = null;
    public boolean g0 = false;
    public View j0 = null;
    public TextView m0 = null;
    public boolean v0 = false;
    public String w0 = null;
    public boolean x0 = false;
    public boolean y0 = false;
    public boolean z0 = false;
    public boolean A0 = false;
    public int[] R0 = new int[2];
    public int T0 = -1;
    public int U0 = Integer.MIN_VALUE;
    public int V0 = 0;
    public int W0 = Integer.MIN_VALUE;
    public boolean X0 = false;
    public boolean Y0 = d.a.i0.b.d.U();
    public CustomMessageListener b1 = new v(2921552);
    public final PbModel.g c1 = new c1();
    public final a.InterfaceC1039a d1 = new n1();
    public d.a.i0.w.w.b e1 = new o1();
    public final CustomMessageListener f1 = new p1(2004016);
    public CustomMessageListener g1 = new q1(2004007);
    public final CustomMessageListener h1 = new a(2921391);
    public CustomMessageListener i1 = new b(2016450);
    public HttpMessageListener j1 = new c(CmdConfigHttp.SET_PRIVATE_CMD, true);
    public CustomMessageListener k1 = new d(2001426);
    public CustomMessageListener l1 = new e(2001427);
    public CustomMessageListener m1 = new f(2001428);
    public d.a.i0.w.w.b n1 = new g();
    public final NewWriteModel.g o1 = new h();
    public View.OnClickListener p1 = new i();
    public CustomMessageListener q1 = new j(2004008);
    public int r1 = 0;
    public boolean v1 = true;
    public View.OnTouchListener w1 = new l();
    public GestureDetector.SimpleOnGestureListener y1 = new m();
    public Runnable z1 = new n();
    public final d.a.c.a.e C1 = new o();
    public View.OnTouchListener D1 = new p();
    public NewWriteModel.g E1 = new s();
    public d.a.i0.w.w.c F1 = new x();
    public final View.OnClickListener G1 = new y();
    public View.OnClickListener H1 = new z();
    public final AdapterView.OnItemClickListener I1 = new a0();
    public CustomMessageListener J1 = new b0(2001332);
    public Runnable K1 = new n0();
    public final View.OnLongClickListener L1 = new t0();
    public SortSwitchButton.f M1 = new u0();
    public r1 t0 = new r1(this, null);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.X0) {
                return;
            }
            VideoPbFragment.this.J4();
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements AdapterView.OnItemClickListener {
        public a0() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().H0() == i2 + 1) {
                return;
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.o4(videoPbFragment.c3(i2));
        }
    }

    /* loaded from: classes3.dex */
    public class a1 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20151e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20152f;

        /* loaded from: classes3.dex */
        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
                if (u0Var == null || u0Var.g() == null) {
                    return;
                }
                if (!VideoPbFragment.this.E0.g().e()) {
                    VideoPbFragment.this.E0.b(false);
                }
                VideoPbFragment.this.E0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        }

        public a1(String str, String str2) {
            this.f20151e = str;
            this.f20152f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            int g2;
            int i3 = d.a.c.e.p.l.i(VideoPbFragment.this.f20144e.getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                g2 = d.a.c.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            } else {
                i2 = i3 / 2;
                g2 = d.a.c.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            }
            int i4 = i3 - (i2 + g2);
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            boolean z = true;
            int i5 = (videoPbFragment.R0[1] + videoPbFragment.S0) - i4;
            if (videoPbFragment.e3() != null) {
                VideoPbFragment.this.e3().smoothScrollBy(0, i5);
            }
            if (VideoPbFragment.this.O0 != null) {
                VideoPbFragment.this.M0.a().setVisibility(8);
                VideoPbFragment.this.O0.n(this.f20151e, this.f20152f, VideoPbFragment.this.g3(), (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || !VideoPbFragment.this.z().y0().L().S1()) ? false : false);
                d.a.i0.w.w.h b2 = VideoPbFragment.this.O0.b();
                if (b2 != null && VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                    b2.E(VideoPbFragment.this.z().y0().d());
                    b2.X(VideoPbFragment.this.z().y0().L());
                }
                if (VideoPbFragment.this.E0.f() == null && VideoPbFragment.this.O0.b().s() != null) {
                    VideoPbFragment.this.O0.b().s().g(new a());
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    videoPbFragment2.E0.n(videoPbFragment2.O0.b().s().i());
                    VideoPbFragment.this.O0.b().K(VideoPbFragment.this.n1);
                }
            }
            VideoPbFragment.this.j3();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.Z4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b0 extends CustomMessageListener {
        public b0(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.a.i0.b1.m.f.c(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.f48276a, aVar.f48277b, aVar.f48278c);
        }
    }

    /* loaded from: classes3.dex */
    public class b1 implements c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20157a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20158b;

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$b1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0219a implements TextWatcher {
                public C0219a() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
                    if (u0Var == null || u0Var.g() == null) {
                        return;
                    }
                    if (!VideoPbFragment.this.E0.g().e()) {
                        VideoPbFragment.this.E0.b(false);
                    }
                    VideoPbFragment.this.E0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int g2;
                int i3 = d.a.c.e.p.l.i(VideoPbFragment.this.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.a.c.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i2 = i3 / 2;
                    g2 = d.a.c.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i4 = i3 - (i2 + g2);
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                boolean z = true;
                int i5 = (videoPbFragment.R0[1] + videoPbFragment.S0) - i4;
                if (videoPbFragment.e3() != null) {
                    VideoPbFragment.this.e3().smoothScrollBy(0, i5);
                }
                if (VideoPbFragment.this.O0 != null) {
                    VideoPbFragment.this.M0.a().setVisibility(8);
                    z = (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || !VideoPbFragment.this.z().y0().L().S1()) ? false : false;
                    d.a.j0.d2.k.e.u uVar = VideoPbFragment.this.O0;
                    b1 b1Var = b1.this;
                    uVar.n(b1Var.f20157a, b1Var.f20158b, VideoPbFragment.this.g3(), z);
                    d.a.i0.w.w.h b2 = VideoPbFragment.this.O0.b();
                    if (b2 != null && VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                        b2.E(VideoPbFragment.this.z().y0().d());
                        b2.X(VideoPbFragment.this.z().y0().L());
                    }
                    if (VideoPbFragment.this.E0.f() == null && VideoPbFragment.this.O0.b().s() != null) {
                        VideoPbFragment.this.O0.b().s().g(new C0219a());
                        VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                        videoPbFragment2.E0.n(videoPbFragment2.O0.b().s().i());
                        VideoPbFragment.this.O0.b().K(VideoPbFragment.this.n1);
                    }
                }
                VideoPbFragment.this.j3();
            }
        }

        public b1(String str, String str2) {
            this.f20157a = str;
            this.f20158b = str2;
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new a(), 0L);
            }
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class c extends HttpMessageListener {
        public c(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (VideoPbFragment.this.getView() != null) {
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                videoPbFragment.hideLoadingView(videoPbFragment.getView());
                VideoPbFragment.this.hideProgressBar();
            }
            if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    int type = privacySettingMessage.getType();
                    if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                        BdTopToast bdTopToast = new BdTopToast(VideoPbFragment.this.getContext());
                        bdTopToast.i(true);
                        bdTopToast.h(VideoPbFragment.this.getString(R.string.block_user_success));
                        bdTopToast.j((ViewGroup) VideoPbFragment.this.getView());
                        VideoPbFragment.this.y4(type);
                        return;
                    }
                    String string = StringUtils.isNull(httpResponsedMessage.getErrorString()) ? VideoPbFragment.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString();
                    BdTopToast bdTopToast2 = new BdTopToast(VideoPbFragment.this.getContext());
                    bdTopToast2.i(false);
                    bdTopToast2.h(string);
                    bdTopToast2.j((ViewGroup) VideoPbFragment.this.getView());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c0 implements Observer<a2> {
        public c0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            BdTypeRecyclerView e3;
            if (a2Var == null || a2Var.u1() == null) {
                return;
            }
            if (VideoPbFragment.this.o.b0() == null || !VideoPbFragment.this.o.b0().equals(a2Var.u1().video_url)) {
                if (!d.a.c.e.p.k.isEmpty(VideoPbFragment.this.o.b0())) {
                    VideoPbFragment.this.A0 = true;
                    if (VideoPbFragment.this.B3()) {
                        VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.N1);
                    } else {
                        VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.P1);
                    }
                    if (!VideoPbFragment.this.B3() && (e3 = VideoPbFragment.this.e3()) != null) {
                        e3.scrollToPosition(0);
                    }
                }
                if (VideoPbFragment.this.p == null || !VideoPbFragment.this.p.k()) {
                    VideoPbFragment.this.k4();
                    VideoPbFragment.this.u2(a2Var);
                }
                VideoPbFragment.this.A3();
                if (VideoPbFragment.this.p.l()) {
                    VideoPbFragment.this.p.s();
                }
                boolean z = !StringHelper.equals(VideoPbFragment.this.o.b0(), a2Var.u1().video_url);
                VideoPbFragment.this.o.setData(a2Var);
                if (VideoPbFragment.this.B3()) {
                    VideoPbFragment.this.o.V0(VideoPbFragment.this.f20148i.getCurrentItem() == 0);
                } else {
                    VideoPbFragment.this.o.V0(false);
                }
                if (z) {
                    VideoPbFragment.this.o.startPlay();
                    VideoPbFragment.this.o.y0();
                    return;
                }
                return;
            }
            VideoPbFragment.this.o.setData(a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c1 implements PbModel.g {
        public c1() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.a.j0.d2.h.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
            d.a.i0.w.h m;
            VideoPbFragment.this.w4();
            VideoPbFragment.this.n3();
            if (VideoPbFragment.this.Q) {
                VideoPbFragment.this.Q = false;
            }
            VideoPbFragment.this.E4(false);
            if (z && eVar != null) {
                a2 L = eVar.L();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).s(eVar, i3);
                VideoPbFragment.this.a4(eVar);
                d.a.j0.d2.o.p.a E = eVar.E();
                if (E != null && !E.q) {
                    VideoPbFragment.this.v2(E);
                }
                VideoPbFragment.this.g4(eVar);
                VideoPbFragment.this.d4(z, i2, i3, i4, eVar, str, i5);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.R().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.R().getBimg_end_time());
                if (VideoPbFragment.this.U != null) {
                    VideoPbFragment.this.U.h(eVar.r());
                }
                AntiData d2 = eVar.d();
                if (d2 != null) {
                    VideoPbFragment.this.w0 = d2.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.w0) && VideoPbFragment.this.M0 != null && VideoPbFragment.this.M0.a() != null && (m = VideoPbFragment.this.M0.a().m(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.w0)) {
                        ((View) m).setOnClickListener(VideoPbFragment.this.p1);
                    }
                }
                if (VideoPbFragment.this.B0 != null && L != null && L.T() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(L.T());
                    VideoPbFragment.this.B0.setLikeUserData(attentionHostData);
                }
            } else {
                if (i2 == 4 || i2 == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.z().O0());
                        jSONObject.put("fid", VideoPbFragment.this.z().getForumId());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                }
                if (i2 != 0) {
                    EnterForePvThread enterForePvThread = new EnterForePvThread();
                    enterForePvThread.setOpType("2");
                    enterForePvThread.start();
                }
                if ((VideoPbFragment.this.B3() && VideoPbFragment.this.f3() == null) || VideoPbFragment.this.Q2() == null) {
                    return;
                }
                ArrayList<PostData> arrayList = null;
                if (VideoPbFragment.this.B3()) {
                    if (i2 != -1) {
                        if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                            arrayList = VideoPbFragment.this.z().y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                            VideoPbFragment.this.f3().k1(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (VideoPbFragment.this.f3().e1()) {
                            VideoPbFragment.this.f3().l1(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            VideoPbFragment.this.f3().l1(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    } else {
                        VideoPbFragment.this.f3().k1("");
                    }
                    VideoPbFragment.this.f3().R0();
                } else {
                    if (i2 != -1) {
                        if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                            arrayList = VideoPbFragment.this.z().y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                            VideoPbFragment.this.Q2().p1(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (VideoPbFragment.this.Q2().h1()) {
                            VideoPbFragment.this.Q2().q1(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            VideoPbFragment.this.Q2().q1(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    } else {
                        VideoPbFragment.this.Q2().p1("");
                    }
                    VideoPbFragment.this.Q2().T0();
                }
            }
            d.a.j0.c3.c.g().h(VideoPbFragment.this.getUniqueId(), false);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.S != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.j0.o3.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.S.B) {
                d.a.j0.o3.a aVar = (d.a.j0.o3.a) customResponsedMessage.getData();
                VideoPbFragment.this.S.T();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.S.M();
                DataRes dataRes = aVar.f57309a;
                if (aVar.f57311c == 0 && dataRes != null) {
                    int d2 = d.a.c.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.a.c.e.p.k.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    VideoPbFragment.this.S.s0(r2, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.S.f0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d0 implements Observer<Integer> {
        public d0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            VideoPbFragment.this.f20148i.setCurrentItem(num.intValue());
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements Runnable {
        public d1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.A == null || VideoPbFragment.this.A.v()) {
                if (VideoPbFragment.this.A != null && VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null && VideoPbFragment.this.z().y0().l() != null) {
                    TiebaStatic.log(new StatisticItem("c13712").param("fid", VideoPbFragment.this.z().y0().l().getId()).param("fname", VideoPbFragment.this.z().y0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.z().y0().N()).param("obj_param1", VideoPbFragment.this.A.p));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c13608").param("obj_id", VideoPbFragment.this.A.u()).param("obj_name", VideoPbFragment.this.A.t()).param("obj_type", 2).param("fid", VideoPbFragment.this.z().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.z().y0().N()));
            }
            VideoPbFragment.this.M4();
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.S == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.j0.d2.o.n.a aVar = VideoPbFragment.this.S;
            if (tag == aVar.B) {
                aVar.T();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.a.j0.d2.h.e y0 = VideoPbFragment.this.z().y0();
                if (y0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    y0.u().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.T.c(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.S.x0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.S.r0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.a.c.e.p.k.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.T.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e0 implements Observer<a2> {
        public e0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            VideoPbFragment.this.o.Y0(a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class e1 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f20170e;

        public e1(ViewGroup.LayoutParams layoutParams) {
            this.f20170e = layoutParams;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPbFragment.this.Y4(this.f20170e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.S == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.a.j0.d2.o.n.a aVar = VideoPbFragment.this.S;
            if (tag == aVar.B) {
                aVar.T();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.T.c(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.a.c.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.T.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f0 implements Observer<a2> {
        public f0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            VideoPbFragment.this.o.X0(a2Var);
        }
    }

    /* loaded from: classes3.dex */
    public class f1 implements Animator.AnimatorListener {
        public f1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPbFragment.this.z.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d.a.i0.w.w.b {
        public g() {
        }

        @Override // d.a.i0.w.w.b
        public boolean a() {
            d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
            if (u0Var == null || u0Var.g() == null || !VideoPbFragment.this.E0.g().d()) {
                return !VideoPbFragment.this.B2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.E0.g().c());
            if (VideoPbFragment.this.O0 != null && VideoPbFragment.this.O0.b() != null && VideoPbFragment.this.O0.b().v()) {
                VideoPbFragment.this.O0.b().t(VideoPbFragment.this.E0.h());
            }
            VideoPbFragment.this.E0.b(true);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class g0 implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20176e;

        public g0(String str) {
            this.f20176e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.a1.k();
            VideoPbFragment.this.G3(this.f20176e);
            VideoPbFragment.this.o3();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2).param("obj_param1", 0));
        }
    }

    /* loaded from: classes3.dex */
    public class g1 implements Animator.AnimatorListener {
        public g1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPbFragment.this.W4();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class h implements NewWriteModel.g {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f20180e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f20180e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f20180e != null) {
                    VideoPbFragment.this.Q4();
                    VideoPbFragment.this.Y3(this.f20180e.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements a.e {
            public b(h hVar) {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public h() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.i0.s.c.h0 h0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                    statisticItem.param("fid", VideoPbFragment.this.z().y0().m());
                }
                statisticItem.param("tid", VideoPbFragment.this.z().O0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            VideoPbFragment.this.R4();
            VideoPbFragment.this.v4(z, postWriteCallBackData);
            int i2 = -1;
            if (postWriteCallBackData != null) {
                i2 = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            boolean z2 = false;
            if (!z) {
                if (i2 == 220015) {
                    VideoPbFragment.this.showToast(str);
                    if (VideoPbFragment.this.M0.B() || VideoPbFragment.this.M0.D()) {
                        VideoPbFragment.this.M0.z(false, postWriteCallBackData);
                    }
                    VideoPbFragment.this.E0.k(postWriteCallBackData);
                    return;
                } else if (i2 == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = VideoPbFragment.this.B0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                        return;
                    } else {
                        DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        return;
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(VideoPbFragment.this.getActivity());
                    if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new b(this));
                    aVar.setPositiveButton(R.string.open_now, new c());
                    aVar.create(VideoPbFragment.this.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                    return;
                } else if (d.a.j0.n3.a.c(i2) || h0Var != null || i2 == 227001) {
                    return;
                } else {
                    VideoPbFragment.this.C4(i2, antiData, str);
                    return;
                }
            }
            if (PbReplySwitch.getInOn() && VideoPbFragment.this.z() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                VideoPbFragment.this.z().K(postWriteCallBackData.getPostId());
                if (VideoPbFragment.this.B3() && VideoPbFragment.this.f3() != null) {
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.V0 = videoPbFragment.f3().U0();
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    videoPbFragment2.W0 = videoPbFragment2.f3().V0();
                    VideoPbFragment.this.z().H1(VideoPbFragment.this.V0, VideoPbFragment.this.W0);
                } else if (VideoPbFragment.this.Q2() != null) {
                    VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
                    videoPbFragment3.V0 = videoPbFragment3.Q2().W0();
                    VideoPbFragment videoPbFragment4 = VideoPbFragment.this;
                    videoPbFragment4.W0 = videoPbFragment4.Q2().X0();
                    VideoPbFragment.this.z().H1(VideoPbFragment.this.V0, VideoPbFragment.this.W0);
                }
            }
            if (VideoPbFragment.this.f20148i != null) {
                if (VideoPbFragment.this.B3()) {
                    VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.O1);
                } else {
                    VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.P1);
                }
            }
            VideoPbFragment.this.S.E();
            VideoPbFragment.this.E0.c();
            if (VideoPbFragment.this.M0 != null) {
                VideoPbFragment videoPbFragment5 = VideoPbFragment.this;
                videoPbFragment5.r4(videoPbFragment5.M0.C());
            }
            VideoPbFragment.this.l3();
            VideoPbFragment.this.E4(true);
            VideoPbFragment.this.z().V0();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
            VideoPbFragment.this.D4(antiData, postWriteCallBackData);
            if (writeData == null) {
                return;
            }
            String floor = writeData.getFloor();
            if (writeData == null || writeData.getType() != 2) {
                if (VideoPbFragment.this.z().d0()) {
                    d.a.j0.d2.h.e y0 = VideoPbFragment.this.z().y0();
                    if (y0 != null && y0.L() != null && y0.L().T() != null && (userId = y0.L().T().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.z().U1()) {
                        VideoPbFragment.this.x4();
                    }
                } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.z().U1()) {
                    VideoPbFragment.this.x4();
                }
            } else if (floor != null) {
                if (VideoPbFragment.this.B3() && VideoPbFragment.this.f3() != null) {
                    VideoPbFragment.this.f3().d1();
                } else if (VideoPbFragment.this.Q2() != null) {
                    VideoPbFragment.this.Q2().g1();
                }
            }
            if (postWriteCallBackData.getmAdverSegmentData() != null) {
                d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData), 500L);
            }
            VideoPbFragment videoPbFragment6 = VideoPbFragment.this;
            if (writeData != null && writeData.getType() == 2) {
                z2 = true;
            }
            videoPbFragment6.t2(z2);
        }
    }

    /* loaded from: classes3.dex */
    public class h0 implements Observer<Boolean> {
        public h0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            VideoPbFragment.this.c4();
        }
    }

    /* loaded from: classes3.dex */
    public class h1 implements d.a.c.e.k.c<ImageView> {
        public h1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.a.i0.r.k.c().g()) {
                    tbImageView.setAdjustViewBounds(false);
                    tbImageView.setInterceptOnClick(false);
                } else {
                    tbImageView.setDefaultResource(R.drawable.icon_click);
                    tbImageView.setAdjustViewBounds(true);
                    tbImageView.setInterceptOnClick(true);
                }
            }
            return imageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.a.i0.r.k.c().g();
            foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                foreDrawableImageView.setAdjustViewBounds(false);
                foreDrawableImageView.setInterceptOnClick(false);
            } else {
                foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                foreDrawableImageView.setAdjustViewBounds(true);
                foreDrawableImageView.setInterceptOnClick(true);
            }
            return foreDrawableImageView;
        }

        public ImageView h(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.Z();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.Q();
            }
            return imageView;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.w0);
        }
    }

    /* loaded from: classes3.dex */
    public class i0 implements Observer<Boolean> {
        public i0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            VideoPbFragment.this.q.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    /* loaded from: classes3.dex */
    public class i1 implements d.a.c.e.k.c<GifView> {
        public i1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.a.i0.r.k.c().g()) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.n0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.a.i0.r.k.c().g();
            gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
            if (g2) {
                gifView.setAdjustViewBounds(false);
                gifView.setInterceptOnClick(false);
            } else {
                gifView.setDefaultResource(R.drawable.icon_click);
                gifView.setAdjustViewBounds(true);
                gifView.setInterceptOnClick(true);
            }
            return gifView;
        }

        public GifView h(GifView gifView) {
            gifView.r0();
            gifView.n0();
            gifView.setImageDrawable(null);
            gifView.t0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (VideoPbFragment.this.M0 != null) {
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                videoPbFragment.r4(videoPbFragment.M0.C());
            }
            VideoPbFragment.this.E4(false);
        }
    }

    /* loaded from: classes3.dex */
    public class j0 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f20189e;

        public j0(VideoPbViewModel videoPbViewModel) {
            this.f20189e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (VideoPbFragment.this.B3() && (this.f20189e.m() || VideoPbFragment.this.z().N0() == VideoPbFragment.O1)) {
                VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.O1);
            } else if (this.f20189e.m() || VideoPbFragment.this.z().N0() == VideoPbFragment.P1) {
                VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.P1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VideoPbFragment.this.B3() && (this.f20189e.m() || VideoPbFragment.this.z().N0() == VideoPbFragment.O1)) {
                VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.O1);
            } else if (this.f20189e.m() || VideoPbFragment.this.z().N0() == VideoPbFragment.P1) {
                VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.P1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class j1 implements d.a.c.e.k.c<View> {
        public j1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            ((PlayVoiceBntNew) view).l();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).k();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).k();
            return view;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.A == null || VideoPbFragment.this.A.v()) {
                if (VideoPbFragment.this.A != null) {
                    if (VideoPbFragment.this.A.m) {
                        VideoPbFragment videoPbFragment = VideoPbFragment.this;
                        videoPbFragment.F3(videoPbFragment.A.o, VideoPbFragment.this.A.n);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.A.h();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13713").param("fid", VideoPbFragment.this.z().y0().l().getId()).param("fname", VideoPbFragment.this.z().y0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.z().y0().N()).param("obj_param1", VideoPbFragment.this.A.p));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c13590").param("obj_id", VideoPbFragment.this.A.u()).param("obj_name", VideoPbFragment.this.A.t()).param("obj_type", 2).param("fid", VideoPbFragment.this.z().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.z().y0().N()));
            String p = VideoPbFragment.this.A.p();
            if (TextUtils.isEmpty(p)) {
                return;
            }
            if (!URLUtil.isHttpUrl(p) && !URLUtil.isHttpsUrl(p)) {
                Uri parse = Uri.parse(p);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    return;
                }
                return;
            }
            UrlManager.getInstance().dealOneLink(VideoPbFragment.this.getPageContext(), new String[]{p});
        }
    }

    /* loaded from: classes3.dex */
    public class k0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public k0() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            if (z) {
                if (i2 == ReplyPrivacyCheckController.TYPE_THREAD) {
                    VideoPbFragment.this.M0.L(null, null);
                } else if (i2 == ReplyPrivacyCheckController.TYPE_FLOOR && VideoPbFragment.this.O0 != null && VideoPbFragment.this.O0.b() != null) {
                    VideoPbFragment.this.O0.b().D();
                } else if (i2 == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.n4(videoPbFragment.W);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k1 implements d.a.c.e.k.c<LinearLayout> {
        public k1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            LinearLayout linearLayout = new LinearLayout(VideoPbFragment.this.getPageContext().getPageActivity());
            linearLayout.setId(R.id.pb_text_voice_layout);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setGravity(16);
            linearLayout.setBaselineAligned(true);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(layoutParams);
            return linearLayout;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
            return linearLayout;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnTouchListener {
        public l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.x1 != null && VideoPbFragment.this.x1.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.r1 == 1) {
                if (!VideoPbFragment.this.v1) {
                    VideoPbFragment.this.O4();
                    UtilHelper.showStatusBar(VideoPbFragment.this.A(), VideoPbFragment.this.A().getRootView());
                    VideoPbFragment.this.v1 = true;
                    d.a.c.e.m.e.a().removeCallbacks(VideoPbFragment.this.z1);
                    d.a.c.e.m.e.a().postDelayed(VideoPbFragment.this.z1, 3000L);
                }
            } else if (VideoPbFragment.this.r1 == 2 && (VideoPbFragment.this.v1 || VideoPbFragment.this.C3())) {
                VideoPbFragment.this.N4();
                UtilHelper.hideStatusBar(VideoPbFragment.this.A(), VideoPbFragment.this.A().getRootView());
                VideoPbFragment.this.v1 = false;
                if (VideoPbFragment.this.o != null) {
                    VideoPbFragment.this.o.W0(false);
                }
            }
            VideoPbFragment.this.r1 = 0;
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class l0 implements ViewPager.OnPageChangeListener {
        public l0() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            boolean z = true;
            if (i2 == 0) {
                if (VideoPbFragment.this.Q2() != null) {
                    VideoPbFragment.this.Q2().k1(false);
                } else if (VideoPbFragment.this.B3() && VideoPbFragment.this.f3() != null) {
                    VideoPbFragment.this.f3().g1(false);
                }
                if (VideoPbFragment.this.R2() != null) {
                    VideoPbFragment.this.R2().U0(true);
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.z4(videoPbFragment.R2().M0() == 0 ? 8 : 0);
                    VideoPbFragment.this.h0.setVisibility(8);
                }
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                VideoPbFragment.this.o.V0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false);
                VideoPbFragment.this.j4();
                if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                    TiebaStatic.log(new StatisticItem("c13592").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()));
                }
            } else {
                if (VideoPbFragment.this.R2() != null) {
                    VideoPbFragment.this.R2().U0(false);
                }
                if (VideoPbFragment.this.Q2() != null) {
                    VideoPbFragment.this.Q2().k1(true);
                    int c1 = VideoPbFragment.this.Q2().c1();
                    int a1 = VideoPbFragment.this.Q2().a1();
                    if (c1 != 0) {
                        VideoPbFragment.this.z4(8);
                        VideoPbFragment.this.Q2().t1(0);
                    } else if (a1 != 0) {
                        VideoPbFragment.this.Q2().t1(8);
                        VideoPbFragment.this.z4(0);
                    } else {
                        VideoPbFragment.this.Q2().t1(8);
                        VideoPbFragment.this.z4(8);
                    }
                } else if (VideoPbFragment.this.f3() != null) {
                    VideoPbFragment.this.f3().g1(true);
                    int a12 = VideoPbFragment.this.f3().a1();
                    int Y0 = VideoPbFragment.this.f3().Y0();
                    if (a12 != 0) {
                        VideoPbFragment.this.z4(8);
                        VideoPbFragment.this.f3().o1(0);
                    } else if (Y0 != 0) {
                        VideoPbFragment.this.f3().o1(8);
                        VideoPbFragment.this.z4(0);
                    } else {
                        VideoPbFragment.this.f3().o1(8);
                        VideoPbFragment.this.z4(8);
                    }
                    VideoPbFragment.this.h0.setVisibility(0);
                }
                VideoPbFragment.this.o.V0(false);
                VideoPbFragment.this.m.setExpanded(false, true);
                if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                    TiebaStatic.log(new StatisticItem("c13593").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()));
                }
            }
            VideoPbFragment.this.j.d(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class l1 implements d.a.c.e.k.c<RelativeLayout> {
        public l1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    /* loaded from: classes3.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public m() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.r1 = 0;
            VideoPbFragment.this.s1 = 0.0f;
            VideoPbFragment.this.t1 = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            VideoPbFragment.this.s1 += f2;
            VideoPbFragment.this.t1 += f3;
            if (VideoPbFragment.this.r1 == 0 && !VideoPbFragment.this.u1 && VideoPbFragment.this.o != null && !VideoPbFragment.this.o.C()) {
                int height = VideoPbFragment.this.q.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.t1) <= Math.abs(VideoPbFragment.this.s1) || VideoPbFragment.this.t1 > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.t1) > Math.abs(VideoPbFragment.this.s1) && VideoPbFragment.this.t1 > 0.0f && f3 > 0.0f) {
                        VideoPbFragment.this.r1 = 2;
                    }
                } else {
                    VideoPbFragment.this.r1 = 1;
                }
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class m0 extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.t.a f20199a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f20200b;

        public m0(d.a.i0.t.a aVar, int i2) {
            this.f20199a = aVar;
            this.f20200b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            VideoPbFragment.this.L4(this.f20199a, bitmap, this.f20200b);
        }
    }

    /* loaded from: classes3.dex */
    public class m1 implements Comparator<d.a.i0.t.a> {
        public m1() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.a.i0.t.a aVar, d.a.i0.t.a aVar2) {
            return aVar.compareTo(aVar2);
        }
    }

    /* loaded from: classes3.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!VideoPbFragment.this.v1 || VideoPbFragment.this.C3()) {
                return;
            }
            VideoPbFragment.this.N4();
            UtilHelper.hideStatusBar(VideoPbFragment.this.A(), VideoPbFragment.this.A().getRootView());
            VideoPbFragment.this.v1 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class n0 implements Runnable {
        public n0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.P != null) {
                d.a.j0.d2.p.d.b(VideoPbFragment.this.P);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements a.InterfaceC1039a {
        public n1() {
        }

        @Override // d.a.i0.h.a.InterfaceC1039a
        public void a(boolean z, boolean z2, String str) {
            a2 L;
            VideoPbFragment.this.w4();
            if (z && VideoPbFragment.this.z() != null) {
                if (VideoPbFragment.this.U != null) {
                    VideoPbFragment.this.U.h(z2);
                }
                VideoPbFragment.this.z().T1(z2);
                if (VideoPbFragment.this.z().y0() != null && (L = VideoPbFragment.this.z().y0().L()) != null) {
                    if (z2) {
                        L.F2++;
                    } else {
                        int i2 = L.F2;
                        if (i2 > 0) {
                            L.F2 = i2 - 1;
                        }
                    }
                }
                if (VideoPbFragment.this.z().k0()) {
                    VideoPbFragment.this.Q3();
                } else if (VideoPbFragment.this.B3()) {
                    if (VideoPbFragment.this.R2() != null) {
                        VideoPbFragment.this.R2().P0();
                    }
                    if (VideoPbFragment.this.f3() != null) {
                        VideoPbFragment.this.f3().d1();
                    }
                } else if (VideoPbFragment.this.Q2() != null) {
                    VideoPbFragment.this.Q2().g1();
                }
                if (z2) {
                    if (VideoPbFragment.this.U != null) {
                        if (VideoPbFragment.this.U.f() == null || VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || VideoPbFragment.this.z().y0().L().T() == null) {
                            return;
                        }
                        MarkData f2 = VideoPbFragment.this.U.f();
                        MetaData T = VideoPbFragment.this.z().y0().L().T();
                        if (f2 != null && T != null) {
                            if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), T.getUserId()) && !T.hadConcerned()) {
                                VideoPbFragment.this.S.p0(T);
                            } else {
                                VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                            }
                        } else {
                            VideoPbFragment videoPbFragment = VideoPbFragment.this;
                            videoPbFragment.showToast(videoPbFragment.getPageContext().getString(R.string.add_mark));
                        }
                    }
                    VideoPbFragment.this.s2();
                    return;
                }
                VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                videoPbFragment2.showToast(videoPbFragment2.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
            videoPbFragment3.showToast(videoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
        }
    }

    /* loaded from: classes3.dex */
    public class o extends d.a.c.a.e {
        public o() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            boolean z = false;
            if (obj != null && VideoPbFragment.this.z() != null) {
                switch (VideoPbFragment.this.Y.getLoadDataMode()) {
                    case 0:
                        VideoPbFragment.this.z().V0();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoPbFragment.this.J2(bVar, (bVar.f21665e != 1002 || bVar.f21666f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        VideoPbFragment.this.K2(1, dVar.f21668a, dVar.f21669b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        VideoPbFragment videoPbFragment = VideoPbFragment.this;
                        videoPbFragment.L2(videoPbFragment.Y.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                        videoPbFragment2.K2(videoPbFragment2.Y.getLoadDataMode(), gVar.f21682a, gVar.f21683b, false);
                        VideoPbFragment.this.S.c0(gVar.f21684c);
                        return;
                    default:
                        return;
                }
            }
            VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
            videoPbFragment3.K2(videoPbFragment3.Y.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes3.dex */
    public class o0 implements View.OnClickListener {
        public o0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DialogLoginHelper.checkUpIsLogin(new d.a.i0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huitie"))) {
                VideoPbFragment.this.I2(false);
                VideoPbFragment.this.b4();
                if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || VideoPbFragment.this.z().y0().L().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", VideoPbFragment.this.z().P0()).param("fid", VideoPbFragment.this.z().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()).param("obj_locate", 1).param("uid", VideoPbFragment.this.z().y0().L().T().getUserId()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o1 implements d.a.i0.w.w.b {
        public o1() {
        }

        @Override // d.a.i0.w.w.b
        public boolean a() {
            d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
            if (u0Var == null || u0Var.e() == null || !VideoPbFragment.this.E0.e().d()) {
                return !VideoPbFragment.this.B2(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.E0.e().c());
            if (VideoPbFragment.this.M0 != null && (VideoPbFragment.this.M0.B() || VideoPbFragment.this.M0.D())) {
                VideoPbFragment.this.M0.z(false, VideoPbFragment.this.E0.h());
            }
            VideoPbFragment.this.E0.a(true);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class p implements View.OnTouchListener {
        public p() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.Q0.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class p0 implements View.OnClickListener {
        public p0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.m3();
        }
    }

    /* loaded from: classes3.dex */
    public class p1 extends CustomMessageListener {
        public p1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.z() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (VideoPbFragment.this.M0 != null) {
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                videoPbFragment.r4(videoPbFragment.M0.C());
            }
            VideoPbFragment.this.j4();
            VideoPbFragment.this.S.E();
        }
    }

    /* loaded from: classes3.dex */
    public static class q implements b.InterfaceC1250b {
        @Override // d.a.j0.f0.b.InterfaceC1250b
        public void a(boolean z) {
            if (z) {
                d.a.j0.d2.i.b.d();
            } else {
                d.a.j0.d2.i.b.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q0 implements View.OnClickListener {
        public q0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.j4();
        }
    }

    /* loaded from: classes3.dex */
    public class q1 extends CustomMessageListener {
        public q1(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.a.j0.d2.e eVar = (d.a.j0.d2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                VideoPbFragment.this.h4((d.a.j0.d2.h.q) eVar.a());
            } else if (b2 == 1) {
                VideoPbFragment.this.J2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    VideoPbFragment.this.f4(false, null);
                } else {
                    VideoPbFragment.this.f4(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements a.e {
        public r() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r0 implements View.OnClickListener {
        public r0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.a1.k();
            VideoPbFragment.this.o3();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921552));
            TiebaStatic.log(new StatisticItem("c14129").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_param1", 2).param("obj_locate", 2));
        }
    }

    /* loaded from: classes3.dex */
    public class s implements NewWriteModel.g {

        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostWriteCallBackData f20220e;

            public a(PostWriteCallBackData postWriteCallBackData) {
                this.f20220e = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f20220e != null) {
                    VideoPbFragment.this.Q4();
                    VideoPbFragment.this.Y3(this.f20220e.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements a.e {
            public b(s sVar) {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements a.e {
            public c() {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public s() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.a.i0.s.c.h0 h0Var, WriteData writeData, AntiData antiData) {
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                    statisticItem.param("fid", VideoPbFragment.this.z().y0().m());
                }
                if (VideoPbFragment.this.z() != null) {
                    statisticItem.param("tid", VideoPbFragment.this.z().O0());
                }
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
                if (u0Var != null) {
                    u0Var.d();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    d.a.i0.s.h.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                }
                if (postWriteCallBackData.getmAdverSegmentData() != null) {
                    d.a.c.e.m.e.a().postDelayed(new a(postWriteCallBackData), 500L);
                    return;
                }
                return;
            }
            if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = VideoPbFragment.this.B0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(VideoPbFragment.this.getActivity());
                if (d.a.c.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new b(this));
                aVar.setPositiveButton(R.string.open_now, new c());
                aVar.create(VideoPbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            }
            if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                return;
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            if (videoPbFragment.E0 == null) {
                return;
            }
            if (videoPbFragment.O0 != null && VideoPbFragment.this.O0.b() != null && VideoPbFragment.this.O0.b().v()) {
                VideoPbFragment.this.O0.b().t(postWriteCallBackData);
            }
            VideoPbFragment.this.E0.l(postWriteCallBackData);
        }
    }

    /* loaded from: classes3.dex */
    public class s0 implements PbFakeFloorModel.b {
        public s0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            VideoPbFragment.this.P0.A(postData);
            if (VideoPbFragment.this.Q2() != null) {
                VideoPbFragment.this.Q2().g1();
            } else if (VideoPbFragment.this.B3() && VideoPbFragment.this.f3() != null) {
                VideoPbFragment.this.f3().d1();
            }
            VideoPbFragment.this.O0.c();
            VideoPbFragment.this.N0.q();
            VideoPbFragment.this.E4(false);
        }
    }

    /* loaded from: classes3.dex */
    public class t implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f20224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f20225f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f20226g;

        public t(MarkData markData, MarkData markData2, d.a.i0.r.s.a aVar) {
            this.f20224e = markData;
            this.f20225f = markData2;
            this.f20226g = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            if (VideoPbFragment.this.U != null) {
                if (VideoPbFragment.this.U.e()) {
                    VideoPbFragment.this.U.d();
                    VideoPbFragment.this.U.h(false);
                }
                VideoPbFragment.this.U.i(this.f20224e);
                VideoPbFragment.this.U.h(true);
                VideoPbFragment.this.U.a();
            }
            this.f20225f.setPostId(this.f20224e.getPostId());
            Intent intent = new Intent();
            intent.putExtra("mark", this.f20225f);
            VideoPbFragment.this.f20144e.setResult(-1, intent);
            this.f20226g.dismiss();
            VideoPbFragment.this.S4();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
        }
    }

    /* loaded from: classes3.dex */
    public class t0 implements View.OnLongClickListener {
        public t0() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.S.j0(true);
            return VideoPbFragment.this.S.N().onLongClick(view);
        }
    }

    /* loaded from: classes3.dex */
    public class u implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f20229e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f20230f;

        public u(MarkData markData, d.a.i0.r.s.a aVar) {
            this.f20229e = markData;
            this.f20230f = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.putExtra("mark", this.f20229e);
            VideoPbFragment.this.f20144e.setResult(-1, intent);
            this.f20230f.dismiss();
            VideoPbFragment.this.S4();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
        }
    }

    /* loaded from: classes3.dex */
    public class u0 implements SortSwitchButton.f {
        public u0() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i2) {
            d.a.j0.d2.o.n.a aVar = VideoPbFragment.this.S;
            if (aVar != null) {
                aVar.E();
            }
            boolean z = false;
            if (!d.a.c.e.p.j.z()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            }
            if (VideoPbFragment.this.z() != null && !VideoPbFragment.this.z().isLoading) {
                VideoPbFragment.this.R4();
                VideoPbFragment.this.x4();
                z = true;
                if (VideoPbFragment.this.z().y0() != null && VideoPbFragment.this.z().y0().f52020f != null && VideoPbFragment.this.z().y0().f52020f.size() > i2) {
                    int intValue = VideoPbFragment.this.z().y0().f52020f.get(i2).sort_type.intValue();
                    TiebaStatic.log(new StatisticItem("c13699").param("tid", VideoPbFragment.this.z().P0()).param("fid", VideoPbFragment.this.z().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                    if (VideoPbFragment.this.z().X1(intValue)) {
                        VideoPbFragment.this.Q = true;
                    }
                }
            }
            return z;
        }

        public final int b(int i2) {
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 0) {
                return 2;
            }
            return i2 == 1 ? 3 : 0;
        }
    }

    /* loaded from: classes3.dex */
    public class v extends CustomMessageListener {
        public v(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2921552) {
                return;
            }
            VideoPbFragment.this.o3();
        }
    }

    /* loaded from: classes3.dex */
    public class v0 implements c.d {
        public v0() {
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void a(boolean z, int i2) {
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (VideoPbFragment.this.M0 != null && VideoPbFragment.this.M0.a() != null) {
                    VideoPbFragment.this.M0.a().A(new d.a.i0.w.a(45, 27, null));
                }
                VideoPbFragment.this.C2();
            }
        }

        @Override // d.a.j0.q0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes3.dex */
    public class w implements DialogInterface.OnCancelListener {
        public w() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class w0 implements AntiHelper.k {
        public w0() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes3.dex */
    public class x implements d.a.i0.w.w.c {
        public x() {
        }

        @Override // d.a.i0.w.w.c
        public void a() {
            VideoPbFragment.this.showProgressBar();
        }
    }

    /* loaded from: classes3.dex */
    public class x0 implements View.OnClickListener {
        public x0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.j4();
        }
    }

    /* loaded from: classes3.dex */
    public class y implements View.OnClickListener {
        public y() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i2;
            int i3;
            int i4;
            boolean W1;
            int i5;
            if (view == null || !VideoPbFragment.this.isAdded()) {
                return;
            }
            int i6 = 1;
            if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", VideoPbFragment.this.z().O0());
                statisticItem2.param("fid", VideoPbFragment.this.z().getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                if (VideoPbFragment.this.g0) {
                    VideoPbFragment.this.g0 = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.P0 == null || postData.t() == null || postData.A() == 1 || !VideoPbFragment.this.checkUpIsLogin()) {
                            return;
                        }
                        if (VideoPbFragment.this.O0 != null) {
                            VideoPbFragment.this.O0.c();
                        }
                        d.a.j0.d2.h.q qVar = new d.a.j0.d2.h.q();
                        qVar.A(VideoPbFragment.this.z().y0().l());
                        qVar.E(VideoPbFragment.this.z().y0().L());
                        qVar.C(postData);
                        VideoPbFragment.this.P0.E(qVar);
                        VideoPbFragment.this.P0.setPostId(postData.E());
                        VideoPbFragment.this.P3(view, postData.t().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.a.j0.d2.m.a.b(VideoPbFragment.this.z().y0(), postData, postData.d0, 8, 1);
                        if (VideoPbFragment.this.M0 != null) {
                            VideoPbFragment videoPbFragment = VideoPbFragment.this;
                            videoPbFragment.r4(videoPbFragment.M0.C());
                        }
                    }
                }
            } else if ((VideoPbFragment.this.B3() && VideoPbFragment.this.f3() != null && VideoPbFragment.this.f3().Z0() != null && view == VideoPbFragment.this.f3().Z0()) || ((VideoPbFragment.this.Q2() != null && VideoPbFragment.this.Q2().b1() != null && view == VideoPbFragment.this.Q2().b1()) || view.getId() == R.id.pb_more)) {
                if (!VideoPbFragment.this.Q && VideoPbFragment.this.z().h1(true)) {
                    VideoPbFragment.this.Q = true;
                    if (VideoPbFragment.this.B3()) {
                        VideoPbFragment.this.f3().n1();
                    } else {
                        VideoPbFragment.this.Q2().s1();
                    }
                }
            } else {
                d.a.j0.d2.o.n.a aVar = VideoPbFragment.this.S;
                if (aVar != null && aVar.O() != null && view == VideoPbFragment.this.S.O().e()) {
                    VideoPbFragment.this.S.H();
                    return;
                }
                d.a.j0.d2.o.n.a aVar2 = VideoPbFragment.this.S;
                if ((aVar2 == null || ((aVar2.O() == null || view != VideoPbFragment.this.S.O().h()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    if (view == videoPbFragment2.t) {
                        if (videoPbFragment2.z() == null || VideoPbFragment.this.z().y0() == null) {
                            return;
                        }
                        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            StatisticItem statisticItem3 = new StatisticItem("c13266");
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("fid", VideoPbFragment.this.z().y0().m());
                            statisticItem3.param("tid", VideoPbFragment.this.z().O0());
                            statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(statisticItem3);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        d.a.c.e.p.l.x(VideoPbFragment.this.f20144e, VideoPbFragment.this.t);
                        VideoPbFragment.this.f20144e.finish();
                    } else if (view == videoPbFragment2.v && videoPbFragment2.S != null) {
                        if (d.a.i0.z0.l.a()) {
                            return;
                        }
                        if (VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null) {
                            ArrayList<PostData> D = VideoPbFragment.this.z().y0().D();
                            if ((D == null || D.size() <= 0) && VideoPbFragment.this.z().M0()) {
                                d.a.c.e.p.l.M(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", VideoPbFragment.this.z().O0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", VideoPbFragment.this.z().getForumId()));
                            VideoPbFragment.this.S.h0();
                            return;
                        }
                        d.a.c.e.p.l.M(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                    } else if (VideoPbFragment.this.S.O() != null && view == VideoPbFragment.this.S.O().k()) {
                        if (VideoPbFragment.this.z() == null) {
                            return;
                        }
                        VideoPbFragment.this.S.E();
                        if (d.a.c.e.p.j.z()) {
                            VideoPbFragment.this.R4();
                            VideoPbFragment.this.x4();
                            VideoPbFragment.this.z().R1(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else {
                        d.a.j0.d2.o.n.a aVar3 = VideoPbFragment.this.S;
                        if (aVar3 != null && aVar3.O() != null && view == VideoPbFragment.this.S.O().h()) {
                            VideoPbFragment.this.S.H();
                            return;
                        }
                        d.a.j0.d2.o.n.a aVar4 = VideoPbFragment.this.S;
                        if (aVar4 != null && ((aVar4.O() != null && view == VideoPbFragment.this.S.O().q()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                            VideoPbFragment.this.S.E();
                            if (d.a.c.e.p.j.z()) {
                                if (!VideoPbFragment.this.Q) {
                                    VideoPbFragment.this.R4();
                                    VideoPbFragment.this.x4();
                                    VideoPbFragment.this.S.w0(view);
                                    return;
                                }
                                view.setTag(Integer.valueOf(VideoPbFragment.this.z().K0()));
                                return;
                            }
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        d.a.j0.d2.o.n.a aVar5 = VideoPbFragment.this.S;
                        if (aVar5 != null && aVar5.O() != null && view == VideoPbFragment.this.S.O().p()) {
                            if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null) {
                                return;
                            }
                            VideoPbFragment.this.S.H();
                            TiebaStatic.log(new StatisticItem("c13062"));
                            VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
                            videoPbFragment3.S.S(videoPbFragment3.z().y0().L().f0());
                        } else if (view.getId() == R.id.pb_floor_feedback) {
                            try {
                                sparseArray = (SparseArray) view.getTag();
                            } catch (ClassCastException e2) {
                                e2.printStackTrace();
                                sparseArray = null;
                            }
                            d.a.j0.d2.o.n.a aVar6 = VideoPbFragment.this.S;
                            if (aVar6 != null) {
                                aVar6.m0(sparseArray);
                            }
                        } else {
                            d.a.j0.d2.o.n.a aVar7 = VideoPbFragment.this.S;
                            if (aVar7 != null && aVar7.O() != null && view == VideoPbFragment.this.S.O().n()) {
                                int skinType = TbadkCoreApplication.getInst().getSkinType();
                                if (skinType == 1) {
                                    VideoPbFragment.this.onChangeSkinType(skinType);
                                    SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                } else if (skinType == 0 || skinType == 4) {
                                    UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                                    VideoPbFragment.this.onChangeSkinType(skinType);
                                    UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                                    TbadkCoreApplication.getInst().setSkinType(1);
                                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                }
                                VideoPbFragment.this.S.I();
                                return;
                            }
                            d.a.j0.d2.o.n.a aVar8 = VideoPbFragment.this.S;
                            if (aVar8 != null && aVar8.O() != null && view == VideoPbFragment.this.S.O().o()) {
                                VideoPbFragment.this.S.I();
                                VideoPbFragment videoPbFragment4 = VideoPbFragment.this;
                                videoPbFragment4.S.u0(videoPbFragment4.I1);
                                return;
                            }
                            d.a.j0.d2.o.n.a aVar9 = VideoPbFragment.this.S;
                            if (aVar9 != null && (view == aVar9.K() || (VideoPbFragment.this.S.O() != null && (view == VideoPbFragment.this.S.O().l() || view == VideoPbFragment.this.S.O().m())))) {
                                if (!d.a.c.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                } else if ((VideoPbFragment.this.z() == null && VideoPbFragment.this.z().y0() == null) || VideoPbFragment.this.Y.K()) {
                                    return;
                                } else {
                                    VideoPbFragment.this.S.E();
                                    if (VideoPbFragment.this.S.O() != null && view == VideoPbFragment.this.S.O().m()) {
                                        i4 = VideoPbFragment.this.z().y0().L().x0() == 1 ? 5 : 4;
                                    } else if (VideoPbFragment.this.S.O() != null && view == VideoPbFragment.this.S.O().l()) {
                                        i4 = VideoPbFragment.this.z().y0().L().w0() == 1 ? 3 : 6;
                                    } else {
                                        i4 = view == VideoPbFragment.this.S.K() ? 2 : 0;
                                    }
                                    ForumData l = VideoPbFragment.this.z().y0().l();
                                    String name = l.getName();
                                    String id = l.getId();
                                    String o0 = VideoPbFragment.this.z().y0().L().o0();
                                    VideoPbFragment.this.showProgressBar();
                                    VideoPbFragment.this.Y.O(id, name, o0, i4, VideoPbFragment.this.S.L());
                                    return;
                                }
                            }
                            d.a.j0.d2.o.n.a aVar10 = VideoPbFragment.this.S;
                            if (aVar10 != null && aVar10.O() != null && view == VideoPbFragment.this.S.O().g()) {
                                if (VideoPbFragment.this.z() == null) {
                                    return;
                                }
                                if (!d.a.c.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbFragment.this.S.E();
                                VideoPbFragment videoPbFragment5 = VideoPbFragment.this;
                                SparseArray<Object> X2 = videoPbFragment5.X2(videoPbFragment5.z().y0(), VideoPbFragment.this.z().M0(), 1);
                                if (X2 == null) {
                                    return;
                                }
                                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.z().y0().l().getId(), VideoPbFragment.this.z().y0().l().getName(), VideoPbFragment.this.z().y0().L().o0(), String.valueOf(VideoPbFragment.this.z().y0().R().getUserId()), (String) X2.get(R.id.tag_forbid_user_name), (String) X2.get(R.id.tag_forbid_user_name_show), (String) X2.get(R.id.tag_forbid_user_post_id), (String) X2.get(R.id.tag_forbid_user_portrait))));
                                return;
                            }
                            d.a.j0.d2.o.n.a aVar11 = VideoPbFragment.this.S;
                            if (aVar11 != null && aVar11.O() != null && view == VideoPbFragment.this.S.O().f()) {
                                if (VideoPbFragment.this.z() == null) {
                                    return;
                                }
                                if (!d.a.c.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbFragment videoPbFragment6 = VideoPbFragment.this;
                                SparseArray<Object> X22 = videoPbFragment6.X2(videoPbFragment6.z().y0(), VideoPbFragment.this.z().M0(), 1);
                                if (X22 != null) {
                                    if (StringUtils.isNull((String) X22.get(R.id.tag_del_multi_forum))) {
                                        VideoPbFragment.this.S.d0(((Integer) X22.get(R.id.tag_del_post_type)).intValue(), (String) X22.get(R.id.tag_del_post_id), ((Integer) X22.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X22.get(R.id.tag_del_post_is_self)).booleanValue());
                                    } else {
                                        VideoPbFragment.this.S.e0(((Integer) X22.get(R.id.tag_del_post_type)).intValue(), (String) X22.get(R.id.tag_del_post_id), ((Integer) X22.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) X22.get(R.id.tag_del_post_is_self)).booleanValue(), (String) X22.get(R.id.tag_del_multi_forum));
                                    }
                                }
                                VideoPbFragment.this.S.H();
                            } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                    if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                        if (view.getId() == R.id.pb_editor_tool_share) {
                                            VideoPbFragment.this.i3(true);
                                        } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                            if (view.getId() == R.id.tv_pb_reply_more) {
                                                if (VideoPbFragment.this.V0 >= 0) {
                                                    if (VideoPbFragment.this.z() != null) {
                                                        VideoPbFragment.this.z().D1();
                                                    }
                                                    if (VideoPbFragment.this.B3() && VideoPbFragment.this.z() != null && VideoPbFragment.this.f3() != null && VideoPbFragment.this.f3().E0() != null) {
                                                        VideoPbFragment.this.f3().E0().f(VideoPbFragment.this.z().y0());
                                                    } else if (VideoPbFragment.this.Q2() != null && VideoPbFragment.this.Q2().E0() != null) {
                                                        VideoPbFragment.this.Q2().E0().u(VideoPbFragment.this.z().y0());
                                                    }
                                                    VideoPbFragment.this.V0 = 0;
                                                    VideoPbFragment.this.W0 = Integer.MIN_VALUE;
                                                    if (VideoPbFragment.this.B3() && VideoPbFragment.this.z() != null && VideoPbFragment.this.f3() != null) {
                                                        VideoPbFragment.this.f3().j1(VideoPbFragment.this.z().r0(), VideoPbFragment.this.z().q0());
                                                        VideoPbFragment.this.z().H1(0, 0);
                                                    } else if (VideoPbFragment.this.z() == null || VideoPbFragment.this.Q2() == null) {
                                                    } else {
                                                        VideoPbFragment.this.Q2().n1(VideoPbFragment.this.z().r0(), VideoPbFragment.this.z().q0());
                                                        VideoPbFragment.this.z().H1(0, 0);
                                                    }
                                                }
                                            } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                if (VideoPbFragment.this.z() == null) {
                                                    return;
                                                }
                                                StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                statisticItem4.param("tid", VideoPbFragment.this.z().O0());
                                                statisticItem4.param("fid", VideoPbFragment.this.z().getForumId());
                                                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem4.param("obj_locate", 2);
                                                TiebaStatic.log(statisticItem4);
                                            } else if (view.getId() == R.id.pb_item_tail_content) {
                                                if (ViewHelper.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                    String p = d.a.i0.r.d0.b.j().p("tail_link", "");
                                                    if (!StringUtils.isNull(p)) {
                                                        TiebaStatic.log("c10056");
                                                        d.a.i0.l.a.o(view.getContext(), string, p, true, true, true);
                                                    }
                                                    VideoPbFragment.this.j4();
                                                }
                                            } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                VideoPbFragment.this.j4();
                                            } else if (VideoPbFragment.this.S.O() != null && view == VideoPbFragment.this.S.O().d()) {
                                                VideoPbFragment.this.S.E();
                                                if (VideoPbFragment.this.z() != null) {
                                                    VideoPbFragment.this.x.i(VideoPbFragment.this.z().O0());
                                                }
                                                if (VideoPbFragment.this.z() == null || !VideoPbFragment.this.z().isPrivacy()) {
                                                    VideoPbFragment.this.x.c();
                                                    if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.z() != null && VideoPbFragment.this.z().y0() != null && VideoPbFragment.this.z().y0().N() != null && VideoPbFragment.this.z().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                        i6 = 2;
                                                    }
                                                    if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null) {
                                                        return;
                                                    }
                                                    VideoPbFragment.this.x.e(3, i6, VideoPbFragment.this.z().y0().N());
                                                    return;
                                                }
                                                VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                if (VideoPbFragment.this.z().y0() != null) {
                                                    VideoPbFragment.this.x.e(3, 3, VideoPbFragment.this.z().y0().N());
                                                }
                                            } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                statisticItem5.param("tid", VideoPbFragment.this.z().O0());
                                                statisticItem5.param("fid", VideoPbFragment.this.z().getForumId());
                                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem5.param("obj_locate", 7);
                                                TiebaStatic.log(statisticItem5);
                                                VideoPbFragment.this.S.j0(false);
                                                VideoPbFragment.this.S.N().onLongClick(view);
                                            }
                                        } else if (VideoPbFragment.this.z() != null) {
                                            VideoPbFragment videoPbFragment7 = VideoPbFragment.this;
                                            if (videoPbFragment7.S == null || videoPbFragment7.f20148i == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || !VideoPbFragment.this.checkUpIsLogin()) {
                                                return;
                                            }
                                            d.a.j0.d2.h.e y0 = VideoPbFragment.this.z().y0();
                                            int Z0 = y0.L().Z0();
                                            int currentItem = VideoPbFragment.this.f20148i.getCurrentItem();
                                            if (Z0 == 0) {
                                                if (VideoPbFragment.this.B3() && currentItem == VideoPbFragment.N1) {
                                                    VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.O1);
                                                }
                                                VideoPbFragment.this.I2(false);
                                                VideoPbFragment.this.b4();
                                                return;
                                            }
                                            if (VideoPbFragment.this.B3() && currentItem == VideoPbFragment.N1) {
                                                VideoPbFragment.this.f20148i.setCurrentItem(VideoPbFragment.O1);
                                            } else if ((VideoPbFragment.this.B3() && VideoPbFragment.this.f3() == null) || VideoPbFragment.this.Q2() == null || VideoPbFragment.this.e3() == null) {
                                                return;
                                            } else {
                                                StatisticItem param = new StatisticItem("c13403").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                int i7 = (int) (d.a.c.e.p.l.i(VideoPbFragment.this.getContext()) * 0.6d);
                                                BdTypeRecyclerView e3 = VideoPbFragment.this.e3();
                                                if (e3 == null) {
                                                    return;
                                                }
                                                boolean canScrollVertically = e3.canScrollVertically(1);
                                                boolean canScrollVertically2 = e3.canScrollVertically(-1);
                                                if (VideoPbFragment.this.m != null) {
                                                    VideoPbFragment.this.m.setExpanded(false, true);
                                                }
                                                if (e3.getLayoutManager() == null || !(e3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                    return;
                                                }
                                                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) e3.getLayoutManager();
                                                if (!canScrollVertically2 && canScrollVertically) {
                                                    if (VideoPbFragment.this.T0 == -1 && VideoPbFragment.this.U0 == Integer.MIN_VALUE) {
                                                        return;
                                                    }
                                                    if (VideoPbFragment.this.T0 > 3 || (VideoPbFragment.this.T0 == 3 && VideoPbFragment.this.U0 < (-i7))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.T0, VideoPbFragment.this.U0 + i7);
                                                        e3.smoothScrollBy(0, i7);
                                                    } else if (VideoPbFragment.this.T0 >= 2) {
                                                        int i8 = i7 / 2;
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.T0, VideoPbFragment.this.U0 + i8);
                                                        e3.smoothScrollBy(0, i8);
                                                    } else if (VideoPbFragment.this.T0 == 1) {
                                                        int i9 = i7 / 4;
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.T0, VideoPbFragment.this.U0 + i9);
                                                        e3.smoothScrollBy(0, i9);
                                                    } else {
                                                        e3.smoothScrollBy(0, -VideoPbFragment.this.U0);
                                                    }
                                                    param.param("obj_locate", 2);
                                                    i3 = 1;
                                                } else {
                                                    int firstVisiblePosition = e3.getFirstVisiblePosition();
                                                    View childAt = e3.getChildAt(0);
                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                    VideoPbFragment.this.T0 = firstVisiblePosition;
                                                    VideoPbFragment.this.U0 = top;
                                                    if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || e3.getCount() < 6)) {
                                                        e3.smoothScrollToPosition(0);
                                                    } else {
                                                        linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                        e3.smoothScrollToPosition(0);
                                                    }
                                                    i3 = 1;
                                                    param.param("obj_locate", 1);
                                                }
                                                TiebaStatic.log(param);
                                                d.a.i0.i0.c f2 = TbPageExtraHelper.f(view);
                                                StatisticItem statisticItem6 = new StatisticItem("c12942");
                                                statisticItem6.param("obj_type", i3);
                                                statisticItem6.param("obj_locate", 4);
                                                statisticItem6.param("tid", VideoPbFragment.this.z().O0());
                                                statisticItem6.param("nid", y0.L().L0());
                                                if (f2 != null) {
                                                    statisticItem6.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                }
                                                if (TbPageExtraHelper.m() != null) {
                                                    statisticItem6.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                }
                                                TiebaStatic.log(statisticItem6);
                                            }
                                            if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.z().y0().L() == null || VideoPbFragment.this.z().y0().L().T() == null) {
                                                return;
                                            }
                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()).param("obj_locate", 2).param("uid", VideoPbFragment.this.z().y0().L().T().getUserId()));
                                        }
                                    } else if (!d.a.c.e.p.j.z()) {
                                        VideoPbFragment.this.showToast(R.string.network_not_available);
                                    } else {
                                        VideoPbFragment videoPbFragment8 = VideoPbFragment.this;
                                        if (videoPbFragment8.S == null || videoPbFragment8.z() == null) {
                                            return;
                                        }
                                        if (VideoPbFragment.this.B3() && VideoPbFragment.this.f3() == null) {
                                            return;
                                        }
                                        if (VideoPbFragment.this.B3() || VideoPbFragment.this.Q2() != null) {
                                            VideoPbFragment.this.S.E();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.a.i0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_shoucang"))) {
                                                if (!VideoPbFragment.this.z2(11009) || VideoPbFragment.this.z() == null) {
                                                    return;
                                                }
                                                VideoPbFragment.this.R3();
                                                if (VideoPbFragment.this.z().y0() != null && VideoPbFragment.this.z().y0().L() != null && VideoPbFragment.this.z().y0().L().T() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.z().O0()).param("fid", VideoPbFragment.this.z().y0().m()).param("obj_locate", 3).param("uid", VideoPbFragment.this.z().y0().L().T().getUserId()));
                                                }
                                                if (VideoPbFragment.this.z().y0().L() == null || VideoPbFragment.this.z().y0().L().T() == null || VideoPbFragment.this.z().y0().L().T().getUserId() == null || VideoPbFragment.this.U == null) {
                                                    return;
                                                }
                                                VideoPbFragment videoPbFragment9 = VideoPbFragment.this;
                                                int Q = videoPbFragment9.S.Q(videoPbFragment9.z().y0());
                                                a2 L = VideoPbFragment.this.z().y0().L();
                                                if (L.O1()) {
                                                    i2 = 2;
                                                } else if (L.R1()) {
                                                    i2 = 3;
                                                } else if (L.P1()) {
                                                    i2 = 4;
                                                } else {
                                                    i2 = L.Q1() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", VideoPbFragment.this.z().O0()).param("obj_locate", 1).param("obj_id", VideoPbFragment.this.z().y0().L().T().getUserId()).param("obj_type", !VideoPbFragment.this.U.e()).param("obj_source", Q).param("obj_param1", i2));
                                                return;
                                            }
                                            VideoPbFragment.this.D = view;
                                        }
                                    }
                                } else if (VideoPbFragment.this.z() == null) {
                                } else {
                                    if (view.getId() == R.id.pb_post_reply) {
                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                        statisticItem7.param("tid", VideoPbFragment.this.z().O0());
                                        statisticItem7.param("fid", VideoPbFragment.this.z().getForumId());
                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem7.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem7);
                                    }
                                    if (view.getId() == R.id.post_info_commont_img) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new d.a.i0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                            VideoPbFragment.this.C = view;
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.a.i0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                        VideoPbFragment.this.C = view;
                                        return;
                                    }
                                    if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                                        if (sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                            if (view.getId() == R.id.pb_post_reply && (statisticItem = postData2.e0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", VideoPbFragment.this.z().P0()).param("fid", VideoPbFragment.this.z().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.E()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null || VideoPbFragment.this.P0 == null || postData2.t() == null || postData2.A() == 1) {
                                                return;
                                            }
                                            if (VideoPbFragment.this.O0 != null) {
                                                VideoPbFragment.this.O0.c();
                                            }
                                            if (VideoPbFragment.this.Y0 && postData2.M() != null && postData2.M().size() != 0) {
                                                VideoPbFragment.this.P4(postData2, null, true, false);
                                                return;
                                            }
                                            d.a.j0.d2.h.q qVar2 = new d.a.j0.d2.h.q();
                                            qVar2.A(VideoPbFragment.this.z().y0().l());
                                            qVar2.E(VideoPbFragment.this.z().y0().L());
                                            qVar2.C(postData2);
                                            VideoPbFragment.this.P0.E(qVar2);
                                            VideoPbFragment.this.P0.setPostId(postData2.E());
                                            VideoPbFragment.this.P3(view, postData2.t().getUserId(), "", postData2);
                                            if (VideoPbFragment.this.M0 != null) {
                                                VideoPbFragment videoPbFragment10 = VideoPbFragment.this;
                                                videoPbFragment10.r4(videoPbFragment10.M0.C());
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                    statisticItem8.param("tid", VideoPbFragment.this.z().O0());
                                    statisticItem8.param("fid", VideoPbFragment.this.z().getForumId());
                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem8.param("obj_locate", 4);
                                    TiebaStatic.log(statisticItem8);
                                }
                                if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new d.a.i0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                    VideoPbFragment.this.B = view;
                                } else if (!VideoPbFragment.this.checkUpIsLogin()) {
                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", VideoPbFragment.this.z().y0().m()));
                                } else if (VideoPbFragment.this.z() == null || VideoPbFragment.this.z().y0() == null) {
                                } else {
                                    d.a.j0.d2.o.n.a aVar12 = VideoPbFragment.this.S;
                                    if (aVar12 != null) {
                                        aVar12.E();
                                    }
                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                    PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_reply_data);
                                    if (postData3 == null) {
                                        return;
                                    }
                                    if (postData3.C() == 1) {
                                        TiebaStatic.log(new StatisticItem("c12630"));
                                    }
                                    StatisticItem statisticItem9 = postData3.e0;
                                    if (statisticItem9 != null) {
                                        StatisticItem copy2 = statisticItem9.copy();
                                        copy2.delete("obj_locate");
                                        if (view.getId() == R.id.new_sub_pb_list_richText) {
                                            copy2.param("obj_locate", 6);
                                        } else if (view.getId() == R.id.pb_floor_reply_more) {
                                            copy2.param("obj_locate", 8);
                                        }
                                        TiebaStatic.log(copy2);
                                    }
                                    VideoPbFragment.this.R4();
                                    TiebaStatic.log("c11742");
                                    if (postData4 != null) {
                                        VideoPbFragment.this.P4(postData3, postData4, false, true);
                                    } else {
                                        VideoPbFragment.this.P4(postData3, null, false, false);
                                    }
                                }
                            }
                        }
                    }
                } else if (!d.a.c.e.p.j.z()) {
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                    view.setTag(Boolean.FALSE);
                } else {
                    VideoPbFragment.this.S.E();
                    if (!VideoPbFragment.this.Q) {
                        VideoPbFragment.this.R4();
                        VideoPbFragment.this.x4();
                        if (view.getId() == R.id.owner_reply) {
                            W1 = VideoPbFragment.this.z().W1(true, VideoPbFragment.this.T2());
                        } else {
                            W1 = view.getId() == R.id.all_reply ? VideoPbFragment.this.z().W1(false, VideoPbFragment.this.T2()) : VideoPbFragment.this.z().V1(VideoPbFragment.this.T2());
                        }
                        view.setTag(Boolean.valueOf(W1));
                        if (W1) {
                            VideoPbFragment.this.G4();
                            i5 = 1;
                            VideoPbFragment.this.Q = true;
                        } else {
                            i5 = 1;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i5, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y0 implements d.a.i0.w.b {
        public y0() {
        }

        @Override // d.a.i0.w.b
        public void onAction(d.a.i0.w.a aVar) {
            Object obj = aVar.f49951c;
            if (obj instanceof d.a.i0.s.c.v) {
                if (((d.a.i0.s.c.v) obj).e() == EmotionGroupType.BIG_EMOTION || ((d.a.i0.s.c.v) aVar.f49951c).e() == EmotionGroupType.USER_COLLECT) {
                    if (VideoPbFragment.this.K0 == null) {
                        VideoPbFragment.this.K0 = new PermissionJudgePolicy();
                    }
                    VideoPbFragment.this.K0.clearRequestPermissionList();
                    VideoPbFragment.this.K0.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (VideoPbFragment.this.K0.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                        return;
                    }
                    VideoPbFragment.this.M0.h((d.a.i0.s.c.v) aVar.f49951c);
                    VideoPbFragment.this.M0.z(false, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z implements View.OnClickListener {
        public z() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            d.a.j0.d2.o.n.a aVar = VideoPbFragment.this.S;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        VideoPbFragment.this.S.A(sparseArray);
                        return;
                    }
                    aVar.g0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    VideoPbFragment.this.S.A(sparseArray);
                } else if (booleanValue3) {
                    aVar.d0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z0 implements TextWatcher {
        public z0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.a.j0.d2.k.e.u0 u0Var = VideoPbFragment.this.E0;
            if (u0Var == null || u0Var.e() == null) {
                return;
            }
            if (!VideoPbFragment.this.E0.e().e()) {
                VideoPbFragment.this.E0.a(false);
            }
            VideoPbFragment.this.E0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int i5;
            if (VideoPbFragment.this.N0 != null && VideoPbFragment.this.N0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i5 = i4 + i2) && TextUtils.isEmpty(charSequence.toString().substring(i2, i5))) {
            }
        }
    }

    public static /* synthetic */ float I3(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public static VideoPbFragment T3() {
        return new VideoPbFragment();
    }

    @Override // d.a.j0.d2.o.i
    public PbActivity A() {
        return this.f20144e;
    }

    @Override // d.a.j0.d2.o.i
    public PbFragment A0() {
        return null;
    }

    public boolean A2() {
        if ((z() != null && z().y0().a0()) || this.B0 == null || z() == null || z().y0() == null || ThreadCardUtils.isSelf(z().y0().L()) || z().y0().d() == null) {
            return true;
        }
        return this.B0.checkPrivacyBeforeInvokeEditor(z().y0().d().replyPrivateFlag);
    }

    public final void A3() {
        if (this.p == null) {
            this.p = new d.a.j0.d2.o.l(getBaseFragmentActivity(), this.n);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? d.a.c.e.p.l.r(A()) : 0;
            Rect rect = new Rect(0, r2, d.a.c.e.p.l.k(getContext()), this.n.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.p.r(videoPbViewModel.h(), rect);
            if (this.p.l()) {
                this.p.q(new j0(videoPbViewModel));
            } else if (B3() && (videoPbViewModel.m() || z().N0() == O1)) {
                this.f20148i.setCurrentItem(O1);
            } else if (videoPbViewModel.m() || z().N0() == P1) {
                this.f20148i.setCurrentItem(P1);
            }
        }
    }

    public void A4(boolean z2) {
        this.y = z2;
    }

    public boolean B2(int i2) {
        if (this.B0 == null || z() == null || z().y0() == null || ThreadCardUtils.isSelf(z().y0().L()) || z().y0().d() == null) {
            return true;
        }
        return this.B0.checkPrivacyBeforeSend(z().y0().d().replyPrivateFlag, i2);
    }

    public boolean B3() {
        return z() != null && z().c1();
    }

    public final void B4(boolean z2) {
        this.M0.f0(z2);
        this.M0.i0(z2);
        this.M0.p0(z2);
    }

    public void C2() {
        if (!checkUpIsLogin()) {
            if (z() != null) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", z().getForumId()));
            }
        } else if (A2()) {
            d.a.i0.w.w.e eVar = this.M0;
            if (eVar != null && (eVar.B() || this.M0.D())) {
                this.M0.z(false, null);
                return;
            }
            if (this.N0 != null) {
                w3();
                this.t0.f20216a = false;
                if (this.N0.n(2) != null) {
                    d.a.j0.d3.g0.a.c(getPageContext(), (View) this.N0.n(2).k, false, null);
                }
            }
            j3();
        }
    }

    public final boolean C3() {
        d.a.j0.d2.o.r.a aVar = this.o;
        return aVar != null && aVar.Q0();
    }

    public final void C4(int i2, AntiData antiData, String str) {
        if (AntiHelper.m(i2, str)) {
            if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new w0()) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        } else if (i2 == 230277) {
            d.a.j0.d2.o.n.a aVar = this.S;
            if (aVar != null) {
                aVar.x0(str);
            }
        } else {
            showToast(str);
        }
    }

    public final void D2() {
        if (z().e0() || z().h0()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", z().O0());
            this.f20144e.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, z().O0()));
        if (T4()) {
            this.f20144e.finish();
        }
    }

    public boolean D3() {
        return this.v1;
    }

    public final void D4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                d.a.i0.s.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            } else {
                d.a.j0.d3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                return;
            }
        }
        if (z() != null && !z().m0()) {
            antiData.setBlock_forum_name(z().y0().l().getName());
            antiData.setBlock_forum_id(z().y0().l().getId());
            antiData.setUser_name(z().y0().R().getUserName());
            antiData.setUser_id(z().y0().R().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void E2(ForumManageModel.b bVar) {
        List<PostData> list = z().y0().Q().f52071a;
        int size = list.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.get(i2).M().size()) {
                    break;
                } else if (bVar.f21667g.equals(list.get(i2).M().get(i3).E())) {
                    list.get(i2).M().remove(i3);
                    list.get(i2).m();
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            list.get(i2).o(bVar.f21667g);
        }
        if (z2) {
            if (Q2() != null) {
                Q2().g1();
            } else if (B3() && f3() != null) {
                f3().d1();
            }
        }
    }

    public boolean E3() {
        d.a.j0.d2.o.r.a aVar = this.o;
        if (aVar == null) {
            return false;
        }
        return aVar.R0();
    }

    public void E4(boolean z2) {
        if (this.j0 == null) {
            return;
        }
        r4(this.M0.C());
        if (this.v0) {
            F4(z2);
        } else {
            k3(z2);
        }
        Z3();
        c4();
    }

    public void F2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        int intValue = ((Integer) sparseArray.get(Q1)).intValue();
        if (intValue == R1) {
            if (this.Y.K()) {
                return;
            }
            showProgressBar();
            String str = (String) sparseArray.get(R.id.tag_del_post_id);
            int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            if (jSONArray != null) {
                this.Y.M(StringHelper.JsonArrayToString(jSONArray));
            }
            this.Y.N(z().y0().l().getId(), z().y0().l().getName(), z().y0().L().o0(), str, intValue3, intValue2, booleanValue, z().y0().L().V());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
        } else if (intValue == S1 || intValue == T1) {
            if (z().W() != null) {
                z().W().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
            }
            if (intValue == S1) {
                TiebaStatic.log("c10499");
            }
        }
    }

    public final void F3(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public void F4(boolean z2) {
        TextView textView;
        if (this.j0 == null || (textView = this.m0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.j0.startAnimation(alphaAnimation);
        }
        this.i0.setVisibility(0);
        this.j0.setVisibility(0);
        this.t0.f20216a = true;
    }

    public void G2(d.a.i0.r.s.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (z() == null || z().y0() == null || z().y0().L() == null || z().y0().l() == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (aVar.getYesButtonTag() instanceof SparseArray) {
                F2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                return;
            }
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
    }

    public final void G3(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getPageContext().getPageActivity(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public void G4() {
        View view = this.R;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void H2(int i2, String str, int i3, boolean z2) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(Q1, Integer.valueOf(R1));
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            F2(sparseArray, null);
        } else {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public /* synthetic */ void H3(View view) {
        d.a.j0.d2.o.p.a aVar = this.A;
        if (aVar != null && !aVar.v()) {
            TiebaStatic.log(new StatisticItem("c13591"));
        } else if (this.A != null) {
            TiebaStatic.log(new StatisticItem("c13608").param("tid", z().y0().N()));
            this.A.q = true;
        }
        K4();
    }

    public void H4() {
        RightFloatLayerView rightFloatLayerView = this.a1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.g();
        }
    }

    public void I2(boolean z2) {
        AppBarLayout appBarLayout = this.m;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(z2);
        }
    }

    public final void I4(int i2) {
        d.a.j0.d2.o.q.a.c(A(), P2(), i2);
    }

    public final void J2(ForumManageModel.b bVar, boolean z2) {
        if (bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f21662b) ? bVar.f21662b : getString(R.string.delete_fail);
        int i2 = 0;
        if (bVar.f21663c == 1211066) {
            hideProgressBar();
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(R.string.dialog_known, new r());
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else {
            K2(0, bVar.f21661a, bVar.f21662b, z2);
        }
        if (bVar.f21661a) {
            int i3 = bVar.f21664d;
            if (i3 == 1) {
                ArrayList<PostData> D = z().y0().D();
                int size = D.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.f21667g.equals(D.get(i2).E())) {
                        D.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                z().y0().L().Z3(z().y0().L().Z0() - 1);
                if (Q2() != null) {
                    Q2().g1();
                } else if (B3() && f3() != null) {
                    f3().d1();
                }
            } else if (i3 == 0) {
                D2();
            } else if (i3 == 2) {
                ArrayList<PostData> D2 = z().y0().D();
                int size2 = D2.size();
                boolean z3 = false;
                for (int i4 = 0; i4 < size2 && !z3; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= D2.get(i4).M().size()) {
                            break;
                        } else if (bVar.f21667g.equals(D2.get(i4).M().get(i5).E())) {
                            D2.get(i4).M().remove(i5);
                            D2.get(i4).m();
                            z3 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    D2.get(i4).o(bVar.f21667g);
                }
                if (z3) {
                    if (Q2() != null) {
                        Q2().g1();
                    } else if (B3() && f3() != null) {
                        f3().d1();
                    }
                }
                E2(bVar);
            }
        }
    }

    public /* synthetic */ void J3(d.a.i0.t.a aVar, int i2, View view) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + d.a.c.e.p.k.getUrlEncode(aVar.d())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    public final void J4() {
        if (z() == null || d.a.c.e.p.k.isEmpty(z().O0())) {
            return;
        }
        d.a.i0.a.c.y().P(d.a.i0.a.b.W, d.a.c.e.m.b.f(z().O0(), 0L));
    }

    public void K2(int i2, boolean z2, String str, boolean z3) {
        hideProgressBar();
        if (z2 && z3) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z3) {
            if (d.a.c.e.p.k.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    public /* synthetic */ void K3(ValueAnimator valueAnimator) {
        this.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public final void K4() {
        if (this.z.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            V4();
        }
    }

    public final void L2(int i2, ForumManageModel.g gVar) {
        String string;
        if (gVar == null || z() == null || z().y0() == null || z().y0().L() == null) {
            return;
        }
        K2(this.Y.getLoadDataMode(), gVar.f21682a, gVar.f21683b, false);
        if (gVar.f21682a) {
            this.x0 = true;
            if (i2 == 2 || i2 == 3) {
                this.y0 = true;
                this.z0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.y0 = false;
                this.z0 = true;
            }
            if (i2 == 2) {
                z().y0().L().L3(1);
                z().J1(1);
            } else if (i2 == 3) {
                z().y0().L().L3(0);
                z().J1(0);
            } else if (i2 == 4) {
                z().y0().L().M3(1);
                z().K1(1);
            } else if (i2 == 5) {
                z().y0().L().M3(0);
                z().K1(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f21683b)) {
                string = gVar.f21683b;
            } else {
                string = getString(R.string.operation_failed);
            }
            d.a.c.e.p.l.M(getPageContext().getPageActivity(), string);
        }
        if (z().y0().L() == null || R2() == null) {
            return;
        }
        R2().V0();
    }

    public /* synthetic */ void L3(ValueAnimator valueAnimator) {
        this.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void L4(final d.a.i0.t.a aVar, Bitmap bitmap, final int i2) {
        if (d.a.j0.d2.k.e.r0.a(aVar, i2)) {
            final Random random = new Random();
            c.b bVar = new c.b(bitmap);
            bVar.p(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new c.InterfaceC1202c() { // from class: d.a.j0.d2.o.e
                @Override // d.a.j0.d2.p.c.InterfaceC1202c
                public final float a() {
                    return VideoPbFragment.I3(random);
                }
            });
            bVar.q(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d.a.j0.d2.p.c l2 = bVar.l();
            this.O.f();
            this.O.a(l2, 22);
            d.a.c.e.m.e.a().postDelayed(this.K1, 2000L);
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            TbImageView tbImageView = this.P;
            if (tbImageView != null) {
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: d.a.j0.d2.o.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        VideoPbFragment.this.J3(aVar, i2, view);
                    }
                });
            }
        }
    }

    public final String M2(int i2) {
        if (i2 == 0) {
            return getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i2 > 9990000) {
            return "· · ·";
        }
        if (i2 >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i2 / 10000.0f) + "W";
        } else if (i2 >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i2 / 10000.0f) + "W";
        } else {
            return "" + i2;
        }
    }

    public /* synthetic */ void M3(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2, ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * U1);
        layoutParams.height = floatValue;
        layoutParams2.height = i2 + floatValue;
        this.z.setLayoutParams(layoutParams);
        this.m.setLayoutParams(layoutParams2);
    }

    public final void M4() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.z.setAlpha(0.0f);
            this.z.setVisibility(0);
            X4(layoutParams);
        }
    }

    public d.a.i0.s.e.a N2() {
        return this.X;
    }

    public /* synthetic */ void N3(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i2, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i3 = U1;
        int i4 = (int) (floatValue * i3);
        layoutParams.height = i4;
        layoutParams2.height = (i2 - i3) + i4;
        this.z.setLayoutParams(layoutParams);
        this.m.setLayoutParams(layoutParams2);
    }

    public final void N4() {
        if (this.B1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
            this.B1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.B1.start();
    }

    public LinearLayout O2() {
        return this.k0;
    }

    public final void O3() {
        if (this.l0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.l0.setImageResource(0);
            this.l0.V(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.l0.setImageResource(R.drawable.transparent_bg);
    }

    public final void O4() {
        if (this.A1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
            this.A1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.A1.start();
    }

    public final int P2() {
        if (z() == null || z().y0() == null || z().y0().L() == null) {
            return -1;
        }
        return z().y0().L().G();
    }

    public final void P3(View view, String str, String str2, PostData postData) {
        if (view == null || str == null || str2 == null || y2() || !A2()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.R0);
            this.S0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.O0 != null && postData != null) {
            this.O0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.t().getName_show(), postData.K() != null ? postData.K().toString() : ""));
        }
        if (z() != null && z().y0() != null && z().y0().a0()) {
            d.a.c.e.m.e.a().postDelayed(new a1(str, str2), 0L);
            return;
        }
        if (this.D0 == null) {
            d.a.j0.q0.f2.a.c cVar = new d.a.j0.q0.f2.a.c(getPageContext());
            this.D0 = cVar;
            cVar.k(1);
            this.D0.j(new b1(str, str2));
        }
        if (z() == null || z().y0() == null || z().y0().l() == null) {
            return;
        }
        this.D0.g(z().y0().l().getId(), d.a.c.e.m.b.f(z().O0(), 0L));
    }

    public final void P4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        PbActivity.e n2;
        PostData S2;
        String O0 = z().O0();
        String E = postData.E();
        String E2 = postData2 != null ? postData2.E() : "";
        int S = z().y0() != null ? z().y0().S() : 0;
        if (f3() != null && f3().b1() != null) {
            n2 = f3().b1().n(E);
        } else if (Q2() == null || Q2().d1() == null) {
            return;
        } else {
            n2 = Q2().d1().n(E);
        }
        PbActivity.e eVar = n2;
        if (postData == null || z() == null || z().y0() == null || eVar == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(O0, E, "pb", true, null, false, E2, S, postData.O(), z().y0().d(), false, postData.t().getIconInfo()).addBigImageData(eVar.f19653a, eVar.f19654b, eVar.f19659g, eVar.j);
        boolean z4 = true;
        if (z3) {
            addBigImageData.setHighLightPostId(E2);
            addBigImageData.setKeyIsUseSpid(true);
        }
        addBigImageData.setKeyFromForumId(z().getForumId());
        addBigImageData.setBjhData(z().T());
        addBigImageData.setKeyPageStartFrom(z().x0());
        addBigImageData.setFromFrsForumId(z().getFromForumId());
        addBigImageData.setIsOpenEditor(z2);
        if (z().y0().o() != null) {
            addBigImageData.setHasForumRule(z().y0().o().has_forum_rule.intValue());
        }
        if (z().y0().R() != null) {
            addBigImageData.setIsManager(z().y0().R().getIs_manager());
        }
        if (z().y0().l().getDeletedReasonInfo() != null) {
            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(z().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(z().y0().l().getDeletedReasonInfo().is_boomgrow.intValue());
        }
        if (z().y0().l() != null) {
            addBigImageData.setForumHeadUrl(z().y0().l().getImage_url());
            addBigImageData.setUserLevel(z().y0().l().getUser_level());
        }
        if (z() != null && (S2 = S2(z().y0())) != null) {
            if (!S2.S && !postData.S) {
                z4 = false;
            }
            addBigImageData.setMainPostMaskVisibly(z4);
        }
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.r
    public void Q(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.a.i0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.a.i0.b1.m.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (d.a.j0.d2.k.e.x0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.a.i0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public DetailInfoAndReplyFragment Q2() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(P1) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.j.b(P1);
    }

    public final void Q3() {
        if (z() == null) {
            return;
        }
        d.a.j0.d2.h.e y02 = z().y0();
        z().T1(true);
        d.a.i0.h.a aVar = this.U;
        if (aVar != null) {
            y02.q0(aVar.g());
        }
        if (B3()) {
            if (R2() != null) {
                R2().P0();
            }
            if (f3() != null) {
                f3().d1();
            }
        } else if (Q2() != null) {
            Q2().g1();
        }
    }

    public void Q4() {
        FallingView fallingView = this.O;
        if (fallingView != null) {
            fallingView.g();
        }
        if (this.P != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.K1);
            this.P.setVisibility(8);
        }
    }

    public DetailInfoFragment R2() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(N1) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.j.b(N1);
    }

    public final void R3() {
        MarkData R;
        if (z() == null || z().y0() == null) {
            return;
        }
        if (B3() && f3() == null) {
            return;
        }
        if ((B3() || Q2() != null) && this.U != null) {
            if (z().y0() != null && z().y0().a0()) {
                R = z().R(0);
            } else {
                CustomViewPager customViewPager = this.f20148i;
                if (customViewPager != null && customViewPager.getCurrentItem() == N1) {
                    R = z().s0(S2(z().y0()));
                } else if (B3()) {
                    R = z().R(f3().W0());
                } else {
                    R = z().R(Q2().Y0());
                }
            }
            if (R == null) {
                return;
            }
            if (R.isApp() && (R = z().R(f3().W0() + 1)) == null) {
                return;
            }
            x4();
            this.U.i(R);
            if (!this.U.e()) {
                this.U.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.U.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void R4() {
        VoiceManager voiceManager = this.Z;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    public PostData S2(d.a.j0.d2.h.e eVar) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.T() != null) {
            return eVar.T();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next != null && next.A() == 1) {
                    postData = next;
                    break;
                }
            }
        }
        if (postData == null) {
            postData = eVar.j();
        }
        if (postData == null) {
            postData = d3(eVar);
        }
        if (postData != null && postData.t() != null && postData.t().getUserTbVipInfoData() != null && postData.t().getUserTbVipInfoData().getvipIntro() != null) {
            postData.t().getGodUserData().setIntro(postData.t().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public final boolean S3(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p2 = d.a.i0.r.d0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                d.a.i0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), p2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return false;
    }

    public final void S4() {
        this.f20144e.superCloseActivity();
    }

    public final String T2() {
        ArrayList<PostData> D;
        int count;
        if (z() == null || z().y0() == null || z().y0().D() == null || (count = ListUtils.getCount((D = z().y0().D()))) == 0) {
            return "";
        }
        if (z().J0()) {
            Iterator<PostData> it = D.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.A() == 1) {
                    return next.E();
                }
            }
        }
        int i2 = 0;
        if (e3() != null) {
            if (B3()) {
                i2 = f3().U0();
            } else {
                i2 = Q2().W0();
            }
        }
        PostData postData = (PostData) ListUtils.getItem(D, i2);
        if (postData != null && postData.t() != null) {
            if (z().f1(postData.t().getUserId())) {
                return postData.E();
            }
            for (int i3 = i2 - 1; i3 != 0; i3--) {
                PostData postData2 = (PostData) ListUtils.getItem(D, i3);
                if (postData2 == null || postData2.t() == null || postData2.t().getUserId() == null) {
                    break;
                } else if (z().f1(postData2.t().getUserId())) {
                    return postData2.E();
                }
            }
            for (int i4 = i2 + 1; i4 < count; i4++) {
                PostData postData3 = (PostData) ListUtils.getItem(D, i4);
                if (postData3 == null || postData3.t() == null || postData3.t().getUserId() == null) {
                    break;
                } else if (z().f1(postData3.t().getUserId())) {
                    return postData3.E();
                }
            }
        }
        return "";
    }

    public final boolean T4() {
        if (z() == null) {
            return true;
        }
        if (z().y0() == null || !z().y0().a0()) {
            if (z().k0()) {
                MarkData X = z().X();
                if (X != null && z().i0() && e3() != null) {
                    MarkData R = z().R(e3().getFirstVisiblePosition());
                    if (R == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", X);
                        this.f20144e.setResult(-1, intent);
                        return true;
                    } else if (R.getPostId() != null && !R.getPostId().equals(X.getPostId())) {
                        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(getBaseFragmentActivity());
                        aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                        aVar.setPositiveButton(R.string.confirm, new t(R, X, aVar));
                        aVar.setNegativeButton(R.string.cancel, new u(X, aVar));
                        aVar.setOnCalcelListener(new w());
                        aVar.create(getBaseFragmentActivity().getPageContext());
                        aVar.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", X);
                        this.f20144e.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (z().y0() != null && z().y0().D() != null && z().y0().D().size() > 0 && z().i0()) {
                this.f20144e.setResult(1);
            }
            return true;
        }
        return true;
    }

    public boolean U2() {
        return this.y;
    }

    public void U3(boolean z2) {
        this.l.setVisibility(z2 ? 0 : 8);
    }

    public void U4() {
        d.a.i0.w.w.e eVar = this.M0;
        if (eVar != null) {
            r4(eVar.C());
        }
        j4();
        this.S.E();
    }

    public View.OnClickListener V2() {
        return this.G1;
    }

    public final void V3() {
        if (!d.a.c.e.p.j.z()) {
            showToast(R.string.network_not_available);
        } else if (this.S == null || z() == null) {
        } else {
            this.S.E();
            if (this.Q) {
                return;
            }
            R4();
            x4();
            if (z().LoadData()) {
                G4();
            }
        }
    }

    public final void V4() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.N = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d.a.j0.d2.o.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    VideoPbFragment.this.K3(valueAnimator2);
                }
            });
            this.N.setDuration(200L);
            this.N.start();
            this.N.addListener(new e1(layoutParams));
        }
    }

    @Override // d.a.j0.d2.o.i
    public PbModel.g W() {
        return this.c1;
    }

    public View.OnClickListener W2() {
        return this.H1;
    }

    public void W3(int i2) {
        RightFloatLayerView rightFloatLayerView;
        if (i2 == 0) {
            d.a.j0.c3.c.g().h(getUniqueId(), false);
            if (e3() != null) {
                x2(e3(), true);
            }
        }
        if (i2 == 0) {
            RightFloatLayerView rightFloatLayerView2 = this.a1;
            if (rightFloatLayerView2 != null) {
                rightFloatLayerView2.q();
            }
        } else if (i2 == 1) {
            RightFloatLayerView rightFloatLayerView3 = this.a1;
            if (rightFloatLayerView3 != null) {
                rightFloatLayerView3.p();
            }
        } else if (i2 != 2 || (rightFloatLayerView = this.a1) == null) {
        } else {
            rightFloatLayerView.r();
        }
    }

    public final void W4() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.setDuration(300L);
        this.M.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d.a.j0.d2.o.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.L3(valueAnimator);
            }
        });
        this.M.start();
    }

    public SparseArray<Object> X2(d.a.j0.d2.h.e eVar, boolean z2, int i2) {
        PostData S2;
        d.a.i0.r.q.d0 d0Var;
        int i3;
        StringBuilder sb = null;
        if (eVar == null || (S2 = S2(eVar)) == null) {
            return null;
        }
        String userId = S2.t().getUserId();
        boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i2 == 0) {
            sparseArray.put(R.id.tag_del_post_id, S2.E());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.S()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
        } else if (i2 == 1) {
            if (S2.t() != null) {
                sparseArray.put(R.id.tag_forbid_user_name, S2.t().getUserName());
                sparseArray.put(R.id.tag_forbid_user_name_show, S2.t().getName_show());
                sparseArray.put(R.id.tag_forbid_user_portrait, S2.t().getPortrait());
                sparseArray.put(R.id.tag_forbid_user_post_id, S2.E());
            }
            sparseArray.put(R.id.tag_del_post_id, S2.E());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.S()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
        }
        if (!z3) {
            List<w1> p2 = eVar.p();
            if (ListUtils.getCount(p2) > 0) {
                sb = new StringBuilder();
                for (w1 w1Var : p2) {
                    if (w1Var != null && !StringUtils.isNull(w1Var.g()) && (d0Var = w1Var.f49300g) != null && d0Var.f49125a && !d0Var.f49127c && ((i3 = d0Var.f49126b) == 1 || i3 == 2)) {
                        sb.append(d.a.c.e.p.k.cutString(w1Var.g(), 12));
                        sb.append(TbadkCoreApplication.getInst().getString(R.string.forum));
                        sb.append("、");
                    }
                }
            }
            if (sb != null && !StringUtils.isNull(sb.toString())) {
                sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
            }
        }
        return sparseArray;
    }

    public void X3(boolean z2) {
        if (A() == null) {
            return;
        }
        if (this.v1 && !TbSingleton.getInstance().isNotchScreen(A()) && !TbSingleton.getInstance().isCutoutScreen(A())) {
            N4();
            UtilHelper.hideStatusBar(A(), A().getRootView());
            this.v1 = false;
        }
        this.t0.f20217b = z2;
        Z3();
        c4();
    }

    public final void X4(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        final int i2 = layoutParams2.height;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d.a.j0.d2.o.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.M3(layoutParams, layoutParams2, i2, valueAnimator);
            }
        });
        this.M.setDuration(300L);
        this.M.start();
        this.M.addListener(new g1());
    }

    public d.a.i0.h.a Y2() {
        return this.U;
    }

    public void Y3(d.a.i0.t.a aVar, int i2) {
        if (d.a.j0.d2.k.e.r0.a(aVar, i2)) {
            this.P.V(aVar.f(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.e())).setProgressiveRenderingEnabled(true).build(), getPageContext()).subscribe(new m0(aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public final void Y4(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        final int i2 = layoutParams2.height;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.M = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: d.a.j0.d2.o.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.N3(layoutParams, layoutParams2, i2, valueAnimator);
            }
        });
        this.M.setDuration(300L);
        this.M.start();
        this.M.addListener(new f1());
    }

    public View.OnLongClickListener Z2() {
        return this.L1;
    }

    public final void Z3() {
        if (this.o == null) {
            return;
        }
        if (this.t0.a()) {
            this.o.X(false);
            return;
        }
        d.a.j0.d2.o.r.a aVar = this.o;
        aVar.X(!aVar.R0());
    }

    public final void Z4() {
        if (z() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.x(z().getForumId()) || z().y0() == null || z().y0().l() == null) {
            return;
        }
        if (z().y0().l().isLike() == 1) {
            z().O().w(z().getForumId(), z().O0());
        }
    }

    public View.OnTouchListener a3() {
        return this.D1;
    }

    public final void a4(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        a2 L = eVar.L();
        if (L != null && L.y2()) {
            w2();
        } else {
            u4(this.L0);
        }
        d.a.i0.w.w.e eVar2 = this.M0;
        if (eVar2 != null) {
            r4(eVar2.C());
            this.M0.M(eVar.d());
            this.M0.N(eVar.l(), eVar.R());
            this.M0.r0(L);
            if (z() != null) {
                this.M0.O(z().c0(), z().O0(), z().Z());
            }
            if (L != null) {
                this.M0.h0(L.l2());
            }
        }
    }

    public void a5(d.a.j0.d2.h.e eVar) {
        if (eVar != null && AntiHelper.o(eVar.L())) {
            d.a.j0.d2.p.h hVar = this.q0;
            if (hVar != null) {
                hVar.h(false);
                this.q0.g();
            }
            ViewGroup.LayoutParams layoutParams = this.p0.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.p0.setLayoutParams(layoutParams);
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            return;
        }
        d.a.j0.d2.p.h hVar2 = this.q0;
        if (hVar2 == null || !hVar2.e()) {
            ViewGroup.LayoutParams layoutParams2 = this.p0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.p0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.p0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public d.a.i0.w.w.e b3() {
        return this.M0;
    }

    public void b4() {
        if (!checkUpIsLogin() || z() == null || z().y0() == null || z().y0().l() == null || y2()) {
            return;
        }
        if (z().y0().a0()) {
            C2();
            return;
        }
        if (this.C0 == null) {
            d.a.j0.q0.f2.a.c cVar = new d.a.j0.q0.f2.a.c(getPageContext());
            this.C0 = cVar;
            cVar.k(0);
            this.C0.j(new v0());
        }
        this.C0.g(z().y0().l().getId(), d.a.c.e.m.b.f(z().O0(), 0L));
    }

    public void b5(boolean z2) {
        DetailInfoAndReplyFragment Q2 = Q2();
        if (Q2 != null && Q2.E0() != null && Q2.E0().l() != null && Q2.E0().m() != null) {
            Q2.E0().l().W0(z2);
            Q2.E0().m().r0(z2);
        }
        MaskView maskView = this.E;
        if (maskView != null) {
            maskView.setVisibility(z2 ? 0 : 8);
        }
    }

    public final int c3(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? 1 : 7;
            }
            return 6;
        }
        return 5;
    }

    public final void c4() {
        if (this.o == null || this.f20148i == null) {
            return;
        }
        boolean z2 = false;
        if (!B3()) {
            this.o.V0(false);
        } else if (this.f20148i.getCurrentItem() != 0) {
            this.o.V0(false);
        } else if (this.t0.a()) {
            this.o.V0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.o.V0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public final PostData d3(d.a.j0.d2.h.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.L() == null || eVar.L().T() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData T = eVar.L().T();
        String userId = T.getUserId();
        HashMap<String, MetaData> E1 = eVar.L().E1();
        if (E1 != null && (metaData = E1.get(userId)) != null && metaData.getUserId() != null) {
            T = metaData;
        }
        postData.i0(1);
        postData.l0(eVar.L().f0());
        postData.x0(eVar.L().x1());
        postData.w0(eVar.L().Z());
        postData.g0(T);
        return postData;
    }

    public void d4(boolean z2, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
        for (BaseFragment baseFragment : this.j.c()) {
            if (baseFragment instanceof d.a.j0.d2.o.h) {
                ((d.a.j0.d2.o.h) baseFragment).x0(z2, i2, i3, i4, eVar, str, i5);
            }
        }
        x0(z2, i2, i3, i4, eVar, str, i5);
    }

    public BdTypeRecyclerView e3() {
        Iterator<BaseFragment> it = this.j.c().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).Z0();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).X0();
            }
        }
        return null;
    }

    public void e4(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        a5(eVar);
        this.o0.setVisibility(eVar.a0() ? 8 : 0);
        if (eVar.r()) {
            WebPManager.setPureDrawable(this.o0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.o0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String M2 = M2(eVar.L().Z0());
        TextView textView = this.r0;
        if (textView != null) {
            textView.setText(M2);
        }
        TextView textView2 = this.s0;
        if (textView2 != null) {
            textView2.setText(M2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.L()));
    }

    public ReplyFragment f3() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(O1) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.j.b(O1);
    }

    public void f4(boolean z2, MarkData markData) {
        if (z() == null) {
            return;
        }
        w4();
        z().T1(z2);
        d.a.i0.h.a aVar = this.U;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.U.i(markData);
            }
        }
        if (z().k0()) {
            Q3();
        } else if (B3()) {
            if (R2() != null) {
                R2().P0();
            }
            if (f3() != null) {
                f3().d1();
            }
        } else if (Q2() != null) {
            Q2().g1();
        }
    }

    @Override // d.a.j0.d2.o.i
    public void finish() {
        CardHListViewData q2;
        PbModel pbModel = this.f20144e.getPbModel();
        if (pbModel != null && pbModel.y0() != null && !pbModel.y0().a0()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = pbModel.y0().L().o0();
            if (pbModel.isShareThread() && pbModel.y0().L().r1 != null) {
                historyMessage.threadName = pbModel.y0().L().r1.f12797b;
            } else {
                historyMessage.threadName = pbModel.y0().L().x1();
            }
            if (pbModel.isShareThread() && !isSimpleForum()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = pbModel.y0().l().getName();
            }
            ArrayList<PostData> D = pbModel.y0().D();
            int U0 = f3() != null ? f3().U0() : 0;
            if (D != null && U0 >= 0 && U0 < D.size()) {
                historyMessage.postID = D.get(U0).E();
            }
            historyMessage.isHostOnly = pbModel.d0();
            historyMessage.isSquence = pbModel.M0();
            historyMessage.isShareThread = pbModel.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        d.a.i0.w.w.e eVar = this.M0;
        if (eVar != null) {
            eVar.I();
        }
        if (pbModel != null && (pbModel.e0() || pbModel.h0())) {
            Intent intent = new Intent();
            intent.putExtra("tid", pbModel.O0());
            if (this.x0) {
                if (this.z0) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", pbModel.n0());
                }
                if (this.y0) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", pbModel.j0());
                }
            }
            if (pbModel.y0() != null && System.currentTimeMillis() - this.f20145f >= 40000 && (q2 = pbModel.y0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                intent.putExtra("guess_like_data", q2);
            }
            this.f20144e.setResult(-1, intent);
        }
        if (T4()) {
            if (pbModel != null) {
                d.a.j0.d2.h.e y02 = pbModel.y0();
                if (y02 != null) {
                    if (y02.R() != null) {
                        y02.R().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.A0) {
                        if (this.n != null) {
                            Rect rect = new Rect();
                            this.n.getGlobalVisibleRect(rect);
                            d.a.j0.d2.k.e.m0.b().t(rect);
                        }
                        d.a.j0.d2.k.e.m0.b().s(this.f20148i.getCurrentItem());
                        BdTypeRecyclerView e3 = e3();
                        d.a.j0.d2.k.e.m0.b().n(pbModel.z0(), e3 != null ? e3.onSaveInstanceState() : null, pbModel.M0(), pbModel.d0(), false);
                    }
                }
            } else {
                d.a.j0.d2.k.e.m0.b().m();
            }
            S4();
        }
    }

    public String g3() {
        if (!d.a.c.e.p.k.isEmpty(this.u0)) {
            return this.u0;
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(d.a.j0.d2.k.e.r0.b());
        this.u0 = string;
        return string;
    }

    public void g4(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.L().Z0());
        if (eVar.L().Z0() == 0) {
            valueOf = "";
        }
        this.f20147h.F(valueOf);
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<GifView> getGifViewPool() {
        if (this.a0 == null) {
            this.a0 = new d.a.c.e.k.b<>(new i1(), 20, 0);
        }
        return this.a0;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<ImageView> getImageViewPool() {
        if (this.c0 == null) {
            this.c0 = new d.a.c.e.k.b<>(new h1(), 8, 0);
        }
        return this.c0;
    }

    @Override // d.a.i0.b1.m.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.a.c.e.k.b<RelativeLayout> bVar = new d.a.c.e.k.b<>(new l1(), 10, 0);
        this.f0 = bVar;
        return bVar;
    }

    @Override // d.a.i0.b1.m.h
    public int getRichTextViewId() {
        return 0;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<TextView> getTextViewPool() {
        if (this.b0 == null) {
            this.b0 = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.b0;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.e0 == null) {
            this.e0 = new d.a.c.e.k.b<>(new k1(), 15, 0);
        }
        return this.e0;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.Z == null) {
            this.Z = VoiceManager.instance();
        }
        return this.Z;
    }

    @Override // d.a.i0.b1.m.h
    public d.a.c.e.k.b<View> getVoiceViewPool() {
        if (this.d0 == null) {
            this.d0 = new d.a.c.e.k.b<>(new j1(), 8, 0);
        }
        return this.d0;
    }

    public final void h3(int i2, Intent intent) {
        d.a.i0.w.n nVar;
        d.a.j0.d2.k.e.u uVar;
        d.a.i0.w.n nVar2;
        if (i2 == 0) {
            l3();
            d.a.j0.d2.k.e.u uVar2 = this.O0;
            if (uVar2 != null) {
                uVar2.c();
            }
            E4(false);
        }
        j4();
        if (intent == null) {
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
        if (serializableExtra instanceof PbEditorData) {
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType == 0) {
                this.M0.S();
                this.M0.t0(pbEditorData.getVoiceModel());
                this.M0.G(writeData);
                d.a.i0.w.m n2 = this.M0.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new d.a.i0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.M0.L(null, null);
                }
            } else if (editorType != 1 || (uVar = this.O0) == null || uVar.b() == null) {
            } else {
                d.a.i0.w.w.h b2 = this.O0.b();
                b2.X(z().y0().L());
                b2.z(writeData);
                b2.Y(pbEditorData.getVoiceModel());
                d.a.i0.w.m n3 = b2.a().n(6);
                if (n3 != null && (nVar2 = n3.k) != null) {
                    nVar2.onAction(new d.a.i0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    b2.D();
                }
            }
        }
    }

    public void h4(d.a.j0.d2.h.q qVar) {
        boolean z2;
        MetaData metaData;
        if (z() == null || z().y0() == null || qVar.i() == null) {
            return;
        }
        String E = qVar.i().E();
        ArrayList<PostData> D = z().y0().D();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= D.size()) {
                break;
            }
            PostData postData = D.get(i2);
            if (postData.E() == null || !postData.E().equals(E)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = qVar.k();
                postData.u0(qVar.m());
                if (postData.M() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.S() != null && next != null && next.t() != null && (metaData = postData.S().get(next.t().getUserId())) != null) {
                            next.g0(metaData);
                            next.o0(true);
                            next.z0(getPageContext(), z().f1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.M().size();
                    if (postData.M() != null && postData.M().size() < 2) {
                        postData.M().clear();
                        postData.M().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.e0();
                }
            }
        }
        if (z().i0() || !z2) {
            return;
        }
        if (B3() && f3() != null) {
            f3().d1();
        } else if (Q2() != null) {
            Q2().g1();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i3(boolean z2) {
        d.a.j0.d2.h.e y02;
        int i2;
        if (z() == null || this.S == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (y02 = z().y0()) == null) {
            return;
        }
        a2 L = y02.L();
        if (L != null && L.T() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", z().O0()).param("fid", y02.m()).param("obj_locate", 4).param("uid", L.T().getUserId()));
        }
        if (L != null) {
            if (L.O1()) {
                i2 = 2;
            } else if (L.R1()) {
                i2 = 3;
            } else if (L.P1()) {
                i2 = 4;
            } else if (L.Q1()) {
                i2 = 5;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem.param("tid", z().O0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", z().getForumId());
            if (!z2) {
                statisticItem.param("obj_locate", 6);
            } else {
                statisticItem.param("obj_locate", 5);
            }
            statisticItem.param("obj_name", i2);
            statisticItem.param("obj_type", 2);
            if (L != null) {
                if (L.O1()) {
                    statisticItem.param("obj_type", 10);
                } else if (L.R1()) {
                    statisticItem.param("obj_type", 9);
                } else if (L.Q1()) {
                    statisticItem.param("obj_type", 8);
                } else if (L.P1()) {
                    statisticItem.param("obj_type", 7);
                } else if (L.s1) {
                    statisticItem.param("obj_type", 6);
                } else {
                    int i3 = L.Z;
                    if (i3 == 0) {
                        statisticItem.param("obj_type", 1);
                    } else if (i3 == 40) {
                        statisticItem.param("obj_type", 2);
                    } else if (i3 == 49) {
                        statisticItem.param("obj_type", 3);
                    } else if (i3 == 54) {
                        statisticItem.param("obj_type", 4);
                    } else {
                        statisticItem.param("obj_type", 5);
                    }
                }
                statisticItem.param("nid", L.L0());
                statisticItem.param("card_type", L.U0());
                statisticItem.param("recom_source", L.R0);
                statisticItem.param("ab_tag", L.T0);
                statisticItem.param("weight", L.S0);
                statisticItem.param("extra", L.U0);
                statisticItem.param("nid", L.L0());
                if (L.V() != null && !d.a.c.e.p.k.isEmpty(L.V().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, L.V().oriUgcVid);
                }
            }
            if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (A() != null) {
                d.a.i0.j0.c.e(A(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
            if (d.a.c.e.p.l.D()) {
                showToast(R.string.neterror);
                return;
            } else if (z().y0() == null) {
                d.a.c.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> D = y02.D();
                if ((D == null || D.size() <= 0) && z().M0()) {
                    d.a.c.e.p.l.M(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                    return;
                }
                this.S.E();
                R4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), L)) {
                    return;
                }
                d.a.j0.d2.p.h hVar = this.q0;
                if (hVar != null) {
                    hVar.h(false);
                    a5(y02);
                }
                if (ShareSwitch.isOn()) {
                    I4(z2 ? 2 : 1);
                    return;
                }
                this.S.q0();
                z().V().u(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem2.param("tid", z().O0());
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("fid", z().getForumId());
        if (!z2) {
        }
        statisticItem2.param("obj_name", i2);
        statisticItem2.param("obj_type", 2);
        if (L != null) {
        }
        if (!d.a.c.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (A() != null) {
        }
        TiebaStatic.log(statisticItem2);
        if (d.a.c.e.p.l.D()) {
        }
    }

    public final void i4() {
        if (this.M0 == null || this.N0 == null) {
            return;
        }
        d.a.i0.w.w.a.a().c(0);
        this.M0.T();
        this.M0.R();
        if (this.M0.y() != null) {
            this.M0.y().setMaxImagesAllowed(this.M0.z ? 1 : 9);
        }
        this.M0.l0(SendView.k);
        this.M0.j(SendView.k);
        d.a.i0.w.h m2 = this.N0.m(23);
        d.a.i0.w.h m3 = this.N0.m(2);
        d.a.i0.w.h m4 = this.N0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.N0.invalidate();
    }

    public final void initData() {
        d.a.i0.h.a c2 = d.a.i0.h.a.c(this.f20144e);
        this.U = c2;
        if (c2 != null) {
            c2.j(this.d1);
        }
        ForumManageModel forumManageModel = new ForumManageModel(this.f20144e);
        this.Y = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.C1);
        this.X = new d.a.i0.s.e.a(getPageContext());
        this.S = new d.a.j0.d2.o.n.a(this);
    }

    public boolean isSimpleForum() {
        PbModel pbModel = this.f20144e.getPbModel();
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    public void j3() {
        if (this.j0 == null) {
            return;
        }
        this.i0.setVisibility(8);
        this.j0.setVisibility(8);
        this.t0.f20216a = false;
        Z3();
        c4();
    }

    public void j4() {
        i4();
        l3();
        this.O0.c();
        E4(false);
    }

    public void k3(boolean z2) {
        if (this.j0 == null || this.m0 == null) {
            return;
        }
        if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
            this.m0.setText(TbSingleton.getInstance().getAdVertiComment());
        } else {
            this.m0.setText(g3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.j0.startAnimation(alphaAnimation);
        }
        this.i0.setVisibility(0);
        this.j0.setVisibility(0);
        this.t0.f20216a = true;
    }

    public final void k4() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        layoutParams.height = 0;
        this.z.setLayoutParams(layoutParams);
        this.z.setVisibility(8);
    }

    public void l3() {
        EditorTools editorTools = this.N0;
        if (editorTools != null) {
            editorTools.o();
        }
    }

    public void l4() {
        this.T0 = -1;
        this.U0 = Integer.MIN_VALUE;
    }

    public void m3() {
        if (this.f20144e.getCurrentFocus() != null) {
            d.a.c.e.p.l.x(getPageContext().getPageActivity(), this.f20144e.getCurrentFocus());
        }
    }

    public boolean m4(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.u()) && d.a.i0.r.k.c().g()) {
                    return S3(postData.E());
                }
                if (checkUpIsLogin() && z() != null && z().y0() != null) {
                    d.a.j0.d2.k.e.u uVar = this.O0;
                    if (uVar != null) {
                        uVar.c();
                    }
                    d.a.j0.d2.h.q qVar = new d.a.j0.d2.h.q();
                    qVar.A(z().y0().l());
                    qVar.E(z().y0().L());
                    qVar.C(postData);
                    this.P0.E(qVar);
                    this.P0.setPostId(postData.E());
                    P3(view, postData.t().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    d.a.i0.w.w.e eVar = this.M0;
                    if (eVar != null) {
                        r4(eVar.C());
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void n3() {
        View view = this.R;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void n4(EmotionImageData emotionImageData) {
        if (emotionImageData == null) {
            return;
        }
        if (this.V == null) {
            d.a.j0.d2.k.e.a1.f.a aVar = new d.a.j0.d2.k.e.a1.f.a(this.f20144e);
            this.V = aVar;
            aVar.n(this.F1);
            this.V.m(this.o1);
        }
        this.V.k(emotionImageData, z(), z().y0());
    }

    public void o3() {
        RightFloatLayerView rightFloatLayerView = this.a1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.f();
        }
    }

    public final void o4(int i2) {
        if (z() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(z().O0());
            sendMessage(privacySettingMessage);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        a4(videoPbViewModel.c());
        g4(videoPbViewModel.c());
        if (z() != null && z().y0() != null) {
            boolean i02 = z().i0();
            d.a.j0.d2.h.e y02 = z().y0();
            if (i02) {
                PostData S2 = S2(y02);
                if (y02.t() != null && !y02.t().equals(S2.E()) && this.f20148i != null) {
                    if (B3()) {
                        this.f20148i.setCurrentItem(O1);
                    } else {
                        this.f20148i.setCurrentItem(P1);
                    }
                }
            }
        }
        videoPbViewModel.j().observe(this, new c0());
        videoPbViewModel.b().observe(this, new d0());
        videoPbViewModel.i().observe(this, new e0());
        videoPbViewModel.g().observe(this, new f0());
        videoPbViewModel.e().observe(this, new h0());
        videoPbViewModel.f().observe(this, new i0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i2, i3, intent);
        this.M0.H(i2, i3, intent);
        d.a.j0.d2.k.e.a1.f.a aVar = this.V;
        if (aVar != null) {
            aVar.i(i2, i3, intent);
        }
        d.a.j0.d2.k.e.u uVar = this.O0;
        if (uVar != null) {
            uVar.g(i2, i3, intent);
        }
        if (i2 == 25035) {
            h3(i3, intent);
        }
        if (i3 == -1) {
            if (i2 == 11009) {
                R3();
            } else if (i2 == 13011) {
                d.a.j0.r2.a.g().m(getPageContext());
            } else if (i2 != 25016 && i2 != 25023 && i2 != 24007 && i2 != 24008) {
                switch (i2) {
                    case 25055:
                        View view = this.B;
                        if (view != null) {
                            view.performClick();
                            return;
                        }
                        return;
                    case 25056:
                        View view2 = this.C;
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case 25057:
                        if (O2() != null) {
                            O2().performClick();
                            return;
                        }
                        return;
                    case 25058:
                        View view3 = this.D;
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } else {
                Serializable serializableExtra = intent.getSerializableExtra(PbSearchEmotionActivity.EMOTION_BACK_DATA);
                if (serializableExtra == null || !(serializableExtra instanceof EmotionImageData) || (emotionImageData = (EmotionImageData) serializableExtra) == null) {
                    return;
                }
                this.W = emotionImageData;
                if (B2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                    n4(emotionImageData);
                }
            }
        }
    }

    @Override // d.a.i0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.g0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f20144e = (PbActivity) context;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.f20144e);
        getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        getBaseFragmentActivity().getLayoutMode().j(this.f20146g);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0611);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0608);
        SkinManager.setBackgroundColor(this.f20147h, R.color.CAM_X0207);
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f20147h;
        if (newPagerSlidingTabBaseStrip != null) {
            newPagerSlidingTabBaseStrip.G();
        }
        d.a.j0.d2.k.e.u0 u0Var = this.E0;
        if (u0Var != null) {
            u0Var.i();
        }
        d.a.j0.d2.o.l lVar = this.p;
        if (lVar == null || !lVar.k()) {
            SkinManager.setBackgroundColor(this.f20146g, R.color.CAM_X0201);
        }
        EditorTools editorTools = this.N0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.a.j0.d2.k.e.u uVar = this.O0;
        if (uVar != null) {
            uVar.h(i2);
        }
        RightFloatLayerView rightFloatLayerView = this.a1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        HeadImageView headImageView = this.l0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.k0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        if (z() != null && z().k0()) {
            WebPManager.setPureDrawable(this.o0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.o0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.n0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.I, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (z() != null) {
            a5(z().y0());
        }
        SkinManager.setBackgroundResource(this.k, R.drawable.personalize_tab_shadow);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0206);
        SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.i0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.G, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.m0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.s0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r0, R.color.CAM_X0107);
        TextView textView = this.r0;
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        if (Q2() != null) {
            Q2().onChangeSkinType(i2);
        } else if (B3() && f3() != null) {
            f3().onChangeSkinType(i2);
        }
        if (R2() != null) {
            R2().onChangeSkinType(i2);
        }
        View view = this.L;
        if (view != null) {
            view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
        }
        R4();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d.a.j0.d2.o.r.a aVar = this.o;
        if (aVar == null || aVar.R0()) {
            return;
        }
        if (!(this.o.C() && configuration.orientation == 1) && (this.o.C() || configuration.orientation != 2)) {
            return;
        }
        this.o.V(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f20145f = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        s3(bundle);
        getVoiceManager().onCreate(getPageContext());
        d.a.i0.r.f0.c cVar = new d.a.i0.r.f0.c();
        this.T = cVar;
        cVar.f48836a = 1000L;
        if (this.S != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.S.B;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.S.B;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.x = new d.a.j0.w.a(getPageContext());
        d.a.j0.c3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20146g = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        z3();
        return this.f20146g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.c3.c.g().k(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        d.a.j0.d2.p.h hVar = this.q0;
        if (hVar != null) {
            hVar.g();
        }
        ForumManageModel forumManageModel = this.Y;
        if (forumManageModel != null) {
            forumManageModel.cancelLoadData();
        }
        d.a.j0.d2.o.r.a aVar = this.o;
        if (aVar != null) {
            aVar.S0();
        }
        d.a.j0.d2.k.e.a1.f.a aVar2 = this.V;
        if (aVar2 != null) {
            aVar2.f();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.B0;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        if (z() != null) {
            z().cancelLoadData();
            z().destory();
            if (z().u0() != null) {
                z().u0().d();
            }
        }
        d.a.i0.w.w.e eVar = this.M0;
        if (eVar != null) {
            eVar.I();
        }
        this.T = null;
        Q4();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.u1 && (this.v1 || C3())) {
            N4();
            UtilHelper.hideStatusBar(A(), A().getRootView());
            this.v1 = false;
            d.a.j0.d2.o.r.a aVar = this.o;
            if (aVar != null) {
                aVar.W0(false);
            }
        }
        if (i2 == 4) {
            return this.o.D();
        }
        if (i2 == 24) {
            return this.o.c0();
        }
        if (i2 == 25) {
            return this.o.T0();
        }
        return false;
    }

    @Override // d.a.i0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.g0 = true;
    }

    @Override // d.a.i0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        if (d.a.j0.d2.k.e.x0.c(str) && z() != null && z().O0() != null) {
            TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", z().O0()));
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.a.i0.t.m mVar = new d.a.i0.t.m();
                mVar.f49905a = str;
                mVar.f49906b = 3;
                mVar.f49907c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, mVar));
            }
        } else {
            d.a.j0.d2.k.e.x0.a().e(getPageContext(), str);
        }
        this.g0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.X0 = true;
        getVoiceManager().onPause(getPageContext());
        this.o.o0(true);
        if (z() != null && !z().m0()) {
            this.M0.U(z().O0());
        }
        d.a.i0.a.c.y().E();
        MessageManager.getInstance().unRegisterListener(this.l1);
        MessageManager.getInstance().unRegisterListener(this.m1);
        MessageManager.getInstance().unRegisterListener(this.k1);
        MessageManager.getInstance().unRegisterListener(this.J1);
    }

    @Override // d.a.i0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.S.k0(str);
        d.a.i0.r.s.b P = this.S.P();
        if (P == null) {
            this.S.U();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            P.f(1).setVisibility(8);
        } else {
            P.f(1).setVisibility(0);
        }
        P.m();
        this.g0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.X0 = false;
        getVoiceManager().onResume(getPageContext());
        this.o.o0(false);
        J4();
        registerListener(this.l1);
        registerListener(this.m1);
        registerListener(this.k1);
        registerListener(this.J1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (z() != null) {
            z().E1(bundle);
        }
        if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // d.a.i0.b1.m.h
    public void onSongClicked(Context context, String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        d.a.j0.c3.c.g().h(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        O3();
    }

    @Override // d.a.i0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        d.a.j0.d2.k.e.x0.a().e(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.g0 = true;
    }

    @Override // d.a.i0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public final void p3() {
        this.h0 = (LinearLayout) this.f20146g.findViewById(R.id.video_pb_comment_container);
        this.i0 = this.f20146g.findViewById(R.id.video_view_comment_top_line);
        this.j0 = this.f20146g.findViewById(R.id.pb_editor_tool_comment);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f20146g.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.l0 = headImageView;
        headImageView.setVisibility(0);
        this.l0.setIsRound(true);
        this.l0.setBorderWidth(d.a.c.e.p.l.g(getContext(), R.dimen.L_X01));
        this.l0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.l0.setPlaceHolder(0);
        O3();
        this.m0 = (TextView) this.f20146g.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f20146g.findViewById(R.id.pb_editer_tool_comment_layout);
        this.k0 = linearLayout;
        linearLayout.setOnClickListener(new o0());
        ImageView imageView = (ImageView) this.f20146g.findViewById(R.id.pb_editor_tool_comment_icon);
        this.n0 = imageView;
        imageView.setOnClickListener(this.G1);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView2 = (ImageView) this.f20146g.findViewById(R.id.pb_editor_tool_collection);
        this.o0 = imageView2;
        imageView2.setOnClickListener(this.G1);
        if (booleanExtra) {
            this.o0.setVisibility(8);
        } else {
            this.o0.setVisibility(0);
        }
        ImageView imageView3 = (ImageView) this.f20146g.findViewById(R.id.pb_editor_tool_share);
        this.p0 = imageView3;
        imageView3.setOnClickListener(this.G1);
        d.a.j0.d2.p.h hVar = new d.a.j0.d2.p.h(this.p0);
        this.q0 = hVar;
        hVar.d();
        TextView textView = (TextView) this.f20146g.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.r0 = textView;
        textView.setVisibility(0);
        E4(false);
    }

    public void p4(int i2) {
        LinearLayout linearLayout = this.h0;
        if (linearLayout != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public final void q3() {
        this.P0 = new PbFakeFloorModel(getPageContext());
        d.a.j0.d2.k.e.u uVar = new d.a.j0.d2.k.e.u(getPageContext(), this.P0, this.f20146g);
        this.O0 = uVar;
        uVar.k(new q0());
        this.O0.m(this.E1);
        this.P0.D(new s0());
    }

    public void q4(EditorTools editorTools) {
        this.N0 = editorTools;
        editorTools.setId(R.id.pb_editor);
        this.N0.setOnCancelClickListener(new x0());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.N0.getParent() == null) {
            this.f20146g.addView(this.N0, layoutParams);
        }
        this.N0.w(TbadkCoreApplication.getInst().getSkinType());
        this.N0.setActionListener(24, new y0());
        l3();
        this.M0.i(new z0());
    }

    public void r3() {
        q4(this.M0.a());
    }

    public void r4(boolean z2) {
        this.v0 = z2;
    }

    public final void s2() {
        if (z() == null || z().y0() == null || z().y0().L() == null) {
            return;
        }
        a2 L = z().y0().L();
        L.T0 = z().D0();
        L.S0 = z().G0();
        L.R0 = z().F0();
        L.U0 = z().E0();
        L.z2 = z().m0();
        if (L.c0() == 0) {
            L.u3(d.a.c.e.m.b.f(z().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.i0.j0.c.i(getContext(), L, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void s3(Bundle bundle) {
        d.a.i0.w.w.g gVar = new d.a.i0.w.w.g();
        this.L0 = gVar;
        u4(gVar);
        d.a.i0.w.w.e eVar = (d.a.i0.w.w.e) this.L0.a(getActivity());
        this.M0 = eVar;
        eVar.e0(this.f20144e.getPageContext());
        this.M0.n0(this.o1);
        this.M0.o0(this.F1);
        this.M0.g0(1);
        this.M0.F(this.f20144e.getPageContext(), bundle);
        this.M0.a().b(new d.a.i0.w.k(getActivity()));
        this.M0.a().C(true);
        B4(true);
        this.M0.O(z().c0(), z().O0(), z().Z());
        registerListener(this.g1);
        registerListener(this.i1);
        registerListener(this.q1);
        registerListener(this.f1);
        registerListener(this.h1);
        registerListener(this.j1);
        if (!z().m0()) {
            this.M0.s(z().O0());
        }
        if (TbSingleton.getInstance().getAdVertiSementData() != null && !TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiSementData().c())) {
            this.M0.k0(TbSingleton.getInstance().getAdVertiSementData().c());
        } else if (z().X0()) {
            this.M0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.M0.k0(g3());
        }
        this.E0 = new d.a.j0.d2.k.e.u0();
        if (this.M0.v() != null) {
            this.E0.m(this.M0.v().i());
        }
        this.M0.d0(this.e1);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.B0 = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new k0());
    }

    public void s4(boolean z2) {
        this.Q = z2;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        super.setPrimary(z2);
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || (customViewPager = this.f20148i) == null) {
            return;
        }
        videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
    }

    public final void t2(boolean z2) {
        if (z() == null || z().y0() == null || z().y0().L() == null) {
            return;
        }
        a2 L = z().y0().L();
        L.T0 = z().D0();
        L.S0 = z().G0();
        L.R0 = z().F0();
        L.U0 = z().E0();
        if (L.c0() == 0) {
            L.u3(d.a.c.e.m.b.f(z().getForumId(), 0L));
        }
        StatisticItem i2 = d.a.i0.j0.c.i(getContext(), L, "c13563");
        TbPageTag l2 = d.a.i0.j0.c.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.param("obj_type", 2);
            } else {
                i2.param("obj_type", 1);
            }
            d.a.i0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
    }

    public final void t3() {
        this.O = (FallingView) this.f20146g.findViewById(R.id.falling_view);
        TbImageView tbImageView = (TbImageView) this.f20146g.findViewById(R.id.falling_ad_view);
        this.P = tbImageView;
        tbImageView.setPlaceHolder(2);
    }

    public void t4(boolean z2) {
        this.v1 = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u2(a2 a2Var) {
        double d2;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect S;
        double k2 = d.a.c.e.p.l.k(getContext());
        double i3 = (2.0d * k2) / d.a.c.e.p.l.i(getContext());
        if (a2Var != null && a2Var.u1() != null) {
            int intValue = a2Var.u1().video_width.intValue();
            int intValue2 = a2Var.u1().video_height.intValue();
            if (intValue2 > 0) {
                d2 = (intValue * 1.0f) / intValue2;
                if (d2 > 1.7777777777777777d) {
                    d2 = 1.7777777777777777d;
                }
                if (d2 >= i3) {
                    i3 = d2;
                }
                int ceil = (int) Math.ceil(k2 / i3);
                int height = (z() != null || (S = z().S()) == null) ? ceil : S.height();
                i2 = 0;
                layoutParams = this.n.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i2 = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.n.setLayoutParams(layoutParams);
                this.n.setMaxHeight(ceil);
                this.n.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
                this.n.setOriginHeight(height);
                if (B3()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f20147h.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, V1);
                    } else {
                        layoutParams3.height = V1;
                    }
                    this.f20147h.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
                if (B3()) {
                    ceil += V1;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                }
                this.m.setLayoutParams(layoutParams2);
                if (i2 == 0 && (this.m.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.m.getLayoutParams()).getBehavior();
                    if (behavior instanceof VideoZoomBehavior) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i2);
                        return;
                    }
                    return;
                }
            }
        }
        d2 = 1.7777777777777777d;
        if (d2 > 1.7777777777777777d) {
        }
        if (d2 >= i3) {
        }
        int ceil2 = (int) Math.ceil(k2 / i3);
        if (z() != null) {
        }
        i2 = 0;
        layoutParams = this.n.getLayoutParams();
        if (layoutParams != null) {
        }
        this.n.setLayoutParams(layoutParams);
        this.n.setMaxHeight(ceil2);
        this.n.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
        this.n.setOriginHeight(height);
        if (B3()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
        if (B3()) {
        }
        if (layoutParams2 != null) {
        }
        this.m.setLayoutParams(layoutParams2);
        if (i2 == 0) {
        }
    }

    public final void u3() {
        this.G = (TextView) this.f20146g.findViewById(R.id.pb_video_mount_title);
        this.K = (TbImageView) this.f20146g.findViewById(R.id.pb_video_mount_pic);
        this.H = (TextView) this.f20146g.findViewById(R.id.pb_video_mount_desc);
        this.I = (ImageView) this.f20146g.findViewById(R.id.pb_video_mount_close);
        this.J = (TBSpecificationBtn) this.f20146g.findViewById(R.id.pb_video_mount_link);
        this.L = this.f20146g.findViewById(R.id.ala_live_point);
        this.K.setRadius(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
        this.K.setConrers(15);
        this.J.setConfig(new d.a.i0.r.f0.m.c());
        this.I.setOnClickListener(new View.OnClickListener() { // from class: d.a.j0.d2.o.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPbFragment.this.H3(view);
            }
        });
        this.J.setOnClickListener(this.F);
        this.z.setOnClickListener(this.F);
    }

    public final void u4(d.a.i0.w.w.g gVar) {
        if (gVar == null || z() == null) {
            return;
        }
        gVar.o(z().a0());
        if (z().y0() != null && z().y0().l() != null) {
            gVar.n(z().y0().l());
        }
        gVar.p("pb");
        gVar.q(z());
    }

    public final void v2(d.a.j0.d2.o.p.a aVar) {
        if (aVar == null || this.A != null) {
            return;
        }
        this.A = aVar;
        this.G.setText(aVar.u());
        this.H.setText(aVar.t());
        String s2 = aVar.s();
        TBSpecificationBtn tBSpecificationBtn = this.J;
        if (TextUtils.isEmpty(s2)) {
            s2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
        }
        tBSpecificationBtn.setText(s2);
        this.K.V(aVar.m(), 10, false);
        this.L.setVisibility(aVar.v() ? 0 : 8);
        d.a.c.e.m.e.a().postDelayed(new d1(), aVar.l().longValue() * 1000);
    }

    public final void v3() {
        NavigationBar navigationBar = (NavigationBar) this.f20146g.findViewById(R.id.video_pb_navigation_bar);
        this.q = navigationBar;
        navigationBar.setOnClickListener(new p0());
        this.q.hideBottomLine();
        this.q.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.q.getTopCoverBgView().setVisibility(0);
        this.r = this.f20146g.findViewById(R.id.statebar);
        View findViewById = this.f20146g.findViewById(R.id.status_bar_background);
        this.s = findViewById;
        if (this.u1) {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            layoutParams.height = d.a.c.e.p.l.r(A());
            this.r.setLayoutParams(layoutParams);
            this.r.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            layoutParams2.height = d.a.c.e.p.l.r(A());
            this.s.setLayoutParams(layoutParams2);
            this.s.setVisibility(0);
        }
        View addSystemImageButton = this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.G1);
        this.t = addSystemImageButton;
        this.u = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        View addCustomView = this.q.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.G1);
        this.v = addCustomView;
        this.w = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
        layoutParams3.rightMargin = g3;
        this.v.setLayoutParams(layoutParams3);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.v.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.x1 = new GestureDetector(getContext(), this.y1);
        this.q.setOnTouchListener(this.w1);
    }

    public void v4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        d.a.j0.d2.o.n.a aVar = this.S;
        if (aVar == null) {
            return;
        }
        if (z2) {
            aVar.E();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            this.S.F();
        } else {
            this.S.E();
        }
    }

    @Override // d.a.j0.d2.o.i
    public VideoPbFragment w() {
        return this;
    }

    public final void w2() {
        if (z() == null || this.f20144e == null) {
            return;
        }
        d.a.i0.w.w.e eVar = this.M0;
        if (eVar == null || !eVar.z) {
            d.a.i0.w.w.d dVar = new d.a.i0.w.w.d();
            u4(dVar);
            d.a.i0.w.w.e eVar2 = (d.a.i0.w.w.e) dVar.a(getContext());
            this.M0 = eVar2;
            eVar2.e0(this.f20144e.getPageContext());
            this.M0.n0(this.o1);
            this.M0.o0(this.F1);
            this.M0.F(this.f20144e.getPageContext(), this.f20144e.getIntent() == null ? null : this.f20144e.getIntent().getExtras());
            this.M0.a().C(true);
            q4(this.M0.a());
            if (!z().m0()) {
                this.M0.s(z().O0());
            }
            if (TbSingleton.getInstance().getAdVertiSementData() != null && !TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiSementData().c())) {
                this.M0.k0(TbSingleton.getInstance().getAdVertiSementData().c());
            } else if (z().X0()) {
                this.M0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.M0.k0(g3());
            }
        }
    }

    public void w3() {
        EditorTools editorTools = this.N0;
        if (editorTools == null) {
            return;
        }
        editorTools.j();
        d.a.i0.w.w.e eVar = this.M0;
        if (eVar != null) {
            eVar.P();
        }
        j3();
    }

    public void w4() {
        hideProgressBar();
        if (B3() && f3() != null) {
            f3().R0();
            f3().S0();
        } else if (Q2() != null) {
            Q2().T0();
            Q2().U0();
        }
    }

    @Override // d.a.j0.d2.o.h
    public void x0(boolean z2, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5) {
    }

    public void x2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
        int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
        ArrayList arrayList = new ArrayList();
        if (lastVisiblePosition > firstVisiblePosition) {
            while (firstVisiblePosition <= lastVisiblePosition) {
                if (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().B(firstVisiblePosition)) != null && postData.q() != null) {
                    postData.q().j(postData.A());
                    arrayList.add(postData.q());
                }
                firstVisiblePosition++;
            }
        }
        if (ListUtils.getItem(arrayList, 0) != null) {
            Collections.sort(arrayList, new m1());
            if (((d.a.i0.t.a) ListUtils.getItem(arrayList, 0)).c() != 1) {
                Q4();
                Y3((d.a.i0.t.a) ListUtils.getItem(arrayList, 0), 1);
            } else if (z2) {
            } else {
                Q4();
                Y3((d.a.i0.t.a) ListUtils.getItem(arrayList, 0), 0);
            }
        }
    }

    public void x3() {
        RightFloatLayerView rightFloatLayerView = this.a1;
        if (rightFloatLayerView == null) {
            return;
        }
        if (!rightFloatLayerView.n()) {
            o3();
            return;
        }
        d.a.i0.s.c.f adFloatViewData = TbSingleton.getInstance().getAdFloatViewData();
        this.Z0 = adFloatViewData;
        if (adFloatViewData == null) {
            return;
        }
        this.a1.setData(adFloatViewData.c());
        H4();
        TiebaStatic.log(new StatisticItem("c14128").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", 2));
        this.a1.setLogoListener(new g0(this.Z0.d()));
        this.a1.setFeedBackListener(new r0());
    }

    public void x4() {
        d.a.c.e.p.l.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    public final boolean y2() {
        PbModel z2 = z();
        if (z2 == null || z2.y0() == null) {
            return false;
        }
        a2 L = z2.y0().L();
        z2.y0().d();
        return AntiHelper.b(getPageContext(), L);
    }

    public final void y3() {
        this.f20147h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f20147h.setContainerLayoutParams(layoutParams);
        this.f20147h.setRectPaintColor(R.color.CAM_X0302);
        this.f20147h.C(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.f20147h.setIndicatorOffset(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.f20147h.setIndicatorOvershot(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.f20147h.setIndicatorMarginBottom(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.f20147h.setExpandedTabLayoutParams(layoutParams2);
    }

    public final void y4(int i2) {
        if (z() == null) {
            return;
        }
        int H0 = z().H0();
        if (i2 == 5) {
            z().Q1(2);
        } else if (i2 == 6) {
            z().Q1(3);
        } else if (i2 != 7) {
            z().Q1(1);
        } else {
            z().Q1(4);
        }
        int H02 = z().H0();
        if (H0 == 4 || H02 == 4) {
            V3();
        }
    }

    @Override // d.a.j0.d2.o.i
    public PbModel z() {
        return this.f20144e.getPbModel();
    }

    public final boolean z2(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public final void z3() {
        d.a.j0.f0.b bVar = new d.a.j0.f0.b(getActivity());
        this.Q0 = bVar;
        bVar.i(W1);
        this.u1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        v3();
        this.m = (AppBarLayout) this.f20146g.findViewById(R.id.appbar_layout);
        this.k = this.f20146g.findViewById(R.id.pb_video_pager_shadow);
        this.a1 = (RightFloatLayerView) this.f20146g.findViewById(R.id.right_layer_view);
        registerListener(this.b1);
        x3();
        this.n = (VideoContainerLayout) this.f20146g.findViewById(R.id.pb_video_container);
        d.a.j0.d2.o.r.a aVar = new d.a.j0.d2.o.r.a(getContext(), this.n);
        this.o = aVar;
        aVar.setStageType("2002");
        this.o.setUniqueId(getUniqueId());
        this.o.b1(this);
        this.o.Z0(A().getRootView());
        this.o.a1(this.s);
        ((RelativeLayout) this.f20146g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((d.a.c.e.p.l.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.f20147h = (NewPagerSlidingTabBaseStrip) this.f20146g.findViewById(R.id.pb_video_tab_strip);
        this.z = this.f20146g.findViewById(R.id.pb_video_mount_layout);
        this.f20148i = (CustomViewPager) this.f20146g.findViewById(R.id.pb_video_view_pager);
        this.l = this.f20146g.findViewById(R.id.keyboard_background_shadow);
        this.E = (MaskView) this.f20146g.findViewById(R.id.mask_view);
        this.l.setOnClickListener(this.G1);
        y3();
        u3();
        p3();
        VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.j = videoPbFragmentAdapter;
        this.f20148i.setAdapter(videoPbFragmentAdapter);
        this.f20147h.setViewPager(this.f20148i);
        this.f20147h.setOnPageChangeListener(new l0());
        this.R = this.f20146g.findViewById(R.id.viewstub_progress);
        r3();
        t3();
        q3();
        if (!this.u1 && this.v1) {
            N4();
            UtilHelper.hideStatusBar(A(), A().getRootView());
            this.v1 = false;
        }
        if (B3()) {
            return;
        }
        this.f20147h.getLayoutParams().height = 0;
    }

    public void z4(int i2) {
        View view = this.k;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    /* loaded from: classes3.dex */
    public class r1 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20216a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20217b;

        public r1() {
            this.f20217b = true;
        }

        public boolean a() {
            return (this.f20216a && this.f20217b) ? false : true;
        }

        public /* synthetic */ r1(VideoPbFragment videoPbFragment, k kVar) {
            this();
        }
    }
}
