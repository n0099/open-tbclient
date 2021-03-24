package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.exifinterface.media.ExifInterface;
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
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
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
import com.google.android.material.appbar.AppBarLayout;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.b1.m.f;
import d.b.h0.h.a;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.w1;
import d.b.h0.r.s.a;
import d.b.i0.f0.b;
import d.b.i0.p0.f2.a.c;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class VideoPbFragment extends BaseFragment implements d.b.h0.b1.m.h, VoiceManager.j, d.b.i0.c2.o.b, TbRichTextView.q, d.b.i0.c2.o.a {
    public static int H1 = 0;
    public static int I1 = 1;
    public static int J1 = 0;
    public static int K1 = 0;
    public static int L1 = 3;
    public static int M1 = 4;
    public static int N1 = 6;
    public static final int O1 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    public static final int P1 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    public static final b.InterfaceC1244b Q1 = new n();
    public d.b.i0.c2.o.i.a A;
    public d.b.i0.p0.f2.a.c A0;
    public View B;
    public d.b.i0.p0.f2.a.c B0;
    public View C;
    public d.b.i0.c2.k.e.s0 C0;
    public View D;
    public PermissionJudgePolicy D0;
    public MaskView E;
    public d.b.h0.w.w.g E0;
    public TextView G;
    public TextView H;
    public ImageView I;
    public TBSpecificationBtn J;
    public TbImageView K;
    public d.b.h0.w.w.e K0;
    public View L;
    public EditorTools L0;
    public ValueAnimator M;
    public d.b.i0.c2.k.e.s M0;
    public ValueAnimator N;
    public PbFakeFloorModel N0;
    public d.b.i0.f0.b O0;
    public View P;
    public d.b.i0.c2.o.g.a Q;
    public int Q0;
    public d.b.h0.r.f0.c R;
    public d.b.i0.c2.k.e.y0.f.a T;
    public EmotionImageData U;
    public VoiceManager X;
    public d.b.b.e.k.b<GifView> Y;
    public d.b.b.e.k.b<TextView> Z;
    public d.b.b.e.k.b<ImageView> a0;
    public d.b.b.e.k.b<View> b0;
    public d.b.b.e.k.b<LinearLayout> c0;
    public d.b.b.e.k.b<RelativeLayout> d0;

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19966e;
    public LinearLayout f0;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f19968g;
    public View g0;

    /* renamed from: h  reason: collision with root package name */
    public NewPagerSlidingTabBaseStrip f19969h;
    public CustomViewPager i;
    public LinearLayout i0;
    public VideoPbFragmentAdapter j;
    public HeadImageView j0;
    public View k;
    public View l;
    public ImageView l0;
    public AppBarLayout m;
    public ImageView m0;
    public VideoContainerLayout n;
    public ImageView n0;
    public float n1;
    public d.b.i0.c2.o.k.a o;
    public d.b.i0.c2.p.d o0;
    public float o1;
    public d.b.i0.c2.o.e p;
    public TextView p0;
    public boolean p1;
    public NavigationBar q;
    public TextView q0;
    public View r;
    public View s;
    public String s0;
    public GestureDetector s1;
    public View t;
    public ImageView u;
    public View v;
    public ObjectAnimator v1;
    public ImageView w;
    public ObjectAnimator w1;
    public d.b.i0.w.a x;
    public View z;
    public ReplyPrivacyCheckController z0;

    /* renamed from: f  reason: collision with root package name */
    public long f19967f = 0;
    public boolean y = false;
    public View.OnClickListener F = new k();
    public boolean O = false;
    public d.b.h0.h.a S = null;
    public d.b.h0.s.e.a V = null;
    public ForumManageModel W = null;
    public boolean e0 = false;
    public View h0 = null;
    public TextView k0 = null;
    public boolean t0 = false;
    public String u0 = null;
    public boolean v0 = false;
    public boolean w0 = false;
    public boolean x0 = false;
    public boolean y0 = false;
    public int[] P0 = new int[2];
    public int R0 = -1;
    public int S0 = Integer.MIN_VALUE;
    public int T0 = 0;
    public int U0 = Integer.MIN_VALUE;
    public boolean V0 = false;
    public boolean W0 = d.b.h0.b.d.S();
    public final PbModel.g X0 = new v();
    public final a.InterfaceC1064a Y0 = new g0();
    public d.b.h0.w.w.b Z0 = new r0();
    public final CustomMessageListener a1 = new c1(2004016);
    public CustomMessageListener b1 = new m1(2004007);
    public final CustomMessageListener c1 = new n1(2921391);
    public CustomMessageListener d1 = new o1(2016450);
    public HttpMessageListener e1 = new p1(CmdConfigHttp.SET_PRIVATE_CMD, true);
    public CustomMessageListener f1 = new a(2001426);
    public CustomMessageListener g1 = new b(2001427);
    public CustomMessageListener h1 = new c(2001428);
    public d.b.h0.w.w.b i1 = new d();
    public final NewWriteModel.g j1 = new e();
    public View.OnClickListener k1 = new f();
    public CustomMessageListener l1 = new g(2004008);
    public int m1 = 0;
    public boolean q1 = true;
    public View.OnTouchListener r1 = new h();
    public GestureDetector.SimpleOnGestureListener t1 = new i();
    public Runnable u1 = new j();
    public final d.b.b.a.e x1 = new l();
    public View.OnTouchListener y1 = new m();
    public NewWriteModel.g z1 = new p();
    public d.b.h0.w.w.c A1 = new t();
    public final View.OnClickListener B1 = new u();
    public View.OnClickListener C1 = new w();
    public final AdapterView.OnItemClickListener D1 = new x();
    public CustomMessageListener E1 = new y(2001332);
    public final View.OnLongClickListener F1 = new o0();
    public SortSwitchButton.f G1 = new p0();
    public q1 r0 = new q1(this, null);

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.Q != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.i0.n3.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.Q.B) {
                d.b.i0.n3.a aVar = (d.b.i0.n3.a) customResponsedMessage.getData();
                VideoPbFragment.this.Q.T();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.Q.M();
                DataRes dataRes = aVar.f57156a;
                if (aVar.f57158c == 0 && dataRes != null) {
                    int d2 = d.b.b.e.m.b.d(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r2 = d2 == 1;
                    if (d.b.b.e.p.k.isEmpty(str)) {
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
                    VideoPbFragment.this.Q.s0(r2, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.Q.f0(sparseArray, r2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements Observer<Integer> {
        public a0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            VideoPbFragment.this.i.setCurrentItem(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19972e;

        public a1(ViewGroup.LayoutParams layoutParams) {
            this.f19972e = layoutParams;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPbFragment.this.H4(this.f19972e);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.Q == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.b.i0.c2.o.g.a aVar = VideoPbFragment.this.Q;
            if (tag == aVar.B) {
                aVar.T();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                d.b.i0.c2.h.e y0 = VideoPbFragment.this.L().y0();
                if (y0 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    y0.u().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.R.c(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.Q.x0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.Q.r0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (d.b.b.e.p.k.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.R.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements Observer<a2> {
        public b0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            VideoPbFragment.this.o.X0(a2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19976e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19977f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19978g;

        public b1(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            this.f19976e = layoutParams;
            this.f19977f = layoutParams2;
            this.f19978g = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.O1);
            this.f19976e.height = floatValue;
            this.f19977f.height = (this.f19978g - VideoPbFragment.O1) + floatValue;
            VideoPbFragment.this.z.setLayoutParams(this.f19976e);
            VideoPbFragment.this.m.setLayoutParams(this.f19977f);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.Q == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            d.b.i0.c2.o.g.a aVar = VideoPbFragment.this.Q;
            if (tag == aVar.B) {
                aVar.T();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.R.c(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (d.b.b.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.R.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements Observer<a2> {
        public c0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            VideoPbFragment.this.o.W0(a2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c1 extends CustomMessageListener {
        public c1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.L() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (VideoPbFragment.this.K0 != null) {
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                videoPbFragment.d4(videoPbFragment.K0.C());
            }
            VideoPbFragment.this.V3();
            VideoPbFragment.this.Q.E();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.b.h0.w.w.b {
        public d() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
            if (s0Var == null || s0Var.g() == null || !VideoPbFragment.this.C0.g().d()) {
                return !VideoPbFragment.this.z2(ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.C0.g().c());
            if (VideoPbFragment.this.M0 != null && VideoPbFragment.this.M0.b() != null && VideoPbFragment.this.M0.b().v()) {
                VideoPbFragment.this.M0.b().t(VideoPbFragment.this.C0.h());
            }
            VideoPbFragment.this.C0.b(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements Observer<Boolean> {
        public d0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            VideoPbFragment.this.O3();
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements Animator.AnimatorListener {
        public d1() {
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

    /* loaded from: classes5.dex */
    public class e implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(e eVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public e() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.b.h0.s.c.f0 f0Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                    statisticItem.param("fid", VideoPbFragment.this.L().y0().m());
                }
                statisticItem.param("tid", VideoPbFragment.this.L().O0());
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            VideoPbFragment.this.A4();
            VideoPbFragment.this.h4(z, postWriteCallBackData);
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            } else {
                str = "";
            }
            boolean z2 = false;
            if (!z) {
                if (i == 220015) {
                    VideoPbFragment.this.showToast(str);
                    if (VideoPbFragment.this.K0.B() || VideoPbFragment.this.K0.D()) {
                        VideoPbFragment.this.K0.z(false, postWriteCallBackData);
                    }
                    VideoPbFragment.this.C0.k(postWriteCallBackData);
                    return;
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = VideoPbFragment.this.z0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                        return;
                    } else {
                        DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                        return;
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(VideoPbFragment.this.getActivity());
                    if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.cancel, new a(this));
                    aVar.setPositiveButton(R.string.open_now, new b());
                    aVar.create(VideoPbFragment.this.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                    return;
                } else if (d.b.i0.m3.a.c(i) || f0Var != null || i == 227001) {
                    return;
                } else {
                    VideoPbFragment.this.o4(i, antiData, str);
                    return;
                }
            }
            if (PbReplySwitch.getInOn() && VideoPbFragment.this.L() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                VideoPbFragment.this.L().K(postWriteCallBackData.getPostId());
                if (VideoPbFragment.this.w3() && VideoPbFragment.this.d3() != null) {
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.T0 = videoPbFragment.d3().U0();
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    videoPbFragment2.U0 = videoPbFragment2.d3().V0();
                    VideoPbFragment.this.L().H1(VideoPbFragment.this.T0, VideoPbFragment.this.U0);
                } else if (VideoPbFragment.this.O2() != null) {
                    VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
                    videoPbFragment3.T0 = videoPbFragment3.O2().U0();
                    VideoPbFragment videoPbFragment4 = VideoPbFragment.this;
                    videoPbFragment4.U0 = videoPbFragment4.O2().V0();
                    VideoPbFragment.this.L().H1(VideoPbFragment.this.T0, VideoPbFragment.this.U0);
                }
            }
            if (VideoPbFragment.this.i != null) {
                if (VideoPbFragment.this.w3()) {
                    VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.I1);
                } else {
                    VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.J1);
                }
            }
            VideoPbFragment.this.Q.E();
            VideoPbFragment.this.C0.c();
            if (VideoPbFragment.this.K0 != null) {
                VideoPbFragment videoPbFragment5 = VideoPbFragment.this;
                videoPbFragment5.d4(videoPbFragment5.K0.C());
            }
            VideoPbFragment.this.j3();
            VideoPbFragment.this.q4(true);
            VideoPbFragment.this.L().V0();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
            VideoPbFragment.this.p4(antiData, postWriteCallBackData);
            if (writeData == null) {
                return;
            }
            String floor = writeData.getFloor();
            if (writeData == null || writeData.getType() != 2) {
                if (VideoPbFragment.this.L().d0()) {
                    d.b.i0.c2.h.e y0 = VideoPbFragment.this.L().y0();
                    if (y0 != null && y0.L() != null && y0.L().T() != null && (userId = y0.L().T().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.L().U1()) {
                        VideoPbFragment.this.j4();
                    }
                } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.L().U1()) {
                    VideoPbFragment.this.j4();
                }
            } else if (floor != null) {
                if (VideoPbFragment.this.w3() && VideoPbFragment.this.d3() != null) {
                    VideoPbFragment.this.d3().d1();
                } else if (VideoPbFragment.this.O2() != null) {
                    VideoPbFragment.this.O2().e1();
                }
            }
            VideoPbFragment videoPbFragment6 = VideoPbFragment.this;
            if (writeData != null && writeData.getType() == 2) {
                z2 = true;
            }
            videoPbFragment6.s2(z2);
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements Observer<Boolean> {
        public e0() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            VideoPbFragment.this.q.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19989e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f19990f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f19991g;

        public e1(ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            this.f19989e = layoutParams;
            this.f19990f = layoutParams2;
            this.f19991g = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.O1);
            this.f19989e.height = floatValue;
            this.f19990f.height = this.f19991g + floatValue;
            VideoPbFragment.this.z.setLayoutParams(this.f19989e);
            VideoPbFragment.this.m.setLayoutParams(this.f19990f);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.u0);
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements Animator.AnimatorListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPbViewModel f19994e;

        public f0(VideoPbViewModel videoPbViewModel) {
            this.f19994e = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (VideoPbFragment.this.w3() && (this.f19994e.m() || VideoPbFragment.this.L().N0() == VideoPbFragment.I1)) {
                VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.I1);
            } else if (this.f19994e.m() || VideoPbFragment.this.L().N0() == VideoPbFragment.J1) {
                VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.J1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (VideoPbFragment.this.w3() && (this.f19994e.m() || VideoPbFragment.this.L().N0() == VideoPbFragment.I1)) {
                VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.I1);
            } else if (this.f19994e.m() || VideoPbFragment.this.L().N0() == VideoPbFragment.J1) {
                VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.J1);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements Animator.AnimatorListener {
        public f1() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            VideoPbFragment.this.F4();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes5.dex */
    public class g extends CustomMessageListener {
        public g(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (VideoPbFragment.this.K0 != null) {
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                videoPbFragment.d4(videoPbFragment.K0.C());
            }
            VideoPbFragment.this.q4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements a.InterfaceC1064a {
        public g0() {
        }

        @Override // d.b.h0.h.a.InterfaceC1064a
        public void a(boolean z, boolean z2, String str) {
            a2 L;
            VideoPbFragment.this.i4();
            if (z && VideoPbFragment.this.L() != null) {
                if (VideoPbFragment.this.S != null) {
                    VideoPbFragment.this.S.h(z2);
                }
                VideoPbFragment.this.L().T1(z2);
                if (VideoPbFragment.this.L().y0() != null && (L = VideoPbFragment.this.L().y0().L()) != null) {
                    if (z2) {
                        L.F2++;
                    } else {
                        int i = L.F2;
                        if (i > 0) {
                            L.F2 = i - 1;
                        }
                    }
                }
                if (VideoPbFragment.this.L().k0()) {
                    VideoPbFragment.this.D3();
                } else if (VideoPbFragment.this.w3()) {
                    if (VideoPbFragment.this.P2() != null) {
                        VideoPbFragment.this.P2().P0();
                    }
                    if (VideoPbFragment.this.d3() != null) {
                        VideoPbFragment.this.d3().d1();
                    }
                } else if (VideoPbFragment.this.O2() != null) {
                    VideoPbFragment.this.O2().e1();
                }
                if (z2) {
                    if (VideoPbFragment.this.S != null) {
                        if (VideoPbFragment.this.S.f() == null || VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || VideoPbFragment.this.L().y0().L().T() == null) {
                            return;
                        }
                        MarkData f2 = VideoPbFragment.this.S.f();
                        MetaData T = VideoPbFragment.this.L().y0().L().T();
                        if (f2 != null && T != null) {
                            if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), T.getUserId()) && !T.hadConcerned()) {
                                VideoPbFragment.this.Q.p0(T);
                            } else {
                                VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                            }
                        } else {
                            VideoPbFragment videoPbFragment = VideoPbFragment.this;
                            videoPbFragment.showToast(videoPbFragment.getPageContext().getString(R.string.add_mark));
                        }
                    }
                    VideoPbFragment.this.r2();
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

    /* loaded from: classes5.dex */
    public class g1 implements ValueAnimator.AnimatorUpdateListener {
        public g1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            VideoPbFragment.this.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.s1 != null && VideoPbFragment.this.s1.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.m1 == 1) {
                if (!VideoPbFragment.this.q1) {
                    VideoPbFragment.this.y4();
                    UtilHelper.showStatusBar(VideoPbFragment.this.P(), VideoPbFragment.this.P().getRootView());
                    VideoPbFragment.this.q1 = true;
                    d.b.b.e.m.e.a().removeCallbacks(VideoPbFragment.this.u1);
                    d.b.b.e.m.e.a().postDelayed(VideoPbFragment.this.u1, 3000L);
                }
            } else if (VideoPbFragment.this.m1 == 2 && (VideoPbFragment.this.q1 || VideoPbFragment.this.x3())) {
                VideoPbFragment.this.x4();
                UtilHelper.hideStatusBar(VideoPbFragment.this.P(), VideoPbFragment.this.P().getRootView());
                VideoPbFragment.this.q1 = false;
                if (VideoPbFragment.this.o != null) {
                    VideoPbFragment.this.o.V0(false);
                }
            }
            VideoPbFragment.this.m1 = 0;
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public h0() {
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            if (z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    VideoPbFragment.this.K0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && VideoPbFragment.this.M0 != null && VideoPbFragment.this.M0.b() != null) {
                    VideoPbFragment.this.M0.b().D();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.Z3(videoPbFragment.U);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements d.b.b.e.k.c<ImageView> {
        public h1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            if (imageView instanceof TbImageView) {
                TbImageView tbImageView = (TbImageView) imageView;
                tbImageView.setTag(null);
                if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            imageView.setBackgroundDrawable(null);
            imageView.setImageDrawable(null);
            imageView.setTag(null);
            imageView.setOnClickListener(null);
            if (imageView instanceof ForeDrawableImageView) {
                ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ImageView d() {
            ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
                foreDrawableImageView.c0();
                foreDrawableImageView.setForegroundDrawable(0);
                foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                foreDrawableImageView.S();
            }
            return imageView;
        }
    }

    /* loaded from: classes5.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
        public i() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.m1 = 0;
            VideoPbFragment.this.n1 = 0.0f;
            VideoPbFragment.this.o1 = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            VideoPbFragment.this.n1 += f2;
            VideoPbFragment.this.o1 += f3;
            if (VideoPbFragment.this.m1 == 0 && !VideoPbFragment.this.p1 && VideoPbFragment.this.o != null && !VideoPbFragment.this.o.D()) {
                int height = VideoPbFragment.this.q.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.o1) <= Math.abs(VideoPbFragment.this.n1) || VideoPbFragment.this.o1 > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.o1) > Math.abs(VideoPbFragment.this.n1) && VideoPbFragment.this.o1 > 0.0f && f3 > 0.0f) {
                        VideoPbFragment.this.m1 = 2;
                    }
                } else {
                    VideoPbFragment.this.m1 = 1;
                }
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements ViewPager.OnPageChangeListener {
        public i0() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            boolean z = true;
            if (i == 0) {
                if (VideoPbFragment.this.O2() != null) {
                    VideoPbFragment.this.O2().i1(false);
                } else if (VideoPbFragment.this.w3() && VideoPbFragment.this.d3() != null) {
                    VideoPbFragment.this.d3().g1(false);
                }
                if (VideoPbFragment.this.P2() != null) {
                    VideoPbFragment.this.P2().U0(true);
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    videoPbFragment.l4(videoPbFragment.P2().M0() == 0 ? 8 : 0);
                    VideoPbFragment.this.f0.setVisibility(8);
                }
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                VideoPbFragment.this.o.U0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false);
                VideoPbFragment.this.V3();
                if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                    TiebaStatic.log(new StatisticItem("c13592").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()));
                }
            } else {
                if (VideoPbFragment.this.P2() != null) {
                    VideoPbFragment.this.P2().U0(false);
                }
                if (VideoPbFragment.this.O2() != null) {
                    VideoPbFragment.this.O2().i1(true);
                    int a1 = VideoPbFragment.this.O2().a1();
                    int Y0 = VideoPbFragment.this.O2().Y0();
                    if (a1 != 0) {
                        VideoPbFragment.this.l4(8);
                        VideoPbFragment.this.O2().r1(0);
                    } else if (Y0 != 0) {
                        VideoPbFragment.this.O2().r1(8);
                        VideoPbFragment.this.l4(0);
                    } else {
                        VideoPbFragment.this.O2().r1(8);
                        VideoPbFragment.this.l4(8);
                    }
                } else if (VideoPbFragment.this.d3() != null) {
                    VideoPbFragment.this.d3().g1(true);
                    int a12 = VideoPbFragment.this.d3().a1();
                    int Y02 = VideoPbFragment.this.d3().Y0();
                    if (a12 != 0) {
                        VideoPbFragment.this.l4(8);
                        VideoPbFragment.this.d3().o1(0);
                    } else if (Y02 != 0) {
                        VideoPbFragment.this.d3().o1(8);
                        VideoPbFragment.this.l4(0);
                    } else {
                        VideoPbFragment.this.d3().o1(8);
                        VideoPbFragment.this.l4(8);
                    }
                    VideoPbFragment.this.f0.setVisibility(0);
                }
                VideoPbFragment.this.o.U0(false);
                VideoPbFragment.this.m.setExpanded(false, true);
                if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                    TiebaStatic.log(new StatisticItem("c13593").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()));
                }
            }
            VideoPbFragment.this.j.k(i);
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements d.b.b.e.k.c<GifView> {
        public i1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            gifView.setTag(null);
            if (d.b.h0.r.k.c().g()) {
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
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            gifView.setBackgroundDrawable(null);
            gifView.setImageDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            gifView.p0();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public GifView d() {
            GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
            boolean g2 = d.b.h0.r.k.c().g();
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
            gifView.s0();
            gifView.p0();
            gifView.setImageDrawable(null);
            gifView.t0();
            gifView.setBackgroundDrawable(null);
            gifView.setTag(null);
            gifView.setOnClickListener(null);
            gifView.setDefaultBgResource(R.color.common_color_10220);
            return gifView;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!VideoPbFragment.this.q1 || VideoPbFragment.this.x3()) {
                return;
            }
            VideoPbFragment.this.x4();
            UtilHelper.hideStatusBar(VideoPbFragment.this.P(), VideoPbFragment.this.P().getRootView());
            VideoPbFragment.this.q1 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements View.OnClickListener {
        public j0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.A == null || VideoPbFragment.this.A.v()) {
                if (VideoPbFragment.this.A != null) {
                    TiebaStatic.log(new StatisticItem("c13608").param("tid", VideoPbFragment.this.L().y0().N()));
                    VideoPbFragment.this.A.q = true;
                }
            } else {
                TiebaStatic.log(new StatisticItem("c13591"));
            }
            VideoPbFragment.this.v4();
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements d.b.b.e.k.c<View> {
        public j1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            ((PlayVoiceBntNew) view).o();
            return view;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(View view) {
            ((PlayVoiceBntNew) view).n();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public View d() {
            PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
            playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
            playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
            return playVoiceBntNew;
        }

        public View h(View view) {
            ((PlayVoiceBntNew) view).n();
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.A == null || VideoPbFragment.this.A.v()) {
                if (VideoPbFragment.this.A != null) {
                    if (VideoPbFragment.this.A.m) {
                        VideoPbFragment videoPbFragment = VideoPbFragment.this;
                        videoPbFragment.A3(videoPbFragment.A.o, VideoPbFragment.this.A.n);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.A.g();
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().l() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13713").param("fid", VideoPbFragment.this.L().y0().l().getId()).param("fname", VideoPbFragment.this.L().y0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.L().y0().N()).param("obj_param1", VideoPbFragment.this.A.p));
                    return;
                }
                return;
            }
            TiebaStatic.log(new StatisticItem("c13590").param("obj_id", VideoPbFragment.this.A.u()).param("obj_name", VideoPbFragment.this.A.t()).param("obj_type", 2).param("fid", VideoPbFragment.this.L().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.L().y0().N()));
            String o = VideoPbFragment.this.A.o();
            if (TextUtils.isEmpty(o)) {
                return;
            }
            if (!URLUtil.isHttpUrl(o) && !URLUtil.isHttpsUrl(o)) {
                Uri parse = Uri.parse(o);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    return;
                }
                return;
            }
            UrlManager.getInstance().dealOneLink(VideoPbFragment.this.getPageContext(), new String[]{o});
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements View.OnClickListener {
        public k0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huitie"))) {
                VideoPbFragment.this.G2(false);
                VideoPbFragment.this.N3();
                if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || VideoPbFragment.this.L().y0().L().T() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", VideoPbFragment.this.L().P0()).param("fid", VideoPbFragment.this.L().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()).param("obj_locate", 1).param("uid", VideoPbFragment.this.L().y0().L().T().getUserId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements d.b.b.e.k.c<LinearLayout> {
        public k1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            return linearLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            linearLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
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

    /* loaded from: classes5.dex */
    public class l extends d.b.b.a.e {
        public l() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            boolean z = false;
            if (obj != null && VideoPbFragment.this.L() != null) {
                switch (VideoPbFragment.this.W.getLoadDataMode()) {
                    case 0:
                        VideoPbFragment.this.L().V0();
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoPbFragment.this.H2(bVar, (bVar.f21383e != 1002 || bVar.f21384f) ? true : true);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        VideoPbFragment.this.I2(1, dVar.f21386a, dVar.f21387b, true);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        VideoPbFragment videoPbFragment = VideoPbFragment.this;
                        videoPbFragment.J2(videoPbFragment.W.getLoadDataMode(), (ForumManageModel.g) obj);
                        return;
                    case 6:
                        ForumManageModel.g gVar = (ForumManageModel.g) obj;
                        VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                        videoPbFragment2.I2(videoPbFragment2.W.getLoadDataMode(), gVar.f21400a, gVar.f21401b, false);
                        VideoPbFragment.this.Q.c0(gVar.f21402c);
                        return;
                    default:
                        return;
                }
            }
            VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
            videoPbFragment3.I2(videoPbFragment3.W.getLoadDataMode(), false, null, false);
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public l0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.k3();
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements d.b.b.e.k.c<RelativeLayout> {
        public l1() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            return relativeLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            return relativeLayout;
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnTouchListener {
        public m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.O0.c(motionEvent);
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements View.OnClickListener {
        public m0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.V3();
        }
    }

    /* loaded from: classes5.dex */
    public class m1 extends CustomMessageListener {
        public m1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            d.b.i0.c2.e eVar = (d.b.i0.c2.e) customResponsedMessage.getData();
            int b2 = eVar.b();
            if (b2 == 0) {
                VideoPbFragment.this.T3((d.b.i0.c2.h.q) eVar.a());
            } else if (b2 == 1) {
                VideoPbFragment.this.H2((ForumManageModel.b) eVar.a(), false);
            } else if (b2 != 2) {
            } else {
                if (eVar.a() == null) {
                    VideoPbFragment.this.R3(false, null);
                } else {
                    VideoPbFragment.this.R3(true, (MarkData) eVar.a());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements b.InterfaceC1244b {
        @Override // d.b.i0.f0.b.InterfaceC1244b
        public void a(boolean z) {
            if (z) {
                d.b.i0.c2.i.b.d();
            } else {
                d.b.i0.c2.i.b.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements PbFakeFloorModel.b {
        public n0() {
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            VideoPbFragment.this.N0.A(postData);
            if (VideoPbFragment.this.O2() != null) {
                VideoPbFragment.this.O2().e1();
            } else if (VideoPbFragment.this.w3() && VideoPbFragment.this.d3() != null) {
                VideoPbFragment.this.d3().d1();
            }
            VideoPbFragment.this.M0.c();
            VideoPbFragment.this.L0.q();
            VideoPbFragment.this.q4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class n1 extends CustomMessageListener {
        public n1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.V0) {
                return;
            }
            VideoPbFragment.this.u4();
        }
    }

    /* loaded from: classes5.dex */
    public class o implements a.e {
        public o() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements View.OnLongClickListener {
        public o0() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.Q.j0(true);
            return VideoPbFragment.this.Q.N().onLongClick(view);
        }
    }

    /* loaded from: classes5.dex */
    public class o1 extends CustomMessageListener {
        public o1(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.I4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements NewWriteModel.g {

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public a(p pVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b() {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                aVar.dismiss();
                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
            }
        }

        public p() {
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d.b.h0.s.c.f0 f0Var, WriteData writeData, AntiData antiData) {
            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                StatisticItem statisticItem = new StatisticItem("c13268");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                    statisticItem.param("fid", VideoPbFragment.this.L().y0().m());
                }
                if (VideoPbFragment.this.L() != null) {
                    statisticItem.param("tid", VideoPbFragment.this.L().O0());
                }
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(statisticItem);
            }
            if (z) {
                d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
                if (s0Var != null) {
                    s0Var.d();
                }
                if (postWriteCallBackData == null || postWriteCallBackData.getIconStampData() == null) {
                    return;
                }
                d.b.h0.s.h.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                return;
            }
            if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                ReplyPrivacyCheckController replyPrivacyCheckController = VideoPbFragment.this.z0;
                if (replyPrivacyCheckController != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).u();
                } else {
                    DefaultNavigationBarCoverTip.s(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(VideoPbFragment.this.getActivity());
                if (d.b.b.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.setMessage(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.setMessage(postWriteCallBackData.getErrorString());
                }
                aVar.setNegativeButton(R.string.cancel, new a(this));
                aVar.setPositiveButton(R.string.open_now, new b());
                aVar.create(VideoPbFragment.this.getPageContext()).show();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
            }
            if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                return;
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            if (videoPbFragment.C0 == null) {
                return;
            }
            if (videoPbFragment.M0 != null && VideoPbFragment.this.M0.b() != null && VideoPbFragment.this.M0.b().v()) {
                VideoPbFragment.this.M0.b().t(postWriteCallBackData);
            }
            VideoPbFragment.this.C0.l(postWriteCallBackData);
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements SortSwitchButton.f {
        public p0() {
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            d.b.i0.c2.o.g.a aVar = VideoPbFragment.this.Q;
            if (aVar != null) {
                aVar.E();
            }
            boolean z = false;
            if (!d.b.b.e.p.j.z()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            }
            if (VideoPbFragment.this.L() != null && !VideoPbFragment.this.L().isLoading) {
                VideoPbFragment.this.A4();
                VideoPbFragment.this.j4();
                z = true;
                if (VideoPbFragment.this.L().y0() != null && VideoPbFragment.this.L().y0().f52424f != null && VideoPbFragment.this.L().y0().f52424f.size() > i) {
                    int intValue = VideoPbFragment.this.L().y0().f52424f.get(i).sort_type.intValue();
                    TiebaStatic.log(new StatisticItem("c13699").param("tid", VideoPbFragment.this.L().P0()).param("fid", VideoPbFragment.this.L().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                    if (VideoPbFragment.this.L().X1(intValue)) {
                        VideoPbFragment.this.O = true;
                    }
                }
            }
            return z;
        }

        public final int b(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            return i == 1 ? 3 : 0;
        }
    }

    /* loaded from: classes5.dex */
    public class p1 extends HttpMessageListener {
        public p1(int i, boolean z) {
            super(i, z);
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
                        VideoPbFragment.this.k4(type);
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

    /* loaded from: classes5.dex */
    public class q implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f20027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MarkData f20028f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f20029g;

        public q(MarkData markData, MarkData markData2, d.b.h0.r.s.a aVar) {
            this.f20027e = markData;
            this.f20028f = markData2;
            this.f20029g = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            if (VideoPbFragment.this.S != null) {
                if (VideoPbFragment.this.S.e()) {
                    VideoPbFragment.this.S.d();
                    VideoPbFragment.this.S.h(false);
                }
                VideoPbFragment.this.S.i(this.f20027e);
                VideoPbFragment.this.S.h(true);
                VideoPbFragment.this.S.a();
            }
            this.f20028f.setPostId(this.f20027e.getPostId());
            Intent intent = new Intent();
            intent.putExtra("mark", this.f20028f);
            VideoPbFragment.this.f19966e.setResult(-1, intent);
            this.f20029g.dismiss();
            VideoPbFragment.this.B4();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements c.d {
        public q0() {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                if (VideoPbFragment.this.K0 != null && VideoPbFragment.this.K0.a() != null) {
                    VideoPbFragment.this.K0.a().A(new d.b.h0.w.a(45, 27, null));
                }
                VideoPbFragment.this.A2();
            }
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class r implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MarkData f20035e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f20036f;

        public r(MarkData markData, d.b.h0.r.s.a aVar) {
            this.f20035e = markData;
            this.f20036f = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            Intent intent = new Intent();
            intent.putExtra("mark", this.f20035e);
            VideoPbFragment.this.f19966e.setResult(-1, intent);
            this.f20036f.dismiss();
            VideoPbFragment.this.B4();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements d.b.h0.w.w.b {
        public r0() {
        }

        @Override // d.b.h0.w.w.b
        public boolean a() {
            d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
            if (s0Var == null || s0Var.e() == null || !VideoPbFragment.this.C0.e().d()) {
                return !VideoPbFragment.this.z2(ReplyPrivacyCheckController.TYPE_THREAD);
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.showToast(videoPbFragment.C0.e().c());
            if (VideoPbFragment.this.K0 != null && (VideoPbFragment.this.K0.B() || VideoPbFragment.this.K0.D())) {
                VideoPbFragment.this.K0.z(false, VideoPbFragment.this.C0.h());
            }
            VideoPbFragment.this.C0.a(true);
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class s implements DialogInterface.OnCancelListener {
        public s() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements AntiHelper.k {
        public s0() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
        }
    }

    /* loaded from: classes5.dex */
    public class t implements d.b.h0.w.w.c {
        public t() {
        }

        @Override // d.b.h0.w.w.c
        public void a() {
            VideoPbFragment.this.showProgressBar();
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements View.OnClickListener {
        public t0() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.V3();
        }
    }

    /* loaded from: classes5.dex */
    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            int i2;
            int i3;
            boolean W1;
            int i4;
            if (view == null || !VideoPbFragment.this.isAdded()) {
                return;
            }
            int i5 = 1;
            if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                StatisticItem statisticItem2 = new StatisticItem("c13398");
                statisticItem2.param("tid", VideoPbFragment.this.L().O0());
                statisticItem2.param("fid", VideoPbFragment.this.L().getForumId());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                if (VideoPbFragment.this.e0) {
                    VideoPbFragment.this.e0 = false;
                    return;
                }
                TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                if (tbRichTextView.getTag() instanceof SparseArray) {
                    Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                    if (obj instanceof PostData) {
                        PostData postData = (PostData) obj;
                        if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.N0 == null || postData.s() == null || postData.z() == 1 || !VideoPbFragment.this.checkUpIsLogin()) {
                            return;
                        }
                        if (VideoPbFragment.this.M0 != null) {
                            VideoPbFragment.this.M0.c();
                        }
                        d.b.i0.c2.h.q qVar = new d.b.i0.c2.h.q();
                        qVar.A(VideoPbFragment.this.L().y0().l());
                        qVar.E(VideoPbFragment.this.L().y0().L());
                        qVar.C(postData);
                        VideoPbFragment.this.N0.E(qVar);
                        VideoPbFragment.this.N0.setPostId(postData.D());
                        VideoPbFragment.this.C3(view, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        d.b.i0.c2.m.a.b(VideoPbFragment.this.L().y0(), postData, postData.d0, 8, 1);
                        if (VideoPbFragment.this.K0 != null) {
                            VideoPbFragment videoPbFragment = VideoPbFragment.this;
                            videoPbFragment.d4(videoPbFragment.K0.C());
                        }
                    }
                }
            } else if ((VideoPbFragment.this.w3() && VideoPbFragment.this.d3() != null && VideoPbFragment.this.d3().Z0() != null && view == VideoPbFragment.this.d3().Z0()) || ((VideoPbFragment.this.O2() != null && VideoPbFragment.this.O2().Z0() != null && view == VideoPbFragment.this.O2().Z0()) || view.getId() == R.id.pb_more)) {
                if (!VideoPbFragment.this.O && VideoPbFragment.this.L().h1(true)) {
                    VideoPbFragment.this.O = true;
                    if (VideoPbFragment.this.w3()) {
                        VideoPbFragment.this.d3().n1();
                    } else {
                        VideoPbFragment.this.O2().q1();
                    }
                }
            } else {
                d.b.i0.c2.o.g.a aVar = VideoPbFragment.this.Q;
                if (aVar != null && aVar.O() != null && view == VideoPbFragment.this.Q.O().e()) {
                    VideoPbFragment.this.Q.H();
                    return;
                }
                d.b.i0.c2.o.g.a aVar2 = VideoPbFragment.this.Q;
                if ((aVar2 == null || ((aVar2.O() == null || view != VideoPbFragment.this.Q.O().i()) && view.getId() != R.id.owner_reply && view.getId() != R.id.all_reply)) && view.getId() != R.id.floor_owner_reply && view.getId() != R.id.reply_title) {
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    if (view == videoPbFragment2.t) {
                        if (videoPbFragment2.L() == null || VideoPbFragment.this.L().y0() == null) {
                            return;
                        }
                        if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            StatisticItem statisticItem3 = new StatisticItem("c13266");
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem3.param("fid", VideoPbFragment.this.L().y0().m());
                            statisticItem3.param("tid", VideoPbFragment.this.L().O0());
                            statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(statisticItem3);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        d.b.b.e.p.l.w(VideoPbFragment.this.f19966e, VideoPbFragment.this.t);
                        VideoPbFragment.this.f19966e.finish();
                    } else if (view == videoPbFragment2.v && videoPbFragment2.Q != null) {
                        if (d.b.h0.z0.l.a()) {
                            return;
                        }
                        if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                            ArrayList<PostData> D = VideoPbFragment.this.L().y0().D();
                            if ((D == null || D.size() <= 0) && VideoPbFragment.this.L().M0()) {
                                d.b.b.e.p.l.L(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                                return;
                            }
                            TiebaStatic.log(new StatisticItem("c12378").param("tid", VideoPbFragment.this.L().O0()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", VideoPbFragment.this.L().getForumId()));
                            VideoPbFragment.this.Q.h0();
                            return;
                        }
                        d.b.b.e.p.l.L(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                    } else if (VideoPbFragment.this.Q.O() != null && view == VideoPbFragment.this.Q.O().l()) {
                        if (VideoPbFragment.this.L() == null) {
                            return;
                        }
                        VideoPbFragment.this.Q.E();
                        if (d.b.b.e.p.j.z()) {
                            VideoPbFragment.this.A4();
                            VideoPbFragment.this.j4();
                            VideoPbFragment.this.L().R1(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else {
                        d.b.i0.c2.o.g.a aVar3 = VideoPbFragment.this.Q;
                        if (aVar3 != null && aVar3.O() != null && view == VideoPbFragment.this.Q.O().i()) {
                            VideoPbFragment.this.Q.H();
                            return;
                        }
                        d.b.i0.c2.o.g.a aVar4 = VideoPbFragment.this.Q;
                        if (aVar4 != null && ((aVar4.O() != null && view == VideoPbFragment.this.Q.O().s()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                            VideoPbFragment.this.Q.E();
                            if (d.b.b.e.p.j.z()) {
                                if (!VideoPbFragment.this.O) {
                                    VideoPbFragment.this.A4();
                                    VideoPbFragment.this.j4();
                                    VideoPbFragment.this.Q.w0(view);
                                    return;
                                }
                                view.setTag(Integer.valueOf(VideoPbFragment.this.L().K0()));
                                return;
                            }
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        d.b.i0.c2.o.g.a aVar5 = VideoPbFragment.this.Q;
                        if (aVar5 != null && aVar5.O() != null && view == VideoPbFragment.this.Q.O().r()) {
                            if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null) {
                                return;
                            }
                            VideoPbFragment.this.Q.H();
                            TiebaStatic.log(new StatisticItem("c13062"));
                            VideoPbFragment videoPbFragment3 = VideoPbFragment.this;
                            videoPbFragment3.Q.S(videoPbFragment3.L().y0().L().f0());
                        } else if (view.getId() == R.id.pb_floor_feedback) {
                            try {
                                sparseArray = (SparseArray) view.getTag();
                            } catch (ClassCastException e2) {
                                e2.printStackTrace();
                                sparseArray = null;
                            }
                            d.b.i0.c2.o.g.a aVar6 = VideoPbFragment.this.Q;
                            if (aVar6 != null) {
                                aVar6.m0(sparseArray);
                            }
                        } else {
                            d.b.i0.c2.o.g.a aVar7 = VideoPbFragment.this.Q;
                            if (aVar7 != null && aVar7.O() != null && view == VideoPbFragment.this.Q.O().o()) {
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
                                VideoPbFragment.this.Q.I();
                                return;
                            }
                            d.b.i0.c2.o.g.a aVar8 = VideoPbFragment.this.Q;
                            if (aVar8 != null && aVar8.O() != null && view == VideoPbFragment.this.Q.O().q()) {
                                VideoPbFragment.this.Q.I();
                                VideoPbFragment videoPbFragment4 = VideoPbFragment.this;
                                videoPbFragment4.Q.u0(videoPbFragment4.D1);
                                return;
                            }
                            d.b.i0.c2.o.g.a aVar9 = VideoPbFragment.this.Q;
                            if (aVar9 != null && (view == aVar9.K() || (VideoPbFragment.this.Q.O() != null && (view == VideoPbFragment.this.Q.O().m() || view == VideoPbFragment.this.Q.O().n())))) {
                                if (!d.b.b.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                } else if ((VideoPbFragment.this.L() == null && VideoPbFragment.this.L().y0() == null) || VideoPbFragment.this.W.K()) {
                                    return;
                                } else {
                                    VideoPbFragment.this.Q.E();
                                    if (VideoPbFragment.this.Q.O() != null && view == VideoPbFragment.this.Q.O().n()) {
                                        i3 = VideoPbFragment.this.L().y0().L().x0() == 1 ? 5 : 4;
                                    } else if (VideoPbFragment.this.Q.O() != null && view == VideoPbFragment.this.Q.O().m()) {
                                        i3 = VideoPbFragment.this.L().y0().L().w0() == 1 ? 3 : 6;
                                    } else {
                                        i3 = view == VideoPbFragment.this.Q.K() ? 2 : 0;
                                    }
                                    ForumData l = VideoPbFragment.this.L().y0().l();
                                    String name = l.getName();
                                    String id = l.getId();
                                    String o0 = VideoPbFragment.this.L().y0().L().o0();
                                    VideoPbFragment.this.showProgressBar();
                                    VideoPbFragment.this.W.O(id, name, o0, i3, VideoPbFragment.this.Q.L());
                                    return;
                                }
                            }
                            d.b.i0.c2.o.g.a aVar10 = VideoPbFragment.this.Q;
                            if (aVar10 != null && aVar10.O() != null && view == VideoPbFragment.this.Q.O().h()) {
                                if (VideoPbFragment.this.L() == null) {
                                    return;
                                }
                                if (!d.b.b.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbFragment.this.Q.E();
                                VideoPbFragment videoPbFragment5 = VideoPbFragment.this;
                                SparseArray<Object> V2 = videoPbFragment5.V2(videoPbFragment5.L().y0(), VideoPbFragment.this.L().M0(), 1);
                                if (V2 == null) {
                                    return;
                                }
                                VideoPbFragment.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.L().y0().l().getId(), VideoPbFragment.this.L().y0().l().getName(), VideoPbFragment.this.L().y0().L().o0(), String.valueOf(VideoPbFragment.this.L().y0().Q().getUserId()), (String) V2.get(R.id.tag_forbid_user_name), (String) V2.get(R.id.tag_forbid_user_name_show), (String) V2.get(R.id.tag_forbid_user_post_id), (String) V2.get(R.id.tag_forbid_user_portrait))));
                                return;
                            }
                            d.b.i0.c2.o.g.a aVar11 = VideoPbFragment.this.Q;
                            if (aVar11 != null && aVar11.O() != null && view == VideoPbFragment.this.Q.O().f()) {
                                if (VideoPbFragment.this.L() == null) {
                                    return;
                                }
                                if (!d.b.b.e.p.j.z()) {
                                    VideoPbFragment.this.showToast(R.string.network_not_available);
                                    return;
                                }
                                VideoPbFragment videoPbFragment6 = VideoPbFragment.this;
                                SparseArray<Object> V22 = videoPbFragment6.V2(videoPbFragment6.L().y0(), VideoPbFragment.this.L().M0(), 1);
                                if (V22 != null) {
                                    if (StringUtils.isNull((String) V22.get(R.id.tag_del_multi_forum))) {
                                        VideoPbFragment.this.Q.d0(((Integer) V22.get(R.id.tag_del_post_type)).intValue(), (String) V22.get(R.id.tag_del_post_id), ((Integer) V22.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) V22.get(R.id.tag_del_post_is_self)).booleanValue());
                                    } else {
                                        VideoPbFragment.this.Q.e0(((Integer) V22.get(R.id.tag_del_post_type)).intValue(), (String) V22.get(R.id.tag_del_post_id), ((Integer) V22.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) V22.get(R.id.tag_del_post_is_self)).booleanValue(), (String) V22.get(R.id.tag_del_multi_forum));
                                    }
                                }
                                VideoPbFragment.this.Q.H();
                            } else if (view.getId() != R.id.sub_pb_more && view.getId() != R.id.sub_pb_item && view.getId() != R.id.pb_floor_reply_more && view.getId() != R.id.new_sub_pb_list_richText && view.getId() != R.id.pb_post_reply_count) {
                                if (view.getId() != R.id.pb_post_reply && view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                    if (view.getId() != R.id.pb_editor_tool_collection && view.getId() != R.id.collect_num_container) {
                                        if (view.getId() == R.id.pb_editor_tool_share) {
                                            VideoPbFragment.this.g3(true);
                                        } else if (view.getId() != R.id.pb_editor_tool_comment_icon && view.getId() != R.id.thread_info_commont_container) {
                                            if (view.getId() == R.id.tv_pb_reply_more) {
                                                if (VideoPbFragment.this.T0 >= 0) {
                                                    if (VideoPbFragment.this.L() != null) {
                                                        VideoPbFragment.this.L().D1();
                                                    }
                                                    if (VideoPbFragment.this.w3() && VideoPbFragment.this.L() != null && VideoPbFragment.this.d3() != null && VideoPbFragment.this.d3().E0() != null) {
                                                        VideoPbFragment.this.d3().E0().f(VideoPbFragment.this.L().y0());
                                                    } else if (VideoPbFragment.this.O2() != null && VideoPbFragment.this.O2().E0() != null) {
                                                        VideoPbFragment.this.O2().E0().u(VideoPbFragment.this.L().y0());
                                                    }
                                                    VideoPbFragment.this.T0 = 0;
                                                    VideoPbFragment.this.U0 = Integer.MIN_VALUE;
                                                    if (VideoPbFragment.this.w3() && VideoPbFragment.this.L() != null && VideoPbFragment.this.d3() != null) {
                                                        VideoPbFragment.this.d3().j1(VideoPbFragment.this.L().r0(), VideoPbFragment.this.L().q0());
                                                        VideoPbFragment.this.L().H1(0, 0);
                                                    } else if (VideoPbFragment.this.L() == null || VideoPbFragment.this.O2() == null) {
                                                    } else {
                                                        VideoPbFragment.this.O2().l1(VideoPbFragment.this.L().r0(), VideoPbFragment.this.L().q0());
                                                        VideoPbFragment.this.L().H1(0, 0);
                                                    }
                                                }
                                            } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                                                if (VideoPbFragment.this.L() == null) {
                                                    return;
                                                }
                                                StatisticItem statisticItem4 = new StatisticItem("c13398");
                                                statisticItem4.param("tid", VideoPbFragment.this.L().O0());
                                                statisticItem4.param("fid", VideoPbFragment.this.L().getForumId());
                                                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem4.param("obj_locate", 2);
                                                TiebaStatic.log(statisticItem4);
                                            } else if (view.getId() == R.id.pb_item_tail_content) {
                                                if (ViewHelper.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                    String o = d.b.h0.r.d0.b.i().o("tail_link", "");
                                                    if (!StringUtils.isNull(o)) {
                                                        TiebaStatic.log("c10056");
                                                        d.b.h0.l.a.o(view.getContext(), string, o, true, true, true);
                                                    }
                                                    VideoPbFragment.this.V3();
                                                }
                                            } else if (view.getId() == R.id.keyboard_background_shadow) {
                                                VideoPbFragment.this.V3();
                                            } else if (VideoPbFragment.this.Q.O() != null && view == VideoPbFragment.this.Q.O().d()) {
                                                VideoPbFragment.this.Q.E();
                                                if (VideoPbFragment.this.L() != null) {
                                                    VideoPbFragment.this.x.i(VideoPbFragment.this.L().O0());
                                                }
                                                if (VideoPbFragment.this.L() == null || !VideoPbFragment.this.L().isPrivacy()) {
                                                    VideoPbFragment.this.x.c();
                                                    if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null && VideoPbFragment.this.L().y0().N() != null && VideoPbFragment.this.L().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
                                                        i5 = 2;
                                                    }
                                                    if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null) {
                                                        return;
                                                    }
                                                    VideoPbFragment.this.x.e(3, i5, VideoPbFragment.this.L().y0().N());
                                                    return;
                                                }
                                                VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                if (VideoPbFragment.this.L().y0() != null) {
                                                    VideoPbFragment.this.x.e(3, 3, VideoPbFragment.this.L().y0().N());
                                                }
                                            } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                                                StatisticItem statisticItem5 = new StatisticItem("c13398");
                                                statisticItem5.param("tid", VideoPbFragment.this.L().O0());
                                                statisticItem5.param("fid", VideoPbFragment.this.L().getForumId());
                                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem5.param("obj_locate", 7);
                                                TiebaStatic.log(statisticItem5);
                                                VideoPbFragment.this.Q.j0(false);
                                                VideoPbFragment.this.Q.N().onLongClick(view);
                                            }
                                        } else if (VideoPbFragment.this.L() != null) {
                                            VideoPbFragment videoPbFragment7 = VideoPbFragment.this;
                                            if (videoPbFragment7.Q == null || videoPbFragment7.i == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || !VideoPbFragment.this.checkUpIsLogin()) {
                                                return;
                                            }
                                            d.b.i0.c2.h.e y0 = VideoPbFragment.this.L().y0();
                                            int Z0 = y0.L().Z0();
                                            int currentItem = VideoPbFragment.this.i.getCurrentItem();
                                            if (Z0 == 0) {
                                                if (VideoPbFragment.this.w3() && currentItem == VideoPbFragment.H1) {
                                                    VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.I1);
                                                }
                                                VideoPbFragment.this.G2(false);
                                                VideoPbFragment.this.N3();
                                                return;
                                            }
                                            if (VideoPbFragment.this.w3() && currentItem == VideoPbFragment.H1) {
                                                VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.I1);
                                            } else if ((VideoPbFragment.this.w3() && VideoPbFragment.this.d3() == null) || VideoPbFragment.this.O2() == null || VideoPbFragment.this.c3() == null) {
                                                return;
                                            } else {
                                                StatisticItem param = new StatisticItem("c13403").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                double i6 = d.b.b.e.p.l.i(VideoPbFragment.this.getContext());
                                                Double.isNaN(i6);
                                                int i7 = (int) (i6 * 0.6d);
                                                BdTypeRecyclerView c3 = VideoPbFragment.this.c3();
                                                if (c3 == null) {
                                                    return;
                                                }
                                                boolean canScrollVertically = c3.canScrollVertically(1);
                                                boolean canScrollVertically2 = c3.canScrollVertically(-1);
                                                if (VideoPbFragment.this.m != null) {
                                                    VideoPbFragment.this.m.setExpanded(false, true);
                                                }
                                                if (c3.getLayoutManager() == null || !(c3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                    return;
                                                }
                                                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) c3.getLayoutManager();
                                                if (!canScrollVertically2 && canScrollVertically) {
                                                    if (VideoPbFragment.this.R0 == -1 && VideoPbFragment.this.S0 == Integer.MIN_VALUE) {
                                                        return;
                                                    }
                                                    if (VideoPbFragment.this.R0 > 3 || (VideoPbFragment.this.R0 == 3 && VideoPbFragment.this.S0 < (-i7))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.R0, VideoPbFragment.this.S0 + i7);
                                                        c3.smoothScrollBy(0, i7);
                                                    } else if (VideoPbFragment.this.R0 >= 2) {
                                                        int i8 = i7 / 2;
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.R0, VideoPbFragment.this.S0 + i8);
                                                        c3.smoothScrollBy(0, i8);
                                                    } else if (VideoPbFragment.this.R0 == 1) {
                                                        int i9 = i7 / 4;
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.R0, VideoPbFragment.this.S0 + i9);
                                                        c3.smoothScrollBy(0, i9);
                                                    } else {
                                                        c3.smoothScrollBy(0, -VideoPbFragment.this.S0);
                                                    }
                                                    param.param("obj_locate", 2);
                                                    i2 = 1;
                                                } else {
                                                    int firstVisiblePosition = c3.getFirstVisiblePosition();
                                                    View childAt = c3.getChildAt(0);
                                                    int top = childAt == null ? 0 : childAt.getTop();
                                                    VideoPbFragment.this.R0 = firstVisiblePosition;
                                                    VideoPbFragment.this.S0 = top;
                                                    if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i7) || c3.getCount() < 6)) {
                                                        c3.smoothScrollToPosition(0);
                                                    } else {
                                                        linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                        c3.smoothScrollToPosition(0);
                                                    }
                                                    i2 = 1;
                                                    param.param("obj_locate", 1);
                                                }
                                                TiebaStatic.log(param);
                                                d.b.h0.i0.c f2 = TbPageExtraHelper.f(view);
                                                StatisticItem statisticItem6 = new StatisticItem("c12942");
                                                statisticItem6.param("obj_type", i2);
                                                statisticItem6.param("obj_locate", 4);
                                                statisticItem6.param("tid", VideoPbFragment.this.L().O0());
                                                statisticItem6.param("nid", y0.L().L0());
                                                if (f2 != null) {
                                                    statisticItem6.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
                                                }
                                                if (TbPageExtraHelper.m() != null) {
                                                    statisticItem6.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                                                }
                                                TiebaStatic.log(statisticItem6);
                                            }
                                            if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || VideoPbFragment.this.L().y0().L().T() == null) {
                                                return;
                                            }
                                            TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()).param("obj_locate", 2).param("uid", VideoPbFragment.this.L().y0().L().T().getUserId()));
                                        }
                                    } else if (!d.b.b.e.p.j.z()) {
                                        VideoPbFragment.this.showToast(R.string.network_not_available);
                                    } else {
                                        VideoPbFragment videoPbFragment8 = VideoPbFragment.this;
                                        if (videoPbFragment8.Q == null || videoPbFragment8.L() == null) {
                                            return;
                                        }
                                        if (VideoPbFragment.this.w3() && VideoPbFragment.this.d3() == null) {
                                            return;
                                        }
                                        if (VideoPbFragment.this.w3() || VideoPbFragment.this.O2() != null) {
                                            VideoPbFragment.this.Q.E();
                                            if (view.getId() != R.id.pb_editor_tool_collection || DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_shoucang"))) {
                                                if (!VideoPbFragment.this.x2(11009) || VideoPbFragment.this.L() == null) {
                                                    return;
                                                }
                                                VideoPbFragment.this.E3();
                                                if (VideoPbFragment.this.L().y0() != null && VideoPbFragment.this.L().y0().L() != null && VideoPbFragment.this.L().y0().L().T() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", VideoPbFragment.this.L().O0()).param("fid", VideoPbFragment.this.L().y0().m()).param("obj_locate", 3).param("uid", VideoPbFragment.this.L().y0().L().T().getUserId()));
                                                }
                                                if (VideoPbFragment.this.L().y0().L() == null || VideoPbFragment.this.L().y0().L().T() == null || VideoPbFragment.this.L().y0().L().T().getUserId() == null || VideoPbFragment.this.S == null) {
                                                    return;
                                                }
                                                VideoPbFragment videoPbFragment9 = VideoPbFragment.this;
                                                int Q = videoPbFragment9.Q.Q(videoPbFragment9.L().y0());
                                                a2 L = VideoPbFragment.this.L().y0().L();
                                                if (L.O1()) {
                                                    i = 2;
                                                } else if (L.R1()) {
                                                    i = 3;
                                                } else if (L.P1()) {
                                                    i = 4;
                                                } else {
                                                    i = L.Q1() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", VideoPbFragment.this.L().O0()).param("obj_locate", 1).param("obj_id", VideoPbFragment.this.L().y0().L().T().getUserId()).param("obj_type", !VideoPbFragment.this.S.e()).param("obj_source", Q).param("obj_param1", i));
                                                return;
                                            }
                                            VideoPbFragment.this.D = view;
                                        }
                                    }
                                } else if (VideoPbFragment.this.L() == null) {
                                } else {
                                    if (view.getId() == R.id.pb_post_reply) {
                                        StatisticItem statisticItem7 = new StatisticItem("c13398");
                                        statisticItem7.param("tid", VideoPbFragment.this.L().O0());
                                        statisticItem7.param("fid", VideoPbFragment.this.L().getForumId());
                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem7.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem7);
                                    }
                                    if (view.getId() == R.id.post_info_commont_img) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                            VideoPbFragment.this.C = view;
                                            return;
                                        }
                                    } else if (view.getId() == R.id.pb_post_reply && !DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
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
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", VideoPbFragment.this.L().P0()).param("fid", VideoPbFragment.this.L().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData2.D()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.N0 == null || postData2.s() == null || postData2.z() == 1) {
                                                return;
                                            }
                                            if (VideoPbFragment.this.M0 != null) {
                                                VideoPbFragment.this.M0.c();
                                            }
                                            if (VideoPbFragment.this.W0 && postData2.L() != null && postData2.L().size() != 0) {
                                                VideoPbFragment.this.z4(postData2, null, true, false);
                                                return;
                                            }
                                            d.b.i0.c2.h.q qVar2 = new d.b.i0.c2.h.q();
                                            qVar2.A(VideoPbFragment.this.L().y0().l());
                                            qVar2.E(VideoPbFragment.this.L().y0().L());
                                            qVar2.C(postData2);
                                            VideoPbFragment.this.N0.E(qVar2);
                                            VideoPbFragment.this.N0.setPostId(postData2.D());
                                            VideoPbFragment.this.C3(view, postData2.s().getUserId(), "", postData2);
                                            if (VideoPbFragment.this.K0 != null) {
                                                VideoPbFragment videoPbFragment10 = VideoPbFragment.this;
                                                videoPbFragment10.d4(videoPbFragment10.K0.C());
                                            }
                                        }
                                    }
                                }
                            } else {
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                    statisticItem8.param("tid", VideoPbFragment.this.L().O0());
                                    statisticItem8.param("fid", VideoPbFragment.this.L().getForumId());
                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem8.param("obj_locate", 4);
                                    TiebaStatic.log(statisticItem8);
                                }
                                if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !DialogLoginHelper.checkUpIsLogin(new d.b.h0.r.q.r0(VideoPbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                                    VideoPbFragment.this.B = view;
                                } else if (!VideoPbFragment.this.checkUpIsLogin()) {
                                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", VideoPbFragment.this.L().y0().m()));
                                } else if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null) {
                                } else {
                                    d.b.i0.c2.o.g.a aVar12 = VideoPbFragment.this.Q;
                                    if (aVar12 != null) {
                                        aVar12.E();
                                    }
                                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                                    PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                    PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_reply_data);
                                    if (postData3 == null) {
                                        return;
                                    }
                                    if (postData3.B() == 1) {
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
                                    VideoPbFragment.this.A4();
                                    TiebaStatic.log("c11742");
                                    if (postData4 != null) {
                                        VideoPbFragment.this.z4(postData3, postData4, false, true);
                                    } else {
                                        VideoPbFragment.this.z4(postData3, null, false, false);
                                    }
                                }
                            }
                        }
                    }
                } else if (!d.b.b.e.p.j.z()) {
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                    view.setTag(Boolean.FALSE);
                } else {
                    VideoPbFragment.this.Q.E();
                    if (!VideoPbFragment.this.O) {
                        VideoPbFragment.this.A4();
                        VideoPbFragment.this.j4();
                        if (view.getId() == R.id.owner_reply) {
                            W1 = VideoPbFragment.this.L().W1(true, VideoPbFragment.this.R2());
                        } else {
                            W1 = view.getId() == R.id.all_reply ? VideoPbFragment.this.L().W1(false, VideoPbFragment.this.R2()) : VideoPbFragment.this.L().V1(VideoPbFragment.this.R2());
                        }
                        view.setTag(Boolean.valueOf(W1));
                        if (W1) {
                            VideoPbFragment.this.s4();
                            i4 = 1;
                            VideoPbFragment.this.O = true;
                        } else {
                            i4 = 1;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i4, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements d.b.h0.w.b {
        public u0() {
        }

        @Override // d.b.h0.w.b
        public void onAction(d.b.h0.w.a aVar) {
            Object obj = aVar.f51525c;
            if (obj instanceof d.b.h0.s.c.t) {
                if (((d.b.h0.s.c.t) obj).e() == EmotionGroupType.BIG_EMOTION || ((d.b.h0.s.c.t) aVar.f51525c).e() == EmotionGroupType.USER_COLLECT) {
                    if (VideoPbFragment.this.D0 == null) {
                        VideoPbFragment.this.D0 = new PermissionJudgePolicy();
                    }
                    VideoPbFragment.this.D0.clearRequestPermissionList();
                    VideoPbFragment.this.D0.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (VideoPbFragment.this.D0.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                        return;
                    }
                    VideoPbFragment.this.K0.h((d.b.h0.s.c.t) aVar.f51525c);
                    VideoPbFragment.this.K0.z(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements PbModel.g {
        public v() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void b(d.b.i0.c2.h.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.g
        public void c(boolean z, int i, int i2, int i3, d.b.i0.c2.h.e eVar, String str, int i4) {
            d.b.h0.w.h m;
            VideoPbFragment.this.i4();
            VideoPbFragment.this.l3();
            if (VideoPbFragment.this.O) {
                VideoPbFragment.this.O = false;
            }
            VideoPbFragment.this.q4(false);
            if (z && eVar != null) {
                a2 L = eVar.L();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).s(eVar, i2);
                VideoPbFragment.this.M3(eVar);
                d.b.i0.c2.o.i.a E = eVar.E();
                if (E != null && !E.q) {
                    VideoPbFragment.this.u2(E);
                }
                VideoPbFragment.this.S3(eVar);
                VideoPbFragment.this.P3(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.Q().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.Q().getBimg_end_time());
                if (VideoPbFragment.this.S != null) {
                    VideoPbFragment.this.S.h(eVar.r());
                }
                AntiData d2 = eVar.d();
                if (d2 != null) {
                    VideoPbFragment.this.u0 = d2.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.u0) && VideoPbFragment.this.K0 != null && VideoPbFragment.this.K0.a() != null && (m = VideoPbFragment.this.K0.a().m(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.u0)) {
                        ((View) m).setOnClickListener(VideoPbFragment.this.k1);
                    }
                }
                if (VideoPbFragment.this.z0 != null && L != null && L.T() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(L.T());
                    VideoPbFragment.this.z0.setLikeUserData(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.L().O0());
                        jSONObject.put("fid", VideoPbFragment.this.L().getForumId());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                }
                if (i != 0) {
                    EnterForePvThread enterForePvThread = new EnterForePvThread();
                    enterForePvThread.setOpType("2");
                    enterForePvThread.start();
                }
                if ((VideoPbFragment.this.w3() && VideoPbFragment.this.d3() == null) || VideoPbFragment.this.O2() == null) {
                    return;
                }
                ArrayList<PostData> arrayList = null;
                if (VideoPbFragment.this.w3()) {
                    if (i != -1) {
                        if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                            arrayList = VideoPbFragment.this.L().y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).z() != 1)) {
                            VideoPbFragment.this.d3().k1(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (VideoPbFragment.this.d3().e1()) {
                            VideoPbFragment.this.d3().l1(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            VideoPbFragment.this.d3().l1(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    } else {
                        VideoPbFragment.this.d3().k1("");
                    }
                    VideoPbFragment.this.d3().R0();
                } else {
                    if (i != -1) {
                        if (VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                            arrayList = VideoPbFragment.this.L().y0().D();
                        }
                        if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).z() != 1)) {
                            VideoPbFragment.this.O2().n1(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        } else if (VideoPbFragment.this.O2().f1()) {
                            VideoPbFragment.this.O2().o1(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                        } else {
                            VideoPbFragment.this.O2().o1(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                        }
                    } else {
                        VideoPbFragment.this.O2().n1("");
                    }
                    VideoPbFragment.this.O2().R0();
                }
            }
            d.b.i0.b3.c.g().h(VideoPbFragment.this.getUniqueId(), false);
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements TextWatcher {
        public v0() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
            if (s0Var == null || s0Var.e() == null) {
                return;
            }
            if (!VideoPbFragment.this.C0.e().e()) {
                VideoPbFragment.this.C0.a(false);
            }
            VideoPbFragment.this.C0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            if (VideoPbFragment.this.L0 != null && VideoPbFragment.this.L0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i) && TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements View.OnClickListener {
        public w() {
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
            d.b.i0.c2.o.g.a aVar = VideoPbFragment.this.Q;
            if (aVar != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 1);
                        VideoPbFragment.this.Q.A(sparseArray);
                        return;
                    }
                    aVar.g0(view);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    VideoPbFragment.this.Q.A(sparseArray);
                } else if (booleanValue3) {
                    aVar.d0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20048e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20049f;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public a() {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
                if (s0Var == null || s0Var.g() == null) {
                    return;
                }
                if (!VideoPbFragment.this.C0.g().e()) {
                    VideoPbFragment.this.C0.b(false);
                }
                VideoPbFragment.this.C0.g().l(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        }

        public w0(String str, String str2) {
            this.f20048e = str;
            this.f20049f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g2;
            int i2 = d.b.b.e.p.l.i(VideoPbFragment.this.f19966e.getApplicationContext());
            if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                i = TbadkCoreApplication.getInst().getKeyboardHeight();
                g2 = d.b.b.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            } else {
                i = i2 / 2;
                g2 = d.b.b.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
            }
            int i3 = i2 - (i + g2);
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            boolean z = true;
            int i4 = (videoPbFragment.P0[1] + videoPbFragment.Q0) - i3;
            if (videoPbFragment.c3() != null) {
                VideoPbFragment.this.c3().smoothScrollBy(0, i4);
            }
            if (VideoPbFragment.this.M0 != null) {
                VideoPbFragment.this.K0.a().setVisibility(8);
                VideoPbFragment.this.M0.n(this.f20048e, this.f20049f, VideoPbFragment.this.e3(), (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || !VideoPbFragment.this.L().y0().L().S1()) ? false : false);
                d.b.h0.w.w.h b2 = VideoPbFragment.this.M0.b();
                if (b2 != null && VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                    b2.E(VideoPbFragment.this.L().y0().d());
                    b2.X(VideoPbFragment.this.L().y0().L());
                }
                if (VideoPbFragment.this.C0.f() == null && VideoPbFragment.this.M0.b().s() != null) {
                    VideoPbFragment.this.M0.b().s().g(new a());
                    VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                    videoPbFragment2.C0.n(videoPbFragment2.M0.b().s().i());
                    VideoPbFragment.this.M0.b().K(VideoPbFragment.this.i1);
                }
            }
            VideoPbFragment.this.h3();
        }
    }

    /* loaded from: classes5.dex */
    public class x implements AdapterView.OnItemClickListener {
        public x() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().H0() == i + 1) {
                return;
            }
            VideoPbFragment videoPbFragment = VideoPbFragment.this;
            videoPbFragment.a4(videoPbFragment.a3(i));
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements c.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f20053a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f20054b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$x0$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0218a implements TextWatcher {
                public C0218a() {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    d.b.i0.c2.k.e.s0 s0Var = VideoPbFragment.this.C0;
                    if (s0Var == null || s0Var.g() == null) {
                        return;
                    }
                    if (!VideoPbFragment.this.C0.g().e()) {
                        VideoPbFragment.this.C0.b(false);
                    }
                    VideoPbFragment.this.C0.g().l(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            }

            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g2;
                int i2 = d.b.b.e.p.l.i(VideoPbFragment.this.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g2 = d.b.b.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    g2 = d.b.b.e.p.l.g(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + g2);
                VideoPbFragment videoPbFragment = VideoPbFragment.this;
                boolean z = true;
                int i4 = (videoPbFragment.P0[1] + videoPbFragment.Q0) - i3;
                if (videoPbFragment.c3() != null) {
                    VideoPbFragment.this.c3().smoothScrollBy(0, i4);
                }
                if (VideoPbFragment.this.M0 != null) {
                    VideoPbFragment.this.K0.a().setVisibility(8);
                    z = (VideoPbFragment.this.L() == null || VideoPbFragment.this.L().y0() == null || VideoPbFragment.this.L().y0().L() == null || !VideoPbFragment.this.L().y0().L().S1()) ? false : false;
                    d.b.i0.c2.k.e.s sVar = VideoPbFragment.this.M0;
                    x0 x0Var = x0.this;
                    sVar.n(x0Var.f20053a, x0Var.f20054b, VideoPbFragment.this.e3(), z);
                    d.b.h0.w.w.h b2 = VideoPbFragment.this.M0.b();
                    if (b2 != null && VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null) {
                        b2.E(VideoPbFragment.this.L().y0().d());
                        b2.X(VideoPbFragment.this.L().y0().L());
                    }
                    if (VideoPbFragment.this.C0.f() == null && VideoPbFragment.this.M0.b().s() != null) {
                        VideoPbFragment.this.M0.b().s().g(new C0218a());
                        VideoPbFragment videoPbFragment2 = VideoPbFragment.this;
                        videoPbFragment2.C0.n(videoPbFragment2.M0.b().s().i());
                        VideoPbFragment.this.M0.b().K(VideoPbFragment.this.i1);
                    }
                }
                VideoPbFragment.this.h3();
            }
        }

        public x0(String str, String str2) {
            this.f20053a = str;
            this.f20054b = str2;
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void a(boolean z, int i) {
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void b(boolean z) {
            if (z) {
                d.b.b.e.m.e.a().postDelayed(new a(), 0L);
            }
        }

        @Override // d.b.i0.p0.f2.a.c.d
        public void c(boolean z) {
        }
    }

    /* loaded from: classes5.dex */
    public class y extends CustomMessageListener {
        public y(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof f.a)) {
                return;
            }
            f.a aVar = (f.a) customResponsedMessage.getData();
            d.b.h0.b1.m.f.c(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.f49978a, aVar.f49979b, aVar.f49980c);
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements Runnable {
        public y0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.A == null || VideoPbFragment.this.A.v()) {
                if (VideoPbFragment.this.A != null && VideoPbFragment.this.L() != null && VideoPbFragment.this.L().y0() != null && VideoPbFragment.this.L().y0().l() != null) {
                    TiebaStatic.log(new StatisticItem("c13712").param("fid", VideoPbFragment.this.L().y0().l().getId()).param("fname", VideoPbFragment.this.L().y0().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.L().y0().N()).param("obj_param1", VideoPbFragment.this.A.p));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c13608").param("obj_id", VideoPbFragment.this.A.u()).param("obj_name", VideoPbFragment.this.A.t()).param("obj_type", 2).param("fid", VideoPbFragment.this.L().y0().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", VideoPbFragment.this.L().y0().N()));
            }
            VideoPbFragment.this.w4();
        }
    }

    /* loaded from: classes5.dex */
    public class z implements Observer<a2> {
        public z() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable a2 a2Var) {
            BdTypeRecyclerView c3;
            if (a2Var == null || a2Var.u1() == null) {
                return;
            }
            if (VideoPbFragment.this.o.getVideoUrl() == null || !VideoPbFragment.this.o.getVideoUrl().equals(a2Var.u1().video_url)) {
                if (!d.b.b.e.p.k.isEmpty(VideoPbFragment.this.o.getVideoUrl())) {
                    VideoPbFragment.this.y0 = true;
                    if (VideoPbFragment.this.w3()) {
                        VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.H1);
                    } else {
                        VideoPbFragment.this.i.setCurrentItem(VideoPbFragment.J1);
                    }
                    if (!VideoPbFragment.this.w3() && (c3 = VideoPbFragment.this.c3()) != null) {
                        c3.scrollToPosition(0);
                    }
                }
                if (VideoPbFragment.this.p == null || !VideoPbFragment.this.p.k()) {
                    VideoPbFragment.this.W3();
                    VideoPbFragment.this.t2(a2Var);
                }
                VideoPbFragment.this.v3();
                if (VideoPbFragment.this.p.l()) {
                    VideoPbFragment.this.p.s();
                }
                boolean z = !StringHelper.equals(VideoPbFragment.this.o.getVideoUrl(), a2Var.u1().video_url);
                VideoPbFragment.this.o.setData(a2Var);
                if (VideoPbFragment.this.w3()) {
                    VideoPbFragment.this.o.U0(VideoPbFragment.this.i.getCurrentItem() == 0);
                } else {
                    VideoPbFragment.this.o.U0(false);
                }
                if (z) {
                    VideoPbFragment.this.o.startPlay();
                    VideoPbFragment.this.o.x0();
                    return;
                }
                return;
            }
            VideoPbFragment.this.o.setData(a2Var);
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements ValueAnimator.AnimatorUpdateListener {
        public z0() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            VideoPbFragment.this.z.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static VideoPbFragment G3() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.q
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (d.b.h0.b1.m.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), d.b.h0.b1.m.f.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (d.b.i0.c2.k.e.v0.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new d.b.h0.b1.d(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public void A2() {
        if (!checkUpIsLogin()) {
            if (L() != null) {
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", L().getForumId()));
            }
        } else if (y2()) {
            d.b.h0.w.w.e eVar = this.K0;
            if (eVar != null && (eVar.B() || this.K0.D())) {
                this.K0.z(false, null);
                return;
            }
            if (this.L0 != null) {
                s3();
                this.r0.f20032a = false;
                if (this.L0.n(2) != null) {
                    d.b.i0.c3.g0.a.c(getPageContext(), (View) this.L0.n(2).k, false, null);
                }
            }
            h3();
        }
    }

    public final void A3(String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
        urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public final void A4() {
        VoiceManager voiceManager = this.X;
        if (voiceManager != null) {
            voiceManager.stopPlay();
        }
    }

    public final void B2() {
        if (L().e0() || L().h0()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", L().O0());
            this.f19966e.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, L().O0()));
        if (C4()) {
            this.f19966e.finish();
        }
    }

    public final void B3() {
        if (this.j0 != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.j0.setImageResource(0);
            this.j0.W(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.j0.setImageResource(R.drawable.transparent_bg);
    }

    public final void B4() {
        this.f19966e.superCloseActivity();
    }

    public void C2(ForumManageModel.b bVar) {
        List<PostData> list = L().y0().P().f52470a;
        int size = list.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = 0;
            while (true) {
                if (i3 >= list.get(i2).L().size()) {
                    break;
                } else if (bVar.f21385g.equals(list.get(i2).L().get(i3).D())) {
                    list.get(i2).L().remove(i3);
                    list.get(i2).n();
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            list.get(i2).o(bVar.f21385g);
        }
        if (z2) {
            if (O2() != null) {
                O2().e1();
            } else if (w3() && d3() != null) {
                d3().d1();
            }
        }
    }

    public final void C3(View view, String str, String str2, PostData postData) {
        if (view == null || str == null || str2 == null || w2() || !y2()) {
            return;
        }
        if (view.getParent() instanceof View) {
            ((View) view.getParent()).getLocationOnScreen(this.P0);
            this.Q0 = ((View) view.getParent()).getMeasuredHeight();
        }
        if (this.M0 != null && postData != null) {
            this.M0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.s().getName_show(), postData.J() != null ? postData.J().toString() : ""));
        }
        if (L() != null && L().y0() != null && L().y0().Z()) {
            d.b.b.e.m.e.a().postDelayed(new w0(str, str2), 0L);
            return;
        }
        if (this.B0 == null) {
            d.b.i0.p0.f2.a.c cVar = new d.b.i0.p0.f2.a.c(getPageContext());
            this.B0 = cVar;
            cVar.k(1);
            this.B0.j(new x0(str, str2));
        }
        if (L() == null || L().y0() == null || L().y0().l() == null) {
            return;
        }
        this.B0.h(L().y0().l().getId(), d.b.b.e.m.b.f(L().O0(), 0L));
    }

    public final boolean C4() {
        if (L() == null) {
            return true;
        }
        if (L().y0() == null || !L().y0().Z()) {
            if (L().k0()) {
                MarkData X = L().X();
                if (X != null && L().i0() && c3() != null) {
                    MarkData R = L().R(c3().getFirstVisiblePosition());
                    if (R == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", X);
                        this.f19966e.setResult(-1, intent);
                        return true;
                    } else if (R.getPostId() != null && !R.getPostId().equals(X.getPostId())) {
                        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getBaseFragmentActivity());
                        aVar.setMessage(getPageContext().getString(R.string.alert_update_mark));
                        aVar.setPositiveButton(R.string.confirm, new q(R, X, aVar));
                        aVar.setNegativeButton(R.string.cancel, new r(X, aVar));
                        aVar.setOnCalcelListener(new s());
                        aVar.create(getBaseFragmentActivity().getPageContext());
                        aVar.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", X);
                        this.f19966e.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (L().y0() != null && L().y0().D() != null && L().y0().D().size() > 0 && L().i0()) {
                this.f19966e.setResult(1);
            }
            return true;
        }
        return true;
    }

    public void D2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        int intValue = ((Integer) sparseArray.get(K1)).intValue();
        if (intValue == L1) {
            if (this.W.K()) {
                return;
            }
            showProgressBar();
            String str = (String) sparseArray.get(R.id.tag_del_post_id);
            int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
            boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
            int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            if (jSONArray != null) {
                this.W.M(StringHelper.JsonArrayToString(jSONArray));
            }
            this.W.N(L().y0().l().getId(), L().y0().l().getName(), L().y0().L().o0(), str, intValue3, intValue2, booleanValue, L().y0().L().V());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
        } else if (intValue == M1 || intValue == N1) {
            if (L().W() != null) {
                L().W().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
            }
            if (intValue == M1) {
                TiebaStatic.log("c10499");
            }
        }
    }

    public final void D3() {
        if (L() == null) {
            return;
        }
        d.b.i0.c2.h.e y02 = L().y0();
        L().T1(true);
        d.b.h0.h.a aVar = this.S;
        if (aVar != null) {
            y02.p0(aVar.g());
        }
        if (w3()) {
            if (P2() != null) {
                P2().P0();
            }
            if (d3() != null) {
                d3().d1();
            }
        } else if (O2() != null) {
            O2().e1();
        }
    }

    public void D4() {
        d.b.h0.w.w.e eVar = this.K0;
        if (eVar != null) {
            d4(eVar.C());
        }
        V3();
        this.Q.E();
    }

    public void E2(d.b.h0.r.s.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (L() == null || L().y0() == null || L().y0().L() == null || L().y0().l() == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            if (aVar.getYesButtonTag() instanceof SparseArray) {
                D2((SparseArray) aVar.getYesButtonTag(), jSONArray);
                return;
            }
            return;
        }
        TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
    }

    public final void E3() {
        MarkData R;
        if (L() == null || L().y0() == null) {
            return;
        }
        if (w3() && d3() == null) {
            return;
        }
        if ((w3() || O2() != null) && this.S != null) {
            if (L().y0() != null && L().y0().Z()) {
                R = L().R(0);
            } else {
                CustomViewPager customViewPager = this.i;
                if (customViewPager != null && customViewPager.getCurrentItem() == H1) {
                    R = L().s0(Q2(L().y0()));
                } else if (w3()) {
                    R = L().R(d3().W0());
                } else {
                    R = L().R(O2().W0());
                }
            }
            if (R == null) {
                return;
            }
            if (R.isApp() && (R = L().R(d3().W0() + 1)) == null) {
                return;
            }
            j4();
            this.S.i(R);
            if (!this.S.e()) {
                this.S.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.S.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void E4() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        ValueAnimator valueAnimator = this.N;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.N = ofFloat;
            ofFloat.addUpdateListener(new z0());
            this.N.setDuration(200L);
            this.N.start();
            this.N.addListener(new a1(layoutParams));
        }
    }

    public void F2(int i2, String str, int i3, boolean z2) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
        sparseArray.put(K1, Integer.valueOf(L1));
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            D2(sparseArray, null);
        } else {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public final boolean F3(String str) {
        if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String o2 = d.b.h0.r.d0.b.i().o("bubble_link", "");
            if (StringUtils.isNull(o2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                d.b.h0.l.a.o(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), o2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return false;
    }

    public final void F4() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.setDuration(300L);
        this.M.addUpdateListener(new g1());
        this.M.start();
    }

    public void G2(boolean z2) {
        AppBarLayout appBarLayout = this.m;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(z2);
        }
    }

    public final void G4(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        int i2 = layoutParams2.height;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.M = ofFloat;
        ofFloat.addUpdateListener(new e1(layoutParams, layoutParams2, i2));
        this.M.setDuration(300L);
        this.M.start();
        this.M.addListener(new f1());
    }

    public final void H2(ForumManageModel.b bVar, boolean z2) {
        if (bVar == null) {
            return;
        }
        String string = !TextUtils.isEmpty(bVar.f21380b) ? bVar.f21380b : getString(R.string.delete_fail);
        int i2 = 0;
        if (bVar.f21381c == 1211066) {
            hideProgressBar();
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
            aVar.setMessage(string);
            aVar.setPositiveButton(R.string.dialog_known, new o());
            aVar.setCancelable(true);
            aVar.create(getPageContext());
            aVar.show();
        } else {
            I2(0, bVar.f21379a, bVar.f21380b, z2);
        }
        if (bVar.f21379a) {
            int i3 = bVar.f21382d;
            if (i3 == 1) {
                ArrayList<PostData> D = L().y0().D();
                int size = D.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (bVar.f21385g.equals(D.get(i2).D())) {
                        D.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
                L().y0().L().Y3(L().y0().L().Z0() - 1);
                if (O2() != null) {
                    O2().e1();
                } else if (w3() && d3() != null) {
                    d3().d1();
                }
            } else if (i3 == 0) {
                B2();
            } else if (i3 == 2) {
                ArrayList<PostData> D2 = L().y0().D();
                int size2 = D2.size();
                boolean z3 = false;
                for (int i4 = 0; i4 < size2 && !z3; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= D2.get(i4).L().size()) {
                            break;
                        } else if (bVar.f21385g.equals(D2.get(i4).L().get(i5).D())) {
                            D2.get(i4).L().remove(i5);
                            D2.get(i4).n();
                            z3 = true;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    D2.get(i4).o(bVar.f21385g);
                }
                if (z3) {
                    if (O2() != null) {
                        O2().e1();
                    } else if (w3() && d3() != null) {
                        d3().d1();
                    }
                }
                C2(bVar);
            }
        }
    }

    public void H3(boolean z2) {
        this.l.setVisibility(z2 ? 0 : 8);
    }

    public final void H4(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
        int i2 = layoutParams2.height;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.M = ofFloat;
        ofFloat.addUpdateListener(new b1(layoutParams, layoutParams2, i2));
        this.M.setDuration(300L);
        this.M.start();
        this.M.addListener(new d1());
    }

    @Override // d.b.i0.c2.o.b
    public VideoPbFragment I() {
        return this;
    }

    public void I2(int i2, boolean z2, String str, boolean z3) {
        hideProgressBar();
        if (z2 && z3) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z3) {
            if (d.b.b.e.p.k.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    public final void I3() {
        if (!d.b.b.e.p.j.z()) {
            showToast(R.string.network_not_available);
        } else if (this.Q == null || L() == null) {
        } else {
            this.Q.E();
            if (this.O) {
                return;
            }
            A4();
            j4();
            if (L().LoadData()) {
                s4();
            }
        }
    }

    public final void I4() {
        if (L() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.x(L().getForumId()) || L().y0() == null || L().y0().l() == null) {
            return;
        }
        if (L().y0().l().isLike() == 1) {
            L().O().w(L().getForumId(), L().O0());
        }
    }

    public final void J2(int i2, ForumManageModel.g gVar) {
        String string;
        if (gVar == null || L() == null || L().y0() == null || L().y0().L() == null) {
            return;
        }
        I2(this.W.getLoadDataMode(), gVar.f21400a, gVar.f21401b, false);
        if (gVar.f21400a) {
            this.v0 = true;
            if (i2 == 2 || i2 == 3) {
                this.w0 = true;
                this.x0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.w0 = false;
                this.x0 = true;
            }
            if (i2 == 2) {
                L().y0().L().K3(1);
                L().J1(1);
            } else if (i2 == 3) {
                L().y0().L().K3(0);
                L().J1(0);
            } else if (i2 == 4) {
                L().y0().L().L3(1);
                L().K1(1);
            } else if (i2 == 5) {
                L().y0().L().L3(0);
                L().K1(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.f21401b)) {
                string = gVar.f21401b;
            } else {
                string = getString(R.string.operation_failed);
            }
            d.b.b.e.p.l.L(getPageContext().getPageActivity(), string);
        }
        if (L().y0().L() == null || P2() == null) {
            return;
        }
        P2().V0();
    }

    public void J3(int i2) {
        if (i2 == 0) {
            d.b.i0.b3.c.g().h(getUniqueId(), false);
        }
    }

    public void J4(d.b.i0.c2.h.e eVar) {
        if (eVar != null && AntiHelper.o(eVar.L())) {
            d.b.i0.c2.p.d dVar = this.o0;
            if (dVar != null) {
                dVar.h(false);
                this.o0.g();
            }
            ViewGroup.LayoutParams layoutParams = this.n0.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.n0.setLayoutParams(layoutParams);
            WebPManager.setPureDrawable(this.n0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            return;
        }
        d.b.i0.c2.p.d dVar2 = this.o0;
        if (dVar2 == null || !dVar2.e()) {
            ViewGroup.LayoutParams layoutParams2 = this.n0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.n0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.n0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public final String K2(int i2) {
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
            return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i2 >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i2 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i2;
        }
    }

    public void K3(boolean z2) {
        if (P() == null) {
            return;
        }
        if (this.q1 && !TbSingleton.getInstance().isNotchScreen(P()) && !TbSingleton.getInstance().isCutoutScreen(P())) {
            x4();
            UtilHelper.hideStatusBar(P(), P().getRootView());
            this.q1 = false;
        }
        this.r0.f20033b = z2;
        L3();
        O3();
    }

    public void K4(boolean z2) {
        DetailInfoAndReplyFragment O2 = O2();
        if (O2 != null && O2.E0() != null && O2.E0().l() != null && O2.E0().m() != null) {
            O2.E0().l().W0(z2);
            O2.E0().m().s0(z2);
        }
        MaskView maskView = this.E;
        if (maskView != null) {
            maskView.setVisibility(z2 ? 0 : 8);
        }
    }

    @Override // d.b.i0.c2.o.b
    public PbModel L() {
        return this.f19966e.getPbModel();
    }

    public d.b.h0.s.e.a L2() {
        return this.V;
    }

    public final void L3() {
        if (this.o == null) {
            return;
        }
        if (this.r0.a()) {
            this.o.Y(false);
            return;
        }
        d.b.i0.c2.o.k.a aVar = this.o;
        aVar.Y(!aVar.Q0());
    }

    public LinearLayout M2() {
        return this.i0;
    }

    public final void M3(d.b.i0.c2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        a2 L = eVar.L();
        if (L != null && L.x2()) {
            v2();
        } else {
            g4(this.E0);
        }
        d.b.h0.w.w.e eVar2 = this.K0;
        if (eVar2 != null) {
            d4(eVar2.C());
            this.K0.M(eVar.d());
            this.K0.N(eVar.l(), eVar.Q());
            this.K0.r0(L);
            if (L() != null) {
                this.K0.O(L().c0(), L().O0(), L().Z());
            }
            if (L != null) {
                this.K0.h0(L.k2());
            }
        }
    }

    public final int N2() {
        if (L() == null || L().y0() == null || L().y0().L() == null) {
            return -1;
        }
        return L().y0().L().G();
    }

    public void N3() {
        if (!checkUpIsLogin() || L() == null || L().y0() == null || L().y0().l() == null || w2()) {
            return;
        }
        if (L().y0().Z()) {
            A2();
            return;
        }
        if (this.A0 == null) {
            d.b.i0.p0.f2.a.c cVar = new d.b.i0.p0.f2.a.c(getPageContext());
            this.A0 = cVar;
            cVar.k(0);
            this.A0.j(new q0());
        }
        this.A0.h(L().y0().l().getId(), d.b.b.e.m.b.f(L().O0(), 0L));
    }

    public DetailInfoAndReplyFragment O2() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(J1) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.j.i(J1);
    }

    public final void O3() {
        if (this.o == null || this.i == null) {
            return;
        }
        boolean z2 = false;
        if (!w3()) {
            this.o.U0(false);
        } else if (this.i.getCurrentItem() != 0) {
            this.o.U0(false);
        } else if (this.r0.a()) {
            this.o.U0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.o.U0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    @Override // d.b.i0.c2.o.b
    public PbActivity P() {
        return this.f19966e;
    }

    public DetailInfoFragment P2() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(H1) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.j.i(H1);
    }

    public void P3(boolean z2, int i2, int i3, int i4, d.b.i0.c2.h.e eVar, String str, int i5) {
        for (BaseFragment baseFragment : this.j.j()) {
            if (baseFragment instanceof d.b.i0.c2.o.a) {
                ((d.b.i0.c2.o.a) baseFragment).t0(z2, i2, i3, i4, eVar, str, i5);
            }
        }
        t0(z2, i2, i3, i4, eVar, str, i5);
    }

    public PostData Q2(d.b.i0.c2.h.e eVar) {
        PostData postData = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.S() != null) {
            return eVar.S();
        }
        if (!ListUtils.isEmpty(eVar.D())) {
            Iterator<PostData> it = eVar.D().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PostData next = it.next();
                if (next != null && next.z() == 1) {
                    postData = next;
                    break;
                }
            }
        }
        if (postData == null) {
            postData = eVar.j();
        }
        if (postData == null) {
            postData = b3(eVar);
        }
        if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
            postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
        }
        return postData;
    }

    public void Q3(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        J4(eVar);
        this.m0.setVisibility(eVar.Z() ? 8 : 0);
        if (eVar.r()) {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String K2 = K2(eVar.L().Z0());
        TextView textView = this.p0;
        if (textView != null) {
            textView.setText(K2);
        }
        TextView textView2 = this.q0;
        if (textView2 != null) {
            textView2.setText(K2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.L()));
    }

    public final String R2() {
        ArrayList<PostData> D;
        int count;
        if (L() == null || L().y0() == null || L().y0().D() == null || (count = ListUtils.getCount((D = L().y0().D()))) == 0) {
            return "";
        }
        if (L().J0()) {
            Iterator<PostData> it = D.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.z() == 1) {
                    return next.D();
                }
            }
        }
        int i2 = 0;
        if (c3() != null) {
            if (w3()) {
                i2 = d3().U0();
            } else {
                i2 = O2().U0();
            }
        }
        PostData postData = (PostData) ListUtils.getItem(D, i2);
        if (postData != null && postData.s() != null) {
            if (L().f1(postData.s().getUserId())) {
                return postData.D();
            }
            for (int i3 = i2 - 1; i3 != 0; i3--) {
                PostData postData2 = (PostData) ListUtils.getItem(D, i3);
                if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                    break;
                } else if (L().f1(postData2.s().getUserId())) {
                    return postData2.D();
                }
            }
            for (int i4 = i2 + 1; i4 < count; i4++) {
                PostData postData3 = (PostData) ListUtils.getItem(D, i4);
                if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                    break;
                } else if (L().f1(postData3.s().getUserId())) {
                    return postData3.D();
                }
            }
        }
        return "";
    }

    public void R3(boolean z2, MarkData markData) {
        if (L() == null) {
            return;
        }
        i4();
        L().T1(z2);
        d.b.h0.h.a aVar = this.S;
        if (aVar != null) {
            aVar.h(z2);
            if (markData != null) {
                this.S.i(markData);
            }
        }
        if (L().k0()) {
            D3();
        } else if (w3()) {
            if (P2() != null) {
                P2().P0();
            }
            if (d3() != null) {
                d3().d1();
            }
        } else if (O2() != null) {
            O2().e1();
        }
    }

    public boolean S2() {
        return this.y;
    }

    public void S3(d.b.i0.c2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return;
        }
        String valueOf = String.valueOf(eVar.L().Z0());
        if (eVar.L().Z0() == 0) {
            valueOf = "";
        }
        this.f19969h.F(valueOf);
    }

    public View.OnClickListener T2() {
        return this.B1;
    }

    public void T3(d.b.i0.c2.h.q qVar) {
        boolean z2;
        MetaData metaData;
        if (L() == null || L().y0() == null || qVar.i() == null) {
            return;
        }
        String D = qVar.i().D();
        ArrayList<PostData> D2 = L().y0().D();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= D2.size()) {
                break;
            }
            PostData postData = D2.get(i2);
            if (postData.D() == null || !postData.D().equals(D)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = qVar.k();
                postData.s0(qVar.m());
                if (postData.L() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.R() != null && next != null && next.s() != null && (metaData = postData.R().get(next.s().getUserId())) != null) {
                            next.e0(metaData);
                            next.m0(true);
                            next.x0(getPageContext(), L().f1(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.L().size();
                    if (postData.L() != null && postData.L().size() < 2) {
                        postData.L().clear();
                        postData.L().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.w() != null) {
                    postData.d0();
                }
            }
        }
        if (L().i0() || !z2) {
            return;
        }
        if (w3() && d3() != null) {
            d3().d1();
        } else if (O2() != null) {
            O2().e1();
        }
    }

    public View.OnClickListener U2() {
        return this.C1;
    }

    public final void U3() {
        if (this.K0 == null || this.L0 == null) {
            return;
        }
        d.b.h0.w.w.a.a().c(0);
        this.K0.T();
        this.K0.R();
        if (this.K0.y() != null) {
            this.K0.y().setMaxImagesAllowed(this.K0.z ? 1 : 9);
        }
        this.K0.l0(SendView.k);
        this.K0.j(SendView.k);
        d.b.h0.w.h m2 = this.L0.m(23);
        d.b.h0.w.h m3 = this.L0.m(2);
        d.b.h0.w.h m4 = this.L0.m(5);
        if (m3 != null) {
            m3.b();
        }
        if (m4 != null) {
            m4.b();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.L0.invalidate();
    }

    public SparseArray<Object> V2(d.b.i0.c2.h.e eVar, boolean z2, int i2) {
        PostData Q2;
        d.b.h0.r.q.d0 d0Var;
        int i3;
        StringBuilder sb = null;
        if (eVar == null || (Q2 = Q2(eVar)) == null) {
            return null;
        }
        String userId = Q2.s().getUserId();
        boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (i2 == 0) {
            sparseArray.put(R.id.tag_del_post_id, Q2.D());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.R()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
        } else if (i2 == 1) {
            if (Q2.s() != null) {
                sparseArray.put(R.id.tag_forbid_user_name, Q2.s().getUserName());
                sparseArray.put(R.id.tag_forbid_user_name_show, Q2.s().getName_show());
                sparseArray.put(R.id.tag_forbid_user_portrait, Q2.s().getPortrait());
                sparseArray.put(R.id.tag_forbid_user_post_id, Q2.D());
            }
            sparseArray.put(R.id.tag_del_post_id, Q2.D());
            sparseArray.put(R.id.tag_del_post_type, 0);
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.R()));
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
        }
        if (!z3) {
            List<w1> p2 = eVar.p();
            if (ListUtils.getCount(p2) > 0) {
                sb = new StringBuilder();
                for (w1 w1Var : p2) {
                    if (w1Var != null && !StringUtils.isNull(w1Var.i()) && (d0Var = w1Var.f50921g) != null && d0Var.f50756a && !d0Var.f50758c && ((i3 = d0Var.f50757b) == 1 || i3 == 2)) {
                        sb.append(d.b.b.e.p.k.cutString(w1Var.i(), 12));
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

    public void V3() {
        U3();
        j3();
        this.M0.c();
        q4(false);
    }

    public d.b.h0.h.a W2() {
        return this.S;
    }

    public final void W3() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        layoutParams.height = 0;
        this.z.setLayoutParams(layoutParams);
        this.z.setVisibility(8);
    }

    public View.OnLongClickListener X2() {
        return this.F1;
    }

    public void X3() {
        this.R0 = -1;
        this.S0 = Integer.MIN_VALUE;
    }

    public View.OnTouchListener Y2() {
        return this.y1;
    }

    public boolean Y3(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.t()) && d.b.h0.r.k.c().g()) {
                    return F3(postData.D());
                }
                if (checkUpIsLogin() && L() != null && L().y0() != null) {
                    d.b.i0.c2.k.e.s sVar = this.M0;
                    if (sVar != null) {
                        sVar.c();
                    }
                    d.b.i0.c2.h.q qVar = new d.b.i0.c2.h.q();
                    qVar.A(L().y0().l());
                    qVar.E(L().y0().L());
                    qVar.C(postData);
                    this.N0.E(qVar);
                    this.N0.setPostId(postData.D());
                    C3(view, postData.s().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    d.b.h0.w.w.e eVar = this.K0;
                    if (eVar != null) {
                        d4(eVar.C());
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public d.b.h0.w.w.e Z2() {
        return this.K0;
    }

    public final void Z3(EmotionImageData emotionImageData) {
        if (emotionImageData == null) {
            return;
        }
        if (this.T == null) {
            d.b.i0.c2.k.e.y0.f.a aVar = new d.b.i0.c2.k.e.y0.f.a(this.f19966e);
            this.T = aVar;
            aVar.n(this.A1);
            this.T.m(this.j1);
        }
        this.T.k(emotionImageData, L(), L().y0());
    }

    public final int a3(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return i2 != 3 ? 1 : 7;
            }
            return 6;
        }
        return 5;
    }

    public final void a4(int i2) {
        if (L() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(L().O0());
            sendMessage(privacySettingMessage);
        }
    }

    public final PostData b3(d.b.i0.c2.h.e eVar) {
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
        postData.g0(1);
        postData.j0(eVar.L().f0());
        postData.v0(eVar.L().x1());
        postData.u0(eVar.L().Z());
        postData.e0(T);
        return postData;
    }

    public void b4(int i2) {
        LinearLayout linearLayout = this.f0;
        if (linearLayout != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public BdTypeRecyclerView c3() {
        Iterator<BaseFragment> it = this.j.j().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).X0();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).X0();
            }
        }
        return null;
    }

    public void c4(EditorTools editorTools) {
        this.L0 = editorTools;
        editorTools.setId(R.id.pb_editor);
        this.L0.setOnCancelClickListener(new t0());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.L0.getParent() == null) {
            this.f19968g.addView(this.L0, layoutParams);
        }
        this.L0.w(TbadkCoreApplication.getInst().getSkinType());
        this.L0.setActionListener(24, new u0());
        j3();
        this.K0.i(new v0());
    }

    public ReplyFragment d3() {
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.i(I1) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.j.i(I1);
    }

    public void d4(boolean z2) {
        this.t0 = z2;
    }

    public String e3() {
        if (!d.b.b.e.p.k.isEmpty(this.s0)) {
            return this.s0;
        }
        String string = TbadkCoreApplication.getInst().getResources().getString(d.b.i0.c2.k.e.p0.a());
        this.s0 = string;
        return string;
    }

    public void e4(boolean z2) {
        this.O = z2;
    }

    public final void f3(int i2, Intent intent) {
        d.b.h0.w.n nVar;
        d.b.i0.c2.k.e.s sVar;
        d.b.h0.w.n nVar2;
        if (i2 == 0) {
            j3();
            d.b.i0.c2.k.e.s sVar2 = this.M0;
            if (sVar2 != null) {
                sVar2.c();
            }
            q4(false);
        }
        V3();
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
                this.K0.S();
                this.K0.t0(pbEditorData.getVoiceModel());
                this.K0.G(writeData);
                d.b.h0.w.m n2 = this.K0.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.K0.L(null, null);
                }
            } else if (editorType != 1 || (sVar = this.M0) == null || sVar.b() == null) {
            } else {
                d.b.h0.w.w.h b2 = this.M0.b();
                b2.X(L().y0().L());
                b2.z(writeData);
                b2.Y(pbEditorData.getVoiceModel());
                d.b.h0.w.m n3 = b2.a().n(6);
                if (n3 != null && (nVar2 = n3.k) != null) {
                    nVar2.onAction(new d.b.h0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    b2.D();
                }
            }
        }
    }

    public void f4(boolean z2) {
        this.q1 = z2;
    }

    @Override // d.b.i0.c2.o.b
    public void finish() {
        CardHListViewData q2;
        PbModel pbModel = this.f19966e.getPbModel();
        if (pbModel != null && pbModel.y0() != null && !pbModel.y0().Z()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = pbModel.y0().L().o0();
            if (pbModel.isShareThread() && pbModel.y0().L().r1 != null) {
                historyMessage.threadName = pbModel.y0().L().r1.f13211b;
            } else {
                historyMessage.threadName = pbModel.y0().L().x1();
            }
            if (pbModel.isShareThread() && !isSimpleForum()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = pbModel.y0().l().getName();
            }
            ArrayList<PostData> D = pbModel.y0().D();
            int U0 = d3() != null ? d3().U0() : 0;
            if (D != null && U0 >= 0 && U0 < D.size()) {
                historyMessage.postID = D.get(U0).D();
            }
            historyMessage.isHostOnly = pbModel.d0();
            historyMessage.isSquence = pbModel.M0();
            historyMessage.isShareThread = pbModel.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        d.b.h0.w.w.e eVar = this.K0;
        if (eVar != null) {
            eVar.I();
        }
        if (pbModel != null && (pbModel.e0() || pbModel.h0())) {
            Intent intent = new Intent();
            intent.putExtra("tid", pbModel.O0());
            if (this.v0) {
                if (this.x0) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", pbModel.n0());
                }
                if (this.w0) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", pbModel.j0());
                }
            }
            if (pbModel.y0() != null && System.currentTimeMillis() - this.f19967f >= 40000 && (q2 = pbModel.y0().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                intent.putExtra("guess_like_data", q2);
            }
            this.f19966e.setResult(-1, intent);
        }
        if (C4()) {
            if (pbModel != null) {
                d.b.i0.c2.h.e y02 = pbModel.y0();
                if (y02 != null) {
                    if (y02.Q() != null) {
                        y02.Q().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.y0) {
                        if (this.n != null) {
                            Rect rect = new Rect();
                            this.n.getGlobalVisibleRect(rect);
                            d.b.i0.c2.k.e.k0.b().t(rect);
                        }
                        d.b.i0.c2.k.e.k0.b().s(this.i.getCurrentItem());
                        BdTypeRecyclerView c3 = c3();
                        d.b.i0.c2.k.e.k0.b().n(pbModel.z0(), c3 != null ? c3.onSaveInstanceState() : null, pbModel.M0(), pbModel.d0(), false);
                    }
                }
            } else {
                d.b.i0.c2.k.e.k0.b().m();
            }
            B4();
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
    public void g3(boolean z2) {
        d.b.i0.c2.h.e y02;
        int i2;
        if (L() == null || this.Q == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (y02 = L().y0()) == null) {
            return;
        }
        a2 L = y02.L();
        if (L != null && L.T() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", L().O0()).param("fid", y02.m()).param("obj_locate", 4).param("uid", L.T().getUserId()));
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
            statisticItem.param("tid", L().O0());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", L().getForumId());
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
                if (L.V() != null && !d.b.b.e.p.k.isEmpty(L.V().oriUgcVid)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, L.V().oriUgcVid);
                }
            }
            if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (P() != null) {
                d.b.h0.j0.c.e(P(), statisticItem);
            }
            TiebaStatic.log(statisticItem);
            if (d.b.b.e.p.l.C()) {
                showToast(R.string.neterror);
                return;
            } else if (L().y0() == null) {
                d.b.b.e.p.l.L(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                return;
            } else {
                ArrayList<PostData> D = y02.D();
                if ((D == null || D.size() <= 0) && L().M0()) {
                    d.b.b.e.p.l.L(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                    return;
                }
                this.Q.E();
                A4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), L)) {
                    return;
                }
                d.b.i0.c2.p.d dVar = this.o0;
                if (dVar != null) {
                    dVar.h(false);
                    J4(y02);
                }
                if (ShareSwitch.isOn()) {
                    t4(z2 ? 2 : 1);
                    return;
                }
                this.Q.q0();
                L().V().u(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem2.param("tid", L().O0());
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem2.param("fid", L().getForumId());
        if (!z2) {
        }
        statisticItem2.param("obj_name", i2);
        statisticItem2.param("obj_type", 2);
        if (L != null) {
        }
        if (!d.b.b.e.p.k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (P() != null) {
        }
        TiebaStatic.log(statisticItem2);
        if (d.b.b.e.p.l.C()) {
        }
    }

    public final void g4(d.b.h0.w.w.g gVar) {
        if (gVar == null || L() == null) {
            return;
        }
        gVar.o(L().a0());
        if (L().y0() != null && L().y0().l() != null) {
            gVar.n(L().y0().l());
        }
        gVar.p("pb");
        gVar.q(L());
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<GifView> getGifViewPool() {
        if (this.Y == null) {
            this.Y = new d.b.b.e.k.b<>(new i1(), 20, 0);
        }
        return this.Y;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<ImageView> getImageViewPool() {
        if (this.a0 == null) {
            this.a0 = new d.b.b.e.k.b<>(new h1(), 8, 0);
        }
        return this.a0;
    }

    @Override // d.b.h0.b1.m.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        d.b.b.e.k.b<RelativeLayout> bVar = new d.b.b.e.k.b<>(new l1(), 10, 0);
        this.d0 = bVar;
        return bVar;
    }

    @Override // d.b.h0.b1.m.h
    public int getRichTextViewId() {
        return 0;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<TextView> getTextViewPool() {
        if (this.Z == null) {
            this.Z = TbRichTextView.w(getPageContext().getPageActivity(), 8);
        }
        return this.Z;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<LinearLayout> getTextVoiceViewPool() {
        if (this.c0 == null) {
            this.c0 = new d.b.b.e.k.b<>(new k1(), 15, 0);
        }
        return this.c0;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        if (this.X == null) {
            this.X = VoiceManager.instance();
        }
        return this.X;
    }

    @Override // d.b.h0.b1.m.h
    public d.b.b.e.k.b<View> getVoiceViewPool() {
        if (this.b0 == null) {
            this.b0 = new d.b.b.e.k.b<>(new j1(), 8, 0);
        }
        return this.b0;
    }

    public void h3() {
        if (this.h0 == null) {
            return;
        }
        this.g0.setVisibility(8);
        this.h0.setVisibility(8);
        this.r0.f20032a = false;
        L3();
        O3();
    }

    public void h4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        d.b.i0.c2.o.g.a aVar = this.Q;
        if (aVar == null) {
            return;
        }
        if (z2) {
            aVar.E();
        } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
            this.Q.F();
        } else {
            this.Q.E();
        }
    }

    public void i3(boolean z2) {
        TextView textView;
        if (this.h0 == null || (textView = this.k0) == null) {
            return;
        }
        textView.setText(e3());
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.h0.startAnimation(alphaAnimation);
        }
        this.g0.setVisibility(0);
        this.h0.setVisibility(0);
        this.r0.f20032a = true;
    }

    public void i4() {
        hideProgressBar();
        if (w3() && d3() != null) {
            d3().R0();
            d3().S0();
        } else if (O2() != null) {
            O2().R0();
            O2().S0();
        }
    }

    public final void initData() {
        d.b.h0.h.a c2 = d.b.h0.h.a.c(this.f19966e);
        this.S = c2;
        if (c2 != null) {
            c2.j(this.Y0);
        }
        ForumManageModel forumManageModel = new ForumManageModel(this.f19966e);
        this.W = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.x1);
        this.V = new d.b.h0.s.e.a(getPageContext());
        this.Q = new d.b.i0.c2.o.g.a(this);
    }

    public boolean isSimpleForum() {
        PbModel pbModel = this.f19966e.getPbModel();
        if (pbModel == null) {
            return false;
        }
        return pbModel.e1();
    }

    public void j3() {
        EditorTools editorTools = this.L0;
        if (editorTools != null) {
            editorTools.o();
        }
    }

    public void j4() {
        d.b.b.e.p.l.w(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    public void k3() {
        if (this.f19966e.getCurrentFocus() != null) {
            d.b.b.e.p.l.w(getPageContext().getPageActivity(), this.f19966e.getCurrentFocus());
        }
    }

    public final void k4(int i2) {
        if (L() == null) {
            return;
        }
        int H0 = L().H0();
        if (i2 == 5) {
            L().Q1(2);
        } else if (i2 == 6) {
            L().Q1(3);
        } else if (i2 != 7) {
            L().Q1(1);
        } else {
            L().Q1(4);
        }
        int H02 = L().H0();
        if (H0 == 4 || H02 == 4) {
            I3();
        }
    }

    public void l3() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void l4(int i2) {
        View view = this.k;
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public final void m3() {
        this.f0 = (LinearLayout) this.f19968g.findViewById(R.id.video_pb_comment_container);
        this.g0 = this.f19968g.findViewById(R.id.video_view_comment_top_line);
        this.h0 = this.f19968g.findViewById(R.id.pb_editor_tool_comment);
        d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds242);
        HeadImageView headImageView = (HeadImageView) this.f19968g.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.j0 = headImageView;
        headImageView.setVisibility(0);
        this.j0.setIsRound(true);
        this.j0.setBorderWidth(d.b.b.e.p.l.g(getContext(), R.dimen.L_X01));
        this.j0.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.j0.setPlaceHolder(0);
        B3();
        this.k0 = (TextView) this.f19968g.findViewById(R.id.pb_editor_tool_comment_reply_text);
        LinearLayout linearLayout = (LinearLayout) this.f19968g.findViewById(R.id.pb_editer_tool_comment_layout);
        this.i0 = linearLayout;
        linearLayout.setOnClickListener(new k0());
        ImageView imageView = (ImageView) this.f19968g.findViewById(R.id.pb_editor_tool_comment_icon);
        this.l0 = imageView;
        imageView.setOnClickListener(this.B1);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView2 = (ImageView) this.f19968g.findViewById(R.id.pb_editor_tool_collection);
        this.m0 = imageView2;
        imageView2.setOnClickListener(this.B1);
        if (booleanExtra) {
            this.m0.setVisibility(8);
        } else {
            this.m0.setVisibility(0);
        }
        ImageView imageView3 = (ImageView) this.f19968g.findViewById(R.id.pb_editor_tool_share);
        this.n0 = imageView3;
        imageView3.setOnClickListener(this.B1);
        d.b.i0.c2.p.d dVar = new d.b.i0.c2.p.d(this.n0);
        this.o0 = dVar;
        dVar.d();
        TextView textView = (TextView) this.f19968g.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.p0 = textView;
        textView.setVisibility(0);
        q4(false);
    }

    public void m4(boolean z2) {
        this.y = z2;
    }

    public final void n3() {
        this.N0 = new PbFakeFloorModel(getPageContext());
        d.b.i0.c2.k.e.s sVar = new d.b.i0.c2.k.e.s(getPageContext(), this.N0, this.f19968g);
        this.M0 = sVar;
        sVar.k(new m0());
        this.M0.m(this.z1);
        this.N0.D(new n0());
    }

    public final void n4(boolean z2) {
        this.K0.f0(z2);
        this.K0.i0(z2);
        this.K0.p0(z2);
    }

    public void o3() {
        c4(this.K0.a());
    }

    public final void o4(int i2, AntiData antiData, String str) {
        if (AntiHelper.m(i2, str)) {
            if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new s0()) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        } else if (i2 == 230277) {
            d.b.i0.c2.o.g.a aVar = this.Q;
            if (aVar != null) {
                aVar.x0(str);
            }
        } else {
            showToast(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M3(videoPbViewModel.c());
        S3(videoPbViewModel.c());
        if (L() != null && L().y0() != null) {
            boolean i02 = L().i0();
            d.b.i0.c2.h.e y02 = L().y0();
            if (i02) {
                PostData Q2 = Q2(y02);
                if (y02.t() != null && !y02.t().equals(Q2.D()) && this.i != null) {
                    if (w3()) {
                        this.i.setCurrentItem(I1);
                    } else {
                        this.i.setCurrentItem(J1);
                    }
                }
            }
        }
        videoPbViewModel.j().observe(this, new z());
        videoPbViewModel.b().observe(this, new a0());
        videoPbViewModel.i().observe(this, new b0());
        videoPbViewModel.g().observe(this, new c0());
        videoPbViewModel.e().observe(this, new d0());
        videoPbViewModel.f().observe(this, new e0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i2, i3, intent);
        this.K0.H(i2, i3, intent);
        d.b.i0.c2.k.e.y0.f.a aVar = this.T;
        if (aVar != null) {
            aVar.i(i2, i3, intent);
        }
        d.b.i0.c2.k.e.s sVar = this.M0;
        if (sVar != null) {
            sVar.g(i2, i3, intent);
        }
        if (i2 == 25035) {
            f3(i3, intent);
        }
        if (i3 == -1) {
            if (i2 == 11009) {
                E3();
            } else if (i2 == 13011) {
                d.b.i0.q2.a.g().m(getPageContext());
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
                        if (M2() != null) {
                            M2().performClick();
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
                this.U = emotionImageData;
                if (z2(ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE)) {
                    Z3(emotionImageData);
                }
            }
        }
    }

    @Override // d.b.h0.b1.m.h
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.e0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.f19966e = (PbActivity) context;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.f19966e);
        getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
        getBaseFragmentActivity().getLayoutMode().j(this.f19968g);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0611);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0608);
        SkinManager.setBackgroundColor(this.f19969h, R.color.CAM_X0207);
        NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f19969h;
        if (newPagerSlidingTabBaseStrip != null) {
            newPagerSlidingTabBaseStrip.G();
        }
        d.b.i0.c2.k.e.s0 s0Var = this.C0;
        if (s0Var != null) {
            s0Var.i();
        }
        d.b.i0.c2.o.e eVar = this.p;
        if (eVar == null || !eVar.k()) {
            SkinManager.setBackgroundColor(this.f19968g, R.color.CAM_X0201);
        }
        EditorTools editorTools = this.L0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        d.b.i0.c2.k.e.s sVar = this.M0;
        if (sVar != null) {
            sVar.h(i2);
        }
        HeadImageView headImageView = this.j0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.i0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        if (L() != null && L().k0()) {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.m0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.l0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.I, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (L() != null) {
            J4(L().y0());
        }
        SkinManager.setBackgroundResource(this.k, R.drawable.personalize_tab_shadow);
        SkinManager.setBackgroundColor(this.z, R.color.CAM_X0206);
        SkinManager.setBackgroundColor(this.h0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.g0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.H, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.G, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k0, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.q0, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.p0, R.color.CAM_X0107);
        TextView textView = this.p0;
        int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18);
        int i3 = R.color.CAM_X0207;
        SkinManager.setBackgroundShapeDrawable(textView, g2, i3, i3);
        if (O2() != null) {
            O2().onChangeSkinType(i2);
        } else if (w3() && d3() != null) {
            d3().onChangeSkinType(i2);
        }
        if (P2() != null) {
            P2().onChangeSkinType(i2);
        }
        View view = this.L;
        if (view != null) {
            view.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(view.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
        }
        A4();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        d.b.i0.c2.o.k.a aVar = this.o;
        if (aVar == null || aVar.Q0()) {
            return;
        }
        if (!(this.o.D() && configuration.orientation == 1) && (this.o.D() || configuration.orientation != 2)) {
            return;
        }
        this.o.W(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f19967f = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        p3(bundle);
        getVoiceManager().onCreate(getPageContext());
        d.b.h0.r.f0.c cVar = new d.b.h0.r.f0.c();
        this.R = cVar;
        cVar.f50483a = 1000L;
        if (this.Q != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.Q.B;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.Q.B;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.x = new d.b.i0.w.a(getPageContext());
        d.b.i0.b3.c.g().i(getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f19968g = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        u3();
        return this.f19968g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.b3.c.g().k(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        d.b.i0.c2.p.d dVar = this.o0;
        if (dVar != null) {
            dVar.g();
        }
        ForumManageModel forumManageModel = this.W;
        if (forumManageModel != null) {
            forumManageModel.cancelLoadData();
        }
        d.b.i0.c2.o.k.a aVar = this.o;
        if (aVar != null) {
            aVar.R0();
        }
        d.b.i0.c2.k.e.y0.f.a aVar2 = this.T;
        if (aVar2 != null) {
            aVar2.f();
        }
        ReplyPrivacyCheckController replyPrivacyCheckController = this.z0;
        if (replyPrivacyCheckController != null) {
            replyPrivacyCheckController.onDestroy();
        }
        if (L() != null) {
            L().cancelLoadData();
            L().destory();
            if (L().u0() != null) {
                L().u0().d();
            }
        }
        d.b.h0.w.w.e eVar = this.K0;
        if (eVar != null) {
            eVar.I();
        }
        this.R = null;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!this.p1 && (this.q1 || x3())) {
            x4();
            UtilHelper.hideStatusBar(P(), P().getRootView());
            this.q1 = false;
            d.b.i0.c2.o.k.a aVar = this.o;
            if (aVar != null) {
                aVar.V0(false);
            }
        }
        if (i2 == 4) {
            return this.o.H();
        }
        if (i2 == 24) {
            return this.o.N();
        }
        if (i2 == 25) {
            return this.o.S0();
        }
        return false;
    }

    @Override // d.b.h0.b1.m.h
    public void onLinkButtonClicked(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.e0 = true;
    }

    @Override // d.b.h0.b1.m.h
    public void onLinkClicked(Context context, String str, boolean z2) {
        if (d.b.i0.c2.k.e.v0.c(str) && L() != null && L().O0() != null) {
            TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", L().O0()));
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                d.b.h0.t.l lVar = new d.b.h0.t.l();
                lVar.f51481a = str;
                lVar.f51482b = 3;
                lVar.f51483c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, lVar));
            }
        } else {
            d.b.i0.c2.k.e.v0.a().e(getPageContext(), str);
        }
        this.e0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.V0 = true;
        getVoiceManager().onPause(getPageContext());
        this.o.e0(true);
        if (L() != null && !L().m0()) {
            this.K0.U(L().O0());
        }
        d.b.h0.a.c.y().E();
        MessageManager.getInstance().unRegisterListener(this.g1);
        MessageManager.getInstance().unRegisterListener(this.h1);
        MessageManager.getInstance().unRegisterListener(this.f1);
        MessageManager.getInstance().unRegisterListener(this.E1);
    }

    @Override // d.b.h0.b1.m.h
    public void onPhoneClicked(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.Q.k0(str);
        d.b.h0.r.s.b P = this.Q.P();
        if (P == null) {
            this.Q.U();
        }
        TiebaStatic.log("pb_show_phonedialog");
        if (str2.equals("2")) {
            P.f(1).setVisibility(8);
        } else {
            P.f(1).setVisibility(0);
        }
        P.m();
        this.e0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.V0 = false;
        getVoiceManager().onResume(getPageContext());
        this.o.e0(false);
        u4();
        registerListener(this.g1);
        registerListener(this.h1);
        registerListener(this.f1);
        registerListener(this.E1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (L() != null) {
            L().E1(bundle);
        }
        if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            return;
        }
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // d.b.h0.b1.m.h
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
        d.b.i0.b3.c.g().h(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        super.onUserChanged(z2);
        B3();
    }

    @Override // d.b.h0.b1.m.h
    public void onVideoClicked(Context context, String str) {
        d.b.i0.c2.k.e.v0.a().e(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.e0 = true;
    }

    @Override // d.b.h0.b1.m.h
    public void onVideoP2PClicked(Context context, String str) {
    }

    public final void p3(Bundle bundle) {
        d.b.h0.w.w.g gVar = new d.b.h0.w.w.g();
        this.E0 = gVar;
        g4(gVar);
        d.b.h0.w.w.e eVar = (d.b.h0.w.w.e) this.E0.a(getActivity());
        this.K0 = eVar;
        eVar.e0(this.f19966e.getPageContext());
        this.K0.n0(this.j1);
        this.K0.o0(this.A1);
        this.K0.g0(1);
        this.K0.F(this.f19966e.getPageContext(), bundle);
        this.K0.a().b(new d.b.h0.w.k(getActivity()));
        this.K0.a().C(true);
        n4(true);
        this.K0.O(L().c0(), L().O0(), L().Z());
        registerListener(this.b1);
        registerListener(this.d1);
        registerListener(this.l1);
        registerListener(this.a1);
        registerListener(this.c1);
        registerListener(this.e1);
        if (!L().m0()) {
            this.K0.s(L().O0());
        }
        if (L().X0()) {
            this.K0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.K0.k0(e3());
        }
        this.C0 = new d.b.i0.c2.k.e.s0();
        if (this.K0.v() != null) {
            this.C0.m(this.K0.v().i());
        }
        this.K0.d0(this.Z0);
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
        this.z0 = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new h0());
    }

    public final void p4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                d.b.h0.s.h.b.a(getPageContext(), postWriteCallBackData);
                return;
            } else {
                d.b.i0.c3.q0.g.b(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
                return;
            }
        }
        if (L() != null && !L().m0()) {
            antiData.setBlock_forum_name(L().y0().l().getName());
            antiData.setBlock_forum_id(L().y0().l().getId());
            antiData.setUser_name(L().y0().Q().getUserName());
            antiData.setUser_id(L().y0().Q().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public final void q3() {
        this.G = (TextView) this.f19968g.findViewById(R.id.pb_video_mount_title);
        this.K = (TbImageView) this.f19968g.findViewById(R.id.pb_video_mount_pic);
        this.H = (TextView) this.f19968g.findViewById(R.id.pb_video_mount_desc);
        this.I = (ImageView) this.f19968g.findViewById(R.id.pb_video_mount_close);
        this.J = (TBSpecificationBtn) this.f19968g.findViewById(R.id.pb_video_mount_link);
        this.L = this.f19968g.findViewById(R.id.ala_live_point);
        this.K.setRadius(d.b.b.e.p.l.g(getContext(), R.dimen.tbds10));
        this.K.setConrers(15);
        this.J.setConfig(new d.b.h0.r.f0.m.c());
        this.I.setOnClickListener(new j0());
        this.J.setOnClickListener(this.F);
        this.z.setOnClickListener(this.F);
    }

    public void q4(boolean z2) {
        if (this.h0 == null) {
            return;
        }
        d4(this.K0.C());
        if (this.t0) {
            r4(z2);
        } else {
            i3(z2);
        }
        L3();
        O3();
    }

    @Override // d.b.i0.c2.o.b
    public PbModel.g r() {
        return this.X0;
    }

    public final void r2() {
        if (L() == null || L().y0() == null || L().y0().L() == null) {
            return;
        }
        a2 L = L().y0().L();
        L.T0 = L().D0();
        L.S0 = L().G0();
        L.R0 = L().F0();
        L.U0 = L().E0();
        L.z2 = L().m0();
        if (L.c0() == 0) {
            L.t3(d.b.b.e.m.b.f(L().getForumId(), 0L));
        }
        StatisticItem i2 = d.b.h0.j0.c.i(getContext(), L, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public final void r3() {
        NavigationBar navigationBar = (NavigationBar) this.f19968g.findViewById(R.id.video_pb_navigation_bar);
        this.q = navigationBar;
        navigationBar.setOnClickListener(new l0());
        this.q.hideBottomLine();
        this.q.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.q.getTopCoverBgView().setVisibility(0);
        this.r = this.f19968g.findViewById(R.id.statebar);
        View findViewById = this.f19968g.findViewById(R.id.status_bar_background);
        this.s = findViewById;
        if (this.p1) {
            ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
            layoutParams.height = d.b.b.e.p.l.r(P());
            this.r.setLayoutParams(layoutParams);
            this.r.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
            layoutParams2.height = d.b.b.e.p.l.r(P());
            this.s.setLayoutParams(layoutParams2);
            this.s.setVisibility(0);
        }
        View addSystemImageButton = this.q.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.B1);
        this.t = addSystemImageButton;
        this.u = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        View addCustomView = this.q.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.B1);
        this.v = addCustomView;
        this.w = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
        int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
        layoutParams3.rightMargin = g3;
        this.v.setLayoutParams(layoutParams3);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.w, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.v.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.s1 = new GestureDetector(getContext(), this.t1);
        this.q.setOnTouchListener(this.r1);
    }

    public void r4(boolean z2) {
        TextView textView;
        if (this.h0 == null || (textView = this.k0) == null) {
            return;
        }
        textView.setText(R.string.draft_to_send);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.h0.startAnimation(alphaAnimation);
        }
        this.g0.setVisibility(0);
        this.h0.setVisibility(0);
        this.r0.f20032a = true;
    }

    public final void s2(boolean z2) {
        if (L() == null || L().y0() == null || L().y0().L() == null) {
            return;
        }
        a2 L = L().y0().L();
        L.T0 = L().D0();
        L.S0 = L().G0();
        L.R0 = L().F0();
        L.U0 = L().E0();
        if (L.c0() == 0) {
            L.t3(d.b.b.e.m.b.f(L().getForumId(), 0L));
        }
        StatisticItem i2 = d.b.h0.j0.c.i(getContext(), L, "c13563");
        TbPageTag l2 = d.b.h0.j0.c.l(getContext());
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
            d.b.h0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(i2);
        }
    }

    public void s3() {
        EditorTools editorTools = this.L0;
        if (editorTools == null) {
            return;
        }
        editorTools.j();
        d.b.h0.w.w.e eVar = this.K0;
        if (eVar != null) {
            eVar.P();
        }
        h3();
    }

    public void s4() {
        View view = this.P;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        super.setPrimary(z2);
        VideoPbFragmentAdapter videoPbFragmentAdapter = this.j;
        if (videoPbFragmentAdapter == null || (customViewPager = this.i) == null) {
            return;
        }
        videoPbFragmentAdapter.k(z2 ? customViewPager.getCurrentItem() : -1);
    }

    @Override // d.b.i0.c2.o.a
    public void t0(boolean z2, int i2, int i3, int i4, d.b.i0.c2.h.e eVar, String str, int i5) {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t2(a2 a2Var) {
        double d2;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect S;
        int k2 = d.b.b.e.p.l.k(getContext());
        int i3 = d.b.b.e.p.l.i(getContext());
        double d3 = k2;
        Double.isNaN(d3);
        double d4 = i3;
        Double.isNaN(d4);
        double d5 = (2.0d * d3) / d4;
        if (a2Var != null && a2Var.u1() != null) {
            int intValue = a2Var.u1().video_width.intValue();
            int intValue2 = a2Var.u1().video_height.intValue();
            if (intValue2 > 0) {
                d2 = (intValue * 1.0f) / intValue2;
                if (d2 > 1.7777777777777777d) {
                    d2 = 1.7777777777777777d;
                }
                if (d2 >= d5) {
                    d5 = d2;
                }
                Double.isNaN(d3);
                int ceil = (int) Math.ceil(d3 / d5);
                int height = (L() != null || (S = L().S()) == null) ? ceil : S.height();
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
                VideoContainerLayout videoContainerLayout = this.n;
                Double.isNaN(d3);
                videoContainerLayout.setMinHeight((int) Math.ceil(d3 / 1.7777777777777777d));
                this.n.setOriginHeight(height);
                if (w3()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f19969h.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, P1);
                    } else {
                        layoutParams3.height = P1;
                    }
                    this.f19969h.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
                if (w3()) {
                    ceil += P1;
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
        if (d2 >= d5) {
        }
        Double.isNaN(d3);
        int ceil2 = (int) Math.ceil(d3 / d5);
        if (L() != null) {
        }
        i2 = 0;
        layoutParams = this.n.getLayoutParams();
        if (layoutParams != null) {
        }
        this.n.setLayoutParams(layoutParams);
        this.n.setMaxHeight(ceil2);
        VideoContainerLayout videoContainerLayout2 = this.n;
        Double.isNaN(d3);
        videoContainerLayout2.setMinHeight((int) Math.ceil(d3 / 1.7777777777777777d));
        this.n.setOriginHeight(height);
        if (w3()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.m.getLayoutParams();
        if (w3()) {
        }
        if (layoutParams2 != null) {
        }
        this.m.setLayoutParams(layoutParams2);
        if (i2 == 0) {
        }
    }

    public final void t3() {
        this.f19969h.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.f19969h.setContainerLayoutParams(layoutParams);
        this.f19969h.setRectPaintColor(R.color.CAM_X0302);
        this.f19969h.C(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.f19969h.setIndicatorOffset(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.f19969h.setIndicatorOvershot(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.f19969h.setIndicatorMarginBottom(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.f19969h.setExpandedTabLayoutParams(layoutParams2);
    }

    public final void t4(int i2) {
        d.b.i0.c2.o.j.a.c(P(), N2(), i2);
    }

    public final void u2(d.b.i0.c2.o.i.a aVar) {
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
        this.K.W(aVar.n(), 10, false);
        this.L.setVisibility(aVar.v() ? 0 : 8);
        d.b.b.e.m.e.a().postDelayed(new y0(), aVar.j().longValue() * 1000);
    }

    public final void u3() {
        d.b.i0.f0.b bVar = new d.b.i0.f0.b(getActivity());
        this.O0 = bVar;
        bVar.i(Q1);
        this.p1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        r3();
        this.m = (AppBarLayout) this.f19968g.findViewById(R.id.appbar_layout);
        this.k = this.f19968g.findViewById(R.id.pb_video_pager_shadow);
        this.n = (VideoContainerLayout) this.f19968g.findViewById(R.id.pb_video_container);
        d.b.i0.c2.o.k.a aVar = new d.b.i0.c2.o.k.a(getContext(), this.n);
        this.o = aVar;
        aVar.setStageType("2002");
        this.o.setUniqueId(getUniqueId());
        this.o.a1(this);
        this.o.Y0(P().getRootView());
        this.o.Z0(this.s);
        double k2 = d.b.b.e.p.l.k(getContext()) * 9;
        Double.isNaN(k2);
        ((RelativeLayout) this.f19968g.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil(k2 / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.f19969h = (NewPagerSlidingTabBaseStrip) this.f19968g.findViewById(R.id.pb_video_tab_strip);
        this.z = this.f19968g.findViewById(R.id.pb_video_mount_layout);
        this.i = (CustomViewPager) this.f19968g.findViewById(R.id.pb_video_view_pager);
        this.l = this.f19968g.findViewById(R.id.keyboard_background_shadow);
        this.E = (MaskView) this.f19968g.findViewById(R.id.mask_view);
        this.l.setOnClickListener(this.B1);
        t3();
        q3();
        m3();
        VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.j = videoPbFragmentAdapter;
        this.i.setAdapter(videoPbFragmentAdapter);
        this.f19969h.setViewPager(this.i);
        this.f19969h.setOnPageChangeListener(new i0());
        this.P = this.f19968g.findViewById(R.id.viewstub_progress);
        o3();
        n3();
        if (!this.p1 && this.q1) {
            x4();
            UtilHelper.hideStatusBar(P(), P().getRootView());
            this.q1 = false;
        }
        if (w3()) {
            return;
        }
        this.f19969h.getLayoutParams().height = 0;
    }

    public final void u4() {
        if (L() == null || d.b.b.e.p.k.isEmpty(L().O0())) {
            return;
        }
        d.b.h0.a.c.y().P(d.b.h0.a.b.W, d.b.b.e.m.b.f(L().O0(), 0L));
    }

    public final void v2() {
        if (L() == null || this.f19966e == null) {
            return;
        }
        d.b.h0.w.w.e eVar = this.K0;
        if (eVar == null || !eVar.z) {
            d.b.h0.w.w.d dVar = new d.b.h0.w.w.d();
            g4(dVar);
            d.b.h0.w.w.e eVar2 = (d.b.h0.w.w.e) dVar.a(getContext());
            this.K0 = eVar2;
            eVar2.e0(this.f19966e.getPageContext());
            this.K0.n0(this.j1);
            this.K0.o0(this.A1);
            this.K0.F(this.f19966e.getPageContext(), this.f19966e.getIntent() == null ? null : this.f19966e.getIntent().getExtras());
            this.K0.a().C(true);
            c4(this.K0.a());
            if (!L().m0()) {
                this.K0.s(L().O0());
            }
            if (L().X0()) {
                this.K0.k0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.K0.k0(e3());
            }
        }
    }

    public final void v3() {
        if (this.p == null) {
            this.p = new d.b.i0.c2.o.e(getBaseFragmentActivity(), this.n);
            int r2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? d.b.b.e.p.l.r(P()) : 0;
            Rect rect = new Rect(0, r2, d.b.b.e.p.l.k(getContext()), this.n.getOriginHeight() + r2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.p.r(videoPbViewModel.h(), rect);
            if (this.p.l()) {
                this.p.q(new f0(videoPbViewModel));
            } else if (w3() && (videoPbViewModel.m() || L().N0() == I1)) {
                this.i.setCurrentItem(I1);
            } else if (videoPbViewModel.m() || L().N0() == J1) {
                this.i.setCurrentItem(J1);
            }
        }
    }

    public final void v4() {
        if (this.z.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            E4();
        }
    }

    public final boolean w2() {
        PbModel L = L();
        if (L == null || L.y0() == null) {
            return false;
        }
        a2 L2 = L.y0().L();
        L.y0().d();
        return AntiHelper.b(getPageContext(), L2);
    }

    public boolean w3() {
        return L() != null && L().c1();
    }

    public final void w4() {
        ViewGroup.LayoutParams layoutParams = this.z.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.z.setAlpha(0.0f);
            this.z.setVisibility(0);
            G4(layoutParams);
        }
    }

    public final boolean x2(int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return true;
    }

    public final boolean x3() {
        d.b.i0.c2.o.k.a aVar = this.o;
        return aVar != null && aVar.P0();
    }

    public final void x4() {
        if (this.w1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
            this.w1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.w1.start();
    }

    @Override // d.b.i0.c2.o.b
    public PbFragment y0() {
        return null;
    }

    public boolean y2() {
        if ((L() != null && L().y0().Z()) || this.z0 == null || L() == null || L().y0() == null || ThreadCardUtils.isSelf(L().y0().L()) || L().y0().d() == null) {
            return true;
        }
        return this.z0.checkPrivacyBeforeInvokeEditor(L().y0().d().replyPrivateFlag);
    }

    public boolean y3() {
        return this.q1;
    }

    public final void y4() {
        if (this.v1 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
            this.v1 = ofFloat;
            ofFloat.setDuration(200L);
        }
        this.v1.start();
    }

    public boolean z2(int i2) {
        if (this.z0 == null || L() == null || L().y0() == null || ThreadCardUtils.isSelf(L().y0().L()) || L().y0().d() == null) {
            return true;
        }
        return this.z0.checkPrivacyBeforeSend(L().y0().d().replyPrivateFlag, i2);
    }

    public boolean z3() {
        d.b.i0.c2.o.k.a aVar = this.o;
        if (aVar == null) {
            return false;
        }
        return aVar.Q0();
    }

    public final void z4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        PbActivity.e n2;
        PostData Q2;
        String O0 = L().O0();
        String D = postData.D();
        String D2 = postData2 != null ? postData2.D() : "";
        int R = L().y0() != null ? L().y0().R() : 0;
        if (d3() != null && d3().b1() != null) {
            n2 = d3().b1().n(D);
        } else if (O2() == null || O2().b1() == null) {
            return;
        } else {
            n2 = O2().b1().n(D);
        }
        PbActivity.e eVar = n2;
        if (postData == null || L() == null || L().y0() == null || eVar == null) {
            return;
        }
        SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(O0, D, "pb", true, null, false, D2, R, postData.N(), L().y0().d(), false, postData.s().getIconInfo()).addBigImageData(eVar.f19506a, eVar.f19507b, eVar.f19512g, eVar.j);
        boolean z4 = true;
        if (z3) {
            addBigImageData.setHighLightPostId(D2);
            addBigImageData.setKeyIsUseSpid(true);
        }
        addBigImageData.setKeyFromForumId(L().getForumId());
        addBigImageData.setBjhData(L().T());
        addBigImageData.setKeyPageStartFrom(L().x0());
        addBigImageData.setFromFrsForumId(L().getFromForumId());
        addBigImageData.setIsOpenEditor(z2);
        if (L().y0().o() != null) {
            addBigImageData.setHasForumRule(L().y0().o().has_forum_rule.intValue());
        }
        if (L().y0().Q() != null) {
            addBigImageData.setIsManager(L().y0().Q().getIs_manager());
        }
        if (L().y0().l().getDeletedReasonInfo() != null) {
            addBigImageData.setDeletedReasonInfoIsGrayCaleForum(L().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
            addBigImageData.setDeletedReasonInfoIsIsBoomGrow(L().y0().l().getDeletedReasonInfo().is_boomgrow.intValue());
        }
        if (L().y0().l() != null) {
            addBigImageData.setForumHeadUrl(L().y0().l().getImage_url());
            addBigImageData.setUserLevel(L().y0().l().getUser_level());
        }
        if (L() != null && (Q2 = Q2(L().y0())) != null) {
            if (!Q2.S && !postData.S) {
                z4 = false;
            }
            addBigImageData.setMainPostMaskVisibly(z4);
        }
        sendMessage(new CustomMessage(2002001, addBigImageData));
    }

    /* loaded from: classes5.dex */
    public class q1 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f20032a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f20033b;

        public q1() {
            this.f20033b = true;
        }

        public boolean a() {
            return (this.f20032a && this.f20033b) ? false : true;
        }

        public /* synthetic */ q1(VideoPbFragment videoPbFragment, k kVar) {
            this();
        }
    }
}
