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
import com.baidu.tieba.a48;
import com.baidu.tieba.ah;
import com.baidu.tieba.at4;
import com.baidu.tieba.bs8;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.ci8;
import com.baidu.tieba.d35;
import com.baidu.tieba.dr4;
import com.baidu.tieba.e38;
import com.baidu.tieba.f46;
import com.baidu.tieba.f55;
import com.baidu.tieba.g25;
import com.baidu.tieba.g88;
import com.baidu.tieba.h08;
import com.baidu.tieba.h68;
import com.baidu.tieba.hj5;
import com.baidu.tieba.i18;
import com.baidu.tieba.i45;
import com.baidu.tieba.i78;
import com.baidu.tieba.ik5;
import com.baidu.tieba.j48;
import com.baidu.tieba.j88;
import com.baidu.tieba.jm4;
import com.baidu.tieba.jp4;
import com.baidu.tieba.k68;
import com.baidu.tieba.k85;
import com.baidu.tieba.k88;
import com.baidu.tieba.km4;
import com.baidu.tieba.l85;
import com.baidu.tieba.l88;
import com.baidu.tieba.ll5;
import com.baidu.tieba.lv4;
import com.baidu.tieba.m05;
import com.baidu.tieba.m65;
import com.baidu.tieba.m85;
import com.baidu.tieba.mj5;
import com.baidu.tieba.mk5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n65;
import com.baidu.tieba.n85;
import com.baidu.tieba.nq8;
import com.baidu.tieba.nv4;
import com.baidu.tieba.nz7;
import com.baidu.tieba.o48;
import com.baidu.tieba.o85;
import com.baidu.tieba.og;
import com.baidu.tieba.p15;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pe5;
import com.baidu.tieba.pg;
import com.baidu.tieba.pk5;
import com.baidu.tieba.q85;
import com.baidu.tieba.q9;
import com.baidu.tieba.qz4;
import com.baidu.tieba.r45;
import com.baidu.tieba.r48;
import com.baidu.tieba.r78;
import com.baidu.tieba.r88;
import com.baidu.tieba.ry4;
import com.baidu.tieba.rz8;
import com.baidu.tieba.s35;
import com.baidu.tieba.s78;
import com.baidu.tieba.s85;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.sp4;
import com.baidu.tieba.t65;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tn5;
import com.baidu.tieba.tq4;
import com.baidu.tieba.ue5;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.uu4;
import com.baidu.tieba.v78;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vt6;
import com.baidu.tieba.w65;
import com.baidu.tieba.wa6;
import com.baidu.tieba.wn5;
import com.baidu.tieba.wr8;
import com.baidu.tieba.wy4;
import com.baidu.tieba.x08;
import com.baidu.tieba.x55;
import com.baidu.tieba.x65;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.y65;
import com.baidu.tieba.yi;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements wn5, VoiceManager.j, s78, TbRichTextView.s, r78 {
    public static /* synthetic */ Interceptable $ic;
    public static final int K1;
    public static final int L1;
    public static int M1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public ReplyPrivacyCheckController A0;
    public final View.OnClickListener A1;
    public View.OnClickListener B;
    public vt6 B0;
    public View.OnClickListener B1;
    public TextView C;
    public vt6 C0;
    public final AdapterView.OnItemClickListener C1;
    public TextView D;
    public o48 D0;
    public CustomMessageListener D1;
    public ImageView E;
    public PermissionJudgePolicy E0;
    public CustomMessageListener E1;
    public TBSpecificationBtn F;
    public q85 F0;
    public CustomMessageListener F1;
    public TbImageView G;
    public o85 G0;
    public final ItemCardHelper.c G1;
    public View H;
    public EditorTools H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public e38 I0;
    public final View.OnLongClickListener I1;
    public ValueAnimator J;
    public PbFakeFloorModel J0;
    public SortSwitchButton.f J1;
    public FallingView K;
    public wa6 K0;
    public boolean L;
    public int[] L0;
    public View M;
    public int M0;
    public g88 N;
    public int N0;
    public wy4 O;
    public int O0;
    public jp4 P;
    public int P0;
    public s35 Q;
    public int Q0;
    public ForumManageModel R;
    public boolean R0;
    public VoiceManager S;
    @NonNull
    public TiePlusEventController.f S0;
    public og<GifView> T;
    public FrameLayout T0;
    public og<TextView> U;
    public RightFloatLayerView U0;
    public og<ImageView> V;
    public final PbModel.h V0;
    public og<View> W;
    public final jp4.a W0;
    public og<LinearLayout> X;
    public l85 X0;
    public og<RelativeLayout> Y;
    public final CustomMessageListener Y0;
    public boolean Z;
    public CustomMessageListener Z0;
    public AbsPbActivity a;
    public LinearLayout a0;
    public final CustomMessageListener a1;
    public long b;
    public View b0;
    public CustomMessageListener b1;
    public RelativeLayout c;
    public View c0;
    public HttpMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public LinearLayout d0;
    public CustomMessageListener d1;
    public CustomViewPager e;
    public ImageView e0;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public TextView f0;
    public CustomMessageListener f1;
    public View g;
    public ImageView g0;
    public l85 g1;
    public View h;
    public ImageView h0;
    public final NewWriteModel.d h1;
    public AppBarLayout i;
    public ImageView i0;
    public View.OnClickListener i1;
    public VideoContainerLayout j;
    public r88 j0;
    public CustomMessageListener j1;
    public l88 k;
    public int k1;
    public v78 l;
    public float l1;
    public NavigationBar m;
    public float m1;
    public View n;
    public boolean n1;
    public View o;
    public boolean o1;
    public View p;
    public View.OnTouchListener p1;
    public ImageView q;
    public TextView q0;
    public GestureDetector q1;
    public View r;
    public TextView r0;
    public GestureDetector.SimpleOnGestureListener r1;
    public ImageView s;
    public d2 s0;
    public Runnable s1;
    public f46 t;
    public String t0;
    public ObjectAnimator t1;
    public boolean u;
    public boolean u0;
    public ObjectAnimator u1;
    public View v;
    public String v0;
    public final q9 v1;
    public j88 w;
    public boolean w0;
    public View.OnTouchListener w1;
    public View x;
    public boolean x0;
    public final wa6.b x1;
    public View y;
    public boolean y0;
    public NewWriteModel.d y1;
    public View z;
    public boolean z0;
    public m85 z1;

    public abstract boolean A4();

    @Override // com.baidu.tieba.wn5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public abstract boolean C4();

    @Override // com.baidu.tieba.s78
    public AbsVideoPbFragment J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public abstract int Q3();

    @Override // com.baidu.tieba.wn5
    public void S(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, context, str) == null) {
        }
    }

    public abstract int S3();

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i b1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public final int b4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i2)) == null) {
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

    @Override // com.baidu.tieba.wn5
    public void d1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048673, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tieba.wn5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<ItemCardView> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r78
    public void n1(boolean z2, int i2, int i3, int i4, h08 h08Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), h08Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public abstract void o5(boolean z2);

    @Override // com.baidu.tieba.s78
    public PbFragment r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<TiebaPlusRecommendCard> w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return null;
        }
        return (og) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class j1 implements vt6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        @Override // com.baidu.tieba.vt6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.vt6.d
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
            public class C0406a implements TextWatcher {
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

                public C0406a(a aVar) {
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
                    o48 o48Var;
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (o48Var = this.a.a.c.D0) != null && o48Var.g() != null) {
                        if (!this.a.a.c.D0.g().e()) {
                            this.a.a.c.D0.b(false);
                        }
                        this.a.a.c.D0.g().l(false);
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
                    int j = yi.j(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        g = yi.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = j / 2;
                        g = yi.g(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i2 = j - (i + g);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i3 = (absVideoPbFragment.L0[1] + absVideoPbFragment.M0) - i2;
                    if (absVideoPbFragment.d4() != null) {
                        this.a.c.d4().smoothScrollBy(0, i3);
                    }
                    if (this.a.c.I0 != null) {
                        this.a.c.G0.b().setVisibility(8);
                        z = (this.a.c.M() == null || this.a.c.M().l1() == null || this.a.c.M().l1().Q() == null || !this.a.c.M().l1().Q().isBjh()) ? false : false;
                        e38 e38Var = this.a.c.I0;
                        j1 j1Var = this.a;
                        e38Var.t(j1Var.a, j1Var.b, j1Var.c.f4(), z);
                        this.a.c.I0.q(this.a.c.Q3());
                        s85 f = this.a.c.I0.f();
                        if (f != null && this.a.c.M() != null && this.a.c.M().l1() != null) {
                            f.H(this.a.c.M().l1().d());
                            f.d0(this.a.c.M().l1().Q());
                        }
                        if (this.a.c.D0.f() == null && this.a.c.I0.f().u() != null) {
                            this.a.c.I0.f().u().g(new C0406a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.D0.n(absVideoPbFragment2.I0.f().u().i());
                            this.a.c.I0.f().N(this.a.c.g1);
                        }
                    }
                    this.a.c.i4();
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

        @Override // com.baidu.tieba.vt6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            ah.a().postDelayed(new a(this), 0L);
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
                    this.b.a.S4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        statisticItem.param("fid", this.a.M().l1().m());
                    }
                    statisticItem.param("tid", this.a.M().F1());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.M5();
                this.a.q5(z, postWriteCallBackData);
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (writeData != null) {
                    m05.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (z) {
                    if (PbReplySwitch.getInOn() && this.a.M() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                        this.a.M().t0(postWriteCallBackData.getPostId());
                        if (this.a.D4() && this.a.e4() != null) {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.P0 = absVideoPbFragment.e4().N1();
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.Q0 = absVideoPbFragment2.e4().O1();
                            this.a.M().K2(this.a.P0, this.a.Q0);
                        } else if (this.a.N3() != null) {
                            AbsVideoPbFragment absVideoPbFragment3 = this.a;
                            absVideoPbFragment3.P0 = absVideoPbFragment3.N3().P1();
                            AbsVideoPbFragment absVideoPbFragment4 = this.a;
                            absVideoPbFragment4.Q0 = absVideoPbFragment4.N3().Q1();
                            this.a.M().K2(this.a.P0, this.a.Q0);
                        }
                    }
                    if (this.a.e != null) {
                        if (this.a.D4()) {
                            this.a.e.setCurrentItem(1);
                        } else {
                            this.a.e.setCurrentItem(0);
                        }
                    }
                    this.a.N.F();
                    this.a.D0.c();
                    if (this.a.G0 != null) {
                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                        absVideoPbFragment5.l5(absVideoPbFragment5.G0.y());
                    }
                    this.a.k4();
                    this.a.z5(true);
                    this.a.M().O1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                    this.a.y5(antiData, postWriteCallBackData);
                    if (writeData == null) {
                        return;
                    }
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (this.a.D4() && this.a.e4() != null) {
                                this.a.e4().W1();
                            } else if (this.a.N3() != null) {
                                this.a.N3().Z1();
                            }
                        }
                    } else if (this.a.M().O0()) {
                        h08 l1 = this.a.M().l1();
                        if (l1 != null && l1.Q() != null && l1.Q().getAuthor() != null && (userId = l1.Q().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.M().c3()) {
                            this.a.s5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.M().c3()) {
                        this.a.s5();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    }
                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                    if (writeData != null && writeData.getType() == 2) {
                        z2 = true;
                    }
                    if (writeData != null) {
                        str2 = writeData.getContent();
                    }
                    absVideoPbFragment6.o3(z2, str2);
                } else if (i == 220015) {
                    this.a.showToast(str);
                    if (this.a.G0.x() || this.a.G0.z()) {
                        this.a.G0.w(false, postWriteCallBackData);
                    }
                    this.a.D0.k(postWriteCallBackData);
                } else if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.A0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    lv4 lv4Var = new lv4(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        lv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        lv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new b(this));
                    lv4Var.setPositiveButton(R.string.open_now, new c(this));
                    lv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (d35Var != null || i == 227001) {
                } else {
                    this.a.x5(i, antiData, str);
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
                o48 o48Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (o48Var = this.a.c.D0) != null && o48Var.g() != null) {
                    if (!this.a.c.D0.g().e()) {
                        this.a.c.D0.b(false);
                    }
                    this.a.c.D0.g().l(false);
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
                int j = yi.j(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = j / 2;
                    g = yi.g(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i2 = j - (i + g);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i3 = (absVideoPbFragment.L0[1] + absVideoPbFragment.M0) - i2;
                if (absVideoPbFragment.d4() != null) {
                    this.c.d4().smoothScrollBy(0, i3);
                }
                if (this.c.I0 != null) {
                    this.c.G0.b().setVisibility(8);
                    this.c.I0.t(this.a, this.b, this.c.f4(), (this.c.M() == null || this.c.M().l1() == null || this.c.M().l1().Q() == null || !this.c.M().l1().Q().isBjh()) ? false : false);
                    this.c.I0.q(this.c.Q3());
                    s85 f = this.c.I0.f();
                    if (f != null && this.c.M() != null && this.c.M().l1() != null) {
                        f.H(this.c.M().l1().d());
                        f.d0(this.c.M().l1().Q());
                    }
                    if (this.c.D0.f() == null && this.c.I0.f().u() != null) {
                        this.c.I0.f().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.D0.n(absVideoPbFragment2.I0.f().u().i());
                        this.c.I0.f().N(this.c.g1);
                    }
                }
                this.c.i4();
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
                    this.b.a.S4(postWriteCallBackData.getmAdverSegmentData(), 2);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements lv4.e {
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

            @Override // com.baidu.tieba.lv4.e
            public void onClick(lv4 lv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                    lv4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                    m05.b(writeData.getContent(), "4");
                }
                if (z) {
                    o48 o48Var = this.a.D0;
                    if (o48Var != null) {
                        o48Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        r45.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                        ah.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                        return;
                    }
                    return;
                }
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                }
                if (i == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.A0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    lv4 lv4Var = new lv4(this.a.getActivity());
                    if (xi.isEmpty(postWriteCallBackData.getErrorString())) {
                        lv4Var.setMessage(this.a.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        lv4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new b(this));
                    lv4Var.setPositiveButton(R.string.open_now, new c(this));
                    lv4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    if (absVideoPbFragment.D0 != null) {
                        if (absVideoPbFragment.I0 != null && this.a.I0.f() != null && this.a.I0.f().y()) {
                            this.a.I0.f().w(postWriteCallBackData);
                        }
                        this.a.D0.l(postWriteCallBackData);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.R0) {
                return;
            }
            this.a.F5();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements mj5<ShareItem> {
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
        @Override // com.baidu.tieba.mj5
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
                this.a.N.p0(true);
                return this.a.N.P().onLongClick(view2);
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
            String f4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.M() != null && this.a.M().T1()) {
                    f4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    f4 = this.a.f4();
                }
                if (!StringUtils.isNull(f4) && this.a.M() != null && this.a.M().l1() != null) {
                    f4 = TbSingleton.getInstance().getAdVertiComment(this.a.M().l1().r0(), this.a.M().l1().s0(), f4);
                }
                if (this.a.G0 != null) {
                    this.a.G0.c0(f4);
                }
                if (this.a.f0 != null) {
                    this.a.f0.setText(f4);
                }
                this.a.z5(false);
                this.a.D5();
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
            this.a.U5();
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
            g88 g88Var = this.a.N;
            if (g88Var != null) {
                if (z) {
                    if (z2) {
                        sparseArray.put(R.id.tag_from, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.N.l0(view2);
                } else if (z2) {
                    sparseArray.put(R.id.tag_from, 0);
                    sparseArray.put(R.id.tag_check_mute_from, 1);
                    this.a.N.B(sparseArray);
                } else if (z3) {
                    g88Var.g0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
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
                g88 g88Var = this.a.N;
                if (g88Var != null) {
                    g88Var.F();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.network_not_available);
                    return false;
                }
                if (this.a.M() != null && !this.a.M().isLoading) {
                    this.a.M5();
                    this.a.s5();
                    z = true;
                    if (this.a.M().l1() != null && this.a.M().l1().f != null && this.a.M().l1().f.size() > i) {
                        int intValue = this.a.M().l1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.M().G1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.M().f3(intValue)) {
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
                if (this.a.G0 != null) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.l5(absVideoPbFragment.G0.y());
                }
                this.a.d5();
                this.a.N.F();
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
                    this.a.t5(type);
                    return;
                }
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
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
                absVideoPbFragment.h5(absVideoPbFragment.b4(i));
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
        public void b(h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h08Var) == null) {
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
        public void c(boolean z, int i, int i2, int i3, h08 h08Var, String str, int i4) {
            String f4;
            t65 n;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), h08Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fd));
                }
                this.a.r5();
                this.a.m4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.z5(false);
                if (z && h08Var != null) {
                    ThreadData Q = h08Var.Q();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(h08Var, i2);
                    this.a.U4(h08Var);
                    this.a.B5(h08Var);
                    this.a.a5(h08Var);
                    this.a.X4(z, i, i2, i3, h08Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(h08Var.X().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(h08Var.X().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(h08Var.X().getBimg_end_time());
                    if (h08Var.H() != null && h08Var.H().size() >= 1 && h08Var.H().get(0) != null) {
                        this.a.M().L2(h08Var.H().get(0).M());
                    } else if (h08Var.a0() != null) {
                        this.a.M().L2(h08Var.a0().M());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(h08Var.r());
                    }
                    AntiData d = h08Var.d();
                    if (d != null) {
                        this.a.v0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.v0) && this.a.G0 != null && this.a.G0.b() != null && (n = this.a.G0.b().n(6)) != null && !TextUtils.isEmpty(this.a.v0)) {
                            ((View) n).setOnClickListener(this.a.i1);
                        }
                    }
                    if (this.a.A0 != null && Q != null && Q.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(Q.getAuthor());
                        this.a.A0.setLikeUserData(attentionHostData);
                    }
                    this.a.w4(h08Var);
                    if (this.a.M() != null && this.a.M().T1()) {
                        f4 = this.a.getPageContext().getString(R.string.pb_reply_hint_from_smart_frs);
                    } else {
                        f4 = this.a.f4();
                    }
                    if (!StringUtils.isNull(f4)) {
                        this.a.G0.c0(TbSingleton.getInstance().getAdVertiComment(h08Var.r0(), h08Var.s0(), f4));
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
                    if ((this.a.D4() && this.a.e4() == null) || this.a.N3() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.D4()) {
                        if (i != -1) {
                            if (this.a.M() != null && this.a.M().l1() != null) {
                                arrayList = this.a.M().l1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                                this.a.e4().d2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.e4().X1()) {
                                this.a.e4().e2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e5f));
                            } else {
                                this.a.e4().e2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e60));
                            }
                        } else {
                            this.a.e4().d2("");
                        }
                        this.a.e4().K1();
                    } else {
                        if (i != -1) {
                            if (this.a.M() != null && this.a.M().l1() != null) {
                                arrayList = this.a.M().l1().H();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).D() != 1)) {
                                this.a.N3().k2(this.a.getResources().getString(R.string.list_no_more_new));
                            } else if (this.a.N3().b2()) {
                                this.a.N3().l2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e5f));
                            } else {
                                this.a.N3().l2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e60));
                            }
                        } else {
                            this.a.N3().k2("");
                        }
                        this.a.N3().M1();
                    }
                }
                nq8.g().h(this.a.getUniqueId(), false);
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
                nz7 nz7Var = (nz7) customResponsedMessage.getData();
                int type = nz7Var.getType();
                if (type != 0) {
                    if (type != 1) {
                        if (type == 2) {
                            if (nz7Var.a() == null) {
                                this.a.Z4(false, null);
                                return;
                            } else {
                                this.a.Z4(true, (MarkData) nz7Var.a());
                                return;
                            }
                        }
                        return;
                    }
                    this.a.G3((ForumManageModel.b) nz7Var.a(), false);
                    return;
                }
                this.a.b5((x08) nz7Var.a());
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof rz8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                rz8 rz8Var = (rz8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = rz8Var.a;
                boolean z = false;
                if (rz8Var.c == 0 && dataRes != null) {
                    int e = xg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    if (e == 1) {
                        z = true;
                    }
                    if (xi.isEmpty(str)) {
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
                    this.a.N.F0(z, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.tag_mul_del_post_type, Boolean.TRUE);
                    this.a.N.k0(sparseArray, z);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof tn5.a)) {
                tn5.a aVar = (tn5.a) customResponsedMessage.getData();
                tn5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements vt6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        @Override // com.baidu.tieba.vt6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.vt6.d
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

        @Override // com.baidu.tieba.vt6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.G0 != null && this.a.G0.b() != null) {
                    this.a.G0.b().B(new m65(45, 27, null));
                }
                this.a.x3();
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
                g88 g88Var = this.a.N;
                if (tag == g88Var.D) {
                    g88Var.V();
                    UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                    String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                    h08 l1 = this.a.M().l1();
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
                        this.a.N.L0(errorString);
                    } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                        this.a.N.E0();
                    } else {
                        String errorString2 = userMuteAddResponseMessage.getErrorString();
                        if (xi.isEmpty(errorString2)) {
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
            bs8 bs8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bs8) && (bs8Var = (bs8) customResponsedMessage.getData()) != null && (agreeData = bs8Var.b) != null && agreeData.agreeType == 2 && this.a.j0 != null && this.a.M() != null && UbsABTestHelper.isResizeInduceSharingABTestA() && !h68.k(this.a.M().F1())) {
                this.a.j0.o(2);
                h68.b(this.a.M().F1());
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
        public void onNavigationButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lv4Var) == null) {
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
                g88 g88Var = this.a.N;
                if (tag == g88Var.D) {
                    g88Var.V();
                    UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                    if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                        this.a.O.d(this.a.getResources().getString(R.string.un_mute_success));
                        return;
                    }
                    String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                    if (xi.isEmpty(muteMessage)) {
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
            l88 l88Var;
            BdTypeRecyclerView d4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null && (l88Var = this.a.k) != null) {
                if (l88Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                    this.a.k.setData(threadData);
                    return;
                }
                boolean z = true;
                if (!xi.isEmpty(this.a.k.c0())) {
                    this.a.z0 = true;
                    if (this.a.D4()) {
                        this.a.e.setCurrentItem(0);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                    if (!this.a.D4() && (d4 = this.a.d4()) != null) {
                        d4.scrollToPosition(0);
                    }
                }
                if (this.a.l == null || !this.a.l.k()) {
                    this.a.e5();
                    this.a.p3(threadData);
                }
                this.a.z4();
                if (this.a.l != null && this.a.l.l()) {
                    this.a.l.s();
                }
                boolean z2 = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
                this.a.k.setData(threadData);
                if (this.a.D4()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    l88 l88Var2 = absVideoPbFragment.k;
                    if (absVideoPbFragment.e.getCurrentItem() != 0) {
                        z = false;
                    }
                    l88Var2.R0(z);
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
                this.a.d5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements l85 {
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

        @Override // com.baidu.tieba.l85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o48 o48Var = this.a.D0;
                if (o48Var != null && o48Var.g() != null && this.a.D0.g().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.D0.g().c());
                    if (this.a.I0 != null && this.a.I0.f() != null && this.a.I0.f().y()) {
                        this.a.I0.f().w(this.a.D0.h());
                    }
                    this.a.D0.b(true);
                    return true;
                } else if (!this.a.w3(ReplyPrivacyCheckController.TYPE_FLOOR)) {
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
        public final /* synthetic */ h08 a;
        public final /* synthetic */ p15 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, h08 h08Var, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, h08Var, p15Var};
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
            this.a = h08Var;
            this.b = p15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b != null && this.c.U0 != null) {
                this.c.U0.g(this.b);
                this.c.U0.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements n65 {
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

        @Override // com.baidu.tieba.n65
        public void A(m65 m65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m65Var) == null) {
                Object obj = m65Var.c;
                if ((obj instanceof g25) && EmotionGroupType.isSendAsPic(((g25) obj).getType())) {
                    if (this.a.E0 == null) {
                        this.a.E0 = new PermissionJudgePolicy();
                    }
                    this.a.E0.clearRequestPermissionList();
                    this.a.E0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.G0.f((g25) m65Var.c);
                    this.a.G0.w(false, null);
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
            o48 o48Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && (o48Var = this.a.D0) != null && o48Var.e() != null) {
                if (!this.a.D0.e().e()) {
                    this.a.D0.a(false);
                }
                this.a.D0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.H0 == null || this.a.H0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
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
                absVideoPbFragment.showToast(absVideoPbFragment.v0);
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
            l88 l88Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (l88Var = this.a.k) != null) {
                l88Var.U0(threadData);
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
            if (this.a.G0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.l5(absVideoPbFragment.G0.y());
            }
            this.a.z5(false);
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
            l88 l88Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) && (l88Var = this.a.k) != null) {
                l88Var.T0(threadData);
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
                        absVideoPbFragment.H4(absVideoPbFragment.w.j, this.a.w.i);
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
            this.a.W4();
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
                this.a.H5();
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
                    if (this.a.q1 == null || !this.a.q1.onTouchEvent(motionEvent)) {
                        return false;
                    }
                    return true;
                }
                if (this.a.k1 == 1) {
                    if (!this.a.o1) {
                        this.a.J5();
                        UtilHelper.showStatusBar(this.a.R(), this.a.R().getRootView());
                        this.a.o1 = true;
                        ah.a().removeCallbacks(this.a.s1);
                        ah.a().postDelayed(this.a.s1, 3000L);
                    }
                } else if (this.a.k1 == 2 && (this.a.o1 || this.a.E4())) {
                    this.a.I5();
                    UtilHelper.hideStatusBar(this.a.R(), this.a.R().getRootView());
                    this.a.o1 = false;
                    l88 l88Var = this.a.k;
                    if (l88Var != null) {
                        l88Var.S0(false);
                    }
                }
                this.a.k1 = 0;
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
                this.a.o5(bool.booleanValue());
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
            this.a.k1 = 0;
            this.a.l1 = 0.0f;
            this.a.m1 = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            l88 l88Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.l1 += f;
                this.a.m1 += f2;
                if (this.a.k1 == 0 && !this.a.n1 && (l88Var = this.a.k) != null && !l88Var.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.m1) <= Math.abs(this.a.l1) || this.a.m1 > (-height) / 5) {
                        if (Math.abs(this.a.m1) > Math.abs(this.a.l1) && this.a.m1 > 0.0f && f2 > 0.0f) {
                            this.a.k1 = 2;
                        }
                    } else {
                        this.a.k1 = 1;
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
                if (this.b.D4() && (this.a.n() || this.b.M().E1() == 1)) {
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
                if (this.b.D4() && (this.a.n() || this.b.M().E1() == 1)) {
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
            this.b.T5(this.a);
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
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.o1 || this.a.E4()) {
                return;
            }
            this.a.I5();
            UtilHelper.hideStatusBar(this.a.R(), this.a.R().getRootView());
            this.a.o1 = false;
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
                    this.a.G0.G(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.I0 != null && this.a.I0.f() != null) {
                    this.a.I0.f().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements jp4.a {
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

        @Override // com.baidu.tieba.jp4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.r5();
                if (z && this.a.M() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.M().b3(z2);
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
                        if (this.a.D4()) {
                            if (this.a.O3() != null) {
                                this.a.O3().I1();
                            }
                            if (this.a.e4() != null) {
                                this.a.e4().W1();
                            }
                        } else if (this.a.N3() != null) {
                            this.a.N3().Z1();
                        }
                    } else {
                        this.a.K4();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() != null && this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                                MarkData f = this.a.P.f();
                                MetaData author = this.a.M().l1().Q().getAuthor();
                                if (f != null && author != null) {
                                    if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                        this.a.N.B0(author);
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f00d6);
                                    }
                                } else {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.add_mark));
                                }
                            } else {
                                return;
                            }
                        }
                        this.a.n3();
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
    public class o extends q9 {
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

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.M() != null) {
                    switch (this.a.R.getLoadDataMode()) {
                        case 0:
                            this.a.M().O1();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.G3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.H3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.I3(absVideoPbFragment.R.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.H3(absVideoPbFragment2.R.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.f0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.H3(absVideoPbFragment3.R.getLoadDataMode(), false, null, false);
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.K1);
                this.a.height = floatValue;
                this.b.height = (this.c - AbsVideoPbFragment.K1) + floatValue;
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
                this.a.K0.c(motionEvent);
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
    public class q implements wa6.b {
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

        @Override // com.baidu.tieba.wa6.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    i18.d();
                } else {
                    i18.c();
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
                    if (this.a.N3() != null) {
                        this.a.N3().e2(false);
                    } else if (this.a.D4() && this.a.e4() != null) {
                        this.a.e4().Z1(false);
                    }
                    if (this.a.O3() != null) {
                        this.a.O3().N1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        if (absVideoPbFragment.O3().F1() == 0) {
                            i2 = 8;
                        } else {
                            i2 = 0;
                        }
                        absVideoPbFragment.u5(i2);
                        this.a.a0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    l88 l88Var = this.a.k;
                    if (l88Var != null) {
                        l88Var.R0(z);
                    }
                    this.a.d5();
                    if (this.a.M() != null && this.a.M().l1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()));
                    }
                } else {
                    if (this.a.O3() != null) {
                        this.a.O3().N1(false);
                    }
                    if (this.a.N3() != null) {
                        this.a.N3().e2(true);
                        int V1 = this.a.N3().V1();
                        int T1 = this.a.N3().T1();
                        if (V1 != 0) {
                            this.a.u5(8);
                            this.a.N3().o2(0);
                        } else if (T1 != 0) {
                            this.a.N3().o2(8);
                            this.a.u5(0);
                        } else {
                            this.a.N3().o2(8);
                            this.a.u5(8);
                        }
                    } else if (this.a.e4() != null) {
                        this.a.e4().Z1(true);
                        int T12 = this.a.e4().T1();
                        int R1 = this.a.e4().R1();
                        if (T12 != 0) {
                            this.a.u5(8);
                            this.a.e4().h2(0);
                        } else if (R1 != 0) {
                            this.a.e4().h2(8);
                            this.a.u5(0);
                        } else {
                            this.a.e4().h2(8);
                            this.a.u5(8);
                        }
                        this.a.a0.setVisibility(0);
                    }
                    l88 l88Var2 = this.a.k;
                    if (l88Var2 != null) {
                        l88Var2.R0(false);
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.K1);
                this.a.height = floatValue;
                this.b.height = this.c + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements lv4.e {
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

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && lv4Var != null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p15 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, p15Var};
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
            this.a = p15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.U0.setHomePbFloatLastCloseTime();
                this.b.n4();
                this.b.U0.u(this.a);
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
            this.a.R5();
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
            this.a.D5();
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K.setTag(Boolean.FALSE);
                if (this.a.U0 == null) {
                    return;
                }
                this.a.U0.setAutoCompleteShown(false);
                if (this.a.U0.getVisibility() == 0) {
                    this.a.U0.setTag(this.a.K);
                    this.a.U0.c();
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
    public class t implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ lv4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, lv4Var};
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
            this.c = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
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
                this.d.N5();
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
                this.a.G5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t1 implements pg<ImageView> {
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                    if (dr4.c().g()) {
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = dr4.c().g();
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
    public class u implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ lv4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, lv4Var};
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
            this.b = lv4Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.N5();
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
                if (absVideoPbFragment.A0 != null && absVideoPbFragment.M() != null && this.a.M().l1() != null && this.a.M().l1().d() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.A0.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.M().l1().d().replyPrivateFlag)) {
                        return;
                    }
                }
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    return;
                }
                this.a.G0.n0();
                this.a.D3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u1 implements pg<GifView> {
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                if (dr4.c().g()) {
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = dr4.c().g();
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
            this.a.F3(false);
            this.a.V4();
            if (this.a.M() != null && this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.M().G1()).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (this.a.A4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.M().getForumId());
                    statisticItem.param("tid", this.a.M().F1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.R3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.Q3());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v1 implements pg<View> {
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.r0());
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
                layoutParams.height = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds144);
                this.a.a0.setLayoutParams(layoutParams);
                if (this.a.D4() && this.a.d != null) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.L1);
                    } else {
                        layoutParams2.height = AbsVideoPbFragment.L1;
                    }
                    this.a.d.setLayoutParams(layoutParams2);
                    this.a.e.setScrollable(true);
                }
                this.a.d5();
                if (this.a.O3() != null) {
                    this.a.O3().I1();
                }
                if (this.a.N3() != null) {
                    this.a.N3().Z1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements pg<LinearLayout> {
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
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
    public class x implements m85 {
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

        @Override // com.baidu.tieba.m85
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
                this.a.l4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements pg<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.pg
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pg
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
                if (view2.getId() == R.id.obfuscated_res_0x7f0918e7) {
                    if (this.a.M() != null) {
                        this.a.M().k2(false);
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
                    if (this.a.A4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.M().getForumId());
                        statisticItem3.param("tid", this.a.M().F1());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.R3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.Q3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (!this.a.Z) {
                        TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                        if (tbRichTextView.getTag() instanceof SparseArray) {
                            Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                            if (obj instanceof PostData) {
                                PostData postData = (PostData) obj;
                                if (this.a.M() == null || this.a.M().l1() == null || this.a.J0 == null || postData.r() == null || postData.D() == 1 || !this.a.checkUpIsLogin()) {
                                    return;
                                }
                                if (this.a.I0 != null) {
                                    this.a.I0.g();
                                }
                                x08 x08Var = new x08();
                                x08Var.A(this.a.M().l1().l());
                                x08Var.E(this.a.M().l1().Q());
                                x08Var.C(postData);
                                this.a.J0.c0(x08Var);
                                this.a.J0.setPostId(postData.M());
                                this.a.J4(view2, postData.r().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                i78.b(this.a.M().l1(), postData, postData.d0, 8, 1);
                                if (this.a.G0 != null) {
                                    AbsVideoPbFragment absVideoPbFragment = this.a;
                                    absVideoPbFragment.l5(absVideoPbFragment.G0.y());
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
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().F1(), true, false);
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
                    if ((!this.a.D4() || this.a.e4() == null || this.a.e4().S1() == null || view2 != this.a.e4().S1()) && ((this.a.N3() == null || this.a.N3().U1() == null || view2 != this.a.N3().U1()) && view2.getId() != R.id.pb_more)) {
                        g88 g88Var = this.a.N;
                        if (g88Var != null && g88Var.Q() != null && view2 == this.a.N.Q().l()) {
                            this.a.N.I();
                            return;
                        }
                        g88 g88Var2 = this.a.N;
                        if ((g88Var2 == null || ((g88Var2.Q() == null || view2 != this.a.N.Q().p()) && view2.getId() != R.id.obfuscated_res_0x7f091823 && view2.getId() != R.id.obfuscated_res_0x7f09027f)) && view2.getId() != R.id.obfuscated_res_0x7f090a48 && view2.getId() != R.id.obfuscated_res_0x7f091cb5) {
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            if (view2 == absVideoPbFragment2.p) {
                                if (absVideoPbFragment2.M() == null || this.a.M().l1() == null) {
                                    return;
                                }
                                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                    StatisticItem statisticItem5 = new StatisticItem("c13266");
                                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                    statisticItem5.param("fid", this.a.M().l1().m());
                                    statisticItem5.param("tid", this.a.M().F1());
                                    statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                    TiebaStatic.log(statisticItem5);
                                    TbadkCoreApplication.getInst().setTaskId("");
                                }
                                yi.z(this.a.a, this.a.p);
                                this.a.a.finish();
                            } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                                if (hj5.a()) {
                                    return;
                                }
                                if (this.a.M() != null && this.a.M().l1() != null) {
                                    ArrayList<PostData> H = this.a.M().l1().H();
                                    if ((H == null || H.size() <= 0) && this.a.M().D1()) {
                                        yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                                        return;
                                    }
                                    TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.M().F1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.M().getForumId()));
                                    this.a.N.m0();
                                    return;
                                }
                                yi.Q(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                            } else if (this.a.N.Q() != null && view2 == this.a.N.Q().r()) {
                                if (this.a.M() == null) {
                                    return;
                                }
                                this.a.N.F();
                                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                    this.a.showToast(R.string.network_not_available);
                                    return;
                                }
                                this.a.M5();
                                this.a.s5();
                                this.a.M().Z2(1);
                            } else {
                                g88 g88Var3 = this.a.N;
                                if (g88Var3 != null && g88Var3.Q() != null && view2 == this.a.N.Q().p()) {
                                    this.a.N.I();
                                    return;
                                }
                                g88 g88Var4 = this.a.N;
                                if (g88Var4 != null && ((g88Var4.Q() != null && view2 == this.a.N.Q().x()) || view2.getId() == R.id.obfuscated_res_0x7f091927 || view2.getId() == R.id.obfuscated_res_0x7f091925)) {
                                    this.a.N.F();
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.network_not_available);
                                        return;
                                    } else if (this.a.L) {
                                        view2.setTag(Integer.valueOf(this.a.M().B1()));
                                        return;
                                    } else {
                                        this.a.M5();
                                        this.a.s5();
                                        this.a.N.K0(view2);
                                        return;
                                    }
                                }
                                g88 g88Var5 = this.a.N;
                                if (g88Var5 != null && g88Var5.Q() != null && view2 == this.a.N.Q().w()) {
                                    if (this.a.M() == null || this.a.M().l1() == null || this.a.M().l1().Q() == null) {
                                        return;
                                    }
                                    this.a.N.I();
                                    TiebaStatic.log(new StatisticItem("c13062"));
                                    AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                    absVideoPbFragment3.N.U(absVideoPbFragment3.M().l1().Q().getFirstPostId());
                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b0) {
                                    try {
                                        sparseArray = (SparseArray) view2.getTag();
                                    } catch (ClassCastException e) {
                                        e.printStackTrace();
                                        sparseArray = null;
                                    }
                                    g88 g88Var6 = this.a.N;
                                    if (g88Var6 != null) {
                                        g88Var6.x0(sparseArray);
                                    }
                                } else {
                                    g88 g88Var7 = this.a.N;
                                    int i4 = 4;
                                    if (g88Var7 != null && g88Var7.Q() != null && view2 == this.a.N.Q().u()) {
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
                                        this.a.N.J();
                                        return;
                                    }
                                    g88 g88Var8 = this.a.N;
                                    if (g88Var8 != null && g88Var8.Q() != null && view2 == this.a.N.Q().v()) {
                                        this.a.N.J();
                                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                        absVideoPbFragment4.N.H0(absVideoPbFragment4.C1);
                                        return;
                                    }
                                    g88 g88Var9 = this.a.N;
                                    if (g88Var9 != null && g88Var9.Q() != null && view2 == this.a.N.Q().o()) {
                                        TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                        if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.M().F1())) == null) {
                                            return;
                                        }
                                        UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                        this.a.N.I();
                                        TiebaPlusConfigData.addClickStatsForFireLink(3);
                                        return;
                                    }
                                    g88 g88Var10 = this.a.N;
                                    if (g88Var10 != null && (view2 == g88Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().s() || view2 == this.a.N.Q().t())))) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        } else if (this.a.M() == null || this.a.M().l1() == null || this.a.R.Z()) {
                                            return;
                                        } else {
                                            this.a.N.F();
                                            if (this.a.N.Q() != null && view2 == this.a.N.Q().t()) {
                                                if (this.a.M().l1().Q().getIs_top() == 1) {
                                                    i4 = 5;
                                                }
                                            } else if (this.a.N.Q() != null && view2 == this.a.N.Q().s()) {
                                                i4 = this.a.M().l1().Q().getIs_good() == 1 ? 3 : 6;
                                            } else {
                                                i4 = view2 == this.a.N.M() ? 2 : 0;
                                            }
                                            ForumData l = this.a.M().l1().l();
                                            String name = l.getName();
                                            String id = l.getId();
                                            String id2 = this.a.M().l1().Q().getId();
                                            this.a.showProgressBar();
                                            this.a.R.d0(id, name, id2, i4, this.a.N.N());
                                            return;
                                        }
                                    }
                                    g88 g88Var11 = this.a.N;
                                    if (g88Var11 != null && g88Var11.Q() != null && view2 == this.a.N.Q().n()) {
                                        if (this.a.M() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        this.a.N.F();
                                        AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                        SparseArray<Object> W3 = absVideoPbFragment5.W3(absVideoPbFragment5.M().l1(), this.a.M().D1(), 1);
                                        if (W3 == null) {
                                            return;
                                        }
                                        this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.M().l1().l().getId(), this.a.M().l1().l().getName(), this.a.M().l1().Q().getId(), String.valueOf(this.a.M().l1().X().getUserId()), (String) W3.get(R.id.tag_forbid_user_name), (String) W3.get(R.id.tag_forbid_user_name_show), (String) W3.get(R.id.tag_forbid_user_post_id), (String) W3.get(R.id.tag_forbid_user_portrait))));
                                        return;
                                    }
                                    g88 g88Var12 = this.a.N;
                                    if (g88Var12 != null && g88Var12.Q() != null && view2 == this.a.N.Q().g()) {
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                        SparseArray<Object> W32 = absVideoPbFragment6.W3(absVideoPbFragment6.M().l1(), this.a.M().D1(), 1);
                                        if (W32 != null) {
                                            this.a.N.j0(((Integer) W32.get(R.id.tag_del_post_type)).intValue(), (String) W32.get(R.id.tag_del_post_id), ((Integer) W32.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) W32.get(R.id.tag_del_post_is_self)).booleanValue());
                                        }
                                        this.a.N.I();
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
                                    g88 g88Var13 = this.a.N;
                                    if (g88Var13 != null && g88Var13.Q() != null && view2 == this.a.N.Q().m()) {
                                        if (this.a.M() == null) {
                                            return;
                                        }
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.network_not_available);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                        SparseArray<Object> W33 = absVideoPbFragment7.W3(absVideoPbFragment7.M().l1(), this.a.M().D1(), 1);
                                        if (W33 != null) {
                                            if (StringUtils.isNull((String) W33.get(R.id.tag_del_multi_forum))) {
                                                this.a.N.g0(((Integer) W33.get(R.id.tag_del_post_type)).intValue(), (String) W33.get(R.id.tag_del_post_id), ((Integer) W33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) W33.get(R.id.tag_del_post_is_self)).booleanValue());
                                            } else {
                                                this.a.N.h0(((Integer) W33.get(R.id.tag_del_post_type)).intValue(), (String) W33.get(R.id.tag_del_post_id), ((Integer) W33.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) W33.get(R.id.tag_del_post_is_self)).booleanValue(), (String) W33.get(R.id.tag_del_multi_forum));
                                            }
                                        }
                                        this.a.N.I();
                                    } else if (view2.getId() != R.id.sub_pb_more && view2.getId() != R.id.obfuscated_res_0x7f092063 && view2.getId() != R.id.obfuscated_res_0x7f0918b2 && view2.getId() != R.id.obfuscated_res_0x7f09173b && view2.getId() != R.id.obfuscated_res_0x7f091916) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f091914 && view2.getId() != R.id.obfuscated_res_0x7f091af8 && view2.getId() != R.id.obfuscated_res_0x7f0918ac) {
                                            if (view2.getId() != R.id.obfuscated_res_0x7f091899 && view2.getId() != R.id.collect_num_container) {
                                                if (view2.getId() != R.id.obfuscated_res_0x7f09189e && view2.getId() != R.id.share_more_container) {
                                                    if (view2.getId() != R.id.obfuscated_res_0x7f09189b && view2.getId() != R.id.thread_info_commont_container) {
                                                        if (view2.getId() != R.id.obfuscated_res_0x7f0924a0) {
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
                                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0918de && view2.getId() != R.id.obfuscated_res_0x7f0918a6) {
                                                                if (view2.getId() == R.id.obfuscated_res_0x7f0910d4) {
                                                                    this.a.d5();
                                                                    return;
                                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f0907b6 && view2.getId() != R.id.obfuscated_res_0x7f090a45) {
                                                                    if (this.a.N.Q() != null && view2 == this.a.N.Q().k()) {
                                                                        this.a.N.F();
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
                                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b4 || view2.getId() == R.id.obfuscated_res_0x7f09190e) {
                                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                                        statisticItem9.param("tid", this.a.M().F1());
                                                                        statisticItem9.param("fid", this.a.M().getForumId());
                                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                        statisticItem9.param("obj_locate", 7);
                                                                        TiebaStatic.log(statisticItem9);
                                                                        if (this.a.A4()) {
                                                                            StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                            statisticItem10.param("fid", this.a.M().getForumId());
                                                                            statisticItem10.param("tid", this.a.M().F1());
                                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                            statisticItem10.param(str, this.a.R3());
                                                                            statisticItem10.param("obj_source", 1);
                                                                            statisticItem10.param("obj_type", 2);
                                                                            statisticItem10.param("obj_locate", this.a.Q3());
                                                                            TiebaStatic.log(statisticItem10);
                                                                        }
                                                                        this.a.N.p0(false);
                                                                        this.a.N.P().onLongClick(view2);
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
                                                                    ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f0907b7);
                                                                    EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f0907b8);
                                                                    View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a45);
                                                                    if (postData2.t0()) {
                                                                        postData2.T0(false);
                                                                        k68.e(postData2);
                                                                    } else {
                                                                        if (this.a.M() != null ? k68.c(this.a.M().l1(), postData2) : false) {
                                                                            postData2.T0(true);
                                                                            findViewById.setVisibility(0);
                                                                        }
                                                                    }
                                                                    SkinManager.setBackgroundColor(findViewById, postData2.t0() ? R.color.CAM_X0201 : R.color.transparent);
                                                                    SkinManager.setViewTextColor(eMTextView, postData2.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                                    WebPManager.setPureDrawable(imageView, postData2.t0() ? R.drawable.icon_pure_pb_del_select : R.drawable.icon_pure_pb_del_normal, postData2.t0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                                    return;
                                                                }
                                                            } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                String r = ry4.l().r("tail_link", "");
                                                                if (!StringUtils.isNull(r)) {
                                                                    TiebaStatic.log("c10056");
                                                                    sp4.s(view2.getContext(), string, r, true, true, true);
                                                                }
                                                                this.a.d5();
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (this.a.P0 >= 0) {
                                                            if (this.a.M() != null) {
                                                                this.a.M().G2();
                                                            }
                                                            if (this.a.D4() && this.a.M() != null && this.a.e4() != null && this.a.e4().x1() != null) {
                                                                this.a.e4().x1().f(this.a.M().l1());
                                                            } else if (this.a.N3() != null && this.a.N3().x1() != null) {
                                                                this.a.N3().x1().r(this.a.M().l1());
                                                            }
                                                            this.a.P0 = 0;
                                                            this.a.Q0 = Integer.MIN_VALUE;
                                                            if (this.a.D4() && this.a.M() != null && this.a.e4() != null) {
                                                                this.a.e4().c2(this.a.M().e1(), this.a.M().d1());
                                                                this.a.M().K2(0, 0);
                                                                return;
                                                            } else if (this.a.M() == null || this.a.N3() == null) {
                                                                return;
                                                            } else {
                                                                this.a.N3().i2(this.a.M().e1(), this.a.M().d1());
                                                                this.a.M().K2(0, 0);
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
                                                        h08 l1 = this.a.M().l1();
                                                        int reply_num = l1.Q().getReply_num();
                                                        int currentItem = this.a.e.getCurrentItem();
                                                        if (reply_num == 0) {
                                                            if (this.a.D4() && currentItem == 0) {
                                                                this.a.e.setCurrentItem(1);
                                                            }
                                                            this.a.F3(false);
                                                            this.a.V4();
                                                            return;
                                                        }
                                                        if (!this.a.D4() || currentItem != 0) {
                                                            if ((this.a.D4() && this.a.e4() == null) || this.a.N3() == null || this.a.d4() == null) {
                                                                return;
                                                            }
                                                            StatisticItem param = new StatisticItem("c13403").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            int j = (int) (yi.j(this.a.getContext()) * 0.6d);
                                                            BdTypeRecyclerView d4 = this.a.d4();
                                                            if (d4 == null) {
                                                                return;
                                                            }
                                                            boolean canScrollVertically = d4.canScrollVertically(1);
                                                            boolean canScrollVertically2 = d4.canScrollVertically(-1);
                                                            AppBarLayout appBarLayout = this.a.i;
                                                            str2 = "obj_source";
                                                            if (appBarLayout != null) {
                                                                appBarLayout.setExpanded(false, true);
                                                            }
                                                            if (d4.getLayoutManager() == null || !(d4.getLayoutManager() instanceof LinearLayoutManager)) {
                                                                return;
                                                            }
                                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) d4.getLayoutManager();
                                                            if (canScrollVertically2 || !canScrollVertically) {
                                                                int firstVisiblePosition = d4.getFirstVisiblePosition();
                                                                View childAt = d4.getChildAt(0);
                                                                int top = childAt == null ? 0 : childAt.getTop();
                                                                this.a.N0 = firstVisiblePosition;
                                                                this.a.O0 = top;
                                                                if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-j) || d4.getCount() < 6)) {
                                                                    d4.smoothScrollToPosition(0);
                                                                } else {
                                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                    d4.smoothScrollToPosition(0);
                                                                }
                                                                i2 = 1;
                                                                param.param("obj_locate", 1);
                                                            } else if (this.a.N0 == -1 && this.a.O0 == Integer.MIN_VALUE) {
                                                                return;
                                                            } else {
                                                                if (this.a.N0 > 3 || (this.a.N0 == 3 && this.a.O0 < (-j))) {
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + j);
                                                                    d4.smoothScrollBy(0, j);
                                                                } else if (this.a.N0 >= 2) {
                                                                    int i6 = j / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + i6);
                                                                    d4.smoothScrollBy(0, i6);
                                                                } else if (this.a.N0 == 1) {
                                                                    int i7 = j / 4;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + i7);
                                                                    d4.smoothScrollBy(0, i7);
                                                                } else {
                                                                    d4.smoothScrollBy(0, -this.a.O0);
                                                                }
                                                                param.param("obj_locate", 2);
                                                                i2 = 1;
                                                            }
                                                            TiebaStatic.log(param);
                                                            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
                                                        if (this.a.A4()) {
                                                            StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem12.param("fid", this.a.M().getForumId());
                                                            statisticItem12.param("tid", this.a.M().F1());
                                                            statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem12.param(str3, this.a.R3());
                                                            statisticItem12.param(str2, 1);
                                                            statisticItem12.param("obj_type", 12);
                                                            statisticItem12.param("obj_locate", this.a.Q3());
                                                            TiebaStatic.log(statisticItem12);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                this.a.h4(true);
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
                                            if (this.a.D4() && this.a.e4() == null) {
                                                return;
                                            }
                                            if (this.a.D4() || this.a.N3() != null) {
                                                this.a.N.F();
                                                if (view2.getId() != R.id.obfuscated_res_0x7f091899 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                    if (!this.a.u3(11009) || this.a.M() == null) {
                                                        return;
                                                    }
                                                    this.a.L4();
                                                    if (this.a.M().l1() != null && this.a.M().l1().Q() != null && this.a.M().l1().Q().getAuthor() != null) {
                                                        TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.M().F1()).param("fid", this.a.M().l1().m()).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                                                        if (this.a.A4()) {
                                                            StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem13.param("fid", this.a.M().getForumId());
                                                            statisticItem13.param("tid", this.a.M().F1());
                                                            statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem13.param(str4, this.a.R3());
                                                            statisticItem13.param("obj_source", 1);
                                                            statisticItem13.param("obj_type", 13);
                                                            statisticItem13.param("obj_locate", this.a.Q3());
                                                            TiebaStatic.log(statisticItem13);
                                                        }
                                                    }
                                                    if (this.a.M().l1().Q() == null || this.a.M().l1().Q().getAuthor() == null || this.a.M().l1().Q().getAuthor().getUserId() == null || this.a.P == null) {
                                                        return;
                                                    }
                                                    AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                    int S = absVideoPbFragment10.N.S(absVideoPbFragment10.M().l1());
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
                                                    TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.M().F1()).param("obj_locate", 1).param("obj_id", this.a.M().l1().Q().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
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
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091914) {
                                            StatisticItem statisticItem14 = new StatisticItem("c13398");
                                            statisticItem14.param("tid", this.a.M().F1());
                                            statisticItem14.param("fid", this.a.M().getForumId());
                                            statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem14.param("obj_locate", 6);
                                            TiebaStatic.log(statisticItem14);
                                        }
                                        if (view2.getId() == R.id.obfuscated_res_0x7f091af8) {
                                            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                                this.a.y = view2;
                                                return;
                                            }
                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f091914 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                        if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                            SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                                PostData postData3 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                                if (view2.getId() == R.id.obfuscated_res_0x7f091914 && (statisticItem = postData3.e0) != null) {
                                                    StatisticItem copy = statisticItem.copy();
                                                    copy.delete("obj_locate");
                                                    copy.param("obj_locate", 8);
                                                    TiebaStatic.log(copy);
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091af8 || view2.getId() == R.id.obfuscated_res_0x7f0918ac) {
                                                    TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.M().G1()).param("fid", this.a.M().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData3.M()).param("obj_source", 1).param("obj_type", 3));
                                                }
                                                if (this.a.M() == null || this.a.M().l1() == null || this.a.J0 == null || postData3.r() == null || postData3.D() == 1) {
                                                    return;
                                                }
                                                if (this.a.I0 != null) {
                                                    this.a.I0.g();
                                                }
                                                x08 x08Var2 = new x08();
                                                x08Var2.A(this.a.M().l1().l());
                                                x08Var2.E(this.a.M().l1().Q());
                                                x08Var2.C(postData3);
                                                this.a.J0.c0(x08Var2);
                                                this.a.J0.setPostId(postData3.M());
                                                this.a.J4(view2, postData3.r().getUserId(), "", postData3);
                                                if (this.a.G0 != null) {
                                                    AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                    absVideoPbFragment11.l5(absVideoPbFragment11.G0.y());
                                                }
                                            }
                                        }
                                    } else {
                                        String str6 = str;
                                        if (view2.getId() == R.id.obfuscated_res_0x7f09173b) {
                                            StatisticItem statisticItem15 = new StatisticItem("c13398");
                                            statisticItem15.param("tid", this.a.M().F1());
                                            statisticItem15.param("fid", this.a.M().getForumId());
                                            statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem15.param("obj_locate", 4);
                                            TiebaStatic.log(statisticItem15);
                                            if (this.a.A4()) {
                                                StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem16.param("fid", this.a.M().getForumId());
                                                statisticItem16.param("tid", this.a.M().F1());
                                                statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem16.param(str6, this.a.R3());
                                                statisticItem16.param("obj_source", 1);
                                                statisticItem16.param("obj_type", 8);
                                                statisticItem16.param("obj_locate", this.a.Q3());
                                                TiebaStatic.log(statisticItem16);
                                            }
                                        }
                                        if ((view2.getId() != R.id.obfuscated_res_0x7f0918b2 && view2.getId() != R.id.obfuscated_res_0x7f091916) || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0918b2 && this.a.A4()) {
                                                StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                statisticItem17.param("fid", this.a.M().getForumId());
                                                statisticItem17.param("tid", this.a.M().F1());
                                                statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem17.param(str6, this.a.R3());
                                                statisticItem17.param("obj_source", 1);
                                                statisticItem17.param("obj_type", 9);
                                                statisticItem17.param("obj_locate", this.a.Q3());
                                                TiebaStatic.log(statisticItem17);
                                            }
                                            if (!this.a.checkUpIsLogin()) {
                                                i78.r("c10517", this.a.M().l1().m(), 3);
                                                return;
                                            } else if (this.a.M() == null || this.a.M().l1() == null) {
                                                return;
                                            } else {
                                                g88 g88Var14 = this.a.N;
                                                if (g88Var14 != null) {
                                                    g88Var14.F();
                                                }
                                                SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                                PostData postData4 = (PostData) sparseArray4.get(R.id.tag_load_sub_data);
                                                PostData postData5 = (PostData) sparseArray4.get(R.id.tag_load_sub_reply_data);
                                                if (postData4 == null) {
                                                    return;
                                                }
                                                if (postData4.H() == 1) {
                                                    TiebaStatic.log(new StatisticItem("c12630"));
                                                }
                                                StatisticItem statisticItem18 = postData4.e0;
                                                if (statisticItem18 != null) {
                                                    StatisticItem copy2 = statisticItem18.copy();
                                                    copy2.delete("obj_locate");
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09173b) {
                                                        copy2.param("obj_locate", 6);
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b2) {
                                                        copy2.param("obj_locate", 8);
                                                    }
                                                    TiebaStatic.log(copy2);
                                                }
                                                this.a.M5();
                                                TiebaStatic.log("c11742");
                                                if (postData5 != null) {
                                                    this.a.K5(postData4, postData5, false, true);
                                                    return;
                                                } else {
                                                    this.a.K5(postData4, null, false, false);
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
                            this.a.N.F();
                            if (this.a.L) {
                                view2.setTag(Boolean.FALSE);
                                return;
                            }
                            this.a.M5();
                            this.a.s5();
                            boolean e3 = view2.getId() == R.id.obfuscated_res_0x7f091823 ? this.a.M().e3(true, this.a.R3()) : view2.getId() == R.id.obfuscated_res_0x7f09027f ? this.a.M().e3(false, this.a.R3()) : this.a.M().d3(this.a.R3());
                            view2.setTag(Boolean.valueOf(e3));
                            if (e3) {
                                this.a.C5();
                                i3 = 1;
                                this.a.L = true;
                            } else {
                                i3 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i3, new Object[0]);
                        }
                    } else if (!this.a.L && this.a.M().g2(true)) {
                        this.a.L = true;
                        if (this.a.D4()) {
                            if (this.a.e4() != null) {
                                this.a.e4().g2();
                            }
                        } else if (this.a.N3() != null) {
                            this.a.N3().n2();
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
                this.a.d5();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements l85 {
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

        @Override // com.baidu.tieba.l85
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o48 o48Var = this.a.D0;
                if (o48Var != null && o48Var.e() != null && this.a.D0.e().d()) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.showToast(absVideoPbFragment.D0.e().c());
                    if (this.a.G0 != null && (this.a.G0.x() || this.a.G0.z())) {
                        this.a.G0.w(false, this.a.D0.h());
                    }
                    this.a.D0.a(true);
                    return true;
                } else if (this.a.w3(ReplyPrivacyCheckController.TYPE_THREAD)) {
                    return false;
                } else {
                    return true;
                }
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends ik5<ShareItem> {
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
        @Override // com.baidu.tieba.ik5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel M = this.b.M();
                if (M != null) {
                    M.N2(this.a);
                }
                return h68.d(this.b.M3(), 2, M);
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
                this.a.J0.X(postData);
                if (this.a.N3() != null) {
                    this.a.N3().Z1();
                } else if (this.a.D4() && this.a.e4() != null) {
                    this.a.e4().W1();
                }
                this.a.I0.g();
                this.a.H0.r();
                this.a.z5(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<f55> {
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
        public int compare(f55 f55Var, f55 f55Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, f55Var, f55Var2)) == null) {
                return f55Var.compareTo(f55Var2);
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
        K1 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        L1 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        M1 = 3;
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FallingView fallingView = this.K;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.U0;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K) {
                this.U0.setTag(null);
                this.U0.setAutoCompleteShown(true);
                this.U0.d();
            }
        }
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && M() != null && !xi.isEmpty(M().F1())) {
            km4.w().P(jm4.Z, xg.g(M().F1(), 0L));
        }
    }

    public final void H5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        this.v.setAlpha(0.0f);
        this.v.setVisibility(0);
        S5(layoutParams);
    }

    public final void I5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.u1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 1.0f, 0.0f);
                this.u1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.u1.start();
        }
    }

    public final void J5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.t1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 0.0f, 1.0f);
                this.t1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.t1.start();
        }
    }

    public final int M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (M() != null && M().l1() != null && M().l1().Q() != null) {
                return M().l1().Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.network_not_available);
            } else if (this.N != null && M() != null) {
                this.N.F();
                if (this.L) {
                    return;
                }
                M5();
                s5();
                if (M().loadData()) {
                    C5();
                }
            }
        }
    }

    public final void R5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048646, this) != null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.s0.a()) {
            this.k.X(false);
            return;
        }
        l88 l88Var = this.k;
        if (!A4() && !this.k.N0()) {
            z2 = true;
        }
        l88Var.X(z2);
    }

    public BdTypeRecyclerView d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).S1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).Q1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            jp4 c3 = jp4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.W0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.R = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.v1);
            this.Q = new s35(getPageContext());
            this.N = new g88(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onStop();
            r0().onStop(getPageContext());
            nq8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.F1);
        }
    }

    public void r5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            hideProgressBar();
            if (D4() && e4() != null) {
                e4().K1();
                e4().L1();
            } else if (N3() != null) {
                N3().M1();
                N3().N1();
            }
        }
    }

    public final boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
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
        this.u0 = false;
        this.v0 = null;
        this.w0 = false;
        this.x0 = false;
        this.y0 = false;
        this.z0 = false;
        this.L0 = new int[2];
        this.N0 = -1;
        this.O0 = Integer.MIN_VALUE;
        this.P0 = 0;
        this.Q0 = Integer.MIN_VALUE;
        this.R0 = false;
        this.S0 = new v(this);
        this.V0 = new c1(this);
        this.W0 = new n1(this);
        this.X0 = new y1(this);
        this.Y0 = new b2(this, 2004016);
        this.Z0 = new c2(this, 2004007);
        this.a1 = new a(this, 2921391);
        this.b1 = new b(this, 2016450);
        this.c1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.d1 = new d(this, 2001426);
        this.e1 = new e(this, 2001427);
        this.f1 = new f(this, 2001428);
        this.g1 = new g(this);
        this.h1 = new h(this);
        this.i1 = new i(this);
        this.j1 = new j(this, 2004008);
        this.k1 = 0;
        this.o1 = true;
        this.p1 = new l(this);
        this.r1 = new m(this);
        this.s1 = new n(this);
        this.v1 = new o(this);
        this.w1 = new p(this);
        this.x1 = new q(this);
        this.y1 = new s(this);
        this.z1 = new x(this);
        this.A1 = new y(this);
        this.B1 = new b0(this);
        this.C1 = new c0(this);
        this.D1 = new d0(this, 2001332);
        this.E1 = new e0(this, 2016528);
        this.F1 = new o0(this, 2001440);
        this.G1 = new p0(this);
        this.H1 = new w0(this, 2921509);
        this.I1 = new a1(this);
        this.J1 = new b1(this);
        this.s0 = new d2(this, null);
    }

    public final void L4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && M() != null && M().l1() != null) {
            if (!D4() || e4() != null) {
                if ((D4() || N3() != null) && this.P != null) {
                    MarkData markData = null;
                    if (M().l1() != null && M().l1().l0()) {
                        markData = M().B0(0);
                    } else {
                        CustomViewPager customViewPager = this.e;
                        if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                            markData = M().f1(P3(M().l1()));
                        } else if (D4()) {
                            if (e4() != null) {
                                markData = M().B0(e4().P1());
                            }
                        } else if (N3() != null) {
                            markData = M().B0(N3().R1());
                        }
                    }
                    if (markData == null) {
                        return;
                    }
                    if (markData.isApp() && e4() != null && (markData = M().B0(e4().P1() + 1)) == null) {
                        return;
                    }
                    s5();
                    this.P.i(markData);
                    if (!this.P.e()) {
                        if (M() != null && !h68.k(M().F1())) {
                            this.j0.o(2);
                            h68.b(M().F1());
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

    public final String R3() {
        InterceptResult invokeV;
        ArrayList<PostData> H;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            if (M() == null || M().l1() == null || M().l1().H() == null || (count = ListUtils.getCount((H = M().l1().H()))) == 0) {
                return "";
            }
            if (M().w1()) {
                Iterator<PostData> it = H.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.D() == 1) {
                        return next.M();
                    }
                }
            }
            int i2 = 0;
            if (d4() != null) {
                if (D4()) {
                    if (e4() != null) {
                        i2 = e4().N1();
                    }
                } else if (N3() != null) {
                    i2 = N3().P1();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(H, i2);
            if (postData != null && postData.r() != null) {
                if (M().d2(postData.r().getUserId())) {
                    return postData.M();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(H, i3);
                    if (postData2 == null || postData2.r() == null || postData2.r().getUserId() == null) {
                        break;
                    } else if (M().d2(postData2.r().getUserId())) {
                        return postData2.M();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(H, i4);
                    if (postData3 == null || postData3.r() == null || postData3.r().getUserId() == null) {
                        break;
                    } else if (M().d2(postData3.r().getUserId())) {
                        return postData3.M();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            this.a0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09260e);
            this.b0 = this.c.findViewById(R.id.obfuscated_res_0x7f09266f);
            this.c0 = this.c.findViewById(R.id.obfuscated_res_0x7f09189a);
            yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0908bd);
            this.e0 = imageView;
            imageView.setOnClickListener(new u0(this));
            I4();
            this.f0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09189d);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091895);
            this.d0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09189b);
            this.g0 = imageView2;
            imageView2.setOnClickListener(this.A1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091899);
            this.h0 = imageView3;
            imageView3.setOnClickListener(this.A1);
            if (booleanExtra) {
                this.h0.setVisibility(8);
            } else {
                this.h0.setVisibility(0);
            }
            if (C4()) {
                this.g0.setVisibility(0);
            } else {
                this.g0.setVisibility(8);
                this.h0.setPadding(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09189e);
            this.i0 = imageView4;
            imageView4.setOnClickListener(this.A1);
            this.j0 = new r88(this.i0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.j0.f();
            }
            if (M() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !h68.k(M().F1())) {
                this.j0.f();
                h68.b(M().F1());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09189c);
            this.q0 = textView;
            textView.setVisibility(0);
            z5(false);
        }
    }

    public final void B5(h08 h08Var) {
        j88 I;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, h08Var) == null) && (I = h08Var.I()) != null && !I.l) {
            q3(I);
        }
    }

    public final void E5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            k88.c(R(), M3(), i2);
        }
    }

    public void F3(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) && (appBarLayout = this.i) != null) {
            appBarLayout.setExpanded(z2);
        }
    }

    public void O4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
            View view2 = this.h;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final void h5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048686, this, i2) == null) && M() != null) {
            showLoadingView(getView());
            PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
            privacySettingMessage.setTid(M().F1());
            sendMessage(privacySettingMessage);
        }
    }

    public void i5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048688, this, i2) == null) && (linearLayout = this.a0) != null) {
            linearLayout.setVisibility(i2);
        }
    }

    public void l5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            this.u0 = z2;
        }
    }

    public void m5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z2) == null) {
            this.L = z2;
        }
    }

    public void n5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.o1 = z2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) {
            super.onUserChanged(z2);
            I4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
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

    public void u5(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048743, this, i2) == null) && (view2 = this.g) != null) {
            view2.setVisibility(i2);
        }
    }

    public void v5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z2) == null) {
            this.u = z2;
        }
    }

    public final void w5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z2) == null) {
            this.G0.X(z2);
            this.G0.a0(z2);
            this.G0.i0(z2);
        }
    }

    public void z5(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048761, this, z2) != null) || this.c0 == null) {
            return;
        }
        l5(this.G0.y());
        if (this.u0) {
            A5(z2);
        } else {
            j4(z2);
        }
        T4();
        W4();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048711, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(S3(), viewGroup, false);
            y4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.Z = true;
        }
    }

    @Override // com.baidu.tieba.wn5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, str) == null) {
            r48.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.Z = true;
        }
    }

    public void S4(f55 f55Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048642, this, f55Var, i2) == null) && (fallingView = this.K) != null) {
            fallingView.A(f55Var, getPageContext(), i2, false);
        }
    }

    @Override // com.baidu.tieba.wn5
    public void b0(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048667, this, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.Z = true;
    }

    public final void o4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048703, this, i2, i3) == null) {
            mk5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void q5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048724, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            g88 g88Var = this.N;
            if (g88Var == null) {
                return;
            }
            if (z2) {
                g88Var.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    public boolean B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            EditorTools editorTools = this.H0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C5() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(0);
        }
    }

    public void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", M1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (!A4() && M() != null && M().b2()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s78
    public PbModel.h E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.V0;
        }
        return (PbModel.h) invokeV.objValue;
    }

    public void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", M1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean E4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            l88 l88Var = this.k;
            if (l88Var != null && l88Var.M0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean F4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.o1;
        }
        return invokeV.booleanValue;
    }

    public boolean G4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            l88 l88Var = this.k;
            if (l88Var == null) {
                return false;
            }
            return l88Var.N0();
        }
        return invokeV.booleanValue;
    }

    public final void G5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        Q5();
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.e0 != null) {
            E3();
            this.e0.setImageResource(R.drawable.icon_pure_post_expression24);
        }
    }

    public s35 K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.Q;
        }
        return (s35) invokeV.objValue;
    }

    public LinearLayout L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.d0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public void L5() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (fallingView = this.K) != null) {
            fallingView.C();
        }
    }

    @Override // com.baidu.tieba.s78
    public PbModel M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.a.j1();
        }
        return (PbModel) invokeV.objValue;
    }

    public final void M5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (voiceManager = this.S) != null) {
            voiceManager.stopPlay();
        }
    }

    @Override // com.baidu.tieba.wn5
    public og<RelativeLayout> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            og<RelativeLayout> ogVar = new og<>(new x1(this), 10, 0);
            this.Y = ogVar;
            return ogVar;
        }
        return (og) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return (DetailInfoAndReplyFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final void N5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (absPbActivity = this.a) != null) {
            absPbActivity.v1();
        }
    }

    public DetailInfoFragment O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return (DetailInfoFragment) this.f.b(0);
            }
            return null;
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<ImageView> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.V == null) {
                this.V = new og<>(new t1(this), 8, 0);
            }
            return this.V;
        }
        return (og) invokeV.objValue;
    }

    public void P5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            o85 o85Var = this.G0;
            if (o85Var != null) {
                l5(o85Var.y());
            }
            d5();
            this.N.F();
        }
    }

    @Override // com.baidu.tieba.wn5
    public og<View> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.W == null) {
                this.W = new og<>(new v1(this), 8, 0);
            }
            return this.W;
        }
        return (og) invokeV.objValue;
    }

    @Override // com.baidu.tieba.s78
    public AbsPbActivity R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.a;
        }
        return (AbsPbActivity) invokeV.objValue;
    }

    public boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public View.OnClickListener U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.A1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public og<TextView> V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (this.U == null) {
                this.U = TbRichTextView.D(getPageContext().getPageActivity(), 8);
            }
            return this.U;
        }
        return (og) invokeV.objValue;
    }

    public View.OnClickListener V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.B1;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public jp4 X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.P;
        }
        return (jp4) invokeV.objValue;
    }

    public View.OnLongClickListener Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.I1;
        }
        return (View.OnLongClickListener) invokeV.objValue;
    }

    public View.OnTouchListener Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.w1;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public o85 a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.G0;
        }
        return (o85) invokeV.objValue;
    }

    public void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            c5();
            k4();
            this.I0.g();
            z5(false);
        }
    }

    public ReplyFragment e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter != null && (videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return (ReplyFragment) this.f.b(1);
            }
            return null;
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public final void e5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public String f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (!xi.isEmpty(this.t0)) {
                return this.t0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(j48.g());
            this.t0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.N0 = -1;
            this.O0 = Integer.MIN_VALUE;
        }
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048687, this) != null) || this.c0 == null) {
            return;
        }
        this.b0.setVisibility(8);
        this.c0.setVisibility(8);
        this.s0.a = false;
        T4();
        W4();
    }

    public void k4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && (editorTools = this.H0) != null) {
            editorTools.p();
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            this.K.setFallingFeedbackListener(new a2(this));
        }
    }

    public void l4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048694, this) == null) && this.a.getCurrentFocus() != null) {
            yi.z(getPageContext().getPageActivity(), this.a.getCurrentFocus());
        }
    }

    public void m4() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048696, this) == null) && (view2 = this.M) != null) {
            view2.setVisibility(8);
        }
    }

    public void n4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && (rightFloatLayerView = this.U0) != null) {
            rightFloatLayerView.c();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onStart();
            r0().onStart(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            if (this.S == null) {
                this.S = VoiceManager.instance();
            }
            return this.S;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void r4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            j5(this.G0.b());
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            PbModel j12 = this.a.j1();
            if (j12 == null) {
                return false;
            }
            return j12.c2();
        }
        return invokeV.booleanValue;
    }

    public void s5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            yi.z(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && M() != null && !xi.isEmpty(M().F1())) {
            super.taskStart();
        }
    }

    @Override // com.baidu.tieba.wn5
    public og<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            if (this.T == null) {
                this.T = new og<>(new u1(this), 20, 0);
            }
            return this.T;
        }
        return (og) invokeV.objValue;
    }

    public void v4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048746, this) != null) || (editorTools = this.H0) == null) {
            return;
        }
        editorTools.j();
        i4();
    }

    @Override // com.baidu.tieba.wn5
    public og<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            if (this.X == null) {
                this.X = new og<>(new w1(this), 15, 0);
            }
            return this.X;
        }
        return (og) invokeV.objValue;
    }

    public void A3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sparseArray, jSONArray) == null) {
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

    public final void I3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048604, this, i2, gVar) == null) && gVar != null && M() != null && M().l1() != null && M().l1().Q() != null) {
            H3(this.R.getLoadDataMode(), gVar.a, gVar.b, false);
            if (gVar.a) {
                this.w0 = true;
                if (i2 != 2 && i2 != 3) {
                    if (i2 == 4 || i2 == 5) {
                        this.x0 = false;
                        this.y0 = true;
                    }
                } else {
                    this.x0 = true;
                    this.y0 = false;
                }
                if (i2 == 2) {
                    M().l1().Q().setIs_good(1);
                    M().O2(1);
                } else if (i2 == 3) {
                    M().l1().Q().setIs_good(0);
                    M().O2(0);
                } else if (i2 == 4) {
                    M().l1().Q().setIs_top(1);
                    M().P2(1);
                } else if (i2 == 5) {
                    M().l1().Q().setIs_top(0);
                    M().P2(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                    string = gVar.b;
                } else {
                    string = getString(R.string.operation_failed);
                }
                yi.Q(getPageContext().getPageActivity(), string);
            }
            if (D4()) {
                if (M().l1().Q() != null && O3() != null) {
                    O3().O1();
                }
            } else if (M().l1().Q() != null && N3() != null) {
                N3().g2();
            }
        }
    }

    public final void g4(int i2, Intent intent) {
        y65 y65Var;
        e38 e38Var;
        y65 y65Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048681, this, i2, intent) == null) {
            if (i2 == 0) {
                k4();
                e38 e38Var2 = this.I0;
                if (e38Var2 != null) {
                    e38Var2.g();
                }
                z5(false);
            }
            d5();
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
                if (editorType == 1 && (e38Var = this.I0) != null && e38Var.f() != null) {
                    s85 f2 = this.I0.f();
                    f2.d0(M().l1().Q());
                    f2.C(writeData);
                    f2.e0(pbEditorData.getVoiceModel());
                    x65 o2 = f2.b().o(6);
                    if (o2 != null && (y65Var2 = o2.m) != null) {
                        y65Var2.A(new m65(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        f2.G();
                        return;
                    }
                    return;
                }
                return;
            }
            this.G0.L();
            this.G0.m0(pbEditorData.getVoiceModel());
            this.G0.B(writeData);
            x65 o3 = this.G0.b().o(6);
            if (o3 != null && (y65Var = o3.m) != null) {
                y65Var.A(new m65(52, 0, pbEditorData.getVoiceModel()));
            }
            if (i2 == -1) {
                this.G0.G(null, null);
            }
        }
    }

    public void A5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) && this.c0 != null && (textView = this.f0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0539);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.c0.startAnimation(alphaAnimation);
            }
            this.b0.setVisibility(0);
            this.c0.setVisibility(0);
            this.s0.a = true;
        }
    }

    public void a5(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, h08Var) == null) && h08Var != null && h08Var.Q() != null) {
            String valueOf = String.valueOf(h08Var.Q().getReply_num());
            if (h08Var.Q().getReply_num() == 0) {
                valueOf = "";
            }
            this.d.F(valueOf);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            l88 l88Var = this.k;
            if (l88Var != null && !l88Var.N0()) {
                if ((this.k.isFullScreen() && configuration.orientation == 1) || (!this.k.isFullScreen() && configuration.orientation == 2)) {
                    this.k.V(false);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (M() != null) {
                M().H2(bundle);
            }
            if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                r0().onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    public final boolean u3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048741, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public void B3(lv4 lv4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, lv4Var, jSONArray) == null) {
            lv4Var.dismiss();
            if (M() != null && M().l1() != null && M().l1().Q() != null && M().l1().l() != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!(lv4Var.getYesButtonTag() instanceof SparseArray)) {
                        return;
                    }
                    A3((SparseArray) lv4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public void Z4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048664, this, z2, markData) != null) || M() == null) {
            return;
        }
        r5();
        M().b3(z2);
        jp4 jp4Var = this.P;
        if (jp4Var != null) {
            jp4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (M().W0()) {
            K4();
        } else if (D4()) {
            if (O3() != null) {
                O3().I1();
            }
            if (e4() != null) {
                e4().W1();
            }
        } else if (N3() != null) {
            N3().Z1();
        }
    }

    public void C3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                A3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public final void G3(ForumManageModel.b bVar, boolean z2) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048597, this, bVar, z2) == null) && bVar != null && isAdded()) {
            if (!TextUtils.isEmpty(bVar.b)) {
                string = bVar.b;
            } else {
                string = getString(R.string.delete_fail);
            }
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                lv4 lv4Var = new lv4(getPageContext().getPageActivity());
                lv4Var.setMessage(string);
                lv4Var.setPositiveButton(R.string.dialog_known, new r(this));
                lv4Var.setCancelable(true);
                lv4Var.create(getPageContext());
                lv4Var.show();
            } else {
                H3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> H = M().l1().H();
                    int size = H.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(H.get(i2).M())) {
                            H.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    M().l1().Q().setReply_num(M().l1().Q().getReply_num() - 1);
                    if (N3() != null) {
                        N3().Z1();
                    } else if (D4() && e4() != null) {
                        e4().W1();
                    }
                } else if (i3 == 0) {
                    y3();
                } else if (i3 == 2) {
                    ArrayList<PostData> H2 = M().l1().H();
                    int size2 = H2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= H2.get(i4).b0().size()) {
                                break;
                            } else if (bVar.g.equals(H2.get(i4).b0().get(i5).M())) {
                                H2.get(i4).b0().remove(i5);
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
                        if (N3() != null) {
                            N3().Z1();
                        } else if (D4() && e4() != null) {
                            e4().W1();
                        }
                    }
                    z3(bVar);
                }
            }
        }
    }

    public void H3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f12b0));
            } else if (z3) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
                }
                showToast(str);
            }
        }
    }

    public final void H4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final String J3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0e46);
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

    public PostData P3(h08 h08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, h08Var)) == null) {
            PostData postData = null;
            if (h08Var == null) {
                return null;
            }
            if (h08Var.a0() != null) {
                return h08Var.a0();
            }
            if (!ListUtils.isEmpty(h08Var.H())) {
                Iterator<PostData> it = h08Var.H().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.D() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = h08Var.j();
            }
            if (postData == null) {
                postData = c4(h08Var);
            }
            if (postData != null && postData.r() != null && postData.r().getUserTbVipInfoData() != null && postData.r().getUserTbVipInfoData().getvipIntro() != null) {
                postData.r().getGodUserData().setIntro(postData.r().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void U4(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048649, this, h08Var) != null) || h08Var == null) {
            return;
        }
        ThreadData Q = h08Var.Q();
        if (Q != null && Q.isUgcThreadType()) {
            r3();
        } else {
            p5(this.F0);
        }
        o85 o85Var = this.G0;
        if (o85Var != null) {
            l5(o85Var.y());
            this.G0.H(h08Var.d());
            this.G0.I(h08Var.l(), h08Var.X());
            this.G0.k0(Q);
            if (M() != null) {
                this.G0.J(M().N0(), M().F1(), M().J0());
            }
            if (Q != null) {
                this.G0.Z(Q.isMutiForumThread());
            }
        }
    }

    public void V5(h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, h08Var) == null) {
            if (h08Var != null && AntiHelper.o(h08Var.Q())) {
                r88 r88Var = this.j0;
                if (r88Var != null) {
                    r88Var.l(false);
                    this.j0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.i0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.i0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            r88 r88Var2 = this.j0;
            if (r88Var2 != null && r88Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.i0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.i0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.i0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void Y4(h08 h08Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, h08Var) == null) && h08Var != null && h08Var.Q() != null) {
            V5(h08Var);
            ImageView imageView = this.h0;
            if (h08Var.l0()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (h08Var.r()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String J3 = J3(h08Var.Q().getReply_num());
            TextView textView = this.q0;
            if (textView != null) {
                textView.setText(J3);
            }
            TextView textView2 = this.r0;
            if (textView2 != null) {
                textView2.setText(J3);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, h08Var.Q()));
        }
    }

    public final PostData c4(h08 h08Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, h08Var)) == null) {
            if (h08Var != null && h08Var.Q() != null && h08Var.Q().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = h08Var.Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = h08Var.Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.G0(1);
                postData.M0(h08Var.Q().getFirstPostId());
                postData.d1(h08Var.Q().getTitle());
                postData.c1(h08Var.Q().getCreateTime());
                postData.E0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void j4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048690, this, z2) == null) && this.c0 != null && this.f0 != null) {
            if (M() != null && M().l1() != null) {
                this.f0.setText(TbSingleton.getInstance().getAdVertiComment(M().l1().r0(), M().l1().s0(), f4()));
            } else {
                this.f0.setText(f4());
            }
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.c0.startAnimation(alphaAnimation);
            }
            this.b0.setVisibility(0);
            this.c0.setVisibility(0);
            this.s0.a = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            s4(bundle);
            r0().onCreate(getPageContext());
            wy4 wy4Var = new wy4();
            this.O = wy4Var;
            wy4Var.a = 1000L;
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
            registerListener(this.E1);
            this.t = new f46(getPageContext());
            nq8.g().i(getUniqueId());
        }
    }

    public final void q3(j88 j88Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048722, this, j88Var) == null) && j88Var != null && this.w == null) {
            this.w = j88Var;
            this.C.setText(j88Var.getTitle());
            this.D.setText(j88Var.k());
            String i2 = j88Var.i();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(i2)) {
                i2 = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(i2);
            int i3 = 0;
            this.G.K(j88Var.f(), 10, false);
            View view2 = this.H;
            if (!j88Var.m()) {
                i3 = 8;
            }
            view2.setVisibility(i3);
            ah.a().postDelayed(new k1(this), j88Var.c().longValue() * 1000);
        }
    }

    public final void J4(View view2, String str, String str2, PostData postData) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(1048609, this, view2, str, str2, postData) != null) || view2 == null || str == null || str2 == null || t3() || !v3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.L0);
            this.M0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.I0 != null && postData != null) {
            if (postData.X() != null) {
                str3 = postData.X().toString();
            } else {
                str3 = "";
            }
            this.I0.o(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.r().getName_show(), str3));
        }
        if (M() != null && M().l1() != null && M().l1().l0()) {
            ah.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.C0 == null) {
            vt6 vt6Var = new vt6(getPageContext());
            this.C0 = vt6Var;
            vt6Var.j(1);
            this.C0.i(new j1(this, str, str2));
        }
        if (M() != null && M().l1() != null && M().l1().l() != null) {
            this.C0.g(M().l1().l().getId(), xg.g(M().F1(), 0L));
        }
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || M() == null) {
            return;
        }
        h08 l12 = M().l1();
        M().b3(true);
        jp4 jp4Var = this.P;
        if (jp4Var != null) {
            l12.L0(jp4Var.g());
        }
        if (D4()) {
            if (O3() != null) {
                O3().I1();
            }
            if (e4() != null) {
                e4().W1();
            }
        } else if (N3() != null) {
            N3().Z1();
        }
    }

    public final void Q5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048635, this) != null) || (layoutParams = this.v.getLayoutParams()) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            super.onResume();
            this.R0 = false;
            r0().onResume(getPageContext());
            l88 l88Var = this.k;
            if (l88Var != null) {
                l88Var.onBackground(false);
            }
            F5();
            registerListener(this.e1);
            registerListener(this.f1);
            registerListener(this.d1);
            registerListener(this.D1);
            ItemCardHelper.w(this.G1);
            MessageManager.getInstance().registerListener(this.F1);
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            if (M().Q0() || M().T0()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", M().F1());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, M().F1()));
            if (O5()) {
                this.a.finish();
            }
        }
    }

    public final void K5(PostData postData, PostData postData2, boolean z2, boolean z3) {
        String str;
        int i2;
        AbsPbActivity.e p2;
        boolean z4;
        boolean z5;
        PostData P3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String F1 = M().F1();
            String M = postData.M();
            if (postData2 != null) {
                str = postData2.M();
            } else {
                str = "";
            }
            if (M().l1() != null) {
                i2 = M().l1().Y();
            } else {
                i2 = 0;
            }
            if (e4() != null && e4().U1() != null) {
                p2 = e4().U1().p(M);
            } else if (N3() != null && N3().W1() != null) {
                p2 = N3().W1().p(M);
            } else {
                return;
            }
            AbsPbActivity.e eVar = p2;
            if (postData != null && M() != null && M().l1() != null && eVar != null) {
                if (Q3() != 1 && Q3() != 2 && Q3() != 3 && Q3() != 4 && Q3() != 5) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(F1, M, "pb", true, A4(), null, false, str, i2, postData.e0(), M().l1().d(), false, postData.r().getIconInfo(), Q3(), z4).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
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
                if (M() != null && (P3 = P3(M().l1())) != null) {
                    if (!P3.S && !postData.S) {
                        z5 = false;
                    }
                    addBigImageData.setMainPostMaskVisibly(z5);
                }
                if (A4() && this.a.getIntent() != null) {
                    addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                }
                addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
                sendMessage(new CustomMessage(2002001, addBigImageData));
            }
        }
    }

    public final boolean M4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
            if (StringUtils.isNull(str) || !ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                return false;
            }
            String r2 = ry4.l().r("bubble_link", "");
            if (StringUtils.isNull(r2)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
            } else {
                sp4.s(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), r2 + "?props_id=" + str, true, true, true);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean g5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, view2)) == null) {
            if (view2 == null || !(view2.getTag() instanceof SparseArray)) {
                return false;
            }
            Object obj = ((SparseArray) view2.getTag()).get(R.id.tag_clip_board);
            if (!(obj instanceof PostData)) {
                return false;
            }
            PostData postData = (PostData) obj;
            if (!TextUtils.isEmpty(postData.t()) && dr4.c().g()) {
                return M4(postData.M());
            }
            if (checkUpIsLogin() && M() != null && M().l1() != null) {
                e38 e38Var = this.I0;
                if (e38Var != null) {
                    e38Var.g();
                }
                x08 x08Var = new x08();
                x08Var.A(M().l1().l());
                x08Var.E(M().l1().Q());
                x08Var.C(postData);
                this.J0.c0(x08Var);
                this.J0.setPostId(postData.M());
                J4(view2, postData.r().getUserId(), "", postData);
                TiebaStatic.log("c11743");
                o85 o85Var = this.G0;
                if (o85Var != null) {
                    l5(o85Var.y());
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void w4(h08 h08Var) {
        p15 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048750, this, h08Var) == null) && this.T0 != null && h08Var != null && h08Var.g() != 3 && !A4()) {
            if (h08Var.r0()) {
                pbAdFloatViewItemData = h08Var.d0();
            } else {
                pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
            if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
                if (!RightFloatLayerView.k()) {
                    n4();
                    return;
                }
                if (this.U0 == null) {
                    this.U0 = RightFloatLayerLottieView.F(pbAdFloatViewItemData, getContext());
                    this.T0.removeAllViews();
                    this.T0.addView(this.U0);
                }
                if ((this.K.getTag() instanceof Boolean) && !((Boolean) this.K.getTag()).booleanValue()) {
                    this.U0.setAutoCompleteShown(false);
                    this.U0.setTag(this.K);
                    this.U0.c();
                }
                if (pbAdFloatViewItemData.a()) {
                    return;
                }
                this.U0.setData(pbAdFloatViewItemData);
                this.U0.setLogoListener(new g0(this, h08Var, pbAdFloatViewItemData));
                this.U0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
                return;
            }
            n4();
        }
    }

    public void z3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, bVar) == null) {
            List<PostData> list = M().l1().V().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).b0().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).b0().get(i3).M())) {
                        list.get(i2).b0().remove(i3);
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
                if (N3() != null) {
                    N3().Z1();
                } else if (D4() && e4() != null) {
                    e4().W1();
                }
            }
        }
    }

    public boolean N4(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        l88 l88Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, keyEvent)) == null) {
            if (!this.n1 && (this.o1 || E4())) {
                I5();
                UtilHelper.hideStatusBar(R(), R().getRootView());
                this.o1 = false;
                l88 l88Var2 = this.k;
                if (l88Var2 != null) {
                    l88Var2.S0(false);
                }
            }
            if (i2 == 4) {
                l88 l88Var3 = this.k;
                if (l88Var3 == null) {
                    return false;
                }
                return l88Var3.onBackPress();
            } else if (i2 == 24) {
                l88 l88Var4 = this.k;
                if (l88Var4 == null) {
                    return false;
                }
                return l88Var4.onVolumeUp();
            } else if (i2 != 25 || (l88Var = this.k) == null) {
                return false;
            } else {
                return l88Var.P0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final boolean O5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (M() == null) {
                return true;
            }
            if (M().l1() != null && M().l1().l0()) {
                return true;
            }
            if (M().W0()) {
                MarkData H0 = M().H0();
                if (H0 != null && M().U0() && d4() != null) {
                    MarkData B0 = M().B0(d4().getFirstVisiblePosition());
                    if (B0 == null) {
                        Intent intent = new Intent();
                        intent.putExtra("mark", H0);
                        this.a.setResult(-1, intent);
                        return true;
                    } else if (B0.getPostId() != null && !B0.getPostId().equals(H0.getPostId())) {
                        lv4 lv4Var = new lv4(getBaseFragmentActivity());
                        lv4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f026f));
                        lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0446, new t(this, B0, H0, lv4Var));
                        lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new u(this, H0, lv4Var));
                        lv4Var.setOnCalcelListener(new w(this));
                        lv4Var.create(getBaseFragmentActivity().getPageContext());
                        lv4Var.show();
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

    public final void r3() {
        Bundle extras;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && M() != null && this.a != null) {
            o85 o85Var = this.G0;
            if (o85Var != null && o85Var.t) {
                return;
            }
            n85 n85Var = new n85();
            p5(n85Var);
            o85 o85Var2 = (o85) n85Var.a(getContext());
            this.G0 = o85Var2;
            o85Var2.W(this.a.getPageContext());
            this.G0.f0(this.h1);
            this.G0.g0(this.z1);
            o85 o85Var3 = this.G0;
            TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
            if (this.a.getIntent() == null) {
                extras = null;
            } else {
                extras = this.a.getIntent().getExtras();
            }
            o85Var3.A(pageContext, extras);
            this.G0.b().D(true);
            j5(this.G0.b());
            if (!M().Y0()) {
                this.G0.q(M().F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.G0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().T1()) {
                this.G0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.G0.c0(f4());
            }
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f092611);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802cf);
            int i2 = 0;
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f092045);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f09204c);
            this.o = findViewById;
            if (this.n1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = yi.u(R());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = yi.u(R());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.A1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.widget_navi_back_button);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.A1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(g2, g2);
            layoutParams3.rightMargin = g3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View view2 = this.r;
            if (!TbadkCoreApplication.isLogin()) {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.q1 = new GestureDetector(getContext(), this.r1);
            this.m.setOnTouchListener(this.p1);
        }
    }

    public void Q4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            if (i2 == 0) {
                nq8.g().h(getUniqueId(), false);
                if (d4() != null) {
                    s3(d4(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.U0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.U0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.U0) != null) {
                rightFloatLayerView.r();
            }
        }
    }

    public void R4(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048638, this, z2) != null) || R() == null) {
            return;
        }
        if (this.o1 && !TbSingleton.getInstance().isNotchScreen(R()) && !TbSingleton.getInstance().isCutoutScreen(R())) {
            I5();
            UtilHelper.hideStatusBar(R(), R().getRootView());
            this.o1 = false;
        }
        this.s0.b = z2;
        T4();
        W4();
    }

    public final void S5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, layoutParams) == null) {
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

    public final void T5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, layoutParams) == null) {
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

    public void W5(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048657, this, z2) == null) {
            DetailInfoAndReplyFragment N3 = N3();
            if (N3 != null && N3.x1() != null && N3.x1().f() != null && N3.x1().g() != null) {
                N3.x1().f().u0(z2);
                N3.x1().g().G(z2);
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

    public void j5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, editorTools) == null) {
            this.H0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091896);
            this.H0.setOnCancelClickListener(new f1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.H0.getParent() == null) {
                this.c.addView(this.H0, layoutParams);
            }
            this.H0.x(TbadkCoreApplication.getInst().getSkinType());
            this.H0.setActionListener(24, new g1(this));
            k4();
            this.G0.g(new h1(this));
        }
    }

    public final void p5(q85 q85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048721, this, q85Var) == null) && q85Var != null && M() != null) {
            q85Var.p(M().K0());
            if (M().l1() != null && M().l1().l() != null) {
                q85Var.o(M().l1().l());
            }
            q85Var.q("pb");
            q85Var.r(M());
        }
    }

    public final void t5(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048737, this, i2) != null) || M() == null) {
            return;
        }
        int u12 = M().u1();
        if (i2 != 5) {
            if (i2 != 6) {
                if (i2 != 7) {
                    M().V2(1);
                } else {
                    M().V2(4);
                }
            } else {
                M().V2(3);
            }
        } else {
            M().V2(2);
        }
        int u13 = M().u1();
        if (u12 == 4 || u13 == 4) {
            P4();
        }
    }

    public boolean w3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048749, this, i2)) == null) {
            if (this.A0 != null && M() != null && M().l1() != null && !ThreadCardUtils.isSelf(M().l1().Q()) && M().l1().d() != null) {
                return this.A0.checkPrivacyBeforeSend(M().l1().d().replyPrivateFlag, i2);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.wn5
    public void T(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048644, this, context, str, z2) == null) {
            if (r48.c(str) && M() != null && M().F1() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", M().F1()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    x55 x55Var = new x55();
                    x55Var.a = str;
                    x55Var.b = 3;
                    x55Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, x55Var));
                }
            } else {
                r48.a().e(getPageContext(), str);
            }
            this.Z = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048706, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.G0.C(i2, i3, intent);
            e38 e38Var = this.I0;
            if (e38Var != null) {
                e38Var.k(i2, i3, intent);
            }
            if (i2 == 25035) {
                g4(i3, intent);
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
                                if (L3() != null) {
                                    L3().performClick();
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
                    ci8.g().m(getPageContext());
                    return;
                }
                L4();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void u0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048740, this, spannableStringBuilder, textView, tbRichTextView) != null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (tn5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), tn5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (r48.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new ll5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final void U5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && M() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.L(M().getForumId()) && M().l1() != null && M().l1().l() != null) {
            boolean z2 = true;
            if (M().l1().l().isLike() != 1) {
                z2 = false;
            }
            if (z2) {
                M().y0().K(M().getForumId(), M().F1());
            }
        }
    }

    public void V4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048653, this) != null) || !checkUpIsLogin() || M() == null || M().l1() == null || M().l1().l() == null || t3()) {
            return;
        }
        if (M().l1().l0()) {
            x3();
            return;
        }
        if (this.B0 == null) {
            vt6 vt6Var = new vt6(getPageContext());
            this.B0 = vt6Var;
            vt6Var.j(0);
            this.B0.i(new d1(this));
        }
        this.B0.g(M().l1().l().getId(), xg.g(M().F1(), 0L));
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && this.k != null && this.e != null) {
            boolean z2 = false;
            if (!D4()) {
                this.k.R0(false);
            } else if (this.e.getCurrentItem() != 0) {
                this.k.R0(false);
            } else if (this.s0.a()) {
                this.k.R0(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.k.R0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
                }
            }
        }
    }

    public final void c5() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && this.G0 != null && this.H0 != null) {
            k85.a().c(0);
            this.G0.M();
            this.G0.K();
            if (this.G0.v() != null) {
                WriteImagesInfo v2 = this.G0.v();
                if (this.G0.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            this.G0.d0(SendView.f);
            this.G0.h(SendView.f);
            t65 n2 = this.H0.n(23);
            t65 n3 = this.H0.n(2);
            t65 n4 = this.H0.n(5);
            if (n3 != null) {
                n3.display();
            }
            if (n4 != null) {
                n4.display();
            }
            if (n2 != null) {
                n2.hide();
            }
            this.H0.invalidate();
        }
    }

    public final void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048699, this) == null) && M() != null && M().l1() != null && M().l1().Q() != null) {
            ThreadData Q = M().l1().Q();
            Q.mRecomAbTag = M().q1();
            Q.mRecomWeight = M().t1();
            Q.mRecomSource = M().s1();
            Q.mRecomExtra = M().r1();
            Q.isSubPb = M().Y0();
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = ue5.i(getContext(), Q, "c13562");
            if (i2 != null) {
                TiebaStatic.log(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onPause();
            this.R0 = true;
            r0().onPause();
            l88 l88Var = this.k;
            if (l88Var != null) {
                l88Var.onBackground(true);
            }
            if (M() != null && !M().Y0()) {
                this.G0.N(M().F1());
            }
            RightFloatLayerView rightFloatLayerView = this.U0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            km4.w().E();
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.d1);
            MessageManager.getInstance().unRegisterListener(this.D1);
        }
    }

    public final void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            this.J0 = new PbFakeFloorModel(getPageContext());
            PbModel M = M();
            this.J0.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
            this.J0.setFromForumId(M.getFromForumId());
            e38 e38Var = new e38(getPageContext(), this.J0, this.c);
            this.I0 = e38Var;
            e38Var.p(new y0(this));
            this.I0.s(this.y1);
            this.J0.b0(new z0(this));
        }
    }

    public boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            if ((M() != null && M().l1().l0()) || this.A0 == null || M() == null || M().l1() == null || ThreadCardUtils.isSelf(M().l1().Q()) || M().l1().d() == null) {
                return true;
            }
            return this.A0.checkPrivacyBeforeInvokeEditor(M().l1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            if (!checkUpIsLogin()) {
                if (M() != null) {
                    i78.r("c10517", M().getForumId(), 2);
                }
            } else if (!v3()) {
            } else {
                o85 o85Var = this.G0;
                if (o85Var != null && (o85Var.x() || this.G0.z())) {
                    this.G0.w(false, null);
                    return;
                }
                if (this.H0 != null) {
                    v4();
                    this.s0.a = false;
                    if (this.H0.o(2) != null) {
                        wr8.c(getPageContext(), (View) this.H0.o(2).m, false, null);
                    }
                }
                i4();
            }
        }
    }

    public SparseArray<Object> W3(h08 h08Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData P3;
        boolean z3;
        at4 at4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048655, this, new Object[]{h08Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (h08Var == null || (P3 = P3(h08Var)) == null) {
                return null;
            }
            String userId = P3.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, P3.M());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(h08Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (P3.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, P3.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, P3.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, P3.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, P3.M());
                }
                sparseArray.put(R.id.tag_del_post_id, P3.M());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(h08Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<uu4> p2 = h08Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (uu4 uu4Var : p2) {
                        if (uu4Var != null && !StringUtils.isNull(uu4Var.d()) && (at4Var = uu4Var.f) != null && at4Var.a && !at4Var.c && ((i3 = at4Var.b) == 1 || i3 == 2)) {
                            sb.append(xi.cutString(uu4Var.d(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0683));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04b9), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.wn5
    public void X(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048658, this, context, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.N.q0(str);
            nv4 R = this.N.R();
            if (R == null) {
                this.N.W();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                R.f(1).setVisibility(8);
            } else {
                R.f(1).setVisibility(0);
            }
            R.m();
            this.Z = true;
        }
    }

    public final void x5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048754, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                g88 g88Var = this.N;
                if (g88Var != null) {
                    g88Var.L0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public void X4(boolean z2, int i2, int i3, int i4, h08 h08Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), h08Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof r78) {
                    ((r78) baseFragment).n1(z2, i2, i3, i4, h08Var, str, i5);
                }
            }
            n1(z2, i2, i3, i4, h08Var, str, i5);
        }
    }

    public void b5(x08 x08Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048670, this, x08Var) == null) && M() != null && M().l1() != null && x08Var.i() != null) {
            String M = x08Var.i().M();
            ArrayList<PostData> H = M().l1().H();
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                z2 = true;
                if (i2 >= H.size()) {
                    break;
                }
                PostData postData = H.get(i2);
                if (postData.M() != null && postData.M().equals(M)) {
                    ArrayList<PostData> k2 = x08Var.k();
                    postData.a1(x08Var.m());
                    if (postData.b0() != null && k2 != null) {
                        Iterator<PostData> it = k2.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.j0() != null && next != null && next.r() != null && (metaData = postData.j0().get(next.r().getUserId())) != null) {
                                next.E0(metaData);
                                next.Q0(true);
                                next.j1(getPageContext(), M().d2(metaData.getUserId()));
                            }
                        }
                        if (k2.size() != postData.b0().size()) {
                            z3 = true;
                        }
                        if (!postData.q0(true)) {
                            postData.b0().clear();
                            postData.b0().addAll(k2);
                        }
                        z2 = z3;
                    }
                    if (postData.z() != null) {
                        postData.C0();
                    }
                } else {
                    i2++;
                }
            }
            if (!M().U0() && z2) {
                if (D4() && e4() != null) {
                    e4().W1();
                } else if (N3() != null) {
                    N3().Z1();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906fd));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            U4(videoPbViewModel.c());
            w4(videoPbViewModel.c());
            a5(videoPbViewModel.c());
            if (M() != null && M().l1() != null) {
                boolean U0 = M().U0();
                h08 l12 = M().l1();
                if (U0) {
                    PostData P3 = P3(l12);
                    if (l12.v() != null && !l12.v().equals(P3.M()) && this.e != null) {
                        if (D4()) {
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
            this.a.l1().d(this.S0);
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
    public final void p3(ThreadData threadData) {
        double d3;
        int ceil;
        int i2;
        int i3;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect C0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, threadData) == null) {
            double l2 = yi.l(getContext());
            double j2 = (2.0d * l2) / yi.j(getContext());
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
                    if (D4()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, L1);
                        } else {
                            layoutParams3.height = L1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (D4()) {
                        ceil += L1;
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
            if (D4()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (D4()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i3 == 0) {
            }
        }
    }

    @Override // com.baidu.tieba.s78
    public void finish() {
        CardHListViewData q2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            PbModel j12 = this.a.j1();
            if (j12 != null && j12.l1() != null && !j12.l1().l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = j12.l1().Q().getId();
                if (j12.isShareThread() && j12.l1().Q().originalThreadData != null) {
                    historyMessage.threadName = j12.l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = j12.l1().Q().getTitle();
                }
                if (j12.isShareThread() && !s0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = j12.l1().l().getName();
                }
                ArrayList<PostData> H = j12.l1().H();
                if (e4() != null) {
                    i2 = e4().N1();
                } else {
                    i2 = 0;
                }
                if (H != null && i2 >= 0 && i2 < H.size()) {
                    historyMessage.postID = H.get(i2).M();
                }
                historyMessage.isHostOnly = j12.O0();
                historyMessage.isSquence = j12.D1();
                historyMessage.isShareThread = j12.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            o85 o85Var = this.G0;
            if (o85Var != null) {
                o85Var.D();
            }
            if (j12 != null && (j12.Q0() || j12.T0())) {
                Intent intent = new Intent();
                intent.putExtra("tid", j12.F1());
                if (this.w0) {
                    if (this.y0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", j12.Z0());
                    }
                    if (this.x0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", j12.V0());
                    }
                }
                if (j12.l1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = j12.l1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (O5()) {
                if (j12 != null) {
                    h08 l12 = j12.l1();
                    if (l12 != null) {
                        if (l12.X() != null) {
                            l12.X().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            l12.X().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.z0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                a48.b().t(rect);
                            }
                            a48.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView d4 = d4();
                            Parcelable parcelable = null;
                            if (d4 != null) {
                                parcelable = d4.onSaveInstanceState();
                            }
                            a48.b().n(j12.m1(), parcelable, j12.D1(), j12.O0(), false);
                        }
                    }
                } else {
                    a48.b().m();
                }
                N5();
            }
        }
    }

    public void y4() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            wa6 wa6Var = new wa6(getActivity());
            this.K0 = wa6Var;
            wa6Var.i(this.x1);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.n1 = z2;
            u4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0902ba);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f09194a);
            this.T0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091cf8);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091938);
            l88 l88Var = new l88(getContext(), this.j);
            this.k = l88Var;
            l88Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(R().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091e8c)).setMinimumHeight(((int) Math.ceil((yi.l(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f09194e);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f091945);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091950);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f0910d4);
            this.A = (MaskView) this.c.findViewById(R.id.mask_view);
            this.h.setOnClickListener(this.A1);
            x4();
            t4();
            p4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0926a5);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f0909c9);
            k5();
            this.K.setAnimationListener(new s0(this));
            r4();
            q4();
            if (!this.n1 && this.o1) {
                I5();
                UtilHelper.hideStatusBar(R(), R().getRootView());
                this.o1 = false;
            }
            if (!D4()) {
                this.d.getLayoutParams().height = 0;
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
    public void h4(boolean z2) {
        h08 l12;
        int i2;
        r88 r88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048685, this, z2) == null) && M() != null && this.N != null) {
            if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (l12 = M().l1()) == null) {
                return;
            }
            ThreadData Q = l12.Q();
            int i3 = 1;
            if (Q != null && Q.getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13402").param("tid", M().F1()).param("fid", l12.m()).param("obj_locate", 4).param("uid", TbadkCoreApplication.getCurrentAccount()));
                if (A4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", M().getForumId());
                    statisticItem.param("tid", M().F1());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", R3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 14);
                    statisticItem.param("obj_locate", Q3());
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
                    if (Q.getBaijiahaoData() != null && !xi.isEmpty(Q.getBaijiahaoData().oriUgcVid)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, Q.getBaijiahaoData().oriUgcVid);
                    }
                }
                if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                }
                if (R() != null) {
                    ue5.e(R(), statisticItem2);
                }
                r88Var = this.j0;
                if (r88Var != null) {
                    statisticItem2.param("obj_param1", r88Var.g());
                }
                TiebaStatic.log(statisticItem2);
                if (yi.F()) {
                    showToast(R.string.obfuscated_res_0x7f0f0cb8);
                    return;
                } else if (M().l1() == null) {
                    yi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                    return;
                } else {
                    ArrayList<PostData> H = l12.H();
                    if ((H == null || H.size() <= 0) && M().D1()) {
                        yi.Q(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0e5e));
                        return;
                    }
                    this.N.F();
                    M5();
                    TiebaStatic.log(new StatisticItem("c11939"));
                    if (AntiHelper.e(getContext(), Q)) {
                        return;
                    }
                    r88 r88Var2 = this.j0;
                    if (r88Var2 != null) {
                        r88Var2.l(false);
                        V5(l12);
                    }
                    if (ShareSwitch.isOn()) {
                        if (z2) {
                            i3 = 2;
                        }
                        if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.j0.i()) {
                            this.j0.m(false);
                            o4(i45.a(), this.j0.g());
                            return;
                        }
                        E5(i3);
                        return;
                    }
                    this.N.C0();
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
            if (!xi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            }
            if (R() != null) {
            }
            r88Var = this.j0;
            if (r88Var != null) {
            }
            TiebaStatic.log(statisticItem22);
            if (yi.F()) {
            }
        }
    }

    public final void o3(boolean z2, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048702, this, z2, str) == null) && M() != null && M().l1() != null && M().l1().Q() != null) {
            ThreadData Q = M().l1().Q();
            Q.mRecomAbTag = M().q1();
            Q.mRecomWeight = M().t1();
            Q.mRecomSource = M().s1();
            Q.mRecomExtra = M().r1();
            if (Q.getFid() == 0) {
                Q.setFid(xg.g(M().getForumId(), 0L));
            }
            StatisticItem i2 = ue5.i(getContext(), Q, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            TbPageTag l2 = ue5.l(getContext());
            if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
            }
            if (i2 != null) {
                if (Q.isVideoThreadType()) {
                    if (pk5.d(str) > 40) {
                        str2 = pk5.l(str, 40);
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
                pe5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                if (currentVisiblePageExtra != null) {
                    i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                if (Q3() == 1) {
                    i2.param("obj_locate", 4);
                } else if (Q3() == 2) {
                    i2.param("obj_locate", 5);
                } else if (Q3() == 3) {
                    i2.param("obj_locate", 2);
                } else if (Q3() == 4) {
                    i2.param("obj_locate", 3);
                } else if (Q3() == 7) {
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
            StatisticItem i3 = ue5.i(getContext(), Q, "c14180");
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
            StatisticItem i4 = ue5.i(getContext(), Q, "c14303");
            if (i4 != null) {
                if (Q3() == 1) {
                    i4.param("obj_locate", 1);
                } else if (Q3() == 2) {
                    i4.param("obj_locate", 2);
                } else if (Q3() == 3) {
                    i4.param("obj_locate", 3);
                } else if (Q3() == 4) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z2 = true;
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            tq4 layoutMode = getBaseFragmentActivity().getLayoutMode();
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
            o48 o48Var = this.D0;
            if (o48Var != null) {
                o48Var.i();
            }
            v78 v78Var = this.l;
            if (v78Var == null || !v78Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.H0;
            if (editorTools != null) {
                editorTools.x(i2);
            }
            e38 e38Var = this.I0;
            if (e38Var != null) {
                e38Var.l(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.U0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            LinearLayout linearLayout = this.d0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(yi.g(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
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
                V5(M().l1());
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.c0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.b0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.q0, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (N3() != null) {
                N3().onChangeSkinType(i2);
            } else if (D4() && e4() != null) {
                e4().onChangeSkinType(i2);
            }
            if (O3() != null) {
                O3().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(yi.g(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            M5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            super.onDestroy();
            nq8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.E1);
            ItemCardHelper.w(null);
            r0().onDestory(getPageContext());
            r88 r88Var = this.j0;
            if (r88Var != null) {
                r88Var.k();
            }
            ForumManageModel forumManageModel = this.R;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            l88 l88Var = this.k;
            if (l88Var != null) {
                l88Var.O0();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.A0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            g88 g88Var = this.N;
            if (g88Var != null) {
                g88Var.o0();
            }
            e38 e38Var = this.I0;
            if (e38Var != null) {
                e38Var.m();
            }
            if (M() != null) {
                M().cancelLoadData();
                M().destory();
                if (M().h1() != null) {
                    M().h1().d();
                }
            }
            o85 o85Var = this.G0;
            if (o85Var != null) {
                o85Var.D();
            }
            this.O = null;
            wr8.d();
            L5();
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091948);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091947);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091944);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091943);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091946);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901fa);
            this.G.setRadius(yi.g(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new qz4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (M() != null && M().l1() != null) {
                B5(M().l1());
            }
        }
    }

    public final void x4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void z4() {
        int u2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048760, this) == null) && this.l == null) {
            this.l = new v78(getBaseFragmentActivity(), this.j);
            if (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity())) {
                u2 = 0;
            } else {
                u2 = yi.u(R());
            }
            Rect rect = new Rect(0, u2, yi.l(getContext()), this.j.getOriginHeight() + u2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (D4() && (videoPbViewModel.n() || M().E1() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || M().E1() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    public void s3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048731, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().E(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().E(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.D());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((f55) ListUtils.getItem(arrayList, 0)).e() == 1) {
                    if (!z2) {
                        S4((f55) ListUtils.getItem(arrayList, 0), 0);
                        return;
                    }
                    return;
                }
                S4((f55) ListUtils.getItem(arrayList, 0), 1);
            }
        }
    }

    public final void y5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048758, this, antiData, postWriteCallBackData) == null) && antiData != null && postWriteCallBackData != null) {
            if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
                if (postWriteCallBackData.getIconStampData() != null) {
                    r45.c(getPageContext(), postWriteCallBackData, 2);
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

    public final void s4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048732, this, bundle) == null) {
            q85 q85Var = new q85();
            this.F0 = q85Var;
            p5(q85Var);
            o85 o85Var = (o85) this.F0.a(getActivity());
            this.G0 = o85Var;
            o85Var.W(this.a.getPageContext());
            this.G0.f0(this.h1);
            this.G0.g0(this.z1);
            this.G0.Y(1);
            this.G0.d0(SendView.f);
            this.G0.h(SendView.f);
            this.G0.A(this.a.getPageContext(), bundle);
            this.G0.b().b(new w65(getActivity()));
            this.G0.b().D(true);
            w5(true);
            if (M() != null) {
                this.G0.J(M().N0(), M().F1(), M().J0());
            }
            registerListener(this.Z0);
            registerListener(this.b1);
            registerListener(this.j1);
            registerListener(this.Y0);
            registerListener(this.a1);
            registerListener(this.c1);
            registerListener(this.H1);
            if (!M().Y0()) {
                this.G0.q(M().F1());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.G0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (M().T1()) {
                this.G0.c0(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
            } else {
                this.G0.c0(f4());
            }
            this.D0 = new o48();
            if (this.G0.s() != null) {
                this.D0.m(this.G0.s().i());
            }
            this.G0.V(this.X0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.A0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }
}
