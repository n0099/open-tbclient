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
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
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
import com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity;
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
import com.repackage.a25;
import com.repackage.a9;
import com.repackage.ag;
import com.repackage.am4;
import com.repackage.aq7;
import com.repackage.bf8;
import com.repackage.bg;
import com.repackage.c05;
import com.repackage.co8;
import com.repackage.ct4;
import com.repackage.cw4;
import com.repackage.dq4;
import com.repackage.dx7;
import com.repackage.dy4;
import com.repackage.e05;
import com.repackage.e75;
import com.repackage.ew7;
import com.repackage.f05;
import com.repackage.fq4;
import com.repackage.fv7;
import com.repackage.gt7;
import com.repackage.gx7;
import com.repackage.gz4;
import com.repackage.hd5;
import com.repackage.hx7;
import com.repackage.ix4;
import com.repackage.ix7;
import com.repackage.jg;
import com.repackage.ji;
import com.repackage.ki;
import com.repackage.kk4;
import com.repackage.kp7;
import com.repackage.ks7;
import com.repackage.ku4;
import com.repackage.lg8;
import com.repackage.lh4;
import com.repackage.li;
import com.repackage.lq7;
import com.repackage.lv5;
import com.repackage.mc5;
import com.repackage.mg;
import com.repackage.mh4;
import com.repackage.mt7;
import com.repackage.np4;
import com.repackage.nu7;
import com.repackage.nv4;
import com.repackage.ow7;
import com.repackage.pc5;
import com.repackage.pt4;
import com.repackage.pw7;
import com.repackage.qb5;
import com.repackage.qg8;
import com.repackage.qo7;
import com.repackage.qt7;
import com.repackage.rc5;
import com.repackage.ry4;
import com.repackage.se5;
import com.repackage.sk4;
import com.repackage.sw7;
import com.repackage.sz4;
import com.repackage.t15;
import com.repackage.t68;
import com.repackage.tb5;
import com.repackage.tn4;
import com.repackage.tt7;
import com.repackage.tx7;
import com.repackage.tz4;
import com.repackage.u15;
import com.repackage.v15;
import com.repackage.ve5;
import com.repackage.w15;
import com.repackage.ww4;
import com.repackage.x15;
import com.repackage.xk6;
import com.repackage.xx4;
import com.repackage.y16;
import com.repackage.ys4;
import com.repackage.z15;
import com.repackage.z65;
import com.repackage.zz4;
import com.tachikoma.core.component.anim.AnimationProperty;
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
/* loaded from: classes3.dex */
public abstract class AbsVideoPbFragment extends BaseFragment implements ve5, VoiceManager.j, pw7, TbRichTextView.s, ow7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int N1;
    public static final int O1;
    public static int P1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public final y16.b A1;
    public View.OnClickListener B;
    public boolean B0;
    public NewWriteModel.e B1;
    public TextView C;
    public ReplyPrivacyCheckController C0;
    public v15 C1;
    public TextView D;
    public xk6 D0;
    public final View.OnClickListener D1;
    public ImageView E;
    public xk6 E0;
    public View.OnClickListener E1;
    public TBSpecificationBtn F;
    public qt7 F0;
    public final AdapterView.OnItemClickListener F1;
    public TbImageView G;
    public PermissionJudgePolicy G0;
    public CustomMessageListener G1;
    public View H;
    public z15 H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public x15 I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public EditorTools J0;
    public final ItemCardHelper.c J1;
    public FallingView K;
    public ks7 K0;
    public CustomMessageListener K1;
    public boolean L;
    public PbFakeFloorModel L0;
    public final View.OnLongClickListener L1;
    public View M;
    public y16 M0;
    public SortSwitchButton.f M1;
    public dx7 N;
    public int[] N0;
    public ct4 O;
    public int O0;
    public kk4 P;
    public int P0;
    public nu7 Q;
    public int Q0;
    public EmotionImageData R;
    public int R0;
    public ix4 S;
    public int S0;
    public ForumManageModel T;
    public boolean T0;
    public VoiceManager U;
    public boolean U0;
    public ag<GifView> V;
    @NonNull
    public TiePlusEventController.f V0;
    public ag<TextView> W;
    public FrameLayout W0;
    public ag<ImageView> X;
    public RightFloatLayerView X0;
    public ag<View> Y;
    public final PbModel.h Y0;
    public ag<LinearLayout> Z;
    public final kk4.a Z0;
    public AbsPbActivity a;
    public u15 a1;
    public long b;
    public final CustomMessageListener b1;
    public RelativeLayout c;
    public CustomMessageListener c1;
    public NewPagerSlidingTabBaseStrip d;
    public final CustomMessageListener d1;
    public CustomViewPager e;
    public CustomMessageListener e1;
    public VideoPbFragmentAdapter f;
    public HttpMessageListener f1;
    public View g;
    public ag<RelativeLayout> g0;
    public CustomMessageListener g1;
    public View h;
    public boolean h0;
    public CustomMessageListener h1;
    public AppBarLayout i;
    public LinearLayout i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public View j0;
    public u15 j1;
    public ix7 k;
    public View k0;
    public final NewWriteModel.e k1;
    public sw7 l;
    public LinearLayout l0;
    public View.OnClickListener l1;
    public NavigationBar m;
    public ImageView m0;
    public CustomMessageListener m1;
    public View n;
    public TextView n0;
    public int n1;
    public View o;
    public ImageView o0;
    public float o1;
    public View p;
    public ImageView p0;
    public float p1;
    public ImageView q;
    public ImageView q0;
    public boolean q1;
    public View r;
    public tx7 r0;
    public boolean r1;
    public ImageView s;
    public TextView s0;
    public View.OnTouchListener s1;
    public lv5 t;
    public TextView t0;
    public GestureDetector t1;
    public boolean u;
    public c2 u0;
    public GestureDetector.SimpleOnGestureListener u1;
    public View v;
    public String v0;
    public Runnable v1;
    public gx7 w;
    public boolean w0;
    public ObjectAnimator w1;
    public View x;
    public String x0;
    public ObjectAnimator x1;
    public View y;
    public boolean y0;
    public final a9 y1;
    public View z;
    public boolean z0;
    public View.OnTouchListener z1;

    /* loaded from: classes3.dex */
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
            this.a.Q4();
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements tb5<ShareItem> {
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
        @Override // com.repackage.tb5
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

    /* loaded from: classes3.dex */
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
                this.a.N.o0(true);
                return this.a.N.P().onLongClick(view2);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.v() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            if (this.a.I0 != null) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.w4(absVideoPbFragment.I0.C());
            }
            this.a.n4();
            this.a.N.F();
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.f5();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e97) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e97)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091eaa) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eaa)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e95) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e95)).booleanValue() : false;
            dx7 dx7Var = this.a.N;
            if (dx7Var != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e67, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    dx7Var.l0(view2);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e67, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e50, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    dx7Var.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                dx7 dx7Var = this.a.N;
                if (dx7Var != null) {
                    dx7Var.F();
                }
                boolean z = false;
                if (!ji.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                    return false;
                }
                if (this.a.v() != null && !this.a.v().isLoading) {
                    this.a.X4();
                    this.a.D4();
                    z = true;
                    if (this.a.v().P1() != null && this.a.v().P1().f != null && this.a.v().P1().f.size() > i) {
                        int intValue = this.a.v().P1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.v().i2()).param("fid", this.a.v().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.v().G3(intValue)) {
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

    /* loaded from: classes3.dex */
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
            qo7 qo7Var = (qo7) customResponsedMessage.getData();
            int type = qo7Var.getType();
            if (type == 0) {
                this.a.l4((aq7) qo7Var.a());
            } else if (type == 1) {
                this.a.P2((ForumManageModel.b) qo7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (qo7Var.a() == null) {
                    this.a.j4(false, null);
                } else {
                    this.a.j4(true, (MarkData) qo7Var.a());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                            bdTopToast.i(true);
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f031b));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.E4(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        BdTopToast bdTopToast2 = new BdTopToast(this.a.getContext());
                        bdTopToast2.i(false);
                        bdTopToast2.h(errorString);
                        bdTopToast2.j((ViewGroup) this.a.getView());
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.v() == null || this.a.v().Y1() == i + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            absVideoPbFragment.s4(absVideoPbFragment.k3(i));
        }
    }

    /* loaded from: classes3.dex */
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
        public void b(kp7 kp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, kp7 kp7Var, String str, int i4) {
            String o3;
            zz4 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), kp7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906b0));
                }
                this.a.C4();
                this.a.v3();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.K4(false);
                if (z && kp7Var != null) {
                    ThreadData O = kp7Var.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(kp7Var, i2);
                    this.a.e4(kp7Var);
                    this.a.M4(kp7Var);
                    this.a.k4(kp7Var);
                    this.a.h4(z, i, i2, i3, kp7Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(kp7Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(kp7Var.U().getBimg_end_time());
                    if (kp7Var.F() != null && kp7Var.F().size() >= 1 && kp7Var.F().get(0) != null) {
                        this.a.v().m3(kp7Var.F().get(0).I());
                    } else if (kp7Var.W() != null) {
                        this.a.v().m3(kp7Var.W().I());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(kp7Var.r());
                    }
                    AntiData d = kp7Var.d();
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
                    this.a.F3(kp7Var);
                    if (this.a.v() != null && this.a.v().v2()) {
                        o3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde);
                    } else {
                        o3 = this.a.o3();
                    }
                    if (!StringUtils.isNull(o3)) {
                        this.a.I0.k0(TbSingleton.getInstance().getAdVertiComment(kp7Var.k0(), kp7Var.l0(), o3));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.v().h2());
                            jSONObject.put("fid", this.a.v().getForumId());
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
                    if ((this.a.M3() && this.a.n3() == null) || this.a.W2() == null) {
                        return;
                    }
                    ArrayList<PostData> arrayList = null;
                    if (this.a.M3()) {
                        if (i != -1) {
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                arrayList = this.a.v().P1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.n3().k1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f6));
                            } else if (this.a.n3().e1()) {
                                this.a.n3().l1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcf));
                            } else {
                                this.a.n3().l1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd0));
                            }
                        } else {
                            this.a.n3().k1("");
                        }
                        this.a.n3().R0();
                    } else {
                        if (i != -1) {
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                arrayList = this.a.v().P1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).A() != 1)) {
                                this.a.W2().r1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09f6));
                            } else if (this.a.W2().i1()) {
                                this.a.W2().s1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dcf));
                            } else {
                                this.a.W2().s1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd0));
                            }
                        } else {
                            this.a.W2().r1("");
                        }
                        this.a.W2().T0();
                    }
                }
                bf8.g().h(this.a.getUniqueId(), false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof co8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                co8 co8Var = (co8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = co8Var.a;
                if (co8Var.c == 0 && dataRes != null) {
                    int e = jg.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (ki.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea4, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ea4, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091eaa, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e67)).intValue();
                if (intValue == 0) {
                    this.a.N.E0(r3, sparseArray);
                } else if (intValue == 1) {
                    this.a.N.k0(sparseArray, r3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof se5.a)) {
                se5.a aVar = (se5.a) customResponsedMessage.getData();
                se5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements xk6.d {
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

        @Override // com.repackage.xk6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xk6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.I0 != null && this.a.I0.a() != null) {
                    this.a.I0.a().A(new sz4(45, 27, null));
                }
                this.a.G2();
            }
        }

        @Override // com.repackage.xk6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
            dx7 dx7Var = this.a.N;
            if (tag == dx7Var.D) {
                dx7Var.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                kp7 P1 = this.a.v().P1();
                if (P1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    P1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b30));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b2c);
                    }
                    this.a.N.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ki.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b2d);
                    }
                    this.a.O.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            qg8 qg8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof qg8) || (qg8Var = (qg8) customResponsedMessage.getData()) == null || (agreeData = qg8Var.b) == null || agreeData.agreeType != 2 || this.a.r0 == null || this.a.v() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || fv7.k(this.a.v().h2())) {
                return;
            }
            this.a.r0.o(2);
            fv7.b(this.a.v().h2());
        }
    }

    /* loaded from: classes3.dex */
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
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            dx7 dx7Var = this.a.N;
            if (tag == dx7Var.D) {
                dx7Var.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14a5));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ki.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14a4);
                }
                this.a.O.b(muteMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            ix7 ix7Var;
            BdTypeRecyclerView m3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (ix7Var = this.a.k) == null) {
                return;
            }
            if (ix7Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!ki.isEmpty(this.a.k.c0())) {
                this.a.B0 = true;
                if (this.a.M3()) {
                    this.a.e.setCurrentItem(0);
                } else {
                    this.a.e.setCurrentItem(0);
                }
                if (!this.a.M3() && (m3 = this.a.m3()) != null) {
                    m3.scrollToPosition(0);
                }
            }
            if (this.a.l == null || !this.a.l.k()) {
                this.a.o4();
                this.a.y2(threadData);
            }
            this.a.I3();
            if (this.a.l != null && this.a.l.l()) {
                this.a.l.s();
            }
            boolean z = !StringHelper.equals(this.a.k.c0(), threadData.getThreadVideoInfo().video_url);
            this.a.k.setData(threadData);
            if (this.a.M3()) {
                AbsVideoPbFragment absVideoPbFragment = this.a;
                absVideoPbFragment.k.S0(absVideoPbFragment.e.getCurrentItem() == 0);
            } else {
                this.a.k.S0(false);
            }
            if (z) {
                this.a.k.startPlay();
                this.a.k.v0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.n4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements u15 {
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

        @Override // com.repackage.u15
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qt7 qt7Var = this.a.F0;
                if (qt7Var == null || qt7Var.g() == null || !this.a.F0.g().d()) {
                    return !this.a.F2(ReplyPrivacyCheckController.TYPE_FLOOR);
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

    /* loaded from: classes3.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp7 a;
        public final /* synthetic */ nv4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, kp7 kp7Var, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, kp7Var, nv4Var};
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
            this.a = kp7Var;
            this.b = nv4Var;
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

    /* loaded from: classes3.dex */
    public class g1 implements tz4 {
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

        @Override // com.repackage.tz4
        public void onAction(sz4 sz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sz4Var) == null) {
                Object obj = sz4Var.c;
                if ((obj instanceof cw4) && EmotionGroupType.isSendAsPic(((cw4) obj).getType())) {
                    if (this.a.G0 == null) {
                        this.a.G0 = new PermissionJudgePolicy();
                    }
                    this.a.G0.clearRequestPermissionList();
                    this.a.G0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.I0.h((cw4) sz4Var.c);
                    this.a.I0.z(false, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes3.dex */
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
                this.b.a.c4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ww4Var, writeData, antiData}) == null) {
                if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        statisticItem.param("fid", this.a.v().P1().m());
                    }
                    statisticItem.param("tid", this.a.v().h2());
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                this.a.X4();
                this.a.B4(z, postWriteCallBackData);
                int i = -1;
                if (postWriteCallBackData != null) {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                if (writeData != null) {
                    ku4.b(writeData.getContent(), "3");
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
                        if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0475), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (ww4Var != null || i == 227001) {
                            return;
                        }
                        this.a.I4(i, antiData, str);
                        return;
                    } else {
                        dq4 dq4Var = new dq4(this.a.getActivity());
                        if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                            dq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce8));
                        } else {
                            dq4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new c(this));
                        dq4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.v() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.v().X0(postWriteCallBackData.getPostId());
                    if (this.a.M3() && this.a.n3() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.R0 = absVideoPbFragment.n3().U0();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.S0 = absVideoPbFragment2.n3().V0();
                        this.a.v().l3(this.a.R0, this.a.S0);
                    } else if (this.a.W2() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.R0 = absVideoPbFragment3.W2().W0();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.S0 = absVideoPbFragment4.W2().X0();
                        this.a.v().l3(this.a.R0, this.a.S0);
                    }
                }
                if (this.a.e != null) {
                    if (this.a.M3()) {
                        this.a.e.setCurrentItem(1);
                    } else {
                        this.a.e.setCurrentItem(0);
                    }
                }
                this.a.N.F();
                this.a.F0.c();
                if (this.a.I0 != null) {
                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                    absVideoPbFragment5.w4(absVideoPbFragment5.I0.C());
                }
                this.a.t3();
                this.a.K4(true);
                this.a.v().q2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.J4(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.v().s1()) {
                        kp7 P1 = this.a.v().P1();
                        if (P1 != null && P1.O() != null && P1.O().getAuthor() != null && (userId = P1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.v().D3()) {
                            this.a.D4();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.v().D3()) {
                        this.a.D4();
                    }
                } else if (floor != null) {
                    if (this.a.M3() && this.a.n3() != null) {
                        this.a.n3().d1();
                    } else if (this.a.W2() != null) {
                        this.a.W2().g1();
                    }
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getmAdverSegmentData() != null) {
                    mg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.x2(z2, writeData != null ? writeData.getContent() : "");
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            qt7 qt7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qt7Var = this.a.F0) == null || qt7Var.e() == null) {
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            ix7 ix7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (ix7Var = this.a.k) == null) {
                return;
            }
            ix7Var.V0(threadData);
        }
    }

    /* loaded from: classes3.dex */
    public class i1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes3.dex */
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
                qt7 qt7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qt7Var = this.a.c.F0) == null || qt7Var.g() == null) {
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
                int i2 = li.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = li.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = li.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                }
                int i3 = i2 - (i + f);
                AbsVideoPbFragment absVideoPbFragment = this.c;
                boolean z = true;
                int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                if (absVideoPbFragment.m3() != null) {
                    this.c.m3().smoothScrollBy(0, i4);
                }
                if (this.c.K0 != null) {
                    this.c.I0.a().setVisibility(8);
                    this.c.K0.o(this.a, this.b, this.c.o3(), (this.c.v() == null || this.c.v().P1() == null || this.c.v().P1().O() == null || !this.c.v().P1().O().isBjh()) ? false : false);
                    this.c.K0.l(this.c.Z2());
                    a25 b = this.c.K0.b();
                    if (b != null && this.c.v() != null && this.c.v().P1() != null) {
                        b.G(this.c.v().P1().d());
                        b.c0(this.c.v().P1().O());
                    }
                    if (this.c.F0.f() == null && this.c.K0.b().t() != null) {
                        this.c.K0.b().t().g(new a(this));
                        AbsVideoPbFragment absVideoPbFragment2 = this.c;
                        absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().i());
                        this.c.K0.b().M(this.c.j1);
                    }
                }
                this.c.r3();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                absVideoPbFragment.w4(absVideoPbFragment.I0.C());
            }
            this.a.K4(false);
        }
    }

    /* loaded from: classes3.dex */
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
            ix7 ix7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (ix7Var = this.a.k) == null) {
                return;
            }
            ix7Var.U0(threadData);
        }
    }

    /* loaded from: classes3.dex */
    public class j1 implements xk6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AbsVideoPbFragment c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j1 a;

            /* renamed from: com.baidu.tieba.pb.videopb.AbsVideoPbFragment$j1$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0226a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0226a(a aVar) {
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
                    qt7 qt7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (qt7Var = this.a.a.c.F0) == null || qt7Var.g() == null) {
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
                    int i2 = li.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = li.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f = li.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    }
                    int i3 = i2 - (i + f);
                    AbsVideoPbFragment absVideoPbFragment = this.a.c;
                    boolean z = true;
                    int i4 = (absVideoPbFragment.N0[1] + absVideoPbFragment.O0) - i3;
                    if (absVideoPbFragment.m3() != null) {
                        this.a.c.m3().smoothScrollBy(0, i4);
                    }
                    if (this.a.c.K0 != null) {
                        this.a.c.I0.a().setVisibility(8);
                        z = (this.a.c.v() == null || this.a.c.v().P1() == null || this.a.c.v().P1().O() == null || !this.a.c.v().P1().O().isBjh()) ? false : false;
                        ks7 ks7Var = this.a.c.K0;
                        j1 j1Var = this.a;
                        ks7Var.o(j1Var.a, j1Var.b, j1Var.c.o3(), z);
                        this.a.c.K0.l(this.a.c.Z2());
                        a25 b = this.a.c.K0.b();
                        if (b != null && this.a.c.v() != null && this.a.c.v().P1() != null) {
                            b.G(this.a.c.v().P1().d());
                            b.c0(this.a.c.v().P1().O());
                        }
                        if (this.a.c.F0.f() == null && this.a.c.K0.b().t() != null) {
                            this.a.c.K0.b().t().g(new C0226a(this));
                            AbsVideoPbFragment absVideoPbFragment2 = this.a.c;
                            absVideoPbFragment2.F0.n(absVideoPbFragment2.K0.b().t().i());
                            this.a.c.K0.b().M(this.a.c.j1);
                        }
                    }
                    this.a.c.r3();
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

        @Override // com.repackage.xk6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.xk6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                mg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.xk6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        if (!this.a.w.h) {
                            if (this.a.w.m != null) {
                                YYLiveUtil.jumpToYYLiveRoom(this.a.getPageContext(), this.a.w.m.mSid, this.a.w.m.mSsid, this.a.w.m.mTemplateId, "", YYLiveUtil.SOURCE_PB_LIVE_BANNER);
                            }
                        } else {
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.Q3(absVideoPbFragment.w.j, this.a.w.i);
                        }
                        if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.v().P1().l().getId()).param("fname", this.a.v().P1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()).param("obj_param1", this.a.w.k);
                        if (this.a.v().P1().O() != null) {
                            ThreadData O = this.a.v().P1().O();
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
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()));
                String i = this.a.w.i();
                if (TextUtils.isEmpty(i)) {
                    return;
                }
                if (!URLUtil.isHttpUrl(i) && !URLUtil.isHttpsUrl(i)) {
                    Uri parse = Uri.parse(i);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(this.a.getActivity(), parse.toString());
                        return;
                    }
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{i});
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.g4();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null && this.a.v() != null && this.a.v().P1() != null && this.a.v().P1().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.v().P1().l().getId()).param("fname", this.a.v().P1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()).param("obj_param1", this.a.w.k));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.m()).param("obj_type", 2).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.v().P1().Q()));
                }
                this.a.S4();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                        this.a.U4();
                        UtilHelper.showStatusBar(this.a.w(), this.a.w().getRootView());
                        this.a.r1 = true;
                        mg.a().removeCallbacks(this.a.v1);
                        mg.a().postDelayed(this.a.v1, 3000L);
                    }
                } else if (this.a.n1 == 2 && (this.a.r1 || this.a.N3())) {
                    this.a.T4();
                    UtilHelper.hideStatusBar(this.a.w(), this.a.w().getRootView());
                    this.a.r1 = false;
                    ix7 ix7Var = this.a.k;
                    if (ix7Var != null) {
                        ix7Var.T0(false);
                    }
                }
                this.a.n1 = 0;
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.z4(bool.booleanValue());
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            ix7 ix7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.o1 += f;
                this.a.p1 += f2;
                if (this.a.n1 == 0 && !this.a.q1 && (ix7Var = this.a.k) != null && !ix7Var.isFullScreen()) {
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

    /* loaded from: classes3.dex */
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
                if (this.b.M3() && (this.a.n() || this.b.v().g2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.v().g2() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.M3() && (this.a.n() || this.b.v().g2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.v().g2() == 0) {
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

    /* loaded from: classes3.dex */
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
                this.b.e5(this.a);
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

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.r1 && !this.a.N3()) {
                this.a.T4();
                UtilHelper.hideStatusBar(this.a.w(), this.a.w().getRootView());
                this.a.r1 = false;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.I0.L(null, null);
                } else if (i == ReplyPrivacyCheckController.TYPE_FLOOR && this.a.K0 != null && this.a.K0.b() != null) {
                    this.a.K0.b().F();
                } else if (i == ReplyPrivacyCheckController.TYPE_EMOTION_IMAGE) {
                    AbsVideoPbFragment absVideoPbFragment = this.a;
                    absVideoPbFragment.r4(absVideoPbFragment.R);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements kk4.a {
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

        @Override // com.repackage.kk4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.C4();
                if (z && this.a.v() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.v().C3(z2);
                    if (this.a.v().P1() != null && (O = this.a.v().P1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.v().A1()) {
                        this.a.U3();
                    } else if (this.a.M3()) {
                        if (this.a.X2() != null) {
                            this.a.X2().P0();
                        }
                        if (this.a.n3() != null) {
                            this.a.n3().d1();
                        }
                    } else if (this.a.W2() != null) {
                        this.a.W2().g1();
                    }
                    if (z2) {
                        if (this.a.P != null) {
                            if (this.a.P.f() == null || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.P.f();
                            MetaData author = this.a.v().P1().O().getAuthor();
                            if (f != null && author != null) {
                                if (!StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), author.getUserId()) && !author.hadConcerned()) {
                                    this.a.N.A0(author);
                                } else {
                                    this.a.showToast(R.string.obfuscated_res_0x7f0f00d1);
                                }
                            } else {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.showToast(absVideoPbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d0));
                            }
                        }
                        this.a.w2();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fad));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14cc));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null && this.a.v() != null) {
                    switch (this.a.T.getLoadDataMode()) {
                        case 0:
                            this.a.v().q2();
                            ForumManageModel.b bVar = (ForumManageModel.b) obj;
                            this.a.P2(bVar, (bVar.e != 1002 || bVar.f) ? true : true);
                            return;
                        case 1:
                            ForumManageModel.d dVar = (ForumManageModel.d) obj;
                            this.a.Q2(1, dVar.a, dVar.b, true);
                            return;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            AbsVideoPbFragment absVideoPbFragment = this.a;
                            absVideoPbFragment.R2(absVideoPbFragment.T.getLoadDataMode(), (ForumManageModel.g) obj);
                            return;
                        case 6:
                            ForumManageModel.g gVar = (ForumManageModel.g) obj;
                            AbsVideoPbFragment absVideoPbFragment2 = this.a;
                            absVideoPbFragment2.Q2(absVideoPbFragment2.T.getLoadDataMode(), gVar.a, gVar.b, false);
                            this.a.N.f0(gVar.c);
                            return;
                        default:
                            return;
                    }
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.Q2(absVideoPbFragment3.T.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.FAIL, this.a.c, 0L);
            }
        }

        @Override // com.baidu.tbadk.core.view.itemcard.ItemCardHelper.c
        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                ItemCardHelper.x(this.a.a, ItemCardHelper.OrderTipStatus.SUCCESS, this.a.c, j);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class q implements y16.b {
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

        @Override // com.repackage.y16.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    lq7.d();
                } else {
                    lq7.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    if (this.a.W2() != null) {
                        this.a.W2().l1(false);
                    } else if (this.a.M3() && this.a.n3() != null) {
                        this.a.n3().g1(false);
                    }
                    if (this.a.X2() != null) {
                        this.a.X2().U0(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.F4(absVideoPbFragment.X2().M0() == 0 ? 8 : 0);
                        this.a.i0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    ix7 ix7Var = this.a.k;
                    if (ix7Var != null) {
                        ix7Var.S0(z);
                    }
                    this.a.n4();
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()));
                    }
                } else {
                    if (this.a.X2() != null) {
                        this.a.X2().U0(false);
                    }
                    if (this.a.W2() != null) {
                        this.a.W2().l1(true);
                        int c1 = this.a.W2().c1();
                        int a1 = this.a.W2().a1();
                        if (c1 != 0) {
                            this.a.F4(8);
                            this.a.W2().v1(0);
                        } else if (a1 != 0) {
                            this.a.W2().v1(8);
                            this.a.F4(0);
                        } else {
                            this.a.W2().v1(8);
                            this.a.F4(8);
                        }
                    } else if (this.a.n3() != null) {
                        this.a.n3().g1(true);
                        int a12 = this.a.n3().a1();
                        int Y0 = this.a.n3().Y0();
                        if (a12 != 0) {
                            this.a.F4(8);
                            this.a.n3().o1(0);
                        } else if (Y0 != 0) {
                            this.a.n3().o1(8);
                            this.a.F4(0);
                        } else {
                            this.a.n3().o1(8);
                            this.a.F4(8);
                        }
                        this.a.i0.setVisibility(0);
                    }
                    ix7 ix7Var2 = this.a.k;
                    if (ix7Var2 != null) {
                        ix7Var2.S0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()));
                    }
                }
                this.a.f.d(i);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class r implements dq4.e {
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

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) || dq4Var == null) {
                return;
            }
            dq4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, nv4 nv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, nv4Var};
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
            this.a = nv4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.X0.setHomePbFloatLastCloseTime();
                this.b.w3();
                this.b.X0.u(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.c5();
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

    /* loaded from: classes3.dex */
    public class s implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsVideoPbFragment a;

        /* loaded from: classes3.dex */
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
                this.b.a.c4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ww4Var, writeData, antiData}) == null) {
                if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.v() != null && this.a.v().P1() != null) {
                        statisticItem.param("fid", this.a.v().P1().m());
                    }
                    if (this.a.v() != null) {
                        statisticItem.param("tid", this.a.v().h2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    ku4.b(writeData.getContent(), "4");
                }
                if (z) {
                    qt7 qt7Var = this.a.F0;
                    if (qt7Var != null) {
                        qt7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        dy4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    mg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
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
                    if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0475), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    dq4 dq4Var = new dq4(this.a.getActivity());
                    if (ki.isEmpty(postWriteCallBackData.getErrorString())) {
                        dq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ce8));
                    } else {
                        dq4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this));
                    dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new c(this));
                    dq4Var.create(this.a.getPageContext()).show();
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

    /* loaded from: classes3.dex */
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
                this.a.O4();
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class t implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ dq4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, dq4Var};
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
            this.c = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
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
                this.d.Y4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.w == null || this.a.w.q()) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.v().P1().Q()));
                        this.a.w.l = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.a.R4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements bg<ImageView> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
                    if (am4.c().g()) {
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
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = am4.c().g();
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
                    foreDrawableImageView.G();
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class u implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ dq4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, dq4Var};
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
            this.b = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                dq4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.Y4();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                this.a.I0.u0();
                this.a.M2();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u1 implements bg<GifView> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
                if (am4.c().g()) {
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
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = am4.c().g();
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

    /* loaded from: classes3.dex */
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
                this.a.h0 = true;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.O2(false);
                this.a.f4();
                if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.v().i2()).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 1).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                if (this.a.J3()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.v().getForumId());
                    statisticItem.param("tid", this.a.v().h2());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("post_id", this.a.a3());
                    statisticItem.param("obj_source", 1);
                    statisticItem.param("obj_type", 11);
                    statisticItem.param("obj_locate", this.a.Z2());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class v1 implements bg<View> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.getVoiceManager());
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            ViewGroup.LayoutParams layoutParams = this.a.i0.getLayoutParams();
            layoutParams.height = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.i0.setLayoutParams(layoutParams);
            if (this.a.M3() && this.a.d != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a.d.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = AbsVideoPbFragment.O1;
                } else {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, AbsVideoPbFragment.O1);
                }
                this.a.d.setLayoutParams(layoutParams2);
                this.a.e.setScrollable(true);
            }
            this.a.n4();
            if (this.a.X2() != null) {
                this.a.X2().P0();
            }
            if (this.a.W2() != null) {
                this.a.W2().g1();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class w1 implements bg<LinearLayout> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f091702);
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

    /* loaded from: classes3.dex */
    public class x implements v15 {
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

        @Override // com.repackage.v15
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.u3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x1 implements bg<RelativeLayout> {
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
        @Override // com.repackage.bg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.bg
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
        @Override // com.repackage.bg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bg
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

    /* loaded from: classes3.dex */
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
            boolean F3;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0916c1) {
                    if (this.a.v() != null) {
                        this.a.v().M2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091e5e);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.obfuscated_res_0x7f091e5e, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.v().h2());
                    statisticItem2.param("fid", this.a.v().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.J3()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.v().getForumId());
                        statisticItem3.param("tid", this.a.v().h2());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.a3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.Z2());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.a.h0) {
                        this.a.h0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e54);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.v() == null || this.a.v().P1() == null || this.a.L0 == null || postData.s() == null || postData.A() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.K0 != null) {
                                this.a.K0.c();
                            }
                            aq7 aq7Var = new aq7();
                            aq7Var.A(this.a.v().P1().l());
                            aq7Var.E(this.a.v().P1().O());
                            aq7Var.C(postData);
                            this.a.L0.U(aq7Var);
                            this.a.L0.setPostId(postData.I());
                            this.a.T3(view2, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            ew7.b(this.a.v().P1(), postData, postData.h0, 8, 1);
                            if (this.a.I0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.w4(absVideoPbFragment.I0.C());
                            }
                        }
                    }
                } else {
                    if (view2.getId() != R.id.obfuscated_res_0x7f091719 || this.a.getPageContext().getPageActivity() == null || this.a.v() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().h2(), false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().h2(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.v().getForumId());
                        statisticItem4.param("fname", this.a.v().o1());
                        statisticItem4.param("tid", this.a.v().h2());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.M3() && this.a.n3() != null && this.a.n3().Z0() != null && view2 == this.a.n3().Z0()) || ((this.a.W2() != null && this.a.W2().b1() != null && view2 == this.a.W2().b1()) || view2.getId() == R.id.obfuscated_res_0x7f0916c3)) {
                        if (!this.a.L && this.a.v().I2(true)) {
                            this.a.L = true;
                            if (this.a.M3()) {
                                if (this.a.n3() != null) {
                                    this.a.n3().n1();
                                    return;
                                }
                                return;
                            } else if (this.a.W2() != null) {
                                this.a.W2().u1();
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    dx7 dx7Var = this.a.N;
                    if (dx7Var != null && dx7Var.Q() != null && view2 == this.a.N.Q().g()) {
                        this.a.N.I();
                        return;
                    }
                    dx7 dx7Var2 = this.a.N;
                    if ((dx7Var2 == null || ((dx7Var2.Q() == null || view2 != this.a.N.Q().k()) && view2.getId() != R.id.obfuscated_res_0x7f09160c && view2.getId() != R.id.obfuscated_res_0x7f09025b)) && view2.getId() != R.id.obfuscated_res_0x7f0909cb && view2.getId() != R.id.obfuscated_res_0x7f091a5b) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view2 == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.v() == null || this.a.v().P1() == null) {
                                return;
                            }
                            if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.v().P1().m());
                                statisticItem5.param("tid", this.a.v().h2());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            li.x(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (qb5.a()) {
                                return;
                            }
                            if (this.a.v() != null && this.a.v().P1() != null) {
                                ArrayList<PostData> F = this.a.v().P1().F();
                                if ((F == null || F.size() <= 0) && this.a.v().f2()) {
                                    li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.v().h2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.v().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            li.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().m()) {
                            if (this.a.v() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (ji.z()) {
                                this.a.X4();
                                this.a.D4();
                                this.a.v().A3(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                        } else {
                            dx7 dx7Var3 = this.a.N;
                            if (dx7Var3 != null && dx7Var3.Q() != null && view2 == this.a.N.Q().k()) {
                                this.a.N.I();
                                return;
                            }
                            dx7 dx7Var4 = this.a.N;
                            if (dx7Var4 != null && ((dx7Var4.Q() != null && view2 == this.a.N.Q().t()) || view2.getId() == R.id.obfuscated_res_0x7f091700 || view2.getId() == R.id.obfuscated_res_0x7f0916fe)) {
                                this.a.N.F();
                                if (ji.z()) {
                                    if (!this.a.L) {
                                        this.a.X4();
                                        this.a.D4();
                                        this.a.N.J0(view2);
                                        return;
                                    }
                                    view2.setTag(Integer.valueOf(this.a.v().d2()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                return;
                            }
                            dx7 dx7Var5 = this.a.N;
                            if (dx7Var5 != null && dx7Var5.Q() != null && view2 == this.a.N.Q().s()) {
                                if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.v().P1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f09168e) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                dx7 dx7Var6 = this.a.N;
                                if (dx7Var6 != null) {
                                    dx7Var6.w0(sparseArray);
                                }
                            } else {
                                dx7 dx7Var7 = this.a.N;
                                int i4 = 4;
                                if (dx7Var7 != null && dx7Var7.Q() != null && view2 == this.a.N.Q().q()) {
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
                                dx7 dx7Var8 = this.a.N;
                                if (dx7Var8 != null && dx7Var8.Q() != null && view2 == this.a.N.Q().r()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.G0(absVideoPbFragment4.F1);
                                    return;
                                }
                                dx7 dx7Var9 = this.a.N;
                                if (dx7Var9 != null && dx7Var9.Q() != null && view2 == this.a.N.Q().j()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.v().h2())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                dx7 dx7Var10 = this.a.N;
                                if (dx7Var10 != null && (view2 == dx7Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().n() || view2 == this.a.N.Q().o())))) {
                                    if (!ji.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                        return;
                                    } else if ((this.a.v() == null && this.a.v().P1() == null) || this.a.T.R()) {
                                        return;
                                    } else {
                                        this.a.N.F();
                                        if (this.a.N.Q() != null && view2 == this.a.N.Q().o()) {
                                            if (this.a.v().P1().O().getIs_top() == 1) {
                                                i4 = 5;
                                            }
                                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().n()) {
                                            i4 = this.a.v().P1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view2 == this.a.N.M() ? 2 : 0;
                                        }
                                        ForumData l = this.a.v().P1().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String id2 = this.a.v().P1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.T.V(id, name, id2, i4, this.a.N.N());
                                        return;
                                    }
                                }
                                dx7 dx7Var11 = this.a.N;
                                if (dx7Var11 != null && dx7Var11.Q() != null && view2 == this.a.N.Q().i()) {
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (!ji.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> f3 = absVideoPbFragment5.f3(absVideoPbFragment5.v().P1(), this.a.v().f2(), 1);
                                    if (f3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.v().P1().l().getId(), this.a.v().P1().l().getName(), this.a.v().P1().O().getId(), String.valueOf(this.a.v().P1().U().getUserId()), (String) f3.get(R.id.obfuscated_res_0x7f091e61), (String) f3.get(R.id.obfuscated_res_0x7f091e62), (String) f3.get(R.id.obfuscated_res_0x7f091e64), (String) f3.get(R.id.obfuscated_res_0x7f091e63))));
                                    return;
                                }
                                dx7 dx7Var12 = this.a.N;
                                if (dx7Var12 != null && dx7Var12.Q() != null && view2 == this.a.N.Q().b()) {
                                    if (!ji.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> f32 = absVideoPbFragment6.f3(absVideoPbFragment6.v().P1(), this.a.v().f2(), 1);
                                    if (f32 != null) {
                                        this.a.N.j0(((Integer) f32.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) f32.get(R.id.obfuscated_res_0x7f091e56), ((Integer) f32.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) f32.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                    }
                                    this.a.N.I();
                                    if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.v().P1().O();
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
                                dx7 dx7Var13 = this.a.N;
                                if (dx7Var13 != null && dx7Var13.Q() != null && view2 == this.a.N.Q().h()) {
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (!ji.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> f33 = absVideoPbFragment7.f3(absVideoPbFragment7.v().P1(), this.a.v().f2(), 1);
                                    if (f33 != null) {
                                        if (StringUtils.isNull((String) f33.get(R.id.obfuscated_res_0x7f091e55))) {
                                            this.a.N.g0(((Integer) f33.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) f33.get(R.id.obfuscated_res_0x7f091e56), ((Integer) f33.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) f33.get(R.id.obfuscated_res_0x7f091e57)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) f33.get(R.id.obfuscated_res_0x7f091e58)).intValue(), (String) f33.get(R.id.obfuscated_res_0x7f091e56), ((Integer) f33.get(R.id.obfuscated_res_0x7f091e73)).intValue(), ((Boolean) f33.get(R.id.obfuscated_res_0x7f091e57)).booleanValue(), (String) f33.get(R.id.obfuscated_res_0x7f091e55));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091db5 && view2.getId() != R.id.obfuscated_res_0x7f091db3 && view2.getId() != R.id.obfuscated_res_0x7f091690 && view2.getId() != R.id.obfuscated_res_0x7f091534 && view2.getId() != R.id.obfuscated_res_0x7f0916f0) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f0916ee && view2.getId() != R.id.obfuscated_res_0x7f0918b3 && view2.getId() != R.id.obfuscated_res_0x7f09168a) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f09167c && view2.getId() != R.id.obfuscated_res_0x7f09065e) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091681) {
                                                this.a.q3(true);
                                                return;
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f09167e && view2.getId() != R.id.obfuscated_res_0x7f091f99) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0921ca) {
                                                    if (this.a.R0 >= 0) {
                                                        if (this.a.v() != null) {
                                                            this.a.v().h3();
                                                        }
                                                        if (this.a.M3() && this.a.v() != null && this.a.n3() != null && this.a.n3().E0() != null) {
                                                            this.a.n3().E0().f(this.a.v().P1());
                                                        } else if (this.a.W2() != null && this.a.W2().E0() != null) {
                                                            this.a.W2().E0().r(this.a.v().P1());
                                                        }
                                                        this.a.R0 = 0;
                                                        this.a.S0 = Integer.MIN_VALUE;
                                                        if (this.a.M3() && this.a.v() != null && this.a.n3() != null) {
                                                            this.a.n3().j1(this.a.v().I1(), this.a.v().H1());
                                                            this.a.v().l3(0, 0);
                                                            return;
                                                        } else if (this.a.v() == null || this.a.W2() == null) {
                                                            return;
                                                        } else {
                                                            this.a.W2().p1(this.a.v().I1(), this.a.v().H1());
                                                            this.a.v().l3(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                    if (this.a.v() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.a.v().h2());
                                                    statisticItem8.param("fid", this.a.v().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0916b8) {
                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1375);
                                                        String q = ys4.k().q("tail_link", "");
                                                        if (!StringUtils.isNull(q)) {
                                                            TiebaStatic.log("c10056");
                                                            sk4.s(view2.getContext(), string, q, true, true, true);
                                                        }
                                                        this.a.n4();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f090fd2) {
                                                    this.a.n4();
                                                    return;
                                                } else if (this.a.N.Q() != null && view2 == this.a.N.Q().e()) {
                                                    this.a.N.F();
                                                    if (this.a.v() != null) {
                                                        this.a.t.f(this.a.v().h2());
                                                    }
                                                    if (this.a.v() == null || !this.a.v().isPrivacy()) {
                                                        this.a.t.b();
                                                        int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().Q() == null || !this.a.v().P1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                        if (this.a.v() == null || this.a.v().P1() == null) {
                                                            return;
                                                        }
                                                        this.a.t.d(3, i5, this.a.v().P1().Q());
                                                        return;
                                                    }
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0eee);
                                                    if (this.a.v().P1() != null) {
                                                        this.a.t.d(3, 3, this.a.v().P1().Q());
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091692 || view2.getId() == R.id.obfuscated_res_0x7f0916e8) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.a.v().h2());
                                                    statisticItem9.param("fid", this.a.v().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.a.J3()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.a.v().getForumId());
                                                        statisticItem10.param("tid", this.a.v().h2());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param(str, this.a.a3());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.a.Z2());
                                                        TiebaStatic.log(statisticItem10);
                                                    }
                                                    this.a.N.o0(false);
                                                    this.a.N.P().onLongClick(view2);
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                String str3 = str;
                                                if (this.a.v() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.v().P1() == null || this.a.v().P1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    kp7 P1 = this.a.v().P1();
                                                    int reply_num = P1.O().getReply_num();
                                                    int currentItem = this.a.e.getCurrentItem();
                                                    if (reply_num == 0) {
                                                        if (this.a.M3() && currentItem == 0) {
                                                            this.a.e.setCurrentItem(1);
                                                        }
                                                        this.a.O2(false);
                                                        this.a.f4();
                                                        return;
                                                    }
                                                    if (this.a.M3() && currentItem == 0) {
                                                        this.a.e.setCurrentItem(1);
                                                        str2 = "obj_source";
                                                    } else if ((this.a.M3() && this.a.n3() == null) || this.a.W2() == null || this.a.m3() == null) {
                                                        return;
                                                    } else {
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (li.i(this.a.getContext()) * 0.6d);
                                                        BdTypeRecyclerView m3 = this.a.m3();
                                                        if (m3 == null) {
                                                            return;
                                                        }
                                                        boolean canScrollVertically = m3.canScrollVertically(1);
                                                        boolean canScrollVertically2 = m3.canScrollVertically(-1);
                                                        AppBarLayout appBarLayout = this.a.i;
                                                        str2 = "obj_source";
                                                        if (appBarLayout != null) {
                                                            appBarLayout.setExpanded(false, true);
                                                        }
                                                        if (m3.getLayoutManager() == null || !(m3.getLayoutManager() instanceof LinearLayoutManager)) {
                                                            return;
                                                        }
                                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) m3.getLayoutManager();
                                                        if (!canScrollVertically2 && canScrollVertically) {
                                                            if (this.a.P0 == -1 && this.a.Q0 == Integer.MIN_VALUE) {
                                                                return;
                                                            }
                                                            if (this.a.P0 <= 3 && (this.a.P0 != 3 || this.a.Q0 >= (-i6))) {
                                                                if (this.a.P0 < 2) {
                                                                    if (this.a.P0 != 1) {
                                                                        m3.smoothScrollBy(0, -this.a.Q0);
                                                                    } else {
                                                                        int i7 = i6 / 4;
                                                                        linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i7);
                                                                        m3.smoothScrollBy(0, i7);
                                                                    }
                                                                } else {
                                                                    int i8 = i6 / 2;
                                                                    linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i8);
                                                                    m3.smoothScrollBy(0, i8);
                                                                }
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(this.a.P0, this.a.Q0 + i6);
                                                                m3.smoothScrollBy(0, i6);
                                                            }
                                                            param.param("obj_locate", 2);
                                                            i2 = 1;
                                                        } else {
                                                            int firstVisiblePosition = m3.getFirstVisiblePosition();
                                                            View childAt = m3.getChildAt(0);
                                                            int top = childAt == null ? 0 : childAt.getTop();
                                                            this.a.P0 = firstVisiblePosition;
                                                            this.a.Q0 = top;
                                                            if (firstVisiblePosition <= 6 && (firstVisiblePosition != 6 || top >= (-i6) || m3.getCount() < 6)) {
                                                                m3.smoothScrollToPosition(0);
                                                            } else {
                                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                                m3.smoothScrollToPosition(0);
                                                            }
                                                            i2 = 1;
                                                            param.param("obj_locate", 1);
                                                        }
                                                        TiebaStatic.log(param);
                                                        z65 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i2);
                                                        statisticItem11.param("obj_locate", 4);
                                                        statisticItem11.param("tid", this.a.v().h2());
                                                        statisticItem11.param("nid", P1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.a.v() == null || this.a.v().P1() == null || this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 2).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                                                    if (this.a.J3()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.v().getForumId());
                                                        statisticItem12.param("tid", this.a.v().h2());
                                                        statisticItem12.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem12.param(str3, this.a.a3());
                                                        statisticItem12.param(str2, 1);
                                                        statisticItem12.param("obj_type", 12);
                                                        statisticItem12.param("obj_locate", this.a.Z2());
                                                        TiebaStatic.log(statisticItem12);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        String str4 = str;
                                        if (!ji.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.v() == null) {
                                            return;
                                        }
                                        if (this.a.M3() && this.a.n3() == null) {
                                            return;
                                        }
                                        if (this.a.M3() || this.a.W2() != null) {
                                            this.a.N.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09167c || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.D2(11009) || this.a.v() == null) {
                                                    return;
                                                }
                                                this.a.V3();
                                                if (this.a.v().P1() != null && this.a.v().P1().O() != null && this.a.v().P1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.v().h2()).param("fid", this.a.v().P1().m()).param("obj_locate", 3).param("uid", this.a.v().P1().O().getAuthor().getUserId()));
                                                    if (this.a.J3()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.v().getForumId());
                                                        statisticItem13.param("tid", this.a.v().h2());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.a3());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.Z2());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.a.v().P1().O() == null || this.a.v().P1().O().getAuthor() == null || this.a.v().P1().O().getAuthor().getUserId() == null || this.a.P == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                int S = absVideoPbFragment10.N.S(absVideoPbFragment10.v().P1());
                                                ThreadData O2 = this.a.v().P1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.v().h2()).param("obj_locate", 1).param("obj_id", this.a.v().P1().O().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.z = view2;
                                            return;
                                        }
                                        return;
                                    }
                                    String str5 = str;
                                    if (this.a.v() == null) {
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916ee) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.v().h2());
                                        statisticItem14.param("fid", this.a.v().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918b3) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0916ee && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2.get(R.id.obfuscated_res_0x7f091e70) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e70);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0916ee && (statisticItem = postData2.i0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918b3 || view2.getId() == R.id.obfuscated_res_0x7f09168a) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.v().i2()).param("fid", this.a.v().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData2.I()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.v() == null || this.a.v().P1() == null || this.a.L0 == null || postData2.s() == null || postData2.A() == 1) {
                                                return;
                                            }
                                            if (this.a.K0 != null) {
                                                this.a.K0.c();
                                            }
                                            if (this.a.U0 && postData2.R() != null && postData2.R().size() != 0) {
                                                this.a.V4(postData2, null, true, false);
                                                return;
                                            }
                                            aq7 aq7Var2 = new aq7();
                                            aq7Var2.A(this.a.v().P1().l());
                                            aq7Var2.E(this.a.v().P1().O());
                                            aq7Var2.C(postData2);
                                            this.a.L0.U(aq7Var2);
                                            this.a.L0.setPostId(postData2.I());
                                            this.a.T3(view2, postData2.s().getUserId(), "", postData2);
                                            if (this.a.I0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.w4(absVideoPbFragment11.I0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091534) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.v().h2());
                                        statisticItem15.param("fid", this.a.v().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.J3()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.v().getForumId());
                                            statisticItem16.param("tid", this.a.v().h2());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.a3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.Z2());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view2.getId() == R.id.obfuscated_res_0x7f091690 || view2.getId() == R.id.obfuscated_res_0x7f0916f0) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view2;
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091690 && this.a.J3()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.v().getForumId());
                                        statisticItem17.param("tid", this.a.v().h2());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.a3());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.Z2());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.v().P1().m()));
                                    } else if (this.a.v() == null || this.a.v().P1() == null) {
                                    } else {
                                        dx7 dx7Var14 = this.a.N;
                                        if (dx7Var14 != null) {
                                            dx7Var14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e70);
                                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e71);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.E() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData3.i0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091534) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091690) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.X4();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.a.V4(postData3, postData4, false, true);
                                        } else {
                                            this.a.V4(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!ji.z()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c34);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.X4();
                            this.a.D4();
                            if (view2.getId() == R.id.obfuscated_res_0x7f09160c) {
                                F3 = this.a.v().F3(true, this.a.a3());
                            } else {
                                F3 = view2.getId() == R.id.obfuscated_res_0x7f09025b ? this.a.v().F3(false, this.a.a3()) : this.a.v().E3(this.a.a3());
                            }
                            view2.setTag(Boolean.valueOf(F3));
                            if (F3) {
                                this.a.N4();
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

    /* loaded from: classes3.dex */
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
                this.a.n4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y1 implements u15 {
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

        @Override // com.repackage.u15
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                qt7 qt7Var = this.a.F0;
                if (qt7Var == null || qt7Var.e() == null || !this.a.F0.e().d()) {
                    return !this.a.F2(ReplyPrivacyCheckController.TYPE_THREAD);
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

    /* loaded from: classes3.dex */
    public class z extends mc5<ShareItem> {
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
        @Override // com.repackage.mc5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel v = this.b.v();
                if (v != null) {
                    v.o3(this.a);
                }
                return fv7.d(this.b.V2(), 2, v);
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.L0.P(postData);
                if (this.a.W2() != null) {
                    this.a.W2().g1();
                } else if (this.a.M3() && this.a.n3() != null) {
                    this.a.n3().d1();
                }
                this.a.K0.c();
                this.a.J0.q();
                this.a.K4(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class z1 implements Comparator<ry4> {
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
        public int compare(ry4 ry4Var, ry4 ry4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ry4Var, ry4Var2)) == null) ? ry4Var.compareTo(ry4Var2) : invokeLL.intValue;
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
        N1 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        O1 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
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
        this.h0 = false;
        this.k0 = null;
        this.n0 = null;
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

    public final void A2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || v() == null || this.a == null) {
            return;
        }
        x15 x15Var = this.I0;
        if (x15Var == null || !x15Var.v) {
            w15 w15Var = new w15();
            A4(w15Var);
            x15 x15Var2 = (x15) w15Var.a(getContext());
            this.I0 = x15Var2;
            x15Var2.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.F(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.I0.a().C(true);
            u4(this.I0.a());
            if (!v().C1()) {
                this.I0.s(v().h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (v().v2()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde));
            } else {
                this.I0.k0(o3());
            }
        }
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u4(this.I0.a());
        }
    }

    public final void A4(z15 z15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z15Var) == null) || z15Var == null || v() == null) {
            return;
        }
        z15Var.p(v().o1());
        if (v().P1() != null && v().P1().l() != null) {
            z15Var.o(v().P1().l());
        }
        z15Var.q("pb");
        z15Var.r(v());
    }

    public void B2(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().C(firstVisiblePosition)) != null && postData.p() != null) {
                        postData.p().q(postData.A());
                        arrayList.add(postData.p());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((ry4) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    c4((ry4) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    c4((ry4) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void B3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            z15 z15Var = new z15();
            this.H0 = z15Var;
            A4(z15Var);
            x15 x15Var = (x15) this.H0.a(getActivity());
            this.I0 = x15Var;
            x15Var.e0(this.a.getPageContext());
            this.I0.n0(this.k1);
            this.I0.o0(this.C1);
            this.I0.g0(1);
            this.I0.F(this.a.getPageContext(), bundle);
            this.I0.a().b(new c05(getActivity()));
            this.I0.a().C(true);
            H4(true);
            if (v() != null) {
                this.I0.O(v().r1(), v().h2(), v().n1());
            }
            registerListener(this.c1);
            registerListener(this.e1);
            registerListener(this.m1);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.f1);
            registerListener(this.K1);
            if (!v().C1()) {
                this.I0.s(v().h2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.k0(TbSingleton.getInstance().getAdVertiComment());
            } else if (v().v2()) {
                this.I0.k0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde));
            } else {
                this.I0.k0(o3());
            }
            this.F0 = new qt7();
            if (this.I0.v() != null) {
                this.F0.m(this.I0.v().i());
            }
            this.I0.d0(this.a1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.C0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public void B4(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            dx7 dx7Var = this.N;
            if (dx7Var == null) {
                return;
            }
            if (z2) {
                dx7Var.F();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.N.G();
            } else {
                this.N.F();
            }
        }
    }

    public final boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            PbModel v2 = v();
            if (v2 == null || v2.P1() == null) {
                return false;
            }
            ThreadData O = v2.P1().O();
            v2.P1().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09171f);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09171e);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09171b);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09171a);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f09171d);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901e8);
            this.G.setRadius(li.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new pt4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (v() == null || v().P1() == null) {
                return;
            }
            M4(v().P1());
        }
    }

    public void C4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            hideProgressBar();
            if (M3() && n3() != null) {
                n3().R0();
                n3().S0();
            } else if (W2() != null) {
                W2().T0();
                W2().U0();
            }
        }
    }

    public final boolean D2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f09232d);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c8);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f091d96);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091d9b);
            this.o = findViewById;
            if (this.q1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = li.s(w());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = li.s(w());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.D1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f092442);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f08060f, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05d2, this.D1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0914e8);
            int f2 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(f2, f2);
            layoutParams3.rightMargin = f3;
            this.r.setLayoutParams(layoutParams3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.s, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.r.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
            this.t1 = new GestureDetector(getContext(), this.u1);
            this.m.setOnTouchListener(this.s1);
        }
    }

    public void D4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            li.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if ((v() != null && v().P1().g0()) || this.C0 == null || v() == null || v().P1() == null || ThreadCardUtils.isSelf(v().P1().O()) || v().P1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeInvokeEditor(v().P1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void E3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.j();
        x15 x15Var = this.I0;
        if (x15Var != null) {
            x15Var.P();
        }
        r3();
    }

    public final void E4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || v() == null) {
            return;
        }
        int Y1 = v().Y1();
        if (i2 == 5) {
            v().w3(2);
        } else if (i2 == 6) {
            v().w3(3);
        } else if (i2 != 7) {
            v().w3(1);
        } else {
            v().w3(4);
        }
        int Y12 = v().Y1();
        if (Y1 == 4 || Y12 == 4) {
            Z3();
        }
    }

    public boolean F2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (this.C0 == null || v() == null || v().P1() == null || ThreadCardUtils.isSelf(v().P1().O()) || v().P1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeSend(v().P1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void F3(kp7 kp7Var) {
        nv4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, kp7Var) == null) || this.W0 == null || kp7Var == null || kp7Var.g() == 3 || J3()) {
            return;
        }
        if (kp7Var.k0()) {
            pbAdFloatViewItemData = kp7Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a() && getContext() != null) {
            if (!RightFloatLayerView.k()) {
                w3();
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
            this.X0.setLogoListener(new g0(this, kp7Var, pbAdFloatViewItemData));
            this.X0.setFeedBackListener(new r0(this, pbAdFloatViewItemData));
            return;
        }
        w3();
    }

    public void F4(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (view2 = this.g) == null) {
            return;
        }
        view2.setVisibility(i2);
    }

    public void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!checkUpIsLogin()) {
                if (v() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", v().getForumId()));
                }
            } else if (E2()) {
                x15 x15Var = this.I0;
                if (x15Var != null && (x15Var.B() || this.I0.D())) {
                    this.I0.z(false, null);
                    return;
                }
                if (this.J0 != null) {
                    E3();
                    this.u0.a = false;
                    if (this.J0.n(2) != null) {
                        lg8.c(getPageContext(), (View) this.J0.n(2).m, false, null);
                    }
                }
                r3();
            }
        }
    }

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.d.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = li.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), li.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), li.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), li.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
            layoutParams2.gravity = 16;
            this.d.setExpandedTabLayoutParams(layoutParams2);
        }
    }

    public void G4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            this.u = z2;
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (v().u1() || v().x1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", v().h2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, v().h2()));
            if (Z4()) {
                this.a.finish();
            }
        }
    }

    public void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            y16 y16Var = new y16(getActivity());
            this.M0 = y16Var;
            y16Var.i(this.A1);
            this.q1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            D3();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090292);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f091721);
            this.W0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091aa1);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09170f);
            ix7 ix7Var = new ix7(getContext(), this.j);
            this.k = ix7Var;
            ix7Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.Y0(this);
            this.k.W0(w().getRootView());
            this.k.X0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091bf5)).setMinimumHeight(((int) Math.ceil((li.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091725);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f09171c);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f091727);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090fd2);
            this.A = (MaskView) this.c.findViewById(R.id.obfuscated_res_0x7f091380);
            this.h.setOnClickListener(this.D1);
            G3();
            C3();
            y3();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0923c0);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090958);
            v4();
            this.K.setAnimationListener(new s0(this));
            A3();
            z3();
            if (!this.q1 && this.r1) {
                T4();
                UtilHelper.hideStatusBar(w(), w().getRootView());
                this.r1 = false;
            }
            if (M3()) {
                return;
            }
            this.d.getLayoutParams().height = 0;
        }
    }

    public final void H4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.I0.f0(z2);
            this.I0.i0(z2);
            this.I0.p0(z2);
        }
    }

    public void I2(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            List<PostData> list = v().P1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).R().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).R().get(i3).I())) {
                        list.get(i2).R().remove(i3);
                        list.get(i2).k();
                        z2 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                list.get(i2).m(bVar.g);
            }
            if (z2) {
                if (W2() != null) {
                    W2().g1();
                } else if (M3() && n3() != null) {
                    n3().d1();
                }
            }
        }
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.l == null) {
            this.l = new sw7(getBaseFragmentActivity(), this.j);
            int s2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? li.s(w()) : 0;
            Rect rect = new Rect(0, s2, li.k(getContext()), this.j.getOriginHeight() + s2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (M3() && (videoPbViewModel.n() || v().g2() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || v().g2() == 0) {
                this.e.setCurrentItem(0);
            }
        }
    }

    public final void I4(int i2, AntiData antiData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048602, this, i2, antiData, str) == null) {
            if (AntiHelper.m(i2, str)) {
                if (AntiHelper.w(getPageContext().getPageActivity(), str, i2, new e1(this)) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
                }
            } else if (i2 == 230277) {
                dx7 dx7Var = this.N;
                if (dx7Var != null) {
                    dx7Var.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    public void J2(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (v().k1() != null) {
                        v().k1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.T.R()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e56);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e73)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e57)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e58)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e6a) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6a)).booleanValue() : false;
                if (jSONArray != null) {
                    this.T.T(StringHelper.JsonArrayToString(jSONArray));
                }
                this.T.U(v().P1().l().getId(), v().P1().l().getName(), v().P1().O().getId(), str, intValue3, intValue2, booleanValue, v().P1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public abstract boolean J3();

    public final void J4(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                dy4.c(getPageContext(), postWriteCallBackData, 2);
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1117);
            }
            if (StringUtils.isNull(colorMsg)) {
                li.O(getPageContext().getPageActivity(), errorString);
                return;
            }
            String str = errorString + " " + preMsg + colorMsg;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0305));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, errorString.length() + preMsg.length() + 1, str.length(), 17);
            li.J(getPageContext().getPageActivity(), str, spannableString, 3000);
            return;
        }
        if (v() != null && !v().C1()) {
            antiData.setBlock_forum_name(v().P1().l().getName());
            antiData.setBlock_forum_id(v().P1().l().getId());
            antiData.setUser_name(v().P1().U().getUserName());
            antiData.setUser_id(v().P1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void K2(dq4 dq4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, dq4Var, jSONArray) == null) {
            dq4Var.dismiss();
            if (v() == null || v().P1() == null || v().P1().O() == null || v().P1().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (dq4Var.getYesButtonTag() instanceof SparseArray) {
                    J2((SparseArray) dq4Var.getYesButtonTag(), jSONArray);
                    return;
                }
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
        }
    }

    public boolean K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            EditorTools editorTools = this.J0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) || this.k0 == null) {
            return;
        }
        w4(this.I0.C());
        if (this.w0) {
            L4(z2);
        } else {
            s3(z2);
        }
        d4();
        g4();
    }

    public void L2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e56, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e58, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z2));
            sparseArray.put(0, 3);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                J2(sparseArray, null);
            } else {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    public abstract boolean L3();

    public void L4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) || this.k0 == null || (textView = this.n0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0514);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? (J3() || v() == null || !v().D2()) ? false : true : invokeV.booleanValue;
    }

    public final void M4(kp7 kp7Var) {
        gx7 G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, kp7Var) == null) || (G = kp7Var.G()) == null || G.l) {
            return;
        }
        z2(G);
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ix7 ix7Var = this.k;
            return ix7Var != null && ix7Var.N0();
        }
        return invokeV.booleanValue;
    }

    public void N4() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(0);
    }

    public void O2(boolean z2) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048618, this, z2) == null) || (appBarLayout = this.i) == null) {
            return;
        }
        appBarLayout.setExpanded(z2);
    }

    public boolean O3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.r1 : invokeV.booleanValue;
    }

    public final void O4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
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

    public final void P2(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048621, this, bVar, z2) == null) && bVar != null && isAdded()) {
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f04a9);
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                dq4 dq4Var = new dq4(getPageContext().getPageActivity());
                dq4Var.setMessage(string);
                dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e8, new r(this));
                dq4Var.setCancelable(true);
                dq4Var.create(getPageContext());
                dq4Var.show();
            } else {
                Q2(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> F = v().P1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).I())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    v().P1().O().setReply_num(v().P1().O().getReply_num() - 1);
                    if (W2() != null) {
                        W2().g1();
                    } else if (M3() && n3() != null) {
                        n3().d1();
                    }
                } else if (i3 == 0) {
                    H2();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = v().P1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).R().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).R().get(i5).I())) {
                                F2.get(i4).R().remove(i5);
                                F2.get(i4).k();
                                z3 = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        F2.get(i4).m(bVar.g);
                    }
                    if (z3) {
                        if (W2() != null) {
                            W2().g1();
                        } else if (M3() && n3() != null) {
                            n3().d1();
                        }
                    }
                    I2(bVar);
                }
            }
        }
    }

    public boolean P3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            ix7 ix7Var = this.k;
            if (ix7Var == null) {
                return false;
            }
            return ix7Var.O0();
        }
        return invokeV.booleanValue;
    }

    public final void P4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            hx7.c(w(), V2(), i2);
        }
    }

    public void Q2(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1229));
            } else if (z3) {
                if (ki.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                }
                showToast(str);
            }
        }
    }

    public final void Q3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || v() == null || ki.isEmpty(v().h2())) {
            return;
        }
        mh4.x().Q(lh4.X, jg.g(v().h2(), 0L));
    }

    public final void R2(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048627, this, i2, gVar) == null) || gVar == null || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        Q2(this.T.getLoadDataMode(), gVar.a, gVar.b, false);
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
                v().P1().O().setIs_good(1);
                v().p3(1);
            } else if (i2 == 3) {
                v().P1().O().setIs_good(0);
                v().p3(0);
            } else if (i2 == 4) {
                v().P1().O().setIs_top(1);
                v().q3(1);
            } else if (i2 == 5) {
                v().P1().O().setIs_top(0);
                v().q3(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                string = gVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f0cf9);
            }
            li.O(getPageContext().getPageActivity(), string);
        }
        if (M3()) {
            if (v().P1().O() == null || X2() == null) {
                return;
            }
            X2().W0();
        } else if (v().P1().O() == null || W2() == null) {
        } else {
            W2().n1();
        }
    }

    public /* synthetic */ void R3() {
        String o3;
        if (v() != null && v().v2()) {
            o3 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0dde);
        } else {
            o3 = o3();
        }
        if (!StringUtils.isNull(o3) && v() != null && v().P1() != null) {
            o3 = TbSingleton.getInstance().getAdVertiComment(v().P1().k0(), v().P1().l0(), o3);
        }
        x15 x15Var = this.I0;
        if (x15Var != null) {
            x15Var.k0(o3);
        }
        TextView textView = this.n0;
        if (textView != null) {
            textView.setText(o3);
        }
        K4(false);
        O4();
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || this.v.getLayoutParams() == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            b5();
        }
    }

    public final String S2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0db5);
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

    public final void S3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || this.m0 == null) {
            return;
        }
        N2();
        this.m0.setImageResource(R.drawable.obfuscated_res_0x7f080986);
    }

    public final void S4() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.v.setAlpha(0.0f);
            this.v.setVisibility(0);
            d5(layoutParams);
        }
    }

    public ix4 T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.S : (ix4) invokeV.objValue;
    }

    public final void T3(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048634, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || C2() || !E2()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.N0);
            this.O0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.K0 != null && postData != null) {
            this.K0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fc6), postData.s().getName_show(), postData.P() != null ? postData.P().toString() : ""));
        }
        if (v() != null && v().P1() != null && v().P1().g0()) {
            mg.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.E0 == null) {
            xk6 xk6Var = new xk6(getPageContext());
            this.E0 = xk6Var;
            xk6Var.j(1);
            this.E0.i(new j1(this, str, str2));
        }
        if (v() == null || v().P1() == null || v().P1().l() == null) {
            return;
        }
        this.E0.g(v().P1().l().getId(), jg.g(v().h2(), 0L));
    }

    public final void T4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (this.x1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.x1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.x1.start();
        }
    }

    public LinearLayout U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.l0 : (LinearLayout) invokeV.objValue;
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || v() == null) {
            return;
        }
        kp7 P12 = v().P1();
        v().C3(true);
        kk4 kk4Var = this.P;
        if (kk4Var != null) {
            P12.E0(kk4Var.g());
        }
        if (M3()) {
            if (X2() != null) {
                X2().P0();
            }
            if (n3() != null) {
                n3().d1();
            }
        } else if (W2() != null) {
            W2().g1();
        }
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            if (this.w1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.w1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.w1.start();
        }
    }

    @Override // com.repackage.pw7
    public PbModel.h V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.Y0 : (PbModel.h) invokeV.objValue;
    }

    public final int V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (v() == null || v().P1() == null || v().P1().O() == null) {
                return -1;
            }
            return v().P1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void V3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || v() == null || v().P1() == null) {
            return;
        }
        if (M3() && n3() == null) {
            return;
        }
        if ((M3() || W2() != null) && this.P != null) {
            MarkData markData = null;
            if (v().P1() != null && v().P1().g0()) {
                markData = v().f1(0);
            } else {
                CustomViewPager customViewPager = this.e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = v().J1(Y2(v().P1()));
                } else if (M3()) {
                    if (n3() != null) {
                        markData = v().f1(n3().W0());
                    }
                } else if (W2() != null) {
                    markData = v().f1(W2().Y0());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && n3() != null && (markData = v().f1(n3().W0() + 1)) == null) {
                return;
            }
            D4();
            this.P.i(markData);
            if (!this.P.e()) {
                if (v() != null && !fv7.k(v().h2())) {
                    this.r0.o(2);
                    fv7.b(v().h2());
                }
                this.P.a();
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                return;
            }
            this.P.d();
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
        }
    }

    public final void V4(PostData postData, PostData postData2, boolean z2, boolean z3) {
        AbsPbActivity.e n2;
        boolean z4;
        PostData Y2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String h2 = v().h2();
            String I = postData.I();
            String I2 = postData2 != null ? postData2.I() : "";
            int V = v().P1() != null ? v().P1().V() : 0;
            if (n3() != null && n3().b1() != null) {
                n2 = n3().b1().n(I);
            } else if (W2() == null || W2().d1() == null) {
                return;
            } else {
                n2 = W2().d1().n(I);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || v() == null || v().P1() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(h2, I, "pb", true, J3(), null, false, I2, V, postData.U(), v().P1().d(), false, postData.s().getIconInfo(), Z2(), Z2() == 1 || Z2() == 2 || Z2() == 3 || Z2() == 4 || Z2() == 5).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(I2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(v().getForumId());
            addBigImageData.setTiebaPlusData(v().H(), v().D(), v().E(), v().C(), v().I());
            addBigImageData.setBjhData(v().h1());
            addBigImageData.setKeyPageStartFrom(v().O1());
            addBigImageData.setFromFrsForumId(v().getFromForumId());
            addBigImageData.setWorksInfoData(v().m2());
            addBigImageData.setIsOpenEditor(z2);
            if (v().P1().o() != null) {
                addBigImageData.setHasForumRule(v().P1().o().has_forum_rule.intValue());
            }
            if (v().P1().U() != null) {
                addBigImageData.setIsManager(v().P1().U().getIs_manager());
            }
            if (v().P1().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(v().P1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(v().P1().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (v().P1().l() != null) {
                addBigImageData.setForumHeadUrl(v().P1().l().getImage_url());
                addBigImageData.setUserLevel(v().P1().l().getUser_level());
            }
            if (v() != null && (Y2 = Y2(v().P1())) != null) {
                if (!Y2.Q && !postData.Q) {
                    z4 = false;
                }
                addBigImageData.setMainPostMaskVisibly(z4);
            }
            if (J3() && this.a.getIntent() != null) {
                addBigImageData.setFromVideoPageUniqueId((BdUniqueId) this.a.getIntent().getSerializableExtra("key_from_video_page_id"));
            }
            addBigImageData.setForceInterceptStimeStat(this.a.isForceInterceptStimeStat());
            sendMessage(new CustomMessage(2002001, addBigImageData));
        }
    }

    public DetailInfoAndReplyFragment W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoAndReplyFragment)) {
                return null;
            }
            return (DetailInfoAndReplyFragment) this.f.b(0);
        }
        return (DetailInfoAndReplyFragment) invokeV.objValue;
    }

    public final boolean W3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = ys4.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    sk4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0535), q2 + "?props_id=" + str, true, true, true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void W4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.F();
    }

    public DetailInfoFragment X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(0) instanceof DetailInfoFragment)) {
                return null;
            }
            return (DetailInfoFragment) this.f.b(0);
        }
        return (DetailInfoFragment) invokeV.objValue;
    }

    public boolean X3(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        ix7 ix7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048647, this, i2, keyEvent)) == null) {
            if (!this.q1 && (this.r1 || N3())) {
                T4();
                UtilHelper.hideStatusBar(w(), w().getRootView());
                this.r1 = false;
                ix7 ix7Var2 = this.k;
                if (ix7Var2 != null) {
                    ix7Var2.T0(false);
                }
            }
            if (i2 == 4) {
                ix7 ix7Var3 = this.k;
                if (ix7Var3 != null) {
                    return ix7Var3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                ix7 ix7Var4 = this.k;
                if (ix7Var4 != null) {
                    return ix7Var4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (ix7Var = this.k) == null) {
                return false;
            } else {
                return ix7Var.Q0();
            }
        }
        return invokeIL.booleanValue;
    }

    public final void X4() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || (voiceManager = this.U) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public PostData Y2(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, kp7Var)) == null) {
            PostData postData = null;
            if (kp7Var == null) {
                return null;
            }
            if (kp7Var.W() != null) {
                return kp7Var.W();
            }
            if (!ListUtils.isEmpty(kp7Var.F())) {
                Iterator<PostData> it = kp7Var.F().iterator();
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
                postData = kp7Var.j();
            }
            if (postData == null) {
                postData = l3(kp7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void Y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z2) == null) {
            this.h.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void Y4() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.superCloseActivity();
    }

    public abstract int Z2();

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            if (!ji.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c34);
            } else if (this.N == null || v() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                X4();
                D4();
                if (v().loadData()) {
                    N4();
                }
            }
        }
    }

    public final boolean Z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (v() == null) {
                return true;
            }
            if (v().P1() == null || !v().P1().g0()) {
                if (v().A1()) {
                    MarkData l12 = v().l1();
                    if (l12 != null && v().y1() && m3() != null) {
                        MarkData f12 = v().f1(m3().getFirstVisiblePosition());
                        if (f12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", l12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (f12.getPostId() != null && !f12.getPostId().equals(l12.getPostId())) {
                            dq4 dq4Var = new dq4(getBaseFragmentActivity());
                            dq4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025f));
                            dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f042e, new t(this, f12, l12, dq4Var));
                            dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new u(this, l12, dq4Var));
                            dq4Var.setOnCalcelListener(new w(this));
                            dq4Var.create(getBaseFragmentActivity().getPageContext());
                            dq4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", l12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (v().P1() != null && v().P1().F() != null && v().P1().F().size() > 0 && v().y1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String a3() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (v() == null || v().P1() == null || v().P1().F() == null || (count = ListUtils.getCount((F = v().P1().F()))) == 0) {
                return "";
            }
            if (v().a2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.A() == 1) {
                        return next.I();
                    }
                }
            }
            int i2 = 0;
            if (m3() != null) {
                if (M3()) {
                    if (n3() != null) {
                        i2 = n3().U0();
                    }
                } else if (W2() != null) {
                    i2 = W2().W0();
                }
            }
            PostData postData = (PostData) ListUtils.getItem(F, i2);
            if (postData != null && postData.s() != null) {
                if (v().F2(postData.s().getUserId())) {
                    return postData.I();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (v().F2(postData2.s().getUserId())) {
                        return postData2.I();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (v().F2(postData3.s().getUserId())) {
                        return postData3.I();
                    }
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void a4(int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            if (i2 == 0) {
                bf8.g().h(getUniqueId(), false);
                if (m3() != null) {
                    B2(m3(), true);
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

    public void a5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            x15 x15Var = this.I0;
            if (x15Var != null) {
                w4(x15Var.C());
            }
            n4();
            this.N.F();
        }
    }

    public abstract int b3();

    public void b4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) || w() == null) {
            return;
        }
        if (this.r1 && !TbSingleton.getInstance().isNotchScreen(w()) && !TbSingleton.getInstance().isCutoutScreen(w())) {
            T4();
            UtilHelper.hideStatusBar(w(), w().getRootView());
            this.r1 = false;
        }
        this.u0.b = z2;
        d4();
        g4();
    }

    public final void b5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
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

    public boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void c4(ry4 ry4Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048662, this, ry4Var, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.D(ry4Var, getPageContext(), i2, false);
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    public View.OnClickListener d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.D1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.u0.a()) {
            this.k.X(false);
            return;
        }
        ix7 ix7Var = this.k;
        if (!J3() && !this.k.O0()) {
            z2 = true;
        }
        ix7Var.X(z2);
    }

    public final void d5(ViewGroup.LayoutParams layoutParams) {
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

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.s
    public void decorateText(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048667, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX)) {
            return;
        }
        Object[] objArr = (se5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), se5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (tt7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(FoldCommentActivity.PB_LITERATURE_LOOK_MORE_ICON_SUFFIX);
                spannableStringBuilder2.setSpan(new hd5(drawable), 0, 33, 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                spannableStringBuilder.setSpan(objArr[i2], spannableStringBuilder.getSpanStart(objArr[i2]), spannableStringBuilder.length(), 18);
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                return;
            }
        }
    }

    public View.OnClickListener e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.E1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void e4(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048669, this, kp7Var) == null) || kp7Var == null) {
            return;
        }
        ThreadData O = kp7Var.O();
        if (O != null && O.isUgcThreadType()) {
            A2();
        } else {
            A4(this.H0);
        }
        x15 x15Var = this.I0;
        if (x15Var != null) {
            w4(x15Var.C());
            this.I0.M(kp7Var.d());
            this.I0.N(kp7Var.l(), kp7Var.U());
            this.I0.r0(O);
            if (v() != null) {
                this.I0.O(v().r1(), v().h2(), v().n1());
            }
            if (O != null) {
                this.I0.h0(O.isMutiForumThread());
            }
        }
    }

    public final void e5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, layoutParams) == null) {
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

    public SparseArray<Object> f3(kp7 kp7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Y2;
        tn4 tn4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048671, this, new Object[]{kp7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (kp7Var == null || (Y2 = Y2(kp7Var)) == null) {
                return null;
            }
            String userId = Y2.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e56, Y2.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(kp7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Y2.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e61, Y2.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e62, Y2.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e63, Y2.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e64, Y2.I());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e56, Y2.I());
                sparseArray.put(R.id.obfuscated_res_0x7f091e58, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e57, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e73, Integer.valueOf(kp7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e97, Boolean.TRUE);
            }
            if (!z3) {
                List<np4> p2 = kp7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (np4 np4Var : p2) {
                        if (np4Var != null && !StringUtils.isNull(np4Var.a()) && (tn4Var = np4Var.g) != null && tn4Var.a && !tn4Var.c && ((i3 = tn4Var.b) == 1 || i3 == 2)) {
                            sb.append(ki.cutString(np4Var.a(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0652));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e55, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049c), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || !checkUpIsLogin() || v() == null || v().P1() == null || v().P1().l() == null || C2()) {
            return;
        }
        if (v().P1().g0()) {
            G2();
            return;
        }
        if (this.D0 == null) {
            xk6 xk6Var = new xk6(getPageContext());
            this.D0 = xk6Var;
            xk6Var.j(0);
            this.D0.i(new d1(this));
        }
        this.D0.g(v().P1().l().getId(), jg.g(v().h2(), 0L));
    }

    public final void f5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || v() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.D(v().getForumId()) || v().P1() == null || v().P1().l() == null) {
            return;
        }
        if (v().P1().l().isLike() == 1) {
            v().c1().C(v().getForumId(), v().h2());
        }
    }

    @Override // com.repackage.pw7
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            PbModel pbModel = this.a.getPbModel();
            if (pbModel != null && pbModel.P1() != null && !pbModel.P1().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = pbModel.P1().O().getId();
                if (pbModel.isShareThread() && pbModel.P1().O().originalThreadData != null) {
                    historyMessage.threadName = pbModel.P1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = pbModel.P1().O().getTitle();
                }
                if (pbModel.isShareThread() && !isSimpleForum()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = pbModel.P1().l().getName();
                }
                ArrayList<PostData> F = pbModel.P1().F();
                int U0 = n3() != null ? n3().U0() : 0;
                if (F != null && U0 >= 0 && U0 < F.size()) {
                    historyMessage.postID = F.get(U0).I();
                }
                historyMessage.isHostOnly = pbModel.s1();
                historyMessage.isSquence = pbModel.f2();
                historyMessage.isShareThread = pbModel.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            x15 x15Var = this.I0;
            if (x15Var != null) {
                x15Var.I();
            }
            if (pbModel != null && (pbModel.u1() || pbModel.x1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", pbModel.h2());
                if (this.y0) {
                    if (this.A0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", pbModel.D1());
                    }
                    if (this.z0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", pbModel.z1());
                    }
                }
                if (pbModel.P1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = pbModel.P1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (Z4()) {
                if (pbModel != null) {
                    kp7 P12 = pbModel.P1();
                    if (P12 != null) {
                        if (P12.U() != null) {
                            P12.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.B0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                gt7.b().t(rect);
                            }
                            gt7.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView m3 = m3();
                            gt7.b().n(pbModel.Q1(), m3 != null ? m3.onSaveInstanceState() : null, pbModel.f2(), pbModel.s1(), false);
                        }
                    }
                } else {
                    gt7.b().m();
                }
                Y4();
            }
        }
    }

    public kk4 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.P : (kk4) invokeV.objValue;
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048676, this) == null) || this.k == null || this.e == null) {
            return;
        }
        boolean z2 = false;
        if (!M3()) {
            this.k.S0(false);
        } else if (this.e.getCurrentItem() != 0) {
            this.k.S0(false);
        } else if (this.u0.a()) {
            this.k.S0(false);
        } else {
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            if (videoPbViewModel != null) {
                this.k.S0((videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || videoPbViewModel.e().getValue().booleanValue()) ? true : true);
            }
        }
    }

    public void g5(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, kp7Var) == null) {
            if (kp7Var != null && AntiHelper.o(kp7Var.O())) {
                tx7 tx7Var = this.r0;
                if (tx7Var != null) {
                    tx7Var.l(false);
                    this.r0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.q0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080950, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            tx7 tx7Var2 = this.r0;
            if (tx7Var2 == null || !tx7Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.q0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f080950, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.repackage.ve5
    public ag<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            if (this.V == null) {
                this.V = new ag<>(new u1(this), 20, 0);
            }
            return this.V;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (this.X == null) {
                this.X = new ag<>(new t1(this), 8, 0);
            }
            return this.X;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048682, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.repackage.ve5
    public ag<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            ag<RelativeLayout> agVar = new ag<>(new x1(this), 10, 0);
            this.g0 = agVar;
            return agVar;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.ve5
    public ag<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (this.W == null) {
                this.W = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.W;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            if (this.Z == null) {
                this.Z = new ag<>(new w1(this), 15, 0);
            }
            return this.Z;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (this.U == null) {
                this.U = VoiceManager.instance();
            }
            return this.U;
        }
        return (VoiceManager) invokeV.objValue;
    }

    @Override // com.repackage.ve5
    public ag<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            if (this.Y == null) {
                this.Y = new ag<>(new v1(this), 8, 0);
            }
            return this.Y;
        }
        return (ag) invokeV.objValue;
    }

    public View.OnLongClickListener h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.L1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void h4(boolean z2, int i2, int i3, int i4, kp7 kp7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048691, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), kp7Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof ow7) {
                    ((ow7) baseFragment).v0(z2, i2, i3, i4, kp7Var, str, i5);
                }
            }
            v0(z2, i2, i3, i4, kp7Var, str, i5);
        }
    }

    public void h5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) {
            DetailInfoAndReplyFragment W2 = W2();
            if (W2 != null && W2.E0() != null && W2.E0().f() != null && W2.E0().g() != null) {
                W2.E0().f().O0(z2);
                W2.E0().g().m0(z2);
            }
            MaskView maskView = this.A;
            if (maskView != null) {
                maskView.setVisibility(z2 ? 0 : 8);
            }
        }
    }

    public View.OnTouchListener i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.z1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void i4(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048694, this, kp7Var) == null) || kp7Var == null || kp7Var.O() == null) {
            return;
        }
        g5(kp7Var);
        this.p0.setVisibility(kp7Var.g0() ? 8 : 0);
        if (kp7Var.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08094c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08094b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String S2 = S2(kp7Var.O().getReply_num());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(S2);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(S2);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, kp7Var.O()));
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            kk4 c3 = kk4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.Z0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y1);
            this.S = new ix4(getPageContext());
            this.N = new dx7(this);
        }
    }

    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            PbModel pbModel = this.a.getPbModel();
            if (pbModel == null) {
                return false;
            }
            return pbModel.E2();
        }
        return invokeV.booleanValue;
    }

    public x15 j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.I0 : (x15) invokeV.objValue;
    }

    public void j4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048698, this, z2, markData) == null) || v() == null) {
            return;
        }
        C4();
        v().C3(z2);
        kk4 kk4Var = this.P;
        if (kk4Var != null) {
            kk4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (v().A1()) {
            U3();
        } else if (M3()) {
            if (X2() != null) {
                X2().P0();
            }
            if (n3() != null) {
                n3().d1();
            }
        } else if (W2() != null) {
            W2().g1();
        }
    }

    public final int k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048699, this, i2)) == null) {
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

    public void k4(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, kp7Var) == null) || kp7Var == null || kp7Var.O() == null) {
            return;
        }
        String valueOf = String.valueOf(kp7Var.O().getReply_num());
        if (kp7Var.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.d.F(valueOf);
    }

    public final PostData l3(kp7 kp7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048701, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.O() == null || kp7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = kp7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = kp7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.p0(1);
            postData.u0(kp7Var.O().getFirstPostId());
            postData.G0(kp7Var.O().getTitle());
            postData.F0(kp7Var.O().getCreateTime());
            postData.n0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void l4(aq7 aq7Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048702, this, aq7Var) == null) || v() == null || v().P1() == null || aq7Var.i() == null) {
            return;
        }
        String I = aq7Var.i().I();
        ArrayList<PostData> F = v().P1().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.I() == null || !postData.I().equals(I)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = aq7Var.k();
                postData.D0(aq7Var.m());
                if (postData.R() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Y() != null && next != null && next.s() != null && (metaData = postData.Y().get(next.s().getUserId())) != null) {
                            next.n0(metaData);
                            next.x0(true);
                            next.J0(getPageContext(), v().F2(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.R().size();
                    if (!postData.c0(true)) {
                        postData.R().clear();
                        postData.R().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.x() != null) {
                    postData.l0();
                }
            }
        }
        if (v().y1() || !z2) {
            return;
        }
        if (M3() && n3() != null) {
            n3().d1();
        } else if (W2() != null) {
            W2().g1();
        }
    }

    public BdTypeRecyclerView m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            Iterator<BaseFragment> it = this.f.c().iterator();
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
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public final void m4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048704, this) == null) || this.I0 == null || this.J0 == null) {
            return;
        }
        t15.a().c(0);
        this.I0.T();
        this.I0.R();
        if (this.I0.y() != null) {
            this.I0.y().setMaxImagesAllowed(this.I0.v ? 1 : 9);
        }
        this.I0.l0(SendView.g);
        this.I0.j(SendView.g);
        zz4 m2 = this.J0.m(23);
        zz4 m3 = this.J0.m(2);
        zz4 m4 = this.J0.m(5);
        if (m3 != null) {
            m3.e();
        }
        if (m4 != null) {
            m4.e();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.J0.invalidate();
    }

    public ReplyFragment n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || !(videoPbFragmentAdapter.b(1) instanceof ReplyFragment)) {
                return null;
            }
            return (ReplyFragment) this.f.b(1);
        }
        return (ReplyFragment) invokeV.objValue;
    }

    public void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            m4();
            t3();
            this.K0.c();
            K4(false);
        }
    }

    public String o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            if (!ki.isEmpty(this.v0)) {
                return this.v0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(mt7.b());
            this.v0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f0906b0));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            e4(videoPbViewModel.c());
            F3(videoPbViewModel.c());
            k4(videoPbViewModel.c());
            if (v() != null && v().P1() != null) {
                boolean y12 = v().y1();
                kp7 P12 = v().P1();
                if (y12) {
                    PostData Y2 = Y2(P12);
                    if (P12.u() != null && !P12.u().equals(Y2.I()) && this.e != null) {
                        if (M3()) {
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
            this.a.getTiePlusEventController().l(this.V0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048710, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.I0.H(i2, i3, intent);
            nu7 nu7Var = this.Q;
            if (nu7Var != null) {
                nu7Var.i(i2, i3, intent);
            }
            ks7 ks7Var = this.K0;
            if (ks7Var != null) {
                ks7Var.g(i2, i3, intent);
            }
            if (i2 == 25035) {
                p3(i3, intent);
            }
            if (i3 == -1) {
                if (i2 == 11009) {
                    V3();
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
                            if (U2() != null) {
                                U2().performClick();
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
                    t68.g().m(getPageContext());
                }
            }
        }
    }

    @Override // com.repackage.ve5
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048711, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.h0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048713, this, i2) == null) {
            super.onChangeSkinType(i2);
            UtilHelper.changeStatusBarIconAndTextColor(true, this.a);
            getBaseFragmentActivity().getLayoutMode().k(i2 == 1);
            getBaseFragmentActivity().getLayoutMode().j(this.c);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0611);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0608);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0207);
            NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.d;
            if (newPagerSlidingTabBaseStrip != null) {
                newPagerSlidingTabBaseStrip.G();
            }
            qt7 qt7Var = this.F0;
            if (qt7Var != null) {
                qt7Var.i();
            }
            sw7 sw7Var = this.l;
            if (sw7Var == null || !sw7Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.J0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            ks7 ks7Var = this.K0;
            if (ks7Var != null) {
                ks7Var.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            LinearLayout linearLayout = this.l0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(li.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (v() != null && v().A1()) {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08094c, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f08094b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.o0, R.drawable.obfuscated_res_0x7f08094e, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.m0, R.drawable.obfuscated_res_0x7f080986, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f080910, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (v() != null) {
                g5(v().P1());
            }
            SkinManager.setBackgroundResource(this.g, R.drawable.personalize_tab_shadow);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0206);
            SkinManager.setBackgroundColor(this.k0, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.j0, R.color.CAM_X0203);
            SkinManager.setViewTextColor(this.D, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.C, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n0, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundShapeDrawable(this.s0, li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
            if (W2() != null) {
                W2().onChangeSkinType(i2);
            } else if (M3() && n3() != null) {
                n3().onChangeSkinType(i2);
            }
            if (X2() != null) {
                X2().onChangeSkinType(i2);
            }
            View view2 = this.H;
            if (view2 != null) {
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(li.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            X4();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            ix7 ix7Var = this.k;
            if (ix7Var == null || ix7Var.O0()) {
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
        if (interceptable == null || interceptable.invokeL(1048715, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            B3(bundle);
            getVoiceManager().onCreate(getPageContext());
            ct4 ct4Var = new ct4();
            this.O = ct4Var;
            ct4Var.a = 1000L;
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
            this.t = new lv5(getPageContext());
            bf8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048716, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(b3(), viewGroup, false);
            H3();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onDestroy();
            bf8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.H1);
            getVoiceManager().onDestory(getPageContext());
            tx7 tx7Var = this.r0;
            if (tx7Var != null) {
                tx7Var.k();
            }
            ForumManageModel forumManageModel = this.T;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            ix7 ix7Var = this.k;
            if (ix7Var != null) {
                ix7Var.P0();
            }
            nu7 nu7Var = this.Q;
            if (nu7Var != null) {
                nu7Var.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.C0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (v() != null) {
                v().cancelLoadData();
                v().destory();
                if (v().L1() != null) {
                    v().L1().d();
                }
            }
            x15 x15Var = this.I0;
            if (x15Var != null) {
                x15Var.I();
            }
            this.O = null;
            W4();
        }
    }

    @Override // com.repackage.ve5
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048718, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.h0 = true;
    }

    @Override // com.repackage.ve5
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048719, this, context, str, z2) == null) {
            if (tt7.c(str) && v() != null && v().h2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", v().h2()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    gz4 gz4Var = new gz4();
                    gz4Var.a = str;
                    gz4Var.b = 3;
                    gz4Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, gz4Var));
                }
            } else {
                tt7.a().e(getPageContext(), str);
            }
            this.h0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onPause();
            this.T0 = true;
            getVoiceManager().onPause(getPageContext());
            ix7 ix7Var = this.k;
            if (ix7Var != null) {
                ix7Var.onBackground(true);
            }
            if (v() != null && !v().C1()) {
                this.I0.U(v().h2());
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            mh4.x().F();
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // com.repackage.ve5
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048721, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.p0(str);
        fq4 R = this.N.R();
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
        this.h0 = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            super.onResume();
            this.T0 = false;
            getVoiceManager().onResume(getPageContext());
            ix7 ix7Var = this.k;
            if (ix7Var != null) {
                ix7Var.onBackground(false);
            }
            Q4();
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
        if (interceptable == null || interceptable.invokeL(1048723, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (v() != null) {
                v().i3(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.repackage.ve5
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048724, this, context, str) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            super.onStart();
            getVoiceManager().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            super.onStop();
            getVoiceManager().onStop(getPageContext());
            bf8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.I1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z2) == null) {
            super.onUserChanged(z2);
            S3();
        }
    }

    @Override // com.repackage.ve5
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048728, this, context, str) == null) {
            tt7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.h0 = true;
        }
    }

    @Override // com.repackage.ve5
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048729, this, context, str) == null) {
        }
    }

    public final void p3(int i2, Intent intent) {
        f05 f05Var;
        ks7 ks7Var;
        f05 f05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048730, this, i2, intent) == null) {
            if (i2 == 0) {
                t3();
                ks7 ks7Var2 = this.K0;
                if (ks7Var2 != null) {
                    ks7Var2.c();
                }
                K4(false);
            }
            n4();
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
                    this.I0.S();
                    this.I0.t0(pbEditorData.getVoiceModel());
                    this.I0.G(writeData);
                    e05 n2 = this.I0.a().n(6);
                    if (n2 != null && (f05Var = n2.m) != null) {
                        f05Var.onAction(new sz4(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.I0.L(null, null);
                    }
                } else if (editorType != 1 || (ks7Var = this.K0) == null || ks7Var.b() == null) {
                } else {
                    a25 b3 = this.K0.b();
                    b3.c0(v().P1().O());
                    b3.B(writeData);
                    b3.d0(pbEditorData.getVoiceModel());
                    e05 n3 = b3.a().n(6);
                    if (n3 != null && (f05Var2 = n3.m) != null) {
                        f05Var2.onAction(new sz4(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        b3.F();
                    }
                }
            }
        }
    }

    public void p4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            this.P0 = -1;
            this.Q0 = Integer.MIN_VALUE;
        }
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
    public void q3(boolean z2) {
        kp7 P12;
        int i2;
        tx7 tx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) || v() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (P12 = v().P1()) == null) {
            return;
        }
        ThreadData O = P12.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", v().h2()).param("fid", P12.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (J3()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", v().getForumId());
                statisticItem.param("tid", v().h2());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", a3());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 14);
                statisticItem.param("obj_locate", Z2());
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
            statisticItem2.param("tid", v().h2());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", v().getForumId());
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
                if (O.getBaijiahaoData() != null && !ki.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (w() != null) {
                e75.e(w(), statisticItem2);
            }
            tx7Var = this.r0;
            if (tx7Var != null) {
                statisticItem2.param("obj_param1", tx7Var.g());
            }
            TiebaStatic.log(statisticItem2);
            if (li.D()) {
                showToast(R.string.obfuscated_res_0x7f0f0c33);
                return;
            } else if (v().P1() == null) {
                li.O(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                return;
            } else {
                ArrayList<PostData> F = P12.F();
                if ((F == null || F.size() <= 0) && v().f2()) {
                    li.O(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dce));
                    return;
                }
                this.N.F();
                X4();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                tx7 tx7Var2 = this.r0;
                if (tx7Var2 != null) {
                    tx7Var2.l(false);
                    g5(P12);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.r0.i()) {
                        this.r0.m(false);
                        x3(xx4.a(), this.r0.g());
                        return;
                    }
                    P4(i4);
                    return;
                }
                this.N.B0();
                v().j1().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", v().h2());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", v().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!ki.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (w() != null) {
        }
        tx7Var = this.r0;
        if (tx7Var != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (li.D()) {
        }
    }

    public boolean q4(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048733, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091e54);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.u()) && am4.c().g()) {
                        return W3(postData.I());
                    }
                    if (checkUpIsLogin() && v() != null && v().P1() != null) {
                        ks7 ks7Var = this.K0;
                        if (ks7Var != null) {
                            ks7Var.c();
                        }
                        aq7 aq7Var = new aq7();
                        aq7Var.A(v().P1().l());
                        aq7Var.E(v().P1().O());
                        aq7Var.C(postData);
                        this.L0.U(aq7Var);
                        this.L0.setPostId(postData.I());
                        T3(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        x15 x15Var = this.I0;
                        if (x15Var != null) {
                            w4(x15Var.C());
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

    public void r3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048734, this) == null) || this.k0 == null) {
            return;
        }
        this.j0.setVisibility(8);
        this.k0.setVisibility(8);
        this.u0.a = false;
        d4();
        g4();
    }

    public final void r4(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048735, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            nu7 nu7Var = new nu7(this.a);
            this.Q = nu7Var;
            nu7Var.n(this.C1);
            this.Q.m(this.k1);
        }
        this.Q.k(emotionImageData, v(), v().P1());
    }

    @Override // com.repackage.pw7
    public AbsVideoPbFragment s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) || this.k0 == null || this.n0 == null) {
            return;
        }
        if (v() != null && v().P1() != null) {
            this.n0.setText(TbSingleton.getInstance().getAdVertiComment(v().P1().k0(), v().P1().l0(), o3()));
        } else {
            this.n0.setText(o3());
        }
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

    public final void s4(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048738, this, i2) == null) || v() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(v().h2());
        sendMessage(privacySettingMessage);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || (customViewPager = this.e) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public void t3() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.o();
    }

    public void t4(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048741, this, i2) == null) || (linearLayout = this.i0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public String taskActionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? "712" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void taskStart() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048743, this) == null) || v() == null || ki.isEmpty(v().h2())) {
            return;
        }
        super.taskStart();
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048744, this) == null) || this.a.getCurrentFocus() == null) {
            return;
        }
        li.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void u4(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, editorTools) == null) {
            this.J0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f091679);
            this.J0.setOnCancelClickListener(new f1(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.J0.getParent() == null) {
                this.c.addView(this.J0, layoutParams);
            }
            this.J0.w(TbadkCoreApplication.getInst().getSkinType());
            this.J0.setActionListener(24, new g1(this));
            t3();
            this.I0.i(new h1(this));
        }
    }

    @Override // com.repackage.pw7
    public PbModel v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) ? this.a.getPbModel() : (PbModel) invokeV.objValue;
    }

    @Override // com.repackage.ow7
    public void v0(boolean z2, int i2, int i3, int i4, kp7 kp7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048747, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), kp7Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void v3() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.K.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.nw7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AbsVideoPbFragment.this.R3();
                    }
                }
            });
        }
    }

    @Override // com.repackage.pw7
    public AbsPbActivity w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public final void w2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        ThreadData O = v().P1().O();
        O.mRecomAbTag = v().U1();
        O.mRecomWeight = v().X1();
        O.mRecomSource = v().W1();
        O.mRecomExtra = v().V1();
        O.isSubPb = v().C1();
        if (O.getFid() == 0) {
            O.setFid(jg.g(v().getForumId(), 0L));
        }
        StatisticItem i2 = e75.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public void w3() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || (rightFloatLayerView = this.X0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void w4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048753, this, z2) == null) {
            this.w0 = z2;
        }
    }

    public final void x2(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048754, this, z2, str) == null) || v() == null || v().P1() == null || v().P1().O() == null) {
            return;
        }
        ThreadData O = v().P1().O();
        O.mRecomAbTag = v().U1();
        O.mRecomWeight = v().X1();
        O.mRecomSource = v().W1();
        O.mRecomExtra = v().V1();
        if (O.getFid() == 0) {
            O.setFid(jg.g(v().getForumId(), 0L));
        }
        StatisticItem i2 = e75.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l2 = e75.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, rc5.d(str) > 40 ? rc5.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            z65 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            if (Z2() == 1) {
                i2.param("obj_locate", 4);
            } else if (Z2() == 2) {
                i2.param("obj_locate", 5);
            } else if (Z2() == 3) {
                i2.param("obj_locate", 2);
            } else if (Z2() == 4) {
                i2.param("obj_locate", 3);
            } else if (Z2() == 7) {
                i2.param("obj_locate", 7);
            } else {
                i2.param("obj_locate", 6);
            }
            i2.addParam("obj_type", 1);
            i2.addParam("tid", v().h2());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", v().P1().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = e75.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", v().h2());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", v().P1().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = e75.i(getContext(), O, "c14303");
        if (i4 != null) {
            if (Z2() == 1) {
                i4.param("obj_locate", 1);
            } else if (Z2() == 2) {
                i4.param("obj_locate", 2);
            } else if (Z2() == 3) {
                i4.param("obj_locate", 3);
            } else if (Z2() == 4) {
                i4.param("obj_locate", 4);
            }
            i4.param("tid", v().h2());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", v().P1().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void x3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048755, this, i2, i3) == null) {
            pc5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void x4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z2) == null) {
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
    public final void y2(ThreadData threadData) {
        double d2;
        int i2;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect g12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, threadData) == null) {
            double k2 = li.k(getContext());
            double i3 = (2.0d * k2) / li.i(getContext());
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
                    int height = (v() != null || (g12 = v().g1()) == null) ? ceil : g12.height();
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
                    if (M3()) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = new RelativeLayout.LayoutParams(-1, O1);
                        } else {
                            layoutParams3.height = O1;
                        }
                        this.d.setLayoutParams(layoutParams3);
                    }
                    layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
                    if (M3()) {
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
            if (v() != null) {
            }
            i2 = 0;
            layoutParams = this.j.getLayoutParams();
            if (layoutParams != null) {
            }
            this.j.setLayoutParams(layoutParams);
            this.j.setMaxHeight(ceil2);
            this.j.setMinHeight((int) Math.ceil(k2 / 1.7777777777777777d));
            this.j.setOriginHeight(height);
            if (M3()) {
            }
            layoutParams2 = (CoordinatorLayout.LayoutParams) this.i.getLayoutParams();
            if (M3()) {
            }
            if (layoutParams2 != null) {
            }
            this.i.setLayoutParams(layoutParams2);
            if (i2 == 0) {
            }
        }
    }

    public final void y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.i0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09232c);
            this.j0 = this.c.findViewById(R.id.obfuscated_res_0x7f09238a);
            this.k0 = this.c.findViewById(R.id.obfuscated_res_0x7f09167d);
            li.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            li.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09084c);
            this.m0 = imageView;
            imageView.setOnClickListener(new u0(this));
            S3();
            this.n0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091680);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091678);
            this.l0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09167e);
            this.o0 = imageView2;
            imageView2.setOnClickListener(this.D1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09167c);
            this.p0 = imageView3;
            imageView3.setOnClickListener(this.D1);
            if (booleanExtra) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setVisibility(0);
            }
            if (L3()) {
                this.o0.setVisibility(0);
            } else {
                this.o0.setVisibility(8);
                this.p0.setPadding(li.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, li.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091681);
            this.q0 = imageView4;
            imageView4.setOnClickListener(this.D1);
            this.r0 = new tx7(this.q0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.r0.f();
            }
            if (v() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !fv7.k(v().h2())) {
                this.r0.f();
                fv7.b(v().h2());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09167f);
            this.s0 = textView;
            textView.setVisibility(0);
            K4(false);
        }
    }

    public void y4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) {
            this.r1 = z2;
        }
    }

    @Override // com.repackage.pw7
    public PbFragment z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void z2(gx7 gx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048761, this, gx7Var) == null) && gx7Var != null && this.w == null) {
            this.w = gx7Var;
            this.C.setText(gx7Var.getTitle());
            this.D.setText(gx7Var.m());
            String k2 = gx7Var.k();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(k2)) {
                k2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0ded);
            }
            tBSpecificationBtn.setText(k2);
            this.G.K(gx7Var.g(), 10, false);
            this.H.setVisibility(gx7Var.q() ? 0 : 8);
            mg.a().postDelayed(new k1(this), gx7Var.e().longValue() * 1000);
        }
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048762, this) == null) {
            this.L0 = new PbFakeFloorModel(getPageContext());
            PbModel v2 = v();
            this.L0.R(v2.H(), v2.D(), v2.E(), v2.C(), v2.I());
            this.L0.setFromForumId(v2.getFromForumId());
            ks7 ks7Var = new ks7(getPageContext(), this.L0, this.c);
            this.K0 = ks7Var;
            ks7Var.k(new y0(this));
            this.K0.n(this.B1);
            this.L0.T(new z0(this));
        }
    }

    public abstract void z4(boolean z2);

    /* loaded from: classes3.dex */
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
