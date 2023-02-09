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
import android.os.Parcelable;
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
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.FoldCommentActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbLoadingViewOptimizeSwitch;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.R;
import com.baidu.tieba.a29;
import com.baidu.tieba.a85;
import com.baidu.tieba.ai8;
import com.baidu.tieba.au4;
import com.baidu.tieba.aw4;
import com.baidu.tieba.b98;
import com.baidu.tieba.br4;
import com.baidu.tieba.bt5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ce8;
import com.baidu.tieba.cr4;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.e75;
import com.baidu.tieba.ea5;
import com.baidu.tieba.ej;
import com.baidu.tieba.f95;
import com.baidu.tieba.fe8;
import com.baidu.tieba.gh;
import com.baidu.tieba.gh8;
import com.baidu.tieba.gi8;
import com.baidu.tieba.hh8;
import com.baidu.tieba.j05;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jo5;
import com.baidu.tieba.k55;
import com.baidu.tieba.kc6;
import com.baidu.tieba.kd5;
import com.baidu.tieba.kh8;
import com.baidu.tieba.kp5;
import com.baidu.tieba.l05;
import com.baidu.tieba.la8;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.m09;
import com.baidu.tieba.mb5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n65;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nq5;
import com.baidu.tieba.o45;
import com.baidu.tieba.od5;
import com.baidu.tieba.od8;
import com.baidu.tieba.oo5;
import com.baidu.tieba.op5;
import com.baidu.tieba.p35;
import com.baidu.tieba.p85;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pj5;
import com.baidu.tieba.q95;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qv4;
import com.baidu.tieba.r99;
import com.baidu.tieba.rp5;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sc8;
import com.baidu.tieba.sd5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sz4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tr8;
import com.baidu.tieba.u35;
import com.baidu.tieba.ug;
import com.baidu.tieba.uj5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.v19;
import com.baidu.tieba.v98;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vg;
import com.baidu.tieba.vh8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.w9;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wa8;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wf8;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xd8;
import com.baidu.tieba.xg8;
import com.baidu.tieba.xx4;
import com.baidu.tieba.y17;
import com.baidu.tieba.yh8;
import com.baidu.tieba.ys5;
import com.baidu.tieba.zf8;
import com.baidu.tieba.zh8;
import com.baidu.tieba.zi6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements bt5, VoiceManager.j, hh8, TbRichTextView.u, gh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int L1;
    public static final int M1;
    public static int N1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public ld5 A1;
    public View.OnClickListener B;
    public ReplyPrivacyCheckController B0;
    public final View.OnClickListener B1;
    public TextView C;
    public y17 C0;
    public View.OnClickListener C1;
    public TextView D;
    public y17 D0;
    public final AdapterView.OnItemClickListener D1;
    public ImageView E;
    public ce8 E0;
    public CustomMessageListener E1;
    public TBSpecificationBtn F;
    public PermissionJudgePolicy F0;
    public CustomMessageListener F1;
    public TbImageView G;
    public qd5 G0;
    public CustomMessageListener G1;
    public View H;
    public od5 H0;
    public final ItemCardHelper.c H1;
    public ValueAnimator I;
    public EditorTools I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public sc8 J0;
    public final View.OnLongClickListener J1;
    public FallingView K;
    public PbFakeFloorModel K0;
    public SortSwitchButton.f K1;
    public boolean L;
    public zi6 L0;
    public View M;
    public int[] M0;
    public vh8 N;
    public int N0;
    public u35 O;
    public int O0;
    public au4 P;
    public int P0;
    public p85 Q;
    public int Q0;
    public ForumManageModel R;
    public int R0;
    public VoiceManager S;
    public boolean S0;
    public ug<GifView> T;
    @NonNull
    public TiePlusEventController.f T0;
    public ug<TextView> U;
    public FrameLayout U0;
    public ug<ImageView> V;
    public RightFloatLayerView V0;
    public ug<View> W;
    public final PbModel.h W0;
    public ug<LinearLayout> X;
    public final au4.a X0;
    public ug<RelativeLayout> Y;
    public kd5 Y0;
    public boolean Z;
    public final CustomMessageListener Z0;
    public AbsPbActivity a;
    public LinearLayout a0;
    public CustomMessageListener a1;
    public long b;
    public View b0;
    public final CustomMessageListener b1;
    public RelativeLayout c;
    public View c0;
    public CustomMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public LinearLayout d0;
    public HttpMessageListener d1;
    public CustomViewPager e;
    public ImageView e0;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public TextView f0;
    public CustomMessageListener f1;
    public View g;
    public ImageView g0;
    public CustomMessageListener g1;
    public View h;
    public ImageView h0;
    public kd5 h1;
    public AppBarLayout i;
    public ImageView i0;
    public final NewWriteModel.d i1;
    public VideoContainerLayout j;
    public gi8 j0;
    public View.OnClickListener j1;
    public ai8 k;
    public CustomMessageListener k1;
    public kh8 l;
    public int l1;
    public NavigationBar m;
    public float m1;
    public View n;
    public float n1;
    public View o;
    public boolean o1;
    public View p;
    public boolean p1;
    public ImageView q;
    public View.OnTouchListener q1;
    public View r;
    public TextView r0;
    public GestureDetector r1;
    public ImageView s;
    public TextView s0;
    public GestureDetector.SimpleOnGestureListener s1;
    public kc6 t;
    public d2 t0;
    public Runnable t1;
    public boolean u;
    public String u0;
    public ObjectAnimator u1;
    public View v;
    public boolean v0;
    public ObjectAnimator v1;
    public yh8 w;
    public String w0;
    public final w9 w1;
    public View x;
    public boolean x0;
    public View.OnTouchListener x1;
    public View y;
    public boolean y0;
    public final zi6.b y1;
    public View z;
    public boolean z0;
    public NewWriteModel.d z1;

    @Override // com.baidu.tieba.bt5
    public ug<TiebaPlusRecommendCard> B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract boolean G4();

    public abstract boolean I4();

    @Override // com.baidu.tieba.hh8
    public AbsVideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<FestivalTipView> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void V(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048652, this, context, str) == null) {
        }
    }

    public abstract int W3();

    public abstract int Y3();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i c1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public void e1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048683, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.bt5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public final int h4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048693, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 1 : 7;
                }
                return 6;
            }
            return 5;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<ItemCardView> l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gh8
    public void r1(boolean z2, int i2, int i3, int i4, v98 v98Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048730, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), v98Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    public abstract void u5(boolean z2);

    @Override // com.baidu.tieba.hh8
    public PbFragment v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class j1 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$j1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0388a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                    }
                }

                public C0388a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    ce8 ce8Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ce8Var = this.a.a.c.E0) != null && ce8Var.g() != null) {
                        if (!this.a.a.c.E0.g().e()) {
                            this.a.a.c.E0.b(false);
                        }
                        this.a.a.c.E0.g().l(false);
                    }
                }
            }

            public a(j1 j1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {j1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = j1Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                int g;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int j = ej.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = ej.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = j / 2;
                        g = ej.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i2 = j - (i + g);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i3 = (absVideoPbFragment.M0[1] + absVideoPbFragment.N0) - i2;
                    if (absVideoPbFragment.j4() != null) {
                        this.a.c.j4().smoothScrollBy(0, i3);
                    }
                    if (this.a.c.J0 != null) {
                        this.a.c.H0.b().setVisibility(8);
                        z = (this.a.c.M() == null || this.a.c.M().l1() == null || this.a.c.M().l1().Q() == null || !this.a.c.M().l1().Q().isBjh()) ? false : false;
                        sc8 sc8Var = this.a.c.J0;
                        j1 j1Var = this.a;
                        sc8Var.t(j1Var.a, j1Var.b, j1Var.c.l4(), z);
                        this.a.c.J0.q(this.a.c.W3());
                        sd5 f = this.a.c.J0.f();
                        if (f != null && this.a.c.M() != null && this.a.c.M().l1() != null) {
                            f.H(this.a.c.M().l1().d());
                            f.d0(this.a.c.M().l1().Q());
                        }
                        if (this.a.c.E0.f() == null && this.a.c.J0.f().u() != null) {
                            this.a.c.J0.f().u().g(new C0388a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.E0.n(absVideoPbFragment2.J0.f().u().i());
                            this.a.c.J0.f().N(this.a.c.h1);
                        }
                    }
                    this.a.c.o4();
                }
            }
        }

        public j1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.y17.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            gh.a().postDelayed(new a(this), 0L);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ h b;

            public a(h hVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = hVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.X4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public c(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public h(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        statisticItem.param("fid", this.a.M().l1().m());
                    }
                    statisticItem.param("tid", this.a.M().F1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.S5();
                this.a.w5(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.M().t0(postWriteCallBackData.getPostId());
                        if (this.a.J4() && this.a.k4() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.Q0 = absVideoPbFragment.k4().S1();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.R0 = absVideoPbFragment2.k4().T1();
                            this.a.M().N2(this.a.Q0, this.a.R0);
                        } else if (this.a.T3() != null) {
                            AbsVideoPbFragment absVideoPbFragment3 = this.a;
                            absVideoPbFragment3.Q0 = absVideoPbFragment3.T3().U1();
                            AbsVideoPbFragment absVideoPbFragment4 = this.a;
                            absVideoPbFragment4.R0 = absVideoPbFragment4.T3().V1();
                            this.a.M().N2(this.a.Q0, this.a.R0);
                        }
                    }
                    if (this.a.e != null) {
                        if (this.a.J4()) {
                            this.a.e.setCurrentItem(1);
                        } else {
                            this.a.e.setCurrentItem(0);
                        }
                    }
                    this.a.N.G();
                    this.a.E0.c();
                    if (this.a.H0 != null) {
                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                        absVideoPbFragment5.r5(absVideoPbFragment5.H0.y());
                    }
                    this.a.q4();
                    this.a.F5(true);
                    this.a.M().Q1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.E5(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (this.a.J4() && this.a.k4() != null) {
                                this.a.k4().b2();
                            } else if (this.a.T3() != null) {
                                this.a.T3().f2();
                            }
                        }
                    } else if (this.a.M().O0()) {
                        v98 l1 = this.a.M().l1();
                        if (l1 != null && l1.Q() != null && l1.Q().getAuthor() != null && (userId = l1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.M().f3()) {
                            this.a.y5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.M().f3()) {
                        this.a.y5();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    absVideoPbFragment6.u3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.H0.x() || this.a.H0.z()) {
                        this.a.H0.w(false, postWriteCallBackData);
                    }
                    this.a.E0.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.B0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (a85Var != null || i == 227001) {
                } else {
                    this.a.D5(i, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i1 a;

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                }
            }

            public a(i1 i1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {i1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = i1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ce8 ce8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ce8Var = this.a.c.E0) != null && ce8Var.g() != null) {
                    if (!this.a.c.E0.g().e()) {
                        this.a.c.E0.b(false);
                    }
                    this.a.c.E0.g().l(false);
                }
            }
        }

        public i1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int j = ej.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = ej.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.M0[1] + absVideoPbFragment.N0) - i2;
                if (absVideoPbFragment.j4() != null) {
                    this.c.j4().smoothScrollBy(0, i3);
                }
                if (this.c.J0 != null) {
                    this.c.H0.b().setVisibility(8);
                    this.c.J0.t(this.a, this.b, this.c.l4(), (this.c.M() == null || this.c.M().l1() == null || this.c.M().l1().Q() == null || !this.c.M().l1().Q().isBjh()) ? false : false);
                    this.c.J0.q(this.c.W3());
                    sd5 f = this.c.J0.f();
                    if (f != null && this.c.M() != null && this.c.M().l1() != null) {
                        f.H(this.c.M().l1().d());
                        f.d0(this.c.M().l1().Q());
                    }
                    if (this.c.E0.f() == null && this.c.J0.f().u() != null) {
                        this.c.J0.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.E0.n(absVideoPbFragment2.J0.f().u().i());
                        this.c.J0.f().N(this.c.h1);
                    }
                }
                this.c.o4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostWriteCallBackData a;
            public final /* synthetic */ s b;

            public a(s sVar, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = sVar;
                this.a = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                PostWriteCallBackData postWriteCallBackData;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (postWriteCallBackData = this.a) != null) {
                    this.b.a.X4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements j05.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public c(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // com.baidu.tieba.j05.e
            public void onClick(j05 j05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                    j05Var.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public s(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, a85 a85Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, a85Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        statisticItem.param("fid", this.a.M().l1().m());
                    }
                    if (this.a.M() != null) {
                        statisticItem.param("tid", this.a.M().F1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    k55.b(writeData.getContent(), "4");
                }
                if (z) {
                    ce8 ce8Var = this.a.E0;
                    if (ce8Var != null) {
                        ce8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        q95.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.B0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    j05 j05Var = new j05(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        j05Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        j05Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new b(this));
                    j05Var.setPositiveButton(R.string.open_now, new c(this));
                    j05Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.E0 != null) {
                        if (absVideoPbFragment.J0 != null && this.a.J0.f() != null && this.a.J0.f().y()) {
                            this.a.J0.f().w(postWriteCallBackData);
                        }
                        this.a.E0.l(postWriteCallBackData);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.S0) {
                return;
            }
            this.a.L5();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements oo5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public a0(AbsVideoPbFragment absVideoPbFragment, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oo5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.l(bundle);
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.c.getContext(), this.b, shareItem, false));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a1 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public a1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.N.q0(true);
                return this.a.N.Q().onLongClick(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a2 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public a2(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String l4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.M() != null && this.a.M().W1()) {
                    l4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    l4 = this.a.l4();
                }
                if (!StringUtils.isNull(l4) && this.a.M() != null && this.a.M().l1() != null) {
                    l4 = TbSingleton.getInstance().getAdVertiComment(this.a.M().l1().r0(), this.a.M().l1().s0(), l4);
                }
                if (this.a.H0 != null) {
                    this.a.H0.c0(l4);
                }
                if (this.a.f0 != null) {
                    this.a.f0.setText(l4);
                }
                this.a.F5(false);
                this.a.J5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof CustomResponsedMessage) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            this.a.a6();
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public b0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
            } else {
                z3 = false;
            }
            vh8 vh8Var = this.a.N;
            if (vh8Var != null) {
                if (z) {
                    if (z2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.a.N.C(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.N.m0(view2);
                } else if (z2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.a.N.C(sparseArray);
                } else if (z3) {
                    vh8Var.h0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                if (i == 2) {
                    return 1;
                }
                if (i == 0) {
                    return 2;
                }
                return i == 1 ? 3 : 0;
            }
            return invokeI.intValue;
        }

        public b1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.view.SortSwitchButton.f
        public boolean a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                vh8 vh8Var = this.a.N;
                if (vh8Var != null) {
                    vh8Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.M() != null && !this.a.M().isLoading) {
                    this.a.S5();
                    this.a.y5();
                    z = true;
                    if (this.a.M().l1() != null && this.a.M().l1().f != null && this.a.M().l1().f.size() > i) {
                        int intValue = this.a.M().l1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.M().G1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.M().i3(intValue)) {
                            this.a.L = true;
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b2(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.M() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.H0 != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.r5(absVideoPbFragment.H0.y());
                }
                this.a.i5();
                this.a.N.G();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsVideoPbFragment absVideoPbFragment, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.getView() != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.hideLoadingView(absVideoPbFragment.getView());
                    this.a.hideProgressBar();
                }
                if (httpResponsedMessage == null || !(httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    return;
                }
                PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                if (!TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                    return;
                }
                int type = privacySettingMessage.getType();
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                    bdTopToast.h(true);
                    bdTopToast.g(this.a.getString(R.string.block_user_success));
                    bdTopToast.i((ViewGroup) this.a.getView());
                    this.a.z5(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d08);
                } else {
                    errorString = httpResponsedMessage.getErrorString();
                }
                BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                bdTopToast2.h(false);
                bdTopToast2.g(errorString);
                bdTopToast2.i((ViewGroup) this.a.getView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public c0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.M() != null && this.a.M().u1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.m5(absVideoPbFragment.h4(i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(v98 v98Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v98Var) == null) {
            }
        }

        public c1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, v98 v98Var, String str, int i4) {
            String l4;
            sb5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), v98Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090718));
                }
                this.a.x5();
                this.a.s4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.F5(false);
                if (z && v98Var != null) {
                    ThreadData Q = v98Var.Q();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(v98Var, i2);
                    this.a.Z4(v98Var);
                    this.a.H5(v98Var);
                    this.a.f5(v98Var);
                    this.a.c5(z, i, i2, i3, v98Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(v98Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(v98Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(v98Var.X().getBimg_end_time());
                    if (v98Var.H() != null && v98Var.H().size() >= 1 && v98Var.H().get(0) != null) {
                        this.a.M().O2(v98Var.H().get(0).O());
                    } else if (v98Var.a0() != null) {
                        this.a.M().O2(v98Var.a0().O());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(v98Var.r());
                    }
                    AntiData d = v98Var.d();
                    if (d != null) {
                        this.a.w0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.w0) && this.a.H0 != null && this.a.H0.b() != null && (o = this.a.H0.b().o(6)) != null && !TextUtils.isEmpty(this.a.w0)) {
                            ((View) o).setOnClickListener(this.a.j1);
                        }
                    }
                    if (this.a.B0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.B0.setLikeUserData(attentionHostData);
                    }
                    this.a.C4(v98Var);
                    if (this.a.M() != null && this.a.M().W1()) {
                        l4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        l4 = this.a.l4();
                    }
                    if (!StringUtils.isNull(l4)) {
                        this.a.H0.c0(TbSingleton.getInstance().getAdVertiComment(v98Var.r0(), v98Var.s0(), l4));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.M().F1());
                            jSONObject.put("fid", this.a.M().getForumId());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016553, jSONObject));
                    }
                    if (i != 0) {
                        EnterForePvThread enterForePvThread = new EnterForePvThread();
                        enterForePvThread.setOpType("2");
                        enterForePvThread.start();
                    }
                    if ((this.a.J4() && this.a.k4() == null) || this.a.T3() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.J4()) {
                        if (i != -1) {
                            if (this.a.M() != null && this.a.M().l1() != null) {
                                arrayList = this.a.M().l1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                                this.a.k4().i2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.k4().c2()) {
                                this.a.k4().j2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eaf));
                            } else {
                                this.a.k4().j2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eb0));
                            }
                        } else {
                            this.a.k4().i2("");
                        }
                        this.a.k4().P1();
                    } else {
                        if (i != -1) {
                            if (this.a.M() != null && this.a.M().l1() != null) {
                                arrayList = this.a.M().l1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).F() != 1)) {
                                this.a.T3().q2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.T3().h2()) {
                                this.a.T3().r2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eaf));
                            } else {
                                this.a.T3().r2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eb0));
                            }
                        } else {
                            this.a.T3().q2("");
                        }
                        this.a.T3().R1();
                    }
                }
                m09.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c2(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                b98 b98Var = (b98) customResponsedMessage.getData();
                int type = b98Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (b98Var.a() == null) {
                                this.a.e5(false, null);
                                return;
                            } else {
                                this.a.e5(true, (MarkData) b98Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.M3((ForumManageModel.b) b98Var.a(), false);
                    return;
                }
                this.a.g5((la8) b98Var.a());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof r99) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                r99 r99Var = (r99) customResponsedMessage.getData();
                this.a.N.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.P();
                DataRes dataRes = r99Var.a;
                boolean z = false;
                if (r99Var.c == 0 && dataRes != null) {
                    int e = dh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (dj.isEmpty(str)) {
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
                    this.a.N.G0(z, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.N.l0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ys5.a)) {
                ys5.a aVar = (ys5.a) customResponsedMessage.getData();
                ys5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements y17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // com.baidu.tieba.y17.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.y17.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }

        public d1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.y17.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.H0 != null && this.a.H0.b() != null) {
                    this.a.H0.b().C(new lb5(45, 27, null));
                }
                this.a.D3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public d2(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.b = true;
        }

        public /* synthetic */ d2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a && this.b) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                vh8 vh8Var = this.a.N;
                if (tag == vh8Var.D) {
                    vh8Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    v98 l1 = this.a.M().l1();
                    if (l1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        l1.w().add(muteUser);
                    }
                    if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                        this.a.O.d(this.a.getResources().getString(R.string.mute_success));
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                        String errorString = userMuteAddResponseMessage.getErrorString();
                        if (TextUtils.isEmpty(errorString)) {
                            errorString = this.a.getResources().getString(R.string.mute_error_beyond_limit);
                        }
                        this.a.N.M0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.N.F0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (dj.isEmpty(errorString2)) {
                            errorString2 = this.a.getResources().getString(R.string.mute_fail);
                        }
                        this.a.O.c(errorString2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a29 a29Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof a29) && (a29Var = (a29) customResponsedMessage.getData()) != null && (agreeData = a29Var.b) != null && agreeData.agreeType == 2 && this.a.j0 != null && this.a.M() != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !wf8.k(this.a.M().F1())) {
                this.a.j0.o(2);
                wf8.b(this.a.M().F1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public e1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
                vh8 vh8Var = this.a.N;
                if (tag == vh8Var.D) {
                    vh8Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.O.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (dj.isEmpty(muteMessage)) {
                        muteMessage = this.a.getResources().getString(R.string.un_mute_fail);
                    }
                    this.a.O.c(muteMessage);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public f0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            ai8 ai8Var;
            BdTypeRecyclerView j4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null && (ai8Var = this.a.k) != null) {
                if (ai8Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                    this.a.k.setData(threadData);
                    return;
                }
                boolean z = true;
                if (!dj.isEmpty(this.a.k.c0())) {
                    this.a.A0 = true;
                    if (this.a.J4()) {
                        this.a.e.setCurrentItem(0);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                    if (!this.a.J4() && (j4 = this.a.j4()) != null) {
                        j4.scrollToPosition(0);
                    }
                }
                if (this.a.l == null || !this.a.l.k()) {
                    this.a.j5();
                    this.a.v3(threadData);
                }
                this.a.F4();
                if (this.a.l != null && this.a.l.l()) {
                    this.a.l.s();
                }
                boolean z2 = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
                this.a.k.setData(threadData);
                if (this.a.J4()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    ai8 ai8Var2 = absVideoPbFragment.k;
                    if (absVideoPbFragment.e.getCurrentItem() != 0) {
                        z = false;
                    }
                    ai8Var2.R0(z);
                } else {
                    this.a.k.R0(false);
                }
                if (z2) {
                    this.a.k.startPlay();
                    this.a.k.u0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public f1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public g(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ce8 ce8Var = this.a.E0;
                if (ce8Var != null && ce8Var.g() != null && this.a.E0.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.E0.g().c());
                    if (this.a.J0 != null && this.a.J0.f() != null && this.a.J0.f().y()) {
                        this.a.J0.f().w(this.a.E0.h());
                    }
                    this.a.E0.b(true);
                    return true;
                } else if (!this.a.C3(ReplyPrivacyCheckController.TYPE_FLOOR)) {
                    return true;
                } else {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v98 a;
        public final /* synthetic */ n65 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, v98 v98Var, n65 n65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, v98Var, n65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = v98Var;
            this.b = n65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b != null && this.c.V0 != null) {
                this.c.V0.g(this.b);
                this.c.V0.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements mb5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public g1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.mb5
        public void A(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) {
                Object obj = lb5Var.c;
                if ((obj instanceof e75) && EmotionGroupType.isSendAsPic(((e75) obj).getType())) {
                    if (this.a.F0 == null) {
                        this.a.F0 = new PermissionJudgePolicy();
                    }
                    this.a.F0.clearRequestPermissionList();
                    this.a.F0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.H0.f((e75) lb5Var.c);
                    this.a.H0.w(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements Observer<Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public h0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, num) == null) {
                this.a.e.setCurrentItem(num.intValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public h1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ce8 ce8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (ce8Var = this.a.E0) != null && ce8Var.e() != null) {
                if (!this.a.E0.e().e()) {
                    this.a.E0.a(false);
                }
                this.a.E0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.I0 == null || this.a.I0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.w0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public i0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            ai8 ai8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (ai8Var = this.a.k) != null) {
                ai8Var.U0(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.H0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.r5(absVideoPbFragment.H0.y());
            }
            this.a.F5(false);
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Observer<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable ThreadData threadData) {
            ai8 ai8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (ai8Var = this.a.k) != null) {
                ai8Var.T0(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.w != null && !this.a.w.m()) {
                    TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.k()).param("obj_type", 2).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M().l1().S()));
                    String h = this.a.w.h();
                    if (TextUtils.isEmpty(h)) {
                        return;
                    }
                    if (!URLUtil.isHttpUrl(h) && !URLUtil.isHttpsUrl(h)) {
                        Uri parse = Uri.parse(h);
                        if (parse != null) {
                            UtilHelper.dealOneScheme(this.a.getActivity(), parse.toString());
                            return;
                        }
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{h});
                } else if (this.a.w != null) {
                    if (this.a.w.h) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.N4(absVideoPbFragment.w.j, this.a.w.i);
                    } else if (this.a.w.m != null) {
                        YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                    }
                    if (this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().l() != null) {
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.M().l1().l().getId()).param("fname", this.a.M().l1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M().l1().S()).param("obj_param1", this.a.w.k);
                        if (this.a.M().l1().Q() != null) {
                            ThreadData Q = this.a.M().l1().Q();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(Q.getThreadAlaInfo());
                            AlaInfoData threadAlaInfo = Q.getThreadAlaInfo();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (threadAlaInfo != null && Q.getThreadAlaInfo().isLegalYYLiveData()) {
                                TiebaStaticHelper.addYYParam(param, Q.getThreadAlaInfo().mYyExtData);
                            } else if (this.a.w.m != null) {
                                TiebaStaticHelper.addYYParam(param, this.a.w.m);
                                calculateLiveType = YYLiveUtil.calculateLiveType(this.a.w.m);
                            } else {
                                str = "";
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, bool) != null) {
                return;
            }
            this.a.b5();
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public k1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.w != null && !this.a.w.m()) {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.k()).param("obj_type", 2).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M().l1().S()));
                } else if (this.a.w != null && this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().l() != null) {
                    TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.M().l1().l().getId()).param("fname", this.a.M().l1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.M().l1().S()).param("obj_param1", this.a.w.k));
                }
                this.a.N5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                    if (this.a.r1 == null || !this.a.r1.onTouchEvent(motionEvent)) {
                        return false;
                    }
                    return true;
                }
                if (this.a.l1 == 1) {
                    if (!this.a.p1) {
                        this.a.P5();
                        UtilHelper.showStatusBar(this.a.N(), this.a.N().getRootView());
                        this.a.p1 = true;
                        gh.a().removeCallbacks(this.a.t1);
                        gh.a().postDelayed(this.a.t1, 3000L);
                    }
                } else if (this.a.l1 == 2 && (this.a.p1 || this.a.K4())) {
                    this.a.O5();
                    UtilHelper.hideStatusBar(this.a.N(), this.a.N().getRootView());
                    this.a.p1 = false;
                    ai8 ai8Var = this.a.k;
                    if (ai8Var != null) {
                        ai8Var.S0(false);
                    }
                }
                this.a.l1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.u5(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public l1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public m(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.l1 = 0;
            this.a.m1 = 0.0f;
            this.a.n1 = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            ai8 ai8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.m1 += f;
                this.a.n1 += f2;
                if (this.a.l1 == 0 && !this.a.o1 && (ai8Var = this.a.k) != null && !ai8Var.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.n1) <= Math.abs(this.a.m1) || this.a.n1 > (-height) / 5) {
                        if (Math.abs(this.a.n1) > Math.abs(this.a.m1) && this.a.n1 > 0.0f && f2 > 0.0f) {
                            this.a.l1 = 2;
                        }
                    } else {
                        this.a.l1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbViewModel a;
        public final /* synthetic */ AbsVideoPbFragment b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public m0(AbsVideoPbFragment absVideoPbFragment, VideoPbViewModel videoPbViewModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, videoPbViewModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = videoPbViewModel;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.b.J4() && (this.a.n() || this.b.M().E1() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.M().E1() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.J4() && (this.a.n() || this.b.M().E1() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.M().E1() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ AbsVideoPbFragment b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public m1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = layoutParams;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.b.Z5(this.a);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.p1 || this.a.K4()) {
                return;
            }
            this.a.O5();
            UtilHelper.hideStatusBar(this.a.N(), this.a.N().getRootView());
            this.a.p1 = false;
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                if (i == ReplyPrivacyCheckController.TYPE_THREAD) {
                    this.a.H0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.J0 != null && this.a.J0.f() != null) {
                    this.a.J0.f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements au4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public n1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.au4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.x5();
                if (z && this.a.M() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.M().e3(z2);
                    if (this.a.M().l1() != null && (Q = this.a.M().l1().Q()) != null) {
                        if (z2) {
                            Q.collectNum++;
                        } else {
                            int i = Q.collectNum;
                            if (i > 0) {
                                Q.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.M().W0()) {
                        if (this.a.J4()) {
                            if (this.a.U3() != null) {
                                this.a.U3().N1();
                            }
                            if (this.a.k4() != null) {
                                this.a.k4().b2();
                            }
                        } else if (this.a.T3() != null) {
                            this.a.T3().f2();
                        }
                    } else {
                        this.a.Q4();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() != null && this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                                MarkData f = this.a.P.f();
                                MetaData author = this.a.M().l1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                        this.a.N.C0(author);
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d5);
                                    }
                                } else {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.t3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o extends w9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public o(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.w9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.M() != null) {
                    switch (this.a.R.getLoadDataMode()) {
                        case 0:
                            this.a.M().Q1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.M3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.N3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.O3(absVideoPbFragment.R.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.N3(absVideoPbFragment2.R.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.g0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.N3(absVideoPbFragment3.R.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof View)) {
                return;
            }
            ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.c);
        }
    }

    /* loaded from: classes5.dex */
    public class o1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public o1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absVideoPbFragment;
            this.a = layoutParams;
            this.b = layoutParams2;
            this.c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.L1);
                this.a.height = floatValue;
                this.b.height = (this.c - AbsVideoPbFragment.L1) + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public p(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.L0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements ItemCardHelper.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public p0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.y(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public p1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.v.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements zi6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public q(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.zi6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    wa8.d();
                } else {
                    wa8.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) {
            }
        }

        public q0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                boolean z = true;
                if (i == 0) {
                    if (this.a.T3() != null) {
                        this.a.T3().k2(false);
                    } else if (this.a.J4() && this.a.k4() != null) {
                        this.a.k4().e2(false);
                    }
                    if (this.a.U3() != null) {
                        this.a.U3().S1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        if (absVideoPbFragment.U3().K1() == 0) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        absVideoPbFragment.A5(i2);
                        this.a.a0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    ai8 ai8Var = this.a.k;
                    if (ai8Var != null) {
                        ai8Var.R0(z);
                    }
                    this.a.i5();
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()));
                    }
                } else {
                    if (this.a.U3() != null) {
                        this.a.U3().S1(false);
                    }
                    if (this.a.T3() != null) {
                        this.a.T3().k2(true);
                        int a2 = this.a.T3().a2();
                        int Y1 = this.a.T3().Y1();
                        if (a2 != 0) {
                            this.a.A5(8);
                            this.a.T3().u2(0);
                        } else if (Y1 != 0) {
                            this.a.T3().u2(8);
                            this.a.A5(0);
                        } else {
                            this.a.T3().u2(8);
                            this.a.A5(8);
                        }
                    } else if (this.a.k4() != null) {
                        this.a.k4().e2(true);
                        int Y12 = this.a.k4().Y1();
                        int W1 = this.a.k4().W1();
                        if (Y12 != 0) {
                            this.a.A5(8);
                            this.a.k4().m2(0);
                        } else if (W1 != 0) {
                            this.a.k4().m2(8);
                            this.a.A5(0);
                        } else {
                            this.a.k4().m2(8);
                            this.a.A5(8);
                        }
                        this.a.a0.setVisibility(0);
                    }
                    ai8 ai8Var2 = this.a.k;
                    if (ai8Var2 != null) {
                        ai8Var2.R0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()));
                    }
                }
                this.a.f.d(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public q1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, layoutParams, layoutParams2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absVideoPbFragment;
            this.a = layoutParams;
            this.b = layoutParams2;
            this.c = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.L1);
                this.a.height = floatValue;
                this.b.height = this.c + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public r(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) && j05Var != null) {
                j05Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n65 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, n65 n65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, n65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = n65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.V0.setHomePbFloatLastCloseTime();
                this.b.t4();
                this.b.V0.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public r1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.X5();
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public s0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.J5();
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K.setTag(Boolean.FALSE);
                if (this.a.V0 == null) {
                    return;
                }
                this.a.V0.setAutoCompleteShown(false);
                if (this.a.V0.getVisibility() == 0) {
                    this.a.V0.setTag(this.a.K);
                    this.a.V0.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public s1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ j05 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absVideoPbFragment;
            this.a = markData;
            this.b = markData2;
            this.c = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
                if (this.d.P != null) {
                    if (this.d.P.e()) {
                        this.d.P.d();
                        this.d.P.h(false);
                    }
                    this.d.P.i(this.a);
                    this.d.P.h(true);
                    this.d.P.a();
                }
                this.b.setPostId(this.a.getPostId());
                Intent intent = new Intent();
                intent.putExtra("mark", this.b);
                this.d.a.setResult(-1, intent);
                this.c.dismiss();
                this.d.T5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public t0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.w != null && !this.a.w.m()) {
                    TiebaStatic.log(new StatisticItem("c13591"));
                } else if (this.a.w != null) {
                    TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.M().l1().S()));
                    this.a.w.l = true;
                }
                this.a.M5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements vg<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public t1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                }
            }
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (aw4.c().g()) {
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
            return (ImageView) invokeL.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.O();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.F();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = aw4.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class u implements j05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ j05 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, j05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absVideoPbFragment;
            this.a = markData;
            this.b = j05Var;
        }

        @Override // com.baidu.tieba.j05.e
        public void onClick(j05 j05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, j05Var) == null) {
                j05Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.T5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.B0 != null && absVideoPbFragment.M() != null && this.a.M().l1() != null && this.a.M().l1().d() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.B0.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.M().l1().d().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.H0.n0();
                this.a.J3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements vg<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public u1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.b0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.e0();
                gifView.b0();
                gifView.setImageDrawable(null);
                gifView.f0();
                gifView.setBackgroundDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (aw4.c().g()) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = aw4.c().g();
                gifView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g) {
                    gifView.setAdjustViewBounds(false);
                    gifView.setInterceptOnClick(false);
                } else {
                    gifView.setDefaultResource(R.drawable.icon_click);
                    gifView.setAdjustViewBounds(true);
                    gifView.setInterceptOnClick(true);
                }
                return gifView;
            }
            return (GifView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public v(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Z = true;
        }
    }

    /* loaded from: classes5.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public v0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                return;
            }
            this.a.L3(false);
            this.a.a5();
            if (this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.M().G1()).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (this.a.G4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.M().getForumId());
                    statisticItem.param("tid", this.a.M().F1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.X3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.W3());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements vg<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public v1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ View c(View view2) {
            View view3 = view2;
            h(view3);
            return view3;
        }

        public View e(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).o();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        public View h(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
                ((PlayVoiceBntNew) view2).n();
                return view2;
            }
            return (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.u0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class w implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public w(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                dialogInterface.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(AbsVideoPbFragment absVideoPbFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean)) {
                ViewGroup.LayoutParams layoutParams = this.a.a0.getLayoutParams();
                layoutParams.height = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.a0.setLayoutParams(layoutParams);
                if (this.a.J4() && this.a.d != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.M1);
                    } else {
                        layoutParams2.height = AbsVideoPbFragment.M1;
                    }
                    this.a.d.setLayoutParams(layoutParams2);
                    this.a.e.setScrollable(true);
                }
                this.a.i5();
                if (this.a.U3() != null) {
                    this.a.U3().N1();
                }
                if (this.a.T3() != null) {
                    this.a.T3().f2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements vg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        public w1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.pb_text_voice_layout);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements ld5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.ld5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public x0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements vg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        public x1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.vg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new RelativeLayout(this.a.getPageContext().getPageActivity());
            }
            return (RelativeLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str2;
            int i2;
            String jumpUrlWithTid;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09194e) {
                    if (this.a.M() != null) {
                        this.a.M().n2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.M().F1());
                    statisticItem2.param("fid", this.a.M().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.G4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.M().getForumId());
                        statisticItem3.param("tid", this.a.M().F1());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.X3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.W3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (!this.a.Z) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof PostData) {
                                PostData postData = (PostData) obj;
                                if (this.a.M() == null || this.a.M().l1() == null || this.a.K0 == null || postData.r() == null || postData.F() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.J0 != null) {
                                    this.a.J0.g();
                                }
                                la8 la8Var = new la8();
                                la8Var.A(this.a.M().l1().l());
                                la8Var.E(this.a.M().l1().Q());
                                la8Var.C(postData);
                                this.a.K0.c0(la8Var);
                                this.a.K0.setPostId(postData.O());
                                this.a.P4(view2, postData.r().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                xg8.b(this.a.M().l1(), postData, postData.d0, 8, 1);
                                if (this.a.H0 != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.r5(absVideoPbFragment.H0.y());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.a.Z = false;
                } else {
                    if (view2.getId() != R.id.pb_video_more || this.a.getPageContext().getPageActivity() == null || this.a.M() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().F1(), false, true);
                            this.a.q5(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().F1(), true, false);
                            this.a.q5(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.M().getForumId());
                        statisticItem4.param("fname", this.a.M().K0());
                        statisticItem4.param("tid", this.a.M().F1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((!this.a.J4() || this.a.k4() == null || this.a.k4().X1() == null || view2 != this.a.k4().X1()) && ((this.a.T3() == null || this.a.T3().Z1() == null || view2 != this.a.T3().Z1()) && view2.getId() != R.id.pb_more)) {
                        vh8 vh8Var = this.a.N;
                        if (vh8Var != null && vh8Var.R() != null && view2 == this.a.N.R().m()) {
                            this.a.N.J();
                            return;
                        }
                        vh8 vh8Var2 = this.a.N;
                        if ((vh8Var2 == null || ((vh8Var2.R() == null || view2 != this.a.N.R().q()) && view2.getId() != R.id.obfuscated_res_0x7f09188c && view2.getId() != R.id.obfuscated_res_0x7f090272)) && view2.getId() != R.id.obfuscated_res_0x7f090aa3 && view2.getId() != R.id.obfuscated_res_0x7f091d1c) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            if (view2 == absVideoPbFragment2.p) {
                                if (absVideoPbFragment2.M() == null || this.a.M().l1() == null) {
                                    return;
                                }
                                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    StatisticItem statisticItem5 = new StatisticItem("c13266");
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem5.param("fid", this.a.M().l1().m());
                                    statisticItem5.param("tid", this.a.M().F1());
                                    statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(statisticItem5);
                                    TbadkCoreApplication.getInst().setTaskId("");
                                }
                                ej.z(this.a.a, this.a.p);
                                this.a.a.finish();
                            } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                                if (jo5.a()) {
                                    return;
                                }
                                if (this.a.M() != null && this.a.M().l1() != null) {
                                    ArrayList<PostData> H = this.a.M().l1().H();
                                    if ((H == null || H.size() <= 0) && this.a.M().D1()) {
                                        ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                                        return;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.M().F1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.M().getForumId()));
                                    this.a.N.n0();
                                    return;
                                }
                                ej.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                            } else if (this.a.N.R() != null && view2 == this.a.N.R().s()) {
                                if (this.a.M() == null) {
                                    return;
                                }
                                this.a.N.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.S5();
                                this.a.y5();
                                this.a.M().c3(1);
                            } else {
                                vh8 vh8Var3 = this.a.N;
                                if (vh8Var3 != null && vh8Var3.R() != null && view2 == this.a.N.R().q()) {
                                    this.a.N.J();
                                    return;
                                }
                                vh8 vh8Var4 = this.a.N;
                                if (vh8Var4 != null && ((vh8Var4.R() != null && view2 == this.a.N.R().y()) || view2.getId() == R.id.obfuscated_res_0x7f09198d || view2.getId() == R.id.obfuscated_res_0x7f09198b)) {
                                    this.a.N.G();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.L) {
                                        view2.setTag(Integer.valueOf(this.a.M().B1()));
                                        return;
                                    } else {
                                        this.a.S5();
                                        this.a.y5();
                                        this.a.N.L0(view2);
                                        return;
                                    }
                                }
                                vh8 vh8Var5 = this.a.N;
                                if (vh8Var5 != null && vh8Var5.R() != null && view2 == this.a.N.R().x()) {
                                    if (this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().Q() == null) {
                                        return;
                                    }
                                    this.a.N.J();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.N.V(absVideoPbFragment3.M().l1().Q().getFirstPostId());
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091919) {
                                    try {
                                        sparseArray = (SparseArray) view2.getTag();
                                    } catch (ClassCastException e) {
                                        e.printStackTrace();
                                        sparseArray = null;
                                    }
                                    vh8 vh8Var6 = this.a.N;
                                    if (vh8Var6 != null) {
                                        vh8Var6.y0(sparseArray);
                                    }
                                } else {
                                    vh8 vh8Var7 = this.a.N;
                                    int i4 = 4;
                                    if (vh8Var7 != null && vh8Var7.R() != null && view2 == this.a.N.R().v()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        if (skinType == 1) {
                                            this.a.onChangeSkinType(skinType);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 0).param("obj_source", 1));
                                        } else if (skinType == 0 || skinType == 4) {
                                            UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                            this.a.onChangeSkinType(skinType);
                                            UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_1));
                                            TbadkCoreApplication.getInst().setSkinType(1);
                                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.SET_NIGHT_MODE).param("obj_type", 1).param("obj_source", 1));
                                        }
                                        this.a.N.K();
                                        return;
                                    }
                                    vh8 vh8Var8 = this.a.N;
                                    if (vh8Var8 != null && vh8Var8.R() != null && view2 == this.a.N.R().w()) {
                                        this.a.N.K();
                                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                        absVideoPbFragment4.N.I0(absVideoPbFragment4.D1);
                                        return;
                                    }
                                    vh8 vh8Var9 = this.a.N;
                                    if (vh8Var9 != null && vh8Var9.R() != null && view2 == this.a.N.R().p()) {
                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.M().F1())) == null) {
                                            return;
                                        }
                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                        this.a.N.J();
                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                        return;
                                    }
                                    vh8 vh8Var10 = this.a.N;
                                    if (vh8Var10 != null && (view2 == vh8Var10.N() || (this.a.N.R() != null && (view2 == this.a.N.R().t() || view2 == this.a.N.R().u())))) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        } else if (this.a.M() == null || this.a.M().l1() == null || this.a.R.Z()) {
                                            return;
                                        } else {
                                            this.a.N.G();
                                            if (this.a.N.R() != null && view2 == this.a.N.R().u()) {
                                                if (this.a.M().l1().Q().getIs_top() == 1) {
                                                    i4 = 5;
                                                }
                                            } else if (this.a.N.R() != null && view2 == this.a.N.R().t()) {
                                                i4 = this.a.M().l1().Q().getIs_good() == 1 ? 3 : 6;
                                            } else {
                                                i4 = view2 == this.a.N.N() ? 2 : 0;
                                            }
                                            ForumData l = this.a.M().l1().l();
                                            String name = l.getName();
                                            String id = l.getId();
                                            String id2 = this.a.M().l1().Q().getId();
                                            this.a.showProgressBar();
                                            this.a.R.d0(id, name, id2, i4, this.a.N.O());
                                            return;
                                        }
                                    }
                                    vh8 vh8Var11 = this.a.N;
                                    if (vh8Var11 != null && vh8Var11.R() != null && view2 == this.a.N.R().o()) {
                                        if (this.a.M() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.N.G();
                                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                        SparseArray<Object> c4 = absVideoPbFragment5.c4(absVideoPbFragment5.M().l1(), this.a.M().D1(), 1);
                                        if (c4 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().l1().l().getId(), this.a.M().l1().l().getName(), this.a.M().l1().Q().getId(), String.valueOf(this.a.M().l1().X().getUserId()), (String) c4.get(R.id.tag_forbid_user_name), (String) c4.get(R.id.tag_forbid_user_name_show), (String) c4.get(R.id.tag_forbid_user_post_id), (String) c4.get(R.id.tag_forbid_user_portrait))));
                                        return;
                                    }
                                    vh8 vh8Var12 = this.a.N;
                                    if (vh8Var12 != null && vh8Var12.R() != null && view2 == this.a.N.R().k()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                        SparseArray<Object> c42 = absVideoPbFragment6.c4(absVideoPbFragment6.M().l1(), this.a.M().D1(), 1);
                                        if (c42 != null) {
                                            this.a.N.k0(((Integer) c42.get(R.id.tag_del_post_type)).intValue(), (String) c42.get(R.id.tag_del_post_id), ((Integer) c42.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c42.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.N.J();
                                        if (this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().Q() == null) {
                                            return;
                                        }
                                        ThreadData Q = this.a.M().l1().Q();
                                        StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem6.param("tid", Q.getId());
                                        statisticItem6.param("fid", Q.getFid());
                                        statisticItem6.param("fname", Q.getForum_name());
                                        TiebaStatic.log(statisticItem6);
                                        StatisticItem statisticItem7 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                        statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                        statisticItem7.param("tid", Q.getId());
                                        statisticItem7.param("fid", Q.getFid());
                                        statisticItem7.param("fname", Q.getForum_name());
                                        statisticItem7.param("obj_source", 3);
                                        TiebaStatic.log(statisticItem7);
                                        return;
                                    }
                                    vh8 vh8Var13 = this.a.N;
                                    if (vh8Var13 != null && vh8Var13.R() != null && view2 == this.a.N.R().n()) {
                                        if (this.a.M() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                        SparseArray<Object> c43 = absVideoPbFragment7.c4(absVideoPbFragment7.M().l1(), this.a.M().D1(), 1);
                                        if (c43 != null) {
                                            if (StringUtils.isNull((String) c43.get(R.id.tag_del_multi_forum))) {
                                                this.a.N.h0(((Integer) c43.get(R.id.tag_del_post_type)).intValue(), (String) c43.get(R.id.tag_del_post_id), ((Integer) c43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c43.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.N.i0(((Integer) c43.get(R.id.tag_del_post_type)).intValue(), (String) c43.get(R.id.tag_del_post_id), ((Integer) c43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) c43.get(R.id.tag_del_post_is_self)).booleanValue(), (String) c43.get(R.id.tag_del_multi_forum));
                                            }
                                        }
                                        this.a.N.J();
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f0920e7 && view2.getId() != R.id.obfuscated_res_0x7f09191b && view2.getId() != R.id.obfuscated_res_0x7f0917a5 && view2.getId() != R.id.obfuscated_res_0x7f09197d) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f09197b && view2.getId() != R.id.obfuscated_res_0x7f091b5b && view2.getId() != R.id.obfuscated_res_0x7f091915) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091902 && view2.getId() != R.id.collect_num_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091907 && view2.getId() != R.id.share_more_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091904 && view2.getId() != R.id.thread_info_commont_container) {
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f09252e) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.M() == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.M().F1());
                                                                statisticItem8.param("fid", this.a.M().getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem8);
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091945 && view2.getId() != R.id.obfuscated_res_0x7f09190f) {
                                                                if (view2.getId() == R.id.obfuscated_res_0x7f091136) {
                                                                    this.a.i5();
                                                                    return;
                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0907d7 && view2.getId() != R.id.obfuscated_res_0x7f090aa0) {
                                                                    if (this.a.N.R() != null && view2 == this.a.N.R().l()) {
                                                                        this.a.N.G();
                                                                        if (this.a.M() != null) {
                                                                            this.a.t.f(this.a.M().F1());
                                                                        }
                                                                        if (this.a.M() != null && this.a.M().isPrivacy()) {
                                                                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                            if (this.a.M().l1() != null) {
                                                                                this.a.t.d(3, 3, this.a.M().l1().S());
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        this.a.t.b();
                                                                        int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().S() == null || !this.a.M().l1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                        if (this.a.M() == null || this.a.M().l1() == null) {
                                                                            return;
                                                                        }
                                                                        this.a.t.d(3, i5, this.a.M().l1().S());
                                                                        return;
                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09191d || view2.getId() == R.id.obfuscated_res_0x7f091975) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", this.a.M().F1());
                                                                        statisticItem9.param("fid", this.a.M().getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 7);
                                                                        TiebaStatic.log(statisticItem9);
                                                                        if (this.a.G4()) {
                                                                            StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                            statisticItem10.param("fid", this.a.M().getForumId());
                                                                            statisticItem10.param("tid", this.a.M().F1());
                                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem10.param(str, this.a.X3());
                                                                            statisticItem10.param("obj_source", 1);
                                                                            statisticItem10.param("obj_type", 2);
                                                                            statisticItem10.param("obj_locate", this.a.W3());
                                                                            TiebaStatic.log(statisticItem10);
                                                                        }
                                                                        this.a.N.q0(false);
                                                                        this.a.N.Q().onLongClick(view2);
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                } else {
                                                                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                                                    if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof PostData)) {
                                                                        return;
                                                                    }
                                                                    PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                                                                    View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                    if (postData2 == null || view3 == null) {
                                                                        return;
                                                                    }
                                                                    ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907d8);
                                                                    EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907d9);
                                                                    View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090aa0);
                                                                    if (postData2.v0()) {
                                                                        postData2.W0(false);
                                                                        zf8.e(postData2);
                                                                    } else {
                                                                        if (this.a.M() != null ? zf8.c(this.a.M().l1(), postData2) : false) {
                                                                            postData2.W0(true);
                                                                            findViewById.setVisibility(0);
                                                                        }
                                                                    }
                                                                    SkinManager.setBackgroundColor(findViewById, postData2.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                    SkinManager.setViewTextColor(eMTextView, postData2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                    WebPManager.setPureDrawable(imageView, postData2.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                    return;
                                                                }
                                                            } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = p35.m().s("tail_link", "");
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    BrowserHelper.t(view2.getContext(), string, s, true, true, true);
                                                                }
                                                                this.a.i5();
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (this.a.Q0 >= 0) {
                                                            if (this.a.M() != null) {
                                                                this.a.M().J2();
                                                            }
                                                            if (this.a.J4() && this.a.M() != null && this.a.k4() != null && this.a.k4().C1() != null) {
                                                                this.a.k4().C1().f(this.a.M().l1());
                                                            } else if (this.a.T3() != null && this.a.T3().C1() != null) {
                                                                this.a.T3().C1().r(this.a.M().l1());
                                                            }
                                                            this.a.Q0 = 0;
                                                            this.a.R0 = Integer.MIN_VALUE;
                                                            if (this.a.J4() && this.a.M() != null && this.a.k4() != null) {
                                                                this.a.k4().h2(this.a.M().e1(), this.a.M().d1());
                                                                this.a.M().N2(0, 0);
                                                                return;
                                                            } else if (this.a.M() == null || this.a.T3() == null) {
                                                                return;
                                                            } else {
                                                                this.a.T3().o2(this.a.M().e1(), this.a.M().d1());
                                                                this.a.M().N2(0, 0);
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    String str3 = str;
                                                    if (this.a.M() != null) {
                                                        AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                        if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.M().l1() == null || this.a.M().l1().Q() == null || !this.a.checkUpIsLogin()) {
                                                            return;
                                                        }
                                                        v98 l1 = this.a.M().l1();
                                                        int reply_num = l1.Q().getReply_num();
                                                        int currentItem = this.a.e.getCurrentItem();
                                                        if (reply_num == 0) {
                                                            if (this.a.J4() && currentItem == 0) {
                                                                this.a.e.setCurrentItem(1);
                                                            }
                                                            this.a.L3(false);
                                                            this.a.a5();
                                                            return;
                                                        }
                                                        if (!this.a.J4() || currentItem != 0) {
                                                            if ((this.a.J4() && this.a.k4() == null) || this.a.T3() == null || this.a.j4() == null) {
                                                                return;
                                                            }
                                                            StatisticItem param = new StatisticItem("c13403").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            int j = (int) (ej.j(this.a.getContext()) * 0.6d);
                                                            BdTypeRecyclerView j4 = this.a.j4();
                                                            if (j4 == null) {
                                                                return;
                                                            }
                                                            boolean canScrollVertically = j4.canScrollVertically(1);
                                                            boolean canScrollVertically2 = j4.canScrollVertically(-1);
                                                            AppBarLayout appBarLayout = this.a.i;
                                                            str2 = "obj_source";
                                                            if (appBarLayout != null) {
                                                                appBarLayout.setExpanded(false, true);
                                                            }
                                                            if (j4.getLayoutManager() == null || !(j4.getLayoutManager() instanceof LinearLayoutManager)) {
                                                                return;
                                                            }
                                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) j4.getLayoutManager();
                                                            if (canScrollVertically2 || !canScrollVertically) {
                                                                int firstVisiblePosition = j4.getFirstVisiblePosition();
                                                                View childAt = j4.getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                this.a.O0 = firstVisiblePosition;
                                                                this.a.P0 = top;
                                                                if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-j) || j4.getCount() < 6)) {
                                                                    j4.smoothScrollToPosition(0);
                                                                } else {
                                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                    j4.smoothScrollToPosition(0);
                                                                }
                                                                i2 = 1;
                                                                param.param("obj_locate", 1);
                                                            } else if (this.a.O0 == -1 && this.a.P0 == Integer.MIN_VALUE) {
                                                                return;
                                                            } else {
                                                                if (this.a.O0 > 3 || (this.a.O0 == 3 && this.a.P0 < (-j))) {
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.O0, this.a.P0 + j);
                                                                    j4.smoothScrollBy(0, j);
                                                                } else if (this.a.O0 >= 2) {
                                                                    int i6 = j / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.O0, this.a.P0 + i6);
                                                                    j4.smoothScrollBy(0, i6);
                                                                } else if (this.a.O0 == 1) {
                                                                    int i7 = j / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.O0, this.a.P0 + i7);
                                                                    j4.smoothScrollBy(0, i7);
                                                                } else {
                                                                    j4.smoothScrollBy(0, -this.a.P0);
                                                                }
                                                                param.param("obj_locate", 2);
                                                                i2 = 1;
                                                            }
                                                            TiebaStatic.log(param);
                                                            pj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                            StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                            statisticItem11.param("obj_type", i2);
                                                            statisticItem11.param("obj_locate", 4);
                                                            statisticItem11.param("tid", this.a.M().F1());
                                                            statisticItem11.param("nid", l1.Q().getNid());
                                                            if (findPageExtraByView != null) {
                                                                statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                            }
                                                            if (TbPageExtraHelper.getPrePageKey() != null) {
                                                                statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                            }
                                                            TiebaStatic.log(statisticItem11);
                                                        } else {
                                                            this.a.e.setCurrentItem(1);
                                                            str2 = "obj_source";
                                                        }
                                                        if (this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().Q() == null || this.a.M().l1().Q().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        if (this.a.G4()) {
                                                            StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem12.param("fid", this.a.M().getForumId());
                                                            statisticItem12.param("tid", this.a.M().F1());
                                                            statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem12.param(str3, this.a.X3());
                                                            statisticItem12.param(str2, 1);
                                                            statisticItem12.param("obj_type", 12);
                                                            statisticItem12.param("obj_locate", this.a.W3());
                                                            TiebaStatic.log(statisticItem12);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.a.n4(true);
                                                return;
                                            }
                                            String str4 = str;
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                            if (absVideoPbFragment9.N == null || absVideoPbFragment9.M() == null) {
                                                return;
                                            }
                                            if (this.a.J4() && this.a.k4() == null) {
                                                return;
                                            }
                                            if (this.a.J4() || this.a.T3() != null) {
                                                this.a.N.G();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091902 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                    if (!this.a.A3(11009) || this.a.M() == null) {
                                                        return;
                                                    }
                                                    this.a.R4();
                                                    if (this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        if (this.a.G4()) {
                                                            StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem13.param("fid", this.a.M().getForumId());
                                                            statisticItem13.param("tid", this.a.M().F1());
                                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem13.param(str4, this.a.X3());
                                                            statisticItem13.param("obj_source", 1);
                                                            statisticItem13.param("obj_type", 13);
                                                            statisticItem13.param("obj_locate", this.a.W3());
                                                            TiebaStatic.log(statisticItem13);
                                                        }
                                                    }
                                                    if (this.a.M().l1().Q() == null || this.a.M().l1().Q().getAuthor() == null || this.a.M().l1().Q().getAuthor().getUserId() == null || this.a.P == null) {
                                                        return;
                                                    }
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    int T = absVideoPbFragment10.N.T(absVideoPbFragment10.M().l1());
                                                    ThreadData Q2 = this.a.M().l1().Q();
                                                    if (Q2.isBJHArticleThreadType()) {
                                                        i = 2;
                                                    } else if (Q2.isBJHVideoThreadType()) {
                                                        i = 3;
                                                    } else if (Q2.isBJHNormalThreadType()) {
                                                        i = 4;
                                                    } else {
                                                        i = Q2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.M().F1()).param("obj_locate", 1).param("obj_id", this.a.M().l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", T).param("obj_param1", i));
                                                    return;
                                                }
                                                this.a.z = view2;
                                                return;
                                            }
                                            return;
                                        }
                                        String str5 = str;
                                        if (this.a.M() == null) {
                                            return;
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f09197b) {
                                            StatisticItem statisticItem14 = new StatisticItem("c13398");
                                            statisticItem14.param("tid", this.a.M().F1());
                                            statisticItem14.param("fid", this.a.M().getForumId());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem14);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091b5b) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.y = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09197b && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f09197b && (statisticItem = postData3.e0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091b5b || view2.getId() == R.id.obfuscated_res_0x7f091915) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.M().G1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData3.O()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.M() == null || this.a.M().l1() == null || this.a.K0 == null || postData3.r() == null || postData3.F() == 1) {
                                                    return;
                                                }
                                                if (this.a.J0 != null) {
                                                    this.a.J0.g();
                                                }
                                                la8 la8Var2 = new la8();
                                                la8Var2.A(this.a.M().l1().l());
                                                la8Var2.E(this.a.M().l1().Q());
                                                la8Var2.C(postData3);
                                                this.a.K0.c0(la8Var2);
                                                this.a.K0.setPostId(postData3.O());
                                                this.a.P4(view2, postData3.r().getUserId(), "", postData3);
                                                if (this.a.H0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                    absVideoPbFragment11.r5(absVideoPbFragment11.H0.y());
                                                }
                                            }
                                        }
                                    } else {
                                        String str6 = str;
                                        if (view2.getId() == R.id.obfuscated_res_0x7f0917a5) {
                                            StatisticItem statisticItem15 = new StatisticItem("c13398");
                                            statisticItem15.param("tid", this.a.M().F1());
                                            statisticItem15.param("fid", this.a.M().getForumId());
                                            statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem15.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem15);
                                            if (this.a.G4()) {
                                                StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem16.param("fid", this.a.M().getForumId());
                                                statisticItem16.param("tid", this.a.M().F1());
                                                statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem16.param(str6, this.a.X3());
                                                statisticItem16.param("obj_source", 1);
                                                statisticItem16.param("obj_type", 8);
                                                statisticItem16.param("obj_locate", this.a.W3());
                                                TiebaStatic.log(statisticItem16);
                                            }
                                        }
                                        if ((view2.getId() != R.id.obfuscated_res_0x7f09191b && view2.getId() != R.id.obfuscated_res_0x7f09197d) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09191b && this.a.G4()) {
                                                StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem17.param("fid", this.a.M().getForumId());
                                                statisticItem17.param("tid", this.a.M().F1());
                                                statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem17.param(str6, this.a.X3());
                                                statisticItem17.param("obj_source", 1);
                                                statisticItem17.param("obj_type", 9);
                                                statisticItem17.param("obj_locate", this.a.W3());
                                                TiebaStatic.log(statisticItem17);
                                            }
                                            if (!this.a.checkUpIsLogin()) {
                                                xg8.r("c10517", this.a.M().l1().m(), 3);
                                                return;
                                            } else if (this.a.M() == null || this.a.M().l1() == null) {
                                                return;
                                            } else {
                                                vh8 vh8Var14 = this.a.N;
                                                if (vh8Var14 != null) {
                                                    vh8Var14.G();
                                                }
                                                SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                PostData postData5 = (PostData) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                                if (postData4 == null) {
                                                    return;
                                                }
                                                if (postData4.J() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem18 = postData4.e0;
                                                if (statisticItem18 != null) {
                                                    StatisticItem copy2 = statisticItem18.copy();
                                                    copy2.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f0917a5) {
                                                        copy2.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09191b) {
                                                        copy2.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy2);
                                                }
                                                this.a.S5();
                                                TiebaStatic.log("c11742");
                                                if (postData5 != null) {
                                                    this.a.Q5(postData4, postData5, false, true);
                                                    return;
                                                } else {
                                                    this.a.Q5(postData4, null, false, false);
                                                    return;
                                                }
                                            }
                                        }
                                        this.a.x = view2;
                                    }
                                }
                            }
                        } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                            this.a.showToast(R.string.network_not_available);
                            view2.setTag(Boolean.FALSE);
                        } else {
                            this.a.N.G();
                            if (this.a.L) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.S5();
                            this.a.y5();
                            boolean h3 = view2.getId() == R.id.obfuscated_res_0x7f09188c ? this.a.M().h3(true, this.a.X3()) : view2.getId() == R.id.obfuscated_res_0x7f090272 ? this.a.M().h3(false, this.a.X3()) : this.a.M().g3(this.a.X3());
                            view2.setTag(Boolean.valueOf(h3));
                            if (h3) {
                                this.a.I5();
                                i3 = 1;
                                this.a.L = true;
                            } else {
                                i3 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i3, new Object[0]);
                        }
                    } else if (!this.a.L && this.a.M().j2(true)) {
                        this.a.L = true;
                        if (this.a.J4()) {
                            if (this.a.k4() != null) {
                                this.a.k4().l2();
                            }
                        } else if (this.a.T3() != null) {
                            this.a.T3().t2();
                        }
                    }
                }
            }
        }

        public y(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }
    }

    /* loaded from: classes5.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements kd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public y1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.kd5
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ce8 ce8Var = this.a.E0;
                if (ce8Var != null && ce8Var.e() != null && this.a.E0.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.E0.e().c());
                    if (this.a.H0 != null && (this.a.H0.x() || this.a.H0.z())) {
                        this.a.H0.w(false, this.a.E0.h());
                    }
                    this.a.E0.a(true);
                    return true;
                } else if (this.a.C3(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends kp5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public z(AbsVideoPbFragment absVideoPbFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absVideoPbFragment;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kp5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.Q2(this.a);
                }
                return wf8.d(this.b.S3(), 2, M);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public z0(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.K0.X(postData);
                if (this.a.T3() != null) {
                    this.a.T3().f2();
                } else if (this.a.J4() && this.a.k4() != null) {
                    this.a.k4().b2();
                }
                this.a.J0.g();
                this.a.I0.s();
                this.a.F5(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<ea5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public z1(AbsVideoPbFragment absVideoPbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absVideoPbFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ea5 ea5Var, ea5 ea5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ea5Var, ea5Var2)) == null) {
                return ea5Var.compareTo(ea5Var2);
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1317086303, "Lcom/baidu/tieba/pb/videopb/AbsVideoPbFragment;");
                return;
            }
        }
        L1 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        M1 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        N1 = 3;
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            FallingView fallingView = this.K;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.V0;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K) {
                this.V0.setTag(null);
                this.V0.setAutoCompleteShown(true);
                this.V0.d();
            }
        }
    }

    public final void L5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && M() != null && !dj.isEmpty(M().F1())) {
            cr4.w().P(br4.Z, dh.g(M().F1(), 0L));
        }
    }

    public final void N5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048626, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        this.v.setAlpha(0.0f);
        this.v.setVisibility(0);
        Y5(layoutParams);
    }

    public final void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (this.v1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 1.0f, 0.0f);
                this.v1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.v1.start();
        }
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.u1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 0.0f, 1.0f);
                this.u1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.u1.start();
        }
    }

    public final int S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (M() != null && M().l1() != null && M().l1().Q() != null) {
                return M().l1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.N != null && M() != null) {
                this.N.G();
                if (this.L) {
                    return;
                }
                S5();
                y5();
                if (M().loadData()) {
                    I5();
                }
            }
        }
    }

    public final void X5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.t0.a()) {
            this.k.X(false);
            return;
        }
        ai8 ai8Var = this.k;
        if (!G4() && !this.k.N0()) {
            z2 = true;
        }
        ai8Var.X(z2);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048697, this) == null) {
            au4 c3 = au4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.X0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.R = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.w1);
            this.Q = new p85(getPageContext());
            this.N = new vh8(this);
        }
    }

    public BdTypeRecyclerView j4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).X1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).V1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onStop();
            u0().onStop(getPageContext());
            m09.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    public void x5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            hideProgressBar();
            if (J4() && k4() != null) {
                k4().P1();
                k4().Q1();
            } else if (T3() != null) {
                T3().R1();
                T3().S1();
            }
        }
    }

    public final boolean z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            PbModel M = M();
            if (M != null && M.l1() != null) {
                ThreadData Q = M.l1().Q();
                M.l1().d();
                return AntiHelper.b(getPageContext(), Q);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AbsVideoPbFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0L;
        this.u = false;
        this.B = new k(this);
        this.L = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.Z = false;
        this.c0 = null;
        this.f0 = null;
        this.v0 = false;
        this.w0 = null;
        this.x0 = false;
        this.y0 = false;
        this.z0 = false;
        this.A0 = false;
        this.M0 = new int[2];
        this.O0 = -1;
        this.P0 = Integer.MIN_VALUE;
        this.Q0 = 0;
        this.R0 = Integer.MIN_VALUE;
        this.S0 = false;
        this.T0 = new v(this);
        this.W0 = new c1(this);
        this.X0 = new n1(this);
        this.Y0 = new y1(this);
        this.Z0 = new b2(this, 2004016);
        this.a1 = new c2(this, 2004007);
        this.b1 = new a(this, 2921391);
        this.c1 = new b(this, 2016450);
        this.d1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.e1 = new d(this, 2001426);
        this.f1 = new e(this, 2001427);
        this.g1 = new f(this, 2001428);
        this.h1 = new g(this);
        this.i1 = new h(this);
        this.j1 = new i(this);
        this.k1 = new j(this, 2004008);
        this.l1 = 0;
        this.p1 = true;
        this.q1 = new l(this);
        this.s1 = new m(this);
        this.t1 = new n(this);
        this.w1 = new o(this);
        this.x1 = new p(this);
        this.y1 = new q(this);
        this.z1 = new s(this);
        this.A1 = new x(this);
        this.B1 = new y(this);
        this.C1 = new b0(this);
        this.D1 = new c0(this);
        this.E1 = new d0(this, 2001332);
        this.F1 = new e0(this, 2016528);
        this.G1 = new o0(this, 2001440);
        this.H1 = new p0(this);
        this.I1 = new w0(this, 2921509);
        this.J1 = new a1(this);
        this.K1 = new b1(this);
        this.t0 = new d2(this, null);
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && M() != null && M().l1() != null) {
            if (!J4() || k4() != null) {
                if ((J4() || T3() != null) && this.P != null) {
                    MarkData markData = null;
                    if (M().l1() != null && M().l1().l0()) {
                        markData = M().B0(0);
                    } else {
                        CustomViewPager customViewPager = this.e;
                        if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                            markData = M().f1(V3(M().l1()));
                        } else if (J4()) {
                            if (k4() != null) {
                                markData = M().B0(k4().U1());
                            }
                        } else if (T3() != null) {
                            markData = M().B0(T3().W1());
                        }
                    }
                    if (markData == null) {
                        return;
                    }
                    if (markData.isApp() && k4() != null && (markData = M().B0(k4().U1() + 1)) == null) {
                        return;
                    }
                    y5();
                    this.P.i(markData);
                    if (!this.P.e()) {
                        if (M() != null && !wf8.k(M().F1())) {
                            this.j0.o(2);
                            wf8.b(M().F1());
                        }
                        this.P.a();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.P.d();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    public final String X3() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (M() == null || M().l1() == null || M().l1().H() == null || (count = ListUtils.getCount((H = M().l1().H()))) == 0) {
                return "";
            }
            if (M().w1()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        return next.O();
                    }
                }
            }
            int i2 = 0;
            if (j4() != null) {
                if (J4()) {
                    if (k4() != null) {
                        i2 = k4().S1();
                    }
                } else if (T3() != null) {
                    i2 = T3().U1();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(H, i2);
            if (postData != null && postData.r() != null) {
                if (M().g2(postData.r().getUserId())) {
                    return postData.O();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i3);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (M().g2(postData2.r().getUserId())) {
                        return postData2.O();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i4);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (M().g2(postData3.r().getUserId())) {
                        return postData3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.a0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0926a5);
            this.b0 = this.c.findViewById(R.id.obfuscated_res_0x7f092706);
            this.c0 = this.c.findViewById(R.id.obfuscated_res_0x7f091903);
            ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0908e1);
            this.e0 = imageView;
            imageView.setOnClickListener(new u0(this));
            O4();
            this.f0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091906);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0918fe);
            this.d0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091904);
            this.g0 = imageView2;
            imageView2.setOnClickListener(this.B1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091902);
            this.h0 = imageView3;
            imageView3.setOnClickListener(this.B1);
            if (booleanExtra) {
                this.h0.setVisibility(8);
            } else {
                this.h0.setVisibility(0);
            }
            if (I4()) {
                this.g0.setVisibility(0);
            } else {
                this.g0.setVisibility(8);
                this.h0.setPadding(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091907);
            this.i0 = imageView4;
            imageView4.setOnClickListener(this.B1);
            this.j0 = new gi8(this.i0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.j0.f();
            }
            if (M() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !wf8.k(M().F1())) {
                this.j0.f();
                wf8.b(M().F1());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091905);
            this.r0 = textView;
            textView.setVisibility(0);
            F5(false);
        }
    }

    @Override // com.baidu.tieba.bt5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.Z = true;
        }
    }

    @Override // com.baidu.tieba.bt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            fe8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.Z = true;
        }
    }

    public void X4(ea5 ea5Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048662, this, ea5Var, i2) == null) && (fallingView = this.K) != null) {
            fallingView.A(ea5Var, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.bt5
    public void g0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048689, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.Z = true;
    }

    public final void u4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048743, this, i2, i3) == null) {
            op5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void w5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048753, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            vh8 vh8Var = this.N;
            if (vh8Var == null) {
                return;
            }
            if (z2) {
                vh8Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.H();
            } else {
                this.N.G();
            }
        }
    }

    public void A5(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && (view2 = this.g) != null) {
            view2.setVisibility(i2);
        }
    }

    public void B5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            this.u = z2;
        }
    }

    public final void C5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            this.H0.X(z2);
            this.H0.a0(z2);
            this.H0.i0(z2);
        }
    }

    public void F5(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048597, this, z2) != null) || this.c0 == null) {
            return;
        }
        r5(this.H0.y());
        if (this.v0) {
            G5(z2);
        } else {
            p4(z2);
        }
        Y4();
        b5();
    }

    public final void H5(v98 v98Var) {
        yh8 I;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, v98Var) == null) && (I = v98Var.I()) != null && !I.l) {
            w3(I);
        }
    }

    public final void K5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            zh8.c(N(), S3(), i2);
        }
    }

    public void L3(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) && (appBarLayout = this.i) != null) {
            appBarLayout.setExpanded(z2);
        }
    }

    public void T4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            View view2 = this.h;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final void m5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048706, this, i2) == null) && M() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(M().F1());
            sendMessage(privacySettingMessage);
        }
    }

    public void n5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048708, this, i2) == null) && (linearLayout = this.a0) != null) {
            linearLayout.setVisibility(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            super.onUserChanged(z2);
            O4();
        }
    }

    public final void q5(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).a2());
            }
        }
    }

    public void r5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            this.v0 = z2;
        }
    }

    public void s5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.L = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (customViewPager = this.e) != null) {
                if (z2) {
                    i2 = customViewPager.getCurrentItem();
                } else {
                    i2 = -1;
                }
                videoPbFragmentAdapter.d(i2);
            }
        }
    }

    public void t5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z2) == null) {
            this.p1 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048717, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(Y3(), viewGroup, false);
            E4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public void B4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (editorTools = this.I0) == null) {
            return;
        }
        editorTools.j();
        o4();
    }

    @Override // com.baidu.tieba.hh8
    public PbModel.h G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.W0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public boolean H4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            EditorTools editorTools = this.I0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void I5() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(0);
        }
    }

    public void J3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", N1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (!G4() && M() != null && M().e2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", N1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean K4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ai8 ai8Var = this.k;
            if (ai8Var != null && ai8Var.M0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.p1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hh8
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.a.H1();
        }
        return (PbModel) invokeV.objValue;
    }

    public boolean M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ai8 ai8Var = this.k;
            if (ai8Var == null) {
                return false;
            }
            return ai8Var.N0();
        }
        return invokeV.booleanValue;
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        W5();
    }

    @Override // com.baidu.tieba.hh8
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.e0 != null) {
            K3();
            this.e0.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<RelativeLayout> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new x1(this), 10, 0);
            this.Y = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public p85 Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.Q;
        }
        return (p85) invokeV.objValue;
    }

    public LinearLayout R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.d0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public void R5() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (fallingView = this.K) != null) {
            fallingView.C();
        }
    }

    public final void S5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (voiceManager = this.S) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<ImageView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.V == null) {
                this.V = new ug<>(new t1(this), 8, 0);
            }
            return this.V;
        }
        return (ug) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final void T5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.T1();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<View> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.W == null) {
                this.W = new ug<>(new v1(this), 8, 0);
            }
            return this.W;
        }
        return (ug) invokeV.objValue;
    }

    public DetailInfoFragment U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return (DetailInfoFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void V5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            od5 od5Var = this.H0;
            if (od5Var != null) {
                r5(od5Var.y());
            }
            i5();
            this.N.G();
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<TextView> W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.U == null) {
                this.U = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.U;
        }
        return (ug) invokeV.objValue;
    }

    public boolean Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.B1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.C1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public au4 d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.P;
        }
        return (au4) invokeV.objValue;
    }

    public View.OnLongClickListener e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.J1;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.x1;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public od5 g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.H0;
        }
        return (od5) invokeV.objValue;
    }

    public void i5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            h5();
            q4();
            this.J0.g();
            F5(false);
        }
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public ReplyFragment k4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return (ReplyFragment) this.f.b(1);
            }
            return null;
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            this.O0 = -1;
            this.P0 = Integer.MIN_VALUE;
        }
    }

    public String l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            if (!dj.isEmpty(this.u0)) {
                return this.u0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(xd8.g());
            this.u0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void o4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048709, this) != null) || this.c0 == null) {
            return;
        }
        this.b0.setVisibility(8);
        this.c0.setVisibility(8);
        this.t0.a = false;
        Y4();
        b5();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onStart();
            u0().onStart(getPageContext());
        }
    }

    public final void p5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.K.setFallingFeedbackListener(new a2(this));
        }
    }

    public void q4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048728, this) == null) && (editorTools = this.I0) != null) {
            editorTools.q();
        }
    }

    public void r4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && this.a.getCurrentFocus() != null) {
            ej.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public void s4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(8);
        }
    }

    public void t4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (rightFloatLayerView = this.V0) != null) {
            rightFloatLayerView.c();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && M() != null && !dj.isEmpty(M().F1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            if (this.S == null) {
                this.S = VoiceManager.instance();
            }
            return this.S;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bt5
    public ug<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            if (this.T == null) {
                this.T = new ug<>(new u1(this), 20, 0);
            }
            return this.T;
        }
        return (ug) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            PbModel H1 = this.a.H1();
            if (H1 == null) {
                return false;
            }
            return H1.f2();
        }
        return invokeV.booleanValue;
    }

    public void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            o5(this.H0.b());
        }
    }

    @Override // com.baidu.tieba.bt5
    public ug<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            if (this.X == null) {
                this.X = new ug<>(new w1(this), 15, 0);
            }
            return this.X;
        }
        return (ug) invokeV.objValue;
    }

    public void y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            ej.z(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void A0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (ys5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ys5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (fe8.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new nq5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.bt5
    public void W(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048656, this, context, str, z2) == null) {
            if (fe8.c(str) && M() != null && M().F1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", M().F1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    wa5 wa5Var = new wa5();
                    wa5Var.a = str;
                    wa5Var.b = 3;
                    wa5Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, wa5Var));
                }
            } else {
                fe8.a().e(getPageContext(), str);
            }
            this.Z = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048712, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.H0.C(i2, i3, intent);
            sc8 sc8Var = this.J0;
            if (sc8Var != null) {
                sc8Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                m4(i3, intent);
            }
            if (i3 == -1) {
                if (i2 != 11009) {
                    if (i2 != 13011) {
                        switch (i2) {
                            case 25055:
                                View view2 = this.x;
                                if (view2 != null) {
                                    view2.performClick();
                                    return;
                                }
                                return;
                            case 25056:
                                View view3 = this.y;
                                if (view3 != null) {
                                    view3.performClick();
                                    return;
                                }
                                return;
                            case 25057:
                                if (R3() != null) {
                                    R3().performClick();
                                    return;
                                }
                                return;
                            case 25058:
                                View view4 = this.z;
                                if (view4 != null) {
                                    view4.performClick();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    tr8.g().m(getPageContext());
                    return;
                }
                R4();
            }
        }
    }

    public final boolean A3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public void G5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) && this.c0 != null && (textView = this.f0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0550);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.c0.startAnimation(alphaAnimation);
            }
            this.b0.setVisibility(0);
            this.c0.setVisibility(0);
            this.t0.a = true;
        }
    }

    public void f5(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048687, this, v98Var) == null) && v98Var != null && v98Var.Q() != null) {
            String valueOf = String.valueOf(v98Var.Q().getReply_num());
            if (v98Var.Q().getReply_num() == 0) {
                valueOf = "";
            }
            this.d.F(valueOf);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ai8 ai8Var = this.k;
            if (ai8Var != null && !ai8Var.N0()) {
                if ((this.k.isFullScreen() && configuration.orientation == 1) || (!this.k.isFullScreen() && configuration.orientation == 2)) {
                    this.k.V(false);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (M() != null) {
                M().K2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                u0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void A4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0926a8);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802cf);
            int i2 = 0;
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f0920c9);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f0920d0);
            this.o = findViewById;
            if (this.o1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = ej.u(N());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = ej.u(N());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.B1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.B1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View view2 = this.r;
            if (!TbadkCoreApplication.isLogin()) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.r1 = new GestureDetector(getContext(), this.s1);
            this.m.setOnTouchListener(this.q1);
        }
    }

    public final boolean U5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (M() == null) {
                return true;
            }
            if (M().l1() != null && M().l1().l0()) {
                return true;
            }
            if (M().W0()) {
                MarkData H0 = M().H0();
                if (H0 != null && M().U0() && j4() != null) {
                    MarkData B0 = M().B0(j4().getFirstVisiblePosition());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", H0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(H0.getPostId())) {
                        j05 j05Var = new j05(getBaseFragmentActivity());
                        j05Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        j05Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045b, new t(this, B0, H0, j05Var));
                        j05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038c, new u(this, H0, j05Var));
                        j05Var.setOnCalcelListener(new w(this));
                        j05Var.create(getBaseFragmentActivity().getPageContext());
                        j05Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", H0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (M().l1() != null && M().l1().H() != null && M().l1().H().size() > 0 && M().U0()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void x3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048754, this) == null) && M() != null && this.a != null) {
            od5 od5Var = this.H0;
            if (od5Var != null && od5Var.t) {
                return;
            }
            nd5 nd5Var = new nd5();
            v5(nd5Var);
            od5 od5Var2 = (od5) nd5Var.a(getContext());
            this.H0 = od5Var2;
            od5Var2.W(this.a.getPageContext());
            this.H0.f0(this.i1);
            this.H0.g0(this.A1);
            od5 od5Var3 = this.H0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            od5Var3.A(pageContext, extras);
            this.H0.b().E(true);
            o5(this.H0.b());
            if (!M().Y0()) {
                this.H0.q(M().F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.H0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().W1()) {
                this.H0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.H0.c0(l4());
            }
        }
    }

    public boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if ((M() != null && M().l1().l0()) || this.B0 == null || M() == null || M().l1() == null || ThreadCardUtils.isSelf(M().l1().Q()) || M().l1().d() == null) {
                return true;
            }
            return this.B0.checkPrivacyBeforeInvokeEditor(M().l1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!checkUpIsLogin()) {
                if (M() != null) {
                    xg8.r("c10517", M().getForumId(), 2);
                }
            } else if (!B3()) {
            } else {
                od5 od5Var = this.H0;
                if (od5Var != null && (od5Var.x() || this.H0.z())) {
                    this.H0.w(false, null);
                    return;
                }
                if (this.I0 != null) {
                    B4();
                    this.t0.a = false;
                    if (this.I0.p(2) != null) {
                        v19.c(getPageContext(), (View) this.I0.p(2).m, false, null);
                    }
                }
                o4();
            }
        }
    }

    public void a5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048671, this) != null) || !checkUpIsLogin() || M() == null || M().l1() == null || M().l1().l() == null || z3()) {
            return;
        }
        if (M().l1().l0()) {
            D3();
            return;
        }
        if (this.C0 == null) {
            y17 y17Var = new y17(getPageContext());
            this.C0 = y17Var;
            y17Var.j(0);
            this.C0.i(new d1(this));
        }
        this.C0.g(M().l1().l().getId(), dh.g(M().F1(), 0L));
    }

    public final void a6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && M() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(M().getForumId()) && M().l1() != null && M().l1().l() != null) {
            boolean z2 = true;
            if (M().l1().l().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                M().y0().K(M().getForumId(), M().F1());
            }
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048674, this) == null) && this.k != null && this.e != null) {
            boolean z2 = false;
            if (!J4()) {
                this.k.R0(false);
            } else if (this.e.getCurrentItem() != 0) {
                this.k.R0(false);
            } else if (this.t0.a()) {
                this.k.R0(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.k.R0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
                }
            }
        }
    }

    public final void h5() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048694, this) == null) && this.H0 != null && this.I0 != null) {
            jd5.a().c(0);
            this.H0.M();
            this.H0.K();
            if (this.H0.v() != null) {
                WriteImagesInfo v2 = this.H0.v();
                if (this.H0.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            this.H0.d0(SendView.f);
            this.H0.h(SendView.f);
            sb5 o2 = this.I0.o(23);
            sb5 o3 = this.I0.o(2);
            sb5 o4 = this.I0.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.I0.invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onPause();
            this.S0 = true;
            u0().onPause();
            ai8 ai8Var = this.k;
            if (ai8Var != null) {
                ai8Var.onBackground(true);
            }
            if (M() != null && !M().Y0()) {
                this.H0.N(M().F1());
            }
            RightFloatLayerView rightFloatLayerView = this.V0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            cr4.w().E();
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && M() != null && M().l1() != null && M().l1().Q() != null) {
            ThreadData Q = M().l1().Q();
            Q.mRecomAbTag = M().q1();
            Q.mRecomWeight = M().t1();
            Q.mRecomSource = M().s1();
            Q.mRecomExtra = M().r1();
            Q.isSubPb = M().Y0();
            if (Q.getFid() == 0) {
                Q.setFid(dh.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = uj5.i(getContext(), Q, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            this.K0 = new PbFakeFloorModel(getPageContext());
            PbModel M = M();
            this.K0.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
            this.K0.setFromForumId(M.getFromForumId());
            sc8 sc8Var = new sc8(getPageContext(), this.K0, this.c);
            this.J0 = sc8Var;
            sc8Var.p(new y0(this));
            this.J0.s(this.z1);
            this.K0.b0(new z0(this));
        }
    }

    public boolean C3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (this.B0 != null && M() != null && M().l1() != null && !ThreadCardUtils.isSelf(M().l1().Q()) && M().l1().d() != null) {
                return this.B0.checkPrivacyBeforeSend(M().l1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void V4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            if (i2 == 0) {
                m09.g().h(getUniqueId(), false);
                if (j4() != null) {
                    y3(j4(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.V0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.V0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.V0) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public void W4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048659, this, z2) != null) || N() == null) {
            return;
        }
        if (this.p1 && !TbSingleton.getInstance().isNotchScreen(N()) && !TbSingleton.getInstance().isCutoutScreen(N())) {
            O5();
            UtilHelper.hideStatusBar(N(), N().getRootView());
            this.p1 = false;
        }
        this.t0.b = z2;
        Y4();
        b5();
    }

    public final void Y5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new q1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new r1(this));
        }
    }

    public final void Z5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new o1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new p1(this));
        }
    }

    public void c6(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z2) == null) {
            DetailInfoAndReplyFragment T3 = T3();
            if (T3 != null && T3.C1() != null && T3.C1().f() != null && T3.C1().g() != null) {
                T3.C1().f().u0(z2);
                T3.C1().g().G(z2);
            }
            MaskView maskView = this.A;
            if (maskView != null) {
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                maskView.setVisibility(i2);
            }
        }
    }

    public void o5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, editorTools) == null) {
            this.I0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0918ff);
            this.I0.setOnCancelClickListener(new f1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.I0.getParent() == null) {
                this.c.addView(this.I0, layoutParams);
            }
            this.I0.y(TbadkCoreApplication.getInst().getSkinType());
            this.I0.setActionListener(24, new g1(this));
            q4();
            this.H0.g(new h1(this));
        }
    }

    public final void v5(qd5 qd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048750, this, qd5Var) == null) && qd5Var != null && M() != null) {
            qd5Var.p(M().K0());
            if (M().l1() != null && M().l1().l() != null) {
                qd5Var.o(M().l1().l());
            }
            qd5Var.q("pb");
            qd5Var.r(M());
        }
    }

    public final void z5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048763, this, i2) != null) || M() == null) {
            return;
        }
        int u12 = M().u1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    M().Y2(1);
                } else {
                    M().Y2(4);
                }
            } else {
                M().Y2(3);
            }
        } else {
            M().Y2(2);
        }
        int u13 = M().u1();
        if (u12 == 4 || u13 == 4) {
            U4();
        }
    }

    public void C4(v98 v98Var) {
        n65 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, v98Var) == null) && this.U0 != null && v98Var != null && v98Var.g() != 3 && !G4()) {
            if (v98Var.r0()) {
                pbAdFloatViewItemData = v98Var.d0();
            } else {
                pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
            if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
                if (!RightFloatLayerView.k()) {
                    t4();
                    return;
                }
                if (this.V0 == null) {
                    this.V0 = RightFloatLayerLottieView.E(pbAdFloatViewItemData, getContext());
                    this.U0.removeAllViews();
                    this.U0.addView(this.V0);
                }
                if ((this.K.getTag() instanceof Boolean) && !((Boolean) this.K.getTag()).booleanValue()) {
                    this.V0.setAutoCompleteShown(false);
                    this.V0.setTag(this.K);
                    this.V0.c();
                }
                if (pbAdFloatViewItemData.a()) {
                    return;
                }
                this.V0.setData(pbAdFloatViewItemData);
                this.V0.setLogoListener(new g0(this, v98Var, pbAdFloatViewItemData));
                this.V0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
                return;
            }
            t4();
        }
    }

    public void F3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) {
            List<PostData> list = M().l1().V().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).d0().get(i3).O())) {
                        list.get(i2).d0().remove(i3);
                        list.get(i2).k();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).l(bVar.g);
            }
            if (z2) {
                if (T3() != null) {
                    T3().f2();
                } else if (J4() && k4() != null) {
                    k4().b2();
                }
            }
        }
    }

    public final boolean S4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s2 = p35.m().s("bubble_link", "");
            if (StringUtils.isNull(s2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                BrowserHelper.t(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean l5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (!TextUtils.isEmpty(postData.t()) && aw4.c().g()) {
                return S4(postData.O());
            }
            if (checkUpIsLogin() && M() != null && M().l1() != null) {
                sc8 sc8Var = this.J0;
                if (sc8Var != null) {
                    sc8Var.g();
                }
                la8 la8Var = new la8();
                la8Var.A(M().l1().l());
                la8Var.E(M().l1().Q());
                la8Var.C(postData);
                this.K0.c0(la8Var);
                this.K0.setPostId(postData.O());
                P4(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                od5 od5Var = this.H0;
                if (od5Var != null) {
                    r5(od5Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void D4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void F4() {
        int u2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.l == null) {
            this.l = new kh8(getBaseFragmentActivity(), this.j);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                u2 = 0;
            } else {
                u2 = ej.u(N());
            }
            Rect rect = new Rect(0, u2, ej.l(getContext()), this.j.getOriginHeight() + u2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (J4() && (videoPbViewModel.n() || M().E1() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || M().E1() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onDestroy();
            m09.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.F1);
            ItemCardHelper.w(null);
            u0().onDestory(getPageContext());
            gi8 gi8Var = this.j0;
            if (gi8Var != null) {
                gi8Var.k();
            }
            ForumManageModel forumManageModel = this.R;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ai8 ai8Var = this.k;
            if (ai8Var != null) {
                ai8Var.O0();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.B0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            vh8 vh8Var = this.N;
            if (vh8Var != null) {
                vh8Var.p0();
            }
            sc8 sc8Var = this.J0;
            if (sc8Var != null) {
                sc8Var.m();
            }
            if (M() != null) {
                M().cancelLoadData();
                M().destory();
                if (M().h1() != null) {
                    M().h1().d();
                }
            }
            od5 od5Var = this.H0;
            if (od5Var != null) {
                od5Var.D();
            }
            this.O = null;
            v19.d();
            R5();
        }
    }

    public final void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0919ae);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0919ad);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0919aa);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0919a9);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0919ac);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901ef);
            this.G.setRadius(ej.g(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new o45());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (M() != null && M().l1() != null) {
                H5(M().l1());
            }
        }
    }

    public final void D5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                vh8 vh8Var = this.N;
                if (vh8Var != null) {
                    vh8Var.M0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.bt5
    public void c0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048676, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.N.r0(str);
            l05 S = this.N.S();
            if (S == null) {
                this.N.X();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                S.f(1).setVisibility(8);
            } else {
                S.f(1).setVisibility(0);
            }
            S.m();
            this.Z = true;
        }
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (M().Q0() || M().T0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", M().F1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, M().F1()));
            if (U5()) {
                this.a.finish();
            }
        }
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || M() == null) {
            return;
        }
        v98 l12 = M().l1();
        M().e3(true);
        au4 au4Var = this.P;
        if (au4Var != null) {
            l12.L0(au4Var.g());
        }
        if (J4()) {
            if (U3() != null) {
                U3().N1();
            }
            if (k4() != null) {
                k4().b2();
            }
        } else if (T3() != null) {
            T3().f2();
        }
    }

    public final void W5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048660, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.J = ofFloat;
        ofFloat.addUpdateListener(new l1(this));
        this.J.setDuration(200L);
        this.J.start();
        this.J.addListener(new m1(this, layoutParams));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            super.onResume();
            this.S0 = false;
            u0().onResume(getPageContext());
            ai8 ai8Var = this.k;
            if (ai8Var != null) {
                ai8Var.onBackground(false);
            }
            L5();
            registerListener(this.f1);
            registerListener(this.g1);
            registerListener(this.e1);
            registerListener(this.E1);
            ItemCardHelper.w(this.H1);
            MessageManager.getInstance().registerListener(this.G1);
        }
    }

    public void E4() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            zi6 zi6Var = new zi6(getActivity());
            this.L0 = zi6Var;
            zi6Var.i(this.y1);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.o1 = z2;
            A4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0902af);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f0919b0);
            this.U0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091d5f);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09199e);
            ai8 ai8Var = new ai8(getContext(), this.j);
            this.k = ai8Var;
            ai8Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(N().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091f02)).setMinimumHeight(((int) Math.ceil((ej.l(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f0919b4);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f0919ab);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f0919b6);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f091136);
            this.A = (MaskView) this.c.findViewById(R.id.mask_view);
            this.h.setOnClickListener(this.B1);
            D4();
            z4();
            v4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f09273b);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090a1e);
            p5();
            this.K.setAnimationListener(new s0(this));
            x4();
            w4();
            if (!this.o1 && this.p1) {
                O5();
                UtilHelper.hideStatusBar(N(), N().getRootView());
                this.p1 = false;
            }
            if (!J4()) {
                this.d.getLayoutParams().height = 0;
            }
        }
    }

    @Override // com.baidu.tieba.hh8
    public void finish() {
        CardHListViewData q2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            PbModel H1 = this.a.H1();
            if (H1 != null && H1.l1() != null && H1.l1().Q() != null && !H1.l1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = H1.l1().Q().getId();
                if (H1.isShareThread() && H1.l1().Q().originalThreadData != null) {
                    historyMessage.threadName = H1.l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = H1.l1().Q().getTitle();
                }
                if (H1.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = H1.l1().l().getName();
                }
                ArrayList<PostData> H = H1.l1().H();
                if (k4() != null) {
                    i2 = k4().S1();
                } else {
                    i2 = 0;
                }
                if (H != null && i2 >= 0 && i2 < H.size()) {
                    historyMessage.postID = H.get(i2).O();
                }
                historyMessage.isHostOnly = H1.O0();
                historyMessage.isSquence = H1.D1();
                historyMessage.isShareThread = H1.isShareThread();
                historyMessage.threadType = H1.l1().Q().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            od5 od5Var = this.H0;
            if (od5Var != null) {
                od5Var.D();
            }
            if (H1 != null && (H1.Q0() || H1.T0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", H1.F1());
                if (this.x0) {
                    if (this.z0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", H1.Z0());
                    }
                    if (this.y0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", H1.V0());
                    }
                }
                if (H1.l1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = H1.l1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (U5()) {
                if (H1 != null) {
                    v98 l12 = H1.l1();
                    if (l12 != null) {
                        if (l12.X() != null) {
                            l12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            l12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.A0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                od8.b().t(rect);
                            }
                            od8.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView j4 = j4();
                            Parcelable parcelable = null;
                            if (j4 != null) {
                                parcelable = j4.onSaveInstanceState();
                            }
                            od8.b().n(H1.m1(), parcelable, H1.D1(), H1.O0(), false);
                        }
                    }
                } else {
                    od8.b().m();
                }
                T5();
            }
        }
    }

    public final void E5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    q95.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (M() != null && !M().Y0()) {
                antiData.setBlock_forum_name(M().l1().l().getName());
                antiData.setBlock_forum_id(M().l1().l().getId());
                antiData.setUser_name(M().l1().X().getUserName());
                antiData.setUser_id(M().l1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public void y3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048758, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().E(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.F());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((ea5) ListUtils.getItem(arrayList, 0)).e() == 1) {
                    if (!z2) {
                        X4((ea5) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                X4((ea5) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public void G3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.R.Z()) {
                    return;
                }
                showProgressBar();
                String str = (String) sparseArray.get(R.id.tag_del_post_id);
                int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                if (sparseArray.get(R.id.tag_is_block_thread) != null) {
                    z2 = ((Boolean) sparseArray.get(R.id.tag_is_block_thread)).booleanValue();
                } else {
                    z2 = false;
                }
                if (jSONArray != null) {
                    this.R.b0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.R.c0(M().l1().l().getId(), M().l1().l().getName(), M().l1().Q().getId(), str, intValue3, intValue2, booleanValue, M().l1().Q().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (M().G0() != null) {
                    M().G0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void O3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048627, this, i2, gVar) == null) && gVar != null && M() != null && M().l1() != null && M().l1().Q() != null) {
            N3(this.R.getLoadDataMode(), gVar.a, gVar.b, false);
            if (gVar.a) {
                this.x0 = true;
                if (i2 != 2 && i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        this.y0 = false;
                        this.z0 = true;
                    }
                } else {
                    this.y0 = true;
                    this.z0 = false;
                }
                if (i2 == 2) {
                    M().l1().Q().setIs_good(1);
                    M().R2(1);
                } else if (i2 == 3) {
                    M().l1().Q().setIs_good(0);
                    M().R2(0);
                } else if (i2 == 4) {
                    M().l1().Q().setIs_top(1);
                    M().S2(1);
                } else if (i2 == 5) {
                    M().l1().Q().setIs_top(0);
                    M().S2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                ej.Q(getPageContext().getPageActivity(), string);
            }
            if (J4()) {
                if (M().l1().Q() != null && U3() != null) {
                    U3().T1();
                }
            } else if (M().l1().Q() != null && T3() != null) {
                T3().m2();
            }
        }
    }

    public final void m4(int i2, Intent intent) {
        xb5 xb5Var;
        sc8 sc8Var;
        xb5 xb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048705, this, i2, intent) == null) {
            if (i2 == 0) {
                q4();
                sc8 sc8Var2 = this.J0;
                if (sc8Var2 != null) {
                    sc8Var2.g();
                }
                F5(false);
            }
            i5();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (!(serializableExtra instanceof PbEditorData)) {
                return;
            }
            PbEditorData pbEditorData = (PbEditorData) serializableExtra;
            WriteData writeData = new WriteData();
            writeData.setContent(pbEditorData.getContent());
            writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
            writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
            int editorType = pbEditorData.getEditorType();
            if (editorType != 0) {
                if (editorType == 1 && (sc8Var = this.J0) != null && sc8Var.f() != null) {
                    sd5 f2 = this.J0.f();
                    f2.d0(M().l1().Q());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    wb5 p2 = f2.b().p(6);
                    if (p2 != null && (xb5Var2 = p2.m) != null) {
                        xb5Var2.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.H0.L();
            this.H0.m0(pbEditorData.getVoiceModel());
            this.H0.B(writeData);
            wb5 p3 = this.H0.b().p(6);
            if (p3 != null && (xb5Var = p3.m) != null) {
                xb5Var.A(new lb5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.H0.G(null, null);
            }
        }
    }

    public void H3(j05 j05Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, j05Var, jSONArray) == null) {
            j05Var.dismiss();
            if (M() != null && M().l1() != null && M().l1().Q() != null && M().l1().l() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(j05Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    G3((SparseArray) j05Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void e5(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048685, this, z2, markData) != null) || M() == null) {
            return;
        }
        x5();
        M().e3(z2);
        au4 au4Var = this.P;
        if (au4Var != null) {
            au4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (M().W0()) {
            Q4();
        } else if (J4()) {
            if (U3() != null) {
                U3().N1();
            }
            if (k4() != null) {
                k4().b2();
            }
        } else if (T3() != null) {
            T3().f2();
        }
    }

    public void I3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                G3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void M3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048620, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                j05 j05Var = new j05(getPageContext().getPageActivity());
                j05Var.setMessage(string);
                j05Var.setPositiveButton(R.string.dialog_known, new r(this));
                j05Var.setCancelable(true);
                j05Var.create(getPageContext());
                j05Var.show();
            } else {
                N3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> H = M().l1().H();
                    int size = H.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(H.get(i2).O())) {
                            H.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    M().l1().Q().setReply_num(M().l1().Q().getReply_num() - 1);
                    if (T3() != null) {
                        T3().f2();
                    } else if (J4() && k4() != null) {
                        k4().b2();
                    }
                } else if (i3 == 0) {
                    E3();
                } else if (i3 == 2) {
                    ArrayList<PostData> H2 = M().l1().H();
                    int size2 = H2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= H2.get(i4).d0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i4).d0().get(i5).O())) {
                                H2.get(i4).d0().remove(i5);
                                H2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        H2.get(i4).l(bVar.g);
                    }
                    if (z3) {
                        if (T3() != null) {
                            T3().f2();
                        } else if (J4() && k4() != null) {
                            k4().b2();
                        }
                    }
                    F3(bVar);
                }
            }
        }
    }

    public void N3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f12fe));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d08);
                }
                showToast(str);
            }
        }
    }

    public final void N4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final String P3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0e96);
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
        return (String) invokeI.objValue;
    }

    public PostData V3(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, v98Var)) == null) {
            PostData postData = null;
            if (v98Var == null) {
                return null;
            }
            if (v98Var.a0() != null) {
                return v98Var.a0();
            }
            if (!ListUtils.isEmpty(v98Var.H())) {
                Iterator<PostData> it = v98Var.H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.F() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = v98Var.j();
            }
            if (postData == null) {
                postData = i4(v98Var);
            }
            if (postData != null && postData.r() != null && postData.r().getUserTbVipInfoData() != null && postData.r().getUserTbVipInfoData().getvipIntro() != null) {
                postData.r().getGodUserData().setIntro(postData.r().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void Z4(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, v98Var) != null) || v98Var == null) {
            return;
        }
        ThreadData Q = v98Var.Q();
        if (Q != null && Q.isUgcThreadType()) {
            x3();
        } else {
            v5(this.G0);
        }
        od5 od5Var = this.H0;
        if (od5Var != null) {
            r5(od5Var.y());
            this.H0.H(v98Var.d());
            this.H0.I(v98Var.l(), v98Var.X());
            this.H0.k0(Q);
            if (M() != null) {
                this.H0.J(M().N0(), M().F1(), M().J0());
            }
            if (Q != null) {
                this.H0.Z(Q.isMutiForumThread());
            }
        }
    }

    public void b6(v98 v98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, v98Var) == null) {
            if (v98Var != null && AntiHelper.o(v98Var.Q())) {
                gi8 gi8Var = this.j0;
                if (gi8Var != null) {
                    gi8Var.l(false);
                    this.j0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.i0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.i0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            gi8 gi8Var2 = this.j0;
            if (gi8Var2 != null && gi8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.i0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.i0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void d5(v98 v98Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, v98Var) == null) && v98Var != null && v98Var.Q() != null) {
            b6(v98Var);
            ImageView imageView = this.h0;
            if (v98Var.l0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (v98Var.r()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String P3 = P3(v98Var.Q().getReply_num());
            TextView textView = this.r0;
            if (textView != null) {
                textView.setText(P3);
            }
            TextView textView2 = this.s0;
            if (textView2 != null) {
                textView2.setText(P3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, v98Var.Q()));
        }
    }

    public final PostData i4(v98 v98Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048695, this, v98Var)) == null) {
            if (v98Var != null && v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = v98Var.Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = v98Var.Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.J0(1);
                postData.P0(v98Var.Q().getFirstPostId());
                postData.g1(v98Var.Q().getTitle());
                postData.f1(v98Var.Q().getCreateTime());
                postData.G0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            y4(bundle);
            u0().onCreate(getPageContext());
            u35 u35Var = new u35();
            this.O = u35Var;
            u35Var.a = 1000L;
            if (this.N != null) {
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
                userMuteAddAndDelCustomMessage.from = 1;
                BdUniqueId bdUniqueId = this.N.D;
                userMuteAddAndDelCustomMessage.mId = bdUniqueId;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
                BdUniqueId bdUniqueId2 = this.N.D;
                userMuteCheckCustomMessage.mId = bdUniqueId2;
                userMuteCheckCustomMessage.setTag(bdUniqueId2);
                MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            }
            registerListener(this.F1);
            this.t = new kc6(getPageContext());
            m09.g().i(getUniqueId());
        }
    }

    public void p4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) && this.c0 != null && this.f0 != null) {
            if (M() != null && M().l1() != null) {
                this.f0.setText(TbSingleton.getInstance().getAdVertiComment(M().l1().r0(), M().l1().s0(), l4()));
            } else {
                this.f0.setText(l4());
            }
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.c0.startAnimation(alphaAnimation);
            }
            this.b0.setVisibility(0);
            this.c0.setVisibility(0);
            this.t0.a = true;
        }
    }

    public final void w3(yh8 yh8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048751, this, yh8Var) == null) && yh8Var != null && this.w == null) {
            this.w = yh8Var;
            this.C.setText(yh8Var.getTitle());
            this.D.setText(yh8Var.k());
            String i2 = yh8Var.i();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(i2)) {
                i2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(i2);
            int i3 = 0;
            this.G.K(yh8Var.f(), 10, false);
            View view2 = this.H;
            if (!yh8Var.m()) {
                i3 = 8;
            }
            view2.setVisibility(i3);
            gh.a().postDelayed(new k1(this), yh8Var.c().longValue() * 1000);
        }
    }

    public final void P4(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048632, this, view2, str, str2, postData) != null) || view2 == null || str == null || str2 == null || z3() || !B3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.M0);
            this.N0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.J0 != null && postData != null) {
            if (postData.Z() != null) {
                str3 = postData.Z().toString();
            } else {
                str3 = "";
            }
            this.J0.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
        }
        if (M() != null && M().l1() != null && M().l1().l0()) {
            gh.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.D0 == null) {
            y17 y17Var = new y17(getPageContext());
            this.D0 = y17Var;
            y17Var.j(1);
            this.D0.i(new j1(this, str, str2));
        }
        if (M() != null && M().l1() != null && M().l1().l() != null) {
            this.D0.g(M().l1().l().getId(), dh.g(M().F1(), 0L));
        }
    }

    public final void Q5(PostData postData, PostData postData2, boolean z2, boolean z3) {
        String str;
        int i2;
        AbsPbActivity.e p2;
        boolean z4;
        boolean z5;
        PostData V3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String F1 = M().F1();
            String O = postData.O();
            if (postData2 != null) {
                str = postData2.O();
            } else {
                str = "";
            }
            if (M().l1() != null) {
                i2 = M().l1().Y();
            } else {
                i2 = 0;
            }
            if (k4() != null && k4().Z1() != null) {
                p2 = k4().Z1().p(O);
            } else if (T3() != null && T3().b2() != null) {
                p2 = T3().b2().p(O);
            } else {
                return;
            }
            AbsPbActivity.e eVar = p2;
            if (postData != null && M() != null && M().l1() != null && eVar != null) {
                if (W3() != 1 && W3() != 2 && W3() != 3 && W3() != 4 && W3() != 5) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(F1, O, "pb", true, G4(), null, false, str, i2, postData.g0(), M().l1().d(), false, postData.r().getIconInfo(), W3(), z4).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
                if (z3) {
                    addBigImageData.setHighLightPostId(str);
                    z5 = true;
                    addBigImageData.setKeyIsUseSpid(true);
                } else {
                    z5 = true;
                }
                addBigImageData.setKeyFromForumId(M().getForumId());
                addBigImageData.setTiebaPlusData(M().P(), M().L(), M().M(), M().K(), M().Q());
                addBigImageData.setBjhData(M().D0());
                addBigImageData.setKeyPageStartFrom(M().k1());
                addBigImageData.setFromFrsForumId(M().getFromForumId());
                addBigImageData.setWorksInfoData(M().K1());
                addBigImageData.setIsOpenEditor(z2);
                if (M().l1().o() != null) {
                    addBigImageData.setHasForumRule(M().l1().o().has_forum_rule.intValue());
                }
                if (M().l1().X() != null) {
                    addBigImageData.setIsManager(M().l1().X().getIs_manager());
                }
                if (M().l1().l().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (M().l1().l() != null) {
                    addBigImageData.setForumHeadUrl(M().l1().l().getImage_url());
                    addBigImageData.setUserLevel(M().l1().l().getUser_level());
                }
                if (M() != null && (V3 = V3(M().l1())) != null) {
                    if (!V3.S && !postData.S) {
                        z5 = false;
                    }
                    addBigImageData.setMainPostMaskVisibly(z5);
                }
                if (G4() && this.a.getIntent() != null) {
                    addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                }
                addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public SparseArray<Object> c4(v98 v98Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData V3;
        boolean z3;
        xx4 xx4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048678, this, new Object[]{v98Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (v98Var == null || (V3 = V3(v98Var)) == null) {
                return null;
            }
            String userId = V3.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, V3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(v98Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (V3.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, V3.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, V3.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, V3.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, V3.O());
                }
                sparseArray.put(R.id.tag_del_post_id, V3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(v98Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<sz4> p2 = v98Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (sz4 sz4Var : p2) {
                        if (sz4Var != null && !StringUtils.isNull(sz4Var.d()) && (xx4Var = sz4Var.f) != null && xx4Var.a && !xx4Var.c && ((i3 = xx4Var.b) == 1 || i3 == 2)) {
                            sb.append(dj.cutString(sz4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06b6));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d0), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void c5(boolean z2, int i2, int i3, int i4, v98 v98Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), v98Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof gh8) {
                    ((gh8) baseFragment).r1(z2, i2, i3, i4, v98Var, str, i5);
                }
            }
            r1(z2, i2, i3, i4, v98Var, str, i5);
        }
    }

    public void g5(la8 la8Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048691, this, la8Var) == null) && M() != null && M().l1() != null && la8Var.i() != null) {
            String O = la8Var.i().O();
            ArrayList<PostData> H = M().l1().H();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= H.size()) {
                    break;
                }
                PostData postData = H.get(i2);
                if (postData.O() != null && postData.O().equals(O)) {
                    ArrayList<PostData> k2 = la8Var.k();
                    postData.d1(la8Var.m());
                    if (postData.d0() != null && k2 != null) {
                        Iterator<PostData> it = k2.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.l0() != null && next != null && next.r() != null && (metaData = postData.l0().get(next.r().getUserId())) != null) {
                                next.G0(metaData);
                                next.T0(true);
                                next.m1(getPageContext(), M().g2(metaData.getUserId()));
                            }
                        }
                        if (k2.size() != postData.d0().size()) {
                            z3 = true;
                        }
                        if (!postData.s0(true)) {
                            postData.d0().clear();
                            postData.d0().addAll(k2);
                        }
                        z2 = z3;
                    }
                    if (postData.z() != null) {
                        postData.E0();
                    }
                } else {
                    i2++;
                }
            }
            if (!M().U0() && z2) {
                if (J4() && k4() != null) {
                    k4().b2();
                } else if (T3() != null) {
                    T3().f2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f090718));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            Z4(videoPbViewModel.c());
            C4(videoPbViewModel.c());
            f5(videoPbViewModel.c());
            if (M() != null && M().l1() != null) {
                boolean U0 = M().U0();
                v98 l12 = M().l1();
                if (U0) {
                    PostData V3 = V3(l12);
                    if (l12.v() != null && !l12.v().equals(V3.O()) && this.e != null) {
                        if (J4()) {
                            this.e.setCurrentItem(1);
                        } else {
                            this.e.setCurrentItem(0);
                        }
                    }
                }
            }
            videoPbViewModel.k().observe(this, new f0(this));
            videoPbViewModel.b().observe(this, new h0(this));
            videoPbViewModel.j().observe(this, new i0(this));
            videoPbViewModel.h().observe(this, new j0(this));
            videoPbViewModel.e().observe(this, new k0(this));
            videoPbViewModel.f().observe(this, new l0(this));
            this.a.J1().d(this.T0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v3(ThreadData threadData) {
        double d3;
        int ceil;
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, threadData) == null) {
            double l2 = ej.l(getContext());
            double j2 = (2.0d * l2) / ej.j(getContext());
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                int intValue = threadData.getThreadVideoInfo().video_width.intValue();
                int intValue2 = threadData.getThreadVideoInfo().video_height.intValue();
                if (intValue2 > 0) {
                    d3 = (intValue * 1.0f) / intValue2;
                    if (d3 > 1.7777777777777777d) {
                        d3 = 1.7777777777777777d;
                    }
                    if (d3 >= j2) {
                        j2 = d3;
                    }
                    ceil = (int) Math.ceil(l2 / j2);
                    if (M() == null && (C0 = M().C0()) != null) {
                        i2 = C0.height();
                    } else {
                        i2 = ceil;
                    }
                    i3 = 0;
                    layoutParams = this.j.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, i2);
                    } else {
                        i3 = layoutParams.height - i2;
                        layoutParams.height = i2;
                    }
                    this.j.setLayoutParams(layoutParams);
                    this.j.setMaxHeight(ceil);
                    this.j.setMinHeight((int) Math.ceil(l2 / 1.7777777777777777d));
                    this.j.setOriginHeight(i2);
                    if (J4()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, M1);
                        } else {
                            layoutParams3.height = M1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (J4()) {
                        ceil += M1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                    }
                    this.i.setLayoutParams(layoutParams2);
                    if (i3 == 0 && (this.i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.i.getLayoutParams()).getBehavior();
                        if (behavior instanceof VideoZoomBehavior) {
                            ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i3);
                            return;
                        }
                        return;
                    }
                }
            }
            d3 = 1.7777777777777777d;
            if (d3 > 1.7777777777777777d) {
            }
            if (d3 >= j2) {
            }
            ceil = (int) Math.ceil(l2 / j2);
            if (M() == null) {
            }
            i2 = ceil;
            i3 = 0;
            layoutParams = this.j.getLayoutParams();
            if (layoutParams != null) {
            }
            this.j.setLayoutParams(layoutParams);
            this.j.setMaxHeight(ceil);
            this.j.setMinHeight((int) Math.ceil(l2 / 1.7777777777777777d));
            this.j.setOriginHeight(i2);
            if (J4()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (J4()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i3 == 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n4(boolean z2) {
        v98 l12;
        int i2;
        gi8 gi8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048707, this, z2) == null) && M() != null && this.N != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (l12 = M().l1()) == null) {
                return;
            }
            ThreadData Q = l12.Q();
            int i3 = 1;
            if (Q != null && Q.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", M().F1()).param("fid", l12.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (G4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", M().getForumId());
                    statisticItem.param("tid", M().F1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", X3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 14);
                    statisticItem.param("obj_locate", W3());
                    TiebaStatic.log(statisticItem);
                }
            }
            if (Q != null) {
                if (Q.isBJHArticleThreadType()) {
                    i2 = 2;
                } else if (Q.isBJHVideoThreadType()) {
                    i2 = 3;
                } else if (Q.isBJHNormalThreadType()) {
                    i2 = 4;
                } else if (Q.isBJHVideoDynamicThreadType()) {
                    i2 = 5;
                }
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", M().F1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", M().getForumId());
                if (!z2) {
                    statisticItem2.param("obj_locate", 6);
                } else {
                    statisticItem2.param("obj_locate", 5);
                }
                statisticItem2.param("obj_name", i2);
                statisticItem2.param("obj_type", 2);
                if (Q != null) {
                    if (Q.isBJHArticleThreadType()) {
                        statisticItem2.param("obj_type", 10);
                    } else if (Q.isBJHVideoThreadType()) {
                        statisticItem2.param("obj_type", 9);
                    } else if (Q.isBJHVideoDynamicThreadType()) {
                        statisticItem2.param("obj_type", 8);
                    } else if (Q.isBJHNormalThreadType()) {
                        statisticItem2.param("obj_type", 7);
                    } else if (Q.isShareThread) {
                        statisticItem2.param("obj_type", 6);
                    } else {
                        int i4 = Q.threadType;
                        if (i4 == 0) {
                            statisticItem2.param("obj_type", 1);
                        } else if (i4 == 40) {
                            statisticItem2.param("obj_type", 2);
                        } else if (i4 == 49) {
                            statisticItem2.param("obj_type", 3);
                        } else if (i4 == 54) {
                            statisticItem2.param("obj_type", 4);
                        } else {
                            statisticItem2.param("obj_type", 5);
                        }
                    }
                    statisticItem2.param("nid", Q.getNid());
                    statisticItem2.param("card_type", Q.getRecomCardType());
                    statisticItem2.param("recom_source", Q.mRecomSource);
                    statisticItem2.param("ab_tag", Q.mRecomAbTag);
                    statisticItem2.param("weight", Q.mRecomWeight);
                    statisticItem2.param("extra", Q.mRecomExtra);
                    statisticItem2.param("nid", Q.getNid());
                    if (Q.getBaijiahaoData() != null && !dj.isEmpty(Q.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, Q.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (N() != null) {
                    uj5.e(N(), statisticItem2);
                }
                gi8Var = this.j0;
                if (gi8Var != null) {
                    statisticItem2.param("obj_param1", gi8Var.g());
                }
                TiebaStatic.log(statisticItem2);
                if (ej.F()) {
                    showToast(R.string.obfuscated_res_0x7f0f0d08);
                    return;
                } else if (M().l1() == null) {
                    ej.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                    return;
                } else {
                    ArrayList<PostData> H = l12.H();
                    if ((H == null || H.size() <= 0) && M().D1()) {
                        ej.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0eae));
                        return;
                    }
                    this.N.G();
                    S5();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), Q)) {
                        return;
                    }
                    gi8 gi8Var2 = this.j0;
                    if (gi8Var2 != null) {
                        gi8Var2.l(false);
                        b6(l12);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.j0.i()) {
                            this.j0.m(false);
                            u4(f95.a(), this.j0.g());
                            return;
                        }
                        K5(i3);
                        return;
                    }
                    this.N.D0();
                    M().F0().I(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", M().F1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", M().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (Q != null) {
            }
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (N() != null) {
            }
            gi8Var = this.j0;
            if (gi8Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (ej.F()) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            qv4 layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 1) {
                z2 = false;
            }
            layoutMode.l(z2);
            getBaseFragmentActivity().getLayoutMode().k(this.c);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            ce8 ce8Var = this.E0;
            if (ce8Var != null) {
                ce8Var.i();
            }
            kh8 kh8Var = this.l;
            if (kh8Var == null || !kh8Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.I0;
            if (editorTools != null) {
                editorTools.y(i2);
            }
            sc8 sc8Var = this.J0;
            if (sc8Var != null) {
                sc8Var.l(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.V0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.n();
            }
            LinearLayout linearLayout = this.d0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (M() != null && M().W0()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.g0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (M() != null) {
                b6(M().l1());
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.r0, ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (T3() != null) {
                T3().onChangeSkinType(i2);
            } else if (J4() && k4() != null) {
                k4().onChangeSkinType(i2);
            }
            if (U3() != null) {
                U3().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.g(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            S5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ai8 ai8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048719, this, i2, keyEvent)) == null) {
            if (!this.o1 && (this.p1 || K4())) {
                O5();
                UtilHelper.hideStatusBar(N(), N().getRootView());
                this.p1 = false;
                ai8 ai8Var2 = this.k;
                if (ai8Var2 != null) {
                    ai8Var2.S0(false);
                }
            }
            if (i2 == 4) {
                ai8 ai8Var3 = this.k;
                if (ai8Var3 == null) {
                    return false;
                }
                return ai8Var3.onBackPress();
            } else if (i2 == 24) {
                ai8 ai8Var4 = this.k;
                if (ai8Var4 == null) {
                    return false;
                }
                return ai8Var4.onVolumeUp();
            } else if (i2 != 25 || (ai8Var = this.k) == null) {
                return false;
            } else {
                return ai8Var.P0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final void u3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048742, this, z2, str) == null) && M() != null && M().l1() != null && M().l1().Q() != null) {
            ThreadData Q = M().l1().Q();
            Q.mRecomAbTag = M().q1();
            Q.mRecomWeight = M().t1();
            Q.mRecomSource = M().s1();
            Q.mRecomExtra = M().r1();
            if (Q.getFid() == 0) {
                Q.setFid(dh.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = uj5.i(getContext(), Q, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = uj5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (Q.isVideoThreadType()) {
                    if (rp5.f(str) > 40) {
                        str2 = rp5.n(str, 40);
                    } else {
                        str2 = str;
                    }
                    i2.param(TiebaStatic.Params.POST_CONTENT, str2);
                }
                i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
                if (z2) {
                    i2.addParam("obj_type", 2);
                } else {
                    i2.addParam("obj_type", 1);
                }
                pj5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (W3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (W3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (W3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (W3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (W3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", M().F1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", M().l1().m());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = uj5.i(getContext(), Q, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", M().F1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", M().l1().m());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = uj5.i(getContext(), Q, "c14303");
            if (i4 != null) {
                if (W3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (W3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (W3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (W3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", M().F1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", M().l1().m());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }

    public final void y4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bundle) == null) {
            qd5 qd5Var = new qd5();
            this.G0 = qd5Var;
            v5(qd5Var);
            od5 od5Var = (od5) this.G0.a(getActivity());
            this.H0 = od5Var;
            od5Var.W(this.a.getPageContext());
            this.H0.f0(this.i1);
            this.H0.g0(this.A1);
            this.H0.Y(1);
            this.H0.d0(SendView.f);
            this.H0.h(SendView.f);
            this.H0.A(this.a.getPageContext(), bundle);
            this.H0.b().b(new vb5(getActivity()));
            this.H0.b().E(true);
            C5(true);
            if (M() != null) {
                this.H0.J(M().N0(), M().F1(), M().J0());
            }
            registerListener(this.a1);
            registerListener(this.c1);
            registerListener(this.k1);
            registerListener(this.Z0);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.I1);
            if (!M().Y0()) {
                this.H0.q(M().F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.H0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().W1()) {
                this.H0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.H0.c0(l4());
            }
            this.E0 = new ce8();
            if (this.H0.s() != null) {
                this.E0.m(this.H0.s().i());
            }
            this.H0.V(this.Y0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.B0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }
}
