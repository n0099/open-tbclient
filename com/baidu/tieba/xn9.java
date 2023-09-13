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
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
import com.baidu.tieba.eha;
import com.baidu.tieba.i55;
import com.baidu.tieba.lh9;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nh9;
import com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
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
import com.baidu.tieba.qm9;
import com.baidu.tieba.so9;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.AgreeMessageData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tk9;
import com.baidu.tieba.v46;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.y45;
import com.baidu.tieba.y46;
import com.baidu.tieba.ym9;
import com.baidu.tieba.z45;
import com.baidu.tieba.z95;
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
import tbclient.StyleConf;
import tbclient.StyleContentInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class xn9 {
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
    public static eha.f v2;
    public transient /* synthetic */ FieldHolder $fh;
    public so9 A;
    public ImageView A0;
    public boolean A1;
    public PbContentCollectionController B;
    public TextView B0;
    public boolean B1;
    public qm9 C;
    public WaterRippleView C0;
    public in9 C1;
    public om9 D;
    public ImageView D0;
    public NavigationBarCoverTip D1;
    public LinearLayout E;
    public AgreeView E0;
    public v46 E1;
    public TextView F;
    public ImageView F0;
    public y46 F1;
    public TextView G;
    public ImageView G0;
    public String G1;
    public ObservedChangeRelativeLayout H;
    public HeadImageView H0;
    public PermissionJudgePolicy H1;
    public gm9 I;
    public View I0;
    public boolean I1;
    public y45 J;
    public FriendBotView J0;
    public int J1;
    public z45 K;
    public es9 K0;
    public int K1;
    public View L;
    public TextView L0;
    public boolean L1;
    public EditText M;
    public TextView M0;
    public boolean M1;
    public fs9 N;
    public boolean N0;
    public ds9 N1;
    public PbListView O;
    public int O0;
    public MaskView O1;
    public as9 P;
    public BlueCircleProgressDialog P0;
    public final PbFallingView P1;
    public View Q;
    public boolean Q0;
    public RightFloatLayerView Q1;
    public View R;
    public aj9 R0;
    public final FrameLayout R1;
    public View S;
    public tha S0;
    public LinearLayout S1;

    /* renamed from: T  reason: collision with root package name */
    public View.OnClickListener f1185T;
    public int T0;
    public yp9 T1;
    public SortSwitchButton.f U;
    public int U0;
    public final Object U1;
    public TbRichTextView.z V;
    public boolean V0;
    public Runnable V1;
    public NoNetworkView.b W;
    public boolean W0;
    public CallRobotEntrance W1;
    public g55 X;
    public ViewStub X0;
    public CustomMessageListener X1;
    public View.OnClickListener Y;
    public PbInterviewStatusView Y0;
    public View.OnClickListener Y1;
    public y45 Z;
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
    public PbFragment.k3 e2;
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
    public g55 i0;
    public int i1;
    public z95.g i2;
    public final Handler j;
    public g55 j0;
    public int j1;
    public View.OnClickListener j2;
    public final nq9 k;
    public b55 k0;
    public Runnable k1;
    public final List<TbImageView> k2;
    public mq9 l;
    public boolean l0;
    public PbFakeFloorModel l1;
    public boolean l2;
    public ViewStub m;
    public boolean m0;
    public vm9 m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public String o0;
    public int o1;
    public NoNetworkView p;
    public vk9 p0;
    public boolean p1;
    public List<CustomBlueCheckRadioButton> q;
    public ScrollView q0;
    public boolean q1;
    public PbThreadPostView r;
    public EditorTools r0;
    public boolean r1;
    public tn9 s;
    public boolean s0;
    public int s1;
    public ym9 t;
    public View t0;
    public PbTopTipView t1;
    public ym9 u;
    public View u0;
    public PopupWindow u1;
    public to9 v;
    public EjectionAnimationView v0;
    public TextView v1;
    public vo9 w;
    public Button w0;
    public List<String> w1;
    public xo9 x;
    public View x0;
    public bp9 x1;
    public uo9 y;
    public View y0;
    public tl9 y1;
    public wo9 z;
    public LinearLayout z0;
    public PbLandscapeListView.c z1;

    public boolean C2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? R.id.obfuscated_res_0x7f091acc : invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048811, this)) == null) ? R.id.obfuscated_res_0x7f091f50 : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* loaded from: classes8.dex */
        public class a implements pi5 {
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

            @Override // com.baidu.tieba.pi5
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

        public b(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.U3();
            ri5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.g3();
            this.a.v0.l();
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ym9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ xn9 b;

        /* loaded from: classes8.dex */
        public class a implements gi9 {
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

            @Override // com.baidu.tieba.gi9
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

            @Override // com.baidu.tieba.gi9
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

        public i(xn9 xn9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = pbFragment;
        }

        @Override // com.baidu.tieba.ym9.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (YunDialogManager.isShowingDialog()) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("BotGuideManager", "底bar点击引导未展示,云弹窗正在展示：" + YunDialogManager.getShowingDialog());
                } else if (ji9.c()) {
                    DefaultLog.getInstance().e("BotGuideManager", "底bar点击引导未展示,BotGuideManager在展示其他");
                } else {
                    long j = SharedPrefHelper.getInstance().getLong("pb_friend_bot_bottom_click_last_time", 0L);
                    if (!DateUtils.isToday(j) && !this.b.U2()) {
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
                                ji9.e(str, this.b.J0, this.a.e0(), new a(this, str));
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
                    defaultLog4.e("BotGuideManager", "底bar点击引导未展示,当天已经展示过了：" + DateUtils.isToday(j) + "，话题在展示：" + this.b.U2());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements ym9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* loaded from: classes8.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.e0() != null) {
                    o55.g(Collections.singletonList(new un9(this.a.a.f.e0(), this.a.a.s)));
                }
            }
        }

        public j(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.ym9.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.W0 && !this.a.f.R7() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ xn9 g;

        /* loaded from: classes8.dex */
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

        public l(xn9 xn9Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = xn9Var;
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
                    int y1 = this.g.y1(this.b);
                    int i3 = this.a;
                    int i4 = y1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = y1 - i;
                    }
                    if (this.g.e1 == null || (layoutParams = this.g.e1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && y1 < this.g.g.getMeasuredHeight()) {
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

    /* loaded from: classes8.dex */
    public class n implements qm9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* loaded from: classes8.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.D != null && this.b.a.f.e0() != null) {
                    this.b.a.D.q(this.a);
                    o55.g(Collections.singletonList(new rm9(this.b.a.f.e0(), this.b.a.D)));
                }
            }
        }

        public n(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.qm9.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.R7() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* loaded from: classes8.dex */
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

        public w0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
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

    /* loaded from: classes8.dex */
    public class a implements zj9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        @Override // com.baidu.tieba.zj9
        public /* synthetic */ void onStart() {
            yj9.a(this);
        }

        public a(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.zj9
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.v0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public a0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.N0 != null && this.a.f.N0.e() != null) {
                if (!this.a.f.N0.e().e()) {
                    this.a.f.N0.a(false);
                }
                this.a.f.N0.e().l(false);
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
                    xn9 xn9Var = this.a;
                    xn9Var.x1 = new bp9(xn9Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.w1)) {
                        this.a.x1.q(this.a.w1);
                    }
                    this.a.x1.r(this.a.r0);
                }
                this.a.x1.p(substring);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a1 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public a1(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String x1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.X() != null && this.a.f.X().b2()) {
                    x1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    x1 = this.a.x1();
                }
                if (!StringUtils.isNull(x1) && this.a.R0 != null) {
                    x1 = TbSingleton.getInstance().getAdVertiComment(this.a.R0.q0(), this.a.R0.r0(), x1);
                }
                if (this.a.f != null && this.a.f.E6() != null) {
                    this.a.f.E6().d0(x1);
                }
                if (this.a.B0 != null) {
                    this.a.B0.setText(x1);
                }
                this.a.c4(false);
                this.a.w4();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b0 implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ xn9 b;

        public b0(xn9 xn9Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.b.X.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.N2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.e2 != null) {
                            this.b.e2.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.O6(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.S4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;
        public final /* synthetic */ xn9 b;

        public b1(xn9 xn9Var, mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = mc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.Q1.setHomePbFloatLastCloseTime();
                this.b.N1();
                this.b.Q1.t(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public c(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.E0 != null && this.a.E0.getData() != null) {
                xn9 xn9Var = this.a;
                xn9Var.a3(xn9Var.E0.getData(), this.a.E0.getData().agreeNum);
                if (!this.a.E0.J()) {
                    xn9 xn9Var2 = this.a;
                    xn9Var2.T2(xn9Var2.E0);
                }
                if (this.a.R0 != null && this.a.R0.O() != null && this.a.R0.O().isExcellentThread() && BreatheTipWidget.f()) {
                    gg5.a("c15279", this.a.R0.Q(), this.a.R0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c0 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c1 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ xn9 b;

        public c1(xn9 xn9Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.L1 && this.a != null && this.b.f.X() != null && this.b.f.X().f2()) {
                    this.b.L1 = true;
                    this.a.N5(false);
                }
                if (this.b.M1) {
                    return;
                }
                this.b.M1 = true;
                if (this.b.k2() && this.b.B != null) {
                    this.b.B.h();
                    this.b.B.g(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public d(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.W1()) {
                        return;
                    }
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1185T.onClick(view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ xn9 c;

        public d0(xn9 xn9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xn9Var;
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
                    BdUtilHelper.showToast(this.c.f.e0(), (int) R.string.obfuscated_res_0x7f0f0e40);
                } else {
                    this.c.f.a6(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d1 implements tk9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public d1(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.tk9.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.S6();
            }
        }

        @Override // com.baidu.tieba.tk9.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public e(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
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
                    this.a.f.P5(sparseArray);
                    return;
                }
                this.a.S2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.P5(sparseArray);
            } else if (z3) {
                this.a.N2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public e0(xn9 xn9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, alertDialog};
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

    /* loaded from: classes8.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ xk5 b;
        public final /* synthetic */ xn9 c;

        public e1(xn9 xn9Var, ReplyPrivacyCheckController replyPrivacyCheckController, xk5 xk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, replyPrivacyCheckController, xk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xn9Var;
            this.a = replyPrivacyCheckController;
            this.b = xk5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.o6() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.o6().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.N4();
                this.b.o0();
                this.c.K0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public f(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ xn9 c;

        public f0(xn9 xn9Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xn9Var;
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
                    BdUtilHelper.showToast(this.c.f.e0(), (int) R.string.obfuscated_res_0x7f0f0e40);
                } else {
                    this.c.f.a6(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public f1(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H2();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public g(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, thaVar) == null) {
                this.a.l1.d0(thaVar);
                this.a.I.f0();
                this.a.m1.g();
                this.a.r0.t();
                this.a.c4(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements eha.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.eha.f
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public h(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.w4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.P1.setTag(Boolean.FALSE);
                if (this.a.Q1 == null) {
                    return;
                }
                this.a.Q1.setAutoCompleteShown(false);
                if (this.a.Q1.getVisibility() == 0) {
                    this.a.Q1.setTag(this.a.P1);
                    this.a.Q1.c();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public h0(xn9 xn9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, alertDialog};
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

    /* loaded from: classes8.dex */
    public class i0 implements v46.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y45 a;
        public final /* synthetic */ xn9 b;

        public i0(xn9 xn9Var, y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, y45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = y45Var;
        }

        @Override // com.baidu.tieba.v46.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.b6(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements y46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ xn9 b;

        public j0(xn9 xn9Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.y46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.a6(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(xn9 xn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Integer.valueOf(i)};
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
            this.a = xn9Var;
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

    /* loaded from: classes8.dex */
    public class k0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public k0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
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

    /* loaded from: classes8.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public l0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.b0 instanceof Dialog)) {
                kg.b(this.a.b0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements nh9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public m(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.nh9.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.X() != null) {
                    this.a.f.X().n3();
                }
                if (this.a.W1 != null) {
                    this.a.J0.k(this.a.W1);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07fa);
                }
                xp9.d(str, str2, str3, 3);
                this.a.I.f0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m0 implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45.c a;
        public final /* synthetic */ xn9 b;

        public m0(xn9 xn9Var, z45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n0 implements i55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45.c a;
        public final /* synthetic */ xn9 b;

        public n0(xn9 xn9Var, z45.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.i55.f
        public void G0(i55 i55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, i55Var, i, view2) == null) {
                this.b.j0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public o(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.I0.getVisibility() == 0) {
                    SharedPrefHelper.getInstance().putBoolean("pb_share_red_dot_shown", true);
                    this.a.I0.setVisibility(8);
                }
                this.a.f1185T.onClick(this.a.G0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public o0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
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
                if (this.a.f.e0() != null) {
                    this.a.f.e0().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
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

    /* loaded from: classes8.dex */
    public class p0 implements so9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public p0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.so9.a
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

    /* loaded from: classes8.dex */
    public class q implements FriendBotView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public q(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.G4(3, 4, z);
            this.a.Y3();
        }

        @Override // com.baidu.tbadk.core.view.FriendBotView.f
        public void b(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) != null) || xw5.a()) {
                return;
            }
            this.a.G4(2, 4, z);
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.a.f.getContext());
            } else if (z2) {
                this.a.Y3();
            } else if (!z) {
                if (this.a.W1.ability_conf == null) {
                    return;
                }
                xn9 xn9Var = this.a;
                xn9Var.s0(str, xn9Var.W1.ability_conf.bot_uk, this.a.W1.ability_conf.skill_id.intValue());
            } else {
                xp9.e(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public q0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            xn9 xn9Var;
            nq9 nq9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.I != null && (nq9Var = (xn9Var = this.a).k) != null && nq9Var.k != null && xn9Var.R0 != null && this.a.R0.O() != null && !this.a.R0.O().isVideoThreadType() && !this.a.n2() && this.a.R0.k() != null && !ei.isEmpty(this.a.R0.k().getName())) {
                if ((this.a.I.L() == null || !this.a.I.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements lh9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public r(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.lh9.b
        public void a(@NonNull CallRobotEntrance callRobotEntrance) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, callRobotEntrance) != null) || this.a.J0 == null) {
                return;
            }
            boolean o = this.a.J0.o();
            this.a.s2(callRobotEntrance, o);
            if (o) {
                xp9.e(this.a.J0.getLoadingToast());
                return;
            }
            AbilityConf abilityConf = callRobotEntrance.ability_conf;
            if (abilityConf == null) {
                return;
            }
            BotEntranceManager.h().m(abilityConf.bot_uk, abilityConf.skill_id.intValue());
            this.a.W1 = callRobotEntrance;
            StyleConf styleConf = callRobotEntrance.style_conf;
            if (styleConf != null) {
                this.a.J0.setCallRobotEntranceData(new v15(callRobotEntrance, styleConf.day, styleConf.dark, false));
            }
            this.a.O4();
            xn9 xn9Var = this.a;
            xn9Var.s0(xn9Var.J0.getLoadingToast(), abilityConf.bot_uk, abilityConf.skill_id.intValue());
        }
    }

    /* loaded from: classes8.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;
        public final /* synthetic */ xn9 b;

        public r0(xn9 xn9Var, mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = mc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.R0 != null && this.b.Q1 != null) {
                this.b.Q1.g(this.a);
                this.b.Q1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements gi9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xn9 b;

        public s(xn9 xn9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.gi9
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

        @Override // com.baidu.tieba.gi9
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

    /* loaded from: classes8.dex */
    public class s0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xn9 b;

        public s0(xn9 xn9Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xn9Var;
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
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0e40);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xn9 d;

        public t(xn9 xn9Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xn9Var;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                if (this.d.f == null) {
                    return;
                }
                this.d.f.showToast(str);
                if (this.d.f.X() != null) {
                    this.d.f.X().n3();
                }
                if (this.d.f.H6().T0() != null) {
                    this.d.f.H6().T0().f0();
                }
                if (this.d.J0 != null && this.d.W1 != null) {
                    this.d.J0.k(this.d.W1);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                super.f(r5);
                xp9.e(this.b);
                xp9.b(this.d.f.X(), this.c);
                if (this.d.V1 != null) {
                    SafeHandler.getInst().removeCallbacks(this.d.V1);
                }
                xn9 xn9Var = this.d;
                xn9Var.V1 = new oh9(this.c, xn9Var.f);
                SafeHandler.getInst().postDelayed(this.d.V1, 30000L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ aj9 c;
        public final /* synthetic */ xn9 d;

        public t0(xn9 xn9Var, Parcelable parcelable, ArrayList arrayList, aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, parcelable, arrayList, aj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xn9Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = aj9Var;
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
                    this.d.O.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fff));
                    this.d.O.B();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements PbFirstFloorDoubleClickAnimation.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public u(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.pb.PbFirstFloorDoubleClickAnimation.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E0.W();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public u0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.s1) {
                    this.a.F0();
                    this.a.D2();
                }
                this.a.N0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(xn9 xn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Integer.valueOf(i)};
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
            this.a = xn9Var;
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

    /* loaded from: classes8.dex */
    public class v0 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public v0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                this.a.F0();
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public w(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.E == null) {
                    this.a.W1();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(xn9 xn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Integer.valueOf(i)};
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
            this.a = xn9Var;
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

    /* loaded from: classes8.dex */
    public class x0 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public y(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y0 implements y45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y0(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.y45.e
        public void onClick(y45 y45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                y45Var.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements ti5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xn9 a;

        public z(xn9 xn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xn9Var;
        }

        @Override // com.baidu.tieba.ti5
        public void G(si5 si5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, si5Var) == null) {
                Object obj = si5Var.c;
                if ((obj instanceof ed5) && EmotionGroupType.isSendAsPic(((ed5) obj).getType())) {
                    if (this.a.H1 == null) {
                        this.a.H1 = new PermissionJudgePolicy();
                    }
                    this.a.H1.clearRequestPermissionList();
                    this.a.H1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.H1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    ed5 ed5Var = (ed5) si5Var.c;
                    this.a.f.E6().f(ed5Var);
                    if (ed5Var.i()) {
                        this.a.f.E6().H(null, null);
                    } else {
                        this.a.f.E6().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ xn9 e;

        public z0(xn9 xn9Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xn9Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = xn9Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948306278, "Lcom/baidu/tieba/xn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948306278, "Lcom/baidu/tieba/xn9;");
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

    public void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            J4();
            this.I.g0(1);
            tn9 tn9Var = this.s;
            if (tn9Var != null) {
                tn9Var.j();
            }
            om9 om9Var = this.D;
            if (om9Var != null) {
                om9Var.g();
            }
            qm9 qm9Var = this.C;
            if (qm9Var != null) {
                qm9Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public tha a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int Z0 = Z0() - this.o.getHeaderViewsCount();
            int i2 = 0;
            if (Z0 < 0) {
                Z0 = 0;
            }
            if (this.I.A(Z0) != null && this.I.A(Z0) != tha.W0) {
                i2 = Z0 + 1;
            }
            if (!(this.I.z(i2) instanceof tha)) {
                return null;
            }
            return (tha) this.I.z(i2);
        }
        return (tha) invokeV.objValue;
    }

    public final int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i2 = 0; i2 < this.o.getData().size(); i2++) {
                    cn cnVar = this.o.getData().get(i2);
                    if (cnVar != null && cnVar.getType() == cj9.k) {
                        return i2 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            if (S3()) {
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

    public void l3() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048748, this) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            View findViewById = i2.findViewById(R.id.obfuscated_res_0x7f091abf);
            if (i2.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public void s4() {
        tha thaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048779, this) != null) || !TbadkCoreApplication.isLogin() || this.R0 == null || !this.q1 || this.p1 || this.m0 || (thaVar = this.S0) == null || thaVar.t() == null || this.S0.t().getIsLike() || this.S0.t().hadConcerned()) {
        }
    }

    public xn9(PbFragment pbFragment, View.OnClickListener onClickListener, vk9 vk9Var, SortSwitchButton.f fVar) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, vk9Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.f1185T = null;
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
        this.K1 = 0;
        this.U1 = new Object();
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
        this.f1185T = onClickListener;
        this.U = fVar;
        this.p0 = vk9Var;
        this.s1 = BdUtilHelper.getEquipmentWidth(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0718, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f090486);
        this.D1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091b3b);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f092319);
        this.R1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091f73);
        this.H = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092608);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f091956);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.Z0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070424));
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
        this.o.setOnTouchListener(this.f.N2);
        this.a = new c1(this, pbFragment);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.k = new nq9(pbFragment, this.g);
        if (this.f.x6()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916ea);
            this.m = viewStub;
            viewStub.setVisibility(0);
            mq9 mq9Var = new mq9(pbFragment);
            this.l = mq9Var;
            mq9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = BdUtilHelper.getDimens(this.f.getActivity(), R.dimen.obfuscated_res_0x7f070368);
        }
        this.Z0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new tk9(new d1(this)));
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f09299b);
        this.y0 = this.g.findViewById(R.id.obfuscated_res_0x7f091ad0);
        this.O0 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703a6);
        this.A0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090993);
        this.A0.setOnClickListener(new e1(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.E6()));
        L0();
        this.B0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ad3);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091aca);
        this.z0 = linearLayout;
        linearLayout.setOnClickListener(new f1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f090997);
        this.v0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.D0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ad1);
        this.O1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.D0.setOnClickListener(this.f1185T);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091acc);
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
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091acf);
        this.F0 = imageView;
        imageView.setOnClickListener(this.f1185T);
        if (booleanExtra) {
            this.F0.setVisibility(8);
        } else {
            this.F0.setVisibility(0);
        }
        Q1();
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091ad6);
        this.I0 = findViewById;
        if (!SharedPrefHelper.getInstance().getBoolean("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.G0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ad4);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091ad5);
        this.H0 = headImageView;
        headImageView.setIsRound(true);
        this.H0.setOnClickListener(this.Y1);
        this.G0.setOnClickListener(new d(this));
        v2();
        es9 es9Var = new es9(this.G0);
        this.K0 = es9Var;
        es9Var.m(this.H0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091ad2);
        this.M0 = textView;
        textView.setVisibility(0);
        this.L0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091acd);
        this.X0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09118b);
        this.E0.setVisibility(0);
        this.L0.setVisibility(0);
        this.v = new to9(this.f, vk9Var);
        this.x = new xo9(this.f, vk9Var, this.f1185T);
        gm9 gm9Var = new gm9(this.f, this.o);
        this.I = gm9Var;
        gm9Var.E0(this.f1185T);
        this.I.H0(this.p0);
        this.I.B0(this.V);
        this.I.D0(this.U);
        this.I.x0(this.j2);
        e eVar = new e(this);
        this.Y = eVar;
        this.I.z0(eVar);
        b2();
        U1();
        wo9 wo9Var = new wo9(this.f);
        this.z = wo9Var;
        wo9Var.f = 2;
        T1();
        R1();
        this.A.a(this.o);
        this.x.q(this.o);
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
            view2.setOnClickListener(this.f1185T);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.R;
        if (view3 != null) {
            view3.setOnClickListener(this.f1185T);
        }
        this.O.D();
        this.O.r(R.drawable.pb_foot_more_trans_selector);
        this.O.F(R.color.CAM_X0109);
        this.O.s(R.drawable.pb_foot_more_trans_selector);
        this.S = this.g.findViewById(R.id.obfuscated_res_0x7f0929d6);
        this.f.registerListener(this.d2);
        this.l1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel X = this.f.X();
        this.l1.f0(X.V(), X.R(), X.S(), X.Q(), X.W());
        vm9 vm9Var = new vm9(this.f.getPageContext(), this.l1, this.g);
        this.m1 = vm9Var;
        vm9Var.p(new f(this));
        this.m1.s(this.f.q2);
        this.l1.h0(new g(this));
        if (this.f.X() != null && !StringUtils.isNull(this.f.X().u1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.X().u1());
        }
        this.a1 = this.g.findViewById(R.id.obfuscated_res_0x7f091ad8);
        this.b1 = this.g.findViewById(R.id.obfuscated_res_0x7f090484);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f092325);
        this.c1 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.X() != null && this.f.X().d1()) {
            this.a1.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.c1.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = m2;
            this.c1.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091b5b));
        this.d1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.d0);
        this.d1.g.setVisibility(8);
        this.d1.r(this.f1185T);
        this.d1.q(this.U);
        this.f.registerListener(this.a2);
        PbFragment pbFragment3 = this.f;
        this.N1 = new ds9(pbFragment3, pbFragment3.getUniqueId());
        this.P1 = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090ae9);
        p3();
        this.P1.setAnimationListener(new h(this));
        A0();
        this.u0 = this.g.findViewById(R.id.obfuscated_res_0x7f091ac0);
        z0(YoungsterVerifyUtils.isYoungsterOpen());
        this.s = new tn9(this.f.e0(), (ViewGroup) E1().findViewById(R.id.obfuscated_res_0x7f091b6e));
        ym9 ym9Var = new ym9(this.o, -2);
        this.u = ym9Var;
        ym9Var.d(new i(this, pbFragment));
        ym9 ym9Var2 = new ym9(this.o, 5);
        this.t = ym9Var2;
        ym9Var2.d(new j(this));
        this.S1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09285f);
        this.T1 = new yp9(this.f.getActivity());
        Y1();
        hu6.b().a(this.U1, new nh9(new m(this)));
    }

    public void A3(String str) {
        mq9 mq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (mq9Var = this.l) != null) {
            mq9Var.b(str);
        }
    }

    public final void A4(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, thaVar) == null) && thaVar != null) {
            this.B1 = !StringUtils.isNull(thaVar.g0());
            xo9 xo9Var = this.x;
            if (xo9Var != null) {
                xo9Var.t(thaVar);
            }
        }
    }

    public void B3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.n1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.o1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void C3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zVar) == null) {
            this.V = zVar;
            this.I.B0(zVar);
            this.y1.p(this.V);
        }
    }

    public void D3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            this.W = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.addNetworkChangeListener(bVar);
            }
        }
    }

    public void D4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void E3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void F3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void G2(fn fnVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, fnVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = fnVar;
            pbLandscapeListView.W = true;
        }
    }

    public void G3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.I.F0(onClickListener);
        }
    }

    public void H3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.J1 = i2;
        }
    }

    public void I3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onLongClickListener) == null) {
            this.x.I(onLongClickListener);
            this.I.C0(onLongClickListener);
            tl9 tl9Var = this.y1;
            if (tl9Var != null) {
                tl9Var.q(onLongClickListener);
            }
        }
    }

    public void K4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
            this.l0 = z2;
        }
    }

    public void O3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z2) == null) {
            this.x.K(z2);
        }
    }

    public void Q3(int i2) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i2) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void R3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, list) == null) {
            this.w1 = list;
            bp9 bp9Var = this.x1;
            if (bp9Var != null) {
                bp9Var.q(list);
            }
        }
    }

    public void S2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        R2(sparseArray, false);
    }

    public void T4(aj9 aj9Var) {
        to9 to9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, aj9Var) == null) && (to9Var = this.v) != null) {
            to9Var.h(aj9Var, this.Q0);
        }
    }

    public void b4(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            View view2 = this.t0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public final boolean f2(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048723, this, aj9Var)) == null) {
            return wn9.w(aj9Var);
        }
        return invokeL.booleanValue;
    }

    public void n3(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048756, this, str) == null) && (pbListView = this.O) != null) {
            pbListView.H(str);
        }
    }

    public final int q1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048766, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.Y0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void q3(PbFragment.k3 k3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, k3Var) == null) {
            this.e2 = k3Var;
        }
    }

    public final void r0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, view2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
            layoutParams.addRule(11);
            view2.setLayoutParams(layoutParams);
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z2) == null) {
            this.s0 = z2;
        }
    }

    public void s3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z2) == null) {
            this.I.o0(z2);
        }
    }

    public void t3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048783, this, z2) == null) {
            this.I1 = z2;
        }
    }

    public boolean u0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048785, this, z2)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                this.r0.t();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void u3(boolean z2) {
        gm9 gm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048788, this, z2) == null) && (gm9Var = this.I) != null) {
            gm9Var.p0(z2);
        }
    }

    public void v3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z2) == null) {
            this.A1 = z2;
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048798, this, z2) == null) {
            this.I.r0(z2);
        }
    }

    public void x3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048803, this, z2) == null) {
            this.I.w0(z2);
        }
    }

    public void y3(z95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, gVar) == null) {
            this.i2 = gVar;
            fs9 fs9Var = this.N;
            if (fs9Var != null) {
                fs9Var.a(gVar);
            }
        }
    }

    public void z3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, onClickListener) == null) {
            this.j2 = onClickListener;
            gm9 gm9Var = this.I;
            if (gm9Var != null) {
                gm9Var.x0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void C4(aj9 aj9Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048590, this, aj9Var, z2) != null) || aj9Var == null) {
            return;
        }
        Q4(aj9Var, z2);
        I0();
    }

    public final void J3(tha thaVar, aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, thaVar, aj9Var) == null) {
            this.x.J(thaVar, aj9Var);
        }
    }

    public void V2(AdverSegmentData adverSegmentData, int i2) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048683, this, adverSegmentData, i2) == null) && (pbFallingView = this.P1) != null) {
            pbFallingView.A(adverSegmentData, this.f.getPageContext(), i2, false);
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            tl9 tl9Var = new tl9(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0917af));
            this.y1 = tl9Var;
            tl9Var.n(this.f1185T);
            this.y1.o(this.Y);
            this.y1.p(this.V);
            this.y1.n(this.f1185T);
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
            I1();
            g55 g55Var = this.i0;
            if (g55Var != null) {
                g55Var.dismiss();
            }
            J0();
            y45 y45Var = this.J;
            if (y45Var != null) {
                y45Var.dismiss();
            }
            z45 z45Var = this.K;
            if (z45Var != null) {
                z45Var.e();
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            y45 y45Var = this.Z;
            if (y45Var != null) {
                y45Var.dismiss();
            }
            Dialog dialog = this.a0;
            if (dialog != null) {
                kg.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.b0;
            if (dialog2 != null) {
                kg.b(dialog2, this.f.getPageContext());
            }
            g55 g55Var = this.X;
            if (g55Var != null) {
                g55Var.dismiss();
            }
        }
    }

    public final void N4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (pbFragment = this.f) != null && pbFragment.E6() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.E6().z())));
        }
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.J0 = (FriendBotView) this.g.findViewById(R.id.obfuscated_res_0x7f091ace);
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.X() != null) {
                this.J0.setTid(this.f.X().P());
            }
            this.J0.l();
        }
    }

    public final void R4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048665, this) != null) || !this.f.x6()) {
            return;
        }
        if (this.f.C6() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
        if (this.f.B6() == -1) {
            SkinManager.setViewTextColor(this.G, R.color.CAM_X0110, 1);
        }
    }

    public final boolean T3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.X().r1().k().getDeletedReasonInfo() == null || 1 != this.f.X().r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048694, this) != null) || this.f.u1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        n nVar = new n(this);
        this.D = new om9(this.f.e0());
        this.C = new qm9(this.o, nVar);
    }

    public final void g3() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048728, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.C0) == null) {
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

    public void h3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048732, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.A.d(pbLandscapeListView);
            this.w.h(this.o);
            this.x.G(this.o);
            this.y.d(this.o);
            this.v.f(this.o);
        }
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
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

    public boolean n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048755, this)) == null) {
            aj9 aj9Var = this.R0;
            if (aj9Var == null || aj9Var.k() == null || "0".equals(this.R0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.R0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048763, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.H6() != null && this.f.H6().R0 != null && this.f.H6().R0.K() != null) {
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

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            PbListView pbListView = this.O;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.O.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048799, this) == null) {
            PbFallingView pbFallingView = this.P1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.Q1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.P1) {
                this.Q1.setTag(null);
                this.Q1.setAutoCompleteShown(true);
                this.Q1.d();
            }
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048801, this)) == null) {
            if (!ei.isEmpty(this.G1)) {
                return this.G1;
            }
            if (this.f != null) {
                this.G1 = TbadkCoreApplication.getInst().getResources().getString(wn9.g());
            }
            return this.G1;
        }
        return (String) invokeV.objValue;
    }

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public View B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public PbThreadPostView C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.H;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void E4() {
        yp9 yp9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (yp9Var = this.T1) != null && (linearLayout = this.S1) != null) {
            yp9Var.c(linearLayout);
        }
    }

    public void F1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            nq9 nq9Var = this.k;
            if (nq9Var != null && (view2 = nq9Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void F4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f.showProgressBar();
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.k.f();
            g55 g55Var = this.i0;
            if (g55Var != null) {
                g55Var.dismiss();
            }
            J0();
            y45 y45Var = this.J;
            if (y45Var != null) {
                y45Var.dismiss();
            }
            z45 z45Var = this.K;
            if (z45Var != null) {
                z45Var.e();
            }
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || this.y0 == null) {
            return;
        }
        this.x0.setVisibility(8);
        this.y0.setVisibility(8);
        this.N0 = false;
    }

    public void H0() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (es9Var = this.K0) != null) {
            es9Var.k(false);
        }
    }

    public final void H4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !p2()) {
            return;
        }
        G4(1, 4, this.J0.o());
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
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (editorTools = this.r0) != null) {
            editorTools.q();
            bp9 bp9Var = this.x1;
            if (bp9Var != null) {
                bp9Var.m();
            }
        }
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.I.g0(2);
            J2();
            t2();
            U4();
            H4();
            x0();
            qm9 qm9Var = this.C;
            if (qm9Var != null) {
                qm9Var.k();
            }
        }
    }

    public void I4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (pbFallingView = this.P1) != null) {
            pbFallingView.C();
        }
    }

    public void J1() {
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (nq9Var = this.k) != null) {
            nq9Var.k();
        }
    }

    public final void J2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (pbFragment = this.f) != null && pbFragment.E6() != null) {
            this.f.E6().F();
        }
    }

    public void J4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048625, this) == null) && this.k2 != null) {
            while (this.k2.size() > 0) {
                TbImageView remove = this.k2.remove(0);
                if (remove != null) {
                    remove.stopLoading();
                }
            }
        }
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

    public void K1() {
        BlueCircleProgressDialog blueCircleProgressDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (blueCircleProgressDialog = this.P0) != null) {
            blueCircleProgressDialog.setDialogVisiable(false);
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
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            if (this.E == null) {
                W1();
            }
            this.n.setVisibility(8);
            Handler handler = this.b2;
            if (handler != null && (runnable = this.c2) != null) {
                handler.removeCallbacks(runnable);
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
            K1();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.S.setVisibility(8);
        }
    }

    public void M3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            BdUtilHelper.hideSoftKeyPad(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
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
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (rightFloatLayerView = this.Q1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.O.D();
            this.O.U();
        }
    }

    public void O1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (editorTools = this.r0) != null) {
            editorTools.t();
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
        yp9 yp9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && (yp9Var = this.T1) != null) {
            yp9Var.a();
        }
    }

    public void Q0() {
        FriendBotView friendBotView;
        CallRobotEntrance callRobotEntrance;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048656, this) == null) && (friendBotView = this.J0) != null && (callRobotEntrance = this.W1) != null) {
            friendBotView.k(callRobotEntrance);
        }
    }

    public final void R1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && this.B == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.B = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public gm9 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.I;
        }
        return (gm9) invokeV.objValue;
    }

    public final void T1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048672, this) == null) && this.A == null && (pbFragment = this.f) != null) {
            this.A = new so9(pbFragment.getContext());
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && this.w == null) {
            this.w = new vo9(this.f, this.p0);
        }
    }

    public boolean U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            tn9 tn9Var = this.s;
            if (tn9Var != null && tn9Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public FriendBotView V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.J0;
        }
        return (FriendBotView) invokeV.objValue;
    }

    public void V3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            nq9 nq9Var = this.k;
            if (nq9Var != null && (view2 = nq9Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
            }
        }
    }

    public LinearLayout W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.z0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            View view2 = this.c0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.h0;
        }
        return (String) invokeV.objValue;
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            this.x.F(this.R0, this.S0, this.q1, this.p1);
        }
    }

    public void Y3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            Z3(null);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public PbFallingView b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.P1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048707, this) == null) && this.y == null) {
            this.y = new uo9(this.f, this.f1185T);
        }
    }

    public int d1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
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

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.N0;
        }
        return invokeV.booleanValue;
    }

    public final void e3() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048720, this) == null) && (pbInterviewStatusView = this.Y0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Y0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.Y0.setLayoutParams(marginLayoutParams);
        }
    }

    public Button f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.w0;
        }
        return (Button) invokeV.objValue;
    }

    public void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048724, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.O);
            }
            this.i = 2;
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public TextView h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.x.v();
        }
        return (TextView) invokeV.objValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            es9 es9Var = this.K0;
            if (es9Var != null) {
                return es9Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void i4() {
        nq9 nq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (nq9Var = this.k) != null && !this.r1) {
            nq9Var.w();
            this.r1 = true;
        }
    }

    public PbInterviewStatusView j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) {
            return this.Y0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.h2);
        }
        return invokeV.booleanValue;
    }

    public void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            i3();
            I1();
            this.m1.g();
            c4(false);
        }
    }

    public void j4() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.A1;
        }
        return invokeV.booleanValue;
    }

    public void k3() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048744, this) != null) || (handler = this.b2) == null) {
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

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            if (this.P0 == null) {
                this.P0 = new BlueCircleProgressDialog(this.f.getPageContext());
            }
            this.P0.setDialogVisiable(true);
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return e1(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public BdTypeListView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.I.n0(this.R0, false);
            this.I.f0();
        }
    }

    public tl9 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048758, this)) == null) {
            return this.y1;
        }
        return (tl9) invokeV.objValue;
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048762, this)) == null) {
            return this.R;
        }
        return (View) invokeV.objValue;
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048764, this) == null) {
            this.P1.setFallingFeedbackListener(new a1(this));
        }
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048767, this)) == null) {
            es9 es9Var = this.K0;
            if (es9Var == null) {
                return false;
            }
            return es9Var.h();
        }
        return invokeV.booleanValue;
    }

    public View r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048771, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048772, this)) == null) {
            EditorTools editorTools = this.r0;
            if (editorTools != null && editorTools.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public PbListView s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048776, this)) == null) {
            return this.O;
        }
        return (PbListView) invokeV.objValue;
    }

    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            try {
                return Integer.parseInt(this.M.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public View u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048786, this)) == null) {
            return this.a1;
        }
        return (View) invokeV.objValue;
    }

    public void u2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            b3(this.R0);
        }
    }

    public void u4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.S.setVisibility(0);
        }
    }

    public PbFakeFloorModel v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048791, this)) == null) {
            return this.l1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void v4() {
        gm9 gm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048794, this) == null) && (gm9Var = this.I) != null) {
            gm9Var.I0();
        }
    }

    public vm9 w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048796, this)) == null) {
            return this.m1;
        }
        return (vm9) invokeV.objValue;
    }

    public void x4() {
        es9 es9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048804, this) != null) || (es9Var = this.K0) == null) {
            return;
        }
        es9Var.n(2);
    }

    public void A2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            es9 es9Var = this.K0;
            if (es9Var != null) {
                es9Var.j();
            }
            in9 in9Var = this.C1;
            if (in9Var != null) {
                in9Var.c();
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
            eha.d();
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
            hu6.b().unregister(this.U1);
            this.b2 = null;
            this.j.removeCallbacksAndMessages(null);
            this.I.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            gm9 gm9Var = this.I;
            if (gm9Var != null) {
                gm9Var.i0();
            }
            bp9 bp9Var = this.x1;
            if (bp9Var != null) {
                bp9Var.l();
            }
            xo9 xo9Var = this.x;
            if (xo9Var != null) {
                xo9Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.q(null);
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
            if (this.V1 != null) {
                SafeHandler.getInst().removeCallbacks(this.V1);
            }
            vm9 vm9Var = this.m1;
            if (vm9Var != null) {
                vm9Var.m();
            }
            ji9.d();
        }
    }

    public void D2() {
        tha thaVar;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.f == null) {
            return;
        }
        if (!this.I1 && this.J1 != 17) {
            if (this.q1 && !this.p1 && (thaVar = this.S0) != null && thaVar.t() != null) {
                int i3 = 2;
                if (this.f.I0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.p1) {
                    i3 = 1;
                }
                nr9.u("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f.getPageContext().getPageActivity(), this.S0.t().getUserId(), this.S0.t().getUserName(), this.f.X().Q0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        aj9 aj9Var = this.R0;
        if (aj9Var != null && aj9Var.k() != null && !ei.isEmpty(this.R0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.R0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.R0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.R0.k().getId()));
        }
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            N4();
            this.f.P7();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.X() != null && this.f.X().r1() != null && this.f.X().r1().O() != null && this.f.X().r1().O().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.X().M1()).param("fid", this.f.X().r1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.X().b).param("fid", this.f.X().r1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f091abf);
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
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(zfa.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new p(this));
        }
    }

    public final void U4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048680, this) == null) && (pbFragment = this.f) != null && pbFragment.X() != null && this.f.X().G != null && this.f.X().G.O() != null && this.f.X().G.O().isXiuXiuThread()) {
            ThreadData O = this.f.X().G.O();
            int i3 = 0;
            if (this.f.X().W0()) {
                i2 = 1;
            } else if (this.f.X().Z0()) {
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

    public void Z2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048699, this) != null) || (pbLandscapeListView = this.o) == null) {
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
        int y1 = y1(pbReplyTitleViewHolder);
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
        this.o.setOnLayoutListener(new l(this, y1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048795, this) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                nr9.v("c10517", this.o0, 2);
            } else if (!this.f.R5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                xk5 E6 = this.f.E6();
                if (E6 != null && (E6.y() || E6.A())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.E6().w(false, null);
                    return;
                }
                if (this.r0 != null) {
                    X1();
                }
                EditorTools editorTools = this.r0;
                if (editorTools != null) {
                    this.N0 = false;
                    if (editorTools.p(2) != null) {
                        eha.c(this.f.getPageContext(), (View) this.r0.p(2).m, false, v2);
                    }
                }
                G1();
            }
        }
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

    public void K3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048629, this, z2, postWriteCallBackData) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048780, this, absListView, i2)) == null) {
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

    public void w2(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ym9 ym9Var = this.t;
            if (ym9Var != null) {
                ym9Var.b(z2, i2);
            }
            ym9 ym9Var2 = this.u;
            if (ym9Var2 != null) {
                ym9Var2.b(z2, i2);
            }
            qm9 qm9Var = this.C;
            if (qm9Var != null) {
                qm9Var.m(this.R0.k());
                this.C.i(z2, i2);
            }
        }
    }

    public void B2(TbRichText tbRichText) {
        aj9 aj9Var;
        tha thaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, tbRichText) == null) && (aj9Var = this.R0) != null && aj9Var.F() != null && !this.R0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.R0.F().size() && (thaVar = this.R0.F().get(i2)) != null && thaVar.t() != null && !StringUtils.isNull(thaVar.t().getUserId()); i2++) {
                if (this.R0.F().get(i2).t().getUserId().equals(tbRichText.getAuthorId())) {
                    tl9 tl9Var = this.y1;
                    if (tl9Var != null && tl9Var.k()) {
                        c4(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void B4(aj9 aj9Var) {
        boolean z2;
        vo9 vo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aj9Var) == null) && !this.B1 && aj9Var != null && aj9Var.O() != null && !aj9Var.O().isVideoThreadType()) {
            ThreadData O = aj9Var.O();
            boolean z3 = false;
            if (O.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (O.getIs_top() == 1) {
                z3 = true;
            }
            xo9 xo9Var = this.x;
            if (xo9Var != null) {
                xo9Var.u(aj9Var, z2, z3);
            }
            if (O.isShowTitle() && (vo9Var = this.w) != null && vo9Var.d() != null) {
                wn9.b(this.w.d(), O.isHeadLinePost, O.isGoodThread(), O.isTopThread());
            }
            if (T0() != null) {
                T0().J0(aj9Var);
            }
        }
    }

    public void H1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048612, this, z2) == null) && this.y0 != null && this.B0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            aj9 aj9Var = this.R0;
            if (aj9Var != null && aj9Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            aj9 aj9Var2 = this.R0;
            if (aj9Var2 != null && aj9Var2.r0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.B0.setText(tbSingleton.getAdVertiComment(z3, z4, x1()));
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

    public void P4(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, aj9Var) == null) {
            if (aj9Var != null && AntiHelper.o(aj9Var.O())) {
                es9 es9Var = this.K0;
                if (es9Var != null) {
                    es9Var.k(false);
                    this.K0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.G0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.G0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            es9 es9Var2 = this.K0;
            if (es9Var2 != null && es9Var2.g()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.G0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.G0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.G0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
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
                return this.f.getString(R.string.obfuscated_res_0x7f0f0fe7);
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

    public void S4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            gm9 gm9Var = this.I;
            if (gm9Var != null) {
                gm9Var.A0(z2);
                this.I.f0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.h1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.p(z2);
            }
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                pbFragment.j8(z2);
            }
            if (z2) {
                zp9.d(this.f.getPageContext(), this.f.X(), this.f.H6());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            aj9 aj9Var = this.R0;
            if (aj9Var != null) {
                str = aj9Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void W3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048688, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f13f1, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d0, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.e0()).setTitle(R.string.musk_my_thread_confirm).setDesc(R.string.musk_my_thread_confirm_subtitle).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new f0(this, show, sparseArray));
        operateBtnConfig2.setListener(new h0(this, show));
    }

    public final void c2(aj9 aj9Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048711, this, aj9Var) == null) && (pbListView = this.O) != null && pbListView.i() != null) {
            LinearLayout i2 = this.O.i();
            if (aj9Var.y().b() == 0 && !this.f.X().W0() && !o2(aj9Var)) {
                if (this.b == null) {
                    S1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i2.addView(this.b);
                ForumData k2 = aj9Var.k();
                k25 forumShowInfo = k2.getForumShowInfo();
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

    public void m3(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, editorTools) == null) {
            this.r0 = editorTools;
            editorTools.setOnCancelClickListener(new y(this));
            this.r0.setId(R.id.obfuscated_res_0x7f091acb);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.r0.getParent() == null) {
                this.g.addView(this.r0, layoutParams);
            }
            this.r0.z(TbadkCoreApplication.getInst().getSkinType());
            this.r0.setActionListener(24, new z(this));
            I1();
            this.f.E6().g(new a0(this));
        }
    }

    public void x2(AgreeMessageData agreeMessageData) {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048802, this, agreeMessageData) == null) && agreeMessageData != null && agreeMessageData.agreeData != null && (aj9Var = this.R0) != null && aj9Var.O() != null && this.R0.O().getAgreeData() != null) {
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
            a3(agreeData2, agreeData2.agreeNum);
        }
    }

    public void z4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048814, this, z2) == null) && this.o != null && (textView = this.Z0) != null && this.h != null) {
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
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + q1(true);
                this.Z0.setLayoutParams(layoutParams2);
            }
            e3();
        }
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.l2) {
            TiebaStatic.log("c10490");
            this.l2 = true;
            y45 y45Var = new y45(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(q2));
            y45Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            y45Var.setContentView(inflate);
            y45Var.setYesButtonTag(sparseArray);
            y45Var.setPositiveButton(R.string.grade_button_tips, this.f);
            y45Var.setNegativeButton(R.string.look_again, new x0(this));
            y45Var.create(this.f.getPageContext()).show();
        }
    }

    public final void O4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            if (ji9.c()) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,BotGuideManager在展示其他");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_long_click_shown", false)) {
                DefaultLog.getInstance().e("BotGuideManager", "新手长按引导未展示,长按引导已经展示过");
            } else if (SharedPrefHelper.getInstance().getBoolean("pb_friend_bot_bottom_new_user_shown", false) && (pbFragment = this.f) != null) {
                BaseFragmentActivity baseFragmentActivity = pbFragment.getBaseFragmentActivity();
                if (baseFragmentActivity != null && this.J0 != null) {
                    String string = baseFragmentActivity.getString(R.string.obfuscated_res_0x7f0f0ff2);
                    ji9.e(string, this.J0, baseFragmentActivity, new s(this, string));
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

    public final void U3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
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

    public final void t2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048782, this) == null) && (pbFragment = this.f) != null && pbFragment.X() != null && this.f.X().G != null && this.f.X().G.O() != null && this.f.X().G.O().isQuestionThread()) {
            ThreadData O = this.f.X().G.O();
            String E1 = this.f.X().E1();
            String F1 = this.f.X().F1();
            int i2 = 5;
            if ("question_answer_invite".equals(E1)) {
                i2 = 1;
            } else if ("3".equals(F1)) {
                i2 = 2;
            } else if ("answer_top".equals(E1)) {
                i2 = 3;
            } else if (this.f.X().W0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i2));
        }
    }

    public final void y0() {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048805, this) == null) && this.B != null && (aj9Var = this.R0) != null && aj9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.w.b().getVisibility() == 0) {
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

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            y45 y45Var = new y45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            y45Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(o2, Integer.valueOf(r2));
            y45Var.setYesButtonTag(sparseArray);
            y45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f184b, this.f);
            y45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new y0(this));
            y45Var.create(this.f.getPageContext()).show();
        }
    }

    public void M4(zi9 zi9Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048640, this, zi9Var) != null) || zi9Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(zi9Var.b)) {
            this.k.y(zi9Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1663);
        int i2 = JavaTypesHelper.toInt(zi9Var.a, 0);
        if (i2 != 100) {
            if (i2 != 300) {
                if (i2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15cd);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0336);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1374);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new s0(this, zi9Var.c));
    }

    public void T2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048673, this, view2) == null) && this.E0.getData() != null && this.E0.getData().hasAgree && this.f.getActivity() != null) {
            PbFirstFloorDoubleClickAnimation pbFirstFloorDoubleClickAnimation = new PbFirstFloorDoubleClickAnimation(this.f.getContext());
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070901);
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

    public final boolean f4(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048725, this, aj9Var)) == null) {
            if (aj9Var == null || aj9Var.O() == null) {
                return false;
            }
            if (aj9Var.O().getIsLive() != 1 && aj9Var.O().getThreadType() != 33 && ((aj9Var.O().getTopicData() == null || aj9Var.O().getTopicData().a() == 0) && aj9Var.O().getIs_top() != 1 && aj9Var.O().getIs_good() != 1 && !aj9Var.O().isActInfo() && !aj9Var.O().isInterviewLive() && !aj9Var.O().isVoteThreadType() && aj9Var.O().getYulePostActivityData() == null && ei.isEmpty(aj9Var.O().getCategory()) && !aj9Var.O().isGodThread() && !aj9Var.O().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.K1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0() {
        ds9 ds9Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (ds9Var = this.N1) == null) {
            return;
        }
        if (this.o != null && ds9Var.a() != null && this.N1.a().getParent() != null) {
            i2 = this.o.getPositionForView(this.N1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.N1.a().getTop() + t2 <= this.a1.getBottom()) {
                this.K1 = 1;
                z2 = true;
            } else {
                this.K1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1;
        if (this.K1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.u(z3);
        this.N1.e(z2);
    }

    public void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.f.hideProgressBar();
            aj9 aj9Var = this.R0;
            if (aj9Var != null && this.O != null && aj9Var.y() != null && this.R0.y().b() == 0) {
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

    public final boolean S3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            aj9 aj9Var = this.R0;
            if (aj9Var != null && aj9Var.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.f != null && this.w.b() != null && this.w.b().getVisibility() == 0 && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048686, this) != null) || !this.f.x6()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f0916e5);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.E == null) {
            this.E = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0916e4);
            vt5.a(this.f.getPageContext(), this.E);
        }
        if (this.F == null) {
            this.F = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916e9);
        }
        if (this.G == null) {
            this.G = (TextView) this.E.findViewById(R.id.obfuscated_res_0x7f0916e8);
        }
        this.F.setOnClickListener(this.f1185T);
        this.G.setOnClickListener(this.f1185T);
    }

    public final void W2() {
        nq9 nq9Var;
        aj9 aj9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048687, this) == null) && this.w != null && (nq9Var = this.k) != null && nq9Var.j() != null && (aj9Var = this.R0) != null && aj9Var.O() != null && this.R0.O().isQuestionThread() && this.w.b() != null && this.w.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.w.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.w.b().getHeight();
            if (this.w.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            nq9 nq9Var2 = this.k;
            if (height > nq9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            nq9Var2.z(z3, this.R0.O().getSpan_str());
        }
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            if (this.f != null && this.r0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.r0.j();
                G1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int Z0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
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

    public final void i3() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && (pbFragment = this.f) != null && pbFragment.E6() != null && this.r0 != null) {
            sk5.a().c(0);
            xk5 E6 = this.f.E6();
            E6.N();
            E6.L();
            if (E6.v() != null) {
                WriteImagesInfo v3 = E6.v();
                if (E6.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v3.setMaxImagesAllowed(i2);
            }
            E6.e0(SendView.h);
            E6.h(SendView.h);
            aj5 o3 = this.r0.o(23);
            aj5 o4 = this.r0.o(2);
            aj5 o5 = this.r0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.r0.invalidate();
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
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

    public final void x0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048800, this) == null) {
            if (S3() && this.R0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.R0.O().getTid()).addParam("obj_param1", this.R0.O().getThreadRecommendInfoDataList().get(0).businessId);
                int i2 = this.R0.O().getThreadRecommendInfoDataList().get(0).albumType;
                if (i2 != -1) {
                    addParam.addParam("obj_type", i2);
                }
                addParam.eventStat();
            }
            if (k2() && (pbContentCollectionController = this.B) != null) {
                pbContentCollectionController.h();
                this.B.g(true);
            }
        }
    }

    public void E2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            if (z2) {
                i4();
            } else {
                J1();
            }
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            X2(this.h1.a, false);
        }
    }

    public void L4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
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

    public void a2(aj9 aj9Var) {
        mc5 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048703, this, aj9Var) != null) || aj9Var == null) {
            return;
        }
        if (aj9Var.q0()) {
            pbAdFloatViewItemData = aj9Var.b0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            Z1(aj9Var, pbAdFloatViewItemData);
        } else {
            N1();
        }
    }

    public void c4(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048713, this, z2) != null) || this.y0 == null) {
            return;
        }
        if (this.f.E6() != null && this.f.E6().z()) {
            z3 = true;
        } else {
            z3 = false;
        }
        r3(z3);
        if (this.s0) {
            g4(z2);
        } else {
            H1(z2);
        }
    }

    public void g4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048729, this, z2) == null) && this.y0 != null && (textView = this.B0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f060a);
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

    public final boolean l2(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        tha X;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048747, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                aj9 aj9Var = this.R0;
                if (aj9Var != null && (X = aj9Var.X()) != null && X.t() != null) {
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

    public final boolean o2(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048759, this, aj9Var)) == null) {
            if (aj9Var == null) {
                return true;
            }
            ArrayList<tha> F = aj9Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((tha) ListUtils.getItem(F, 0)).L() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int y1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048806, this, pbReplyTitleViewHolder)) == null) {
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

    public void z2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048812, this, configuration) != null) || configuration == null) {
            return;
        }
        F0();
        if (configuration.orientation == 2) {
            G1();
            I1();
        } else {
            j3();
        }
        vm9 vm9Var = this.m1;
        if (vm9Var != null) {
            vm9Var.g();
        }
        this.f.S6();
        this.H.setVisibility(8);
        this.k.v(false);
        this.f.k8(false);
    }

    public final void G4(int i2, int i3, boolean z2) {
        String str;
        AbilityConf abilityConf;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            CallRobotEntrance callRobotEntrance = this.W1;
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

    public void K2(AbsListView absListView, int i2, int i3, int i4) {
        boolean z2;
        PbListView pbListView;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048628, this, absListView, i2, i3, i4) == null) {
            ym9 ym9Var = this.u;
            if (ym9Var != null) {
                ym9Var.c(i2, i3);
            }
            ym9 ym9Var2 = this.t;
            if (ym9Var2 != null) {
                ym9Var2.c(i2, i3);
            }
            qm9 qm9Var = this.C;
            if (qm9Var != null) {
                qm9Var.l(i2, i3);
            }
            nq9 nq9Var = this.k;
            if (nq9Var != null && this.x != null) {
                nq9Var.q(absListView, i2, i3, i4);
            }
            W2();
            this.h1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
            if (t0(absListView, i2) && !this.k.o()) {
                z2 = true;
            } else {
                z2 = false;
            }
            b4(z2);
            X2(this.h1.a, false);
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
                un6.f(this.O.i(), 0);
            }
        }
    }

    public void L2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048633, this, absListView, i2) == null) {
            if (i2 == 0) {
                this.h1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.h1));
                X2(this.h1.a, true);
                E0();
                this.I.m0(true);
            }
            this.I.l0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.Q1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                y0();
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.Q1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.Q1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void a3(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048704, this, agreeData, j2) == null) && agreeData != null && (textView = this.L0) != null) {
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

    public void M2(ArrayList<r25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, arrayList) == null) {
            if (this.c0 == null) {
                this.c0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.c0);
            if (this.b0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003c9);
                this.b0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.b0.setCancelable(true);
                this.q0 = (ScrollView) this.c0.findViewById(R.id.good_scroll);
                this.b0.setContentView(this.c0);
                WindowManager.LayoutParams attributes = this.b0.getWindow().getAttributes();
                attributes.width = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703f9);
                this.b0.getWindow().setAttributes(attributes);
                this.e0 = new k0(this);
                this.d0 = (LinearLayout) this.c0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.c0.findViewById(R.id.dialog_button_cancel);
                this.g0 = textView;
                textView.setOnClickListener(new l0(this));
                TextView textView2 = (TextView) this.c0.findViewById(R.id.dialog_button_ok);
                this.f0 = textView2;
                textView2.setOnClickListener(this.f1185T);
            }
            this.d0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton B0 = B0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(B0);
            B0.setChecked(true);
            this.d0.addView(B0);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    r25 r25Var = arrayList.get(i2);
                    if (r25Var != null && !TextUtils.isEmpty(r25Var.b()) && r25Var.a() > 0) {
                        CustomBlueCheckRadioButton B02 = B0(String.valueOf(r25Var.a()), r25Var.b());
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
            kg.j(this.b0, this.f.getPageContext());
        }
    }

    public void N2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            O2(i2, str, i3, z2, null);
        }
    }

    public void d3(aj9 aj9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048716, this, new Object[]{aj9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            o4(aj9Var, z2, i2, i3);
            this.x.C(i3);
        }
    }

    public void O0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f14aa));
            } else if (z3) {
                if (ei.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e40);
                }
                this.f.showToast(str);
            }
        }
    }

    public void Q2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048658, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(o2, Integer.valueOf(p2));
            if (z2) {
                W3(sparseArray);
            } else {
                X3(i2, sparseArray);
            }
        }
    }

    public void O2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            P2(i2, str, i3, z2, str2, false);
        }
    }

    public void P2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048653, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
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
            this.Z = new y45(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Z.setMessageId(i4);
            } else {
                this.Z.setOnlyMessageShowCenter(false);
                this.Z.setMessage(str2);
            }
            this.Z.setYesButtonTag(sparseArray);
            this.Z.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, this.f);
            this.Z.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, new c0(this));
            this.Z.setCancelable(true);
            this.Z.create(this.f.getPageContext());
            if (z3) {
                e4(sparseArray, i5, i4);
            } else if (z2) {
                e4(sparseArray, i5, i4);
            } else if (T3()) {
                x46 x46Var = new x46(this.f.X().r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.X().r1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.X().r1().n().has_forum_rule.intValue());
                x46Var.i(this.f.X().r1().k().getId(), this.f.X().r1().k().getName());
                x46Var.h(this.f.X().r1().k().getImage_url());
                x46Var.j(this.f.X().r1().k().getUser_level());
                l4(sparseArray, i2, x46Var, this.f.X().r1().V(), false);
            } else {
                t4(this.Z, i2);
            }
        }
    }

    public void P3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, str) == null) {
            this.B0.performClick();
            if (!StringUtils.isNull(str) && this.f.E6() != null && this.f.E6().s() != null && this.f.E6().s().i() != null) {
                EditText i2 = this.f.E6().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void V1(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048682, this, aj9Var) != null) || aj9Var == null || aj9Var.O() == null || !aj9Var.O().isInterviewLive() || this.Y0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.X0.inflate();
        this.Y0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.f1185T);
        this.Y0.setCallback(this.f.w6());
        this.Y0.setData(this.f, aj9Var);
    }

    public void Z3(gi9 gi9Var) {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, gi9Var) == null) && (aj9Var = this.R0) != null && aj9Var.K() != null && !ListUtils.isEmpty(this.R0.K().robot_skill_info) && !ListUtils.isEmpty(this.R0.K().bottom_bar_robot_skill)) {
            lh9.a(this.J0, BotEntranceManager.e(this.R0.K().robot_skill_info, this.R0.K().bottom_bar_robot_skill), new r(this), gi9Var);
        }
    }

    public final int e1(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048718, this, i2)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            tm adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof sha)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof tm)) {
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

    public void o3(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048760, this, str) == null) && this.O != null) {
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
        if (interceptable == null || interceptable.invokeZ(1048810, this, z2) == null) {
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

    public boolean Q4(aj9 aj9Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048660, this, aj9Var, z2)) == null) {
            if (aj9Var == null) {
                return false;
            }
            if (this.w != null) {
                if (aj9Var.O() != null && aj9Var.O().getIsNoTitle() == 0 && !aj9Var.O().isVideoThreadType()) {
                    if (aj9Var.O() != null) {
                        ThreadData O = aj9Var.O();
                        O.parserSpecTitleForFrsAndPb(true, f4(aj9Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (aj9Var.O().isBJHArticleThreadType()) {
                        this.x.G(this.o);
                        this.w.h(this.o);
                        this.w.a(this.o);
                        this.x.q(this.o);
                        this.x.L(this.R0);
                        if (f2(aj9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.i(aj9Var);
                        }
                    } else {
                        this.x.L(this.R0);
                        if (f2(aj9Var)) {
                            this.w.h(this.o);
                        } else {
                            this.w.k(aj9Var);
                        }
                    }
                } else if (aj9Var.O().getIsNoTitle() == 1) {
                    if (aj9Var.O() != null) {
                        this.w.h(this.o);
                        this.x.L(this.R0);
                    }
                } else {
                    this.w.h(this.o);
                    this.x.L(this.R0);
                }
            }
            A4(aj9Var.X());
            B4(aj9Var);
            this.Q0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void X3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048692, this, i2, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.X() != null && this.f.X().r1() != null && this.f.X().r1().n() != null && this.f.X().r1().k() != null && this.f.X().r1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            x46 x46Var = new x46(this.f.X().r1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.X().r1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.X().r1().n().has_forum_rule.intValue());
            x46Var.i(this.f.X().r1().k().getId(), this.f.X().r1().k().getName());
            x46Var.h(this.f.X().r1().k().getImage_url());
            x46Var.j(this.f.X().r1().k().getUser_level());
            l4(sparseArray, i2, x46Var, this.f.X().r1().V(), true);
        }
    }

    public final void t4(y45 y45Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048784, this, y45Var, i2) == null) && (pbFragment = this.f) != null && y45Var != null) {
            if (this.E1 == null && this.v != null) {
                this.E1 = new v46(pbFragment.getPageContext(), this.v.c());
            }
            AntiData o6 = this.f.o6();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (o6 != null && o6.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = o6.getDelThreadInfoList();
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
            this.E1.C(new i0(this, y45Var));
        }
    }

    public void y4(e35 e35Var, y45.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048809, this, e35Var, eVar) != null) || e35Var == null) {
            return;
        }
        int a2 = e35Var.a();
        int h2 = e35Var.h();
        y45 y45Var = this.J;
        if (y45Var != null) {
            y45Var.show();
        } else {
            this.J = new y45(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0269, (ViewGroup) null);
            this.L = inflate;
            this.J.setContentView(inflate);
            this.J.setPositiveButton(R.string.obfuscated_res_0x7f0f059b, eVar);
            this.J.setNegativeButton(R.string.obfuscated_res_0x7f0f0590, new v0(this));
            this.J.setOnCalcelListener(new w0(this));
            this.J.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.L.findViewById(R.id.obfuscated_res_0x7f091141);
        this.M = editText;
        editText.setText("");
        TextView textView = (TextView) this.L.findViewById(R.id.obfuscated_res_0x7f09082b);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.M, 150);
    }

    public void R2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        e55 e55Var;
        e55 e55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048663, this, sparseArray, z2) == null) {
            i55 i55Var = new i55(this.f.getContext());
            i55Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f0324));
            i55Var.q(new b0(this, z2));
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
                    e55Var2 = new e55(10, this.f.getString(R.string.obfuscated_res_0x7f0f055a), i55Var);
                } else {
                    e55Var2 = new e55(10, this.f.getString(R.string.obfuscated_res_0x7f0f054b), i55Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                e55Var2.d.setTag(sparseArray2);
                arrayList.add(e55Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                e55 e55Var3 = new e55(13, this.f.getString(R.string.multi_delete), i55Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                e55Var3.d.setTag(sparseArray3);
                arrayList.add(e55Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                e55 e55Var4 = new e55(11, this.f.getString(R.string.forbidden_person), i55Var);
                e55Var4.d.setTag(sparseArray4);
                arrayList.add(e55Var4);
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
                    e55Var = new e55(12, this.f.getString(R.string.un_mute), i55Var);
                } else {
                    e55Var = new e55(12, this.f.getString(R.string.obfuscated_res_0x7f0f0d18), i55Var);
                }
                e55Var.d.setTag(sparseArray5);
                arrayList.add(e55Var);
            }
            vp9.f(arrayList);
            i55Var.m(arrayList, true);
            g55 g55Var = new g55(this.f.getPageContext(), i55Var);
            this.X = g55Var;
            g55Var.l();
        }
    }

    public final void X2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048691, this, pbReplyTitleViewHolder, z2) == null) && !this.p1 && this.a1 != null && this.k.j() != null) {
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
                b4(false);
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
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.f1) {
                    this.a1.setVisibility(0);
                    b4(false);
                } else if (top < measuredHeight) {
                    this.a1.setVisibility(0);
                    b4(false);
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

    public final void Z1(aj9 aj9Var, mc5 mc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048698, this, aj9Var, mc5Var) == null) && this.R1 != null && aj9Var != null && mc5Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                N1();
                return;
            }
            if (this.Q1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(mc5Var, this.f.getContext());
                this.Q1 = E;
                E.setPageContext(this.f.getPageContext());
                this.R1.removeAllViews();
                this.R1.addView(this.Q1);
            }
            if ((this.P1.getTag() instanceof Boolean) && !((Boolean) this.P1.getTag()).booleanValue()) {
                this.Q1.setAutoCompleteShown(false);
                this.Q1.setTag(this.P1);
                this.Q1.c();
            }
            if (mc5Var.a()) {
                return;
            }
            this.Q1.setData(mc5Var);
            this.Q1.setLogoListener(new r0(this, mc5Var));
            this.Q1.setFeedBackListener(new b1(this, mc5Var));
        }
    }

    public final void a4(aj9 aj9Var) {
        boolean z2;
        StyleContentInfo styleContentInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, aj9Var) == null) {
            if (aj9Var != null && aj9Var.K() != null) {
                RobotEntrance K = aj9Var.K();
                if (!ListUtils.isEmpty(K.robot_skill_info) && !ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                    if (!ListUtils.isEmpty(K.bottom_bar_robot_skill)) {
                        CallRobotEntrance c2 = BotEntranceManager.h().c(K.robot_skill_info, K.bottom_bar_robot_skill);
                        this.W1 = c2;
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
                            StyleConf styleConf = this.W1.style_conf;
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
                            layoutParams.addRule(0, R.id.obfuscated_res_0x7f091ace);
                            this.F0.setLayoutParams(layoutParams);
                            this.J0.setClickCallBack(this.Z1);
                            this.J0.setCallRobotEntranceData(new v15(this.W1, styleContentInfo2, styleContentInfo, z2));
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

    public final void b3(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048708, this, aj9Var) == null) && aj9Var != null && aj9Var.O() != null) {
            P4(aj9Var);
            ImageView imageView = this.F0;
            if (imageView != null && imageView.getContext() != null) {
                if (aj9Var.q()) {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String S0 = S0(aj9Var.O().getReply_num());
            TextView textView = this.M0;
            if (textView != null) {
                textView.setText(S0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, aj9Var.O()));
            a3(aj9Var.O().getAgreeData(), aj9Var.O().getAgreeNum());
            if (this.E0 != null && aj9Var.O() != null) {
                this.E0.setThreadData(aj9Var.O());
                int i2 = 1;
                if (aj9Var.O().getAgreeData() != null) {
                    aj9Var.O().getAgreeData().isInThread = true;
                }
                this.E0.setData(aj9Var.O().getAgreeData());
                h15 h15Var = new h15();
                h15Var.b = 26;
                if (aj9Var.O().isVideoThreadType() && aj9Var.O().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                h15Var.c = i2;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.X() != null) {
                    h15Var.j = this.f.X().getFromForumId();
                    h15Var.f = this.f.X().q1();
                }
                this.E0.setStatisticData(h15Var);
            }
        }
    }

    public void d2(aj9 aj9Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, aj9Var) == null) {
            int i2 = 0;
            this.I.n0(aj9Var, false);
            this.I.f0();
            I0();
            tl9 tl9Var = this.y1;
            if (tl9Var != null) {
                tl9Var.m();
            }
            ArrayList<tha> F = aj9Var.F();
            if (aj9Var.y().b() == 0 || F == null || F.size() < aj9Var.y().e()) {
                if (o2(aj9Var)) {
                    g1 g1Var = this.h1;
                    if (g1Var != null && (pbReplyTitleViewHolder = g1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.h1.a.getView().getTop() < 0) {
                            bottom = this.h1.a.getView().getHeight();
                        } else {
                            bottom = this.h1.a.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.f.c7()) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1005), i2);
                    } else {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1006), i2);
                    }
                } else {
                    if (aj9Var.y().b() == 0) {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.O.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.O.n();
                }
            }
            b3(aj9Var);
        }
    }

    public void d4(aj9 aj9Var) {
        tha thaVar;
        nq9 nq9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048717, this, aj9Var) == null) && aj9Var != null && (thaVar = this.S0) != null && thaVar.t() != null && (nq9Var = this.k) != null) {
            boolean z3 = !this.p1;
            this.q1 = z3;
            nq9Var.A(z3);
            if (this.f.F6() != null) {
                this.f.F6().s(this.q1);
            }
            Y2();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.I0() && !ListUtils.isEmpty(aj9Var.o())) {
                d45 d45Var = aj9Var.o().get(0);
                if (d45Var != null) {
                    this.k.D(aj9Var, d45Var.d(), d45Var.b(), d45Var.a(), d45Var.f());
                }
            } else if (aj9Var.k() != null) {
                nq9 nq9Var2 = this.k;
                String name = aj9Var.k().getName();
                String id = aj9Var.k().getId();
                String image_url = aj9Var.k().getImage_url();
                if (aj9Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                nq9Var2.D(aj9Var, name, id, image_url, z2);
            }
            if (this.q1) {
                this.x.Q(aj9Var, this.S0, this.m0);
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
            this.x.Q(aj9Var, this.S0, this.m0);
            this.z1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void h4(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048733, this, view2) != null) || SharedPrefHelper.getInstance().getBoolean("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f04d1);
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

    public void r4(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, onItemClickListener) == null) {
            b55 b55Var = this.k0;
            if (b55Var != null) {
                b55Var.d();
                this.k0 = null;
            }
            if (this.R0 == null) {
                return;
            }
            ArrayList<k55> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.R0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new k55(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.R0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new k55(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.R0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new k55(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.R0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new k55(string4, "", z5, Integer.toString(7)));
            b55 b55Var2 = new b55(this.f.getPageContext());
            b55Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.k0 = b55Var2;
            b55Var2.k(arrayList, onItemClickListener);
            b55Var2.c();
            this.k0.n();
        }
    }

    public void c3(int i2, aj9 aj9Var, boolean z2, int i3) {
        tha X;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048712, this, new Object[]{Integer.valueOf(i2), aj9Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && aj9Var != null && (X = aj9Var.X()) != null && X.t() != null) {
            MetaData t3 = X.t();
            t3.setGiftNum(t3.getGiftNum() + i2);
        }
    }

    public final void e4(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048721, this, sparseArray, i2, i3) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.OperateBtnConfig operateBtnConfig = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f054b, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.OperateBtnConfig operateBtnConfig2 = new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f03d0, TBAlertConfig.OperateBtnStyle.SECONDARY);
        AlertDialog show = new TBAlertBuilder(this.f.e0()).setTitle(i2).setDesc(i3).setDescLightStyle(true).setOperateBtn(operateBtnConfig2, operateBtnConfig).setCancelable(false).show();
        operateBtnConfig.setListener(new d0(this, show, sparseArray));
        operateBtnConfig2.setListener(new e0(this, show));
    }

    public final void s0(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048775, this, new Object[]{str, str2, Long.valueOf(j2)}) != null) || this.R0.O() == null) {
            return;
        }
        bi9.c();
        String c2 = xp9.c(this.R0.O().getFirstPostId(), TbadkCoreApplication.getCurrentPortrait(), System.currentTimeMillis());
        xp9.a(this.f.getPageContext(), str2, j2, this.R0.O().getTid(), this.R0.O().getFirstPostId(), c2, new t(this, str, c2));
    }

    public final void l4(SparseArray<Object> sparseArray, int i2, x46 x46Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048749, this, new Object[]{sparseArray, Integer.valueOf(i2), x46Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.F1 == null && this.v != null) {
            this.F1 = new y46(pbFragment.getPageContext(), this.v.c(), x46Var, userData);
        }
        this.F1.F(z2);
        AntiData o6 = this.f.o6();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (o6 != null && o6.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = o6.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
        negativeFeedBackData.setFeedBackReasonMap(sparseArray2);
        this.F1.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
        this.F1.G(negativeFeedBackData);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.F1.J(str);
        this.F1.I(new j0(this, sparseArray));
    }

    public void q4(z45.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048769, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            g55 g55Var = this.i0;
            if (g55Var != null) {
                g55Var.dismiss();
                this.i0 = null;
            }
            i55 i55Var = new i55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new e55(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04e5), i55Var));
            }
            if (z3) {
                arrayList.add(new e55(1, this.f.getPageContext().getString(R.string.report_text), i55Var));
            } else if (!z2) {
                arrayList.add(new e55(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c5a), i55Var));
            } else {
                arrayList.add(new e55(1, this.f.getPageContext().getString(R.string.remove_mark), i55Var));
            }
            i55Var.l(arrayList);
            i55Var.q(new m0(this, cVar));
            g55 g55Var2 = new g55(this.f.getPageContext(), i55Var);
            this.j0 = g55Var2;
            g55Var2.l();
        }
    }

    public SparseArray<Object> n1(aj9 aj9Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        tha X;
        boolean z3;
        i25 i25Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048754, this, new Object[]{aj9Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (aj9Var == null || (X = aj9Var.X()) == null) {
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
                sparseArray.put(R.id.tag_del_post_id, X.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (X.t() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, X.t().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, X.t().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, X.t().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, X.U());
                }
                sparseArray.put(R.id.tag_del_post_id, X.U());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(aj9Var.W()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<d45> o3 = aj9Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (d45 d45Var : o3) {
                        if (d45Var != null && !StringUtils.isNull(d45Var.d()) && (i25Var = d45Var.h) != null && i25Var.a && !i25Var.c && ((i3 = i25Var.b) == 1 || i3 == 2)) {
                            sb.append(ei.cutString(d45Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f077f));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0543), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void n4(aj9 aj9Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        if ((interceptable == null || interceptable.invokeCommon(1048757, this, new Object[]{aj9Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && aj9Var != null && this.o != null) {
            this.R0 = aj9Var;
            this.T0 = i2;
            if (aj9Var.O() != null) {
                this.i1 = aj9Var.O().getCopyThreadRemindType();
                this.m0 = l2(aj9Var.O());
            }
            if (aj9Var.V() != null) {
                this.h2 = aj9Var.V().getUserId();
            }
            V1(aj9Var);
            this.V0 = false;
            this.Q0 = z2;
            L3();
            lj9 lj9Var = aj9Var.h;
            if (lj9Var != null && lj9Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(aj9Var);
                    this.r.setChildOnClickLinstener(this.f1185T);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            o4(aj9Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            d4(aj9Var);
            this.x.R(aj9Var, this.S0);
            if (this.C1 == null) {
                this.C1 = new in9(this.f.getPageContext(), this.D1);
            }
            this.C1.a(aj9Var.w());
            if (this.f.x6()) {
                if (this.N == null) {
                    fs9 fs9Var = new fs9(this.f.getPageContext());
                    this.N = fs9Var;
                    fs9Var.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                fs9 fs9Var2 = this.N;
                if (fs9Var2 != null) {
                    fs9Var2.C(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (aj9Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.N == null) {
                    fs9 fs9Var3 = new fs9(this.f.getPageContext());
                    this.N = fs9Var3;
                    fs9Var3.f();
                    this.N.a(this.i2);
                }
                this.o.setPullRefresh(this.N);
                fs9 fs9Var4 = this.N;
                if (fs9Var4 != null) {
                    fs9Var4.C(TbadkCoreApplication.getInst().getSkinType());
                }
                K1();
            }
            I0();
            this.I.v0(this.Q0);
            this.I.s0(false);
            gm9 gm9Var = this.I;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            gm9Var.t0(z4);
            gm9 gm9Var2 = this.I;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            gm9Var2.u0(z5);
            gm9 gm9Var3 = this.I;
            if (z3 && this.f2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            gm9Var3.q0(z6);
            this.I.n0(aj9Var, false);
            this.I.f0();
            gm9 gm9Var4 = this.I;
            if (aj9Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            gm9Var4.h0(z7, aj9Var.f());
            this.x.P(aj9Var.X(), aj9Var.j0());
            if (aj9Var.O() != null && aj9Var.O().getPraise() != null && this.e != -1) {
                aj9Var.O().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.e1);
            this.o.addFooterView(this.e1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.O);
                this.i = 2;
                K1();
            } else {
                this.V0 = true;
                if (aj9Var.y().b() == 1) {
                    if (this.P == null) {
                        PbFragment pbFragment2 = this.f;
                        this.P = new as9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.P);
                } else {
                    this.o.setNextPage(this.O);
                }
                this.i = 3;
            }
            ArrayList<tha> F = aj9Var.F();
            if (aj9Var.y().b() != 0 && F != null && F.size() >= aj9Var.y().e()) {
                if (z3) {
                    if (this.f2) {
                        M0();
                        if (aj9Var.y().b() != 0) {
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
                if (o2(aj9Var)) {
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
                    if (this.f.c7()) {
                        this.O.y(false);
                        if (ListUtils.isEmpty(aj9Var.R())) {
                            this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1005), i5);
                        }
                    } else if (ListUtils.isEmpty(aj9Var.R())) {
                        this.O.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1006), i5);
                    }
                    if (this.f.F6() != null && !this.f.F6().p()) {
                        this.f.F6().x();
                    }
                } else {
                    if (aj9Var.y().b() == 0) {
                        tha thaVar = (tha) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (thaVar != null) {
                            thaVar.P = false;
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
                if (aj9Var.y().b() == 0 || F == null) {
                    f3();
                }
            }
            switch (i2) {
                case 2:
                    if (this.o.getData() == null && aj9Var.F() == null) {
                        size = 0;
                    } else {
                        size = (this.o.getData().size() - aj9Var.F().size()) + this.o.getHeaderViewsCount();
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
                    if (i4 == 1 && (e2 = on9.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                        this.o.post(new t0(this, e2, F, aj9Var));
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
                    if (i4 == 1 && (e3 = on9.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
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
                    } else if (ListUtils.isEmpty(aj9Var.R())) {
                        if (this.o.getData() == null && aj9Var.F() == null) {
                            size2 = 0;
                        } else {
                            size2 = (this.o.getData().size() - aj9Var.F().size()) + this.o.getHeaderViewsCount();
                        }
                        PbLandscapeListView pbLandscapeListView3 = this.o;
                        if (i3 > 0) {
                            i7 = i3 + size2;
                        } else {
                            i7 = 0;
                        }
                        pbLandscapeListView3.setSelection(i7);
                    } else {
                        this.o.setSelection(aj9Var.F().size() + this.o.getHeaderViewsCount());
                    }
                    this.O.g();
                    this.O.H(this.f.getString(R.string.obfuscated_res_0x7f0f0fff));
                    this.O.E(0);
                    this.O.B();
                    break;
            }
            if (this.i1 == n2 && j2()) {
                C0();
            }
            if (this.n1) {
                Z2();
                this.n1 = false;
                if (i4 == 0) {
                    B3(true);
                }
            }
            if (aj9Var.d == 1 || aj9Var.e == 1) {
                if (this.t1 == null) {
                    this.t1 = new PbTopTipView(this.f.getContext());
                }
                if (aj9Var.e == 1 && "game_guide".equals(this.f.J6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f1011));
                    this.t1.l(this.g, this.U0);
                } else if (aj9Var.d == 1 && "game_news".equals(this.f.J6())) {
                    this.t1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f1010));
                    this.t1.l(this.g, this.U0);
                }
            }
            c2(aj9Var);
            int i8 = this.c;
            if (i8 == -1) {
                i8 = c1();
            }
            this.c = i8;
            this.o.removeFooterView(this.N1.a());
            if (!ListUtils.isEmpty(aj9Var.H()) && aj9Var.y().b() == 0) {
                this.o.removeFooterView(this.e1);
                this.N1.d(Math.max(this.y0.getMeasuredHeight(), this.O0 / 2));
                this.o.addFooterView(this.N1.a());
                this.N1.f(aj9Var);
            }
            b3(aj9Var);
            if (aj9Var.h0() && this.f.X().j2() && this.f.G6() != null) {
                this.f.G6().d();
            }
            if (aj9Var.f() != 3) {
                a2(aj9Var);
            }
            this.B0.setText(TbSingleton.getInstance().getAdVertiComment(aj9Var.q0(), aj9Var.r0(), x1()));
            if (this.s != null) {
                aj9 aj9Var2 = this.R0;
                if (aj9Var2 != null && aj9Var2.k() != null && (pbFragment = this.f) != null && pbFragment.X() != null) {
                    this.s.r(this.f.X().b);
                }
                aj9 aj9Var3 = this.R0;
                if (aj9Var3 != null && aj9Var3.O() != null && !ListUtils.isEmpty(this.R0.O().getThreadRecommendInfoDataList()) && this.R0.O().getThreadRecommendInfoDataList().get(0) != null && this.R0.O().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.s.q(this.R0.O().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.s.q(null);
                }
            }
            if (this.D != null && this.R0.k() != null) {
                this.D.o(this.R0.k().getSpritePBGuide(), this.R0.k().getImage_url(), this.R0.k().getId());
            }
            if (S3()) {
                this.B.e(this.R0.O());
            } else {
                this.B.d(this.o);
            }
            a4(this.R0);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o4(aj9 aj9Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048761, this, new Object[]{aj9Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && aj9Var != null && aj9Var.O() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && wn9.C(pbFragment)) {
                this.x.G(this.o);
                this.w.h(this.o);
            }
            if (this.f.I0()) {
                if (aj9Var.g() != null) {
                    this.n0 = aj9Var.g().d();
                    this.o0 = aj9Var.g().b();
                }
                if (this.n0 == null && this.f.X() != null && this.f.X().Q0() != null) {
                    this.n0 = this.f.X().Q0();
                }
            }
            tha X = aj9Var.X();
            J3(X, aj9Var);
            int i4 = 8;
            this.x.M(8);
            int i5 = 1;
            if (aj9Var.x0()) {
                this.p1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.p1 = false;
                this.k.u(false);
            }
            if (this.f.F6() != null) {
                this.f.F6().w(this.p1);
            }
            if (X == null) {
                return;
            }
            this.S0 = X;
            this.x.M(0);
            this.y.e(aj9Var, this.o);
            this.A.e(aj9Var, this.J1, new p0(this));
            this.w.j(aj9Var);
            this.v.h(aj9Var, this.Q0);
            this.v.g(aj9Var);
            this.x.N(this.U0, this.R0, X, this.g2);
            if (this.d1 != null) {
                if (aj9Var.j0()) {
                    this.d1.getView().setVisibility(8);
                } else {
                    this.d1.getView().setVisibility(0);
                    pj9 pj9Var = new pj9(pj9.g);
                    pj9Var.b = aj9Var.g;
                    pj9Var.c = this.f.c7();
                    pj9Var.e = aj9Var.f;
                    pj9Var.f = aj9Var.O().isQuestionThread();
                    this.d1.i(pj9Var);
                }
            }
            A4(X);
            B4(aj9Var);
            SafeHandler.getInst().post(new q0(this));
            this.z.f(this.o);
            if (X.f1164T) {
                this.z.g(X.U());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.z.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            gm9 gm9Var = this.I;
            if (gm9Var != null && gm9Var.B() != null) {
                this.I.B().W(X.f1164T);
            }
            gm9 gm9Var2 = this.I;
            if (gm9Var2 != null) {
                gm9Var2.y0(X.f1164T);
            }
            MaskView maskView = this.O1;
            if (X.f1164T) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public void p4(z45.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048765, this, cVar, z2) == null) {
            g55 g55Var = this.j0;
            if (g55Var != null) {
                g55Var.dismiss();
                this.j0 = null;
            }
            i55 i55Var = new i55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            aj9 aj9Var = this.R0;
            if (aj9Var != null && aj9Var.O() != null && !this.R0.O().isBjh()) {
                arrayList.add(new e55(0, this.f.getPageContext().getString(R.string.save_to_emotion), i55Var));
            }
            if (!z2) {
                arrayList.add(new e55(1, this.f.getPageContext().getString(R.string.save_to_local), i55Var));
            }
            i55Var.l(arrayList);
            i55Var.q(new n0(this, cVar));
            g55 g55Var2 = new g55(this.f.getPageContext(), i55Var);
            this.j0 = g55Var2;
            g55Var2.l();
        }
    }

    public final void s2(CallRobotEntrance callRobotEntrance, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048777, this, callRobotEntrance, z2) != null) || callRobotEntrance == null) {
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
        aj9 aj9Var = this.R0;
        if (aj9Var == null) {
            str = "";
        } else {
            threadData = aj9Var.O();
            str = this.R0.l();
        }
        if (threadData == null) {
            str2 = "";
        } else {
            str2 = String.valueOf(threadData.getTid());
        }
        CommonStatisticUtils.statisticBotSkillMenu(2, abilityConf.bot_uk, 4, z2, str, str4, str2);
    }

    public void y2(int i2) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048807, this, i2) != null) || this.U0 == i2) {
            return;
        }
        this.U0 = i2;
        C4(this.R0, this.Q0);
        d3(this.R0, this.Q0, this.T0, i2);
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
        uo9 uo9Var = this.y;
        if (uo9Var != null) {
            uo9Var.c(i2);
        }
        to9 to9Var = this.v;
        if (to9Var != null) {
            to9Var.e(i2);
        }
        vo9 vo9Var = this.w;
        if (vo9Var != null) {
            vo9Var.g(i2);
        }
        xo9 xo9Var = this.x;
        if (xo9Var != null) {
            xo9Var.C(i2);
        }
        wo9 wo9Var = this.z;
        if (wo9Var != null) {
            wo9Var.e();
        }
        so9 so9Var = this.A;
        if (so9Var != null) {
            so9Var.c();
        }
        MaskView maskView = this.O1;
        if (maskView != null) {
            maskView.f();
        }
        tn9 tn9Var = this.s;
        if (tn9Var != null) {
            tn9Var.o();
        }
        om9 om9Var = this.D;
        if (om9Var != null) {
            om9Var.n();
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
        y45 y45Var = this.J;
        if (y45Var != null) {
            y45Var.autoChangeSkinType(this.f.getPageContext());
        }
        K4(this.l0);
        this.I.f0();
        fs9 fs9Var = this.N;
        if (fs9Var != null) {
            fs9Var.C(i2);
        }
        EditorTools editorTools = this.r0;
        if (editorTools != null) {
            editorTools.z(i2);
        }
        as9 as9Var = this.P;
        if (as9Var != null) {
            as9Var.g(i2);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        R4();
        UtilHelper.setStatusBarBackground(this.h, i2);
        UtilHelper.setStatusBarBackground(this.c1, i2);
        if (this.E != null) {
            vt5.a(this.f.getPageContext(), this.E);
        }
        vm9 vm9Var = this.m1;
        if (vm9Var != null) {
            vm9Var.l(i2);
        }
        nq9 nq9Var = this.k;
        if (nq9Var != null) {
            nq9Var.p(i2);
        }
        LinearLayout linearLayout = this.z0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        aj9 aj9Var = this.R0;
        if (aj9Var != null && aj9Var.q()) {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.D0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.A0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        P4(this.R0);
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
                a3(data, data.agreeNum);
            }
        }
        tl9 tl9Var = this.y1;
        if (tl9Var != null) {
            tl9Var.l(i2);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            EMManager.from(this.b).setCorner(R.string.J_X05).setBackGroundRealColor(zfa.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        es9 es9Var = this.K0;
        if (es9Var != null) {
            es9Var.i();
        }
        ds9 ds9Var = this.N1;
        if (ds9Var != null) {
            ds9Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.Q1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.b1, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.b1.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.S1;
        if (linearLayout2 != null) {
            EMManager.from(linearLayout2).setBackGroundColor(R.color.CAM_X0201);
        }
        yp9 yp9Var = this.T1;
        if (yp9Var != null) {
            yp9Var.b(i2);
        }
    }
}
