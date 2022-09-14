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
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.RightFloatLayerLottieView;
import com.baidu.tbadk.widget.RightFloatLayerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ObservedChangeRelativeLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.au4;
import com.baidu.tieba.cu4;
import com.baidu.tieba.gm8;
import com.baidu.tieba.lu4;
import com.baidu.tieba.lx4;
import com.baidu.tieba.mz7;
import com.baidu.tieba.nn5;
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
import com.baidu.tieba.qn5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.uy7;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.vv7;
import com.baidu.tieba.vx7;
import com.baidu.tieba.xt7;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class zy7 {
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
    public static gm8.f r2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public NavigationBarCoverTip A1;
    public TextView B;
    public ImageView B0;
    public nn5 B1;
    public TextView C;
    public ImageView C0;
    public qn5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public String D1;
    public gx7 E;
    public View E0;
    public PermissionJudgePolicy E1;
    public au4 F;
    public e38 F0;
    public long F1;
    public cu4 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public int H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public f38 J;
    public boolean J0;
    public boolean J1;
    public PbListView K;
    public int K0;
    public d38 K1;
    public b38 L;
    public fx4 L0;
    public MaskView L1;
    public View M;
    public boolean M0;
    public final FallingView M1;
    public View N;
    public vu7 N0;
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
    public ju4 S;
    public ViewStub S0;
    public View.OnClickListener S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public CustomMessageListener T1;
    public au4 U;
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
    public lx4.g c2;
    public RelativeLayout d;
    public ju4 d0;
    public z0 d1;
    public View.OnClickListener d2;
    public View e;
    public ju4 e0;
    public PbEmotionBar e1;
    public final List<TbImageView> e2;
    public int f;
    public eu4 f0;
    public int f1;
    public int f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public boolean g2;
    public final a18 h;
    public boolean h0;
    public Runnable h1;
    public boolean h2;
    public z08 i;
    public String i0;
    public PbFakeFloorModel i1;
    public ViewStub j;
    public String j0;
    public sx7 j1;
    public ViewStub k;
    public xv7 k0;
    public ry7 k1;
    public PbLandscapeListView l;
    public ScrollView l0;
    public boolean l1;
    public NoNetworkView m;
    public EditorTools m0;
    public int m1;
    public List<CustomBlueCheckRadioButton> n;
    public boolean n0;
    public boolean n1;
    public PbThreadPostView o;
    public View o0;
    public boolean o1;
    public wx7 p;
    public View p0;
    public boolean p1;
    public vx7 q;
    public EjectionAnimationView q0;
    public int q1;
    public vy7 r;
    public Button r0;
    public PbTopTipView r1;
    public uy7 s;
    public View s0;
    public PopupWindow s1;
    public sz7 t;
    public View t0;
    public TextView t1;
    public nz7 u;
    public LinearLayout u0;
    public List<String> u1;
    public pz7 v;
    public HeadImageView v0;
    public xz7 v1;
    public rz7 w;
    public ImageView w0;
    public vw7 w1;
    public oz7 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public qz7 y;
    public WaterRippleView y0;
    public boolean y1;
    public mz7 z;
    public ImageView z0;
    public iy7 z1;

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
        public final /* synthetic */ zy7 g;

        /* renamed from: com.baidu.tieba.zy7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0485a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0485a(a aVar) {
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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.g.a1 == null || this.a.g.a1.getLayoutParams() == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = this.a.g.a1.getLayoutParams();
                layoutParams.height = this.a.g.g1;
                this.a.g.a1.setLayoutParams(layoutParams);
            }
        }

        public a(zy7 zy7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = zy7Var;
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
                    int i1 = this.g.i1(this.b);
                    int i3 = this.a;
                    int i4 = i1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = i1 - i;
                    }
                    if (this.g.a1 == null || (layoutParams = this.g.a1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || i1 >= this.g.d.getMeasuredHeight()) {
                        layoutParams.height = this.g.g1;
                    } else {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                this.g.l.setSelectionFromTop(this.e, this.f);
                            }
                        }
                        layoutParams.height = this.g.g1;
                    }
                    this.g.a1.setLayoutParams(layoutParams);
                    gh.a().post(new RunnableC0485a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements nn5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au4 a;
        public final /* synthetic */ zy7 b;

        public a0(zy7 zy7Var, au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, au4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = au4Var;
        }

        @Override // com.baidu.tieba.nn5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements uv7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public b(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.uv7
        public /* synthetic */ void onStart() {
            tv7.a(this);
        }

        @Override // com.baidu.tieba.uv7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements qn5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ zy7 b;

        public b0(zy7 zy7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.qn5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.j5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        /* loaded from: classes6.dex */
        public class a implements r45 {
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

            @Override // com.baidu.tieba.r45
            public void a(List<Bitmap> list) {
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

        public c(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B3();
                t45.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.M2();
                this.a.q0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public c0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
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
        public final /* synthetic */ zy7 a;

        public d(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A0 == null || this.a.A0.getData() == null) {
                return;
            }
            zy7 zy7Var = this.a;
            zy7Var.G2(zy7Var.A0.getData(), this.a.A0.getData().agreeNum);
            if (this.a.A0.F()) {
                return;
            }
            zy7 zy7Var2 = this.a;
            zy7Var2.z2(zy7Var2.A0);
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public d0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                ih.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public e(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.q1()) {
                        return;
                    }
                    bx4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4.c a;
        public final /* synthetic */ zy7 b;

        public e0(zy7 zy7Var, cu4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public f(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092082) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092082)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092080) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092080)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09204d, 1);
                    this.a.c.b5(sparseArray);
                    return;
                }
                this.a.y2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f09204d, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092036, 1);
                this.a.c.b5(sparseArray);
            } else if (booleanValue3) {
                this.a.t2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4.c a;
        public final /* synthetic */ zy7 b;

        public f0(zy7 zy7Var, cu4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public g(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b05 a;
        public final /* synthetic */ zy7 b;

        public g0(zy7 zy7Var, b05 b05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, b05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = b05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b.N0 == null || this.b.N1 == null) {
                return;
            }
            this.b.N1.g(this.a);
            this.b.N1.setAutoCompleteShown(false);
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public h(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.Q(postData);
                this.a.E.a0();
                this.a.j1.c();
                this.a.m0.q();
                this.a.H3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public h0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!(view2 instanceof HeadImageView) || this.a.N0 == null || this.a.N0.O() == null || this.a.N0.O().getAuthor() == null || this.a.N0.O().getAuthor().getAlaInfo() == null || this.a.N0.O().getAuthor().getAlaInfo().live_status != 1) {
                    if (this.a.n1) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    }
                    if (!this.a.n1 && this.a.N0 != null && this.a.N0.O() != null && this.a.N0.O().getAuthor() != null && this.a.N0.O().getAuthor().isBigV()) {
                        TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                    }
                    if (this.a.c.P() != null) {
                        this.a.c.P().d.b.onClick(view2);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c11851");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem("c13715");
                statisticItem2.param("fid", this.a.N0.m());
                statisticItem2.param("fname", this.a.N0.n());
                statisticItem2.param("obj_param1", this.a.N0.O().getAuthor().getAlaInfo().user_info != null ? this.a.N0.O().getAuthor().getAlaInfo().user_info.user_id : 0L);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", this.a.N0.Q());
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.N0.O().getAuthor().getAlaInfo()));
                if (this.a.N0.O().getAuthor().getAlaInfo().mYyExtData != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem2, this.a.N0.O().getAuthor().getAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem2);
                if (this.a.N0.O().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                    YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.N0.O().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public i(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.s
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b4();
            }
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
    public class i0 implements mz7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public i0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.mz7.a
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
    public class j implements vx7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.p == null) {
                    return;
                }
                this.a.a.p.p();
            }
        }

        public j(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.vx7.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public j0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            zy7 zy7Var;
            a18 a18Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.E == null || (a18Var = (zy7Var = this.a).h) == null || a18Var.i == null || zy7Var.N0 == null || this.a.N0.O() == null || this.a.N0.O().isVideoThreadType() || this.a.T1() || this.a.N0.l() == null || dj.isEmpty(this.a.N0.l().getName())) {
                return;
            }
            if ((this.a.E.J() == null || !this.a.E.J().isShown()) && (linearLayout = this.a.h.i) != null) {
                linearLayout.setVisibility(0);
                if (this.a.c == null || this.a.c.K() == null) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem("c13400");
                statisticItem.param("tid", this.a.c.K().m2());
                statisticItem.param("fid", this.a.c.K().getForumId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements uy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

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
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.r == null) {
                    return;
                }
                this.a.a.r.r();
            }
        }

        public k(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.uy7.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c.N6()) {
                return;
            }
            this.a.l.post(new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ zy7 b;

        public k0(zy7 zy7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ej.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c59);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public l(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    bx4.k().u("pb_share_red_dot_shown", true);
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
        public final /* synthetic */ vu7 c;
        public final /* synthetic */ zy7 d;

        public l0(zy7 zy7Var, Parcelable parcelable, ArrayList arrayList, vu7 vu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, parcelable, arrayList, vu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = zy7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = vu7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) <= 1 || this.c.y().b() <= 0) {
                    return;
                }
                this.d.K.f();
                this.d.K.D(this.d.c.getString(R.string.obfuscated_res_0x7f0f0df5));
                this.d.K.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements xt7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public m(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.xt7.d
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
        public final /* synthetic */ zy7 a;

        public m0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.q1) {
                    this.a.p0();
                    this.a.j2();
                }
                this.a.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(zy7 zy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Integer.valueOf(i)};
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
            this.a = zy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2005016 || this.a.E == null) {
                return;
            }
            this.a.E.a0();
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public n0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                this.a.p0();
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public o(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A == null) {
                    this.a.D1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

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
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public o0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                gh.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(zy7 zy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Integer.valueOf(i)};
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
            this.a = zy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public q(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Q2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements v45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public r(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.v45
        public void B(u45 u45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, u45Var) == null) {
                Object obj = u45Var.c;
                if ((obj instanceof r05) && EmotionGroupType.isSendAsPic(((r05) obj).getType())) {
                    if (this.a.E1 == null) {
                        this.a.E1 = new PermissionJudgePolicy();
                    }
                    this.a.E1.clearRequestPermissionList();
                    this.a.E1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    r05 r05Var = (r05) u45Var.c;
                    this.a.c.L5().e(r05Var);
                    if (r05Var.i()) {
                        this.a.c.L5().G(null, null);
                    } else {
                        this.a.c.L5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b05 a;
        public final /* synthetic */ zy7 b;

        public r0(zy7 zy7Var, b05 b05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, b05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = b05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.N1.setHomePbFloatLastCloseTime();
                this.b.y1();
                this.b.N1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public s(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.I0 == null || this.a.c.I0.e() == null) {
                return;
            }
            if (!this.a.c.I0.e().e()) {
                this.a.c.I0.a(false);
            }
            this.a.c.I0.e().l(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.m0 == null || this.a.m0.getVisibility() != 0 || charSequence == null || charSequence.length() < (i4 = i3 + i)) {
                return;
            }
            String substring = charSequence.toString().substring(i, i4);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            if (this.a.v1 == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.addRule(2, this.a.m0.getId());
                zy7 zy7Var = this.a;
                zy7Var.v1 = new xz7(zy7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.u1)) {
                    this.a.v1.q(this.a.u1);
                }
                this.a.v1.r(this.a.m0);
            }
            this.a.v1.p(substring);
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
        public final /* synthetic */ zy7 e;

        public s0(zy7 zy7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zy7Var;
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
                if (i == this.b || i - this.c >= 0) {
                    this.e.s1.showAsDropDown(this.e.t0, this.d.getLeft(), -this.e.t0.getHeight());
                } else {
                    this.e.s1.showAsDropDown(this.d);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements lu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ zy7 b;

        public t(zy7 zy7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.lu4.e
        public void n0(lu4 lu4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lu4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.t2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f09203c), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09205a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09203d)).booleanValue());
                        return;
                    case 11:
                        if (this.b.X1 != null) {
                            this.b.X1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09205a), sparseArray.get(R.id.obfuscated_res_0x7f092047), sparseArray.get(R.id.obfuscated_res_0x7f09204a), sparseArray.get(R.id.obfuscated_res_0x7f092048), sparseArray.get(R.id.obfuscated_res_0x7f092049)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.Y5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092092), sparseArray);
                        return;
                    case 13:
                        this.b.s4(true);
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
        public final /* synthetic */ zy7 a;

        public t0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String h1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.K() != null && this.a.c.K().A2()) {
                    h1 = this.a.c.getString(R.string.obfuscated_res_0x7f0f0e0a);
                } else {
                    h1 = this.a.h1();
                }
                if (!StringUtils.isNull(h1) && this.a.N0 != null) {
                    h1 = TbSingleton.getInstance().getAdVertiComment(this.a.N0.n0(), this.a.N0.o0(), h1);
                }
                if (this.a.c != null && this.a.c.L5() != null) {
                    this.a.c.L5().c0(h1);
                }
                if (this.a.x0 != null) {
                    this.a.x0.setText(h1);
                }
                this.a.H3(false);
                this.a.b4();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements au4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.au4.e
        public void onClick(au4 au4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, au4Var) == null) {
                au4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(zy7 zy7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, Integer.valueOf(i)};
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
            this.a = zy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921306) {
                this.a.Q1 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements gm8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.tieba.gm8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ zy7 b;

        public v0(zy7 zy7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zy7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.J1 || this.a == null || this.b.c.K() == null || !this.b.c.K().D2()) {
                return;
            }
            this.b.J1 = true;
            this.a.Y4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ zy7 c;

        public w(zy7 zy7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy7Var;
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
                    ej.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.c.j5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements vv7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public w0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // com.baidu.tieba.vv7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.b6();
            }
        }

        @Override // com.baidu.tieba.vv7.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.l == null) {
                return;
            }
            if (this.a.t != null) {
                this.a.t.t();
            }
            this.a.l.setSelection(0);
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(zy7 zy7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, alertDialog};
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ w65 b;
        public final /* synthetic */ zy7 c;

        public x0(zy7 zy7Var, ReplyPrivacyCheckController replyPrivacyCheckController, w65 w65Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, replyPrivacyCheckController, w65Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy7Var;
            this.a = replyPrivacyCheckController;
            this.b = w65Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null || this.c.c == null || this.c.c.s5() == null || this.a.checkPrivacyBeforeInvokeEditor(this.c.c.s5().replyPrivateFlag)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                        this.c.o4();
                        this.b.n0();
                        this.c.v0();
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ zy7 c;

        public y(zy7 zy7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zy7Var;
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
                    ej.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.c.c.j5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zy7 a;

        public y0(zy7 zy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(zy7 zy7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zy7Var, alertDialog};
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (alertDialog = this.a) == null) {
                return;
            }
            alertDialog.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public static class z0 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948376369, "Lcom/baidu/tieba/zy7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948376369, "Lcom/baidu/tieba/zy7;");
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
        p2 = ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        q2 = 1;
        r2 = new v();
    }

    public zy7(PbFragment pbFragment, View.OnClickListener onClickListener, xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, xv7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
        this.k0 = xv7Var;
        this.q1 = ej.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0641, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903f9);
        this.A1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091858);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091f7d);
        this.O1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c3b);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09224a);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f0925c4);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f091692);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c74);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ej.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.setOverScrollMode(2);
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (fm5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.J2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new a18(pbFragment, this.d);
        if (this.c.C5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0914a6);
            this.j = viewStub;
            viewStub.setVisibility(0);
            z08 z08Var = new z08(pbFragment);
            this.i = z08Var;
            z08Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ej.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new vv7(new w0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f0925aa);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917f6);
        ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090889);
        this.w0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.L5()));
        Y1();
        w0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f9);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0917f1);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09088d);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f7);
        this.L1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0914c7);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f3);
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
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f5);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0917fc);
        this.E0 = findViewById;
        findViewById.setVisibility((bx4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917fa);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917fb);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.S1);
        this.C0.setOnClickListener(new e(this));
        b2();
        e38 e38Var = new e38(this.C0);
        this.F0 = e38Var;
        e38Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f8);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917f4);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f73);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new nz7(this.c, xv7Var);
        this.w = new rz7(this.c, xv7Var, this.P);
        gx7 gx7Var = new gx7(this.c, this.l);
        this.E = gx7Var;
        gx7Var.y0(this.P);
        this.E.A0(this.k0);
        this.E.v0(this.Q);
        this.E.x0(this.c.g2);
        this.E.r0(this.d2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.t0(fVar);
        H1();
        B1();
        qz7 qz7Var = new qz7(this.c);
        this.y = qz7Var;
        qz7Var.f = 2;
        A1();
        this.z.a(this.l);
        this.w.m(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091848);
        this.N = this.K.b().findViewById(R.id.obfuscated_res_0x7f0917e1);
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
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f0925e0);
        this.c.registerListener(this.W1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel K = this.c.K();
        this.i1.S(K.I(), K.E(), K.F(), K.D(), K.J());
        sx7 sx7Var = new sx7(this.c.getPageContext(), this.i1, this.d);
        this.j1 = sx7Var;
        sx7Var.k(new g(this));
        this.j1.n(this.c.l2);
        this.i1.U(new h(this));
        if (this.c.K() != null && !StringUtils.isNull(this.c.K().V1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.K().V1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917fe);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903f7);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091f8a);
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
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091876));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.c0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.g2);
        this.c.registerListener(this.T1);
        this.c.registerListener(this.R1);
        PbFragment pbFragment3 = this.c;
        this.K1 = new d38(pbFragment3, pbFragment3.getUniqueId());
        this.M1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090994);
        W2();
        this.M1.setAnimationListener(new i(this));
        k0();
        P2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917e7);
        j0(fm5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && K.H2() && yt7.b().e()) {
            if (this.p == null) {
                this.p = new wx7(this.c.getActivity(), (ViewGroup) p1().findViewById(R.id.obfuscated_res_0x7f091820));
            }
            vx7 vx7Var = new vx7(this.l);
            this.q = vx7Var;
            vx7Var.d(new j(this));
        }
        this.r = new vy7(this.c.P(), (ViewGroup) p1().findViewById(R.id.obfuscated_res_0x7f091889));
        uy7 uy7Var = new uy7(this.l);
        this.s = uy7Var;
        uy7Var.d(new k(this));
    }

    public void A0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void A1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new mz7(pbFragment.getContext());
        }
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vy7 vy7Var = this.r;
            return vy7Var != null && vy7Var.l();
        }
        return invokeV.booleanValue;
    }

    public final boolean A3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
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
                return numberFormat.format(((float) j3) / 10000.0f) + "W";
            } else if (j3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(((float) j3) / 10000.0f) + "W";
            } else {
                return "" + j3;
            }
        }
        return (String) invokeJ.objValue;
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.v == null) {
            this.v = new pz7(this.c, this.k0);
        }
    }

    public void B2(m35 m35Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, m35Var, i3) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.A(m35Var, this.c.getPageContext(), i3, false);
    }

    public final void B3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
            return;
        }
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
            int f2 = ej.f(this.c.getActivity(), R.dimen.tbds166);
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

    public final String C0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0de2);
            }
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (i3 > 9990000) {
                return "· · ·";
            }
            if (i3 >= 1000000) {
                numberFormat.setMaximumFractionDigits(0);
                return numberFormat.format(i3 / 10000.0f) + "W";
            } else if (i3 >= 10000) {
                numberFormat.setMaximumFractionDigits(1);
                return numberFormat.format(i3 / 10000.0f) + "W";
            } else {
                return "" + i3;
            }
        }
        return (String) invokeI.objValue;
    }

    public final void C1(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, vu7Var) == null) && vu7Var != null && vu7Var.O() != null && vu7Var.O().isInterviewLive() && this.T0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
            this.T0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.P);
            this.T0.setCallback(this.c.A5());
            this.T0.setData(this.c, vu7Var);
        }
    }

    public final void C2() {
        a18 a18Var;
        vu7 vu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.v == null || (a18Var = this.h) == null || a18Var.p() == null || (vu7Var = this.N0) == null || vu7Var.O() == null || !this.N0.O().isQuestionThread() || this.v.c() == null || this.v.c().getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        this.v.c().getLocationInWindow(iArr);
        boolean z2 = true;
        int height = iArr[1] + this.v.c().getHeight();
        boolean z3 = this.v.c().getParent() != null;
        a18 a18Var2 = this.h;
        if (height > a18Var2.p().getBottom() && z3) {
            z2 = false;
        }
        a18Var2.H(z2, this.N0.O().getSpan_str());
    }

    public void C3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            a18 a18Var = this.h;
            if (a18Var == null || (view2 = a18Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public gx7 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.E : (gx7) invokeV.objValue;
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.c.C5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0914a1);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.A == null) {
                this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0914a0);
                td5.a(this.c.getPageContext(), this.A);
            }
            if (this.B == null) {
                this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f0914a5);
            }
            if (this.C == null) {
                this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f0914a4);
            }
            this.B.setOnClickListener(this.P);
            this.C.setOnClickListener(this.P);
        }
    }

    public final void D2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, pbReplyTitleViewHolder, z2) == null) || this.n1 || this.W0 == null || this.h.p() == null) {
            return;
        }
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
            G3(false);
            this.h.a.hideBottomLine();
            if (this.W0.getParent() == null || ((ViewGroup) this.W0.getParent()).getHeight() > this.W0.getTop()) {
                return;
            }
            this.W0.getParent().requestLayout();
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
            if (top != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                if (this.D.getY() < 0.0f) {
                    measuredHeight = i2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.p().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.b1) {
                    this.W0.setVisibility(0);
                    G3(false);
                } else if (top < measuredHeight) {
                    this.W0.setVisibility(0);
                    G3(false);
                } else {
                    this.W0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.c1 = true;
                }
            }
        } else if (this.l.getFirstVisiblePosition() == 0) {
            this.W0.setVisibility(4);
            this.h.a.hideBottomLine();
        }
    }

    public void D3() {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (sz7Var = this.t) == null) {
            return;
        }
        sz7Var.u(this.l);
    }

    public LinearLayout E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.u0 : (LinearLayout) invokeV.objValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.c != null && this.m0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.m0.j();
                r1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.w.A(this.N0, this.O0, this.o1, this.n1);
        }
    }

    public final void E3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1194, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b45);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b46);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new y(this, w2, sparseArray));
        aVar2.a(new z(this, w2));
    }

    public View F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            View view2 = this.X;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907b9);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void F1(vu7 vu7Var, b05 b05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, vu7Var, b05Var) == null) || this.O1 == null || vu7Var == null || b05Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            y1();
            return;
        }
        if (this.N1 == null) {
            this.N1 = RightFloatLayerLottieView.F(b05Var, this.c.getContext());
            this.O1.removeAllViews();
            this.O1.addView(this.N1);
        }
        if ((this.M1.getTag() instanceof Boolean) && !((Boolean) this.M1.getTag()).booleanValue()) {
            this.N1.setAutoCompleteShown(false);
            this.N1.setTag(this.M1);
            this.N1.c();
        }
        if (b05Var.a()) {
            return;
        }
        this.N1.setData(b05Var);
        this.N1.setLogoListener(new g0(this, b05Var));
        this.N1.setFeedBackListener(new r0(this, b05Var));
    }

    public void F2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.m1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.d1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1.c;
        int i1 = i1(pbReplyTitleViewHolder);
        int measuredHeight = this.D.getMeasuredHeight() + ((int) this.D.getY());
        boolean z2 = this.W0.getVisibility() == 0;
        boolean z3 = this.D.getY() < 0.0f;
        if ((z2 && pbReplyTitleViewHolder != null) || firstVisiblePosition >= this.E.H() + this.l.getHeaderViewsCount()) {
            int measuredHeight2 = pbReplyTitleViewHolder != null ? pbReplyTitleViewHolder.g.getMeasuredHeight() : 0;
            if (z3) {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), i2 - measuredHeight2);
            } else {
                this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - measuredHeight2);
            }
        } else {
            this.l.setSelectionFromTop(firstVisiblePosition, top);
        }
        if (this.n1 && this.t != null) {
            this.l.setSelectionFromTop(this.E.H() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.P0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, i1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void F3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048599, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().o() == null || this.c.K().S1().l() == null || this.c.K().S1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092050, Boolean.TRUE);
        }
        pn5 pn5Var = new pn5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
        pn5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
        pn5Var.h(this.c.K().S1().l().getImage_url());
        pn5Var.j(this.c.K().S1().l().getUser_level());
        Q3(sparseArray, i3, pn5Var, this.c.K().S1().V(), true);
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public void G1(vu7 vu7Var) {
        b05 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, vu7Var) == null) || vu7Var == null) {
            return;
        }
        if (vu7Var.n0()) {
            pbAdFloatViewItemData = vu7Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            F1(vu7Var, pbAdFloatViewItemData);
        } else {
            y1();
        }
    }

    public final void G2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048602, this, agreeData, j3) == null) || agreeData == null || (textView = this.G0) == null) {
            return;
        }
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

    public void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            this.o0.setVisibility(z2 ? 0 : 8);
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

    public final void H1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.x == null) {
            this.x = new oz7(this.c, this.P);
        }
    }

    public final void H2(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, vu7Var) == null) || vu7Var == null || vu7Var.O() == null) {
            return;
        }
        p4(vu7Var);
        ImageView imageView = this.B0;
        if (imageView != null && imageView.getContext() != null) {
            if (vu7Var.r()) {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097b, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
        String C0 = C0(vu7Var.O().getReply_num());
        TextView textView = this.H0;
        if (textView != null) {
            textView.setText(C0);
        }
        TextView textView2 = this.I0;
        if (textView2 != null) {
            textView2.setText(C0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, vu7Var.O()));
        G2(vu7Var.O().getAgreeData(), vu7Var.O().getAgreeNum());
        if (this.A0 == null || vu7Var.O() == null) {
            return;
        }
        this.A0.setThreadData(vu7Var.O());
        int i3 = 1;
        if (vu7Var.O().getAgreeData() != null) {
            vu7Var.O().getAgreeData().isInThread = true;
        }
        this.A0.setData(vu7Var.O().getAgreeData());
        rq4 rq4Var = new rq4();
        rq4Var.b = 26;
        if (vu7Var.O().isVideoThreadType() && vu7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        rq4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.K() != null) {
            rq4Var.j = this.c.K().getFromForumId();
            rq4Var.f = this.c.K().R1();
        }
        this.A0.setStatisticData(rq4Var);
    }

    public void H3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) || this.t0 == null) {
            return;
        }
        Y2(this.c.L5().y());
        if (this.n0) {
            L3(z2);
        } else {
            s1(z2);
        }
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
            if (this.E.y(H0) != null && this.E.y(H0) != PostData.J0) {
                i3 = H0 + 1;
            }
            if (this.E.x(i3) instanceof PostData) {
                return (PostData) this.E.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void I1(vu7 vu7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, vu7Var) == null) {
            int i3 = 0;
            this.E.i0(vu7Var, false);
            this.E.a0();
            s0();
            vw7 vw7Var = this.w1;
            if (vw7Var != null) {
                vw7Var.n();
            }
            ArrayList<PostData> F = vu7Var.F();
            if (vu7Var.y().b() == 0 || F == null || F.size() < vu7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).C() != 1)) {
                    if (vu7Var.y().b() == 0) {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
                    } else {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a53));
                    }
                    this.K.k();
                } else {
                    z0 z0Var = this.d1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                    }
                    if (this.c.l6()) {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfb), i3);
                    } else {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfc), i3);
                    }
                }
            }
            H2(vu7Var);
        }
    }

    public void I2(int i3, vu7 vu7Var, boolean z2, int i4) {
        PostData L0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i3), vu7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (L0 = L0(vu7Var, z2)) == null || L0.s() == null) {
            return;
        }
        MetaData s2 = L0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void I3(vu7 vu7Var) {
        PostData postData;
        a18 a18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, vu7Var) == null) || vu7Var == null || (postData = this.O0) == null || postData.s() == null || (a18Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.n1;
        this.o1 = z2;
        a18Var.I(z2);
        if (this.c.M5() != null) {
            this.c.M5().s(this.o1);
        }
        E2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.u0() && !ListUtils.isEmpty(vu7Var.p())) {
            kt4 kt4Var = vu7Var.p().get(0);
            if (kt4Var != null) {
                this.h.M(vu7Var, kt4Var.c(), kt4Var.d(), kt4Var.a(), kt4Var.getIsLike());
            }
        } else if (vu7Var.l() != null) {
            this.h.M(vu7Var, vu7Var.l().getName(), vu7Var.l().getId(), vu7Var.l().getImage_url(), vu7Var.l().isLike() == 1);
        }
        if (this.o1) {
            this.w.L(vu7Var, this.O0, this.h0);
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
        this.w.L(vu7Var, this.O0, this.h0);
        this.x1 = null;
        this.l.setListViewDragListener(null);
    }

    public FallingView J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.M1 : (FallingView) invokeV.objValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.a2 : invokeV.booleanValue;
    }

    public void J2(vu7 vu7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{vu7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            T3(vu7Var, z2, i3, i4);
            this.w.y(i4);
        }
    }

    public final void J3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048615, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04b0, TBAlertConfig.OperateBtnStyle.MAIN);
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

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? M0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.J0 : invokeV.booleanValue;
    }

    public final void K2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (pbInterviewStatusView = this.T0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.T0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.T0.setLayoutParams(layoutParams);
        }
    }

    public final boolean K3(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.O() == null) {
                return false;
            }
            return vu7Var.O().getIsLive() == 1 || vu7Var.O().getThreadType() == 33 || !(vu7Var.O().getTopicData() == null || vu7Var.O().getTopicData().a() == 0) || vu7Var.O().getIs_top() == 1 || vu7Var.O().getIs_good() == 1 || vu7Var.O().isActInfo() || vu7Var.O().isInterviewLive() || vu7Var.O().isVoteThreadType() || vu7Var.O().getYulePostActivityData() != null || !dj.isEmpty(vu7Var.O().getCategory()) || vu7Var.O().isGodThread() || vu7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public PostData L0(vu7 vu7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048620, this, vu7Var, z2)) == null) {
            PostData postData = null;
            if (vu7Var == null) {
                return null;
            }
            if (vu7Var.X() != null) {
                return vu7Var.X();
            }
            if (!ListUtils.isEmpty(vu7Var.F())) {
                Iterator<PostData> it = vu7Var.F().iterator();
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
                postData = vu7Var.j();
            }
            if (!O1(postData)) {
                postData = g1(vu7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean L1(vu7 vu7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = vu7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0de3).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048622, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.K);
        this.f = 2;
    }

    public void L3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) || this.t0 == null || (textView = this.x0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f0526);
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.t0.startAnimation(alphaAnimation);
        }
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        this.J0 = true;
        if (this.e1 == null || this.w1.l()) {
            return;
        }
        this.e1.setVisibility(0);
        P2(true);
    }

    public final int M0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i3)) == null) {
            un adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof su7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            int n3 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof un)) ? 0 : this.l.getAdapter2().n();
            if (i3 > n3) {
                return i3 - n3;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public final void M2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
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

    public void M3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || bx4.k().h("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f0442);
        this.t1.setGravity(17);
        this.t1.setPadding(ej.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ej.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ej.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
        bx4.k().u("show_long_press_collection_tips", true);
    }

    public Button N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.r0 : (Button) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void N2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.z.d(pbLandscapeListView);
        this.v.g(this.l);
        this.w.B(this.l);
        this.x.d(this.l);
        this.u.f(this.l);
    }

    public void N3() {
        a18 a18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || (a18Var = this.h) == null || this.p1) {
            return;
        }
        a18Var.D();
        this.p1 = true;
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean O1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public final void O2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (pbFragment = this.c) == null || pbFragment.L5() == null || this.m0 == null) {
            return;
        }
        s65.a().c(0);
        w65 L5 = this.c.L5();
        L5.M();
        L5.K();
        if (L5.v() != null) {
            L5.v().setMaxImagesAllowed(L5.t ? 1 : 9);
        }
        L5.d0(SendView.h);
        L5.g(SendView.h);
        b55 m3 = this.m0.m(23);
        b55 m4 = this.m0.m(2);
        b55 m5 = this.m0.m(5);
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

    public void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public TextView P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.w.q() : (TextView) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
        }
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            if (this.L0 == null) {
                this.L0 = new fx4(this.c.getPageContext());
            }
            this.L0.h(true);
        }
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            e38 e38Var = this.F0;
            if (e38Var != null) {
                return e38Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2) : invokeV.booleanValue;
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            O2();
            t1();
            this.j1.c();
            H3(false);
        }
    }

    public final void Q3(SparseArray<Object> sparseArray, int i3, pn5 pn5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{sparseArray, Integer.valueOf(i3), pn5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.C1 == null && this.u != null) {
            this.C1 = new qn5(pbFragment.getPageContext(), this.u.c(), pn5Var, userData);
        }
        this.C1.C(z2);
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        is4 is4Var = new is4();
        is4Var.j(sparseArray2);
        this.C1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c4), this.c.getString(R.string.obfuscated_res_0x7f0f04c5), this.c.getString(R.string.obfuscated_res_0x7f0f04c6), this.c.getString(R.string.obfuscated_res_0x7f0f04c7), this.c.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.C1.D(is4Var);
        this.C1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.C1.F(new b0(this, sparseArray));
    }

    public PbInterviewStatusView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.T0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean R1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData L0 = L0(this.N0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (L0 == null || L0.s() == null) ? "" : L0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void R2() {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || (sz7Var = this.t) == null) {
            return;
        }
        sz7Var.q(this.l, this.V0, this.P0);
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.E.i0(this.N0, false);
            this.E.a0();
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.y1 : invokeV.booleanValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            View view2 = this.a1;
            if (view2 == null || view2.getParent() == null || this.K.m()) {
                return false;
            }
            int bottom = this.a1.getBottom();
            Rect rect = new Rect();
            this.a1.getWindowVisibleDisplayFrame(rect);
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void S2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (handler = this.U1) == null) {
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

    public void S3(vu7 vu7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        vu7 vu7Var2;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{vu7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || vu7Var == null || this.l == null) {
            return;
        }
        this.N0 = vu7Var;
        this.P0 = i3;
        if (vu7Var.O() != null) {
            this.f1 = vu7Var.O().getCopyThreadRemindType();
            if (vu7Var.O().getAnchorLevel() != 0) {
                this.a2 = true;
            }
            this.h0 = R1(vu7Var.O());
        }
        if (vu7Var.V() != null) {
            this.b2 = vu7Var.V().getUserId();
        }
        C1(vu7Var);
        h0();
        this.R0 = false;
        this.M0 = z2;
        t3();
        ev7 ev7Var = vu7Var.h;
        if (ev7Var != null && ev7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(vu7Var);
                this.o.setChildOnClickLinstener(this.P);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        T3(vu7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        I3(vu7Var);
        this.w.M(vu7Var, this.O0);
        if (this.z1 == null) {
            this.z1 = new iy7(this.c.getPageContext(), this.A1);
        }
        this.z1.a(vu7Var.w());
        if (this.c.C5()) {
            if (this.J == null) {
                f38 f38Var = new f38(this.c.getPageContext());
                this.J = f38Var;
                f38Var.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            R2();
            f38 f38Var2 = this.J;
            if (f38Var2 != null) {
                f38Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (vu7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.J == null) {
                f38 f38Var3 = new f38(this.c.getPageContext());
                this.J = f38Var3;
                f38Var3.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            R2();
            f38 f38Var4 = this.J;
            if (f38Var4 != null) {
                f38Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            v1();
        }
        s0();
        this.E.p0(this.M0);
        this.E.m0(false);
        this.E.n0(i3 == 5);
        this.E.o0(i3 == 6);
        this.E.k0(z3 && this.Y1 && i3 != 2);
        this.E.i0(vu7Var, false);
        this.E.a0();
        this.E.c0(vu7Var.y().b() != 0, vu7Var.g());
        this.w.K(L0(vu7Var, z2), vu7Var.i0());
        if (vu7Var.O() != null && vu7Var.O().getPraise() != null && this.b != -1) {
            vu7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.a1);
        this.l.addFooterView(this.a1);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.K);
            this.f = 2;
            v1();
        } else {
            this.R0 = true;
            if (vu7Var.y().b() == 1) {
                if (this.L == null) {
                    PbFragment pbFragment2 = this.c;
                    this.L = new b38(pbFragment2, pbFragment2);
                }
                this.l.setNextPage(this.L);
            } else {
                this.l.setNextPage(this.K);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = vu7Var.F();
        if (vu7Var.y().b() != 0 && F != null && F.size() >= vu7Var.y().e()) {
            if (z3) {
                if (this.Y1) {
                    x0();
                    if (vu7Var.y().b() != 0) {
                        this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0df4));
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
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).C() != 1)) {
                if (vu7Var.y().b() == 0) {
                    this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
                } else {
                    this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a53));
                }
                this.K.k();
            } else {
                z0 z0Var = this.d1;
                if (z0Var == null || (pbReplyTitleViewHolder = z0Var.c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i6 = 0;
                } else {
                    i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                }
                if (this.c.l6()) {
                    this.K.v(false);
                    if (ListUtils.isEmpty(vu7Var.R())) {
                        this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfb), i6);
                    }
                } else if (ListUtils.isEmpty(vu7Var.R())) {
                    this.K.G(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dfc), i6);
                }
                if (this.c.M5() != null && !this.c.M5().p()) {
                    this.c.M5().x();
                }
            }
            if (vu7Var.y().b() == 0 || F == null) {
                L2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && vu7Var.F() == null) ? 0 : (this.l.getData().size() - vu7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.Y1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        sz7 sz7Var = this.t;
                        if (sz7Var != null && sz7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - ej.s(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                            }
                        } else {
                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(vu7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && vu7Var.F() == null) ? 0 : (this.l.getData().size() - vu7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(vu7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.K.f();
                    this.K.D(this.c.getString(R.string.obfuscated_res_0x7f0f0df5));
                    this.K.y();
                }
            } else if (i5 == 1 && (e3 = oy7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e2 = oy7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new l0(this, e2, F, vu7Var));
        }
        if (this.f1 == j2 && Q1()) {
            m0();
        }
        if (this.l1) {
            F2();
            this.l1 = false;
            if (i5 == 0) {
                i3(true);
            }
        }
        if (vu7Var.d == 1 || vu7Var.e == 1) {
            if (this.r1 == null) {
                this.r1 = new PbTopTipView(this.c.getContext());
            }
            if (vu7Var.e == 1 && "game_guide".equals(this.c.S5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e07));
                this.r1.l(this.d, this.Q0);
            } else if (vu7Var.d == 1 && "game_news".equals(this.c.S5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e06));
                this.r1.l(this.d, this.Q0);
            }
        }
        this.l.removeFooterView(this.K1.a());
        if (!ListUtils.isEmpty(vu7Var.I()) && vu7Var.y().b() == 0) {
            this.l.removeFooterView(this.a1);
            this.K1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
            this.l.addFooterView(this.K1.a());
            this.K1.f(vu7Var);
        }
        H2(vu7Var);
        if (vu7Var.g0() && this.c.K().H2() && this.c.O5() != null) {
            this.c.O5().d();
        }
        if (vu7Var.g() != 3) {
            G1(vu7Var);
        }
        this.x0.setText(TbSingleton.getInstance().getAdVertiComment(vu7Var.n0(), vu7Var.o0(), h1()));
        if (this.p != null && (vu7Var2 = this.N0) != null && vu7Var2.l() != null) {
            this.p.m(this.N0.l().getImage_url());
            this.p.n(this.N0.l().getName());
            PbFragment pbFragment3 = this.c;
            if (pbFragment3 != null && pbFragment3.K() != null) {
                this.p.o(this.c.K().b);
            }
        }
        if (this.r != null) {
            vu7 vu7Var3 = this.N0;
            if (vu7Var3 != null && vu7Var3.l() != null && (pbFragment = this.c) != null && pbFragment.K() != null) {
                this.r.q(this.c.K().b);
            }
            vu7 vu7Var4 = this.N0;
            if (vu7Var4 == null || vu7Var4.O() == null || ListUtils.isEmpty(this.N0.O().getThreadRecommendInfoDataList())) {
                return;
            }
            this.r.p(this.N0.O().getThreadRecommendInfoDataList().get(0));
        }
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.t != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return M0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            vu7 vu7Var = this.N0;
            return vu7Var == null || vu7Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public void T2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new q(this));
            this.m0.setId(R.id.obfuscated_res_0x7f0917f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.w(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new r(this));
            t1();
            this.c.L5().f(new s(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void T3(vu7 vu7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{vu7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || vu7Var == null || vu7Var.O() == null) {
            return;
        }
        if (this.c.u0()) {
            if (vu7Var.h() != null) {
                this.i0 = vu7Var.h().c();
                this.j0 = vu7Var.h().d();
            }
            if (this.i0 == null && this.c.K() != null && this.c.K().r1() != null) {
                this.i0 = this.c.K().r1();
            }
        }
        PostData L0 = L0(vu7Var, z2);
        r3(L0, vu7Var);
        this.w.H(8);
        if (vu7Var.u0()) {
            this.n1 = true;
            this.h.B(true);
            this.h.a.hideBottomLine();
            if (this.t == null) {
                this.t = new sz7(this.c);
            }
            this.t.v(vu7Var, L0, this.l, this.w, this.U0, this.h, this.i0, this.F1);
            this.t.s(this.Z1);
            R2();
        } else {
            this.n1 = false;
            this.h.B(false);
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.p(this.l);
            }
        }
        if (this.c.M5() != null) {
            this.c.M5().w(this.n1);
        }
        if (L0 == null) {
            return;
        }
        this.O0 = L0;
        this.w.H(0);
        SparseArray<Object> u2 = this.w.u();
        u2.put(R.id.obfuscated_res_0x7f09203a, L0);
        u2.put(R.id.obfuscated_res_0x7f092053, Boolean.FALSE);
        this.x.e(vu7Var, this.l);
        this.z.e(vu7Var, this.H1, new i0(this));
        this.v.i(vu7Var);
        this.u.h(vu7Var, this.M0);
        this.u.g(vu7Var);
        this.w.I(this.Q0, this.N0, L0, this.Z1);
        if (this.Z0 != null) {
            if (vu7Var.i0()) {
                this.Z0.getView().setVisibility(8);
            } else {
                this.Z0.getView().setVisibility(0);
                iv7 iv7Var = new iv7(iv7.i);
                if (vu7Var.O() != null) {
                    vu7Var.O().getReply_num();
                }
                iv7Var.c = vu7Var.g;
                vu7Var.c();
                iv7Var.d = this.c.l6();
                iv7Var.g = vu7Var.f;
                iv7Var.h = vu7Var.O().isQuestionThread();
                this.Z0.h(iv7Var);
            }
        }
        f4(vu7Var);
        gh.a().post(new j0(this));
        this.y.f(this.l);
        if (L0.Q) {
            this.y.g(L0.L());
            this.y.c(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        gx7 gx7Var = this.E;
        if (gx7Var != null && gx7Var.z() != null) {
            this.E.z().F(L0.Q);
        }
        gx7 gx7Var2 = this.E;
        if (gx7Var2 != null) {
            gx7Var2.s0(L0.Q);
        }
        this.L1.setVisibility(L0.Q ? 0 : 8);
    }

    public BdTypeListView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            sz7 sz7Var = this.t;
            return sz7Var != null && sz7Var.f();
        }
        return invokeV.booleanValue;
    }

    public void U2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, str) == null) || (pbListView = this.K) == null) {
            return;
        }
        pbListView.D(str);
    }

    public void U3(cu4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048659, this, cVar, z2) == null) {
            ju4 ju4Var = this.e0;
            if (ju4Var != null) {
                ju4Var.dismiss();
                this.e0 = null;
            }
            lu4 lu4Var = new lu4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            vu7 vu7Var = this.N0;
            if (vu7Var != null && vu7Var.O() != null && !this.N0.O().isBjh()) {
                arrayList.add(new hu4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10ae), lu4Var));
            }
            if (!z2) {
                arrayList.add(new hu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10af), lu4Var));
            }
            lu4Var.j(arrayList);
            lu4Var.n(new f0(this, cVar));
            ju4 ju4Var2 = new ju4(this.c.getPageContext(), lu4Var);
            this.e0 = ju4Var2;
            ju4Var2.k();
        }
    }

    public SparseArray<Object> V0(vu7 vu7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData L0;
        qr4 qr4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048660, this, new Object[]{vu7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (vu7Var == null || (L0 = L0(vu7Var, z2)) == null) {
                return null;
            }
            String userId = L0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f09203c, L0.L());
                sparseArray.put(R.id.obfuscated_res_0x7f09203e, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(vu7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.FALSE);
            } else if (i3 == 1) {
                if (L0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092047, L0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f092048, L0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f092049, L0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f09204a, L0.L());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f09203c, L0.L());
                sparseArray.put(R.id.obfuscated_res_0x7f09203e, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(vu7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092082, Boolean.TRUE);
            }
            if (!z3) {
                List<kt4> p3 = vu7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (kt4 kt4Var : p3) {
                        if (kt4Var != null && !StringUtils.isNull(kt4Var.c()) && (qr4Var = kt4Var.g) != null && qr4Var.a && !qr4Var.c && ((i4 = qr4Var.b) == 1 || i4 == 2)) {
                            sb.append(dj.cutString(kt4Var.c(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f066e));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09203b, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04a8), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.P1 : invokeV.booleanValue;
    }

    public void V2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, str) == null) || this.K == null) {
            return;
        }
        int i3 = 0;
        z0 z0Var = this.d1;
        if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
            i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
        }
        this.K.G(str, i3);
    }

    public void V3(cu4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            ju4 ju4Var = this.d0;
            if (ju4Var != null) {
                ju4Var.dismiss();
                this.d0 = null;
            }
            lu4 lu4Var = new lu4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new hu4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0452), lu4Var));
            }
            if (z3) {
                arrayList.add(new hu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1016), lu4Var));
            } else if (!z2) {
                arrayList.add(new hu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0aaa), lu4Var));
            } else {
                arrayList.add(new hu4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff1), lu4Var));
            }
            lu4Var.j(arrayList);
            lu4Var.n(new e0(this, cVar));
            ju4 ju4Var2 = new ju4(this.c.getPageContext(), lu4Var);
            this.e0 = ju4Var2;
            ju4Var2.k();
        }
    }

    public vw7 W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.w1 : (vw7) invokeV.objValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            e38 e38Var = this.F0;
            if (e38Var == null) {
                return false;
            }
            return e38Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            this.M1.setFallingFeedbackListener(new t0(this));
        }
    }

    public void W3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, onItemClickListener) == null) {
            eu4 eu4Var = this.f0;
            if (eu4Var != null) {
                eu4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList<nu4> arrayList = new ArrayList<>();
            arrayList.add(new nu4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0275), "", this.N0.L() == 1, Integer.toString(1)));
            arrayList.add(new nu4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b59), "", this.N0.L() == 2, Integer.toString(5)));
            arrayList.add(new nu4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b56), "", this.N0.L() == 3, Integer.toString(6)));
            arrayList.add(new nu4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b77), "", this.N0.L() == 4, Integer.toString(7)));
            eu4 eu4Var2 = new eu4(this.c.getPageContext());
            eu4Var2.l(R.string.obfuscated_res_0x7f0f0e03);
            this.f0 = eu4Var2;
            eu4Var2.k(arrayList, onItemClickListener);
            eu4Var2.c();
            this.f0.n();
        }
    }

    public View X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.N : (View) invokeV.objValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void X2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, h3Var) == null) {
            this.X1 = h3Var;
        }
    }

    public void X3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || !TbadkCoreApplication.isLogin() || this.N0 == null || !this.o1 || this.n1 || this.h0 || (postData = this.O0) == null || postData.s() == null || this.O0.s().getIsLike() || this.O0.s().hadConcerned() || this.k1 != null) {
            return;
        }
        this.k1 = new ry7(this.c);
    }

    public final int Y0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048672, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public final void Y1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || (imageView = this.w0) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f0809b8);
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public final void Y3(au4 au4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048675, this, au4Var, i3) == null) || (pbFragment = this.c) == null || au4Var == null) {
            return;
        }
        if (this.B1 == null && this.u != null) {
            this.B1 = new nn5(pbFragment.getPageContext(), this.u.c());
        }
        AntiData s5 = this.c.s5();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (s5 != null && s5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = s5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        is4 is4Var = new is4();
        is4Var.j(sparseArray);
        this.B1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c4), this.c.getString(R.string.obfuscated_res_0x7f0f04c5), this.c.getString(R.string.obfuscated_res_0x7f0f04c6), this.c.getString(R.string.obfuscated_res_0x7f0f04c7), this.c.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.B1.x(is4Var);
        this.B1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.B1.z(new a0(this, au4Var));
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public final void Z1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().G == null || this.c.K().G.O() == null || !this.c.K().G.O().isQuestionThread()) {
            return;
        }
        ThreadData O = this.c.K().G.O();
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
        TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", O.getId()).param("fid", O.getFid()).param("obj_source", i3));
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.E.j0(z2);
        }
    }

    public void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public PbListView a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.K : (PbListView) invokeV.objValue;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            H2(this.N0);
        }
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) {
            this.G1 = z2;
        }
    }

    public void a4() {
        gx7 gx7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048684, this) == null) || (gx7Var = this.E) == null) {
            return;
        }
        gx7Var.B0();
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048686, this) == null) && UbsABTestHelper.isShareTopRight()) {
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

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public final void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048688, this) == null) {
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

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.W0 : (View) invokeV.objValue;
    }

    public void c2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048690, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            vx7 vx7Var = this.q;
            if (vx7Var != null) {
                vx7Var.b();
            }
            uy7 uy7Var = this.s;
            if (uy7Var != null) {
                uy7Var.b(z2, i3);
            }
        }
    }

    public void c3(boolean z2) {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) || (sz7Var = this.t) == null) {
            return;
        }
        sz7Var.r(z2);
    }

    public void c4() {
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048692, this) == null) || (e38Var = this.F0) == null) {
            return;
        }
        e38Var.o(2);
    }

    public final boolean d0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, absListView, i3)) == null) {
            if (absListView == null) {
                return false;
            }
            boolean z2 = i3 > 0;
            if (z2 || absListView.getChildCount() <= 0) {
                return z2;
            }
            return absListView.getChildAt(0).getTop() < absListView.getListPaddingTop();
        }
        return invokeLI.booleanValue;
    }

    public PbFakeFloorModel d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.i1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public void d2(lm8 lm8Var) {
        vu7 vu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048695, this, lm8Var) == null) || lm8Var == null || lm8Var.a == null || lm8Var.b == null || (vu7Var = this.N0) == null || vu7Var.O() == null || this.N0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.N0.O().getAgreeData();
        String str = lm8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = lm8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = lm8Var.b;
        G2(agreeData2, agreeData2.agreeNum);
    }

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z2) == null) {
            this.E.l0(z2);
        }
    }

    public void d4(ms4 ms4Var, au4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048697, this, ms4Var, eVar) == null) || ms4Var == null) {
            return;
        }
        int a2 = ms4Var.a();
        int h2 = ms4Var.h();
        au4 au4Var = this.F;
        if (au4Var != null) {
            au4Var.show();
        } else {
            this.F = new au4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022b, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.dialog_ok, eVar);
            this.F.setNegativeButton(R.string.dialog_cancel, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090f30);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f090745);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0481), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public void e0() {
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048698, this) == null) || (e38Var = this.F0) == null) {
            return;
        }
        e38Var.m(false);
    }

    public sx7 e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.j1 : (sx7) invokeV.objValue;
    }

    public void e2(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048700, this, i3) == null) || this.Q0 == i3) {
            return;
        }
        this.Q0 = i3;
        g4(this.N0, this.M0);
        J2(this.N0, this.M0, this.P0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().l(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        sz7 sz7Var = this.t;
        if (sz7Var != null) {
            sz7Var.h(i3);
        }
        oz7 oz7Var = this.x;
        if (oz7Var != null) {
            oz7Var.c(i3);
        }
        nz7 nz7Var = this.u;
        if (nz7Var != null) {
            nz7Var.e(i3);
        }
        pz7 pz7Var = this.v;
        if (pz7Var != null) {
            pz7Var.f(i3);
        }
        rz7 rz7Var = this.w;
        if (rz7Var != null) {
            rz7Var.y(i3);
        }
        qz7 qz7Var = this.y;
        if (qz7Var != null) {
            qz7Var.e();
        }
        mz7 mz7Var = this.z;
        if (mz7Var != null) {
            mz7Var.c();
        }
        MaskView maskView = this.L1;
        if (maskView != null) {
            maskView.f();
        }
        vy7 vy7Var = this.r;
        if (vy7Var != null) {
            vy7Var.n();
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
        au4 au4Var = this.F;
        if (au4Var != null) {
            au4Var.autoChangeSkinType(this.c.getPageContext());
        }
        l4(this.g0);
        this.E.a0();
        f38 f38Var = this.J;
        if (f38Var != null) {
            f38Var.H(i3);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        b38 b38Var = this.L;
        if (b38Var != null) {
            b38Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        r4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.Y0, i3);
        if (this.A != null) {
            td5.a(this.c.getPageContext(), this.A);
        }
        sx7 sx7Var = this.j1;
        if (sx7Var != null) {
            sx7Var.h(i3);
        }
        a18 a18Var = this.h;
        if (a18Var != null) {
            sz7 sz7Var2 = this.t;
            if (sz7Var2 != null) {
                sz7Var2.i(i3);
            } else {
                a18Var.v(i3);
            }
        }
        HeadImageView headImageView = this.v0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ej.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        vu7 vu7Var = this.N0;
        if (vu7Var != null && vu7Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097b, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08097a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08097d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f0809b8, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        p4(this.N0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.t1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.s();
            this.A0.L(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                G2(data, data.agreeNum);
            }
        }
        vw7 vw7Var = this.w1;
        if (vw7Var != null) {
            vw7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        e38 e38Var = this.F0;
        if (e38Var != null) {
            e38Var.j();
        }
        d38 d38Var = this.K1;
        if (d38Var != null) {
            d38Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.N1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.obfuscated_res_0x7f092417), (int) R.color.CAM_X0105);
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048701, this, z2) == null) {
            this.E.q0(z2);
        }
    }

    public void e4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048702, this, z2) == null) || this.l == null || (textView = this.V0) == null || this.e == null) {
            return;
        }
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
            R2();
            return;
        }
        if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.V0.getLayoutParams();
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + Y0(true);
            this.V0.setLayoutParams(layoutParams2);
        }
        R2();
        K2();
    }

    public boolean f0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048703, this, z2)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.m0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public sz7 f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.t : (sz7) invokeV.objValue;
    }

    public void f2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048705, this, configuration) == null) || configuration == null) {
            return;
        }
        p0();
        if (configuration.orientation == 2) {
            r1();
            t1();
        } else {
            Q2();
        }
        sx7 sx7Var = this.j1;
        if (sx7Var != null) {
            sx7Var.c();
        }
        this.c.b6();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.c7(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                o1().setVisibility(0);
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

    public void f3(lx4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, gVar) == null) {
            this.c2 = gVar;
            f38 f38Var = this.J;
            if (f38Var != null) {
                f38Var.f(gVar);
            }
        }
    }

    public final void f4(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048707, this, vu7Var) == null) || vu7Var == null || vu7Var.O() == null || vu7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = vu7Var.O().getIs_good() == 1;
        boolean z3 = vu7Var.O().getIs_top() == 1;
        rz7 rz7Var = this.w;
        if (rz7Var != null) {
            rz7Var.o(vu7Var, z2, z3);
        }
        pz7 pz7Var = this.v;
        if (pz7Var != null) {
            pz7Var.b(vu7Var, z2, z3);
        }
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.K.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ff));
        }
        return invokeV.booleanValue;
    }

    public final PostData g1(vu7 vu7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048709, this, vu7Var)) == null) {
            if (vu7Var == null || vu7Var.O() == null || vu7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = vu7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = vu7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.D0(1);
            postData.J0(vu7Var.O().getFirstPostId());
            postData.a1(vu7Var.O().getTitle());
            postData.Z0(vu7Var.O().getCreateTime());
            postData.B0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void g2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            wx7 wx7Var = this.p;
            if (wx7Var != null) {
                wx7Var.l();
            }
            vy7 vy7Var = this.r;
            if (vy7Var != null) {
                vy7Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            e38 e38Var = this.F0;
            if (e38Var != null) {
                e38Var.k();
            }
            ry7 ry7Var = this.k1;
            if (ry7Var != null) {
                ry7Var.a();
            }
            iy7 iy7Var = this.z1;
            if (iy7Var != null) {
                iy7Var.c();
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
            gm8.d();
            p0();
            x0();
            if (this.h1 != null) {
                gh.a().removeCallbacks(this.h1);
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
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.a();
            }
            gx7 gx7Var = this.E;
            if (gx7Var != null) {
                gx7Var.d0();
            }
            this.l.setOnLayoutListener(null);
            xz7 xz7Var = this.v1;
            if (xz7Var != null) {
                xz7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            rz7 rz7Var = this.w;
            if (rz7Var != null) {
                rz7Var.z();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void g3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, onClickListener) == null) {
            this.d2 = onClickListener;
            gx7 gx7Var = this.E;
            if (gx7Var != null) {
                gx7Var.r0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void g4(vu7 vu7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048712, this, vu7Var, z2) == null) || vu7Var == null) {
            return;
        }
        q4(vu7Var, z2);
        s0();
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048713, this) == null) || this.N0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || u08.k(this.N0.Q())) {
            return;
        }
        this.F0.f();
        u08.b(this.N0.Q());
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            if (!dj.isEmpty(this.D1)) {
                return this.D1;
            }
            if (this.c != null) {
                this.D1 = TbadkCoreApplication.getInst().getResources().getString(xy7.b());
            }
            return this.D1;
        }
        return (String) invokeV.objValue;
    }

    public void h2(TbRichText tbRichText) {
        vu7 vu7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048715, this, tbRichText) == null) || (vu7Var = this.N0) == null || vu7Var.F() == null || this.N0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.N0.F().size() && (postData = this.N0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.N0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                vw7 vw7Var = this.w1;
                if (vw7Var != null && vw7Var.l()) {
                    H3(false);
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

    public void h3(String str) {
        z08 z08Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048716, this, str) == null) || (z08Var = this.i) == null) {
            return;
        }
        z08Var.b(str);
    }

    public void h4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.j0));
            } else if (!this.c.c5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                w65 L5 = this.c.L5();
                if (L5 != null && (L5.x() || L5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.L5().w(false, null);
                    return;
                }
                if (this.m0 != null) {
                    E1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.n(2) != null) {
                        gm8.c(this.c.getPageContext(), (View) this.m0.n(2).m, false, r2);
                    }
                }
                r1();
            }
        }
    }

    public final int i1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048719, this, pbReplyTitleViewHolder)) == null) {
            if (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView() == null) {
                return 0;
            }
            if (pbReplyTitleViewHolder.getView().getTop() != 0 || pbReplyTitleViewHolder.getView().isShown()) {
                return pbReplyTitleViewHolder.getView().getBottom();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean i2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048720, this, i3)) == null) {
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                return sz7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void i3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048721, this, z2) == null) {
            this.l1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.m1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void i4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048722, this) == null) {
            this.c.showProgressBar();
        }
    }

    public void j0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view2 = this.p0;
            if (view2 != null) {
                view2.setVisibility(z2 ? 8 : 0);
            }
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.L(z2 ? 8 : 0);
            }
            View view3 = this.M;
            if (view3 != null) {
                view3.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? R.id.obfuscated_res_0x7f091c1b : invokeV.intValue;
    }

    public void j2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048725, this) == null) || this.c == null) {
            return;
        }
        if ((this.G1 || this.H1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            vu7 vu7Var = this.N0;
            if (vu7Var == null || vu7Var.l() == null || dj.isEmpty(this.N0.l().getName())) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.N0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.N0.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.N0.l().getId()));
        } else if (!this.o1 || this.n1 || (postData = this.O0) == null || postData.s() == null) {
        } else {
            TiebaStatic.log(new StatisticItem("c12601").param("obj_locate", this.c.u0() ? 2 : 1).param("obj_type", this.n1 ? 2 : 1));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.O0.s().getUserId(), this.O0.s().getUserName(), this.c.K().r1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
        }
    }

    public void j3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, i3Var) == null) {
        }
    }

    public void j4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048727, this) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.C();
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            vw7 vw7Var = new vw7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091560));
            this.w1 = vw7Var;
            vw7Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
        }
    }

    public final int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void k2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z2) == null) {
            if (z2) {
                N3();
            } else {
                u1();
            }
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            D2(this.d1.c, false);
        }
    }

    public void k3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, yVar) == null) {
            this.Q = yVar;
            this.E.v0(yVar);
            this.w1.q(this.Q);
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048732, this) == null) || this.e2 == null) {
            return;
        }
        while (this.e2.size() > 0) {
            TbImageView remove = this.e2.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public final CustomBlueCheckRadioButton l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048733, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ej.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.Z);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.Q0 : invokeV.intValue;
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            k4();
            this.E.b0(1);
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.l();
            }
            wx7 wx7Var = this.p;
            if (wx7Var != null) {
                wx7Var.k();
            }
            vy7 vy7Var = this.r;
            if (vy7Var != null) {
                vy7Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void l3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, bVar) == null) {
            this.R = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void l4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || this.g2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.g2 = true;
        au4 au4Var = new au4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(k2, Integer.valueOf(m2));
        au4Var.setTitle(R.string.obfuscated_res_0x7f0f0808);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08b8, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c56)).setText(R.string.obfuscated_res_0x7f0f07a5);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092248)).setText(R.string.obfuscated_res_0x7f0f0808);
        au4Var.setContentView(inflate);
        au4Var.setYesButtonTag(sparseArray);
        au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0807, this.c);
        au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a85, new p0(this));
        au4Var.create(this.c.getPageContext()).show();
    }

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void m2(go goVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, goVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.b0 = goVar;
            pbLandscapeListView.W = true;
        }
    }

    public void m3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void m4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z2) == null) {
            this.h.J(z2);
            if (z2 && this.R0) {
                this.K.D(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03ef));
                this.l.setNextPage(this.K);
                this.f = 2;
            }
            Y1();
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            au4 au4Var = new au4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08b8, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092248);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c56)).setVisibility(8);
            au4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(k2, Integer.valueOf(n2));
            au4Var.setYesButtonTag(sparseArray);
            au4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1563, this.c);
            au4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new q0(this));
            au4Var.create(this.c.getPageContext()).show();
        }
    }

    public PbThreadPostView n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            o4();
            this.c.L6();
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().O() == null || this.c.K().S1().O().getAuthor() == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.K().n2()).param("fid", this.c.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.K().b).param("fid", this.c.K().S1().m()).param("obj_locate", 1).param("uid", this.c.K().S1().O().getAuthor().getUserId()));
        }
    }

    public void n3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048746, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void n4(tu7 tu7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048747, this, tu7Var) == null) || tu7Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(tu7Var.b)) {
            this.h.G(tu7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13e6);
        int e2 = dh.e(tu7Var.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f111f);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f135f);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02fa);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02a4), true, new k0(this, tu7Var.c));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.I1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0() {
        d38 d38Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048748, this) == null) || (d38Var = this.K1) == null) {
            return;
        }
        if (((d38Var.a() == null || this.K1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.K1.a())) != -1) {
            if (this.K1.a().getTop() + p2 <= this.W0.getBottom()) {
                this.I1 = 1;
                z2 = true;
            } else {
                this.I1 = 0;
                z2 = false;
            }
        }
        this.Z0.t(this.I1 == 1);
        this.K1.e(z2);
    }

    public RelativeLayout o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) ? this.D : (RelativeLayout) invokeV.objValue;
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            this.E.b0(2);
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    p1().setSystemUiVisibility(4);
                }
            }
            p2();
            Z1();
        }
    }

    public void o3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, onClickListener) == null) {
            this.E.z0(onClickListener);
        }
    }

    public final void o4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || (pbFragment = this.c) == null || pbFragment.L5() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.L5().y())));
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.h.k();
            rz7 rz7Var = this.w;
            if (rz7Var != null) {
                rz7Var.p();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ej.x(pbFragment.getContext(), this.I);
            }
            t1();
            ju4 ju4Var = this.d0;
            if (ju4Var != null) {
                ju4Var.dismiss();
            }
            t0();
            au4 au4Var = this.F;
            if (au4Var != null) {
                au4Var.dismiss();
            }
            cu4 cu4Var = this.G;
            if (cu4Var != null) {
                cu4Var.e();
            }
        }
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public final void p2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048755, this) == null) || (pbFragment = this.c) == null || pbFragment.L5() == null) {
            return;
        }
        this.c.L5().E();
    }

    public void p3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048756, this, i3) == null) {
            this.H1 = i3;
        }
    }

    public void p4(vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, vu7Var) == null) {
            if (vu7Var != null && AntiHelper.o(vu7Var.O())) {
                e38 e38Var = this.F0;
                if (e38Var != null) {
                    e38Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f08097f, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            e38 e38Var2 = this.F0;
            if (e38Var2 == null || !e38Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.C0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f08097f, UbsABTestHelper.isShareTopRight() ? R.color.CAM_X0105 : R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.h.k();
            rz7 rz7Var = this.w;
            if (rz7Var != null) {
                rz7Var.p();
            }
            ju4 ju4Var = this.d0;
            if (ju4Var != null) {
                ju4Var.dismiss();
            }
            t0();
            au4 au4Var = this.F;
            if (au4Var != null) {
                au4Var.dismiss();
            }
            cu4 cu4Var = this.G;
            if (cu4Var != null) {
                cu4Var.e();
            }
        }
    }

    public void q1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.U0.setVisibility(8);
            }
            a18 a18Var = this.h;
            if (a18Var == null || (view2 = a18Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void q2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        rz7 rz7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048760, this, absListView, i3, i4, i5) == null) {
            vx7 vx7Var = this.q;
            if (vx7Var != null) {
                vx7Var.c(i3, i4);
            }
            uy7 uy7Var = this.s;
            if (uy7Var != null) {
                uy7Var.c(i3, i4);
            }
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.n(absListView, i3, i4, i5);
            }
            a18 a18Var = this.h;
            if (a18Var != null && (rz7Var = this.w) != null) {
                a18Var.x(rz7Var.s());
            }
            C2();
            z0 z0Var = this.d1;
            z0Var.a = i3;
            z0Var.b = this.l.getHeaderViewsCount();
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            G3(d0(absListView, i3));
            int i6 = 0;
            D2(this.d1.c, false);
            o0();
            if (!this.K.n() || this.K.C) {
                return;
            }
            z0 z0Var2 = this.d1;
            if (z0Var2 != null && (pbReplyTitleViewHolder = z0Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.e(i6);
            this.K.C = true;
        }
    }

    public void q3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, onLongClickListener) == null) {
            this.w.D(onLongClickListener);
            this.E.w0(onLongClickListener);
            vw7 vw7Var = this.w1;
            if (vw7Var != null) {
                vw7Var.r(onLongClickListener);
            }
        }
    }

    public boolean q4(vu7 vu7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048762, this, vu7Var, z2)) == null) {
            if (vu7Var == null) {
                return false;
            }
            if (this.v != null) {
                if (vu7Var.O() != null && vu7Var.O().getIsNoTitle() == 0 && !vu7Var.O().isVideoThreadType() && !this.P1) {
                    if (vu7Var.O() != null) {
                        ThreadData O = vu7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, K3(vu7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (vu7Var.O().isBJHArticleThreadType()) {
                        this.w.B(this.l);
                        this.v.g(this.l);
                        this.v.a(this.l);
                        this.w.m(this.l);
                        this.w.G(this.N0);
                        if (L1(vu7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.h(vu7Var);
                        }
                    } else {
                        this.w.G(this.N0);
                        if (L1(vu7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.j(vu7Var);
                        }
                    }
                } else if (vu7Var.O().getIsNoTitle() == 1) {
                    if (vu7Var.O() != null) {
                        this.v.g(this.l);
                        this.w.G(this.N0);
                    }
                } else {
                    this.v.g(this.l);
                    this.w.G(this.N0);
                }
            }
            f4(vu7Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void r0() {
        e38 e38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048763, this) == null) || (e38Var = this.F0) == null) {
            return;
        }
        e38Var.l(false);
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048764, this) == null) || this.t0 == null) {
            return;
        }
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
        this.J0 = false;
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            P2(false);
        }
    }

    public void r2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048765, this, absListView, i3) == null) {
            sz7 sz7Var = this.t;
            if (sz7Var != null) {
                sz7Var.o(absListView, i3);
            }
            if (!this.h2 && i3 == 0) {
                this.f2 = k1();
                this.d1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
                D2(this.d1.c, true);
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
            } else if (i3 != 2 || (rightFloatLayerView = this.N1) == null) {
            } else {
                rightFloatLayerView.r();
            }
        }
    }

    public final void r3(PostData postData, vu7 vu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048766, this, postData, vu7Var) == null) {
            this.w.E(postData, vu7Var);
        }
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048767, this) == null) && this.c.C5()) {
            if (this.c.I5() == -1) {
                SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
            }
            if (this.c.H5() == -1) {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
            }
        }
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048768, this)) == null) ? this.u.b(this.M0) : invokeV.booleanValue;
    }

    public void s1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048769, this, z2) == null) || this.t0 == null || this.x0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        vu7 vu7Var = this.N0;
        boolean z3 = vu7Var != null && vu7Var.n0();
        vu7 vu7Var2 = this.N0;
        this.x0.setText(tbSingleton.getAdVertiComment(z3, vu7Var2 != null && vu7Var2.o0(), h1()));
        if (z2) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400L);
            this.t0.startAnimation(alphaAnimation);
        }
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        this.J0 = true;
        if (this.e1 == null || this.w1.l()) {
            return;
        }
        this.e1.setVisibility(0);
        P2(true);
    }

    public void s2(ArrayList<yr4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e6, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.obfuscated_res_0x7f090cdf);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new c0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.obfuscated_res_0x7f090cde);
                TextView textView = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907b8);
                this.b0 = textView;
                textView.setOnClickListener(new d0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907b9);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton l02 = l0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13eb));
            this.n.add(l02);
            l02.setChecked(true);
            this.Y.addView(l02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    yr4 yr4Var = arrayList.get(i3);
                    if (yr4Var != null && !TextUtils.isEmpty(yr4Var.b()) && yr4Var.a() > 0) {
                        CustomBlueCheckRadioButton l03 = l0(String.valueOf(yr4Var.a()), yr4Var.b());
                        this.n.add(l03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Y.addView(view2);
                        this.Y.addView(l03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ej.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.l0.setLayoutParams(layoutParams2);
                this.l0.removeAllViews();
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l0.addView(this.Y);
                }
            }
            ih.j(this.W, this.c.getPageContext());
        }
    }

    public void s3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048771, this, z2, postWriteCallBackData) == null) {
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

    public void s4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048772, this, z2) == null) {
            gx7 gx7Var = this.E;
            if (gx7Var != null) {
                gx7Var.u0(z2);
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
                pbFragment.b7(z2);
            }
            if (z2) {
                t08.d(this.c.getPageContext(), this.c.K(), this.c.P5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            vu7 vu7Var = this.N0;
            TiebaStatic.log(statisticItem.param("fid", vu7Var != null ? vu7Var.m() : "0").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            au4 au4Var = this.U;
            if (au4Var != null) {
                au4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                ih.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                ih.b(dialog2, this.c.getPageContext());
            }
            ju4 ju4Var = this.S;
            if (ju4Var != null) {
                ju4Var.dismiss();
            }
        }
    }

    public void t1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048774, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.o();
        xz7 xz7Var = this.v1;
        if (xz7Var != null) {
            xz7Var.m();
        }
    }

    public void t2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048775, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            u2(i3, str, i4, z2, null);
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            this.c.hideProgressBar();
            vu7 vu7Var = this.N0;
            if (vu7Var != null && this.K != null && vu7Var.y() != null && this.N0.y().b() == 0) {
                this.K.v(this.N0.t());
                if (this.N0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.N0.m());
                    statisticItem.param("fname", this.N0.n());
                    statisticItem.param("tid", this.N0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            x0();
            this.l.A(0L);
            s0();
        }
    }

    public void t4(vu7 vu7Var) {
        nz7 nz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048777, this, vu7Var) == null) || (nz7Var = this.u) == null) {
            return;
        }
        nz7Var.h(vu7Var, this.M0);
    }

    public void u0() {
        sz7 sz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048778, this) == null) || (sz7Var = this.t) == null) {
            return;
        }
        sz7Var.b();
    }

    public void u1() {
        a18 a18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048779, this) == null) || (a18Var = this.h) == null) {
            return;
        }
        a18Var.q();
    }

    public void u2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048780, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            v2(i3, str, i4, z2, str2, false);
        }
    }

    public void u3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048781, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        ej.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void v1() {
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048783, this) == null) || (fx4Var = this.L0) == null) {
            return;
        }
        fx4Var.h(false);
    }

    public void v2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048784, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, str);
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a5 : R.string.obfuscated_res_0x7f0f1013;
            int i6 = R.string.obfuscated_res_0x7f0f043e;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f04a9;
                    i5 = R.string.obfuscated_res_0x7f0f04aa;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f1017;
                }
            }
            this.U = new au4(this.c.getActivity());
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
                J3(sparseArray, i6, i5);
            } else if (z2) {
                J3(sparseArray, i6, i5);
            } else if (A3()) {
                pn5 pn5Var = new pn5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
                pn5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
                pn5Var.h(this.c.K().S1().l().getImage_url());
                pn5Var.j(this.c.K().S1().l().getUser_level());
                Q3(sparseArray, i3, pn5Var, this.c.K().S1().V(), false);
            } else {
                Y3(this.U, i3);
            }
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048785, this) == null) {
            this.K.A();
            this.K.R();
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            if (this.A == null) {
                D1();
            }
            this.k.setVisibility(8);
            Handler handler = this.U1;
            if (handler == null || (runnable = this.V1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void w2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f09203c, str);
            sparseArray.put(R.id.obfuscated_res_0x7f09203e, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09205a, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f09203d, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            if (z2) {
                E3(sparseArray);
            } else {
                F3(i3, sparseArray);
            }
        }
    }

    public void w3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z2) == null) {
            this.w.F(z2);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.y();
                this.K.f();
            }
            v1();
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048791, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void x2(SparseArray<Object> sparseArray, boolean z2) {
        hu4 hu4Var;
        hu4 hu4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048792, this, sparseArray, z2) == null) {
            lu4 lu4Var = new lu4(this.c.getContext());
            lu4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02e8));
            lu4Var.n(new t(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f092036) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092036)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f09203c)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f09203e) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09203e)).intValue() : -1) == 0) {
                    hu4Var2 = new hu4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04bb), lu4Var);
                } else {
                    hu4Var2 = new hu4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04b0), lu4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray2.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                sparseArray2.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                hu4Var2.d.setTag(sparseArray2);
                arrayList.add(hu4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09205b) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09205b)).booleanValue()) {
                hu4 hu4Var3 = new hu4(13, this.c.getString(R.string.obfuscated_res_0x7f0f0b3d), lu4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f09203c, sparseArray.get(R.id.obfuscated_res_0x7f09203c));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203e, sparseArray.get(R.id.obfuscated_res_0x7f09203e));
                sparseArray3.put(R.id.obfuscated_res_0x7f09203d, sparseArray.get(R.id.obfuscated_res_0x7f09203d));
                sparseArray3.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                hu4Var3.d.setTag(sparseArray3);
                arrayList.add(hu4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092047)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092048))) && !V1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f092047, sparseArray.get(R.id.obfuscated_res_0x7f092047));
                sparseArray4.put(R.id.obfuscated_res_0x7f092048, sparseArray.get(R.id.obfuscated_res_0x7f092048));
                sparseArray4.put(R.id.obfuscated_res_0x7f092049, sparseArray.get(R.id.obfuscated_res_0x7f092049));
                sparseArray4.put(R.id.obfuscated_res_0x7f09205a, sparseArray.get(R.id.obfuscated_res_0x7f09205a));
                sparseArray4.put(R.id.obfuscated_res_0x7f09204a, sparseArray.get(R.id.obfuscated_res_0x7f09204a));
                hu4 hu4Var4 = new hu4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0668), lu4Var);
                hu4Var4.d.setTag(sparseArray4);
                arrayList.add(hu4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092096) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092096)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092051, sparseArray.get(R.id.obfuscated_res_0x7f092051));
                sparseArray5.put(R.id.obfuscated_res_0x7f092092, sparseArray.get(R.id.obfuscated_res_0x7f092092));
                sparseArray5.put(R.id.obfuscated_res_0x7f092093, sparseArray.get(R.id.obfuscated_res_0x7f092093));
                sparseArray5.put(R.id.obfuscated_res_0x7f092091, sparseArray.get(R.id.obfuscated_res_0x7f092091));
                sparseArray5.put(R.id.obfuscated_res_0x7f092094, sparseArray.get(R.id.obfuscated_res_0x7f092094));
                sparseArray5.put(R.id.obfuscated_res_0x7f092095, sparseArray.get(R.id.obfuscated_res_0x7f092095));
                sparseArray5.put(R.id.obfuscated_res_0x7f092090, sparseArray.get(R.id.obfuscated_res_0x7f092090));
                if (z2) {
                    hu4Var = new hu4(12, this.c.getString(R.string.obfuscated_res_0x7f0f14bc), lu4Var);
                } else {
                    hu4Var = new hu4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b49), lu4Var);
                }
                hu4Var.d.setTag(sparseArray5);
                arrayList.add(hu4Var);
            }
            s08.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                lu4Var.k(arrayList, false);
            } else {
                lu4Var.k(arrayList, true);
            }
            ju4 ju4Var = new ju4(this.c.getPageContext(), lu4Var);
            this.S = ju4Var;
            ju4Var.k();
        }
    }

    public void x3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, str) == null) {
            this.x0.performClick();
            if (StringUtils.isNull(str) || this.c.L5() == null || this.c.L5().s() == null || this.c.L5().s().i() == null) {
                return;
            }
            EditText i3 = this.c.L5().s().i();
            i3.setText(str);
            i3.setSelection(str.length());
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            this.l.A(0L);
            s0();
        }
    }

    public void y1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048795, this) == null) || (rightFloatLayerView = this.N1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void y2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048796, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        x2(sparseArray, false);
    }

    public void y3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048797, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public void z0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048798, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f123d));
            } else if (z3) {
                if (dj.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c59);
                }
                this.c.showToast(str);
            }
        }
    }

    public void z1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048799, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.q();
    }

    public void z2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048800, this, view2) == null) || this.A0.getData() == null || !this.A0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        xt7 xt7Var = new xt7(this.c.getContext());
        int f2 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
        layoutParams.topMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        xt7Var.k(f2);
        xt7Var.j(layoutParams);
        xt7Var.i(false);
        xt7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.N0.Q(), this.N0.m());
        xt7Var.l(new m(this));
    }

    public void z3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, list) == null) {
            this.u1 = list;
            xz7 xz7Var = this.v1;
            if (xz7Var != null) {
                xz7Var.q(list);
            }
        }
    }
}
