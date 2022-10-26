package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.FirstPraiseToast;
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
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
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
import com.baidu.tieba.av4;
import com.baidu.tieba.cn8;
import com.baidu.tieba.ey4;
import com.baidu.tieba.ho5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.l08;
import com.baidu.tieba.pb.ejection.EjectionAnimationView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.view.PbThreadPostView;
import com.baidu.tieba.pb.pb.main.view.PbTopTipView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.pb.view.PbInterviewStatusView;
import com.baidu.tieba.pu4;
import com.baidu.tieba.ru4;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tz7;
import com.baidu.tieba.uw7;
import com.baidu.tieba.uy7;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wu7;
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
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class yz7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int i2;
    public static int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static int n2;
    public static int o2;
    public static final int p2;
    public static int q2;
    public static cn8.f r2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public NavigationBarCoverTip A1;
    public TextView B;
    public ImageView B0;
    public ho5 B1;
    public TextView C;
    public ImageView C0;
    public ko5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public String D1;
    public fy7 E;
    public View E0;
    public PermissionJudgePolicy E1;
    public pu4 F;
    public d48 F0;
    public long F1;
    public ru4 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public int H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public e48 J;
    public boolean J0;
    public boolean J1;
    public PbListView K;
    public int K0;
    public c48 K1;
    public a48 L;
    public yx4 L0;
    public MaskView L1;
    public View M;
    public boolean M0;
    public final FallingView M1;
    public View N;
    public uv7 N0;
    public RightFloatLayerView N1;
    public View O;
    public PostData O0;
    public final FrameLayout O1;
    public View.OnClickListener P;
    public int P0;
    public boolean P1;
    public TbRichTextView.y Q;
    public int Q0;
    public String Q1;
    public NoNetworkView.b R;
    public boolean R0;
    public CustomMessageListener R1;
    public yu4 S;
    public ViewStub S0;
    public View.OnClickListener S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public CustomMessageListener T1;
    public pu4 U;
    public FrameLayout U0;
    public Handler U1;
    public Dialog V;
    public TextView V0;
    public Runnable V1;
    public Dialog W;
    public View W0;
    public CustomMessageListener W1;
    public View X;
    public View X0;
    public PbFragment.h3 X1;
    public LinearLayout Y;
    public View Y0;
    public boolean Y1;
    public CompoundButton.OnCheckedChangeListener Z;
    public PbReplyTitleViewHolder Z0;
    public View.OnClickListener Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public TextView a0;
    public View a1;
    public boolean a2;
    public int b;
    public TextView b0;
    public int b1;
    public String b2;
    public PbFragment c;
    public String c0;
    public boolean c1;
    public ey4.g c2;
    public RelativeLayout d;
    public yu4 d0;
    public z0 d1;
    public View.OnClickListener d2;
    public View e;
    public yu4 e0;
    public PbEmotionBar e1;
    public final List e2;
    public int f;
    public tu4 f0;
    public int f1;
    public int f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public boolean g2;
    public final z18 h;
    public boolean h0;
    public Runnable h1;
    public boolean h2;
    public y18 i;
    public String i0;
    public PbFakeFloorModel i1;
    public ViewStub j;
    public String j0;
    public ry7 j1;
    public ViewStub k;
    public ww7 k0;
    public qz7 k1;
    public PbLandscapeListView l;
    public ScrollView l0;
    public boolean l1;
    public NoNetworkView m;
    public EditorTools m0;
    public int m1;
    public List n;
    public boolean n0;
    public boolean n1;
    public PbThreadPostView o;
    public View o0;
    public boolean o1;
    public vy7 p;
    public View p0;
    public boolean p1;
    public uy7 q;
    public EjectionAnimationView q0;
    public int q1;
    public uz7 r;
    public Button r0;
    public PbTopTipView r1;
    public tz7 s;
    public View s0;
    public PopupWindow s1;
    public r08 t;
    public View t0;
    public TextView t1;
    public m08 u;
    public LinearLayout u0;
    public List u1;
    public o08 v;
    public HeadImageView v0;
    public w08 v1;
    public q08 w;
    public ImageView w0;
    public ux7 w1;
    public n08 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public p08 y;
    public WaterRippleView y0;
    public boolean y1;
    public l08 z;
    public ImageView z0;
    public hz7 z1;

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z2) == null) {
        }
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? R.id.obfuscated_res_0x7f091c1a : invokeV.intValue;
    }

    public void h3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, i3Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ yz7 g;

        /* renamed from: com.baidu.tieba.yz7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0468a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0468a(a aVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.a1 != null && this.a.g.a1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.a1.getLayoutParams();
                    layoutParams.height = this.a.g.g1;
                    this.a.g.a1.setLayoutParams(layoutParams);
                }
            }
        }

        public a(yz7 yz7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = yz7Var;
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
                if (i2 >= 0 && i2 <= this.g.d.getMeasuredHeight()) {
                    int g1 = this.g.g1(this.b);
                    int i3 = this.a;
                    int i4 = g1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = g1 - i;
                    }
                    if (this.g.a1 == null || (layoutParams = this.g.a1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.d.getMeasuredHeight() && g1 < this.g.d.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.g1;
                    } else {
                        layoutParams.height = this.g.g1;
                    }
                    this.g.a1.setLayoutParams(layoutParams);
                    hh.a().post(new RunnableC0468a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* loaded from: classes6.dex */
        public class a implements i55 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // com.baidu.tieba.i55
            public void a(List list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.q0.setVisibility(0);
                    this.a.a.q0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.A0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.q0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.q0.k();
                }
            }
        }

        public c(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z3();
            k55.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.J2();
            this.a.q0.l();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements uy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.p != null) {
                    this.a.a.p.p();
                }
            }
        }

        public j(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.uy7.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements tz7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null) {
                    this.a.a.r.r();
                }
            }
        }

        public k(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.tz7.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.M6()) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o0 a;

            public a(o0 o0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {o0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = o0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
            }
        }

        public o0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                hh.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements ho5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ yz7 b;

        public a0(yz7 yz7Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = pu4Var;
        }

        @Override // com.baidu.tieba.ho5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.j5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements tw7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        @Override // com.baidu.tieba.tw7
        public /* synthetic */ void onStart() {
            sw7.a(this);
        }

        public b(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.tw7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements ko5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ yz7 b;

        public b0(yz7 yz7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.ko5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.i5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public c0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.c0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.c0 != null && !str.equals(this.a.c0)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public d(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A0 != null && this.a.A0.getData() != null) {
                yz7 yz7Var = this.a;
                yz7Var.D2(yz7Var.A0.getData(), this.a.A0.getData().agreeNum);
                if (!this.a.A0.F()) {
                    yz7 yz7Var2 = this.a;
                    yz7Var2.w2(yz7Var2.A0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public d0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                jh.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public e(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.q1()) {
                        return;
                    }
                    ux4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru4.c a;
        public final /* synthetic */ yz7 b;

        public e0(yz7 yz7Var, ru4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public f(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092084) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092084)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue();
            } else {
                z3 = false;
            }
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09204f, 1);
                    this.a.c.a5(sparseArray);
                    return;
                }
                this.a.v2(view2);
            } else if (z2) {
                sparseArray.put(R.id.obfuscated_res_0x7f09204f, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092038, 1);
                this.a.c.a5(sparseArray);
            } else if (z3) {
                this.a.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ru4.c a;
        public final /* synthetic */ yz7 b;

        public f0(yz7 yz7Var, ru4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public g(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t05 a;
        public final /* synthetic */ yz7 b;

        public g0(yz7 yz7Var, t05 t05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, t05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = t05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.N0 != null && this.b.N1 != null) {
                this.b.N1.g(this.a);
                this.b.N1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public h(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.Q(postData);
                this.a.E.a0();
                this.a.j1.c();
                this.a.m0.q();
                this.a.F3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public h0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.N0 != null && this.a.N0.P() != null && this.a.N0.P().getAuthor() != null && this.a.N0.P().getAuthor().getAlaInfo() != null && this.a.N0.P().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.N0.m());
                    statisticItem2.param("fname", this.a.N0.n());
                    if (this.a.N0.P().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.N0.P().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.N0.R());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.N0.P().getAuthor().getAlaInfo()));
                    if (this.a.N0.P().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.N0.P().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.N0.P().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.N0.P().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.n1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.n1 && this.a.N0 != null && this.a.N0.P() != null && this.a.N0.P().getAuthor() != null && this.a.N0.P().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.P() != null) {
                    this.a.c.P().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public i(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Z3();
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
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

    /* loaded from: classes6.dex */
    public class i0 implements l08.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public i0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.l08.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.a(this.a.l);
                } else {
                    this.a.z.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public j0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            yz7 yz7Var;
            z18 z18Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (z18Var = (yz7Var = this.a).h) != null && z18Var.i != null && yz7Var.N0 != null && this.a.N0.P() != null && !this.a.N0.P().isVideoThreadType() && !this.a.Q1() && this.a.N0.l() != null && !ej.isEmpty(this.a.N0.l().getName())) {
                if ((this.a.E.J() == null || !this.a.E.J().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    if (this.a.c != null && this.a.c.K() != null) {
                        StatisticItem statisticItem = new StatisticItem("c13400");
                        statisticItem.param("tid", this.a.c.K().m2());
                        statisticItem.param("fid", this.a.c.K().getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yz7 b;

        public k0(yz7 yz7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (fj.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c68);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public l(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    ux4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ uv7 c;
        public final /* synthetic */ yz7 d;

        public l0(yz7 yz7Var, Parcelable parcelable, ArrayList arrayList, uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, parcelable, arrayList, uv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yz7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = uv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.K.f();
                    this.d.K.D(this.d.c.getString(R.string.obfuscated_res_0x7f0f0e06));
                    this.d.K.y();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements wu7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public m(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.wu7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public m0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.q1) {
                    this.a.p0();
                    this.a.g2();
                }
                this.a.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(yz7 yz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Integer.valueOf(i)};
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
            this.a = yz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.E != null) {
                this.a.E.a0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public n0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                this.a.p0();
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public o(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A == null) {
                    this.a.B1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(yz7 yz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Integer.valueOf(i)};
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
            this.a = yz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public q(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements m55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public r(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.m55
        public void B(l55 l55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l55Var) == null) {
                Object obj = l55Var.c;
                if ((obj instanceof j15) && EmotionGroupType.isSendAsPic(((j15) obj).getType())) {
                    if (this.a.E1 == null) {
                        this.a.E1 = new PermissionJudgePolicy();
                    }
                    this.a.E1.clearRequestPermissionList();
                    this.a.E1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    j15 j15Var = (j15) l55Var.c;
                    this.a.c.K5().f(j15Var);
                    if (j15Var.i()) {
                        this.a.c.K5().G(null, null);
                    } else {
                        this.a.c.K5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t05 a;
        public final /* synthetic */ yz7 b;

        public r0(yz7 yz7Var, t05 t05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, t05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = t05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.N1.setHomePbFloatLastCloseTime();
                this.b.w1();
                this.b.N1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public s(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.H0 != null && this.a.c.H0.e() != null) {
                if (!this.a.c.H0.e().e()) {
                    this.a.c.H0.a(false);
                }
                this.a.c.H0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.m0 != null && this.a.m0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.v1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.m0.getId());
                    yz7 yz7Var = this.a;
                    yz7Var.v1 = new w08(yz7Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.u1)) {
                        this.a.v1.q(this.a.u1);
                    }
                    this.a.v1.r(this.a.m0);
                }
                this.a.v1.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ yz7 e;

        public s0(yz7 yz7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = yz7Var;
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
                    this.e.s1.showAsDropDown(this.d);
                } else {
                    this.e.s1.showAsDropDown(this.e.t0, this.d.getLeft(), -this.e.t0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements av4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ yz7 b;

        public t(yz7 yz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.av4.e
        public void n0(av4 av4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, av4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203e), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205c)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203f)).booleanValue());
                        return;
                    case 11:
                        if (this.b.X1 != null) {
                            this.b.X1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205c), sparseArray.get(R.id.obfuscated_res_0x7f092049), sparseArray.get(R.id.obfuscated_res_0x7f09204c), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f09204b)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.X5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092094), sparseArray);
                        return;
                    case 13:
                        this.b.q4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public t0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String f1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.K() != null && this.a.c.K().A2()) {
                    f1 = this.a.c.getString(R.string.obfuscated_res_0x7f0f0e1b);
                } else {
                    f1 = this.a.f1();
                }
                if (!StringUtils.isNull(f1) && this.a.N0 != null) {
                    f1 = TbSingleton.getInstance().getAdVertiComment(this.a.N0.q0(), this.a.N0.r0(), f1);
                }
                if (this.a.c != null && this.a.c.K5() != null) {
                    this.a.c.K5().c0(f1);
                }
                if (this.a.x0 != null) {
                    this.a.x0.setText(f1);
                }
                this.a.F3(false);
                this.a.Z3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(yz7 yz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, Integer.valueOf(i)};
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
            this.a = yz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.Q1 = null;
        }
    }

    /* loaded from: classes6.dex */
    public final class v implements cn8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.cn8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public v() {
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
    public class v0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ yz7 b;

        public v0(yz7 yz7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yz7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.J1 || this.a == null || this.b.c.K() == null || !this.b.c.K().D2()) {
                return;
            }
            this.b.J1 = true;
            this.a.X4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ yz7 c;

        public w(yz7 yz7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yz7Var;
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
                    fj.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c68);
                } else {
                    this.c.c.i5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements uw7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public w0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // com.baidu.tieba.uw7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.a6();
            }
        }

        @Override // com.baidu.tieba.uw7.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                if (this.a.t != null) {
                    this.a.t.t();
                }
                this.a.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(yz7 yz7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, alertDialog};
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
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ n75 b;
        public final /* synthetic */ yz7 c;

        public x0(yz7 yz7Var, ReplyPrivacyCheckController replyPrivacyCheckController, n75 n75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, replyPrivacyCheckController, n75Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yz7Var;
            this.a = replyPrivacyCheckController;
            this.b = n75Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.r5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.r5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.m4();
                this.b.n0();
                this.c.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ yz7 c;

        public y(yz7 yz7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yz7Var;
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
                    fj.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c68);
                } else {
                    this.c.c.i5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yz7 a;

        public y0(yz7 yz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(yz7 yz7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yz7Var, alertDialog};
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
    public class z0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public z0() {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948347539, "Lcom/baidu/tieba/yz7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948347539, "Lcom/baidu/tieba/yz7;");
                return;
            }
        }
        i2 = UtilHelper.getLightStatusBarHeight();
        j2 = 3;
        k2 = 0;
        l2 = 3;
        m2 = 4;
        n2 = 5;
        o2 = 6;
        p2 = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        q2 = 1;
        r2 = new v();
    }

    public PostData I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int H0 = H0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (H0 < 0) {
                H0 = 0;
            }
            if (this.E.y(H0) != null && this.E.y(H0) != PostData.K0) {
                i3 = H0 + 1;
            }
            if (!(this.E.x(i3) instanceof PostData)) {
                return null;
            }
            return (PostData) this.E.x(i3);
        }
        return (PostData) invokeV.objValue;
    }

    public void V3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && TbadkCoreApplication.isLogin() && this.N0 != null && this.o1 && !this.n1 && !this.h0 && (postData = this.O0) != null && postData.s() != null && !this.O0.s().getIsLike() && !this.O0.s().hadConcerned() && this.k1 == null) {
            this.k1 = new qz7(this.c);
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            i4();
            this.E.b0(1);
            r08 r08Var = this.t;
            if (r08Var != null) {
                r08Var.l();
            }
            vy7 vy7Var = this.p;
            if (vy7Var != null) {
                vy7Var.k();
            }
            uz7 uz7Var = this.r;
            if (uz7Var != null) {
                uz7Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.E.b0(2);
            r08 r08Var = this.t;
            if (r08Var != null) {
                r08Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    n1().setSystemUiVisibility(4);
                }
            }
            m2();
            W1();
        }
    }

    public yz7(PbFragment pbFragment, View.OnClickListener onClickListener, ww7 ww7Var) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ww7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = new Handler();
        this.l = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
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
        this.g0 = false;
        this.h0 = false;
        this.i0 = null;
        this.j0 = null;
        this.l0 = null;
        this.n0 = false;
        this.r0 = null;
        this.t0 = null;
        this.x0 = null;
        this.J0 = true;
        this.L0 = null;
        this.M0 = false;
        this.Q0 = 3;
        this.R0 = false;
        this.S0 = null;
        this.b1 = 0;
        this.c1 = true;
        this.d1 = new z0();
        this.f1 = 0;
        this.l1 = false;
        this.m1 = 0;
        this.n1 = false;
        this.o1 = false;
        this.p1 = false;
        this.q1 = 0;
        this.y1 = false;
        this.F1 = 0L;
        this.I1 = 0;
        this.R1 = new u0(this, 2921306);
        this.S1 = new l(this);
        this.T1 = new n(this, 2005016);
        this.U1 = new Handler();
        this.W1 = new p(this, 2004009);
        this.Y1 = true;
        this.Z1 = new h0(this);
        this.a2 = false;
        this.b2 = null;
        this.e2 = new ArrayList();
        this.g2 = false;
        this.F1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.P = onClickListener;
        this.k0 = ww7Var;
        this.q1 = fj.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0641, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f090402);
        this.A1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f09184c);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091f7f);
        this.O1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c3a);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092237);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0925af);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f091684);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c73);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + fj.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.setOverScrollMode(2);
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (zm5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.I2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new z18(pbFragment, this.d);
        if (this.c.B5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091498);
            this.j = viewStub;
            viewStub.setVisibility(0);
            y18 y18Var = new y18(pbFragment);
            this.i = y18Var;
            y18Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = fj.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new uw7(new w0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f092595);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917e8);
        fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090892);
        this.w0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.K5()));
        V1();
        w0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917eb);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0917e3);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090896);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917e9);
        this.L1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0914b9);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0917e5);
        this.A0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.A0.s();
        this.A0.setAgreeLongClickListener(new c(this));
        this.A0.setAfterClickListener(new d(this));
        this.A0.setUseDynamicLikeRes("/pb");
        if (this.A0.getAgreeNumView() != null) {
            this.A0.getAgreeNumView().setVisibility(8);
        }
        if (this.A0.getMsgData() != null) {
            this.A0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917e7);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0917ee);
        this.E0 = findViewById;
        if (!ux4.k().h("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917ec);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917ed);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.S1);
        this.C0.setOnClickListener(new e(this));
        Y1();
        d48 d48Var = new d48(this.C0);
        this.F0 = d48Var;
        d48Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917ea);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917e6);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f67);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new m08(this.c, ww7Var);
        this.w = new q08(this.c, ww7Var, this.P);
        fy7 fy7Var = new fy7(this.c, this.l);
        this.E = fy7Var;
        fy7Var.z0(this.P);
        this.E.B0(this.k0);
        this.E.w0(this.Q);
        this.E.y0(this.c.f2);
        this.E.s0(this.d2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.u0(fVar);
        F1();
        z1();
        p08 p08Var = new p08(this.c);
        this.y = p08Var;
        p08Var.f = 2;
        y1();
        this.z.a(this.l);
        this.w.n(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.b().findViewById(R.id.obfuscated_res_0x7f09183c);
        this.N = this.K.b().findViewById(R.id.obfuscated_res_0x7f0917d3);
        if (!this.K.i().booleanValue()) {
            this.N.setVisibility(8);
        }
        View view2 = this.M;
        if (view2 != null) {
            view2.setOnClickListener(this.P);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        View view3 = this.N;
        if (view3 != null) {
            view3.setOnClickListener(this.P);
        }
        this.K.A();
        this.K.o(R.drawable.pb_foot_more_trans_selector);
        this.K.p(R.drawable.pb_foot_more_trans_selector);
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f0925cb);
        this.c.registerListener(this.W1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel K = this.c.K();
        this.i1.S(K.I(), K.E(), K.F(), K.D(), K.J());
        ry7 ry7Var = new ry7(this.c.getPageContext(), this.i1, this.d);
        this.j1 = ry7Var;
        ry7Var.k(new g(this));
        this.j1.n(this.c.k2);
        this.i1.U(new h(this));
        if (this.c.K() != null && !StringUtils.isNull(this.c.K().V1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.K().V1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917f0);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f090400);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091f8c);
        this.Y0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.K() != null && this.c.K().E1()) {
            this.W0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Y0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = i2;
            this.Y0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09186a));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.c0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.f2);
        this.c.registerListener(this.T1);
        this.c.registerListener(this.R1);
        PbFragment pbFragment3 = this.c;
        this.K1 = new c48(pbFragment3, pbFragment3.getUniqueId());
        this.M1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f09099e);
        T2();
        this.M1.setAnimationListener(new i(this));
        k0();
        M2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917d9);
        j0(zm5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && K.H2() && xu7.b().e()) {
            if (this.p == null) {
                this.p = new vy7(this.c.getActivity(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f091814));
            }
            uy7 uy7Var = new uy7(this.l);
            this.q = uy7Var;
            uy7Var.d(new j(this));
        }
        this.r = new uz7(this.c.P(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f09187e));
        tz7 tz7Var = new tz7(this.l);
        this.s = tz7Var;
        tz7Var.d(new k(this));
    }

    public void Z1(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            uy7 uy7Var = this.q;
            if (uy7Var != null) {
                uy7Var.b();
            }
            tz7 tz7Var = this.s;
            if (tz7Var != null) {
                tz7Var.b(z2, i3);
            }
        }
    }

    public void e4(uv7 uv7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048702, this, uv7Var, z2) != null) || uv7Var == null) {
            return;
        }
        o4(uv7Var, z2);
        s0();
    }

    public final void p3(PostData postData, uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048756, this, postData, uv7Var) == null) {
            this.w.H(postData, uv7Var);
        }
    }

    public void y2(f45 f45Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048794, this, f45Var, i3) == null) && (fallingView = this.M1) != null) {
            fallingView.A(f45Var, this.c.getPageContext(), i3, false);
        }
    }

    public void E3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            View view2 = this.o0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public void F3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z2) != null) || this.t0 == null) {
            return;
        }
        V2(this.c.K5().y());
        if (this.n0) {
            J3(z2);
        } else {
            q1(z2);
        }
    }

    public void R2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048646, this, str) == null) && (pbListView = this.K) != null) {
            pbListView.D(str);
        }
    }

    public void U2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, h3Var) == null) {
            this.X1 = h3Var;
        }
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.E.j0(z2);
        }
    }

    public final int X0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048668, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.G1 = z2;
        }
    }

    public void Y2(boolean z2) {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) && (fy7Var = this.E) != null) {
            fy7Var.k0(z2);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public void a3(boolean z2) {
        r08 r08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) && (r08Var = this.t) != null) {
            r08Var.r(z2);
        }
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.E.m0(z2);
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            this.E.r0(z2);
        }
    }

    public void d3(ey4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, gVar) == null) {
            this.c2 = gVar;
            e48 e48Var = this.J;
            if (e48Var != null) {
                e48Var.f(gVar);
            }
        }
    }

    public void e3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, onClickListener) == null) {
            this.d2 = onClickListener;
            fy7 fy7Var = this.E;
            if (fy7Var != null) {
                fy7Var.s0(onClickListener);
            }
        }
    }

    public boolean f0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048703, this, z2)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.u()) {
                this.m0.q();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean f2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i3)) == null) {
            r08 r08Var = this.t;
            if (r08Var != null) {
                return r08Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f3(String str) {
        y18 y18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048706, this, str) == null) && (y18Var = this.i) != null) {
            y18Var.b(str);
        }
    }

    public void f4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048707, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
            this.l1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.m1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void i3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, yVar) == null) {
            this.Q = yVar;
            this.E.w0(yVar);
            this.w1.q(this.Q);
        }
    }

    public void j2(ho hoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, hoVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.b0 = hoVar;
            pbLandscapeListView.W = true;
        }
    }

    public void j3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, bVar) == null) {
            this.R = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void j4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void k3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void l3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void m3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, onClickListener) == null) {
            this.E.A0(onClickListener);
        }
    }

    public void n3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i3) == null) {
            this.H1 = i3;
        }
    }

    public void o3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, onLongClickListener) == null) {
            this.w.G(onLongClickListener);
            this.E.x0(onLongClickListener);
            ux7 ux7Var = this.w1;
            if (ux7Var != null) {
                ux7Var.r(onLongClickListener);
            }
        }
    }

    public void r4(uv7 uv7Var) {
        m08 m08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048767, this, uv7Var) == null) && (m08Var = this.u) != null) {
            m08Var.h(uv7Var, this.M0);
        }
    }

    public void u3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048779, this, z2) == null) {
            this.w.I(z2);
        }
    }

    public void v2(View view2) {
        SparseArray sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048782, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        u2(sparseArray, false);
    }

    public void w3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048787, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void x3(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, list) == null) {
            this.u1 = list;
            w08 w08Var = this.v1;
            if (w08Var != null) {
                w08Var.q(list);
            }
        }
    }

    public void A0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w.D(this.N0, this.O0, this.o1, this.n1);
        }
    }

    public void B3() {
        r08 r08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (r08Var = this.t) != null) {
            r08Var.u(this.l);
        }
    }

    public fy7 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.E;
        }
        return (fy7) invokeV.objValue;
    }

    public LinearLayout E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.u0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public View F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            View view2 = this.X;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907c2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.x == null) {
            this.x = new n08(this.c, this.P);
        }
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.c0;
        }
        return (String) invokeV.objValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a2;
        }
        return invokeV.booleanValue;
    }

    public final void H2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (pbInterviewStatusView = this.T0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.T0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.T0.setLayoutParams(layoutParams);
        }
    }

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.J0;
        }
        return invokeV.booleanValue;
    }

    public void I2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.f != 2) {
            this.l.setNextPage(this.K);
            this.f = 2;
        }
    }

    public FallingView J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.M1;
        }
        return (FallingView) invokeV.objValue;
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return L0(this.l.getFirstVisiblePosition());
        }
        return invokeV.intValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void L3() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (z18Var = this.h) != null && !this.p1) {
            z18Var.D();
            this.p1 = true;
        }
    }

    public Button M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.r0;
        }
        return (Button) invokeV.objValue;
    }

    public void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.l.getHeaderViewsCount();
        }
        return invokeV.intValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2);
        }
        return invokeV.booleanValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            L2();
            r1();
            this.j1.c();
            F3(false);
        }
    }

    public void N3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.L0 == null) {
                this.L0 = new yx4(this.c.getPageContext());
            }
            this.L0.h(true);
        }
    }

    public TextView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.w.r();
        }
        return (TextView) invokeV.objValue;
    }

    public final void O2() {
        r08 r08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (r08Var = this.t) != null) {
            r08Var.q(this.l, this.V0, this.P0);
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            d48 d48Var = this.F0;
            if (d48Var != null) {
                return d48Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void P2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || (handler = this.U1) == null) {
            return;
        }
        Runnable runnable = this.V1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        o oVar = new o(this);
        this.V1 = oVar;
        this.U1.postDelayed(oVar, 2000L);
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.E.i0(this.N0, false);
            this.E.a0();
        }
    }

    public PbInterviewStatusView Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.T0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.y1;
        }
        return invokeV.booleanValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            r08 r08Var = this.t;
            if (r08Var != null && r08Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.t != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return L0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.P1;
        }
        return invokeV.booleanValue;
    }

    public BdTypeListView T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.l;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            d48 d48Var = this.F0;
            if (d48Var == null) {
                return false;
            }
            return d48Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.M1.setFallingFeedbackListener(new t0(this));
        }
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.u()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ux7 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.w1;
        }
        return (ux7) invokeV.objValue;
    }

    public final void V1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (imageView = this.w0) != null) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f0809bb);
        }
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            E2(this.N0);
        }
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048671, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public View Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.M;
        }
        return (View) invokeV.objValue;
    }

    public void Y3() {
        fy7 fy7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && (fy7Var = this.E) != null) {
            fy7Var.C0();
        }
    }

    public PbListView Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.K;
        }
        return (PbListView) invokeV.objValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.m;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void a4() {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || (d48Var = this.F0) == null) {
            return;
        }
        d48Var.o(2);
    }

    public View b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.W0;
        }
        return (View) invokeV.objValue;
    }

    public PbFakeFloorModel c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.i1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public ry7 d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.j1;
        }
        return (ry7) invokeV.objValue;
    }

    public void e0() {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (d48Var = this.F0) != null) {
            d48Var.m(false);
        }
    }

    public r08 e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.t;
        }
        return (r08) invokeV.objValue;
    }

    public void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048712, this) == null) {
            this.c.showProgressBar();
        }
    }

    public void h4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048717, this) == null) && (fallingView = this.M1) != null) {
            fallingView.C();
        }
    }

    public final int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048722, this) == null) && this.e2 != null) {
            while (this.e2.size() > 0) {
                TbImageView tbImageView = (TbImageView) this.e2.remove(0);
                if (tbImageView != null) {
                    tbImageView.P();
                }
            }
        }
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.Q0;
        }
        return invokeV.intValue;
    }

    public View k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public PbThreadPostView l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public RelativeLayout m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return this.D;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final void m2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && (pbFragment = this.c) != null && pbFragment.K5() != null) {
            this.c.K5().E();
        }
    }

    public View n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public void o1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.U0.setVisibility(8);
            }
            z18 z18Var = this.h;
            if (z18Var != null && (view2 = z18Var.d) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void p1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048754, this) != null) || this.t0 == null) {
            return;
        }
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
        this.J0 = false;
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            M2(false);
        }
    }

    public void r0() {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (d48Var = this.F0) != null) {
            d48Var.l(false);
        }
    }

    public void r1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && (editorTools = this.m0) != null) {
            editorTools.o();
            w08 w08Var = this.v1;
            if (w08Var != null) {
                w08Var.m();
            }
        }
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) {
            return this.u.b(this.M0);
        }
        return invokeV.booleanValue;
    }

    public void s1() {
        z18 z18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && (z18Var = this.h) != null) {
            z18Var.q();
        }
    }

    public void s3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            fj.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void t1() {
        yx4 yx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048773, this) == null) && (yx4Var = this.L0) != null) {
            yx4Var.h(false);
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048775, this) == null) {
            this.K.A();
            this.K.R();
        }
    }

    public void u0() {
        r08 r08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048776, this) == null) && (r08Var = this.t) != null) {
            r08Var.b();
        }
    }

    public void u1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            if (this.A == null) {
                B1();
            }
            this.k.setVisibility(8);
            Handler handler = this.U1;
            if (handler != null && (runnable = this.V1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048780, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048784, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048785, this) == null) && (rightFloatLayerView = this.N1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048788, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.y();
                this.K.f();
            }
            t1();
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && (editorTools = this.m0) != null) {
            editorTools.q();
        }
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048790, this)) == null) {
            uz7 uz7Var = this.r;
            if (uz7Var != null && uz7Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048792, this) == null) {
            this.l.A(0L);
            s0();
        }
    }

    public final void y1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048793, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new l08(pbFragment.getContext());
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048797, this) == null) && this.v == null) {
            this.v = new o08(this.c, this.k0);
        }
    }

    public final void A1(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv7Var) != null) || uv7Var == null || uv7Var.P() == null || !uv7Var.P().isInterviewLive() || this.T0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
        this.T0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.T0.setCallback(this.c.z5());
        this.T0.setData(this.c, uv7Var);
    }

    public void J3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && this.t0 != null && (textView = this.x0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f052e);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.t0.startAnimation(alphaAnimation);
            }
            this.s0.setVisibility(0);
            this.t0.setVisibility(0);
            this.J0 = true;
            if (this.e1 != null && !this.w1.l()) {
                this.e1.setVisibility(0);
                M2(true);
            }
        }
    }

    public final int L0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i3)) == null) {
            vn adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof rv7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof vn)) {
                i4 = this.l.getAdapter2().n();
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

    public void S2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048650, this, str) == null) && this.K != null) {
            int i3 = 0;
            z0 z0Var = this.d1;
            if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.G(str, i3);
        }
    }

    public final void d4(uv7 uv7Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, uv7Var) == null) && uv7Var != null && uv7Var.P() != null && !uv7Var.P().isVideoThreadType()) {
            boolean z3 = false;
            if (uv7Var.P().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (uv7Var.P().getIs_top() == 1) {
                z3 = true;
            }
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.p(uv7Var, z2, z3);
            }
            o08 o08Var = this.v;
            if (o08Var != null) {
                o08Var.b(uv7Var, z2, z3);
            }
        }
    }

    public void j0(boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            int i5 = 0;
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view2 = this.p0;
            if (view2 != null) {
                if (z2) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                view2.setVisibility(i4);
            }
            PbListView pbListView = this.K;
            if (pbListView != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                pbListView.L(i3);
            }
            View view3 = this.M;
            if (view3 != null) {
                if (z2) {
                    i5 = 8;
                }
                view3.setVisibility(i5);
            }
        }
    }

    public void v3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, str) == null) {
            this.x0.performClick();
            if (!StringUtils.isNull(str) && this.c.K5() != null && this.c.K5().s() != null && this.c.K5().s().i() != null) {
                EditText i3 = this.c.K5().s().i();
                i3.setText(str);
                i3.setSelection(str.length());
            }
        }
    }

    public final void A2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, pbReplyTitleViewHolder, z2) == null) && !this.n1 && this.W0 != null && this.h.p() != null) {
            View s2 = D0().s();
            if (s2 != null) {
                int[] iArr = new int[2];
                s2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.W0.getVisibility() == 0 && i4 - this.h.p().getBottom() <= this.W0.getHeight()) {
                        this.X0.setVisibility(0);
                        if (i4 > this.h.p().getBottom()) {
                            i3 = -(((this.W0.getHeight() + this.X0.getHeight()) + this.h.p().getBottom()) - s2.getBottom());
                        } else {
                            i3 = -this.W0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W0.getLayoutParams();
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
                            this.W0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.X0.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.W0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.W0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int H = this.E.H();
            if (H > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (H > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.W0.setVisibility(4);
                    return;
                }
                this.W0.setVisibility(0);
                E3(false);
                this.h.a.hideBottomLine();
                if (this.W0.getParent() != null && ((ViewGroup) this.W0.getParent()).getHeight() <= this.W0.getTop()) {
                    this.W0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.c1) {
                        this.b1 = top;
                        this.c1 = false;
                    }
                    int i5 = this.b1;
                    if (top < i5) {
                        i5 = top;
                    }
                    this.b1 = i5;
                }
                if (top == 0 && !pbReplyTitleViewHolder.getView().isShown()) {
                    return;
                }
                if (this.D.getY() < 0.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    measuredHeight = i2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.b1) {
                    this.W0.setVisibility(0);
                    E3(false);
                } else if (top < measuredHeight) {
                    this.W0.setVisibility(0);
                    E3(false);
                } else {
                    this.W0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.c1 = true;
                }
            } else if (this.l.getFirstVisiblePosition() == 0) {
                this.W0.setVisibility(4);
                this.h.a.hideBottomLine();
            }
        }
    }

    public void u2(SparseArray sparseArray, boolean z2) {
        int i3;
        wu4 wu4Var;
        wu4 wu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048778, this, sparseArray, z2) == null) {
            av4 av4Var = new av4(this.c.getContext());
            av4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02e8));
            av4Var.n(new t(this, z2));
            ArrayList arrayList = new ArrayList();
            int i4 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092038) instanceof Integer) {
                i3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092038)).intValue();
            } else {
                i3 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09203e)) && i3 != 2) {
                if (sparseArray.get(R.id.obfuscated_res_0x7f092040) instanceof Integer) {
                    i4 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092040)).intValue();
                }
                if (i4 == 0) {
                    wu4Var2 = new wu4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04c3), av4Var);
                } else {
                    wu4Var2 = new wu4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04b8), av4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray2.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray2.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                wu4Var2.d.setTag(sparseArray2);
                arrayList.add(wu4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09205d) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205d)).booleanValue()) {
                wu4 wu4Var3 = new wu4(13, this.c.getString(R.string.obfuscated_res_0x7f0f0b4c), av4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray3.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203f, sparseArray.get(R.id.obfuscated_res_0x7f09203f));
                sparseArray3.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                wu4Var3.d.setTag(sparseArray3);
                arrayList.add(wu4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092049)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09204a))) && !S1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204b, sparseArray.get(R.id.obfuscated_res_0x7f09204b));
                sparseArray4.put(R.id.obfuscated_res_0x7f09205c, sparseArray.get(R.id.obfuscated_res_0x7f09205c));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204c, sparseArray.get(R.id.obfuscated_res_0x7f09204c));
                wu4 wu4Var4 = new wu4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0671), av4Var);
                wu4Var4.d.setTag(sparseArray4);
                arrayList.add(wu4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092098)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092053, sparseArray.get(R.id.obfuscated_res_0x7f092053));
                sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                sparseArray5.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray5.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray5.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                if (z2) {
                    wu4Var = new wu4(12, this.c.getString(R.string.obfuscated_res_0x7f0f14d6), av4Var);
                } else {
                    wu4Var = new wu4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b58), av4Var);
                }
                wu4Var.d.setTag(sparseArray5);
                arrayList.add(wu4Var);
            }
            r18.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                av4Var.k(arrayList, false);
            } else {
                av4Var.k(arrayList, true);
            }
            yu4 yu4Var = new yu4(this.c.getPageContext(), av4Var);
            this.S = yu4Var;
            yu4Var.k();
        }
    }

    public void A3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            z18 z18Var = this.h;
            if (z18Var != null && (view2 = z18Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public final void J2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
            return;
        }
        ViewParent parent = waterRippleView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.y0);
        }
        TextView textView = this.G0;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public void K2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.z.d(pbLandscapeListView);
            this.v.g(this.l);
            this.w.E(this.l);
            this.x.d(this.l);
            this.u.f(this.l);
        }
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            View view2 = this.a1;
            if (view2 == null || view2.getParent() == null || this.K.m()) {
                return false;
            }
            int bottom = this.a1.getBottom();
            Rect rect = new Rect();
            this.a1.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            uv7 uv7Var = this.N0;
            if (uv7Var == null || uv7Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            FallingView fallingView = this.M1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.M1) {
                this.N1.setTag(null);
                this.N1.setAutoCompleteShown(true);
                this.N1.d();
            }
        }
    }

    public String f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (!ej.isEmpty(this.D1)) {
                return this.D1;
            }
            if (this.c != null) {
                this.D1 = TbadkCoreApplication.getInst().getResources().getString(wz7.b());
            }
            return this.D1;
        }
        return (String) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.h())) {
                return this.K.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a0c));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && this.N0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !t18.k(this.N0.R())) {
            this.F0.f();
            t18.b(this.N0.R());
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            ux7 ux7Var = new ux7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091552));
            this.w1 = ux7Var;
            ux7Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
        }
    }

    public final void m4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048742, this) == null) && (pbFragment = this.c) != null && pbFragment.K5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.K5().y())));
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.h.k();
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.q();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                fj.x(pbFragment.getContext(), this.I);
            }
            r1();
            yu4 yu4Var = this.d0;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            t0();
            pu4 pu4Var = this.F;
            if (pu4Var != null) {
                pu4Var.dismiss();
            }
            ru4 ru4Var = this.G;
            if (ru4Var != null) {
                ru4Var.e();
            }
        }
    }

    public final void p4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048757, this) != null) || !this.c.B5()) {
            return;
        }
        if (this.c.H5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.G5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.h.k();
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.q();
            }
            yu4 yu4Var = this.d0;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
            t0();
            pu4 pu4Var = this.F;
            if (pu4Var != null) {
                pu4Var.dismiss();
            }
            ru4 ru4Var = this.G;
            if (ru4Var != null) {
                ru4Var.e();
            }
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048772, this) == null) {
            pu4 pu4Var = this.U;
            if (pu4Var != null) {
                pu4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                jh.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                jh.b(dialog2, this.c.getPageContext());
            }
            yu4 yu4Var = this.S;
            if (yu4Var != null) {
                yu4Var.dismiss();
            }
        }
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048795, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String B0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j3)) == null) {
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

    public final String C0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0df3);
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

    public final void C3(SparseArray sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f11a9, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b54);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b55);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new y(this, w2, sparseArray));
        aVar2.a(new z(this, w2));
    }

    public void Q2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new q(this));
            this.m0.setId(R.id.obfuscated_res_0x7f0917e4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.w(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new r(this));
            r1();
            this.c.K5().g(new s(this));
        }
    }

    public void a2(hn8 hn8Var) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, hn8Var) == null) && hn8Var != null && hn8Var.b != null && (uv7Var = this.N0) != null && uv7Var.P() != null && this.N0.P().getAgreeData() != null) {
            AgreeData agreeData = this.N0.P().getAgreeData();
            String str = hn8Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = hn8Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = hn8Var.b;
            D2(agreeData2, agreeData2.agreeNum);
        }
    }

    public void c2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048690, this, configuration) != null) || configuration == null) {
            return;
        }
        p0();
        if (configuration.orientation == 2) {
            p1();
            r1();
        } else {
            N2();
        }
        ry7 ry7Var = this.j1;
        if (ry7Var != null) {
            ry7Var.c();
        }
        this.c.a6();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.b7(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                m1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.h2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.h2 = false;
                this.l.setIsLandscape(false);
                int i3 = this.f2;
                if (i3 > 0) {
                    this.l.smoothScrollBy(i3, 0);
                }
            }
            this.t.j(configuration);
            this.U0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    public void c4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048692, this, z2) == null) && this.l != null && (textView = this.V0) != null && this.e != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.l.removeHeaderView(this.V0);
                    this.l.setTextViewAdded(false);
                }
                if (this.V0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.V0.getLayoutParams();
                    layoutParams.height = i2;
                    this.V0.setLayoutParams(layoutParams);
                }
                O2();
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.V0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + X0(true);
                this.V0.setLayoutParams(layoutParams2);
            }
            O2();
            H2();
        }
    }

    public void n4(uv7 uv7Var) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, uv7Var) == null) {
            if (uv7Var != null && AntiHelper.o(uv7Var.P())) {
                d48 d48Var = this.F0;
                if (d48Var != null) {
                    d48Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f080982, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            d48 d48Var2 = this.F0;
            if (d48Var2 != null && d48Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.C0.setLayoutParams(layoutParams2);
            ImageView imageView = this.C0;
            if (UbsABTestHelper.isShareTopRight()) {
                i3 = R.color.CAM_X0105;
            } else {
                i3 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080982, i3, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void q1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) && this.t0 != null && this.x0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            uv7 uv7Var = this.N0;
            if (uv7Var != null && uv7Var.q0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            uv7 uv7Var2 = this.N0;
            if (uv7Var2 != null && uv7Var2.r0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.x0.setText(tbSingleton.getAdVertiComment(z3, z4, f1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.t0.startAnimation(alphaAnimation);
            }
            this.s0.setVisibility(0);
            this.t0.setVisibility(0);
            this.J0 = true;
            if (this.e1 != null && !this.w1.l()) {
                this.e1.setVisibility(0);
                M2(true);
            }
        }
    }

    public void q4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048762, this, z2) == null) {
            fy7 fy7Var = this.E;
            if (fy7Var != null) {
                fy7Var.v0(z2);
                this.E.a0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.o(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.d1.c;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.o(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.a7(z2);
            }
            if (z2) {
                s18.d(this.c.getPageContext(), this.c.K(), this.c.O5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            uv7 uv7Var = this.N0;
            if (uv7Var != null) {
                str = uv7Var.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.c.B5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091493);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091492);
            me5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091497);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091496);
        }
        this.B.setOnClickListener(this.P);
        this.C.setOnClickListener(this.P);
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.c != null && this.m0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.m0.j();
                p1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int H0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int firstVisiblePosition = pbLandscapeListView.getFirstVisiblePosition();
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (lastVisiblePosition > firstVisiblePosition) {
                int i3 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i3];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i4 = 0;
                for (int i5 = firstVisiblePosition; i5 <= lastVisiblePosition; i5++) {
                    int i6 = i5 - firstVisiblePosition;
                    if (i6 < childCount && (childAt = this.l.getChildAt(i6)) != null) {
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

    public final void L2() {
        PbFragment pbFragment;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (pbFragment = this.c) != null && pbFragment.K5() != null && this.m0 != null) {
            j75.a().c(0);
            n75 K5 = this.c.K5();
            K5.M();
            K5.K();
            if (K5.v() != null) {
                WriteImagesInfo v2 = K5.v();
                if (K5.t) {
                    i3 = 1;
                } else {
                    i3 = 9;
                }
                v2.setMaxImagesAllowed(i3);
            }
            K5.d0(SendView.h);
            K5.h(SendView.h);
            s55 m3 = this.m0.m(23);
            s55 m4 = this.m0.m(2);
            s55 m5 = this.m0.m(5);
            if (m4 != null) {
                m4.display();
            }
            if (m5 != null) {
                m5.display();
            }
            if (m3 != null) {
                m3.hide();
            }
            this.m0.invalidate();
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048673, this) == null) && UbsABTestHelper.isShareTopRight()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
            layoutParams.addRule(11);
            this.B0.setLayoutParams(layoutParams);
            if (this.C0.getParent() != null) {
                ((ViewGroup) this.C0.getParent()).removeView(this.C0);
                ((ViewGroup) this.D0.getParent()).removeView(this.D0);
            }
            if (this.E0.getParent() != null) {
                ((ViewGroup) this.E0.getParent()).removeView(this.E0);
            }
            RelativeLayout relativeLayout = new RelativeLayout(TbadkCoreApplication.getInst().getContext());
            relativeLayout.addView(this.C0);
            relativeLayout.addView(this.D0);
            relativeLayout.addView(this.E0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.I1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0() {
        c48 c48Var;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048748, this) != null) || (c48Var = this.K1) == null) {
            return;
        }
        if (c48Var.a() != null && this.K1.a().getParent() != null) {
            i3 = this.l.getPositionForView(this.K1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.K1.a().getTop() + p2 <= this.W0.getBottom()) {
                this.I1 = 1;
                z2 = true;
            } else {
                this.I1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0;
        if (this.I1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.t(z3);
        this.K1.e(z2);
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            this.c.hideProgressBar();
            uv7 uv7Var = this.N0;
            if (uv7Var != null && this.K != null && uv7Var.y() != null && this.N0.y().b() == 0) {
                this.K.v(this.N0.t());
                if (this.N0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.N0.m());
                    statisticItem.param("fname", this.N0.n());
                    statisticItem.param("tid", this.N0.R());
                    TiebaStatic.log(statisticItem);
                }
            }
            x0();
            this.l.A(0L);
            s0();
        }
    }

    public final void z2() {
        z18 z18Var;
        uv7 uv7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048798, this) == null) && this.v != null && (z18Var = this.h) != null && z18Var.p() != null && (uv7Var = this.N0) != null && uv7Var.P() != null && this.N0.P().isQuestionThread() && this.v.c() != null && this.v.c().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.c().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.c().getHeight();
            if (this.v.c().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            z18 z18Var2 = this.h;
            if (height > z18Var2.p().getBottom() && z2) {
                z3 = false;
            }
            z18Var2.H(z3, this.N0.P().getSpan_str());
        }
    }

    public void C2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.m1;
        int i5 = 0;
        if (this.l.getFirstVisiblePosition() != 0 && this.l.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i3 = this.l.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i3 = 0;
        }
        View childAt = this.l.getChildAt(0);
        if (childAt != null) {
            i4 = childAt.getTop();
        } else {
            i4 = -1;
        }
        this.d1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1.c;
        int g1 = g1(pbReplyTitleViewHolder);
        int measuredHeight = this.D.getMeasuredHeight() + ((int) this.D.getY());
        boolean z3 = true;
        if (this.W0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.D.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.E.H() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), i2 - i5);
            } else {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - i5);
            }
        } else {
            this.l.setSelectionFromTop(i3, i4);
        }
        if (this.n1 && this.t != null) {
            this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.P0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, g1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
        }
    }

    public void g2() {
        PostData postData;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048710, this) != null) || this.c == null) {
            return;
        }
        if (!this.G1 && this.H1 != 17) {
            if (this.o1 && !this.n1 && (postData = this.O0) != null && postData.s() != null) {
                int i4 = 2;
                if (this.c.u0()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (!this.n1) {
                    i4 = 1;
                }
                TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", i3).param("obj_type", i4));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.O0.s().getUserId(), this.O0.s().getUserName(), this.c.K().r1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        uv7 uv7Var = this.N0;
        if (uv7Var != null && uv7Var.l() != null && !ej.isEmpty(this.N0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.N0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.N0.R()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.N0.l().getId()));
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.j0));
            } else if (!this.c.b5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                n75 K5 = this.c.K5();
                if (K5 != null && (K5.x() || K5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.K5().w(false, null);
                    return;
                }
                if (this.m0 != null) {
                    C1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.n(2) != null) {
                        cn8.c(this.c.getPageContext(), (View) this.m0.n(2).m, false, r2);
                    }
                }
                p1();
            }
        }
    }

    public final void D1(uv7 uv7Var, t05 t05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, uv7Var, t05Var) == null) && this.O1 != null && uv7Var != null && t05Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                w1();
                return;
            }
            if (this.N1 == null) {
                this.N1 = RightFloatLayerLottieView.F(t05Var, this.c.getContext());
                this.O1.removeAllViews();
                this.O1.addView(this.N1);
            }
            if ((this.M1.getTag() instanceof Boolean) && !((Boolean) this.M1.getTag()).booleanValue()) {
                this.N1.setAutoCompleteShown(false);
                this.N1.setTag(this.M1);
                this.N1.c();
            }
            if (t05Var.a()) {
                return;
            }
            this.N1.setData(t05Var);
            this.N1.setLogoListener(new g0(this, t05Var));
            this.N1.setFeedBackListener(new r0(this, t05Var));
        }
    }

    public void S3(ru4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, cVar, z2) == null) {
            yu4 yu4Var = this.e0;
            if (yu4Var != null) {
                yu4Var.dismiss();
                this.e0 = null;
            }
            av4 av4Var = new av4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            uv7 uv7Var = this.N0;
            if (uv7Var != null && uv7Var.P() != null && !this.N0.P().isBjh()) {
                arrayList.add(new wu4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c1), av4Var));
            }
            if (!z2) {
                arrayList.add(new wu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10c2), av4Var));
            }
            av4Var.j(arrayList);
            av4Var.n(new f0(this, cVar));
            yu4 yu4Var2 = new yu4(this.c.getPageContext(), av4Var);
            this.e0 = yu4Var2;
            yu4Var2.k();
        }
    }

    public void o2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048750, this, absListView, i3) == null) {
            r08 r08Var = this.t;
            if (r08Var != null) {
                r08Var.o(absListView, i3);
            }
            if (!this.h2 && i3 == 0) {
                this.f2 = i1();
                this.d1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
                A2(this.d1.c, true);
                o0();
                this.E.h0(true);
            }
            this.E.g0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.N1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.N1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i3 == 2 && (rightFloatLayerView = this.N1) != null) {
                rightFloatLayerView.r();
            }
        }
    }

    public final void D2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048590, this, agreeData, j3) == null) && agreeData != null && (textView = this.G0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.G0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.G0.setText(B0(j3));
                this.G0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void D3(int i3, SparseArray sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048591, this, i3, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.K() != null && this.c.K().S1() != null && this.c.K().S1().o() != null && this.c.K().S1().l() != null && this.c.K().S1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.obfuscated_res_0x7f092052, Boolean.TRUE);
            }
            jo5 jo5Var = new jo5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
            jo5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
            jo5Var.h(this.c.K().S1().l().getImage_url());
            jo5Var.j(this.c.K().S1().l().getUser_level());
            O3(sparseArray, i3, jo5Var, this.c.K().S1().W(), true);
        }
    }

    public final void W3(pu4 pu4Var, int i3) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048667, this, pu4Var, i3) == null) && (pbFragment = this.c) != null && pu4Var != null) {
            if (this.B1 == null && this.u != null) {
                this.B1 = new ho5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData r5 = this.c.r5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (r5 != null && r5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = r5.getDelThreadInfoList();
                for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                    }
                }
            }
            xs4 xs4Var = new xs4();
            xs4Var.j(sparseArray);
            this.B1.B(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cc), this.c.getString(R.string.obfuscated_res_0x7f0f04cd), this.c.getString(R.string.obfuscated_res_0x7f0f04ce), this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0)});
            this.B1.A(xs4Var);
            if (i3 != 1 && i3 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.B1.D(str);
            this.B1.C(new a0(this, pu4Var));
        }
    }

    public void b4(bt4 bt4Var, pu4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048688, this, bt4Var, eVar) != null) || bt4Var == null) {
            return;
        }
        int a2 = bt4Var.a();
        int h2 = bt4Var.h();
        pu4 pu4Var = this.F;
        if (pu4Var != null) {
            pu4Var.show();
        } else {
            this.F = new pu4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022a, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.dialog_ok, eVar);
            this.F.setNegativeButton(R.string.dialog_cancel, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090f24);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f09074e);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0489), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean o4(uv7 uv7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048752, this, uv7Var, z2)) == null) {
            if (uv7Var == null) {
                return false;
            }
            if (this.v != null) {
                if (uv7Var.P() != null && uv7Var.P().getIsNoTitle() == 0 && !uv7Var.P().isVideoThreadType() && !this.P1) {
                    if (uv7Var.P() != null) {
                        ThreadData P = uv7Var.P();
                        P.parserSpecTitleForFrsAndPb(true, I3(uv7Var));
                        P.setResource(3);
                        P.setPbTitle("2");
                    }
                    if (uv7Var.P().isBJHArticleThreadType()) {
                        this.w.E(this.l);
                        this.v.g(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.J(this.N0);
                        if (J1(uv7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.h(uv7Var);
                        }
                    } else {
                        this.w.J(this.N0);
                        if (J1(uv7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.j(uv7Var);
                        }
                    }
                } else if (uv7Var.P().getIsNoTitle() == 1) {
                    if (uv7Var.P() != null) {
                        this.v.g(this.l);
                        this.w.J(this.N0);
                    }
                } else {
                    this.v.g(this.l);
                    this.w.J(this.N0);
                }
            }
            d4(uv7Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void E1(uv7 uv7Var) {
        t05 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, uv7Var) != null) || uv7Var == null) {
            return;
        }
        if (uv7Var.q0()) {
            pbAdFloatViewItemData = uv7Var.c0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            D1(uv7Var, pbAdFloatViewItemData);
        } else {
            w1();
        }
    }

    public final boolean J1(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, uv7Var)) == null) {
            if (uv7Var == null || uv7Var.P() == null) {
                return false;
            }
            SpannableStringBuilder span_str = uv7Var.P().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0df4).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean O1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        PostData Y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                uv7 uv7Var = this.N0;
                if (uv7Var != null && (Y = uv7Var.Y()) != null && Y.s() != null) {
                    str = Y.s().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int g1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048709, this, pbReplyTitleViewHolder)) == null) {
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

    public void h2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) {
            if (z2) {
                L3();
            } else {
                s1();
            }
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            A2(this.d1.c, false);
        }
    }

    public void k4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            this.h.J(z2);
            if (z2 && this.R0) {
                this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03f6));
                this.l.setNextPage(this.K);
                this.f = 2;
            }
            V1();
        }
    }

    public final void E2(uv7 uv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, uv7Var) == null) && uv7Var != null && uv7Var.P() != null) {
            n4(uv7Var);
            ImageView imageView = this.B0;
            if (imageView != null && imageView.getContext() != null) {
                if (uv7Var.r()) {
                    WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097e, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String C0 = C0(uv7Var.P().getReply_num());
            TextView textView = this.H0;
            if (textView != null) {
                textView.setText(C0);
            }
            TextView textView2 = this.I0;
            if (textView2 != null) {
                textView2.setText(C0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, uv7Var.P()));
            D2(uv7Var.P().getAgreeData(), uv7Var.P().getAgreeNum());
            if (this.A0 != null && uv7Var.P() != null) {
                this.A0.setThreadData(uv7Var.P());
                int i3 = 1;
                if (uv7Var.P().getAgreeData() != null) {
                    uv7Var.P().getAgreeData().isInThread = true;
                }
                this.A0.setData(uv7Var.P().getAgreeData());
                gr4 gr4Var = new gr4();
                gr4Var.b = 26;
                if (uv7Var.P().isVideoThreadType() && uv7Var.P().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                gr4Var.c = i3;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.K() != null) {
                    gr4Var.j = this.c.K().getFromForumId();
                    gr4Var.f = this.c.K().R1();
                }
                this.A0.setStatisticData(gr4Var);
            }
        }
    }

    public void G1(uv7 uv7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, uv7Var) == null) {
            int i3 = 0;
            this.E.i0(uv7Var, false);
            this.E.a0();
            s0();
            ux7 ux7Var = this.w1;
            if (ux7Var != null) {
                ux7Var.n();
            }
            ArrayList G = uv7Var.G();
            if (uv7Var.y().b() == 0 || G == null || G.size() < uv7Var.y().e()) {
                if (ListUtils.getCount(G) != 0 && (ListUtils.getCount(G) != 1 || G.get(0) == null || ((PostData) G.get(0)).D() != 1)) {
                    if (uv7Var.y().b() == 0) {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a0c));
                    } else {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a60));
                    }
                    this.K.k();
                } else {
                    z0 z0Var = this.d1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            bottom = this.d1.c.getView().getHeight();
                        } else {
                            bottom = this.d1.c.getView().getBottom();
                        }
                        i3 = bottom;
                    }
                    if (this.c.k6()) {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e0c), i3);
                    } else {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e0d), i3);
                    }
                }
            }
            E2(uv7Var);
        }
    }

    public void G3(uv7 uv7Var) {
        PostData postData;
        z18 z18Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, uv7Var) == null) && uv7Var != null && (postData = this.O0) != null && postData.s() != null && (z18Var = this.h) != null) {
            boolean z3 = !this.n1;
            this.o1 = z3;
            z18Var.I(z3);
            if (this.c.L5() != null) {
                this.c.L5().s(this.o1);
            }
            B2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.u0() && !ListUtils.isEmpty(uv7Var.p())) {
                zt4 zt4Var = (zt4) uv7Var.p().get(0);
                if (zt4Var != null) {
                    this.h.M(uv7Var, zt4Var.d(), zt4Var.b(), zt4Var.a(), zt4Var.e());
                }
            } else if (uv7Var.l() != null) {
                z18 z18Var2 = this.h;
                String name = uv7Var.l().getName();
                String id = uv7Var.l().getId();
                String image_url = uv7Var.l().getImage_url();
                if (uv7Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z18Var2.M(uv7Var, name, id, image_url, z2);
            }
            if (this.o1) {
                this.w.O(uv7Var, this.O0, this.h0);
                View view2 = this.Y0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.x1 == null) {
                    this.x1 = new m0(this);
                }
                this.l.setListViewDragListener(this.x1);
                return;
            }
            View view3 = this.Y0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.O(uv7Var, this.O0, this.h0);
            this.x1 = null;
            this.l.setListViewDragListener(null);
        }
    }

    public void K3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, view2) != null) || ux4.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.t0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.t1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f0449);
        this.t1.setGravity(17);
        this.t1.setPadding(fj.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, fj.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = fj.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.t1.getParent() == null) {
            frameLayout.addView(this.t1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.s1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.s1.setHeight(-2);
        this.s1.setWidth(-2);
        this.s1.setFocusable(true);
        this.s1.setOutsideTouchable(false);
        this.s1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        this.l.postDelayed(new s0(this, i5, i3, i4, view2), 100L);
        ux4.k().u("show_long_press_collection_tips", true);
    }

    public void U3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onItemClickListener) == null) {
            tu4 tu4Var = this.f0;
            if (tu4Var != null) {
                tu4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            String string = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0275);
            boolean z5 = false;
            if (this.N0.M() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new cv4(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b68);
            if (this.N0.M() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new cv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b65);
            if (this.N0.M() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new cv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b86);
            if (this.N0.M() == 4) {
                z5 = true;
            }
            arrayList.add(new cv4(string4, "", z5, Integer.toString(7)));
            tu4 tu4Var2 = new tu4(this.c.getPageContext());
            tu4Var2.l(R.string.obfuscated_res_0x7f0f0e14);
            this.f0 = tu4Var2;
            tu4Var2.k(arrayList, onItemClickListener);
            tu4Var2.c();
            this.f0.n();
        }
    }

    public void F2(int i3, uv7 uv7Var, boolean z2, int i4) {
        PostData Y;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i3), uv7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && uv7Var != null && (Y = uv7Var.Y()) != null && Y.s() != null) {
            MetaData s2 = Y.s();
            s2.setGiftNum(s2.getGiftNum() + i3);
        }
    }

    public void G2(uv7 uv7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{uv7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            R3(uv7Var, z2, i3, i4);
            this.w.B(i4);
        }
    }

    public void q2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048760, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            r2(i3, str, i4, z2, null);
        }
    }

    public final void H3(SparseArray sparseArray, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048607, this, sparseArray, i3, i4) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b8, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(i3);
        tBAlertBuilder.k(i4);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new w(this, w2, sparseArray));
        aVar2.a(new x(this, w2));
    }

    public final boolean I3(uv7 uv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, uv7Var)) == null) {
            if (uv7Var == null || uv7Var.P() == null) {
                return false;
            }
            if (uv7Var.P().getIsLive() != 1 && uv7Var.P().getThreadType() != 33 && ((uv7Var.P().getTopicData() == null || uv7Var.P().getTopicData().a() == 0) && uv7Var.P().getIs_top() != 1 && uv7Var.P().getIs_good() != 1 && !uv7Var.P().isActInfo() && !uv7Var.P().isInterviewLive() && !uv7Var.P().isVoteThreadType() && uv7Var.P().getYulePostActivityData() == null && ej.isEmpty(uv7Var.P().getCategory()) && !uv7Var.P().isGodThread() && !uv7Var.P().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e2(TbRichText tbRichText) {
        uv7 uv7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, tbRichText) == null) && (uv7Var = this.N0) != null && uv7Var.G() != null && !this.N0.G().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.N0.G().size() && (postData = (PostData) this.N0.G().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
                if (((PostData) this.N0.G().get(i3)).s().getUserId().equals(tbRichText.getAuthorId())) {
                    ux7 ux7Var = this.w1;
                    if (ux7Var != null && ux7Var.l()) {
                        F3(false);
                    }
                    PbEmotionBar pbEmotionBar = this.e1;
                    if (pbEmotionBar != null) {
                        pbEmotionBar.q(true);
                    }
                    postData.s().getName_show();
                    return;
                }
            }
        }
    }

    public void l4(sv7 sv7Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048737, this, sv7Var) != null) || sv7Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(sv7Var.b)) {
            this.h.G(sv7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13fb);
        int e2 = eh.e(sv7Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1374);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02fa);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1132);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02a4), true, new k0(this, sv7Var.c));
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            pu4 pu4Var = new pu4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08b9, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092235);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c5f)).setVisibility(8);
            pu4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(k2, Integer.valueOf(n2));
            pu4Var.setYesButtonTag(sparseArray);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f157e, this.c);
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new q0(this));
            pu4Var.create(this.c.getPageContext()).show();
        }
    }

    public void w2(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048786, this, view2) == null) && this.A0.getData() != null && this.A0.getData().hasAgree && this.c.getActivity() != null) {
            wu7 wu7Var = new wu7(this.c.getContext());
            int f2 = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int f3 = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
            layoutParams.topMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            wu7Var.k(f2);
            wu7Var.j(layoutParams);
            wu7Var.i(false);
            wu7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.N0.R(), this.N0.m());
            wu7Var.l(new m(this));
        }
    }

    public final void O3(SparseArray sparseArray, int i3, jo5 jo5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048635, this, new Object[]{sparseArray, Integer.valueOf(i3), jo5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.C1 == null && this.u != null) {
            this.C1 = new ko5(pbFragment.getPageContext(), this.u.c(), jo5Var, userData);
        }
        this.C1.F(z2);
        AntiData r5 = this.c.r5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (r5 != null && r5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = r5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        xs4 xs4Var = new xs4();
        xs4Var.j(sparseArray2);
        this.C1.H(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cc), this.c.getString(R.string.obfuscated_res_0x7f0f04cd), this.c.getString(R.string.obfuscated_res_0x7f0f04ce), this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0)});
        this.C1.G(xs4Var);
        if (i3 != 1 && i3 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.C1.J(str);
        this.C1.I(new b0(this, sparseArray));
    }

    public void T3(ru4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            yu4 yu4Var = this.d0;
            if (yu4Var != null) {
                yu4Var.dismiss();
                this.d0 = null;
            }
            av4 av4Var = new av4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new wu4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0459), av4Var));
            }
            if (z3) {
                arrayList.add(new wu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1029), av4Var));
            } else if (!z2) {
                arrayList.add(new wu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ab8), av4Var));
            } else {
                arrayList.add(new wu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1004), av4Var));
            }
            av4Var.j(arrayList);
            av4Var.n(new e0(this, cVar));
            yu4 yu4Var2 = new yu4(this.c.getPageContext(), av4Var);
            this.e0 = yu4Var2;
            yu4Var2.k();
        }
    }

    public void Q3(uv7 uv7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
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
        uv7 uv7Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{uv7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && uv7Var != null && this.l != null) {
            this.N0 = uv7Var;
            this.P0 = i3;
            if (uv7Var.P() != null) {
                this.f1 = uv7Var.P().getCopyThreadRemindType();
                if (uv7Var.P().getAnchorLevel() != 0) {
                    this.a2 = true;
                }
                this.h0 = O1(uv7Var.P());
            }
            if (uv7Var.W() != null) {
                this.b2 = uv7Var.W().getUserId();
            }
            A1(uv7Var);
            h0();
            this.R0 = false;
            this.M0 = z2;
            r3();
            dw7 dw7Var = uv7Var.h;
            if (dw7Var != null && dw7Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData(uv7Var);
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            R3(uv7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            G3(uv7Var);
            this.w.P(uv7Var, this.O0);
            if (this.z1 == null) {
                this.z1 = new hz7(this.c.getPageContext(), this.A1);
            }
            this.z1.a(uv7Var.w());
            if (this.c.B5()) {
                if (this.J == null) {
                    e48 e48Var = new e48(this.c.getPageContext());
                    this.J = e48Var;
                    e48Var.n();
                    this.J.f(this.c2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                e48 e48Var2 = this.J;
                if (e48Var2 != null) {
                    e48Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (uv7Var.y().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    e48 e48Var3 = new e48(this.c.getPageContext());
                    this.J = e48Var3;
                    e48Var3.n();
                    this.J.f(this.c2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                e48 e48Var4 = this.J;
                if (e48Var4 != null) {
                    e48Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                t1();
            }
            s0();
            this.E.q0(this.M0);
            this.E.n0(false);
            fy7 fy7Var = this.E;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            fy7Var.o0(z4);
            fy7 fy7Var2 = this.E;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            fy7Var2.p0(z5);
            fy7 fy7Var3 = this.E;
            if (z3 && this.Y1 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            fy7Var3.l0(z6);
            this.E.i0(uv7Var, false);
            this.E.a0();
            fy7 fy7Var4 = this.E;
            if (uv7Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            fy7Var4.c0(z7, uv7Var.g());
            this.w.N(uv7Var.Y(), uv7Var.k0());
            if (uv7Var.P() != null && uv7Var.P().getPraise() != null && this.b != -1) {
                uv7Var.P().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.a1);
            this.l.addFooterView(this.a1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                t1();
            } else {
                this.R0 = true;
                if (uv7Var.y().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new a48(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList G = uv7Var.G();
            if (uv7Var.y().b() != 0 && G != null && G.size() >= uv7Var.y().e()) {
                if (z3) {
                    if (this.Y1) {
                        x0();
                        if (uv7Var.y().b() != 0) {
                            this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e05));
                        }
                    } else {
                        this.K.A();
                        this.K.O();
                    }
                } else {
                    this.K.A();
                    this.K.O();
                }
                this.K.k();
            } else {
                if (ListUtils.getCount(G) != 0 && (ListUtils.getCount(G) != 1 || G.get(0) == null || ((PostData) G.get(0)).D() != 1)) {
                    if (uv7Var.y().b() == 0) {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a0c));
                    } else {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a60));
                    }
                    this.K.k();
                } else {
                    z0 z0Var = this.d1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            i6 = this.d1.c.getView().getHeight();
                        } else {
                            i6 = this.d1.c.getView().getBottom();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (this.c.k6()) {
                        this.K.v(false);
                        if (ListUtils.isEmpty(uv7Var.S())) {
                            this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e0c), i6);
                        }
                    } else if (ListUtils.isEmpty(uv7Var.S())) {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e0d), i6);
                    }
                    if (this.c.L5() != null && !this.c.L5().p()) {
                        this.c.L5().x();
                    }
                }
                if (uv7Var.y().b() == 0 || G == null) {
                    I2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (i4 == 0) {
                                        r08 r08Var = this.t;
                                        if (r08Var != null && r08Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - fj.s(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(uv7Var.S())) {
                                        if (this.l.getData() == null && uv7Var.G() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - uv7Var.G().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i4 > 0) {
                                            i8 = i4 + size2;
                                        } else {
                                            i8 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i8);
                                    } else {
                                        this.l.setSelection(uv7Var.G().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.f();
                                    this.K.D(this.c.getString(R.string.obfuscated_res_0x7f0f0e06));
                                    this.K.y();
                                }
                            } else if (i5 == 1 && (e3 = nz7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.Y1 = false;
                    }
                } else if (i5 == 1 && (e2 = nz7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new l0(this, e2, G, uv7Var));
                }
            } else {
                if (this.l.getData() == null && uv7Var.G() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - uv7Var.G().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i4 > 1) {
                    i7 = (i4 + size) - 2;
                } else {
                    i7 = 0;
                }
                pbLandscapeListView3.setSelection(i7);
            }
            if (this.f1 == j2 && N1()) {
                m0();
            }
            if (this.l1) {
                C2();
                this.l1 = false;
                if (i5 == 0) {
                    g3(true);
                }
            }
            if (uv7Var.d == 1 || uv7Var.e == 1) {
                if (this.r1 == null) {
                    this.r1 = new PbTopTipView(this.c.getContext());
                }
                if (uv7Var.e == 1 && "game_guide".equals(this.c.R5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e18));
                    this.r1.l(this.d, this.Q0);
                } else if (uv7Var.d == 1 && "game_news".equals(this.c.R5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e17));
                    this.r1.l(this.d, this.Q0);
                }
            }
            this.l.removeFooterView(this.K1.a());
            if (!ListUtils.isEmpty(uv7Var.J()) && uv7Var.y().b() == 0) {
                this.l.removeFooterView(this.a1);
                this.K1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
                this.l.addFooterView(this.K1.a());
                this.K1.f(uv7Var);
            }
            E2(uv7Var);
            if (uv7Var.i0() && this.c.K().H2() && this.c.N5() != null) {
                this.c.N5().d();
            }
            if (uv7Var.g() != 3) {
                E1(uv7Var);
            }
            this.x0.setText(TbSingleton.getInstance().getAdVertiComment(uv7Var.q0(), uv7Var.r0(), f1()));
            if (this.p != null && (uv7Var2 = this.N0) != null && uv7Var2.l() != null) {
                this.p.m(this.N0.l().getImage_url());
                this.p.n(this.N0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.K() != null) {
                    this.p.o(this.c.K().b);
                }
            }
            if (this.r != null) {
                uv7 uv7Var3 = this.N0;
                if (uv7Var3 != null && uv7Var3.l() != null && (pbFragment = this.c) != null && pbFragment.K() != null) {
                    this.r.q(this.c.K().b);
                }
                uv7 uv7Var4 = this.N0;
                if (uv7Var4 != null && uv7Var4.P() != null && !ListUtils.isEmpty(this.N0.P().getThreadRecommendInfoDataList())) {
                    this.r.p(this.N0.P().getThreadRecommendInfoDataList().get(0));
                }
            }
        }
    }

    public final void R3(uv7 uv7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{uv7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && uv7Var != null && uv7Var.P() != null) {
            if (this.c.u0()) {
                if (uv7Var.h() != null) {
                    this.i0 = uv7Var.h().d();
                    this.j0 = uv7Var.h().b();
                }
                if (this.i0 == null && this.c.K() != null && this.c.K().r1() != null) {
                    this.i0 = this.c.K().r1();
                }
            }
            PostData Y = uv7Var.Y();
            p3(Y, uv7Var);
            int i5 = 8;
            this.w.K(8);
            int i6 = 1;
            if (uv7Var.x0()) {
                this.n1 = true;
                this.h.B(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new r08(this.c);
                }
                this.t.v(uv7Var, Y, this.l, this.w, this.U0, this.h, this.i0, this.F1);
                this.t.s(this.Z1);
                O2();
            } else {
                this.n1 = false;
                this.h.B(false);
                r08 r08Var = this.t;
                if (r08Var != null) {
                    r08Var.p(this.l);
                }
            }
            if (this.c.L5() != null) {
                this.c.L5().w(this.n1);
            }
            if (Y == null) {
                return;
            }
            this.O0 = Y;
            this.w.K(0);
            SparseArray v2 = this.w.v();
            v2.put(R.id.obfuscated_res_0x7f09203c, Y);
            v2.put(R.id.obfuscated_res_0x7f092055, Boolean.FALSE);
            this.x.e(uv7Var, this.l);
            this.z.e(uv7Var, this.H1, new i0(this));
            this.v.i(uv7Var);
            this.u.h(uv7Var, this.M0);
            this.u.g(uv7Var);
            this.w.L(this.Q0, this.N0, Y, this.Z1);
            if (this.Z0 != null) {
                if (uv7Var.k0()) {
                    this.Z0.getView().setVisibility(8);
                } else {
                    this.Z0.getView().setVisibility(0);
                    hw7 hw7Var = new hw7(hw7.i);
                    if (uv7Var.P() != null) {
                        uv7Var.P().getReply_num();
                    }
                    hw7Var.c = uv7Var.g;
                    uv7Var.c();
                    hw7Var.d = this.c.k6();
                    hw7Var.g = uv7Var.f;
                    hw7Var.h = uv7Var.P().isQuestionThread();
                    this.Z0.h(hw7Var);
                }
            }
            d4(uv7Var);
            hh.a().post(new j0(this));
            this.y.f(this.l);
            if (Y.R) {
                this.y.g(Y.M());
                if (this.l.getHeaderViewsCount() <= 1) {
                    i6 = 0;
                }
                this.y.c(this.l, i6);
            }
            fy7 fy7Var = this.E;
            if (fy7Var != null && fy7Var.z() != null) {
                this.E.z().F(Y.R);
            }
            fy7 fy7Var2 = this.E;
            if (fy7Var2 != null) {
                fy7Var2.t0(Y.R);
            }
            MaskView maskView = this.L1;
            if (Y.R) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public SparseArray U0(uv7 uv7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData Y;
        boolean z3;
        fs4 fs4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{uv7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (uv7Var == null || (Y = uv7Var.Y()) == null) {
                return null;
            }
            String userId = Y.s().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray sparseArray = new SparseArray();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f09203e, Y.M());
                sparseArray.put(R.id.obfuscated_res_0x7f092040, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(uv7Var.X()));
                sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.FALSE);
            } else if (i3 == 1) {
                if (Y.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092049, Y.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204a, Y.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204b, Y.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204c, Y.M());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09203e, Y.M());
                sparseArray.put(R.id.obfuscated_res_0x7f092040, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(uv7Var.X()));
                sparseArray.put(R.id.obfuscated_res_0x7f092084, Boolean.TRUE);
            }
            if (!z3) {
                List<zt4> p3 = uv7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (zt4 zt4Var : p3) {
                        if (zt4Var != null && !StringUtils.isNull(zt4Var.d()) && (fs4Var = zt4Var.f) != null && fs4Var.a && !fs4Var.c && ((i4 = fs4Var.b) == 1 || i4 == 2)) {
                            sb.append(ej.cutString(zt4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0677));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09203d, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04b0), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void W1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (pbFragment = this.c) != null && pbFragment.K() != null && this.c.K().G != null && this.c.K().G.P() != null && this.c.K().G.P().isQuestionThread()) {
            ThreadData P = this.c.K().G.P();
            String e2 = this.c.K().e2();
            String f2 = this.c.K().f2();
            int i3 = 5;
            if ("question_answer_invite".equals(e2)) {
                i3 = 1;
            } else if ("3".equals(f2)) {
                i3 = 2;
            } else if ("answer_top".equals(e2)) {
                i3 = 3;
            } else if (this.c.K().x1()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", P.getId()).param("fid", P.getFid()).param("obj_source", i3));
        }
    }

    public void d2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            vy7 vy7Var = this.p;
            if (vy7Var != null) {
                vy7Var.l();
            }
            uz7 uz7Var = this.r;
            if (uz7Var != null) {
                uz7Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            d48 d48Var = this.F0;
            if (d48Var != null) {
                d48Var.k();
            }
            qz7 qz7Var = this.k1;
            if (qz7Var != null) {
                qz7Var.a();
            }
            hz7 hz7Var = this.z1;
            if (hz7Var != null) {
                hz7Var.c();
            }
            PbTopTipView pbTopTipView = this.r1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.R) != null) {
                noNetworkView.e(bVar);
            }
            cn8.d();
            p0();
            x0();
            if (this.h1 != null) {
                hh.a().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.U1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.b0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            r08 r08Var = this.t;
            if (r08Var != null) {
                r08Var.a();
            }
            fy7 fy7Var = this.E;
            if (fy7Var != null) {
                fy7Var.d0();
            }
            this.l.setOnLayoutListener(null);
            w08 w08Var = this.v1;
            if (w08Var != null) {
                w08Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            q08 q08Var = this.w;
            if (q08Var != null) {
                q08Var.C();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && !this.g2) {
            TiebaStatic.log("c10490");
            this.g2 = true;
            pu4 pu4Var = new pu4(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(k2, Integer.valueOf(m2));
            pu4Var.setTitle(R.string.obfuscated_res_0x7f0f0814);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08b9, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c5f)).setText(R.string.obfuscated_res_0x7f0f07b1);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092235)).setText(R.string.obfuscated_res_0x7f0f0814);
            pu4Var.setContentView(inflate);
            pu4Var.setYesButtonTag(sparseArray);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0813, this.c);
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a92, new p0(this));
            pu4Var.create(this.c.getPageContext()).show();
        }
    }

    public final void z3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048799, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            if (this.A0.getWidth() != 0 && this.A0.getHeight() != 0) {
                WaterRippleView waterRippleView = this.y0;
                if (waterRippleView == null) {
                    this.y0 = new WaterRippleView(this.c.getActivity());
                } else {
                    ViewParent parent = waterRippleView.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(this.y0);
                    }
                }
                Rect rect = new Rect();
                this.d.getGlobalVisibleRect(rect);
                Rect rect2 = new Rect();
                this.A0.getImgAgree().getGlobalVisibleRect(rect2);
                int f2 = fj.f(this.c.getActivity(), R.dimen.tbds166);
                int i3 = ((rect2.right + rect2.left) / 2) - f2;
                int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - f2;
                int i5 = f2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i5, i5);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i3, 0, 0, i4);
                this.d.addView(this.y0, layoutParams);
                TextView textView = this.G0;
                if (textView != null) {
                    textView.setVisibility(4);
                    return;
                }
                return;
            }
            BdLog.e("AgreeView not measured");
        }
    }

    public void b2(int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048686, this, i3) != null) || this.Q0 == i3) {
            return;
        }
        this.Q0 = i3;
        e4(this.N0, this.M0);
        G2(this.N0, this.M0, this.P0, i3);
        zp4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        boolean z2 = true;
        if (i3 != 1) {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        r08 r08Var = this.t;
        if (r08Var != null) {
            r08Var.h(i3);
        }
        n08 n08Var = this.x;
        if (n08Var != null) {
            n08Var.c(i3);
        }
        m08 m08Var = this.u;
        if (m08Var != null) {
            m08Var.e(i3);
        }
        o08 o08Var = this.v;
        if (o08Var != null) {
            o08Var.f(i3);
        }
        q08 q08Var = this.w;
        if (q08Var != null) {
            q08Var.B(i3);
        }
        p08 p08Var = this.y;
        if (p08Var != null) {
            p08Var.e();
        }
        l08 l08Var = this.z;
        if (l08Var != null) {
            l08Var.c();
        }
        MaskView maskView = this.L1;
        if (maskView != null) {
            maskView.f();
        }
        uz7 uz7Var = this.r;
        if (uz7Var != null) {
            uz7Var.n();
        }
        PbListView pbListView = this.K;
        if (pbListView != null) {
            pbListView.d(i3);
        }
        if (this.M != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.M);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        pu4 pu4Var = this.F;
        if (pu4Var != null) {
            pu4Var.autoChangeSkinType(this.c.getPageContext());
        }
        j4(this.g0);
        this.E.a0();
        e48 e48Var = this.J;
        if (e48Var != null) {
            e48Var.H(i3);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        a48 a48Var = this.L;
        if (a48Var != null) {
            a48Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        p4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.Y0, i3);
        if (this.A != null) {
            me5.a(this.c.getPageContext(), this.A);
        }
        ry7 ry7Var = this.j1;
        if (ry7Var != null) {
            ry7Var.h(i3);
        }
        z18 z18Var = this.h;
        if (z18Var != null) {
            r08 r08Var2 = this.t;
            if (r08Var2 != null) {
                r08Var2.i(i3);
            } else {
                z18Var.v(i3);
            }
        }
        HeadImageView headImageView = this.v0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(fj.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        uv7 uv7Var = this.N0;
        if (uv7Var != null && uv7Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097e, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080980, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f0809bb, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        n4(this.N0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.t1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.s();
            this.A0.L(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                D2(data, data.agreeNum);
            }
        }
        ux7 ux7Var = this.w1;
        if (ux7Var != null) {
            ux7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        d48 d48Var = this.F0;
        if (d48Var != null) {
            d48Var.j();
        }
        c48 c48Var = this.K1;
        if (c48Var != null) {
            c48Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.N1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.obfuscated_res_0x7f092405), (int) R.color.CAM_X0105);
    }

    public final boolean d0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, absListView, i3)) == null) {
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

    public final CustomBlueCheckRadioButton l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048733, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, fj.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.Z);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void q3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048761, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                p0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                q0();
            } else {
                p0();
            }
        }
    }

    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048730, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            m4();
            this.c.K6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.K() != null && this.c.K().S1() != null && this.c.K().S1().P() != null && this.c.K().S1().P().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.K().n2()).param("fid", this.c.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.K().b).param("fid", this.c.K().S1().m()).param("obj_locate", 1).param("uid", this.c.K().S1().P().getAuthor().getUserId()));
            }
        }
    }

    public void n2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        q08 q08Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048745, this, absListView, i3, i4, i5) == null) {
            uy7 uy7Var = this.q;
            if (uy7Var != null) {
                uy7Var.c(i3, i4);
            }
            tz7 tz7Var = this.s;
            if (tz7Var != null) {
                tz7Var.c(i3, i4);
            }
            r08 r08Var = this.t;
            if (r08Var != null) {
                r08Var.n(absListView, i3, i4, i5);
            }
            z18 z18Var = this.h;
            if (z18Var != null && (q08Var = this.w) != null) {
                z18Var.x(q08Var.t());
            }
            z2();
            z0 z0Var = this.d1;
            z0Var.a = i3;
            z0Var.b = this.l.getHeaderViewsCount();
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            E3(d0(absListView, i3));
            int i6 = 0;
            A2(this.d1.c, false);
            o0();
            if (this.K.n() && !this.K.C) {
                z0 z0Var2 = this.d1;
                if (z0Var2 != null && (pbReplyTitleViewHolder = z0Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.d1.c.getView().getTop() < 0) {
                        bottom = this.d1.c.getView().getHeight();
                    } else {
                        bottom = this.d1.c.getView().getBottom();
                    }
                    i6 = bottom;
                }
                this.K.e(i6);
                this.K.C = true;
            }
        }
    }

    public void p2(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e5, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.obfuscated_res_0x7f090ce8);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new c0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.obfuscated_res_0x7f090ce7);
                TextView textView = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907c1);
                this.b0 = textView;
                textView.setOnClickListener(new d0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907c2);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton l02 = l0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1400));
            this.n.add(l02);
            l02.setChecked(true);
            this.Y.addView(l02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ns4 ns4Var = (ns4) arrayList.get(i3);
                    if (ns4Var != null && !TextUtils.isEmpty(ns4Var.b()) && ns4Var.a() > 0) {
                        CustomBlueCheckRadioButton l03 = l0(String.valueOf(ns4Var.a()), ns4Var.b());
                        this.n.add(l03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, fj.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Y.addView(view2);
                        this.Y.addView(l03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = fj.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = fj.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = fj.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.l0.setLayoutParams(layoutParams2);
                this.l0.removeAllViews();
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l0.addView(this.Y);
                }
            }
            jh.j(this.W, this.c.getPageContext());
        }
    }

    public void r2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048765, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            s2(i3, str, i4, z2, str2, false);
        }
    }

    public void s2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048770, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            if (i4 == 1002 && !z2) {
                i5 = R.string.obfuscated_res_0x7f0f1026;
            } else {
                i5 = R.string.obfuscated_res_0x7f0f04ad;
            }
            int i6 = R.string.obfuscated_res_0x7f0f0445;
            if (i3 == 0) {
                if (i4 == 1002 && !z2) {
                    i5 = R.string.obfuscated_res_0x7f0f102a;
                } else {
                    i6 = R.string.obfuscated_res_0x7f0f04b1;
                    i5 = R.string.obfuscated_res_0x7f0f04b2;
                }
            }
            this.U = new pu4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i5);
            } else {
                this.U.setOnlyMessageShowCenter(false);
                this.U.setMessage(str2);
            }
            this.U.setYesButtonTag(sparseArray);
            this.U.setPositiveButton(R.string.dialog_ok, this.c);
            this.U.setNegativeButton(R.string.dialog_cancel, new u(this));
            this.U.setCancelable(true);
            this.U.create(this.c.getPageContext());
            if (z3) {
                H3(sparseArray, i6, i5);
            } else if (z2) {
                H3(sparseArray, i6, i5);
            } else if (y3()) {
                jo5 jo5Var = new jo5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
                jo5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
                jo5Var.h(this.c.K().S1().l().getImage_url());
                jo5Var.j(this.c.K().S1().l().getUser_level());
                O3(sparseArray, i3, jo5Var, this.c.K().S1().W(), false);
            } else {
                W3(this.U, i3);
            }
        }
    }

    public void t2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048774, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092040, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09205c, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09203f, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            if (z2) {
                C3(sparseArray);
            } else {
                D3(i3, sparseArray);
            }
        }
    }

    public void z0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048796, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1252));
            } else if (z3) {
                if (ej.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c68);
                }
                this.c.showToast(str);
            }
        }
    }
}
