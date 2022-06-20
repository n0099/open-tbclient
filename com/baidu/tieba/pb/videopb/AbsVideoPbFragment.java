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
import com.repackage.a88;
import com.repackage.ad5;
import com.repackage.am6;
import com.repackage.av7;
import com.repackage.az7;
import com.repackage.c9;
import com.repackage.cl4;
import com.repackage.dc5;
import com.repackage.do4;
import com.repackage.ed5;
import com.repackage.eg;
import com.repackage.eh8;
import com.repackage.ez4;
import com.repackage.fg;
import com.repackage.gc5;
import com.repackage.gd5;
import com.repackage.h05;
import com.repackage.hr7;
import com.repackage.ht4;
import com.repackage.hx4;
import com.repackage.i05;
import com.repackage.i25;
import com.repackage.j25;
import com.repackage.jh8;
import com.repackage.k25;
import com.repackage.km4;
import com.repackage.ko8;
import com.repackage.kw5;
import com.repackage.ky4;
import com.repackage.ky7;
import com.repackage.l25;
import com.repackage.lt4;
import com.repackage.lx7;
import com.repackage.m25;
import com.repackage.mw7;
import com.repackage.n75;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nq4;
import com.repackage.nu7;
import com.repackage.nw4;
import com.repackage.ny7;
import com.repackage.o05;
import com.repackage.o25;
import com.repackage.oi;
import com.repackage.oy7;
import com.repackage.p25;
import com.repackage.pf5;
import com.repackage.pi;
import com.repackage.pq4;
import com.repackage.py7;
import com.repackage.qg;
import com.repackage.qy4;
import com.repackage.r05;
import com.repackage.rq7;
import com.repackage.rt7;
import com.repackage.s75;
import com.repackage.sf5;
import com.repackage.sr7;
import com.repackage.t05;
import com.repackage.tu7;
import com.repackage.u05;
import com.repackage.uf8;
import com.repackage.uk4;
import com.repackage.uu4;
import com.repackage.uv7;
import com.repackage.vh4;
import com.repackage.vx4;
import com.repackage.vx7;
import com.repackage.vz4;
import com.repackage.wd5;
import com.repackage.wh4;
import com.repackage.wx7;
import com.repackage.xp4;
import com.repackage.xp7;
import com.repackage.xu7;
import com.repackage.xv4;
import com.repackage.y26;
import com.repackage.yt4;
import com.repackage.zx7;
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
public abstract class AbsVideoPbFragment extends BaseFragment implements sf5, VoiceManager.j, wx7, TbRichTextView.s, vx7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int N1;
    public static final int O1;
    public static int P1;
    public transient /* synthetic */ FieldHolder $fh;
    public MaskView A;
    public boolean A0;
    public final y26.b A1;
    public View.OnClickListener B;
    public boolean B0;
    public NewWriteModel.e B1;
    public TextView C;
    public ReplyPrivacyCheckController C0;
    public k25 C1;
    public TextView D;
    public am6 D0;
    public final View.OnClickListener D1;
    public ImageView E;
    public am6 E0;
    public View.OnClickListener E1;
    public TBSpecificationBtn F;
    public xu7 F0;
    public final AdapterView.OnItemClickListener F1;
    public TbImageView G;
    public PermissionJudgePolicy G0;
    public CustomMessageListener G1;
    public View H;
    public o25 H0;
    public CustomMessageListener H1;
    public ValueAnimator I;
    public m25 I0;
    public CustomMessageListener I1;
    public ValueAnimator J;
    public EditorTools J0;
    public final ItemCardHelper.c J1;
    public FallingView K;
    public rt7 K0;
    public CustomMessageListener K1;
    public boolean L;
    public PbFakeFloorModel L0;
    public final View.OnLongClickListener L1;
    public View M;
    public y26 M0;
    public SortSwitchButton.f M1;
    public ky7 N;
    public int[] N0;
    public lt4 O;
    public int O0;
    public uk4 P;
    public int P0;
    public uv7 Q;
    public int Q0;
    public EmotionImageData R;
    public int R0;
    public vx4 S;
    public int S0;
    public ForumManageModel T;
    public boolean T0;
    public VoiceManager U;
    public boolean U0;
    public eg<GifView> V;
    @NonNull
    public TiePlusEventController.f V0;
    public eg<TextView> W;
    public FrameLayout W0;
    public eg<ImageView> X;
    public RightFloatLayerView X0;
    public eg<View> Y;
    public final PbModel.h Y0;
    public eg<LinearLayout> Z;
    public final uk4.a Z0;
    public AbsPbActivity a;
    public j25 a1;
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
    public eg<RelativeLayout> g0;
    public CustomMessageListener g1;
    public View h;
    public boolean h0;
    public CustomMessageListener h1;
    public AppBarLayout i;
    public LinearLayout i0;
    public CustomMessageListener i1;
    public VideoContainerLayout j;
    public View j0;
    public j25 j1;
    public py7 k;
    public View k0;
    public final NewWriteModel.e k1;
    public zx7 l;
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
    public az7 r0;
    public boolean r1;
    public ImageView s;
    public TextView s0;
    public View.OnTouchListener s1;
    public kw5 t;
    public TextView t0;
    public GestureDetector t1;
    public boolean u;
    public c2 u0;
    public GestureDetector.SimpleOnGestureListener u1;
    public View v;
    public String v0;
    public Runnable v1;
    public ny7 w;
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
            this.a.E5();
        }
    }

    /* loaded from: classes3.dex */
    public class a0 implements gc5<ShareItem> {
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
        @Override // com.repackage.gc5
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.F() == null || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean) || ((Boolean) customResponsedMessage.getData()).booleanValue()) {
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
                this.a.T5();
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
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091e8c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8c)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea0) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea0)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091e8a) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e8a)).booleanValue() : false;
            ky7 ky7Var = this.a.N;
            if (ky7Var != null) {
                if (booleanValue) {
                    if (booleanValue2) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e5c, 1);
                        this.a.N.B(sparseArray);
                        return;
                    }
                    ky7Var.l0(view2);
                } else if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e5c, 0);
                    sparseArray.put(R.id.obfuscated_res_0x7f091e45, 1);
                    this.a.N.B(sparseArray);
                } else if (booleanValue3) {
                    ky7Var.g0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
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
                ky7 ky7Var = this.a.N;
                if (ky7Var != null) {
                    ky7Var.F();
                }
                boolean z = false;
                if (!ni.z()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                    return false;
                }
                if (this.a.F() != null && !this.a.F().isLoading) {
                    this.a.L5();
                    this.a.r5();
                    z = true;
                    if (this.a.F().Q1() != null && this.a.F().Q1().f != null && this.a.F().Q1().f.size() > i) {
                        int intValue = this.a.F().Q1().f.get(i).sort_type.intValue();
                        TiebaStatic.log(new StatisticItem("c13699").param("tid", this.a.F().j2()).param("fid", this.a.F().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", b(intValue)));
                        if (this.a.F().H3(intValue)) {
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
            xp7 xp7Var = (xp7) customResponsedMessage.getData();
            int type = xp7Var.getType();
            if (type == 0) {
                this.a.Z4((hr7) xp7Var.a());
            } else if (type == 1) {
                this.a.D3((ForumManageModel.b) xp7Var.a(), false);
            } else if (type != 2) {
            } else {
                if (xp7Var.a() == null) {
                    this.a.X4(false, null);
                } else {
                    this.a.X4(true, (MarkData) xp7Var.a());
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
                            bdTopToast.h(this.a.getString(R.string.obfuscated_res_0x7f0f0319));
                            bdTopToast.j((ViewGroup) this.a.getView());
                            this.a.s5(type);
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37);
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
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.F() == null || this.a.F().Z1() == i + 1) {
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.a;
            absVideoPbFragment.g5(absVideoPbFragment.Y3(i));
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
        public void b(rq7 rq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rq7Var) == null) {
            }
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.h
        public void c(boolean z, int i, int i2, int i3, rq7 rq7Var, String str, int i4) {
            String c4;
            o05 m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), rq7Var, str, Integer.valueOf(i4)}) == null) {
                if (PbLoadingViewOptimizeSwitch.isSwitchOn() && this.a.getBaseFragmentActivity() != null) {
                    this.a.getBaseFragmentActivity().hideLoadingView(this.a.getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09069b));
                }
                this.a.q5();
                this.a.j4();
                if (this.a.L) {
                    this.a.L = false;
                }
                this.a.y5(false);
                if (z && rq7Var != null) {
                    ThreadData O = rq7Var.O();
                    ((VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class)).t(rq7Var, i2);
                    this.a.S4(rq7Var);
                    this.a.A5(rq7Var);
                    this.a.Y4(rq7Var);
                    this.a.V4(z, i, i2, i3, rq7Var, str, i4);
                    TbadkCoreApplication.getInst().setDefaultBubble(rq7Var.U().getBimg_url());
                    TbadkCoreApplication.getInst().setDefaultBubbleEndTime(rq7Var.U().getBimg_end_time());
                    if (rq7Var.F() != null && rq7Var.F().size() >= 1 && rq7Var.F().get(0) != null) {
                        this.a.F().n3(rq7Var.F().get(0).J());
                    } else if (rq7Var.W() != null) {
                        this.a.F().n3(rq7Var.W().J());
                    }
                    if (this.a.P != null) {
                        this.a.P.h(rq7Var.r());
                    }
                    AntiData d = rq7Var.d();
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
                    this.a.t4(rq7Var);
                    if (this.a.F() != null && this.a.F().w2()) {
                        c4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0de4);
                    } else {
                        c4 = this.a.c4();
                    }
                    if (!StringUtils.isNull(c4)) {
                        this.a.I0.l0(TbSingleton.getInstance().getAdVertiComment(rq7Var.k0(), rq7Var.l0(), c4));
                    }
                } else {
                    if (i == 4 || i == 350008) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("tid", this.a.F().i2());
                            jSONObject.put("fid", this.a.F().getForumId());
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
                            if (this.a.F() != null && this.a.F().Q1() != null) {
                                arrayList = this.a.F().Q1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.b4().Y1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09fb));
                            } else if (this.a.b4().S1()) {
                                this.a.b4().Z1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd5));
                            } else {
                                this.a.b4().Z1(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd6));
                            }
                        } else {
                            this.a.b4().Y1("");
                        }
                        this.a.b4().F1();
                    } else {
                        if (i != -1) {
                            if (this.a.F() != null && this.a.F().Q1() != null) {
                                arrayList = this.a.F().Q1().F();
                            }
                            if (ListUtils.getCount(arrayList) != 0 && (ListUtils.getCount(arrayList) != 1 || arrayList.get(0) == null || arrayList.get(0).B() != 1)) {
                                this.a.K3().f2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09fb));
                            } else if (this.a.K3().W1()) {
                                this.a.K3().g2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd5));
                            } else {
                                this.a.K3().g2(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0dd6));
                            }
                        } else {
                            this.a.K3().f2("");
                        }
                        this.a.K3().H1();
                    }
                }
                uf8.g().h(this.a.getUniqueId(), false);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.N != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ko8) && customResponsedMessage.getOrginalMessage().getTag() == this.a.N.D) {
                ko8 ko8Var = (ko8) customResponsedMessage.getData();
                this.a.N.V();
                SparseArray<Object> sparseArray = (SparseArray) this.a.N.O();
                DataRes dataRes = ko8Var.a;
                if (ko8Var.c == 0 && dataRes != null) {
                    int e = ng.e(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    r3 = e == 1;
                    if (oi.isEmpty(str)) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e9a, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.obfuscated_res_0x7f091e9a, str);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea0, Boolean.TRUE);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ea0, Boolean.FALSE);
                }
                int intValue = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e5c)).intValue();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pf5.a)) {
                pf5.a aVar = (pf5.a) customResponsedMessage.getData();
                pf5.c(this.a.getPageContext(), this.a, aVar.a, aVar.b, aVar.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d1 implements am6.d {
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

        @Override // com.repackage.am6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.am6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.I0 != null && this.a.I0.a() != null) {
                    this.a.I0.a().A(new h05(45, 27, null));
                }
                this.a.u3();
            }
        }

        @Override // com.repackage.am6.d
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
            ky7 ky7Var = this.a.N;
            if (tag == ky7Var.D) {
                ky7Var.V();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                rq7 Q1 = this.a.F().Q1();
                if (Q1 != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    Q1.v().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b34));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b30);
                    }
                    this.a.N.K0(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.N.D0();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (oi.isEmpty(errorString2)) {
                        errorString2 = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b31);
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
            jh8 jh8Var;
            AgreeData agreeData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof jh8) || (jh8Var = (jh8) customResponsedMessage.getData()) == null || (agreeData = jh8Var.b) == null || agreeData.agreeType != 2 || this.a.r0 == null || this.a.F() == null || !UbsABTestHelper.isResizeInduceSharingABTestA() || mw7.k(this.a.F().i2())) {
                return;
            }
            this.a.r0.o(2);
            mw7.b(this.a.F().i2());
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
        public void onNavigationButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nq4Var) == null) {
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
            ky7 ky7Var = this.a.N;
            if (tag == ky7Var.D) {
                ky7Var.V();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.O.c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14b2));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (oi.isEmpty(muteMessage)) {
                    muteMessage = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14b1);
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
            py7 py7Var;
            BdTypeRecyclerView a4;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || threadData == null || threadData.getThreadVideoInfo() == null || (py7Var = this.a.k) == null) {
                return;
            }
            if (py7Var.c0() != null && this.a.k.c0().equals(threadData.getThreadVideoInfo().video_url)) {
                this.a.k.setData(threadData);
                return;
            }
            if (!oi.isEmpty(this.a.k.c0())) {
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
                this.a.b5();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements j25 {
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

        @Override // com.repackage.j25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xu7 xu7Var = this.a.F0;
                if (xu7Var == null || xu7Var.g() == null || !this.a.F0.g().d()) {
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

    /* loaded from: classes3.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rq7 a;
        public final /* synthetic */ xv4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public g0(AbsVideoPbFragment absVideoPbFragment, rq7 rq7Var, xv4 xv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, rq7Var, xv4Var};
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
            this.a = rq7Var;
            this.b = xv4Var;
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
    public class g1 implements i05 {
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

        @Override // com.repackage.i05
        public void C(h05 h05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, h05Var) == null) {
                Object obj = h05Var.c;
                if ((obj instanceof nw4) && EmotionGroupType.isSendAsPic(((nw4) obj).getType())) {
                    if (this.a.G0 == null) {
                        this.a.G0 = new PermissionJudgePolicy();
                    }
                    this.a.G0.clearRequestPermissionList();
                    this.a.G0.appendRequestPermission(this.a.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.G0.startRequestPermission(this.a.getBaseFragmentActivity())) {
                        return;
                    }
                    this.a.I0.h((nw4) h05Var.c);
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
                this.b.a.Q4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nq4.e {
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

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements nq4.e {
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

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            String str;
            String userId;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.F() != null && this.a.F().Q1() != null) {
                        statisticItem.param("fid", this.a.F().Q1().m());
                    }
                    statisticItem.param("tid", this.a.F().i2());
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
                    uu4.b(writeData.getContent(), "3");
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
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                            return;
                        } else {
                            DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                            return;
                        }
                    } else if (postWriteCallBackData == null || !postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                        if (hx4Var != null || i == 227001) {
                            return;
                        }
                        this.a.w5(i, antiData, str);
                        return;
                    } else {
                        nq4 nq4Var = new nq4(this.a.getActivity());
                        if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                            nq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ced));
                        } else {
                            nq4Var.setMessage(postWriteCallBackData.getErrorString());
                        }
                        nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this));
                        nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new c(this));
                        nq4Var.create(this.a.getPageContext()).show();
                        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                        return;
                    }
                }
                if (PbReplySwitch.getInOn() && this.a.F() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    this.a.F().Y0(postWriteCallBackData.getPostId());
                    if (this.a.A4() && this.a.b4() != null) {
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.R0 = absVideoPbFragment.b4().I1();
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        absVideoPbFragment2.S0 = absVideoPbFragment2.b4().J1();
                        this.a.F().m3(this.a.R0, this.a.S0);
                    } else if (this.a.K3() != null) {
                        AbsVideoPbFragment absVideoPbFragment3 = this.a;
                        absVideoPbFragment3.R0 = absVideoPbFragment3.K3().K1();
                        AbsVideoPbFragment absVideoPbFragment4 = this.a;
                        absVideoPbFragment4.S0 = absVideoPbFragment4.K3().L1();
                        this.a.F().m3(this.a.R0, this.a.S0);
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
                this.a.F().r2();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921306));
                this.a.x5(antiData, postWriteCallBackData);
                if (writeData == null) {
                    return;
                }
                String floor = writeData.getFloor();
                if (writeData == null || writeData.getType() != 2) {
                    if (this.a.F().t1()) {
                        rq7 Q1 = this.a.F().Q1();
                        if (Q1 != null && Q1.O() != null && Q1.O().getAuthor() != null && (userId = Q1.O().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && this.a.F().E3()) {
                            this.a.r5();
                        }
                    } else if (!PbReplySwitch.getInOn() && this.a.F().E3()) {
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
                    qg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
                }
                AbsVideoPbFragment absVideoPbFragment6 = this.a;
                if (writeData != null && writeData.getType() == 2) {
                    z2 = true;
                }
                absVideoPbFragment6.l3(z2, writeData != null ? writeData.getContent() : "");
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
            xu7 xu7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (xu7Var = this.a.F0) == null || xu7Var.e() == null) {
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
            py7 py7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (py7Var = this.a.k) == null) {
                return;
            }
            py7Var.V0(threadData);
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
                xu7 xu7Var;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (xu7Var = this.a.c.F0) == null || xu7Var.g() == null) {
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
                int i2 = pi.i(this.c.a.getApplicationContext());
                if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                    i = TbadkCoreApplication.getInst().getKeyboardHeight();
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                } else {
                    i = i2 / 2;
                    f = pi.f(this.c.getPageContext().getPageActivity(), R.dimen.tbds256);
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
                    this.c.K0.o(this.a, this.b, this.c.c4(), (this.c.F() == null || this.c.F().Q1() == null || this.c.F().Q1().O() == null || !this.c.F().Q1().O().isBjh()) ? false : false);
                    this.c.K0.l(this.c.N3());
                    p25 b = this.c.K0.b();
                    if (b != null && this.c.F() != null && this.c.F().Q1() != null) {
                        b.G(this.c.F().Q1().d());
                        b.c0(this.c.F().Q1().O());
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
                absVideoPbFragment.k5(absVideoPbFragment.I0.C());
            }
            this.a.y5(false);
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
            py7 py7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) || (py7Var = this.a.k) == null) {
                return;
            }
            py7Var.U0(threadData);
        }
    }

    /* loaded from: classes3.dex */
    public class j1 implements am6.d {
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
            public class C0233a implements TextWatcher {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0233a(a aVar) {
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
                    xu7 xu7Var;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || (xu7Var = this.a.a.c.F0) == null || xu7Var.g() == null) {
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
                    int i2 = pi.i(this.a.c.getContext());
                    if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                        i = TbadkCoreApplication.getInst().getKeyboardHeight();
                        f = pi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
                    } else {
                        i = i2 / 2;
                        f = pi.f(this.a.c.getPageContext().getPageActivity(), R.dimen.tbds256);
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
                        z = (this.a.c.F() == null || this.a.c.F().Q1() == null || this.a.c.F().Q1().O() == null || !this.a.c.F().Q1().O().isBjh()) ? false : false;
                        rt7 rt7Var = this.a.c.K0;
                        j1 j1Var = this.a;
                        rt7Var.o(j1Var.a, j1Var.b, j1Var.c.c4(), z);
                        this.a.c.K0.l(this.a.c.N3());
                        p25 b = this.a.c.K0.b();
                        if (b != null && this.a.c.F() != null && this.a.c.F().Q1() != null) {
                            b.G(this.a.c.F().Q1().d());
                            b.c0(this.a.c.F().Q1().O());
                        }
                        if (this.a.c.F0.f() == null && this.a.c.K0.b().t() != null) {
                            this.a.c.K0.b().t().g(new C0233a(this));
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

        @Override // com.repackage.am6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.am6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                qg.a().postDelayed(new a(this), 0L);
            }
        }

        @Override // com.repackage.am6.d
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
                        if (this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().l() == null) {
                            return;
                        }
                        StatisticItem param = new StatisticItem("c13713").param("fid", this.a.F().Q1().l().getId()).param("fname", this.a.F().Q1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F().Q1().Q()).param("obj_param1", this.a.w.k);
                        if (this.a.F().Q1().O() != null) {
                            ThreadData O = this.a.F().Q1().O();
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
                TiebaStatic.log(new StatisticItem("c13590").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.l()).param("obj_type", 2).param("fid", this.a.F().Q1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F().Q1().Q()));
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
                this.a.U4();
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
                if (this.a.w == null || this.a.w.n()) {
                    if (this.a.w != null && this.a.F() != null && this.a.F().Q1() != null && this.a.F().Q1().l() != null) {
                        TiebaStatic.log(new StatisticItem("c13712").param("fid", this.a.F().Q1().l().getId()).param("fname", this.a.F().Q1().l().getName()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F().Q1().Q()).param("obj_param1", this.a.w.k));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13608").param("obj_id", this.a.w.getTitle()).param("obj_name", this.a.w.l()).param("obj_type", 2).param("fid", this.a.F().Q1().m()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", this.a.F().Q1().Q()));
                }
                this.a.G5();
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
                        this.a.I5();
                        UtilHelper.showStatusBar(this.a.N(), this.a.N().O0());
                        this.a.r1 = true;
                        qg.a().removeCallbacks(this.a.v1);
                        qg.a().postDelayed(this.a.v1, 3000L);
                    }
                } else if (this.a.n1 == 2 && (this.a.r1 || this.a.B4())) {
                    this.a.H5();
                    UtilHelper.hideStatusBar(this.a.N(), this.a.N().O0());
                    this.a.r1 = false;
                    py7 py7Var = this.a.k;
                    if (py7Var != null) {
                        py7Var.T0(false);
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
                this.a.n5(bool.booleanValue());
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
            py7 py7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                this.a.o1 += f;
                this.a.p1 += f2;
                if (this.a.n1 == 0 && !this.a.q1 && (py7Var = this.a.k) != null && !py7Var.isFullScreen()) {
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
                if (this.b.A4() && (this.a.n() || this.b.F().h2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.F().h2() == 0) {
                    this.b.e.setCurrentItem(0);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.b.A4() && (this.a.n() || this.b.F().h2() == 1)) {
                    this.b.e.setCurrentItem(1);
                } else if (this.a.n() || this.b.F().h2() == 0) {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.r1 && !this.a.B4()) {
                this.a.H5();
                UtilHelper.hideStatusBar(this.a.N(), this.a.N().O0());
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
                    absVideoPbFragment.f5(absVideoPbFragment.R);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n1 implements uk4.a {
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

        @Override // com.repackage.uk4.a
        public void a(boolean z, boolean z2, String str) {
            ThreadData O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                this.a.q5();
                if (z && this.a.F() != null) {
                    if (this.a.P != null) {
                        this.a.P.h(z2);
                    }
                    this.a.F().D3(z2);
                    if (this.a.F().Q1() != null && (O = this.a.F().Q1().O()) != null) {
                        if (z2) {
                            O.collectNum++;
                        } else {
                            int i = O.collectNum;
                            if (i > 0) {
                                O.collectNum = i - 1;
                            }
                        }
                    }
                    if (this.a.F().B1()) {
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
                            if (this.a.P.f() == null || this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null || this.a.F().Q1().O().getAuthor() == null) {
                                return;
                            }
                            MarkData f = this.a.P.f();
                            MetaData author = this.a.F().Q1().O().getAuthor();
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
                        this.a.k3();
                        return;
                    }
                    AbsVideoPbFragment absVideoPbFragment2 = this.a;
                    absVideoPbFragment2.showToast(absVideoPbFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fb8));
                    return;
                }
                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                absVideoPbFragment3.showToast(absVideoPbFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d9));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (obj != null && this.a.F() != null) {
                    switch (this.a.T.getLoadDataMode()) {
                        case 0:
                            this.a.F().r2();
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
    public class q implements y26.b {
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

        @Override // com.repackage.y26.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    sr7.d();
                } else {
                    sr7.c();
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
                    if (this.a.K3() != null) {
                        this.a.K3().Z1(false);
                    } else if (this.a.A4() && this.a.b4() != null) {
                        this.a.b4().U1(false);
                    }
                    if (this.a.L3() != null) {
                        this.a.L3().I1(true);
                        AbsVideoPbFragment absVideoPbFragment = this.a;
                        absVideoPbFragment.t5(absVideoPbFragment.L3().A1() == 0 ? 8 : 0);
                        this.a.i0.setVisibility(8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(this.a.getActivity()).get(VideoPbViewModel.class);
                    z = (videoPbViewModel.e() == null || videoPbViewModel.e().getValue() == null || !videoPbViewModel.e().getValue().booleanValue()) ? false : false;
                    py7 py7Var = this.a.k;
                    if (py7Var != null) {
                        py7Var.S0(z);
                    }
                    this.a.b5();
                    if (this.a.F() != null && this.a.F().Q1() != null) {
                        TiebaStatic.log(new StatisticItem("c13592").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()));
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
                        this.a.i0.setVisibility(0);
                    }
                    py7 py7Var2 = this.a.k;
                    if (py7Var2 != null) {
                        py7Var2.S0(false);
                    }
                    this.a.i.setExpanded(false, true);
                    if (this.a.F() != null && this.a.F().Q1() != null) {
                        TiebaStatic.log(new StatisticItem("c13593").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()));
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
    public class r implements nq4.e {
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

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) || nq4Var == null) {
                return;
            }
            nq4Var.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xv4 a;
        public final /* synthetic */ AbsVideoPbFragment b;

        public r0(AbsVideoPbFragment absVideoPbFragment, xv4 xv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, xv4Var};
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
            this.a = xv4Var;
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
                this.b.a.Q4(postWriteCallBackData.getmAdverSegmentData(), 2);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements nq4.e {
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

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements nq4.e {
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

            @Override // com.repackage.nq4.e
            public void onClick(nq4 nq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                    nq4Var.dismiss();
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
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, hx4 hx4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, hx4Var, writeData, antiData}) == null) {
                if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                    StatisticItem statisticItem = new StatisticItem("c13268");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.F() != null && this.a.F().Q1() != null) {
                        statisticItem.param("fid", this.a.F().Q1().m());
                    }
                    if (this.a.F() != null) {
                        statisticItem.param("tid", this.a.F().i2());
                    }
                    statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem);
                }
                if (writeData != null) {
                    uu4.b(writeData.getContent(), "4");
                }
                if (z) {
                    xu7 xu7Var = this.a.F0;
                    if (xu7Var != null) {
                        xu7Var.d();
                    }
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        qy4.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                    if (postWriteCallBackData == null || postWriteCallBackData.getmAdverSegmentData() == null) {
                        return;
                    }
                    qg.a().postDelayed(new a(this, postWriteCallBackData), 500L);
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
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0466), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    nq4 nq4Var = new nq4(this.a.getActivity());
                    if (oi.isEmpty(postWriteCallBackData.getErrorString())) {
                        nq4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0ced));
                    } else {
                        nq4Var.setMessage(postWriteCallBackData.getErrorString());
                    }
                    nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this));
                    nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0cef, new c(this));
                    nq4Var.create(this.a.getPageContext()).show();
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
    public class t implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ MarkData b;
        public final /* synthetic */ nq4 c;
        public final /* synthetic */ AbsVideoPbFragment d;

        public t(AbsVideoPbFragment absVideoPbFragment, MarkData markData, MarkData markData2, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, markData2, nq4Var};
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
            this.c = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
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
                if (this.a.w == null || this.a.w.n()) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13608").param("tid", this.a.F().Q1().Q()));
                        this.a.w.l = true;
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c13591"));
                }
                this.a.F5();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class t1 implements fg<ImageView> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                    if (km4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g = km4.c().g();
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

    /* loaded from: classes3.dex */
    public class u implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MarkData a;
        public final /* synthetic */ nq4 b;
        public final /* synthetic */ AbsVideoPbFragment c;

        public u(AbsVideoPbFragment absVideoPbFragment, MarkData markData, nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absVideoPbFragment, markData, nq4Var};
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
            this.b = nq4Var;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
                Intent intent = new Intent();
                intent.putExtra("mark", this.a);
                this.c.a.setResult(-1, intent);
                this.b.dismiss();
                this.c.M5();
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
                this.a.I0.v0();
                this.a.A3();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u1 implements fg<GifView> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
                if (km4.c().g()) {
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
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                GifView gifView = new GifView(this.a.getPageContext().getPageActivity());
                boolean g = km4.c().g();
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
                this.a.C3(false);
                this.a.T4();
                if (this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null || this.a.F().Q1().O().getAuthor() == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.a.F().j2()).param("fid", this.a.F().Q1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()).param("obj_locate", 1).param("uid", this.a.F().Q1().O().getAuthor().getUserId()));
                if (this.a.x4()) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem.param("fid", this.a.F().getForumId());
                    statisticItem.param("tid", this.a.F().i2());
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

    /* loaded from: classes3.dex */
    public class v1 implements fg<View> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ View a(View view2) {
            View view3 = view2;
            e(view3);
            return view3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
                ((PlayVoiceBntNew) view2).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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
            layoutParams.height = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds144);
            this.a.i0.setLayoutParams(layoutParams);
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

    /* loaded from: classes3.dex */
    public class w1 implements fg<LinearLayout> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
                linearLayout.setId(R.id.obfuscated_res_0x7f0916f6);
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
    public class x implements k25 {
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

        @Override // com.repackage.k25
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
                this.a.i4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class x1 implements fg<RelativeLayout> {
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
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
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
            boolean G3;
            int i3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.a.isAdded()) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0916b5) {
                    if (this.a.F() != null) {
                        this.a.F().N2(false);
                        return;
                    }
                    return;
                }
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091e53);
                if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                    view2.setTag(R.id.obfuscated_res_0x7f091e53, null);
                } else if ((view2 instanceof TbListTextView) && (view2.getParent() instanceof TbRichTextView)) {
                    StatisticItem statisticItem2 = new StatisticItem("c13398");
                    statisticItem2.param("tid", this.a.F().i2());
                    statisticItem2.param("fid", this.a.F().getForumId());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    if (this.a.x4()) {
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                        statisticItem3.param("fid", this.a.F().getForumId());
                        statisticItem3.param("tid", this.a.F().i2());
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem3.param("post_id", this.a.O3());
                        statisticItem3.param("obj_source", 1);
                        statisticItem3.param("obj_type", 3);
                        statisticItem3.param("obj_locate", this.a.N3());
                        TiebaStatic.log(statisticItem3);
                    }
                    if (this.a.h0) {
                        this.a.h0 = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view2.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.obfuscated_res_0x7f091e49);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (this.a.F() == null || this.a.F().Q1() == null || this.a.L0 == null || postData.s() == null || postData.B() == 1 || !this.a.checkUpIsLogin()) {
                                return;
                            }
                            if (this.a.K0 != null) {
                                this.a.K0.c();
                            }
                            hr7 hr7Var = new hr7();
                            hr7Var.A(this.a.F().Q1().l());
                            hr7Var.E(this.a.F().Q1().O());
                            hr7Var.C(postData);
                            this.a.L0.V(hr7Var);
                            this.a.L0.setPostId(postData.J());
                            this.a.H4(view2, postData.s().getUserId(), "", postData);
                            TiebaStatic.log("c11743");
                            lx7.b(this.a.F().Q1(), postData, postData.h0, 8, 1);
                            if (this.a.I0 != null) {
                                AbsVideoPbFragment absVideoPbFragment = this.a;
                                absVideoPbFragment.k5(absVideoPbFragment.I0.C());
                            }
                        }
                    }
                } else {
                    if (view2.getId() != R.id.obfuscated_res_0x7f09170d || this.a.getPageContext().getPageActivity() == null || this.a.F() == null || this.a.a == null || this.a.a.getIntent() == null) {
                        str = "post_id";
                    } else {
                        if (this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 1 && this.a.a.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_PAGE_TYPE, 0) != 2) {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.F().i2(), false, true);
                            foldCommentActivityConfig.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig));
                        } else {
                            str = "post_id";
                            FoldCommentActivityConfig foldCommentActivityConfig2 = new FoldCommentActivityConfig(this.a.getPageContext().getPageActivity(), this.a.F().i2(), true, false);
                            foldCommentActivityConfig2.setFromVideoPageUniqueId((BdUniqueId) this.a.a.getIntent().getSerializableExtra("key_from_video_page_id"));
                            this.a.sendMessage(new CustomMessage(2002001, foldCommentActivityConfig2));
                        }
                        StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_CLICK);
                        statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem4.param("fid", this.a.F().getForumId());
                        statisticItem4.param("fname", this.a.F().p1());
                        statisticItem4.param("tid", this.a.F().i2());
                        TiebaStatic.log(statisticItem4);
                    }
                    if ((this.a.A4() && this.a.b4() != null && this.a.b4().N1() != null && view2 == this.a.b4().N1()) || ((this.a.K3() != null && this.a.K3().P1() != null && view2 == this.a.K3().P1()) || view2.getId() == R.id.obfuscated_res_0x7f0916b7)) {
                        if (!this.a.L && this.a.F().J2(true)) {
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
                    ky7 ky7Var = this.a.N;
                    if (ky7Var != null && ky7Var.Q() != null && view2 == this.a.N.Q().j()) {
                        this.a.N.I();
                        return;
                    }
                    ky7 ky7Var2 = this.a.N;
                    if ((ky7Var2 == null || ((ky7Var2.Q() == null || view2 != this.a.N.Q().n()) && view2.getId() != R.id.obfuscated_res_0x7f0915ff && view2.getId() != R.id.obfuscated_res_0x7f090259)) && view2.getId() != R.id.obfuscated_res_0x7f0909b9 && view2.getId() != R.id.obfuscated_res_0x7f091a52) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.a;
                        if (view2 == absVideoPbFragment2.p) {
                            if (absVideoPbFragment2.F() == null || this.a.F().Q1() == null) {
                                return;
                            }
                            if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                StatisticItem statisticItem5 = new StatisticItem("c13266");
                                statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                                statisticItem5.param("fid", this.a.F().Q1().m());
                                statisticItem5.param("tid", this.a.F().i2());
                                statisticItem5.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(statisticItem5);
                                TbadkCoreApplication.getInst().setTaskId("");
                            }
                            pi.x(this.a.a, this.a.p);
                            this.a.a.finish();
                        } else if (view2 == absVideoPbFragment2.r && absVideoPbFragment2.N != null) {
                            if (dc5.a()) {
                                return;
                            }
                            if (this.a.F() != null && this.a.F().Q1() != null) {
                                ArrayList<PostData> F = this.a.F().Q1().F();
                                if ((F == null || F.size() <= 0) && this.a.F().g2()) {
                                    pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd4));
                                    return;
                                }
                                TiebaStatic.log(new StatisticItem("c12378").param("tid", this.a.F().i2()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.a.F().getForumId()));
                                this.a.N.m0();
                                return;
                            }
                            pi.O(this.a.getPageContext().getPageActivity(), this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd4));
                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().p()) {
                            if (this.a.F() == null) {
                                return;
                            }
                            this.a.N.F();
                            if (ni.z()) {
                                this.a.L5();
                                this.a.r5();
                                this.a.F().B3(1);
                                return;
                            }
                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                        } else {
                            ky7 ky7Var3 = this.a.N;
                            if (ky7Var3 != null && ky7Var3.Q() != null && view2 == this.a.N.Q().n()) {
                                this.a.N.I();
                                return;
                            }
                            ky7 ky7Var4 = this.a.N;
                            if (ky7Var4 != null && ((ky7Var4.Q() != null && view2 == this.a.N.Q().v()) || view2.getId() == R.id.obfuscated_res_0x7f0916f4 || view2.getId() == R.id.obfuscated_res_0x7f0916f2)) {
                                this.a.N.F();
                                if (ni.z()) {
                                    if (!this.a.L) {
                                        this.a.L5();
                                        this.a.r5();
                                        this.a.N.J0(view2);
                                        return;
                                    }
                                    view2.setTag(Integer.valueOf(this.a.F().e2()));
                                    return;
                                }
                                this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                return;
                            }
                            ky7 ky7Var5 = this.a.N;
                            if (ky7Var5 != null && ky7Var5.Q() != null && view2 == this.a.N.Q().u()) {
                                if (this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null) {
                                    return;
                                }
                                this.a.N.I();
                                TiebaStatic.log(new StatisticItem("c13062"));
                                AbsVideoPbFragment absVideoPbFragment3 = this.a;
                                absVideoPbFragment3.N.U(absVideoPbFragment3.F().Q1().O().getFirstPostId());
                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091681) {
                                try {
                                    sparseArray = (SparseArray) view2.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                    sparseArray = null;
                                }
                                ky7 ky7Var6 = this.a.N;
                                if (ky7Var6 != null) {
                                    ky7Var6.w0(sparseArray);
                                }
                            } else {
                                ky7 ky7Var7 = this.a.N;
                                int i4 = 4;
                                if (ky7Var7 != null && ky7Var7.Q() != null && view2 == this.a.N.Q().s()) {
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
                                ky7 ky7Var8 = this.a.N;
                                if (ky7Var8 != null && ky7Var8.Q() != null && view2 == this.a.N.Q().t()) {
                                    this.a.N.J();
                                    AbsVideoPbFragment absVideoPbFragment4 = this.a;
                                    absVideoPbFragment4.N.G0(absVideoPbFragment4.F1);
                                    return;
                                }
                                ky7 ky7Var9 = this.a.N;
                                if (ky7Var9 != null && ky7Var9.Q() != null && view2 == this.a.N.Q().m()) {
                                    TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                                    if (tiebaPlusConfigData == null || (jumpUrlWithTid = tiebaPlusConfigData.getJumpUrlWithTid(this.a.F().i2())) == null) {
                                        return;
                                    }
                                    UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{jumpUrlWithTid});
                                    this.a.N.I();
                                    TiebaPlusConfigData.addClickStatsForFireLink(3);
                                    return;
                                }
                                ky7 ky7Var10 = this.a.N;
                                if (ky7Var10 != null && (view2 == ky7Var10.M() || (this.a.N.Q() != null && (view2 == this.a.N.Q().q() || view2 == this.a.N.Q().r())))) {
                                    if (!ni.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                        return;
                                    } else if ((this.a.F() == null && this.a.F().Q1() == null) || this.a.T.S()) {
                                        return;
                                    } else {
                                        this.a.N.F();
                                        if (this.a.N.Q() != null && view2 == this.a.N.Q().r()) {
                                            if (this.a.F().Q1().O().getIs_top() == 1) {
                                                i4 = 5;
                                            }
                                        } else if (this.a.N.Q() != null && view2 == this.a.N.Q().q()) {
                                            i4 = this.a.F().Q1().O().getIs_good() == 1 ? 3 : 6;
                                        } else {
                                            i4 = view2 == this.a.N.M() ? 2 : 0;
                                        }
                                        ForumData l = this.a.F().Q1().l();
                                        String name = l.getName();
                                        String id = l.getId();
                                        String id2 = this.a.F().Q1().O().getId();
                                        this.a.showProgressBar();
                                        this.a.T.W(id, name, id2, i4, this.a.N.N());
                                        return;
                                    }
                                }
                                ky7 ky7Var11 = this.a.N;
                                if (ky7Var11 != null && ky7Var11.Q() != null && view2 == this.a.N.Q().l()) {
                                    if (this.a.F() == null) {
                                        return;
                                    }
                                    if (!ni.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                        return;
                                    }
                                    this.a.N.F();
                                    AbsVideoPbFragment absVideoPbFragment5 = this.a;
                                    SparseArray<Object> T3 = absVideoPbFragment5.T3(absVideoPbFragment5.F().Q1(), this.a.F().g2(), 1);
                                    if (T3 == null) {
                                        return;
                                    }
                                    this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.F().Q1().l().getId(), this.a.F().Q1().l().getName(), this.a.F().Q1().O().getId(), String.valueOf(this.a.F().Q1().U().getUserId()), (String) T3.get(R.id.obfuscated_res_0x7f091e56), (String) T3.get(R.id.obfuscated_res_0x7f091e57), (String) T3.get(R.id.obfuscated_res_0x7f091e59), (String) T3.get(R.id.obfuscated_res_0x7f091e58))));
                                    return;
                                }
                                ky7 ky7Var12 = this.a.N;
                                if (ky7Var12 != null && ky7Var12.Q() != null && view2 == this.a.N.Q().a()) {
                                    if (!ni.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment6 = this.a;
                                    SparseArray<Object> T32 = absVideoPbFragment6.T3(absVideoPbFragment6.F().Q1(), this.a.F().g2(), 1);
                                    if (T32 != null) {
                                        this.a.N.j0(((Integer) T32.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) T32.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) T32.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) T32.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
                                    }
                                    this.a.N.I();
                                    if (this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null) {
                                        return;
                                    }
                                    ThreadData O = this.a.F().Q1().O();
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
                                ky7 ky7Var13 = this.a.N;
                                if (ky7Var13 != null && ky7Var13.Q() != null && view2 == this.a.N.Q().k()) {
                                    if (this.a.F() == null) {
                                        return;
                                    }
                                    if (!ni.z()) {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                        return;
                                    }
                                    AbsVideoPbFragment absVideoPbFragment7 = this.a;
                                    SparseArray<Object> T33 = absVideoPbFragment7.T3(absVideoPbFragment7.F().Q1(), this.a.F().g2(), 1);
                                    if (T33 != null) {
                                        if (StringUtils.isNull((String) T33.get(R.id.obfuscated_res_0x7f091e4a))) {
                                            this.a.N.g0(((Integer) T33.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) T33.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) T33.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) T33.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue());
                                        } else {
                                            this.a.N.h0(((Integer) T33.get(R.id.obfuscated_res_0x7f091e4d)).intValue(), (String) T33.get(R.id.obfuscated_res_0x7f091e4b), ((Integer) T33.get(R.id.obfuscated_res_0x7f091e68)).intValue(), ((Boolean) T33.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue(), (String) T33.get(R.id.obfuscated_res_0x7f091e4a));
                                        }
                                    }
                                    this.a.N.I();
                                } else if (view2.getId() != R.id.obfuscated_res_0x7f091dac && view2.getId() != R.id.obfuscated_res_0x7f091daa && view2.getId() != R.id.obfuscated_res_0x7f091683 && view2.getId() != R.id.obfuscated_res_0x7f091526 && view2.getId() != R.id.obfuscated_res_0x7f0916e4) {
                                    if (view2.getId() != R.id.obfuscated_res_0x7f0916e2 && view2.getId() != R.id.obfuscated_res_0x7f0918aa && view2.getId() != R.id.obfuscated_res_0x7f09167d) {
                                        if (view2.getId() != R.id.obfuscated_res_0x7f09166f && view2.getId() != R.id.obfuscated_res_0x7f09063f) {
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091674) {
                                                this.a.e4(true);
                                                return;
                                            } else if (view2.getId() != R.id.obfuscated_res_0x7f091671 && view2.getId() != R.id.obfuscated_res_0x7f091f99) {
                                                if (view2.getId() == R.id.obfuscated_res_0x7f0921c6) {
                                                    if (this.a.R0 >= 0) {
                                                        if (this.a.F() != null) {
                                                            this.a.F().i3();
                                                        }
                                                        if (this.a.A4() && this.a.F() != null && this.a.b4() != null && this.a.b4().r1() != null) {
                                                            this.a.b4().r1().f(this.a.F().Q1());
                                                        } else if (this.a.K3() != null && this.a.K3().r1() != null) {
                                                            this.a.K3().r1().r(this.a.F().Q1());
                                                        }
                                                        this.a.R0 = 0;
                                                        this.a.S0 = Integer.MIN_VALUE;
                                                        if (this.a.A4() && this.a.F() != null && this.a.b4() != null) {
                                                            this.a.b4().X1(this.a.F().J1(), this.a.F().I1());
                                                            this.a.F().m3(0, 0);
                                                            return;
                                                        } else if (this.a.F() == null || this.a.K3() == null) {
                                                            return;
                                                        } else {
                                                            this.a.K3().d2(this.a.F().J1(), this.a.F().I1());
                                                            this.a.F().m3(0, 0);
                                                            return;
                                                        }
                                                    }
                                                    return;
                                                } else if ((view2 instanceof PlayVoiceBntNew) && (view2.getParent() instanceof TbRichTextView)) {
                                                    if (this.a.F() == null) {
                                                        return;
                                                    }
                                                    StatisticItem statisticItem8 = new StatisticItem("c13398");
                                                    statisticItem8.param("tid", this.a.F().i2());
                                                    statisticItem8.param("fid", this.a.F().getForumId());
                                                    statisticItem8.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem8.param("obj_locate", 2);
                                                    TiebaStatic.log(statisticItem8);
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f0916ac) {
                                                    if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                        String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1382);
                                                        String q = ht4.k().q("tail_link", "");
                                                        if (!StringUtils.isNull(q)) {
                                                            TiebaStatic.log("c10056");
                                                            cl4.s(view2.getContext(), string, q, true, true, true);
                                                        }
                                                        this.a.b5();
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f090fc2) {
                                                    this.a.b5();
                                                    return;
                                                } else if (this.a.N.Q() != null && view2 == this.a.N.Q().h()) {
                                                    this.a.N.F();
                                                    if (this.a.F() != null) {
                                                        this.a.t.f(this.a.F().i2());
                                                    }
                                                    if (this.a.F() == null || !this.a.F().isPrivacy()) {
                                                        this.a.t.b();
                                                        int i5 = (TbSingleton.getInstance().mCanCallFans || this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().Q() == null || !this.a.F().Q1().Q().equals(TbSingleton.getInstance().mCallFansTid)) ? 1 : 2;
                                                        if (this.a.F() == null || this.a.F().Q1() == null) {
                                                            return;
                                                        }
                                                        this.a.t.d(3, i5, this.a.F().Q1().Q());
                                                        return;
                                                    }
                                                    this.a.showToast(R.string.obfuscated_res_0x7f0f0ef9);
                                                    if (this.a.F().Q1() != null) {
                                                        this.a.t.d(3, 3, this.a.F().Q1().Q());
                                                        return;
                                                    }
                                                    return;
                                                } else if (view2.getId() == R.id.obfuscated_res_0x7f091685 || view2.getId() == R.id.obfuscated_res_0x7f0916dc) {
                                                    StatisticItem statisticItem9 = new StatisticItem("c13398");
                                                    statisticItem9.param("tid", this.a.F().i2());
                                                    statisticItem9.param("fid", this.a.F().getForumId());
                                                    statisticItem9.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                    statisticItem9.param("obj_locate", 7);
                                                    TiebaStatic.log(statisticItem9);
                                                    if (this.a.x4()) {
                                                        StatisticItem statisticItem10 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem10.param("fid", this.a.F().getForumId());
                                                        statisticItem10.param("tid", this.a.F().i2());
                                                        statisticItem10.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem10.param(str, this.a.O3());
                                                        statisticItem10.param("obj_source", 1);
                                                        statisticItem10.param("obj_type", 2);
                                                        statisticItem10.param("obj_locate", this.a.N3());
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
                                                if (this.a.F() != null) {
                                                    AbsVideoPbFragment absVideoPbFragment8 = this.a;
                                                    if (absVideoPbFragment8.N == null || absVideoPbFragment8.e == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null || !this.a.checkUpIsLogin()) {
                                                        return;
                                                    }
                                                    rq7 Q1 = this.a.F().Q1();
                                                    int reply_num = Q1.O().getReply_num();
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
                                                        StatisticItem param = new StatisticItem("c13403").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()).param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        int i6 = (int) (pi.i(this.a.getContext()) * 0.6d);
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
                                                        n75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                                                        StatisticItem statisticItem11 = new StatisticItem("c12942");
                                                        statisticItem11.param("obj_type", i2);
                                                        statisticItem11.param("obj_locate", 4);
                                                        statisticItem11.param("tid", this.a.F().i2());
                                                        statisticItem11.param("nid", Q1.O().getNid());
                                                        if (findPageExtraByView != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                                                        }
                                                        if (TbPageExtraHelper.getPrePageKey() != null) {
                                                            statisticItem11.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                                                        }
                                                        TiebaStatic.log(statisticItem11);
                                                    }
                                                    if (this.a.F() == null || this.a.F().Q1() == null || this.a.F().Q1().O() == null || this.a.F().Q1().O().getAuthor() == null) {
                                                        return;
                                                    }
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()).param("obj_locate", 2).param("uid", this.a.F().Q1().O().getAuthor().getUserId()));
                                                    if (this.a.x4()) {
                                                        StatisticItem statisticItem12 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem12.param("fid", this.a.F().getForumId());
                                                        statisticItem12.param("tid", this.a.F().i2());
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
                                        if (!ni.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                                            return;
                                        }
                                        AbsVideoPbFragment absVideoPbFragment9 = this.a;
                                        if (absVideoPbFragment9.N == null || absVideoPbFragment9.F() == null) {
                                            return;
                                        }
                                        if (this.a.A4() && this.a.b4() == null) {
                                            return;
                                        }
                                        if (this.a.A4() || this.a.K3() != null) {
                                            this.a.N.F();
                                            if (view2.getId() != R.id.obfuscated_res_0x7f09166f || DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_COLLECT_RESULT_PAGE))) {
                                                if (!this.a.r3(11009) || this.a.F() == null) {
                                                    return;
                                                }
                                                this.a.J4();
                                                if (this.a.F().Q1() != null && this.a.F().Q1().O() != null && this.a.F().Q1().O().getAuthor() != null) {
                                                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.F().i2()).param("fid", this.a.F().Q1().m()).param("obj_locate", 3).param("uid", this.a.F().Q1().O().getAuthor().getUserId()));
                                                    if (this.a.x4()) {
                                                        StatisticItem statisticItem13 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                                        statisticItem13.param("fid", this.a.F().getForumId());
                                                        statisticItem13.param("tid", this.a.F().i2());
                                                        statisticItem13.param("uid", TbadkCoreApplication.getCurrentAccount());
                                                        statisticItem13.param(str4, this.a.O3());
                                                        statisticItem13.param("obj_source", 1);
                                                        statisticItem13.param("obj_type", 13);
                                                        statisticItem13.param("obj_locate", this.a.N3());
                                                        TiebaStatic.log(statisticItem13);
                                                    }
                                                }
                                                if (this.a.F().Q1().O() == null || this.a.F().Q1().O().getAuthor() == null || this.a.F().Q1().O().getAuthor().getUserId() == null || this.a.P == null) {
                                                    return;
                                                }
                                                AbsVideoPbFragment absVideoPbFragment10 = this.a;
                                                int S = absVideoPbFragment10.N.S(absVideoPbFragment10.F().Q1());
                                                ThreadData O2 = this.a.F().Q1().O();
                                                if (O2.isBJHArticleThreadType()) {
                                                    i = 2;
                                                } else if (O2.isBJHVideoThreadType()) {
                                                    i = 3;
                                                } else if (O2.isBJHNormalThreadType()) {
                                                    i = 4;
                                                } else {
                                                    i = O2.isBJHVideoDynamicThreadType() ? 5 : 1;
                                                }
                                                TiebaStatic.log(new StatisticItem("c12526").param("tid", this.a.F().i2()).param("obj_locate", 1).param("obj_id", this.a.F().Q1().O().getAuthor().getUserId()).param("obj_type", !this.a.P.e()).param("obj_source", S).param("obj_param1", i));
                                                return;
                                            }
                                            this.a.z = view2;
                                            return;
                                        }
                                        return;
                                    }
                                    String str5 = str;
                                    if (this.a.F() == null) {
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0916e2) {
                                        StatisticItem statisticItem14 = new StatisticItem("c13398");
                                        statisticItem14.param("tid", this.a.F().i2());
                                        statisticItem14.param("fid", this.a.F().getForumId());
                                        statisticItem14.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem14.param("obj_locate", 6);
                                        TiebaStatic.log(statisticItem14);
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f0918aa) {
                                        if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                            this.a.y = view2;
                                            return;
                                        }
                                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0916e2 && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_REPLY_RESULT_PAGE))) {
                                        this.a.y = view2;
                                        return;
                                    }
                                    if (this.a.checkUpIsLogin() && (view2.getTag() instanceof SparseArray)) {
                                        SparseArray sparseArray2 = (SparseArray) view2.getTag();
                                        if (sparseArray2.get(R.id.obfuscated_res_0x7f091e65) instanceof PostData) {
                                            PostData postData2 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e65);
                                            if (view2.getId() == R.id.obfuscated_res_0x7f0916e2 && (statisticItem = postData2.i0) != null) {
                                                StatisticItem copy = statisticItem.copy();
                                                copy.delete("obj_locate");
                                                copy.param("obj_locate", 8);
                                                TiebaStatic.log(copy);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918aa || view2.getId() == R.id.obfuscated_res_0x7f09167d) {
                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.F().j2()).param("fid", this.a.F().getForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param(str5, postData2.J()).param("obj_source", 1).param("obj_type", 3));
                                            }
                                            if (this.a.F() == null || this.a.F().Q1() == null || this.a.L0 == null || postData2.s() == null || postData2.B() == 1) {
                                                return;
                                            }
                                            if (this.a.K0 != null) {
                                                this.a.K0.c();
                                            }
                                            if (this.a.U0 && postData2.S() != null && postData2.S().size() != 0) {
                                                this.a.J5(postData2, null, true, false);
                                                return;
                                            }
                                            hr7 hr7Var2 = new hr7();
                                            hr7Var2.A(this.a.F().Q1().l());
                                            hr7Var2.E(this.a.F().Q1().O());
                                            hr7Var2.C(postData2);
                                            this.a.L0.V(hr7Var2);
                                            this.a.L0.setPostId(postData2.J());
                                            this.a.H4(view2, postData2.s().getUserId(), "", postData2);
                                            if (this.a.I0 != null) {
                                                AbsVideoPbFragment absVideoPbFragment11 = this.a;
                                                absVideoPbFragment11.k5(absVideoPbFragment11.I0.C());
                                            }
                                        }
                                    }
                                } else {
                                    String str6 = str;
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091526) {
                                        StatisticItem statisticItem15 = new StatisticItem("c13398");
                                        statisticItem15.param("tid", this.a.F().i2());
                                        statisticItem15.param("fid", this.a.F().getForumId());
                                        statisticItem15.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem15.param("obj_locate", 4);
                                        TiebaStatic.log(statisticItem15);
                                        if (this.a.x4()) {
                                            StatisticItem statisticItem16 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                            statisticItem16.param("fid", this.a.F().getForumId());
                                            statisticItem16.param("tid", this.a.F().i2());
                                            statisticItem16.param("uid", TbadkCoreApplication.getCurrentAccount());
                                            statisticItem16.param(str6, this.a.O3());
                                            statisticItem16.param("obj_source", 1);
                                            statisticItem16.param("obj_type", 8);
                                            statisticItem16.param("obj_locate", this.a.N3());
                                            TiebaStatic.log(statisticItem16);
                                        }
                                    }
                                    if ((view2.getId() == R.id.obfuscated_res_0x7f091683 || view2.getId() == R.id.obfuscated_res_0x7f0916e4) && !DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.a.getActivity(), LoginDialogData.PB_MORE_REPLY_RESULT_PAGE))) {
                                        this.a.x = view2;
                                        return;
                                    }
                                    if (view2.getId() == R.id.obfuscated_res_0x7f091683 && this.a.x4()) {
                                        StatisticItem statisticItem17 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                                        statisticItem17.param("fid", this.a.F().getForumId());
                                        statisticItem17.param("tid", this.a.F().i2());
                                        statisticItem17.param("uid", TbadkCoreApplication.getCurrentAccount());
                                        statisticItem17.param(str6, this.a.O3());
                                        statisticItem17.param("obj_source", 1);
                                        statisticItem17.param("obj_type", 9);
                                        statisticItem17.param("obj_locate", this.a.N3());
                                        TiebaStatic.log(statisticItem17);
                                    }
                                    if (!this.a.checkUpIsLogin()) {
                                        TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 3).param("fid", this.a.F().Q1().m()));
                                    } else if (this.a.F() == null || this.a.F().Q1() == null) {
                                    } else {
                                        ky7 ky7Var14 = this.a.N;
                                        if (ky7Var14 != null) {
                                            ky7Var14.F();
                                        }
                                        SparseArray sparseArray3 = (SparseArray) view2.getTag();
                                        PostData postData3 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e65);
                                        PostData postData4 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e66);
                                        if (postData3 == null) {
                                            return;
                                        }
                                        if (postData3.F() == 1) {
                                            TiebaStatic.log(new StatisticItem("c12630"));
                                        }
                                        StatisticItem statisticItem18 = postData3.i0;
                                        if (statisticItem18 != null) {
                                            StatisticItem copy2 = statisticItem18.copy();
                                            copy2.delete("obj_locate");
                                            if (view2.getId() == R.id.obfuscated_res_0x7f091526) {
                                                copy2.param("obj_locate", 6);
                                            } else if (view2.getId() == R.id.obfuscated_res_0x7f091683) {
                                                copy2.param("obj_locate", 8);
                                            }
                                            TiebaStatic.log(copy2);
                                        }
                                        this.a.L5();
                                        TiebaStatic.log("c11742");
                                        if (postData4 != null) {
                                            this.a.J5(postData3, postData4, false, true);
                                        } else {
                                            this.a.J5(postData3, null, false, false);
                                        }
                                    }
                                }
                            }
                        }
                    } else if (!ni.z()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c38);
                        view2.setTag(Boolean.FALSE);
                    } else {
                        this.a.N.F();
                        if (!this.a.L) {
                            this.a.L5();
                            this.a.r5();
                            if (view2.getId() == R.id.obfuscated_res_0x7f0915ff) {
                                G3 = this.a.F().G3(true, this.a.O3());
                            } else {
                                G3 = view2.getId() == R.id.obfuscated_res_0x7f090259 ? this.a.F().G3(false, this.a.O3()) : this.a.F().F3(this.a.O3());
                            }
                            view2.setTag(Boolean.valueOf(G3));
                            if (G3) {
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
                this.a.b5();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class y1 implements j25 {
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

        @Override // com.repackage.j25
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                xu7 xu7Var = this.a.F0;
                if (xu7Var == null || xu7Var.e() == null || !this.a.F0.e().d()) {
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

    /* loaded from: classes3.dex */
    public class z extends ad5<ShareItem> {
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
        @Override // com.repackage.ad5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                PbModel F = this.b.F();
                if (F != null) {
                    F.p3(this.a);
                }
                return mw7.d(this.b.J3(), 2, F);
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

    /* loaded from: classes3.dex */
    public class z1 implements Comparator<ez4> {
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
        public int compare(ez4 ez4Var, ez4 ez4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ez4Var, ez4Var2)) == null) ? ez4Var.compareTo(ez4Var2) : invokeLL.intValue;
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
        N1 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds146);
        O1 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds114);
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

    @Override // com.repackage.sf5
    public eg<LinearLayout> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.Z == null) {
                this.Z = new eg<>(new w1(this), 15, 0);
            }
            return this.Z;
        }
        return (eg) invokeV.objValue;
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean A4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (x4() || F() == null || !F().E2()) ? false : true : invokeV.booleanValue;
    }

    public final void A5(rq7 rq7Var) {
        ny7 G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, rq7Var) == null) || (G = rq7Var.G()) == null || G.l) {
            return;
        }
        n3(G);
    }

    @Override // com.repackage.wx7
    public AbsVideoPbFragment B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this : (AbsVideoPbFragment) invokeV.objValue;
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", P1);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            py7 py7Var = this.k;
            return py7Var != null && py7Var.N0();
        }
        return invokeV.booleanValue;
    }

    public void B5() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(0);
    }

    @Override // com.repackage.wx7
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
            String string = !TextUtils.isEmpty(bVar.b) ? bVar.b : getString(R.string.obfuscated_res_0x7f0f049b);
            int i2 = 0;
            if (bVar.c == 1211066) {
                hideProgressBar();
                nq4 nq4Var = new nq4(getPageContext().getPageActivity());
                nq4Var.setMessage(string);
                nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04da, new r(this));
                nq4Var.setCancelable(true);
                nq4Var.create(getPageContext());
                nq4Var.show();
            } else {
                E3(0, bVar.a, bVar.b, z2);
            }
            if (bVar.a) {
                int i3 = bVar.d;
                if (i3 == 1) {
                    ArrayList<PostData> F = F().Q1().F();
                    int size = F.size();
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (bVar.g.equals(F.get(i2).J())) {
                            F.remove(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    F().Q1().O().setReply_num(F().Q1().O().getReply_num() - 1);
                    if (K3() != null) {
                        K3().U1();
                    } else if (A4() && b4() != null) {
                        b4().R1();
                    }
                } else if (i3 == 0) {
                    v3();
                } else if (i3 == 2) {
                    ArrayList<PostData> F2 = F().Q1().F();
                    int size2 = F2.size();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size2 && !z3; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= F2.get(i4).S().size()) {
                                break;
                            } else if (bVar.g.equals(F2.get(i4).S().get(i5).J())) {
                                F2.get(i4).S().remove(i5);
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
            py7 py7Var = this.k;
            if (py7Var == null) {
                return false;
            }
            return py7Var.O0();
        }
        return invokeV.booleanValue;
    }

    public final void D5(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            oy7.c(N(), J3(), i2);
        }
    }

    @Override // com.repackage.sf5
    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void E3(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            hideProgressBar();
            if (z2 && z3) {
                showToast(getPageContext().getString(R.string.obfuscated_res_0x7f0f1236));
            } else if (z3) {
                if (oi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c37);
                }
                showToast(str);
            }
        }
    }

    public final void E4(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            urlManager.dealOneLink(pageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
        }
    }

    public final void E5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || F() == null || oi.isEmpty(F().i2())) {
            return;
        }
        wh4.w().P(vh4.X, ng.g(F().i2(), 0L));
    }

    @Override // com.repackage.wx7
    public PbModel F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.a.N0() : (PbModel) invokeV.objValue;
    }

    public final void F3(int i2, ForumManageModel.g gVar) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048596, this, i2, gVar) == null) || gVar == null || F() == null || F().Q1() == null || F().Q1().O() == null) {
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
                F().Q1().O().setIs_good(1);
                F().q3(1);
            } else if (i2 == 3) {
                F().Q1().O().setIs_good(0);
                F().q3(0);
            } else if (i2 == 4) {
                F().Q1().O().setIs_top(1);
                F().r3(1);
            } else if (i2 == 5) {
                F().Q1().O().setIs_top(0);
                F().r3(0);
            }
        } else {
            if (gVar != null && !TextUtils.isEmpty(gVar.b)) {
                string = gVar.b;
            } else {
                string = getString(R.string.obfuscated_res_0x7f0f0cfe);
            }
            pi.O(getPageContext().getPageActivity(), string);
        }
        if (A4()) {
            if (F().Q1().O() == null || L3() == null) {
                return;
            }
            L3().K1();
        } else if (F().Q1().O() == null || K3() == null) {
        } else {
            K3().b2();
        }
    }

    public /* synthetic */ void F4() {
        String c4;
        if (F() != null && F().w2()) {
            c4 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0de4);
        } else {
            c4 = c4();
        }
        if (!StringUtils.isNull(c4) && F() != null && F().Q1() != null) {
            c4 = TbSingleton.getInstance().getAdVertiComment(F().Q1().k0(), F().Q1().l0(), c4);
        }
        m25 m25Var = this.I0;
        if (m25Var != null) {
            m25Var.l0(c4);
        }
        TextView textView = this.n0;
        if (textView != null) {
            textView.setText(c4);
        }
        y5(false);
        C5();
    }

    public final void F5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.v.getLayoutParams() == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            if (i2 == 0) {
                return getString(R.string.obfuscated_res_0x7f0f0dbb);
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
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.m0 == null) {
            return;
        }
        B3();
        this.m0.setImageResource(R.drawable.obfuscated_res_0x7f080971);
    }

    public final void G5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
            return;
        }
        ValueAnimator valueAnimator = this.I;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.v.setAlpha(0.0f);
            this.v.setVisibility(0);
            R5(layoutParams);
        }
    }

    @Override // com.repackage.sf5
    public void H(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.h0 = true;
        }
    }

    public vx4 H3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.S : (vx4) invokeV.objValue;
    }

    public final void H4(View view2, String str, String str2, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048604, this, view2, str, str2, postData) == null) || view2 == null || str == null || str2 == null || q3() || !s3()) {
            return;
        }
        if (view2.getParent() instanceof View) {
            ((View) view2.getParent()).getLocationOnScreen(this.N0);
            this.O0 = ((View) view2.getParent()).getMeasuredHeight();
        }
        if (this.K0 != null && postData != null) {
            this.K0.j(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fd1), postData.s().getName_show(), postData.Q() != null ? postData.Q().toString() : ""));
        }
        if (F() != null && F().Q1() != null && F().Q1().g0()) {
            qg.a().postDelayed(new i1(this, str, str2), 0L);
            return;
        }
        if (this.E0 == null) {
            am6 am6Var = new am6(getPageContext());
            this.E0 = am6Var;
            am6Var.j(1);
            this.E0.i(new j1(this, str, str2));
        }
        if (F() == null || F().Q1() == null || F().Q1().l() == null) {
            return;
        }
        this.E0.g(F().Q1().l().getId(), ng.g(F().i2(), 0L));
    }

    public final void H5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.x1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 1.0f, 0.0f);
                this.x1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.x1.start();
        }
    }

    public LinearLayout I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.l0 : (LinearLayout) invokeV.objValue;
    }

    public final void I4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || F() == null) {
            return;
        }
        rq7 Q1 = F().Q1();
        F().D3(true);
        uk4 uk4Var = this.P;
        if (uk4Var != null) {
            Q1.E0(uk4Var.g());
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
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.w1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.o, AnimationProperty.OPACITY, 0.0f, 1.0f);
                this.w1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.w1.start();
        }
    }

    @Override // com.repackage.sf5
    public void J(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, str) == null) {
            av7.a().e(getPageContext(), str);
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
            this.h0 = true;
        }
    }

    public final int J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (F() == null || F().Q1() == null || F().Q1().O() == null) {
                return -1;
            }
            return F().Q1().O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void J4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || F() == null || F().Q1() == null) {
            return;
        }
        if (A4() && b4() == null) {
            return;
        }
        if ((A4() || K3() != null) && this.P != null) {
            MarkData markData = null;
            if (F().Q1() != null && F().Q1().g0()) {
                markData = F().g1(0);
            } else {
                CustomViewPager customViewPager = this.e;
                if (customViewPager != null && customViewPager.getCurrentItem() == 0) {
                    markData = F().K1(M3(F().Q1()));
                } else if (A4()) {
                    if (b4() != null) {
                        markData = F().g1(b4().K1());
                    }
                } else if (K3() != null) {
                    markData = F().g1(K3().M1());
                }
            }
            if (markData == null) {
                return;
            }
            if (markData.isApp() && b4() != null && (markData = F().g1(b4().K1() + 1)) == null) {
                return;
            }
            r5();
            this.P.i(markData);
            if (!this.P.e()) {
                if (F() != null && !mw7.k(F().i2())) {
                    this.r0.o(2);
                    mw7.b(F().i2());
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
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{postData, postData2, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            String i2 = F().i2();
            String J = postData.J();
            String J2 = postData2 != null ? postData2.J() : "";
            int V = F().Q1() != null ? F().Q1().V() : 0;
            if (b4() != null && b4().P1() != null) {
                n2 = b4().P1().n(J);
            } else if (K3() == null || K3().R1() == null) {
                return;
            } else {
                n2 = K3().R1().n(J);
            }
            AbsPbActivity.e eVar = n2;
            if (postData == null || F() == null || F().Q1() == null || eVar == null) {
                return;
            }
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(i2, J, "pb", true, x4(), null, false, J2, V, postData.V(), F().Q1().d(), false, postData.s().getIconInfo(), N3(), N3() == 1 || N3() == 2 || N3() == 3 || N3() == 4 || N3() == 5).addBigImageData(eVar.a, eVar.b, eVar.g, eVar.j);
            if (z3) {
                addBigImageData.setHighLightPostId(J2);
                z4 = true;
                addBigImageData.setKeyIsUseSpid(true);
            } else {
                z4 = true;
            }
            addBigImageData.setKeyFromForumId(F().getForumId());
            addBigImageData.setTiebaPlusData(F().I(), F().E(), F().F(), F().D(), F().J());
            addBigImageData.setBjhData(F().i1());
            addBigImageData.setKeyPageStartFrom(F().P1());
            addBigImageData.setFromFrsForumId(F().getFromForumId());
            addBigImageData.setWorksInfoData(F().n2());
            addBigImageData.setIsOpenEditor(z2);
            if (F().Q1().o() != null) {
                addBigImageData.setHasForumRule(F().Q1().o().has_forum_rule.intValue());
            }
            if (F().Q1().U() != null) {
                addBigImageData.setIsManager(F().Q1().U().getIs_manager());
            }
            if (F().Q1().l().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(F().Q1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(F().Q1().l().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (F().Q1().l() != null) {
                addBigImageData.setForumHeadUrl(F().Q1().l().getImage_url());
                addBigImageData.setUserLevel(F().Q1().l().getUser_level());
            }
            if (F() != null && (M3 = M3(F().Q1())) != null) {
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

    public DetailInfoAndReplyFragment K3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (!StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
                String q2 = ht4.k().q("bubble_link", "");
                if (StringUtils.isNull(q2)) {
                    return false;
                }
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                } else {
                    cl4.s(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0529), q2 + "?props_id=" + str, true, true, true);
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
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.F();
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
        py7 py7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
            if (!this.q1 && (this.r1 || B4())) {
                H5();
                UtilHelper.hideStatusBar(N(), N().O0());
                this.r1 = false;
                py7 py7Var2 = this.k;
                if (py7Var2 != null) {
                    py7Var2.T0(false);
                }
            }
            if (i2 == 4) {
                py7 py7Var3 = this.k;
                if (py7Var3 != null) {
                    return py7Var3.onBackPress();
                }
                return false;
            } else if (i2 == 24) {
                py7 py7Var4 = this.k;
                if (py7Var4 != null) {
                    return py7Var4.onVolumeUp();
                }
                return false;
            } else if (i2 != 25 || (py7Var = this.k) == null) {
                return false;
            } else {
                return py7Var.Q0();
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

    @Override // com.repackage.sf5
    public eg<RelativeLayout> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            eg<RelativeLayout> egVar = new eg<>(new x1(this), 10, 0);
            this.g0 = egVar;
            return egVar;
        }
        return (eg) invokeV.objValue;
    }

    public PostData M3(rq7 rq7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, rq7Var)) == null) {
            PostData postData = null;
            if (rq7Var == null) {
                return null;
            }
            if (rq7Var.W() != null) {
                return rq7Var.W();
            }
            if (!ListUtils.isEmpty(rq7Var.F())) {
                Iterator<PostData> it = rq7Var.F().iterator();
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
                postData = rq7Var.j();
            }
            if (postData == null) {
                postData = Z3(rq7Var);
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
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.h.setVisibility(z2 ? 0 : 8);
        }
    }

    public final void M5() {
        AbsPbActivity absPbActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || (absPbActivity = this.a) == null) {
            return;
        }
        absPbActivity.g1();
    }

    @Override // com.repackage.wx7
    public AbsPbActivity N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.a : (AbsPbActivity) invokeV.objValue;
    }

    public abstract int N3();

    public final void N4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (!ni.z()) {
                showToast(R.string.obfuscated_res_0x7f0f0c38);
            } else if (this.N == null || F() == null) {
            } else {
                this.N.F();
                if (this.L) {
                    return;
                }
                L5();
                r5();
                if (F().loadData()) {
                    B5();
                }
            }
        }
    }

    public final boolean N5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (F() == null) {
                return true;
            }
            if (F().Q1() == null || !F().Q1().g0()) {
                if (F().B1()) {
                    MarkData m12 = F().m1();
                    if (m12 != null && F().z1() && a4() != null) {
                        MarkData g12 = F().g1(a4().getFirstVisiblePosition());
                        if (g12 == null) {
                            Intent intent = new Intent();
                            intent.putExtra("mark", m12);
                            this.a.setResult(-1, intent);
                            return true;
                        } else if (g12.getPostId() != null && !g12.getPostId().equals(m12.getPostId())) {
                            nq4 nq4Var = new nq4(getBaseFragmentActivity());
                            nq4Var.setMessage(getPageContext().getString(R.string.obfuscated_res_0x7f0f025f));
                            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f041f, new t(this, g12, m12, nq4Var));
                            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new u(this, m12, nq4Var));
                            nq4Var.setOnCalcelListener(new w(this));
                            nq4Var.create(getBaseFragmentActivity().getPageContext());
                            nq4Var.show();
                            return false;
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra("mark", m12);
                            this.a.setResult(-1, intent2);
                        }
                    }
                    return true;
                }
                if (F().Q1() != null && F().Q1().F() != null && F().Q1().F().size() > 0 && F().z1()) {
                    this.a.setResult(1);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.sf5
    public eg<ImageView> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (this.X == null) {
                this.X = new eg<>(new t1(this), 8, 0);
            }
            return this.X;
        }
        return (eg) invokeV.objValue;
    }

    public final String O3() {
        InterceptResult invokeV;
        ArrayList<PostData> F;
        int count;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (F() == null || F().Q1() == null || F().Q1().F() == null || (count = ListUtils.getCount((F = F().Q1().F()))) == 0) {
                return "";
            }
            if (F().b2()) {
                Iterator<PostData> it = F.iterator();
                while (it.hasNext()) {
                    PostData next = it.next();
                    if (next != null && next.B() == 1) {
                        return next.J();
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
                if (F().G2(postData.s().getUserId())) {
                    return postData.J();
                }
                for (int i3 = i2 - 1; i3 != 0; i3--) {
                    PostData postData2 = (PostData) ListUtils.getItem(F, i3);
                    if (postData2 == null || postData2.s() == null || postData2.s().getUserId() == null) {
                        break;
                    } else if (F().G2(postData2.s().getUserId())) {
                        return postData2.J();
                    }
                }
                for (int i4 = i2 + 1; i4 < count; i4++) {
                    PostData postData3 = (PostData) ListUtils.getItem(F, i4);
                    if (postData3 == null || postData3.s() == null || postData3.s().getUserId() == null) {
                        break;
                    } else if (F().G2(postData3.s().getUserId())) {
                        return postData3.J();
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
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            if (i2 == 0) {
                uf8.g().h(getUniqueId(), false);
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
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            m25 m25Var = this.I0;
            if (m25Var != null) {
                k5(m25Var.C());
            }
            b5();
            this.N.F();
        }
    }

    @Override // com.repackage.sf5
    public eg<View> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (this.Y == null) {
                this.Y = new eg<>(new v1(this), 8, 0);
            }
            return this.Y;
        }
        return (eg) invokeV.objValue;
    }

    public abstract int P3();

    public void P4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) || N() == null) {
            return;
        }
        if (this.r1 && !TbSingleton.getInstance().isNotchScreen(N()) && !TbSingleton.getInstance().isCutoutScreen(N())) {
            H5();
            UtilHelper.hideStatusBar(N(), N().O0());
            this.r1 = false;
        }
        this.u0.b = z2;
        R4();
        U4();
    }

    public final void P5() {
        ViewGroup.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (layoutParams = this.v.getLayoutParams()) == null) {
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

    @Override // com.repackage.sf5
    public void Q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, str) == null) {
        }
    }

    public boolean Q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.u : invokeV.booleanValue;
    }

    public void Q4(ez4 ez4Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048637, this, ez4Var, i2) == null) || (fallingView = this.K) == null) {
            return;
        }
        fallingView.D(ez4Var, getPageContext(), i2, false);
    }

    public final void Q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.I = ofFloat;
            ofFloat.setDuration(300L);
            this.I.addUpdateListener(new s1(this));
            this.I.start();
        }
    }

    @Override // com.repackage.sf5
    public void R(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048639, this, context, str, z2) == null) {
            if (av7.c(str) && F() != null && F().i2() != null) {
                TiebaStatic.log(new StatisticItem("c11664").param("obj_param1", 1).param("post_id", F().i2()));
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    vz4 vz4Var = new vz4();
                    vz4Var.a = str;
                    vz4Var.b = 3;
                    vz4Var.c = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, vz4Var));
                }
            } else {
                av7.a().e(getPageContext(), str);
            }
            this.h0 = true;
        }
    }

    public View.OnClickListener R3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.D1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.k == null) {
            return;
        }
        boolean z2 = false;
        if (this.u0.a()) {
            this.k.X(false);
            return;
        }
        py7 py7Var = this.k;
        if (!x4() && !this.k.O0()) {
            z2 = true;
        }
        py7Var.X(z2);
    }

    public final void R5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, layoutParams) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.E1 : (View.OnClickListener) invokeV.objValue;
    }

    public final void S4(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, rq7Var) == null) || rq7Var == null) {
            return;
        }
        ThreadData O = rq7Var.O();
        if (O != null && O.isUgcThreadType()) {
            o3();
        } else {
            o5(this.H0);
        }
        m25 m25Var = this.I0;
        if (m25Var != null) {
            k5(m25Var.C());
            this.I0.M(rq7Var.d());
            this.I0.N(rq7Var.l(), rq7Var.U());
            this.I0.s0(O);
            if (F() != null) {
                this.I0.O(F().s1(), F().i2(), F().o1());
            }
            if (O != null) {
                this.I0.h0(O.isMutiForumThread());
            }
        }
    }

    public final void S5(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, layoutParams) == null) {
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

    public SparseArray<Object> T3(rq7 rq7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData M3;
        do4 do4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048646, this, new Object[]{rq7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (rq7Var == null || (M3 = M3(rq7Var)) == null) {
                return null;
            }
            String userId = M3.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e4b, M3.J());
                sparseArray.put(R.id.obfuscated_res_0x7f091e4d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e68, Integer.valueOf(rq7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e8c, Boolean.FALSE);
            } else if (i2 == 1) {
                if (M3.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e56, M3.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e57, M3.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e58, M3.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091e59, M3.J());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091e4b, M3.J());
                sparseArray.put(R.id.obfuscated_res_0x7f091e4d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f091e68, Integer.valueOf(rq7Var.V()));
                sparseArray.put(R.id.obfuscated_res_0x7f091e8c, Boolean.TRUE);
            }
            if (!z3) {
                List<xp4> p2 = rq7Var.p();
                if (ListUtils.getCount(p2) > 0) {
                    sb = new StringBuilder();
                    for (xp4 xp4Var : p2) {
                        if (xp4Var != null && !StringUtils.isNull(xp4Var.c()) && (do4Var = xp4Var.g) != null && do4Var.a && !do4Var.c && ((i3 = do4Var.b) == 1 || i3 == 2)) {
                            sb.append(oi.cutString(xp4Var.c(), 12));
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0646));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091e4a, String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f048e), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void T4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048647, this) == null) || !checkUpIsLogin() || F() == null || F().Q1() == null || F().Q1().l() == null || q3()) {
            return;
        }
        if (F().Q1().g0()) {
            u3();
            return;
        }
        if (this.D0 == null) {
            am6 am6Var = new am6(getPageContext());
            this.D0 = am6Var;
            am6Var.j(0);
            this.D0.i(new d1(this));
        }
        this.D0.g(F().Q1().l().getId(), ng.g(F().i2(), 0L));
    }

    public final void T5() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048648, this) == null) || F() == null || !TbadkCoreApplication.isLogin() || !AddExperiencedModel.E(F().getForumId()) || F().Q1() == null || F().Q1().l() == null) {
            return;
        }
        if (F().Q1().l().isLike() == 1) {
            F().d1().D(F().getForumId(), F().i2());
        }
    }

    public uk4 U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.P : (uk4) invokeV.objValue;
    }

    public final void U4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || this.k == null || this.e == null) {
            return;
        }
        boolean z2 = false;
        if (!A4()) {
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

    public void U5(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048651, this, rq7Var) == null) {
            if (rq7Var != null && AntiHelper.o(rq7Var.O())) {
                az7 az7Var = this.r0;
                if (az7Var != null) {
                    az7Var.l(false);
                    this.r0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.q0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.q0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f08093b, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            az7 az7Var2 = this.r0;
            if (az7Var2 == null || !az7Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.q0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.q0, R.drawable.obfuscated_res_0x7f08093b, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // com.repackage.sf5
    public void V(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048652, this, context, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.N.p0(str);
        pq4 R = this.N.R();
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

    public View.OnLongClickListener V3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.L1 : (View.OnLongClickListener) invokeV.objValue;
    }

    public void V4(boolean z2, int i2, int i3, int i4, rq7 rq7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rq7Var, str, Integer.valueOf(i5)}) == null) {
            for (BaseFragment baseFragment : this.f.c()) {
                if (baseFragment instanceof vx7) {
                    ((vx7) baseFragment).g1(z2, i2, i3, i4, rq7Var, str, i5);
                }
            }
            g1(z2, i2, i3, i4, rq7Var, str, i5);
        }
    }

    public void V5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z2) == null) {
            DetailInfoAndReplyFragment K3 = K3();
            if (K3 != null && K3.r1() != null && K3.r1().f() != null && K3.r1().g() != null) {
                K3.r1().f().O0(z2);
                K3.r1().g().m0(z2);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.z1 : (View.OnTouchListener) invokeV.objValue;
    }

    public void W4(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, rq7Var) == null) || rq7Var == null || rq7Var.O() == null) {
            return;
        }
        U5(rq7Var);
        this.p0.setVisibility(rq7Var.g0() ? 8 : 0);
        if (rq7Var.r()) {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080937, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        String G3 = G3(rq7Var.O().getReply_num());
        TextView textView = this.s0;
        if (textView != null) {
            textView.setText(G3);
        }
        TextView textView2 = this.t0;
        if (textView2 != null) {
            textView2.setText(G3);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, rq7Var.O()));
    }

    public m25 X3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.I0 : (m25) invokeV.objValue;
    }

    public void X4(boolean z2, MarkData markData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048659, this, z2, markData) == null) || F() == null) {
            return;
        }
        q5();
        F().D3(z2);
        uk4 uk4Var = this.P;
        if (uk4Var != null) {
            uk4Var.h(z2);
            if (markData != null) {
                this.P.i(markData);
            }
        }
        if (F().B1()) {
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

    @Override // com.repackage.sf5
    public void Y(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048660, this, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        this.h0 = true;
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

    public void Y4(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, rq7Var) == null) || rq7Var == null || rq7Var.O() == null) {
            return;
        }
        String valueOf = String.valueOf(rq7Var.O().getReply_num());
        if (rq7Var.O().getReply_num() == 0) {
            valueOf = "";
        }
        this.d.F(valueOf);
    }

    @Override // com.repackage.sf5
    public eg<TextView> Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.W == null) {
                this.W = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.W;
        }
        return (eg) invokeV.objValue;
    }

    public final PostData Z3(rq7 rq7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, rq7Var)) == null) {
            if (rq7Var == null || rq7Var.O() == null || rq7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = rq7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = rq7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.q0(1);
            postData.v0(rq7Var.O().getFirstPostId());
            postData.H0(rq7Var.O().getTitle());
            postData.G0(rq7Var.O().getCreateTime());
            postData.o0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void Z4(hr7 hr7Var) {
        boolean z2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, hr7Var) == null) || F() == null || F().Q1() == null || hr7Var.i() == null) {
            return;
        }
        String J = hr7Var.i().J();
        ArrayList<PostData> F = F().Q1().F();
        int i2 = 0;
        while (true) {
            z2 = true;
            if (i2 >= F.size()) {
                break;
            }
            PostData postData = F.get(i2);
            if (postData.J() == null || !postData.J().equals(J)) {
                i2++;
            } else {
                ArrayList<PostData> k2 = hr7Var.k();
                postData.E0(hr7Var.m());
                if (postData.S() != null && k2 != null) {
                    Iterator<PostData> it = k2.iterator();
                    while (it.hasNext()) {
                        PostData next = it.next();
                        if (postData.Z() != null && next != null && next.s() != null && (metaData = postData.Z().get(next.s().getUserId())) != null) {
                            next.o0(metaData);
                            next.y0(true);
                            next.K0(getPageContext(), F().G2(metaData.getUserId()));
                        }
                    }
                    boolean z3 = k2.size() != postData.S().size();
                    if (!postData.d0(true)) {
                        postData.S().clear();
                        postData.S().addAll(k2);
                    }
                    z2 = z3;
                }
                if (postData.y() != null) {
                    postData.m0();
                }
            }
        }
        if (F().z1() || !z2) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048667, this) == null) || this.I0 == null || this.J0 == null) {
            return;
        }
        i25.a().c(0);
        this.I0.T();
        this.I0.R();
        if (this.I0.y() != null) {
            this.I0.y().setMaxImagesAllowed(this.I0.v ? 1 : 9);
        }
        this.I0.m0(SendView.g);
        this.I0.j(SendView.g);
        o05 m2 = this.J0.m(23);
        o05 m3 = this.J0.m(2);
        o05 m4 = this.J0.m(5);
        if (m3 != null) {
            m3.r();
        }
        if (m4 != null) {
            m4.r();
        }
        if (m2 != null) {
            m2.hide();
        }
        this.J0.invalidate();
    }

    public ReplyFragment b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            a5();
            h4();
            this.K0.c();
            y5(false);
        }
    }

    public String c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (!oi.isEmpty(this.v0)) {
                return this.v0;
            }
            String string = TbadkCoreApplication.getInst().getResources().getString(tu7.b());
            this.v0 = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void c5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            layoutParams.height = 0;
            this.v.setLayoutParams(layoutParams);
            this.v.setVisibility(8);
        }
    }

    public final void d4(int i2, Intent intent) {
        u05 u05Var;
        rt7 rt7Var;
        u05 u05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048672, this, i2, intent) == null) {
            if (i2 == 0) {
                h4();
                rt7 rt7Var2 = this.K0;
                if (rt7Var2 != null) {
                    rt7Var2.c();
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
                    this.I0.S();
                    this.I0.u0(pbEditorData.getVoiceModel());
                    this.I0.G(writeData);
                    t05 n2 = this.I0.a().n(6);
                    if (n2 != null && (u05Var = n2.m) != null) {
                        u05Var.C(new h05(52, 0, pbEditorData.getVoiceModel()));
                    }
                    if (i2 == -1) {
                        this.I0.L(null, null);
                    }
                } else if (editorType != 1 || (rt7Var = this.K0) == null || rt7Var.b() == null) {
                } else {
                    p25 b3 = this.K0.b();
                    b3.c0(F().Q1().O());
                    b3.B(writeData);
                    b3.d0(pbEditorData.getVoiceModel());
                    t05 n3 = b3.a().n(6);
                    if (n3 != null && (u05Var2 = n3.m) != null) {
                        u05Var2.C(new h05(52, 0, pbEditorData.getVoiceModel()));
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
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            this.P0 = -1;
            this.Q0 = Integer.MIN_VALUE;
        }
    }

    @Override // com.repackage.sf5
    public eg<ItemCardView> e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
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
        rq7 Q1;
        int i2;
        az7 az7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048675, this, z2) == null) || F() == null || this.N == null) {
            return;
        }
        if ((!ShareSwitch.isOn() && !checkUpIsLogin()) || (Q1 = F().Q1()) == null) {
            return;
        }
        ThreadData O = Q1.O();
        if (O != null && O.getAuthor() != null) {
            TiebaStatic.log(new StatisticItem("c13402").param("tid", F().i2()).param("fid", Q1.m()).param("obj_locate", 4).param("uid", O.getAuthor().getUserId()));
            if (x4()) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", F().getForumId());
                statisticItem.param("tid", F().i2());
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
            statisticItem2.param("tid", F().i2());
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", F().getForumId());
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
                if (O.getBaijiahaoData() != null && !oi.isEmpty(O.getBaijiahaoData().oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, O.getBaijiahaoData().oriUgcVid);
                }
            }
            if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
            }
            if (N() != null) {
                s75.e(N(), statisticItem2);
            }
            az7Var = this.r0;
            if (az7Var != null) {
                statisticItem2.param("obj_param1", az7Var.g());
            }
            TiebaStatic.log(statisticItem2);
            if (pi.D()) {
                showToast(R.string.obfuscated_res_0x7f0f0c37);
                return;
            } else if (F().Q1() == null) {
                pi.O(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd4));
                return;
            } else {
                ArrayList<PostData> F = Q1.F();
                if ((F == null || F.size() <= 0) && F().g2()) {
                    pi.O(getPageContext().getPageActivity(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0dd4));
                    return;
                }
                this.N.F();
                L5();
                TiebaStatic.log(new StatisticItem("c11939"));
                if (AntiHelper.e(getContext(), O)) {
                    return;
                }
                az7 az7Var2 = this.r0;
                if (az7Var2 != null) {
                    az7Var2.l(false);
                    U5(Q1);
                }
                if (ShareSwitch.isOn()) {
                    int i4 = z2 ? 2 : 1;
                    if ((UbsABTestHelper.isResizeInduceSharingABTest() || UbsABTestHelper.isResizeInduceSharingABTestA()) && this.r0.i()) {
                        this.r0.m(false);
                        l4(ky4.a(), this.r0.g());
                        return;
                    }
                    D5(i4);
                    return;
                }
                this.N.B0();
                F().k1().B(CheckRealNameModel.TYPE_PB_SHARE, 6);
                return;
            }
        }
        i2 = 1;
        StatisticItem statisticItem22 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        statisticItem22.param("tid", F().i2());
        statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem22.param("fid", F().getForumId());
        if (!z2) {
        }
        statisticItem22.param("obj_name", i2);
        statisticItem22.param("obj_type", 2);
        if (O != null) {
        }
        if (!oi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
        }
        if (N() != null) {
        }
        az7Var = this.r0;
        if (az7Var != null) {
        }
        TiebaStatic.log(statisticItem22);
        if (pi.D()) {
        }
    }

    public boolean e5(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, view2)) == null) {
            if (view2 != null && (view2.getTag() instanceof SparseArray)) {
                Object obj = ((SparseArray) view2.getTag()).get(R.id.obfuscated_res_0x7f091e49);
                if (obj instanceof PostData) {
                    PostData postData = (PostData) obj;
                    if (!TextUtils.isEmpty(postData.t()) && km4.c().g()) {
                        return K4(postData.J());
                    }
                    if (checkUpIsLogin() && F() != null && F().Q1() != null) {
                        rt7 rt7Var = this.K0;
                        if (rt7Var != null) {
                            rt7Var.c();
                        }
                        hr7 hr7Var = new hr7();
                        hr7Var.A(F().Q1().l());
                        hr7Var.E(F().Q1().O());
                        hr7Var.C(postData);
                        this.L0.V(hr7Var);
                        this.L0.setPostId(postData.J());
                        H4(view2, postData.s().getUserId(), "", postData);
                        TiebaStatic.log("c11743");
                        m25 m25Var = this.I0;
                        if (m25Var != null) {
                            k5(m25Var.C());
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

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i f1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || this.k0 == null) {
            return;
        }
        this.j0.setVisibility(8);
        this.k0.setVisibility(8);
        this.u0.a = false;
        R4();
        U4();
    }

    public final void f5(EmotionImageData emotionImageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048679, this, emotionImageData) == null) || emotionImageData == null) {
            return;
        }
        if (this.Q == null) {
            uv7 uv7Var = new uv7(this.a);
            this.Q = uv7Var;
            uv7Var.n(this.C1);
            this.Q.m(this.k1);
        }
        this.Q.k(emotionImageData, F(), F().Q1());
    }

    @Override // com.repackage.wx7
    public void finish() {
        CardHListViewData q2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            PbModel N0 = this.a.N0();
            if (N0 != null && N0.Q1() != null && !N0.Q1().g0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = getPageContext();
                historyMessage.threadId = N0.Q1().O().getId();
                if (N0.isShareThread() && N0.Q1().O().originalThreadData != null) {
                    historyMessage.threadName = N0.Q1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = N0.Q1().O().getTitle();
                }
                if (N0.isShareThread() && !v0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = N0.Q1().l().getName();
                }
                ArrayList<PostData> F = N0.Q1().F();
                int I1 = b4() != null ? b4().I1() : 0;
                if (F != null && I1 >= 0 && I1 < F.size()) {
                    historyMessage.postID = F.get(I1).J();
                }
                historyMessage.isHostOnly = N0.t1();
                historyMessage.isSquence = N0.g2();
                historyMessage.isShareThread = N0.isShareThread();
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
            m25 m25Var = this.I0;
            if (m25Var != null) {
                m25Var.I();
            }
            if (N0 != null && (N0.v1() || N0.y1())) {
                Intent intent = new Intent();
                intent.putExtra("tid", N0.i2());
                if (this.y0) {
                    if (this.A0) {
                        intent.putExtra("type", 4);
                        intent.putExtra("top_data", N0.E1());
                    }
                    if (this.z0) {
                        intent.putExtra("type", 2);
                        intent.putExtra("good_data", N0.A1());
                    }
                }
                if (N0.Q1() != null && System.currentTimeMillis() - this.b >= 40000 && (q2 = N0.Q1().q()) != null && !ListUtils.isEmpty(q2.getDataList())) {
                    intent.putExtra("guess_like_data", q2);
                }
                this.a.setResult(-1, intent);
            }
            if (N5()) {
                if (N0 != null) {
                    rq7 Q1 = N0.Q1();
                    if (Q1 != null) {
                        if (Q1.U() != null) {
                            Q1.U().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                        }
                        if (!this.B0) {
                            if (this.j != null) {
                                Rect rect = new Rect();
                                this.j.getGlobalVisibleRect(rect);
                                nu7.b().t(rect);
                            }
                            nu7.b().s(this.e.getCurrentItem());
                            BdTypeRecyclerView a4 = a4();
                            nu7.b().n(N0.R1(), a4 != null ? a4.onSaveInstanceState() : null, N0.g2(), N0.t1(), false);
                        }
                    }
                } else {
                    nu7.b().m();
                }
                M5();
            }
        }
    }

    @Override // com.repackage.vx7
    public void g1(boolean z2, int i2, int i3, int i4, rq7 rq7Var, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048681, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), rq7Var, str, Integer.valueOf(i5)}) == null) {
        }
    }

    public void g4(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) || this.k0 == null || this.n0 == null) {
            return;
        }
        if (F() != null && F().Q1() != null) {
            this.n0.setText(TbSingleton.getInstance().getAdVertiComment(F().Q1().k0(), F().Q1().l0(), c4()));
        } else {
            this.n0.setText(c4());
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

    public final void g5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048683, this, i2) == null) || F() == null) {
            return;
        }
        showLoadingView(getView());
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage("reply", i2);
        privacySettingMessage.setTid(F().i2());
        sendMessage(privacySettingMessage);
    }

    @Override // com.repackage.sf5
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.repackage.sf5
    public void h1(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048685, this, context, str) == null) {
        }
    }

    public void h4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.o();
    }

    public void h5(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048687, this, i2) == null) || (linearLayout = this.i0) == null) {
            return;
        }
        linearLayout.setVisibility(i2);
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || this.a.getCurrentFocus() == null) {
            return;
        }
        pi.x(getPageContext().getPageActivity(), this.a.getCurrentFocus());
    }

    public void i5(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048689, this, editorTools) == null) {
            this.J0 = editorTools;
            editorTools.setId(R.id.obfuscated_res_0x7f09166c);
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
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            uk4 c3 = uk4.c(this.a);
            this.P = c3;
            if (c3 != null) {
                c3.j(this.Z0);
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.a);
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.y1);
            this.S = new vx4(getPageContext());
            this.N = new ky7(this);
        }
    }

    public void j4() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || (view2 = this.M) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void j5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            this.K.setFallingFeedbackListener(new FallingView.l() { // from class: com.repackage.ux7
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
        if (!(interceptable == null || interceptable.invokeV(1048693, this) == null) || F() == null || F().Q1() == null || F().Q1().O() == null) {
            return;
        }
        ThreadData O = F().Q1().O();
        O.mRecomAbTag = F().V1();
        O.mRecomWeight = F().Y1();
        O.mRecomSource = F().X1();
        O.mRecomExtra = F().W1();
        O.isSubPb = F().D1();
        if (O.getFid() == 0) {
            O.setFid(ng.g(F().getForumId(), 0L));
        }
        StatisticItem i2 = s75.i(getContext(), O, "c13562");
        if (i2 != null) {
            TiebaStatic.log(i2);
        }
    }

    public void k4() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048694, this) == null) || (rightFloatLayerView = this.X0) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void k5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            this.w0 = z2;
        }
    }

    @Override // com.repackage.wx7
    public PbFragment l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return null;
        }
        return (PbFragment) invokeV.objValue;
    }

    public final void l3(boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048697, this, z2, str) == null) || F() == null || F().Q1() == null || F().Q1().O() == null) {
            return;
        }
        ThreadData O = F().Q1().O();
        O.mRecomAbTag = F().V1();
        O.mRecomWeight = F().Y1();
        O.mRecomSource = F().X1();
        O.mRecomExtra = F().W1();
        if (O.getFid() == 0) {
            O.setFid(ng.g(F().getForumId(), 0L));
        }
        StatisticItem i2 = s75.i(getContext(), O, TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
        TbPageTag l2 = s75.l(getContext());
        if (i2 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a005");
            i2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a023");
        }
        if (i2 != null) {
            if (O.isVideoThreadType()) {
                i2.param(TiebaStatic.Params.POST_CONTENT, gd5.d(str) > 40 ? gd5.n(str, 40) : str);
            }
            i2.param(TiebaStatic.Params.REPLY_TYPE, 1);
            if (z2) {
                i2.addParam("obj_type", 2);
            } else {
                i2.addParam("obj_type", 1);
            }
            n75 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            i2.addParam("tid", F().i2());
            i2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i2.addParam("fid", F().Q1().m());
            TiebaStatic.log(i2);
        }
        StatisticItem i3 = s75.i(getContext(), O, "c14180");
        if (i3 != null && l2 != null && "a023".equals(l2.locatePage)) {
            i3.addParam("obj_type", 2);
        } else {
            i3.addParam("obj_type", 1);
        }
        i3.param("tid", F().i2());
        i3.param("uid", TbadkCoreApplication.getCurrentAccountId());
        i3.param("fid", F().Q1().m());
        if (l2 != null) {
            i3.param("obj_source", l2.tabType);
        }
        TiebaStatic.log(i3);
        StatisticItem i4 = s75.i(getContext(), O, "c14303");
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
            i4.param("tid", F().i2());
            i4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            i4.param("fid", F().Q1().m());
            i4.param("obj_type", 1);
        }
        TiebaStatic.log(i4);
    }

    public final void l4(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048698, this, i2, i3) == null) {
            ed5.b(new z(this, i3), new a0(this, i3, i2));
        }
    }

    public void l5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
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
        Rect h12;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048700, this, threadData) == null) {
            double k2 = pi.k(getContext());
            double i3 = (2.0d * k2) / pi.i(getContext());
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
                    int height = (F() != null || (h12 = F().h1()) == null) ? ceil : h12.height();
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
            if (F() != null) {
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
        if (interceptable == null || interceptable.invokeV(1048701, this) == null) {
            this.i0 = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092319);
            this.j0 = this.c.findViewById(R.id.obfuscated_res_0x7f092377);
            this.k0 = this.c.findViewById(R.id.obfuscated_res_0x7f091670);
            pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
            pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070287);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090837);
            this.m0 = imageView;
            imageView.setOnClickListener(new u0(this));
            G4();
            this.n0 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091673);
            LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09166b);
            this.l0 = linearLayout;
            linearLayout.setOnClickListener(new v0(this));
            ImageView imageView2 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091671);
            this.o0 = imageView2;
            imageView2.setOnClickListener(this.D1);
            boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
            ImageView imageView3 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09166f);
            this.p0 = imageView3;
            imageView3.setOnClickListener(this.D1);
            if (booleanExtra) {
                this.p0.setVisibility(8);
            } else {
                this.p0.setVisibility(0);
            }
            if (z4()) {
                this.o0.setVisibility(0);
            } else {
                this.o0.setVisibility(8);
                this.p0.setPadding(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds84), 0, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds44), 0);
            }
            ImageView imageView4 = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091674);
            this.q0 = imageView4;
            imageView4.setOnClickListener(this.D1);
            this.r0 = new az7(this.q0);
            if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
                this.r0.f();
            }
            if (F() != null && UbsABTestHelper.isResizeInduceSharingABTest() && !mw7.k(F().i2())) {
                this.r0.f();
                mw7.b(F().i2());
            }
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091672);
            this.s0 = textView;
            textView.setVisibility(0);
            y5(false);
        }
    }

    public void m5(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) {
            this.r1 = z2;
        }
    }

    public final void n3(ny7 ny7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, ny7Var) == null) && ny7Var != null && this.w == null) {
            this.w = ny7Var;
            this.C.setText(ny7Var.getTitle());
            this.D.setText(ny7Var.l());
            String j2 = ny7Var.j();
            TBSpecificationBtn tBSpecificationBtn = this.F;
            if (TextUtils.isEmpty(j2)) {
                j2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0df3);
            }
            tBSpecificationBtn.setText(j2);
            this.G.J(ny7Var.f(), 10, false);
            this.H.setVisibility(ny7Var.n() ? 0 : 8);
            qg.a().postDelayed(new k1(this), ny7Var.c().longValue() * 1000);
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            this.L0 = new PbFakeFloorModel(getPageContext());
            PbModel F = F();
            this.L0.S(F.I(), F.E(), F.F(), F.D(), F.J());
            this.L0.setFromForumId(F.getFromForumId());
            rt7 rt7Var = new rt7(getPageContext(), this.L0, this.c);
            this.K0 = rt7Var;
            rt7Var.k(new y0(this));
            this.K0.n(this.B1);
            this.L0.U(new z0(this));
        }
    }

    public abstract void n5(boolean z2);

    public final void o3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048706, this) == null) || F() == null || this.a == null) {
            return;
        }
        m25 m25Var = this.I0;
        if (m25Var == null || !m25Var.v) {
            l25 l25Var = new l25();
            o5(l25Var);
            m25 m25Var2 = (m25) l25Var.a(getContext());
            this.I0 = m25Var2;
            m25Var2.e0(this.a.getPageContext());
            this.I0.o0(this.k1);
            this.I0.p0(this.C1);
            this.I0.F(this.a.getPageContext(), this.a.getIntent() == null ? null : this.a.getIntent().getExtras());
            this.I0.a().C(true);
            i5(this.I0.a());
            if (!F().D1()) {
                this.I0.s(F().i2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (F().w2()) {
                this.I0.l0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0de4));
            } else {
                this.I0.l0(c4());
            }
        }
    }

    public void o4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            i5(this.I0.a());
        }
    }

    public final void o5(o25 o25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, o25Var) == null) || o25Var == null || F() == null) {
            return;
        }
        o25Var.p(F().p1());
        if (F().Q1() != null && F().Q1().l() != null) {
            o25Var.o(F().Q1().l());
        }
        o25Var.q("pb");
        o25Var.r(F());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, bundle) == null) {
            super.onActivityCreated(bundle);
            getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.obfuscated_res_0x7f09069b));
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            S4(videoPbViewModel.c());
            t4(videoPbViewModel.c());
            Y4(videoPbViewModel.c());
            if (F() != null && F().Q1() != null) {
                boolean z12 = F().z1();
                rq7 Q1 = F().Q1();
                if (z12) {
                    PostData M3 = M3(Q1);
                    if (Q1.u() != null && !Q1.u().equals(M3.J()) && this.e != null) {
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
            this.a.S0().l(this.V0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048710, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.I0.H(i2, i3, intent);
            uv7 uv7Var = this.Q;
            if (uv7Var != null) {
                uv7Var.i(i2, i3, intent);
            }
            rt7 rt7Var = this.K0;
            if (rt7Var != null) {
                rt7Var.g(i2, i3, intent);
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
                    a88.g().m(getPageContext());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, context) == null) {
            super.onAttach(context);
            this.a = (AbsPbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i2) == null) {
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
            xu7 xu7Var = this.F0;
            if (xu7Var != null) {
                xu7Var.i();
            }
            zx7 zx7Var = this.l;
            if (zx7Var == null || !zx7Var.k()) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            EditorTools editorTools = this.J0;
            if (editorTools != null) {
                editorTools.w(i2);
            }
            rt7 rt7Var = this.K0;
            if (rt7Var != null) {
                rt7Var.h(i2);
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null) {
                rightFloatLayerView.o();
            }
            LinearLayout linearLayout = this.l0;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
            }
            if (F() != null && F().B1()) {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080937, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.p0, R.drawable.obfuscated_res_0x7f080936, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            WebPManager.setPureDrawable(this.o0, R.drawable.obfuscated_res_0x7f080939, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.m0, R.drawable.obfuscated_res_0x7f080971, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.E, R.drawable.obfuscated_res_0x7f0808f8, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            if (F() != null) {
                U5(F().Q1());
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
            SkinManager.setBackgroundShapeDrawable(this.s0, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
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
                view2.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(pi.f(view2.getContext(), R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0309)));
            }
            L5();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            py7 py7Var = this.k;
            if (py7Var == null || py7Var.O0()) {
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
        if (interceptable == null || interceptable.invokeL(1048714, this, bundle) == null) {
            this.b = System.currentTimeMillis();
            super.onCreate(bundle);
            this.needLogStayDuration = false;
            initData();
            p4(bundle);
            u0().onCreate(getPageContext());
            lt4 lt4Var = new lt4();
            this.O = lt4Var;
            lt4Var.a = 1000L;
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
            this.t = new kw5(getPageContext());
            uf8.g().i(getUniqueId());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048715, this, layoutInflater, viewGroup, bundle)) == null) {
            this.c = (RelativeLayout) layoutInflater.inflate(P3(), viewGroup, false);
            v4();
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            super.onDestroy();
            uf8.g().k(getUniqueId());
            MessageManager.getInstance().unRegisterListener(this.H1);
            u0().onDestory(getPageContext());
            az7 az7Var = this.r0;
            if (az7Var != null) {
                az7Var.k();
            }
            ForumManageModel forumManageModel = this.T;
            if (forumManageModel != null) {
                forumManageModel.cancelLoadData();
            }
            py7 py7Var = this.k;
            if (py7Var != null) {
                py7Var.P0();
            }
            uv7 uv7Var = this.Q;
            if (uv7Var != null) {
                uv7Var.f();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.C0;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            if (F() != null) {
                F().cancelLoadData();
                F().destory();
                if (F().M1() != null) {
                    F().M1().d();
                }
            }
            m25 m25Var = this.I0;
            if (m25Var != null) {
                m25Var.I();
            }
            this.O = null;
            K5();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            super.onPause();
            this.T0 = true;
            u0().onPause(getPageContext());
            py7 py7Var = this.k;
            if (py7Var != null) {
                py7Var.onBackground(true);
            }
            if (F() != null && !F().D1()) {
                this.I0.U(F().i2());
            }
            RightFloatLayerView rightFloatLayerView = this.X0;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            wh4.w().E();
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            MessageManager.getInstance().unRegisterListener(this.g1);
            MessageManager.getInstance().unRegisterListener(this.G1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            super.onResume();
            this.T0 = false;
            u0().onResume(getPageContext());
            py7 py7Var = this.k;
            if (py7Var != null) {
                py7Var.onBackground(false);
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
        if (interceptable == null || interceptable.invokeL(1048719, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (F() != null) {
                F().j3(bundle);
            }
            if (getPageContext() == null || getPageContext().getPageActivity() == null) {
                return;
            }
            u0().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            super.onStart();
            u0().onStart(getPageContext());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048721, this) == null) {
            super.onStop();
            u0().onStop(getPageContext());
            uf8.g().h(getUniqueId(), false);
            MessageManager.getInstance().unRegisterListener(this.I1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048722, this, z2) == null) {
            super.onUserChanged(z2);
            G4();
        }
    }

    public void p3(BdTypeRecyclerView bdTypeRecyclerView, boolean z2) {
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048723, this, bdTypeRecyclerView, z2) == null) {
            int firstVisiblePosition = bdTypeRecyclerView.getListView2().getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getListView2().getLastVisiblePosition();
            ArrayList arrayList = new ArrayList();
            if (lastVisiblePosition > firstVisiblePosition) {
                while (firstVisiblePosition <= lastVisiblePosition) {
                    if (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) != null && (bdTypeRecyclerView.getListView2().C(firstVisiblePosition) instanceof PostData) && (postData = (PostData) bdTypeRecyclerView.getListView2().C(firstVisiblePosition)) != null && postData.o() != null) {
                        postData.o().q(postData.B());
                        arrayList.add(postData.o());
                    }
                    firstVisiblePosition++;
                }
            }
            if (ListUtils.getItem(arrayList, 0) != null) {
                Collections.sort(arrayList, new z1(this));
                if (((ez4) ListUtils.getItem(arrayList, 0)).e() != 1) {
                    Q4((ez4) ListUtils.getItem(arrayList, 0), 1);
                } else if (z2) {
                } else {
                    Q4((ez4) ListUtils.getItem(arrayList, 0), 0);
                }
            }
        }
    }

    public final void p4(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, bundle) == null) {
            o25 o25Var = new o25();
            this.H0 = o25Var;
            o5(o25Var);
            m25 m25Var = (m25) this.H0.a(getActivity());
            this.I0 = m25Var;
            m25Var.e0(this.a.getPageContext());
            this.I0.o0(this.k1);
            this.I0.p0(this.C1);
            this.I0.g0(1);
            this.I0.F(this.a.getPageContext(), bundle);
            this.I0.a().b(new r05(getActivity()));
            this.I0.a().C(true);
            v5(true);
            if (F() != null) {
                this.I0.O(F().s1(), F().i2(), F().o1());
            }
            registerListener(this.c1);
            registerListener(this.e1);
            registerListener(this.m1);
            registerListener(this.b1);
            registerListener(this.d1);
            registerListener(this.f1);
            registerListener(this.K1);
            if (!F().D1()) {
                this.I0.s(F().i2());
            }
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getAdVertiComment())) {
                this.I0.l0(TbSingleton.getInstance().getAdVertiComment());
            } else if (F().w2()) {
                this.I0.l0(getPageContext().getString(R.string.obfuscated_res_0x7f0f0de4));
            } else {
                this.I0.l0(c4());
            }
            this.F0 = new xu7();
            if (this.I0.v() != null) {
                this.F0.m(this.I0.v().i());
            }
            this.I0.d0(this.a1);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.C0 = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new n0(this));
        }
    }

    public void p5(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048725, this, z2, postWriteCallBackData) == null) {
            hideProgressBar();
            ky7 ky7Var = this.N;
            if (ky7Var == null) {
                return;
            }
            if (z2) {
                ky7Var.F();
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
        if (!(interceptable == null || interceptable.invokeLLL(1048726, this, spannableStringBuilder, textView, tbRichTextView) == null) || spannableStringBuilder == null || textView == null || tbRichTextView == null || spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            return;
        }
        Object[] objArr = (pf5[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), pf5.class);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (av7.c(objArr[i2].d()) && (drawable = SkinManager.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                spannableStringBuilder2.setSpan(new wd5(drawable), 0, 33, 33);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            PbModel F = F();
            if (F == null || F.Q1() == null) {
                return false;
            }
            ThreadData O = F.Q1().O();
            F.Q1().d();
            return AntiHelper.b(getPageContext(), O);
        }
        return invokeV.booleanValue;
    }

    public final void q4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            this.C = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091713);
            this.G = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091712);
            this.D = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09170f);
            this.E = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09170e);
            this.F = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091711);
            this.H = this.c.findViewById(R.id.obfuscated_res_0x7f0901e7);
            this.G.setRadius(pi.f(getContext(), R.dimen.tbds10));
            this.G.setConrers(15);
            this.F.setConfig(new yt4());
            this.E.setOnClickListener(new t0(this));
            this.F.setOnClickListener(this.B);
            this.v.setOnClickListener(this.B);
            if (F() == null || F().Q1() == null) {
                return;
            }
            A5(F().Q1());
        }
    }

    public void q5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048730, this, i2)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f09231a);
            this.m = navigationBar;
            navigationBar.setOnClickListener(new x0(this));
            this.m.hideBottomLine();
            this.m.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802c7);
            this.m.getTopCoverBgView().setVisibility(0);
            this.n = this.c.findViewById(R.id.obfuscated_res_0x7f091d8d);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091d92);
            this.o = findViewById;
            if (this.q1) {
                ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
                layoutParams.height = pi.s(N());
                this.n.setLayoutParams(layoutParams);
                this.n.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                layoutParams2.height = pi.s(N());
                this.o.setLayoutParams(layoutParams2);
                this.o.setVisibility(0);
            }
            View addSystemImageButton = this.m.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.D1);
            this.p = addSystemImageButton;
            this.q = (ImageView) addSystemImageButton.findViewById(R.id.obfuscated_res_0x7f09242f);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.q, R.drawable.obfuscated_res_0x7f08060d, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05cf, this.D1);
            this.r = addCustomView;
            this.s = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0914da);
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds132);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21);
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
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            pi.x(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            if ((F() != null && F().Q1().g0()) || this.C0 == null || F() == null || F().Q1() == null || ThreadCardUtils.isSelf(F().Q1().O()) || F().Q1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeInvokeEditor(F().Q1().d().replyPrivateFlag);
        }
        return invokeV.booleanValue;
    }

    public void s4() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048734, this) == null) || (editorTools = this.J0) == null) {
            return;
        }
        editorTools.j();
        m25 m25Var = this.I0;
        if (m25Var != null) {
            m25Var.P();
        }
        f4();
    }

    public final void s5(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048735, this, i2) == null) || F() == null) {
            return;
        }
        int Z1 = F().Z1();
        if (i2 == 5) {
            F().x3(2);
        } else if (i2 == 6) {
            F().x3(3);
        } else if (i2 != 7) {
            F().x3(1);
        } else {
            F().x3(4);
        }
        int Z12 = F().Z1();
        if (Z1 == 4 || Z12 == 4) {
            N4();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z2) {
        CustomViewPager customViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z2) == null) {
            super.setPrimary(z2);
            VideoPbFragmentAdapter videoPbFragmentAdapter = this.f;
            if (videoPbFragmentAdapter == null || (customViewPager = this.e) == null) {
                return;
            }
            videoPbFragmentAdapter.d(z2 ? customViewPager.getCurrentItem() : -1);
        }
    }

    public boolean t3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048737, this, i2)) == null) {
            if (this.C0 == null || F() == null || F().Q1() == null || ThreadCardUtils.isSelf(F().Q1().O()) || F().Q1().d() == null) {
                return true;
            }
            return this.C0.checkPrivacyBeforeSend(F().Q1().d().replyPrivateFlag, i2);
        }
        return invokeI.booleanValue;
    }

    public void t4(rq7 rq7Var) {
        xv4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048738, this, rq7Var) == null) || this.W0 == null || rq7Var == null || rq7Var.g() == 3 || x4()) {
            return;
        }
        if (rq7Var.k0()) {
            pbAdFloatViewItemData = rq7Var.Z();
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
            this.X0.setLogoListener(new g0(this, rq7Var, pbAdFloatViewItemData));
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
        if (!(interceptable == null || interceptable.invokeV(1048741, this) == null) || F() == null || oi.isEmpty(F().i2())) {
            return;
        }
        super.taskStart();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            if (this.U == null) {
                this.U = VoiceManager.instance();
            }
            return this.U;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048743, this) == null) {
            if (!checkUpIsLogin()) {
                if (F() != null) {
                    TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", F().getForumId()));
                }
            } else if (s3()) {
                m25 m25Var = this.I0;
                if (m25Var != null && (m25Var.B() || this.I0.D())) {
                    this.I0.z(false, null);
                    return;
                }
                if (this.J0 != null) {
                    s4();
                    this.u0.a = false;
                    if (this.J0.n(2) != null) {
                        eh8.c(getPageContext(), (View) this.J0.n(2).m, false, null);
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
            layoutParams.leftMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds4);
            this.d.setContainerLayoutParams(layoutParams);
            this.d.setRectPaintColor(R.color.CAM_X0302);
            this.d.C(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
            this.d.setIndicatorOffset(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds64));
            this.d.setIndicatorOvershot(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8));
            this.d.setIndicatorMarginBottom(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
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

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            PbModel N0 = this.a.N0();
            if (N0 == null) {
                return false;
            }
            return N0.F2();
        }
        return invokeV.booleanValue;
    }

    public final void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            if (F().v1() || F().y1()) {
                Intent intent = new Intent();
                intent.putExtra("type", 0);
                intent.putExtra("tid", F().i2());
                this.a.setResult(-1, intent);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, F().i2()));
            if (N5()) {
                this.a.finish();
            }
        }
    }

    public void v4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            y26 y26Var = new y26(getActivity());
            this.M0 = y26Var;
            y26Var.i(this.A1);
            this.q1 = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
            r4();
            this.i = (AppBarLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090292);
            this.g = this.c.findViewById(R.id.obfuscated_res_0x7f091715);
            this.W0 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a99);
            this.j = (VideoContainerLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091703);
            py7 py7Var = new py7(getContext(), this.j);
            this.k = py7Var;
            py7Var.setStageType("2002");
            this.k.setUniqueId(getUniqueId());
            this.k.Y0(this);
            this.k.W0(N().O0());
            this.k.X0(this.o);
            ((RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091bed)).setMinimumHeight(((int) Math.ceil((pi.k(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
            this.d = (NewPagerSlidingTabBaseStrip) this.c.findViewById(R.id.obfuscated_res_0x7f091719);
            this.v = this.c.findViewById(R.id.obfuscated_res_0x7f091710);
            this.e = (CustomViewPager) this.c.findViewById(R.id.obfuscated_res_0x7f09171b);
            this.h = this.c.findViewById(R.id.obfuscated_res_0x7f090fc2);
            this.A = (MaskView) this.c.findViewById(R.id.obfuscated_res_0x7f091377);
            this.h.setOnClickListener(this.D1);
            u4();
            q4();
            m4();
            VideoPbFragmentAdapter videoPbFragmentAdapter = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
            this.f = videoPbFragmentAdapter;
            this.e.setAdapter(videoPbFragmentAdapter);
            this.d.setViewPager(this.e);
            this.d.setOnPageChangeListener(new q0(this));
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.K = (FallingView) this.c.findViewById(R.id.obfuscated_res_0x7f090946);
            j5();
            this.K.setAnimationListener(new s0(this));
            o4();
            n4();
            if (!this.q1 && this.r1) {
                H5();
                UtilHelper.hideStatusBar(N(), N().O0());
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
            this.I0.f0(z2);
            this.I0.j0(z2);
            this.I0.q0(z2);
        }
    }

    public void w3(ForumManageModel.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048750, this, bVar) == null) {
            List<PostData> list = F().Q1().T().a;
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 0;
                while (true) {
                    if (i3 >= list.get(i2).S().size()) {
                        break;
                    } else if (bVar.g.equals(list.get(i2).S().get(i3).J())) {
                        list.get(i2).S().remove(i3);
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
            this.l = new zx7(getBaseFragmentActivity(), this.j);
            int s2 = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? pi.s(N()) : 0;
            Rect rect = new Rect(0, s2, pi.k(getContext()), this.j.getOriginHeight() + s2);
            VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.l.r(videoPbViewModel.i(), rect);
            if (this.l.l()) {
                this.l.q(new m0(this, videoPbViewModel));
            } else if (A4() && (videoPbViewModel.n() || F().h2() == 1)) {
                this.e.setCurrentItem(1);
            } else if (videoPbViewModel.n() || F().h2() == 0) {
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
                ky7 ky7Var = this.N;
                if (ky7Var != null) {
                    ky7Var.K0(str);
                }
            } else {
                showToast(str);
            }
        }
    }

    @Override // com.repackage.sf5
    public eg<GifView> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            if (this.V == null) {
                this.V = new eg<>(new u1(this), 20, 0);
            }
            return this.V;
        }
        return (eg) invokeV.objValue;
    }

    public void x3(SparseArray<Object> sparseArray, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048754, this, sparseArray, jSONArray) == null) {
            int intValue = ((Integer) sparseArray.get(0)).intValue();
            if (intValue != 3) {
                if (intValue == 4 || intValue == 6) {
                    if (F().l1() != null) {
                        F().l1().b(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == 4) {
                        TiebaStatic.log("c10499");
                    }
                }
            } else if (this.T.S()) {
            } else {
                showProgressBar();
                String str = (String) sparseArray.get(R.id.obfuscated_res_0x7f091e4b);
                int intValue2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e68)).intValue();
                boolean booleanValue = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e4c)).booleanValue();
                int intValue3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e4d)).intValue();
                boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091e5f) != null ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e5f)).booleanValue() : false;
                if (jSONArray != null) {
                    this.T.U(StringHelper.JsonArrayToString(jSONArray));
                }
                this.T.V(F().Q1().l().getId(), F().Q1().l().getName(), F().Q1().O().getId(), str, intValue3, intValue2, booleanValue, F().Q1().O().getBaijiahaoData(), booleanValue2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    public abstract boolean x4();

    public final void x5(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048756, this, antiData, postWriteCallBackData) == null) || antiData == null || postWriteCallBackData == null) {
            return;
        }
        if (!AntiHelper.n(antiData) && !AntiHelper.g(antiData) && !AntiHelper.h(antiData) && !AntiHelper.f(antiData)) {
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                qy4.c(getPageContext(), postWriteCallBackData, 2);
                return;
            }
            if (StringUtils.isNull(errorString)) {
                errorString = getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f1122);
            }
            if (StringUtils.isNull(colorMsg)) {
                pi.O(getPageContext().getPageActivity(), errorString);
                return;
            }
            String str = errorString + " " + preMsg + colorMsg;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getPageContext().getPageActivity().getResources().getColor(R.color.CAM_X0305));
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(foregroundColorSpan, errorString.length() + preMsg.length() + 1, str.length(), 17);
            pi.J(getPageContext().getPageActivity(), str, spannableString, 3000);
            return;
        }
        if (F() != null && !F().D1()) {
            antiData.setBlock_forum_name(F().Q1().l().getName());
            antiData.setBlock_forum_id(F().Q1().l().getId());
            antiData.setUser_name(F().Q1().U().getUserName());
            antiData.setUser_id(F().Q1().U().getUserId());
        }
        AntiHelper.x(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
    }

    public void y3(nq4 nq4Var, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048757, this, nq4Var, jSONArray) == null) {
            nq4Var.dismiss();
            if (F() == null || F().Q1() == null || F().Q1().O() == null || F().Q1().l() == null) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                if (nq4Var.getYesButtonTag() instanceof SparseArray) {
                    x3((SparseArray) nq4Var.getYesButtonTag(), jSONArray);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            EditorTools editorTools = this.J0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void y5(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) || this.k0 == null) {
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

    @Override // com.repackage.sf5
    public eg<TiebaPlusRecommendCard> z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return null;
        }
        return (eg) invokeV.objValue;
    }

    public void z3(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091e4b, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091e4d, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f091e68, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f091e4c, Boolean.valueOf(z2));
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
        if (!(interceptable == null || interceptable.invokeZ(1048763, this, z2) == null) || this.k0 == null || (textView = this.n0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0506);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.k0.startAnimation(alphaAnimation);
        }
        this.j0.setVisibility(0);
        this.k0.setVisibility(0);
        this.u0.a = true;
    }

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
