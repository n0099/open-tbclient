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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d55;
import com.baidu.tieba.f55;
import com.baidu.tieba.k79;
import com.baidu.tieba.l99;
import com.baidu.tieba.m39;
import com.baidu.tieba.m89;
import com.baidu.tieba.mz9;
import com.baidu.tieba.o55;
import com.baidu.tieba.o59;
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
import com.baidu.tieba.r46;
import com.baidu.tieba.t39;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.u46;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.x95;
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
import tbclient.ItemInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class r89 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g2;
    public static int h2;
    public static int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static final int n2;
    public static int o2;
    public static mz9.f p2;
    public transient /* synthetic */ FieldHolder $fh;
    public PbContentCollectionController A;
    public TextView A0;
    public NavigationBarCoverTip A1;
    public k79 B;
    public WaterRippleView B0;
    public r46 B1;
    public j79 C;
    public ImageView C0;
    public u46 C1;
    public LinearLayout D;
    public AgreeView D0;
    public String D1;
    public TextView E;
    public ImageView E0;
    public PermissionJudgePolicy E1;
    public TextView F;
    public ImageView F0;
    public boolean F1;
    public ObservedChangeRelativeLayout G;
    public HeadImageView G0;
    public int G1;
    public b79 H;
    public View H0;
    public int H1;
    public d55 I;
    public wc9 I0;
    public boolean I1;
    public f55 J;
    public TextView J0;
    public boolean J1;
    public View K;
    public TextView K0;
    public vc9 K1;
    public EditText L;
    public boolean L0;
    public MaskView L1;
    public xc9 M;
    public int M0;
    public final PbFallingView M1;
    public PbListView N;
    public r95 N0;
    public RightFloatLayerView N1;
    public sc9 O;
    public boolean O0;
    public final FrameLayout O1;
    public View P;
    public j49 P0;
    public LinearLayout P1;
    public View Q;
    public b0a Q0;
    public ra9 Q1;
    public View R;
    public int R0;
    public final Object R1;
    public View.OnClickListener S;
    public int S0;
    public CustomMessageListener S1;

    /* renamed from: T  reason: collision with root package name */
    public SortSwitchButton.f f1163T;
    public boolean T0;
    public View.OnClickListener T1;
    public TbRichTextView.z U;
    public ViewStub U0;
    public CustomMessageListener U1;
    public NoNetworkView.b V;
    public PbInterviewStatusView V0;
    public Handler V1;
    public m55 W;
    public TextView W0;
    public Runnable W1;
    public View.OnClickListener X;
    public View X0;
    public CustomMessageListener X1;
    public d55 Y;
    public View Y0;
    public PbFragment.e3 Y1;
    public Dialog Z;
    public View Z0;
    public boolean Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public Dialog a0;
    public PbReplyTitleViewHolder a1;
    public View.OnClickListener a2;
    public CardForumHeadLayout b;
    public View b0;
    public View b1;
    public String b2;
    public int c;
    public LinearLayout c0;
    public int c1;
    public x95.g c2;
    public boolean d;
    public CompoundButton.OnCheckedChangeListener d0;
    public boolean d1;
    public View.OnClickListener d2;
    public int e;
    public TextView e0;
    public b1 e1;
    public final List<TbImageView> e2;
    public PbFragment f;
    public TextView f0;
    public int f1;
    public boolean f2;
    public RelativeLayout g;
    public String g0;
    public int g1;
    public View h;
    public m55 h0;
    public Runnable h1;
    public int i;
    public m55 i0;
    public PbFakeFloorModel i1;
    public final Handler j;
    public h55 j0;
    public p79 j1;
    public final fb9 k;
    public boolean k0;
    public boolean k1;
    public eb9 l;
    public boolean l0;
    public int l1;
    public ViewStub m;
    public String m0;
    public boolean m1;
    public ViewStub n;
    public String n0;
    public boolean n1;
    public PbLandscapeListView o;
    public q59 o0;
    public boolean o1;
    public NoNetworkView p;
    public ScrollView p0;
    public int p1;
    public List<CustomBlueCheckRadioButton> q;
    public EditorTools q0;
    public PbTopTipView q1;
    public PbThreadPostView r;
    public boolean r0;
    public PopupWindow r1;
    public n89 s;
    public View s0;
    public TextView s1;
    public m89 t;
    public View t0;
    public List<String> t1;
    public m99 u;
    public EjectionAnimationView u0;
    public u99 u1;
    public o99 v;
    public Button v0;
    public o69 v1;
    public q99 w;
    public View w0;
    public PbLandscapeListView.c w1;
    public n99 x;
    public View x0;
    public boolean x1;
    public p99 y;
    public LinearLayout y0;
    public boolean y1;
    public l99 z;
    public ImageView z0;
    public b89 z1;

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? R.id.obfuscated_res_0x7f091a07 : invokeV.intValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? R.id.obfuscated_res_0x7f091e59 : invokeV.intValue;
    }

    public boolean k2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048727, this, i3)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* loaded from: classes7.dex */
        public class a implements vh5 {
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

            @Override // com.baidu.tieba.vh5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.u0.setVisibility(0);
                    this.a.a.u0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.D0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.u0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.u0.k();
                }
            }
        }

        public b(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.C3();
            xh5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.O2();
            this.a.u0.l();
        }
    }

    /* loaded from: classes7.dex */
    public class i implements m89.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.s != null && this.a.a.f.V() != null) {
                    u55.g(Collections.singletonList(new o89(this.a.a.f.V(), this.a.a.s)));
                }
            }
        }

        public i(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.m89.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.f.z6() && this.a.o != null) {
                this.a.o.post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ r89 g;

        /* loaded from: classes7.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.b1 != null && this.a.g.b1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.b1.getLayoutParams();
                    layoutParams.height = this.a.g.g1;
                    this.a.g.b1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(r89 r89Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = r89Var;
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
                    int j1 = this.g.j1(this.b);
                    int i3 = this.a;
                    int i4 = j1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = j1 - i;
                    }
                    if (this.g.b1 == null || (layoutParams = this.g.b1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.g.getMeasuredHeight() && j1 < this.g.g.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.g.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.o != null) {
                                    this.g.o.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.g1;
                    } else {
                        layoutParams.height = this.g.g1;
                    }
                    this.g.b1.setLayoutParams(layoutParams);
                    xg.a().post(new a(this));
                }
                if (this.g.o != null) {
                    this.g.o.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements k79.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ m b;

            public a(m mVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = mVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a.C != null && this.b.a.f.V() != null) {
                    this.b.a.C.q(this.a);
                    u55.g(Collections.singletonList(new l79(this.b.a.f.V(), this.b.a.C)));
                }
            }
        }

        public m(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.k79.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && !this.a.f.z6() && !this.a.d && this.a.o != null) {
                this.a.o.post(new a(this, i));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q0 a;

            public a(q0 q0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {q0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q0Var;
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

        public q0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                xg.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements i59 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        @Override // com.baidu.tieba.i59
        public /* synthetic */ void onStart() {
            h59.a(this);
        }

        public a(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.i59
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.u0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ r89 c;

        public a0(r89 r89Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r89Var;
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
                    wi.P(this.c.f.V(), R.string.obfuscated_res_0x7f0f0df3);
                } else {
                    this.c.f.l5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public a1(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public b0(r89 r89Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public static class b1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

        public b1() {
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public c(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.D0 != null && this.a.D0.getData() != null) {
                r89 r89Var = this.a;
                r89Var.I2(r89Var.D0.getData(), this.a.D0.getData().agreeNum);
                if (!this.a.D0.K()) {
                    r89 r89Var2 = this.a;
                    r89Var2.B2(r89Var2.D0);
                }
                if (this.a.P0 != null && this.a.P0.N() != null && this.a.P0.N().isExcellentThread() && BreatheTipWidget.f()) {
                    xf5.a("c15279", this.a.P0.P(), this.a.P0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c0 implements r46.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d55 a;
        public final /* synthetic */ r89 b;

        public c0(r89 r89Var, d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, d55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = d55Var;
        }

        @Override // com.baidu.tieba.r46.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.m5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public d(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.getVisibility() == 0) {
                    if (this.a.f != null && this.a.f.H1()) {
                        return;
                    }
                    o95.p().A("pb_share_red_dot_shown", true);
                    this.a.H0.setVisibility(8);
                }
                this.a.S.onClick(view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements u46.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ r89 b;

        public d0(r89 r89Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.u46.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.f.l5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public e(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
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
                    this.a.f.b5(sparseArray);
                    return;
                }
                this.a.A2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.f.b5(sparseArray);
            } else if (z3) {
                this.a.v2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public e0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.g0 = (String) compoundButton.getTag();
                if (this.a.q != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.q) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.g0 != null && !str.equals(this.a.g0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public f(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public f0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.a0 instanceof Dialog)) {
                zg.b(this.a.a0, this.a.f.getPageContext());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public g(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(b0a b0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, b0aVar) == null) {
                this.a.i1.l0(b0aVar);
                this.a.H.f0();
                this.a.j1.g();
                this.a.q0.s();
                this.a.H3(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g0 implements mz9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.mz9.f
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

    /* loaded from: classes7.dex */
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public h(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.b4();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M1.setTag(Boolean.FALSE);
                if (this.a.N1 == null) {
                    return;
                }
                this.a.N1.setAutoCompleteShown(false);
                if (this.a.N1.getVisibility() == 0) {
                    this.a.N1.setTag(this.a.M1);
                    this.a.N1.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f55.c a;
        public final /* synthetic */ r89 b;

        public h0(r89 r89Var, f55.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 o55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o55Var, i, view2) == null) {
                this.b.i0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f55.c a;
        public final /* synthetic */ r89 b;

        public i0(r89 r89Var, f55.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 o55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o55Var, i, view2) == null) {
                this.b.i0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements t39.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public j(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.t39.a
        public void a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
                if (this.a.f != null && this.a.f.Q() != null) {
                    this.a.f.Q().s3();
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f07e2);
                }
                qa9.d(str, str2, str3, 0);
                this.a.H.f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public j0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.P0 != null && this.a.P0.N() != null && this.a.P0.N().getAuthor() != null && this.a.P0.N().getAuthor().getAlaInfo() != null && this.a.P0.N().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.P0.l());
                    statisticItem2.param("fname", this.a.P0.m());
                    if (this.a.P0.N().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.P0.N().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.P0.P());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.P0.N().getAuthor().getAlaInfo()));
                    if (this.a.P0.N().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.P0.N().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.P0.N().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.f.getPageContext(), this.a.P0.N().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.m1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.m1 && this.a.P0 != null && this.a.P0.N() != null && this.a.P0.N().getAuthor() != null && this.a.P0.N().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.f.V() != null) {
                    this.a.f.V().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(r89 r89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Integer.valueOf(i)};
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
            this.a = r89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.e1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements l99.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public k0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.l99.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.a(this.a.o);
                } else {
                    this.a.z.d(this.a.o);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public l0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            r89 r89Var;
            fb9 fb9Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.H != null && (fb9Var = (r89Var = this.a).k) != null && fb9Var.k != null && r89Var.P0 != null && this.a.P0.N() != null && !this.a.P0.N().isVideoThreadType() && !this.a.X1() && this.a.P0.k() != null && !vi.isEmpty(this.a.P0.k().getName())) {
                if ((this.a.H.L() == null || !this.a.H.L().isShown()) && (linearLayout = this.a.k.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.k.h();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ r89 b;

        public m0(r89 r89Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (wi.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.f.getPageContext(), new String[]{this.a});
                    this.b.f.finish();
                    return;
                }
                this.b.f.showToast(R.string.obfuscated_res_0x7f0f0df3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public n(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.getVisibility() == 0) {
                    o95.p().A("pb_share_red_dot_shown", true);
                    this.a.H0.setVisibility(8);
                }
                this.a.S.onClick(this.a.F0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ j49 c;
        public final /* synthetic */ r89 d;

        public n0(r89 r89Var, Parcelable parcelable, ArrayList arrayList, j49 j49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, parcelable, arrayList, j49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r89Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = j49Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.o != null) {
                    this.d.o.onRestoreInstanceState(this.a);
                }
                if (this.d.N != null && ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.N.g();
                    this.d.N.H(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fac));
                    this.d.N.B();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
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

    /* loaded from: classes7.dex */
    public class o0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public o0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.f != null && this.a.f.isAdded()) {
                if (i < 0 && f > this.a.p1) {
                    this.a.s0();
                    this.a.l2();
                }
                this.a.A0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements m39.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public p(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.m39.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D0.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public p0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                this.a.s0();
                d55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(r89 r89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Integer.valueOf(i)};
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
            this.a = r89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.H != null) {
                this.a.H.f0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public r(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.D == null) {
                    this.a.G1();
                }
                this.a.n.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;
        public final /* synthetic */ r89 b;

        public r0(r89 r89Var, mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = mc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.P0 != null && this.b.N1 != null) {
                this.b.N1.g(this.a);
                this.b.N1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(r89 r89Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Integer.valueOf(i)};
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
            this.a = r89Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.L0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public t(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.R2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public t0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u implements zh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public u(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.zh5
        public void C(yh5 yh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yh5Var) == null) {
                Object obj = yh5Var.c;
                if ((obj instanceof dd5) && EmotionGroupType.isSendAsPic(((dd5) obj).getType())) {
                    if (this.a.E1 == null) {
                        this.a.E1 = new PermissionJudgePolicy();
                    }
                    this.a.E1.clearRequestPermissionList();
                    this.a.E1.appendRequestPermission(this.a.f.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E1.startRequestPermission(this.a.f.getBaseFragmentActivity())) {
                        return;
                    }
                    dd5 dd5Var = (dd5) yh5Var.c;
                    this.a.f.I5().f(dd5Var);
                    if (dd5Var.i()) {
                        this.a.f.I5().H(null, null);
                    } else {
                        this.a.f.I5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ r89 e;

        public u0(r89 r89Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r89Var;
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
                    this.e.r1.showAsDropDown(this.d);
                } else {
                    this.e.r1.showAsDropDown(this.e.x0, this.d.getLeft(), -this.e.x0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public v(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.f.L0 != null && this.a.f.L0.e() != null) {
                if (!this.a.f.L0.e().e()) {
                    this.a.f.L0.a(false);
                }
                this.a.f.L0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.q0 != null && this.a.q0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.u1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.q0.getId());
                    r89 r89Var = this.a;
                    r89Var.u1 = new u99(r89Var.f.getPageContext(), this.a.g, layoutParams);
                    if (!ListUtils.isEmpty(this.a.t1)) {
                        this.a.u1.q(this.a.t1);
                    }
                    this.a.u1.r(this.a.q0);
                }
                this.a.u1.p(substring);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public v0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String i1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null && this.a.f.Q() != null && this.a.f.Q().h2()) {
                    i1 = this.a.f.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    i1 = this.a.i1();
                }
                if (!StringUtils.isNull(i1) && this.a.P0 != null) {
                    i1 = TbSingleton.getInstance().getAdVertiComment(this.a.P0.p0(), this.a.P0.q0(), i1);
                }
                if (this.a.f != null && this.a.f.I5() != null) {
                    this.a.f.I5().d0(i1);
                }
                if (this.a.A0 != null) {
                    this.a.A0.setText(i1);
                }
                this.a.H3(false);
                this.a.b4();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements o55.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ r89 b;

        public w(r89 r89Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.o55.f
        public void M0(o55 o55Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o55Var, i, view2) == null) {
                this.b.W.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.v2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.Y1 != null) {
                            this.b.Y1.callback(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.f.R5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.u4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc5 a;
        public final /* synthetic */ r89 b;

        public w0(r89 r89Var, mc5 mc5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, mc5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = mc5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.N1.setHomePbFloatLastCloseTime();
                this.b.y1();
                this.b.N1.t(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements d55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public x(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d55.e
        public void onClick(d55 d55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d55Var) == null) {
                d55Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ r89 b;

        public x0(r89 r89Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r89Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.I1 && this.a != null && this.b.f.Q() != null && this.b.f.Q().l2()) {
                    this.b.I1 = true;
                    this.a.Z4(false);
                }
                if (this.b.J1) {
                    return;
                }
                this.b.J1 = true;
                if (this.b.U1() && this.b.A != null) {
                    this.b.A.h();
                    this.b.A.g(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ r89 c;

        public y(r89 r89Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r89Var;
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
                    wi.P(this.c.f.V(), R.string.obfuscated_res_0x7f0f0df3);
                } else {
                    this.c.f.l5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 implements o59.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r89 a;

        public y0(r89 r89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r89Var;
        }

        @Override // com.baidu.tieba.o59.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.U5();
            }
        }

        @Override // com.baidu.tieba.o59.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.o != null) {
                this.a.o.setSelection(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(r89 r89Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, alertDialog};
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

    /* loaded from: classes7.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ dk5 b;
        public final /* synthetic */ r89 c;

        public z0(r89 r89Var, ReplyPrivacyCheckController replyPrivacyCheckController, dk5 dk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r89Var, replyPrivacyCheckController, dk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = r89Var;
            this.a = replyPrivacyCheckController;
            this.b = dk5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.f != null && this.c.f.s5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.f.s5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.q4();
                this.b.o0();
                this.c.x0();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075638, "Lcom/baidu/tieba/r89;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075638, "Lcom/baidu/tieba/r89;");
                return;
            }
        }
        g2 = UtilHelper.getLightStatusBarHeight();
        h2 = 3;
        i2 = 0;
        j2 = 3;
        k2 = 4;
        l2 = 5;
        m2 = 6;
        n2 = wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        o2 = 1;
        p2 = new g0();
    }

    public b0a L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.o == null) {
                return null;
            }
            int K0 = K0() - this.o.getHeaderViewsCount();
            int i3 = 0;
            if (K0 < 0) {
                K0 = 0;
            }
            if (this.H.A(K0) != null && this.H.A(K0) != b0a.W0) {
                i3 = K0 + 1;
            }
            if (!(this.H.z(i3) instanceof b0a)) {
                return null;
            }
            return (b0a) this.H.z(i3);
        }
        return (b0a) invokeV.objValue;
    }

    public final int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null && pbLandscapeListView.getData() != null) {
                for (int i3 = 0; i3 < this.o.getData().size(); i3++) {
                    wn wnVar = this.o.getData().get(i3);
                    if (wnVar != null && wnVar.getType() == l49.k) {
                        return i3 + this.o.getHeaderViewsCount();
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void T2() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048654, this) == null) && (pbListView = this.N) != null && pbListView.i() != null) {
            LinearLayout i3 = this.N.i();
            View findViewById = i3.findViewById(R.id.obfuscated_res_0x7f0919fa);
            if (i3.getVisibility() == 0 && findViewById != null && findViewById.getVisibility() == 0) {
                this.d = true;
                TiebaStatic.log(new StatisticItem("c15304").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (A3()) {
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

    public void X3() {
        b0a b0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048671, this) != null) || !TbadkCoreApplication.isLogin() || this.P0 == null || !this.n1 || this.m1 || this.l0 || (b0aVar = this.Q0) == null || b0aVar.q() == null || this.Q0.q().getIsLike() || this.Q0.q().hadConcerned()) {
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048742, this) == null) {
            m4();
            this.H.g0(1);
            n89 n89Var = this.s;
            if (n89Var != null) {
                n89Var.j();
            }
            j79 j79Var = this.C;
            if (j79Var != null) {
                j79Var.g();
            }
            k79 k79Var = this.B;
            if (k79Var != null) {
                k79Var.i();
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public r89(PbFragment pbFragment, View.OnClickListener onClickListener, q59 q59Var, SortSwitchButton.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, q59Var, fVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
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
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.S = null;
        this.U = null;
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
        this.k0 = false;
        this.l0 = false;
        this.m0 = null;
        this.n0 = null;
        this.p0 = null;
        this.r0 = false;
        this.v0 = null;
        this.x0 = null;
        this.A0 = null;
        this.L0 = true;
        this.N0 = null;
        this.O0 = false;
        this.S0 = 3;
        this.T0 = false;
        this.U0 = null;
        this.c1 = 0;
        this.d1 = true;
        this.e1 = new b1();
        this.f1 = 0;
        this.k1 = false;
        this.l1 = 0;
        this.m1 = false;
        this.n1 = false;
        this.o1 = false;
        this.p1 = 0;
        this.x1 = false;
        this.y1 = false;
        this.H1 = 0;
        this.R1 = new Object();
        this.S1 = new k(this, 2921757);
        this.T1 = new n(this);
        this.U1 = new q(this, 2005016);
        this.V1 = new Handler();
        this.X1 = new s(this, 2004009);
        this.Z1 = true;
        this.a2 = new j0(this);
        this.b2 = null;
        this.e2 = new ArrayList();
        this.f2 = false;
        this.f = pbFragment;
        this.e1.b = pbFragment.getPageContext().getUniqueId();
        this.S = onClickListener;
        this.f1163T = fVar;
        this.o0 = q59Var;
        this.p1 = wi.l(this.f.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06ce, (ViewGroup) null);
        this.g = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s0 = this.g.findViewById(R.id.obfuscated_res_0x7f09046a);
        this.A1 = (NavigationBarCoverTip) this.g.findViewById(R.id.obfuscated_res_0x7f091a76);
        this.h = this.g.findViewById(R.id.obfuscated_res_0x7f092201);
        this.O1 = (FrameLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091e7d);
        this.G = (ObservedChangeRelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0924e4);
        this.p = (NoNetworkView) this.g.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.g.findViewById(R.id.obfuscated_res_0x7f0918a3);
        this.o = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.W0 = new TextView(this.f.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + wi.g(this.f.getActivity(), R.dimen.obfuscated_res_0x7f07041a));
        this.o.setOverScrollMode(2);
        this.o.w(this.W0, 0);
        this.o.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.b1 = new View(this.f.getPageContext().getPageActivity());
        if (i36.a()) {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.b1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        MessageManager.getInstance().registerListener(this.S1);
        this.b1.setVisibility(4);
        this.o.addFooterView(this.b1);
        this.o.setOnTouchListener(this.f.K2);
        this.a = new x0(this, pbFragment);
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.k = new fb9(pbFragment, this.g);
        if (this.f.B5()) {
            ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091692);
            this.m = viewStub;
            viewStub.setVisibility(0);
            eb9 eb9Var = new eb9(pbFragment);
            this.l = eb9Var;
            eb9Var.c();
            this.k.a.setVisibility(8);
            layoutParams.height = wi.g(this.f.getActivity(), R.dimen.obfuscated_res_0x7f07035e);
        }
        this.W0.setLayoutParams(layoutParams);
        this.k.j().setOnTouchListener(new o59(new y0(this)));
        this.w0 = this.g.findViewById(R.id.obfuscated_res_0x7f09287f);
        this.x0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a0a);
        this.M0 = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07039c);
        this.z0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090979);
        this.z0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.f.getPageContext()), this.f.I5()));
        y0();
        this.A0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a0d);
        LinearLayout linearLayout = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091a05);
        this.y0 = linearLayout;
        linearLayout.setOnClickListener(new a1(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f09097d);
        this.u0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.C0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a0b);
        this.L1 = (MaskView) this.g.findViewById(R.id.mask_view);
        this.C0.setOnClickListener(this.S);
        AgreeView agreeView = (AgreeView) this.g.findViewById(R.id.obfuscated_res_0x7f091a07);
        this.D0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.D0.x();
        this.D0.setAgreeLongClickListener(new b(this));
        this.D0.setAfterClickListener(new c(this));
        this.D0.setUseDynamicLikeRes("/pb");
        if (this.D0.getAgreeNumView() != null) {
            this.D0.getAgreeNumView().setVisibility(8);
        }
        if (this.D0.getMsgData() != null) {
            this.D0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.f.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a09);
        this.E0 = imageView;
        imageView.setOnClickListener(this.S);
        if (booleanExtra) {
            this.E0.setVisibility(8);
        } else {
            this.E0.setVisibility(0);
        }
        View findViewById = this.g.findViewById(R.id.obfuscated_res_0x7f091a10);
        this.H0 = findViewById;
        if (!o95.p().l("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.F0 = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a0e);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091a0f);
        this.G0 = headImageView;
        headImageView.setIsRound(true);
        this.G0.setOnClickListener(this.T1);
        this.F0.setOnClickListener(new d(this));
        d2();
        wc9 wc9Var = new wc9(this.F0);
        this.I0 = wc9Var;
        wc9Var.m(this.G0);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a0c);
        this.K0 = textView;
        textView.setVisibility(0);
        this.J0 = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a08);
        this.U0 = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091143);
        this.D0.setVisibility(0);
        this.J0.setVisibility(0);
        this.u = new m99(this.f, q59Var);
        this.w = new q99(this.f, q59Var, this.S);
        b79 b79Var = new b79(this.f, this.o);
        this.H = b79Var;
        b79Var.F0(this.S);
        this.H.H0(this.o0);
        this.H.C0(this.U);
        this.H.E0(this.f1163T);
        this.H.y0(this.d2);
        e eVar = new e(this);
        this.X = eVar;
        this.H.A0(eVar);
        L1();
        E1();
        p99 p99Var = new p99(this.f);
        this.y = p99Var;
        p99Var.f = 2;
        D1();
        B1();
        this.z.a(this.o);
        this.w.q(this.o);
        this.v.a(this.o);
        this.A.a(this.o);
        this.u.a(this.o);
        PbListView pbListView = new PbListView(this.f.getPageContext().getPageActivity());
        this.N = pbListView;
        this.P = pbListView.c().findViewById(R.id.pb_more_view);
        this.Q = this.N.c().findViewById(R.id.pb_check_more);
        if (!this.N.k().booleanValue()) {
            this.Q.setVisibility(8);
        }
        View view2 = this.P;
        if (view2 != null) {
            view2.setOnClickListener(this.S);
            SkinManager.setBackgroundResource(this.P, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.Q;
        if (view3 != null) {
            view3.setOnClickListener(this.S);
        }
        this.N.D();
        this.N.r(R.drawable.pb_foot_more_trans_selector);
        this.N.F(R.color.CAM_X0109);
        this.N.s(R.drawable.pb_foot_more_trans_selector);
        this.R = this.g.findViewById(R.id.obfuscated_res_0x7f0928b7);
        this.f.registerListener(this.X1);
        this.i1 = new PbFakeFloorModel(this.f.getPageContext());
        PbModel Q = this.f.Q();
        this.i1.n0(Q.d0(), Q.Z(), Q.a0(), Q.Y(), Q.e0());
        p79 p79Var = new p79(this.f.getPageContext(), this.i1, this.g);
        this.j1 = p79Var;
        p79Var.p(new f(this));
        this.j1.s(this.f.n2);
        this.i1.p0(new g(this));
        if (this.f.Q() != null && !StringUtils.isNull(this.f.Q().B1())) {
            PbFragment pbFragment2 = this.f;
            pbFragment2.showToast(pbFragment2.Q().B1());
        }
        this.X0 = this.g.findViewById(R.id.obfuscated_res_0x7f091a12);
        this.Y0 = this.g.findViewById(R.id.obfuscated_res_0x7f090468);
        View findViewById2 = this.g.findViewById(R.id.obfuscated_res_0x7f09220d);
        this.Z0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.f.Q() != null && this.f.Q().k1()) {
            this.X0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Z0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = g2;
            this.Z0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.f.getPageContext(), this.g.findViewById(R.id.obfuscated_res_0x7f091a95));
        this.a1 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.d0);
        this.a1.g.setVisibility(8);
        this.a1.r(this.S);
        this.a1.q(this.f1163T);
        this.f.registerListener(this.U1);
        PbFragment pbFragment3 = this.f;
        this.K1 = new vc9(pbFragment3, pbFragment3.getUniqueId());
        this.M1 = (PbFallingView) this.g.findViewById(R.id.obfuscated_res_0x7f090ac3);
        X2();
        this.M1.setAnimationListener(new h(this));
        n0();
        this.t0 = this.g.findViewById(R.id.obfuscated_res_0x7f0919fb);
        m0(i36.a());
        this.s = new n89(this.f.V(), (ViewGroup) p1().findViewById(R.id.obfuscated_res_0x7f091aa8));
        m89 m89Var = new m89(this.o);
        this.t = m89Var;
        m89Var.d(new i(this));
        this.P1 = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092744);
        this.Q1 = new ra9(this.f.getActivity());
        I1();
        bs6.b().a(this.R1, new t39(new j(this)));
    }

    public void A2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        z2(sparseArray, false);
    }

    public void G3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            View view2 = this.s0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public final boolean P1(j49 j49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, j49Var)) == null) {
            return q89.x(j49Var);
        }
        return invokeL.booleanValue;
    }

    public void V2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048662, this, str) == null) && (pbListView = this.N) != null) {
            pbListView.H(str);
        }
    }

    public void Y2(PbFragment.e3 e3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, e3Var) == null) {
            this.Y1 = e3Var;
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.r0 = z2;
        }
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) {
            this.H.p0(z2);
        }
    }

    public final int b1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048685, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.F1 = z2;
        }
    }

    public void c3(boolean z2) {
        b79 b79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) && (b79Var = this.H) != null) {
            b79Var.q0(z2);
        }
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z2) == null) {
            this.x1 = z2;
        }
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.H.s0(z2);
        }
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z2) == null) {
            this.H.x0(z2);
        }
    }

    public final void f4(b0a b0aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048704, this, b0aVar) == null) && b0aVar != null) {
            this.y1 = !StringUtils.isNull(b0aVar.f0());
            q99 q99Var = this.w;
            if (q99Var != null) {
                q99Var.t(b0aVar);
            }
        }
    }

    public void g3(x95.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, gVar) == null) {
            this.c2 = gVar;
            xc9 xc9Var = this.M;
            if (xc9Var != null) {
                xc9Var.f(gVar);
            }
        }
    }

    public boolean h0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048710, this, z2)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools != null && editorTools.w()) {
                this.q0.s();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void h3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, onClickListener) == null) {
            this.d2 = onClickListener;
            b79 b79Var = this.H;
            if (b79Var != null) {
                b79Var.y0(onClickListener);
            }
        }
    }

    public void i3(String str) {
        eb9 eb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048718, this, str) == null) && (eb9Var = this.l) != null) {
            eb9Var.b(str);
        }
    }

    public void i4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, str) == null) {
            this.f.showToast(str);
        }
    }

    public void j3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            this.k1 = z2;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                this.l1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void k3(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, zVar) == null) {
            this.U = zVar;
            this.H.C0(zVar);
            this.v1.q(this.U);
        }
    }

    public void l3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, bVar) == null) {
            this.V = bVar;
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void m3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048738, this, pVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void n3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048743, this, onScrollListener) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void n4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z2) == null) {
            this.k0 = z2;
        }
    }

    public void o2(zn znVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048747, this, znVar) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.b0 = znVar;
            pbLandscapeListView.W = true;
        }
    }

    public void o3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048748, this, onClickListener) == null) {
            this.H.G0(onClickListener);
        }
    }

    public void p3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i3) == null) {
            this.G1 = i3;
        }
    }

    public void q3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, onLongClickListener) == null) {
            this.w.I(onLongClickListener);
            this.H.D0(onLongClickListener);
            o69 o69Var = this.v1;
            if (o69Var != null) {
                o69Var.r(onLongClickListener);
            }
        }
    }

    public void v4(j49 j49Var) {
        m99 m99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048784, this, j49Var) == null) && (m99Var = this.u) != null) {
            m99Var.h(j49Var, this.O0);
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048788, this, z2) == null) {
            this.w.K(z2);
        }
    }

    public void y3(int i3) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048797, this, i3) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setSelection(i3);
        }
    }

    public void z3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, list) == null) {
            this.t1 = list;
            u99 u99Var = this.u1;
            if (u99Var != null) {
                u99Var.q(list);
            }
        }
    }

    public void D2(AdverSegmentData adverSegmentData, int i3) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048590, this, adverSegmentData, i3) == null) && (pbFallingView = this.M1) != null) {
            pbFallingView.A(adverSegmentData, this.f.getPageContext(), i3, false);
        }
    }

    @SuppressLint({"CutPasteId"})
    public void h4(j49 j49Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048714, this, j49Var, z2) != null) || j49Var == null) {
            return;
        }
        s4(j49Var, z2);
        v0();
    }

    public final void r3(b0a b0aVar, j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048763, this, b0aVar, j49Var) == null) {
            this.w.J(b0aVar, j49Var);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            v0();
        }
    }

    public void A1() {
        ra9 ra9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ra9Var = this.Q1) != null) {
            ra9Var.a();
        }
    }

    public final void B1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.A == null && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            this.A = new PbContentCollectionController(this.f.getActivity());
        }
    }

    public void C0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            n89 n89Var = this.s;
            if (n89Var != null && n89Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void D1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.z == null && (pbFragment = this.f) != null) {
            this.z = new l99(pbFragment.getContext());
        }
    }

    public void D3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            fb9 fb9Var = this.k;
            if (fb9Var != null && (view2 = fb9Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.v == null) {
            this.v = new o99(this.f, this.o0);
        }
    }

    public b79 F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.H;
        }
        return (b79) invokeV.objValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.w.F(this.P0, this.Q0, this.n1, this.m1);
        }
    }

    public LinearLayout H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.y0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            View view2 = this.b0;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.g0;
        }
        return (String) invokeV.objValue;
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && this.x == null) {
            this.x = new n99(this.f, this.S);
        }
    }

    public PbFallingView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.M1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public final void M2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (pbInterviewStatusView = this.V0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.V0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.V0.setLayoutParams(marginLayoutParams);
        }
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && this.i != 2) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.N);
            }
            this.i = 2;
        }
    }

    public void N3() {
        fb9 fb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (fb9Var = this.k) != null && !this.o1) {
            fb9Var.w();
            this.o1 = true;
        }
    }

    public int O0() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                i3 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i3 = 0;
            }
            return P0(i3);
        }
        return invokeV.intValue;
    }

    public boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.L0;
        }
        return invokeV.booleanValue;
    }

    public void O3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (pbLandscapeListView = this.o) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.N0 == null) {
                this.N0 = new r95(this.f.getPageContext());
            }
            this.N0.h(true);
        }
    }

    public Button Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.v0;
        }
        return (Button) invokeV.objValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            Q2();
            t1();
            this.j1.g();
            H3(false);
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.H.o0(this.P0, false);
            this.H.f0();
        }
    }

    public TextView S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.w.v();
        }
        return (TextView) invokeV.objValue;
    }

    public void S2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048650, this) != null) || (handler = this.V1) == null) {
            return;
        }
        Runnable runnable = this.W1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        r rVar = new r(this);
        this.W1 = rVar;
        this.V1.postDelayed(rVar, 2000L);
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            wc9 wc9Var = this.I0;
            if (wc9Var != null) {
                return wc9Var.f();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2);
        }
        return invokeV.booleanValue;
    }

    public PbInterviewStatusView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.V0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.x1;
        }
        return invokeV.booleanValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return P0(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public BdTypeListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.o;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public final void X2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            this.M1.setFallingFeedbackListener(new v0(this));
        }
    }

    public o69 Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.v1;
        }
        return (o69) invokeV.objValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            wc9 wc9Var = this.I0;
            if (wc9Var == null) {
                return false;
            }
            return wc9Var.h();
        }
        return invokeV.booleanValue;
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.R.setVisibility(0);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.p;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            EditorTools editorTools = this.q0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a4() {
        b79 b79Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && (b79Var = this.H) != null) {
            b79Var.I0();
        }
    }

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.P;
        }
        return (View) invokeV.objValue;
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            J2(this.P0);
        }
    }

    public void c4() {
        wc9 wc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048692, this) != null) || (wc9Var = this.I0) == null) {
            return;
        }
        wc9Var.n(2);
    }

    public PbListView d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.N;
        }
        return (PbListView) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            try {
                return Integer.parseInt(this.L.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public View f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.X0;
        }
        return (View) invokeV.objValue;
    }

    public PbFakeFloorModel g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.i1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public p79 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.j1;
        }
        return (p79) invokeV.objValue;
    }

    public void j4() {
        ra9 ra9Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048724, this) == null) && (ra9Var = this.Q1) != null && (linearLayout = this.P1) != null) {
            ra9Var.c(linearLayout);
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.f.showProgressBar();
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.S0;
        }
        return invokeV.intValue;
    }

    public void l4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && (pbFallingView = this.M1) != null) {
            pbFallingView.C();
        }
    }

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && this.e2 != null) {
            while (this.e2.size() > 0) {
                TbImageView remove = this.e2.remove(0);
                if (remove != null) {
                    remove.R();
                }
            }
        }
    }

    public PbThreadPostView n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) {
            return this.r;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.G;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.g;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void q1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048756, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            fb9 fb9Var = this.k;
            if (fb9Var != null && (view2 = fb9Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            this.H.g0(2);
            r2();
            b2();
            w4();
            k0();
            k79 k79Var = this.B;
            if (k79Var != null) {
                k79Var.j();
            }
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048761, this) != null) || this.x0 == null) {
            return;
        }
        this.w0.setVisibility(8);
        this.x0.setVisibility(8);
        this.L0 = false;
    }

    public final void r2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048762, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null) {
            this.f.I5().F();
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            this.k.f();
            m55 m55Var = this.h0;
            if (m55Var != null) {
                m55Var.dismiss();
            }
            w0();
            d55 d55Var = this.I;
            if (d55Var != null) {
                d55Var.dismiss();
            }
            f55 f55Var = this.J;
            if (f55Var != null) {
                f55Var.e();
            }
        }
    }

    public void t1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && (editorTools = this.q0) != null) {
            editorTools.q();
            u99 u99Var = this.u1;
            if (u99Var != null) {
                u99Var.m();
            }
        }
    }

    public void u0() {
        wc9 wc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048775, this) == null) && (wc9Var = this.I0) != null) {
            wc9Var.k(false);
        }
    }

    public void u1() {
        fb9 fb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && (fb9Var = this.k) != null) {
            fb9Var.k();
        }
    }

    public void u3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (pbFragment = this.f) != null && pbFragment.getBaseFragmentActivity() != null) {
            wi.z(this.f.getPageContext().getPageActivity(), this.f.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public final boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048780, this)) == null) {
            return this.u.b(this.O0);
        }
        return invokeV.booleanValue;
    }

    public void v1() {
        r95 r95Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048781, this) == null) && (r95Var = this.N0) != null) {
            r95Var.h(false);
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            this.N.D();
            this.N.U();
        }
    }

    public void w1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            if (this.D == null) {
                G1();
            }
            this.n.setVisibility(8);
            Handler handler = this.V1;
            if (handler != null && (runnable = this.W1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048791, this) == null) {
            this.R.setVisibility(8);
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", o2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && (rightFloatLayerView = this.N1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            PbListView pbListView = this.N;
            if (pbListView != null) {
                pbListView.B();
                this.N.g();
            }
            v1();
        }
    }

    public void z1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048799, this) == null) && (editorTools = this.q0) != null) {
            editorTools.s();
        }
    }

    public final boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            j49 j49Var = this.P0;
            if (j49Var != null && j49Var.N() != null && !ListUtils.isEmpty(this.P0.N().getThreadRecommendInfoDataList()) && this.f != null && this.v.b() != null && this.v.b().getVisibility() == 0 && this.P0.N().getThreadRecommendInfoDataList().get(0) != null && this.P0.N().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void E2() {
        fb9 fb9Var;
        j49 j49Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && this.v != null && (fb9Var = this.k) != null && fb9Var.j() != null && (j49Var = this.P0) != null && j49Var.N() != null && this.P0.N().isQuestionThread() && this.v.b() != null && this.v.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.b().getHeight();
            if (this.v.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            fb9 fb9Var2 = this.k;
            if (height > fb9Var2.j().getBottom() && z2) {
                z3 = false;
            }
            fb9Var2.z(z3, this.P0.N().getSpan_str());
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || !this.f.B5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f09168d);
        this.n = viewStub;
        viewStub.setVisibility(0);
        if (this.D == null) {
            this.D = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f09168c);
            lt5.a(this.f.getPageContext(), this.D);
        }
        if (this.E == null) {
            this.E = (TextView) this.D.findViewById(R.id.obfuscated_res_0x7f091691);
        }
        if (this.F == null) {
            this.F = (TextView) this.D.findViewById(R.id.obfuscated_res_0x7f091690);
        }
        this.E.setOnClickListener(this.S);
        this.F.setOnClickListener(this.S);
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (this.f != null && this.q0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.q0.j();
                r1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int K0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.o.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i3 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i3];
                Rect rect = new Rect();
                int childCount = this.o.getChildCount();
                int i4 = 0;
                for (int i5 = firstVisiblePosition; i5 <= lastVisiblePosition; i5++) {
                    int i6 = i5 - firstVisiblePosition;
                    if (i6 < childCount && (childAt = this.o.getChildAt(i6)) != null) {
                        childAt.getGlobalVisibleRect(rect);
                        iArr[i6] = rect.height();
                    }
                    i4 += iArr[i6];
                }
                int i7 = i4 / 2;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (i8 >= i3) {
                        break;
                    }
                    i9 += iArr[i8];
                    if (i9 > i7) {
                        firstVisiblePosition += i8;
                        break;
                    }
                    i8++;
                }
            }
            if (firstVisiblePosition < 0) {
                return 0;
            }
            return firstVisiblePosition;
        }
        return invokeV.intValue;
    }

    public final void Q2() {
        PbFragment pbFragment;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null && this.q0 != null) {
            yj5.a().c(0);
            dk5 I5 = this.f.I5();
            I5.N();
            I5.L();
            if (I5.v() != null) {
                WriteImagesInfo v2 = I5.v();
                if (I5.t) {
                    i3 = 1;
                } else {
                    i3 = 9;
                }
                v2.setMaxImagesAllowed(i3);
            }
            I5.e0(SendView.h);
            I5.h(SendView.h);
            gi5 o3 = this.q0.o(23);
            gi5 o4 = this.q0.o(2);
            gi5 o5 = this.q0.o(5);
            if (o4 != null) {
                o4.display();
            }
            if (o5 != null) {
                o5.display();
            }
            if (o3 != null) {
                o3.hide();
            }
            this.q0.invalidate();
        }
    }

    public final void k0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048725, this) == null) {
            if (A3() && this.P0 != null) {
                StatisticItem addParam = new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.P0.N().getTid()).addParam("obj_param1", this.P0.N().getThreadRecommendInfoDataList().get(0).businessId);
                int i3 = this.P0.N().getThreadRecommendInfoDataList().get(0).albumType;
                if (i3 != -1) {
                    addParam.addParam("obj_type", i3);
                }
                addParam.eventStat();
            }
            if (U1() && (pbContentCollectionController = this.A) != null) {
                pbContentCollectionController.h();
                this.A.g(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.H1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r0() {
        vc9 vc9Var;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048760, this) != null) || (vc9Var = this.K1) == null) {
            return;
        }
        if (this.o != null && vc9Var.a() != null && this.K1.a().getParent() != null) {
            i3 = this.o.getPositionForView(this.K1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.K1.a().getTop() + n2 <= this.X0.getBottom()) {
                this.H1 = 1;
                z2 = true;
            } else {
                this.H1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
        if (this.H1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.u(z3);
        this.K1.e(z2);
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            this.f.hideProgressBar();
            j49 j49Var = this.P0;
            if (j49Var != null && this.N != null && j49Var.y() != null && this.P0.y().b() == 0) {
                this.N.y(this.P0.s());
                if (this.P0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.P0.l());
                    statisticItem.param("fname", this.P0.m());
                    statisticItem.param("tid", this.P0.P());
                    TiebaStatic.log(statisticItem);
                }
            }
            z0();
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            v0();
        }
    }

    public void B0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.f.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.f;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f144c));
            } else if (z3) {
                if (vi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                }
                this.f.showToast(str);
            }
        }
    }

    public void y2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048796, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            if (z2) {
                E3(sparseArray);
            } else {
                F3(i3, sparseArray);
            }
        }
    }

    public void B2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && this.D0.getData() != null && this.D0.getData().hasAgree && this.f.getActivity() != null) {
            m39 m39Var = new m39(this.f.getContext());
            int g3 = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g4 = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708e4);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g4, g3);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((g4 * 1) / 1.45d));
            layoutParams.topMargin = wi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            m39Var.k(g3);
            m39Var.j(layoutParams);
            m39Var.i(false);
            if (this.P0 != null && (pbFragment = this.f) != null) {
                m39Var.n(true, pbFragment.getActivity().findViewById(16908290), 0, i4, this.P0.P(), this.P0.l());
            }
            m39Var.l(new p(this));
        }
    }

    public final boolean K3(j49 j49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, j49Var)) == null) {
            if (j49Var == null || j49Var.N() == null) {
                return false;
            }
            if (j49Var.N().getIsLive() != 1 && j49Var.N().getThreadType() != 33 && ((j49Var.N().getTopicData() == null || j49Var.N().getTopicData().a() == 0) && j49Var.N().getIs_top() != 1 && j49Var.N().getIs_good() != 1 && !j49Var.N().isActInfo() && !j49Var.N().isInterviewLive() && !j49Var.N().isVoteThreadType() && j49Var.N().getYulePostActivityData() == null && vi.isEmpty(j49Var.N().getCategory()) && !j49Var.N().isGodThread() && !j49Var.N().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void M1(j49 j49Var) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, j49Var) == null) && (pbListView = this.N) != null && pbListView.i() != null) {
            LinearLayout i3 = this.N.i();
            if (UbsABTestHelper.isPbEnterForum() && j49Var.y().b() == 0 && !this.f.Q().d1() && !Y1(j49Var)) {
                if (this.b == null) {
                    C1();
                }
                ViewParent parent = this.b.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.b);
                }
                i3.addView(this.b);
                ForumData k3 = j49Var.k();
                q25 forumShowInfo = k3.getForumShowInfo();
                if (forumShowInfo != null) {
                    forumShowInfo.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                }
                this.b.setData(k3.getName(), k3.getImage_url(), k3.getPost_num(), k3.getMember_num(), k3.getPendants(), forumShowInfo);
                return;
            }
            i3.removeView(this.b);
            i3.setVisibility(8);
        }
    }

    public void p4(i49 i49Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048754, this, i49Var) != null) || i49Var == null) {
            return;
        }
        this.k.C();
        if (!StringUtils.isNull(i49Var.b)) {
            this.k.y(i49Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1602);
        int e2 = ug.e(i49Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f156f);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0332);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1317);
        }
        this.f.showNetRefreshView(this.g, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new m0(this, i49Var.c));
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            d55 d55Var = new d55(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            d55Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(l2));
            d55Var.setYesButtonTag(sparseArray);
            d55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f17e8, this.f);
            d55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ca, new t0(this));
            d55Var.create(this.f.getPageContext()).show();
        }
    }

    public final boolean B3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            PbFragment pbFragment = this.f;
            if (pbFragment == null || pbFragment.Q().y1().k().getDeletedReasonInfo() == null || 1 != this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || this.f.s1 == 3 || !TbadkCoreApplication.isLogin()) {
            return;
        }
        m mVar = new m(this);
        this.C = new j79(this.f.V());
        this.B = new k79(this.o, mVar);
    }

    public final void O2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || (pbFragment = this.f) == null || pbFragment.getActivity() == null || (waterRippleView = this.B0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.B0);
        }
        TextView textView = this.J0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void P2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (pbLandscapeListView = this.o) != null) {
            this.z.d(pbLandscapeListView);
            this.v.h(this.o);
            this.w.G(this.o);
            this.x.d(this.o);
            this.u.f(this.o);
        }
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            View view2 = this.b1;
            if (view2 == null || view2.getParent() == null || this.N.p()) {
                return false;
            }
            int bottom = this.b1.getBottom();
            Rect rect = new Rect();
            this.b1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            j49 j49Var = this.P0;
            if (j49Var == null || j49Var.k() == null || "0".equals(this.P0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.P0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
            PbFallingView pbFallingView = this.M1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.M1) {
                this.N1.setTag(null);
                this.N1.setAutoCompleteShown(true);
                this.N1.d();
            }
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            PbListView pbListView = this.N;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.j())) {
                return this.N.j().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            if (!vi.isEmpty(this.D1)) {
                return this.D1;
            }
            if (this.f != null) {
                this.D1 = TbadkCoreApplication.getInst().getResources().getString(q89.g());
            }
            return this.D1;
        }
        return (String) invokeV.objValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048740, this) == null) {
            o69 o69Var = new o69(this.f, this, (ViewStub) this.g.findViewById(R.id.obfuscated_res_0x7f091757));
            this.v1 = o69Var;
            o69Var.o(this.S);
            this.v1.p(this.X);
            this.v1.q(this.U);
            this.v1.o(this.S);
            this.v1.s(this.o0);
        }
    }

    public final void q4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048759, this) == null) && (pbFragment = this.f) != null && pbFragment.I5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.f.I5().z())));
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048765, this) == null) {
            this.k.f();
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                wi.z(pbFragment.getContext(), this.L);
            }
            t1();
            m55 m55Var = this.h0;
            if (m55Var != null) {
                m55Var.dismiss();
            }
            w0();
            d55 d55Var = this.I;
            if (d55Var != null) {
                d55Var.dismiss();
            }
            f55 f55Var = this.J;
            if (f55Var != null) {
                f55Var.e();
            }
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048774, this) != null) || !this.f.B5()) {
            return;
        }
        if (this.f.G5() == -1) {
            SkinManager.setViewTextColor(this.E, R.color.CAM_X0110, 1);
        }
        if (this.f.F5() == -1) {
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0110, 1);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048785, this) == null) {
            d55 d55Var = this.Y;
            if (d55Var != null) {
                d55Var.dismiss();
            }
            Dialog dialog = this.Z;
            if (dialog != null) {
                zg.b(dialog, this.f.getPageContext());
            }
            Dialog dialog2 = this.a0;
            if (dialog2 != null) {
                zg.b(dialog2, this.f.getPageContext());
            }
            m55 m55Var = this.W;
            if (m55Var != null) {
                m55Var.dismiss();
            }
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f.getContext());
            this.b = cardForumHeadLayout;
            cardForumHeadLayout.setId(R.id.obfuscated_res_0x7f0919fa);
            this.b.setNeedShowForumlable(false);
            this.b.setJumpCallFrom(2);
            this.b.setBarNameIncludePadding(false);
            this.b.setBarThreadLineSpace(wi.g(this.f.getContext(), R.dimen.tbds26));
            this.b.setAttentionLineSpace(wi.g(this.f.getContext(), R.dimen.tbds26));
            int g3 = wi.g(this.f.getContext(), R.dimen.M_W_X006);
            int g4 = wi.g(this.f.getContext(), R.dimen.tbds16);
            int g5 = wi.g(this.f.getContext(), R.dimen.tbds15);
            int g6 = wi.g(this.f.getContext(), R.dimen.M_W_X007);
            int g7 = wi.g(this.f.getContext(), R.dimen.M_H_X005);
            this.b.setPadding(g3, g4, g3, g5);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.leftMargin = g6;
            marginLayoutParams.rightMargin = g6;
            marginLayoutParams.bottomMargin = g7;
            this.b.setLayoutParams(marginLayoutParams);
            p75 d2 = p75.d(this.b);
            d2.o(R.string.J_X05);
            d2.h(gy9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
            this.b.setAfterClickListener(new o(this));
        }
    }

    public void H2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || (pbLandscapeListView = this.o) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.l1;
        int i5 = 0;
        if (this.o.getFirstVisiblePosition() != 0 && this.o.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i3 = this.o.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i3 = 0;
        }
        View childAt = this.o.getChildAt(0);
        if (childAt != null) {
            i4 = childAt.getTop();
        } else {
            i4 = -1;
        }
        this.e1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.e1.a;
        int j1 = j1(pbReplyTitleViewHolder);
        int measuredHeight = this.G.getMeasuredHeight() + ((int) this.G.getY());
        boolean z3 = true;
        if (this.X0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.G.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.H.J() + this.o.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.o.setSelectionFromTop(this.H.J() + this.o.getHeaderViewsCount(), g2 - i5);
            } else {
                this.o.setSelectionFromTop(this.H.J() + this.o.getHeaderViewsCount(), this.k.j().getMeasuredHeight() - i5);
            }
        } else {
            this.o.setSelectionFromTop(i3, i4);
        }
        if (this.R0 != 6) {
            return;
        }
        this.o.setOnLayoutListener(new l(this, j1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
    }

    public void i2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            wc9 wc9Var = this.I0;
            if (wc9Var != null) {
                wc9Var.j();
            }
            b89 b89Var = this.z1;
            if (b89Var != null) {
                b89Var.c();
            }
            PbTopTipView pbTopTipView = this.q1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.f.hideProgressBar();
            NoNetworkView noNetworkView = this.p;
            if (noNetworkView != null && (bVar = this.V) != null) {
                noNetworkView.e(bVar);
            }
            mz9.d();
            s0();
            z0();
            if (this.h1 != null) {
                xg.a().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.V0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.S1);
            bs6.b().unregister(this.R1);
            this.V1 = null;
            this.j.removeCallbacksAndMessages(null);
            this.H.g0(3);
            View view2 = this.h;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            b79 b79Var = this.H;
            if (b79Var != null) {
                b79Var.i0();
            }
            u99 u99Var = this.u1;
            if (u99Var != null) {
                u99Var.l();
            }
            q99 q99Var = this.w;
            if (q99Var != null) {
                q99Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.q(null);
            }
            this.w1 = null;
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.o.setListViewDragListener(null);
                this.o.K();
                this.o = null;
            }
            AgreeView agreeView = this.D0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.D0.setAfterClickListener(null);
            }
            b1 b1Var = this.e1;
            if (b1Var != null) {
                b1Var.a = null;
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            if (!this.f.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                fc9.t("c10517", this.n0, 2);
            } else if (!this.f.d5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                dk5 I5 = this.f.I5();
                if (I5 != null && (I5.y() || I5.A())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.f.I5().w(false, null);
                    return;
                }
                if (this.q0 != null) {
                    H1();
                }
                EditorTools editorTools = this.q0;
                if (editorTools != null) {
                    this.L0 = false;
                    if (editorTools.p(2) != null) {
                        mz9.c(this.f.getPageContext(), (View) this.q0.p(2).m, false, p2);
                    }
                }
                r1();
            }
        }
    }

    public void l2() {
        b0a b0aVar;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048732, this) != null) || this.f == null) {
            return;
        }
        if (!this.F1 && this.G1 != 17) {
            if (this.n1 && !this.m1 && (b0aVar = this.Q0) != null && b0aVar.q() != null) {
                int i4 = 2;
                if (this.f.z0()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (!this.m1) {
                    i4 = 1;
                }
                fc9.s("c12601", i4, i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f.getPageContext().getPageActivity(), this.Q0.q().getUserId(), this.Q0.q().getUserName(), this.f.Q().X0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        j49 j49Var = this.P0;
        if (j49Var != null && j49Var.k() != null && !vi.isEmpty(this.P0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f.getContext()).createNormalCfg(this.P0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.P0.P()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.P0.k().getId()));
        }
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048752, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.f.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            q4();
            this.f.x6();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && pbFragment.Q() != null && this.f.Q().y1() != null && this.f.Q().y1().N() != null && this.f.Q().y1().N().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.f.Q().S1()).param("fid", this.f.Q().y1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f.Q().b).param("fid", this.f.Q().y1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void w4() {
        PbFragment pbFragment;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().G != null && this.f.Q().G.N() != null && this.f.Q().G.N().isXiuXiuThread()) {
            ThreadData N = this.f.Q().G.N();
            int i4 = 0;
            if (this.f.Q().d1()) {
                i3 = 1;
            } else if (this.f.Q().g1()) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(N.getForum_name());
            if (itemInfo != null) {
                i4 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i3).addParam("fid", N.getFid()).addParam("fname", N.getForum_name()).addParam("post_id", N.getTid()).addParam("obj_id", i4).addParam("obj_name", str).eventStat();
        }
    }

    public final void C3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (pbFragment = this.f) != null && pbFragment.getActivity() != null) {
            if (this.D0.getWidth() != 0 && this.D0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.B0;
                if (waterRippleView == null) {
                    this.B0 = new WaterRippleView(this.f.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.B0);
                    }
                }
                Rect rect = new Rect();
                this.g.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.D0.getImgAgree().getGlobalVisibleRect(rect2);
                int g3 = wi.g(this.f.getActivity(), R.dimen.tbds166);
                int i3 = ((rect2.right + rect2.left) / 2) - g3;
                int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g3;
                int i5 = g3 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i3, 0, 0, i4);
                this.g.addView(this.B0, layoutParams);
                TextView textView = this.J0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public final void b2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().G != null && this.f.Q().G.N() != null && this.f.Q().G.N().isQuestionThread()) {
            ThreadData N = this.f.Q().G.N();
            String K1 = this.f.Q().K1();
            String L1 = this.f.Q().L1();
            int i3 = 5;
            if ("question_answer_invite".equals(K1)) {
                i3 = 1;
            } else if ("3".equals(L1)) {
                i3 = 2;
            } else if ("answer_top".equals(K1)) {
                i3 = 3;
            } else if (this.f.Q().d1()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", N.getId()).param("fid", N.getFid()).param("obj_source", i3));
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E0.getLayoutParams();
            layoutParams.addRule(11);
            this.E0.setLayoutParams(layoutParams);
            if (this.F0.getParent() != null) {
                ((ViewGroup) this.F0.getParent()).removeView(this.F0);
                ((ViewGroup) this.G0.getParent()).removeView(this.G0);
            }
            if (this.H0.getParent() != null) {
                ((ViewGroup) this.H0.getParent()).removeView(this.H0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.F0);
            relativeLayout.addView(this.G0);
            relativeLayout.addView(this.H0);
            this.k.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.k.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public final void l0() {
        j49 j49Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048730, this) == null) && this.A != null && (j49Var = this.P0) != null && j49Var.N() != null && !ListUtils.isEmpty(this.P0.N().getThreadRecommendInfoDataList()) && this.P0.N().getThreadRecommendInfoDataList().get(0) != null && this.v.b().getVisibility() == 0) {
            if (this.v.b().getParent() == null) {
                this.A.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.A.b().getLocationInWindow(iArr);
            if (iArr[1] + this.A.b().getHeight() > this.k.j().getBottom()) {
                this.A.i();
                this.A.g(true);
                return;
            }
            this.A.g(false);
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048750, this) == null) && !this.f2) {
            TiebaStatic.log("c10490");
            this.f2 = true;
            d55 d55Var = new d55(this.f.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(i2, Integer.valueOf(k2));
            d55Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            d55Var.setContentView(inflate);
            d55Var.setYesButtonTag(sparseArray);
            d55Var.setPositiveButton(R.string.grade_button_tips, this.f);
            d55Var.setNegativeButton(R.string.look_again, new s0(this));
            d55Var.create(this.f.getPageContext()).show();
        }
    }

    public final String D0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048588, this, j3)) == null) {
            if (j3 == 0) {
                return "";
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (j3 > 9990000) {
                return "· · ·";
            }
            if (j3 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(((float) j3) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (j3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j3) / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + j3;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final String E0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i3)) == null) {
            if (i3 == 0) {
                return this.f.getString(R.string.obfuscated_res_0x7f0f0f95);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i3 > 9990000) {
                return "· · ·";
            }
            if (i3 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i3 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else if (i3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i3 / 10000.0f) + ExifInterface.LONGITUDE_WEST;
            } else {
                return "" + i3;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void E3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, sparseArray) != null) || this.f == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1394, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03ca, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.f.V());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new a0(this, z2, sparseArray));
        aVar2.a(new b0(this, z2));
    }

    public void U2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, editorTools) == null) {
            this.q0 = editorTools;
            editorTools.setOnCancelClickListener(new t(this));
            this.q0.setId(R.id.obfuscated_res_0x7f091a06);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.q0.getParent() == null) {
                this.g.addView(this.q0, layoutParams);
            }
            this.q0.y(TbadkCoreApplication.getInst().getSkinType());
            this.q0.setActionListener(24, new u(this));
            t1();
            this.f.I5().g(new v(this));
        }
    }

    public void e4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048700, this, z2) == null) && this.o != null && (textView = this.W0) != null && this.h != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(8);
                    this.o.removeHeaderView(this.W0);
                    this.o.setTextViewAdded(false);
                }
                if (this.W0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                    layoutParams.height = g2;
                    this.W0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.W0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + b1(true);
                this.W0.setLayoutParams(layoutParams2);
            }
            M2();
        }
    }

    public void f2(rz9 rz9Var) {
        j49 j49Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, rz9Var) == null) && rz9Var != null && rz9Var.b != null && (j49Var = this.P0) != null && j49Var.N() != null && this.P0.N().getAgreeData() != null) {
            AgreeData agreeData = this.P0.N().getAgreeData();
            String str = rz9Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = rz9Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = rz9Var.b;
            I2(agreeData2, agreeData2.agreeNum);
        }
    }

    public final void g4(j49 j49Var) {
        boolean z2;
        o99 o99Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048709, this, j49Var) == null) && !this.y1 && j49Var != null && j49Var.N() != null && !j49Var.N().isVideoThreadType()) {
            ThreadData N = j49Var.N();
            boolean z3 = false;
            if (N.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (N.getIs_top() == 1) {
                z3 = true;
            }
            q99 q99Var = this.w;
            if (q99Var != null) {
                q99Var.u(j49Var, z2, z3);
            }
            if (N.isShowTitle() && (o99Var = this.v) != null && o99Var.d() != null) {
                q89.b(this.v.d(), N.isHeadLinePost, N.isGoodThread(), N.isTopThread());
            }
            if (F0() != null) {
                F0().J0(j49Var);
            }
        }
    }

    public void j2(TbRichText tbRichText) {
        j49 j49Var;
        b0a b0aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048722, this, tbRichText) == null) && (j49Var = this.P0) != null && j49Var.F() != null && !this.P0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.P0.F().size() && (b0aVar = this.P0.F().get(i3)) != null && b0aVar.q() != null && !StringUtils.isNull(b0aVar.q().getUserId()); i3++) {
                if (this.P0.F().get(i3).q().getUserId().equals(tbRichText.getAuthorId())) {
                    o69 o69Var = this.v1;
                    if (o69Var != null && o69Var.l()) {
                        H3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void r4(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, j49Var) == null) {
            if (j49Var != null && AntiHelper.o(j49Var.N())) {
                wc9 wc9Var = this.I0;
                if (wc9Var != null) {
                    wc9Var.k(false);
                    this.I0.j();
                }
                ViewGroup.LayoutParams layoutParams = this.F0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.F0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            wc9 wc9Var2 = this.I0;
            if (wc9Var2 != null && wc9Var2.g()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.F0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.F0.setLayoutParams(layoutParams2);
            WebPManager.setPureDrawable(this.F0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void s1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048766, this, z2) == null) && this.x0 != null && this.A0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            j49 j49Var = this.P0;
            if (j49Var != null && j49Var.p0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            j49 j49Var2 = this.P0;
            if (j49Var2 != null && j49Var2.q0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.A0.setText(tbSingleton.getAdVertiComment(z3, z4, i1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.x0.startAnimation(alphaAnimation);
            }
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.L0 = true;
        }
    }

    public void u4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) {
            b79 b79Var = this.H;
            if (b79Var != null) {
                b79Var.B0(z2);
                this.H.f0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.a1;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.e1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.p(z2);
            }
            PbFragment pbFragment = this.f;
            if (pbFragment != null) {
                pbFragment.N6(z2);
            }
            if (z2) {
                sa9.d(this.f.getPageContext(), this.f.Q(), this.f.L5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            j49 j49Var = this.P0;
            if (j49Var != null) {
                str = j49Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void F1(j49 j49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, j49Var) != null) || j49Var == null || j49Var.N() == null || !j49Var.N().isInterviewLive() || this.V0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.U0.inflate();
        this.V0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.S);
        this.V0.setCallback(this.f.A5());
        this.V0.setData(this.f, j49Var);
    }

    public final int P0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i3)) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            if (pbLandscapeListView == null) {
                return 0;
            }
            nn adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof a0a)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            if (this.o.getAdapter2() != null && (this.o.getAdapter2() instanceof nn)) {
                i4 = this.o.getAdapter2().n();
            } else {
                i4 = 0;
            }
            if (i3 <= i4) {
                return 0;
            }
            return i3 - i4;
        }
        return invokeI.intValue;
    }

    public void W2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048666, this, str) == null) && this.N != null) {
            int i3 = 0;
            b1 b1Var = this.e1;
            if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.e1.a.getView().getTop() < 0 ? this.e1.a.getView().getHeight() : this.e1.a.getView().getBottom();
            }
            this.N.K(str, i3);
        }
    }

    public void m0(boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.o;
            int i5 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.t0;
            if (view2 != null) {
                if (z2) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                view2.setVisibility(i4);
            }
            PbListView pbListView = this.N;
            if (pbListView != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                pbListView.O(i3);
            }
            View view3 = this.P;
            if (view3 != null) {
                if (z2) {
                    i5 = 8;
                }
                view3.setVisibility(i5);
            }
        }
    }

    public void x3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, str) == null) {
            this.A0.performClick();
            if (!StringUtils.isNull(str) && this.f.I5() != null && this.f.I5().s() != null && this.f.I5().s().i() != null) {
                EditText i3 = this.f.I5().s().i();
                i3.setText(str);
                i3.setSelection(str.length());
            }
        }
    }

    public final void F2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, pbReplyTitleViewHolder, z2) == null) && !this.m1 && this.X0 != null && this.k.j() != null) {
            View u2 = F0().u();
            if (u2 != null) {
                int[] iArr = new int[2];
                u2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.X0.getVisibility() == 0 && i4 - this.k.j().getBottom() <= this.X0.getHeight()) {
                        this.Y0.setVisibility(0);
                        if (i4 > this.k.j().getBottom()) {
                            i3 = -(((this.X0.getHeight() + this.Y0.getHeight()) + this.k.j().getBottom()) - u2.getBottom());
                        } else {
                            i3 = -this.X0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
                            this.X0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.Y0.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.X0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.X0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int J = this.H.J();
            if (J > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null && J > pbLandscapeListView.getFirstVisiblePosition() - this.o.getHeaderViewsCount()) {
                    this.X0.setVisibility(4);
                    return;
                }
                this.X0.setVisibility(0);
                G3(false);
                this.k.a.hideBottomLine();
                if (this.X0.getParent() != null && ((ViewGroup) this.X0.getParent()).getHeight() <= this.X0.getTop()) {
                    this.X0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.d1) {
                        this.c1 = top;
                        this.d1 = false;
                    }
                    int i5 = this.c1;
                    if (top < i5) {
                        i5 = top;
                    }
                    this.c1 = i5;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.G.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = g2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.k.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.k.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.c1) {
                    this.X0.setVisibility(0);
                    G3(false);
                } else if (top < measuredHeight) {
                    this.X0.setVisibility(0);
                    G3(false);
                } else {
                    this.X0.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
                if (z2) {
                    this.d1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.o;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.X0.setVisibility(4);
                    this.k.a.hideBottomLine();
                }
            }
        }
    }

    public void z2(SparseArray<Object> sparseArray, boolean z2) {
        int i3;
        k55 k55Var;
        k55 k55Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048800, this, sparseArray, z2) == null) {
            o55 o55Var = new o55(this.f.getContext());
            o55Var.t(this.f.getString(R.string.obfuscated_res_0x7f0f0320));
            o55Var.q(new w(this, z2));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
            } else {
                i3 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i3 != 2) {
                if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                    i4 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                }
                if (i4 == 0) {
                    k55Var2 = new k55(10, this.f.getString(R.string.obfuscated_res_0x7f0f054f), o55Var);
                } else {
                    k55Var2 = new k55(10, this.f.getString(R.string.obfuscated_res_0x7f0f0540), o55Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                k55Var2.d.setTag(sparseArray2);
                arrayList.add(k55Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                k55 k55Var3 = new k55(13, this.f.getString(R.string.multi_delete), o55Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                k55Var3.d.setTag(sparseArray3);
                arrayList.add(k55Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                k55 k55Var4 = new k55(11, this.f.getString(R.string.forbidden_person), o55Var);
                k55Var4.d.setTag(sparseArray4);
                arrayList.add(k55Var4);
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
                    k55Var = new k55(12, this.f.getString(R.string.un_mute), o55Var);
                } else {
                    k55Var = new k55(12, this.f.getString(R.string.obfuscated_res_0x7f0f0cd0), o55Var);
                }
                k55Var.d.setTag(sparseArray5);
                arrayList.add(k55Var);
            }
            oa9.e(arrayList);
            o55Var.m(arrayList, true);
            m55 m55Var = new m55(this.f.getPageContext(), o55Var);
            this.W = m55Var;
            m55Var.l();
        }
    }

    public final void F3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048599, this, i3, sparseArray) == null) && (pbFragment = this.f) != null && pbFragment.Q() != null && this.f.Q().y1() != null && this.f.Q().y1().n() != null && this.f.Q().y1().k() != null && this.f.Q().y1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            t46 t46Var = new t46(this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.Q().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.Q().y1().n().has_forum_rule.intValue());
            t46Var.i(this.f.Q().y1().k().getId(), this.f.Q().y1().k().getName());
            t46Var.h(this.f.Q().y1().k().getImage_url());
            t46Var.j(this.f.Q().y1().k().getUser_level());
            Q3(sparseArray, i3, t46Var, this.f.Q().y1().U(), true);
        }
    }

    public final void Y3(d55 d55Var, int i3) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048675, this, d55Var, i3) == null) && (pbFragment = this.f) != null && d55Var != null) {
            if (this.B1 == null && this.u != null) {
                this.B1 = new r46(pbFragment.getPageContext(), this.u.c());
            }
            AntiData s5 = this.f.s5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (s5 != null && s5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
                for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                    }
                }
            }
            h35 h35Var = new h35();
            h35Var.j(sparseArray);
            this.B1.B(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
            this.B1.A(h35Var);
            if (i3 != 1 && i3 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.B1.D(str);
            this.B1.C(new c0(this, d55Var));
        }
    }

    public void d4(l35 l35Var, d55.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048696, this, l35Var, eVar) != null) || l35Var == null) {
            return;
        }
        int a2 = l35Var.a();
        int h3 = l35Var.h();
        d55 d55Var = this.I;
        if (d55Var != null) {
            d55Var.show();
        } else {
            this.I = new d55(this.f.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d025e, (ViewGroup) null);
            this.K = inflate;
            this.I.setContentView(inflate);
            this.I.setPositiveButton(R.string.obfuscated_res_0x7f0f0590, eVar);
            this.I.setNegativeButton(R.string.obfuscated_res_0x7f0f0585, new p0(this));
            this.I.setOnCalcelListener(new q0(this));
            this.I.create(this.f.getPageContext()).show();
        }
        EditText editText = (EditText) this.K.findViewById(R.id.obfuscated_res_0x7f0910fb);
        this.L = editText;
        editText.setText("");
        TextView textView = (TextView) this.K.findViewById(R.id.obfuscated_res_0x7f09081a);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.f.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.L, 150);
    }

    public boolean s4(j49 j49Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048769, this, j49Var, z2)) == null) {
            if (j49Var == null) {
                return false;
            }
            if (this.v != null) {
                if (j49Var.N() != null && j49Var.N().getIsNoTitle() == 0 && !j49Var.N().isVideoThreadType()) {
                    if (j49Var.N() != null) {
                        ThreadData N = j49Var.N();
                        N.parserSpecTitleForFrsAndPb(true, K3(j49Var));
                        N.setResource(3);
                        N.setPbTitle("2");
                    }
                    if (j49Var.N().isBJHArticleThreadType()) {
                        this.w.G(this.o);
                        this.v.h(this.o);
                        this.v.a(this.o);
                        this.w.q(this.o);
                        this.w.L(this.P0);
                        if (P1(j49Var)) {
                            this.v.h(this.o);
                        } else {
                            this.v.i(j49Var);
                        }
                    } else {
                        this.w.L(this.P0);
                        if (P1(j49Var)) {
                            this.v.h(this.o);
                        } else {
                            this.v.k(j49Var);
                        }
                    }
                } else if (j49Var.N().getIsNoTitle() == 1) {
                    if (j49Var.N() != null) {
                        this.v.h(this.o);
                        this.w.L(this.P0);
                    }
                } else {
                    this.v.h(this.o);
                    this.w.L(this.P0);
                }
            }
            f4(j49Var.W());
            g4(j49Var);
            this.O0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void H3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048607, this, z2) != null) || this.x0 == null) {
            return;
        }
        if (this.f.I5() != null && this.f.I5().z()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Z2(z3);
        if (this.r0) {
            L3(z2);
        } else {
            s1(z2);
        }
    }

    public void K1(j49 j49Var) {
        mc5 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048617, this, j49Var) != null) || j49Var == null) {
            return;
        }
        if (j49Var.p0()) {
            pbAdFloatViewItemData = j49Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            J1(j49Var, pbAdFloatViewItemData);
        } else {
            y1();
        }
    }

    public void L3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) && this.x0 != null && (textView = this.A0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f05fa);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.x0.startAnimation(alphaAnimation);
            }
            this.w0.setVisibility(0);
            this.x0.setVisibility(0);
            this.L0 = true;
        }
    }

    public final boolean V1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        b0a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                j49 j49Var = this.P0;
                if (j49Var != null && (W = j49Var.W()) != null && W.q() != null) {
                    str = W.q().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y1(j49 j49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, j49Var)) == null) {
            if (j49Var == null) {
                return true;
            }
            ArrayList<b0a> F = j49Var.F();
            if (ListUtils.getCount(F) == 0) {
                return true;
            }
            if (ListUtils.getCount(F) == 1 && ListUtils.getItem(F, 0) != null && ((b0a) ListUtils.getItem(F, 0)).I() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void h2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048712, this, configuration) != null) || configuration == null) {
            return;
        }
        s0();
        if (configuration.orientation == 2) {
            r1();
            t1();
        } else {
            R2();
        }
        p79 p79Var = this.j1;
        if (p79Var != null) {
            p79Var.g();
        }
        this.f.U5();
        this.G.setVisibility(8);
        this.k.v(false);
        this.f.O6(false);
    }

    public final int j1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048721, this, pbReplyTitleViewHolder)) == null) {
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

    public void m2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            if (z2) {
                N3();
            } else {
                u1();
            }
            this.e1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            F2(this.e1.a, false);
        }
    }

    public void o4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048749, this, z2) == null) {
            this.k.B(z2);
            if (z2 && this.T0) {
                this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.N);
                }
                this.i = 2;
            }
        }
    }

    public final void I2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048610, this, agreeData, j3) == null) && agreeData != null && (textView = this.J0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.J0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.J0.setText(D0(j3));
                this.J0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void t2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048772, this, absListView, i3) == null) {
            if (i3 == 0) {
                this.e1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
                F2(this.e1.a, true);
                r0();
                this.H.m0(true);
            }
            this.H.l0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.N1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                l0();
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.N1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i3 == 2 && (rightFloatLayerView = this.N1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public void I3(j49 j49Var) {
        b0a b0aVar;
        fb9 fb9Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, j49Var) == null) && j49Var != null && (b0aVar = this.Q0) != null && b0aVar.q() != null && (fb9Var = this.k) != null) {
            boolean z3 = !this.m1;
            this.n1 = z3;
            fb9Var.A(z3);
            if (this.f.J5() != null) {
                this.f.J5().s(this.n1);
            }
            G2();
            PbFragment pbFragment = this.f;
            if (pbFragment != null && !pbFragment.z0() && !ListUtils.isEmpty(j49Var.o())) {
                k45 k45Var = j49Var.o().get(0);
                if (k45Var != null) {
                    this.k.D(j49Var, k45Var.d(), k45Var.b(), k45Var.a(), k45Var.f());
                }
            } else if (j49Var.k() != null) {
                fb9 fb9Var2 = this.k;
                String name = j49Var.k().getName();
                String id = j49Var.k().getId();
                String image_url = j49Var.k().getImage_url();
                if (j49Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fb9Var2.D(j49Var, name, id, image_url, z2);
            }
            if (this.n1) {
                this.w.Q(j49Var, this.Q0, this.l0);
                View view2 = this.Z0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.w1 == null) {
                    this.w1 = new o0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.o;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.w1);
                    return;
                }
                return;
            }
            View view3 = this.Z0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.Q(j49Var, this.Q0, this.l0);
            this.w1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.o;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public final void J2(j49 j49Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, j49Var) == null) && j49Var != null && j49Var.N() != null) {
            r4(j49Var);
            ImageView imageView = this.E0;
            if (imageView != null && imageView.getContext() != null) {
                if (j49Var.q()) {
                    WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String E0 = E0(j49Var.N().getReply_num());
            TextView textView = this.K0;
            if (textView != null) {
                textView.setText(E0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, j49Var.N()));
            I2(j49Var.N().getAgreeData(), j49Var.N().getAgreeNum());
            if (this.D0 != null && j49Var.N() != null) {
                this.D0.setThreadData(j49Var.N());
                int i3 = 1;
                if (j49Var.N().getAgreeData() != null) {
                    j49Var.N().getAgreeData().isInThread = true;
                }
                this.D0.setData(j49Var.N().getAgreeData());
                o15 o15Var = new o15();
                o15Var.b = 26;
                if (j49Var.N().isVideoThreadType() && j49Var.N().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                o15Var.c = i3;
                PbFragment pbFragment = this.f;
                if (pbFragment != null && pbFragment.Q() != null) {
                    o15Var.j = this.f.Q().getFromForumId();
                    o15Var.f = this.f.Q().x1();
                }
                this.D0.setStatisticData(o15Var);
            }
        }
    }

    public void M3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, view2) != null) || o95.p().l("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.x0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.f.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.f.getContext());
        this.s1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04c8);
        this.s1.setGravity(17);
        this.s1.setPadding(wi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, wi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = wi.g(this.f.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.s1.getParent() == null) {
            frameLayout.addView(this.s1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.f.getContext());
        this.r1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.r1.setHeight(-2);
        this.r1.setWidth(-2);
        this.r1.setFocusable(true);
        this.r1.setOutsideTouchable(false);
        this.r1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.r1);
        PbLandscapeListView pbLandscapeListView = this.o;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new u0(this, i5, i3, i4, view2), 100L);
        }
        o95.p().A("show_long_press_collection_tips", true);
    }

    public void N1(j49 j49Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, j49Var) == null) {
            int i3 = 0;
            this.H.o0(j49Var, false);
            this.H.f0();
            v0();
            o69 o69Var = this.v1;
            if (o69Var != null) {
                o69Var.n();
            }
            ArrayList<b0a> F = j49Var.F();
            if (j49Var.y().b() == 0 || F == null || F.size() < j49Var.y().e()) {
                if (Y1(j49Var)) {
                    b1 b1Var = this.e1;
                    if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.a.getView().getTop() < 0) {
                            bottom = this.e1.a.getView().getHeight();
                        } else {
                            bottom = this.e1.a.getView().getBottom();
                        }
                        i3 = bottom;
                    }
                    if (this.f.d6()) {
                        this.N.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb2), i3);
                    } else {
                        this.N.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb3), i3);
                    }
                } else {
                    if (j49Var.y().b() == 0) {
                        this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.N.n();
                }
            }
            J2(j49Var);
        }
    }

    public void W3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, onItemClickListener) == null) {
            h55 h55Var = this.j0;
            if (h55Var != null) {
                h55Var.d();
                this.j0 = null;
            }
            if (this.P0 == null) {
                return;
            }
            ArrayList<q55> arrayList = new ArrayList<>();
            String string = this.f.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.P0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new q55(string, "", z2, Integer.toString(1)));
            String string2 = this.f.getContext().getString(R.string.my_fans);
            if (this.P0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new q55(string2, "", z3, Integer.toString(5)));
            String string3 = this.f.getContext().getString(R.string.my_attentions);
            if (this.P0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new q55(string3, "", z4, Integer.toString(6)));
            String string4 = this.f.getContext().getString(R.string.myself_only);
            if (this.P0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new q55(string4, "", z5, Integer.toString(7)));
            h55 h55Var2 = new h55(this.f.getPageContext());
            h55Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.j0 = h55Var2;
            h55Var2.k(arrayList, onItemClickListener);
            h55Var2.c();
            this.j0.n();
        }
    }

    public final void J1(j49 j49Var, mc5 mc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048613, this, j49Var, mc5Var) == null) && this.O1 != null && j49Var != null && mc5Var != null && this.f.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                y1();
                return;
            }
            if (this.N1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(mc5Var, this.f.getContext());
                this.N1 = E;
                E.setPageContext(this.f.getPageContext());
                this.O1.removeAllViews();
                this.O1.addView(this.N1);
            }
            if ((this.M1.getTag() instanceof Boolean) && !((Boolean) this.M1.getTag()).booleanValue()) {
                this.N1.setAutoCompleteShown(false);
                this.N1.setTag(this.M1);
                this.N1.c();
            }
            if (mc5Var.a()) {
                return;
            }
            this.N1.setData(mc5Var);
            this.N1.setLogoListener(new r0(this, mc5Var));
            this.N1.setFeedBackListener(new w0(this, mc5Var));
        }
    }

    public final void J3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048615, this, sparseArray, i3, i4) != null) || this.f == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0540, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03ca, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.f.V());
        tBAlertBuilder.w(i3);
        tBAlertBuilder.m(i4);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new y(this, z2, sparseArray));
        aVar2.a(new z(this, z2));
    }

    public void K2(int i3, j49 j49Var, boolean z2, int i4) {
        b0a W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i3), j49Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && j49Var != null && (W = j49Var.W()) != null && W.q() != null) {
            MetaData q2 = W.q();
            q2.setGiftNum(q2.getGiftNum() + i3);
        }
    }

    public void L2(j49 j49Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{j49Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            T3(j49Var, z2, i3, i4);
            this.w.C(i4);
        }
    }

    public void v2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048782, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            w2(i3, str, i4, z2, null);
        }
    }

    public final void Q3(SparseArray<Object> sparseArray, int i3, t46 t46Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048643, this, new Object[]{sparseArray, Integer.valueOf(i3), t46Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.f) == null) {
            return;
        }
        if (this.C1 == null && this.u != null) {
            this.C1 = new u46(pbFragment.getPageContext(), this.u.c(), t46Var, userData);
        }
        this.C1.F(z2);
        AntiData s5 = this.f.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        h35 h35Var = new h35();
        h35Var.j(sparseArray2);
        this.C1.H(new String[]{this.f.getString(R.string.delete_thread_reason_1), this.f.getString(R.string.delete_thread_reason_2), this.f.getString(R.string.delete_thread_reason_3), this.f.getString(R.string.delete_thread_reason_4), this.f.getString(R.string.delete_thread_reason_5)});
        this.C1.G(h35Var);
        if (i3 != 1 && i3 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.C1.J(str);
        this.C1.I(new d0(this, sparseArray));
    }

    public void V3(f55.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            m55 m55Var = this.h0;
            if (m55Var != null) {
                m55Var.dismiss();
                this.h0 = null;
            }
            o55 o55Var = new o55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new k55(0, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f04dc), o55Var));
            }
            if (z3) {
                arrayList.add(new k55(1, this.f.getPageContext().getString(R.string.report_text), o55Var));
            } else if (!z2) {
                arrayList.add(new k55(1, this.f.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c2b), o55Var));
            } else {
                arrayList.add(new k55(1, this.f.getPageContext().getString(R.string.remove_mark), o55Var));
            }
            o55Var.l(arrayList);
            o55Var.q(new h0(this, cVar));
            m55 m55Var2 = new m55(this.f.getPageContext(), o55Var);
            this.i0 = m55Var2;
            m55Var2.l();
        }
    }

    public void S3(j49 j49Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int size;
        int i7;
        PbFragment pbFragment;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{j49Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && j49Var != null && this.o != null) {
            this.P0 = j49Var;
            this.R0 = i3;
            if (j49Var.N() != null) {
                this.f1 = j49Var.N().getCopyThreadRemindType();
                this.l0 = V1(j49Var.N());
            }
            if (j49Var.U() != null) {
                this.b2 = j49Var.U().getUserId();
            }
            F1(j49Var);
            this.T0 = false;
            this.O0 = z2;
            t3();
            u49 u49Var = j49Var.h;
            if (u49Var != null && u49Var.b()) {
                if (this.r == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.f.getContext());
                    this.r = pbThreadPostView;
                    this.o.w(pbThreadPostView, 1);
                    this.r.setData(j49Var);
                    this.r.setChildOnClickLinstener(this.S);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.r;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.o) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            T3(j49Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            I3(j49Var);
            this.w.R(j49Var, this.Q0);
            if (this.z1 == null) {
                this.z1 = new b89(this.f.getPageContext(), this.A1);
            }
            this.z1.a(j49Var.w());
            if (this.f.B5()) {
                if (this.M == null) {
                    xc9 xc9Var = new xc9(this.f.getPageContext());
                    this.M = xc9Var;
                    xc9Var.n();
                    this.M.f(this.c2);
                }
                this.o.setPullRefresh(this.M);
                xc9 xc9Var2 = this.M;
                if (xc9Var2 != null) {
                    xc9Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (j49Var.y().c() == 0 && z2) {
                this.o.setPullRefresh(null);
            } else {
                if (this.M == null) {
                    xc9 xc9Var3 = new xc9(this.f.getPageContext());
                    this.M = xc9Var3;
                    xc9Var3.n();
                    this.M.f(this.c2);
                }
                this.o.setPullRefresh(this.M);
                xc9 xc9Var4 = this.M;
                if (xc9Var4 != null) {
                    xc9Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                v1();
            }
            v0();
            this.H.w0(this.O0);
            this.H.t0(false);
            b79 b79Var = this.H;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            b79Var.u0(z4);
            b79 b79Var2 = this.H;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            b79Var2.v0(z5);
            b79 b79Var3 = this.H;
            if (z3 && this.Z1 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            b79Var3.r0(z6);
            this.H.o0(j49Var, false);
            this.H.f0();
            b79 b79Var4 = this.H;
            if (j49Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            b79Var4.h0(z7, j49Var.f());
            this.w.P(j49Var.W(), j49Var.i0());
            if (j49Var.N() != null && j49Var.N().getPraise() != null && this.e != -1) {
                j49Var.N().getPraise().setIsLike(this.e);
            }
            this.o.removeFooterView(this.b1);
            this.o.addFooterView(this.b1);
            if (TbadkCoreApplication.isLogin()) {
                this.o.setNextPage(this.N);
                this.i = 2;
                v1();
            } else {
                this.T0 = true;
                if (j49Var.y().b() == 1) {
                    if (this.O == null) {
                        PbFragment pbFragment2 = this.f;
                        this.O = new sc9(pbFragment2, pbFragment2);
                    }
                    this.o.setNextPage(this.O);
                } else {
                    this.o.setNextPage(this.N);
                }
                this.i = 3;
            }
            ArrayList<b0a> F = j49Var.F();
            if (j49Var.y().b() != 0 && F != null && F.size() >= j49Var.y().e()) {
                if (z3) {
                    if (this.Z1) {
                        z0();
                        if (j49Var.y().b() != 0) {
                            this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.N.D();
                        this.N.R();
                    }
                } else {
                    this.N.D();
                    this.N.R();
                }
                this.N.n();
            } else {
                if (Y1(j49Var)) {
                    b1 b1Var = this.e1;
                    if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.e1.a.getView().getTop() < 0) {
                            i6 = this.e1.a.getView().getHeight();
                        } else {
                            i6 = this.e1.a.getView().getBottom();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (this.f.d6()) {
                        this.N.y(false);
                        if (ListUtils.isEmpty(j49Var.Q())) {
                            this.N.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb2), i6);
                        }
                    } else if (ListUtils.isEmpty(j49Var.Q())) {
                        this.N.K(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0fb3), i6);
                    }
                    if (this.f.J5() != null && !this.f.J5().p()) {
                        this.f.J5().x();
                    }
                } else {
                    if (j49Var.y().b() == 0) {
                        b0a b0aVar = (b0a) ListUtils.getItem(F, ListUtils.getCount(F) - 1);
                        if (b0aVar != null) {
                            b0aVar.P = false;
                        }
                        this.N.E(-UtilHelper.getDimenPixelSize(R.dimen.tbds36));
                        this.o.setClipChildren(false);
                        this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_all_comments));
                    } else {
                        this.N.E(0);
                        this.N.H(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.N.n();
                }
                if (j49Var.y().b() == 0 || F == null) {
                    N2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (i4 == 0) {
                                        this.o.setSelection(this.H.D() + this.o.getHeaderViewsCount());
                                    } else if (ListUtils.isEmpty(j49Var.Q())) {
                                        if (this.o.getData() == null && j49Var.F() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.o.getData().size() - j49Var.F().size()) + this.o.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.o;
                                        if (i4 > 0) {
                                            i8 = size2 + i4;
                                        } else {
                                            i8 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i8);
                                    } else {
                                        this.o.setSelection(j49Var.F().size() + this.o.getHeaderViewsCount());
                                    }
                                    this.N.g();
                                    this.N.H(this.f.getString(R.string.obfuscated_res_0x7f0f0fac));
                                    this.N.E(0);
                                    this.N.B();
                                }
                            } else if (i5 == 1 && (e3 = h89.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.o.onRestoreInstanceState(e3);
                            } else {
                                this.o.setSelection(0);
                            }
                        } else {
                            this.o.setSelection(0);
                        }
                    } else {
                        this.Z1 = false;
                    }
                } else if (i5 == 1 && (e2 = h89.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.o.post(new n0(this, e2, F, j49Var));
                }
            } else {
                if (this.o.getData() == null && j49Var.F() == null) {
                    size = 0;
                } else {
                    size = (this.o.getData().size() - j49Var.F().size()) + this.o.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.o;
                if (i4 > 1) {
                    i7 = (size + i4) - 2;
                } else {
                    i7 = 0;
                }
                pbLandscapeListView3.setSelection(i7);
            }
            if (this.f1 == h2 && T1()) {
                p0();
            }
            if (this.k1) {
                H2();
                this.k1 = false;
                if (i5 == 0) {
                    j3(true);
                }
            }
            if (j49Var.d == 1 || j49Var.e == 1) {
                if (this.q1 == null) {
                    this.q1 = new PbTopTipView(this.f.getContext());
                }
                if (j49Var.e == 1 && "game_guide".equals(this.f.N5())) {
                    this.q1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0fbe));
                    this.q1.l(this.g, this.S0);
                } else if (j49Var.d == 1 && "game_news".equals(this.f.N5())) {
                    this.q1.setText(this.f.getString(R.string.obfuscated_res_0x7f0f0fbd));
                    this.q1.l(this.g, this.S0);
                }
            }
            M1(j49Var);
            int i9 = this.c;
            if (i9 == -1) {
                i9 = N0();
            }
            this.c = i9;
            this.o.removeFooterView(this.K1.a());
            if (!ListUtils.isEmpty(j49Var.H()) && j49Var.y().b() == 0) {
                this.o.removeFooterView(this.b1);
                this.K1.d(Math.max(this.x0.getMeasuredHeight(), this.M0 / 2));
                this.o.addFooterView(this.K1.a());
                this.K1.f(j49Var);
            }
            J2(j49Var);
            if (j49Var.g0() && this.f.Q().p2() && this.f.K5() != null) {
                this.f.K5().d();
            }
            if (j49Var.f() != 3) {
                K1(j49Var);
            }
            this.A0.setText(TbSingleton.getInstance().getAdVertiComment(j49Var.p0(), j49Var.q0(), i1()));
            if (this.s != null) {
                j49 j49Var2 = this.P0;
                if (j49Var2 != null && j49Var2.k() != null && (pbFragment = this.f) != null && pbFragment.Q() != null) {
                    this.s.r(this.f.Q().b);
                }
                j49 j49Var3 = this.P0;
                if (j49Var3 != null && j49Var3.N() != null && !ListUtils.isEmpty(this.P0.N().getThreadRecommendInfoDataList()) && this.P0.N().getThreadRecommendInfoDataList().get(0) != null && this.P0.N().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.s.q(this.P0.N().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.s.q(null);
                }
            }
            if (this.C != null && this.P0.k() != null) {
                this.C.o(this.P0.k().getSpritePBGuide(), this.P0.k().getImage_url(), this.P0.k().getId());
            }
            if (A3()) {
                this.A.e(this.P0.N());
            } else {
                this.A.d(this.o);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void T3(j49 j49Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{j49Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && j49Var != null && j49Var.N() != null) {
            PbFragment pbFragment = this.f;
            if (pbFragment != null && q89.D(pbFragment)) {
                this.w.G(this.o);
                this.v.h(this.o);
            }
            if (this.f.z0()) {
                if (j49Var.g() != null) {
                    this.m0 = j49Var.g().d();
                    this.n0 = j49Var.g().b();
                }
                if (this.m0 == null && this.f.Q() != null && this.f.Q().X0() != null) {
                    this.m0 = this.f.Q().X0();
                }
            }
            b0a W = j49Var.W();
            r3(W, j49Var);
            int i5 = 8;
            this.w.M(8);
            int i6 = 1;
            if (j49Var.w0()) {
                this.m1 = true;
                this.k.u(true);
                this.k.a.hideBottomLine();
            } else {
                this.m1 = false;
                this.k.u(false);
            }
            if (this.f.J5() != null) {
                this.f.J5().w(this.m1);
            }
            if (W == null) {
                return;
            }
            this.Q0 = W;
            this.w.M(0);
            this.x.e(j49Var, this.o);
            this.z.e(j49Var, this.G1, new k0(this));
            this.v.j(j49Var);
            this.u.h(j49Var, this.O0);
            this.u.g(j49Var);
            this.w.N(this.S0, this.P0, W, this.a2);
            if (this.a1 != null) {
                if (j49Var.i0()) {
                    this.a1.getView().setVisibility(8);
                } else {
                    this.a1.getView().setVisibility(0);
                    y49 y49Var = new y49(y49.g);
                    y49Var.b = j49Var.g;
                    y49Var.c = this.f.d6();
                    y49Var.e = j49Var.f;
                    y49Var.f = j49Var.N().isQuestionThread();
                    this.a1.i(y49Var);
                }
            }
            f4(W);
            g4(j49Var);
            xg.a().post(new l0(this));
            this.y.f(this.o);
            if (W.f1088T) {
                this.y.g(W.S());
                PbLandscapeListView pbLandscapeListView = this.o;
                this.y.c(this.o, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            b79 b79Var = this.H;
            if (b79Var != null && b79Var.B() != null) {
                this.H.B().V(W.f1088T);
            }
            b79 b79Var2 = this.H;
            if (b79Var2 != null) {
                b79Var2.z0(W.f1088T);
            }
            MaskView maskView = this.L1;
            if (W.f1088T) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public void U3(f55.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048659, this, cVar, z2) == null) {
            m55 m55Var = this.i0;
            if (m55Var != null) {
                m55Var.dismiss();
                this.i0 = null;
            }
            o55 o55Var = new o55(this.f.getContext());
            ArrayList arrayList = new ArrayList();
            j49 j49Var = this.P0;
            if (j49Var != null && j49Var.N() != null && !this.P0.N().isBjh()) {
                arrayList.add(new k55(0, this.f.getPageContext().getString(R.string.save_to_emotion), o55Var));
            }
            if (!z2) {
                arrayList.add(new k55(1, this.f.getPageContext().getString(R.string.save_to_local), o55Var));
            }
            o55Var.l(arrayList);
            o55Var.q(new i0(this, cVar));
            m55 m55Var2 = new m55(this.f.getPageContext(), o55Var);
            this.i0 = m55Var2;
            m55Var2.l();
        }
    }

    public SparseArray<Object> Y0(j49 j49Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        b0a W;
        boolean z3;
        o25 o25Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048672, this, new Object[]{j49Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (j49Var == null || (W = j49Var.W()) == null) {
                return null;
            }
            String userId = W.q().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.tag_del_post_id, W.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(j49Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i3 == 1) {
                if (W.q() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, W.q().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, W.q().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, W.q().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, W.S());
                }
                sparseArray.put(R.id.tag_del_post_id, W.S());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(j49Var.V()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<k45> o3 = j49Var.o();
                if (ListUtils.getCount(o3) > 0) {
                    sb = new StringBuilder();
                    for (k45 k45Var : o3) {
                        if (k45Var != null && !StringUtils.isNull(k45Var.d()) && (o25Var = k45Var.h) != null && o25Var.a && !o25Var.c && ((i4 = o25Var.b) == 1 || i4 == 2)) {
                            sb.append(vi.cutString(k45Var.d(), 12));
                            sb.append(this.f.getString(R.string.obfuscated_res_0x7f0f0767));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.f.getString(R.string.obfuscated_res_0x7f0f0538), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void e2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048698, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            m89 m89Var = this.t;
            if (m89Var != null) {
                m89Var.b(z2, i3);
            }
            k79 k79Var = this.B;
            if (k79Var != null) {
                k79Var.l(this.P0.k());
                this.B.h(z2, i3);
            }
        }
    }

    public final boolean g0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048705, this, absListView, i3)) == null) {
            boolean z3 = false;
            if (absListView == null) {
                return false;
            }
            if (i3 > 0) {
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

    public final CustomBlueCheckRadioButton o0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048745, this, str, str2)) == null) {
            Activity pageActivity = this.f.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, wi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.d0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void s3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048768, this, z2, postWriteCallBackData) == null) {
            this.f.hideProgressBar();
            if (z2) {
                s0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                t0();
            } else {
                s0();
            }
        }
    }

    public void g2(int i3) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048707, this, i3) != null) || this.S0 == i3) {
            return;
        }
        this.S0 = i3;
        h4(this.P0, this.O0);
        L2(this.P0, this.O0, this.R0, i3);
        e05 layoutMode = this.f.getBaseFragmentActivity().getLayoutMode();
        if (i3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.f.getBaseFragmentActivity().getLayoutMode().k(this.g);
        SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        n99 n99Var = this.x;
        if (n99Var != null) {
            n99Var.c(i3);
        }
        m99 m99Var = this.u;
        if (m99Var != null) {
            m99Var.e(i3);
        }
        o99 o99Var = this.v;
        if (o99Var != null) {
            o99Var.g(i3);
        }
        q99 q99Var = this.w;
        if (q99Var != null) {
            q99Var.C(i3);
        }
        p99 p99Var = this.y;
        if (p99Var != null) {
            p99Var.e();
        }
        l99 l99Var = this.z;
        if (l99Var != null) {
            l99Var.c();
        }
        MaskView maskView = this.L1;
        if (maskView != null) {
            maskView.f();
        }
        n89 n89Var = this.s;
        if (n89Var != null) {
            n89Var.o();
        }
        j79 j79Var = this.C;
        if (j79Var != null) {
            j79Var.n();
        }
        PbContentCollectionController pbContentCollectionController = this.A;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.N;
        if (pbListView != null) {
            pbListView.e(i3);
        }
        if (this.P != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.P);
            SkinManager.setBackgroundResource(this.P, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.Q != null) {
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.Q);
            SkinManager.setBackgroundResource(this.Q, R.drawable.pb_foot_more_trans_selector);
        }
        d55 d55Var = this.I;
        if (d55Var != null) {
            d55Var.autoChangeSkinType(this.f.getPageContext());
        }
        n4(this.k0);
        this.H.f0();
        xc9 xc9Var = this.M;
        if (xc9Var != null) {
            xc9Var.H(i3);
        }
        EditorTools editorTools = this.q0;
        if (editorTools != null) {
            editorTools.y(i3);
        }
        sc9 sc9Var = this.O;
        if (sc9Var != null) {
            sc9Var.g(i3);
        }
        if (!ListUtils.isEmpty(this.q)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.q) {
                customBlueCheckRadioButton.c();
            }
        }
        t4();
        UtilHelper.setStatusBarBackground(this.h, i3);
        UtilHelper.setStatusBarBackground(this.Z0, i3);
        if (this.D != null) {
            lt5.a(this.f.getPageContext(), this.D);
        }
        p79 p79Var = this.j1;
        if (p79Var != null) {
            p79Var.l(i3);
        }
        fb9 fb9Var = this.k;
        if (fb9Var != null) {
            fb9Var.p(i3);
        }
        LinearLayout linearLayout = this.y0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(wi.g(this.f.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        j49 j49Var = this.P0;
        if (j49Var != null && j49Var.q()) {
            WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.E0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.z0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        r4(this.P0);
        if (this.H0.getVisibility() == 0) {
            this.H0.setBackgroundDrawable(SkinManager.createShapeDrawable(wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.x0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.w0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.s1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.A0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.K0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.K0, wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.J0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.J0, wi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.D0;
        if (agreeView != null) {
            agreeView.x();
            this.D0.Q(i3);
            AgreeData data = this.D0.getData();
            if (data != null) {
                I2(data, data.agreeNum);
            }
        }
        o69 o69Var = this.v1;
        if (o69Var != null) {
            o69Var.m(i3);
        }
        PbThreadPostView pbThreadPostView = this.r;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        CardForumHeadLayout cardForumHeadLayout = this.b;
        if (cardForumHeadLayout != null) {
            cardForumHeadLayout.g();
            p75 d2 = p75.d(this.b);
            d2.o(R.string.J_X05);
            d2.h(gy9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
        }
        wc9 wc9Var = this.I0;
        if (wc9Var != null) {
            wc9Var.i();
        }
        vc9 vc9Var = this.K1;
        if (vc9Var != null) {
            vc9Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.N1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.Y0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.Y0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.P1;
        if (linearLayout2 != null) {
            p75.d(linearLayout2).f(R.color.CAM_X0201);
        }
        ra9 ra9Var = this.Q1;
        if (ra9Var != null) {
            ra9Var.b(i3);
        }
    }

    public void s2(AbsListView absListView, int i3, int i4, int i5) {
        boolean z2;
        PbListView pbListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048767, this, absListView, i3, i4, i5) == null) {
            m89 m89Var = this.t;
            if (m89Var != null) {
                m89Var.c(i3, i4);
            }
            k79 k79Var = this.B;
            if (k79Var != null) {
                k79Var.k(i3, i4);
            }
            fb9 fb9Var = this.k;
            if (fb9Var != null && this.w != null) {
                fb9Var.q(absListView, i3, i4, i5);
            }
            E2();
            this.e1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.e1));
            if (g0(absListView, i3) && !this.k.o()) {
                z2 = true;
            } else {
                z2 = false;
            }
            G3(z2);
            F2(this.e1.a, false);
            r0();
            if (this.N.q() && !this.N.D) {
                b1 b1Var = this.e1;
                if (b1Var != null && (pbReplyTitleViewHolder = b1Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.e1.a.getView().getTop() < 0) {
                        i6 = this.e1.a.getView().getHeight();
                    } else {
                        i6 = this.e1.a.getView().getBottom();
                    }
                } else {
                    i6 = 0;
                }
                this.N.f(i6);
                this.N.D = true;
            }
            if (i3 > this.c && (pbListView = this.N) != null && pbListView.i() != null) {
                wm6.f(this.N.i(), 0);
            }
        }
    }

    public void u2(ArrayList<x25> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, arrayList) == null) {
            if (this.b0 == null) {
                this.b0 = LayoutInflater.from(this.f.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f.getBaseFragmentActivity().getLayoutMode().k(this.b0);
            if (this.a0 == null) {
                Dialog dialog = new Dialog(this.f.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003bf);
                this.a0 = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.a0.setCancelable(true);
                this.p0 = (ScrollView) this.b0.findViewById(R.id.good_scroll);
                this.a0.setContentView(this.b0);
                WindowManager.LayoutParams attributes = this.a0.getWindow().getAttributes();
                attributes.width = wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703ef);
                this.a0.getWindow().setAttributes(attributes);
                this.d0 = new e0(this);
                this.c0 = (LinearLayout) this.b0.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.b0.findViewById(R.id.dialog_button_cancel);
                this.f0 = textView;
                textView.setOnClickListener(new f0(this));
                TextView textView2 = (TextView) this.b0.findViewById(R.id.dialog_button_ok);
                this.e0 = textView2;
                textView2.setOnClickListener(this.S);
            }
            this.c0.removeAllViews();
            this.q = new ArrayList();
            CustomBlueCheckRadioButton o02 = o0("0", this.f.getPageContext().getString(R.string.thread_good_class));
            this.q.add(o02);
            o02.setChecked(true);
            this.c0.addView(o02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    x25 x25Var = arrayList.get(i3);
                    if (x25Var != null && !TextUtils.isEmpty(x25Var.b()) && x25Var.a() > 0) {
                        CustomBlueCheckRadioButton o03 = o0(String.valueOf(x25Var.a()), x25Var.b());
                        this.q.add(o03);
                        View view2 = new View(this.f.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, wi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.c0.addView(view2);
                        this.c0.addView(o03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.p0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = wi.d(this.f.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = wi.d(this.f.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = wi.d(this.f.getPageContext().getPageActivity(), 120.0f);
                }
                this.p0.setLayoutParams(layoutParams2);
                this.p0.removeAllViews();
                LinearLayout linearLayout = this.c0;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.p0.addView(this.c0);
                }
            }
            zg.j(this.a0, this.f.getPageContext());
        }
    }

    public void w2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048787, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            x2(i3, str, i4, z2, str2, false);
        }
    }

    public void x2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048792, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(i2, Integer.valueOf(j2));
            if (i4 == 1002 && !z2) {
                i5 = R.string.report_post_confirm;
            } else {
                i5 = R.string.del_all_post_confirm;
            }
            int i6 = R.string.confirm_title;
            if (i3 == 0) {
                if (i4 == 1002 && !z2) {
                    i5 = R.string.report_thread_confirm;
                } else {
                    i6 = R.string.del_my_thread_confirm;
                    i5 = R.string.del_my_thread_confirm_subtitle;
                }
            }
            this.Y = new d55(this.f.getActivity());
            if (StringUtils.isNull(str2)) {
                this.Y.setMessageId(i5);
            } else {
                this.Y.setOnlyMessageShowCenter(false);
                this.Y.setMessage(str2);
            }
            this.Y.setYesButtonTag(sparseArray);
            this.Y.setPositiveButton(R.string.obfuscated_res_0x7f0f0590, this.f);
            this.Y.setNegativeButton(R.string.obfuscated_res_0x7f0f0585, new x(this));
            this.Y.setCancelable(true);
            this.Y.create(this.f.getPageContext());
            if (z3) {
                J3(sparseArray, i6, i5);
            } else if (z2) {
                J3(sparseArray, i6, i5);
            } else if (B3()) {
                t46 t46Var = new t46(this.f.Q().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f.Q().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.f.Q().y1().n().has_forum_rule.intValue());
                t46Var.i(this.f.Q().y1().k().getId(), this.f.Q().y1().k().getName());
                t46Var.h(this.f.Q().y1().k().getImage_url());
                t46Var.j(this.f.Q().y1().k().getUser_level());
                Q3(sparseArray, i3, t46Var, this.f.Q().y1().U(), false);
            } else {
                Y3(this.Y, i3);
            }
        }
    }
}
