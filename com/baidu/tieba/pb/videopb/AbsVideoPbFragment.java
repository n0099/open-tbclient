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
import com.baidu.tieba.aj8;
import com.baidu.tieba.aq5;
import com.baidu.tieba.b05;
import com.baidu.tieba.b75;
import com.baidu.tieba.bc9;
import com.baidu.tieba.br5;
import com.baidu.tieba.ca5;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.d95;
import com.baidu.tieba.da9;
import com.baidu.tieba.dm8;
import com.baidu.tieba.dq5;
import com.baidu.tieba.ek5;
import com.baidu.tieba.fv4;
import com.baidu.tieba.gg;
import com.baidu.tieba.gi;
import com.baidu.tieba.gt4;
import com.baidu.tieba.h55;
import com.baidu.tieba.hi;
import com.baidu.tieba.hl8;
import com.baidu.tieba.i09;
import com.baidu.tieba.iz4;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jg;
import com.baidu.tieba.k65;
import com.baidu.tieba.kd5;
import com.baidu.tieba.ke6;
import com.baidu.tieba.ki8;
import com.baidu.tieba.kq8;
import com.baidu.tieba.l45;
import com.baidu.tieba.lb5;
import com.baidu.tieba.ld5;
import com.baidu.tieba.lj8;
import com.baidu.tieba.lo8;
import com.baidu.tieba.m35;
import com.baidu.tieba.mb5;
import com.baidu.tieba.mb9;
import com.baidu.tieba.ml6;
import com.baidu.tieba.mm8;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mp8;
import com.baidu.tieba.n85;
import com.baidu.tieba.nd5;
import com.baidu.tieba.nq8;
import com.baidu.tieba.nx4;
import com.baidu.tieba.o95;
import com.baidu.tieba.od5;
import com.baidu.tieba.oo8;
import com.baidu.tieba.oq8;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbCommentFloatActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pq8;
import com.baidu.tieba.pv4;
import com.baidu.tieba.qd5;
import com.baidu.tieba.qh8;
import com.baidu.tieba.qj9;
import com.baidu.tieba.r35;
import com.baidu.tieba.rb9;
import com.baidu.tieba.rm8;
import com.baidu.tieba.sb5;
import com.baidu.tieba.sd5;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.um8;
import com.baidu.tieba.uo5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.vb5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.festivalview.FestivalTipView;
import com.baidu.tieba.vp8;
import com.baidu.tieba.vq8;
import com.baidu.tieba.vt5;
import com.baidu.tieba.wa5;
import com.baidu.tieba.wb5;
import com.baidu.tieba.wp5;
import com.baidu.tieba.wp8;
import com.baidu.tieba.x75;
import com.baidu.tieba.xb5;
import com.baidu.tieba.xf;
import com.baidu.tieba.xs4;
import com.baidu.tieba.yf;
import com.baidu.tieba.yp4;
import com.baidu.tieba.yt5;
import com.baidu.tieba.z8;
import com.baidu.tieba.zj5;
import com.baidu.tieba.zo5;
import com.baidu.tieba.zp4;
import com.baidu.tieba.zp8;
import com.baidu.tieba.zz4;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements yt5, VoiceManager.j, wp8, TbRichTextView.u, vp8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int J1;
    public static final int K1;
    public static int L1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public View.OnClickListener A1;
    public View.OnClickListener B;
    public ReplyPrivacyCheckController B0;
    public final AdapterView.OnItemClickListener B1;
    public TextView C;
    public rm8 C0;
    public CustomMessageListener C1;
    public TextView D;
    public PermissionJudgePolicy D0;
    public CustomMessageListener D1;
    public ImageView E;
    public qd5 E0;
    public CustomMessageListener E1;
    public TBSpecificationBtn F;
    public od5 F0;
    public final ItemCardHelper.c F1;
    public TbImageView G;
    public EditorTools G0;
    public CustomMessageListener G1;
    public View H;
    public hl8 H0;
    public final View.OnLongClickListener H1;
    public ValueAnimator I;
    public PbFakeFloorModel I0;
    public SortSwitchButton.f I1;
    public ValueAnimator J;
    public ml6 J0;
    public PbFallingView K;
    public int[] K0;
    public boolean L;
    public int L0;
    public View M;
    public int M0;
    public kq8 N;
    public int N0;
    public r35 O;
    public int O0;
    public xs4 P;
    public int P0;
    public n85 Q;
    public boolean Q0;
    public ForumManageModel R;
    @NonNull
    public TiePlusEventController.g R0;
    public VoiceManager S;
    public FrameLayout S0;
    public xf<GifView> T;
    public RightFloatLayerView T0;
    public xf<TextView> U;
    public final PbModel.h U0;
    public xf<ImageView> V;
    public final xs4.a V0;
    public xf<View> W;
    public kd5 W0;
    public xf<LinearLayout> X;
    public final CustomMessageListener X0;
    public xf<RelativeLayout> Y;
    public CustomMessageListener Y0;
    public boolean Z;
    public final CustomMessageListener Z0;
    public AbsPbActivity a;
    public LinearLayout a0;
    public CustomMessageListener a1;
    public long b;
    public View b0;
    public HttpMessageListener b1;
    public RelativeLayout c;
    public View c0;
    public CustomMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public LinearLayout d0;
    public CustomMessageListener d1;
    public CustomViewPager e;
    public ImageView e0;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public TextView f0;
    public kd5 f1;
    public View g;
    public ImageView g0;
    public final NewWriteModel.d g1;
    public View h;
    public ImageView h0;
    public View.OnClickListener h1;
    public AppBarLayout i;
    public ImageView i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public vq8 j0;
    public int j1;
    public pq8 k;
    public float k1;
    public zp8 l;
    public float l1;
    public NavigationBar m;
    public boolean m1;
    public View n;
    public boolean n1;
    public View o;
    public View.OnTouchListener o1;
    public View p;
    public GestureDetector p1;
    public ImageView q;
    public GestureDetector.SimpleOnGestureListener q1;
    public View r;
    public TextView r0;
    public Runnable r1;
    public ImageView s;
    public TextView s0;
    public ObjectAnimator s1;
    public ke6 t;
    public c2 t0;
    public ObjectAnimator t1;
    public boolean u;
    public String u0;
    public final z8 u1;
    public View v;
    public boolean v0;
    public View.OnTouchListener v1;
    public nq8 w;
    public String w0;
    public final ml6.b w1;
    public View x;
    public boolean x0;
    public NewWriteModel.d x1;
    public View y;
    public boolean y0;
    public ld5 y1;
    public View z;
    public boolean z0;
    public final View.OnClickListener z1;

    @Override // com.baidu.tieba.wp8
    public AbsVideoPbFragment D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<TiebaPlusRecommendCard> D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract boolean I4();

    public abstract boolean K4();

    @Override // com.baidu.tieba.yt5
    public xf<FestivalTipView> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void X(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048659, this, context, str) == null) {
        }
    }

    public abstract int Y3();

    public abstract int a4();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048684, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048690, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.yt5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public final int j4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048700, this, i2)) == null) {
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

    @Override // com.baidu.tieba.yt5
    public xf<ItemCardView> n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            return null;
        }
        return (xf) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vp8
    public void s1(boolean z2, int i2, int i3, int i4, ki8 ki8Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048735, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ki8Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    public abstract void v5(boolean z2);

    @Override // com.baidu.tieba.wp8
    public PbFragment w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
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
                    this.b.a.Y4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) == null) {
                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.L() != null && this.a.L().w1() != null) {
                        statisticItem.param("fid", this.a.L().w1().m());
                    }
                    statisticItem.param("tid", this.a.L().Q1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.T5();
                this.a.x5(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    h55.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.L() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.L().E0(postWriteCallBackData.getPostId());
                        if (this.a.L4() && this.a.m4() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.O0 = absVideoPbFragment.m4().U1();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.P0 = absVideoPbFragment2.m4().V1();
                            this.a.L().Z2(this.a.O0, this.a.P0);
                        } else if (this.a.V3() != null) {
                            AbsVideoPbFragment absVideoPbFragment3 = this.a;
                            absVideoPbFragment3.O0 = absVideoPbFragment3.V3().W1();
                            AbsVideoPbFragment absVideoPbFragment4 = this.a;
                            absVideoPbFragment4.P0 = absVideoPbFragment4.V3().X1();
                            this.a.L().Z2(this.a.O0, this.a.P0);
                        }
                    }
                    if (this.a.e != null) {
                        if (this.a.L4()) {
                            this.a.e.setCurrentItem(1);
                        } else {
                            this.a.e.setCurrentItem(0);
                        }
                    }
                    this.a.N.G();
                    this.a.C0.c();
                    if (this.a.F0 != null) {
                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                        absVideoPbFragment5.s5(absVideoPbFragment5.F0.y());
                    }
                    this.a.s4();
                    this.a.G5(true);
                    this.a.L().b2();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.F5(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (this.a.L4() && this.a.m4() != null) {
                                this.a.m4().d2();
                            } else if (this.a.V3() != null) {
                                this.a.V3().h2();
                            }
                        }
                    } else if (this.a.L().Z0()) {
                        ki8 w1 = this.a.L().w1();
                        if (w1 != null && w1.Q() != null && w1.Q().getAuthor() != null && (userId = w1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.L().r3()) {
                            this.a.z5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.L().r3()) {
                        this.a.z5();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    absVideoPbFragment6.w3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.F0.x() || this.a.F0.z()) {
                        this.a.F0.w(false, postWriteCallBackData);
                    }
                    this.a.C0.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.B0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    zz4 zz4Var = new zz4(this.a.getActivity());
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        zz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        zz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new b(this));
                    zz4Var.setPositiveButton(R.string.open_now, new c(this));
                    zz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (x75Var != null || i == 227001) {
                } else {
                    this.a.E5(i, antiData, str);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes5.dex */
        public class a implements TextWatcher {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h1 a;

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

            public a(h1 h1Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h1Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = h1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                rm8 rm8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (rm8Var = this.a.c.C0) != null && rm8Var.g() != null) {
                    if (!this.a.c.C0.g().e()) {
                        this.a.c.C0.b(false);
                    }
                    this.a.c.C0.g().l(false);
                }
            }
        }

        public h1(AbsVideoPbFragment absVideoPbFragment, String str, String str2) {
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
                int j = hi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.K0[1] + absVideoPbFragment.L0) - i2;
                if (absVideoPbFragment.l4() != null) {
                    this.c.l4().smoothScrollBy(0, i3);
                }
                if (this.c.H0 != null) {
                    this.c.F0.b().setVisibility(8);
                    this.c.H0.t(this.a, this.b, this.c.n4(), (this.c.L() == null || this.c.L().w1() == null || this.c.L().w1().Q() == null || !this.c.L().w1().Q().isBjh()) ? false : false);
                    this.c.H0.q(this.c.Y3());
                    sd5 f = this.c.H0.f();
                    if (f != null && this.c.L() != null && this.c.L().w1() != null) {
                        f.H(this.c.L().w1().d());
                        f.d0(this.c.L().w1().Q());
                    }
                    if (this.c.C0.f() == null && this.c.H0.f().u() != null) {
                        this.c.H0.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.C0.n(absVideoPbFragment2.H0.f().u().i());
                        this.c.H0.f().N(this.c.f1);
                    }
                }
                this.c.q4();
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
                rm8 rm8Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (rm8Var = this.a.c.C0) != null && rm8Var.g() != null) {
                    if (!this.a.c.C0.g().e()) {
                        this.a.c.C0.b(false);
                    }
                    this.a.c.C0.g().l(false);
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
                int j = hi.j(this.c.getContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = hi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.K0[1] + absVideoPbFragment.L0) - i2;
                if (absVideoPbFragment.l4() != null) {
                    this.c.l4().smoothScrollBy(0, i3);
                }
                if (this.c.H0 != null) {
                    this.c.F0.b().setVisibility(8);
                    this.c.H0.t(this.a, this.b, this.c.n4(), (this.c.L() == null || this.c.L().w1() == null || this.c.L().w1().Q() == null || !this.c.L().w1().Q().isBjh()) ? false : false);
                    this.c.H0.q(this.c.Y3());
                    sd5 f = this.c.H0.f();
                    if (f != null && this.c.L() != null && this.c.L().w1() != null) {
                        f.H(this.c.L().w1().d());
                        f.d0(this.c.L().w1().Q());
                    }
                    if (this.c.C0.f() == null && this.c.H0.f().u() != null) {
                        this.c.H0.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.C0.n(absVideoPbFragment2.H0.f().u().i());
                        this.c.H0.f().N(this.c.f1);
                    }
                }
                this.c.q4();
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
                    this.b.a.Y4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements zz4.e {
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

            @Override // com.baidu.tieba.zz4.e
            public void onClick(zz4 zz4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                    zz4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x75 x75Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, x75Var, writeData, antiData}) == null) {
                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.L() != null && this.a.L().w1() != null) {
                        statisticItem.param("fid", this.a.L().w1().m());
                    }
                    if (this.a.L() != null) {
                        statisticItem.param("tid", this.a.L().Q1());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    h55.b(writeData.getContent(), "4");
                }
                if (z) {
                    rm8 rm8Var = this.a.C0;
                    if (rm8Var != null) {
                        rm8Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        o95.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        jg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
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
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    zz4 zz4Var = new zz4(this.a.getActivity());
                    if (gi.isEmpty(postWriteCallBackData.getErrorString())) {
                        zz4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        zz4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new b(this));
                    zz4Var.setPositiveButton(R.string.open_now, new c(this));
                    zz4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.C0 != null) {
                        if (absVideoPbFragment.H0 != null && this.a.H0.f() != null && this.a.H0.f().y()) {
                            this.a.H0.f().w(postWriteCallBackData);
                        }
                        this.a.C0.l(postWriteCallBackData);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.Q0) {
                return;
            }
            this.a.M5();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements zo5<ShareItem> {
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
        @Override // com.baidu.tieba.zo5
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
    public class a2 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a2(AbsVideoPbFragment absVideoPbFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.L() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (this.a.F0 != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.s5(absVideoPbFragment.F0.y());
                }
                this.a.j5();
                this.a.N.G();
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
            this.a.b6();
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
            kq8 kq8Var = this.a.N;
            if (kq8Var != null) {
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
                    kq8Var.h0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                kq8 kq8Var = this.a.N;
                if (kq8Var != null) {
                    kq8Var.G();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.L() != null && !this.a.L().isLoading) {
                    this.a.T5();
                    this.a.z5();
                    z = true;
                    if (this.a.L().w1() != null && this.a.L().w1().f != null && this.a.L().w1().f.size() > i) {
                        int intValue = this.a.L().w1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.L().R1()).param("fid", this.a.L().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.L().u3(intValue)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                qh8 qh8Var = (qh8) customResponsedMessage.getData();
                int type = qh8Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (qh8Var.a() == null) {
                                this.a.f5(false, null);
                                return;
                            } else {
                                this.a.f5(true, (MarkData) qh8Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.O3((ForumManageModel.b) qh8Var.a(), false);
                    return;
                }
                this.a.h5((aj8) qh8Var.a());
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
                    this.a.A5(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1f);
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
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.L() != null && this.a.L().F1() != i + 1) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.n5(absVideoPbFragment.j4(i));
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
        public void b(ki8 ki8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ki8Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, ki8 ki8Var, String str, int i4) {
            String n4;
            sb5 o;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ki8Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09076e));
                }
                this.a.y5();
                this.a.u4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.G5(false);
                if (z && ki8Var != null) {
                    ThreadData Q = ki8Var.Q();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(ki8Var, i2);
                    this.a.a5(ki8Var);
                    this.a.I5(ki8Var);
                    this.a.g5(ki8Var);
                    this.a.d5(z, i, i2, i3, ki8Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(ki8Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(ki8Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(ki8Var.X().getBimg_end_time());
                    if (ki8Var.H() != null && ki8Var.H().size() >= 1 && ki8Var.H().get(0) != null) {
                        this.a.L().a3(ki8Var.H().get(0).O());
                    } else if (ki8Var.a0() != null) {
                        this.a.L().a3(ki8Var.a0().O());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(ki8Var.r());
                    }
                    AntiData d = ki8Var.d();
                    if (d != null) {
                        this.a.w0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.w0) && this.a.F0 != null && this.a.F0.b() != null && (o = this.a.F0.b().o(6)) != null && !TextUtils.isEmpty(this.a.w0)) {
                            ((View) o).setOnClickListener(this.a.h1);
                        }
                    }
                    if (this.a.B0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.B0.setLikeUserData(attentionHostData);
                    }
                    this.a.E4(ki8Var);
                    if (this.a.L() != null && this.a.L().h2()) {
                        n4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        n4 = this.a.n4();
                    }
                    if (!StringUtils.isNull(n4)) {
                        this.a.F0.c0(TbSingleton.getInstance().getAdVertiComment(ki8Var.r0(), ki8Var.s0(), n4));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.L().Q1());
                            jSONObject.put("fid", this.a.L().getForumId());
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
                    if ((this.a.L4() && this.a.m4() == null) || this.a.V3() == null) {
                        return;
                    }
                    ArrayList<bc9> arrayList = null;
                    if (this.a.L4()) {
                        if (i != -1) {
                            if (this.a.L() != null && this.a.L().w1() != null) {
                                arrayList = this.a.L().w1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).E() != 1)) {
                                this.a.m4().k2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.m4().e2()) {
                                this.a.m4().l2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ec9));
                            } else {
                                this.a.m4().l2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eca));
                            }
                        } else {
                            this.a.m4().k2("");
                        }
                        this.a.m4().R1();
                    } else {
                        if (i != -1) {
                            if (this.a.L() != null && this.a.L().w1() != null) {
                                arrayList = this.a.L().w1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).E() != 1)) {
                                this.a.V3().r2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.V3().i2()) {
                                this.a.V3().s2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ec9));
                            } else {
                                this.a.V3().s2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0eca));
                            }
                        } else {
                            this.a.V3().r2("");
                        }
                        this.a.V3().T1();
                    }
                }
                da9.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public c2(AbsVideoPbFragment absVideoPbFragment) {
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

        public /* synthetic */ c2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof qj9) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                qj9 qj9Var = (qj9) customResponsedMessage.getData();
                this.a.N.W();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.P();
                DataRes dataRes = qj9Var.a;
                boolean z = false;
                if (qj9Var.c == 0 && dataRes != null) {
                    int e = gg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (gi.isEmpty(str)) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vt5.a)) {
                vt5.a aVar = (vt5.a) customResponsedMessage.getData();
                vt5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
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
                kq8 kq8Var = this.a.N;
                if (tag == kq8Var.D) {
                    kq8Var.W();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    ki8 w1 = this.a.L().w1();
                    if (w1 != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.setUserId(str);
                        w1.w().add(muteUser);
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
                        if (gi.isEmpty(errorString2)) {
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
            rb9 rb9Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rb9) && (rb9Var = (rb9) customResponsedMessage.getData()) != null && (agreeData = rb9Var.b) != null && agreeData.agreeType == 2 && this.a.j0 != null && this.a.L() != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !lo8.k(this.a.L().Q1())) {
                this.a.j0.o(2);
                lo8.b(this.a.L().Q1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e1 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j5();
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
                kq8 kq8Var = this.a.N;
                if (tag == kq8Var.D) {
                    kq8Var.W();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.O.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (gi.isEmpty(muteMessage)) {
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
            pq8 pq8Var;
            BdTypeRecyclerView l4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null && (pq8Var = this.a.k) != null) {
                if (pq8Var.f0() != null && this.a.k.f0().equals(threadData.getThreadVideoInfo().video_url)) {
                    this.a.k.setData(threadData);
                    return;
                }
                boolean z = true;
                if (!gi.isEmpty(this.a.k.f0())) {
                    this.a.A0 = true;
                    if (this.a.L4()) {
                        this.a.e.setCurrentItem(0);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                    if (!this.a.L4() && (l4 = this.a.l4()) != null) {
                        l4.scrollToPosition(0);
                    }
                }
                if (this.a.l == null || !this.a.l.k()) {
                    this.a.k5();
                    this.a.x3(threadData);
                }
                this.a.H4();
                if (this.a.l != null && this.a.l.l()) {
                    this.a.l.s();
                }
                boolean z2 = !StringHelper.equals(this.a.k.f0(), threadData.getThreadVideoInfo().video_url);
                this.a.k.setData(threadData);
                if (this.a.L4()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    pq8 pq8Var2 = absVideoPbFragment.k;
                    if (absVideoPbFragment.e.getCurrentItem() != 0) {
                        z = false;
                    }
                    pq8Var2.Y0(z);
                } else {
                    this.a.k.Y0(false);
                }
                if (z2) {
                    this.a.k.startPlay();
                    this.a.k.A0();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f1 implements mb5 {
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

        @Override // com.baidu.tieba.mb5
        public void C(lb5 lb5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) {
                Object obj = lb5Var.c;
                if ((obj instanceof b75) && EmotionGroupType.isSendAsPic(((b75) obj).getType())) {
                    if (this.a.D0 == null) {
                        this.a.D0 = new PermissionJudgePolicy();
                    }
                    this.a.D0.clearRequestPermissionList();
                    this.a.D0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.D0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.F0.f((b75) lb5Var.c);
                    this.a.F0.w(false, null);
                }
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
                rm8 rm8Var = this.a.C0;
                if (rm8Var != null && rm8Var.g() != null && this.a.C0.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.C0.g().c());
                    if (this.a.H0 != null && this.a.H0.f() != null && this.a.H0.f().y()) {
                        this.a.H0.f().w(this.a.C0.h());
                    }
                    this.a.C0.b(true);
                    return true;
                } else if (!this.a.E3(ReplyPrivacyCheckController.TYPE_FLOOR)) {
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
        public final /* synthetic */ ki8 a;
        public final /* synthetic */ k65 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, ki8 ki8Var, k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, ki8Var, k65Var};
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
            this.a = ki8Var;
            this.b = k65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b != null && this.c.T0 != null) {
                this.c.T0.g(this.b);
                this.c.T0.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            rm8 rm8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (rm8Var = this.a.C0) != null && rm8Var.e() != null) {
                if (!this.a.C0.e().e()) {
                    this.a.C0.a(false);
                }
                this.a.C0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.G0 == null || this.a.G0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
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
            pq8 pq8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (pq8Var = this.a.k) != null) {
                pq8Var.b1(threadData);
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
            if (this.a.F0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.s5(absVideoPbFragment.F0.y());
            }
            this.a.G5(false);
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
            pq8 pq8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (pq8Var = this.a.k) != null) {
                pq8Var.a1(threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public j1(AbsVideoPbFragment absVideoPbFragment) {
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
                if (this.a.w != null && !this.a.w.k()) {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.i()).param("obj_type", 2).param("fid", this.a.L().w1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.L().w1().S()));
                } else if (this.a.w != null && this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().l() != null) {
                    TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.L().w1().l().getId()).param("fname", this.a.L().w1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.L().w1().S()).param("obj_param1", this.a.w.k));
                }
                this.a.O5();
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
                if (this.a.w != null && !this.a.w.k()) {
                    TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.i()).param("obj_type", 2).param("fid", this.a.L().w1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.L().w1().S()));
                    String g = this.a.w.g();
                    if (TextUtils.isEmpty(g)) {
                        return;
                    }
                    if (!URLUtil.isHttpUrl(g) && !URLUtil.isHttpsUrl(g)) {
                        Uri parse = Uri.parse(g);
                        if (parse != null) {
                            UtilHelper.dealOneScheme(this.a.getActivity(), parse.toString());
                            return;
                        }
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{g});
                } else if (this.a.w != null) {
                    if (this.a.w.h) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.P4(absVideoPbFragment.w.j, this.a.w.i);
                    } else if (this.a.w.m != null) {
                        YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                    }
                    if (this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().l() != null) {
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.L().w1().l().getId()).param("fname", this.a.L().w1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.L().w1().S()).param("obj_param1", this.a.w.k);
                        if (this.a.L().w1().Q() != null) {
                            ThreadData Q = this.a.L().w1().Q();
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
            this.a.c5();
        }
    }

    /* loaded from: classes5.dex */
    public class k1 implements ValueAnimator.AnimatorUpdateListener {
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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
                    if (this.a.p1 == null || !this.a.p1.onTouchEvent(motionEvent)) {
                        return false;
                    }
                    return true;
                }
                if (this.a.j1 == 1) {
                    if (!this.a.n1) {
                        this.a.Q5();
                        UtilHelper.showStatusBar(this.a.M(), this.a.M().getRootView());
                        this.a.n1 = true;
                        jg.a().removeCallbacks(this.a.r1);
                        jg.a().postDelayed(this.a.r1, 3000L);
                    }
                } else if (this.a.j1 == 2 && (this.a.n1 || this.a.M4())) {
                    this.a.P5();
                    UtilHelper.hideStatusBar(this.a.M(), this.a.M().getRootView());
                    this.a.n1 = false;
                    pq8 pq8Var = this.a.k;
                    if (pq8Var != null) {
                        pq8Var.Z0(false);
                    }
                }
                this.a.j1 = 0;
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
                this.a.v5(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l1 implements Animator.AnimatorListener {
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

        public l1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams) {
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
            this.b.a6(this.a);
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
            this.a.j1 = 0;
            this.a.k1 = 0.0f;
            this.a.l1 = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            pq8 pq8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.k1 += f;
                this.a.l1 += f2;
                if (this.a.j1 == 0 && !this.a.m1 && (pq8Var = this.a.k) != null && !pq8Var.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.l1) <= Math.abs(this.a.k1) || this.a.l1 > (-height) / 5) {
                        if (Math.abs(this.a.l1) > Math.abs(this.a.k1) && this.a.l1 > 0.0f && f2 > 0.0f) {
                            this.a.j1 = 2;
                        }
                    } else {
                        this.a.j1 = 1;
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
                if (this.b.L4() && (this.a.n() || this.b.L().P1() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.L().P1() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.L4() && (this.a.n() || this.b.L().P1() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.L().P1() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public m1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.J1);
                this.a.height = floatValue;
                this.b.height = (this.c - AbsVideoPbFragment.J1) + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.n1 || this.a.M4()) {
                return;
            }
            this.a.P5();
            UtilHelper.hideStatusBar(this.a.M(), this.a.M().getRootView());
            this.a.n1 = false;
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
                    this.a.F0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.H0 != null && this.a.H0.f() != null) {
                    this.a.H0.f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements xs4.a {
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

        @Override // com.baidu.tieba.xs4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.y5();
                if (z && this.a.L() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.L().q3(z2);
                    if (this.a.L().w1() != null && (Q = this.a.L().w1().Q()) != null) {
                        if (z2) {
                            Q.collectNum++;
                        } else {
                            int i = Q.collectNum;
                            if (i > 0) {
                                Q.collectNum = i - 1;
                            }
                        }
                    }
                    if (!this.a.L().h1()) {
                        if (this.a.L4()) {
                            if (this.a.W3() != null) {
                                this.a.W3().P1();
                            }
                            if (this.a.m4() != null) {
                                this.a.m4().d2();
                            }
                        } else if (this.a.V3() != null) {
                            this.a.V3().h2();
                        }
                    } else {
                        this.a.S4();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() != null && this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().Q() != null && this.a.L().w1().Q().getAuthor() != null) {
                                MarkData f = this.a.P.f();
                                MetaData author = this.a.L().w1().Q().getAuthor();
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
                        this.a.v3();
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
    public class o extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.L() != null) {
                    switch (this.a.R.getLoadDataMode()) {
                        case 0:
                            this.a.L().b2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.O3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.P3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.Q3(absVideoPbFragment.R.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.P3(absVideoPbFragment2.R.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.g0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.P3(absVideoPbFragment3.R.getLoadDataMode(), false, null, false);
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
    public class o1 implements Animator.AnimatorListener {
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

        public o1(AbsVideoPbFragment absVideoPbFragment) {
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
                this.a.J0.c(motionEvent);
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
    public class p1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ ViewGroup.LayoutParams b;
        public final /* synthetic */ int c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public p1(AbsVideoPbFragment absVideoPbFragment, ViewGroup.LayoutParams layoutParams, ViewGroup.LayoutParams layoutParams2, int i) {
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.J1);
                this.a.height = floatValue;
                this.b.height = this.c + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements ml6.b {
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

        @Override // com.baidu.tieba.ml6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    lj8.d();
                } else {
                    lj8.c();
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
                    if (this.a.V3() != null) {
                        this.a.V3().l2(false);
                    } else if (this.a.L4() && this.a.m4() != null) {
                        this.a.m4().g2(false);
                    }
                    if (this.a.W3() != null) {
                        this.a.W3().U1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        if (absVideoPbFragment.W3().M1() == 0) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        absVideoPbFragment.B5(i2);
                        this.a.a0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    pq8 pq8Var = this.a.k;
                    if (pq8Var != null) {
                        pq8Var.Y0(z);
                    }
                    this.a.j5();
                    if (this.a.L() != null && this.a.L().w1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()));
                    }
                } else {
                    if (this.a.W3() != null) {
                        this.a.W3().U1(false);
                    }
                    if (this.a.V3() != null) {
                        this.a.V3().l2(true);
                        int c2 = this.a.V3().c2();
                        int a2 = this.a.V3().a2();
                        if (c2 != 0) {
                            this.a.B5(8);
                            this.a.V3().v2(0);
                        } else if (a2 != 0) {
                            this.a.V3().v2(8);
                            this.a.B5(0);
                        } else {
                            this.a.V3().v2(8);
                            this.a.B5(8);
                        }
                    } else if (this.a.m4() != null) {
                        this.a.m4().g2(true);
                        int a22 = this.a.m4().a2();
                        int Y1 = this.a.m4().Y1();
                        if (a22 != 0) {
                            this.a.B5(8);
                            this.a.m4().o2(0);
                        } else if (Y1 != 0) {
                            this.a.m4().o2(8);
                            this.a.B5(0);
                        } else {
                            this.a.m4().o2(8);
                            this.a.B5(8);
                        }
                        this.a.a0.setVisibility(0);
                    }
                    pq8 pq8Var2 = this.a.k;
                    if (pq8Var2 != null) {
                        pq8Var2.Y0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.L() != null && this.a.L().w1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()));
                    }
                }
                this.a.f.d(i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q1 implements Animator.AnimatorListener {
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

        public q1(AbsVideoPbFragment absVideoPbFragment) {
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
            this.a.Y5();
        }
    }

    /* loaded from: classes5.dex */
    public class r implements zz4.e {
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

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) && zz4Var != null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k65 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, k65 k65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, k65Var};
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
            this.a = k65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.T0.setHomePbFloatLastCloseTime();
                this.b.v4();
                this.b.T0.t(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.v.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements PbFallingView.r {
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

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.K5();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K.setTag(Boolean.FALSE);
                if (this.a.T0 == null) {
                    return;
                }
                this.a.T0.setAutoCompleteShown(false);
                if (this.a.T0.getVisibility() == 0) {
                    this.a.T0.setTag(this.a.K);
                    this.a.T0.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s1 implements yf<ImageView> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
                    foreDrawableImageView.Q();
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
                    if (pv4.c().g()) {
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
                    foreDrawableImageView.Q();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    foreDrawableImageView.H();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = pv4.c().g();
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
    public class t implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ zz4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, zz4Var};
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
            this.c = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
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
                this.d.U5();
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
                if (this.a.w != null && !this.a.w.k()) {
                    TiebaStatic.log(new StatisticItem("c13591"));
                } else if (this.a.w != null) {
                    TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.L().w1().S()));
                    this.a.w.l = true;
                }
                this.a.N5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements yf<GifView> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.setBackgroundDrawable(null);
                gifView.setImageDrawable(null);
                gifView.setTag(null);
                gifView.setOnClickListener(null);
                gifView.setDefaultBgResource(R.color.common_color_10220);
                gifView.d0();
            }
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) {
                gifView.g0();
                gifView.d0();
                gifView.setImageDrawable(null);
                gifView.h0();
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
                if (pv4.c().g()) {
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = pv4.c().g();
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
    public class u implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ zz4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, zz4Var};
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
            this.b = zz4Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.U5();
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
                if (absVideoPbFragment.B0 != null && absVideoPbFragment.L() != null && this.a.L().w1() != null && this.a.L().w1().d() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.B0.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.L().w1().d().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.F0.n0();
                this.a.L3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements yf<View> {
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.w0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.g {
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

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.g
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
            this.a.N3(false);
            this.a.b5();
            if (this.a.L() != null && this.a.L().w1() != null && this.a.L().w1().Q() != null && this.a.L().w1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.L().R1()).param("fid", this.a.L().w1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (this.a.I4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.L().getForumId());
                    statisticItem.param("tid", this.a.L().Q1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.Z3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.Y3());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements yf<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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
                layoutParams.height = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.a0.setLayoutParams(layoutParams);
                if (this.a.L4() && this.a.d != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.K1);
                    } else {
                        layoutParams2.height = AbsVideoPbFragment.K1;
                    }
                    this.a.d.setLayoutParams(layoutParams2);
                    this.a.e.setScrollable(true);
                }
                this.a.j5();
                if (this.a.W3() != null) {
                    this.a.W3().P1();
                }
                if (this.a.V3() != null) {
                    this.a.V3().h2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements yf<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
                this.a.t4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements Comparator<ca5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ca5 ca5Var, ca5 ca5Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ca5Var, ca5Var2)) == null) {
                return ca5Var.compareTo(ca5Var2);
            }
            return invokeLL.intValue;
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
            String str2;
            int i;
            int i2;
            String jumpUrlWithTid;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0919d0) {
                    if (this.a.L() != null) {
                        this.a.L().z2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.tag_first);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.tag_first, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.L().Q1());
                    statisticItem2.param("fid", this.a.L().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.I4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.L().getForumId());
                        statisticItem3.param("tid", this.a.L().Q1());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.Z3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.Y3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (!this.a.Z) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof bc9) {
                                bc9 bc9Var = (bc9) obj;
                                if (this.a.L() == null || this.a.L().w1() == null || this.a.I0 == null || bc9Var.r() == null || bc9Var.E() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.H0 != null) {
                                    this.a.H0.g();
                                }
                                aj8 aj8Var = new aj8();
                                aj8Var.A(this.a.L().w1().l());
                                aj8Var.E(this.a.L().w1().Q());
                                aj8Var.C(bc9Var);
                                this.a.I0.n0(aj8Var);
                                this.a.I0.setPostId(bc9Var.O());
                                this.a.R4(view2, bc9Var.r().getUserId(), "", bc9Var);
                                TiebaStatic.log("c11743");
                                mp8.b(this.a.L().w1(), bc9Var, bc9Var.d0, 8, 1);
                                if (this.a.F0 != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.s5(absVideoPbFragment.F0.y());
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
                    if (view2.getId() != R.id.pb_video_more || this.a.getPageContext().getPageActivity() == null || this.a.L() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "obj_type";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "obj_type";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.L().Q1(), false, true);
                            this.a.r5(foldCommentActivityConfig);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "obj_type";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.L().Q1(), true, false);
                            this.a.r5(foldCommentActivityConfig2);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.L().getForumId());
                        statisticItem4.param("fname", this.a.L().V0());
                        statisticItem4.param("tid", this.a.L().Q1());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((!this.a.L4() || this.a.m4() == null || this.a.m4().Z1() == null || view2 != this.a.m4().Z1()) && ((this.a.V3() == null || this.a.V3().b2() == null || view2 != this.a.V3().b2()) && view2.getId() != R.id.pb_more)) {
                        kq8 kq8Var = this.a.N;
                        if (kq8Var != null && kq8Var.R() != null && view2 == this.a.N.R().m()) {
                            this.a.N.J();
                            return;
                        }
                        kq8 kq8Var2 = this.a.N;
                        if ((kq8Var2 == null || ((kq8Var2.R() == null || view2 != this.a.N.R().q()) && view2.getId() != R.id.obfuscated_res_0x7f09190e && view2.getId() != R.id.obfuscated_res_0x7f09027b)) && view2.getId() != R.id.obfuscated_res_0x7f090b07 && view2.getId() != R.id.obfuscated_res_0x7f091da6) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            if (view2 == absVideoPbFragment2.p) {
                                if (absVideoPbFragment2.L() == null || this.a.L().w1() == null) {
                                    return;
                                }
                                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    StatisticItem statisticItem5 = new StatisticItem("c13266");
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem5.param("fid", this.a.L().w1().m());
                                    statisticItem5.param("tid", this.a.L().Q1());
                                    statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(statisticItem5);
                                    TbadkCoreApplication.getInst().setTaskId("");
                                }
                                hi.z(this.a.a, this.a.p);
                                this.a.a.finish();
                            } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                                if (uo5.a()) {
                                    return;
                                }
                                if (this.a.L() != null && this.a.L().w1() != null) {
                                    ArrayList<bc9> H = this.a.L().w1().H();
                                    if ((H == null || H.size() <= 0) && this.a.L().O1()) {
                                        hi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec8));
                                        return;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.L().Q1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.L().getForumId()));
                                    this.a.N.n0();
                                    return;
                                }
                                hi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec8));
                            } else if (this.a.N.R() != null && view2 == this.a.N.R().s()) {
                                if (this.a.L() == null) {
                                    return;
                                }
                                this.a.N.G();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.T5();
                                this.a.z5();
                                this.a.L().o3(1);
                            } else {
                                kq8 kq8Var3 = this.a.N;
                                if (kq8Var3 != null && kq8Var3.R() != null && view2 == this.a.N.R().q()) {
                                    this.a.N.J();
                                    return;
                                }
                                kq8 kq8Var4 = this.a.N;
                                if (kq8Var4 != null && ((kq8Var4.R() != null && view2 == this.a.N.R().A()) || view2.getId() == R.id.obfuscated_res_0x7f091a0f || view2.getId() == R.id.obfuscated_res_0x7f091a0d)) {
                                    this.a.N.G();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.L) {
                                        view2.setTag(Integer.valueOf(this.a.L().M1()));
                                        return;
                                    } else {
                                        this.a.T5();
                                        this.a.z5();
                                        this.a.N.L0(view2);
                                        return;
                                    }
                                }
                                kq8 kq8Var5 = this.a.N;
                                if (kq8Var5 != null && kq8Var5.R() != null && view2 == this.a.N.R().z()) {
                                    if (this.a.L() == null || this.a.L().w1() == null || this.a.L().w1().Q() == null) {
                                        return;
                                    }
                                    this.a.N.J();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.N.V(absVideoPbFragment3.L().w1().Q().getFirstPostId());
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f09199b) {
                                    try {
                                        sparseArray = (SparseArray) view2.getTag();
                                    } catch (ClassCastException e) {
                                        e.printStackTrace();
                                        sparseArray = null;
                                    }
                                    kq8 kq8Var6 = this.a.N;
                                    if (kq8Var6 != null) {
                                        kq8Var6.y0(sparseArray);
                                    }
                                } else {
                                    kq8 kq8Var7 = this.a.N;
                                    if (kq8Var7 != null && kq8Var7.R() != null && view2 == this.a.N.R().x()) {
                                        int skinType = TbadkCoreApplication.getInst().getSkinType();
                                        UtilHelper.showSkinChangeAnimation(this.a.getActivity());
                                        this.a.onChangeSkinType(skinType);
                                        UtilHelper.setNavigationBarBackground(this.a.getActivity(), this.a.getResources().getColor(R.color.CAM_X0201_2));
                                        if (skinType == 0) {
                                            TbadkCoreApplication.getInst().setSkinType(4);
                                        } else {
                                            m35.m().w("key_is_follow_system_mode", false);
                                            SkinManager.setDayOrDarkSkinTypeWithSystemMode(true, false);
                                        }
                                        this.a.N.K();
                                        return;
                                    }
                                    kq8 kq8Var8 = this.a.N;
                                    if (kq8Var8 != null && kq8Var8.R() != null && view2 == this.a.N.R().y()) {
                                        this.a.N.K();
                                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                        absVideoPbFragment4.N.I0(absVideoPbFragment4.B1);
                                        return;
                                    }
                                    kq8 kq8Var9 = this.a.N;
                                    if (kq8Var9 != null && kq8Var9.R() != null && view2 == this.a.N.R().p()) {
                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.L().Q1())) == null) {
                                            return;
                                        }
                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                        this.a.N.J();
                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                        return;
                                    }
                                    kq8 kq8Var10 = this.a.N;
                                    if (kq8Var10 != null && (view2 == kq8Var10.N() || (this.a.N.R() != null && (view2 == this.a.N.R().t() || view2 == this.a.N.R().u())))) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        } else if (this.a.L() == null || this.a.L().w1() == null || this.a.R.k0()) {
                                            return;
                                        } else {
                                            this.a.N.G();
                                            if (this.a.N.R() != null && view2 == this.a.N.R().u()) {
                                                i2 = this.a.L().w1().Q().getIs_top() == 1 ? 5 : 4;
                                            } else if (this.a.N.R() != null && view2 == this.a.N.R().t()) {
                                                i2 = this.a.L().w1().Q().getIs_good() == 1 ? 3 : 6;
                                            } else {
                                                i2 = view2 == this.a.N.N() ? 2 : 0;
                                            }
                                            ForumData l = this.a.L().w1().l();
                                            String name = l.getName();
                                            String id = l.getId();
                                            String id2 = this.a.L().w1().Q().getId();
                                            this.a.showProgressBar();
                                            this.a.R.o0(id, name, id2, i2, this.a.N.O());
                                            return;
                                        }
                                    }
                                    kq8 kq8Var11 = this.a.N;
                                    if (kq8Var11 != null && kq8Var11.R() != null && view2 == this.a.N.R().o()) {
                                        if (this.a.L() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.N.G();
                                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                        SparseArray<Object> e4 = absVideoPbFragment5.e4(absVideoPbFragment5.L().w1(), this.a.L().O1(), 1);
                                        if (e4 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.L().w1().l().getId(), this.a.L().w1().l().getName(), this.a.L().w1().Q().getId(), String.valueOf(this.a.L().w1().X().getUserId()), (String) e4.get(R.id.tag_forbid_user_name), (String) e4.get(R.id.tag_forbid_user_name_show), (String) e4.get(R.id.tag_forbid_user_post_id), (String) e4.get(R.id.tag_forbid_user_portrait))));
                                        return;
                                    }
                                    kq8 kq8Var12 = this.a.N;
                                    if (kq8Var12 != null && kq8Var12.R() != null && view2 == this.a.N.R().i()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                        SparseArray<Object> e42 = absVideoPbFragment6.e4(absVideoPbFragment6.L().w1(), this.a.L().O1(), 1);
                                        if (e42 != null) {
                                            this.a.N.k0(((Integer) e42.get(R.id.tag_del_post_type)).intValue(), (String) e42.get(R.id.tag_del_post_id), ((Integer) e42.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) e42.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.N.J();
                                        if (this.a.L() == null || this.a.L().w1() == null || this.a.L().w1().Q() == null) {
                                            return;
                                        }
                                        ThreadData Q = this.a.L().w1().Q();
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
                                    kq8 kq8Var13 = this.a.N;
                                    if (kq8Var13 != null && kq8Var13.R() != null && view2 == this.a.N.R().n()) {
                                        if (this.a.L() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                        SparseArray<Object> e43 = absVideoPbFragment7.e4(absVideoPbFragment7.L().w1(), this.a.L().O1(), 1);
                                        if (e43 != null) {
                                            if (StringUtils.isNull((String) e43.get(R.id.tag_del_multi_forum))) {
                                                this.a.N.h0(((Integer) e43.get(R.id.tag_del_post_type)).intValue(), (String) e43.get(R.id.tag_del_post_id), ((Integer) e43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) e43.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.N.i0(((Integer) e43.get(R.id.tag_del_post_type)).intValue(), (String) e43.get(R.id.tag_del_post_id), ((Integer) e43.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) e43.get(R.id.tag_del_post_is_self)).booleanValue(), (String) e43.get(R.id.tag_del_multi_forum));
                                            }
                                        }
                                        this.a.N.J();
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f09217d && view2.getId() != R.id.obfuscated_res_0x7f09199d && view2.getId() != R.id.obfuscated_res_0x7f091824 && view2.getId() != R.id.obfuscated_res_0x7f0919ff) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0919fd && view2.getId() != R.id.obfuscated_res_0x7f091bde && view2.getId() != R.id.obfuscated_res_0x7f091997) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091984 && view2.getId() != R.id.collect_num_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091989 && view2.getId() != R.id.share_more_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f091986 && view2.getId() != R.id.thread_info_commont_container) {
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0925d6) {
                                                            if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                                if (this.a.L() == null) {
                                                                    return;
                                                                }
                                                                StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                                statisticItem8.param("tid", this.a.L().Q1());
                                                                statisticItem8.param("fid", this.a.L().getForumId());
                                                                statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem8.param("obj_locate", 2);
                                                                TiebaStatic.log(statisticItem8);
                                                                return;
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0919c7 && view2.getId() != R.id.obfuscated_res_0x7f091991) {
                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0911a9) {
                                                                    this.a.j5();
                                                                    return;
                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09082e && view2.getId() != R.id.obfuscated_res_0x7f090b04) {
                                                                    if (this.a.N.R() != null && view2 == this.a.N.R().l()) {
                                                                        this.a.N.G();
                                                                        if (this.a.L() != null) {
                                                                            this.a.t.f(this.a.L().Q1());
                                                                        }
                                                                        if (this.a.L() != null && this.a.L().isPrivacy()) {
                                                                            this.a.showToast(R.string.privacy_thread_can_not_use_call_fans);
                                                                            if (this.a.L().w1() != null) {
                                                                                this.a.t.d(3, 3, this.a.L().w1().S());
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        this.a.t.b();
                                                                        int i4 = (TbSingleton.getInstance().mCanCallFans || this.a.L() == null || this.a.L().w1() == null || this.a.L().w1().S() == null || !this.a.L().w1().S().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                        if (this.a.L() == null || this.a.L().w1() == null) {
                                                                            return;
                                                                        }
                                                                        this.a.t.d(3, i4, this.a.L().w1().S());
                                                                        return;
                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09199f || view2.getId() == R.id.obfuscated_res_0x7f0919f7) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", this.a.L().Q1());
                                                                        statisticItem9.param("fid", this.a.L().getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 7);
                                                                        TiebaStatic.log(statisticItem9);
                                                                        if (this.a.I4()) {
                                                                            StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                            statisticItem10.param("fid", this.a.L().getForumId());
                                                                            statisticItem10.param("tid", this.a.L().Q1());
                                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem10.param("post_id", this.a.Z3());
                                                                            statisticItem10.param("obj_source", 1);
                                                                            statisticItem10.param(str, 2);
                                                                            statisticItem10.param("obj_locate", this.a.Y3());
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
                                                                    if (sparseArray2 == null || !(sparseArray2.get(R.id.tag_load_sub_data) instanceof bc9)) {
                                                                        return;
                                                                    }
                                                                    bc9 bc9Var2 = (bc9) sparseArray2.get(R.id.tag_load_sub_data);
                                                                    View view3 = (View) sparseArray2.get(R.id.tag_load_sub_view);
                                                                    if (bc9Var2 == null || view3 == null) {
                                                                        return;
                                                                    }
                                                                    ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09082f);
                                                                    EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090830);
                                                                    View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090b04);
                                                                    if (bc9Var2.v0()) {
                                                                        bc9Var2.W0(false);
                                                                        oo8.e(bc9Var2);
                                                                    } else {
                                                                        if (this.a.L() != null ? oo8.c(this.a.L().w1(), bc9Var2) : false) {
                                                                            bc9Var2.W0(true);
                                                                            findViewById.setVisibility(0);
                                                                        }
                                                                    }
                                                                    SkinManager.setBackgroundColor(findViewById, bc9Var2.v0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                    SkinManager.setViewTextColor(eMTextView, bc9Var2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                    WebPManager.setPureDrawable(imageView, bc9Var2.v0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, bc9Var2.v0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                    return;
                                                                }
                                                            } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String s = m35.m().s("tail_link", "");
                                                                if (!StringUtils.isNull(s)) {
                                                                    TiebaStatic.log("c10056");
                                                                    gt4.x(view2.getContext(), string, s, true, true, true);
                                                                }
                                                                this.a.j5();
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (this.a.O0 >= 0) {
                                                            if (this.a.L() != null) {
                                                                this.a.L().V2();
                                                            }
                                                            if (this.a.L4() && this.a.L() != null && this.a.m4() != null && this.a.m4().E1() != null) {
                                                                this.a.m4().E1().f(this.a.L().w1());
                                                            } else if (this.a.V3() != null && this.a.V3().E1() != null) {
                                                                this.a.V3().E1().r(this.a.L().w1());
                                                            }
                                                            this.a.O0 = 0;
                                                            this.a.P0 = Integer.MIN_VALUE;
                                                            if (this.a.L4() && this.a.L() != null && this.a.m4() != null) {
                                                                this.a.m4().j2(this.a.L().p1(), this.a.L().o1());
                                                                this.a.L().Z2(0, 0);
                                                                return;
                                                            } else if (this.a.L() == null || this.a.V3() == null) {
                                                                return;
                                                            } else {
                                                                this.a.V3().p2(this.a.L().p1(), this.a.L().o1());
                                                                this.a.L().Z2(0, 0);
                                                                return;
                                                            }
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    String str3 = str;
                                                    if (this.a.L() != null) {
                                                        AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                        if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.L().w1() == null || this.a.L().w1().Q() == null || !this.a.checkUpIsLogin()) {
                                                            return;
                                                        }
                                                        ki8 w1 = this.a.L().w1();
                                                        int reply_num = w1.Q().getReply_num();
                                                        int currentItem = this.a.e.getCurrentItem();
                                                        if (reply_num == 0) {
                                                            if (this.a.L4() && currentItem == 0) {
                                                                this.a.e.setCurrentItem(1);
                                                            }
                                                            this.a.N3(false);
                                                            this.a.b5();
                                                            return;
                                                        }
                                                        if (!this.a.L4() || currentItem != 0) {
                                                            if ((this.a.L4() && this.a.m4() == null) || this.a.V3() == null || this.a.l4() == null) {
                                                                return;
                                                            }
                                                            StatisticItem param = new StatisticItem("c13403").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            int j = (int) (hi.j(this.a.getContext()) * 0.6d);
                                                            BdTypeRecyclerView l4 = this.a.l4();
                                                            if (l4 == null) {
                                                                return;
                                                            }
                                                            boolean canScrollVertically = l4.canScrollVertically(1);
                                                            boolean canScrollVertically2 = l4.canScrollVertically(-1);
                                                            AppBarLayout appBarLayout = this.a.i;
                                                            str2 = "obj_source";
                                                            if (appBarLayout != null) {
                                                                appBarLayout.setExpanded(false, true);
                                                            }
                                                            if (l4.getLayoutManager() == null || !(l4.getLayoutManager() instanceof LinearLayoutManager)) {
                                                                return;
                                                            }
                                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) l4.getLayoutManager();
                                                            if (canScrollVertically2 || !canScrollVertically) {
                                                                int firstVisiblePosition = l4.getFirstVisiblePosition();
                                                                View childAt = l4.getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                this.a.M0 = firstVisiblePosition;
                                                                this.a.N0 = top;
                                                                if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-j) || l4.getCount() < 6)) {
                                                                    l4.smoothScrollToPosition(0);
                                                                } else {
                                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                    l4.smoothScrollToPosition(0);
                                                                }
                                                                i = 1;
                                                                param.param("obj_locate", 1);
                                                            } else if (this.a.M0 == -1 && this.a.N0 == Integer.MIN_VALUE) {
                                                                return;
                                                            } else {
                                                                if (this.a.M0 > 3 || (this.a.M0 == 3 && this.a.N0 < (-j))) {
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.M0, this.a.N0 + j);
                                                                    l4.smoothScrollBy(0, j);
                                                                } else if (this.a.M0 >= 2) {
                                                                    int i5 = j / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.M0, this.a.N0 + i5);
                                                                    l4.smoothScrollBy(0, i5);
                                                                } else if (this.a.M0 == 1) {
                                                                    int i6 = j / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.M0, this.a.N0 + i6);
                                                                    l4.smoothScrollBy(0, i6);
                                                                } else {
                                                                    l4.smoothScrollBy(0, -this.a.N0);
                                                                }
                                                                param.param("obj_locate", 2);
                                                                i = 1;
                                                            }
                                                            TiebaStatic.log(param);
                                                            zj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                            StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                            statisticItem11.param(str3, i);
                                                            statisticItem11.param("obj_locate", 4);
                                                            statisticItem11.param("tid", this.a.L().Q1());
                                                            statisticItem11.param("nid", w1.Q().getNid());
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
                                                        if (this.a.L() == null || this.a.L().w1() == null || this.a.L().w1().Q() == null || this.a.L().w1().Q().getAuthor() == null) {
                                                            return;
                                                        }
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()).param("obj_locate", 2).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        if (this.a.I4()) {
                                                            StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem12.param("fid", this.a.L().getForumId());
                                                            statisticItem12.param("tid", this.a.L().Q1());
                                                            statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem12.param("post_id", this.a.Z3());
                                                            statisticItem12.param(str2, 1);
                                                            statisticItem12.param(str3, 12);
                                                            statisticItem12.param("obj_locate", this.a.Y3());
                                                            TiebaStatic.log(statisticItem12);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.a.p4(true);
                                                return;
                                            }
                                            String str4 = str;
                                            int i7 = 2;
                                            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                                this.a.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                            if (absVideoPbFragment9.N == null || absVideoPbFragment9.L() == null) {
                                                return;
                                            }
                                            if (this.a.L4() && this.a.m4() == null) {
                                                return;
                                            }
                                            if (this.a.L4() || this.a.V3() != null) {
                                                this.a.N.G();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091984 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                    if (!this.a.C3(11009) || this.a.L() == null) {
                                                        return;
                                                    }
                                                    this.a.T4();
                                                    if (this.a.L().w1() != null && this.a.L().w1().Q() != null && this.a.L().w1().Q().getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.L().Q1()).param("fid", this.a.L().w1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        if (this.a.I4()) {
                                                            StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem13.param("fid", this.a.L().getForumId());
                                                            statisticItem13.param("tid", this.a.L().Q1());
                                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem13.param("post_id", this.a.Z3());
                                                            statisticItem13.param("obj_source", 1);
                                                            statisticItem13.param(str4, 13);
                                                            statisticItem13.param("obj_locate", this.a.Y3());
                                                            TiebaStatic.log(statisticItem13);
                                                        }
                                                    }
                                                    if (this.a.L().w1().Q() == null || this.a.L().w1().Q().getAuthor() == null || this.a.L().w1().Q().getAuthor().getUserId() == null || this.a.P == null) {
                                                        return;
                                                    }
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    int T = absVideoPbFragment10.N.T(absVideoPbFragment10.L().w1());
                                                    ThreadData Q2 = this.a.L().w1().Q();
                                                    if (!Q2.isBJHArticleThreadType()) {
                                                        if (Q2.isBJHVideoThreadType()) {
                                                            i7 = 3;
                                                        } else if (Q2.isBJHNormalThreadType()) {
                                                            i7 = 4;
                                                        } else {
                                                            i7 = Q2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                        }
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.L().Q1()).param("obj_locate", 1).param("obj_id", this.a.L().w1().Q().getAuthor().getUserId()).param(str4, !this.a.P.e()).param("obj_source", T).param("obj_param1", i7));
                                                    return;
                                                }
                                                this.a.z = view2;
                                                return;
                                            }
                                            return;
                                        }
                                        String str5 = str;
                                        if (this.a.L() == null) {
                                            return;
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f0919fd) {
                                            StatisticItem statisticItem14 = new StatisticItem("c13398");
                                            statisticItem14.param("tid", this.a.L().Q1());
                                            statisticItem14.param("fid", this.a.L().getForumId());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem14);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091bde) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.y = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f0919fd && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof bc9) {
                                                bc9 bc9Var3 = (bc9) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0919fd && (statisticItem = bc9Var3.e0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091bde || view2.getId() == R.id.obfuscated_res_0x7f091997) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.L().R1()).param("fid", this.a.L().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", bc9Var3.O()).param("obj_source", 1).param(str5, 3));
                                                }
                                                if (this.a.L() == null || this.a.L().w1() == null || this.a.I0 == null || bc9Var3.r() == null || bc9Var3.E() == 1) {
                                                    return;
                                                }
                                                if (this.a.H0 != null) {
                                                    this.a.H0.g();
                                                }
                                                aj8 aj8Var2 = new aj8();
                                                aj8Var2.A(this.a.L().w1().l());
                                                aj8Var2.E(this.a.L().w1().Q());
                                                aj8Var2.C(bc9Var3);
                                                this.a.I0.n0(aj8Var2);
                                                this.a.I0.setPostId(bc9Var3.O());
                                                this.a.R4(view2, bc9Var3.r().getUserId(), "", bc9Var3);
                                                if (this.a.F0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                    absVideoPbFragment11.s5(absVideoPbFragment11.F0.y());
                                                }
                                            }
                                        }
                                    } else {
                                        String str6 = str;
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091824) {
                                            StatisticItem statisticItem15 = new StatisticItem("c13398");
                                            statisticItem15.param("tid", this.a.L().Q1());
                                            statisticItem15.param("fid", this.a.L().getForumId());
                                            statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem15.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem15);
                                            if (this.a.I4()) {
                                                StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem16.param("fid", this.a.L().getForumId());
                                                statisticItem16.param("tid", this.a.L().Q1());
                                                statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem16.param("post_id", this.a.Z3());
                                                statisticItem16.param("obj_source", 1);
                                                statisticItem16.param(str6, 8);
                                                statisticItem16.param("obj_locate", this.a.Y3());
                                                TiebaStatic.log(statisticItem16);
                                            }
                                        }
                                        if ((view2.getId() != R.id.obfuscated_res_0x7f09199d && view2.getId() != R.id.obfuscated_res_0x7f0919ff) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09199d && this.a.I4()) {
                                                StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem17.param("fid", this.a.L().getForumId());
                                                statisticItem17.param("tid", this.a.L().Q1());
                                                statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem17.param("post_id", this.a.Z3());
                                                statisticItem17.param("obj_source", 1);
                                                statisticItem17.param(str6, 9);
                                                statisticItem17.param("obj_locate", this.a.Y3());
                                                TiebaStatic.log(statisticItem17);
                                            }
                                            if (!this.a.checkUpIsLogin()) {
                                                mp8.r("c10517", this.a.L().w1().m(), 3);
                                                return;
                                            } else if (this.a.L() == null || this.a.L().w1() == null) {
                                                return;
                                            } else {
                                                kq8 kq8Var14 = this.a.N;
                                                if (kq8Var14 != null) {
                                                    kq8Var14.G();
                                                }
                                                SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                bc9 bc9Var4 = (bc9) sparseArray4.get(R.id.tag_load_sub_data);
                                                bc9 bc9Var5 = (bc9) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                                if (bc9Var4 == null) {
                                                    return;
                                                }
                                                if (bc9Var4.J() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem18 = bc9Var4.e0;
                                                if (statisticItem18 != null) {
                                                    StatisticItem copy2 = statisticItem18.copy();
                                                    copy2.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f091824) {
                                                        copy2.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09199d) {
                                                        copy2.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy2);
                                                }
                                                this.a.T5();
                                                TiebaStatic.log("c11742");
                                                if (bc9Var5 != null) {
                                                    this.a.R5(bc9Var4, bc9Var5, false, true);
                                                    return;
                                                } else {
                                                    this.a.R5(bc9Var4, null, false, false);
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
                            this.a.T5();
                            this.a.z5();
                            boolean t3 = view2.getId() == R.id.obfuscated_res_0x7f09190e ? this.a.L().t3(true, this.a.Z3()) : view2.getId() == R.id.obfuscated_res_0x7f09027b ? this.a.L().t3(false, this.a.Z3()) : this.a.L().s3(this.a.Z3());
                            view2.setTag(Boolean.valueOf(t3));
                            if (t3) {
                                this.a.J5();
                                i3 = 1;
                                this.a.L = true;
                            } else {
                                i3 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i3, new Object[0]);
                        }
                    } else if (!this.a.L && this.a.L().v2(true)) {
                        this.a.L = true;
                        if (this.a.L4()) {
                            if (this.a.m4() != null) {
                                this.a.m4().n2();
                            }
                        } else if (this.a.V3() != null) {
                            this.a.V3().u2();
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
                this.a.j5();
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
                rm8 rm8Var = this.a.C0;
                if (rm8Var != null && rm8Var.e() != null && this.a.C0.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.C0.e().c());
                    if (this.a.F0 != null && (this.a.F0.x() || this.a.F0.z())) {
                        this.a.F0.w(false, this.a.C0.h());
                    }
                    this.a.C0.a(true);
                    return true;
                } else if (this.a.E3(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends wp5<ShareItem> {
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
        @Override // com.baidu.tieba.wp5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel L = this.b.L();
                if (L != null) {
                    L.c3(this.a);
                }
                return lo8.d(this.b.U3(), 2, L);
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
        public void a(bc9 bc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bc9Var) == null) {
                this.a.I0.i0(bc9Var);
                if (this.a.V3() != null) {
                    this.a.V3().h2();
                } else if (this.a.L4() && this.a.m4() != null) {
                    this.a.m4().d2();
                }
                this.a.H0.g();
                this.a.G0.s();
                this.a.G5(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements PbFallingView.q {
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

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String n4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.L() != null && this.a.L().h2()) {
                    n4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    n4 = this.a.n4();
                }
                if (!StringUtils.isNull(n4) && this.a.L() != null && this.a.L().w1() != null) {
                    n4 = TbSingleton.getInstance().getAdVertiComment(this.a.L().w1().r0(), this.a.L().w1().s0(), n4);
                }
                if (this.a.F0 != null) {
                    this.a.F0.c0(n4);
                }
                if (this.a.f0 != null) {
                    this.a.f0.setText(n4);
                }
                this.a.G5(false);
                this.a.K5();
            }
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
        J1 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        K1 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        L1 = 3;
    }

    public final boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PbModel L = L();
            if (L != null && L.w1() != null) {
                ThreadData Q = L.w1().Q();
                L.w1().d();
                return AntiHelper.b(getPageContext(), Q);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            PbFallingView pbFallingView = this.K;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.T0;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K) {
                this.T0.setTag(null);
                this.T0.setAutoCompleteShown(true);
                this.T0.d();
            }
        }
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && L() != null && !gi.isEmpty(L().Q1())) {
            zp4.w().P(yp4.Z, gg.g(L().Q1(), 0L));
        }
    }

    public final void O5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        this.v.setAlpha(0.0f);
        this.v.setVisibility(0);
        Z5(layoutParams);
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            if (this.t1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 1.0f, 0.0f);
                this.t1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.t1.start();
        }
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (this.s1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 0.0f, 1.0f);
                this.s1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.s1.start();
        }
    }

    public final int U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (L() != null && L().w1() != null && L().w1().Q() != null) {
                return L().w1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.N != null && L() != null) {
                this.N.G();
                if (this.L) {
                    return;
                }
                T5();
                z5();
                if (L().loadData()) {
                    J5();
                }
            }
        }
    }

    public final void Y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new r1(this));
            this.I.start();
        }
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048669, this) != null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.t0.a()) {
            this.k.a0(false);
            return;
        }
        pq8 pq8Var = this.k;
        if (!I4() && !this.k.U0()) {
            z2 = true;
        }
        pq8Var.a0(z2);
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            xs4 c3 = xs4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.V0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.R = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.u1);
            this.Q = new n85(getPageContext());
            this.N = new kq8(this);
        }
    }

    public BdTypeRecyclerView l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).Z1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).X1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            super.onStop();
            w0().onStop(getPageContext());
            da9.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    public void y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048760, this) == null) {
            hideProgressBar();
            if (L4() && m4() != null) {
                m4().R1();
                m4().S1();
            } else if (V3() != null) {
                V3().T1();
                V3().U1();
            }
        }
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
        this.K0 = new int[2];
        this.M0 = -1;
        this.N0 = Integer.MIN_VALUE;
        this.O0 = 0;
        this.P0 = Integer.MIN_VALUE;
        this.Q0 = false;
        this.R0 = new v(this);
        this.U0 = new c1(this);
        this.V0 = new n1(this);
        this.W0 = new y1(this);
        this.X0 = new a2(this, 2004016);
        this.Y0 = new b2(this, 2004007);
        this.Z0 = new a(this, 2921391);
        this.a1 = new b(this, 2016450);
        this.b1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.c1 = new d(this, 2001426);
        this.d1 = new e(this, 2001427);
        this.e1 = new f(this, 2001428);
        this.f1 = new g(this);
        this.g1 = new h(this);
        this.h1 = new i(this);
        this.i1 = new j(this, 2004008);
        this.j1 = 0;
        this.n1 = true;
        this.o1 = new l(this);
        this.q1 = new m(this);
        this.r1 = new n(this);
        this.u1 = new o(this);
        this.v1 = new p(this);
        this.w1 = new q(this);
        this.x1 = new s(this);
        this.y1 = new x(this);
        this.z1 = new y(this);
        this.A1 = new b0(this);
        this.B1 = new c0(this);
        this.C1 = new d0(this, 2001332);
        this.D1 = new e0(this, 2016528);
        this.E1 = new o0(this, 2001440);
        this.F1 = new p0(this);
        this.G1 = new w0(this, 2921509);
        this.H1 = new a1(this);
        this.I1 = new b1(this);
        this.t0 = new c2(this, null);
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && L() != null && L().w1() != null) {
            if (!L4() || m4() != null) {
                if ((L4() || V3() != null) && this.P != null) {
                    MarkData markData = null;
                    if (L().w1() != null && L().w1().l0()) {
                        markData = L().M0(0);
                    } else {
                        CustomViewPager customViewPager = this.e;
                        if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                            markData = L().q1(X3(L().w1()));
                        } else if (L4()) {
                            if (m4() != null) {
                                markData = L().M0(m4().W1());
                            }
                        } else if (V3() != null) {
                            markData = L().M0(V3().Y1());
                        }
                    }
                    if (markData == null) {
                        return;
                    }
                    if (markData.isApp() && m4() != null && (markData = L().M0(m4().W1() + 1)) == null) {
                        return;
                    }
                    z5();
                    this.P.i(markData);
                    if (!this.P.e()) {
                        if (L() != null && !lo8.k(L().Q1())) {
                            this.j0.o(2);
                            lo8.b(L().Q1());
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

    public final String Z3() {
        InterceptResult invokeV;
        ArrayList<bc9> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (L() == null || L().w1() == null || L().w1().H() == null || (count = ListUtils.getCount((H = L().w1().H()))) == 0) {
                return "";
            }
            if (L().H1()) {
                Iterator<bc9> it = H.iterator();
                while (it.hasNext()) {
                    bc9 next = it.next();
                    if (next != null && next.E() == 1) {
                        return next.O();
                    }
                }
            }
            int i2 = 0;
            if (l4() != null) {
                if (L4()) {
                    if (m4() != null) {
                        i2 = m4().U1();
                    }
                } else if (V3() != null) {
                    i2 = V3().W1();
                }
            }
            bc9 bc9Var = (bc9) ListUtils.getItem(H, i2);
            if (bc9Var != null && bc9Var.r() != null) {
                if (L().s2(bc9Var.r().getUserId())) {
                    return bc9Var.O();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    bc9 bc9Var2 = (bc9) ListUtils.getItem(H, i3);
                    if (bc9Var2 == null || bc9Var2.r() == null || bc9Var2.r().getUserId() == null) {
                        break;
                    } else if (L().s2(bc9Var2.r().getUserId())) {
                        return bc9Var2.O();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    bc9 bc9Var3 = (bc9) ListUtils.getItem(H, i4);
                    if (bc9Var3 == null || bc9Var3.r() == null || bc9Var3.r().getUserId() == null) {
                        break;
                    } else if (L().s2(bc9Var3.r().getUserId())) {
                        return bc9Var3.O();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            this.a0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09275f);
            this.b0 = this.c.findViewById(R.id.obfuscated_res_0x7f0927c0);
            this.c0 = this.c.findViewById(R.id.obfuscated_res_0x7f091985);
            hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            hi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070285);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090944);
            this.e0 = imageView;
            imageView.setOnClickListener(new u0(this));
            Q4();
            this.f0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091988);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091980);
            this.d0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091986);
            this.g0 = imageView2;
            imageView2.setOnClickListener(this.z1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091984);
            this.h0 = imageView3;
            imageView3.setOnClickListener(this.z1);
            if (booleanExtra) {
                this.h0.setVisibility(8);
            } else {
                this.h0.setVisibility(0);
            }
            if (K4()) {
                this.g0.setVisibility(0);
            } else {
                this.g0.setVisibility(8);
                this.h0.setPadding(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091989);
            this.i0 = imageView4;
            imageView4.setOnClickListener(this.z1);
            this.j0 = new vq8(this.i0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.j0.f();
            }
            if (L() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !lo8.k(L().Q1())) {
                this.j0.f();
                lo8.b(L().Q1());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091987);
            this.r0 = textView;
            textView.setVisibility(0);
            G5(false);
        }
    }

    @Override // com.baidu.tieba.yt5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.Z = true;
        }
    }

    @Override // com.baidu.tieba.yt5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, context, str) == null) {
            um8.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.Z = true;
        }
    }

    public void Y4(ca5 ca5Var, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048666, this, ca5Var, i2) == null) && (pbFallingView = this.K) != null) {
            pbFallingView.A(ca5Var, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.yt5
    public void i0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048696, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.Z = true;
    }

    public final void w4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048751, this, i2, i3) == null) {
            aq5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void x5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048757, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            kq8 kq8Var = this.N;
            if (kq8Var == null) {
                return;
            }
            if (z2) {
                kq8Var.G();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.H();
            } else {
                this.N.G();
            }
        }
    }

    public void B5(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i2) == null) && (view2 = this.g) != null) {
            view2.setVisibility(i2);
        }
    }

    public void C5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            this.u = z2;
        }
    }

    public final void D5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) {
            this.F0.X(z2);
            this.F0.a0(z2);
            this.F0.i0(z2);
        }
    }

    public void G5(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048602, this, z2) != null) || this.c0 == null) {
            return;
        }
        s5(this.F0.y());
        if (this.v0) {
            H5(z2);
        } else {
            r4(z2);
        }
        Z4();
        c5();
    }

    public final void I5(ki8 ki8Var) {
        nq8 I;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, ki8Var) == null) && (I = ki8Var.I()) != null && !I.l) {
            y3(I);
        }
    }

    public final void L5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            oq8.c(M(), U3(), i2);
        }
    }

    public void N3(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) && (appBarLayout = this.i) != null) {
            appBarLayout.setExpanded(z2);
        }
    }

    public final void n5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048710, this, i2) == null) && L() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(L().Q1());
            sendMessage(privacySettingMessage);
        }
    }

    public void o5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048712, this, i2) == null) && (linearLayout = this.a0) != null) {
            linearLayout.setVisibility(i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onKeyboardVisibilityChanged(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z2) == null) {
            View view2 = this.h;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z2) == null) {
            super.onUserChanged(z2);
            Q4();
        }
    }

    public final void r5(FoldCommentActivityConfig foldCommentActivityConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, foldCommentActivityConfig) == null) {
            AbsPbActivity absPbActivity = this.a;
            if (absPbActivity instanceof PbCommentFloatActivity) {
                foldCommentActivityConfig.setBlankViewHeight(((PbCommentFloatActivity) absPbActivity).d2());
            }
        }
    }

    public void s5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.v0 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z2) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048740, this, z2) == null) {
            this.L = z2;
        }
    }

    public void u5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.n1 = z2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048719, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(a4(), viewGroup, false);
            G4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.X == null) {
                this.X = new xf<>(new v1(this), 15, 0);
            }
            return this.X;
        }
        return (xf) invokeV.objValue;
    }

    public void D4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (editorTools = this.G0) == null) {
            return;
        }
        editorTools.j();
        q4();
    }

    @Override // com.baidu.tieba.wp8
    public PbModel.h F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.U0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public boolean J4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            EditorTools editorTools = this.G0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void J5() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.wp8
    public PbModel L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.a.K1();
        }
        return (PbModel) invokeV.objValue;
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", L1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean L4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!I4() && L() != null && L().q2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.wp8
    public AbsPbActivity M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", L1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean M4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            pq8 pq8Var = this.k;
            if (pq8Var != null && pq8Var.T0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean N4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.n1;
        }
        return invokeV.booleanValue;
    }

    public final void N5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        X5();
    }

    public boolean O4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            pq8 pq8Var = this.k;
            if (pq8Var == null) {
                return false;
            }
            return pq8Var.U0();
        }
        return invokeV.booleanValue;
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && this.e0 != null) {
            M3();
            this.e0.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<RelativeLayout> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            xf<RelativeLayout> xfVar = new xf<>(new w1(this), 10, 0);
            this.Y = xfVar;
            return xfVar;
        }
        return (xf) invokeV.objValue;
    }

    public n85 S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.Q;
        }
        return (n85) invokeV.objValue;
    }

    public void S5() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && (pbFallingView = this.K) != null) {
            pbFallingView.C();
            this.K.setAnimationListener(null);
        }
    }

    public LinearLayout T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.d0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void T5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (voiceManager = this.S) != null) {
            voiceManager.stopPlay();
        }
    }

    public final void U5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.W1();
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<ImageView> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (this.V == null) {
                this.V = new xf<>(new s1(this), 8, 0);
            }
            return this.V;
        }
        return (xf) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<View> W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (this.W == null) {
                this.W = new xf<>(new u1(this), 8, 0);
            }
            return this.W;
        }
        return (xf) invokeV.objValue;
    }

    public DetailInfoFragment W3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return (DetailInfoFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void W5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            od5 od5Var = this.F0;
            if (od5Var != null) {
                s5(od5Var.y());
            }
            j5();
            this.N.G();
        }
    }

    @Override // com.baidu.tieba.yt5
    public xf<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (this.U == null) {
                this.U = TbRichTextView.H(getPageContext().getPageActivity(), 8);
            }
            return this.U;
        }
        return (xf) invokeV.objValue;
    }

    public boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.z1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public View.OnClickListener d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.A1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public xs4 f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.P;
        }
        return (xs4) invokeV.objValue;
    }

    public View.OnLongClickListener g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.H1;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener h4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.v1;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public od5 i4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.F0;
        }
        return (od5) invokeV.objValue;
    }

    public void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            i5();
            s4();
            this.H0.g();
            G5(false);
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public void l5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            this.M0 = -1;
            this.N0 = Integer.MIN_VALUE;
        }
    }

    public ReplyFragment m4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return (ReplyFragment) this.f.b(1);
            }
            return null;
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public String n4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            if (!gi.isEmpty(this.u0)) {
                return this.u0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(mm8.g());
            this.u0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            super.onStart();
            w0().onStart(getPageContext());
        }
    }

    public void q4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048731, this) != null) || this.c0 == null) {
            return;
        }
        this.b0.setVisibility(8);
        this.c0.setVisibility(8);
        this.t0.a = false;
        Z4();
        c5();
    }

    public final void q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            this.K.setFallingFeedbackListener(new z1(this));
        }
    }

    public void s4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && (editorTools = this.G0) != null) {
            editorTools.q();
        }
    }

    public void t4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && this.a.getCurrentFocus() != null) {
            hi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && L() != null && !gi.isEmpty(L().Q1())) {
            super.taskStart();
        }
    }

    public void u4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(8);
        }
    }

    public void v4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048746, this) == null) && (rightFloatLayerView = this.T0) != null) {
            rightFloatLayerView.c();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            if (this.S == null) {
                this.S = VoiceManager.instance();
            }
            return this.S;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yt5
    public xf<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            if (this.T == null) {
                this.T = new xf<>(new t1(this), 20, 0);
            }
            return this.T;
        }
        return (xf) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            PbModel K12 = this.a.K1();
            if (K12 == null) {
                return false;
            }
            return K12.r2();
        }
        return invokeV.booleanValue;
    }

    public void z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            p5(this.F0.b());
        }
    }

    public void z5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            hi.z(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void A3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition) instanceof bc9) && (bc9Var = (bc9) bdTypeRecyclerView.getListView2().getItem(firstVisiblePosition)) != null && bc9Var.n() != null) {
                        bc9Var.n().r(bc9Var.E());
                        arrayList.add(bc9Var.n());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new x1(this));
                if (((ca5) ListUtils.getItem(arrayList, 0)).e() == 1) {
                    if (!z2) {
                        Y4((ca5) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                Y4((ca5) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public final void F5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048599, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    o95.c(getPageContext(), postWriteCallBackData, 2);
                    return;
                }
                return;
            }
            if (L() != null && !L().j1()) {
                antiData.setBlock_forum_name(L().w1().l().getName());
                antiData.setBlock_forum_id(L().w1().l().getId());
                antiData.setUser_name(L().w1().X().getUserName());
                antiData.setUser_id(L().w1().X().getUserId());
            }
            AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
        }
    }

    public final void A4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            qd5 qd5Var = new qd5();
            this.E0 = qd5Var;
            w5(qd5Var);
            od5 od5Var = (od5) this.E0.a(getActivity());
            this.F0 = od5Var;
            od5Var.W(this.a.getPageContext());
            this.F0.f0(this.g1);
            this.F0.g0(this.y1);
            this.F0.Y(1);
            this.F0.d0(SendView.f);
            this.F0.h(SendView.f);
            this.F0.A(this.a.getPageContext(), bundle);
            this.F0.b().b(new vb5(getActivity()));
            this.F0.b().E(true);
            D5(true);
            if (L() != null) {
                this.F0.J(L().Y0(), L().Q1(), L().U0());
            }
            registerListener(this.Y0);
            registerListener(this.a1);
            registerListener(this.i1);
            registerListener(this.X0);
            registerListener(this.Z0);
            registerListener(this.b1);
            registerListener(this.G1);
            if (!L().j1()) {
                this.F0.q(L().Q1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.F0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (L().h2()) {
                this.F0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.F0.c0(n4());
            }
            this.C0 = new rm8();
            if (this.F0.s() != null) {
                this.C0.m(this.F0.s().i());
            }
            this.F0.V(this.W0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.B0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public final void A5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i2) != null) || L() == null) {
            return;
        }
        int F1 = L().F1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    L().k3(1);
                } else {
                    L().k3(4);
                }
            } else {
                L().k3(3);
            }
        } else {
            L().k3(2);
        }
        int F12 = L().F1();
        if (F1 == 4 || F12 == 4) {
            V4();
        }
    }

    public boolean E3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            if (this.B0 != null && L() != null && L().w1() != null && !ThreadCardUtils.isSelf(L().w1().Q()) && L().w1().d() != null) {
                return this.B0.checkPrivacyBeforeSend(L().w1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public void W4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            if (i2 == 0) {
                da9.g().h(getUniqueId(), false);
                if (l4() != null) {
                    A3(l4(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.T0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.T0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.T0) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public void X4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048661, this, z2) != null) || M() == null) {
            return;
        }
        if (this.n1 && !TbSingleton.getInstance().isNotchScreen(M()) && !TbSingleton.getInstance().isCutoutScreen(M())) {
            P5();
            UtilHelper.hideStatusBar(M(), M().getRootView());
            this.n1 = false;
        }
        this.t0.b = z2;
        Z4();
        c5();
    }

    public final void Z5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new p1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new q1(this));
        }
    }

    public final void a6(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, layoutParams) == null) {
            ViewGroup.LayoutParams layoutParams2 = this.i.getLayoutParams();
            int i2 = layoutParams2.height;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.I = ofFloat;
            ofFloat.addUpdateListener(new m1(this, layoutParams, layoutParams2, i2));
            this.I.setDuration(300L);
            this.I.start();
            this.I.addListener(new o1(this));
        }
    }

    public void d6(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) {
            DetailInfoAndReplyFragment V3 = V3();
            if (V3 != null && V3.E1() != null && V3.E1().f() != null && V3.E1().g() != null) {
                V3.E1().f().w0(z2);
                V3.E1().g().I(z2);
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

    public void p5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, editorTools) == null) {
            this.G0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091981);
            this.G0.setOnCancelClickListener(new e1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.G0.getParent() == null) {
                this.c.addView(this.G0, layoutParams);
            }
            this.G0.y(TbadkCoreApplication.getInst().getSkinType());
            this.G0.setActionListener(24, new f1(this));
            s4();
            this.F0.g(new g1(this));
        }
    }

    public final void w5(qd5 qd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048752, this, qd5Var) == null) && qd5Var != null && L() != null) {
            qd5Var.p(L().V0());
            if (L().w1() != null && L().w1().l() != null) {
                qd5Var.o(L().w1().l());
            }
            qd5Var.q("pb");
            qd5Var.r(L());
        }
    }

    public final void B4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a30);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a2f);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a2c);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a2b);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091a2e);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901f6);
            this.G.setRadius(hi.g(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new l45());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (L() != null && L().w1() != null) {
                I5(L().w1());
            }
        }
    }

    public final void F4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void H4() {
        int u2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.l == null) {
            this.l = new zp8(getBaseFragmentActivity(), this.j);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                u2 = 0;
            } else {
                u2 = hi.u(M());
            }
            Rect rect = new Rect(0, u2, hi.l(getContext()), this.j.getOriginHeight() + u2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (L4() && (videoPbViewModel.n() || L().P1() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || L().P1() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onDestroy();
            da9.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.D1);
            ItemCardHelper.w(null);
            w0().onDestory(getPageContext());
            vq8 vq8Var = this.j0;
            if (vq8Var != null) {
                vq8Var.k();
            }
            ForumManageModel forumManageModel = this.R;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            pq8 pq8Var = this.k;
            if (pq8Var != null) {
                pq8Var.V0();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.B0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            kq8 kq8Var = this.N;
            if (kq8Var != null) {
                kq8Var.p0();
            }
            hl8 hl8Var = this.H0;
            if (hl8Var != null) {
                hl8Var.m();
            }
            if (L() != null) {
                L().cancelLoadData();
                L().destory();
                if (L().s1() != null) {
                    L().s1().d();
                }
            }
            od5 od5Var = this.F0;
            if (od5Var != null) {
                od5Var.D();
            }
            this.O = null;
            mb9.d();
            S5();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.u
    public void C0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048583, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (vt5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), vt5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (um8.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new br5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.yt5
    public void Y(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048663, this, context, str, z2) == null) {
            if (um8.c(str) && L() != null && L().Q1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", L().Q1()));
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
                um8.a().e(getPageContext(), str);
            }
            this.Z = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048714, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.F0.C(i2, i3, intent);
            hl8 hl8Var = this.H0;
            if (hl8Var != null) {
                hl8Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                o4(i3, intent);
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
                                if (T3() != null) {
                                    T3().performClick();
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
                    i09.g().m(getPageContext());
                    return;
                }
                T4();
            }
        }
    }

    public final boolean C3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public void H5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) && this.c0 != null && (textView = this.f0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0557);
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

    public void g5(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048692, this, ki8Var) == null) && ki8Var != null && ki8Var.Q() != null) {
            String valueOf = String.valueOf(ki8Var.Q().getReply_num());
            if (ki8Var.Q().getReply_num() == 0) {
                valueOf = "";
            }
            this.d.F(valueOf);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            pq8 pq8Var = this.k;
            if (pq8Var != null && !pq8Var.U0()) {
                if ((this.k.isFullScreen() && configuration.orientation == 1) || (!this.k.isFullScreen() && configuration.orientation == 2)) {
                    this.k.Y(false);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (L() != null) {
                L().W2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                w0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final void C4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f092762);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802db);
            int i2 = 0;
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f09215e);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f092165);
            this.o = findViewById;
            if (this.m1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = hi.u(M());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = hi.u(M());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.z1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.z1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View view2 = this.r;
            if (!TbadkCoreApplication.isLogin()) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.p1 = new GestureDetector(getContext(), this.q1);
            this.m.setOnTouchListener(this.o1);
        }
    }

    public final boolean V5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (L() == null) {
                return true;
            }
            if (L().w1() != null && L().w1().l0()) {
                return true;
            }
            if (L().h1()) {
                MarkData S0 = L().S0();
                if (S0 != null && L().f1() && l4() != null) {
                    MarkData M0 = L().M0(l4().getFirstVisiblePosition());
                    if (M0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", S0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (M0.getPostId() != null && !M0.getPostId().equals(S0.getPostId())) {
                        zz4 zz4Var = new zz4(getBaseFragmentActivity());
                        zz4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026e));
                        zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f045e, new t(this, M0, S0, zz4Var));
                        zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038e, new u(this, S0, zz4Var));
                        zz4Var.setOnCalcelListener(new w(this));
                        zz4Var.create(getBaseFragmentActivity().getPageContext());
                        zz4Var.show();
                        return false;
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("mark", S0);
                        this.a.setResult(-1, intent2);
                    }
                }
                return true;
            }
            if (L().w1() != null && L().w1().H() != null && L().w1().H().size() > 0 && L().f1()) {
                this.a.setResult(1);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void z3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048761, this) == null) && L() != null && this.a != null) {
            od5 od5Var = this.F0;
            if (od5Var != null && od5Var.t) {
                return;
            }
            nd5 nd5Var = new nd5();
            w5(nd5Var);
            od5 od5Var2 = (od5) nd5Var.a(getContext());
            this.F0 = od5Var2;
            od5Var2.W(this.a.getPageContext());
            this.F0.f0(this.g1);
            this.F0.g0(this.y1);
            od5 od5Var3 = this.F0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            od5Var3.A(pageContext, extras);
            this.F0.b().E(true);
            p5(this.F0.b());
            if (!L().j1()) {
                this.F0.q(L().Q1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.F0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (L().h2()) {
                this.F0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.F0.c0(n4());
            }
        }
    }

    public boolean D3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if ((L() != null && L().w1().l0()) || this.B0 == null || L() == null || L().w1() == null || ThreadCardUtils.isSelf(L().w1().Q()) || L().w1().d() == null) {
                return true;
            }
            return this.B0.checkPrivacyBeforeInvokeEditor(L().w1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (!checkUpIsLogin()) {
                if (L() != null) {
                    mp8.r("c10517", L().getForumId(), 2);
                }
            } else if (!D3()) {
            } else {
                od5 od5Var = this.F0;
                if (od5Var != null && (od5Var.x() || this.F0.z())) {
                    this.F0.w(false, null);
                    return;
                }
                if (this.G0 != null) {
                    D4();
                    this.t0.a = false;
                    if (this.G0.p(2) != null) {
                        mb9.c(getPageContext(), (View) this.G0.p(2).m, false, null);
                    }
                }
                q4();
            }
        }
    }

    public void b5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048675, this) != null) || !checkUpIsLogin() || L() == null || L().w1() == null || L().w1().l() == null || B3()) {
            return;
        }
        if (L().w1().l0()) {
            F3();
            return;
        }
        od5 od5Var = this.F0;
        if (od5Var != null && od5Var.b() != null) {
            this.F0.b().C(new lb5(45, 27, null));
        }
        F3();
    }

    public final void b6() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048676, this) == null) && L() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.W(L().getForumId()) && L().w1() != null && L().w1().l() != null) {
            boolean z2 = true;
            if (L().w1().l().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                L().J0().V(L().getForumId(), L().Q1());
            }
        }
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048678, this) == null) && this.k != null && this.e != null) {
            boolean z2 = false;
            if (!L4()) {
                this.k.Y0(false);
            } else if (this.e.getCurrentItem() != 0) {
                this.k.Y0(false);
            } else if (this.t0.a()) {
                this.k.Y0(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.k.Y0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
                }
            }
        }
    }

    public final void i5() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && this.F0 != null && this.G0 != null) {
            jd5.a().c(0);
            this.F0.M();
            this.F0.K();
            if (this.F0.v() != null) {
                WriteImagesInfo v2 = this.F0.v();
                if (this.F0.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            this.F0.d0(SendView.f);
            this.F0.h(SendView.f);
            sb5 o2 = this.G0.o(23);
            sb5 o3 = this.G0.o(2);
            sb5 o4 = this.G0.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.G0.invalidate();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            super.onPause();
            this.Q0 = true;
            w0().onPause();
            pq8 pq8Var = this.k;
            if (pq8Var != null) {
                pq8Var.onBackground(true);
            }
            if (L() != null && !L().j1()) {
                this.F0.N(L().Q1());
            }
            RightFloatLayerView rightFloatLayerView = this.T0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            zp4.w().E();
            MessageManager.getInstance().unRegisterListener(this.d1);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.c1);
            MessageManager.getInstance().unRegisterListener(this.C1);
        }
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048745, this) == null) && L() != null && L().w1() != null && L().w1().Q() != null) {
            ThreadData Q = L().w1().Q();
            Q.mRecomAbTag = L().B1();
            Q.mRecomWeight = L().E1();
            Q.mRecomSource = L().D1();
            Q.mRecomExtra = L().C1();
            Q.isSubPb = L().j1();
            if (Q.getFid() == 0) {
                Q.setFid(gg.g(L().getForumId(), 0L));
            }
            StatisticItem i2 = ek5.i(getContext(), Q, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    public final void y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.I0 = new PbFakeFloorModel(getPageContext());
            PbModel L = L();
            this.I0.k0(L.a0(), L.W(), L.X(), L.V(), L.b0());
            this.I0.setFromForumId(L.getFromForumId());
            hl8 hl8Var = new hl8(getPageContext(), this.I0, this.c);
            this.H0 = hl8Var;
            hl8Var.p(new y0(this));
            this.H0.s(this.x1);
            this.I0.m0(new z0(this));
        }
    }

    public void E4(ki8 ki8Var) {
        k65 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, ki8Var) == null) && this.S0 != null && ki8Var != null && ki8Var.g() != 3 && !I4()) {
            if (ki8Var.r0()) {
                pbAdFloatViewItemData = ki8Var.d0();
            } else {
                pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
            if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
                if (!RightFloatLayerView.k()) {
                    v4();
                    return;
                }
                if (this.T0 == null) {
                    this.T0 = RightFloatLayerLottieView.E(pbAdFloatViewItemData, getContext());
                    this.S0.removeAllViews();
                    this.S0.addView(this.T0);
                }
                if ((this.K.getTag() instanceof Boolean) && !((Boolean) this.K.getTag()).booleanValue()) {
                    this.T0.setAutoCompleteShown(false);
                    this.T0.setTag(this.K);
                    this.T0.c();
                }
                if (pbAdFloatViewItemData.a()) {
                    return;
                }
                this.T0.setData(pbAdFloatViewItemData);
                this.T0.setLogoListener(new g0(this, ki8Var, pbAdFloatViewItemData));
                this.T0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
                return;
            }
            v4();
        }
    }

    public void H3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            List<bc9> list = L().w1().V().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).d0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).d0().get(i3).O())) {
                        list.get(i2).d0().remove(i3);
                        list.get(i2).j();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).k(bVar.g);
            }
            if (z2) {
                if (V3() != null) {
                    V3().h2();
                } else if (L4() && m4() != null) {
                    m4().d2();
                }
            }
        }
    }

    public final boolean U4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String s2 = m35.m().s("bubble_link", "");
            if (StringUtils.isNull(s2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                gt4.x(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), s2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean m5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof bc9)) {
                return false;
            }
            bc9 bc9Var = (bc9) obj;
            if (!TextUtils.isEmpty(bc9Var.t()) && pv4.c().g()) {
                return U4(bc9Var.O());
            }
            if (checkUpIsLogin() && L() != null && L().w1() != null) {
                hl8 hl8Var = this.H0;
                if (hl8Var != null) {
                    hl8Var.g();
                }
                aj8 aj8Var = new aj8();
                aj8Var.A(L().w1().l());
                aj8Var.E(L().w1().Q());
                aj8Var.C(bc9Var);
                this.I0.n0(aj8Var);
                this.I0.setPostId(bc9Var.O());
                R4(view2, bc9Var.r().getUserId(), "", bc9Var);
                TiebaStatic.log("c11743");
                od5 od5Var = this.F0;
                if (od5Var != null) {
                    s5(od5Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void E5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048595, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new d1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                kq8 kq8Var = this.N;
                if (kq8Var != null) {
                    kq8Var.M0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.yt5
    public void e0(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048683, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.N.r0(str);
            b05 S = this.N.S();
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

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (L().b1() || L().e1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", L().Q1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, L().Q1()));
            if (V5()) {
                this.a.finish();
            }
        }
    }

    public final void S4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048642, this) != null) || L() == null) {
            return;
        }
        ki8 w12 = L().w1();
        L().q3(true);
        xs4 xs4Var = this.P;
        if (xs4Var != null) {
            w12.L0(xs4Var.g());
        }
        if (L4()) {
            if (W3() != null) {
                W3().P1();
            }
            if (m4() != null) {
                m4().d2();
            }
        } else if (V3() != null) {
            V3().h2();
        }
    }

    public final void X5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048662, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.J = ofFloat;
        ofFloat.addUpdateListener(new k1(this));
        this.J.setDuration(200L);
        this.J.start();
        this.J.addListener(new l1(this, layoutParams));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048724, this) == null) {
            super.onResume();
            this.Q0 = false;
            w0().onResume(getPageContext());
            pq8 pq8Var = this.k;
            if (pq8Var != null) {
                pq8Var.onBackground(false);
            }
            M5();
            registerListener(this.d1);
            registerListener(this.e1);
            registerListener(this.c1);
            registerListener(this.C1);
            ItemCardHelper.w(this.F1);
            MessageManager.getInstance().registerListener(this.E1);
        }
    }

    public void G4() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ml6 ml6Var = new ml6(getActivity());
            this.J0 = ml6Var;
            ml6Var.i(this.w1);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.m1 = z2;
            C4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0902b6);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f091a32);
            this.S0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091de9);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a20);
            pq8 pq8Var = new pq8(getContext(), this.j);
            this.k = pq8Var;
            pq8Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.e1(this);
            this.k.c1(M().getRootView());
            this.k.d1(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091f90)).setMinimumHeight(((int) Math.ceil((hi.l(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091a36);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f091a2d);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091a38);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f0911a9);
            this.A = (MaskView) this.c.findViewById(R.id.mask_view);
            this.h.setOnClickListener(this.z1);
            F4();
            B4();
            x4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0927f7);
            this.K = (PbFallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090a81);
            q5();
            this.K.setAnimationListener(new s0(this));
            z4();
            y4();
            if (!this.m1 && this.n1) {
                P5();
                UtilHelper.hideStatusBar(M(), M().getRootView());
                this.n1 = false;
            }
            if (!L4()) {
                this.d.getLayoutParams().height = 0;
            }
        }
    }

    @Override // com.baidu.tieba.wp8
    public void finish() {
        CardHListViewData q2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            PbModel K12 = this.a.K1();
            if (K12 != null && K12.w1() != null && K12.w1().Q() != null && !K12.w1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = K12.w1().Q().getId();
                if (K12.isShareThread() && K12.w1().Q().originalThreadData != null) {
                    historyMessage.threadName = K12.w1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = K12.w1().Q().getTitle();
                }
                if (K12.isShareThread() && !x0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = K12.w1().l().getName();
                }
                ArrayList<bc9> H = K12.w1().H();
                if (m4() != null) {
                    i2 = m4().U1();
                } else {
                    i2 = 0;
                }
                if (H != null && i2 >= 0 && i2 < H.size()) {
                    historyMessage.postID = H.get(i2).O();
                }
                historyMessage.isHostOnly = K12.Z0();
                historyMessage.isSquence = K12.O1();
                historyMessage.isShareThread = K12.isShareThread();
                historyMessage.threadType = K12.w1().Q().getThreadType();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            od5 od5Var = this.F0;
            if (od5Var != null) {
                od5Var.D();
            }
            if (K12 != null && (K12.b1() || K12.e1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", K12.Q1());
                if (this.x0) {
                    if (this.z0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", K12.k1());
                    }
                    if (this.y0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", K12.g1());
                    }
                }
                if (K12.w1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = K12.w1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (V5()) {
                if (K12 != null) {
                    ki8 w12 = K12.w1();
                    if (w12 != null) {
                        if (w12.X() != null) {
                            w12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            w12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.A0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                dm8.b().t(rect);
                            }
                            dm8.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView l4 = l4();
                            Parcelable parcelable = null;
                            if (l4 != null) {
                                parcelable = l4.onSaveInstanceState();
                            }
                            dm8.b().n(K12.x1(), parcelable, K12.O1(), K12.Z0(), false);
                        }
                    }
                } else {
                    dm8.b().m();
                }
                U5();
            }
        }
    }

    public void I3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue == 3) {
                if (this.R.k0()) {
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
                    this.R.m0(StringHelper.JsonArrayToString(jSONArray));
                }
                this.R.n0(L().w1().l().getId(), L().w1().l().getName(), L().w1().Q().getId(), str, intValue3, intValue2, booleanValue, L().w1().Q().getBaijiahaoData(), z2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            } else if (intValue == 4 || intValue == 6) {
                if (L().R0() != null) {
                    L().R0().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                }
                if (intValue == 4) {
                    TiebaStatic.log("c10499");
                }
            }
        }
    }

    public final void Q3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048634, this, i2, gVar) == null) && gVar != null && L() != null && L().w1() != null && L().w1().Q() != null) {
            P3(this.R.getLoadDataMode(), gVar.a, gVar.b, false);
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
                    L().w1().Q().setIs_good(1);
                    L().d3(1);
                } else if (i2 == 3) {
                    L().w1().Q().setIs_good(0);
                    L().d3(0);
                } else if (i2 == 4) {
                    L().w1().Q().setIs_top(1);
                    L().e3(1);
                } else if (i2 == 5) {
                    L().w1().Q().setIs_top(0);
                    L().e3(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                hi.Q(getPageContext().getPageActivity(), string);
            }
            if (L4()) {
                if (L().w1().Q() != null && W3() != null) {
                    W3().V1();
                }
            } else if (L().w1().Q() != null && V3() != null) {
                V3().n2();
            }
        }
    }

    public final void o4(int i2, Intent intent) {
        xb5 xb5Var;
        hl8 hl8Var;
        xb5 xb5Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048711, this, i2, intent) == null) {
            if (i2 == 0) {
                s4();
                hl8 hl8Var2 = this.H0;
                if (hl8Var2 != null) {
                    hl8Var2.g();
                }
                G5(false);
            }
            j5();
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
                if (editorType == 1 && (hl8Var = this.H0) != null && hl8Var.f() != null) {
                    sd5 f2 = this.H0.f();
                    f2.d0(L().w1().Q());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    wb5 p2 = f2.b().p(6);
                    if (p2 != null && (xb5Var2 = p2.m) != null) {
                        xb5Var2.C(new lb5(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.F0.L();
            this.F0.m0(pbEditorData.getVoiceModel());
            this.F0.B(writeData);
            wb5 p3 = this.F0.b().p(6);
            if (p3 != null && (xb5Var = p3.m) != null) {
                xb5Var.C(new lb5(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.F0.G(null, null);
            }
        }
    }

    public void J3(zz4 zz4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, zz4Var, jSONArray) == null) {
            zz4Var.dismiss();
            if (L() != null && L().w1() != null && L().w1().Q() != null && L().w1().l() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(zz4Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    I3((SparseArray) zz4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void f5(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048688, this, z2, markData) != null) || L() == null) {
            return;
        }
        y5();
        L().q3(z2);
        xs4 xs4Var = this.P;
        if (xs4Var != null) {
            xs4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (L().h1()) {
            S4();
        } else if (L4()) {
            if (W3() != null) {
                W3().P1();
            }
            if (m4() != null) {
                m4().d2();
            }
        } else if (V3() != null) {
            V3().h2();
        }
    }

    public void K3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                I3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void O3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048628, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                zz4 zz4Var = new zz4(getPageContext().getPageActivity());
                zz4Var.setMessage(string);
                zz4Var.setPositiveButton(R.string.dialog_known, new r(this));
                zz4Var.setCancelable(true);
                zz4Var.create(getPageContext());
                zz4Var.show();
            } else {
                P3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<bc9> H = L().w1().H();
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
                    L().w1().Q().setReply_num(L().w1().Q().getReply_num() - 1);
                    if (V3() != null) {
                        V3().h2();
                    } else if (L4() && m4() != null) {
                        m4().d2();
                    }
                } else if (i3 == 0) {
                    G3();
                } else if (i3 == 2) {
                    ArrayList<bc9> H2 = L().w1().H();
                    int size2 = H2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= H2.get(i4).d0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i4).d0().get(i5).O())) {
                                H2.get(i4).d0().remove(i5);
                                H2.get(i4).j();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        H2.get(i4).k(bVar.g);
                    }
                    if (z3) {
                        if (V3() != null) {
                            V3().h2();
                        } else if (L4() && m4() != null) {
                            m4().d2();
                        }
                    }
                    H3(bVar);
                }
            }
        }
    }

    public void P3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1314));
            } else if (z3) {
                if (gi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0d1f);
                }
                showToast(str);
            }
        }
    }

    public final void P4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final String R3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0eb0);
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

    public bc9 X3(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048660, this, ki8Var)) == null) {
            bc9 bc9Var = null;
            if (ki8Var == null) {
                return null;
            }
            if (ki8Var.a0() != null) {
                return ki8Var.a0();
            }
            if (!ListUtils.isEmpty(ki8Var.H())) {
                Iterator<bc9> it = ki8Var.H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bc9 next = it.next();
                    if (next != null && next.E() == 1) {
                        bc9Var = next;
                        break;
                    }
                }
            }
            if (bc9Var == null) {
                bc9Var = ki8Var.j();
            }
            if (bc9Var == null) {
                bc9Var = k4(ki8Var);
            }
            if (bc9Var != null && bc9Var.r() != null && bc9Var.r().getUserTbVipInfoData() != null && bc9Var.r().getUserTbVipInfoData().getvipIntro() != null) {
                bc9Var.r().getGodUserData().setIntro(bc9Var.r().getUserTbVipInfoData().getvipIntro());
            }
            return bc9Var;
        }
        return (bc9) invokeL.objValue;
    }

    public final void a5(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048672, this, ki8Var) != null) || ki8Var == null) {
            return;
        }
        ThreadData Q = ki8Var.Q();
        if (Q != null && Q.isUgcThreadType()) {
            z3();
        } else {
            w5(this.E0);
        }
        od5 od5Var = this.F0;
        if (od5Var != null) {
            s5(od5Var.y());
            this.F0.H(ki8Var.d());
            this.F0.I(ki8Var.l(), ki8Var.X());
            this.F0.k0(Q);
            if (L() != null) {
                this.F0.J(L().Y0(), L().Q1(), L().U0());
            }
            if (Q != null) {
                this.F0.Z(Q.isMutiForumThread());
            }
        }
    }

    public void c6(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, ki8Var) == null) {
            if (ki8Var != null && AntiHelper.o(ki8Var.Q())) {
                vq8 vq8Var = this.j0;
                if (vq8Var != null) {
                    vq8Var.l(false);
                    this.j0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.i0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.i0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            vq8 vq8Var2 = this.j0;
            if (vq8Var2 != null && vq8Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.i0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.i0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void e5(ki8 ki8Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048686, this, ki8Var) == null) && ki8Var != null && ki8Var.Q() != null) {
            c6(ki8Var);
            ImageView imageView = this.h0;
            if (ki8Var.l0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (ki8Var.r()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String R3 = R3(ki8Var.Q().getReply_num());
            TextView textView = this.r0;
            if (textView != null) {
                textView.setText(R3);
            }
            TextView textView2 = this.s0;
            if (textView2 != null) {
                textView2.setText(R3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, ki8Var.Q()));
        }
    }

    public final bc9 k4(ki8 ki8Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, ki8Var)) == null) {
            if (ki8Var != null && ki8Var.Q() != null && ki8Var.Q().getAuthor() != null) {
                bc9 bc9Var = new bc9();
                MetaData author = ki8Var.Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = ki8Var.Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                bc9Var.J0(1);
                bc9Var.P0(ki8Var.Q().getFirstPostId());
                bc9Var.g1(ki8Var.Q().getTitle());
                bc9Var.f1(ki8Var.Q().getCreateTime());
                bc9Var.G0(author);
                return bc9Var;
            }
            return null;
        }
        return (bc9) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            A4(bundle);
            w0().onCreate(getPageContext());
            r35 r35Var = new r35();
            this.O = r35Var;
            r35Var.a = 1000L;
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
            registerListener(this.D1);
            this.t = new ke6(getPageContext());
            da9.g().i(getUniqueId());
        }
    }

    public void r4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048733, this, z2) == null) && this.c0 != null && this.f0 != null) {
            if (L() != null && L().w1() != null) {
                this.f0.setText(TbSingleton.getInstance().getAdVertiComment(L().w1().r0(), L().w1().s0(), n4()));
            } else {
                this.f0.setText(n4());
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

    public final void y3(nq8 nq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048758, this, nq8Var) == null) && nq8Var != null && this.w == null) {
            this.w = nq8Var;
            this.C.setText(nq8Var.getTitle());
            this.D.setText(nq8Var.i());
            String h2 = nq8Var.h();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(h2)) {
                h2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(h2);
            int i2 = 0;
            this.G.M(nq8Var.f(), 10, false);
            View view2 = this.H;
            if (!nq8Var.k()) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            jg.a().postDelayed(new j1(this), nq8Var.c().longValue() * 1000);
        }
    }

    public final void R4(View view2, String str, String str2, bc9 bc9Var) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048639, this, view2, str, str2, bc9Var) != null) || view2 == null || str == null || str2 == null || B3() || !D3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.K0);
            this.L0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.H0 != null && bc9Var != null) {
            if (bc9Var.Z() != null) {
                str3 = bc9Var.Z().toString();
            } else {
                str3 = "";
            }
            this.H0.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), bc9Var.r().getName_show(), str3));
        }
        if (L() != null && L().w1() != null && L().w1().l0()) {
            jg.a().postDelayed(new h1(this, str, str2), 0L);
            return;
        }
        jg.a().postDelayed(new i1(this, str, str2), 0L);
        if (L() == null || L().w1() == null || L().w1().l() == null) {
        }
    }

    public final void R5(bc9 bc9Var, bc9 bc9Var2, boolean z2, boolean z3) {
        String str;
        int i2;
        AbsPbActivity.e p2;
        boolean z4;
        boolean z5;
        bc9 X3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{bc9Var, bc9Var2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String Q1 = L().Q1();
            String O = bc9Var.O();
            if (bc9Var2 != null) {
                str = bc9Var2.O();
            } else {
                str = "";
            }
            if (L().w1() != null) {
                i2 = L().w1().Y();
            } else {
                i2 = 0;
            }
            if (m4() != null && m4().b2() != null) {
                p2 = m4().b2().p(O);
            } else if (V3() != null && V3().d2() != null) {
                p2 = V3().d2().p(O);
            } else {
                return;
            }
            AbsPbActivity.e eVar = p2;
            if (bc9Var != null && L() != null && L().w1() != null && eVar != null) {
                if (Y3() != 1 && Y3() != 2 && Y3() != 3 && Y3() != 4 && Y3() != 5) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(Q1, O, "pb", true, I4(), null, false, str, i2, bc9Var.g0(), L().w1().d(), false, bc9Var.r().getIconInfo(), Y3(), z4).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
                if (z3) {
                    addBigImageData.setHighLightPostId(str);
                    z5 = true;
                    addBigImageData.setKeyIsUseSpid(true);
                } else {
                    z5 = true;
                }
                addBigImageData.setKeyFromForumId(L().getForumId());
                addBigImageData.setTiebaPlusData(L().a0(), L().W(), L().X(), L().V(), L().b0());
                addBigImageData.setBjhData(L().O0());
                addBigImageData.setKeyPageStartFrom(L().v1());
                addBigImageData.setFromFrsForumId(L().getFromForumId());
                addBigImageData.setWorksInfoData(L().V1());
                addBigImageData.setIsOpenEditor(z2);
                if (L().w1().o() != null) {
                    addBigImageData.setHasForumRule(L().w1().o().has_forum_rule.intValue());
                }
                if (L().w1().X() != null) {
                    addBigImageData.setIsManager(L().w1().X().getIs_manager());
                }
                if (L().w1().l().getDeletedReasonInfo() != null) {
                    addBigImageData.setDeletedReasonInfoIsGrayCaleForum(L().w1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                    addBigImageData.setDeletedReasonInfoIsIsBoomGrow(L().w1().l().getDeletedReasonInfo().is_boomgrow.intValue());
                }
                if (L().w1().l() != null) {
                    addBigImageData.setForumHeadUrl(L().w1().l().getImage_url());
                    addBigImageData.setUserLevel(L().w1().l().getUser_level());
                }
                if (L() != null && (X3 = X3(L().w1())) != null) {
                    if (!X3.S && !bc9Var.S) {
                        z5 = false;
                    }
                    addBigImageData.setMainPostMaskVisibly(z5);
                }
                if (I4() && this.a.getIntent() != null) {
                    addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                }
                addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public void d5(boolean z2, int i2, int i3, int i4, ki8 ki8Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), ki8Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof vp8) {
                    ((vp8) baseFragment).s1(z2, i2, i3, i4, ki8Var, str, i5);
                }
            }
            s1(z2, i2, i3, i4, ki8Var, str, i5);
        }
    }

    public SparseArray<Object> e4(ki8 ki8Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        bc9 X3;
        boolean z3;
        nx4 nx4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048685, this, new Object[]{ki8Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (ki8Var == null || (X3 = X3(ki8Var)) == null) {
                return null;
            }
            String userId = X3.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, X3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ki8Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (X3.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, X3.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, X3.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, X3.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, X3.O());
                }
                sparseArray.put(R.id.tag_del_post_id, X3.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(ki8Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<iz4> p2 = ki8Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (iz4 iz4Var : p2) {
                        if (iz4Var != null && !StringUtils.isNull(iz4Var.d()) && (nx4Var = iz4Var.f) != null && nx4Var.a && !nx4Var.c && ((i3 = nx4Var.b) == 1 || i3 == 2)) {
                            sb.append(gi.cutString(iz4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f06bd));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04d3), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void h5(aj8 aj8Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048695, this, aj8Var) == null) && L() != null && L().w1() != null && aj8Var.i() != null) {
            String O = aj8Var.i().O();
            ArrayList<bc9> H = L().w1().H();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= H.size()) {
                    break;
                }
                bc9 bc9Var = H.get(i2);
                if (bc9Var.O() != null && bc9Var.O().equals(O)) {
                    ArrayList<bc9> k2 = aj8Var.k();
                    bc9Var.d1(aj8Var.m());
                    if (bc9Var.d0() != null && k2 != null) {
                        Iterator<bc9> it = k2.iterator();
                        while (it.hasNext()) {
                            bc9 next = it.next();
                            if (bc9Var.l0() != null && next != null && next.r() != null && (metaData = bc9Var.l0().get(next.r().getUserId())) != null) {
                                next.G0(metaData);
                                next.T0(true);
                                next.m1(getPageContext(), L().s2(metaData.getUserId()));
                            }
                        }
                        if (k2.size() != bc9Var.d0().size()) {
                            z3 = true;
                        }
                        if (!bc9Var.s0(true)) {
                            bc9Var.d0().clear();
                            bc9Var.d0().addAll(k2);
                        }
                        z2 = z3;
                    }
                    if (bc9Var.y() != null) {
                        bc9Var.E0();
                    }
                } else {
                    i2++;
                }
            }
            if (!L().f1() && z2) {
                if (L4() && m4() != null) {
                    m4().d2();
                } else if (V3() != null) {
                    V3().h2();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09076e));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            a5(videoPbViewModel.c());
            E4(videoPbViewModel.c());
            g5(videoPbViewModel.c());
            if (L() != null && L().w1() != null) {
                boolean f12 = L().f1();
                ki8 w12 = L().w1();
                if (f12) {
                    bc9 X3 = X3(w12);
                    if (w12.v() != null && !w12.v().equals(X3.O()) && this.e != null) {
                        if (L4()) {
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
            this.a.M1().e(this.R0);
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
    public final void x3(ThreadData threadData) {
        double d2;
        int ceil;
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect N0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, threadData) == null) {
            double l2 = hi.l(getContext());
            double j2 = (2.0d * l2) / hi.j(getContext());
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                int intValue = threadData.getThreadVideoInfo().video_width.intValue();
                int intValue2 = threadData.getThreadVideoInfo().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= j2) {
                        j2 = d2;
                    }
                    ceil = (int) Math.ceil(l2 / j2);
                    if (L() == null && (N0 = L().N0()) != null) {
                        i2 = N0.height();
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
                    if (L4()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, K1);
                        } else {
                            layoutParams3.height = K1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (L4()) {
                        ceil += K1;
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
            d2 = 1.7777777777777777d;
            if (d2 > 1.7777777777777777d) {
            }
            if (d2 >= j2) {
            }
            ceil = (int) Math.ceil(l2 / j2);
            if (L() == null) {
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
            if (L4()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (L4()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i3 == 0) {
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            fv4 layoutMode = getBaseFragmentActivity().getLayoutMode();
            if (i2 != 4) {
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
            rm8 rm8Var = this.C0;
            if (rm8Var != null) {
                rm8Var.i();
            }
            zp8 zp8Var = this.l;
            if (zp8Var == null || !zp8Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.G0;
            if (editorTools != null) {
                editorTools.y(i2);
            }
            hl8 hl8Var = this.H0;
            if (hl8Var != null) {
                hl8Var.l(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.T0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.n();
            }
            LinearLayout linearLayout = this.d0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(hi.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (L() != null && L().h1()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.g0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (L() != null) {
                c6(L().w1());
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
            SkinManager.setBackgroundShapeDrawable(this.r0, hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (V3() != null) {
                V3().onChangeSkinType(i2);
            } else if (L4() && m4() != null) {
                m4().onChangeSkinType(i2);
            }
            if (W3() != null) {
                W3().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(hi.g(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            T5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        pq8 pq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048721, this, i2, keyEvent)) == null) {
            if (!this.m1 && (this.n1 || M4())) {
                P5();
                UtilHelper.hideStatusBar(M(), M().getRootView());
                this.n1 = false;
                pq8 pq8Var2 = this.k;
                if (pq8Var2 != null) {
                    pq8Var2.Z0(false);
                }
            }
            if (i2 == 4) {
                pq8 pq8Var3 = this.k;
                if (pq8Var3 == null) {
                    return false;
                }
                return pq8Var3.onBackPress();
            } else if (i2 == 24) {
                pq8 pq8Var4 = this.k;
                if (pq8Var4 == null) {
                    return false;
                }
                return pq8Var4.onVolumeUp();
            } else if (i2 != 25 || (pq8Var = this.k) == null) {
                return false;
            } else {
                return pq8Var.W0();
            }
        }
        return invokeIL.booleanValue;
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
    public void p4(boolean z2) {
        ki8 w12;
        int i2;
        vq8 vq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048729, this, z2) == null) && L() != null && this.N != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (w12 = L().w1()) == null) {
                return;
            }
            ThreadData Q = w12.Q();
            int i3 = 1;
            if (Q != null && Q.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", L().Q1()).param("fid", w12.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (I4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", L().getForumId());
                    statisticItem.param("tid", L().Q1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", Z3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 14);
                    statisticItem.param("obj_locate", Y3());
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
                statisticItem2.param("tid", L().Q1());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("fid", L().getForumId());
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
                    if (Q.getBaijiahaoData() != null && !gi.isEmpty(Q.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, Q.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (M() != null) {
                    ek5.e(M(), statisticItem2);
                }
                vq8Var = this.j0;
                if (vq8Var != null) {
                    statisticItem2.param("obj_param1", vq8Var.g());
                }
                TiebaStatic.log(statisticItem2);
                if (hi.F()) {
                    showToast(R.string.obfuscated_res_0x7f0f0d1f);
                    return;
                } else if (L().w1() == null) {
                    hi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec8));
                    return;
                } else {
                    ArrayList<bc9> H = w12.H();
                    if ((H == null || H.size() <= 0) && L().O1()) {
                        hi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ec8));
                        return;
                    }
                    this.N.G();
                    T5();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), Q)) {
                        return;
                    }
                    vq8 vq8Var2 = this.j0;
                    if (vq8Var2 != null) {
                        vq8Var2.l(false);
                        c6(w12);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.j0.i()) {
                            this.j0.m(false);
                            w4(d95.a(), this.j0.g());
                            return;
                        }
                        L5(i3);
                        return;
                    }
                    this.N.D0();
                    L().Q0().T(CheckRealNameModel.TYPE_PB_SHARE, 6);
                    return;
                }
            }
            i2 = 1;
            StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem22.param("tid", L().Q1());
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem22.param("fid", L().getForumId());
            if (!z2) {
            }
            statisticItem22.param("obj_name", i2);
            statisticItem22.param("obj_type", 2);
            if (Q != null) {
            }
            if (!gi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (M() != null) {
            }
            vq8Var = this.j0;
            if (vq8Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (hi.F()) {
            }
        }
    }

    public final void w3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048750, this, z2, str) == null) && L() != null && L().w1() != null && L().w1().Q() != null) {
            ThreadData Q = L().w1().Q();
            Q.mRecomAbTag = L().B1();
            Q.mRecomWeight = L().E1();
            Q.mRecomSource = L().D1();
            Q.mRecomExtra = L().C1();
            if (Q.getFid() == 0) {
                Q.setFid(gg.g(L().getForumId(), 0L));
            }
            StatisticItem i2 = ek5.i(getContext(), Q, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = ek5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (Q.isVideoThreadType()) {
                    if (dq5.f(str) > 40) {
                        str2 = dq5.n(str, 40);
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
                zj5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (Y3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (Y3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (Y3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (Y3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (Y3() == 7) {
                    i2.param("obj_locate", 7);
                } else {
                    i2.param("obj_locate", 6);
                }
                i2.addParam("obj_type", 1);
                i2.addParam("tid", L().Q1());
                i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i2.addParam("fid", L().w1().m());
                TiebaStatic.log(i2);
            }
            StatisticItem i3 = ek5.i(getContext(), Q, "c14180");
            if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i3.addParam("obj_type", 2);
            } else {
                i3.addParam("obj_type", 1);
            }
            i3.param("tid", L().Q1());
            i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i3.param("fid", L().w1().m());
            if (l2 != null) {
                i3.param("obj_source", l2.tabType);
            }
            TiebaStatic.log(i3);
            StatisticItem i4 = ek5.i(getContext(), Q, "c14303");
            if (i4 != null) {
                if (Y3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (Y3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (Y3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (Y3() == 4) {
                    i4.param("obj_locate", 4);
                }
                i4.param("tid", L().Q1());
                i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                i4.param("fid", L().w1().m());
                i4.param("obj_type", 1);
            }
            TiebaStatic.log(i4);
        }
    }
}
