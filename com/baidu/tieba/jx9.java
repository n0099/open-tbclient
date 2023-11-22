package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FirstPraiseToast;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.BlueCircleProgressDialog;
import com.baidu.tbadk.core.view.FriendBotView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.youngster.utils.YoungsterVerifyUtils;
import com.baidu.tieba.a05;
import com.baidu.tieba.a16;
import com.baidu.tieba.bw9;
import com.baidu.tieba.d16;
import com.baidu.tieba.g55;
import com.baidu.tieba.gra;
import com.baidu.tieba.hy9;
import com.baidu.tieba.j05;
import com.baidu.tieba.jw9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.mixplayer.TbLiveMixPlayerConfig;
import com.baidu.tieba.pb.mixplayer.TbMixPlayerView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.controller.PbContentCollectionController;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.PbFallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pq9;
import com.baidu.tieba.rq9;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.xt9;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import tbclient.AbilityConf;
import tbclient.CallRobotEntrance;
import tbclient.ItemInfo;
import tbclient.RobotEntrance;
import tbclient.RobotSkillInfo;
import tbclient.SpriteMemeInfo;
import tbclient.StyleConf;
import tbclient.StyleContentInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class jx9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int m2;
    public static int n2;
    public static int o2;
    public static int p2;
    public static int q2;
    public static int r2;
    public static int s2;
    public static final int t2;
    public static int u2;
    public static gra.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public hy9 A;
    public ImageView A0;
    public boolean A1;
    public PbContentCollectionController B;
    public TextView B0;
    public boolean B1;
    public bw9 C;
    public WaterRippleView C0;
    public tw9 C1;
    public zv9 D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public LinearLayout E;
    public AgreeView E0;
    public a16 E1;
    public TextView F;
    public ImageView F0;
    public d16 F1;
    public TextView G;
    public ImageView G0;
    public String G1;
    public ObservedChangeRelativeLayout H;
    public HeadImageView H0;
    public PermissionJudgePolicy H1;
    public rv9 I;
    public View I0;
    public int I1;
    public zz4 J;
    public FriendBotView J0;
    public int J1;
    public a05 K;
    public u1a K0;
    public boolean K1;
    public View L;
    public TextView L0;
    public boolean L1;
    public EditText M;
    public TextView M0;
    public t1a M1;
    public v1a N;
    public boolean N0;
    public MaskView N1;
    public PbListView O;
    public int O0;
    public final PbFallingView O1;
    public q1a P;
    public BlueCircleProgressDialog P0;
    public RightFloatLayerView P1;
    public View Q;
    public boolean Q0;
    public final FrameLayout Q1;
    public View R;
    public es9 R0;
    public LinearLayout R1;
    public View S;
    public vra S0;
    public oz9 S1;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1125T;
    public int T0;
    public final Object T1;
    public SortSwitchButton.f U;
    public int U0;
    public Runnable U1;
    public TbRichTextView.z V;
    public boolean V0;
    public CallRobotEntrance V1;
    public NoNetworkView.b W;
    public boolean W0;
    public TbMixPlayerView W1;
    public h05 X;
    public ViewStub X0;
    public CustomMessageListener X1;
    public View.OnClickListener Y;
    public PbInterviewStatusView Y0;
    public View.OnClickListener Y1;
    public zz4 Z;
    public TextView Z0;
    public final FriendBotView.f Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public Dialog a0;
    public View a1;
    public CustomMessageListener a2;
    public CardForumHeadLayout b;
    public Dialog b0;
    public View b1;
    public Handler b2;
    public int c;
    public View c0;
    public View c1;
    public Runnable c2;
    public boolean d;
    public LinearLayout d0;
    public PbReplyTitleViewHolder d1;
    public CustomMessageListener d2;
    public int e;
    public CompoundButton.OnCheckedChangeListener e0;
    public View e1;
    public PbFragment.i3 e2;
    public PbFragment f;
    public TextView f0;
    public int f1;
    public boolean f2;
    public RelativeLayout g;
    public TextView g0;
    public boolean g1;
    public View.OnClickListener g2;
    public View h;
    public String h0;
    public g1 h1;
    public String h2;
    public int i;
    public h05 i0;
    public int i1;
    public g55.g i2;
    public final Handler j;
    public h05 j0;
    public int j1;
    public View.OnClickListener j2;
    public final d0a k;
    public c05 k0;
    public Runnable k1;
    public final List<TbImageView> k2;
    public c0a l;
    public boolean l0;
    public PbFakeFloorModel l1;
    public boolean l2;
    public ViewStub m;
    public boolean m0;
    public gw9 m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public String o0;
    public int o1;
    public NoNetworkView p;
    public zt9 p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public ScrollView q0;
    public boolean q1;
    public PbThreadPostView r;
    public EditorTools r0;
    public boolean r1;
    public fx9 s;
    public boolean s0;
    public int s1;
    public jw9 t;
    public View t0;
    public PbTopTipView t1;
    public jw9 u;
    public View u0;
    public PopupWindow u1;
    public iy9 v;
    public EjectionAnimationView v0;
    public TextView v1;
    public ky9 w;
    public Button w0;
    public List<String> w1;
    public my9 x;
    public View x0;
    public qy9 x1;
    public jy9 y;
    public View y0;
    public ev9 y1;
    public ly9 z;
    public LinearLayout z0;
    public PbLandscapeListView.c z1;

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.id.obfuscated_res_0x7f091f80 : invokeV.intValue;
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
        }
    }

    public boolean J2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? R.id.obfuscated_res_0x7f091b28 : invokeV.intValue;
    }

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048765, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* loaded from: classes6.dex */
        public class a implements vd5 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.vd5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.v0.setVisibility(0);
                    this.a.a.v0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.E0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.v0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.v0.k();
                }
            }
        }

        public b(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.d4();
            xd5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.h
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.o3();
            this.a.v0.l();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements jw9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ jx9 b;

        /* loaded from: classes6.dex */
        public class a implements kr9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ i b;

            public a(i iVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = iVar;
                this.a = str;
            }

            @Override // com.baidu.tieba.kr9
            public void onDismiss() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.b.b.J0 != null) {
                        this.b.b.W0 = false;
                        this.b.b.J0.x();
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导展示完毕隐藏,文案：" + this.a);
                }
            }

            @Override // com.baidu.tieba.kr9
            public void onShow() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                    if (this.b.b.J0 != null) {
                        this.b.b.W0 = true;
                        this.b.b.J0.setDynamicLooping(true);
                        this.b.b.J0.r();
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导展示了,文案：" + this.a);
                }
            }
        }

        public i(jx9 jx9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.jw9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (nr9.c()) {
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,BotGuideManager在展示其他");
                } else {
                    long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_click_last_time", 0L);
                    if (!DateUtils.isToday(j) && !this.b.c3()) {
                        if (this.b.R0 == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData为null");
                            return;
                        }
                        RobotEntrance K = this.b.R0.K();
                        if (K == null) {
                            DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,pbData下robotEntrance为null");
                            return;
                        }
                        String str = K.bottom_bar_click_guide;
                        if (!TextUtils.isEmpty(str) && this.b.f != null) {
                            BaseFragmentActivity baseFragmentActivity = this.b.f.getBaseFragmentActivity();
                            if (baseFragmentActivity != null && this.b.J0 != null) {
                                nr9.e(str, this.b.J0, this.a.r0(), new a(this, str));
                                return;
                            }
                            TbLog defaultLog2 = DefaultLog.getInstance();
                            defaultLog2.e("BotGuideManager", "底bar点击引导未展示,activity=" + baseFragmentActivity + ",mBottomBot=" + this.b.J0);
                            return;
                        }
                        TbLog defaultLog3 = DefaultLog.getInstance();
                        defaultLog3.e("BotGuideManager", "底bar点击引导未展示,guideText=" + str + ",mPbFragment=" + this.b.f);
                        return;
                    }
                    TbLog defaultLog4 = DefaultLog.getInstance();
                    defaultLog4.e("BotGuideManager", "底bar点击引导未展示,当天已经展示过了：" + DateUtils.isToday(j) + "，话题在展示：" + this.b.c3());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements jw9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            public a(j jVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.r0() != null) {
                    p05.g(Collections.singletonList(new gx9(this.a.a.f.r0(), this.a.a.s)));
                }
            }
        }

        public j(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.jw9.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.W0 && !this.a.f.f8() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ jx9 g;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ l a;

            public a(l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = lVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.e1 != null && this.a.g.e1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.e1.getLayoutParams();
                    layoutParams.height = this.a.g.j1;
                    this.a.g.e1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(jx9 jx9Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = jx9Var;
            this.a = i;
            this.b = pbReplyTitleViewHolder;
            this.c = z;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.b
        public void onLayout() {
            ViewGroup.LayoutParams layoutParams;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.a;
                if (i2 >= 0 && i2 <= this.g.g.getMeasuredHeight()) {
                    int z1 = this.g.z1(this.b);
                    int i3 = this.a;
                    int i4 = z1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = z1 - i;
                    }
                    if (this.g.e1 == null || (layoutParams = this.g.e1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && z1 < this.g.g.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.g.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.o != null) {
                                    this.g.o.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.j1;
                    } else {
                        layoutParams.height = this.g.j1;
                    }
                    this.g.e1.setLayoutParams(layoutParams);
                    SafeHandler.getInst().post(new a(this));
                }
                if (this.g.o != null) {
                    this.g.o.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements bw9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ n b;

            public a(n nVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = nVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D != null && this.b.a.f.r0() != null) {
                    this.b.a.D.q(this.a);
                    p05.g(Collections.singletonList(new cw9(this.b.a.f.r0(), this.b.a.D)));
                }
            }
        }

        public n(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.bw9.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.f8() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w0 a;

            public a(w0 w0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {w0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = w0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.f.HidenSoftKeyPad((InputMethodManager) this.a.a.f.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.g);
            }
        }

        public w0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.k1 == null) {
                    this.a.k1 = new a(this);
                }
                SafeHandler.getInst().postDelayed(this.a.k1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements dt9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        @Override // com.baidu.tieba.dt9
        public /* synthetic */ void onStart() {
            ct9.a(this);
        }

        public a(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.dt9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public a0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.M0 != null && this.a.f.M0.e() != null) {
                if (!this.a.f.M0.e().e()) {
                    this.a.f.M0.a(false);
                }
                this.a.f.M0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.r0 != null && this.a.r0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.x1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.r0.getId());
                    jx9 jx9Var = this.a;
                    jx9Var.x1 = new qy9(jx9Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.w1)) {
                        this.a.x1.q(this.a.w1);
                    }
                    this.a.x1.r(this.a.r0);
                }
                this.a.x1.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a1 implements PbFallingView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public a1(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.p
        public void onClick() {
            String y1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.i0() != null && this.a.f.i0().d2()) {
                    y1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    y1 = this.a.y1();
                }
                if (!StringUtils.isNull(y1) && this.a.R0 != null) {
                    y1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.q0(), this.a.R0.r0(), y1);
                }
                if (this.a.f != null && this.a.f.T6() != null) {
                    this.a.f.T6().g0(y1);
                }
                if (this.a.B0 != null) {
                    this.a.B0.setText(y1);
                }
                this.a.m4(false);
                this.a.G4();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ jx9 b;

        public b0(jx9 jx9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                this.b.X.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.V2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.e2 != null) {
                            this.b.e2.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.d7(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.c5(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u75 a;
        public final /* synthetic */ jx9 b;

        public b1(jx9 jx9Var, u75 u75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, u75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = u75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.P1.setHomePbFloatLastCloseTime();
                this.b.R1();
                this.b.P1.t(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public c(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E0 != null && this.a.E0.getData() != null) {
                jx9 jx9Var = this.a;
                jx9Var.i3(jx9Var.E0.getData(), this.a.E0.getData().agreeNum);
                if (!this.a.E0.J()) {
                    jx9 jx9Var2 = this.a;
                    jx9Var2.b3(jx9Var2.E0);
                }
                if (this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().isExcellentThread() && BreatheTipWidget.f()) {
                    mb5.a("c15279", this.a.R0.Q(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
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

    /* loaded from: classes6.dex */
    public class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ jx9 b;

        public c1(jx9 jx9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.K1 && this.a != null && this.b.f.i0() != null && this.b.f.i0().h2()) {
                    this.b.K1 = true;
                    this.a.e6(false);
                }
                if (this.b.L1) {
                    return;
                }
                this.b.L1 = true;
                if (this.b.p2() && this.b.B != null) {
                    this.b.B.h();
                    this.b.B.g(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public d(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.u2()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1125T.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ jx9 c;

        public d0(jx9 jx9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jx9Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.c.f.r0(), (int) R.string.obfuscated_res_0x7f0f0e61);
                } else {
                    this.c.f.r6(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d1 implements xt9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public d1(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.xt9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.h7();
            }
        }

        @Override // com.baidu.tieba.xt9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public e(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
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
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.tag_from, 1);
                    this.a.f.g6(sparseArray);
                    return;
                }
                this.a.a3(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.g6(sparseArray);
            } else if (z3) {
                this.a.V2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public e0(jx9 jx9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ vg5 b;
        public final /* synthetic */ jx9 c;

        public e1(jx9 jx9Var, ReplyPrivacyCheckController replyPrivacyCheckController, vg5 vg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, replyPrivacyCheckController, vg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jx9Var;
            this.a = replyPrivacyCheckController;
            this.b = vg5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.F6() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.F6().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.X4();
                this.b.r0();
                this.c.K0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public f(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ jx9 c;

        public f0(jx9 jx9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jx9Var;
            this.a = alertDialog;
            this.b = sparseArray;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    BdUtilHelper.showToast(this.c.f.r0(), (int) R.string.obfuscated_res_0x7f0f0e61);
                } else {
                    this.c.f.r6(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public f1(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.O2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public g(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(vra vraVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vraVar) == null) {
                this.a.l1.f0(vraVar);
                this.a.I.f0();
                this.a.m1.g();
                this.a.r0.y();
                this.a.m4(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements gra.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.gra.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public g0() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

        public g1() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public h(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.G4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O1.setTag(Boolean.FALSE);
                if (this.a.P1 == null) {
                    return;
                }
                this.a.P1.setAutoCompleteShown(false);
                if (this.a.P1.getVisibility() == 0) {
                    this.a.P1.setTag(this.a.O1);
                    this.a.P1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public h0(jx9 jx9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AlertDialog alertDialog;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (alertDialog = this.a) != null) {
                alertDialog.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements a16.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zz4 a;
        public final /* synthetic */ jx9 b;

        public i0(jx9 jx9Var, zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, zz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = zz4Var;
        }

        @Override // com.baidu.tieba.a16.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.s6(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements d16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ jx9 b;

        public j0(jx9 jx9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.d16.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.r6(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(jx9 jx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Integer.valueOf(i)};
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
            this.a = jx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.h1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public k0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.h0 = (String) compoundButton.getTag();
                if (this.a.q != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.q) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.h0 != null && !str.equals(this.a.h0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public l0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.b0 instanceof Dialog)) {
                xb.b(this.a.b0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements rq9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public m(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.rq9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.i0() != null) {
                    this.a.f.i0().p3();
                }
                if (this.a.V1 != null) {
                    this.a.J0.k(this.a.V1);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0803);
                }
                nz9.d(str, str2, str3, 3);
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a05.c a;
        public final /* synthetic */ jx9 b;

        public m0(jx9 jx9Var, a05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements j05.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a05.c a;
        public final /* synthetic */ jx9 b;

        public n0(jx9 jx9Var, a05.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.j05.f
        public void F0(j05 j05Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, j05Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public o(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1125T.onClick(this.a.G0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public o0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().getAuthor() != null && this.a.R0.O().getAuthor().getAlaInfo() != null && this.a.R0.O().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.R0.l());
                    statisticItem2.param("fname", this.a.R0.m());
                    if (this.a.R0.O().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.R0.O().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.R0.Q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.R0.O().getAuthor().getAlaInfo()));
                    if (this.a.R0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.R0.O().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.R0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.f.getPageContext(), this.a.R0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.p1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.p1 && this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().getAuthor() != null && this.a.R0.O().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.f.r0() != null) {
                    this.a.f.r0().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c15305").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements hy9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public p0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.hy9.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.A.a(this.a.o);
                } else {
                    this.a.A.d(this.a.o);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public q(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.Q4(3, 4, z);
            this.a.i4();
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || bt5.a()) {
                return;
            }
            this.a.Q4(2, 4, z);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.a.f.getContext());
            } else if (z2) {
                this.a.i4();
            } else if (!z) {
                if (this.a.V1.ability_conf == null) {
                    return;
                }
                jx9 jx9Var = this.a;
                jx9Var.s0(str, jx9Var.V1.ability_conf.bot_uk, this.a.V1.ability_conf.skill_id.intValue());
            } else {
                nz9.e(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public q0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            jx9 jx9Var;
            d0a d0aVar;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null && (d0aVar = (jx9Var = this.a).k) != null && d0aVar.k != null && jx9Var.R0 != null && this.a.R0.O() != null && !this.a.R0.O().isVideoThreadType() && !this.a.t2() && this.a.R0.k() != null && !qd.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.I.L() == null || !this.a.I.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements pq9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public r(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pq9.b
        public void a(@NonNull CallRobotEntrance callRobotEntrance) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, callRobotEntrance) != null) || this.a.J0 == null) {
                return;
            }
            boolean o = this.a.J0.o();
            this.a.z2(callRobotEntrance, o);
            if (o) {
                nz9.e(this.a.J0.getLoadingToast());
                return;
            }
            AbilityConf abilityConf = callRobotEntrance.ability_conf;
            if (abilityConf == null) {
                return;
            }
            BotEntranceManager.h().m(abilityConf.bot_uk, abilityConf.skill_id.intValue());
            this.a.V1 = callRobotEntrance;
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null) {
                this.a.J0.setCallRobotEntranceData(new vw4(callRobotEntrance, styleConf.day, styleConf.dark, false));
            }
            this.a.Y4();
            jx9 jx9Var = this.a;
            jx9Var.s0(jx9Var.J0.getLoadingToast(), abilityConf.bot_uk, abilityConf.skill_id.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u75 a;
        public final /* synthetic */ jx9 b;

        public r0(jx9 jx9Var, u75 u75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, u75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = u75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.R0 != null && this.b.P1 != null) {
                this.b.P1.g(this.a);
                this.b.P1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements kr9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jx9 b;

        public s(jx9 jx9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.kr9
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.J0 != null) {
                    this.b.J0.x();
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导展示完毕隐藏,文案：" + this.a);
            }
        }

        @Override // com.baidu.tieba.kr9
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b.J0 != null) {
                    this.b.J0.setDynamicLooping(true);
                    this.b.J0.r();
                }
                SharedPrefHelper.getInstance().putLong("pb_friend_bot_bottom_click_last_time", System.currentTimeMillis());
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导展示了,文案：" + this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jx9 b;

        public s0(jx9 jx9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jx9Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (BdUtilHelper.isNetOk()) {
                    UrlManager.getInstance().dealOneLink(this.b.f.getPageContext(), new String[]{this.a});
                    this.b.f.finish();
                    return;
                }
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0e61);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ jx9 f;

        public t(jx9 jx9Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = jx9Var;
            this.d = str;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.f(i, str, r7);
                if (this.f.f == null) {
                    return;
                }
                this.f.f.showToast(str);
                if (this.f.f.i0() != null) {
                    this.f.f.i0().p3();
                }
                if (this.f.f.W6().T0() != null) {
                    this.f.f.W6().T0().f0();
                }
                if (this.f.J0 != null && this.f.V1 != null) {
                    this.f.J0.k(this.f.V1);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                super.i(r5);
                nz9.e(this.d);
                nz9.b(this.f.f.i0(), this.e);
                if (this.f.U1 != null) {
                    SafeHandler.getInst().removeCallbacks(this.f.U1);
                }
                jx9 jx9Var = this.f;
                jx9Var.U1 = new sq9(this.e, jx9Var.f);
                SafeHandler.getInst().postDelayed(this.f.U1, 30000L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ es9 c;
        public final /* synthetic */ jx9 d;

        public t0(jx9 jx9Var, Parcelable parcelable, ArrayList arrayList, es9 es9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, parcelable, arrayList, es9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jx9Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = es9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.o != null) {
                    this.d.o.onRestoreInstanceState(this.a);
                }
                if (this.d.O != null && ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.O.g();
                    this.d.O.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1020));
                    this.d.O.B();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public u(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.W();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public u0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.s1) {
                    this.a.F0();
                    this.a.K2();
                }
                this.a.N0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(jx9 jx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Integer.valueOf(i)};
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
            this.a = jx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.I != null) {
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public v0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                this.a.F0();
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public w(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.E == null) {
                    this.a.a2();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(jx9 jx9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Integer.valueOf(i)};
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
            this.a = jx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.N0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class x0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
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

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public y(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
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

    /* loaded from: classes6.dex */
    public class z implements zd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jx9 a;

        public z(jx9 jx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jx9Var;
        }

        @Override // com.baidu.tieba.zd5
        public void S(yd5 yd5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yd5Var) == null) {
                Object obj = yd5Var.c;
                if ((obj instanceof m85) && EmotionGroupType.isSendAsPic(((m85) obj).g())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    m85 m85Var = (m85) yd5Var.c;
                    this.a.f.T6().g(m85Var);
                    if (m85Var.j()) {
                        this.a.f.T6().K(null, null);
                    } else {
                        this.a.f.T6().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ jx9 e;

        public z0(jx9 jx9Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jx9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jx9Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i != this.b && i - this.c < 0) {
                    this.e.u1.showAsDropDown(this.d);
                } else {
                    this.e.u1.showAsDropDown(this.e.y0, this.d.getLeft(), -this.e.y0.getHeight());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947898814, "Lcom/baidu/tieba/jx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947898814, "Lcom/baidu/tieba/jx9;");
                return;
            }
        }
        m2 = UtilHelper.getLightStatusBarHeight();
        n2 = 3;
        o2 = 0;
        p2 = 3;
        q2 = 4;
        r2 = 5;
        s2 = 6;
        t2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        u2 = 1;
        v2 = new g0();
    }

    public void C4() {
        vra vraVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.q1 || this.p1 || this.m0 || (vraVar = this.S0) == null || vraVar.t() == null || this.S0.t().getIsLike() || this.S0.t().hadConcerned()) {
        }
    }

    public void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            T4();
            this.I.g0(1);
            fx9 fx9Var = this.s;
            if (fx9Var != null) {
                fx9Var.j();
            }
            zv9 zv9Var = this.D;
            if (zv9Var != null) {
                zv9Var.g();
            }
            bw9 bw9Var = this.C;
            if (bw9Var != null) {
                bw9Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            if (q2()) {
                this.W1.n();
            }
        }
    }

    public vra a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int Z0 = Z0() - this.o.getHeaderViewsCount();
            int i2 = 0;
            if (Z0 < 0) {
                Z0 = 0;
            }
            if (this.I.A(Z0) != null && this.I.A(Z0) != vra.W0) {
                i2 = Z0 + 1;
            }
            if (!(this.I.z(i2) instanceof vra)) {
                return null;
            }
            return (vra) this.I.z(i2);
        }
        return (vra) invokeV.objValue;
    }

    public final int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i2 = 0; i2 < this.o.getData().size(); i2++) {
                    oi oiVar = this.o.getData().get(i2);
                    if (oiVar != null && oiVar.getType() == gs9.k) {
                        return i2 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048773, this)) == null) {
            if (b4()) {
                for (int firstVisiblePosition = this.o.getFirstVisiblePosition(); firstVisiblePosition <= this.o.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.o.getListView2().getChildAt(firstVisiblePosition);
                    if (childAt != null && (childAt.getTag() instanceof String)) {
                        if (TbadkCoreApplication.getInst().getString(R.string.content_collection).equals((String) childAt.getTag())) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t3() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048793, this) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            View findViewById = i2.findViewById(R.id.obfuscated_res_0x7f091b1b);
            if (i2.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public jx9(PbFragment pbFragment, View.OnClickListener onClickListener, zt9 zt9Var, SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, zt9Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.d = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = new Handler();
        this.o = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.f1125T = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        this.f0 = null;
        this.g0 = null;
        this.h0 = null;
        this.i0 = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = false;
        this.m0 = false;
        this.n0 = null;
        this.o0 = null;
        this.q0 = null;
        this.s0 = false;
        this.w0 = null;
        this.y0 = null;
        this.B0 = null;
        this.N0 = true;
        this.P0 = null;
        this.Q0 = false;
        this.U0 = 3;
        this.V0 = false;
        this.W0 = false;
        this.X0 = null;
        this.f1 = 0;
        this.g1 = true;
        this.h1 = new g1();
        this.i1 = 0;
        this.n1 = false;
        this.o1 = 0;
        this.p1 = false;
        this.q1 = false;
        this.r1 = false;
        this.s1 = 0;
        this.A1 = false;
        this.B1 = false;
        this.J1 = 0;
        this.T1 = new Object();
        this.X1 = new k(this, 2921757);
        this.Y1 = new o(this);
        this.Z1 = new q(this);
        this.a2 = new v(this, 2005016);
        this.b2 = new Handler();
        this.d2 = new x(this, 2004009);
        this.f2 = true;
        this.g2 = new o0(this);
        this.h2 = null;
        this.k2 = new ArrayList();
        this.l2 = false;
        this.f = pbFragment;
        this.h1.b = pbFragment.getPageContext().getUniqueId();
        this.f1125T = onClickListener;
        this.U = fVar;
        this.p0 = zt9Var;
        this.s1 = BdUtilHelper.getEquipmentWidth(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d071f, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f09049a);
        this.D1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091b97);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f092344);
        this.Q1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091fa4);
        this.H = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092635);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f0919b2);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.Z0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, ix9.n(this.f));
        this.o.setOverScrollMode(2);
        this.o.w(this.Z0, 0);
        this.o.setTextViewAdded(true);
        this.j1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.e1 = new View(this.f.getPageContext().getPageActivity());
        if (YoungsterVerifyUtils.isYoungsterOpen()) {
            this.e1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.e1.setLayoutParams(new AbsListView.LayoutParams(-1, this.j1));
        }
        MessageManager.getInstance().registerListener(this.X1);
        this.e1.setVisibility(4);
        this.o.addFooterView(this.e1);
        this.o.setOnTouchListener(this.f.L2);
        this.a = new c1(this, pbFragment);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.k = new d0a(pbFragment, this.g);
        if (this.f.M6()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09172e);
            this.m = viewStub;
            viewStub.setVisibility(0);
            c0a c0aVar = new c0a(pbFragment);
            this.l = c0aVar;
            c0aVar.c();
            this.k.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070364);
        }
        this.Z0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new xt9(new d1(this)));
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f0929ba);
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f091b2c);
        this.O0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a2);
        this.A0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f0909c7);
        this.A0.setOnClickListener(new e1(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.T6()));
        L0();
        this.B0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b2f);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091b26);
        this.z0 = linearLayout;
        linearLayout.setOnClickListener(new f1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f0909cb);
        this.v0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.D0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091b2d);
        this.N1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.D0.setOnClickListener(this.f1125T);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091b28);
        this.E0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.E0.x();
        this.E0.setAgreeLongClickListener(new b(this));
        this.E0.setAfterClickListener(new c(this));
        this.E0.setUseDynamicLikeRes("/pb");
        if (this.E0.getAgreeNumView() != null) {
            this.E0.getAgreeNumView().setVisibility(8);
        }
        if (this.E0.getMsgData() != null) {
            this.E0.getMsgData().uniqueId = BdUniqueId.gen();
        }
        boolean booleanExtra = this.f.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091b2b);
        this.F0 = imageView;
        imageView.setOnClickListener(this.f1125T);
        if (booleanExtra) {
            this.F0.setVisibility(8);
        } else {
            this.F0.setVisibility(0);
        }
        U1();
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091b32);
        this.I0 = findViewById;
        findViewById.setVisibility(8);
        this.G0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091b30);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091b31);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setOnClickListener(this.Y1);
        this.G0.setOnClickListener(new d(this));
        C2();
        u1a u1aVar = new u1a(this.G0);
        this.K0 = u1aVar;
        u1aVar.m(this.H0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b2e);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091b29);
        this.X0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0911d4);
        this.E0.setVisibility(0);
        this.L0.setVisibility(0);
        this.v = new iy9(this.f, zt9Var);
        this.x = new my9(this.f, zt9Var, this.f1125T);
        rv9 rv9Var = new rv9(this.f, this.o);
        this.I = rv9Var;
        rv9Var.E0(this.f1125T);
        this.I.H0(this.p0);
        this.I.B0(this.V);
        this.I.D0(this.U);
        this.I.x0(this.j2);
        e eVar = new e(this);
        this.Y = eVar;
        this.I.z0(eVar);
        f2();
        Y1();
        ly9 ly9Var = new ly9(this.f);
        this.z = ly9Var;
        ly9Var.f = 2;
        X1();
        V1();
        this.A.a(this.o);
        this.x.p(this.o);
        this.w.a(this.o);
        this.B.a(this.o);
        this.v.a(this.o);
        PbListView pbListView = new PbListView(this.f.getPageContext().getPageActivity());
        this.O = pbListView;
        this.Q = pbListView.c().findViewById(R.id.pb_more_view);
        this.R = this.O.c().findViewById(R.id.pb_check_more);
        if (!this.O.k().booleanValue()) {
            this.R.setVisibility(8);
        }
        View view2 = this.Q;
        if (view2 != null) {
            view2.setOnClickListener(this.f1125T);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setOnClickListener(this.f1125T);
        }
        this.O.D();
        this.O.r(R.drawable.pb_foot_more_trans_selector);
        this.O.F(R.color.CAM_X0109);
        this.O.s(R.drawable.pb_foot_more_trans_selector);
        this.S = this.g.findViewById(R.id.obfuscated_res_0x7f0929f2);
        this.f.registerListener(this.d2);
        this.l1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel i02 = this.f.i0();
        this.l1.h0(i02.X(), i02.T(), i02.U(), i02.S(), i02.Y());
        gw9 gw9Var = new gw9(this.f.getPageContext(), this.l1, this.g);
        this.m1 = gw9Var;
        gw9Var.p(new f(this));
        this.m1.s(this.f.q2);
        this.l1.j0(new g(this));
        if (this.f.i0() != null && !StringUtils.isNull(this.f.i0().w1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.i0().w1());
        }
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f091b34);
        this.b1 = this.g.findViewById(R.id.obfuscated_res_0x7f090498);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f092350);
        this.c1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.i0() != null && this.f.i0().f1()) {
            this.a1.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.c1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.c1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091bb7));
        this.d1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.u(pbFragment.d0);
        this.d1.g.setVisibility(8);
        this.d1.t(this.f1125T);
        this.d1.s(this.U);
        this.f.registerListener(this.a2);
        PbFragment pbFragment3 = this.f;
        this.M1 = new t1a(pbFragment3, pbFragment3.getUniqueId());
        PbFallingView pbFallingView = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090b1e);
        this.O1 = pbFallingView;
        if (pbFallingView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.O1.getLayoutParams()).setMargins(0, ix9.n(this.f), 0, 0);
        }
        x3();
        this.O1.setAnimationListener(new h(this));
        A0();
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f091b1c);
        z0(YoungsterVerifyUtils.isYoungsterOpen());
        this.s = new fx9(this.f.r0(), (ViewGroup) G1().findViewById(R.id.obfuscated_res_0x7f091bca));
        jw9 jw9Var = new jw9(this.o, -2);
        this.u = jw9Var;
        jw9Var.d(new i(this, pbFragment));
        jw9 jw9Var2 = new jw9(this.o, 5);
        this.t = jw9Var2;
        jw9Var2.d(new j(this));
        this.R1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09287e);
        this.S1 = new oz9(this.f.getActivity());
        c2();
        nq6.b().b(this.T1, new rq9(new m(this)));
    }

    public void A3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) {
            this.I.o0(z2);
        }
    }

    public void C3(boolean z2) {
        rv9 rv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) && (rv9Var = this.I) != null) {
            rv9Var.p0(z2);
        }
    }

    public void D3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            this.A1 = z2;
        }
    }

    public void E3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.I.r0(z2);
        }
    }

    public void F3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            this.I.w0(z2);
        }
    }

    public void G3(g55.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, gVar) == null) {
            this.i2 = gVar;
            v1a v1aVar = this.N;
            if (v1aVar != null) {
                v1aVar.a(gVar);
            }
        }
    }

    public void H3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onClickListener) == null) {
            this.j2 = onClickListener;
            rv9 rv9Var = this.I;
            if (rv9Var != null) {
                rv9Var.x0(onClickListener);
            }
        }
    }

    public void I3(String str) {
        c0a c0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, str) == null) && (c0aVar = this.l) != null) {
            c0aVar.b(str);
        }
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            this.n1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.o1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void K3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, zVar) == null) {
            this.V = zVar;
            this.I.B0(zVar);
            this.y1.p(this.V);
        }
    }

    public final void K4(vra vraVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, vraVar) == null) && vraVar != null) {
            this.B1 = !StringUtils.isNull(vraVar.f0());
            my9 my9Var = this.x;
            if (my9Var != null) {
                my9Var.s(vraVar);
            }
        }
    }

    public void L3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bVar) == null) {
            this.W = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void M3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048639, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void N2(ri riVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048643, this, riVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = riVar;
            pbLandscapeListView.W = true;
        }
    }

    public void N3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048644, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void N4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void O3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, onClickListener) == null) {
            this.I.F0(onClickListener);
        }
    }

    public void P3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.I1 = i2;
        }
    }

    public void Q3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onLongClickListener) == null) {
            this.x.G(onLongClickListener);
            this.I.C0(onLongClickListener);
            ev9 ev9Var = this.y1;
            if (ev9Var != null) {
                ev9Var.q(onLongClickListener);
            }
        }
    }

    public void U4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void W3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
            this.x.I(z2);
        }
    }

    public void Y3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048699, this, i2) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void Z3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, list) == null) {
            this.w1 = list;
            qy9 qy9Var = this.x1;
            if (qy9Var != null) {
                qy9Var.q(list);
            }
        }
    }

    public void a3(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048709, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        Z2(sparseArray, false);
    }

    public final void a4(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048710, this, i2) == null) && (textView = this.Z0) != null && (textView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
            layoutParams.height = i2;
            this.Z0.setLayoutParams(layoutParams);
        }
    }

    public void d5(es9 es9Var) {
        iy9 iy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048726, this, es9Var) == null) && (iy9Var = this.v) != null) {
            iy9Var.h(es9Var, this.Q0);
        }
    }

    public final boolean k2(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048753, this, es9Var)) == null) {
            return ix9.y(es9Var);
        }
        return invokeL.booleanValue;
    }

    public void l4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) {
            View view2 = this.t0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final void r0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.addRule(11);
            view2.setLayoutParams(layoutParams);
        }
    }

    public final int r1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048781, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public boolean u0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048795, this, z2)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.D()) {
                this.r0.y();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void v3(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048803, this, str) == null) && (pbListView = this.O) != null) {
            pbListView.H(str);
        }
    }

    public void y3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, i3Var) == null) {
            this.e2 = i3Var;
        }
    }

    public void z3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048823, this, z2) == null) {
            this.s0 = z2;
        }
    }

    @SuppressLint({"CutPasteId"})
    public void M4(es9 es9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048640, this, es9Var, z2) != null) || es9Var == null) {
            return;
        }
        a5(es9Var, z2);
        I0();
    }

    public final void R3(vra vraVar, es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048664, this, vraVar, es9Var) == null) {
            this.x.H(vraVar, es9Var);
        }
    }

    public void d3(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048724, this, adverSegmentData, i2) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.A(adverSegmentData, this.f.getPageContext(), i2, false);
        }
    }

    public final boolean w2(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048807, this, absListView, i2)) == null) {
            if (t0(absListView, i2) && !this.k.o() && !q2()) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ev9 ev9Var = new ev9(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0917f9));
            this.y1 = ev9Var;
            ev9Var.n(this.f1125T);
            this.y1.o(this.Y);
            this.y1.p(this.V);
            this.y1.n(this.f1125T);
            this.y1.r(this.p0);
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.k.f();
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                BdUtilHelper.hideSoftKeyPad(pbFragment.getContext(), this.M);
            }
            L1();
            h05 h05Var = this.i0;
            if (h05Var != null) {
                h05Var.dismiss();
            }
            J0();
            zz4 zz4Var = this.J;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            a05 a05Var = this.K;
            if (a05Var != null) {
                a05Var.e();
            }
        }
    }

    public final void G4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            PbFallingView pbFallingView = this.O1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.P1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.O1) {
                this.P1.setTag(null);
                this.P1.setAutoCompleteShown(true);
                this.P1.d();
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            zz4 zz4Var = this.Z;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            Dialog dialog = this.a0;
            if (dialog != null) {
                xb.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.b0;
            if (dialog2 != null) {
                xb.b(dialog2, this.f.getPageContext());
            }
            h05 h05Var = this.X;
            if (h05Var != null) {
                h05Var.dismiss();
            }
        }
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            this.I.g0(2);
            R2();
            A2();
            e5();
            R4();
            x0();
            bw9 bw9Var = this.C;
            if (bw9Var != null) {
                bw9Var.k();
            }
            if (q2()) {
                this.W1.o();
            }
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            this.J0 = (FriendBotView) this.g.findViewById(R.id.obfuscated_res_0x7f091b2a);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.i0() != null) {
                this.J0.setTid(this.f.i0().R());
            }
            this.J0.l();
        }
    }

    public final void X4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048695, this) == null) && (pbFragment = this.f) != null && pbFragment.T6() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.T6().C())));
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048716, this) != null) || !this.f.M6()) {
            return;
        }
        if (this.f.R6() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
        if (this.f.Q6() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048718, this) != null) || this.f.u1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        n nVar = new n(this);
        this.D = new zv9(this.f.r0());
        this.C = new bw9(this.o, nVar);
    }

    public final boolean c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.i0().t1().k().getDeletedReasonInfo() == null || 1 != this.f.i0().t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void o3() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048770, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.C0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.C0);
        }
        TextView textView = this.L0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void p3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048774, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.A.d(pbLandscapeListView);
            this.w.h(this.o);
            this.x.E(this.o);
            this.y.d(this.o);
            this.v.f(this.o);
        }
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048787, this)) == null) {
            View view2 = this.e1;
            if (view2 == null || view2.getParent() == null || this.O.p()) {
                return false;
            }
            int bottom = this.e1.getBottom();
            Rect rect = new Rect();
            this.e1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            es9 es9Var = this.R0;
            if (es9Var == null || es9Var.k() == null || "0".equals(this.R0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.R0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048800, this)) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.O.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048802, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.W6() != null && this.f.W6().R0 != null && this.f.W6().R0.K() != null) {
                FriendBotView friendBotView = this.J0;
                if (friendBotView == null || friendBotView.getVisibility() != 8) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048816, this)) == null) {
            if (!qd.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.f != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(ix9.i());
            }
            return this.G1;
        }
        return (String) invokeV.objValue;
    }

    public final void A2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (pbFragment = this.f) != null && pbFragment.i0() != null && this.f.i0().G != null && this.f.i0().G.O() != null && this.f.i0().G.O().isQuestionThread()) {
            ThreadData O = this.f.i0().G.O();
            String G1 = this.f.i0().G1();
            String H1 = this.f.i0().H1();
            int i2 = 5;
            if ("question_answer_invite".equals(G1)) {
                i2 = 1;
            } else if ("3".equals(H1)) {
                i2 = 2;
            } else if ("answer_top".equals(G1)) {
                i2 = 3;
            } else if (this.f.i0().Y0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i2));
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.l2) {
            TiebaStatic.log("c10490");
            this.l2 = true;
            zz4 zz4Var = new zz4(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            zz4Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            zz4Var.setContentView(inflate);
            zz4Var.setYesButtonTag(sparseArray);
            zz4Var.setPositiveButton(R.string.grade_button_tips, this.f);
            zz4Var.setNegativeButton(R.string.look_again, new x0(this));
            zz4Var.create(this.f.getPageContext()).show();
        }
    }

    public final void Y4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
            if (nr9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.f) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                if (baseFragmentActivity != null && this.J0 != null) {
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f1013);
                    nr9.e(string, this.J0, baseFragmentActivity, new s(this, string));
                    SharedPrefHelper.getInstance().putBoolean("pb_friend_bot_bottom_long_click_shown", true);
                    return;
                }
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("BotGuideManager", "新手长按引导未展示,activity=" + baseFragmentActivity + ",mBottomBot=" + this.J0);
            } else {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.e("BotGuideManager", "新手长按引导未展示,新手引导未展示过，mPbFragment==" + this.f);
            }
        }
    }

    public final void d4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048725, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            if (this.E0.getWidth() != 0 && this.E0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.C0;
                if (waterRippleView == null) {
                    this.C0 = new WaterRippleView(this.f.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.C0);
                    }
                }
                Rect rect = new Rect();
                this.g.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.E0.getImgAgree().getGlobalVisibleRect(rect2);
                int dimens = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - dimens;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - dimens;
                int i4 = dimens * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
                this.g.addView(this.C0, layoutParams);
                TextView textView = this.L0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void e4() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            if (!i2()) {
                H1();
                return;
            }
            AlaInfoData c2 = kz9.c(this.R0);
            if (c2 != null && !StringUtils.isNull(c2.mFlv) && c2.live_status == 1) {
                if (this.W1 == null) {
                    this.W1 = (TbMixPlayerView) this.g.findViewById(R.id.obfuscated_res_0x7f0917da);
                    kz9.d(this, this.R0);
                }
                String str2 = null;
                if (this.W1.getTbMixPlayerConfig() instanceof TbLiveMixPlayerConfig) {
                    str2 = ((TbLiveMixPlayerConfig) this.W1.getTbMixPlayerConfig()).a().mFlv;
                }
                if (this.W1.getVisibility() != 0 || ((str = c2.mFlv) != null && !str.equals(str2))) {
                    this.W1.setVisibility(0);
                    this.W1.setMixPlayerConfig(new TbLiveMixPlayerConfig(c2));
                    this.W1.o();
                    a4(ix9.n(this.f) + this.W1.getPlayerHeight());
                    upa.u("c15498", this.R0.O(), c2, 0L);
                    return;
                }
                return;
            }
            H1();
        }
    }

    public final void y0() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048815, this) == null) && this.B != null && (es9Var = this.R0) != null && es9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
            if (this.w.b().getParent() == null) {
                this.B.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.B.b().getLocationInWindow(iArr);
            if (iArr[1] + this.B.b().getHeight() > this.k.j().getBottom()) {
                this.B.i();
                this.B.g(true);
                return;
            }
            this.B.g(false);
        }
    }

    public void A4(a05.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            h05 h05Var = this.i0;
            if (h05Var != null) {
                h05Var.dismiss();
                this.i0 = null;
            }
            j05 j05Var = new j05(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new f05(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04ed), j05Var));
            }
            if (z3) {
                arrayList.add(new f05(1, this.f.getPageContext().getString(R.string.report_text), j05Var));
            } else if (!z2) {
                arrayList.add(new f05(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c7b), j05Var));
            } else {
                arrayList.add(new f05(1, this.f.getPageContext().getString(R.string.remove_mark), j05Var));
            }
            j05Var.m(arrayList);
            j05Var.r(new m0(this, cVar));
            h05 h05Var2 = new h05(this.f.getPageContext(), j05Var);
            this.j0 = h05Var2;
            h05Var2.l();
        }
    }

    public final void v4(SparseArray<Object> sparseArray, int i2, c16 c16Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048804, this, new Object[]{sparseArray, Integer.valueOf(i2), c16Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.F1 == null && this.v != null) {
            this.F1 = new d16(pbFragment.getPageContext(), this.v.c(), c16Var, userData);
        }
        this.F1.G(z2);
        AntiData F6 = this.f.F6();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (F6 != null && F6.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = F6.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
        this.F1.I(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
        this.F1.H(negativeFeedBackData);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.F1.K(str);
        this.F1.J(new j0(this, sparseArray));
    }

    public final CustomBlueCheckRadioButton B0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, BdUtilHelper.getDimens(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.e0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            jw9 jw9Var = this.t;
            if (jw9Var != null) {
                jw9Var.b(z2, i2);
            }
            jw9 jw9Var2 = this.u;
            if (jw9Var2 != null) {
                jw9Var2.b(z2, i2);
            }
            bw9 bw9Var = this.C;
            if (bw9Var != null) {
                bw9Var.m(this.R0.k());
                this.C.i(z2, i2);
            }
        }
    }

    public void S3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048669, this, z2, postWriteCallBackData) == null) {
            this.f.hideProgressBar();
            if (z2) {
                F0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                G0();
            } else {
                F0();
            }
        }
    }

    public final boolean t0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048790, this, absListView, i2)) == null) {
            boolean z3 = false;
            if (absListView == null) {
                return false;
            }
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 && absListView.getChildCount() > 0) {
                if (absListView.getChildAt(0).getTop() < absListView.getListPaddingTop()) {
                    z3 = true;
                }
                return z3;
            }
            return z2;
        }
        return invokeLI.booleanValue;
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            j3(this.R0);
        }
    }

    public View C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public PbThreadPostView D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public final boolean E1() {
        InterceptResult invokeV;
        ThreadData O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            es9 es9Var = this.R0;
            if (es9Var == null || (O = es9Var.O()) == null) {
                return false;
            }
            return !O.isDisableShare();
        }
        return invokeV.booleanValue;
    }

    public void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.S.setVisibility(0);
        }
    }

    public RelativeLayout F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.H;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void F4() {
        rv9 rv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (rv9Var = this.I) != null) {
            rv9Var.I0();
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.k.f();
            h05 h05Var = this.i0;
            if (h05Var != null) {
                h05Var.dismiss();
            }
            J0();
            zz4 zz4Var = this.J;
            if (zz4Var != null) {
                zz4Var.dismiss();
            }
            a05 a05Var = this.K;
            if (a05Var != null) {
                a05Var.e();
            }
        }
    }

    public RelativeLayout G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void H0() {
        u1a u1aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (u1aVar = this.K0) != null) {
            u1aVar.k(false);
        }
    }

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.W1 != null) {
            a4(ix9.n(this.f));
            this.W1.s();
            this.W1.setVisibility(8);
        }
    }

    public void H4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && this.K0 != null && E1()) {
            this.K0.n(2);
        }
    }

    public final boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.v.b(this.Q0);
        }
        return invokeV.booleanValue;
    }

    public void I1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            d0a d0aVar = this.k;
            if (d0aVar != null && (view2 = d0aVar.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.y0 == null) {
            return;
        }
        this.x0.setVisibility(8);
        this.y0.setVisibility(8);
        this.N0 = false;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", u2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void L1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (editorTools = this.r0) != null) {
            editorTools.v();
            qy9 qy9Var = this.x1;
            if (qy9Var != null) {
                qy9Var.m();
            }
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null) {
                pbListView.B();
                this.O.g();
            }
            O1();
        }
    }

    public void M1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (editorTools = this.r0) != null) {
            editorTools.z();
            qy9 qy9Var = this.x1;
            if (qy9Var != null) {
                qy9Var.m();
            }
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            I0();
        }
    }

    public void N1() {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (d0aVar = this.k) != null) {
            d0aVar.k();
        }
    }

    public void O1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (blueCircleProgressDialog = this.P0) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
        }
    }

    public void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            P2(null);
        }
    }

    public void O4() {
        oz9 oz9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048650, this) == null) && (oz9Var = this.S1) != null && (linearLayout = this.R1) != null) {
            oz9Var.c(linearLayout);
        }
    }

    public void P0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048651, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public void P1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            if (this.E == null) {
                a2();
            }
            this.n.setVisibility(8);
            Handler handler = this.b2;
            if (handler != null && (runnable = this.c2) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void P4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.f.showProgressBar();
        }
    }

    public void Q0() {
        FriendBotView friendBotView;
        CallRobotEntrance callRobotEntrance;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (friendBotView = this.J0) != null && (callRobotEntrance = this.V1) != null) {
            friendBotView.k(callRobotEntrance);
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.S.setVisibility(8);
        }
    }

    public void R1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && (rightFloatLayerView = this.P1) != null) {
            rightFloatLayerView.c();
        }
    }

    public final void R2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && (pbFragment = this.f) != null && pbFragment.T6() != null) {
            this.f.T6().I();
        }
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || !v2()) {
            return;
        }
        Q4(1, 4, this.J0.o());
    }

    public void S1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048667, this) == null) && (editorTools = this.r0) != null) {
            editorTools.y();
        }
    }

    public void S4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048670, this) == null) && (pbFallingView = this.O1) != null) {
            pbFallingView.C();
        }
    }

    public rv9 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.I;
        }
        return (rv9) invokeV.objValue;
    }

    public void T1() {
        oz9 oz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && (oz9Var = this.S1) != null) {
            oz9Var.a();
        }
    }

    public void T4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && this.k2 != null) {
            while (this.k2.size() > 0) {
                TbImageView remove = this.k2.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
    }

    public void U3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            BdUtilHelper.hideSoftKeyPad(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public FriendBotView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.J0;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public final void V1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && this.B == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.B = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public void V3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.O.D();
            this.O.U();
        }
    }

    public LinearLayout W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.z0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            View view2 = this.c0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void X1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048692, this) == null) && this.A == null && (pbFragment = this.f) != null) {
            this.A = new hy9(pbFragment.getContext());
        }
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            return this.h0;
        }
        return (String) invokeV.objValue;
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && this.w == null) {
            this.w = new ky9(this.f, this.p0);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public PbFallingView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.O1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public boolean c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            fx9 fx9Var = this.s;
            if (fx9Var != null && fx9Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int d1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return e1(i2);
        }
        return invokeV.intValue;
    }

    public Button f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.w0;
        }
        return (Button) invokeV.objValue;
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048733, this) == null) && this.y == null) {
            this.y = new jy9(this.f, this.f1125T);
        }
    }

    public void f4() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            d0a d0aVar = this.k;
            if (d0aVar != null && (view2 = d0aVar.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void g3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            this.x.D(this.R0, this.S0, this.q1, this.p1);
        }
    }

    public TextView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return this.x.v();
        }
        return (TextView) invokeV.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            u1a u1aVar = this.K0;
            if (u1aVar != null) {
                return u1aVar.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            es9 es9Var = this.R0;
            if (es9Var != null && es9Var.O() != null && this.R0.O().isAlaLiveMixThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            j4(null);
        }
    }

    public PbInterviewStatusView j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.Y0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.A1;
        }
        return invokeV.booleanValue;
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return e1(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048757, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public BdTypeListView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048760, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048761, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void m3() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048762, this) == null) && (pbInterviewStatusView = this.Y0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.Y0.setLayoutParams(marginLayoutParams);
        }
    }

    public void n3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048766, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.O);
            }
            this.i = 2;
        }
    }

    public TbMixPlayerView o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return this.W1;
        }
        return (TbMixPlayerView) invokeV.objValue;
    }

    public final boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048769, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.h2);
        }
        return invokeV.booleanValue;
    }

    public ev9 p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            return this.y1;
        }
        return (ev9) invokeV.objValue;
    }

    public View q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public final boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048777, this)) == null) {
            TbMixPlayerView tbMixPlayerView = this.W1;
            if (tbMixPlayerView != null && tbMixPlayerView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            q3();
            L1();
            this.m1.g();
            m4(false);
        }
    }

    public View s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public void s3() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048788, this) != null) || (handler = this.b2) == null) {
            return;
        }
        Runnable runnable = this.c2;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        w wVar = new w(this);
        this.c2 = wVar;
        this.b2.postDelayed(wVar, 2000L);
    }

    public void s4() {
        d0a d0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && (d0aVar = this.k) != null && !this.r1) {
            d0aVar.w();
            this.r1 = true;
        }
    }

    public PbListView t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return this.O;
        }
        return (PbListView) invokeV.objValue;
    }

    public void t4() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048794, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            try {
                return Integer.parseInt(this.M.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            if (this.P0 == null) {
                this.P0 = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.P0.setDialogVisiable(true);
        }
    }

    public View v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            return this.a1;
        }
        return (View) invokeV.objValue;
    }

    public PbFakeFloorModel w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048806, this)) == null) {
            return this.l1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048809, this) == null) {
            this.I.n0(this.R0, false);
            this.I.f0();
        }
    }

    public gw9 x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) {
            return this.m1;
        }
        return (gw9) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048812, this)) == null) {
            u1a u1aVar = this.K0;
            if (u1aVar == null) {
                return false;
            }
            return u1aVar.h();
        }
        return invokeV.booleanValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048813, this) == null) {
            this.O1.setFallingFeedbackListener(new a1(this));
        }
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048817, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.D()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void B4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onItemClickListener) == null) {
            c05 c05Var = this.k0;
            if (c05Var != null) {
                c05Var.d();
                this.k0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<l05> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new l05(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new l05(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new l05(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new l05(string4, "", z5, Integer.toString(7)));
            c05 c05Var2 = new c05(this.f.getPageContext());
            c05Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.k0 = c05Var2;
            c05Var2.k(arrayList, onItemClickListener);
            c05Var2.c();
            this.k0.n();
        }
    }

    public void P2(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, spriteMemeInfo) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            X4();
            this.f.d8(spriteMemeInfo);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.i0() != null && this.f.i0().t1() != null && this.f.i0().t1().O() != null && this.f.i0().t1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.i0().O1()).param("fid", this.f.i0().t1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.i0().b).param("fid", this.f.i0().t1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public void h2(es9 es9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, es9Var) == null) {
            int i2 = 0;
            this.I.n0(es9Var, false);
            this.I.f0();
            I0();
            ev9 ev9Var = this.y1;
            if (ev9Var != null) {
                ev9Var.m();
            }
            ArrayList<vra> F = es9Var.F();
            if (es9Var.y().b() == 0 || F == null || F.size() < es9Var.y().e()) {
                if (u2(es9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            bottom = this.h1.a.getView().getHeight();
                        } else {
                            bottom = this.h1.a.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.f.r7()) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1026), i2);
                    } else {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1027), i2);
                    }
                } else {
                    if (es9Var.y().b() == 0) {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
            }
            j3(es9Var);
        }
    }

    public final void j3(es9 es9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048750, this, es9Var) == null) && es9Var != null && es9Var.O() != null) {
            Z4(es9Var);
            ImageView imageView = this.F0;
            if (imageView != null && imageView.getContext() != null) {
                if (es9Var.q()) {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String S0 = S0(es9Var.O().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(S0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, es9Var.O()));
            i3(es9Var.O().getAgreeData(), es9Var.O().getAgreeNum());
            if (this.E0 != null && es9Var.O() != null) {
                this.E0.setThreadData(es9Var.O());
                int i2 = 1;
                if (es9Var.O().getAgreeData() != null) {
                    es9Var.O().getAgreeData().isInThread = true;
                }
                this.E0.setData(es9Var.O().getAgreeData());
                hw4 hw4Var = new hw4();
                hw4Var.b = 26;
                if (es9Var.O().isVideoThreadType() && es9Var.O().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                hw4Var.c = i2;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.i0() != null) {
                    hw4Var.j = this.f.i0().getFromForumId();
                    hw4Var.f = this.f.i0().s1();
                }
                this.E0.setStatisticData(hw4Var);
            }
        }
    }

    public final void k4(es9 es9Var) {
        boolean z2;
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, es9Var) == null) {
            if (es9Var != null && es9Var.K() != null) {
                RobotEntrance K = es9Var.K();
                if (!ListUtils.isEmpty(K.robot_skill_info) && !ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                    if (!ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                        CallRobotEntrance c2 = BotEntranceManager.h().c(K.robot_skill_info, K.bottom_bar_robot_skill);
                        this.V1 = c2;
                        if (c2 == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        RobotSkillInfo d2 = BotEntranceManager.h().d(K.robot_skill_info, K.bottom_bar_robot_skill);
                        StyleContentInfo styleContentInfo2 = null;
                        if (z2) {
                            if (d2 != null) {
                                styleContentInfo2 = d2.style_day;
                                styleContentInfo = d2.style_dark;
                            }
                            styleContentInfo = null;
                        } else {
                            StyleConf styleConf = this.V1.style_conf;
                            if (styleConf != null) {
                                styleContentInfo2 = styleConf.day;
                                styleContentInfo = styleConf.dark;
                            }
                            styleContentInfo = null;
                        }
                        if (styleContentInfo2 != null && styleContentInfo != null) {
                            this.J0.setVisibility(0);
                            r0(this.J0);
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F0.getLayoutParams();
                            layoutParams.removeRule(11);
                            layoutParams.addRule(0, R.id.obfuscated_res_0x7f091b2a);
                            this.F0.setLayoutParams(layoutParams);
                            this.J0.setClickCallBack(this.Z1);
                            this.J0.setCallRobotEntranceData(new vw4(this.V1, styleContentInfo2, styleContentInfo, z2));
                            return;
                        }
                        this.J0.setVisibility(8);
                        r0(this.F0);
                        return;
                    }
                    return;
                }
                this.J0.setVisibility(8);
                r0(this.F0);
                return;
            }
            this.J0.setVisibility(8);
            r0(this.F0);
        }
    }

    public void n4(es9 es9Var) {
        vra vraVar;
        d0a d0aVar;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048767, this, es9Var) == null) && es9Var != null && (vraVar = this.S0) != null && vraVar.t() != null && (d0aVar = this.k) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            d0aVar.A(z3);
            if (this.f.U6() != null) {
                this.f.U6().s(this.q1);
            }
            g3();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.Y0() && !ListUtils.isEmpty(es9Var.o())) {
                dz4 dz4Var = es9Var.o().get(0);
                if (dz4Var != null) {
                    this.k.D(es9Var, dz4Var.d(), dz4Var.b(), dz4Var.a(), dz4Var.f());
                }
            } else if (es9Var.k() != null) {
                d0a d0aVar2 = this.k;
                String name = es9Var.k().getName();
                String id = es9Var.k().getId();
                String image_url = es9Var.k().getImage_url();
                if (es9Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                d0aVar2.D(es9Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.x.O(es9Var, this.S0, this.m0);
                View view2 = this.c1;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.z1 == null) {
                    this.z1 = new u0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.z1);
                    return;
                }
                return;
            }
            View view3 = this.c1;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.x.O(es9Var, this.S0, this.m0);
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void r4(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048784, this, view2) != null) || SharedPrefHelper.getInstance().getBoolean("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.y0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f.getContext());
        this.v1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04d9);
        this.v1.setGravity(17);
        this.v1.setPadding(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.v1.getParent() == null) {
            frameLayout.addView(this.v1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f.getContext());
        this.u1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.u1.setHeight(-2);
        this.u1.setWidth(-2);
        this.u1.setFocusable(true);
        this.u1.setOutsideTouchable(false);
        this.u1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.u1);
        PbLandscapeListView pbLandscapeListView = this.o;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new z0(this, i4, i2, i3, view2), 100L);
        }
        SharedPrefHelper.getInstance().putBoolean("show_long_press_collection_tips", true);
    }

    public void w0(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, spriteMemeInfo) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                d1a.u("c10517", this.o0, 2);
            } else if (!this.f.i6()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                vg5 T6 = this.f.T6();
                if (T6 != null) {
                    T6.s0(spriteMemeInfo);
                }
                if (T6 != null && (T6.B() || T6.D())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.T6().z(false, null);
                    return;
                }
                if (this.r0 != null) {
                    b2(spriteMemeInfo);
                }
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.u(2) != null) {
                        gra.c(this.f.getPageContext(), (View) this.r0.u(2).m, false, v2);
                    }
                }
                J1();
            }
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            r0(this.F0);
            if (this.G0.getParent() != null) {
                ((ViewGroup) this.G0.getParent()).removeView(this.G0);
                ((ViewGroup) this.H0.getParent()).removeView(this.H0);
            }
            if (this.I0.getParent() != null) {
                ((ViewGroup) this.I0.getParent()).removeView(this.I0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.G0);
            relativeLayout.addView(this.H0);
            relativeLayout.addView(this.I0);
            this.k.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.k.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.J1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0() {
        t1a t1aVar;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (t1aVar = this.M1) == null) {
            return;
        }
        if (this.o != null && t1aVar.a() != null && this.M1.a().getParent() != null) {
            i2 = this.o.getPositionForView(this.M1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.M1.a().getTop() + t2 <= this.a1.getBottom()) {
                this.J1 = 1;
                z2 = true;
            } else {
                this.J1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
        if (this.J1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.y(z3);
        this.M1.e(z2);
    }

    public void K2() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && this.f != null && this.I1 != 3 && (es9Var = this.R0) != null && es9Var.k() != null && !qd.isEmpty(this.R0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.R0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.R0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.R0.k().getId()));
        }
    }

    public void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.f.hideProgressBar();
            es9 es9Var = this.R0;
            if (es9Var != null && this.O != null && es9Var.y() != null && this.R0.y().b() == 0) {
                this.O.y(this.R0.s());
                if (this.R0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.R0.l());
                    statisticItem.param("fname", this.R0.m());
                    statisticItem.param("tid", this.R0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            M0();
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            I0();
        }
    }

    public int Z0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.o.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.o.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.o.getChildAt(i5)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i5] = rect.height();
                    }
                    i3 += iArr[i5];
                }
                int i6 = i3 / 2;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i7 >= i2) {
                        break;
                    }
                    i8 += iArr[i7];
                    if (i8 > i6) {
                        firstVisiblePosition += i7;
                        break;
                    }
                    i7++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048708, this) != null) || !this.f.M6()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091729);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.E == null) {
            this.E = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091728);
            xp5.a(this.f.getPageContext(), this.E);
        }
        if (this.F == null) {
            this.F = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f09172d);
        }
        if (this.G == null) {
            this.G = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f09172c);
        }
        this.F.setOnClickListener(this.f1125T);
        this.G.setOnClickListener(this.f1125T);
    }

    public final boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            es9 es9Var = this.R0;
            if (es9Var != null && es9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.f != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        d0a d0aVar;
        es9 es9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048729, this) == null) && this.w != null && (d0aVar = this.k) != null && d0aVar.j() != null && (es9Var = this.R0) != null && es9Var.O() != null && this.R0.O().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            d0a d0aVar2 = this.k;
            if (height > d0aVar2.j().getBottom() && z2) {
                z3 = false;
            }
            d0aVar2.z(z3, this.R0.O().getSpan_str());
        }
    }

    public final void q3() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (pbFragment = this.f) != null && pbFragment.T6() != null && this.r0 != null) {
            qg5.a().c(0);
            vg5 T6 = this.f.T6();
            T6.Q();
            T6.O();
            if (T6.y() != null) {
                WriteImagesInfo y2 = T6.y();
                if (T6.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                y2.setMaxImagesAllowed(i2);
            }
            T6.h0(SendView.h);
            T6.j(SendView.h);
            he5 t3 = this.r0.t(23);
            he5 t4 = this.r0.t(2);
            he5 t5 = this.r0.t(5);
            if (t4 != null) {
                t4.display();
            }
            if (t5 != null) {
                t5.display();
            }
            if (t3 != null) {
                t3.hide();
            }
            this.r0.invalidate();
        }
    }

    public final void x0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048810, this) == null) {
            if (b4() && this.R0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.R0.O().getTid()).addParam("obj_param1", this.R0.O().getThreadRecommendInfoDataList().get(0).businessId);
                int i2 = this.R0.O().getThreadRecommendInfoDataList().get(0).albumType;
                if (i2 != -1) {
                    addParam.addParam("obj_type", i2);
                }
                addParam.eventStat();
            }
            if (p2() && (pbContentCollectionController = this.B) != null) {
                pbContentCollectionController.h();
                this.B.g(true);
            }
        }
    }

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            zz4 zz4Var = new zz4(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            zz4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            zz4Var.setYesButtonTag(sparseArray);
            zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1846, this.f);
            zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new y0(this));
            zz4Var.create(this.f.getPageContext()).show();
        }
    }

    public void W4(ds9 ds9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048690, this, ds9Var) != null) || ds9Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(ds9Var.b)) {
            this.k.y(ds9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f168b);
        int i2 = JavaTypesHelper.toInt(ds9Var.a, 0);
        if (i2 != 100) {
            if (i2 != 300) {
                if (i2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15f8);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0338);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f139a);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new s0(this, ds9Var.c));
    }

    public void Z4(es9 es9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, es9Var) == null) {
            if (es9Var != null && AntiHelper.o(es9Var.O())) {
                u1a u1aVar = this.K0;
                if (u1aVar != null) {
                    u1aVar.k(false);
                    this.K0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.G0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.G0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else if (es9Var != null && es9Var.O() != null && es9Var.O().isDisableShare()) {
                View view2 = this.I0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                ViewGroup.LayoutParams layoutParams2 = this.G0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.G0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
                MaskView.e(this.G0, es9Var.O().isDisableShare(), es9Var.O().getDisableShareToast());
            } else {
                u1a u1aVar2 = this.K0;
                if (u1aVar2 != null && u1aVar2.g()) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = this.G0.getLayoutParams();
                layoutParams3.height = -2;
                layoutParams3.width = -2;
                this.G0.setLayoutParams(layoutParams3);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void b3(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, view2) == null) && this.E0.getData() != null && this.E0.getData().hasAgree && this.f.getActivity() != null) {
            PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(this.f.getContext());
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708fc);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimens2, dimens);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((dimens2 * 1) / 1.45d));
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            pbFirstFloorDoubleClickAnimation.setLottieHeight(dimens);
            pbFirstFloorDoubleClickAnimation.setLayoutParmas(layoutParams);
            pbFirstFloorDoubleClickAnimation.setClippingEnable(false);
            if (this.R0 != null && (pbFragment = this.f) != null) {
                pbFirstFloorDoubleClickAnimation.showFireworks(true, pbFragment.getActivity().findViewById(16908290), 0, i3, this.R0.Q(), this.R0.l());
            }
            pbFirstFloorDoubleClickAnimation.setOnPraiseAnimatorListener(new u(this));
        }
    }

    public final boolean p4(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048775, this, es9Var)) == null) {
            if (es9Var == null || es9Var.O() == null) {
                return false;
            }
            if (es9Var.O().getIsLive() != 1 && es9Var.O().getThreadType() != 33 && ((es9Var.O().getTopicData() == null || es9Var.O().getTopicData().a() == 0) && es9Var.O().getIs_top() != 1 && es9Var.O().getIs_good() != 1 && !es9Var.O().isActInfo() && !es9Var.O().isInterviewLive() && !es9Var.O().isVoteThreadType() && es9Var.O().getYulePostActivityData() == null && qd.isEmpty(es9Var.O().getCategory()) && !es9Var.O().isGodThread() && !es9Var.O().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void D4(zz4 zz4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048595, this, zz4Var, i2) == null) && (pbFragment = this.f) != null && zz4Var != null) {
            if (this.E1 == null && this.v != null) {
                this.E1 = new a16(pbFragment.getPageContext(), this.v.c());
            }
            AntiData F6 = this.f.F6();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (F6 != null && F6.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = F6.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            this.E1.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.E1.A(negativeFeedBackData);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.E1.D(str);
            this.E1.C(new i0(this, zz4Var));
        }
    }

    public void I4(ey4 ey4Var, zz4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048620, this, ey4Var, eVar) != null) || ey4Var == null) {
            return;
        }
        int a2 = ey4Var.a();
        int h2 = ey4Var.h();
        zz4 zz4Var = this.J;
        if (zz4Var != null) {
            zz4Var.show();
        } else {
            this.J = new zz4(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d026d, (ViewGroup) null);
            this.L = inflate;
            this.J.setContentView(inflate);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f05a3, eVar);
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f0598, new v0(this));
            this.J.setOnCalcelListener(new w0(this));
            this.J.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.L.findViewById(R.id.obfuscated_res_0x7f091187);
        this.M = editText;
        editText.setText("");
        TextView textView = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f09085c);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.M, 150);
    }

    public boolean a5(es9 es9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048711, this, es9Var, z2)) == null) {
            if (es9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (es9Var.O() != null && es9Var.O().getIsNoTitle() == 0 && !es9Var.O().isVideoThreadType()) {
                    if (es9Var.O() != null) {
                        ThreadData O = es9Var.O();
                        O.parserSpecTitleForFrsAndPb(true, p4(es9Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (es9Var.O().isBJHArticleThreadType()) {
                        this.x.E(this.o);
                        this.w.h(this.o);
                        this.w.a(this.o);
                        this.x.p(this.o);
                        this.x.J(this.R0);
                        if (k2(es9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.i(es9Var);
                        }
                    } else {
                        this.x.J(this.R0);
                        if (k2(es9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.k(es9Var);
                        }
                    }
                } else if (es9Var.O().getIsNoTitle() == 1) {
                    if (es9Var.O() != null) {
                        this.w.h(this.o);
                        this.x.J(this.R0);
                    }
                } else {
                    this.w.h(this.o);
                    this.x.J(this.R0);
                }
            }
            K4(es9Var.X());
            L4(es9Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void h4(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048743, this, i2, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.i0() != null && this.f.i0().t1() != null && this.f.i0().t1().n() != null && this.f.i0().t1().k() != null && this.f.i0().t1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            c16 c16Var = new c16(this.f.i0().t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.i0().t1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.i0().t1().n().has_forum_rule.intValue());
            c16Var.i(this.f.i0().t1().k().getId(), this.f.i0().t1().k().getName());
            c16Var.h(this.f.i0().t1().k().getImage_url());
            c16Var.j(this.f.i0().t1().k().getUser_level());
            v4(sparseArray, i2, c16Var, this.f.i0().t1().V(), true);
        }
    }

    public void E2(AgreeMessageData agreeMessageData) {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (es9Var = this.R0) != null && es9Var.O() != null && this.R0.O().getAgreeData() != null) {
            AgreeData agreeData = this.R0.O().getAgreeData();
            String str = agreeMessageData.agreeData.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = agreeMessageData.agreeData.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = agreeMessageData.agreeData;
            i3(agreeData2, agreeData2.agreeNum);
        }
    }

    public void I2(TbRichText tbRichText) {
        es9 es9Var;
        vra vraVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, tbRichText) == null) && (es9Var = this.R0) != null && es9Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.R0.F().size() && (vraVar = this.R0.F().get(i2)) != null && vraVar.t() != null && !StringUtils.isNull(vraVar.t().getUserId()); i2++) {
                if (this.R0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                    ev9 ev9Var = this.y1;
                    if (ev9Var != null && ev9Var.k()) {
                        m4(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void J4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) && this.o != null && (textView = this.Z0) != null && this.h != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                    this.o.removeHeaderView(this.Z0);
                    this.o.setTextViewAdded(false);
                }
                if (this.Z0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
                    layoutParams.height = m2;
                    this.Z0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.Z0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + r1(true);
                this.Z0.setLayoutParams(layoutParams2);
            }
            m3();
        }
    }

    public void K1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048627, this, z2) == null) && this.y0 != null && this.B0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            es9 es9Var = this.R0;
            if (es9Var != null && es9Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            es9 es9Var2 = this.R0;
            if (es9Var2 != null && es9Var2.r0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.B0.setText(tbSingleton.getAdVertiComment(z3, z4, y1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y0.startAnimation(alphaAnimation);
            }
            this.x0.setVisibility(0);
            this.y0.setVisibility(0);
            this.N0 = true;
        }
    }

    public final void L4(es9 es9Var) {
        boolean z2;
        ky9 ky9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, es9Var) == null) && !this.B1 && es9Var != null && es9Var.O() != null && !es9Var.O().isVideoThreadType()) {
            ThreadData O = es9Var.O();
            boolean z3 = false;
            if (O.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (O.getIs_top() == 1) {
                z3 = true;
            }
            my9 my9Var = this.x;
            if (my9Var != null) {
                my9Var.t(es9Var, z2, z3);
            }
            if (O.isShowTitle() && (ky9Var = this.w) != null && ky9Var.d() != null) {
                ix9.c(this.w.d(), O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
            if (T0() != null) {
                T0().J0(es9Var);
            }
        }
    }

    public final String R0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048661, this, j2)) == null) {
            if (j2 == 0) {
                return "";
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (j2 > 9990000) {
                return "· · ·";
            }
            if (j2 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(((float) j2) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (j2 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j2) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + j2;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final String S0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048666, this, i2)) == null) {
            if (i2 == 0) {
                return this.f.getString(R.string.obfuscated_res_0x7f0f1008);
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

    public void b2(@Nullable SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, spriteMemeInfo) == null) {
            if (this.f != null && this.r0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.r0.n(spriteMemeInfo);
                J1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void c5(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            rv9 rv9Var = this.I;
            if (rv9Var != null) {
                rv9Var.A0(z2);
                this.I.f0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.r(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.h1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.r(z2);
            }
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                pbFragment.w8(z2);
            }
            if (z2) {
                pz9.d(this.f.getPageContext(), this.f.i0(), this.f.W6());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            es9 es9Var = this.R0;
            if (es9Var != null) {
                str = es9Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void g2(es9 es9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048737, this, es9Var) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            if (es9Var.y().b() == 0 && !this.f.i0().Y0() && !u2(es9Var)) {
                if (this.b == null) {
                    W1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i2.addView(this.b);
                ForumData k2 = es9Var.k();
                kx4 forumShowInfo = k2.getForumShowInfo();
                if (forumShowInfo != null) {
                    forumShowInfo.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                }
                this.b.setData(k2.getName(), k2.getImage_url(), k2.getPost_num(), k2.getMember_num(), k2.getPendants(), forumShowInfo);
                return;
            }
            i2.removeView(this.b);
            i2.setVisibility(8);
        }
    }

    public final void g4(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048739, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f1418, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d3, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.r0()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new f0(this, show, sparseArray));
        operateBtnConfig2.setListener(new h0(this, show));
    }

    public void u3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, editorTools) == null) {
            this.r0 = editorTools;
            editorTools.setOnCancelClickListener(new y(this));
            this.r0.setId(R.id.obfuscated_res_0x7f091b27);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.r0.getParent() == null) {
                this.g.addView(this.r0, layoutParams);
            }
            this.r0.F(TbadkCoreApplication.getInst().getSkinType());
            this.r0.setActionListener(24, new z(this));
            M1();
            this.f.T6().i(new a0(this));
        }
    }

    public void F2(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048603, this, i2) != null) || this.U0 == i2) {
            return;
        }
        this.U0 = i2;
        M4(this.R0, this.Q0);
        l3(this.R0, this.Q0, this.T0, i2);
        BDLayoutMode layoutMode = this.f.getBaseFragmentActivity().getLayoutMode();
        if (i2 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.setNightMode(z2);
        this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.g);
        SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        jy9 jy9Var = this.y;
        if (jy9Var != null) {
            jy9Var.c(i2);
        }
        iy9 iy9Var = this.v;
        if (iy9Var != null) {
            iy9Var.e(i2);
        }
        ky9 ky9Var = this.w;
        if (ky9Var != null) {
            ky9Var.g(i2);
        }
        my9 my9Var = this.x;
        if (my9Var != null) {
            my9Var.A(i2);
        }
        ly9 ly9Var = this.z;
        if (ly9Var != null) {
            ly9Var.e();
        }
        hy9 hy9Var = this.A;
        if (hy9Var != null) {
            hy9Var.c();
        }
        MaskView maskView = this.N1;
        if (maskView != null) {
            maskView.g();
        }
        fx9 fx9Var = this.s;
        if (fx9Var != null) {
            fx9Var.o();
        }
        zv9 zv9Var = this.D;
        if (zv9Var != null) {
            zv9Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.B;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.O;
        if (pbListView != null) {
            pbListView.e(i2);
        }
        if (this.Q != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.Q);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.R != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.R);
            SkinManager.setBackgroundResource(this.R, R.drawable.pb_foot_more_trans_selector);
        }
        zz4 zz4Var = this.J;
        if (zz4Var != null) {
            zz4Var.autoChangeSkinType(this.f.getPageContext());
        }
        U4(this.l0);
        this.I.f0();
        v1a v1aVar = this.N;
        if (v1aVar != null) {
            v1aVar.D(i2);
        }
        EditorTools editorTools = this.r0;
        if (editorTools != null) {
            editorTools.F(i2);
        }
        q1a q1aVar = this.P;
        if (q1aVar != null) {
            q1aVar.g(i2);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        b5();
        UtilHelper.setStatusBarBackground(this.h, i2);
        UtilHelper.setStatusBarBackground(this.c1, i2);
        if (this.E != null) {
            xp5.a(this.f.getPageContext(), this.E);
        }
        gw9 gw9Var = this.m1;
        if (gw9Var != null) {
            gw9Var.l(i2);
        }
        d0a d0aVar = this.k;
        if (d0aVar != null) {
            d0aVar.p(i2);
        }
        LinearLayout linearLayout = this.z0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        es9 es9Var = this.R0;
        if (es9Var != null && es9Var.q()) {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        Z4(this.R0);
        if (this.I0.getVisibility() == 0) {
            this.I0.setBackgroundDrawable(SkinManager.createShapeDrawable(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.y0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.x0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.v1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.B0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.M0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.M0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.L0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.L0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.E0;
        if (agreeView != null) {
            agreeView.x();
            this.E0.P(i2);
            AgreeData data = this.E0.getData();
            if (data != null) {
                i3(data, data.agreeNum);
            }
        }
        ev9 ev9Var = this.y1;
        if (ev9Var != null) {
            ev9Var.l(i2);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(bqa.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        u1a u1aVar = this.K0;
        if (u1aVar != null) {
            u1aVar.i();
        }
        t1a t1aVar = this.M1;
        if (t1aVar != null) {
            t1aVar.c();
        }
        RightFloatLayerView rightFloatLayerView = this.P1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.b1, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.b1.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.R1;
        if (linearLayout2 != null) {
            EMManager.from(linearLayout2).setBackGroundColor(R.color.CAM_X0201);
        }
        oz9 oz9Var = this.S1;
        if (oz9Var != null) {
            oz9Var.b(i2);
        }
    }

    public void G2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048608, this, configuration) != null) || configuration == null) {
            return;
        }
        F0();
        if (configuration.orientation == 2) {
            J1();
            L1();
        } else {
            r3();
        }
        gw9 gw9Var = this.m1;
        if (gw9Var != null) {
            gw9Var.g();
        }
        this.f.h7();
        this.H.setVisibility(8);
        this.k.v(false);
        this.f.x8(false);
    }

    public void L2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            if (z2) {
                s4();
            } else {
                N1();
            }
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            f3(this.h1.a, false);
        }
    }

    public void V4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z2) == null) {
            this.k.B(z2);
            if (z2 && this.V0) {
                this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.O);
                }
                this.i = 2;
            }
        }
    }

    public void e2(es9 es9Var) {
        u75 b02;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048728, this, es9Var) != null) || es9Var == null) {
            return;
        }
        if (es9Var.q0()) {
            b02 = es9Var.b0();
        } else {
            b02 = es9Var.b0();
            if (b02 == null || b02.a()) {
                b02 = TbSingleton.getInstance().getPbAdFloatViewItemData();
            }
        }
        if (b02 != null && !b02.a()) {
            d2(es9Var, b02);
        } else {
            R1();
        }
    }

    public void m4(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048763, this, z2) != null) || this.y0 == null) {
            return;
        }
        if (this.f.T6() != null && this.f.T6().C()) {
            z3 = true;
        } else {
            z3 = false;
        }
        z3(z3);
        if (this.s0) {
            q4(z2);
        } else {
            K1(z2);
        }
    }

    public void q4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) && this.y0 != null && (textView = this.B0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0612);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.y0.startAnimation(alphaAnimation);
            }
            this.x0.setVisibility(0);
            this.y0.setVisibility(0);
            this.N0 = true;
        }
    }

    public final boolean r2(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        vra X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048782, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                es9 es9Var = this.R0;
                if (es9Var != null && (X = es9Var.X()) != null && X.t() != null) {
                    str = X.t().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean u2(es9 es9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048797, this, es9Var)) == null) {
            if (es9Var == null) {
                return true;
            }
            ArrayList<vra> F = es9Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((vra) ListUtils.getItem(F, 0)).J() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int z1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048821, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.getView().getTop() == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                return 0;
            }
            return pbReplyTitleViewHolder.getView().getBottom();
        }
        return invokeL.intValue;
    }

    public void H2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            u1a u1aVar = this.K0;
            if (u1aVar != null) {
                u1aVar.j();
            }
            tw9 tw9Var = this.C1;
            if (tw9Var != null) {
                tw9Var.c();
            }
            PbTopTipView pbTopTipView = this.t1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f.hideProgressBar();
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null && (bVar = this.W) != null) {
                noNetworkView.removeNetworkChangeListener(bVar);
            }
            gra.d();
            F0();
            M0();
            if (this.k1 != null) {
                SafeHandler.getInst().removeCallbacks(this.k1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.X1);
            nq6.b().a(this.T1);
            this.b2 = null;
            this.j.removeCallbacksAndMessages(null);
            this.I.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            rv9 rv9Var = this.I;
            if (rv9Var != null) {
                rv9Var.i0();
            }
            qy9 qy9Var = this.x1;
            if (qy9Var != null) {
                qy9Var.l();
            }
            my9 my9Var = this.x;
            if (my9Var != null) {
                my9Var.B();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.s(null);
            }
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.o.setListViewDragListener(null);
                this.o.K();
                this.o = null;
            }
            AgreeView agreeView = this.E0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.E0.setAfterClickListener(null);
            }
            g1 g1Var = this.h1;
            if (g1Var != null) {
                g1Var.a = null;
            }
            if (this.U1 != null) {
                SafeHandler.getInst().removeCallbacks(this.U1);
            }
            gw9 gw9Var = this.m1;
            if (gw9Var != null) {
                gw9Var.m();
            }
            nr9.d();
            TbMixPlayerView tbMixPlayerView = this.W1;
            if (tbMixPlayerView != null) {
                tbMixPlayerView.s();
                this.W1.p();
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048687, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091b1b);
            this.b.setNeedShowForumlable(false);
            this.b.setJumpCallFrom(2);
            this.b.setBarNameIncludePadding(false);
            this.b.setBarThreadLineSpace(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds26));
            this.b.setAttentionLineSpace(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds26));
            int dimens = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_W_X006);
            int dimens2 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds16);
            int dimens3 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds15);
            int dimens4 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_W_X007);
            int dimens5 = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.M_H_X005);
            this.b.setPadding(dimens, dimens2, dimens, dimens3);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = dimens4;
            marginLayoutParams.rightMargin = dimens4;
            marginLayoutParams.bottomMargin = dimens5;
            this.b.setLayoutParams(marginLayoutParams);
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(bqa.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new p(this));
        }
    }

    public final void e5() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && (pbFragment = this.f) != null && pbFragment.i0() != null && this.f.i0().G != null && this.f.i0().G.O() != null && this.f.i0().G.O().isXiuXiuThread()) {
            ThreadData O = this.f.i0().G.O();
            int i3 = 0;
            if (this.f.i0().Y0()) {
                i2 = 1;
            } else if (this.f.i0().b1()) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(O.getForum_name());
            if (itemInfo != null) {
                i3 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i2).addParam("fid", O.getFid()).addParam("fname", O.getForum_name()).addParam("post_id", O.getTid()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
        }
    }

    public void h3() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048742, this) != null) || (pbLandscapeListView = this.o) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.o1;
        int i4 = 0;
        if (this.o.getFirstVisiblePosition() != 0 && this.o.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i2 = this.o.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i2 = 0;
        }
        View childAt = this.o.getChildAt(0);
        if (childAt != null) {
            i3 = childAt.getTop();
        } else {
            i3 = -1;
        }
        this.h1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.h1.a;
        int z1 = z1(pbReplyTitleViewHolder);
        int measuredHeight = this.H.getMeasuredHeight() + ((int) this.H.getY());
        boolean z3 = true;
        if (this.a1.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.H.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.I.J() + this.o.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.o.setSelectionFromTop(this.I.J() + this.o.getHeaderViewsCount(), m2 - i4);
            } else {
                this.o.setSelectionFromTop(this.I.J() + this.o.getHeaderViewsCount(), this.k.j().getMeasuredHeight() - i4);
            }
        } else {
            this.o.setSelectionFromTop(i2, i3);
        }
        if (this.T0 != 9) {
            return;
        }
        this.o.setOnLayoutListener(new l(this, z1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
    }

    public void O0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f14d5));
            } else if (z3) {
                if (qd.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                }
                this.f.showToast(str);
            }
        }
    }

    public void Y2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (z2) {
                g4(sparseArray);
            } else {
                h4(i2, sparseArray);
            }
        }
    }

    public final void Q4(int i2, int i3, boolean z2) {
        String str;
        AbilityConf abilityConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            CallRobotEntrance callRobotEntrance = this.V1;
            String str2 = "";
            if (callRobotEntrance == null || (abilityConf = callRobotEntrance.ability_conf) == null) {
                str = "";
            } else {
                str = abilityConf.bot_uk;
            }
            String l2 = this.R0.l();
            if (this.R0.O() != null) {
                str2 = String.valueOf(this.R0.O().getTid());
            }
            CommonStatisticUtils.statisticFriendBotView(i2, str, i3, z2, l2, str2);
        }
    }

    public void S2(AbsListView absListView, int i2, int i3, int i4) {
        PbListView pbListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048668, this, absListView, i2, i3, i4) == null) {
            jw9 jw9Var = this.u;
            if (jw9Var != null) {
                jw9Var.c(i2, i3);
            }
            jw9 jw9Var2 = this.t;
            if (jw9Var2 != null) {
                jw9Var2.c(i2, i3);
            }
            bw9 bw9Var = this.C;
            if (bw9Var != null) {
                bw9Var.l(i2, i3);
            }
            d0a d0aVar = this.k;
            if (d0aVar != null && this.x != null) {
                d0aVar.q(absListView, i2, i3, i4);
            }
            e3();
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            l4(w2(absListView, i2));
            f3(this.h1.a, false);
            E0();
            if (this.O.q() && !this.O.D) {
                g1 g1Var = this.h1;
                if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.h1.a.getView().getTop() < 0) {
                        i5 = this.h1.a.getView().getHeight();
                    } else {
                        i5 = this.h1.a.getView().getBottom();
                    }
                } else {
                    i5 = 0;
                }
                this.O.f(i5);
                this.O.D = true;
            }
            if (i2 > this.c && (pbListView = this.O) != null && pbListView.i() != null) {
                ek6.f(this.O.i(), 0);
            }
        }
    }

    public void T2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048673, this, absListView, i2) == null) {
            if (i2 == 0) {
                this.h1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
                f3(this.h1.a, true);
                E0();
                this.I.m0(true);
            }
            this.I.l0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.P1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                y0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.P1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.P1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void i3(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048746, this, agreeData, j2) == null) && agreeData != null && (textView = this.L0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.L0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.L0.setText(R0(j2));
                this.L0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void U2(ArrayList<rx4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, arrayList) == null) {
            if (this.c0 == null) {
                this.c0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c0);
            if (this.b0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c6);
                this.b0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.b0.setCancelable(true);
                this.q0 = (ScrollView) this.c0.findViewById(R.id.good_scroll);
                this.b0.setContentView(this.c0);
                WindowManager.LayoutParams attributes = this.b0.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f5);
                this.b0.getWindow().setAttributes(attributes);
                this.e0 = new k0(this);
                this.d0 = (LinearLayout) this.c0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.c0.findViewById(R.id.dialog_button_cancel);
                this.g0 = textView;
                textView.setOnClickListener(new l0(this));
                TextView textView2 = (TextView) this.c0.findViewById(R.id.dialog_button_ok);
                this.f0 = textView2;
                textView2.setOnClickListener(this.f1125T);
            }
            this.d0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton B0 = B0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(B0);
            B0.setChecked(true);
            this.d0.addView(B0);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    rx4 rx4Var = arrayList.get(i2);
                    if (rx4Var != null && !TextUtils.isEmpty(rx4Var.b()) && rx4Var.a() > 0) {
                        CustomBlueCheckRadioButton B02 = B0(String.valueOf(rx4Var.a()), rx4Var.b());
                        this.q.add(B02);
                        View view2 = new View(this.f.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.d0.addView(view2);
                        this.d0.addView(B02);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.q0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = BdUtilHelper.dip2px(this.f.getPageContext().getPageActivity(), 120.0f);
                }
                this.q0.setLayoutParams(layoutParams2);
                this.q0.removeAllViews();
                LinearLayout linearLayout = this.d0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.q0.addView(this.d0);
                }
            }
            xb.j(this.b0, this.f.getPageContext());
        }
    }

    public void V2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048683, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            W2(i2, str, i3, z2, null);
        }
    }

    public void l3(es9 es9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048758, this, new Object[]{es9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            y4(es9Var, z2, i2, i3);
            this.x.A(i3);
        }
    }

    public void W2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048688, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            X2(i2, str, i3, z2, str2, false);
        }
    }

    public void X2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048693, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (i3 == 1002 && !z2) {
                i4 = R.string.report_post_confirm;
            } else {
                i4 = R.string.del_all_post_confirm;
            }
            int i5 = R.string.confirm_title;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i5 = R.string.del_my_thread_confirm;
                    i4 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.Z = new zz4(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Z.setMessageId(i4);
            } else {
                this.Z.setOnlyMessageShowCenter(false);
                this.Z.setMessage(str2);
            }
            this.Z.setYesButtonTag(sparseArray);
            this.Z.setPositiveButton(R.string.obfuscated_res_0x7f0f05a3, this.f);
            this.Z.setNegativeButton(R.string.obfuscated_res_0x7f0f0598, new c0(this));
            this.Z.setCancelable(true);
            this.Z.create(this.f.getPageContext());
            if (z3) {
                o4(sparseArray, i5, i4);
            } else if (z2) {
                o4(sparseArray, i5, i4);
            } else if (c4()) {
                c16 c16Var = new c16(this.f.i0().t1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.i0().t1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.i0().t1().n().has_forum_rule.intValue());
                c16Var.i(this.f.i0().t1().k().getId(), this.f.i0().t1().k().getName());
                c16Var.h(this.f.i0().t1().k().getImage_url());
                c16Var.j(this.f.i0().t1().k().getUser_level());
                v4(sparseArray, i2, c16Var, this.f.i0().t1().V(), false);
            } else {
                D4(this.Z, i2);
            }
        }
    }

    public void X3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.B0.performClick();
            if (!StringUtils.isNull(str) && this.f.T6() != null && this.f.T6().v() != null && this.f.T6().v().k() != null) {
                EditText k2 = this.f.T6().v().k();
                k2.setText(str);
                k2.setSelection(str.length());
            }
        }
    }

    public final void Z1(es9 es9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048702, this, es9Var) != null) || es9Var == null || es9Var.O() == null || !es9Var.O().isInterviewLive() || this.Y0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.X0.inflate();
        this.Y0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.f1125T);
        this.Y0.setCallback(this.f.L6());
        this.Y0.setData(this.f, es9Var);
    }

    public final int e1(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048727, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            fi adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof ura)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof fi)) {
                i3 = this.o.getAdapter2().n();
            } else {
                i3 = 0;
            }
            if (i2 <= i3) {
                return 0;
            }
            return i2 - i3;
        }
        return invokeI.intValue;
    }

    public void j4(kr9 kr9Var) {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048751, this, kr9Var) == null) && (es9Var = this.R0) != null && es9Var.K() != null && !ListUtils.isEmpty(this.R0.K().robot_skill_info) && !ListUtils.isEmpty(this.R0.K().bottom_bar_robot_skill)) {
            pq9.a(this.J0, BotEntranceManager.e(this.R0.K().robot_skill_info, this.R0.K().bottom_bar_robot_skill), new r(this), kr9Var);
        }
    }

    public void w3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048808, this, str) == null) && this.O != null) {
            int i2 = 0;
            g1 g1Var = this.h1;
            if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.h1.a.getView().getTop() < 0 ? this.h1.a.getView().getHeight() : this.h1.a.getView().getBottom();
            }
            this.O.K(str, i2);
        }
    }

    public void z0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048820, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i4 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.u0;
            if (view2 != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            PbListView pbListView = this.O;
            if (pbListView != null) {
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                pbListView.O(i2);
            }
            View view3 = this.Q;
            if (view3 != null) {
                if (z2) {
                    i4 = 8;
                }
                view3.setVisibility(i4);
            }
        }
    }

    public void Z2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        f05 f05Var;
        f05 f05Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048703, this, sparseArray, z2) == null) {
            j05 j05Var = new j05(this.f.getContext());
            j05Var.u(this.f.getString(R.string.obfuscated_res_0x7f0f0326));
            j05Var.r(new b0(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i2 != 2) {
                if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                }
                if (i3 == 0) {
                    f05Var2 = new f05(10, this.f.getString(R.string.obfuscated_res_0x7f0f0562), j05Var);
                } else {
                    f05Var2 = new f05(10, this.f.getString(R.string.obfuscated_res_0x7f0f0553), j05Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                f05Var2.d.setTag(sparseArray2);
                arrayList.add(f05Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                f05 f05Var3 = new f05(13, this.f.getString(R.string.multi_delete), j05Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                f05Var3.d.setTag(sparseArray3);
                arrayList.add(f05Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                f05 f05Var4 = new f05(11, this.f.getString(R.string.forbidden_person), j05Var);
                f05Var4.d.setTag(sparseArray4);
                arrayList.add(f05Var4);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                sparseArray5.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
                if (z2) {
                    f05Var = new f05(12, this.f.getString(R.string.un_mute), j05Var);
                } else {
                    f05Var = new f05(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d39), j05Var);
                }
                f05Var.d.setTag(sparseArray5);
                arrayList.add(f05Var);
            }
            lz9.f(arrayList);
            j05Var.n(arrayList, true);
            h05 h05Var = new h05(this.f.getPageContext(), j05Var);
            this.X = h05Var;
            h05Var.l();
        }
    }

    public final void f3(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        TbMixPlayerView tbMixPlayerView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048734, this, pbReplyTitleViewHolder, z2) == null) && !this.p1 && this.a1 != null && this.k.j() != null) {
            View u3 = T0().u();
            if (u3 != null) {
                int[] iArr = new int[2];
                u3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.a1.getVisibility() == 0 && i3 - this.k.j().getBottom() <= this.a1.getHeight()) {
                        this.b1.setVisibility(0);
                        if (i3 > this.k.j().getBottom()) {
                            i2 = -(((this.a1.getHeight() + this.b1.getHeight()) + this.k.j().getBottom()) - u3.getBottom());
                        } else {
                            i2 = -this.a1.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.a1.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
                            this.a1.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.b1.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.a1.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.a1.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int J = this.I.J();
            if (J > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null && J > pbLandscapeListView.getFirstVisiblePosition() - this.o.getHeaderViewsCount()) {
                    this.a1.setVisibility(4);
                    return;
                }
                this.a1.setVisibility(0);
                l4(false);
                this.k.a.hideBottomLine();
                if (this.a1.getParent() != null && ((ViewGroup) this.a1.getParent()).getHeight() <= this.a1.getTop()) {
                    this.a1.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.g1) {
                        this.f1 = top;
                        this.g1 = false;
                    }
                    int i4 = this.f1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.f1 = i4;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.H.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = m2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.k.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    if (i2() && (tbMixPlayerView = this.W1) != null) {
                        measuredHeight += tbMixPlayerView.getPlayerHeight();
                    }
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.f1) {
                    this.a1.setVisibility(0);
                    l4(false);
                } else if (top < measuredHeight) {
                    this.a1.setVisibility(0);
                    l4(false);
                } else {
                    this.a1.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
                if (z2) {
                    this.g1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.o;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.a1.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
            }
        }
    }

    public final void d2(es9 es9Var, u75 u75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048723, this, es9Var, u75Var) == null) && this.Q1 != null && es9Var != null && u75Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                R1();
                return;
            }
            if (this.P1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(u75Var, this.f.getContext());
                this.P1 = E;
                E.setPageContext(this.f.getPageContext());
                this.Q1.removeAllViews();
                this.Q1.addView(this.P1);
            }
            if ((this.O1.getTag() instanceof Boolean) && !((Boolean) this.O1.getTag()).booleanValue()) {
                this.P1.setAutoCompleteShown(false);
                this.P1.setTag(this.O1);
                this.P1.c();
            }
            if (u75Var.a()) {
                return;
            }
            this.P1.setData(u75Var);
            this.P1.setLogoListener(new r0(this, u75Var));
            this.P1.setFeedBackListener(new b1(this, u75Var));
        }
    }

    public void k3(int i2, es9 es9Var, boolean z2, int i3) {
        vra X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048754, this, new Object[]{Integer.valueOf(i2), es9Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && es9Var != null && (X = es9Var.X()) != null && X.t() != null) {
            MetaData t3 = X.t();
            t3.setGiftNum(t3.getGiftNum() + i2);
        }
    }

    public SparseArray<Object> n1(es9 es9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        vra X;
        boolean z3;
        ix4 ix4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048764, this, new Object[]{es9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (es9Var == null || (X = es9Var.X()) == null) {
                return null;
            }
            String userId = X.t().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, X.T());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(es9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (X.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, X.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, X.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, X.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, X.T());
                }
                sparseArray.put(R.id.tag_del_post_id, X.T());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(es9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<dz4> o3 = es9Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (dz4 dz4Var : o3) {
                        if (dz4Var != null && !StringUtils.isNull(dz4Var.d()) && (ix4Var = dz4Var.h) != null && ix4Var.a && !ix4Var.c && ((i3 = ix4Var.b) == 1 || i3 == 2)) {
                            sb.append(qd.cutString(dz4Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f0787));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f054b), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void o4(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048771, this, sparseArray, i2, i3) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f0553, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d3, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.r0()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new d0(this, show, sparseArray));
        operateBtnConfig2.setListener(new e0(this, show));
    }

    public final void s0(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048785, this, new Object[]{str, str2, Long.valueOf(j2)}) != null) || this.R0.O() == null) {
            return;
        }
        fr9.c();
        String c2 = nz9.c(this.R0.O().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
        nz9.a(this.f.getPageContext(), str2, j2, this.R0.O().getTid(), this.R0.O().getFirstPostId(), c2, new t(this, str, c2));
    }

    public void x4(es9 es9Var, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        int size;
        int i6;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048814, this, new Object[]{es9Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && es9Var != null && this.o != null) {
            this.R0 = es9Var;
            this.T0 = i2;
            if (es9Var.O() != null) {
                this.i1 = es9Var.O().getCopyThreadRemindType();
                this.m0 = r2(es9Var.O());
            }
            if (es9Var.V() != null) {
                this.h2 = es9Var.V().getUserId();
            }
            Z1(es9Var);
            this.V0 = false;
            this.Q0 = z2;
            T3();
            ps9 ps9Var = es9Var.h;
            if (ps9Var != null && ps9Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(es9Var);
                    this.r.setChildOnClickLinstener(this.f1125T);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            y4(es9Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            n4(es9Var);
            this.x.P(es9Var, this.S0);
            if (this.C1 == null) {
                this.C1 = new tw9(this.f.getPageContext(), this.D1);
            }
            this.C1.a(es9Var.w());
            if (this.f.M6()) {
                if (this.N == null) {
                    v1a v1aVar = new v1a(this.f.getPageContext());
                    this.N = v1aVar;
                    v1aVar.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                v1a v1aVar2 = this.N;
                if (v1aVar2 != null) {
                    v1aVar2.D(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (es9Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.N == null) {
                    v1a v1aVar3 = new v1a(this.f.getPageContext());
                    this.N = v1aVar3;
                    v1aVar3.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                v1a v1aVar4 = this.N;
                if (v1aVar4 != null) {
                    v1aVar4.D(TbadkCoreApplication.getInst().getSkinType());
                }
                O1();
            }
            I0();
            this.I.v0(this.Q0);
            this.I.s0(false);
            rv9 rv9Var = this.I;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            rv9Var.t0(z4);
            rv9 rv9Var2 = this.I;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            rv9Var2.u0(z5);
            rv9 rv9Var3 = this.I;
            if (z3 && this.f2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            rv9Var3.q0(z6);
            this.I.n0(es9Var, false);
            this.I.f0();
            rv9 rv9Var4 = this.I;
            if (es9Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            rv9Var4.h0(z7, es9Var.f());
            this.x.N(es9Var.X(), es9Var.j0());
            if (es9Var.O() != null && es9Var.O().getPraise() != null && this.e != -1) {
                es9Var.O().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.e1);
            this.o.addFooterView(this.e1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.O);
                this.i = 2;
                O1();
            } else {
                this.V0 = true;
                if (es9Var.y().b() == 1) {
                    if (this.P == null) {
                        PbFragment pbFragment2 = this.f;
                        this.P = new q1a(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.P);
                } else {
                    this.o.setNextPage(this.O);
                }
                this.i = 3;
            }
            ArrayList<vra> F = es9Var.F();
            if (es9Var.y().b() != 0 && F != null && F.size() >= es9Var.y().e()) {
                if (z3) {
                    if (this.f2) {
                        M0();
                        if (es9Var.y().b() != 0) {
                            this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.O.D();
                        this.O.R();
                    }
                } else {
                    this.O.D();
                    this.O.R();
                }
                this.O.n();
            } else {
                if (u2(es9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            i5 = this.h1.a.getView().getHeight();
                        } else {
                            i5 = this.h1.a.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.f.r7()) {
                        this.O.y(false);
                        if (ListUtils.isEmpty(es9Var.R())) {
                            this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1026), i5);
                        }
                    } else if (ListUtils.isEmpty(es9Var.R())) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1027), i5);
                    }
                    if (this.f.U6() != null && !this.f.U6().p()) {
                        this.f.U6().x();
                    }
                } else {
                    if (es9Var.y().b() == 0) {
                        vra vraVar = (vra) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (vraVar != null) {
                            vraVar.P = false;
                        }
                        this.O.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds32));
                        this.o.setClipChildren(false);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.E(0);
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
                if (es9Var.y().b() == 0 || F == null) {
                    n3();
                }
            }
            switch (i2) {
                case 2:
                    if (this.o.getData() == null && es9Var.F() == null) {
                        size = 0;
                    } else {
                        size = (this.o.getData().size() - es9Var.F().size()) + this.o.getHeaderViewsCount();
                    }
                    PbLandscapeListView pbLandscapeListView2 = this.o;
                    if (i3 > 1) {
                        i6 = (i3 + size) - 2;
                    } else {
                        i6 = 0;
                    }
                    pbLandscapeListView2.setSelection(i6);
                    break;
                case 3:
                    if (i4 == 1 && (e2 = ax9.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.o.post(new t0(this, e2, F, es9Var));
                        break;
                    }
                    break;
                case 4:
                    this.f2 = false;
                    break;
                case 5:
                    this.o.setSelection(0);
                    break;
                case 6:
                case 9:
                    if (i4 == 1 && (e3 = ax9.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                        this.o.onRestoreInstanceState(e3);
                        break;
                    } else {
                        this.o.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    if (i3 == 0) {
                        this.o.setSelection(this.I.D() + this.o.getHeaderViewsCount());
                    } else if (ListUtils.isEmpty(es9Var.R())) {
                        if (this.o.getData() == null && es9Var.F() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.o.getData().size() - es9Var.F().size()) + this.o.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView3 = this.o;
                        if (i3 > 0) {
                            i7 = i3 + size2;
                        } else {
                            i7 = 0;
                        }
                        pbLandscapeListView3.setSelection(i7);
                    } else {
                        this.o.setSelection(es9Var.F().size() + this.o.getHeaderViewsCount());
                    }
                    this.O.g();
                    this.O.H(this.f.getString(R.string.obfuscated_res_0x7f0f1020));
                    this.O.E(0);
                    this.O.B();
                    break;
            }
            if (this.i1 == n2 && o2()) {
                C0();
            }
            if (this.n1) {
                h3();
                this.n1 = false;
                if (i4 == 0) {
                    J3(true);
                }
            }
            if (es9Var.d == 1 || es9Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.f.getContext());
                }
                if (es9Var.e == 1 && "game_guide".equals(this.f.Y6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f1032));
                    this.t1.l(this.g, this.U0);
                } else if (es9Var.d == 1 && "game_news".equals(this.f.Y6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f1031));
                    this.t1.l(this.g, this.U0);
                }
            }
            g2(es9Var);
            int i8 = this.c;
            if (i8 == -1) {
                i8 = c1();
            }
            this.c = i8;
            this.o.removeFooterView(this.M1.a());
            if (!ListUtils.isEmpty(es9Var.H()) && es9Var.y().b() == 0) {
                this.o.removeFooterView(this.e1);
                this.M1.d(Math.max(this.y0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.M1.a());
                this.M1.f(es9Var);
            }
            j3(es9Var);
            if (es9Var.h0() && this.f.i0().l2() && this.f.V6() != null) {
                this.f.V6().d();
            }
            if (es9Var.f() != 3) {
                e2(es9Var);
            }
            this.B0.setText(TbSingleton.getInstance().getAdVertiComment(es9Var.q0(), es9Var.r0(), y1()));
            if (this.s != null) {
                es9 es9Var2 = this.R0;
                if (es9Var2 != null && es9Var2.k() != null && (pbFragment = this.f) != null && pbFragment.i0() != null) {
                    this.s.r(this.f.i0().b);
                }
                es9 es9Var3 = this.R0;
                if (es9Var3 != null && es9Var3.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.s.q(this.R0.O().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.s.q(null);
                }
            }
            if (this.D != null && this.R0.k() != null) {
                this.D.o(this.R0.k().getSpritePBGuide(), this.R0.k().getImage_url(), this.R0.k().getId());
            }
            if (b4()) {
                this.B.e(this.R0.O());
            } else {
                this.B.d(this.o);
            }
            k4(this.R0);
            e4();
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void y4(es9 es9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048819, this, new Object[]{es9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && es9Var != null && es9Var.O() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && ix9.E(pbFragment)) {
                this.x.E(this.o);
                this.w.h(this.o);
            }
            if (this.f.Y0()) {
                if (es9Var.g() != null) {
                    this.n0 = es9Var.g().d();
                    this.o0 = es9Var.g().b();
                }
                if (this.n0 == null && this.f.i0() != null && this.f.i0().S0() != null) {
                    this.n0 = this.f.i0().S0();
                }
            }
            vra X = es9Var.X();
            R3(X, es9Var);
            int i4 = 8;
            this.x.K(8);
            int i5 = 1;
            if (es9Var.x0()) {
                this.p1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.p1 = false;
                this.k.u(false);
            }
            if (this.f.U6() != null) {
                this.f.U6().w(this.p1);
            }
            if (X == null) {
                return;
            }
            this.S0 = X;
            this.x.K(0);
            this.y.e(es9Var, this.o);
            this.A.e(es9Var, this.I1, new p0(this));
            this.w.j(es9Var);
            this.v.h(es9Var, this.Q0);
            this.v.g(es9Var);
            this.x.L(this.U0, this.R0, X, this.g2);
            if (this.d1 != null) {
                if (es9Var.j0()) {
                    this.d1.getView().setVisibility(8);
                } else {
                    this.d1.getView().setVisibility(0);
                    ts9 ts9Var = new ts9(ts9.g);
                    ts9Var.b = es9Var.g;
                    ts9Var.c = this.f.r7();
                    ts9Var.e = es9Var.f;
                    ts9Var.f = es9Var.O().isQuestionThread();
                    this.d1.i(ts9Var);
                }
            }
            K4(X);
            L4(es9Var);
            SafeHandler.getInst().post(new q0(this));
            this.z.f(this.o);
            if (X.f1175T) {
                this.z.g(X.T());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.z.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            rv9 rv9Var = this.I;
            if (rv9Var != null && rv9Var.B() != null) {
                this.I.B().W(X.f1175T);
            }
            rv9 rv9Var2 = this.I;
            if (rv9Var2 != null) {
                rv9Var2.y0(X.f1175T);
            }
            MaskView maskView = this.N1;
            if (X.f1175T) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public final void z2(CallRobotEntrance callRobotEntrance, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048822, this, callRobotEntrance, z2) != null) || callRobotEntrance == null) {
            return;
        }
        AbilityConf abilityConf = callRobotEntrance.ability_conf;
        StyleConf styleConf = callRobotEntrance.style_conf;
        if (abilityConf == null) {
            return;
        }
        String str3 = abilityConf.skill_id + "=";
        if (styleConf != null && !TextUtils.isEmpty(styleConf.content)) {
            str3 = str3 + styleConf.content;
        }
        String str4 = str3;
        ThreadData threadData = null;
        es9 es9Var = this.R0;
        if (es9Var == null) {
            str = "";
        } else {
            threadData = es9Var.O();
            str = this.R0.l();
        }
        if (threadData == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(threadData.getTid());
        }
        CommonStatisticUtils.statisticBotSkillMenu(2, abilityConf.bot_uk, 4, z2, str, str4, str2);
    }

    public void z4(a05.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048824, this, cVar, z2) == null) {
            h05 h05Var = this.j0;
            if (h05Var != null) {
                h05Var.dismiss();
                this.j0 = null;
            }
            j05 j05Var = new j05(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            es9 es9Var = this.R0;
            if (es9Var != null && es9Var.O() != null && !this.R0.O().isBjh()) {
                arrayList.add(new f05(0, this.f.getPageContext().getString(R.string.save_to_emotion), j05Var));
            }
            if (!z2) {
                arrayList.add(new f05(1, this.f.getPageContext().getString(R.string.save_to_local), j05Var));
            }
            j05Var.m(arrayList);
            j05Var.r(new n0(this, cVar));
            h05 h05Var2 = new h05(this.f.getPageContext(), j05Var);
            this.j0 = h05Var2;
            h05Var2.l();
        }
    }
}
