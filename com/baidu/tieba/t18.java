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
import com.baidu.tieba.az4;
import com.baidu.tieba.h28;
import com.baidu.tieba.kv4;
import com.baidu.tieba.mv4;
import com.baidu.tieba.o18;
import com.baidu.tieba.p08;
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
import com.baidu.tieba.py7;
import com.baidu.tieba.rw7;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tp5;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.vv4;
import com.baidu.tieba.wp5;
import com.baidu.tieba.xo8;
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
import tbclient.ItemInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class t18 {
    public static /* synthetic */ Interceptable $ic;
    public static final int j2;
    public static int k2;
    public static int l2;
    public static int m2;
    public static int n2;
    public static int o2;
    public static int p2;
    public static final int q2;
    public static int r2;
    public static xo8.f s2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public c18 A1;
    public TextView B;
    public ImageView B0;
    public NavigationBarCoverTip B1;
    public TextView C;
    public ImageView C0;
    public tp5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public wp5 D1;
    public a08 E;
    public View E0;
    public String E1;
    public kv4 F;
    public z58 F0;
    public PermissionJudgePolicy F1;
    public mv4 G;
    public TextView G0;
    public long G1;
    public View H;
    public TextView H0;
    public boolean H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public a68 J;
    public boolean J0;
    public int J1;
    public PbListView K;
    public int K0;
    public boolean K1;
    public w58 L;
    public uy4 L0;
    public y58 L1;
    public View M;
    public boolean M0;
    public MaskView M1;
    public View N;
    public px7 N0;
    public final FallingView N1;
    public View O;
    public PostData O0;
    public RightFloatLayerView O1;
    public View.OnClickListener P;
    public int P0;
    public final FrameLayout P1;
    public TbRichTextView.y Q;
    public int Q0;
    public boolean Q1;
    public NoNetworkView.b R;
    public boolean R0;
    public String R1;
    public tv4 S;
    public ViewStub S0;
    public CustomMessageListener S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public View.OnClickListener T1;
    public kv4 U;
    public FrameLayout U0;
    public CustomMessageListener U1;
    public Dialog V;
    public TextView V0;
    public Handler V1;
    public Dialog W;
    public View W0;
    public Runnable W1;
    public View X;
    public View X0;
    public CustomMessageListener X1;
    public LinearLayout Y;
    public View Y0;
    public PbFragment.h3 Y1;
    public CompoundButton.OnCheckedChangeListener Z;
    public PbReplyTitleViewHolder Z0;
    public boolean Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public TextView a0;
    public View a1;
    public View.OnClickListener a2;
    public int b;
    public TextView b0;
    public int b1;
    public boolean b2;
    public PbFragment c;
    public String c0;
    public boolean c1;
    public String c2;
    public RelativeLayout d;
    public tv4 d0;
    public z0 d1;
    public az4.g d2;
    public View e;
    public tv4 e0;
    public PbEmotionBar e1;
    public View.OnClickListener e2;
    public int f;
    public ov4 f0;
    public int f1;
    public final List<TbImageView> f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public int g2;
    public final v38 h;
    public boolean h0;
    public Runnable h1;
    public boolean h2;
    public u38 i;
    public String i0;
    public PbFakeFloorModel i1;
    public boolean i2;
    public ViewStub j;
    public String j0;
    public m08 j1;
    public ViewStub k;
    public ry7 k0;
    public l18 k1;
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
    public q08 p;
    public View p0;
    public boolean p1;
    public p08 q;
    public EjectionAnimationView q0;
    public int q1;
    public p18 r;
    public Button r0;
    public PbTopTipView r1;
    public o18 s;
    public View s0;
    public PopupWindow s1;
    public n28 t;
    public View t0;
    public TextView t1;
    public i28 u;
    public LinearLayout u0;
    public List<String> u1;
    public k28 v;
    public HeadImageView v0;
    public s28 v1;
    public m28 w;
    public ImageView w0;
    public pz7 w1;
    public j28 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public l28 y;
    public WaterRippleView y0;
    public boolean y1;
    public h28 z;
    public ImageView z0;
    public boolean z1;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? R.id.obfuscated_res_0x7f091c6b : invokeV.intValue;
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
        public final /* synthetic */ t18 g;

        /* renamed from: com.baidu.tieba.t18$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0427a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0427a(a aVar) {
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

        public a(t18 t18Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = t18Var;
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
                    ah.a().post(new RunnableC0427a(this));
                }
                this.g.l.setOnLayoutListener(null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AgreeView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        /* loaded from: classes6.dex */
        public class a implements i65 {
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

            @Override // com.baidu.tieba.i65
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

        public c(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.g
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z3();
            k65.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.g
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
    public class j implements p08.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

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

        public j(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.p08.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements o18.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

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

        public k(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.o18.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.p6()) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

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

        public o0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.h1 == null) {
                    this.a.h1 = new a(this);
                }
                ah.a().postDelayed(this.a.h1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements tp5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ t18 b;

        public a0(t18 t18Var, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, kv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.tp5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.Z4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements oy7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        @Override // com.baidu.tieba.oy7
        public /* synthetic */ void onStart() {
            ny7.a(this);
        }

        public b(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.oy7
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements wp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ t18 b;

        public b0(t18 t18Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.wp5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.Y4(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public c0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
        public final /* synthetic */ t18 a;

        public d(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A0 != null && this.a.A0.getData() != null) {
                t18 t18Var = this.a;
                t18Var.D2(t18Var.A0.getData(), this.a.A0.getData().agreeNum);
                if (!this.a.A0.G()) {
                    t18 t18Var2 = this.a;
                    t18Var2.w2(t18Var2.A0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public d0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                ch.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public e(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.q1()) {
                        return;
                    }
                    qy4.k().u("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv4.c a;
        public final /* synthetic */ t18 b;

        public e0(t18 t18Var, mv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public f(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920dd) instanceof Boolean) {
                z = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920dd)).booleanValue();
            } else {
                z = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) {
                z2 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue();
            } else {
                z2 = false;
            }
            if (sparseArray.get(R.id.obfuscated_res_0x7f0920db) instanceof Boolean) {
                z3 = ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920db)).booleanValue();
            } else {
                z3 = false;
            }
            if (z) {
                if (z2) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a7, 1);
                    this.a.c.P4(sparseArray);
                    return;
                }
                this.a.v2(view2);
            } else if (z2) {
                sparseArray.put(R.id.obfuscated_res_0x7f0920a7, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092090, 1);
                this.a.c.P4(sparseArray);
            } else if (z3) {
                this.a.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv4.c a;
        public final /* synthetic */ t18 b;

        public f0(t18 t18Var, mv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public g(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
        public final /* synthetic */ p15 a;
        public final /* synthetic */ t18 b;

        public g0(t18 t18Var, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, p15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = p15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.N0 != null && this.b.O1 != null) {
                this.b.O1.g(this.a);
                this.b.O1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public h(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.Q(postData);
                this.a.E.Z();
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
        public final /* synthetic */ t18 a;

        public h0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.N0 != null && this.a.N0.Q() != null && this.a.N0.Q().getAuthor() != null && this.a.N0.Q().getAuthor().getAlaInfo() != null && this.a.N0.Q().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.N0.m());
                    statisticItem2.param("fname", this.a.N0.n());
                    if (this.a.N0.Q().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.N0.Q().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.N0.S());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.N0.Q().getAuthor().getAlaInfo()));
                    if (this.a.N0.Q().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.N0.Q().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.N0.Q().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.N0.Q().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.n1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.n1 && this.a.N0 != null && this.a.N0.Q() != null && this.a.N0.Q().getAuthor() != null && this.a.N0.Q().getAuthor().isBigV()) {
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
        public final /* synthetic */ t18 a;

        public i(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
                this.a.N1.setTag(Boolean.FALSE);
                if (this.a.O1 == null) {
                    return;
                }
                this.a.O1.setAutoCompleteShown(false);
                if (this.a.O1.getVisibility() == 0) {
                    this.a.O1.setTag(this.a.N1);
                    this.a.O1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements h28.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public i0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.h28.a
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
        public final /* synthetic */ t18 a;

        public j0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t18 t18Var;
            v38 v38Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (v38Var = (t18Var = this.a).h) != null && v38Var.i != null && t18Var.N0 != null && this.a.N0.Q() != null && !this.a.N0.Q().isVideoThreadType() && !this.a.Q1() && this.a.N0.l() != null && !xi.isEmpty(this.a.N0.l().getName())) {
                if ((this.a.E.I() == null || !this.a.E.I().isShown()) && (linearLayout = this.a.h.i) != null) {
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
        public final /* synthetic */ t18 b;

        public k0(t18 t18Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (yi.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0c81);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public l(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    qy4.k().u("pb_share_red_dot_shown", true);
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
        public final /* synthetic */ px7 c;
        public final /* synthetic */ t18 d;

        public l0(t18 t18Var, Parcelable parcelable, ArrayList arrayList, px7 px7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, parcelable, arrayList, px7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t18Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = px7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.z().b() > 0) {
                    this.d.K.f();
                    this.d.K.E(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e22));
                    this.d.K.z();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements rw7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public m(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.rw7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.R();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public m0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
        public final /* synthetic */ t18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(t18 t18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Integer.valueOf(i)};
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
            this.a = t18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.E != null) {
                this.a.E.Z();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public n0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.p0();
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public o(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
        public final /* synthetic */ t18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(t18 t18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Integer.valueOf(i)};
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
            this.a = t18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.J0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public q(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
    public class q0 implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements m65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public r(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.m65
        public void B(l65 l65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, l65Var) == null) {
                Object obj = l65Var.c;
                if ((obj instanceof f25) && EmotionGroupType.isSendAsPic(((f25) obj).getType())) {
                    if (this.a.F1 == null) {
                        this.a.F1 = new PermissionJudgePolicy();
                    }
                    this.a.F1.clearRequestPermissionList();
                    this.a.F1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    f25 f25Var = (f25) l65Var.c;
                    this.a.c.v5().f(f25Var);
                    if (f25Var.i()) {
                        this.a.c.v5().G(null, null);
                    } else {
                        this.a.c.v5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p15 a;
        public final /* synthetic */ t18 b;

        public r0(t18 t18Var, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, p15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = p15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.O1.setHomePbFloatLastCloseTime();
                this.b.w1();
                this.b.O1.u(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public s(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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
                    t18 t18Var = this.a;
                    t18Var.v1 = new s28(t18Var.c.getPageContext(), this.a.d, layoutParams);
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
        public final /* synthetic */ t18 e;

        public s0(t18 t18Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t18Var;
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
    public class t implements vv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t18 b;

        public t(t18 t18Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.vv4.e
        public void n0(vv4 vv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, vv4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.q2(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f092096), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f0920b4)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f092097)).booleanValue());
                        return;
                    case 11:
                        if (this.b.Y1 != null) {
                            this.b.Y1.a(new Object[]{sparseArray.get(R.id.obfuscated_res_0x7f0920b4), sparseArray.get(R.id.obfuscated_res_0x7f0920a1), sparseArray.get(R.id.obfuscated_res_0x7f0920a4), sparseArray.get(R.id.obfuscated_res_0x7f0920a2), sparseArray.get(R.id.obfuscated_res_0x7f0920a3)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.G5(this.a, (String) sparseArray.get(R.id.obfuscated_res_0x7f0920ed), sparseArray);
                        return;
                    case 13:
                        this.b.r4(true);
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
        public final /* synthetic */ t18 a;

        public t0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String f1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.K() != null && this.a.c.K().A2()) {
                    f1 = this.a.c.getString(R.string.obfuscated_res_0x7f0f0e37);
                } else {
                    f1 = this.a.f1();
                }
                if (!StringUtils.isNull(f1) && this.a.N0 != null) {
                    f1 = TbSingleton.getInstance().getAdVertiComment(this.a.N0.r0(), this.a.N0.s0(), f1);
                }
                if (this.a.c != null && this.a.c.v5() != null) {
                    this.a.c.v5().c0(f1);
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
    public class u implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public u(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                kv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u0(t18 t18Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, Integer.valueOf(i)};
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
            this.a = t18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.R1 = null;
        }
    }

    /* loaded from: classes6.dex */
    public static class v implements xo8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.xo8.f
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
        public final /* synthetic */ t18 b;

        public v0(t18 t18Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t18Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.K1 || this.a == null || this.b.c.K() == null || !this.b.c.K().D2()) {
                return;
            }
            this.b.K1 = true;
            this.a.N4(false);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ t18 c;

        public w(t18 t18Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t18Var;
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
                    yi.O(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c81);
                } else {
                    this.c.c.Y4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements py7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public w0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.py7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.J5();
            }
        }

        @Override // com.baidu.tieba.py7.b
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

        public x(t18 t18Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, alertDialog};
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
        public final /* synthetic */ n85 b;
        public final /* synthetic */ t18 c;

        public x0(t18 t18Var, ReplyPrivacyCheckController replyPrivacyCheckController, n85 n85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, replyPrivacyCheckController, n85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t18Var;
            this.a = replyPrivacyCheckController;
            this.b = n85Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.g5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.g5().replyPrivateFlag)) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    return;
                }
                this.c.n4();
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
        public final /* synthetic */ t18 c;

        public y(t18 t18Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = t18Var;
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
                    yi.O(this.c.c.P(), R.string.obfuscated_res_0x7f0f0c81);
                } else {
                    this.c.c.Y4(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public y0(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
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

        public z(t18 t18Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var, alertDialog};
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948128462, "Lcom/baidu/tieba/t18;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948128462, "Lcom/baidu/tieba/t18;");
                return;
            }
        }
        j2 = UtilHelper.getLightStatusBarHeight();
        k2 = 3;
        l2 = 0;
        m2 = 3;
        n2 = 4;
        o2 = 5;
        p2 = 6;
        q2 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        r2 = 1;
        s2 = new v();
    }

    public PostData I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int H0 = H0() - this.l.getHeaderViewsCount();
            int i2 = 0;
            if (H0 < 0) {
                H0 = 0;
            }
            if (this.E.y(H0) != null && this.E.y(H0) != PostData.M0) {
                i2 = H0 + 1;
            }
            if (!(this.E.x(i2) instanceof PostData)) {
                return null;
            }
            return (PostData) this.E.x(i2);
        }
        return (PostData) invokeV.objValue;
    }

    public void V3() {
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && TbadkCoreApplication.isLogin() && this.N0 != null && this.o1 && !this.n1 && !this.h0 && (postData = this.O0) != null && postData.s() != null && !this.O0.s().getIsLike() && !this.O0.s().hadConcerned() && this.k1 == null) {
            this.k1 = new l18(this.c);
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            j4();
            this.E.a0(1);
            n28 n28Var = this.t;
            if (n28Var != null) {
                n28Var.l();
            }
            q08 q08Var = this.p;
            if (q08Var != null) {
                q08Var.k();
            }
            p18 p18Var = this.r;
            if (p18Var != null) {
                p18Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.O1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).H(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            this.E.a0(2);
            n28 n28Var = this.t;
            if (n28Var != null) {
                n28Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    n1().setSystemUiVisibility(4);
                }
            }
            m2();
            W1();
            t4();
        }
    }

    public t18(PbFragment pbFragment, View.OnClickListener onClickListener, ry7 ry7Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, ry7Var};
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
        this.z1 = false;
        this.G1 = 0L;
        this.J1 = 0;
        this.S1 = new u0(this, 2921306);
        this.T1 = new l(this);
        this.U1 = new n(this, 2005016);
        this.V1 = new Handler();
        this.X1 = new p(this, 2004009);
        this.Z1 = true;
        this.a2 = new h0(this);
        this.b2 = false;
        this.c2 = null;
        this.f2 = new ArrayList();
        this.h2 = false;
        this.G1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.P = onClickListener;
        this.k0 = ry7Var;
        this.q1 = yi.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0656, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f09040f);
        this.B1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091897);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091fd7);
        this.P1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091c8c);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092297);
        this.m = (NoNetworkView) this.d.findViewById(R.id.obfuscated_res_0x7f092615);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f0916ca);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091cc7);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + yi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.setOverScrollMode(2);
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (ko5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.L2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new v38(pbFragment, this.d);
        if (this.c.p5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0914de);
            this.j = viewStub;
            viewStub.setVisibility(0);
            u38 u38Var = new u38(pbFragment);
            this.i = u38Var;
            u38Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = yi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new py7(new w0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f0925fb);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f091830);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0908a3);
        this.w0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.v5()));
        V1();
        w0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091833);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09182b);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0908a7);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091831);
        this.M1 = (MaskView) this.d.findViewById(R.id.obfuscated_res_0x7f0914ff);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f09182d);
        this.A0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.A0.t();
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
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09182f);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f091836);
        this.E0 = findViewById;
        if (!qy4.k().h("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091834);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091835);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.T1);
        this.C0.setOnClickListener(new e(this));
        Y1();
        z58 z58Var = new z58(this.C0);
        this.F0 = z58Var;
        z58Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091832);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09182e);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090fa4);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new i28(this.c, ry7Var);
        this.w = new m28(this.c, ry7Var, this.P);
        a08 a08Var = new a08(this.c, this.l);
        this.E = a08Var;
        a08Var.y0(this.P);
        this.E.A0(this.k0);
        this.E.v0(this.Q);
        this.E.x0(this.c.i2);
        this.E.r0(this.e2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.t0(fVar);
        F1();
        z1();
        l28 l28Var = new l28(this.c);
        this.y = l28Var;
        l28Var.f = 2;
        y1();
        this.z.a(this.l);
        this.w.n(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.b().findViewById(R.id.obfuscated_res_0x7f091887);
        this.N = this.K.b().findViewById(R.id.obfuscated_res_0x7f09181b);
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
        this.K.B();
        this.K.p(R.drawable.pb_foot_more_trans_selector);
        this.K.q(R.drawable.pb_foot_more_trans_selector);
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f092631);
        this.c.registerListener(this.X1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel K = this.c.K();
        this.i1.S(K.I(), K.E(), K.F(), K.D(), K.J());
        m08 m08Var = new m08(this.c.getPageContext(), this.i1, this.d);
        this.j1 = m08Var;
        m08Var.k(new g(this));
        this.j1.n(this.c.n2);
        this.i1.U(new h(this));
        if (this.c.K() != null && !StringUtils.isNull(this.c.K().V1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.K().V1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f091838);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f09040d);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f091fe4);
        this.Y0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.K() != null && this.c.K().E1()) {
            this.W0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Y0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = j2;
            this.Y0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f0918b5));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.c0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.i2);
        this.c.registerListener(this.U1);
        this.c.registerListener(this.S1);
        PbFragment pbFragment3 = this.c;
        this.L1 = new y58(pbFragment3, pbFragment3.getUniqueId());
        this.N1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f0909af);
        T2();
        this.N1.setAnimationListener(new i(this));
        k0();
        M2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f091821);
        j0(ko5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && K.H2() && sw7.b().e()) {
            if (this.p == null) {
                this.p = new q08(this.c.getActivity(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f09185d));
            }
            p08 p08Var = new p08(this.l);
            this.q = p08Var;
            p08Var.d(new j(this));
        }
        this.r = new p18(this.c.P(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f0918ca));
        o18 o18Var = new o18(this.l);
        this.s = o18Var;
        o18Var.d(new k(this));
    }

    public void Z1(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            p08 p08Var = this.q;
            if (p08Var != null) {
                p08Var.b();
            }
            o18 o18Var = this.s;
            if (o18Var != null) {
                o18Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void f4(px7 px7Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048707, this, px7Var, z2) != null) || px7Var == null) {
            return;
        }
        p4(px7Var, z2);
        s0();
    }

    public final void p3(PostData postData, px7 px7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048756, this, postData, px7Var) == null) {
            this.w.I(postData, px7Var);
        }
    }

    public void y2(e55 e55Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048796, this, e55Var, i2) == null) && (fallingView = this.N1) != null) {
            fallingView.A(e55Var, this.c.getPageContext(), i2, false);
        }
    }

    public void E3(boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z2) == null) {
            View view2 = this.o0;
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
        }
    }

    public void F3(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048599, this, z2) != null) || this.t0 == null) {
            return;
        }
        V2(this.c.v5().y());
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
            pbListView.E(str);
        }
    }

    public void U2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, h3Var) == null) {
            this.Y1 = h3Var;
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
            this.E.i0(z2);
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
            return 0 + yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void X2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) {
            this.H1 = z2;
        }
    }

    public void Y2(boolean z2) {
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) && (a08Var = this.E) != null) {
            a08Var.j0(z2);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public void a3(boolean z2) {
        n28 n28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) && (n28Var = this.t) != null) {
            n28Var.r(z2);
        }
    }

    public void b3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048687, this, z2) == null) {
            this.E.l0(z2);
        }
    }

    public void c3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048691, this, z2) == null) {
            this.E.q0(z2);
        }
    }

    public void d3(az4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, gVar) == null) {
            this.d2 = gVar;
            a68 a68Var = this.J;
            if (a68Var != null) {
                a68Var.f(gVar);
            }
        }
    }

    public final void d4(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048697, this, postData) == null) && postData != null) {
            if (!StringUtils.isNull(postData.Y())) {
                this.z1 = true;
            } else {
                this.z1 = false;
            }
            m28 m28Var = this.w;
            if (m28Var != null) {
                m28Var.p(postData);
            }
        }
    }

    public void e3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, onClickListener) == null) {
            this.e2 = onClickListener;
            a08 a08Var = this.E;
            if (a08Var != null) {
                a08Var.r0(onClickListener);
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

    public boolean f2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048705, this, i2)) == null) {
            n28 n28Var = this.t;
            if (n28Var != null) {
                return n28Var.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f3(String str) {
        u38 u38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048706, this, str) == null) && (u38Var = this.i) != null) {
            u38Var.b(str);
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

    public void g4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void i3(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, yVar) == null) {
            this.Q = yVar;
            this.E.v0(yVar);
            this.w1.q(this.Q);
        }
    }

    public void j2(ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, aoVar) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            pbLandscapeListView.b0 = aoVar;
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

    public void k3(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, pVar) == null) {
            this.l.setOnSrollToBottomListener(pVar);
        }
    }

    public void k4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            this.g0 = z2;
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
            this.E.z0(onClickListener);
        }
    }

    public void n3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i2) == null) {
            this.I1 = i2;
        }
    }

    public void o3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, onLongClickListener) == null) {
            this.w.H(onLongClickListener);
            this.E.w0(onLongClickListener);
            pz7 pz7Var = this.w1;
            if (pz7Var != null) {
                pz7Var.r(onLongClickListener);
            }
        }
    }

    public void s4(px7 px7Var) {
        i28 i28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048772, this, px7Var) == null) && (i28Var = this.u) != null) {
            i28Var.h(px7Var, this.M0);
        }
    }

    public void u3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048781, this, z2) == null) {
            this.w.J(z2);
        }
    }

    public void v2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048784, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        u2(sparseArray, false);
    }

    public void w3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048789, this, i2) == null) {
            this.l.setSelection(i2);
        }
    }

    public void x3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, list) == null) {
            this.u1 = list;
            s28 s28Var = this.v1;
            if (s28Var != null) {
                s28Var.q(list);
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
            this.w.E(this.N0, this.O0, this.o1, this.n1);
        }
    }

    public void B3() {
        n28 n28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (n28Var = this.t) != null) {
            n28Var.u(this.l);
        }
    }

    public a08 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.E;
        }
        return (a08) invokeV.objValue;
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
                return view2.findViewById(R.id.obfuscated_res_0x7f0907d1);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.x == null) {
            this.x = new j28(this.c, this.P);
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
            return this.b2;
        }
        return invokeV.booleanValue;
    }

    public final void H2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (pbInterviewStatusView = this.T0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.T0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.T0.setLayoutParams(marginLayoutParams);
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
            return this.N1;
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
        v38 v38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (v38Var = this.h) != null && !this.p1) {
            v38Var.D();
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
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.c2);
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
                this.L0 = new uy4(this.c.getPageContext());
            }
            this.L0.h(true);
        }
    }

    public TextView O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.w.s();
        }
        return (TextView) invokeV.objValue;
    }

    public final void O2() {
        n28 n28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (n28Var = this.t) != null) {
            n28Var.q(this.l, this.V0, this.P0);
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            z58 z58Var = this.F0;
            if (z58Var != null) {
                return z58Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void P2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || (handler = this.V1) == null) {
            return;
        }
        Runnable runnable = this.W1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        o oVar = new o(this);
        this.W1 = oVar;
        this.V1.postDelayed(oVar, 2000L);
    }

    public void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.E.h0(this.N0, false);
            this.E.Z();
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
            n28 n28Var = this.t;
            if (n28Var != null && n28Var.f()) {
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
            return this.Q1;
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
            z58 z58Var = this.F0;
            if (z58Var == null) {
                return false;
            }
            return z58Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.N1.setFallingFeedbackListener(new t0(this));
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

    public pz7 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.w1;
        }
        return (pz7) invokeV.objValue;
    }

    public final void V1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (imageView = this.w0) != null) {
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f0809d8);
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
        a08 a08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && (a08Var = this.E) != null) {
            a08Var.B0();
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
        z58 z58Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || (z58Var = this.F0) == null) {
            return;
        }
        z58Var.o(2);
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

    public m08 d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.j1;
        }
        return (m08) invokeV.objValue;
    }

    public void e0() {
        z58 z58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (z58Var = this.F0) != null) {
            z58Var.m(false);
        }
    }

    public n28 e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.t;
        }
        return (n28) invokeV.objValue;
    }

    public void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            this.c.showProgressBar();
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
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048722, this) == null) && (fallingView = this.N1) != null) {
            fallingView.C();
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

    public void j4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && this.f2 != null) {
            while (this.f2.size() > 0) {
                TbImageView remove = this.f2.remove(0);
                if (remove != null) {
                    remove.O();
                }
            }
        }
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
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && (pbFragment = this.c) != null && pbFragment.v5() != null) {
            this.c.v5().E();
        }
    }

    public RelativeLayout n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048744, this)) == null) {
            return this.d;
        }
        return (RelativeLayout) invokeV.objValue;
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
            v38 v38Var = this.h;
            if (v38Var != null && (view2 = v38Var.d) != null) {
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
        z58 z58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (z58Var = this.F0) != null) {
            z58Var.l(false);
        }
    }

    public void r1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && (editorTools = this.m0) != null) {
            editorTools.o();
            s28 s28Var = this.v1;
            if (s28Var != null) {
                s28Var.m();
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
        v38 v38Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && (v38Var = this.h) != null) {
            v38Var.q();
        }
    }

    public void s3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            yi.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void t1() {
        uy4 uy4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048774, this) == null) && (uy4Var = this.L0) != null) {
            uy4Var.h(false);
        }
    }

    public void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048776, this) == null) {
            this.K.B();
            this.K.S();
        }
    }

    public void u0() {
        n28 n28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (n28Var = this.t) != null) {
            n28Var.b();
        }
    }

    public void u1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048779, this) == null) {
            if (this.A == null) {
                B1();
            }
            this.k.setVisibility(8);
            Handler handler = this.V1;
            if (handler != null && (runnable = this.W1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", r2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", r2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void w1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048787, this) == null) && (rightFloatLayerView = this.O1) != null) {
            rightFloatLayerView.c();
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.z();
                this.K.f();
            }
            t1();
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (editorTools = this.m0) != null) {
            editorTools.q();
        }
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            p18 p18Var = this.r;
            if (p18Var != null && p18Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            this.l.A(0L);
            s0();
        }
    }

    public final void y1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new h28(pbFragment.getContext());
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048799, this) == null) && this.v == null) {
            this.v = new k28(this.c, this.k0);
        }
    }

    public final void A1(px7 px7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, px7Var) != null) || px7Var == null || px7Var.Q() == null || !px7Var.Q().isInterviewLive() || this.T0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
        this.T0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.T0.setCallback(this.c.o5());
        this.T0.setData(this.c, px7Var);
    }

    public void J3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && this.t0 != null && (textView = this.x0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0531);
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

    public final int L0(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            on adapter2 = this.l.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof mx7)) {
                i2++;
            }
            int o3 = (adapter2.o() + adapter2.m()) - 1;
            if (i2 > o3) {
                i2 = o3;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof on)) {
                i3 = this.l.getAdapter2().n();
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

    public void S2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048650, this, str) == null) && this.K != null) {
            int i2 = 0;
            z0 z0Var = this.d1;
            if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.H(str, i2);
        }
    }

    public final void e4(px7 px7Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, px7Var) == null) && !this.z1 && px7Var != null && px7Var.Q() != null && !px7Var.Q().isVideoThreadType()) {
            boolean z3 = false;
            if (px7Var.Q().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (px7Var.Q().getIs_top() == 1) {
                z3 = true;
            }
            m28 m28Var = this.w;
            if (m28Var != null) {
                m28Var.q(px7Var, z2, z3);
            }
            k28 k28Var = this.v;
            if (k28Var != null) {
                k28Var.b(px7Var, z2, z3);
            }
        }
    }

    public void j0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            int i4 = 0;
            if (z2) {
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0202);
            } else {
                this.l.setBackgroundResource(0);
            }
            View view2 = this.p0;
            if (view2 != null) {
                if (z2) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                view2.setVisibility(i3);
            }
            PbListView pbListView = this.K;
            if (pbListView != null) {
                if (z2) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                pbListView.M(i2);
            }
            View view3 = this.M;
            if (view3 != null) {
                if (z2) {
                    i4 = 8;
                }
                view3.setVisibility(i4);
            }
        }
    }

    public void v3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, str) == null) {
            this.x0.performClick();
            if (!StringUtils.isNull(str) && this.c.v5() != null && this.c.v5().s() != null && this.c.v5().s().i() != null) {
                EditText i2 = this.c.v5().s().i();
                i2.setText(str);
                i2.setSelection(str.length());
            }
        }
    }

    public final void A2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, pbReplyTitleViewHolder, z2) == null) && !this.n1 && this.W0 != null && this.h.p() != null) {
            View s3 = D0().s();
            if (s3 != null) {
                int[] iArr = new int[2];
                s3.getLocationInWindow(iArr);
                int i3 = iArr[1];
                if (i3 != 0) {
                    if (this.W0.getVisibility() == 0 && i3 - this.h.p().getBottom() <= this.W0.getHeight()) {
                        this.X0.setVisibility(0);
                        if (i3 > this.h.p().getBottom()) {
                            i2 = -(((this.W0.getHeight() + this.X0.getHeight()) + this.h.p().getBottom()) - s3.getBottom());
                        } else {
                            i2 = -this.W0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W0.getLayoutParams();
                        if (layoutParams.topMargin != i2) {
                            layoutParams.topMargin = i2;
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
            int G = this.E.G();
            if (G > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                if (G > this.l.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
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
                    int i4 = this.b1;
                    if (top < i4) {
                        i4 = top;
                    }
                    this.b1 = i4;
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
                    measuredHeight = j2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
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

    public void u2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        rv4 rv4Var;
        rv4 rv4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048780, this, sparseArray, z2) == null) {
            vv4 vv4Var = new vv4(this.c.getContext());
            vv4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02e9));
            vv4Var.n(new t(this, z2));
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            if (sparseArray.get(R.id.obfuscated_res_0x7f092090) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092090)).intValue();
            } else {
                i2 = -1;
            }
            if (!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f092096)) && i2 != 2) {
                if (sparseArray.get(R.id.obfuscated_res_0x7f092098) instanceof Integer) {
                    i3 = ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f092098)).intValue();
                }
                if (i3 == 0) {
                    rv4Var2 = new rv4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04c6), vv4Var);
                } else {
                    rv4Var2 = new rv4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04bb), vv4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray2.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray2.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray2.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                rv4Var2.d.setTag(sparseArray2);
                arrayList.add(rv4Var2);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920b5) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920b5)).booleanValue()) {
                rv4 rv4Var3 = new rv4(13, this.c.getString(R.string.obfuscated_res_0x7f0f0b5a), vv4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.obfuscated_res_0x7f092096, sparseArray.get(R.id.obfuscated_res_0x7f092096));
                sparseArray3.put(R.id.obfuscated_res_0x7f092098, sparseArray.get(R.id.obfuscated_res_0x7f092098));
                sparseArray3.put(R.id.obfuscated_res_0x7f092097, sparseArray.get(R.id.obfuscated_res_0x7f092097));
                sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                rv4Var3.d.setTag(sparseArray3);
                arrayList.add(rv4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a1)) || !"".equals(sparseArray.get(R.id.obfuscated_res_0x7f0920a2))) && !S1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a1, sparseArray.get(R.id.obfuscated_res_0x7f0920a1));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a2, sparseArray.get(R.id.obfuscated_res_0x7f0920a2));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a3, sparseArray.get(R.id.obfuscated_res_0x7f0920a3));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920b4, sparseArray.get(R.id.obfuscated_res_0x7f0920b4));
                sparseArray4.put(R.id.obfuscated_res_0x7f0920a4, sparseArray.get(R.id.obfuscated_res_0x7f0920a4));
                rv4 rv4Var4 = new rv4(11, this.c.getString(R.string.obfuscated_res_0x7f0f0675), vv4Var);
                rv4Var4.d.setTag(sparseArray4);
                arrayList.add(rv4Var4);
            }
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920f1) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f0920f1)).booleanValue()) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ab, sparseArray.get(R.id.obfuscated_res_0x7f0920ab));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ed, sparseArray.get(R.id.obfuscated_res_0x7f0920ed));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ee, sparseArray.get(R.id.obfuscated_res_0x7f0920ee));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ec, sparseArray.get(R.id.obfuscated_res_0x7f0920ec));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920ef, sparseArray.get(R.id.obfuscated_res_0x7f0920ef));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920f0, sparseArray.get(R.id.obfuscated_res_0x7f0920f0));
                sparseArray5.put(R.id.obfuscated_res_0x7f0920eb, sparseArray.get(R.id.obfuscated_res_0x7f0920eb));
                if (z2) {
                    rv4Var = new rv4(12, this.c.getString(R.string.obfuscated_res_0x7f0f14fb), vv4Var);
                } else {
                    rv4Var = new rv4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b66), vv4Var);
                }
                rv4Var.d.setTag(sparseArray5);
                arrayList.add(rv4Var);
            }
            n38.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                vv4Var.k(arrayList, false);
            } else {
                vv4Var.k(arrayList, true);
            }
            tv4 tv4Var = new tv4(this.c.getPageContext(), vv4Var);
            this.S = tv4Var;
            tv4Var.k();
        }
    }

    public void A3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            FrameLayout frameLayout = this.U0;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            v38 v38Var = this.h;
            if (v38Var != null && (view2 = v38Var.d) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i2 = 8;
                }
                view2.setVisibility(i2);
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
            this.v.h(this.l);
            this.w.F(this.l);
            this.x.d(this.l);
            this.u.f(this.l);
        }
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            View view2 = this.a1;
            if (view2 == null || view2.getParent() == null || this.K.n()) {
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
            px7 px7Var = this.N0;
            if (px7Var == null || px7Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            FallingView fallingView = this.N1;
            if (fallingView != null) {
                fallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.O1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.N1) {
                this.O1.setTag(null);
                this.O1.setAutoCompleteShown(true);
                this.O1.d();
            }
        }
    }

    public String f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            if (!xi.isEmpty(this.E1)) {
                return this.E1;
            }
            if (this.c != null) {
                this.E1 = TbadkCoreApplication.getInst().getResources().getString(r18.g());
            }
            return this.E1;
        }
        return (String) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.h())) {
                return this.K.h().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && this.N0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !p38.k(this.N0.S())) {
            this.F0.f();
            p38.b(this.N0.S());
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            pz7 pz7Var = new pz7(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091598));
            this.w1 = pz7Var;
            pz7Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
        }
    }

    public final void n4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && (pbFragment = this.c) != null && pbFragment.v5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.v5().y())));
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.h.k();
            m28 m28Var = this.w;
            if (m28Var != null) {
                m28Var.r();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                yi.z(pbFragment.getContext(), this.I);
            }
            r1();
            tv4 tv4Var = this.d0;
            if (tv4Var != null) {
                tv4Var.dismiss();
            }
            t0();
            kv4 kv4Var = this.F;
            if (kv4Var != null) {
                kv4Var.dismiss();
            }
            mv4 mv4Var = this.G;
            if (mv4Var != null) {
                mv4Var.e();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.h.k();
            m28 m28Var = this.w;
            if (m28Var != null) {
                m28Var.r();
            }
            tv4 tv4Var = this.d0;
            if (tv4Var != null) {
                tv4Var.dismiss();
            }
            t0();
            kv4 kv4Var = this.F;
            if (kv4Var != null) {
                kv4Var.dismiss();
            }
            mv4 mv4Var = this.G;
            if (mv4Var != null) {
                mv4Var.e();
            }
        }
    }

    public final void q4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048762, this) != null) || !this.c.p5()) {
            return;
        }
        if (this.c.u5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.t5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            kv4 kv4Var = this.U;
            if (kv4Var != null) {
                kv4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                ch.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                ch.b(dialog2, this.c.getPageContext());
            }
            tv4 tv4Var = this.S;
            if (tv4Var != null) {
                tv4Var.dismiss();
            }
        }
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
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

    public final String C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0e0f);
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

    public final void C3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.obfuscated_res_0x7f0920aa, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f11cd, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0377, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(R.string.obfuscated_res_0x7f0f0b62);
        tBAlertBuilder.k(R.string.obfuscated_res_0x7f0f0b63);
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
            this.m0.setId(R.id.obfuscated_res_0x7f09182c);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.w(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new r(this));
            r1();
            this.c.v5().g(new s(this));
        }
    }

    public void a2(cp8 cp8Var) {
        px7 px7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, cp8Var) == null) && cp8Var != null && cp8Var.b != null && (px7Var = this.N0) != null && px7Var.Q() != null && this.N0.Q().getAgreeData() != null) {
            AgreeData agreeData = this.N0.Q().getAgreeData();
            String str = cp8Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = cp8Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = cp8Var.b;
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
        m08 m08Var = this.j1;
        if (m08Var != null) {
            m08Var.c();
        }
        this.c.J5();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.D6(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                m1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.i2 = true;
                this.l.setIsLandscape(true);
                this.l.smoothScrollToPosition(0);
            } else {
                this.i2 = false;
                this.l.setIsLandscape(false);
                int i2 = this.g2;
                if (i2 > 0) {
                    this.l.smoothScrollBy(i2, 0);
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
                    layoutParams.height = j2;
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

    public void o4(px7 px7Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, px7Var) == null) {
            if (px7Var != null && AntiHelper.o(px7Var.Q())) {
                z58 z58Var = this.F0;
                if (z58Var != null) {
                    z58Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.obfuscated_res_0x7f08099f, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            z58 z58Var2 = this.F0;
            if (z58Var2 != null && z58Var2.h()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = this.C0.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.C0.setLayoutParams(layoutParams2);
            ImageView imageView = this.C0;
            if (UbsABTestHelper.isShareTopRight()) {
                i2 = R.color.CAM_X0105;
            } else {
                i2 = R.color.CAM_X0107;
            }
            WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f08099f, i2, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void q1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) && this.t0 != null && this.x0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            px7 px7Var = this.N0;
            if (px7Var != null && px7Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            px7 px7Var2 = this.N0;
            if (px7Var2 != null && px7Var2.s0()) {
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

    public void r4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z2) == null) {
            a08 a08Var = this.E;
            if (a08Var != null) {
                a08Var.u0(z2);
                this.E.Z();
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
                pbFragment.C6(z2);
            }
            if (z2) {
                o38.d(this.c.getPageContext(), this.c.K(), this.c.y5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            px7 px7Var = this.N0;
            if (px7Var != null) {
                str = px7Var.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.c.p5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0914d9);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0914d8);
            qf5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f0914dd);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f0914dc);
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
                int i2 = (lastVisiblePosition - firstVisiblePosition) + 1;
                int[] iArr = new int[i2];
                Rect rect = new Rect();
                int childCount = this.l.getChildCount();
                int i3 = 0;
                for (int i4 = firstVisiblePosition; i4 <= lastVisiblePosition; i4++) {
                    int i5 = i4 - firstVisiblePosition;
                    if (i5 < childCount && (childAt = this.l.getChildAt(i5)) != null) {
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

    public final void L2() {
        PbFragment pbFragment;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (pbFragment = this.c) != null && pbFragment.v5() != null && this.m0 != null) {
            j85.a().c(0);
            n85 v5 = this.c.v5();
            v5.M();
            v5.K();
            if (v5.v() != null) {
                WriteImagesInfo v2 = v5.v();
                if (v5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            v5.d0(SendView.h);
            v5.h(SendView.h);
            s65 m3 = this.m0.m(23);
            s65 m4 = this.m0.m(2);
            s65 m5 = this.m0.m(5);
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
        if (r5.J1 == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0() {
        y58 y58Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048748, this) != null) || (y58Var = this.L1) == null) {
            return;
        }
        if (y58Var.a() != null && this.L1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.L1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.L1.a().getTop() + q2 <= this.W0.getBottom()) {
                this.J1 = 1;
                z2 = true;
            } else {
                this.J1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0;
        if (this.J1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.t(z3);
        this.L1.e(z2);
    }

    public void r3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048766, this) == null) {
            this.c.hideProgressBar();
            px7 px7Var = this.N0;
            if (px7Var != null && this.K != null && px7Var.z() != null && this.N0.z().b() == 0) {
                this.K.w(this.N0.t());
                if (this.N0.t()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.N0.m());
                    statisticItem.param("fname", this.N0.n());
                    statisticItem.param("tid", this.N0.S());
                    TiebaStatic.log(statisticItem);
                }
            }
            x0();
            this.l.A(0L);
            s0();
        }
    }

    public final void z2() {
        v38 v38Var;
        px7 px7Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048800, this) == null) && this.v != null && (v38Var = this.h) != null && v38Var.p() != null && (px7Var = this.N0) != null && px7Var.Q() != null && this.N0.Q().isQuestionThread() && this.v.d() != null && this.v.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.d().getHeight();
            if (this.v.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            v38 v38Var2 = this.h;
            if (height > v38Var2.p().getBottom() && z2) {
                z3 = false;
            }
            v38Var2.H(z3, this.N0.Q().getSpan_str());
        }
    }

    public void C2() {
        PbLandscapeListView pbLandscapeListView;
        int i2;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.m1;
        int i4 = 0;
        if (this.l.getFirstVisiblePosition() != 0 && this.l.getFirstVisiblePosition() + headerViewsCount >= 0) {
            i2 = this.l.getFirstVisiblePosition() + headerViewsCount;
        } else {
            i2 = 0;
        }
        View childAt = this.l.getChildAt(0);
        if (childAt != null) {
            i3 = childAt.getTop();
        } else {
            i3 = -1;
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
        if ((z2 && pbReplyTitleViewHolder != null) || i2 >= this.E.G() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i4 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), j2 - i4);
            } else {
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), this.h.p().getMeasuredHeight() - i4);
            }
        } else {
            this.l.setSelectionFromTop(i2, i3);
        }
        if (this.n1 && this.t != null) {
            this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), this.t.d());
        } else if (this.P0 != 6) {
        } else {
            this.l.setOnLayoutListener(new a(this, g1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
        }
    }

    public void g2() {
        PostData postData;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048710, this) != null) || this.c == null) {
            return;
        }
        if (!this.H1 && this.I1 != 17) {
            if (this.o1 && !this.n1 && (postData = this.O0) != null && postData.s() != null) {
                int i3 = 2;
                if (this.c.t0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.n1) {
                    i3 = 1;
                }
                q48.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.O0.s().getUserId(), this.O0.s().getUserName(), this.c.K().r1(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        px7 px7Var = this.N0;
        if (px7Var != null && px7Var.l() != null && !xi.isEmpty(this.N0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.N0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.N0.S()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.N0.l().getId()));
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                q48.r("c10517", this.j0, 2);
            } else if (!this.c.Q4()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                n85 v5 = this.c.v5();
                if (v5 != null && (v5.x() || v5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.v5().w(false, null);
                    return;
                }
                if (this.m0 != null) {
                    C1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.n(2) != null) {
                        xo8.c(this.c.getPageContext(), (View) this.m0.n(2).m, false, s2);
                    }
                }
                p1();
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
            n4();
            this.c.n6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.K() != null && this.c.K().S1() != null && this.c.K().S1().Q() != null && this.c.K().S1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.K().n2()).param("fid", this.c.K().S1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.K().b).param("fid", this.c.K().S1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void t4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && (pbFragment = this.c) != null && pbFragment.K() != null && this.c.K().G != null && this.c.K().G.Q() != null && this.c.K().G.Q().isXiuXiuThread()) {
            ThreadData Q = this.c.K().G.Q();
            int i3 = 0;
            if (this.c.K().x1()) {
                i2 = 1;
            } else if (this.c.K().A1()) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(Q.getForum_name());
            if (itemInfo != null) {
                i3 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i2).addParam("fid", Q.getFid()).addParam("fname", Q.getForum_name()).addParam("post_id", Q.getTid()).addParam("obj_id", i3).addParam("obj_name", str).eventStat();
        }
    }

    public final void D1(px7 px7Var, p15 p15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, px7Var, p15Var) == null) && this.P1 != null && px7Var != null && p15Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                w1();
                return;
            }
            if (this.O1 == null) {
                this.O1 = RightFloatLayerLottieView.F(p15Var, this.c.getContext());
                this.P1.removeAllViews();
                this.P1.addView(this.O1);
            }
            if ((this.N1.getTag() instanceof Boolean) && !((Boolean) this.N1.getTag()).booleanValue()) {
                this.O1.setAutoCompleteShown(false);
                this.O1.setTag(this.N1);
                this.O1.c();
            }
            if (p15Var.a()) {
                return;
            }
            this.O1.setData(p15Var);
            this.O1.setLogoListener(new g0(this, p15Var));
            this.O1.setFeedBackListener(new r0(this, p15Var));
        }
    }

    public void S3(mv4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, cVar, z2) == null) {
            tv4 tv4Var = this.e0;
            if (tv4Var != null) {
                tv4Var.dismiss();
                this.e0 = null;
            }
            vv4 vv4Var = new vv4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            px7 px7Var = this.N0;
            if (px7Var != null && px7Var.Q() != null && !this.N0.Q().isBjh()) {
                arrayList.add(new rv4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e2), vv4Var));
            }
            if (!z2) {
                arrayList.add(new rv4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f10e3), vv4Var));
            }
            vv4Var.j(arrayList);
            vv4Var.n(new f0(this, cVar));
            tv4 tv4Var2 = new tv4(this.c.getPageContext(), vv4Var);
            this.e0 = tv4Var2;
            tv4Var2.k();
        }
    }

    public void o2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048750, this, absListView, i2) == null) {
            n28 n28Var = this.t;
            if (n28Var != null) {
                n28Var.o(absListView, i2);
            }
            if (!this.i2 && i2 == 0) {
                this.g2 = i1();
                this.d1.c = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
                A2(this.d1.c, true);
                o0();
                this.E.g0(true);
            }
            this.E.f0();
            if (i2 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.O1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.q();
                }
            } else if (i2 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.O1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.p();
                }
            } else if (i2 == 2 && (rightFloatLayerView = this.O1) != null) {
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

    public final void D3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048591, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.K() != null && this.c.K().S1() != null && this.c.K().S1().o() != null && this.c.K().S1().l() != null && this.c.K().S1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.obfuscated_res_0x7f0920aa, Boolean.TRUE);
            }
            vp5 vp5Var = new vp5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
            vp5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
            vp5Var.h(this.c.K().S1().l().getImage_url());
            vp5Var.j(this.c.K().S1().l().getUser_level());
            O3(sparseArray, i2, vp5Var, this.c.K().S1().X(), true);
        }
    }

    public final void W3(kv4 kv4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048667, this, kv4Var, i2) == null) && (pbFragment = this.c) != null && kv4Var != null) {
            if (this.C1 == null && this.u != null) {
                this.C1 = new tp5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData g5 = this.c.g5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (g5 != null && g5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = g5.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            qt4 qt4Var = new qt4();
            qt4Var.j(sparseArray);
            this.C1.B(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0), this.c.getString(R.string.obfuscated_res_0x7f0f04d1), this.c.getString(R.string.obfuscated_res_0x7f0f04d2), this.c.getString(R.string.obfuscated_res_0x7f0f04d3)});
            this.C1.A(qt4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.C1.D(str);
            this.C1.C(new a0(this, kv4Var));
        }
    }

    public void b4(ut4 ut4Var, kv4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048688, this, ut4Var, eVar) != null) || ut4Var == null) {
            return;
        }
        int a2 = ut4Var.a();
        int h2 = ut4Var.h();
        kv4 kv4Var = this.F;
        if (kv4Var != null) {
            kv4Var.show();
        } else {
            this.F = new kv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d022d, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.dialog_ok, eVar);
            this.F.setNegativeButton(R.string.dialog_cancel, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090f61);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f09075d);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048c), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean p4(px7 px7Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048757, this, px7Var, z2)) == null) {
            if (px7Var == null) {
                return false;
            }
            if (this.v != null) {
                if (px7Var.Q() != null && px7Var.Q().getIsNoTitle() == 0 && !px7Var.Q().isVideoThreadType() && !this.Q1) {
                    if (px7Var.Q() != null) {
                        ThreadData Q = px7Var.Q();
                        Q.parserSpecTitleForFrsAndPb(true, I3(px7Var));
                        Q.setResource(3);
                        Q.setPbTitle("2");
                    }
                    if (px7Var.Q().isBJHArticleThreadType()) {
                        this.w.F(this.l);
                        this.v.h(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.K(this.N0);
                        if (J1(px7Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.i(px7Var);
                        }
                    } else {
                        this.w.K(this.N0);
                        if (J1(px7Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.k(px7Var);
                        }
                    }
                } else if (px7Var.Q().getIsNoTitle() == 1) {
                    if (px7Var.Q() != null) {
                        this.v.h(this.l);
                        this.w.K(this.N0);
                    }
                } else {
                    this.v.h(this.l);
                    this.w.K(this.N0);
                }
            }
            d4(px7Var.Z());
            e4(px7Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void E1(px7 px7Var) {
        p15 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, px7Var) != null) || px7Var == null) {
            return;
        }
        if (px7Var.r0()) {
            pbAdFloatViewItemData = px7Var.d0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            D1(px7Var, pbAdFloatViewItemData);
        } else {
            w1();
        }
    }

    public final boolean J1(px7 px7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, px7Var)) == null) {
            if (px7Var == null || px7Var.Q() == null) {
                return false;
            }
            SpannableStringBuilder span_str = px7Var.Q().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e10).equals(span_str.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean O1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        PostData Z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                px7 px7Var = this.N0;
                if (px7Var != null && (Z = px7Var.Z()) != null && Z.s() != null) {
                    str = Z.s().getUserId();
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

    public void l4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048737, this, z2) == null) {
            this.h.J(z2);
            if (z2 && this.R0) {
                this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03f9));
                this.l.setNextPage(this.K);
                this.f = 2;
            }
            V1();
        }
    }

    public final void E2(px7 px7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, px7Var) == null) && px7Var != null && px7Var.Q() != null) {
            o4(px7Var);
            ImageView imageView = this.B0;
            if (imageView != null && imageView.getContext() != null) {
                if (px7Var.r()) {
                    WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08099b, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08099a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String C0 = C0(px7Var.Q().getReply_num());
            TextView textView = this.H0;
            if (textView != null) {
                textView.setText(C0);
            }
            TextView textView2 = this.I0;
            if (textView2 != null) {
                textView2.setText(C0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, px7Var.Q()));
            D2(px7Var.Q().getAgreeData(), px7Var.Q().getAgreeNum());
            if (this.A0 != null && px7Var.Q() != null) {
                this.A0.setThreadData(px7Var.Q());
                int i2 = 1;
                if (px7Var.Q().getAgreeData() != null) {
                    px7Var.Q().getAgreeData().isInThread = true;
                }
                this.A0.setData(px7Var.Q().getAgreeData());
                zr4 zr4Var = new zr4();
                zr4Var.b = 26;
                if (px7Var.Q().isVideoThreadType() && px7Var.Q().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                zr4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.K() != null) {
                    zr4Var.j = this.c.K().getFromForumId();
                    zr4Var.f = this.c.K().R1();
                }
                this.A0.setStatisticData(zr4Var);
            }
        }
    }

    public void G1(px7 px7Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, px7Var) == null) {
            int i2 = 0;
            this.E.h0(px7Var, false);
            this.E.Z();
            s0();
            pz7 pz7Var = this.w1;
            if (pz7Var != null) {
                pz7Var.n();
            }
            ArrayList<PostData> H = px7Var.H();
            if (px7Var.z().b() == 0 || H == null || H.size() < px7Var.z().e()) {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                    if (px7Var.z().b() == 0) {
                        this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a));
                    } else {
                        this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a6e));
                    }
                    this.K.l();
                } else {
                    z0 z0Var = this.d1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            bottom = this.d1.c.getView().getHeight();
                        } else {
                            bottom = this.d1.c.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.c.S5()) {
                        this.K.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e28), i2);
                    } else {
                        this.K.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e29), i2);
                    }
                }
            }
            E2(px7Var);
        }
    }

    public void G3(px7 px7Var) {
        PostData postData;
        v38 v38Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, px7Var) == null) && px7Var != null && (postData = this.O0) != null && postData.s() != null && (v38Var = this.h) != null) {
            boolean z3 = !this.n1;
            this.o1 = z3;
            v38Var.I(z3);
            if (this.c.w5() != null) {
                this.c.w5().s(this.o1);
            }
            B2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.t0() && !ListUtils.isEmpty(px7Var.p())) {
                tu4 tu4Var = px7Var.p().get(0);
                if (tu4Var != null) {
                    this.h.M(px7Var, tu4Var.d(), tu4Var.b(), tu4Var.a(), tu4Var.e());
                }
            } else if (px7Var.l() != null) {
                v38 v38Var2 = this.h;
                String name = px7Var.l().getName();
                String id = px7Var.l().getId();
                String image_url = px7Var.l().getImage_url();
                if (px7Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                v38Var2.M(px7Var, name, id, image_url, z2);
            }
            if (this.o1) {
                this.w.P(px7Var, this.O0, this.h0);
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
            this.w.P(px7Var, this.O0, this.h0);
            this.x1 = null;
            this.l.setListViewDragListener(null);
        }
    }

    public void K3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, view2) != null) || qy4.k().h("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.t0.getGlobalVisibleRect(rect);
        int i2 = rect.bottom;
        int i3 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i4 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.t1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f044c);
        this.t1.setGravity(17);
        this.t1.setPadding(yi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, yi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = yi.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
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
        GreyUtil.grey(this.s1);
        this.l.postDelayed(new s0(this, i4, i2, i3, view2), 100L);
        qy4.k().u("show_long_press_collection_tips", true);
    }

    public void U3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onItemClickListener) == null) {
            ov4 ov4Var = this.f0;
            if (ov4Var != null) {
                ov4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList<xv4> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0276);
            boolean z5 = false;
            if (this.N0.N() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new xv4(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b76);
            if (this.N0.N() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new xv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b73);
            if (this.N0.N() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new xv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0b94);
            if (this.N0.N() == 4) {
                z5 = true;
            }
            arrayList.add(new xv4(string4, "", z5, Integer.toString(7)));
            ov4 ov4Var2 = new ov4(this.c.getPageContext());
            ov4Var2.l(R.string.obfuscated_res_0x7f0f0e30);
            this.f0 = ov4Var2;
            ov4Var2.k(arrayList, onItemClickListener);
            ov4Var2.c();
            this.f0.n();
        }
    }

    public void F2(int i2, px7 px7Var, boolean z2, int i3) {
        PostData Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), px7Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && px7Var != null && (Z = px7Var.Z()) != null && Z.s() != null) {
            MetaData s3 = Z.s();
            s3.setGiftNum(s3.getGiftNum() + i2);
        }
    }

    public void G2(px7 px7Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{px7Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            R3(px7Var, z2, i2, i3);
            this.w.C(i3);
        }
    }

    public void q2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048760, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            r2(i2, str, i3, z2, null);
        }
    }

    public final void H3(SparseArray<Object> sparseArray, @StringRes int i2, @StringRes int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048607, this, sparseArray, i2, i3) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04bb, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0377, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.P());
        tBAlertBuilder.t(i2);
        tBAlertBuilder.k(i3);
        tBAlertBuilder.m(true);
        tBAlertBuilder.r(aVar2, aVar);
        tBAlertBuilder.h(false);
        AlertDialog w2 = tBAlertBuilder.w();
        aVar.a(new w(this, w2, sparseArray));
        aVar2.a(new x(this, w2));
    }

    public final boolean I3(px7 px7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, px7Var)) == null) {
            if (px7Var == null || px7Var.Q() == null) {
                return false;
            }
            if (px7Var.Q().getIsLive() != 1 && px7Var.Q().getThreadType() != 33 && ((px7Var.Q().getTopicData() == null || px7Var.Q().getTopicData().a() == 0) && px7Var.Q().getIs_top() != 1 && px7Var.Q().getIs_good() != 1 && !px7Var.Q().isActInfo() && !px7Var.Q().isInterviewLive() && !px7Var.Q().isVoteThreadType() && px7Var.Q().getYulePostActivityData() == null && xi.isEmpty(px7Var.Q().getCategory()) && !px7Var.Q().isGodThread() && !px7Var.Q().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e2(TbRichText tbRichText) {
        px7 px7Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, tbRichText) == null) && (px7Var = this.N0) != null && px7Var.H() != null && !this.N0.H().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.N0.H().size() && (postData = this.N0.H().get(i2)) != null && postData.s() != null && !StringUtils.isNull(postData.s().getUserId()); i2++) {
                if (this.N0.H().get(i2).s().getUserId().equals(tbRichText.getAuthorId())) {
                    pz7 pz7Var = this.w1;
                    if (pz7Var != null && pz7Var.l()) {
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

    public void m4(nx7 nx7Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048742, this, nx7Var) != null) || nx7Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(nx7Var.b)) {
            this.h.G(nx7Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1420);
        int e2 = xg.e(nx7Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1398);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02fb);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1153);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02a5), true, new k0(this, nx7Var.c));
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            kv4 kv4Var = new kv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08d1, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092295);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c73)).setVisibility(8);
            kv4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(l2, Integer.valueOf(o2));
            kv4Var.setYesButtonTag(sparseArray);
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f15a3, this.c);
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new q0(this));
            kv4Var.create(this.c.getPageContext()).show();
        }
    }

    public void w2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048788, this, view2) == null) && this.A0.getData() != null && this.A0.getData().hasAgree && this.c.getActivity() != null) {
            rw7 rw7Var = new rw7(this.c.getContext());
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            rw7Var.k(g2);
            rw7Var.j(layoutParams);
            rw7Var.i(false);
            rw7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.N0.S(), this.N0.m());
            rw7Var.l(new m(this));
        }
    }

    public final void O3(SparseArray<Object> sparseArray, int i2, vp5 vp5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048635, this, new Object[]{sparseArray, Integer.valueOf(i2), vp5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.D1 == null && this.u != null) {
            this.D1 = new wp5(pbFragment.getPageContext(), this.u.c(), vp5Var, userData);
        }
        this.D1.F(z2);
        AntiData g5 = this.c.g5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (g5 != null && g5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = g5.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        qt4 qt4Var = new qt4();
        qt4Var.j(sparseArray2);
        this.D1.H(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0), this.c.getString(R.string.obfuscated_res_0x7f0f04d1), this.c.getString(R.string.obfuscated_res_0x7f0f04d2), this.c.getString(R.string.obfuscated_res_0x7f0f04d3)});
        this.D1.G(qt4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.D1.J(str);
        this.D1.I(new b0(this, sparseArray));
    }

    public void T3(mv4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            tv4 tv4Var = this.d0;
            if (tv4Var != null) {
                tv4Var.dismiss();
                this.d0 = null;
            }
            vv4 vv4Var = new vv4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new rv4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f045c), vv4Var));
            }
            if (z3) {
                arrayList.add(new rv4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f104a), vv4Var));
            } else if (!z2) {
                arrayList.add(new rv4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ac6), vv4Var));
            } else {
                arrayList.add(new rv4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1025), vv4Var));
            }
            vv4Var.j(arrayList);
            vv4Var.n(new e0(this, cVar));
            tv4 tv4Var2 = new tv4(this.c.getPageContext(), vv4Var);
            this.e0 = tv4Var2;
            tv4Var2.k();
        }
    }

    public void Q3(px7 px7Var, int i2, int i3, boolean z2, int i4, boolean z3) {
        PbLandscapeListView pbLandscapeListView;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i5;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int size;
        int i6;
        PbFragment pbFragment;
        px7 px7Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{px7Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && px7Var != null && this.l != null) {
            this.N0 = px7Var;
            this.P0 = i2;
            if (px7Var.Q() != null) {
                this.f1 = px7Var.Q().getCopyThreadRemindType();
                if (px7Var.Q().getAnchorLevel() != 0) {
                    this.b2 = true;
                }
                this.h0 = O1(px7Var.Q());
            }
            if (px7Var.X() != null) {
                this.c2 = px7Var.X().getUserId();
            }
            A1(px7Var);
            h0();
            this.R0 = false;
            this.M0 = z2;
            r3();
            yx7 yx7Var = px7Var.h;
            if (yx7Var != null && yx7Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData(px7Var);
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            R3(px7Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            G3(px7Var);
            this.w.Q(px7Var, this.O0);
            if (this.A1 == null) {
                this.A1 = new c18(this.c.getPageContext(), this.B1);
            }
            this.A1.a(px7Var.x());
            if (this.c.p5()) {
                if (this.J == null) {
                    a68 a68Var = new a68(this.c.getPageContext());
                    this.J = a68Var;
                    a68Var.n();
                    this.J.f(this.d2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                a68 a68Var2 = this.J;
                if (a68Var2 != null) {
                    a68Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (px7Var.z().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    a68 a68Var3 = new a68(this.c.getPageContext());
                    this.J = a68Var3;
                    a68Var3.n();
                    this.J.f(this.d2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                a68 a68Var4 = this.J;
                if (a68Var4 != null) {
                    a68Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                t1();
            }
            s0();
            this.E.p0(this.M0);
            this.E.m0(false);
            a08 a08Var = this.E;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            a08Var.n0(z4);
            a08 a08Var2 = this.E;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            a08Var2.o0(z5);
            a08 a08Var3 = this.E;
            if (z3 && this.Z1 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            a08Var3.k0(z6);
            this.E.h0(px7Var, false);
            this.E.Z();
            a08 a08Var4 = this.E;
            if (px7Var.z().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            a08Var4.b0(z7, px7Var.g());
            this.w.O(px7Var.Z(), px7Var.l0());
            if (px7Var.Q() != null && px7Var.Q().getPraise() != null && this.b != -1) {
                px7Var.Q().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.a1);
            this.l.addFooterView(this.a1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                t1();
            } else {
                this.R0 = true;
                if (px7Var.z().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new w58(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList<PostData> H = px7Var.H();
            if (px7Var.z().b() != 0 && H != null && H.size() >= px7Var.z().e()) {
                if (z3) {
                    if (this.Z1) {
                        x0();
                        if (px7Var.z().b() != 0) {
                            this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e21));
                        }
                    } else {
                        this.K.B();
                        this.K.P();
                    }
                } else {
                    this.K.B();
                    this.K.P();
                }
                this.K.l();
            } else {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                    if (px7Var.z().b() == 0) {
                        this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a1a));
                    } else {
                        this.K.E(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a6e));
                    }
                    this.K.l();
                } else {
                    z0 z0Var = this.d1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            i5 = this.d1.c.getView().getHeight();
                        } else {
                            i5 = this.d1.c.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.S5()) {
                        this.K.w(false);
                        if (ListUtils.isEmpty(px7Var.T())) {
                            this.K.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e28), i5);
                        }
                    } else if (ListUtils.isEmpty(px7Var.T())) {
                        this.K.H(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e29), i5);
                    }
                    if (this.c.w5() != null && !this.c.w5().p()) {
                        this.c.w5().x();
                    }
                }
                if (px7Var.z().b() == 0 || H == null) {
                    I2();
                }
            }
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            if (i2 != 6) {
                                if (i2 == 8) {
                                    if (i3 == 0) {
                                        n28 n28Var = this.t;
                                        if (n28Var != null && n28Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - yi.u(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(px7Var.T())) {
                                        if (this.l.getData() == null && px7Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - px7Var.H().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = i3 + size2;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(px7Var.H().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.f();
                                    this.K.E(this.c.getString(R.string.obfuscated_res_0x7f0f0e22));
                                    this.K.z();
                                }
                            } else if (i4 == 1 && (e3 = i18.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.Z1 = false;
                    }
                } else if (i4 == 1 && (e2 = i18.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new l0(this, e2, H, px7Var));
                }
            } else {
                if (this.l.getData() == null && px7Var.H() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - px7Var.H().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (i3 + size) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.f1 == k2 && N1()) {
                m0();
            }
            if (this.l1) {
                C2();
                this.l1 = false;
                if (i4 == 0) {
                    g3(true);
                }
            }
            if (px7Var.d == 1 || px7Var.e == 1) {
                if (this.r1 == null) {
                    this.r1 = new PbTopTipView(this.c.getContext());
                }
                if (px7Var.e == 1 && "game_guide".equals(this.c.B5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e34));
                    this.r1.l(this.d, this.Q0);
                } else if (px7Var.d == 1 && "game_news".equals(this.c.B5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e33));
                    this.r1.l(this.d, this.Q0);
                }
            }
            this.l.removeFooterView(this.L1.a());
            if (!ListUtils.isEmpty(px7Var.K()) && px7Var.z().b() == 0) {
                this.l.removeFooterView(this.a1);
                this.L1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
                this.l.addFooterView(this.L1.a());
                this.L1.f(px7Var);
            }
            E2(px7Var);
            if (px7Var.j0() && this.c.K().H2() && this.c.x5() != null) {
                this.c.x5().d();
            }
            if (px7Var.g() != 3) {
                E1(px7Var);
            }
            this.x0.setText(TbSingleton.getInstance().getAdVertiComment(px7Var.r0(), px7Var.s0(), f1()));
            if (this.p != null && (px7Var2 = this.N0) != null && px7Var2.l() != null) {
                this.p.m(this.N0.l().getImage_url());
                this.p.n(this.N0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.K() != null) {
                    this.p.o(this.c.K().b);
                }
            }
            if (this.r != null) {
                px7 px7Var3 = this.N0;
                if (px7Var3 != null && px7Var3.l() != null && (pbFragment = this.c) != null && pbFragment.K() != null) {
                    this.r.q(this.c.K().b);
                }
                px7 px7Var4 = this.N0;
                if (px7Var4 != null && px7Var4.Q() != null && !ListUtils.isEmpty(this.N0.Q().getThreadRecommendInfoDataList())) {
                    this.r.p(this.N0.Q().getThreadRecommendInfoDataList().get(0));
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void R3(px7 px7Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{px7Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && px7Var != null && px7Var.Q() != null) {
            if (this.c.t0()) {
                if (px7Var.h() != null) {
                    this.i0 = px7Var.h().d();
                    this.j0 = px7Var.h().b();
                }
                if (this.i0 == null && this.c.K() != null && this.c.K().r1() != null) {
                    this.i0 = this.c.K().r1();
                }
            }
            PostData Z = px7Var.Z();
            p3(Z, px7Var);
            int i4 = 8;
            this.w.L(8);
            int i5 = 1;
            if (px7Var.y0()) {
                this.n1 = true;
                this.h.B(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new n28(this.c);
                }
                this.t.v(px7Var, Z, this.l, this.w, this.U0, this.h, this.i0, this.G1);
                this.t.s(this.a2);
                O2();
            } else {
                this.n1 = false;
                this.h.B(false);
                n28 n28Var = this.t;
                if (n28Var != null) {
                    n28Var.p(this.l);
                }
            }
            if (this.c.w5() != null) {
                this.c.w5().w(this.n1);
            }
            if (Z == null) {
                return;
            }
            this.O0 = Z;
            this.w.L(0);
            SparseArray<Object> w2 = this.w.w();
            w2.put(R.id.obfuscated_res_0x7f092094, Z);
            w2.put(R.id.obfuscated_res_0x7f0920ad, Boolean.FALSE);
            this.x.e(px7Var, this.l);
            this.z.e(px7Var, this.I1, new i0(this));
            this.v.j(px7Var);
            this.u.h(px7Var, this.M0);
            this.u.g(px7Var);
            this.w.M(this.Q0, this.N0, Z, this.a2);
            if (this.Z0 != null) {
                if (px7Var.l0()) {
                    this.Z0.getView().setVisibility(8);
                } else {
                    this.Z0.getView().setVisibility(0);
                    cy7 cy7Var = new cy7(cy7.i);
                    if (px7Var.Q() != null) {
                        px7Var.Q().getReply_num();
                    }
                    cy7Var.c = px7Var.g;
                    px7Var.c();
                    cy7Var.d = this.c.S5();
                    cy7Var.g = px7Var.f;
                    cy7Var.h = px7Var.Q().isQuestionThread();
                    this.Z0.h(cy7Var);
                }
            }
            d4(Z);
            e4(px7Var);
            ah.a().post(new j0(this));
            this.y.f(this.l);
            if (Z.S) {
                this.y.g(Z.M());
                if (this.l.getHeaderViewsCount() <= 1) {
                    i5 = 0;
                }
                this.y.c(this.l, i5);
            }
            a08 a08Var = this.E;
            if (a08Var != null && a08Var.z() != null) {
                this.E.z().G(Z.S);
            }
            a08 a08Var2 = this.E;
            if (a08Var2 != null) {
                a08Var2.s0(Z.S);
            }
            MaskView maskView = this.M1;
            if (Z.S) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public SparseArray<Object> U0(px7 px7Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Z;
        boolean z3;
        ys4 ys4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{px7Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (px7Var == null || (Z = px7Var.Z()) == null) {
                return null;
            }
            String userId = Z.s().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.obfuscated_res_0x7f092096, Z.M());
                sparseArray.put(R.id.obfuscated_res_0x7f092098, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(px7Var.Y()));
                sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Z.s() != null) {
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a1, Z.s().getUserName());
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a2, Z.s().getName_show());
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a3, Z.s().getPortrait());
                    sparseArray.put(R.id.obfuscated_res_0x7f0920a4, Z.M());
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092096, Z.M());
                sparseArray.put(R.id.obfuscated_res_0x7f092098, 0);
                sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(px7Var.Y()));
                sparseArray.put(R.id.obfuscated_res_0x7f0920dd, Boolean.TRUE);
            }
            if (!z3) {
                List<tu4> p3 = px7Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (tu4 tu4Var : p3) {
                        if (tu4Var != null && !StringUtils.isNull(tu4Var.d()) && (ys4Var = tu4Var.f) != null && ys4Var.a && !ys4Var.c && ((i3 = ys4Var.b) == 1 || i3 == 2)) {
                            sb.append(xi.cutString(tu4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f067b));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092095, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04b3), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void W1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (pbFragment = this.c) != null && pbFragment.K() != null && this.c.K().G != null && this.c.K().G.Q() != null && this.c.K().G.Q().isQuestionThread()) {
            ThreadData Q = this.c.K().G.Q();
            String e2 = this.c.K().e2();
            String f2 = this.c.K().f2();
            int i2 = 5;
            if ("question_answer_invite".equals(e2)) {
                i2 = 1;
            } else if ("3".equals(f2)) {
                i2 = 2;
            } else if ("answer_top".equals(e2)) {
                i2 = 3;
            } else if (this.c.K().x1()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i2));
        }
    }

    public void d2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            q08 q08Var = this.p;
            if (q08Var != null) {
                q08Var.l();
            }
            p18 p18Var = this.r;
            if (p18Var != null) {
                p18Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            z58 z58Var = this.F0;
            if (z58Var != null) {
                z58Var.k();
            }
            l18 l18Var = this.k1;
            if (l18Var != null) {
                l18Var.a();
            }
            c18 c18Var = this.A1;
            if (c18Var != null) {
                c18Var.c();
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
            xo8.d();
            p0();
            x0();
            if (this.h1 != null) {
                ah.a().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            this.V1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            n28 n28Var = this.t;
            if (n28Var != null) {
                n28Var.a();
            }
            a08 a08Var = this.E;
            if (a08Var != null) {
                a08Var.c0();
            }
            this.l.setOnLayoutListener(null);
            s28 s28Var = this.v1;
            if (s28Var != null) {
                s28Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            m28 m28Var = this.w;
            if (m28Var != null) {
                m28Var.D();
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
            }
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && !this.h2) {
            TiebaStatic.log("c10490");
            this.h2 = true;
            kv4 kv4Var = new kv4(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(l2, Integer.valueOf(n2));
            kv4Var.setTitle(R.string.obfuscated_res_0x7f0f081c);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08d1, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c73)).setText(R.string.obfuscated_res_0x7f0f07b5);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092295)).setText(R.string.obfuscated_res_0x7f0f081c);
            kv4Var.setContentView(inflate);
            kv4Var.setYesButtonTag(sparseArray);
            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f081b, this.c);
            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0aa0, new p0(this));
            kv4Var.create(this.c.getPageContext()).show();
        }
    }

    public final void z3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048801, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
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
                int g2 = yi.g(this.c.getActivity(), R.dimen.tbds166);
                int i2 = ((rect2.right + rect2.left) / 2) - g2;
                int i3 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g2;
                int i4 = g2 * 2;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
                layoutParams.addRule(12, -1);
                layoutParams.setMargins(i2, 0, 0, i3);
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

    public void b2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048686, this, i2) != null) || this.Q0 == i2) {
            return;
        }
        this.Q0 = i2;
        f4(this.N0, this.M0);
        G2(this.N0, this.M0, this.P0, i2);
        sq4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        n28 n28Var = this.t;
        if (n28Var != null) {
            n28Var.h(i2);
        }
        j28 j28Var = this.x;
        if (j28Var != null) {
            j28Var.c(i2);
        }
        i28 i28Var = this.u;
        if (i28Var != null) {
            i28Var.e(i2);
        }
        k28 k28Var = this.v;
        if (k28Var != null) {
            k28Var.g(i2);
        }
        m28 m28Var = this.w;
        if (m28Var != null) {
            m28Var.C(i2);
        }
        l28 l28Var = this.y;
        if (l28Var != null) {
            l28Var.e();
        }
        h28 h28Var = this.z;
        if (h28Var != null) {
            h28Var.c();
        }
        MaskView maskView = this.M1;
        if (maskView != null) {
            maskView.f();
        }
        p18 p18Var = this.r;
        if (p18Var != null) {
            p18Var.n();
        }
        PbListView pbListView = this.K;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (this.M != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.M);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        kv4 kv4Var = this.F;
        if (kv4Var != null) {
            kv4Var.autoChangeSkinType(this.c.getPageContext());
        }
        k4(this.g0);
        this.E.Z();
        a68 a68Var = this.J;
        if (a68Var != null) {
            a68Var.H(i2);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.w(i2);
        }
        w58 w58Var = this.L;
        if (w58Var != null) {
            w58Var.f(i2);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        q4();
        UtilHelper.setStatusBarBackground(this.e, i2);
        UtilHelper.setStatusBarBackground(this.Y0, i2);
        if (this.A != null) {
            qf5.a(this.c.getPageContext(), this.A);
        }
        m08 m08Var = this.j1;
        if (m08Var != null) {
            m08Var.h(i2);
        }
        v38 v38Var = this.h;
        if (v38Var != null) {
            n28 n28Var2 = this.t;
            if (n28Var2 != null) {
                n28Var2.i(i2);
            } else {
                v38Var.v(i2);
            }
        }
        HeadImageView headImageView = this.v0;
        if (headImageView != null) {
            headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
        LinearLayout linearLayout = this.u0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(yi.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        px7 px7Var = this.N0;
        if (px7Var != null && px7Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08099b, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.obfuscated_res_0x7f08099a, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.obfuscated_res_0x7f08099d, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.obfuscated_res_0x7f0809d8, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        o4(this.N0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i2));
        }
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.t1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.I0, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.t();
            this.A0.M(i2);
            AgreeData data = this.A0.getData();
            if (data != null) {
                D2(data, data.agreeNum);
            }
        }
        pz7 pz7Var = this.w1;
        if (pz7Var != null) {
            pz7Var.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        z58 z58Var = this.F0;
        if (z58Var != null) {
            z58Var.j();
        }
        y58 y58Var = this.L1;
        if (y58Var != null) {
            y58Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.O1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.obfuscated_res_0x7f092469), (int) R.color.CAM_X0105);
    }

    public final boolean d0(AbsListView absListView, int i2) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048693, this, absListView, i2)) == null) {
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

    public final CustomBlueCheckRadioButton l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048733, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, yi.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
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

    public void n2(AbsListView absListView, int i2, int i3, int i4) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        m28 m28Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048745, this, absListView, i2, i3, i4) == null) {
            p08 p08Var = this.q;
            if (p08Var != null) {
                p08Var.c(i2, i3);
            }
            o18 o18Var = this.s;
            if (o18Var != null) {
                o18Var.c(i2, i3);
            }
            n28 n28Var = this.t;
            if (n28Var != null) {
                n28Var.n(absListView, i2, i3, i4);
            }
            v38 v38Var = this.h;
            if (v38Var != null && (m28Var = this.w) != null) {
                v38Var.x(m28Var.u());
            }
            z2();
            z0 z0Var = this.d1;
            z0Var.a = i2;
            z0Var.b = this.l.getHeaderViewsCount();
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            E3(d0(absListView, i2));
            int i5 = 0;
            A2(this.d1.c, false);
            o0();
            if (this.K.o() && !this.K.C) {
                z0 z0Var2 = this.d1;
                if (z0Var2 != null && (pbReplyTitleViewHolder = z0Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.d1.c.getView().getTop() < 0) {
                        bottom = this.d1.c.getView().getHeight();
                    } else {
                        bottom = this.d1.c.getView().getBottom();
                    }
                    i5 = bottom;
                }
                this.K.e(i5);
                this.K.C = true;
            }
        }
    }

    public void p2(ArrayList<gt4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01e7, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a8);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.obfuscated_res_0x7f090d08);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new c0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.obfuscated_res_0x7f090d07);
                TextView textView = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907d0);
                this.b0 = textView;
                textView.setOnClickListener(new d0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.obfuscated_res_0x7f0907d1);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton l02 = l0("0", this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1425));
            this.n.add(l02);
            l02.setChecked(true);
            this.Y.addView(l02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    gt4 gt4Var = arrayList.get(i2);
                    if (gt4Var != null && !TextUtils.isEmpty(gt4Var.b()) && gt4Var.a() > 0) {
                        CustomBlueCheckRadioButton l03 = l0(String.valueOf(gt4Var.a()), gt4Var.b());
                        this.n.add(l03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
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
                        layoutParams2.height = yi.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = yi.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = yi.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.l0.setLayoutParams(layoutParams2);
                this.l0.removeAllViews();
                LinearLayout linearLayout = this.Y;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.l0.addView(this.Y);
                }
            }
            ch.j(this.W, this.c.getPageContext());
        }
    }

    public void r2(int i2, String str, int i3, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048765, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2}) == null) {
            s2(i2, str, i3, z2, str2, false);
        }
    }

    public void s2(int i2, String str, int i3, boolean z2, String str2, boolean z3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048770, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z2));
            sparseArray.put(l2, Integer.valueOf(m2));
            if (i3 == 1002 && !z2) {
                i4 = R.string.obfuscated_res_0x7f0f1047;
            } else {
                i4 = R.string.obfuscated_res_0x7f0f04b0;
            }
            int i5 = R.string.obfuscated_res_0x7f0f0448;
            if (i2 == 0) {
                if (i3 == 1002 && !z2) {
                    i4 = R.string.obfuscated_res_0x7f0f104b;
                } else {
                    i5 = R.string.obfuscated_res_0x7f0f04b4;
                    i4 = R.string.obfuscated_res_0x7f0f04b5;
                }
            }
            this.U = new kv4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i4);
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
                H3(sparseArray, i5, i4);
            } else if (z2) {
                H3(sparseArray, i5, i4);
            } else if (y3()) {
                vp5 vp5Var = new vp5(this.c.K().S1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.K().S1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.K().S1().o().has_forum_rule.intValue());
                vp5Var.i(this.c.K().S1().l().getId(), this.c.K().S1().l().getName());
                vp5Var.h(this.c.K().S1().l().getImage_url());
                vp5Var.j(this.c.K().S1().l().getUser_level());
                O3(sparseArray, i2, vp5Var, this.c.K().S1().X(), false);
            } else {
                W3(this.U, i2);
            }
        }
    }

    public void t2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048775, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.obfuscated_res_0x7f092096, str);
            sparseArray.put(R.id.obfuscated_res_0x7f092098, Integer.valueOf(i2));
            sparseArray.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(i3));
            sparseArray.put(R.id.obfuscated_res_0x7f092097, Boolean.valueOf(z2));
            sparseArray.put(l2, Integer.valueOf(m2));
            if (z2) {
                C3(sparseArray);
            } else {
                D3(i2, sparseArray);
            }
        }
    }

    public void z0(int i2, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048798, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f1276));
            } else if (z3) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c81);
                }
                this.c.showToast(str);
            }
        }
    }
}
