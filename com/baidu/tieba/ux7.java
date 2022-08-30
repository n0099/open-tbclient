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
import com.baidu.tieba.dv4;
import com.baidu.tieba.gl5;
import com.baidu.tieba.hs4;
import com.baidu.tieba.hy7;
import com.baidu.tieba.jl5;
import com.baidu.tieba.mu7;
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
import com.baidu.tieba.ps7;
import com.baidu.tieba.px7;
import com.baidu.tieba.rw7;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.uk8;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wr4;
import com.baidu.tieba.yr4;
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
public class ux7 {
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
    public static uk8.f r2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public NavigationBarCoverTip A1;
    public TextView B;
    public ImageView B0;
    public gl5 B1;
    public TextView C;
    public ImageView C0;
    public jl5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public String D1;
    public cw7 E;
    public View E0;
    public PermissionJudgePolicy E1;
    public wr4 F;
    public e28 F0;
    public long F1;
    public yr4 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public int H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public f28 J;
    public boolean J0;
    public boolean J1;
    public PbListView K;
    public int K0;
    public d28 K1;
    public b28 L;
    public xu4 L0;
    public MaskView L1;
    public View M;
    public boolean M0;
    public final FallingView M1;
    public View N;
    public mt7 N0;
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
    public fs4 S;
    public ViewStub S0;
    public View.OnClickListener S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public CustomMessageListener T1;
    public wr4 U;
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
    public dv4.g c2;
    public RelativeLayout d;
    public fs4 d0;
    public w0 d1;
    public View.OnClickListener d2;
    public View e;
    public fs4 e0;
    public PbEmotionBar e1;
    public final List<TbImageView> e2;
    public int f;
    public as4 f0;
    public int f1;
    public int f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public boolean g2;
    public final uz7 h;
    public boolean h0;
    public Runnable h1;
    public boolean h2;
    public tz7 i;
    public String i0;
    public PbFakeFloorModel i1;
    public ViewStub j;
    public String j0;
    public ow7 j1;
    public ViewStub k;
    public ou7 k0;
    public mx7 k1;
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
    public sw7 p;
    public View p0;
    public boolean p1;
    public rw7 q;
    public EjectionAnimationView q0;
    public int q1;
    public qx7 r;
    public Button r0;
    public PbTopTipView r1;
    public px7 s;
    public View s0;
    public PopupWindow s1;
    public ny7 t;
    public View t0;
    public TextView t1;
    public iy7 u;
    public LinearLayout u0;
    public List<String> u1;
    public ky7 v;
    public HeadImageView v0;
    public sy7 v1;
    public my7 w;
    public ImageView w0;
    public mv7 w1;
    public jy7 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public ly7 y;
    public WaterRippleView y0;
    public boolean y1;
    public hy7 z;
    public ImageView z0;
    public ex7 z1;

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
        public final /* synthetic */ ux7 g;

        /* renamed from: com.baidu.tieba.ux7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0421a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0421a(a aVar) {
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

        public a(ux7 ux7Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ux7Var;
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
                    int f1 = this.g.f1(this.b);
                    int i3 = this.a;
                    int i4 = f1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = f1 - i;
                    }
                    if (this.g.a1 == null || (layoutParams = this.g.a1.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 == 0 || i4 > this.g.d.getMeasuredHeight() || f1 >= this.g.d.getMeasuredHeight()) {
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
                    sg.a().post(new RunnableC0421a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public a0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
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
    public class b implements lu7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public b(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.lu7
        public /* synthetic */ void onStart() {
            ku7.a(this);
        }

        @Override // com.baidu.tieba.lu7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public b0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                ug.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* loaded from: classes6.dex */
        public class a implements k25 {
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

            @Override // com.baidu.tieba.k25
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

        public c(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D3();
                m25.g().c(new a(this));
            }
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.O2();
                this.a.q0.l();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr4.c a;
        public final /* synthetic */ ux7 b;

