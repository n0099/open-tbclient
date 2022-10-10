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
import androidx.constraintlayout.motion.widget.Key;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tieba.aj5;
import com.baidu.tieba.an8;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.cz7;
import com.baidu.tieba.d35;
import com.baidu.tieba.dh;
import com.baidu.tieba.di5;
import com.baidu.tieba.dj;
import com.baidu.tieba.ds4;
import com.baidu.tieba.e15;
import com.baidu.tieba.ed8;
import com.baidu.tieba.ej;
import com.baidu.tieba.f75;
import com.baidu.tieba.fh5;
import com.baidu.tieba.g16;
import com.baidu.tieba.g75;
import com.baidu.tieba.gh;
import com.baidu.tieba.gy7;
import com.baidu.tieba.h38;
import com.baidu.tieba.h55;
import com.baidu.tieba.h75;
import com.baidu.tieba.hi5;
import com.baidu.tieba.hq4;
import com.baidu.tieba.i18;
import com.baidu.tieba.i55;
import com.baidu.tieba.i75;
import com.baidu.tieba.ih5;
import com.baidu.tieba.il5;
import com.baidu.tieba.j28;
import com.baidu.tieba.j75;
import com.baidu.tieba.ji5;
import com.baidu.tieba.jv7;
import com.baidu.tieba.k38;
import com.baidu.tieba.ku8;
import com.baidu.tieba.kw7;
import com.baidu.tieba.l18;
import com.baidu.tieba.l35;
import com.baidu.tieba.l38;
import com.baidu.tieba.l75;
import com.baidu.tieba.ll5;
import com.baidu.tieba.ll8;
import com.baidu.tieba.lz4;
import com.baidu.tieba.lz7;
import com.baidu.tieba.m38;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n25;
import com.baidu.tieba.n75;
import com.baidu.tieba.nu4;
import com.baidu.tieba.o05;
import com.baidu.tieba.o55;
import com.baidu.tieba.oc5;
import com.baidu.tieba.ox4;
import com.baidu.tieba.oy4;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pu4;
import com.baidu.tieba.pu7;
import com.baidu.tieba.q9;
import com.baidu.tieba.ql4;
import com.baidu.tieba.qo4;
import com.baidu.tieba.qz7;
import com.baidu.tieba.r55;
import com.baidu.tieba.rl4;
import com.baidu.tieba.s28;
import com.baidu.tieba.s38;
import com.baidu.tieba.s45;
import com.baidu.tieba.s55;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.t28;
import com.baidu.tieba.t55;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tc5;
import com.baidu.tieba.tz7;
import com.baidu.tieba.ug;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.ux4;
import com.baidu.tieba.vg;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.vm8;
import com.baidu.tieba.w28;
import com.baidu.tieba.x76;
import com.baidu.tieba.xt4;
import com.baidu.tieba.y15;
import com.baidu.tieba.yo4;
import com.baidu.tieba.yq6;
import com.baidu.tieba.z35;
import com.baidu.tieba.zv7;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements ll5, VoiceManager.j, t28, TbRichTextView.s, s28 {
    public static /* synthetic */ Interceptable $ic;
    public static final int L1;
    public static final int M1;
    public static int N1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public ReplyPrivacyCheckController A0;
    public h75 A1;
    public View.OnClickListener B;
    public yq6 B0;
    public final View.OnClickListener B1;
    public TextView C;
    public yq6 C0;
    public View.OnClickListener C1;
    public TextView D;
    public qz7 D0;
    public final AdapterView.OnItemClickListener D1;
    public ImageView E;
    public PermissionJudgePolicy E0;
    public CustomMessageListener E1;
    public TBSpecificationBtn F;
    public l75 F0;
    public CustomMessageListener F1;
    public TbImageView G;
    public j75 G0;
    public CustomMessageListener G1;
    public View H;
    public EditorTools H0;
    public final ItemCardHelper.c H1;
    public ValueAnimator I;
    public gy7 I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public PbFakeFloorModel J0;
    public final View.OnLongClickListener J1;
    public FallingView K;
    public x76 K0;
    public SortSwitchButton.f K1;
    public boolean L;
    public int[] L0;
    public View M;
    public int M0;
    public h38 N;
    public int N0;
    public ux4 O;
    public int O0;
    public qo4 P;
    public int P0;
    public n25 Q;
    public int Q0;
    public ForumManageModel R;
    public boolean R0;
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
    public final qo4.a X0;
    public ug<RelativeLayout> Y;
    public g75 Y0;
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
    public g75 h1;
    public AppBarLayout i;
    public ImageView i0;
    public final NewWriteModel.d i1;
    public VideoContainerLayout j;
    public s38 j0;
    public View.OnClickListener j1;
    public m38 k;
    public CustomMessageListener k1;
    public w28 l;
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
    public TextView q0;
    public View.OnTouchListener q1;
    public View r;
    public TextView r0;
    public GestureDetector r1;
    public ImageView s;
    public d2 s0;
    public GestureDetector.SimpleOnGestureListener s1;
    public g16 t;
    public String t0;
    public Runnable t1;
    public boolean u;
    public boolean u0;
    public ObjectAnimator u1;
    public View v;
    public String v0;
    public ObjectAnimator v1;
    public k38 w;
    public boolean w0;
    public final q9 w1;
    public View x;
    public boolean x0;
    public View.OnTouchListener x1;
    public View y;
    public boolean y0;
    public final x76.b y1;
    public View z;
    public boolean z0;
    public NewWriteModel.d z1;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.R0) {
                return;
            }
            this.a.A5();
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements ih5<ShareItem> {
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
        @Override // com.baidu.tieba.ih5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                Bundle bundle = new Bundle();
                bundle.putInt("source", 3);
                bundle.putInt("obj_param1", this.a);
                shareItem.k(bundle);
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
            String a4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.K() != null && this.a.K().A2()) {
                    a4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a);
                } else {
                    a4 = this.a.a4();
                }
                if (!StringUtils.isNull(a4) && this.a.K() != null && this.a.K().S1() != null) {
                    a4 = TbSingleton.getInstance().getAdVertiComment(this.a.K().S1().n0(), this.a.K().S1().o0(), a4);
                }
                if (this.a.G0 != null) {
                    this.a.G0.c0(a4);
                }
                if (this.a.f0 != null) {
                    this.a.f0.setText(a4);
                }
                this.a.u5(false);
                this.a.y5();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                this.a.P5();
            }
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092085) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092085)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092099) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092099)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092083) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092083)).booleanValue() : false;
            h38 h38Var = this.a.N;
            if (h38Var != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092050, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.TRUE);
                    this.a.N.l0(view2);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092050, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f092039, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    h38Var.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b1 implements SortSwitchButton.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
                h38 h38Var = this.a.N;
                if (h38Var != null) {
                    h38Var.F();
                }
                boolean z = false;
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                    return false;
                }
                if (this.a.K() != null && !this.a.K().isLoading) {
                    this.a.H5();
                    this.a.n5();
                    z = true;
                    if (this.a.K().S1() != null && this.a.K().S1().f != null && this.a.K().S1().f.size() > i) {
                        int intValue = this.a.K().S1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.K().n2()).param("fid", this.a.K().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.K().L3(intValue)) {
                            this.a.L = true;
                        }
                    }
                }
                return z;
            }
            return invokeI.booleanValue;
        }

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.K() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.G0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.g5(absVideoPbFragment.G0.y());
            }
            this.a.Y4();
            this.a.N.F();
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
                if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage)) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    if (TextUtils.equals("reply", privacySettingMessage.getOperation())) {
                        int type = privacySettingMessage.getType();
                        if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                            BdTopToast bdTopToast = new BdTopToast(this.a.getContext());
                            bdTopToast.h(true);
                            bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0327));
                            bdTopToast.i((ViewGroup) this.a.getView());
                            this.a.o5(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.K() == null || this.a.K().b2() == i + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            absVideoPbFragment.c5(absVideoPbFragment.W3(i));
        }
    }

    /* loaded from: classes5.dex */
    public class c1 implements PbModel.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), responsedMessage, Boolean.valueOf(z2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void b(jv7 jv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jv7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, jv7 jv7Var, String str, int i4) {
            String a4;
            o55 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), jv7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d3));
                }
                this.a.m5();
                this.a.h4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.u5(false);
                if (z && jv7Var != null) {
                    ThreadData O = jv7Var.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(jv7Var, i2);
                    this.a.P4(jv7Var);
                    this.a.w5(jv7Var);
                    this.a.V4(jv7Var);
                    this.a.S4(z, i, i2, i3, jv7Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(jv7Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleDynamicRes(jv7Var.V().getDynamicUrl());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(jv7Var.V().getBimg_end_time());
                    if (jv7Var.F() != null && jv7Var.F().size() >= 1 && jv7Var.F().get(0) != null) {
                        this.a.K().r3(jv7Var.F().get(0).L());
                    } else if (jv7Var.X() != null) {
                        this.a.K().r3(jv7Var.X().L());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(jv7Var.r());
                    }
                    AntiData d = jv7Var.d();
                    if (d != null) {
                        this.a.v0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.v0) && this.a.G0 != null && this.a.G0.a() != null && (m = this.a.G0.a().m(6)) != null && !TextUtils.isEmpty(this.a.v0)) {
                            ((View) m).setOnClickListener(this.a.j1);
                        }
                    }
                    if (this.a.A0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.A0.setLikeUserData(attentionHostData);
                    }
                    this.a.r4(jv7Var);
                    if (this.a.K() != null && this.a.K().A2()) {
                        a4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a);
                    } else {
                        a4 = this.a.a4();
                    }
                    if (!StringUtils.isNull(a4)) {
                        this.a.G0.c0(TbSingleton.getInstance().getAdVertiComment(jv7Var.n0(), jv7Var.o0(), a4));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.K().m2());
                            jSONObject.put("fid", this.a.K().getForumId());
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
                    if ((this.a.y4() && this.a.Z3() == null) || this.a.I3() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.y4()) {
                        if (i != -1) {
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                arrayList = this.a.K().S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).C() != 1)) {
                                this.a.Z3().X1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a02));
                            } else if (this.a.Z3().R1()) {
                                this.a.Z3().Y1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfb));
                            } else {
                                this.a.Z3().Y1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfc));
                            }
                        } else {
                            this.a.Z3().X1("");
                        }
                        this.a.Z3().E1();
                    } else {
                        if (i != -1) {
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                arrayList = this.a.K().S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).C() != 1)) {
                                this.a.I3().e2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a02));
                            } else if (this.a.I3().V1()) {
                                this.a.I3().f2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfb));
                            } else {
                                this.a.I3().f2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dfc));
                            }
                        } else {
                            this.a.I3().e2("");
                        }
                        this.a.I3().G1();
                    }
                }
                ll8.g().h(this.a.getUniqueId(), false);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            pu7 pu7Var = (pu7) customResponsedMessage.getData();
            int type = pu7Var.getType();
            if (type == 0) {
                this.a.W4((zv7) pu7Var.a());
            } else if (type == 1) {
                this.a.B3((ForumManageModel.b) pu7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (pu7Var.a() == null) {
                    this.a.U4(false, null);
                } else {
                    this.a.U4(true, (MarkData) pu7Var.a());
                }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ku8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                ku8 ku8Var = (ku8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = ku8Var.a;
                if (ku8Var.c == 0 && dataRes != null) {
                    int e = dh.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (dj.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f092093, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092099, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092050)).intValue();
                if (intValue == 0) {
                    this.a.N.F0(r3, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09205e, Boolean.TRUE);
                    this.a.N.k0(sparseArray, r3);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof il5.a)) {
                il5.a aVar = (il5.a) customResponsedMessage.getData();
                il5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d1 implements yq6.d {
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

        @Override // com.baidu.tieba.yq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.G0 != null && this.a.G0.a() != null) {
                    this.a.G0.a().A(new h55(45, 27, null));
                }
                this.a.s3();
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.N == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteAddResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            h38 h38Var = this.a.N;
            if (tag == h38Var.D) {
                h38Var.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                jv7 S1 = this.a.K().S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4e));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4a);
                    }
                    this.a.N.L0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.E0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (dj.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b4b);
                    }
                    this.a.O.c(errorString2);
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
            an8 an8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof an8) || (an8Var = (an8) customResponsedMessage.getData()) == null || (agreeData = an8Var.b) == null || agreeData.agreeType != 2 || this.a.j0 == null || this.a.K() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || i18.k(this.a.K().m2())) {
                return;
            }
            this.a.j0.o(2);
            i18.b(this.a.K().m2());
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
        public void onNavigationButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nu4Var) == null) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.N == null || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof UserMuteDelResponseMessage)) {
                return;
            }
            BdUniqueId tag = customResponsedMessage.getOrginalMessage().getTag();
            h38 h38Var = this.a.N;
            if (tag == h38Var.D) {
                h38Var.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14bf));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (dj.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14be);
                }
                this.a.O.c(muteMessage);
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
            m38 m38Var;
            BdTypeRecyclerView Y3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (m38Var = this.a.k) == null) {
                return;
            }
            if (m38Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!dj.isEmpty(this.a.k.c0())) {
                this.a.z0 = true;
                if (this.a.y4()) {
                    this.a.e.setCurrentItem(0);
                } else {
                    this.a.e.setCurrentItem(0);
                }
                if (!this.a.y4() && (Y3 = this.a.Y3()) != null) {
                    Y3.scrollToPosition(0);
                }
            }
            if (this.a.l == null || !this.a.l.k()) {
                this.a.Z4();
                this.a.k3(threadData);
            }
            this.a.u4();
            if (this.a.l != null && this.a.l.l()) {
                this.a.l.s();
            }
            boolean z = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
            this.a.k.setData(threadData);
            if (this.a.y4()) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k.R0(absVideoPbFragment.e.getCurrentItem() == 0);
            } else {
                this.a.k.R0(false);
            }
            if (z) {
                this.a.k.startPlay();
                this.a.k.u0();
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
                this.a.Y4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements g75 {
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

        @Override // com.baidu.tieba.g75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qz7 qz7Var = this.a.D0;
                if (qz7Var == null || qz7Var.g() == null || !this.a.D0.g().d()) {
                    return !this.a.r3(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.D0.g().c());
                if (this.a.I0 != null && this.a.I0.b() != null && this.a.I0.b().y()) {
                    this.a.I0.b().w(this.a.D0.h());
                }
                this.a.D0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jv7 a;
        public final /* synthetic */ o05 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, jv7 jv7Var, o05 o05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, jv7Var, o05Var};
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
            this.a = jv7Var;
            this.b = o05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b == null || this.c.V0 == null) {
                return;
            }
            this.c.V0.g(this.b);
            this.c.V0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g1 implements i55 {
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

        @Override // com.baidu.tieba.i55
        public void B(h55 h55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) {
                Object obj = h55Var.c;
                if ((obj instanceof e15) && EmotionGroupType.isSendAsPic(((e15) obj).getType())) {
                    if (this.a.E0 == null) {
                        this.a.E0 = new PermissionJudgePolicy();
                    }
                    this.a.E0.clearRequestPermissionList();
                    this.a.E0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.G0.e((e15) h55Var.c);
                    this.a.G0.w(false, null);
                }
            }
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.b.a.N4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        statisticItem.param("fid", this.a.K().S1().m());
                    }
                    statisticItem.param("tid", this.a.K().m2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.H5();
                this.a.l5(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (writeData != null) {
                    lz4.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.G0.x() || this.a.G0.z()) {
                            this.a.G0.w(false, postWriteCallBackData);
                        }
                        this.a.D0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.A0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (y15Var != null || i == 227001) {
                            return;
                        }
                        this.a.s5(i, antiData, str);
                        return;
                    } else {
                        nu4 nu4Var = new nu4(this.a.getActivity());
                        if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                            nu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                        } else {
                            nu4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                        nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(this));
                        nu4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.K().a1(postWriteCallBackData.getPostId());
                    if (this.a.y4() && this.a.Z3() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.P0 = absVideoPbFragment.Z3().H1();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.Q0 = absVideoPbFragment2.Z3().I1();
                        this.a.K().q3(this.a.P0, this.a.Q0);
                    } else if (this.a.I3() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.P0 = absVideoPbFragment3.I3().J1();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.Q0 = absVideoPbFragment4.I3().K1();
                        this.a.K().q3(this.a.P0, this.a.Q0);
                    }
                }
                if (this.a.e != null) {
                    if (this.a.y4()) {
                        this.a.e.setCurrentItem(1);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                }
                this.a.N.F();
                this.a.D0.c();
                if (this.a.G0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                    absVideoPbFragment5.g5(absVideoPbFragment5.G0.y());
                }
                this.a.f4();
                this.a.u5(true);
                this.a.K().v2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.t5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.K().v1()) {
                        jv7 S1 = this.a.K().S1();
                        if (S1 != null && S1.O() != null && S1.O().getAuthor() != null && (userId = S1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.K().I3()) {
                            this.a.n5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.K().I3()) {
                        this.a.n5();
                    }
                } else if (floor != null) {
                    if (this.a.y4() && this.a.Z3() != null) {
                        this.a.Z3().Q1();
                    } else if (this.a.I3() != null) {
                        this.a.I3().T1();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.j3(z2, writeData != null ? writeData.getContent() : "");
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
            qz7 qz7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qz7Var = this.a.D0) == null || qz7Var.e() == null) {
                return;
            }
            if (!this.a.D0.e().e()) {
                this.a.D0.a(false);
            }
            this.a.D0.e().l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
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
            m38 m38Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (m38Var = this.a.k) == null) {
                return;
            }
            m38Var.U0(threadData);
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
                qz7 qz7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qz7Var = this.a.c.D0) == null || qz7Var.g() == null) {
                    return;
                }
                if (!this.a.c.D0.g().e()) {
                    this.a.c.D0.b(false);
                }
                this.a.c.D0.g().l(false);
            }

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
            int f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = ej.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = ej.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i4 = (absVideoPbFragment.L0[1] + absVideoPbFragment.M0) - i3;
                if (absVideoPbFragment.Y3() != null) {
                    this.c.Y3().smoothScrollBy(0, i4);
                }
                if (this.c.I0 != null) {
                    this.c.G0.a().setVisibility(8);
                    this.c.I0.o(this.a, this.b, this.c.a4(), (this.c.K() == null || this.c.K().S1() == null || this.c.K().S1().O() == null || !this.c.K().S1().O().isBjh()) ? false : false);
                    this.c.I0.l(this.c.L3());
                    n75 b = this.c.I0.b();
                    if (b != null && this.c.K() != null && this.c.K().S1() != null) {
                        b.H(this.c.K().S1().d());
                        b.d0(this.c.K().S1().O());
                    }
                    if (this.c.D0.f() == null && this.c.I0.b().u() != null) {
                        this.c.I0.b().u().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.D0.n(absVideoPbFragment2.I0.b().u().i());
                        this.c.I0.b().N(this.c.h1);
                    }
                }
                this.c.d4();
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (this.a.G0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.g5(absVideoPbFragment.G0.y());
            }
            this.a.u5(false);
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
            m38 m38Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (m38Var = this.a.k) == null) {
                return;
            }
            m38Var.T0(threadData);
        }
    }

    /* loaded from: classes5.dex */
    public class j1 implements yq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$j1$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0380a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0380a(a aVar) {
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
                    qz7 qz7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qz7Var = this.a.a.c.D0) == null || qz7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.D0.g().e()) {
                        this.a.a.c.D0.b(false);
                    }
                    this.a.a.c.D0.g().l(false);
                }

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
                int f;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = ej.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = ej.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f = ej.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i3 = i2 - (i + f);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i4 = (absVideoPbFragment.L0[1] + absVideoPbFragment.M0) - i3;
                    if (absVideoPbFragment.Y3() != null) {
                        this.a.c.Y3().smoothScrollBy(0, i4);
                    }
                    if (this.a.c.I0 != null) {
                        this.a.c.G0.a().setVisibility(8);
                        z = (this.a.c.K() == null || this.a.c.K().S1() == null || this.a.c.K().S1().O() == null || !this.a.c.K().S1().O().isBjh()) ? false : false;
                        gy7 gy7Var = this.a.c.I0;
                        j1 j1Var = this.a;
                        gy7Var.o(j1Var.a, j1Var.b, j1Var.c.a4(), z);
                        this.a.c.I0.l(this.a.c.L3());
                        n75 b = this.a.c.I0.b();
                        if (b != null && this.a.c.K() != null && this.a.c.K().S1() != null) {
                            b.H(this.a.c.K().S1().d());
                            b.d0(this.a.c.K().S1().O());
                        }
                        if (this.a.c.D0.f() == null && this.a.c.I0.b().u() != null) {
                            this.a.c.I0.b().u().g(new C0380a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.D0.n(absVideoPbFragment2.I0.b().u().i());
                            this.a.c.I0.b().N(this.a.c.h1);
                        }
                    }
                    this.a.c.d4();
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

        @Override // com.baidu.tieba.yq6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                gh.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.baidu.tieba.yq6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
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
                if (this.a.w == null || this.a.w.n()) {
                    if (this.a.w != null) {
                        if (!this.a.w.h) {
                            if (this.a.w.m != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.C4(absVideoPbFragment.w.j, this.a.w.i);
                        }
                        if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.K().S1().l().getId()).param("fname", this.a.K().S1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K().S1().Q()).param("obj_param1", this.a.w.k);
                        if (this.a.K().S1().O() != null) {
                            ThreadData O = this.a.K().S1().O();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(O.getThreadAlaInfo());
                            AlaInfoData threadAlaInfo = O.getThreadAlaInfo();
                            String str = TiebaStatic.YYValues.YY_LIVE;
                            if (threadAlaInfo == null || !O.getThreadAlaInfo().isLegalYYLiveData()) {
                                if (this.a.w.m != null) {
                                    TiebaStaticHelper.addYYParam(param, this.a.w.m);
                                    calculateLiveType = YYLiveUtil.calculateLiveType(this.a.w.m);
                                } else {
                                    str = "";
                                }
                            } else {
                                TiebaStaticHelper.addYYParam(param, O.getThreadAlaInfo().mYyExtData);
                            }
                            param.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
                            param.param(TiebaStatic.Params.OBJ_PARAM3, str);
                        }
                        TiebaStatic.log(param);
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.l()).param("obj_type", 2).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K().S1().Q()));
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
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                this.a.R4();
            }
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
                if (this.a.w == null || this.a.w.n()) {
                    if (this.a.w != null && this.a.K() != null && this.a.K().S1() != null && this.a.K().S1().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.K().S1().l().getId()).param("fname", this.a.K().S1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K().S1().Q()).param("obj_param1", this.a.w.k));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.l()).param("obj_type", 2).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.K().S1().Q()));
                }
                this.a.C5();
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
                    return this.a.r1 != null && this.a.r1.onTouchEvent(motionEvent);
                }
                if (this.a.l1 == 1) {
                    if (!this.a.p1) {
                        this.a.E5();
                        UtilHelper.showStatusBar(this.a.P(), this.a.P().getRootView());
                        this.a.p1 = true;
                        gh.a().removeCallbacks(this.a.t1);
                        gh.a().postDelayed(this.a.t1, 3000L);
                    }
                } else if (this.a.l1 == 2 && (this.a.p1 || this.a.z4())) {
                    this.a.D5();
                    UtilHelper.hideStatusBar(this.a.P(), this.a.P().getRootView());
                    this.a.p1 = false;
                    m38 m38Var = this.a.k;
                    if (m38Var != null) {
                        m38Var.S0(false);
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
                this.a.j5(bool.booleanValue());
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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.a.l1 = 0;
                this.a.m1 = 0.0f;
                this.a.n1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            m38 m38Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.m1 += f;
                this.a.n1 += f2;
                if (this.a.l1 == 0 && !this.a.o1 && (m38Var = this.a.k) != null && !m38Var.isFullScreen()) {
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
                if (this.b.y4() && (this.a.n() || this.b.K().l2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.K().l2() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.y4() && (this.a.n() || this.b.K().l2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.K().l2() == 0) {
                    this.b.e.setCurrentItem(0);
                }
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
    }

    /* loaded from: classes5.dex */
    public class m1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ AbsVideoPbFragment b;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.b.O5(this.a);
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p1 && !this.a.z4()) {
                this.a.D5();
                UtilHelper.hideStatusBar(this.a.P(), this.a.P().getRootView());
                this.a.p1 = false;
            }
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
                } else if (i != ReplyPrivacyCheckController.TYPE_FLOOR || this.a.I0 == null || this.a.I0.b() == null) {
                } else {
                    this.a.I0.b().G();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n1 implements qo4.a {
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

        @Override // com.baidu.tieba.qo4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.m5();
                if (z && this.a.K() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.K().H3(z2);
                    if (this.a.K().S1() != null && (O = this.a.K().S1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.K().D1()) {
                        this.a.F4();
                    } else if (this.a.y4()) {
                        if (this.a.J3() != null) {
                            this.a.J3().C1();
                        }
                        if (this.a.Z3() != null) {
                            this.a.Z3().Q1();
                        }
                    } else if (this.a.I3() != null) {
                        this.a.I3().T1();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() == null || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.P.f();
                            MetaData author = this.a.K().S1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.N.B0(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d3);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                            }
                        }
                        this.a.i3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff2));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e6));
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
                if (obj != null && this.a.K() != null) {
                    switch (this.a.R.getLoadDataMode()) {
                        case 0:
                            this.a.K().v2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.B3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.C3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.D3(absVideoPbFragment.R.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.C3(absVideoPbFragment2.R.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.f0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.C3(absVideoPbFragment3.R.getLoadDataMode(), false, null, false);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof View)) {
                ItemCardHelper.l(this.a.a, this.a.a.getUniqueId(), (View) customResponsedMessage.getData(), this.a.c);
            }
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
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.v.setVisibility(8);
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
    }

    /* loaded from: classes5.dex */
    public class q implements x76.b {
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

        @Override // com.baidu.tieba.x76.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    kw7.d();
                } else {
                    kw7.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                boolean z = true;
                if (i == 0) {
                    if (this.a.I3() != null) {
                        this.a.I3().Y1(false);
                    } else if (this.a.y4() && this.a.Z3() != null) {
                        this.a.Z3().T1(false);
                    }
                    if (this.a.J3() != null) {
                        this.a.J3().H1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.p5(absVideoPbFragment.J3().z1() == 0 ? 8 : 0);
                        this.a.a0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    m38 m38Var = this.a.k;
                    if (m38Var != null) {
                        m38Var.R0(z);
                    }
                    this.a.Y4();
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()));
                    }
                } else {
                    if (this.a.J3() != null) {
                        this.a.J3().H1(false);
                    }
                    if (this.a.I3() != null) {
                        this.a.I3().Y1(true);
                        int P1 = this.a.I3().P1();
                        int N1 = this.a.I3().N1();
                        if (P1 != 0) {
                            this.a.p5(8);
                            this.a.I3().i2(0);
                        } else if (N1 != 0) {
                            this.a.I3().i2(8);
                            this.a.p5(0);
                        } else {
                            this.a.I3().i2(8);
                            this.a.p5(8);
                        }
                    } else if (this.a.Z3() != null) {
                        this.a.Z3().T1(true);
                        int N12 = this.a.Z3().N1();
                        int L1 = this.a.Z3().L1();
                        if (N12 != 0) {
                            this.a.p5(8);
                            this.a.Z3().b2(0);
                        } else if (L1 != 0) {
                            this.a.Z3().b2(8);
                            this.a.p5(0);
                        } else {
                            this.a.Z3().b2(8);
                            this.a.p5(8);
                        }
                        this.a.a0.setVisibility(0);
                    }
                    m38 m38Var2 = this.a.k;
                    if (m38Var2 != null) {
                        m38Var2.R0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()));
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
    public class r implements nu4.e {
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

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || nu4Var == null) {
                return;
            }
            nu4Var.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o05 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, o05 o05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, o05Var};
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
            this.a = o05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.V0.setHomePbFloatLastCloseTime();
                this.b.i4();
                this.b.V0.u(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r1 implements Animator.AnimatorListener {
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

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.M5();
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (postWriteCallBackData = this.a) == null) {
                    return;
                }
                this.b.a.N4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
                if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        statisticItem.param("fid", this.a.K().S1().m());
                    }
                    if (this.a.K() != null) {
                        statisticItem.param("tid", this.a.K().m2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    lz4.b(writeData.getContent(), "4");
                }
                if (z) {
                    qz7 qz7Var = this.a.D0;
                    if (qz7Var != null) {
                        qz7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        l35.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    gh.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.A0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0480), null).v();
                    } else {
                        DefaultNavigationBarCoverTip.t(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).v();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nu4 nu4Var = new nu4(this.a.getActivity());
                    if (dj.isEmpty(postWriteCallBackData.getErrorString())) {
                        nu4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0d11));
                    } else {
                        nu4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new b(this));
                    nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new c(this));
                    nu4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.D0 == null) {
                    return;
                }
                if (absVideoPbFragment.I0 != null && this.a.I0.b() != null && this.a.I0.b().y()) {
                    this.a.I0.b().w(postWriteCallBackData);
                }
                this.a.D0.l(postWriteCallBackData);
            }
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y5();
            }
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
    public class t implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ nu4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, nu4Var};
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
            this.c = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
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
                this.d.I5();
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
                if (this.a.w == null || this.a.w.n()) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.K().S1().Q()));
                        this.a.w.l = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.a.B5();
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

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (hq4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = hq4.c().g();
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
    }

    /* loaded from: classes5.dex */
    public class u implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ nu4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, nu4Var};
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
            this.b = nu4Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.I5();
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
                if (absVideoPbFragment.A0 != null && absVideoPbFragment.K() != null && this.a.K().S1() != null && this.a.K().S1().d() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.A0.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.K().S1().d().replyPrivateFlag)) {
                        return;
                    }
                }
                if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    this.a.G0.n0();
                    this.a.y3();
                }
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

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) {
                gifView.setTag(null);
                if (hq4.c().g()) {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = hq4.c().g();
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Z = true;
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.A3(false);
                this.a.Q4();
                if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.K().n2()).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("obj_locate", 1).param("uid", this.a.K().S1().O().getAuthor().getUserId()));
                if (this.a.v4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.K().getForumId());
                    statisticItem.param("tid", this.a.K().m2());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.M3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.L3());
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.t0());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.a0.getLayoutParams();
            layoutParams.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.a0.setLayoutParams(layoutParams);
            if (this.a.y4() && this.a.d != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.M1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.M1);
                }
                this.a.d.setLayoutParams(layoutParams2);
                this.a.e.setScrollable(true);
            }
            this.a.Y4();
            if (this.a.J3() != null) {
                this.a.J3().C1();
            }
            if (this.a.I3() != null) {
                this.a.I3().T1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w1 implements vg<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091881);
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

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements h75 {
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

        @Override // com.baidu.tieba.h75
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
                this.a.g4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x1 implements vg<RelativeLayout> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vg
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            SparseArray<Object> sparseArray;
            StatisticItem statisticItem;
            int i;
            String str2;
            int i2;
            String jumpUrlWithTid;
            boolean K3;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091840) {
                    if (this.a.K() != null) {
                        this.a.K().R2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f092047);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.obfuscated_res_0x7f092047, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.K().m2());
                    statisticItem2.param("fid", this.a.K().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.v4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.K().getForumId());
                        statisticItem3.param("tid", this.a.K().m2());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.M3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.L3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.a.Z) {
                        this.a.Z = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f09203d);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.K() == null || this.a.K().S1() == null || this.a.J0 == null || postData.s() == null || postData.C() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.I0 != null) {
                                this.a.I0.c();
                            }
                            zv7 zv7Var = new zv7();
                            zv7Var.A(this.a.K().S1().l());
                            zv7Var.E(this.a.K().S1().O());
                            zv7Var.C(postData);
                            this.a.J0.V(zv7Var);
                            this.a.J0.setPostId(postData.L());
                            this.a.E4(view2, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            j28.b(this.a.K().S1(), postData, postData.c0, 8, 1);
                            if (this.a.G0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.g5(absVideoPbFragment.G0.y());
                            }
                        }
                    }
                } else {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091899 || this.a.getPageContext().getPageActivity() == null || this.a.K() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.K().m2(), false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.K().m2(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.K().getForumId());
                        statisticItem4.param("fname", this.a.K().r1());
                        statisticItem4.param("tid", this.a.K().m2());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.y4() && this.a.Z3() != null && this.a.Z3().M1() != null && view2 == this.a.Z3().M1()) || ((this.a.I3() != null && this.a.I3().O1() != null && view2 == this.a.I3().O1()) || view2.getId() == R.id.obfuscated_res_0x7f091842)) {
                        if (!this.a.L && this.a.K().N2(true)) {
                            this.a.L = true;
                            if (this.a.y4()) {
                                if (this.a.Z3() != null) {
                                    this.a.Z3().a2();
                                    return;
                                }
                                return;
                            } else if (this.a.I3() != null) {
                                this.a.I3().h2();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    h38 h38Var = this.a.N;
                    if (h38Var != null && h38Var.Q() != null && view2 == this.a.N.Q().l()) {
                        this.a.N.I();
                        return;
                    }
                    h38 h38Var2 = this.a.N;
                    if ((h38Var2 == null || ((h38Var2.Q() == null || view2 != this.a.N.Q().p()) && view2.getId() != R.id.obfuscated_res_0x7f091780 && view2.getId() != R.id.obfuscated_res_0x7f09026e)) && view2.getId() != R.id.obfuscated_res_0x7f090a0f && view2.getId() != R.id.obfuscated_res_0x7f091bfd) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view2 == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.K() == null || this.a.K().S1() == null) {
                                return;
                            }
                            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.K().S1().m());
                                statisticItem5.param("tid", this.a.K().m2());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            ej.x(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (fh5.a()) {
                                return;
                            }
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                ArrayList<PostData> F = this.a.K().S1().F();
                                if ((F == null || F.size() <= 0) && this.a.K().k2()) {
                                    ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.K().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            ej.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().r()) {
                            if (this.a.K() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                this.a.H5();
                                this.a.n5();
                                this.a.K().F3(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                        } else {
                            h38 h38Var3 = this.a.N;
                            if (h38Var3 != null && h38Var3.Q() != null && view2 == this.a.N.Q().p()) {
                                this.a.N.I();
                                return;
                            }
                            h38 h38Var4 = this.a.N;
                            if (h38Var4 != null && ((h38Var4.Q() != null && view2 == this.a.N.Q().x()) || view2.getId() == R.id.obfuscated_res_0x7f09187f || view2.getId() == R.id.obfuscated_res_0x7f09187d)) {
                                this.a.N.F();
                                if (BdNetTypeUtil.isNetWorkAvailable()) {
                                    if (!this.a.L) {
                                        this.a.H5();
                                        this.a.n5();
                                        this.a.N.K0(view2);
                                        return;
                                    }
                                    view2.setTag(Integer.valueOf(this.a.K().i2()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                return;
                            }
                            h38 h38Var5 = this.a.N;
                            if (h38Var5 != null && h38Var5.Q() != null && view2 == this.a.N.Q().w()) {
                                if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.K().S1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f09180b) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                h38 h38Var6 = this.a.N;
                                if (h38Var6 != null) {
                                    h38Var6.x0(sparseArray);
                                }
                            } else {
                                h38 h38Var7 = this.a.N;
                                int i4 = 4;
                                if (h38Var7 != null && h38Var7.Q() != null && view2 == this.a.N.Q().u()) {
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
                                h38 h38Var8 = this.a.N;
                                if (h38Var8 != null && h38Var8.Q() != null && view2 == this.a.N.Q().v()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.H0(absVideoPbFragment4.D1);
                                    return;
                                }
                                h38 h38Var9 = this.a.N;
                                if (h38Var9 != null && h38Var9.Q() != null && view2 == this.a.N.Q().o()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.K().m2())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                h38 h38Var10 = this.a.N;
                                if (h38Var10 != null && (view2 == h38Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().s() || view2 == this.a.N.Q().t())))) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                        return;
                                    } else if (this.a.K() == null || this.a.K().S1() == null || this.a.R.S()) {
                                        return;
                                    } else {
                                        this.a.N.F();
                                        if (this.a.N.Q() != null && view2 == this.a.N.Q().t()) {
                                            if (this.a.K().S1().O().getIs_top() == 1) {
                                                i4 = 5;
                                            }
                                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().s()) {
                                            i4 = this.a.K().S1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view2 == this.a.N.M() ? 2 : 0;
                                        }
                                        ForumData l = this.a.K().S1().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String id2 = this.a.K().S1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.R.W(id, name, id2, i4, this.a.N.N());
                                        return;
                                    }
                                }
                                h38 h38Var11 = this.a.N;
                                if (h38Var11 != null && h38Var11.Q() != null && view2 == this.a.N.Q().n()) {
                                    if (this.a.K() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> R3 = absVideoPbFragment5.R3(absVideoPbFragment5.K().S1(), this.a.K().k2(), 1);
                                    if (R3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.K().S1().l().getId(), this.a.K().S1().l().getName(), this.a.K().S1().O().getId(), String.valueOf(this.a.K().S1().V().getUserId()), (String) R3.get(R.id.obfuscated_res_0x7f09204a), (String) R3.get(R.id.obfuscated_res_0x7f09204b), (String) R3.get(R.id.obfuscated_res_0x7f09204d), (String) R3.get(R.id.obfuscated_res_0x7f09204c))));
                                    return;
                                }
                                h38 h38Var12 = this.a.N;
                                if (h38Var12 != null && h38Var12.Q() != null && view2 == this.a.N.Q().j()) {
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> R32 = absVideoPbFragment6.R3(absVideoPbFragment6.K().S1(), this.a.K().k2(), 1);
                                    if (R32 != null) {
                                        this.a.N.j0(((Integer) R32.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) R32.get(R.id.obfuscated_res_0x7f09203f), ((Integer) R32.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) R32.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                    }
                                    this.a.N.I();
                                    if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.K().S1().O();
                                    StatisticItem statisticItem6 = new StatisticItem(CommonStatisticKey.KEY_PB_MORE_DIALOG_MUSK_CLICK);
                                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem6.param("tid", O.getId());
                                    statisticItem6.param("fid", O.getFid());
                                    statisticItem6.param("fname", O.getForum_name());
                                    TiebaStatic.log(statisticItem6);
                                    StatisticItem statisticItem7 = new StatisticItem(CommonStatisticKey.KEY_FRS_MUSK_REASON_DIALOG_SHOW);
                                    statisticItem7.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem7.param("tid", O.getId());
                                    statisticItem7.param("fid", O.getFid());
                                    statisticItem7.param("fname", O.getForum_name());
                                    statisticItem7.param("obj_source", 3);
                                    TiebaStatic.log(statisticItem7);
                                    return;
                                }
                                h38 h38Var13 = this.a.N;
                                if (h38Var13 != null && h38Var13.Q() != null && view2 == this.a.N.Q().m()) {
                                    if (this.a.K() == null) {
                                        return;
                                    }
                                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> R33 = absVideoPbFragment7.R3(absVideoPbFragment7.K().S1(), this.a.K().k2(), 1);
                                    if (R33 != null) {
                                        if (StringUtils.isNull((String) R33.get(R.id.obfuscated_res_0x7f09203e))) {
                                            this.a.N.g0(((Integer) R33.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) R33.get(R.id.obfuscated_res_0x7f09203f), ((Integer) R33.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) R33.get(R.id.obfuscated_res_0x7f092040)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) R33.get(R.id.obfuscated_res_0x7f092041)).intValue(), (String) R33.get(R.id.obfuscated_res_0x7f09203f), ((Integer) R33.get(R.id.obfuscated_res_0x7f09205d)).intValue(), ((Boolean) R33.get(R.id.obfuscated_res_0x7f092040)).booleanValue(), (String) R33.get(R.id.obfuscated_res_0x7f09203e));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091f9f && view2.getId() != R.id.obfuscated_res_0x7f091f9d && view2.getId() != R.id.obfuscated_res_0x7f09180d && view2.getId() != R.id.obfuscated_res_0x7f09169e && view2.getId() != R.id.obfuscated_res_0x7f09186f) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f09186d && view2.getId() != R.id.obfuscated_res_0x7f091a43 && view2.getId() != R.id.obfuscated_res_0x7f091807) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0917f5 && view2.getId() != R.id.obfuscated_res_0x7f090670) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0917fa) {
                                                this.a.c4(true);
                                                return;
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0917f7 && view2.getId() != R.id.obfuscated_res_0x7f092195) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0923de) {
                                                    if (this.a.P0 >= 0) {
                                                        if (this.a.K() != null) {
                                                            this.a.K().m3();
                                                        }
                                                        if (this.a.y4() && this.a.K() != null && this.a.Z3() != null && this.a.Z3().q1() != null) {
                                                            this.a.Z3().q1().f(this.a.K().S1());
                                                        } else if (this.a.I3() != null && this.a.I3().q1() != null) {
                                                            this.a.I3().q1().r(this.a.K().S1());
                                                        }
                                                        this.a.P0 = 0;
                                                        this.a.Q0 = Integer.MIN_VALUE;
                                                        if (this.a.y4() && this.a.K() != null && this.a.Z3() != null) {
                                                            this.a.Z3().W1(this.a.K().L1(), this.a.K().K1());
                                                            this.a.K().q3(0, 0);
                                                            return;
                                                        } else if (this.a.K() == null || this.a.I3() == null) {
                                                            return;
                                                        } else {
                                                            this.a.I3().c2(this.a.K().L1(), this.a.K().K1());
                                                            this.a.K().q3(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                    if (this.a.K() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.a.K().m2());
                                                    statisticItem8.param("fid", this.a.K().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091837 && view2.getId() != R.id.obfuscated_res_0x7f091802) {
                                                    if (view2.getId() == R.id.obfuscated_res_0x7f09103f) {
                                                        this.a.Y4();
                                                        return;
                                                    } else if (view2.getId() != R.id.obfuscated_res_0x7f090786 && view2.getId() != R.id.obfuscated_res_0x7f090a0c) {
                                                        if (this.a.N.Q() != null && view2 == this.a.N.Q().k()) {
                                                            this.a.N.F();
                                                            if (this.a.K() != null) {
                                                                this.a.t.f(this.a.K().m2());
                                                            }
                                                            if (this.a.K() == null || !this.a.K().isPrivacy()) {
                                                                this.a.t.b();
                                                                int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().Q() == null || !this.a.K().S1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                                if (this.a.K() == null || this.a.K().S1() == null) {
                                                                    return;
                                                                }
                                                                this.a.t.d(3, i5, this.a.K().S1().Q());
                                                                return;
                                                            }
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0f2d);
                                                            if (this.a.K().S1() != null) {
                                                                this.a.t.d(3, 3, this.a.K().S1().Q());
                                                                return;
                                                            }
                                                            return;
                                                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09180f || view2.getId() == R.id.obfuscated_res_0x7f091867) {
                                                            StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                            statisticItem9.param("tid", this.a.K().m2());
                                                            statisticItem9.param("fid", this.a.K().getForumId());
                                                            statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem9.param("obj_locate", 7);
                                                            TiebaStatic.log(statisticItem9);
                                                            if (this.a.v4()) {
                                                                StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                                statisticItem10.param("fid", this.a.K().getForumId());
                                                                statisticItem10.param("tid", this.a.K().m2());
                                                                statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                                statisticItem10.param(str, this.a.M3());
                                                                statisticItem10.param("obj_source", 1);
                                                                statisticItem10.param("obj_type", 2);
                                                                statisticItem10.param("obj_locate", this.a.L3());
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
                                                        if (sparseArray2 == null || !(sparseArray2.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData)) {
                                                            return;
                                                        }
                                                        PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f09205a);
                                                        View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f09205c);
                                                        if (postData2 == null || view3 == null) {
                                                            return;
                                                        }
                                                        ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f090787);
                                                        EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090788);
                                                        View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f090a0c);
                                                        if (postData2.q0()) {
                                                            postData2.Q0(false);
                                                            l18.e(postData2);
                                                        } else {
                                                            if (this.a.K() != null ? l18.c(this.a.K().S1(), postData2) : false) {
                                                                postData2.Q0(true);
                                                                findViewById.setVisibility(0);
                                                            }
                                                        }
                                                        SkinManager.setBackgroundColor(findViewById, postData2.q0() ? R.color.CAM_X0201 : R.color.transparent);
                                                        SkinManager.setViewTextColor(eMTextView, postData2.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                        WebPManager.setPureDrawable(imageView, postData2.q0() ? R.drawable.obfuscated_res_0x7f080984 : R.drawable.obfuscated_res_0x7f080983, postData2.q0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                        return;
                                                    }
                                                } else if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f138a);
                                                    String q = ox4.k().q("tail_link", "");
                                                    if (!StringUtils.isNull(q)) {
                                                        TiebaStatic.log("c10056");
                                                        yo4.s(view2.getContext(), string, q, true, true, true);
                                                    }
                                                    this.a.Y4();
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                String str3 = str;
                                                if (this.a.K() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.K().S1() == null || this.a.K().S1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    jv7 S1 = this.a.K().S1();
                                                    int reply_num = S1.O().getReply_num();
                                                    int currentItem = this.a.e.getCurrentItem();
                                                    if (reply_num == 0) {
                                                        if (this.a.y4() && currentItem == 0) {
                                                            this.a.e.setCurrentItem(1);
                                                        }
                                                        this.a.A3(false);
                                                        this.a.Q4();
                                                        return;
                                                    }
                                                    if (this.a.y4() && currentItem == 0) {
                                                        this.a.e.setCurrentItem(1);
                                                        str2 = "obj_source";
                                                    } else if ((this.a.y4() && this.a.Z3() == null) || this.a.I3() == null || this.a.Y3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (ej.i(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView Y3 = this.a.Y3();
                                                        if (Y3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = Y3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = Y3.canScrollVertically(-1);
                                                        AppBarLayout appBarLayout = this.a.i;
                                                        str2 = "obj_source";
                                                        if (appBarLayout != null) {
                                                            appBarLayout.setExpanded(false, true);
                                                        }
                                                        if (Y3.getLayoutManager() == null || !(Y3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) Y3.getLayoutManager();
                                                        if (!canScrollVertically2 && canScrollVertically) {
                                                            if (this.a.N0 == -1 && this.a.O0 == Integer.MIN_VALUE) {
                                                                return;
                                                            }
                                                            if (this.a.N0 <= 3 && (this.a.N0 != 3 || this.a.O0 >= (-i6))) {
                                                                if (this.a.N0 < 2) {
                                                                    if (this.a.N0 != 1) {
                                                                        Y3.smoothScrollBy(0, -this.a.O0);
                                                                    } else {
                                                                        int i7 = i6 / 4;
                                                                        linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + i7);
                                                                        Y3.smoothScrollBy(0, i7);
                                                                    }
                                                                } else {
                                                                    int i8 = i6 / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + i8);
                                                                    Y3.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.N0, this.a.O0 + i6);
                                                                Y3.smoothScrollBy(0, i6);
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        } else {
                                                            int firstVisiblePosition = Y3.getFirstVisiblePosition();
                                                            View childAt = Y3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.N0 = firstVisiblePosition;
                                                            this.a.O0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i6) || Y3.getCount() < 6)) {
                                                                Y3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                Y3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        }
                                                        TiebaStatic.log(param);
                                                        oc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i2);
                                                        statisticItem11.param("obj_locate", 4);
                                                        statisticItem11.param("tid", this.a.K().m2());
                                                        statisticItem11.param("nid", S1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("obj_locate", 2).param("uid", this.a.K().S1().O().getAuthor().getUserId()));
                                                    if (this.a.v4()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.K().getForumId());
                                                        statisticItem12.param("tid", this.a.K().m2());
                                                        statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem12.param(str3, this.a.M3());
                                                        statisticItem12.param(str2, 1);
                                                        statisticItem12.param("obj_type", 12);
                                                        statisticItem12.param("obj_locate", this.a.L3());
                                                        TiebaStatic.log(statisticItem12);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        String str4 = str;
                                        if (!BdNetTypeUtil.isNetWorkAvailable()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.K() == null) {
                                            return;
                                        }
                                        if (this.a.y4() && this.a.Z3() == null) {
                                            return;
                                        }
                                        if (this.a.y4() || this.a.I3() != null) {
                                            this.a.N.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0917f5 || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.p3(11009) || this.a.K() == null) {
                                                    return;
                                                }
                                                this.a.G4();
                                                if (this.a.K().S1() != null && this.a.K().S1().O() != null && this.a.K().S1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("obj_locate", 3).param("uid", this.a.K().S1().O().getAuthor().getUserId()));
                                                    if (this.a.v4()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.K().getForumId());
                                                        statisticItem13.param("tid", this.a.K().m2());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.M3());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.L3());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null || this.a.K().S1().O().getAuthor().getUserId() == null || this.a.P == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                int S = absVideoPbFragment10.N.S(absVideoPbFragment10.K().S1());
                                                ThreadData O2 = this.a.K().S1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.K().m2()).param("obj_locate", 1).param("obj_id", this.a.K().S1().O().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.z = view2;
                                            return;
                                        }
                                        return;
                                    }
                                    String str5 = str;
                                    if (this.a.K() == null) {
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f09186d) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.K().m2());
                                        statisticItem14.param("fid", this.a.K().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a43) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f09186d && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        if (sparseArray3.get(R.id.obfuscated_res_0x7f09205a) instanceof PostData) {
                                            PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f09205a);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09186d && (statisticItem = postData3.d0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a43 || view2.getId() == R.id.obfuscated_res_0x7f091807) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.K().n2()).param("fid", this.a.K().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData3.L()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.K() == null || this.a.K().S1() == null || this.a.J0 == null || postData3.s() == null || postData3.C() == 1) {
                                                return;
                                            }
                                            if (this.a.I0 != null) {
                                                this.a.I0.c();
                                            }
                                            if (this.a.S0 && postData3.Z() != null && postData3.Z().size() != 0) {
                                                this.a.F5(postData3, null, true, false);
                                                return;
                                            }
                                            zv7 zv7Var2 = new zv7();
                                            zv7Var2.A(this.a.K().S1().l());
                                            zv7Var2.E(this.a.K().S1().O());
                                            zv7Var2.C(postData3);
                                            this.a.J0.V(zv7Var2);
                                            this.a.J0.setPostId(postData3.L());
                                            this.a.E4(view2, postData3.s().getUserId(), "", postData3);
                                            if (this.a.G0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.g5(absVideoPbFragment11.G0.y());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.K().m2());
                                        statisticItem15.param("fid", this.a.K().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.v4()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.K().getForumId());
                                            statisticItem16.param("tid", this.a.K().m2());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.M3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.L3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view2.getId() == R.id.obfuscated_res_0x7f09180d || view2.getId() == R.id.obfuscated_res_0x7f09186f) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view2;
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f09180d && this.a.v4()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.K().getForumId());
                                        statisticItem17.param("tid", this.a.K().m2());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.M3());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.L3());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.K().S1().m()));
                                    } else if (this.a.K() == null || this.a.K().S1() == null) {
                                    } else {
                                        h38 h38Var14 = this.a.N;
                                        if (h38Var14 != null) {
                                            h38Var14.F();
                                        }
                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                        PostData postData4 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f09205a);
                                        PostData postData5 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f09205b);
                                        if (postData4 == null) {
                                            return;
                                        }
                                        if (postData4.G() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData4.d0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view2.getId() == R.id.obfuscated_res_0x7f09169e) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f09180d) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.H5();
                                        TiebaStatic.log("c11742");
                                        if (postData5 != null) {
                                            this.a.F5(postData4, postData5, false, true);
                                        } else {
                                            this.a.F5(postData4, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c5a);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.H5();
                            this.a.n5();
                            if (view2.getId() == R.id.obfuscated_res_0x7f091780) {
                                K3 = this.a.K().K3(true, this.a.M3());
                            } else {
                                K3 = view2.getId() == R.id.obfuscated_res_0x7f09026e ? this.a.K().K3(false, this.a.M3()) : this.a.K().J3(this.a.M3());
                            }
                            view2.setTag(Boolean.valueOf(K3));
                            if (K3) {
                                this.a.x5();
                                i3 = 1;
                                this.a.L = true;
                            } else {
                                i3 = 1;
                            }
                            TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "pb_set_host", "pbclick", i3, new Object[0]);
                            return;
                        }
                        view2.setTag(Boolean.FALSE);
                    }
                }
            }
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
                this.a.Y4();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y1 implements g75 {
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

        @Override // com.baidu.tieba.g75
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qz7 qz7Var = this.a.D0;
                if (qz7Var == null || qz7Var.e() == null || !this.a.D0.e().d()) {
                    return !this.a.r3(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.D0.e().c());
                if (this.a.G0 != null && (this.a.G0.x() || this.a.G0.z())) {
                    this.a.G0.w(false, this.a.D0.h());
                }
                this.a.D0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z extends di5<ShareItem> {
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
        @Override // com.baidu.tieba.di5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return i18.d(this.b.H3(), 2, K);
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
                this.a.J0.Q(postData);
                if (this.a.I3() != null) {
                    this.a.I3().T1();
                } else if (this.a.y4() && this.a.Z3() != null) {
                    this.a.Z3().Q1();
                }
                this.a.I0.c();
                this.a.H0.q();
                this.a.u5(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z1 implements Comparator<z35> {
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
        public int compare(z35 z35Var, z35 z35Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z35Var, z35Var2)) == null) ? z35Var.compareTo(z35Var2) : invokeLL.intValue;
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
        L1 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        M1 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        N1 = 3;
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
        this.S0 = UbsABTestHelper.showTrisectionAndFeedback();
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
        this.s0 = new d2(this, null);
    }

    public void A3(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) || (appBarLayout = this.i) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public boolean A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p1 : invokeV.booleanValue;
    }

    public final void A5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || K() == null || dj.isEmpty(K().m2())) {
            return;
        }
        rl4.w().P(ql4.Z, dh.g(K().m2(), 0L));
    }

    @Override // com.baidu.tieba.t28
    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t28
    public PbModel.h B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.W0 : (PbModel.h) invokeV.objValue;
    }

    public final void B3(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048581, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b5);
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                nu4 nu4Var = new nu4(getPageContext().getPageActivity());
                nu4Var.setMessage(string);
                nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04f3, new r(this));
                nu4Var.setCancelable(true);
                nu4Var.create(getPageContext());
                nu4Var.show();
            } else {
                C3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> F = K().S1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).L())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    K().S1().O().setReply_num(K().S1().O().getReply_num() - 1);
                    if (I3() != null) {
                        I3().T1();
                    } else if (y4() && Z3() != null) {
                        Z3().Q1();
                    }
                } else if (i3 == 0) {
                    t3();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = K().S1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).Z().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).Z().get(i5).L())) {
                                F2.get(i4).Z().remove(i5);
                                F2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).l(bVar.g);
                    }
                    if (z3) {
                        if (I3() != null) {
                            I3().T1();
                        } else if (y4() && Z3() != null) {
                            Z3().Q1();
                        }
                    }
                    u3(bVar);
                }
            }
        }
    }

    public boolean B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m38 m38Var = this.k;
            if (m38Var == null) {
                return false;
            }
            return m38Var.N0();
        }
        return invokeV.booleanValue;
    }

    public final void B5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            L5();
        }
    }

    public void C3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f123e));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                }
                showToast(str);
            }
        }
    }

    public final void C4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void C5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.v.setAlpha(0.0f);
            this.v.setVisibility(0);
            N5(layoutParams);
        }
    }

    @Override // com.baidu.tieba.ll5
    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void D3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, gVar) == null) || gVar == null || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        C3(this.R.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.w0 = true;
            if (i2 == 2 || i2 == 3) {
                this.x0 = true;
                this.y0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.x0 = false;
                this.y0 = true;
            }
            if (i2 == 2) {
                K().S1().O().setIs_good(1);
                K().u3(1);
            } else if (i2 == 3) {
                K().S1().O().setIs_good(0);
                K().u3(0);
            } else if (i2 == 4) {
                K().S1().O().setIs_top(1);
                K().v3(1);
            } else if (i2 == 5) {
                K().S1().O().setIs_top(0);
                K().v3(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                string = gVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f0d22);
            }
            ej.N(getPageContext().getPageActivity(), string);
        }
        if (y4()) {
            if (K().S1().O() == null || J3() == null) {
                return;
            }
            J3().J1();
        } else if (K().S1().O() == null || I3() == null) {
        } else {
            I3().a2();
        }
    }

    public final void D4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.e0 == null) {
            return;
        }
        z3();
        this.e0.setImageResource(R.drawable.obfuscated_res_0x7f0809bb);
    }

    public final void D5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.v1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 1.0f, 0.0f);
                this.v1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.v1.start();
        }
    }

    public final String E3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0de2);
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
        return (String) invokeI.objValue;
    }

    public final void E4(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048592, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || o3() || !q3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.L0);
            this.M0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.I0 != null && postData != null) {
            this.I0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f100d), postData.s().getName_show(), postData.W() != null ? postData.W().toString() : ""));
        }
        if (K() != null && K().S1() != null && K().S1().i0()) {
            gh.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.C0 == null) {
            yq6 yq6Var = new yq6(getPageContext());
            this.C0 = yq6Var;
            yq6Var.j(1);
            this.C0.i(new j1(this, str, str2));
        }
        if (K() == null || K().S1() == null || K().S1().l() == null) {
            return;
        }
        this.C0.g(K().S1().l().getId(), dh.g(K().m2(), 0L));
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.u1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 0.0f, 1.0f);
                this.u1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.u1.start();
        }
    }

    public n25 F3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.Q : (n25) invokeV.objValue;
    }

    public final void F4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || K() == null) {
            return;
        }
        jv7 S1 = K().S1();
        K().H3(true);
        qo4 qo4Var = this.P;
        if (qo4Var != null) {
            S1.H0(qo4Var.g());
        }
        if (y4()) {
            if (J3() != null) {
                J3().C1();
            }
            if (Z3() != null) {
                Z3().Q1();
            }
        } else if (I3() != null) {
            I3().T1();
        }
    }

    public final void F5(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e p2;
        boolean z4;
        PostData K3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String m2 = K().m2();
            String L = postData.L();
            String L2 = postData2 != null ? postData2.L() : "";
            int W = K().S1() != null ? K().S1().W() : 0;
            if (Z3() != null && Z3().O1() != null) {
                p2 = Z3().O1().p(L);
            } else if (I3() == null || I3().Q1() == null) {
                return;
            } else {
                p2 = I3().Q1().p(L);
            }
            AbsPbActivity.e eVar = p2;
            if (postData == null || K() == null || K().S1() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(m2, L, "pb", true, v4(), null, false, L2, W, postData.c0(), K().S1().d(), false, postData.s().getIconInfo(), L3(), L3() == 1 || L3() == 2 || L3() == 3 || L3() == 4 || L3() == 5).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(L2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(K().getForumId());
            addBigImageData.setTiebaPlusData(K().I(), K().E(), K().F(), K().D(), K().J());
            addBigImageData.setBjhData(K().k1());
            addBigImageData.setKeyPageStartFrom(K().R1());
            addBigImageData.setFromFrsForumId(K().getFromForumId());
            addBigImageData.setWorksInfoData(K().r2());
            addBigImageData.setIsOpenEditor(z2);
            if (K().S1().o() != null) {
                addBigImageData.setHasForumRule(K().S1().o().has_forum_rule.intValue());
            }
            if (K().S1().V() != null) {
                addBigImageData.setIsManager(K().S1().V().getIs_manager());
            }
            if (K().S1().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (K().S1().l() != null) {
                addBigImageData.setForumHeadUrl(K().S1().l().getImage_url());
                addBigImageData.setUserLevel(K().S1().l().getUser_level());
            }
            if (K() != null && (K3 = K3(K().S1())) != null) {
                if (!K3.R && !postData.R) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (v4() && this.a.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.baidu.tieba.ll5
    public void G(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.Z = true;
        }
    }

    public LinearLayout G3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.d0 : (LinearLayout) invokeV.objValue;
    }

    public final void G4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || K() == null || K().S1() == null) {
            return;
        }
        if (y4() && Z3() == null) {
            return;
        }
        if ((y4() || I3() != null) && this.P != null) {
            MarkData markData = null;
            if (K().S1() != null && K().S1().i0()) {
                markData = K().i1(0);
            } else {
                CustomViewPager customViewPager = this.e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = K().M1(K3(K().S1()));
                } else if (y4()) {
                    if (Z3() != null) {
                        markData = K().i1(Z3().J1());
                    }
                } else if (I3() != null) {
                    markData = K().i1(I3().L1());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && Z3() != null && (markData = K().i1(Z3().J1() + 1)) == null) {
                return;
            }
            n5();
            this.P.i(markData);
            if (!this.P.e()) {
                if (K() != null && !i18.k(K().m2())) {
                    this.j0.o(2);
                    i18.b(K().m2());
                }
                this.P.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.P.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public void G5() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.C();
    }

    public final int H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (K() == null || K().S1() == null || K().S1().O() == null) {
                return -1;
            }
            return K().S1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final boolean H4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = ox4.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    yo4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f054a), q2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void H5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (voiceManager = this.S) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    @Override // com.baidu.tieba.ll5
    public void I(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            tz7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.Z = true;
        }
    }

    public DetailInfoAndReplyFragment I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public boolean I4(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        m38 m38Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (!this.o1 && (this.p1 || z4())) {
                D5();
                UtilHelper.hideStatusBar(P(), P().getRootView());
                this.p1 = false;
                m38 m38Var2 = this.k;
                if (m38Var2 != null) {
                    m38Var2.S0(false);
                }
            }
            if (i2 == 4) {
                m38 m38Var3 = this.k;
                if (m38Var3 != null) {
                    return m38Var3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                m38 m38Var4 = this.k;
                if (m38Var4 != null) {
                    return m38Var4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (m38Var = this.k) == null) {
                return false;
            } else {
                return m38Var.P0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final void I5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.v1();
    }

    public DetailInfoFragment J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public void J4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.h.setVisibility(z2 ? 0 : 8);
        }
    }

    public final boolean J5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (K() == null) {
                return true;
            }
            if (K().S1() == null || !K().S1().i0()) {
                if (K().D1()) {
                    MarkData o12 = K().o1();
                    if (o12 != null && K().B1() && Y3() != null) {
                        MarkData i12 = K().i1(Y3().getFirstVisiblePosition());
                        if (i12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (i12.getPostId() != null && !i12.getPostId().equals(o12.getPostId())) {
                            nu4 nu4Var = new nu4(getBaseFragmentActivity());
                            nu4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0269));
                            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0436, new t(this, i12, o12, nu4Var));
                            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new u(this, o12, nu4Var));
                            nu4Var.setOnCalcelListener(new w(this));
                            nu4Var.create(getBaseFragmentActivity().getPageContext());
                            nu4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", o12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (K().S1() != null && K().S1().F() != null && K().S1().F().size() > 0 && K().B1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t28
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a.j1() : (PbModel) invokeV.objValue;
    }

    public PostData K3(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, jv7Var)) == null) {
            PostData postData = null;
            if (jv7Var == null) {
                return null;
            }
            if (jv7Var.X() != null) {
                return jv7Var.X();
            }
            if (!ListUtils.isEmpty(jv7Var.F())) {
                Iterator<PostData> it = jv7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.C() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = jv7Var.j();
            }
            if (postData == null) {
                postData = X3(jv7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                showToast(R.string.obfuscated_res_0x7f0f0c5a);
            } else if (this.N == null || K() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                H5();
                n5();
                if (K().loadData()) {
                    x5();
                }
            }
        }
    }

    public void K5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            j75 j75Var = this.G0;
            if (j75Var != null) {
                g5(j75Var.y());
            }
            Y4();
            this.N.F();
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            ug<RelativeLayout> ugVar = new ug<>(new x1(this), 10, 0);
            this.Y = ugVar;
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }

    public abstract int L3();

    public void L4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            if (i2 == 0) {
                ll8.g().h(getUniqueId(), false);
                if (Y3() != null) {
                    n3(Y3(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.V0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.V0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.V0) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public final void L5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.J = ofFloat;
            ofFloat.addUpdateListener(new l1(this));
            this.J.setDuration(200L);
            this.J.start();
            this.J.addListener(new m1(this, layoutParams));
        }
    }

    public final String M3() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (K() == null || K().S1() == null || K().S1().F() == null || (count = ListUtils.getCount((F = K().S1().F()))) == 0) {
                return "";
            }
            if (K().d2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.C() == 1) {
                        return next.L();
                    }
                }
            }
            int i2 = 0;
            if (Y3() != null) {
                if (y4()) {
                    if (Z3() != null) {
                        i2 = Z3().H1();
                    }
                } else if (I3() != null) {
                    i2 = I3().J1();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(F, i2);
            if (postData != null && postData.s() != null) {
                if (K().K2(postData.s().getUserId())) {
                    return postData.L();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (K().K2(postData2.s().getUserId())) {
                        return postData2.L();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (K().K2(postData3.s().getUserId())) {
                        return postData3.L();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void M4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) || P() == null) {
            return;
        }
        if (this.p1 && !TbSingleton.getInstance().isNotchScreen(P()) && !TbSingleton.getInstance().isCutoutScreen(P())) {
            D5();
            UtilHelper.hideStatusBar(P(), P().getRootView());
            this.p1 = false;
        }
        this.s0.b = z2;
        O4();
        R4();
    }

    public final void M5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    @Override // com.baidu.tieba.ll5
    public ug<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.V == null) {
                this.V = new ug<>(new t1(this), 8, 0);
            }
            return this.V;
        }
        return (ug) invokeV.objValue;
    }

    public abstract int N3();

    public void N4(z35 z35Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048624, this, z35Var, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.A(z35Var, getPageContext(), i2, false);
    }

    public final void N5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, layoutParams) == null) {
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

    @Override // com.baidu.tieba.ll5
    public ug<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.W == null) {
                this.W = new ug<>(new v1(this), 8, 0);
            }
            return this.W;
        }
        return (ug) invokeV.objValue;
    }

    public boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.s0.a()) {
            this.k.X(false);
            return;
        }
        m38 m38Var = this.k;
        if (!v4() && !this.k.N0()) {
            z2 = true;
        }
        m38Var.X(z2);
    }

    public final void O5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, layoutParams) == null) {
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

    @Override // com.baidu.tieba.t28
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public View.OnClickListener P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.B1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void P4(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, jv7Var) == null) || jv7Var == null) {
            return;
        }
        ThreadData O = jv7Var.O();
        if (O != null && O.isUgcThreadType()) {
            m3();
        } else {
            k5(this.F0);
        }
        j75 j75Var = this.G0;
        if (j75Var != null) {
            g5(j75Var.y());
            this.G0.H(jv7Var.d());
            this.G0.I(jv7Var.l(), jv7Var.V());
            this.G0.k0(O);
            if (K() != null) {
                this.G0.J(K().u1(), K().m2(), K().q1());
            }
            if (O != null) {
                this.G0.Z(O.isMutiForumThread());
            }
        }
    }

    public final void P5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || K() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.E(K().getForumId()) || K().S1() == null || K().S1().l() == null) {
            return;
        }
        if (K().S1().l().isLike() == 1) {
            K().f1().D(K().getForumId(), K().m2());
        }
    }

    @Override // com.baidu.tieba.ll5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, context, str) == null) {
        }
    }

    public View.OnClickListener Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.C1 : (View.OnClickListener) invokeV.objValue;
    }

    public void Q4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || !checkUpIsLogin() || K() == null || K().S1() == null || K().S1().l() == null || o3()) {
            return;
        }
        if (K().S1().i0()) {
            s3();
            return;
        }
        if (this.B0 == null) {
            yq6 yq6Var = new yq6(getPageContext());
            this.B0 = yq6Var;
            yq6Var.j(0);
            this.B0.i(new d1(this));
        }
        this.B0.g(K().S1().l().getId(), dh.g(K().m2(), 0L));
    }

    public void Q5(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, jv7Var) == null) {
            if (jv7Var != null && AntiHelper.o(jv7Var.O())) {
                s38 s38Var = this.j0;
                if (s38Var != null) {
                    s38Var.l(false);
                    this.j0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.i0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.i0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.i0, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            s38 s38Var2 = this.j0;
            if (s38Var2 == null || !s38Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.i0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.i0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.i0, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048638, this, context, str, z2) == null) {
            if (tz7.c(str) && K() != null && K().m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", K().m2()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    s45 s45Var = new s45();
                    s45Var.a = str;
                    s45Var.b = 3;
                    s45Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, s45Var));
                }
            } else {
                tz7.a().e(getPageContext(), str);
            }
            this.Z = true;
        }
    }

    public SparseArray<Object> R3(jv7 jv7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData K3;
        ds4 ds4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{jv7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (jv7Var == null || (K3 = K3(jv7Var)) == null) {
                return null;
            }
            String userId = K3.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f09203f, K3.L());
                sparseArray.put(R.id.obfuscated_res_0x7f092041, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(jv7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.FALSE);
            } else if (i2 == 1) {
                if (K3.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09204a, K3.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204b, K3.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204c, K3.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204d, K3.L());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09203f, K3.L());
                sparseArray.put(R.id.obfuscated_res_0x7f092041, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(jv7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092085, Boolean.TRUE);
            }
            if (!z3) {
                List<xt4> p2 = jv7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (xt4 xt4Var : p2) {
                        if (xt4Var != null && !StringUtils.isNull(xt4Var.c()) && (ds4Var = xt4Var.g) != null && ds4Var.a && !ds4Var.c && ((i3 = ds4Var.b) == 1 || i3 == 2)) {
                            sb.append(dj.cutString(xt4Var.c(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f066e));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09203e, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a8), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.k == null || this.e == null) {
            return;
        }
        boolean z2 = false;
        if (!y4()) {
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

    public void R5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048641, this, z2) == null) {
            DetailInfoAndReplyFragment I3 = I3();
            if (I3 != null && I3.q1() != null && I3.q1().f() != null && I3.q1().g() != null) {
                I3.q1().f().s0(z2);
                I3.q1().g().F(z2);
            }
            MaskView maskView = this.A;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public qo4 S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.P : (qo4) invokeV.objValue;
    }

    public void S4(boolean z2, int i2, int i3, int i4, jv7 jv7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jv7Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof s28) {
                    ((s28) baseFragment).f1(z2, i2, i3, i4, jv7Var, str, i5);
                }
            }
            f1(z2, i2, i3, i4, jv7Var, str, i5);
        }
    }

    public View.OnLongClickListener T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.J1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void T4(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048645, this, jv7Var) == null) || jv7Var == null || jv7Var.O() == null) {
            return;
        }
        Q5(jv7Var);
        this.h0.setVisibility(jv7Var.i0() ? 8 : 0);
        if (jv7Var.r()) {
            WebPManager.setPureDrawable(this.h0, R.drawable.obfuscated_res_0x7f08097e, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.h0, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String E3 = E3(jv7Var.O().getReply_num());
        TextView textView = this.q0;
        if (textView != null) {
            textView.setText(E3);
        }
        TextView textView2 = this.r0;
        if (textView2 != null) {
            textView2.setText(E3);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, jv7Var.O()));
    }

    public View.OnTouchListener U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.x1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void U4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048647, this, z2, markData) == null) || K() == null) {
            return;
        }
        m5();
        K().H3(z2);
        qo4 qo4Var = this.P;
        if (qo4Var != null) {
            qo4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (K().D1()) {
            F4();
        } else if (y4()) {
            if (J3() != null) {
                J3().C1();
            }
            if (Z3() != null) {
                Z3().Q1();
            }
        } else if (I3() != null) {
            I3().T1();
        }
    }

    @Override // com.baidu.tieba.ll5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048648, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.q0(str);
        pu4 R = this.N.R();
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

    public j75 V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.G0 : (j75) invokeV.objValue;
    }

    public void V4(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048650, this, jv7Var) == null) || jv7Var == null || jv7Var.O() == null) {
            return;
        }
        String valueOf = String.valueOf(jv7Var.O().getReply_num());
        if (jv7Var.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.d.F(valueOf);
    }

    public final int W3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i2)) == null) {
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

    public void W4(zv7 zv7Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, zv7Var) == null) || K() == null || K().S1() == null || zv7Var.i() == null) {
            return;
        }
        String L = zv7Var.i().L();
        ArrayList<PostData> F = K().S1().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.L() == null || !postData.L().equals(L)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = zv7Var.k();
                postData.X0(zv7Var.m());
                if (postData.Z() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.g0() != null && next != null && next.s() != null && (metaData = postData.g0().get(next.s().getUserId())) != null) {
                            next.B0(metaData);
                            next.N0(true);
                            next.g1(getPageContext(), K().K2(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.Z().size();
                    if (!postData.n0(true)) {
                        postData.Z().clear();
                        postData.Z().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.z() != null) {
                    postData.z0();
                }
            }
        }
        if (K().B1() || !z2) {
            return;
        }
        if (y4() && Z3() != null) {
            Z3().Q1();
        } else if (I3() != null) {
            I3().T1();
        }
    }

    public final PostData X3(jv7 jv7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.O() == null || jv7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = jv7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = jv7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.D0(1);
            postData.J0(jv7Var.O().getFirstPostId());
            postData.a1(jv7Var.O().getTitle());
            postData.Z0(jv7Var.O().getCreateTime());
            postData.B0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void X4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || this.G0 == null || this.H0 == null) {
            return;
        }
        f75.a().c(0);
        this.G0.M();
        this.G0.K();
        if (this.G0.v() != null) {
            this.G0.v().setMaxImagesAllowed(this.G0.t ? 1 : 9);
        }
        this.G0.d0(SendView.f);
        this.G0.g(SendView.f);
        o55 m2 = this.H0.m(23);
        o55 m3 = this.H0.m(2);
        o55 m4 = this.H0.m(5);
        if (m3 != null) {
            m3.display();
        }
        if (m4 != null) {
            m4.display();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.H0.invalidate();
    }

    @Override // com.baidu.tieba.ll5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048655, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.Z = true;
    }

    @Override // com.baidu.tieba.ll5
    public ug<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (this.U == null) {
                this.U = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.U;
        }
        return (ug) invokeV.objValue;
    }

    public BdTypeRecyclerView Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).M1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).K1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            X4();
            f4();
            this.I0.c();
            u5(false);
        }
    }

    public ReplyFragment Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f.b(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public String a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (!dj.isEmpty(this.t0)) {
                return this.t0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(lz7.b());
            this.t0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            this.N0 = -1;
            this.O0 = Integer.MIN_VALUE;
        }
    }

    public final void b4(int i2, Intent intent) {
        t55 t55Var;
        gy7 gy7Var;
        t55 t55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048663, this, i2, intent) == null) {
            if (i2 == 0) {
                f4();
                gy7 gy7Var2 = this.I0;
                if (gy7Var2 != null) {
                    gy7Var2.c();
                }
                u5(false);
            }
            Y4();
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
                    this.G0.L();
                    this.G0.m0(pbEditorData.getVoiceModel());
                    this.G0.B(writeData);
                    s55 n2 = this.G0.a().n(6);
                    if (n2 != null && (t55Var = n2.m) != null) {
                        t55Var.B(new h55(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.G0.G(null, null);
                    }
                } else if (editorType != 1 || (gy7Var = this.I0) == null || gy7Var.b() == null) {
                } else {
                    n75 b3 = this.I0.b();
                    b3.d0(K().S1().O());
                    b3.C(writeData);
                    b3.e0(pbEditorData.getVoiceModel());
                    s55 n3 = b3.a().n(6);
                    if (n3 != null && (t55Var2 = n3.m) != null) {
                        t55Var2.B(new h55(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.G();
                    }
                }
            }
        }
    }

    public boolean b5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f09203d);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.t()) && hq4.c().g()) {
                        return H4(postData.L());
                    }
                    if (checkUpIsLogin() && K() != null && K().S1() != null) {
                        gy7 gy7Var = this.I0;
                        if (gy7Var != null) {
                            gy7Var.c();
                        }
                        zv7 zv7Var = new zv7();
                        zv7Var.A(K().S1().l());
                        zv7Var.E(K().S1().O());
                        zv7Var.C(postData);
                        this.J0.V(zv7Var);
                        this.J0.setPostId(postData.L());
                        E4(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        j75 j75Var = this.G0;
                        if (j75Var != null) {
                            g5(j75Var.y());
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0205  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c4(boolean z2) {
        jv7 S1;
        int i2;
        s38 s38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048665, this, z2) == null) || K() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (S1 = K().S1()) == null) {
            return;
        }
        ThreadData O = S1.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", K().m2()).param("fid", S1.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (v4()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", K().getForumId());
                statisticItem.param("tid", K().m2());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", M3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", L3());
                TiebaStatic.log(statisticItem);
            }
        }
        if (O != null) {
            if (O.isBJHArticleThreadType()) {
                i2 = 2;
            } else if (O.isBJHVideoThreadType()) {
                i2 = 3;
            } else if (O.isBJHNormalThreadType()) {
                i2 = 4;
            } else if (O.isBJHVideoDynamicThreadType()) {
                i2 = 5;
            }
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", K().m2());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", K().getForumId());
            if (!z2) {
                statisticItem2.param("obj_locate", 6);
            } else {
                statisticItem2.param("obj_locate", 5);
            }
            statisticItem2.param("obj_name", i2);
            statisticItem2.param("obj_type", 2);
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    statisticItem2.param("obj_type", 10);
                } else if (O.isBJHVideoThreadType()) {
                    statisticItem2.param("obj_type", 9);
                } else if (O.isBJHVideoDynamicThreadType()) {
                    statisticItem2.param("obj_type", 8);
                } else if (O.isBJHNormalThreadType()) {
                    statisticItem2.param("obj_type", 7);
                } else if (O.isShareThread) {
                    statisticItem2.param("obj_type", 6);
                } else {
                    int i3 = O.threadType;
                    if (i3 == 0) {
                        statisticItem2.param("obj_type", 1);
                    } else if (i3 == 40) {
                        statisticItem2.param("obj_type", 2);
                    } else if (i3 == 49) {
                        statisticItem2.param("obj_type", 3);
                    } else if (i3 == 54) {
                        statisticItem2.param("obj_type", 4);
                    } else {
                        statisticItem2.param("obj_type", 5);
                    }
                }
                statisticItem2.param("nid", O.getNid());
                statisticItem2.param("card_type", O.getRecomCardType());
                statisticItem2.param("recom_source", O.mRecomSource);
                statisticItem2.param("ab_tag", O.mRecomAbTag);
                statisticItem2.param("weight", O.mRecomWeight);
                statisticItem2.param("extra", O.mRecomExtra);
                statisticItem2.param("nid", O.getNid());
                if (O.getBaijiahaoData() != null && !dj.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (P() != null) {
                tc5.e(P(), statisticItem2);
            }
            s38Var = this.j0;
            if (s38Var != null) {
                statisticItem2.param("obj_param1", s38Var.g());
            }
            TiebaStatic.log(statisticItem2);
            if (ej.D()) {
                showToast(R.string.obfuscated_res_0x7f0f0c59);
                return;
            } else if (K().S1() == null) {
                ej.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                return;
            } else {
                ArrayList<PostData> F = S1.F();
                if ((F == null || F.size() <= 0) && K().k2()) {
                    ej.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfa));
                    return;
                }
                this.N.F();
                H5();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                s38 s38Var2 = this.j0;
                if (s38Var2 != null) {
                    s38Var2.l(false);
                    Q5(S1);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.j0.i()) {
                        this.j0.m(false);
                        j4(d35.a(), this.j0.g());
                        return;
                    }
                    z5(i4);
                    return;
                }
                this.N.C0();
                K().m1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", K().m2());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", K().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!dj.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (P() != null) {
        }
        s38Var = this.j0;
        if (s38Var != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (ej.D()) {
        }
    }

    public final void c5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048666, this, i2) == null) || K() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(K().m2());
        sendMessage(privacySettingMessage);
    }

    public void d4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || this.c0 == null) {
            return;
        }
        this.b0.setVisibility(8);
        this.c0.setVisibility(8);
        this.s0.a = false;
        O4();
        R4();
    }

    public void d5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048668, this, i2) == null) || (linearLayout = this.a0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    @Override // com.baidu.tieba.ll5
    public ug<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void e4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048671, this, z2) == null) || this.c0 == null || this.f0 == null) {
            return;
        }
        if (K() != null && K().S1() != null) {
            this.f0.setText(TbSingleton.getInstance().getAdVertiComment(K().S1().n0(), K().S1().o0(), a4()));
        } else {
            this.f0.setText(a4());
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

    public void e5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, editorTools) == null) {
            this.H0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0917f2);
            this.H0.setOnCancelClickListener(new f1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.H0.getParent() == null) {
                this.c.addView(this.H0, layoutParams);
            }
            this.H0.w(TbadkCoreApplication.getInst().getSkinType());
            this.H0.setActionListener(24, new g1(this));
            f4();
            this.G0.f(new h1(this));
        }
    }

    @Override // com.baidu.tieba.s28
    public void f1(boolean z2, int i2, int i3, int i4, jv7 jv7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), jv7Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void f4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || (editorTools = this.H0) == null) {
            return;
        }
        editorTools.o();
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048675, this) == null) {
            this.K.setFallingFeedbackListener(new a2(this));
        }
    }

    @Override // com.baidu.tieba.t28
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048676, this) == null) {
            PbModel j12 = this.a.j1();
            if (j12 != null && j12.S1() != null && !j12.S1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = j12.S1().O().getId();
                if (j12.isShareThread() && j12.S1().O().originalThreadData != null) {
                    historyMessage.threadName = j12.S1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = j12.S1().O().getTitle();
                }
                if (j12.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = j12.S1().l().getName();
                }
                ArrayList<PostData> F = j12.S1().F();
                int H1 = Z3() != null ? Z3().H1() : 0;
                if (F != null && H1 >= 0 && H1 < F.size()) {
                    historyMessage.postID = F.get(H1).L();
                }
                historyMessage.isHostOnly = j12.v1();
                historyMessage.isSquence = j12.k2();
                historyMessage.isShareThread = j12.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            j75 j75Var = this.G0;
            if (j75Var != null) {
                j75Var.D();
            }
            if (j12 != null && (j12.x1() || j12.A1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", j12.m2());
                if (this.w0) {
                    if (this.y0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", j12.G1());
                    }
                    if (this.x0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", j12.C1());
                    }
                }
                if (j12.S1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = j12.S1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (J5()) {
                if (j12 != null) {
                    jv7 S1 = j12.S1();
                    if (S1 != null) {
                        if (S1.V() != null) {
                            S1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                            S1.V().setDynamicUrl(TbadkCoreApplication.getInst().getDefaultBubbleDynamicRes());
                        }
                        if (!this.z0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                cz7.b().t(rect);
                            }
                            cz7.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView Y3 = Y3();
                            cz7.b().n(j12.T1(), Y3 != null ? Y3.onSaveInstanceState() : null, j12.k2(), j12.v1(), false);
                        }
                    }
                } else {
                    cz7.b().m();
                }
                I5();
            }
        }
    }

    @Override // com.baidu.tieba.ll5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048677, this, context, str) == null) {
        }
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || this.a.getCurrentFocus() == null) {
            return;
        }
        ej.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void g5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048679, this, z2) == null) {
            this.u0 = z2;
        }
    }

    @Override // com.baidu.tieba.ll5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public void h4() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048681, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public void h5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) {
            this.L = z2;
        }
    }

    public final void i3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        ThreadData O = K().S1().O();
        O.mRecomAbTag = K().X1();
        O.mRecomWeight = K().a2();
        O.mRecomSource = K().Z1();
        O.mRecomExtra = K().Y1();
        O.isSubPb = K().F1();
        if (O.getFid() == 0) {
            O.setFid(dh.g(K().getForumId(), 0L));
        }
        StatisticItem i2 = tc5.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public void i4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048684, this) == null) || (rightFloatLayerView = this.V0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void i5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z2) == null) {
            this.p1 = z2;
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048686, this) == null) {
            qo4 c3 = qo4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.X0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.R = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.w1);
            this.Q = new n25(getPageContext());
            this.N = new h38(this);
        }
    }

    public final void j3(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048687, this, z2, str) == null) || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        ThreadData O = K().S1().O();
        O.mRecomAbTag = K().X1();
        O.mRecomWeight = K().a2();
        O.mRecomSource = K().Z1();
        O.mRecomExtra = K().Y1();
        if (O.getFid() == 0) {
            O.setFid(dh.g(K().getForumId(), 0L));
        }
        StatisticItem i2 = tc5.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l2 = tc5.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, ji5.d(str) > 40 ? ji5.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            oc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            if (L3() == 1) {
                i2.param("obj_locate", 4);
            } else if (L3() == 2) {
                i2.param("obj_locate", 5);
            } else if (L3() == 3) {
                i2.param("obj_locate", 2);
            } else if (L3() == 4) {
                i2.param("obj_locate", 3);
            } else if (L3() == 7) {
                i2.param("obj_locate", 7);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.addParam("obj_type", 1);
            i2.addParam("tid", K().m2());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", K().S1().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = tc5.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", K().m2());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", K().S1().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = tc5.i(getContext(), O, "c14303");
        if (i4 != null) {
            if (L3() == 1) {
                i4.param("obj_locate", 1);
            } else if (L3() == 2) {
                i4.param("obj_locate", 2);
            } else if (L3() == 3) {
                i4.param("obj_locate", 3);
            } else if (L3() == 4) {
                i4.param("obj_locate", 4);
            }
            i4.param("tid", K().m2());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", K().S1().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void j4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048688, this, i2, i3) == null) {
            hi5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public abstract void j5(boolean z2);

    @Override // com.baidu.tieba.t28
    public PbFragment k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
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
    public final void k3(ThreadData threadData) {
        double d3;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect j12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, threadData) == null) {
            double k2 = ej.k(getContext());
            double i3 = (2.0d * k2) / ej.i(getContext());
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                int intValue = threadData.getThreadVideoInfo().video_width.intValue();
                int intValue2 = threadData.getThreadVideoInfo().video_height.intValue();
                if (intValue2 > 0) {
                    d3 = (intValue * 1.0f) / intValue2;
                    if (d3 > 1.7777777777777777d) {
                        d3 = 1.7777777777777777d;
                    }
                    if (d3 >= i3) {
                        i3 = d3;
                    }
                    int ceil = (int) Math.ceil(k2 / i3);
                    int height = (K() != null || (j12 = K().j1()) == null) ? ceil : j12.height();
                    i2 = 0;
                    layoutParams = this.j.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams = new ViewGroup.LayoutParams(-1, height);
                    } else {
                        i2 = layoutParams.height - height;
                        layoutParams.height = height;
                    }
                    this.j.setLayoutParams(layoutParams);
                    this.j.setMaxHeight(ceil);
                    this.j.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
                    this.j.setOriginHeight(height);
                    if (y4()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, M1);
                        } else {
                            layoutParams3.height = M1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (y4()) {
                        ceil += M1;
                    }
                    if (layoutParams2 != null) {
                        layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ceil;
                    }
                    this.i.setLayoutParams(layoutParams2);
                    if (i2 == 0 && (this.i.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.i.getLayoutParams()).getBehavior();
                        if (behavior instanceof VideoZoomBehavior) {
                            ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i2);
                            return;
                        }
                        return;
                    }
                }
            }
            d3 = 1.7777777777777777d;
            if (d3 > 1.7777777777777777d) {
            }
            if (d3 >= i3) {
            }
            int ceil2 = (int) Math.ceil(k2 / i3);
            if (K() != null) {
            }
            i2 = 0;
            layoutParams = this.j.getLayoutParams();
            if (layoutParams != null) {
            }
            this.j.setLayoutParams(layoutParams);
            this.j.setMaxHeight(ceil2);
            this.j.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
            this.j.setOriginHeight(height);
            if (y4()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (y4()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            this.a0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09254c);
            this.b0 = this.c.findViewById(R.id.obfuscated_res_0x7f0925ad);
            this.c0 = this.c.findViewById(R.id.obfuscated_res_0x7f0917f6);
            ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090889);
            this.e0 = imageView;
            imageView.setOnClickListener(new u0(this));
            D4();
            this.f0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0917f9);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0917f1);
            this.d0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917f7);
            this.g0 = imageView2;
            imageView2.setOnClickListener(this.B1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917f5);
            this.h0 = imageView3;
            imageView3.setOnClickListener(this.B1);
            if (booleanExtra) {
                this.h0.setVisibility(8);
            } else {
                this.h0.setVisibility(0);
            }
            if (x4()) {
                this.g0.setVisibility(0);
            } else {
                this.g0.setVisibility(8);
                this.h0.setPadding(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917fa);
            this.i0 = imageView4;
            imageView4.setOnClickListener(this.B1);
            this.j0 = new s38(this.i0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.j0.f();
            }
            if (K() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !i18.k(K().m2())) {
                this.j0.f();
                i18.b(K().m2());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0917f8);
            this.q0 = textView;
            textView.setVisibility(0);
            u5(false);
        }
    }

    public final void k5(l75 l75Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, l75Var) == null) || l75Var == null || K() == null) {
            return;
        }
        l75Var.p(K().r1());
        if (K().S1() != null && K().S1().l() != null) {
            l75Var.o(K().S1().l());
        }
        l75Var.q("pb");
        l75Var.r(K());
    }

    public final void l3(k38 k38Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048694, this, k38Var) == null) && k38Var != null && this.w == null) {
            this.w = k38Var;
            this.C.setText(k38Var.getTitle());
            this.D.setText(k38Var.l());
            String j2 = k38Var.j();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(j2)) {
                j2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1a);
            }
            tBSpecificationBtn.setText(j2);
            this.G.K(k38Var.f(), 10, false);
            this.H.setVisibility(k38Var.n() ? 0 : 8);
            gh.a().postDelayed(new k1(this), k38Var.c().longValue() * 1000);
        }
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.J0 = new PbFakeFloorModel(getPageContext());
            PbModel K = K();
            this.J0.S(K.I(), K.E(), K.F(), K.D(), K.J());
            this.J0.setFromForumId(K.getFromForumId());
            gy7 gy7Var = new gy7(getPageContext(), this.J0, this.c);
            this.I0 = gy7Var;
            gy7Var.k(new y0(this));
            this.I0.n(this.z1);
            this.J0.U(new z0(this));
        }
    }

    public void l5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048696, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            h38 h38Var = this.N;
            if (h38Var == null) {
                return;
            }
            if (z2) {
                h38Var.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    public final void m3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || K() == null || this.a == null) {
            return;
        }
        j75 j75Var = this.G0;
        if (j75Var == null || !j75Var.t) {
            i75 i75Var = new i75();
            k5(i75Var);
            j75 j75Var2 = (j75) i75Var.a(getContext());
            this.G0 = j75Var2;
            j75Var2.W(this.a.getPageContext());
            this.G0.f0(this.i1);
            this.G0.g0(this.A1);
            this.G0.A(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.G0.a().C(true);
            e5(this.G0.a());
            if (!K().F1()) {
                this.G0.q(K().m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.G0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (K().A2()) {
                this.G0.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a));
            } else {
                this.G0.c0(a4());
            }
        }
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            e5(this.G0.a());
        }
    }

    public void m5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048699, this) == null) {
            hideProgressBar();
            if (y4() && Z3() != null) {
                Z3().E1();
                Z3().F1();
            } else if (I3() != null) {
                I3().G1();
                I3().H1();
            }
        }
    }

    public void n3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048700, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().B(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.C());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((z35) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    N4((z35) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    N4((z35) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void n4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, bundle) == null) {
            l75 l75Var = new l75();
            this.F0 = l75Var;
            k5(l75Var);
            j75 j75Var = (j75) this.F0.a(getActivity());
            this.G0 = j75Var;
            j75Var.W(this.a.getPageContext());
            this.G0.f0(this.i1);
            this.G0.g0(this.A1);
            this.G0.Y(1);
            this.G0.d0(SendView.f);
            this.G0.g(SendView.f);
            this.G0.A(this.a.getPageContext(), bundle);
            this.G0.a().b(new r55(getActivity()));
            this.G0.a().C(true);
            r5(true);
            if (K() != null) {
                this.G0.J(K().u1(), K().m2(), K().q1());
            }
            registerListener(this.a1);
            registerListener(this.c1);
            registerListener(this.k1);
            registerListener(this.Z0);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.I1);
            if (!K().F1()) {
                this.G0.q(K().m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.G0.c0(TbSingleton.getInstance().getAdVertiComment());
            } else if (K().A2()) {
                this.G0.c0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e0a));
            } else {
                this.G0.c0(a4());
            }
            this.D0 = new qz7();
            if (this.G0.s() != null) {
                this.D0.m(this.G0.s().i());
            }
            this.G0.V(this.Y0);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.A0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public void n5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            ej.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public final boolean o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            PbModel K = K();
            if (K == null || K.S1() == null) {
                return false;
            }
            ThreadData O = K.S1().O();
            K.S1().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09189f);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09189e);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09189b);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09189a);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f09189d);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901f1);
            this.G.setRadius(ej.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new oy4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (K() == null || K().S1() == null) {
                return;
            }
            w5(K().S1());
        }
    }

    public final void o5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048705, this, i2) == null) || K() == null) {
            return;
        }
        int b22 = K().b2();
        if (i2 == 5) {
            K().B3(2);
        } else if (i2 == 6) {
            K().B3(3);
        } else if (i2 != 7) {
            K().B3(1);
        } else {
            K().B3(4);
        }
        int b23 = K().b2();
        if (b22 == 4 || b23 == 4) {
            K4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906d3));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            P4(videoPbViewModel.c());
            r4(videoPbViewModel.c());
            V4(videoPbViewModel.c());
            if (K() != null && K().S1() != null) {
                boolean B1 = K().B1();
                jv7 S1 = K().S1();
                if (B1) {
                    PostData K3 = K3(S1);
                    if (S1.u() != null && !S1.u().equals(K3.L()) && this.e != null) {
                        if (y4()) {
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
            this.a.l1().k(this.T0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048707, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.G0.C(i2, i3, intent);
            gy7 gy7Var = this.I0;
            if (gy7Var != null) {
                gy7Var.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                b4(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    G4();
                } else if (i2 != 13011) {
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
                            if (G3() != null) {
                                G3().performClick();
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
                } else {
                    ed8.g().m(getPageContext());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            getBaseFragmentActivity().getLayoutMode().l(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().k(this.c);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            qz7 qz7Var = this.D0;
            if (qz7Var != null) {
                qz7Var.i();
            }
            w28 w28Var = this.l;
            if (w28Var == null || !w28Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.H0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            gy7 gy7Var = this.I0;
            if (gy7Var != null) {
                gy7Var.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.V0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            LinearLayout linearLayout = this.d0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (K() != null && K().D1()) {
                WebPManager.setPureDrawable(this.h0, R.drawable.obfuscated_res_0x7f08097e, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.h0, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.g0, R.drawable.obfuscated_res_0x7f080980, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e0, R.drawable.obfuscated_res_0x7f0809bb, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f08093d, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (K() != null) {
                Q5(K().S1());
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
            SkinManager.setBackgroundShapeDrawable(this.q0, ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (I3() != null) {
                I3().onChangeSkinType(i2);
            } else if (y4() && Z3() != null) {
                Z3().onChangeSkinType(i2);
            }
            if (J3() != null) {
                J3().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            H5();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            m38 m38Var = this.k;
            if (m38Var == null || m38Var.N0()) {
                return;
            }
            if (!(this.k.isFullScreen() && configuration.orientation == 1) && (this.k.isFullScreen() || configuration.orientation != 2)) {
                return;
            }
            this.k.V(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            n4(bundle);
            t0().onCreate(getPageContext());
            ux4 ux4Var = new ux4();
            this.O = ux4Var;
            ux4Var.a = 1000L;
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
            this.t = new g16(getPageContext());
            ll8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048712, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(N3(), viewGroup, false);
            t4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            super.onDestroy();
            ll8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.F1);
            ItemCardHelper.v(null);
            t0().onDestory(getPageContext());
            s38 s38Var = this.j0;
            if (s38Var != null) {
                s38Var.k();
            }
            ForumManageModel forumManageModel = this.R;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            m38 m38Var = this.k;
            if (m38Var != null) {
                m38Var.O0();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.A0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            h38 h38Var = this.N;
            if (h38Var != null) {
                h38Var.o0();
            }
            if (K() != null) {
                K().cancelLoadData();
                K().destory();
                if (K().O1() != null) {
                    K().O1().d();
                }
            }
            j75 j75Var = this.G0;
            if (j75Var != null) {
                j75Var.D();
            }
            this.O = null;
            vm8.d();
            G5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048714, this) == null) {
            super.onPause();
            this.R0 = true;
            t0().onPause(getPageContext());
            m38 m38Var = this.k;
            if (m38Var != null) {
                m38Var.onBackground(true);
            }
            if (K() != null && !K().F1()) {
                this.G0.N(K().m2());
            }
            RightFloatLayerView rightFloatLayerView = this.V0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            rl4.w().E();
            MessageManager.getInstance().unRegisterListener(this.f1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onResume();
            this.R0 = false;
            t0().onResume(getPageContext());
            m38 m38Var = this.k;
            if (m38Var != null) {
                m38Var.onBackground(false);
            }
            A5();
            registerListener(this.f1);
            registerListener(this.g1);
            registerListener(this.e1);
            registerListener(this.E1);
            ItemCardHelper.v(this.H1);
            MessageManager.getInstance().registerListener(this.G1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (K() != null) {
                K().n3(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            t0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onStart();
            t0().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onStop();
            t0().onStop(getPageContext());
            ll8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z2) == null) {
            super.onUserChanged(z2);
            D4();
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void p0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048720, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (il5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), il5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (tz7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new aj5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final boolean p3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048721, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f09254f);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802ca);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f091f7f);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091f86);
            this.o = findViewById;
            if (this.o1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = ej.s(P());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = ej.s(P());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.B1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092680);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080628, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d062e, this.B1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09164d);
            int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.rightMargin = f3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.r.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.r1 = new GestureDetector(getContext(), this.s1);
            this.m.setOnTouchListener(this.q1);
        }
    }

    public void p5(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048723, this, i2) == null) || (view2 = this.g) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            if ((K() != null && K().S1().i0()) || this.A0 == null || K() == null || K().S1() == null || ThreadCardUtils.isSelf(K().S1().O()) || K().S1().d() == null) {
                return true;
            }
            return this.A0.checkPrivacyBeforeInvokeEditor(K().S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void q4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || (editorTools = this.H0) == null) {
            return;
        }
        editorTools.j();
        d4();
    }

    public void q5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z2) == null) {
            this.u = z2;
        }
    }

    public boolean r3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048727, this, i2)) == null) {
            if (this.A0 == null || K() == null || K().S1() == null || ThreadCardUtils.isSelf(K().S1().O()) || K().S1().d() == null) {
                return true;
            }
            return this.A0.checkPrivacyBeforeSend(K().S1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void r4(jv7 jv7Var) {
        o05 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, jv7Var) == null) || this.U0 == null || jv7Var == null || jv7Var.g() == 3 || v4()) {
            return;
        }
        if (jv7Var.n0()) {
            pbAdFloatViewItemData = jv7Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
            if (!RightFloatLayerView.k()) {
                i4();
                return;
            }
            if (this.V0 == null) {
                this.V0 = RightFloatLayerLottieView.F(pbAdFloatViewItemData, getContext());
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
            this.V0.setLogoListener(new g0(this, jv7Var, pbAdFloatViewItemData));
            this.V0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        i4();
    }

    public final void r5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z2) == null) {
            this.G0.X(z2);
            this.G0.a0(z2);
            this.G0.i0(z2);
        }
    }

    public void s3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            if (!checkUpIsLogin()) {
                if (K() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", K().getForumId()));
                }
            } else if (q3()) {
                j75 j75Var = this.G0;
                if (j75Var != null && (j75Var.x() || this.G0.z())) {
                    this.G0.w(false, null);
                    return;
                }
                if (this.H0 != null) {
                    q4();
                    this.s0.a = false;
                    if (this.H0.n(2) != null) {
                        vm8.c(getPageContext(), (View) this.H0.n(2).m, false, null);
                    }
                }
                d4();
            }
        }
    }

    public final void s4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public final void s5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048732, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                h38 h38Var = this.N;
                if (h38Var != null) {
                    h38Var.L0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || (customViewPager = this.e) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            if (this.S == null) {
                this.S = VoiceManager.instance();
            }
            return this.S;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            if (K().x1() || K().A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", K().m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, K().m2()));
            if (J5()) {
                this.a.finish();
            }
        }
    }

    public void t4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048736, this) == null) {
            x76 x76Var = new x76(getActivity());
            this.K0 = x76Var;
            x76Var.i(this.y1);
            this.o1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            p4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0902ab);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f0918a1);
            this.U0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091c3e);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09188f);
            m38 m38Var = new m38(getContext(), this.j);
            this.k = m38Var;
            m38Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(P().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091dce)).setMinimumHeight(((int) Math.ceil((ej.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f0918a5);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f09189c);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f0918a7);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f09103f);
            this.A = (MaskView) this.c.findViewById(R.id.obfuscated_res_0x7f0914c7);
            this.h.setOnClickListener(this.B1);
            s4();
            o4();
            k4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0925e3);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090994);
            f5();
            this.K.setAnimationListener(new s0(this));
            m4();
            l4();
            if (!this.o1 && this.p1) {
                D5();
                UtilHelper.hideStatusBar(P(), P().getRootView());
                this.p1 = false;
            }
            if (y4()) {
                return;
            }
            this.d.getLayoutParams().height = 0;
        }
    }

    public final void t5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048737, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (postWriteCallBackData.getIconStampData() != null) {
                l35.c(getPageContext(), postWriteCallBackData, 2);
                return;
            }
            return;
        }
        if (K() != null && !K().F1()) {
            antiData.setBlock_forum_name(K().S1().l().getName());
            antiData.setBlock_forum_id(K().S1().l().getId());
            antiData.setUser_name(K().S1().V().getUserName());
            antiData.setUser_id(K().S1().V().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048739, this) == null) || K() == null || dj.isEmpty(K().m2())) {
            return;
        }
        super.taskStart();
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            PbModel j12 = this.a.j1();
            if (j12 == null) {
                return false;
            }
            return j12.J2();
        }
        return invokeV.booleanValue;
    }

    public void u3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, bVar) == null) {
            List<PostData> list = K().S1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).Z().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).Z().get(i3).L())) {
                        list.get(i2).Z().remove(i3);
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
                if (I3() != null) {
                    I3().T1();
                } else if (y4() && Z3() != null) {
                    Z3().Q1();
                }
            }
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && this.l == null) {
            this.l = new w28(getBaseFragmentActivity(), this.j);
            int s2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? ej.s(P()) : 0;
            Rect rect = new Rect(0, s2, ej.k(getContext()), this.j.getOriginHeight() + s2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (y4() && (videoPbViewModel.n() || K().l2() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || K().l2() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    public void u5(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) || this.c0 == null) {
            return;
        }
        g5(this.G0.y());
        if (this.u0) {
            v5(z2);
        } else {
            e4(z2);
        }
        O4();
        R4();
    }

    public void v3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048744, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (K().n1() != null) {
                        K().n1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.R.S()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f09203f);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092040)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092041)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092053) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092053)).booleanValue() : false;
                if (jSONArray != null) {
                    this.R.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.R.V(K().S1().l().getId(), K().S1().l().getName(), K().S1().O().getId(), str, intValue3, intValue2, booleanValue, K().S1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public abstract boolean v4();

    public void v5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048746, this, z2) == null) || this.c0 == null || (textView = this.f0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0526);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.c0.startAnimation(alphaAnimation);
        }
        this.b0.setVisibility(0);
        this.c0.setVisibility(0);
        this.s0.a = true;
    }

    @Override // com.baidu.tieba.ll5
    public ug<GifView> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            if (this.T == null) {
                this.T = new ug<>(new u1(this), 20, 0);
            }
            return this.T;
        }
        return (ug) invokeV.objValue;
    }

    public void w3(nu4 nu4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048748, this, nu4Var, jSONArray) == null) {
            nu4Var.dismiss();
            if (K() == null || K().S1() == null || K().S1().O() == null || K().S1().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (nu4Var.getYesButtonTag() instanceof SparseArray) {
                    v3((SparseArray) nu4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            EditorTools editorTools = this.H0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void w5(jv7 jv7Var) {
        k38 G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048750, this, jv7Var) == null) || (G = jv7Var.G()) == null || G.l) {
            return;
        }
        l3(G);
    }

    public void x3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048751, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092041, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f09205d, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                v3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public abstract boolean x4();

    public void x5() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048753, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // com.baidu.tieba.ll5
    public ug<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return null;
        }
        return (ug) invokeV.objValue;
    }

    public void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048755, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", N1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? (v4() || K() == null || !K().I2()) ? false : true : invokeV.booleanValue;
    }

    public final void y5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
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

    @Override // com.baidu.tieba.ll5
    public ug<LinearLayout> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            if (this.X == null) {
                this.X = new ug<>(new w1(this), 15, 0);
            }
            return this.X;
        }
        return (ug) invokeV.objValue;
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", N1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            m38 m38Var = this.k;
            return m38Var != null && m38Var.M0();
        }
        return invokeV.booleanValue;
    }

    public final void z5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048761, this, i2) == null) {
            l38.c(P(), H3(), i2);
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a && this.b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ d2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }
}
