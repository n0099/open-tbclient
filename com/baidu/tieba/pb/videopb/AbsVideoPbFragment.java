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
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.setting.im.more.PrivacySettingMessage;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.AgreeData;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import com.repackage.az4;
import com.repackage.bb8;
import com.repackage.bm4;
import com.repackage.bx7;
import com.repackage.c9;
import com.repackage.cf5;
import com.repackage.cj4;
import com.repackage.cj8;
import com.repackage.dj4;
import com.repackage.e05;
import com.repackage.er4;
import com.repackage.et7;
import com.repackage.fg;
import com.repackage.fu7;
import com.repackage.g18;
import com.repackage.g45;
import com.repackage.ge5;
import com.repackage.gf5;
import com.repackage.gg;
import com.repackage.gi5;
import com.repackage.gw7;
import com.repackage.gy4;
import com.repackage.gz7;
import com.repackage.h08;
import com.repackage.h25;
import com.repackage.h45;
import com.repackage.i25;
import com.repackage.i45;
import com.repackage.if5;
import com.repackage.j18;
import com.repackage.j45;
import com.repackage.je5;
import com.repackage.ji5;
import com.repackage.jm4;
import com.repackage.jz7;
import com.repackage.k18;
import com.repackage.k45;
import com.repackage.kp4;
import com.repackage.ks7;
import com.repackage.kx7;
import com.repackage.l05;
import com.repackage.l18;
import com.repackage.m45;
import com.repackage.mk8;
import com.repackage.my7;
import com.repackage.nw4;
import com.repackage.o25;
import com.repackage.o45;
import com.repackage.o56;
import com.repackage.o95;
import com.repackage.og;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.px7;
import com.repackage.pz4;
import com.repackage.qi;
import com.repackage.qo6;
import com.repackage.qv4;
import com.repackage.qx4;
import com.repackage.r08;
import com.repackage.r25;
import com.repackage.rg;
import com.repackage.rk8;
import com.repackage.rn4;
import com.repackage.ru4;
import com.repackage.s08;
import com.repackage.s15;
import com.repackage.s25;
import com.repackage.sx7;
import com.repackage.t25;
import com.repackage.t95;
import com.repackage.ur4;
import com.repackage.ut7;
import com.repackage.v08;
import com.repackage.w18;
import com.repackage.wr4;
import com.repackage.wu4;
import com.repackage.xr8;
import com.repackage.yf5;
import com.repackage.z05;
import com.repackage.zy5;
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
/* loaded from: classes4.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements ji5, VoiceManager.j, s08, TbRichTextView.s, r08 {
    public static /* synthetic */ Interceptable $ic;
    public static final int N1;
    public static final int O1;
    public static int P1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public final o56.b A1;
    public View.OnClickListener B;
    public boolean B0;
    public NewWriteModel.e B1;
    public TextView C;
    public ReplyPrivacyCheckController C0;
    public i45 C1;
    public TextView D;
    public qo6 D0;
    public final View.OnClickListener D1;
    public ImageView E;
    public qo6 E0;
    public View.OnClickListener E1;
    public TBSpecificationBtn F;
    public px7 F0;
    public final AdapterView.OnItemClickListener F1;
    public TbImageView G;
    public PermissionJudgePolicy G0;
    public CustomMessageListener G1;
    public View H;
    public m45 H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public k45 I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public EditorTools J0;
    public final ItemCardHelper.c J1;
    public FallingView K;
    public gw7 K0;
    public CustomMessageListener K1;
    public boolean L;
    public PbFakeFloorModel L0;
    public final View.OnLongClickListener L1;
    public View M;
    public o56 M0;
    public SortSwitchButton.f M1;
    public g18 N;
    public int[] N0;
    public wu4 O;
    public int O0;
    public bm4 P;
    public int P0;
    public my7 Q;
    public int Q0;
    public EmotionImageData R;
    public int R0;
    public pz4 S;
    public int S0;
    public ForumManageModel T;
    public boolean T0;
    public VoiceManager U;
    public boolean U0;
    public fg<GifView> V;
    @NonNull
    public TiePlusEventController.f V0;
    public fg<TextView> W;
    public FrameLayout W0;
    public fg<ImageView> X;
    public RightFloatLayerView X0;
    public fg<View> Y;
    public final PbModel.h Y0;
    public fg<LinearLayout> Z;
    public final bm4.a Z0;
    public AbsPbActivity a;
    public fg<RelativeLayout> a0;
    public h45 a1;
    public long b;
    public boolean b0;
    public final CustomMessageListener b1;
    public RelativeLayout c;
    public LinearLayout c0;
    public CustomMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public View d0;
    public final CustomMessageListener d1;
    public CustomViewPager e;
    public View e0;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public LinearLayout f0;
    public HttpMessageListener f1;
    public View g;
    public ImageView g0;
    public CustomMessageListener g1;
    public View h;
    public TextView h0;
    public CustomMessageListener h1;
    public AppBarLayout i;
    public ImageView i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public ImageView j0;
    public h45 j1;
    public l18 k;
    public final NewWriteModel.e k1;
    public v08 l;
    public View.OnClickListener l1;
    public NavigationBar m;
    public CustomMessageListener m1;
    public View n;
    public int n1;
    public View o;
    public float o1;
    public View p;
    public float p1;
    public ImageView q;
    public ImageView q0;
    public boolean q1;
    public View r;
    public w18 r0;
    public boolean r1;
    public ImageView s;
    public TextView s0;
    public View.OnTouchListener s1;
    public zy5 t;
    public TextView t0;
    public GestureDetector t1;
    public boolean u;
    public c2 u0;
    public GestureDetector.SimpleOnGestureListener u1;
    public View v;
    public String v0;
    public Runnable v1;
    public j18 w;
    public boolean w0;
    public ObjectAnimator w1;
    public View x;
    public String x0;
    public ObjectAnimator x1;
    public View y;
    public boolean y0;
    public final c9 y1;
    public View z;
    public boolean z0;
    public View.OnTouchListener z1;

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.T0) {
                return;
            }
            this.a.E5();
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements je5<ShareItem> {
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
        @Override // com.repackage.je5
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.K() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.I0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k5(absVideoPbFragment.I0.C());
            }
            this.a.b5();
            this.a.N.F();
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.T5();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092044) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092044)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f09202e) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09202e)).booleanValue() : false;
            g18 g18Var = this.a.N;
            if (g18Var != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.TRUE);
                    this.a.N.l0(view2);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffb, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091fe4, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    g18Var.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                g18 g18Var = this.a.N;
                if (g18Var != null) {
                    g18Var.F();
                }
                boolean z = false;
                if (!oi.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                    return false;
                }
                if (this.a.K() != null && !this.a.K().isLoading) {
                    this.a.L5();
                    this.a.r5();
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            ks7 ks7Var = (ks7) customResponsedMessage.getData();
            int type = ks7Var.getType();
            if (type == 0) {
                this.a.Z4((ut7) ks7Var.a());
            } else if (type == 1) {
                this.a.D3((ForumManageModel.b) ks7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (ks7Var.a() == null) {
                    this.a.X4(false, null);
                } else {
                    this.a.X4(true, (MarkData) ks7Var.a());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                            bdTopToast.g(this.a.getString(R.string.obfuscated_res_0x7f0f0322));
                            bdTopToast.i((ViewGroup) this.a.getView());
                            this.a.s5(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d);
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

    /* loaded from: classes4.dex */
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
            absVideoPbFragment.g5(absVideoPbFragment.Y3(i));
        }
    }

    /* loaded from: classes4.dex */
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
        public void b(et7 et7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, et7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, et7 et7Var, String str, int i4) {
            String c4;
            o25 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), et7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906bd));
                }
                this.a.q5();
                this.a.j4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.y5(false);
                if (z && et7Var != null) {
                    ThreadData O = et7Var.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(et7Var, i2);
                    this.a.S4(et7Var);
                    this.a.A5(et7Var);
                    this.a.Y4(et7Var);
                    this.a.V4(z, i, i2, i3, et7Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(et7Var.V().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(et7Var.V().getBimg_end_time());
                    if (et7Var.F() != null && et7Var.F().size() >= 1 && et7Var.F().get(0) != null) {
                        this.a.K().r3(et7Var.F().get(0).K());
                    } else if (et7Var.X() != null) {
                        this.a.K().r3(et7Var.X().K());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(et7Var.r());
                    }
                    AntiData d = et7Var.d();
                    if (d != null) {
                        this.a.x0 = d.getVoice_message();
                        if (!StringUtils.isNull(this.a.x0) && this.a.I0 != null && this.a.I0.a() != null && (m = this.a.I0.a().m(6)) != null && !TextUtils.isEmpty(this.a.x0)) {
                            ((View) m).setOnClickListener(this.a.l1);
                        }
                    }
                    if (this.a.C0 != null && O != null && O.getAuthor() != null) {
                        AttentionHostData attentionHostData = new AttentionHostData();
                        attentionHostData.parserWithMetaData(O.getAuthor());
                        this.a.C0.setLikeUserData(attentionHostData);
                    }
                    this.a.t4(et7Var);
                    if (this.a.K() != null && this.a.K().A2()) {
                        c4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ded);
                    } else {
                        c4 = this.a.c4();
                    }
                    if (!StringUtils.isNull(c4)) {
                        this.a.I0.m0(TbSingleton.getInstance().getAdVertiComment(et7Var.n0(), et7Var.o0(), c4));
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
                    if ((this.a.A4() && this.a.b4() == null) || this.a.K3() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.A4()) {
                        if (i != -1) {
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                arrayList = this.a.K().S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.b4().Y1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                            } else if (this.a.b4().S1()) {
                                this.a.b4().Z1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dde));
                            } else {
                                this.a.b4().Z1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ddf));
                            }
                        } else {
                            this.a.b4().Y1("");
                        }
                        this.a.b4().F1();
                    } else {
                        if (i != -1) {
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                arrayList = this.a.K().S1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.K3().f2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                            } else if (this.a.K3().W1()) {
                                this.a.K3().g2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dde));
                            } else {
                                this.a.K3().g2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ddf));
                            }
                        } else {
                            this.a.K3().f2("");
                        }
                        this.a.K3().H1();
                    }
                }
                cj8.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof xr8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                xr8 xr8Var = (xr8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = xr8Var.a;
                if (xr8Var.c == 0 && dataRes != null) {
                    int e = og.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (pi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f09203e, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091ffb)).intValue();
                if (intValue == 0) {
                    this.a.N.F0(r3, sparseArray);
                } else if (intValue == 1) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.TRUE);
                    this.a.N.k0(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gi5.a)) {
                gi5.a aVar = (gi5.a) customResponsedMessage.getData();
                gi5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d1 implements qo6.d {
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.I0 != null && this.a.I0.a() != null) {
                    this.a.I0.a().A(new h25(45, 27, null));
                }
                this.a.u3();
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
            g18 g18Var = this.a.N;
            if (tag == g18Var.D) {
                g18Var.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                et7 S1 = this.a.K().S1();
                if (S1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    S1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b35));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b31);
                    }
                    this.a.N.L0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.E0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (pi.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b32);
                    }
                    this.a.O.c(errorString2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            rk8 rk8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof rk8) || (rk8Var = (rk8) customResponsedMessage.getData()) == null || (agreeData = rk8Var.b) == null || agreeData.agreeType != 2 || this.a.r0 == null || this.a.K() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || gz7.k(this.a.K().m2())) {
                return;
            }
            this.a.r0.o(2);
            gz7.b(this.a.K().m2());
        }
    }

    /* loaded from: classes4.dex */
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
        public void onNavigationButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            g18 g18Var = this.a.N;
            if (tag == g18Var.D) {
                g18Var.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149b));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (pi.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149a);
                }
                this.a.O.c(muteMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            l18 l18Var;
            BdTypeRecyclerView a4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (l18Var = this.a.k) == null) {
                return;
            }
            if (l18Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!pi.isEmpty(this.a.k.c0())) {
                this.a.B0 = true;
                if (this.a.A4()) {
                    this.a.e.setCurrentItem(0);
                } else {
                    this.a.e.setCurrentItem(0);
                }
                if (!this.a.A4() && (a4 = this.a.a4()) != null) {
                    a4.scrollToPosition(0);
                }
            }
            if (this.a.l == null || !this.a.l.k()) {
                this.a.c5();
                this.a.m3(threadData);
            }
            this.a.w4();
            if (this.a.l != null && this.a.l.l()) {
                this.a.l.s();
            }
            boolean z = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
            this.a.k.setData(threadData);
            if (this.a.A4()) {
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

    /* loaded from: classes4.dex */
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
                this.a.b5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                px7 px7Var = this.a.F0;
                if (px7Var == null || px7Var.g() == null || !this.a.F0.g().d()) {
                    return !this.a.t3(ReplyPrivacyCheckController.TYPE_FLOOR);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.F0.g().c());
                if (this.a.K0 != null && this.a.K0.b() != null && this.a.K0.b().x()) {
                    this.a.K0.b().v(this.a.F0.h());
                }
                this.a.F0.b(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ et7 a;
        public final /* synthetic */ qx4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, et7 et7Var, qx4 qx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, et7Var, qx4Var};
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
            this.a = et7Var;
            this.b = qx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b == null || this.c.X0 == null) {
                return;
            }
            this.c.X0.g(this.b);
            this.c.X0.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes4.dex */
    public class g1 implements i25 {
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

        @Override // com.repackage.i25
        public void A(h25 h25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) {
                Object obj = h25Var.c;
                if ((obj instanceof gy4) && EmotionGroupType.isSendAsPic(((gy4) obj).getType())) {
                    if (this.a.G0 == null) {
                        this.a.G0 = new PermissionJudgePolicy();
                    }
                    this.a.G0.clearRequestPermissionList();
                    this.a.G0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.I0.h((gy4) h25Var.c);
                    this.a.I0.z(false, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes4.dex */
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
                this.b.a.Q4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        statisticItem.param("fid", this.a.K().S1().m());
                    }
                    statisticItem.param("tid", this.a.K().m2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.L5();
                this.a.p5(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (writeData != null) {
                    nw4.b(writeData.getContent(), "3");
                }
                boolean z2 = false;
                if (!z) {
                    if (i == 220015) {
                        this.a.showToast(str);
                        if (this.a.I0.B() || this.a.I0.D()) {
                            this.a.I0.z(false, postWriteCallBackData);
                        }
                        this.a.F0.k(postWriteCallBackData);
                        return;
                    } else if (i == 238010) {
                        ReplyPrivacyCheckController replyPrivacyCheckController = this.a.C0;
                        if (replyPrivacyCheckController != null) {
                            replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                            return;
                        }
                        return;
                    } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (az4Var != null || i == 227001) {
                            return;
                        }
                        this.a.w5(i, antiData, str);
                        return;
                    } else {
                        ur4 ur4Var = new ur4(this.a.getActivity());
                        if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                            ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf4));
                        } else {
                            ur4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new b(this));
                        ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf6, new c(this));
                        ur4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.K() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.K().a1(postWriteCallBackData.getPostId());
                    if (this.a.A4() && this.a.b4() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.R0 = absVideoPbFragment.b4().I1();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.S0 = absVideoPbFragment2.b4().J1();
                        this.a.K().q3(this.a.R0, this.a.S0);
                    } else if (this.a.K3() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.R0 = absVideoPbFragment3.K3().K1();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.S0 = absVideoPbFragment4.K3().L1();
                        this.a.K().q3(this.a.R0, this.a.S0);
                    }
                }
                if (this.a.e != null) {
                    if (this.a.A4()) {
                        this.a.e.setCurrentItem(1);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                }
                this.a.N.F();
                this.a.F0.c();
                if (this.a.I0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                    absVideoPbFragment5.k5(absVideoPbFragment5.I0.C());
                }
                this.a.h4();
                this.a.y5(true);
                this.a.K().v2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.x5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.K().v1()) {
                        et7 S1 = this.a.K().S1();
                        if (S1 != null && S1.O() != null && S1.O().getAuthor() != null && (userId = S1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.K().I3()) {
                            this.a.r5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.K().I3()) {
                        this.a.r5();
                    }
                } else if (floor != null) {
                    if (this.a.A4() && this.a.b4() != null) {
                        this.a.b4().R1();
                    } else if (this.a.K3() != null) {
                        this.a.K3().U1();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    rg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.l3(z2, writeData != null ? writeData.getContent() : "");
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            px7 px7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (px7Var = this.a.F0) == null || px7Var.e() == null) {
                return;
            }
            if (!this.a.F0.e().e()) {
                this.a.F0.a(false);
            }
            this.a.F0.e().l(false);
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
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.J0 == null || this.a.J0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i) || TextUtils.isEmpty(charSequence.toString().substring(i, i4))) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
                absVideoPbFragment.showToast(absVideoPbFragment.x0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            l18 l18Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (l18Var = this.a.k) == null) {
                return;
            }
            l18Var.U0(threadData);
        }
    }

    /* loaded from: classes4.dex */
    public class i1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes4.dex */
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
                px7 px7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (px7Var = this.a.c.F0) == null || px7Var.g() == null) {
                    return;
                }
                if (!this.a.c.F0.g().e()) {
                    this.a.c.F0.b(false);
                }
                this.a.c.F0.g().l(false);
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
                int i2 = qi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = qi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                if (absVideoPbFragment.a4() != null) {
                    this.c.a4().smoothScrollBy(0, i4);
                }
                if (this.c.K0 != null) {
                    this.c.I0.a().setVisibility(8);
                    this.c.K0.o(this.a, this.b, this.c.c4(), (this.c.K() == null || this.c.K().S1() == null || this.c.K().S1().O() == null || !this.c.K().S1().O().isBjh()) ? false : false);
                    this.c.K0.l(this.c.N3());
                    o45 b = this.c.K0.b();
                    if (b != null && this.c.K() != null && this.c.K().S1() != null) {
                        b.G(this.c.K().S1().d());
                        b.c0(this.c.K().S1().O());
                    }
                    if (this.c.F0.f() == null && this.c.K0.b().t() != null) {
                        this.c.K0.b().t().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().i());
                        this.c.K0.b().M(this.c.j1);
                    }
                }
                this.c.f4();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (this.a.I0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k5(absVideoPbFragment.I0.C());
            }
            this.a.y5(false);
        }
    }

    /* loaded from: classes4.dex */
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
            l18 l18Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (l18Var = this.a.k) == null) {
                return;
            }
            l18Var.T0(threadData);
        }
    }

    /* loaded from: classes4.dex */
    public class j1 implements qo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$j1$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0251a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0251a(a aVar) {
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
                    px7 px7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (px7Var = this.a.a.c.F0) == null || px7Var.g() == null) {
                        return;
                    }
                    if (!this.a.a.c.F0.g().e()) {
                        this.a.a.c.F0.b(false);
                    }
                    this.a.a.c.F0.g().l(false);
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
                    int i2 = qi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = qi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f = qi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i3 = i2 - (i + f);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                    if (absVideoPbFragment.a4() != null) {
                        this.a.c.a4().smoothScrollBy(0, i4);
                    }
                    if (this.a.c.K0 != null) {
                        this.a.c.I0.a().setVisibility(8);
                        z = (this.a.c.K() == null || this.a.c.K().S1() == null || this.a.c.K().S1().O() == null || !this.a.c.K().S1().O().isBjh()) ? false : false;
                        gw7 gw7Var = this.a.c.K0;
                        j1 j1Var = this.a;
                        gw7Var.o(j1Var.a, j1Var.b, j1Var.c.c4(), z);
                        this.a.c.K0.l(this.a.c.N3());
                        o45 b = this.a.c.K0.b();
                        if (b != null && this.a.c.K() != null && this.a.c.K().S1() != null) {
                            b.G(this.a.c.K().S1().d());
                            b.c0(this.a.c.K().S1().O());
                        }
                        if (this.a.c.F0.f() == null && this.a.c.K0.b().t() != null) {
                            this.a.c.K0.b().t().g(new C0251a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().i());
                            this.a.c.K0.b().M(this.a.c.j1);
                        }
                    }
                    this.a.c.f4();
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

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                rg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
                            absVideoPbFragment.E4(absVideoPbFragment.w.j, this.a.w.i);
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

    /* loaded from: classes4.dex */
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
                this.a.U4();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.G5();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    return this.a.t1 != null && this.a.t1.onTouchEvent(motionEvent);
                }
                if (this.a.n1 == 1) {
                    if (!this.a.r1) {
                        this.a.I5();
                        UtilHelper.showStatusBar(this.a.P(), this.a.P().getRootView());
                        this.a.r1 = true;
                        rg.a().removeCallbacks(this.a.v1);
                        rg.a().postDelayed(this.a.v1, 3000L);
                    }
                } else if (this.a.n1 == 2 && (this.a.r1 || this.a.B4())) {
                    this.a.H5();
                    UtilHelper.hideStatusBar(this.a.P(), this.a.P().getRootView());
                    this.a.r1 = false;
                    l18 l18Var = this.a.k;
                    if (l18Var != null) {
                        l18Var.S0(false);
                    }
                }
                this.a.n1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.n5(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                this.a.n1 = 0;
                this.a.o1 = 0.0f;
                this.a.p1 = 0.0f;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            l18 l18Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.o1 += f;
                this.a.p1 += f2;
                if (this.a.n1 == 0 && !this.a.q1 && (l18Var = this.a.k) != null && !l18Var.isFullScreen()) {
                    int height = this.a.m.getHeight();
                    if (motionEvent.getY() < 0.0f || Math.abs(this.a.p1) <= Math.abs(this.a.o1) || this.a.p1 > (-height) / 5) {
                        if (Math.abs(this.a.p1) > Math.abs(this.a.o1) && this.a.p1 > 0.0f && f2 > 0.0f) {
                            this.a.n1 = 2;
                        }
                    } else {
                        this.a.n1 = 1;
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.b.A4() && (this.a.n() || this.b.K().l2() == 1)) {
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
                if (this.b.A4() && (this.a.n() || this.b.K().l2() == 1)) {
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

    /* loaded from: classes4.dex */
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
                this.b.S5(this.a);
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

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.r1 && !this.a.B4()) {
                this.a.H5();
                UtilHelper.hideStatusBar(this.a.P(), this.a.P().getRootView());
                this.a.r1 = false;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.I0.M(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.K0 != null && this.a.K0.b() != null) {
                    this.a.K0.b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.f5(absVideoPbFragment.R);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n1 implements bm4.a {
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

        @Override // com.repackage.bm4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.q5();
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
                        this.a.I4();
                    } else if (this.a.A4()) {
                        if (this.a.L3() != null) {
                            this.a.L3().D1();
                        }
                        if (this.a.b4() != null) {
                            this.a.b4().R1();
                        }
                    } else if (this.a.K3() != null) {
                        this.a.K3().U1();
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
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.k3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd2));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14c2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o extends c9 {
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

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.K() != null) {
                    switch (this.a.T.getLoadDataMode()) {
                        case 0:
                            this.a.K().v2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.D3(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.E3(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.F3(absVideoPbFragment.T.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.E3(absVideoPbFragment2.T.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.f0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.E3(absVideoPbFragment3.T.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.b.height = (this.c - AbsVideoPbFragment.N1) + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.M0.c(motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class q implements o56.b {
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

        @Override // com.repackage.o56.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    fu7.d();
                } else {
                    fu7.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (this.a.K3() != null) {
                        this.a.K3().Z1(false);
                    } else if (this.a.A4() && this.a.b4() != null) {
                        this.a.b4().U1(false);
                    }
                    if (this.a.L3() != null) {
                        this.a.L3().I1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.t5(absVideoPbFragment.L3().A1() == 0 ? 8 : 0);
                        this.a.c0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    l18 l18Var = this.a.k;
                    if (l18Var != null) {
                        l18Var.R0(z);
                    }
                    this.a.b5();
                    if (this.a.K() != null && this.a.K().S1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()));
                    }
                } else {
                    if (this.a.L3() != null) {
                        this.a.L3().I1(false);
                    }
                    if (this.a.K3() != null) {
                        this.a.K3().Z1(true);
                        int Q1 = this.a.K3().Q1();
                        int O1 = this.a.K3().O1();
                        if (Q1 != 0) {
                            this.a.t5(8);
                            this.a.K3().j2(0);
                        } else if (O1 != 0) {
                            this.a.K3().j2(8);
                            this.a.t5(0);
                        } else {
                            this.a.K3().j2(8);
                            this.a.t5(8);
                        }
                    } else if (this.a.b4() != null) {
                        this.a.b4().U1(true);
                        int O12 = this.a.b4().O1();
                        int M1 = this.a.b4().M1();
                        if (O12 != 0) {
                            this.a.t5(8);
                            this.a.b4().c2(0);
                        } else if (M1 != 0) {
                            this.a.b4().c2(8);
                            this.a.t5(0);
                        } else {
                            this.a.b4().c2(8);
                            this.a.t5(8);
                        }
                        this.a.c0.setVisibility(0);
                    }
                    l18 l18Var2 = this.a.k;
                    if (l18Var2 != null) {
                        l18Var2.R0(false);
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

    /* loaded from: classes4.dex */
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
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * AbsVideoPbFragment.N1);
                this.a.height = floatValue;
                this.b.height = this.c + floatValue;
                this.d.v.setLayoutParams(this.a);
                this.d.i.setLayoutParams(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements ur4.e {
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

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) || ur4Var == null) {
                return;
            }
            ur4Var.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx4 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, qx4 qx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, qx4Var};
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
            this.a = qx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.X0.setHomePbFloatLastCloseTime();
                this.b.k4();
                this.b.X0.u(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.Q5();
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

    /* loaded from: classes4.dex */
    public class s implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes4.dex */
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
                this.b.a.Q4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes4.dex */
        public class b implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements ur4.e {
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

            @Override // com.repackage.ur4.e
            public void onClick(ur4 ur4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                    ur4Var.dismiss();
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) {
                if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
                    nw4.b(writeData.getContent(), "4");
                }
                if (z) {
                    px7 px7Var = this.a.F0;
                    if (px7Var != null) {
                        px7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        l05.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    rg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                    return;
                }
                if ((postWriteCallBackData != null ? postWriteCallBackData.getErrorCode() : -1) == 238010) {
                    ReplyPrivacyCheckController replyPrivacyCheckController = this.a.C0;
                    if (replyPrivacyCheckController != null) {
                        replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                        return;
                    }
                    return;
                }
                if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f047b), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    ur4 ur4Var = new ur4(this.a.getActivity());
                    if (pi.isEmpty(postWriteCallBackData.getErrorString())) {
                        ur4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cf4));
                    } else {
                        ur4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new b(this));
                    ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cf6, new c(this));
                    ur4Var.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                }
                if (postWriteCallBackData == null || !postWriteCallBackData.isSensitiveError()) {
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                if (absVideoPbFragment.F0 == null) {
                    return;
                }
                if (absVideoPbFragment.K0 != null && this.a.K0.b() != null && this.a.K0.b().x()) {
                    this.a.K0.b().v(postWriteCallBackData);
                }
                this.a.F0.l(postWriteCallBackData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 implements FallingView.n {
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

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C5();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K.setTag(Boolean.FALSE);
                if (this.a.X0 == null) {
                    return;
                }
                this.a.X0.setAutoCompleteShown(false);
                if (this.a.X0.getVisibility() == 0) {
                    this.a.X0.setTag(this.a.K);
                    this.a.X0.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class t implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ ur4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, ur4Var};
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
            this.c = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
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
                this.d.M5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.F5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t1 implements gg<ImageView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                    if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = rn4.c().g();
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

    /* loaded from: classes4.dex */
    public class u implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ ur4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, ur4Var};
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
            this.b = ur4Var;
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.M5();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (absVideoPbFragment.C0 != null && absVideoPbFragment.K() != null && this.a.K().S1() != null && this.a.K().S1().d() != null) {
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    if (!absVideoPbFragment2.C0.checkPrivacyBeforeInvokeEditor(absVideoPbFragment2.K().S1().d().replyPrivateFlag)) {
                        return;
                    }
                }
                if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    this.a.I0.x0();
                    this.a.A3();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u1 implements gg<GifView> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
                if (rn4.c().g()) {
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
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = rn4.c().g();
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

    /* loaded from: classes4.dex */
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
                this.a.b0 = true;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.C3(false);
                this.a.T4();
                if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null || this.a.K().S1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.K().n2()).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("obj_locate", 1).param("uid", this.a.K().S1().O().getAuthor().getUserId()));
                if (this.a.x4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.K().getForumId());
                    statisticItem.param("tid", this.a.K().m2());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.O3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.N3());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v1 implements gg<View> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            ViewGroup.LayoutParams layoutParams = this.a.c0.getLayoutParams();
            layoutParams.height = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.c0.setLayoutParams(layoutParams);
            if (this.a.A4() && this.a.d != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.O1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.O1);
                }
                this.a.d.setLayoutParams(layoutParams2);
                this.a.e.setScrollable(true);
            }
            this.a.b5();
            if (this.a.L3() != null) {
                this.a.L3().D1();
            }
            if (this.a.K3() != null) {
                this.a.K3().U1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w1 implements gg<LinearLayout> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091847);
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

    /* loaded from: classes4.dex */
    public class x implements i45 {
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

        @Override // com.repackage.i45
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.i4();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x1 implements gg<RelativeLayout> {
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
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
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
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
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

    /* loaded from: classes4.dex */
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
                if (view2.getId() == R.id.obfuscated_res_0x7f091806) {
                    if (this.a.K() != null) {
                        this.a.K().R2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091ff2);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.obfuscated_res_0x7f091ff2, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.K().m2());
                    statisticItem2.param("fid", this.a.K().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.x4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.K().getForumId());
                        statisticItem3.param("tid", this.a.K().m2());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.O3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.N3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.a.b0) {
                        this.a.b0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.K() == null || this.a.K().S1() == null || this.a.L0 == null || postData.s() == null || postData.B() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.K0 != null) {
                                this.a.K0.c();
                            }
                            ut7 ut7Var = new ut7();
                            ut7Var.A(this.a.K().S1().l());
                            ut7Var.E(this.a.K().S1().O());
                            ut7Var.C(postData);
                            this.a.L0.V(ut7Var);
                            this.a.L0.setPostId(postData.K());
                            this.a.H4(view2, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            h08.b(this.a.K().S1(), postData, postData.b0, 8, 1);
                            if (this.a.I0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.k5(absVideoPbFragment.I0.C());
                            }
                        }
                    }
                } else {
                    if (view2.getId() != R.id.obfuscated_res_0x7f09185f || this.a.getPageContext().getPageActivity() == null || this.a.K() == null || this.a.a == null || this.a.a.getIntent() == null) {
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
                    if ((this.a.A4() && this.a.b4() != null && this.a.b4().N1() != null && view2 == this.a.b4().N1()) || ((this.a.K3() != null && this.a.K3().P1() != null && view2 == this.a.K3().P1()) || view2.getId() == R.id.obfuscated_res_0x7f091808)) {
                        if (!this.a.L && this.a.K().N2(true)) {
                            this.a.L = true;
                            if (this.a.A4()) {
                                if (this.a.b4() != null) {
                                    this.a.b4().b2();
                                    return;
                                }
                                return;
                            } else if (this.a.K3() != null) {
                                this.a.K3().i2();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    g18 g18Var = this.a.N;
                    if (g18Var != null && g18Var.Q() != null && view2 == this.a.N.Q().l()) {
                        this.a.N.I();
                        return;
                    }
                    g18 g18Var2 = this.a.N;
                    if ((g18Var2 == null || ((g18Var2.Q() == null || view2 != this.a.N.Q().p()) && view2.getId() != R.id.obfuscated_res_0x7f091749 && view2.getId() != R.id.obfuscated_res_0x7f090267)) && view2.getId() != R.id.obfuscated_res_0x7f0909f4 && view2.getId() != R.id.obfuscated_res_0x7f091bb4) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view2 == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.K() == null || this.a.K().S1() == null) {
                                return;
                            }
                            if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.K().S1().m());
                                statisticItem5.param("tid", this.a.K().m2());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            qi.x(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (ge5.a()) {
                                return;
                            }
                            if (this.a.K() != null && this.a.K().S1() != null) {
                                ArrayList<PostData> F = this.a.K().S1().F();
                                if ((F == null || F.size() <= 0) && this.a.K().k2()) {
                                    qi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddd));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.K().m2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.K().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            qi.N(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddd));
                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().r()) {
                            if (this.a.K() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (oi.z()) {
                                this.a.L5();
                                this.a.r5();
                                this.a.K().F3(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                        } else {
                            g18 g18Var3 = this.a.N;
                            if (g18Var3 != null && g18Var3.Q() != null && view2 == this.a.N.Q().p()) {
                                this.a.N.I();
                                return;
                            }
                            g18 g18Var4 = this.a.N;
                            if (g18Var4 != null && ((g18Var4.Q() != null && view2 == this.a.N.Q().x()) || view2.getId() == R.id.obfuscated_res_0x7f091845 || view2.getId() == R.id.obfuscated_res_0x7f091843)) {
                                this.a.N.F();
                                if (oi.z()) {
                                    if (!this.a.L) {
                                        this.a.L5();
                                        this.a.r5();
                                        this.a.N.K0(view2);
                                        return;
                                    }
                                    view2.setTag(Integer.valueOf(this.a.K().i2()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                return;
                            }
                            g18 g18Var5 = this.a.N;
                            if (g18Var5 != null && g18Var5.Q() != null && view2 == this.a.N.Q().w()) {
                                if (this.a.K() == null || this.a.K().S1() == null || this.a.K().S1().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.K().S1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d1) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                g18 g18Var6 = this.a.N;
                                if (g18Var6 != null) {
                                    g18Var6.x0(sparseArray);
                                }
                            } else {
                                g18 g18Var7 = this.a.N;
                                int i4 = 4;
                                if (g18Var7 != null && g18Var7.Q() != null && view2 == this.a.N.Q().u()) {
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
                                g18 g18Var8 = this.a.N;
                                if (g18Var8 != null && g18Var8.Q() != null && view2 == this.a.N.Q().v()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.H0(absVideoPbFragment4.F1);
                                    return;
                                }
                                g18 g18Var9 = this.a.N;
                                if (g18Var9 != null && g18Var9.Q() != null && view2 == this.a.N.Q().o()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.K().m2())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                g18 g18Var10 = this.a.N;
                                if (g18Var10 != null && (view2 == g18Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().s() || view2 == this.a.N.Q().t())))) {
                                    if (!oi.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                        return;
                                    } else if ((this.a.K() == null && this.a.K().S1() == null) || this.a.T.S()) {
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
                                        this.a.T.W(id, name, id2, i4, this.a.N.N());
                                        return;
                                    }
                                }
                                g18 g18Var11 = this.a.N;
                                if (g18Var11 != null && g18Var11.Q() != null && view2 == this.a.N.Q().n()) {
                                    if (this.a.K() == null) {
                                        return;
                                    }
                                    if (!oi.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> T3 = absVideoPbFragment5.T3(absVideoPbFragment5.K().S1(), this.a.K().k2(), 1);
                                    if (T3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.K().S1().l().getId(), this.a.K().S1().l().getName(), this.a.K().S1().O().getId(), String.valueOf(this.a.K().S1().V().getUserId()), (String) T3.get(R.id.obfuscated_res_0x7f091ff5), (String) T3.get(R.id.obfuscated_res_0x7f091ff6), (String) T3.get(R.id.obfuscated_res_0x7f091ff8), (String) T3.get(R.id.obfuscated_res_0x7f091ff7))));
                                    return;
                                }
                                g18 g18Var12 = this.a.N;
                                if (g18Var12 != null && g18Var12.Q() != null && view2 == this.a.N.Q().j()) {
                                    if (!oi.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> T32 = absVideoPbFragment6.T3(absVideoPbFragment6.K().S1(), this.a.K().k2(), 1);
                                    if (T32 != null) {
                                        this.a.N.j0(((Integer) T32.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) T32.get(R.id.obfuscated_res_0x7f091fea), ((Integer) T32.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) T32.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
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
                                g18 g18Var13 = this.a.N;
                                if (g18Var13 != null && g18Var13.Q() != null && view2 == this.a.N.Q().m()) {
                                    if (this.a.K() == null) {
                                        return;
                                    }
                                    if (!oi.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> T33 = absVideoPbFragment7.T3(absVideoPbFragment7.K().S1(), this.a.K().k2(), 1);
                                    if (T33 != null) {
                                        if (StringUtils.isNull((String) T33.get(R.id.obfuscated_res_0x7f091fe9))) {
                                            this.a.N.g0(((Integer) T33.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) T33.get(R.id.obfuscated_res_0x7f091fea), ((Integer) T33.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) T33.get(R.id.obfuscated_res_0x7f091feb)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) T33.get(R.id.obfuscated_res_0x7f091fec)).intValue(), (String) T33.get(R.id.obfuscated_res_0x7f091fea), ((Integer) T33.get(R.id.obfuscated_res_0x7f092008)).intValue(), ((Boolean) T33.get(R.id.obfuscated_res_0x7f091feb)).booleanValue(), (String) T33.get(R.id.obfuscated_res_0x7f091fe9));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091f4a && view2.getId() != R.id.obfuscated_res_0x7f091f48 && view2.getId() != R.id.obfuscated_res_0x7f0917d3 && view2.getId() != R.id.obfuscated_res_0x7f091668 && view2.getId() != R.id.obfuscated_res_0x7f091835) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f091833 && view2.getId() != R.id.obfuscated_res_0x7f091a01 && view2.getId() != R.id.obfuscated_res_0x7f0917cd) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f0917be && view2.getId() != R.id.obfuscated_res_0x7f09065d) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0917c3) {
                                                this.a.e4(true);
                                                return;
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f0917c0 && view2.getId() != R.id.obfuscated_res_0x7f09213e) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f092379) {
                                                    if (this.a.R0 >= 0) {
                                                        if (this.a.K() != null) {
                                                            this.a.K().m3();
                                                        }
                                                        if (this.a.A4() && this.a.K() != null && this.a.b4() != null && this.a.b4().r1() != null) {
                                                            this.a.b4().r1().f(this.a.K().S1());
                                                        } else if (this.a.K3() != null && this.a.K3().r1() != null) {
                                                            this.a.K3().r1().r(this.a.K().S1());
                                                        }
                                                        this.a.R0 = 0;
                                                        this.a.S0 = Integer.MIN_VALUE;
                                                        if (this.a.A4() && this.a.K() != null && this.a.b4() != null) {
                                                            this.a.b4().X1(this.a.K().L1(), this.a.K().K1());
                                                            this.a.K().q3(0, 0);
                                                            return;
                                                        } else if (this.a.K() == null || this.a.K3() == null) {
                                                            return;
                                                        } else {
                                                            this.a.K3().d2(this.a.K().L1(), this.a.K().K1());
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
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0917fd) {
                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1368);
                                                        String q = ru4.k().q("tail_link", "");
                                                        if (!StringUtils.isNull(q)) {
                                                            TiebaStatic.log("c10056");
                                                            jm4.s(view2.getContext(), string, q, true, true, true);
                                                        }
                                                        this.a.b5();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091020) {
                                                    this.a.b5();
                                                    return;
                                                } else if (view2.getId() != R.id.obfuscated_res_0x7f09076e && view2.getId() != R.id.obfuscated_res_0x7f0909f1) {
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
                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0f0c);
                                                        if (this.a.K().S1() != null) {
                                                            this.a.t.d(3, 3, this.a.K().S1().Q());
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d5 || view2.getId() == R.id.obfuscated_res_0x7f09182d) {
                                                        StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                        statisticItem9.param("tid", this.a.K().m2());
                                                        statisticItem9.param("fid", this.a.K().getForumId());
                                                        statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem9.param("obj_locate", 7);
                                                        TiebaStatic.log(statisticItem9);
                                                        if (this.a.x4()) {
                                                            StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                            statisticItem10.param("fid", this.a.K().getForumId());
                                                            statisticItem10.param("tid", this.a.K().m2());
                                                            statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                            statisticItem10.param(str, this.a.O3());
                                                            statisticItem10.param("obj_source", 1);
                                                            statisticItem10.param("obj_type", 2);
                                                            statisticItem10.param("obj_locate", this.a.N3());
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
                                                    if (sparseArray2 == null || !(sparseArray2.get(R.id.obfuscated_res_0x7f092005) instanceof PostData)) {
                                                        return;
                                                    }
                                                    PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f092005);
                                                    View view3 = (View) sparseArray2.get(R.id.obfuscated_res_0x7f092007);
                                                    if (postData2 == null || view3 == null) {
                                                        return;
                                                    }
                                                    ImageView imageView = (ImageView) view3.findViewById(R.id.obfuscated_res_0x7f09076f);
                                                    EMTextView eMTextView = (EMTextView) view3.findViewById(R.id.obfuscated_res_0x7f090770);
                                                    View findViewById = view3.findViewById(R.id.obfuscated_res_0x7f0909f1);
                                                    if (postData2.p0()) {
                                                        postData2.P0(false);
                                                        jz7.e(postData2);
                                                    } else {
                                                        if (this.a.K() != null ? jz7.c(this.a.K().S1(), postData2) : false) {
                                                            postData2.P0(true);
                                                            findViewById.setVisibility(0);
                                                        }
                                                    }
                                                    SkinManager.setBackgroundColor(findViewById, postData2.p0() ? R.color.CAM_X0201 : R.color.transparent);
                                                    SkinManager.setViewTextColor(eMTextView, postData2.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107);
                                                    WebPManager.setPureDrawable(imageView, postData2.p0() ? R.drawable.obfuscated_res_0x7f080965 : R.drawable.obfuscated_res_0x7f080964, postData2.p0() ? R.color.CAM_X0304 : R.color.CAM_X0107, null);
                                                    return;
                                                }
                                            } else {
                                                String str3 = str;
                                                if (this.a.K() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.K().S1() == null || this.a.K().S1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    et7 S1 = this.a.K().S1();
                                                    int reply_num = S1.O().getReply_num();
                                                    int currentItem = this.a.e.getCurrentItem();
                                                    if (reply_num == 0) {
                                                        if (this.a.A4() && currentItem == 0) {
                                                            this.a.e.setCurrentItem(1);
                                                        }
                                                        this.a.C3(false);
                                                        this.a.T4();
                                                        return;
                                                    }
                                                    if (this.a.A4() && currentItem == 0) {
                                                        this.a.e.setCurrentItem(1);
                                                        str2 = "obj_source";
                                                    } else if ((this.a.A4() && this.a.b4() == null) || this.a.K3() == null || this.a.a4() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (qi.i(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView a4 = this.a.a4();
                                                        if (a4 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = a4.canScrollVertically(1);
                                                        boolean canScrollVertically2 = a4.canScrollVertically(-1);
                                                        AppBarLayout appBarLayout = this.a.i;
                                                        str2 = "obj_source";
                                                        if (appBarLayout != null) {
                                                            appBarLayout.setExpanded(false, true);
                                                        }
                                                        if (a4.getLayoutManager() == null || !(a4.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) a4.getLayoutManager();
                                                        if (!canScrollVertically2 && canScrollVertically) {
                                                            if (this.a.P0 == -1 && this.a.Q0 == Integer.MIN_VALUE) {
                                                                return;
                                                            }
                                                            if (this.a.P0 <= 3 && (this.a.P0 != 3 || this.a.Q0 >= (-i6))) {
                                                                if (this.a.P0 < 2) {
                                                                    if (this.a.P0 != 1) {
                                                                        a4.smoothScrollBy(0, -this.a.Q0);
                                                                    } else {
                                                                        int i7 = i6 / 4;
                                                                        linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i7);
                                                                        a4.smoothScrollBy(0, i7);
                                                                    }
                                                                } else {
                                                                    int i8 = i6 / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i8);
                                                                    a4.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i6);
                                                                a4.smoothScrollBy(0, i6);
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        } else {
                                                            int firstVisiblePosition = a4.getFirstVisiblePosition();
                                                            View childAt = a4.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.P0 = firstVisiblePosition;
                                                            this.a.Q0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i6) || a4.getCount() < 6)) {
                                                                a4.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                a4.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        }
                                                        TiebaStatic.log(param);
                                                        o95 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
                                                    if (this.a.x4()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.K().getForumId());
                                                        statisticItem12.param("tid", this.a.K().m2());
                                                        statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem12.param(str3, this.a.O3());
                                                        statisticItem12.param(str2, 1);
                                                        statisticItem12.param("obj_type", 12);
                                                        statisticItem12.param("obj_locate", this.a.N3());
                                                        TiebaStatic.log(statisticItem12);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        String str4 = str;
                                        if (!oi.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.K() == null) {
                                            return;
                                        }
                                        if (this.a.A4() && this.a.b4() == null) {
                                            return;
                                        }
                                        if (this.a.A4() || this.a.K3() != null) {
                                            this.a.N.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f0917be || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.r3(11009) || this.a.K() == null) {
                                                    return;
                                                }
                                                this.a.J4();
                                                if (this.a.K().S1() != null && this.a.K().S1().O() != null && this.a.K().S1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.K().m2()).param("fid", this.a.K().S1().m()).param("obj_locate", 3).param("uid", this.a.K().S1().O().getAuthor().getUserId()));
                                                    if (this.a.x4()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.K().getForumId());
                                                        statisticItem13.param("tid", this.a.K().m2());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.O3());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.N3());
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
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091833) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.K().m2());
                                        statisticItem14.param("fid", this.a.K().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091a01) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091833 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        if (sparseArray3.get(R.id.obfuscated_res_0x7f092005) instanceof PostData) {
                                            PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f092005);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091833 && (statisticItem = postData3.c0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091a01 || view2.getId() == R.id.obfuscated_res_0x7f0917cd) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.K().n2()).param("fid", this.a.K().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData3.K()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.K() == null || this.a.K().S1() == null || this.a.L0 == null || postData3.s() == null || postData3.B() == 1) {
                                                return;
                                            }
                                            if (this.a.K0 != null) {
                                                this.a.K0.c();
                                            }
                                            if (this.a.U0 && postData3.Y() != null && postData3.Y().size() != 0) {
                                                this.a.J5(postData3, null, true, false);
                                                return;
                                            }
                                            ut7 ut7Var2 = new ut7();
                                            ut7Var2.A(this.a.K().S1().l());
                                            ut7Var2.E(this.a.K().S1().O());
                                            ut7Var2.C(postData3);
                                            this.a.L0.V(ut7Var2);
                                            this.a.L0.setPostId(postData3.K());
                                            this.a.H4(view2, postData3.s().getUserId(), "", postData3);
                                            if (this.a.I0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.k5(absVideoPbFragment11.I0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.K().m2());
                                        statisticItem15.param("fid", this.a.K().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.x4()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.K().getForumId());
                                            statisticItem16.param("tid", this.a.K().m2());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.O3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.N3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view2.getId() == R.id.obfuscated_res_0x7f0917d3 || view2.getId() == R.id.obfuscated_res_0x7f091835) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view2;
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0917d3 && this.a.x4()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.K().getForumId());
                                        statisticItem17.param("tid", this.a.K().m2());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.O3());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.N3());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.K().S1().m()));
                                    } else if (this.a.K() == null || this.a.K().S1() == null) {
                                    } else {
                                        g18 g18Var14 = this.a.N;
                                        if (g18Var14 != null) {
                                            g18Var14.F();
                                        }
                                        SparseArray sparseArray4 = (SparseArray) view2.getTag();
                                        PostData postData4 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f092005);
                                        PostData postData5 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f092006);
                                        if (postData4 == null) {
                                            return;
                                        }
                                        if (postData4.F() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData4.c0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091668) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0917d3) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.L5();
                                        TiebaStatic.log("c11742");
                                        if (postData5 != null) {
                                            this.a.J5(postData4, postData5, false, true);
                                        } else {
                                            this.a.J5(postData4, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!oi.z()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c3e);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.L5();
                            this.a.r5();
                            if (view2.getId() == R.id.obfuscated_res_0x7f091749) {
                                K3 = this.a.K().K3(true, this.a.O3());
                            } else {
                                K3 = view2.getId() == R.id.obfuscated_res_0x7f090267 ? this.a.K().K3(false, this.a.O3()) : this.a.K().J3(this.a.O3());
                            }
                            view2.setTag(Boolean.valueOf(K3));
                            if (K3) {
                                this.a.B5();
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

    /* loaded from: classes4.dex */
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
                this.a.b5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y1 implements h45 {
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

        @Override // com.repackage.h45
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                px7 px7Var = this.a.F0;
                if (px7Var == null || px7Var.e() == null || !this.a.F0.e().d()) {
                    return !this.a.t3(ReplyPrivacyCheckController.TYPE_THREAD);
                }
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.showToast(absVideoPbFragment.F0.e().c());
                if (this.a.I0 != null && (this.a.I0.B() || this.a.I0.D())) {
                    this.a.I0.z(false, this.a.F0.h());
                }
                this.a.F0.a(true);
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class z extends cf5<ShareItem> {
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
        @Override // com.repackage.cf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel K = this.b.K();
                if (K != null) {
                    K.t3(this.a);
                }
                return gz7.d(this.b.J3(), 2, K);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.L0.Q(postData);
                if (this.a.K3() != null) {
                    this.a.K3().U1();
                } else if (this.a.A4() && this.a.b4() != null) {
                    this.a.b4().R1();
                }
                this.a.K0.c();
                this.a.J0.q();
                this.a.y5(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z1 implements Comparator<z05> {
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
        public int compare(z05 z05Var, z05 z05Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, z05Var, z05Var2)) == null) ? z05Var.compareTo(z05Var2) : invokeLL.intValue;
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
        N1 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        O1 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
        P1 = 3;
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
        this.S = null;
        this.T = null;
        this.b0 = false;
        this.e0 = null;
        this.h0 = null;
        this.w0 = false;
        this.x0 = null;
        this.y0 = false;
        this.z0 = false;
        this.A0 = false;
        this.B0 = false;
        this.N0 = new int[2];
        this.P0 = -1;
        this.Q0 = Integer.MIN_VALUE;
        this.R0 = 0;
        this.S0 = Integer.MIN_VALUE;
        this.T0 = false;
        this.U0 = UbsABTestHelper.showTrisectionAndFeedback();
        this.V0 = new v(this);
        this.Y0 = new c1(this);
        this.Z0 = new n1(this);
        this.a1 = new y1(this);
        this.b1 = new a2(this, 2004016);
        this.c1 = new b2(this, 2004007);
        this.d1 = new a(this, 2921391);
        this.e1 = new b(this, 2016450);
        this.f1 = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
        this.g1 = new d(this, 2001426);
        this.h1 = new e(this, 2001427);
        this.i1 = new f(this, 2001428);
        this.j1 = new g(this);
        this.k1 = new h(this);
        this.l1 = new i(this);
        this.m1 = new j(this, 2004008);
        this.n1 = 0;
        this.r1 = true;
        this.s1 = new l(this);
        this.u1 = new m(this);
        this.v1 = new n(this);
        this.y1 = new o(this);
        this.z1 = new p(this);
        this.A1 = new q(this);
        this.B1 = new s(this);
        this.C1 = new x(this);
        this.D1 = new y(this);
        this.E1 = new b0(this);
        this.F1 = new c0(this);
        this.G1 = new d0(this, 2001332);
        this.H1 = new e0(this, 2016528);
        this.I1 = new o0(this, 2001440);
        this.J1 = new p0(this);
        this.K1 = new w0(this, 2921509);
        this.L1 = new a1(this);
        this.M1 = new b1(this);
        this.u0 = new c2(this, null);
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (x4() || K() == null || !K().I2()) ? false : true : invokeV.booleanValue;
    }

    public final void A5(et7 et7Var) {
        j18 G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, et7Var) == null) || (G = et7Var.G()) == null || G.l) {
            return;
        }
        n3(G);
    }

    @Override // com.repackage.s08
    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            l18 l18Var = this.k;
            return l18Var != null && l18Var.M0();
        }
        return invokeV.booleanValue;
    }

    public void B5() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // com.repackage.ji5
    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.s08
    public PbModel.h C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Y0 : (PbModel.h) invokeV.objValue;
    }

    public void C3(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) || (appBarLayout = this.i) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public boolean C4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.r1 : invokeV.booleanValue;
    }

    public final void C5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            FallingView fallingView = this.K;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.K) {
                this.X0.setTag(null);
                this.X0.setAutoCompleteShown(true);
                this.X0.d();
            }
        }
    }

    public final void D3(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048588, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04b0);
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                ur4 ur4Var = new ur4(getPageContext().getPageActivity());
                ur4Var.setMessage(string);
                ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ec, new r(this));
                ur4Var.setCancelable(true);
                ur4Var.create(getPageContext());
                ur4Var.show();
            } else {
                E3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> F = K().S1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).K())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    K().S1().O().setReply_num(K().S1().O().getReply_num() - 1);
                    if (K3() != null) {
                        K3().U1();
                    } else if (A4() && b4() != null) {
                        b4().R1();
                    }
                } else if (i3 == 0) {
                    v3();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = K().S1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).Y().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).Y().get(i5).K())) {
                                F2.get(i4).Y().remove(i5);
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
                        if (K3() != null) {
                            K3().U1();
                        } else if (A4() && b4() != null) {
                            b4().R1();
                        }
                    }
                    w3(bVar);
                }
            }
        }
    }

    public boolean D4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            l18 l18Var = this.k;
            if (l18Var == null) {
                return false;
            }
            return l18Var.N0();
        }
        return invokeV.booleanValue;
    }

    public final void D5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            k18.c(P(), J3(), i2);
        }
    }

    public void E3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f121c));
            } else if (z3) {
                if (pi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c3d);
                }
                showToast(str);
            }
        }
    }

    public final void E4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || K() == null || pi.isEmpty(K().m2())) {
            return;
        }
        dj4.w().P(cj4.Z, og.g(K().m2(), 0L));
    }

    @Override // com.repackage.ji5
    public void F(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.b0 = true;
        }
    }

    public final void F3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048595, this, i2, gVar) == null) || gVar == null || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        E3(this.T.getLoadDataMode(), gVar.a, gVar.b, false);
        if (gVar.a) {
            this.y0 = true;
            if (i2 == 2 || i2 == 3) {
                this.z0 = true;
                this.A0 = false;
            } else if (i2 == 4 || i2 == 5) {
                this.z0 = false;
                this.A0 = true;
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
                string = getString(R.string.obfuscated_res_0x7f0f0d05);
            }
            qi.N(getPageContext().getPageActivity(), string);
        }
        if (A4()) {
            if (K().S1().O() == null || L3() == null) {
                return;
            }
            L3().K1();
        } else if (K().S1().O() == null || K3() == null) {
        } else {
            K3().b2();
        }
    }

    public /* synthetic */ void F4() {
        String c4;
        if (K() != null && K().A2()) {
            c4 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0ded);
        } else {
            c4 = c4();
        }
        if (!StringUtils.isNull(c4) && K() != null && K().S1() != null) {
            c4 = TbSingleton.getInstance().getAdVertiComment(K().S1().n0(), K().S1().o0(), c4);
        }
        k45 k45Var = this.I0;
        if (k45Var != null) {
            k45Var.m0(c4);
        }
        TextView textView = this.h0;
        if (textView != null) {
            textView.setText(c4);
        }
        y5(false);
        C5();
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            P5();
        }
    }

    public final String G3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0dc5);
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

    public final void G4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.g0 == null) {
            return;
        }
        B3();
        this.g0.setImageResource(R.drawable.obfuscated_res_0x7f08099c);
    }

    public final void G5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.v.setAlpha(0.0f);
            this.v.setVisibility(0);
            R5(layoutParams);
        }
    }

    @Override // com.repackage.ji5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            sx7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.b0 = true;
        }
    }

    public pz4 H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.S : (pz4) invokeV.objValue;
    }

    public final void H4(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048603, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || q3() || !s3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.N0);
            this.O0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.K0 != null && postData != null) {
            this.K0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fed), postData.s().getName_show(), postData.V() != null ? postData.V().toString() : ""));
        }
        if (K() != null && K().S1() != null && K().S1().i0()) {
            rg.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.E0 == null) {
            qo6 qo6Var = new qo6(getPageContext());
            this.E0 = qo6Var;
            qo6Var.j(1);
            this.E0.i(new j1(this, str, str2));
        }
        if (K() == null || K().S1() == null || K().S1().l() == null) {
            return;
        }
        this.E0.g(K().S1().l().getId(), og.g(K().m2(), 0L));
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.x1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 1.0f, 0.0f);
                this.x1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.x1.start();
        }
    }

    public LinearLayout I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f0 : (LinearLayout) invokeV.objValue;
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || K() == null) {
            return;
        }
        et7 S1 = K().S1();
        K().H3(true);
        bm4 bm4Var = this.P;
        if (bm4Var != null) {
            S1.H0(bm4Var.g());
        }
        if (A4()) {
            if (L3() != null) {
                L3().D1();
            }
            if (b4() != null) {
                b4().R1();
            }
        } else if (K3() != null) {
            K3().U1();
        }
    }

    public final void I5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.w1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, Key.ALPHA, 0.0f, 1.0f);
                this.w1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.w1.start();
        }
    }

    public final int J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (K() == null || K().S1() == null || K().S1().O() == null) {
                return -1;
            }
            return K().S1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void J4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || K() == null || K().S1() == null) {
            return;
        }
        if (A4() && b4() == null) {
            return;
        }
        if ((A4() || K3() != null) && this.P != null) {
            MarkData markData = null;
            if (K().S1() != null && K().S1().i0()) {
                markData = K().i1(0);
            } else {
                CustomViewPager customViewPager = this.e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = K().M1(M3(K().S1()));
                } else if (A4()) {
                    if (b4() != null) {
                        markData = K().i1(b4().K1());
                    }
                } else if (K3() != null) {
                    markData = K().i1(K3().M1());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && b4() != null && (markData = K().i1(b4().K1() + 1)) == null) {
                return;
            }
            r5();
            this.P.i(markData);
            if (!this.P.e()) {
                if (K() != null && !gz7.k(K().m2())) {
                    this.r0.o(2);
                    gz7.b(K().m2());
                }
                this.P.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.P.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void J5(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        boolean z4;
        PostData M3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String m2 = K().m2();
            String K = postData.K();
            String K2 = postData2 != null ? postData2.K() : "";
            int W = K().S1() != null ? K().S1().W() : 0;
            if (b4() != null && b4().P1() != null) {
                n2 = b4().P1().n(K);
            } else if (K3() == null || K3().R1() == null) {
                return;
            } else {
                n2 = K3().R1().n(K);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || K() == null || K().S1() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(m2, K, "pb", true, x4(), null, false, K2, W, postData.b0(), K().S1().d(), false, postData.s().getIconInfo(), N3(), N3() == 1 || N3() == 2 || N3() == 3 || N3() == 4 || N3() == 5).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(K2);
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
            if (K() != null && (M3 = M3(K().S1())) != null) {
                if (!M3.Q && !postData.Q) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (x4() && this.a.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    @Override // com.repackage.s08
    public PbModel K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a.b1() : (PbModel) invokeV.objValue;
    }

    public DetailInfoAndReplyFragment K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final boolean K4(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = ru4.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    jm4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f053d), q2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void K5() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.F();
    }

    @Override // com.repackage.ji5
    public fg<RelativeLayout> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            fg<RelativeLayout> fgVar = new fg<>(new x1(this), 10, 0);
            this.a0 = fgVar;
            return fgVar;
        }
        return (fg) invokeV.objValue;
    }

    public DetailInfoFragment L3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public boolean L4(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        l18 l18Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
            if (!this.q1 && (this.r1 || B4())) {
                H5();
                UtilHelper.hideStatusBar(P(), P().getRootView());
                this.r1 = false;
                l18 l18Var2 = this.k;
                if (l18Var2 != null) {
                    l18Var2.S0(false);
                }
            }
            if (i2 == 4) {
                l18 l18Var3 = this.k;
                if (l18Var3 != null) {
                    return l18Var3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                l18 l18Var4 = this.k;
                if (l18Var4 != null) {
                    return l18Var4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (l18Var = this.k) == null) {
                return false;
            } else {
                return l18Var.P0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final void L5() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || (voiceManager = this.U) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public PostData M3(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, et7Var)) == null) {
            PostData postData = null;
            if (et7Var == null) {
                return null;
            }
            if (et7Var.X() != null) {
                return et7Var.X();
            }
            if (!ListUtils.isEmpty(et7Var.F())) {
                Iterator<PostData> it = et7Var.F().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        postData = next;
                        break;
                    }
                }
            }
            if (postData == null) {
                postData = et7Var.j();
            }
            if (postData == null) {
                postData = Z3(et7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void M4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) {
            this.h.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void M5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.q1();
    }

    @Override // com.repackage.ji5
    public fg<ImageView> N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.X == null) {
                this.X = new fg<>(new t1(this), 8, 0);
            }
            return this.X;
        }
        return (fg) invokeV.objValue;
    }

    public abstract int N3();

    public final void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (!oi.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3e);
            } else if (this.N == null || K() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                L5();
                r5();
                if (K().loadData()) {
                    B5();
                }
            }
        }
    }

    public final boolean N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (K() == null) {
                return true;
            }
            if (K().S1() == null || !K().S1().i0()) {
                if (K().D1()) {
                    MarkData o12 = K().o1();
                    if (o12 != null && K().B1() && a4() != null) {
                        MarkData i12 = K().i1(a4().getFirstVisiblePosition());
                        if (i12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", o12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (i12.getPostId() != null && !i12.getPostId().equals(o12.getPostId())) {
                            ur4 ur4Var = new ur4(getBaseFragmentActivity());
                            ur4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f0264));
                            ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0431, new t(this, i12, o12, ur4Var));
                            ur4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0370, new u(this, o12, ur4Var));
                            ur4Var.setOnCalcelListener(new w(this));
                            ur4Var.create(getBaseFragmentActivity().getPageContext());
                            ur4Var.show();
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

    @Override // com.repackage.ji5
    public fg<View> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (this.Y == null) {
                this.Y = new fg<>(new v1(this), 8, 0);
            }
            return this.Y;
        }
        return (fg) invokeV.objValue;
    }

    public final String O3() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (K() == null || K().S1() == null || K().S1().F() == null || (count = ListUtils.getCount((F = K().S1().F()))) == 0) {
                return "";
            }
            if (K().d2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        return next.K();
                    }
                }
            }
            int i2 = 0;
            if (a4() != null) {
                if (A4()) {
                    if (b4() != null) {
                        i2 = b4().I1();
                    }
                } else if (K3() != null) {
                    i2 = K3().K1();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(F, i2);
            if (postData != null && postData.s() != null) {
                if (K().K2(postData.s().getUserId())) {
                    return postData.K();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (K().K2(postData2.s().getUserId())) {
                        return postData2.K();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (K().K2(postData3.s().getUserId())) {
                        return postData3.K();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void O4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048628, this, i2) == null) {
            if (i2 == 0) {
                cj8.g().h(getUniqueId(), false);
                if (a4() != null) {
                    p3(a4(), true);
                }
            }
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.X0;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.X0;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 != 2 || (rightFloatLayerView = this.X0) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public void O5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            k45 k45Var = this.I0;
            if (k45Var != null) {
                k5(k45Var.C());
            }
            b5();
            this.N.F();
        }
    }

    @Override // com.repackage.s08
    public AbsPbActivity P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public abstract int P3();

    public void P4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) || P() == null) {
            return;
        }
        if (this.r1 && !TbSingleton.getInstance().isNotchScreen(P()) && !TbSingleton.getInstance().isCutoutScreen(P())) {
            H5();
            UtilHelper.hideStatusBar(P(), P().getRootView());
            this.r1 = false;
        }
        this.u0.b = z2;
        R4();
        U4();
    }

    public final void P5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
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

    @Override // com.repackage.ji5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048634, this, context, str) == null) {
        }
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void Q4(z05 z05Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048636, this, z05Var, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.D(z05Var, getPageContext(), i2, false);
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    @Override // com.repackage.ji5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048638, this, context, str, z2) == null) {
            if (sx7.c(str) && K() != null && K().m2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", K().m2()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    s15 s15Var = new s15();
                    s15Var.a = str;
                    s15Var.b = 3;
                    s15Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, s15Var));
                }
            } else {
                sx7.a().e(getPageContext(), str);
            }
            this.b0 = true;
        }
    }

    public View.OnClickListener R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.D1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.u0.a()) {
            this.k.X(false);
            return;
        }
        l18 l18Var = this.k;
        if (!x4() && !this.k.N0()) {
            z2 = true;
        }
        l18Var.X(z2);
    }

    public final void R5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, layoutParams) == null) {
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

    public View.OnClickListener S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.E1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void S4(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, et7Var) == null) || et7Var == null) {
            return;
        }
        ThreadData O = et7Var.O();
        if (O != null && O.isUgcThreadType()) {
            o3();
        } else {
            o5(this.H0);
        }
        k45 k45Var = this.I0;
        if (k45Var != null) {
            k5(k45Var.C());
            this.I0.N(et7Var.d());
            this.I0.O(et7Var.l(), et7Var.V());
            this.I0.u0(O);
            if (K() != null) {
                this.I0.P(K().u1(), K().m2(), K().q1());
            }
            if (O != null) {
                this.I0.j0(O.isMutiForumThread());
            }
        }
    }

    public final void S5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, layoutParams) == null) {
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

    public SparseArray<Object> T3(et7 et7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData M3;
        kp4 kp4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048645, this, new Object[]{et7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (et7Var == null || (M3 = M3(et7Var)) == null) {
                return null;
            }
            String userId = M3.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091fea, M3.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(et7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
            } else if (i2 == 1) {
                if (M3.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff5, M3.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff6, M3.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff7, M3.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff8, M3.K());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091fea, M3.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(et7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
            }
            if (!z3) {
                List<er4> p2 = et7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (er4 er4Var : p2) {
                        if (er4Var != null && !StringUtils.isNull(er4Var.c()) && (kp4Var = er4Var.g) != null && kp4Var.a && !kp4Var.c && ((i3 = kp4Var.b) == 1 || i3 == 2)) {
                            sb.append(pi.cutString(er4Var.c(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f065a));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091fe9, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a3), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void T4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || !checkUpIsLogin() || K() == null || K().S1() == null || K().S1().l() == null || q3()) {
            return;
        }
        if (K().S1().i0()) {
            u3();
            return;
        }
        if (this.D0 == null) {
            qo6 qo6Var = new qo6(getPageContext());
            this.D0 = qo6Var;
            qo6Var.j(0);
            this.D0.i(new d1(this));
        }
        this.D0.g(K().S1().l().getId(), og.g(K().m2(), 0L));
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || K() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.E(K().getForumId()) || K().S1() == null || K().S1().l() == null) {
            return;
        }
        if (K().S1().l().isLike() == 1) {
            K().f1().D(K().getForumId(), K().m2());
        }
    }

    public bm4 U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.P : (bm4) invokeV.objValue;
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048649, this) == null) || this.k == null || this.e == null) {
            return;
        }
        boolean z2 = false;
        if (!A4()) {
            this.k.R0(false);
        } else if (this.e.getCurrentItem() != 0) {
            this.k.R0(false);
        } else if (this.u0.a()) {
            this.k.R0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.k.R0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public void U5(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, et7Var) == null) {
            if (et7Var != null && AntiHelper.o(et7Var.O())) {
                w18 w18Var = this.r0;
                if (w18Var != null) {
                    w18Var.l(false);
                    this.r0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.q0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080963, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            w18 w18Var2 = this.r0;
            if (w18Var2 == null || !w18Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.q0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080963, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.repackage.ji5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048651, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.q0(str);
        wr4 R = this.N.R();
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
        this.b0 = true;
    }

    public View.OnLongClickListener V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.L1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void V4(boolean z2, int i2, int i3, int i4, et7 et7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), et7Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof r08) {
                    ((r08) baseFragment).h1(z2, i2, i3, i4, et7Var, str, i5);
                }
            }
            h1(z2, i2, i3, i4, et7Var, str, i5);
        }
    }

    public void V5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z2) == null) {
            DetailInfoAndReplyFragment K3 = K3();
            if (K3 != null && K3.r1() != null && K3.r1().f() != null && K3.r1().g() != null) {
                K3.r1().f().t0(z2);
                K3.r1().g().F(z2);
            }
            MaskView maskView = this.A;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public View.OnTouchListener W3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.z1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void W4(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048656, this, et7Var) == null) || et7Var == null || et7Var.O() == null) {
            return;
        }
        U5(et7Var);
        this.j0.setVisibility(et7Var.i0() ? 8 : 0);
        if (et7Var.r()) {
            WebPManager.setPureDrawable(this.j0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.j0, R.drawable.obfuscated_res_0x7f08095e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String G3 = G3(et7Var.O().getReply_num());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(G3);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(G3);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, et7Var.O()));
    }

    public k45 X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.I0 : (k45) invokeV.objValue;
    }

    public void X4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048658, this, z2, markData) == null) || K() == null) {
            return;
        }
        q5();
        K().H3(z2);
        bm4 bm4Var = this.P;
        if (bm4Var != null) {
            bm4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (K().D1()) {
            I4();
        } else if (A4()) {
            if (L3() != null) {
                L3().D1();
            }
            if (b4() != null) {
                b4().R1();
            }
        } else if (K3() != null) {
            K3().U1();
        }
    }

    @Override // com.repackage.ji5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048659, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.b0 = true;
    }

    @Override // com.repackage.ji5
    public fg<TextView> Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.W == null) {
                this.W = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.W;
        }
        return (fg) invokeV.objValue;
    }

    public final int Y3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048661, this, i2)) == null) {
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

    public void Y4(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, et7Var) == null) || et7Var == null || et7Var.O() == null) {
            return;
        }
        String valueOf = String.valueOf(et7Var.O().getReply_num());
        if (et7Var.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.d.F(valueOf);
    }

    public final PostData Z3(et7 et7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, et7Var)) == null) {
            if (et7Var == null || et7Var.O() == null || et7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = et7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = et7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.C0(1);
            postData.I0(et7Var.O().getFirstPostId());
            postData.Z0(et7Var.O().getTitle());
            postData.Y0(et7Var.O().getCreateTime());
            postData.A0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void Z4(ut7 ut7Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, ut7Var) == null) || K() == null || K().S1() == null || ut7Var.i() == null) {
            return;
        }
        String K = ut7Var.i().K();
        ArrayList<PostData> F = K().S1().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.K() == null || !postData.K().equals(K)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = ut7Var.k();
                postData.W0(ut7Var.m());
                if (postData.Y() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.f0() != null && next != null && next.s() != null && (metaData = postData.f0().get(next.s().getUserId())) != null) {
                            next.A0(metaData);
                            next.M0(true);
                            next.f1(getPageContext(), K().K2(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.Y().size();
                    if (!postData.m0(true)) {
                        postData.Y().clear();
                        postData.Y().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.y() != null) {
                    postData.y0();
                }
            }
        }
        if (K().B1() || !z2) {
            return;
        }
        if (A4() && b4() != null) {
            b4().R1();
        } else if (K3() != null) {
            K3().U1();
        }
    }

    public BdTypeRecyclerView a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
            while (it.hasNext()) {
                BaseFragment next = it.next();
                if (next instanceof DetailInfoAndReplyFragment) {
                    return ((DetailInfoAndReplyFragment) next).N1();
                }
                if (next instanceof ReplyFragment) {
                    return ((ReplyFragment) next).L1();
                }
            }
            return null;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void a5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048666, this) == null) || this.I0 == null || this.J0 == null) {
            return;
        }
        g45.a().c(0);
        this.I0.U();
        this.I0.S();
        if (this.I0.y() != null) {
            this.I0.y().setMaxImagesAllowed(this.I0.v ? 1 : 9);
        }
        this.I0.n0(SendView.f);
        this.I0.j(SendView.f);
        o25 m2 = this.J0.m(23);
        o25 m3 = this.J0.m(2);
        o25 m4 = this.J0.m(5);
        if (m3 != null) {
            m3.display();
        }
        if (m4 != null) {
            m4.display();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.J0.invalidate();
    }

    public ReplyFragment b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f.b(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            a5();
            h4();
            this.K0.c();
            y5(false);
        }
    }

    public String c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (!pi.isEmpty(this.v0)) {
                return this.v0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(kx7.b());
            this.v0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public final void d4(int i2, Intent intent) {
        t25 t25Var;
        gw7 gw7Var;
        t25 t25Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048671, this, i2, intent) == null) {
            if (i2 == 0) {
                h4();
                gw7 gw7Var2 = this.K0;
                if (gw7Var2 != null) {
                    gw7Var2.c();
                }
                y5(false);
            }
            b5();
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
                    this.I0.T();
                    this.I0.w0(pbEditorData.getVoiceModel());
                    this.I0.G(writeData);
                    s25 n2 = this.I0.a().n(6);
                    if (n2 != null && (t25Var = n2.m) != null) {
                        t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.I0.M(null, null);
                    }
                } else if (editorType != 1 || (gw7Var = this.K0) == null || gw7Var.b() == null) {
                } else {
                    o45 b3 = this.K0.b();
                    b3.c0(K().S1().O());
                    b3.B(writeData);
                    b3.d0(pbEditorData.getVoiceModel());
                    s25 n3 = b3.a().n(6);
                    if (n3 != null && (t25Var2 = n3.m) != null) {
                        t25Var2.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    public void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
            this.P0 = -1;
            this.Q0 = Integer.MIN_VALUE;
        }
    }

    @Override // com.repackage.ji5
    public fg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i e1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048674, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
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
    public void e4(boolean z2) {
        et7 S1;
        int i2;
        w18 w18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048675, this, z2) == null) || K() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (S1 = K().S1()) == null) {
            return;
        }
        ThreadData O = S1.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", K().m2()).param("fid", S1.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (x4()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", K().getForumId());
                statisticItem.param("tid", K().m2());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", O3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", N3());
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
                if (O.getBaijiahaoData() != null && !pi.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (P() != null) {
                t95.e(P(), statisticItem2);
            }
            w18Var = this.r0;
            if (w18Var != null) {
                statisticItem2.param("obj_param1", w18Var.g());
            }
            TiebaStatic.log(statisticItem2);
            if (qi.D()) {
                showToast(R.string.obfuscated_res_0x7f0f0c3d);
                return;
            } else if (K().S1() == null) {
                qi.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddd));
                return;
            } else {
                ArrayList<PostData> F = S1.F();
                if ((F == null || F.size() <= 0) && K().k2()) {
                    qi.N(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0ddd));
                    return;
                }
                this.N.F();
                L5();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                w18 w18Var2 = this.r0;
                if (w18Var2 != null) {
                    w18Var2.l(false);
                    U5(S1);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.r0.i()) {
                        this.r0.m(false);
                        l4(e05.a(), this.r0.g());
                        return;
                    }
                    D5(i4);
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
        if (!pi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (P() != null) {
        }
        w18Var = this.r0;
        if (w18Var != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (qi.D()) {
        }
    }

    public boolean e5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091fe8);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.t()) && rn4.c().g()) {
                        return K4(postData.K());
                    }
                    if (checkUpIsLogin() && K() != null && K().S1() != null) {
                        gw7 gw7Var = this.K0;
                        if (gw7Var != null) {
                            gw7Var.c();
                        }
                        ut7 ut7Var = new ut7();
                        ut7Var.A(K().S1().l());
                        ut7Var.E(K().S1().O());
                        ut7Var.C(postData);
                        this.L0.V(ut7Var);
                        this.L0.setPostId(postData.K());
                        H4(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        k45 k45Var = this.I0;
                        if (k45Var != null) {
                            k5(k45Var.C());
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

    public void f4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || this.e0 == null) {
            return;
        }
        this.d0.setVisibility(8);
        this.e0.setVisibility(8);
        this.u0.a = false;
        R4();
        U4();
    }

    public final void f5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048678, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            my7 my7Var = new my7(this.a);
            this.Q = my7Var;
            my7Var.n(this.C1);
            this.Q.m(this.k1);
        }
        this.Q.k(emotionImageData, K(), K().S1());
    }

    @Override // com.repackage.s08
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            PbModel b12 = this.a.b1();
            if (b12 != null && b12.S1() != null && !b12.S1().i0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = b12.S1().O().getId();
                if (b12.isShareThread() && b12.S1().O().originalThreadData != null) {
                    historyMessage.threadName = b12.S1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = b12.S1().O().getTitle();
                }
                if (b12.isShareThread() && !u0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = b12.S1().l().getName();
                }
                ArrayList<PostData> F = b12.S1().F();
                int I1 = b4() != null ? b4().I1() : 0;
                if (F != null && I1 >= 0 && I1 < F.size()) {
                    historyMessage.postID = F.get(I1).K();
                }
                historyMessage.isHostOnly = b12.v1();
                historyMessage.isSquence = b12.k2();
                historyMessage.isShareThread = b12.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            k45 k45Var = this.I0;
            if (k45Var != null) {
                k45Var.I();
            }
            if (b12 != null && (b12.x1() || b12.A1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", b12.m2());
                if (this.y0) {
                    if (this.A0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", b12.G1());
                    }
                    if (this.z0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", b12.C1());
                    }
                }
                if (b12.S1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = b12.S1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (N5()) {
                if (b12 != null) {
                    et7 S1 = b12.S1();
                    if (S1 != null) {
                        if (S1.V() != null) {
                            S1.V().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.B0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                bx7.b().t(rect);
                            }
                            bx7.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView a4 = a4();
                            bx7.b().n(b12.T1(), a4 != null ? a4.onSaveInstanceState() : null, b12.k2(), b12.v1(), false);
                        }
                    }
                } else {
                    bx7.b().m();
                }
                M5();
            }
        }
    }

    @Override // com.repackage.ji5
    public void g1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, context, str) == null) {
        }
    }

    public void g4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048681, this, z2) == null) || this.e0 == null || this.h0 == null) {
            return;
        }
        if (K() != null && K().S1() != null) {
            this.h0.setText(TbSingleton.getInstance().getAdVertiComment(K().S1().n0(), K().S1().o0(), c4()));
        } else {
            this.h0.setText(c4());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.e0.startAnimation(alphaAnimation);
        }
        this.d0.setVisibility(0);
        this.e0.setVisibility(0);
        this.u0.a = true;
    }

    public final void g5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048682, this, i2) == null) || K() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(K().m2());
        sendMessage(privacySettingMessage);
    }

    @Override // com.repackage.ji5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.repackage.r08
    public void h1(boolean z2, int i2, int i3, int i4, et7 et7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), et7Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void h4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.o();
    }

    public void h5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048686, this, i2) == null) || (linearLayout = this.c0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || this.a.getCurrentFocus() == null) {
            return;
        }
        qi.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void i5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, editorTools) == null) {
            this.J0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f0917bb);
            this.J0.setOnCancelClickListener(new f1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.J0.getParent() == null) {
                this.c.addView(this.J0, layoutParams);
            }
            this.J0.w(TbadkCoreApplication.getInst().getSkinType());
            this.J0.setActionListener(24, new g1(this));
            h4();
            this.I0.i(new h1(this));
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            bm4 c3 = bm4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.Z0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y1);
            this.S = new pz4(getPageContext());
            this.N = new g18(this);
        }
    }

    public void j4() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048690, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048691, this) == null) {
            this.K.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.q08
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsVideoPbFragment.this.F4();
                    }
                }
            });
        }
    }

    public final void k3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        ThreadData O = K().S1().O();
        O.mRecomAbTag = K().X1();
        O.mRecomWeight = K().a2();
        O.mRecomSource = K().Z1();
        O.mRecomExtra = K().Y1();
        O.isSubPb = K().F1();
        if (O.getFid() == 0) {
            O.setFid(og.g(K().getForumId(), 0L));
        }
        StatisticItem i2 = t95.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public void k4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || (rightFloatLayerView = this.X0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void k5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            this.w0 = z2;
        }
    }

    @Override // com.repackage.s08
    public PbFragment l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void l3(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048696, this, z2, str) == null) || K() == null || K().S1() == null || K().S1().O() == null) {
            return;
        }
        ThreadData O = K().S1().O();
        O.mRecomAbTag = K().X1();
        O.mRecomWeight = K().a2();
        O.mRecomSource = K().Z1();
        O.mRecomExtra = K().Y1();
        if (O.getFid() == 0) {
            O.setFid(og.g(K().getForumId(), 0L));
        }
        StatisticItem i2 = t95.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l2 = t95.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, if5.d(str) > 40 ? if5.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            o95 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            if (N3() == 1) {
                i2.param("obj_locate", 4);
            } else if (N3() == 2) {
                i2.param("obj_locate", 5);
            } else if (N3() == 3) {
                i2.param("obj_locate", 2);
            } else if (N3() == 4) {
                i2.param("obj_locate", 3);
            } else if (N3() == 7) {
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
        StatisticItem i3 = t95.i(getContext(), O, "c14180");
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
        StatisticItem i4 = t95.i(getContext(), O, "c14303");
        if (i4 != null) {
            if (N3() == 1) {
                i4.param("obj_locate", 1);
            } else if (N3() == 2) {
                i4.param("obj_locate", 2);
            } else if (N3() == 3) {
                i4.param("obj_locate", 3);
            } else if (N3() == 4) {
                i4.param("obj_locate", 4);
            }
            i4.param("tid", K().m2());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", K().S1().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void l4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048697, this, i2, i3) == null) {
            gf5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void l5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048698, this, z2) == null) {
            this.L = z2;
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
    public final void m3(ThreadData threadData) {
        double d2;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect j12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, threadData) == null) {
            double k2 = qi.k(getContext());
            double i3 = (2.0d * k2) / qi.i(getContext());
            if (threadData != null && threadData.getThreadVideoInfo() != null) {
                int intValue = threadData.getThreadVideoInfo().video_width.intValue();
                int intValue2 = threadData.getThreadVideoInfo().video_height.intValue();
                if (intValue2 > 0) {
                    d2 = (intValue * 1.0f) / intValue2;
                    if (d2 > 1.7777777777777777d) {
                        d2 = 1.7777777777777777d;
                    }
                    if (d2 >= i3) {
                        i3 = d2;
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
                    if (A4()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, O1);
                        } else {
                            layoutParams3.height = O1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (A4()) {
                        ceil += O1;
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
            d2 = 1.7777777777777777d;
            if (d2 > 1.7777777777777777d) {
            }
            if (d2 >= i3) {
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
            if (A4()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (A4()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            this.c0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0924e4);
            this.d0 = this.c.findViewById(R.id.obfuscated_res_0x7f092544);
            this.e0 = this.c.findViewById(R.id.obfuscated_res_0x7f0917bf);
            qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            qi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090873);
            this.g0 = imageView;
            imageView.setOnClickListener(new u0(this));
            G4();
            this.h0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0917c2);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0917ba);
            this.f0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917c0);
            this.i0 = imageView2;
            imageView2.setOnClickListener(this.D1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917be);
            this.j0 = imageView3;
            imageView3.setOnClickListener(this.D1);
            if (booleanExtra) {
                this.j0.setVisibility(8);
            } else {
                this.j0.setVisibility(0);
            }
            if (z4()) {
                this.i0.setVisibility(0);
            } else {
                this.i0.setVisibility(8);
                this.j0.setPadding(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0917c3);
            this.q0 = imageView4;
            imageView4.setOnClickListener(this.D1);
            this.r0 = new w18(this.q0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.r0.f();
            }
            if (K() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !gz7.k(K().m2())) {
                this.r0.f();
                gz7.b(K().m2());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0917c1);
            this.s0 = textView;
            textView.setVisibility(0);
            y5(false);
        }
    }

    public void m5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.r1 = z2;
        }
    }

    public final void n3(j18 j18Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, j18Var) == null) && j18Var != null && this.w == null) {
            this.w = j18Var;
            this.C.setText(j18Var.getTitle());
            this.D.setText(j18Var.l());
            String j2 = j18Var.j();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(j2)) {
                j2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0dfd);
            }
            tBSpecificationBtn.setText(j2);
            this.G.K(j18Var.f(), 10, false);
            this.H.setVisibility(j18Var.n() ? 0 : 8);
            rg.a().postDelayed(new k1(this), j18Var.c().longValue() * 1000);
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048703, this) == null) {
            this.L0 = new PbFakeFloorModel(getPageContext());
            PbModel K = K();
            this.L0.S(K.I(), K.E(), K.F(), K.D(), K.J());
            this.L0.setFromForumId(K.getFromForumId());
            gw7 gw7Var = new gw7(getPageContext(), this.L0, this.c);
            this.K0 = gw7Var;
            gw7Var.k(new y0(this));
            this.K0.n(this.B1);
            this.L0.U(new z0(this));
        }
    }

    public abstract void n5(boolean z2);

    public final void o3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048705, this) == null) || K() == null || this.a == null) {
            return;
        }
        k45 k45Var = this.I0;
        if (k45Var == null || !k45Var.v) {
            j45 j45Var = new j45();
            o5(j45Var);
            k45 k45Var2 = (k45) j45Var.a(getContext());
            this.I0 = k45Var2;
            k45Var2.f0(this.a.getPageContext());
            this.I0.p0(this.k1);
            this.I0.q0(this.C1);
            this.I0.F(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.I0.a().C(true);
            i5(this.I0.a());
            if (!K().F1()) {
                this.I0.s(K().m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (K().A2()) {
                this.I0.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0ded));
            } else {
                this.I0.m0(c4());
            }
        }
    }

    public void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            i5(this.I0.a());
        }
    }

    public final void o5(m45 m45Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048707, this, m45Var) == null) || m45Var == null || K() == null) {
            return;
        }
        m45Var.p(K().r1());
        if (K().S1() != null && K().S1().l() != null) {
            m45Var.o(K().S1().l());
        }
        m45Var.q("pb");
        m45Var.r(K());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906bd));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            S4(videoPbViewModel.c());
            t4(videoPbViewModel.c());
            Y4(videoPbViewModel.c());
            if (K() != null && K().S1() != null) {
                boolean B1 = K().B1();
                et7 S1 = K().S1();
                if (B1) {
                    PostData M3 = M3(S1);
                    if (S1.u() != null && !S1.u().equals(M3.K()) && this.e != null) {
                        if (A4()) {
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
            this.a.d1().k(this.V0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048709, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.I0.H(i2, i3, intent);
            my7 my7Var = this.Q;
            if (my7Var != null) {
                my7Var.i(i2, i3, intent);
            }
            gw7 gw7Var = this.K0;
            if (gw7Var != null) {
                gw7Var.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                d4(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    J4();
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
                            if (I3() != null) {
                                I3().performClick();
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
                    bb8.g().m(getPageContext());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048710, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048711, this, i2) == null) {
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
            px7 px7Var = this.F0;
            if (px7Var != null) {
                px7Var.i();
            }
            v08 v08Var = this.l;
            if (v08Var == null || !v08Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.J0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            gw7 gw7Var = this.K0;
            if (gw7Var != null) {
                gw7Var.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            LinearLayout linearLayout = this.f0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (K() != null && K().D1()) {
                WebPManager.setPureDrawable(this.j0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.j0, R.drawable.obfuscated_res_0x7f08095e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.i0, R.drawable.obfuscated_res_0x7f080961, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g0, R.drawable.obfuscated_res_0x7f08099c, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f08091e, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (K() != null) {
                U5(K().S1());
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.e0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.d0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.s0, qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (K3() != null) {
                K3().onChangeSkinType(i2);
            } else if (A4() && b4() != null) {
                b4().onChangeSkinType(i2);
            }
            if (L3() != null) {
                L3().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(qi.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            L5();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            l18 l18Var = this.k;
            if (l18Var == null || l18Var.N0()) {
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
        if (interceptable == null || interceptable.invokeL(1048713, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            p4(bundle);
            t0().onCreate(getPageContext());
            wu4 wu4Var = new wu4();
            this.O = wu4Var;
            wu4Var.a = 1000L;
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
            registerListener(this.H1);
            this.t = new zy5(getPageContext());
            cj8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048714, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(P3(), viewGroup, false);
            v4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048715, this) == null) {
            super.onDestroy();
            cj8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.H1);
            ItemCardHelper.v(null);
            t0().onDestory(getPageContext());
            w18 w18Var = this.r0;
            if (w18Var != null) {
                w18Var.k();
            }
            ForumManageModel forumManageModel = this.T;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            l18 l18Var = this.k;
            if (l18Var != null) {
                l18Var.O0();
            }
            my7 my7Var = this.Q;
            if (my7Var != null) {
                my7Var.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.C0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            g18 g18Var = this.N;
            if (g18Var != null) {
                g18Var.o0();
            }
            if (K() != null) {
                K().cancelLoadData();
                K().destory();
                if (K().O1() != null) {
                    K().O1().d();
                }
            }
            k45 k45Var = this.I0;
            if (k45Var != null) {
                k45Var.I();
            }
            this.O = null;
            mk8.d();
            K5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onPause();
            this.T0 = true;
            t0().onPause(getPageContext());
            l18 l18Var = this.k;
            if (l18Var != null) {
                l18Var.onBackground(true);
            }
            if (K() != null && !K().F1()) {
                this.I0.V(K().m2());
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            dj4.w().E();
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onResume();
            this.T0 = false;
            t0().onResume(getPageContext());
            l18 l18Var = this.k;
            if (l18Var != null) {
                l18Var.onBackground(false);
            }
            E5();
            registerListener(this.h1);
            registerListener(this.i1);
            registerListener(this.g1);
            registerListener(this.G1);
            ItemCardHelper.v(this.J1);
            MessageManager.getInstance().registerListener(this.I1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, bundle) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048719, this) == null) {
            super.onStart();
            t0().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onStop();
            t0().onStop(getPageContext());
            cj8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.I1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            super.onUserChanged(z2);
            G4();
        }
    }

    public void p3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048722, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().B(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().B(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.B());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((z05) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    Q4((z05) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    Q4((z05) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void p4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, bundle) == null) {
            m45 m45Var = new m45();
            this.H0 = m45Var;
            o5(m45Var);
            k45 k45Var = (k45) this.H0.a(getActivity());
            this.I0 = k45Var;
            k45Var.f0(this.a.getPageContext());
            this.I0.p0(this.k1);
            this.I0.q0(this.C1);
            this.I0.i0(1);
            this.I0.n0(SendView.f);
            this.I0.j(SendView.f);
            this.I0.F(this.a.getPageContext(), bundle);
            this.I0.a().b(new r25(getActivity()));
            this.I0.a().C(true);
            v5(true);
            if (K() != null) {
                this.I0.P(K().u1(), K().m2(), K().q1());
            }
            registerListener(this.c1);
            registerListener(this.e1);
            registerListener(this.m1);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.f1);
            registerListener(this.K1);
            if (!K().F1()) {
                this.I0.s(K().m2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.m0(TbSingleton.getInstance().getAdVertiComment());
            } else if (K().A2()) {
                this.I0.m0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0ded));
            } else {
                this.I0.m0(c4());
            }
            this.F0 = new px7();
            if (this.I0.v() != null) {
                this.F0.m(this.I0.v().i());
            }
            this.I0.e0(this.a1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.C0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public void p5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048724, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            g18 g18Var = this.N;
            if (g18Var == null) {
                return;
            }
            if (z2) {
                g18Var.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void q0(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048725, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (gi5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), gi5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (sx7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new yf5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
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

    public final void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048727, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091865);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091864);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091861);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091860);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091863);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901f0);
            this.G.setRadius(qi.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new qv4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (K() == null || K().S1() == null) {
                return;
            }
            A5(K().S1());
        }
    }

    public void q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            hideProgressBar();
            if (A4() && b4() != null) {
                b4().F1();
                b4().G1();
            } else if (K3() != null) {
                K3().H1();
                K3().I1();
            }
        }
    }

    public final boolean r3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048729, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0924e7);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c9);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f091f2a);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091f31);
            this.o = findViewById;
            if (this.q1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = qi.s(P());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = qi.s(P());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.D1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092615);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f080612, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0615, this.D1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09161a);
            int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.rightMargin = f3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.r.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.t1 = new GestureDetector(getContext(), this.u1);
            this.m.setOnTouchListener(this.s1);
        }
    }

    public void r5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            qi.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            if ((K() != null && K().S1().i0()) || this.C0 == null || K() == null || K().S1() == null || ThreadCardUtils.isSelf(K().S1().O()) || K().S1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeInvokeEditor(K().S1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void s4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048733, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.j();
        k45 k45Var = this.I0;
        if (k45Var != null) {
            k45Var.Q();
        }
        f4();
    }

    public final void s5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048734, this, i2) == null) || K() == null) {
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
            N4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            if (this.U == null) {
                this.U = VoiceManager.instance();
            }
            return this.U;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public boolean t3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048737, this, i2)) == null) {
            if (this.C0 == null || K() == null || K().S1() == null || ThreadCardUtils.isSelf(K().S1().O()) || K().S1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeSend(K().S1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void t4(et7 et7Var) {
        qx4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, et7Var) == null) || this.W0 == null || et7Var == null || et7Var.g() == 3 || x4()) {
            return;
        }
        if (et7Var.n0()) {
            pbAdFloatViewItemData = et7Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
            if (!RightFloatLayerView.k()) {
                k4();
                return;
            }
            if (this.X0 == null) {
                this.X0 = RightFloatLayerLottieView.F(pbAdFloatViewItemData, getContext());
                this.W0.removeAllViews();
                this.W0.addView(this.X0);
            }
            if ((this.K.getTag() instanceof Boolean) && !((Boolean) this.K.getTag()).booleanValue()) {
                this.X0.setAutoCompleteShown(false);
                this.X0.setTag(this.K);
                this.X0.c();
            }
            if (pbAdFloatViewItemData.a()) {
                return;
            }
            this.X0.setData(pbAdFloatViewItemData);
            this.X0.setLogoListener(new g0(this, et7Var, pbAdFloatViewItemData));
            this.X0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        k4();
    }

    public void t5(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048739, this, i2) == null) || (view2 = this.g) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || K() == null || pi.isEmpty(K().m2())) {
            return;
        }
        super.taskStart();
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            PbModel b12 = this.a.b1();
            if (b12 == null) {
                return false;
            }
            return b12.J2();
        }
        return invokeV.booleanValue;
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            if (!checkUpIsLogin()) {
                if (K() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", K().getForumId()));
                }
            } else if (s3()) {
                k45 k45Var = this.I0;
                if (k45Var != null && (k45Var.B() || this.I0.D())) {
                    this.I0.z(false, null);
                    return;
                }
                if (this.J0 != null) {
                    s4();
                    this.u0.a = false;
                    if (this.J0.n(2) != null) {
                        mk8.c(getPageContext(), (View) this.J0.n(2).m, false, null);
                    }
                }
                f4();
            }
        }
    }

    public final void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048744, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void u5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z2) == null) {
            this.u = z2;
        }
    }

    @Override // com.repackage.ji5
    public fg<GifView> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            if (this.V == null) {
                this.V = new fg<>(new u1(this), 20, 0);
            }
            return this.V;
        }
        return (fg) invokeV.objValue;
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            if (K().x1() || K().A1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", K().m2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, K().m2()));
            if (N5()) {
                this.a.finish();
            }
        }
    }

    public void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            o56 o56Var = new o56(getActivity());
            this.M0 = o56Var;
            o56Var.i(this.A1);
            this.q1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            r4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f0902a3);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f091867);
            this.W0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091bf2);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091855);
            l18 l18Var = new l18(getContext(), this.j);
            this.k = l18Var;
            l18Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.X0(this);
            this.k.V0(P().getRootView());
            this.k.W0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091d7b)).setMinimumHeight(((int) Math.ceil((qi.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f09186b);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f091862);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f09186d);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f091020);
            this.A = (MaskView) this.c.findViewById(R.id.obfuscated_res_0x7f0914a0);
            this.h.setOnClickListener(this.D1);
            u4();
            q4();
            m4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f09257a);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f09097e);
            j5();
            this.K.setAnimationListener(new s0(this));
            o4();
            n4();
            if (!this.q1 && this.r1) {
                H5();
                UtilHelper.hideStatusBar(P(), P().getRootView());
                this.r1 = false;
            }
            if (A4()) {
                return;
            }
            this.d.getLayoutParams().height = 0;
        }
    }

    public final void v5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            this.I0.g0(z2);
            this.I0.k0(z2);
            this.I0.s0(z2);
        }
    }

    public void w3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, bVar) == null) {
            List<PostData> list = K().S1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).Y().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).Y().get(i3).K())) {
                        list.get(i2).Y().remove(i3);
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
                if (K3() != null) {
                    K3().U1();
                } else if (A4() && b4() != null) {
                    b4().R1();
                }
            }
        }
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048751, this) == null) && this.l == null) {
            this.l = new v08(getBaseFragmentActivity(), this.j);
            int s2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? qi.s(P()) : 0;
            Rect rect = new Rect(0, s2, qi.k(getContext()), this.j.getOriginHeight() + s2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (A4() && (videoPbViewModel.n() || K().l2() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || K().l2() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    public final void w5(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048752, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                g18 g18Var = this.N;
                if (g18Var != null) {
                    g18Var.L0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public void x3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048753, this, sparseArray, jSONArray) == null) {
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
            } else if (this.T.S()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091fea);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092008)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091feb)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fec)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ffe) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ffe)).booleanValue() : false;
                if (jSONArray != null) {
                    this.T.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.T.V(K().S1().l().getId(), K().S1().l().getName(), K().S1().O().getId(), str, intValue3, intValue2, booleanValue, K().S1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public abstract boolean x4();

    public final void x5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048755, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            if (postWriteCallBackData.getIconStampData() != null) {
                l05.c(getPageContext(), postWriteCallBackData, 2);
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

    @Override // com.repackage.ji5
    public fg<LinearLayout> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            if (this.Z == null) {
                this.Z = new fg<>(new w1(this), 15, 0);
            }
            return this.Z;
        }
        return (fg) invokeV.objValue;
    }

    @Override // com.repackage.ji5
    public fg<TiebaPlusRecommendCard> y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            return null;
        }
        return (fg) invokeV.objValue;
    }

    public void y3(ur4 ur4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048758, this, ur4Var, jSONArray) == null) {
            ur4Var.dismiss();
            if (K() == null || K().S1() == null || K().S1().O() == null || K().S1().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (ur4Var.getYesButtonTag() instanceof SparseArray) {
                    x3((SparseArray) ur4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048759, this)) == null) {
            EditorTools editorTools = this.J0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void y5(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048760, this, z2) == null) || this.e0 == null) {
            return;
        }
        k5(this.I0.C());
        if (this.w0) {
            z5(z2);
        } else {
            g4(z2);
        }
        R4();
        U4();
    }

    public void z3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fea, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                x3(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public abstract boolean z4();

    public void z5(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048763, this, z2) == null) || this.e0 == null || (textView = this.h0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0519);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.e0.startAnimation(alphaAnimation);
        }
        this.d0.setVisibility(0);
        this.e0.setVisibility(0);
        this.u0.a = true;
    }

    /* loaded from: classes4.dex */
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

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (this.a && this.b) ? false : true : invokeV.booleanValue;
        }

        public /* synthetic */ c2(AbsVideoPbFragment absVideoPbFragment, k kVar) {
            this(absVideoPbFragment);
        }
    }
}