        public c0(ux7 ux7Var, yr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public d(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.A0 == null || this.a.A0.getData() == null) {
                return;
            }
            ux7 ux7Var = this.a;
            ux7Var.I2(ux7Var.A0.getData(), this.a.A0.getData().agreeNum);
            if (this.a.A0.F()) {
                return;
            }
            ux7 ux7Var2 = this.a;
            ux7Var2.B2(ux7Var2.A0);
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr4.c a;
        public final /* synthetic */ ux7 b;

        public d0(ux7 ux7Var, yr4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public e(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.r1()) {
                        return;
                    }
                    tu4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public e0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
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
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public f(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray<Object> sparseArray;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
                return;
            }
            boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f092032) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092032)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f092030) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092030)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffd, 1);
                    this.a.c.e5(sparseArray);
                    return;
                }
                this.a.A2(view2);
            } else if (booleanValue2) {
                sparseArray.put(R.id.obfuscated_res_0x7f091ffd, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fe6, 1);
                this.a.c.e5(sparseArray);
            } else if (booleanValue3) {
                this.a.v2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements hy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public f0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.hy7.a
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public g(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx4 a;
        public final /* synthetic */ ux7 b;

        public g0(ux7 ux7Var, tx4 tx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, tx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = tx4Var;
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
        public final /* synthetic */ ux7 a;

        public h(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.Q(postData);
                this.a.E.a0();
                this.a.j1.c();
                this.a.m0.q();
                this.a.J3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public h0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ux7 ux7Var;
            uz7 uz7Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.E == null || (uz7Var = (ux7Var = this.a).h) == null || uz7Var.i == null || ux7Var.N0 == null || this.a.N0.O() == null || this.a.N0.O().isVideoThreadType() || this.a.Q1() || this.a.N0.l() == null || qi.isEmpty(this.a.N0.l().getName())) {
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
    public class i implements FallingView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public i(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d4();
            }
        }

        @Override // com.baidu.tieba.pb.view.FallingView.n
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
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ux7 b;

        public i0(ux7 ux7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ri.D()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c40);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public j(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    tu4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ mt7 c;
        public final /* synthetic */ ux7 d;

        public j0(ux7 ux7Var, Parcelable parcelable, ArrayList arrayList, mt7 mt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, parcelable, arrayList, mt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ux7Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = mt7Var;
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
                this.d.K.C(this.d.c.getString(R.string.obfuscated_res_0x7f0f0ddb));
                this.d.K.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ps7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public k(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.ps7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.Q();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public k0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.q1) {
                    this.a.m0();
                    this.a.l2();
                }
                this.a.v0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
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
    public class l0 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public l0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                this.a.m0();
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public m(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A == null) {
                    this.a.A1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m0 a;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c.HidenSoftKeyPad((InputMethodManager) this.a.a.c.getBaseFragmentActivity().getSystemService("input_method"), this.a.a.d);
                }
            }
        }

        public m0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                sg.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
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
    public class n0 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public o(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.S2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements o25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public p(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.o25
        public void A(n25 n25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, n25Var) == null) {
                Object obj = n25Var.c;
                if ((obj instanceof jy4) && EmotionGroupType.isSendAsPic(((jy4) obj).getType())) {
                    if (this.a.E1 == null) {
                        this.a.E1 = new PermissionJudgePolicy();
                    }
                    this.a.E1.clearRequestPermissionList();
                    this.a.E1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.E1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    jy4 jy4Var = (jy4) n25Var.c;
                    this.a.c.O5().h(jy4Var);
                    if (jy4Var.i()) {
                        this.a.c.O5().M(null, null);
                    } else {
                        this.a.c.O5().z(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ ux7 e;

        public p0(ux7 ux7Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ux7Var;
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
    public class q implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public q(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.c.K0 == null || this.a.c.K0.e() == null) {
                return;
            }
            if (!this.a.c.K0.e().e()) {
                this.a.c.K0.a(false);
            }
            this.a.c.K0.e().l(false);
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
                ux7 ux7Var = this.a;
                ux7Var.v1 = new sy7(ux7Var.c.getPageContext(), this.a.d, layoutParams);
                if (!ListUtils.isEmpty(this.a.u1)) {
                    this.a.v1.q(this.a.u1);
                }
                this.a.v1.r(this.a.m0);
            }
            this.a.v1.p(substring);
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx4 a;
        public final /* synthetic */ ux7 b;

        public q0(ux7 ux7Var, tx4 tx4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, tx4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = tx4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.N1.setHomePbFloatLastCloseTime();
                this.b.v1();
                this.b.N1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements hs4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ux7 b;

        public r(ux7 ux7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.hs4.e
        public void i0(hs4 hs4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, hs4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.v2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091fec), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f09200a)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091fed)).booleanValue());
                        return;
                    case 11:
                        if (this.b.X1 != null) {
                            this.b.X1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f09200a), sparseArray.get(R.id.obfuscated_res_0x7f091ff7), sparseArray.get(R.id.obfuscated_res_0x7f091ffa), sparseArray.get(R.id.obfuscated_res_0x7f091ff8), sparseArray.get(R.id.obfuscated_res_0x7f091ff9)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.b6(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f092042), sparseArray);
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

    /* loaded from: classes6.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(ux7 ux7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, Integer.valueOf(i)};
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
            this.a = ux7Var;
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
    public class s implements wr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wr4.e
        public void onClick(wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wr4Var) == null) {
                wr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ ux7 b;

        public s0(ux7 ux7Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.J1 || this.a == null || this.b.c.K() == null || !this.b.c.K().D2()) {
                return;
            }
            this.b.J1 = true;
            this.a.b5(false);
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ux7 c;

        public t(ux7 ux7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ux7Var;
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
                if (!pi.A()) {
                    ri.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.c.c.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements mu7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public t0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // com.baidu.tieba.mu7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.e6();
            }
        }

        @Override // com.baidu.tieba.mu7.b
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
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public u(ux7 ux7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, alertDialog};
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
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ q45 b;
        public final /* synthetic */ ux7 c;

        public u0(ux7 ux7Var, ReplyPrivacyCheckController replyPrivacyCheckController, q45 q45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, replyPrivacyCheckController, q45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ux7Var;
            this.a = replyPrivacyCheckController;
            this.b = q45Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a == null || this.c.c == null || this.c.c.v5() == null || this.a.checkPrivacyBeforeInvokeEditor(this.c.c.v5().replyPrivateFlag)) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    if (DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                        this.c.q4();
                        this.b.x0();
                        this.c.s0();
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements uk8.f {
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

        @Override // com.baidu.tieba.uk8.f
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux7 a;

        public v0(ux7 ux7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ ux7 c;

        public w(ux7 ux7Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ux7Var;
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
                if (!pi.A()) {
                    ri.M(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c40);
                } else {
                    this.c.c.m5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class w0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public w0() {
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
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(ux7 ux7Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, alertDialog};
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
    public class y implements gl5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr4 a;
        public final /* synthetic */ ux7 b;

        public y(ux7 ux7Var, wr4 wr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, wr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = wr4Var;
        }

        @Override // com.baidu.tieba.gl5.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.n5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements jl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ ux7 b;

        public z(ux7 ux7Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux7Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ux7Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.jl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.m5(this.a, jSONArray);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948226453, "Lcom/baidu/tieba/ux7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948226453, "Lcom/baidu/tieba/ux7;");
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
        p2 = ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        q2 = 1;
        r2 = new v();
    }

    public ux7(PbFragment pbFragment, View.OnClickListener onClickListener, ou7 ou7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ou7Var};
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
        this.d1 = new w0();
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
        this.R1 = new r0(this, 2921306);
        this.S1 = new j(this);
        this.T1 = new l(this, 2005016);
        this.U1 = new Handler();
        this.W1 = new n(this, 2004009);
        this.Y1 = true;
        this.Z1 = new e0(this);
        this.a2 = false;
        this.b2 = null;
        this.e2 = new ArrayList();
        this.g2 = false;
        this.F1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.P = onClickListener;
        this.k0 = ou7Var;
        this.q1 = ri.k(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d062a, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903ed);
        this.A1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091822);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091f2d);
        this.O1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091bf4);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0921f7);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f092568);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09165e);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c26);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ri.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (yj5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.M2);
        this.a = new s0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new uz7(pbFragment, this.d);
        if (this.c.F5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091481);
            this.j = viewStub;
            viewStub.setVisibility(0);
            tz7 tz7Var = new tz7(pbFragment);
            this.i = tz7Var;
            tz7Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ri.f(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new mu7(new t0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f09254e);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917c1);
        ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090874);
        this.w0.setOnClickListener(new u0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.O5()));
        a2();
        t0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c4);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0917bc);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new v0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090878);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c2);
        this.L1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0914a2);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0917be);
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
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c0);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0917c7);
        this.E0 = findViewById;
        findViewById.setVisibility((tu4.k().h("pb_share_red_dot_shown", false) || !TbadkCoreApplication.isLogin()) ? 8 : 0);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c5);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c6);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.S1);
        this.C0.setOnClickListener(new e(this));
        d2();
        e28 e28Var = new e28(this.C0);
        this.F0 = e28Var;
        e28Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917c3);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0917bf);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090f58);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new iy7(this.c, ou7Var);
        this.w = new my7(this.c, ou7Var, this.P);
        cw7 cw7Var = new cw7(this.c, this.l);
        this.E = cw7Var;
        cw7Var.y0(this.P);
        this.E.A0(this.k0);
        this.E.v0(this.Q);
        this.E.x0(this.c.j2);
        this.E.r0(this.d2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.t0(fVar);
        E1();
        y1();
        ly7 ly7Var = new ly7(this.c);
        this.y = ly7Var;
        ly7Var.f = 2;
        x1();
        this.z.a(this.l);
        this.w.m(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091812);
        this.N = this.K.b().findViewById(R.id.obfuscated_res_0x7f0917ac);
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
        this.K.z();
        this.K.o(R.drawable.pb_foot_more_trans_selector);
        this.K.p(R.drawable.pb_foot_more_trans_selector);
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f092584);
        this.c.registerListener(this.W1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel K = this.c.K();
        this.i1.S(K.I(), K.E(), K.F(), K.D(), K.J());
        ow7 ow7Var = new ow7(this.c.getPageContext(), this.i1, this.d);
        this.j1 = ow7Var;
        ow7Var.k(new g(this));
        this.j1.n(this.c.o2);
        this.i1.U(new h(this));
        if (this.c.K() != null && !StringUtils.isNull(this.c.K().V1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.K().V1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917c9);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f0903eb);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091f3a);
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
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091840));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.e0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.j2);
        this.c.registerListener(this.T1);
        this.c.registerListener(this.R1);
        PbFragment pbFragment3 = this.c;
        this.K1 = new d28(pbFragment3, pbFragment3.getUniqueId());
        this.M1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f09097f);
        Y2();
        this.M1.setAnimationListener(new i(this));
        h0();
        R2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f0917b2);
        g0(yj5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && K.H2() && qs7.b().e()) {
            if (this.p == null) {
                this.p = new sw7(this.c.getActivity(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f0917ea));
            }
            rw7 rw7Var = new rw7(this.l);
            this.q = rw7Var;
            rw7Var.d(new rw7.a() { // from class: com.baidu.tieba.qv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rw7.a
                public final void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ux7.this.V1();
                    }
                }
            });
        }
        this.r = new qx7(this.c.P(), (ViewGroup) m1().findViewById(R.id.obfuscated_res_0x7f091853));
        px7 px7Var = new px7(this.l);
        this.s = px7Var;
        px7Var.d(new px7.a() { // from class: com.baidu.tieba.rv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.px7.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    ux7.this.W1();
                }
            }
        });
    }

    public cw7 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.E : (cw7) invokeV.objValue;
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.c.F5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09147c);
            this.k = viewStub;
            viewStub.setVisibility(0);
            if (this.A == null) {
                this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09147b);
                mb5.a(this.c.getPageContext(), this.A);
            }
            if (this.B == null) {
                this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091480);
            }
            if (this.C == null) {
                this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09147f);
            }
            this.B.setOnClickListener(this.P);
            this.C.setOnClickListener(this.P);
        }
    }

    public void A2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        z2(sparseArray, false);
    }

    public void A3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i3) == null) {
            this.l.setSelection(i3);
        }
    }

    public LinearLayout B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.u0 : (LinearLayout) invokeV.objValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.c != null && this.m0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.m0.j();
                if (this.c.O5() != null) {
                    this.c.O5().Q();
                }
                o1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public void B2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || this.A0.getData() == null || !this.A0.getData().hasAgree || this.c.getActivity() == null) {
            return;
        }
        ps7 ps7Var = new ps7(this.c.getContext());
        int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds774);
        int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
        int[] iArr = new int[2];
        view2.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(f3, f2);
        layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((f3 * 1) / 1.45d));
        layoutParams.topMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
        ps7Var.k(f2);
        ps7Var.j(layoutParams);
        ps7Var.i(false);
        ps7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i4, this.N0.Q(), this.N0.m());
        ps7Var.l(new k(this));
    }

    public void B3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.u1 = list;
            sy7 sy7Var = this.v1;
            if (sy7Var != null) {
                sy7Var.q(list);
            }
        }
    }

    public View C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view2 = this.X;
            if (view2 != null) {
                return view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void C1(mt7 mt7Var, tx4 tx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, mt7Var, tx4Var) == null) || this.O1 == null || mt7Var == null || tx4Var == null || this.c.getContext() == null) {
            return;
        }
        if (!RightFloatLayerView.k()) {
            v1();
            return;
        }
        if (this.N1 == null) {
            this.N1 = RightFloatLayerLottieView.F(tx4Var, this.c.getContext());
            this.O1.removeAllViews();
            this.O1.addView(this.N1);
        }
        if ((this.M1.getTag() instanceof Boolean) && !((Boolean) this.M1.getTag()).booleanValue()) {
            this.N1.setAutoCompleteShown(false);
            this.N1.setTag(this.M1);
            this.N1.c();
        }
        if (tx4Var.a()) {
            return;
        }
        this.N1.setData(tx4Var);
        this.N1.setLogoListener(new g0(this, tx4Var));
        this.N1.setFeedBackListener(new q0(this, tx4Var));
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            qx7 qx7Var = this.r;
            return qx7Var != null && qx7Var.l();
        }
        return invokeV.booleanValue;
    }

    public final boolean C3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            PbFragment pbFragment = this.c;
            return (pbFragment == null || pbFragment.K().S1().l().getDeletedReasonInfo() == null || 1 != this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public void D1(mt7 mt7Var) {
        tx4 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, mt7Var) == null) || mt7Var == null) {
            return;
        }
        if (mt7Var.n0()) {
            pbAdFloatViewItemData = mt7Var.a0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            C1(mt7Var, pbAdFloatViewItemData);
        } else {
            v1();
        }
    }

    public void D2(f15 f15Var, int i3) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, f15Var, i3) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.D(f15Var, this.c.getPageContext(), i3, false);
    }

    public final void D3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null) {
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
            int f2 = ri.f(this.c.getActivity(), R.dimen.tbds166);
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

    public int E0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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

    public final void E1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.x == null) {
            this.x = new jy7(this.c, this.P);
        }
    }

    public final void E2() {
        uz7 uz7Var;
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || this.v == null || (uz7Var = this.h) == null || uz7Var.p() == null || (mt7Var = this.N0) == null || mt7Var.O() == null || !this.N0.O().isQuestionThread() || this.v.c() == null || this.v.c().getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        this.v.c().getLocationInWindow(iArr);
        boolean z2 = true;
        int height = iArr[1] + this.v.c().getHeight();
        boolean z3 = this.v.c().getParent() != null;
        uz7 uz7Var2 = this.h;
        if (height > uz7Var2.p().getBottom() && z3) {
            z2 = false;
        }
        uz7Var2.H(z2, this.N0.O().getSpan_str());
    }

    public void E3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            uz7 uz7Var = this.h;
            if (uz7Var == null || (view2 = uz7Var.d) == null) {
                return;
            }
            view2.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        }
    }

    public PostData F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int E0 = E0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (E0 < 0) {
                E0 = 0;
            }
            if (this.E.y(E0) != null && this.E.y(E0) != PostData.J0) {
                i3 = E0 + 1;
            }
            if (this.E.x(i3) instanceof PostData) {
                return (PostData) this.E.x(i3);
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public void F1(mt7 mt7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mt7Var) == null) {
            int i3 = 0;
            this.E.i0(mt7Var, false);
            this.E.a0();
            p0();
            mv7 mv7Var = this.w1;
            if (mv7Var != null) {
                mv7Var.n();
            }
            ArrayList<PostData> F = mt7Var.F();
            if (mt7Var.y().b() == 0 || F == null || F.size() < mt7Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                    if (mt7Var.y().b() == 0) {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                    } else {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3d));
                    }
                    this.K.k();
                } else {
                    w0 w0Var = this.d1;
                    if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                    }
                    if (this.c.o6()) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0de1), i3);
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0de2), i3);
                    }
                }
            }
            J2(mt7Var);
        }
    }

    public final void F2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, pbReplyTitleViewHolder, z2) == null) || this.n1 || this.W0 == null || this.h.p() == null) {
            return;
        }
        View s2 = A0().s();
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
            I3(false);
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
                    I3(false);
                } else if (top < measuredHeight) {
                    this.W0.setVisibility(0);
                    I3(false);
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

    public void F3() {
        ny7 ny7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (ny7Var = this.t) == null) {
            return;
        }
        ny7Var.u(this.l);
    }

    public FallingView G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.M1 : (FallingView) invokeV.objValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.a2 : invokeV.booleanValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.w.A(this.N0, this.O0, this.o1, this.n1);
        }
    }

    public final void G3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, sparseArray) == null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1177, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0371, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b2f);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b30);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new w(this, w2, sparseArray));
        aVar2.a(new x(this, w2));
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? J0(this.l.getFirstVisiblePosition()) : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.J0 : invokeV.booleanValue;
    }

    public void H2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.m1;
        int firstVisiblePosition = (this.l.getFirstVisiblePosition() == 0 || this.l.getFirstVisiblePosition() + headerViewsCount < 0) ? 0 : this.l.getFirstVisiblePosition() + headerViewsCount;
        View childAt = this.l.getChildAt(0);
        int top = childAt != null ? childAt.getTop() : -1;
        this.d1.c = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.d1.c;
        int f1 = f1(pbReplyTitleViewHolder);
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
            this.l.setOnLayoutListener(new a(this, f1, pbReplyTitleViewHolder, z2, measuredHeight, firstVisiblePosition, top));
        }
    }

    public final void H3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048607, this, i3, sparseArray) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().o() == null || this.c.K().S1().l() == null || this.c.K().S1().l().getDeletedReasonInfo() == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.TRUE);
        }
        il5 il5Var = new il5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
        il5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
        il5Var.h(this.c.K().S1().l().getImage_url());
        il5Var.j(this.c.K().S1().l().getUser_level());
        S3(sparseArray, i3, il5Var, this.c.K().S1().V(), true);
    }

    public PostData I0(mt7 mt7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048608, this, mt7Var, z2)) == null) {
            PostData postData = null;
            if (mt7Var == null) {
                return null;
            }
            if (mt7Var.X() != null) {
                return mt7Var.X();
            }
            if (!ListUtils.isEmpty(mt7Var.F())) {
                Iterator<PostData> it = mt7Var.F().iterator();
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
                postData = mt7Var.j();
            }
            if (!L1(postData)) {
                postData = d1(mt7Var);
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeLZ.objValue;
    }

    public final boolean I1(mt7 mt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, mt7Var)) == null) {
            if (mt7Var == null || mt7Var.O() == null) {
                return false;
            }
            SpannableStringBuilder span_str = mt7Var.O().getSpan_str();
            if (span_str != null) {
                return TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dc9).equals(span_str.toString());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void I2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048610, this, agreeData, j3) == null) || agreeData == null || (textView = this.G0) == null) {
            return;
        }
        if (j3 > 0) {
            if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                this.G0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            }
            this.G0.setText(y0(j3));
            this.G0.setVisibility(0);
            return;
        }
        textView.setVisibility(8);
    }

    public void I3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.o0.setVisibility(z2 ? 0 : 8);
        }
    }

    public final int J0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i3)) == null) {
            gn adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof jt7)) {
                i3++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o3) {
                i3 = o3;
            }
            int n3 = (this.l.getAdapter2() == null || !(this.l.getAdapter2() instanceof gn)) ? 0 : this.l.getAdapter2().n();
            if (i3 > n3) {
                return i3 - n3;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    public boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public final void J2(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, mt7Var) == null) || mt7Var == null || mt7Var.O() == null) {
            return;
        }
        r4(mt7Var);
        ImageView imageView = this.B0;
        if (imageView != null && imageView.getContext() != null) {
            if (mt7Var.r()) {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f080960, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
        String z0 = z0(mt7Var.O().getReply_num());
        TextView textView = this.H0;
        if (textView != null) {
            textView.setText(z0);
        }
        TextView textView2 = this.I0;
        if (textView2 != null) {
            textView2.setText(z0);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, mt7Var.O()));
        I2(mt7Var.O().getAgreeData(), mt7Var.O().getAgreeNum());
        if (this.A0 == null || mt7Var.O() == null) {
            return;
        }
        this.A0.setThreadData(mt7Var.O());
        int i3 = 1;
        if (mt7Var.O().getAgreeData() != null) {
            mt7Var.O().getAgreeData().isInThread = true;
        }
        this.A0.setData(mt7Var.O().getAgreeData());
        no4 no4Var = new no4();
        no4Var.b = 26;
        if (mt7Var.O().isVideoThreadType() && mt7Var.O().getThreadVideoInfo() != null) {
            i3 = 2;
        }
        no4Var.c = i3;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.K() != null) {
            no4Var.j = this.c.K().getFromForumId();
            no4Var.f = this.c.K().R1();
        }
        this.A0.setStatisticData(no4Var);
    }

    public void J3(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) || this.t0 == null) {
            return;
        }
        a3(this.c.O5().C());
        if (this.n0) {
            N3(z2);
        } else {
            p1(z2);
        }
    }

    public Button K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.r0 : (Button) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public void K2(int i3, mt7 mt7Var, boolean z2, int i4) {
        PostData I0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i3), mt7Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) || i3 <= 0 || (I0 = I0(mt7Var, z2)) == null || I0.s() == null) {
            return;
        }
        MetaData s2 = I0.s();
        s2.setGiftNum(s2.getGiftNum() + i3);
    }

    public void K3(mt7 mt7Var) {
        PostData postData;
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, mt7Var) == null) || mt7Var == null || (postData = this.O0) == null || postData.s() == null || (uz7Var = this.h) == null) {
            return;
        }
        boolean z2 = !this.n1;
        this.o1 = z2;
        uz7Var.I(z2);
        if (this.c.P5() != null) {
            this.c.P5().s(this.o1);
        }
        G2();
        PbFragment pbFragment = this.c;
        if (pbFragment != null && !pbFragment.u0() && !ListUtils.isEmpty(mt7Var.p())) {
            gr4 gr4Var = mt7Var.p().get(0);
            if (gr4Var != null) {
                this.h.M(mt7Var, gr4Var.c(), gr4Var.d(), gr4Var.a(), gr4Var.getIsLike());
            }
        } else if (mt7Var.l() != null) {
            this.h.M(mt7Var, mt7Var.l().getName(), mt7Var.l().getId(), mt7Var.l().getImage_url(), mt7Var.l().isLike() == 1);
        }
        if (this.o1) {
            this.w.L(mt7Var, this.O0, this.h0);
            View view2 = this.Y0;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (this.x1 == null) {
                this.x1 = new k0(this);
            }
            this.l.setListViewDragListener(this.x1);
            return;
        }
        View view3 = this.Y0;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        this.w.L(mt7Var, this.O0, this.h0);
        this.x1 = null;
        this.l.setListViewDragListener(null);
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.l.getHeaderViewsCount() : invokeV.intValue;
    }

    public final boolean L1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s2 = postData.s();
            return (TextUtils.isEmpty(s2.getUserId()) && TextUtils.isEmpty(s2.getAvater())) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public void L2(mt7 mt7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{mt7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            V3(mt7Var, z2, i3, i4);
            this.w.y(i4);
        }
    }

    public final void L3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048623, this, sparseArray, i3, i4) == null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04ac, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0371, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(i3);
        tBAlertBuilder.k(i4);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new t(this, w2, sparseArray));
        aVar2.a(new u(this, w2));
    }

    public TextView M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.w.q() : (TextView) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (pbInterviewStatusView = this.T0) != null && pbInterviewStatusView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.T0.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.T0.setLayoutParams(layoutParams);
        }
    }

    public final boolean M3(mt7 mt7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, mt7Var)) == null) {
            if (mt7Var == null || mt7Var.O() == null) {
                return false;
            }
            return mt7Var.O().getIsLive() == 1 || mt7Var.O().getThreadType() == 33 || !(mt7Var.O().getTopicData() == null || mt7Var.O().getTopicData().a() == 0) || mt7Var.O().getIs_top() == 1 || mt7Var.O().getIs_good() == 1 || mt7Var.O().isActInfo() || mt7Var.O().isInterviewLive() || mt7Var.O().isVoteThreadType() || mt7Var.O().getYulePostActivityData() != null || !qi.isEmpty(mt7Var.O().getCategory()) || mt7Var.O().isGodThread() || mt7Var.O().isRealGod();
        }
        return invokeL.booleanValue;
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            e28 e28Var = this.F0;
            if (e28Var != null) {
                return e28Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.b2) : invokeV.booleanValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || this.f == 2) {
            return;
        }
        this.l.setNextPage(this.K);
        this.f = 2;
    }

    public void N3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) || this.t0 == null || (textView = this.x0) == null) {
            return;
        }
        textView.setText(R.string.obfuscated_res_0x7f0f051a);
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
        R2(true);
    }

    public PbInterviewStatusView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.T0 : (PbInterviewStatusView) invokeV.objValue;
    }

    public final boolean O1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            if (threadData == null || threadData.getAuthor() == null) {
                return false;
            }
            PostData I0 = I0(this.N0, false);
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), (I0 == null || I0.s() == null) ? "" : I0.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void O2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
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

    public void O3(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, view2) == null) || tu4.k().h("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f043e);
        this.t1.setGravity(17);
        this.t1.setPadding(ri.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ri.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ri.f(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
        this.l.postDelayed(new p0(this, i5, i3, i4, view2), 100L);
        tu4.k().u("show_long_press_collection_tips", true);
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.y1 : invokeV.booleanValue;
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
            return bottom > 0 && bottom <= rect.bottom;
        }
        return invokeV.booleanValue;
    }

    public void P2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048638, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        this.z.d(pbLandscapeListView);
        this.v.g(this.l);
        this.w.B(this.l);
        this.x.d(this.l);
        this.u.f(this.l);
    }

    public void P3() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (uz7Var = this.h) == null || this.p1) {
            return;
        }
        uz7Var.D();
        this.p1 = true;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            int lastVisiblePosition = this.l.getLastVisiblePosition();
            if (this.t != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
                if (lastVisiblePosition < 0) {
                    lastVisiblePosition = 0;
                }
            }
            return J0(lastVisiblePosition);
        }
        return invokeV.intValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            mt7 mt7Var = this.N0;
            return mt7Var == null || mt7Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName());
        }
        return invokeV.booleanValue;
    }

    public final void Q2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null || this.m0 == null) {
            return;
        }
        m45.a().c(0);
        q45 O5 = this.c.O5();
        O5.U();
        O5.S();
        if (O5.y() != null) {
            O5.y().setMaxImagesAllowed(O5.v ? 1 : 9);
        }
        O5.n0(SendView.h);
        O5.j(SendView.h);
        u25 m3 = this.m0.m(23);
        u25 m4 = this.m0.m(2);
        u25 m5 = this.m0.m(5);
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

    public void Q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            this.l.setVisibility(0);
        }
    }

    public BdTypeListView R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.l : (BdTypeListView) invokeV.objValue;
    }

    public boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            ny7 ny7Var = this.t;
            return ny7Var != null && ny7Var.f();
        }
        return invokeV.booleanValue;
    }

    public final void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
        }
    }

    public void R3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.L0 == null) {
                this.L0 = new xu4(this.c.getPageContext());
            }
            this.L0.h(true);
        }
    }

    public SparseArray<Object> S0(mt7 mt7Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        PostData I0;
        mp4 mp4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048648, this, new Object[]{mt7Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (mt7Var == null || (I0 = I0(mt7Var, z2)) == null) {
                return null;
            }
            String userId = I0.s().getUserId();
            boolean z3 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, I0.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fee, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(mt7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.FALSE);
            } else if (i3 == 1) {
                if (I0.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff7, I0.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff8, I0.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ff9, I0.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffa, I0.K());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091fec, I0.K());
                sparseArray.put(R.id.obfuscated_res_0x7f091fee, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(mt7Var.W()));
                sparseArray.put(R.id.obfuscated_res_0x7f092032, Boolean.TRUE);
            }
            if (!z3) {
                List<gr4> p3 = mt7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (gr4 gr4Var : p3) {
                        if (gr4Var != null && !StringUtils.isNull(gr4Var.c()) && (mp4Var = gr4Var.g) != null && mp4Var.a && !mp4Var.c && ((i4 = mp4Var.b) == 1 || i4 == 2)) {
                            sb.append(qi.cutString(gr4Var.c(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f065b));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091feb, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04a4), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.P1 : invokeV.booleanValue;
    }

    public void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            Q2();
            q1();
            this.j1.c();
            J3(false);
        }
    }

    public final void S3(SparseArray<Object> sparseArray, int i3, il5 il5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{sparseArray, Integer.valueOf(i3), il5Var, userData, Boolean.valueOf(z2)}) == null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.C1 == null && this.u != null) {
            this.C1 = new jl5(pbFragment.getPageContext(), this.u.c(), il5Var, userData);
        }
        this.C1.C(z2);
        AntiData v5 = this.c.v5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (v5 != null && v5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = v5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray2);
        this.C1.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3), this.c.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.C1.D(eq4Var);
        this.C1.G((i3 == 1 || i3 == 2) ? "4" : "3");
        this.C1.F(new z(this, sparseArray));
    }

    public mv7 T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.w1 : (mv7) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            e28 e28Var = this.F0;
            if (e28Var == null) {
                return false;
            }
            return e28Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        ny7 ny7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (ny7Var = this.t) == null) {
            return;
        }
        ny7Var.q(this.l, this.V0, this.P0);
    }

    public void T3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.E.i0(this.N0, false);
            this.E.a0();
        }
    }

    public View U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.N : (View) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.m0;
            return editorTools != null && editorTools.u();
        }
        return invokeV.booleanValue;
    }

    public void U2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || (handler = this.U1) == null) {
            return;
        }
        Runnable runnable = this.V1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        m mVar = new m(this);
        this.V1 = mVar;
        this.U1.postDelayed(mVar, 2000L);
    }

    public void U3(mt7 mt7Var, int i3, int i4, boolean z2, int i5, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        int i6;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        PbFragment pbFragment;
        mt7 mt7Var2;
        Parcelable e2;
        Parcelable e3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{mt7Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) || mt7Var == null || this.l == null) {
            return;
        }
        this.N0 = mt7Var;
        this.P0 = i3;
        if (mt7Var.O() != null) {
            this.f1 = mt7Var.O().getCopyThreadRemindType();
            if (mt7Var.O().getAnchorLevel() != 0) {
                this.a2 = true;
            }
            this.h0 = O1(mt7Var.O());
        }
        if (mt7Var.V() != null) {
            this.b2 = mt7Var.V().getUserId();
        }
        z1(mt7Var);
        e0();
        this.R0 = false;
        this.M0 = z2;
        v3();
        vt7 vt7Var = mt7Var.h;
        if (vt7Var != null && vt7Var.b()) {
            if (this.o == null) {
                PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                this.o = pbThreadPostView;
                this.l.x(pbThreadPostView, 1);
                this.o.setData(mt7Var);
                this.o.setChildOnClickLinstener(this.P);
            }
        } else {
            PbThreadPostView pbThreadPostView2 = this.o;
            if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                pbLandscapeListView.removeHeaderView(pbThreadPostView2);
            }
        }
        V3(mt7Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
        K3(mt7Var);
        this.w.M(mt7Var, this.O0);
        if (this.z1 == null) {
            this.z1 = new ex7(this.c.getPageContext(), this.A1);
        }
        this.z1.a(mt7Var.w());
        if (this.c.F5()) {
            if (this.J == null) {
                f28 f28Var = new f28(this.c.getPageContext());
                this.J = f28Var;
                f28Var.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            T2();
            f28 f28Var2 = this.J;
            if (f28Var2 != null) {
                f28Var2.H(TbadkCoreApplication.getInst().getSkinType());
            }
        } else if (mt7Var.y().c() == 0 && z2) {
            this.l.setPullRefresh(null);
        } else {
            if (this.J == null) {
                f28 f28Var3 = new f28(this.c.getPageContext());
                this.J = f28Var3;
                f28Var3.n();
                this.J.f(this.c2);
            }
            this.l.setPullRefresh(this.J);
            T2();
            f28 f28Var4 = this.J;
            if (f28Var4 != null) {
                f28Var4.H(TbadkCoreApplication.getInst().getSkinType());
            }
            s1();
        }
        p0();
        this.E.p0(this.M0);
        this.E.m0(false);
        this.E.n0(i3 == 5);
        this.E.o0(i3 == 6);
        this.E.k0(z3 && this.Y1 && i3 != 2);
        this.E.i0(mt7Var, false);
        this.E.a0();
        this.E.c0(mt7Var.y().b() != 0, mt7Var.g());
        this.w.K(I0(mt7Var, z2), mt7Var.i0());
        if (mt7Var.O() != null && mt7Var.O().getPraise() != null && this.b != -1) {
            mt7Var.O().getPraise().setIsLike(this.b);
        }
        this.l.removeFooterView(this.a1);
        this.l.addFooterView(this.a1);
        if (TbadkCoreApplication.isLogin()) {
            this.l.setNextPage(this.K);
            this.f = 2;
            s1();
        } else {
            this.R0 = true;
            if (mt7Var.y().b() == 1) {
                if (this.L == null) {
                    PbFragment pbFragment2 = this.c;
                    this.L = new b28(pbFragment2, pbFragment2);
                }
                this.l.setNextPage(this.L);
            } else {
                this.l.setNextPage(this.K);
            }
            this.f = 3;
        }
        ArrayList<PostData> F = mt7Var.F();
        if (mt7Var.y().b() != 0 && F != null && F.size() >= mt7Var.y().e()) {
            if (z3) {
                if (this.Y1) {
                    u0();
                    if (mt7Var.y().b() != 0) {
                        this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0dda));
                    }
                } else {
                    this.K.z();
                    this.K.N();
                }
            } else {
                this.K.z();
                this.K.N();
            }
            this.K.k();
        } else {
            if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).B() != 1)) {
                if (mt7Var.y().b() == 0) {
                    this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
                } else {
                    this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a3d));
                }
                this.K.k();
            } else {
                w0 w0Var = this.d1;
                if (w0Var == null || (pbReplyTitleViewHolder = w0Var.c) == null || pbReplyTitleViewHolder.getView() == null) {
                    i6 = 0;
                } else {
                    i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
                }
                if (this.c.o6()) {
                    this.K.u(false);
                    if (ListUtils.isEmpty(mt7Var.R())) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0de1), i6);
                    }
                } else if (ListUtils.isEmpty(mt7Var.R())) {
                    this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0de2), i6);
                }
                if (this.c.P5() != null && !this.c.P5().p()) {
                    this.c.P5().x();
                }
            }
            if (mt7Var.y().b() == 0 || F == null) {
                N2();
            }
        }
        if (i3 == 2) {
            this.l.setSelection(i4 > 1 ? (i4 + ((this.l.getData() == null && mt7Var.F() == null) ? 0 : (this.l.getData().size() - mt7Var.F().size()) + this.l.getHeaderViewsCount())) - 2 : 0);
        } else if (i3 != 3) {
            if (i3 == 4) {
                this.Y1 = false;
            } else if (i3 == 5) {
                this.l.setSelection(0);
            } else if (i3 != 6) {
                if (i3 == 8) {
                    if (i4 == 0) {
                        ny7 ny7Var = this.t;
                        if (ny7Var != null && ny7Var.c() != null) {
                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - ri.s(this.c.getPageContext().getPageActivity()));
                            } else {
                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                            }
                        } else {
                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                        }
                    } else if (ListUtils.isEmpty(mt7Var.R())) {
                        this.l.setSelection(i4 > 0 ? i4 + ((this.l.getData() == null && mt7Var.F() == null) ? 0 : (this.l.getData().size() - mt7Var.F().size()) + this.l.getHeaderViewsCount()) : 0);
                    } else {
                        this.l.setSelection(mt7Var.F().size() + this.l.getHeaderViewsCount());
                    }
                    this.K.f();
                    this.K.C(this.c.getString(R.string.obfuscated_res_0x7f0f0ddb));
                    this.K.x();
                }
            } else if (i5 == 1 && (e3 = jx7.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                this.l.onRestoreInstanceState(e3);
            } else {
                this.l.setSelection(0);
            }
        } else if (i5 == 1 && (e2 = jx7.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
            this.l.post(new j0(this, e2, F, mt7Var));
        }
        if (this.f1 == j2 && N1()) {
            j0();
        }
        if (this.l1) {
            H2();
            this.l1 = false;
            if (i5 == 0) {
                k3(true);
            }
        }
        if (mt7Var.d == 1 || mt7Var.e == 1) {
            if (this.r1 == null) {
                this.r1 = new PbTopTipView(this.c.getContext());
            }
            if (mt7Var.e == 1 && "game_guide".equals(this.c.V5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0ded));
                this.r1.l(this.d, this.Q0);
            } else if (mt7Var.d == 1 && "game_news".equals(this.c.V5())) {
                this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0dec));
                this.r1.l(this.d, this.Q0);
            }
        }
        this.l.removeFooterView(this.K1.a());
        if (!ListUtils.isEmpty(mt7Var.I()) && mt7Var.y().b() == 0) {
            this.l.removeFooterView(this.a1);
            this.K1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
            this.l.addFooterView(this.K1.a());
            this.K1.f(mt7Var);
        }
        J2(mt7Var);
        if (mt7Var.g0() && this.c.K().H2() && this.c.R5() != null) {
            this.c.R5().d();
        }
        if (mt7Var.g() != 3) {
            D1(mt7Var);
        }
        this.x0.setText(TbSingleton.getInstance().getAdVertiComment(mt7Var.n0(), mt7Var.o0(), e1()));
        if (this.p != null && (mt7Var2 = this.N0) != null && mt7Var2.l() != null) {
            this.p.m(this.N0.l().getImage_url());
            this.p.n(this.N0.l().getName());
            PbFragment pbFragment3 = this.c;
            if (pbFragment3 != null && pbFragment3.K() != null) {
                this.p.o(this.c.K().b);
            }
        }
        if (this.r != null) {
            mt7 mt7Var3 = this.N0;
            if (mt7Var3 != null && mt7Var3.l() != null && (pbFragment = this.c) != null && pbFragment.K() != null) {
                this.r.q(this.c.K().b);
            }
            mt7 mt7Var4 = this.N0;
            if (mt7Var4 == null || mt7Var4.O() == null || ListUtils.isEmpty(this.N0.O().getThreadRecommendInfoDataList())) {
                return;
            }
            this.r.p(this.N0.O().getThreadRecommendInfoDataList().get(0));
        }
    }

    public final int V0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null && pbInterviewStatusView.getVisibility() == 0 && z2) {
                return 0 + ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
            }
            return 0;
        }
        return invokeZ.intValue;
    }

    public /* synthetic */ void V1() {
        this.l.post(new Runnable() { // from class: com.baidu.tieba.sv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ux7.this.X1();
                }
            }
        });
    }

    public void V2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new o(this));
            this.m0.setId(R.id.obfuscated_res_0x7f0917bd);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.w(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new p(this));
            q1();
            this.c.O5().i(new q(this));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void V3(mt7 mt7Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{mt7Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || mt7Var == null || mt7Var.O() == null) {
            return;
        }
        if (this.c.u0()) {
            if (mt7Var.h() != null) {
                this.i0 = mt7Var.h().c();
                this.j0 = mt7Var.h().d();
            }
            if (this.i0 == null && this.c.K() != null && this.c.K().r1() != null) {
                this.i0 = this.c.K().r1();
            }
        }
        PostData I0 = I0(mt7Var, z2);
        t3(I0, mt7Var);
        this.w.H(8);
        if (mt7Var.u0()) {
            this.n1 = true;
            this.h.B(true);
            this.h.a.hideBottomLine();
            if (this.t == null) {
                this.t = new ny7(this.c);
            }
            this.t.v(mt7Var, I0, this.l, this.w, this.U0, this.h, this.i0, this.F1);
            this.t.s(this.Z1);
            T2();
        } else {
            this.n1 = false;
            this.h.B(false);
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.p(this.l);
            }
        }
        if (this.c.P5() != null) {
            this.c.P5().w(this.n1);
        }
        if (I0 == null) {
            return;
        }
        this.O0 = I0;
        this.w.H(0);
        SparseArray<Object> u2 = this.w.u();
        u2.put(R.id.obfuscated_res_0x7f091fea, I0);
        u2.put(R.id.obfuscated_res_0x7f092003, Boolean.FALSE);
        this.x.e(mt7Var, this.l);
        this.z.e(mt7Var, this.H1, new f0(this));
        this.v.i(mt7Var);
        this.u.h(mt7Var, this.M0);
        this.u.g(mt7Var);
        this.w.I(this.Q0, this.N0, I0, this.Z1);
        if (this.Z0 != null) {
            if (mt7Var.i0()) {
                this.Z0.getView().setVisibility(8);
            } else {
                this.Z0.getView().setVisibility(0);
                zt7 zt7Var = new zt7(zt7.i);
                if (mt7Var.O() != null) {
                    mt7Var.O().getReply_num();
                }
                zt7Var.c = mt7Var.g;
                mt7Var.c();
                zt7Var.d = this.c.o6();
                zt7Var.g = mt7Var.f;
                zt7Var.h = mt7Var.O().isQuestionThread();
                this.Z0.h(zt7Var);
            }
        }
        h4(mt7Var);
        sg.a().post(new h0(this));
        this.y.e(this.l);
        if (I0.Q) {
            this.y.f(I0.K());
            this.y.b(this.l, this.l.getHeaderViewsCount() <= 1 ? 0 : 1);
        }
        cw7 cw7Var = this.E;
        if (cw7Var != null && cw7Var.z() != null) {
            this.E.z().F(I0.Q);
        }
        cw7 cw7Var2 = this.E;
        if (cw7Var2 != null) {
            cw7Var2.s0(I0.Q);
        }
        this.L1.setVisibility(I0.Q ? 0 : 8);
    }

    public View W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.M : (View) invokeV.objValue;
    }

    public /* synthetic */ void W1() {
        if (this.c.Q6()) {
            return;
        }
        this.l.post(new Runnable() { // from class: com.baidu.tieba.uv7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ux7.this.Y1();
                }
            }
        });
    }

    public void W2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, str) == null) || (pbListView = this.K) == null) {
            return;
        }
        pbListView.C(str);
    }

    public void W3(yr4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048667, this, cVar, z2) == null) {
            fs4 fs4Var = this.e0;
            if (fs4Var != null) {
                fs4Var.dismiss();
                this.e0 = null;
            }
            hs4 hs4Var = new hs4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            mt7 mt7Var = this.N0;
            if (mt7Var != null && mt7Var.O() != null && !this.N0.O().isBjh()) {
                arrayList.add(new ds4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1091), hs4Var));
            }
            if (!z2) {
                arrayList.add(new ds4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1092), hs4Var));
            }
            hs4Var.j(arrayList);
            hs4Var.n(new d0(this, cVar));
            fs4 fs4Var2 = new fs4(this.c.getPageContext(), hs4Var);
            this.e0 = fs4Var2;
            fs4Var2.k();
        }
    }

    public PbListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.K : (PbListView) invokeV.objValue;
    }

    public /* synthetic */ void X1() {
        sw7 sw7Var = this.p;
        if (sw7Var != null) {
            sw7Var.p();
        }
    }

    public void X2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, str) == null) || this.K == null) {
            return;
        }
        int i3 = 0;
        w0 w0Var = this.d1;
        if (w0Var != null && (pbReplyTitleViewHolder = w0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
            i3 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
        }
        this.K.F(str, i3);
    }

    public void X3(yr4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            fs4 fs4Var = this.d0;
            if (fs4Var != null) {
                fs4Var.dismiss();
                this.d0 = null;
            }
            hs4 hs4Var = new hs4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new ds4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f044e), hs4Var));
            }
            if (z3) {
                arrayList.add(new ds4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ffa), hs4Var));
            } else if (!z2) {
                arrayList.add(new ds4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a94), hs4Var));
            } else {
                arrayList.add(new ds4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0fd5), hs4Var));
            }
            hs4Var.j(arrayList);
            hs4Var.n(new c0(this, cVar));
            fs4 fs4Var2 = new fs4(this.c.getPageContext(), hs4Var);
            this.e0 = fs4Var2;
            fs4Var2.k();
        }
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public /* synthetic */ void Y1() {
        qx7 qx7Var = this.r;
        if (qx7Var != null) {
            qx7Var.r();
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048674, this) == null) {
            this.M1.setFallingFeedbackListener(new FallingView.l() { // from class: com.baidu.tieba.tv7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pb.view.FallingView.l
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ux7.this.Z1();
                    }
                }
            });
        }
    }

    public void Y3(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, onItemClickListener) == null) {
            as4 as4Var = this.f0;
            if (as4Var != null) {
                as4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList<js4> arrayList = new ArrayList<>();
            arrayList.add(new js4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0271), "", this.N0.L() == 1, Integer.toString(1)));
            arrayList.add(new js4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b43), "", this.N0.L() == 2, Integer.toString(5)));
            arrayList.add(new js4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b40), "", this.N0.L() == 3, Integer.toString(6)));
            arrayList.add(new js4(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b5e), "", this.N0.L() == 4, Integer.toString(7)));
            as4 as4Var2 = new as4(this.c.getPageContext());
            as4Var2.l(R.string.obfuscated_res_0x7f0f0de9);
            this.f0 = as4Var2;
            as4Var2.k(arrayList, onItemClickListener);
            as4Var2.c();
            this.f0.n();
        }
    }

    public View Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.W0 : (View) invokeV.objValue;
    }

    public /* synthetic */ void Z1() {
        String e1;
        PbFragment pbFragment = this.c;
        if (pbFragment != null && pbFragment.K() != null && this.c.K().A2()) {
            e1 = this.c.getString(R.string.obfuscated_res_0x7f0f0df0);
        } else {
            e1 = e1();
        }
        if (!StringUtils.isNull(e1) && this.N0 != null) {
            e1 = TbSingleton.getInstance().getAdVertiComment(this.N0.n0(), this.N0.o0(), e1);
        }
        PbFragment pbFragment2 = this.c;
        if (pbFragment2 != null && pbFragment2.O5() != null) {
            this.c.O5().m0(e1);
        }
        TextView textView = this.x0;
        if (textView != null) {
            textView.setText(e1);
        }
        J3(false);
        d4();
    }

    public void Z2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, h3Var) == null) {
            this.X1 = h3Var;
        }
    }

    public void Z3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || !TbadkCoreApplication.isLogin() || this.N0 == null || !this.o1 || this.n1 || this.h0 || (postData = this.O0) == null || postData.s() == null || this.O0.s().getIsLike() || this.O0.s().hadConcerned() || this.k1 != null) {
            return;
        }
        this.k1 = new mx7(this.c);
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.m : (NoNetworkView) invokeV.objValue;
    }

    public final boolean a0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048681, this, absListView, i3)) == null) {
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

    public PbFakeFloorModel a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.i1 : (PbFakeFloorModel) invokeV.objValue;
    }

    public final void a2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (imageView = this.w0) == null) {
            return;
        }
        imageView.setImageResource(R.drawable.obfuscated_res_0x7f08099d);
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048684, this, z2) == null) {
            this.n0 = z2;
        }
    }

    public final void a4(wr4 wr4Var, int i3) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048685, this, wr4Var, i3) == null) || (pbFragment = this.c) == null || wr4Var == null) {
            return;
        }
        if (this.B1 == null && this.u != null) {
            this.B1 = new gl5(pbFragment.getPageContext(), this.u.c());
        }
        AntiData v5 = this.c.v5();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (v5 != null && v5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = v5.getDelThreadInfoList();
            for (int i4 = 0; i4 < delThreadInfoList.size(); i4++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i4).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i4).text_id, delThreadInfoList.get(i4).text_info);
                }
            }
        }
        eq4 eq4Var = new eq4();
        eq4Var.j(sparseArray);
        this.B1.y(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3), this.c.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.B1.x(eq4Var);
        this.B1.A((i3 == 1 || i3 == 2) ? "4" : "3");
        this.B1.z(new y(this, wr4Var));
    }

    public void b0() {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (e28Var = this.F0) == null) {
            return;
        }
        e28Var.m(false);
    }

    public ow7 b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.j1 : (ow7) invokeV.objValue;
    }

    public final void b2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048688, this) == null) || (pbFragment = this.c) == null || pbFragment.K() == null || this.c.K().G == null || this.c.K().G.O() == null || !this.c.K().G.O().isQuestionThread()) {
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

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) {
            this.E.j0(z2);
        }
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048690, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public boolean c0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048691, this, z2)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools == null || !editorTools.u()) {
                return false;
            }
            this.m0.q();
            return true;
        }
        return invokeZ.booleanValue;
    }

    public ny7 c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.t : (ny7) invokeV.objValue;
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048693, this) == null) {
            J2(this.N0);
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z2) == null) {
            this.G1 = z2;
        }
    }

    public void c4() {
        cw7 cw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048695, this) == null) || (cw7Var = this.E) == null) {
            return;
        }
        cw7Var.B0();
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView == null || TextUtils.isEmpty(pbListView.h())) {
                return false;
            }
            return this.K.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec));
        }
        return invokeV.booleanValue;
    }

    public final PostData d1(mt7 mt7Var) {
        InterceptResult invokeL;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048697, this, mt7Var)) == null) {
            if (mt7Var == null || mt7Var.O() == null || mt7Var.O().getAuthor() == null) {
                return null;
            }
            PostData postData = new PostData();
            MetaData author = mt7Var.O().getAuthor();
            String userId = author.getUserId();
            HashMap<String, MetaData> userMap = mt7Var.O().getUserMap();
            if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                author = metaData;
            }
            postData.C0(1);
            postData.I0(mt7Var.O().getFirstPostId());
            postData.Z0(mt7Var.O().getTitle());
            postData.Y0(mt7Var.O().getCreateTime());
            postData.A0(author);
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && UbsABTestHelper.isShareTopRight()) {
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

    public void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public final void d4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048700, this) == null) {
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

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048701, this) == null) || this.N0 == null || !UbsABTestHelper.isResizeInduceSharingABTest() || oz7.k(this.N0.Q())) {
            return;
        }
        this.F0.f();
        oz7.b(this.N0.Q());
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            if (!qi.isEmpty(this.D1)) {
                return this.D1;
            }
            if (this.c != null) {
                this.D1 = TbadkCoreApplication.getInst().getResources().getString(sx7.b());
            }
            return this.D1;
        }
        return (String) invokeV.objValue;
    }

    public void e2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048703, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            rw7 rw7Var = this.q;
            if (rw7Var != null) {
                rw7Var.b();
            }
            px7 px7Var = this.s;
            if (px7Var != null) {
                px7Var.b(z2, i3);
            }
        }
    }

    public void e3(boolean z2) {
        ny7 ny7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048704, this, z2) == null) || (ny7Var = this.t) == null) {
            return;
        }
        ny7Var.r(z2);
    }

    public void e4() {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048705, this) == null) || (e28Var = this.F0) == null) {
            return;
        }
        e28Var.o(2);
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048706, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                TiebaStatic.log(new StatisticItem("c10517").param("obj_locate", 2).param("fid", this.j0));
            } else if (!this.c.f5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                q45 O5 = this.c.O5();
                if (O5 != null && (O5.B() || O5.D())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.O5().z(false, null);
                    return;
                }
                if (this.m0 != null) {
                    B1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.n(2) != null) {
                        uk8.c(this.c.getPageContext(), (View) this.m0.n(2).m, false, r2);
                    }
                }
                o1();
            }
        }
    }

    public final int f1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, pbReplyTitleViewHolder)) == null) {
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

    public void f2(zk8 zk8Var) {
        mt7 mt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048708, this, zk8Var) == null) || zk8Var == null || zk8Var.a == null || zk8Var.b == null || (mt7Var = this.N0) == null || mt7Var.O() == null || this.N0.O().getAgreeData() == null) {
            return;
        }
        AgreeData agreeData = this.N0.O().getAgreeData();
        String str = zk8Var.b.nid;
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
            if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                return;
            }
        } else {
            String str2 = zk8Var.b.threadId;
            String str3 = agreeData.threadId;
            if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                return;
            }
        }
        AgreeData agreeData2 = zk8Var.b;
        I2(agreeData2, agreeData2.agreeNum);
    }

    public void f3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z2) == null) {
            this.E.l0(z2);
        }
    }

    public void f4(iq4 iq4Var, wr4.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048710, this, iq4Var, eVar) == null) || iq4Var == null) {
            return;
        }
        int a2 = iq4Var.a();
        int h2 = iq4Var.h();
        wr4 wr4Var = this.F;
        if (wr4Var != null) {
            wr4Var.show();
        } else {
            this.F = new wr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0227, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f04ef, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, new l0(this));
            this.F.setOnCalcelListener(new m0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090f15);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f09072f);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047d), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public void g0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z2) == null) {
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
                pbListView.K(z2 ? 8 : 0);
            }
            View view3 = this.M;
            if (view3 != null) {
                view3.setVisibility(z2 ? 8 : 0);
            }
        }
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? R.id.obfuscated_res_0x7f091bd4 : invokeV.intValue;
    }

    public void g2(int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048713, this, i3) == null) || this.Q0 == i3) {
            return;
        }
        this.Q0 = i3;
        i4(this.N0, this.M0);
        L2(this.N0, this.M0, this.P0, i3);
        this.c.getBaseFragmentActivity().getLayoutMode().l(i3 == 1);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        ny7 ny7Var = this.t;
        if (ny7Var != null) {
            ny7Var.h(i3);
        }
        jy7 jy7Var = this.x;
        if (jy7Var != null) {
            jy7Var.c(i3);
        }
        iy7 iy7Var = this.u;
        if (iy7Var != null) {
            iy7Var.e(i3);
        }
        ky7 ky7Var = this.v;
        if (ky7Var != null) {
            ky7Var.f(i3);
        }
        my7 my7Var = this.w;
        if (my7Var != null) {
            my7Var.y(i3);
        }
        ly7 ly7Var = this.y;
        if (ly7Var != null) {
            ly7Var.d();
        }
        hy7 hy7Var = this.z;
        if (hy7Var != null) {
            hy7Var.c();
        }
        MaskView maskView = this.L1;
        if (maskView != null) {
            maskView.f();
        }
        qx7 qx7Var = this.r;
        if (qx7Var != null) {
            qx7Var.n();
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
        wr4 wr4Var = this.F;
        if (wr4Var != null) {
            wr4Var.autoChangeSkinType(this.c.getPageContext());
        }
        n4(this.g0);
        this.E.a0();
        f28 f28Var = this.J;
        if (f28Var != null) {
            f28Var.H(i3);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.w(i3);
        }
        b28 b28Var = this.L;
        if (b28Var != null) {
            b28Var.f(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        t4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.Y0, i3);
        if (this.A != null) {
            mb5.a(this.c.getPageContext(), this.A);
        }
        ow7 ow7Var = this.j1;
        if (ow7Var != null) {
            ow7Var.h(i3);
        }
        uz7 uz7Var = this.h;
        if (uz7Var != null) {
            ny7 ny7Var2 = this.t;
            if (ny7Var2 != null) {
                ny7Var2.i(i3);
            } else {
                uz7Var.v(i3);
            }
        }
        HeadImageView headImageView = this.v0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ri.f(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        mt7 mt7Var = this.N0;
        if (mt7Var != null && mt7Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f080960, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08095f, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f080962, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f08099d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        r4(this.N0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.t1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, ri.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.s();
            this.A0.L(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                I2(data, data.agreeNum);
            }
        }
        mv7 mv7Var = this.w1;
        if (mv7Var != null) {
            mv7Var.m(i3);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        e28 e28Var = this.F0;
        if (e28Var != null) {
            e28Var.j();
        }
        d28 d28Var = this.K1;
        if (d28Var != null) {
            d28Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.N1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.obfuscated_res_0x7f0923bd), (int) R.color.CAM_X0105);
    }

    public void g3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048714, this, z2) == null) {
            this.E.q0(z2);
        }
    }

    public void g4(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048715, this, z2) == null) || this.l == null || (textView = this.V0) == null || this.e == null) {
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
            T2();
            return;
        }
        if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
            AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.V0.getLayoutParams();
            layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + V0(true);
            this.V0.setLayoutParams(layoutParams2);
        }
        T2();
        M2();
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            mv7 mv7Var = new mv7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091537));
            this.w1 = mv7Var;
            mv7Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
        }
    }

    public final int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            View childAt = this.l.getChildAt(0);
            if (childAt == null) {
                return 0;
            }
            return (-childAt.getTop()) + (this.l.getFirstVisiblePosition() * childAt.getHeight());
        }
        return invokeV.intValue;
    }

    public void h2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048718, this, configuration) == null) || configuration == null) {
            return;
        }
        m0();
        if (configuration.orientation == 2) {
            o1();
            q1();
        } else {
            S2();
        }
        ow7 ow7Var = this.j1;
        if (ow7Var != null) {
            ow7Var.c();
        }
        this.c.e6();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.g7(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                l1().setVisibility(0);
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

    public void h3(dv4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, gVar) == null) {
            this.c2 = gVar;
            f28 f28Var = this.J;
            if (f28Var != null) {
                f28Var.f(gVar);
            }
        }
    }

    public final void h4(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048720, this, mt7Var) == null) || mt7Var == null || mt7Var.O() == null || mt7Var.O().isVideoThreadType()) {
            return;
        }
        boolean z2 = mt7Var.O().getIs_good() == 1;
        boolean z3 = mt7Var.O().getIs_top() == 1;
        my7 my7Var = this.w;
        if (my7Var != null) {
            my7Var.o(mt7Var, z2, z3);
        }
        ky7 ky7Var = this.v;
        if (ky7Var != null) {
            ky7Var.b(mt7Var, z2, z3);
        }
    }

    public final CustomBlueCheckRadioButton i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048721, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ri.f(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.Z);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.Q0 : invokeV.intValue;
    }

    public void i2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            sw7 sw7Var = this.p;
            if (sw7Var != null) {
                sw7Var.l();
            }
            qx7 qx7Var = this.r;
            if (qx7Var != null) {
                qx7Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            e28 e28Var = this.F0;
            if (e28Var != null) {
                e28Var.k();
            }
            mx7 mx7Var = this.k1;
            if (mx7Var != null) {
                mx7Var.a();
            }
            ex7 ex7Var = this.z1;
            if (ex7Var != null) {
                ex7Var.c();
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
            uk8.d();
            m0();
            u0();
            if (this.h1 != null) {
                sg.a().removeCallbacks(this.h1);
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
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.a();
            }
            cw7 cw7Var = this.E;
            if (cw7Var != null) {
                cw7Var.d0();
            }
            this.l.setOnLayoutListener(null);
            sy7 sy7Var = this.v1;
            if (sy7Var != null) {
                sy7Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            my7 my7Var = this.w;
            if (my7Var != null) {
                my7Var.z();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void i3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onClickListener) == null) {
            this.d2 = onClickListener;
            cw7 cw7Var = this.E;
            if (cw7Var != null) {
                cw7Var.r0(onClickListener);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void i4(mt7 mt7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048725, this, mt7Var, z2) == null) || mt7Var == null) {
            return;
        }
        s4(mt7Var, z2);
        p0();
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048726, this) == null) || this.g2) {
            return;
        }
        TiebaStatic.log("c10490");
        this.g2 = true;
        wr4 wr4Var = new wr4(this.c.getPageContext().getPageActivity());
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(k2, Integer.valueOf(m2));
        wr4Var.setTitle(R.string.obfuscated_res_0x7f0f07f5);
        View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0898, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c3b)).setText(R.string.obfuscated_res_0x7f0f0792);
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921f5)).setText(R.string.obfuscated_res_0x7f0f07f5);
        wr4Var.setContentView(inflate);
        wr4Var.setYesButtonTag(sparseArray);
        wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07f4, this.c);
        wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0a6f, new n0(this));
        wr4Var.create(this.c.getPageContext()).show();
    }

    public View j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void j2(TbRichText tbRichText) {
        mt7 mt7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048728, this, tbRichText) == null) || (mt7Var = this.N0) == null || mt7Var.F() == null || this.N0.F().isEmpty() || tbRichText == null || StringUtils.isNull(tbRichText.getAuthorId())) {
            return;
        }
        for (int i3 = 0; i3 < this.N0.F().size() && (postData = this.N0.F().get(i3)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i3++) {
            if (this.N0.F().get(i3).s().getUserId().equals(tbRichText.getAuthorId())) {
                mv7 mv7Var = this.w1;
                if (mv7Var != null && mv7Var.l()) {
                    J3(false);
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

    public void j3(String str) {
        tz7 tz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048729, this, str) == null) || (tz7Var = this.i) == null) {
            return;
        }
        tz7Var.b(str);
    }

    public void j4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            wr4 wr4Var = new wr4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0898, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0921f5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c3b)).setVisibility(8);
            wr4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(k2, Integer.valueOf(n2));
            wr4Var.setYesButtonTag(sparseArray);
            wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1543, this.c);
            wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new o0(this));
            wr4Var.create(this.c.getPageContext()).show();
        }
    }

    public PbThreadPostView k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.o : (PbThreadPostView) invokeV.objValue;
    }

    public boolean k2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048733, this, i3)) == null) {
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                return ny7Var.k(i3);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void k3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z2) == null) {
            this.l1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.m1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void k4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.c.showProgressBar();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r5.I1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l0() {
        d28 d28Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048736, this) == null) || (d28Var = this.K1) == null) {
            return;
        }
        if (((d28Var.a() == null || this.K1.a().getParent() == null) ? -1 : this.l.getPositionForView(this.K1.a())) != -1) {
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

    public RelativeLayout l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.D : (RelativeLayout) invokeV.objValue;
    }

    public void l2() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048738, this) == null) || this.c == null) {
            return;
        }
        if ((this.G1 || this.H1 == 17) && UbsABTestHelper.leftSlideToFrs()) {
            mt7 mt7Var = this.N0;
            if (mt7Var == null || mt7Var.l() == null || qi.isEmpty(this.N0.l().getName())) {
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

    public void l3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, i3Var) == null) {
        }
    }

    public void l4() {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048740, this) == null) || (fallingView = this.M1) == null) {
            return;
        }
        fallingView.F();
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048741, this) == null) {
            this.h.k();
            my7 my7Var = this.w;
            if (my7Var != null) {
                my7Var.p();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ri.x(pbFragment.getContext(), this.I);
            }
            q1();
            fs4 fs4Var = this.d0;
            if (fs4Var != null) {
                fs4Var.dismiss();
            }
            q0();
            wr4 wr4Var = this.F;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            yr4 yr4Var = this.G;
            if (yr4Var != null) {
                yr4Var.e();
            }
        }
    }

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public void m2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z2) == null) {
            if (z2) {
                P3();
            } else {
                r1();
            }
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            F2(this.d1.c, false);
        }
    }

    public void m3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, yVar) == null) {
            this.Q = yVar;
            this.E.v0(yVar);
            this.w1.q(this.Q);
        }
    }

    public void m4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048745, this) == null) || this.e2 == null) {
            return;
        }
        while (this.e2.size() > 0) {
            TbImageView remove = this.e2.remove(0);
            if (remove != null) {
                remove.O();
            }
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            this.h.k();
            my7 my7Var = this.w;
            if (my7Var != null) {
                my7Var.p();
            }
            fs4 fs4Var = this.d0;
            if (fs4Var != null) {
                fs4Var.dismiss();
            }
            q0();
            wr4 wr4Var = this.F;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            yr4 yr4Var = this.G;
            if (yr4Var != null) {
                yr4Var.e();
            }
        }
    }

    public void n1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            if (this.l != null) {
                this.U0.setVisibility(8);
            }
            uz7 uz7Var = this.h;
            if (uz7Var == null || (view2 = uz7Var.d) == null) {
                return;
            }
            view2.setVisibility(8);
        }
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            m4();
            this.E.b0(1);
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.l();
            }
            sw7 sw7Var = this.p;
            if (sw7Var != null) {
                sw7Var.k();
            }
            qx7 qx7Var = this.r;
            if (qx7Var != null) {
                qx7Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.N1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void n3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, bVar) == null) {
            this.R = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public void n4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void o0() {
        e28 e28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048751, this) == null) || (e28Var = this.F0) == null) {
            return;
        }
        e28Var.l(false);
    }

    public void o1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048752, this) == null) || this.t0 == null) {
            return;
        }
        this.s0.setVisibility(8);
        this.t0.setVisibility(8);
        this.J0 = false;
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.setVisibility(8);
            R2(false);
        }
    }

    public void o2(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, snVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.b0 = snVar;
            pbLandscapeListView.W = true;
        }
    }

    public void o3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void o4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z2) == null) {
            this.h.J(z2);
            if (z2 && this.R0) {
                this.K.C(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03eb));
                this.l.setNextPage(this.K);
                this.f = 2;
            }
            a2();
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048756, this)) == null) ? this.u.b(this.M0) : invokeV.booleanValue;
    }

    public void p1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048757, this, z2) == null) || this.t0 == null || this.x0 == null) {
            return;
        }
        TbSingleton tbSingleton = TbSingleton.getInstance();
        mt7 mt7Var = this.N0;
        boolean z3 = mt7Var != null && mt7Var.n0();
        mt7 mt7Var2 = this.N0;
        this.x0.setText(tbSingleton.getAdVertiComment(z3, mt7Var2 != null && mt7Var2.o0(), e1()));
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
        R2(true);
    }

    public void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            q4();
            this.c.O6();
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.K() == null || this.c.K().S1() == null || this.c.K().S1().O() == null || this.c.K().S1().O().getAuthor() == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.K().n2()).param("fid", this.c.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.K().b).param("fid", this.c.K().S1().m()).param("obj_locate", 1).param("uid", this.c.K().S1().O().getAuthor().getUserId()));
        }
    }

    public void p3(AbsListView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, onScrollListener) == null) {
            this.l.setOnScrollListener(onScrollListener);
        }
    }

    public void p4(kt7 kt7Var) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048760, this, kt7Var) == null) || kt7Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(kt7Var.b)) {
            this.h.G(kt7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13c8);
        int e2 = pg.e(kt7Var.a, 0);
        if (e2 == 100) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1102);
        } else if (e2 != 300) {
            string = e2 != 400 ? "" : TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1341);
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02f6);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02a0), true, new i0(this, kt7Var.c));
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048761, this) == null) {
            wr4 wr4Var = this.U;
            if (wr4Var != null) {
                wr4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                ug.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                ug.b(dialog2, this.c.getPageContext());
            }
            fs4 fs4Var = this.S;
            if (fs4Var != null) {
                fs4Var.dismiss();
            }
        }
    }

    public void q1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048762, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.o();
        sy7 sy7Var = this.v1;
        if (sy7Var != null) {
            sy7Var.m();
        }
    }

    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048763, this) == null) {
            this.E.b0(2);
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    m1().setSystemUiVisibility(4);
                }
            }
            r2();
            b2();
        }
    }

    public void q3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, onClickListener) == null) {
            this.E.z0(onClickListener);
        }
    }

    public final void q4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048765, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.O5().C())));
    }

    public void r0() {
        ny7 ny7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048766, this) == null) || (ny7Var = this.t) == null) {
            return;
        }
        ny7Var.b();
    }

    public void r1() {
        uz7 uz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048767, this) == null) || (uz7Var = this.h) == null) {
            return;
        }
        uz7Var.q();
    }

    public final void r2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048768, this) == null) || (pbFragment = this.c) == null || pbFragment.O5() == null) {
            return;
        }
        this.c.O5().K();
    }

    public void r3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048769, this, i3) == null) {
            this.H1 = i3;
        }
    }

    public void r4(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, mt7Var) == null) {
            if (mt7Var != null && AntiHelper.o(mt7Var.O())) {
                e28 e28Var = this.F0;
                if (e28Var != null) {
                    e28Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f080964, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            e28 e28Var2 = this.F0;
            if (e28Var2 == null || !e28Var2.h()) {
                ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                this.C0.setLayoutParams(layoutParams2);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f080964, UbsABTestHelper.isShareTopRight() ? R.color.CAM_X0105 : R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048771, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void s1() {
        xu4 xu4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048772, this) == null) || (xu4Var = this.L0) == null) {
            return;
        }
        xu4Var.h(false);
    }

    public void s2(AbsListView absListView, int i3, int i4, int i5) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        my7 my7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048773, this, absListView, i3, i4, i5) == null) {
            rw7 rw7Var = this.q;
            if (rw7Var != null) {
                rw7Var.c(i3, i4);
            }
            px7 px7Var = this.s;
            if (px7Var != null) {
                px7Var.c(i3, i4);
            }
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.n(absListView, i3, i4, i5);
            }
            uz7 uz7Var = this.h;
            if (uz7Var != null && (my7Var = this.w) != null) {
                uz7Var.x(my7Var.s());
            }
            E2();
            w0 w0Var = this.d1;
            w0Var.a = i3;
            w0Var.b = this.l.getHeaderViewsCount();
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            I3(a0(absListView, i3));
            int i6 = 0;
            F2(this.d1.c, false);
            l0();
            if (!this.K.n() || this.K.C) {
                return;
            }
            w0 w0Var2 = this.d1;
            if (w0Var2 != null && (pbReplyTitleViewHolder = w0Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i6 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.e(i6);
            this.K.C = true;
        }
    }

    public void s3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, onLongClickListener) == null) {
            this.w.D(onLongClickListener);
            this.E.w0(onLongClickListener);
            mv7 mv7Var = this.w1;
            if (mv7Var != null) {
                mv7Var.r(onLongClickListener);
            }
        }
    }

    public boolean s4(mt7 mt7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048775, this, mt7Var, z2)) == null) {
            if (mt7Var == null) {
                return false;
            }
            if (this.v != null) {
                if (mt7Var.O() != null && mt7Var.O().getIsNoTitle() == 0 && !mt7Var.O().isVideoThreadType() && !this.P1) {
                    if (mt7Var.O() != null) {
                        ThreadData O = mt7Var.O();
                        O.parserSpecTitleForFrsAndPb(true, M3(mt7Var));
                        O.setResource(3);
                        O.setPbTitle("2");
                    }
                    if (mt7Var.O().isBJHArticleThreadType()) {
                        this.w.B(this.l);
                        this.v.g(this.l);
                        this.v.a(this.l);
                        this.w.m(this.l);
                        this.w.G(this.N0);
                        if (I1(mt7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.h(mt7Var);
                        }
                    } else {
                        this.w.G(this.N0);
                        if (I1(mt7Var)) {
                            this.v.g(this.l);
                        } else {
                            this.v.j(mt7Var);
                        }
                    }
                } else if (mt7Var.O().getIsNoTitle() == 1) {
                    if (mt7Var.O() != null) {
                        this.v.g(this.l);
                        this.w.G(this.N0);
                    }
                } else {
                    this.v.g(this.l);
                    this.w.G(this.N0);
                }
            }
            h4(mt7Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", q2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void t1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048777, this) == null) {
            if (this.A == null) {
                A1();
            }
            this.k.setVisibility(8);
            Handler handler = this.U1;
            if (handler == null || (runnable = this.V1) == null) {
                return;
            }
            handler.removeCallbacks(runnable);
        }
    }

    public void t2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048778, this, absListView, i3) == null) {
            ny7 ny7Var = this.t;
            if (ny7Var != null) {
                ny7Var.o(absListView, i3);
            }
            if (!this.h2 && i3 == 0) {
                this.f2 = h1();
                this.d1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
                F2(this.d1.c, true);
                l0();
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

    public final void t3(PostData postData, mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048779, this, postData, mt7Var) == null) {
            this.w.E(postData, mt7Var);
        }
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048780, this) == null) && this.c.F5()) {
            if (this.c.L5() == -1) {
                SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
            }
            if (this.c.K5() == -1) {
                SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048781, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.x();
                this.K.f();
            }
            s1();
        }
    }

    public void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void u2(ArrayList<up4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e3, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a7);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.obfuscated_res_0x7f090cc4);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new a0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.obfuscated_res_0x7f090cc3);
                TextView textView = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907a1);
                this.b0 = textView;
                textView.setOnClickListener(new b0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907a2);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton i02 = i0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f13cd));
            this.n.add(i02);
            i02.setChecked(true);
            this.Y.addView(i02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    up4 up4Var = arrayList.get(i3);
                    if (up4Var != null && !TextUtils.isEmpty(up4Var.b()) && up4Var.a() > 0) {
                        CustomBlueCheckRadioButton i03 = i0(String.valueOf(up4Var.a()), up4Var.b());
                        this.n.add(i03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Y.addView(view2);
                        this.Y.addView(i03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.l0.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 186.0f);
                }
                this.l0.setLayoutParams(layoutParams2);
                this.l0.removeAllViews();
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l0.addView(this.Y);
                }
            }
            ug.j(this.W, this.c.getPageContext());
        }
    }

    public void u3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048784, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                m0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                n0();
            } else {
                m0();
            }
        }
    }

    public void u4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048785, this, z2) == null) {
            cw7 cw7Var = this.E;
            if (cw7Var != null) {
                cw7Var.u0(z2);
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
                pbFragment.f7(z2);
            }
            if (z2) {
                nz7.d(this.c.getPageContext(), this.c.K(), this.c.S5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            mt7 mt7Var = this.N0;
            TiebaStatic.log(statisticItem.param("fid", mt7Var != null ? mt7Var.m() : "0").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            this.l.A(0L);
            p0();
        }
    }

    public void v1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048787, this) == null) || (rightFloatLayerView = this.N1) == null) {
            return;
        }
        rightFloatLayerView.c();
    }

    public void v2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048788, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            w2(i3, str, i4, z2, null);
        }
    }

    public void v3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048789, this) == null) {
            this.c.hideProgressBar();
            mt7 mt7Var = this.N0;
            if (mt7Var != null && this.K != null && mt7Var.y() != null && this.N0.y().b() == 0) {
                this.K.u(this.N0.t());
                if (this.N0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.N0.m());
                    statisticItem.param("fname", this.N0.n());
                    statisticItem.param("tid", this.N0.Q());
                    TiebaStatic.log(statisticItem);
                }
            }
            u0();
            this.l.A(0L);
            p0();
        }
    }

    public void v4(mt7 mt7Var) {
        iy7 iy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048790, this, mt7Var) == null) || (iy7Var = this.u) == null) {
            return;
        }
        iy7Var.h(mt7Var, this.M0);
    }

    public void w0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048791, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f121f));
            } else if (z3) {
                if (qi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c40);
                }
                this.c.showToast(str);
            }
        }
    }

    public void w1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048792, this) == null) || (editorTools = this.m0) == null) {
            return;
        }
        editorTools.q();
    }

    public void w2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048793, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            x2(i3, str, i4, z2, str2, false);
        }
    }

    public void w3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048794, this) == null) || (pbFragment = this.c) == null || pbFragment.getBaseFragmentActivity() == null) {
            return;
        }
        ri.x(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
    }

    public void x0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048795, this) == null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        pbLandscapeListView.setForbidDragListener(true);
    }

    public final void x1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048796, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new hy7(pbFragment.getContext());
        }
    }

    public void x2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048797, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            int i5 = (i4 != 1002 || z2) ? R.string.obfuscated_res_0x7f0f04a1 : R.string.obfuscated_res_0x7f0f0ff7;
            int i6 = R.string.obfuscated_res_0x7f0f043a;
            if (i3 == 0) {
                if (i4 != 1002 || z2) {
                    i6 = R.string.obfuscated_res_0x7f0f04a5;
                    i5 = R.string.obfuscated_res_0x7f0f04a6;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f0ffb;
                }
            }
            this.U = new wr4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i5);
            } else {
                this.U.setOnlyMessageShowCenter(false);
                this.U.setMessage(str2);
            }
            this.U.setYesButtonTag(sparseArray);
            this.U.setPositiveButton(R.string.obfuscated_res_0x7f0f04ef, this.c);
            this.U.setNegativeButton(R.string.obfuscated_res_0x7f0f04ea, new s(this));
            this.U.setCancelable(true);
            this.U.create(this.c.getPageContext());
            if (z3) {
                L3(sparseArray, i6, i5);
            } else if (z2) {
                L3(sparseArray, i6, i5);
            } else if (C3()) {
                il5 il5Var = new il5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
                il5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
                il5Var.h(this.c.K().S1().l().getImage_url());
                il5Var.j(this.c.K().S1().l().getUser_level());
                S3(sparseArray, i3, il5Var, this.c.K().S1().V(), false);
            } else {
                a4(this.U, i3);
            }
        }
    }

    public void x3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048798, this) == null) {
            this.K.z();
            this.K.Q();
        }
    }

    public final String y0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048799, this, j3)) == null) {
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

    public final void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048800, this) == null) && this.v == null) {
            this.v = new ky7(this.c, this.k0);
        }
    }

    public void y2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048801, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f091fec, str);
            sparseArray.put(R.id.obfuscated_res_0x7f091fee, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f09200a, Integer.valueOf(i4));
            sparseArray.put(R.id.obfuscated_res_0x7f091fed, Boolean.valueOf(z2));
            sparseArray.put(k2, Integer.valueOf(l2));
            if (z2) {
                G3(sparseArray);
            } else {
                H3(i3, sparseArray);
            }
        }
    }

    public void y3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z2) == null) {
            this.w.F(z2);
        }
    }

    public final String z0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048803, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0dc8);
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

    public final void z1(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048804, this, mt7Var) == null) && mt7Var != null && mt7Var.O() != null && mt7Var.O().isInterviewLive() && this.T0 == null) {
            PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
            this.T0 = pbInterviewStatusView;
            pbInterviewStatusView.setOnClickListener(this.P);
            this.T0.setCallback(this.c.D5());
            this.T0.setData(this.c, mt7Var);
        }
    }

    public void z2(SparseArray<Object> sparseArray, boolean z2) {
        ds4 ds4Var;
        ds4 ds4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048805, this, sparseArray, z2) == null) {
            hs4 hs4Var = new hs4(this.c.getContext());
            hs4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02e4));
            hs4Var.n(new r(this, z2));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091fe6) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fe6)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091fec)) && intValue != 2) {
                if ((sparseArray.get(R.id.obfuscated_res_0x7f091fee) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091fee)).intValue() : -1) == 0) {
                    ds4Var2 = new ds4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04b7), hs4Var);
                } else {
                    ds4Var2 = new ds4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04ac), hs4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray2.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray2.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                ds4Var2.d.setTag(sparseArray2);
                arrayList.add(ds4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f09200b) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f09200b)).booleanValue()) {
                ds4 ds4Var3 = new ds4(13, this.c.getString(R.string.obfuscated_res_0x7f0f0b27), hs4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f091fec, sparseArray.get(R.id.obfuscated_res_0x7f091fec));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fee, sparseArray.get(R.id.obfuscated_res_0x7f091fee));
                sparseArray3.put(R.id.obfuscated_res_0x7f091fed, sparseArray.get(R.id.obfuscated_res_0x7f091fed));
                sparseArray3.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                ds4Var3.d.setTag(sparseArray3);
                arrayList.add(ds4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff7)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f091ff8))) && !S1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff7, sparseArray.get(R.id.obfuscated_res_0x7f091ff7));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff8, sparseArray.get(R.id.obfuscated_res_0x7f091ff8));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ff9, sparseArray.get(R.id.obfuscated_res_0x7f091ff9));
                sparseArray4.put(R.id.obfuscated_res_0x7f09200a, sparseArray.get(R.id.obfuscated_res_0x7f09200a));
                sparseArray4.put(R.id.obfuscated_res_0x7f091ffa, sparseArray.get(R.id.obfuscated_res_0x7f091ffa));
                ds4 ds4Var4 = new ds4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0655), hs4Var);
                ds4Var4.d.setTag(sparseArray4);
                arrayList.add(ds4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f092046) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092046)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f092001, sparseArray.get(R.id.obfuscated_res_0x7f092001));
                sparseArray5.put(R.id.obfuscated_res_0x7f092042, sparseArray.get(R.id.obfuscated_res_0x7f092042));
                sparseArray5.put(R.id.obfuscated_res_0x7f092043, sparseArray.get(R.id.obfuscated_res_0x7f092043));
                sparseArray5.put(R.id.obfuscated_res_0x7f092041, sparseArray.get(R.id.obfuscated_res_0x7f092041));
                sparseArray5.put(R.id.obfuscated_res_0x7f092044, sparseArray.get(R.id.obfuscated_res_0x7f092044));
                sparseArray5.put(R.id.obfuscated_res_0x7f092045, sparseArray.get(R.id.obfuscated_res_0x7f092045));
                sparseArray5.put(R.id.obfuscated_res_0x7f092040, sparseArray.get(R.id.obfuscated_res_0x7f092040));
                if (z2) {
                    ds4Var = new ds4(12, this.c.getString(R.string.obfuscated_res_0x7f0f149c), hs4Var);
                } else {
                    ds4Var = new ds4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b33), hs4Var);
                }
                ds4Var.d.setTag(sparseArray5);
                arrayList.add(ds4Var);
            }
            mz7.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                hs4Var.k(arrayList, false);
            } else {
                hs4Var.k(arrayList, true);
            }
            fs4 fs4Var = new fs4(this.c.getPageContext(), hs4Var);
            this.S = fs4Var;
            fs4Var.k();
        }
    }

    public void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, str) == null) {
            this.x0.performClick();
            if (StringUtils.isNull(str) || this.c.O5() == null || this.c.O5().v() == null || this.c.O5().v().i() == null) {
                return;
            }
            EditText i3 = this.c.O5().v().i();
            i3.setText(str);
            i3.setSelection(str.length());
        }
    }
}
