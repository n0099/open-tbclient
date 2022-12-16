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
import com.baidu.tieba.g48;
import com.baidu.tieba.h18;
import com.baidu.tieba.h38;
import com.baidu.tieba.jz7;
import com.baidu.tieba.lv4;
import com.baidu.tieba.nv4;
import com.baidu.tieba.oq5;
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
import com.baidu.tieba.rq5;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.wr8;
import com.baidu.tieba.wv4;
import com.baidu.tieba.z48;
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
/* loaded from: classes5.dex */
public class l48 {
    public static /* synthetic */ Interceptable $ic;
    public static final int k2;
    public static int l2;
    public static int m2;
    public static int n2;
    public static int o2;
    public static int p2;
    public static int q2;
    public static final int r2;
    public static int s2;
    public static wr8.f t2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public u38 A1;
    public TextView B;
    public ImageView B0;
    public NavigationBarCoverTip B1;
    public TextView C;
    public ImageView C0;
    public oq5 C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public rq5 D1;
    public s28 E;
    public View E0;
    public String E1;
    public lv4 F;
    public r88 F0;
    public PermissionJudgePolicy F1;
    public nv4 G;
    public TextView G0;
    public long G1;
    public View H;
    public TextView H0;
    public boolean H1;
    public EditText I;
    public TextView I0;
    public int I1;
    public s88 J;
    public boolean J0;
    public int J1;
    public PbListView K;
    public int K0;
    public boolean K1;
    public o88 L;
    public uy4 L0;
    public q88 L1;
    public View M;
    public boolean M0;
    public MaskView M1;
    public View N;
    public h08 N0;
    public final FallingView N1;
    public View O;
    public PostData O0;
    public RightFloatLayerView O1;
    public View.OnClickListener P;
    public int P0;
    public final FrameLayout P1;
    public TbRichTextView.y Q;
    public int Q0;
    public CustomMessageListener Q1;
    public NoNetworkView.b R;
    public boolean R0;
    public boolean R1;
    public uv4 S;
    public ViewStub S0;
    public String S1;
    public View.OnClickListener T;
    public PbInterviewStatusView T0;
    public CustomMessageListener T1;
    public lv4 U;
    public FrameLayout U0;
    public View.OnClickListener U1;
    public Dialog V;
    public TextView V0;
    public CustomMessageListener V1;
    public Dialog W;
    public View W0;
    public Handler W1;
    public View X;
    public View X0;
    public Runnable X1;
    public LinearLayout Y;
    public View Y0;
    public CustomMessageListener Y1;
    public CompoundButton.OnCheckedChangeListener Z;
    public PbReplyTitleViewHolder Z0;
    public PbFragment.h3 Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public TextView a0;
    public View a1;
    public boolean a2;
    public int b;
    public TextView b0;
    public int b1;
    public View.OnClickListener b2;
    public PbFragment c;
    public String c0;
    public boolean c1;
    public boolean c2;
    public RelativeLayout d;
    public uv4 d0;
    public a1 d1;
    public String d2;
    public View e;
    public uv4 e0;
    public PbEmotionBar e1;
    public az4.g e2;
    public int f;
    public pv4 f0;
    public int f1;
    public View.OnClickListener f2;
    public final Handler g;
    public boolean g0;
    public int g1;
    public final List<TbImageView> g2;
    public final n68 h;
    public boolean h0;
    public Runnable h1;
    public int h2;
    public m68 i;
    public String i0;
    public PbFakeFloorModel i1;
    public boolean i2;
    public ViewStub j;
    public String j0;
    public e38 j1;
    public boolean j2;
    public ViewStub k;
    public j18 k0;
    public d48 k1;
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
    public i38 p;
    public View p0;
    public boolean p1;
    public h38 q;
    public EjectionAnimationView q0;
    public int q1;
    public h48 r;
    public Button r0;
    public PbTopTipView r1;
    public g48 s;
    public View s0;
    public PopupWindow s1;
    public f58 t;
    public View t0;
    public TextView t1;
    public a58 u;
    public LinearLayout u0;
    public List<String> u1;
    public c58 v;
    public HeadImageView v0;
    public k58 v1;
    public e58 w;
    public ImageView w0;
    public h28 w1;
    public b58 x;
    public TextView x0;
    public PbLandscapeListView.c x1;
    public d58 y;
    public WaterRippleView y0;
    public boolean y1;
    public z48 z;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? R.id.obfuscated_res_0x7f091cd6 : invokeV.intValue;
    }

    public void h3(PbFragment.i3 i3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, i3Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AgreeView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* loaded from: classes5.dex */
        public class a implements j65 {
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

            @Override // com.baidu.tieba.j65
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

        public c(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.g
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.z3();
            l65.g().c(new a(this));
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

    /* loaded from: classes5.dex */
    public class j implements h38.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* loaded from: classes5.dex */
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

        public j(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.h38.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements PbLandscapeListView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbReplyTitleViewHolder b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ l48 g;

        /* loaded from: classes5.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.a1 != null && this.a.g.a1.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.a1.getLayoutParams();
                    layoutParams.height = this.a.g.g1;
                    this.a.g.a1.setLayoutParams(layoutParams);
                }
            }
        }

        public l(l48 l48Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = l48Var;
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
                                if (this.g.l != null) {
                                    this.g.l.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.g1;
                    } else {
                        layoutParams.height = this.g.g1;
                    }
                    this.g.a1.setLayoutParams(layoutParams);
                    ah.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements g48.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m a;

            public a(m mVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = mVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null) {
                    this.a.a.r.r();
                }
            }
        }

        public m(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.g48.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.x6() && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p0 a;

            public a(p0 p0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {p0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = p0Var;
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

        public p0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public a(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public a0(l48 l48Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public static class a1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public PbReplyTitleViewHolder c;

        public a1() {
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

    /* loaded from: classes5.dex */
    public class b implements g18 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        @Override // com.baidu.tieba.g18
        public /* synthetic */ void onStart() {
            f18.a(this);
        }

        public b(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.g18
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.q0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements oq5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv4 a;
        public final /* synthetic */ l48 b;

        public b0(l48 l48Var, lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, lv4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = lv4Var;
        }

        @Override // com.baidu.tieba.oq5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.g5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements rq5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ l48 b;

        public c0(l48 l48Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.rq5.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.f5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public d(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A0 != null && this.a.A0.getData() != null) {
                l48 l48Var = this.a;
                l48Var.D2(l48Var.A0.getData(), this.a.A0.getData().agreeNum);
                if (!this.a.A0.H()) {
                    l48 l48Var2 = this.a;
                    l48Var2.w2(l48Var2.A0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public d0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public e(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.x1()) {
                        return;
                    }
                    ry4.l().v("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public e0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.W instanceof Dialog)) {
                ch.b(this.a.W, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public f(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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
                    this.a.c.W4(sparseArray);
                    return;
                }
                this.a.v2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.W4(sparseArray);
            } else if (z3) {
                this.a.q2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4.c a;
        public final /* synthetic */ l48 b;

        public f0(l48 l48Var, nv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public g(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g0 implements wr8.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.wr8.f
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

    /* loaded from: classes5.dex */
    public class h implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public h(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.i1.X(postData);
                this.a.E.Z();
                this.a.j1.g();
                this.a.m0.r();
                this.a.F3(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nv4.c a;
        public final /* synthetic */ l48 b;

        public h0(l48 l48Var, nv4.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.b.e0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements FallingView.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public i(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public i0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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
                if (this.a.c.R() != null) {
                    this.a.c.R().d.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements z48.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public j0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.z48.a
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

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(l48 l48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i)};
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
            this.a = l48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.d1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public k0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            l48 l48Var;
            n68 n68Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (n68Var = (l48Var = this.a).h) != null && n68Var.i != null && l48Var.N0 != null && this.a.N0.Q() != null && !this.a.N0.Q().isVideoThreadType() && !this.a.Q1() && this.a.N0.l() != null && !xi.isEmpty(this.a.N0.l().getName())) {
                if ((this.a.E.I() == null || !this.a.E.I().isShown()) && (linearLayout = this.a.h.i) != null) {
                    linearLayout.setVisibility(0);
                    if (this.a.c != null && this.a.c.M() != null) {
                        StatisticItem statisticItem = new StatisticItem("c13400");
                        statisticItem.param("tid", this.a.c.M().F1());
                        statisticItem.param("fid", this.a.c.M().getForumId());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ l48 b;

        public l0(l48 l48Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
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
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0cb8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ h08 c;
        public final /* synthetic */ l48 d;

        public m0(l48 l48Var, Parcelable parcelable, ArrayList arrayList, h08 h08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, parcelable, arrayList, h08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = l48Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = h08Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.l.onRestoreInstanceState(this.a);
                if (ListUtils.getCount(this.b) > 1 && this.c.z().b() > 0) {
                    this.d.K.g();
                    this.d.K.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e59));
                    this.d.K.A();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public n(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    ry4.l().v("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public n0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class o implements jz7.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public o(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.jz7.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.S();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public o0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                this.a.p0();
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(l48 l48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i)};
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
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public q(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class q0 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(l48 l48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i)};
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
            this.a = l48Var;
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

    /* loaded from: classes5.dex */
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p15 a;
        public final /* synthetic */ l48 b;

        public r0(l48 l48Var, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, p15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
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

    /* loaded from: classes5.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public s(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s0 implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public s0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements n65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public t(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.n65
        public void A(m65 m65Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m65Var) == null) {
                Object obj = m65Var.c;
                if ((obj instanceof g25) && EmotionGroupType.isSendAsPic(((g25) obj).getType())) {
                    if (this.a.F1 == null) {
                        this.a.F1 = new PermissionJudgePolicy();
                    }
                    this.a.F1.clearRequestPermissionList();
                    this.a.F1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.F1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    g25 g25Var = (g25) m65Var.c;
                    this.a.c.C5().f(g25Var);
                    if (g25Var.i()) {
                        this.a.c.C5().G(null, null);
                    } else {
                        this.a.c.C5().w(false, null);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ View d;
        public final /* synthetic */ l48 e;

        public t0(l48 l48Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l48Var;
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

    /* loaded from: classes5.dex */
    public class u implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public u(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.I0 != null && this.a.c.I0.e() != null) {
                if (!this.a.c.I0.e().e()) {
                    this.a.c.I0.a(false);
                }
                this.a.c.I0.e().l(false);
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
                    l48 l48Var = this.a;
                    l48Var.v1 = new k58(l48Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.u1)) {
                        this.a.v1.q(this.a.u1);
                    }
                    this.a.v1.r(this.a.m0);
                }
                this.a.v1.p(substring);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u0 implements FallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public u0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.pb.view.FallingView.q
        public void onClick() {
            String f1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.M() != null && this.a.c.M().T1()) {
                    f1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    f1 = this.a.f1();
                }
                if (!StringUtils.isNull(f1) && this.a.N0 != null) {
                    f1 = TbSingleton.getInstance().getAdVertiComment(this.a.N0.r0(), this.a.N0.s0(), f1);
                }
                if (this.a.c != null && this.a.c.C5() != null) {
                    this.a.c.C5().c0(f1);
                }
                if (this.a.x0 != null) {
                    this.a.x0.setText(f1);
                }
                this.a.F3(false);
                this.a.Z3();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ l48 b;

        public v(l48 l48Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.wv4.e
        public void n0(wv4 wv4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, wv4Var, i, view2) == null) {
                this.b.S.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.q2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.Z1 != null) {
                            this.b.Z1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.O5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
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

    /* loaded from: classes5.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p15 a;
        public final /* synthetic */ l48 b;

        public v0(l48 l48Var, p15 p15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, p15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
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

    /* loaded from: classes5.dex */
    public class w implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public w(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w0(l48 l48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, Integer.valueOf(i)};
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
            this.a = l48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921306) {
                return;
            }
            this.a.S1 = null;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ l48 c;

        public x(l48 l48Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l48Var;
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
                    yi.P(this.c.c.R(), R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    this.c.c.f5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ l48 b;

        public x0(l48 l48Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l48Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.K1 || this.a == null || this.b.c.M() == null || !this.b.c.M().W1()) {
                return;
            }
            this.b.K1 = true;
            this.a.U4(false);
        }
    }

    /* loaded from: classes5.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public y(l48 l48Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, alertDialog};
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

    /* loaded from: classes5.dex */
    public class y0 implements h18.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l48 a;

        public y0(l48 l48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l48Var;
        }

        @Override // com.baidu.tieba.h18.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.R5();
            }
        }

        @Override // com.baidu.tieba.h18.b
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

    /* loaded from: classes5.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ l48 c;

        public z(l48 l48Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l48Var;
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
                    yi.P(this.c.c.R(), R.string.obfuscated_res_0x7f0f0cb8);
                } else {
                    this.c.c.f5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyPrivacyCheckController a;
        public final /* synthetic */ o85 b;
        public final /* synthetic */ l48 c;

        public z0(l48 l48Var, ReplyPrivacyCheckController replyPrivacyCheckController, o85 o85Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l48Var, replyPrivacyCheckController, o85Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l48Var;
            this.a = replyPrivacyCheckController;
            this.b = o85Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a != null && this.c.c != null && this.c.c.n5() != null && !this.a.checkPrivacyBeforeInvokeEditor(this.c.c.n5().replyPrivateFlag)) {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947893017, "Lcom/baidu/tieba/l48;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947893017, "Lcom/baidu/tieba/l48;");
                return;
            }
        }
        k2 = UtilHelper.getLightStatusBarHeight();
        l2 = 3;
        m2 = 0;
        n2 = 3;
        o2 = 4;
        p2 = 5;
        q2 = 6;
        r2 = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        s2 = 1;
        t2 = new g0();
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
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && TbadkCoreApplication.isLogin() && this.N0 != null && this.o1 && !this.n1 && !this.h0 && (postData = this.O0) != null && postData.r() != null && !this.O0.r().getIsLike() && !this.O0.r().hadConcerned() && this.k1 == null) {
            this.k1 = new d48(this.c);
        }
    }

    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048720, this) == null) {
            j4();
            this.E.a0(1);
            f58 f58Var = this.t;
            if (f58Var != null) {
                f58Var.l();
            }
            i38 i38Var = this.p;
            if (i38Var != null) {
                i38Var.k();
            }
            h48 h48Var = this.r;
            if (h48Var != null) {
                h48Var.j();
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
            f58 f58Var = this.t;
            if (f58Var != null) {
                f58Var.m();
                if (!TbSingleton.getInstance().isNotchScreen(this.c.getFragmentActivity()) && !TbSingleton.getInstance().isCutoutScreen(this.c.getFragmentActivity())) {
                    n1().setSystemUiVisibility(4);
                }
            }
            m2();
            W1();
            t4();
        }
    }

    public l48(PbFragment pbFragment, View.OnClickListener onClickListener, j18 j18Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, j18Var};
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
        this.d1 = new a1();
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
        this.Q1 = new k(this, 2921757);
        this.T1 = new w0(this, 2921306);
        this.U1 = new n(this);
        this.V1 = new p(this, 2005016);
        this.W1 = new Handler();
        this.Y1 = new r(this, 2004009);
        this.a2 = true;
        this.b2 = new i0(this);
        this.c2 = false;
        this.d2 = null;
        this.g2 = new ArrayList();
        this.i2 = false;
        this.G1 = System.currentTimeMillis();
        this.c = pbFragment;
        this.P = onClickListener;
        this.k0 = j18Var;
        this.q1 = yi.l(pbFragment.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0667, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.o0 = this.d.findViewById(R.id.obfuscated_res_0x7f090410);
        this.B1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091901);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f092046);
        this.P1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091cf8);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092308);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        this.l = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f09172f);
        this.U0 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091d34);
        this.V0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + yi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070306));
        this.l.setOverScrollMode(2);
        this.l.x(this.V0, 0);
        this.l.setTextViewAdded(true);
        this.g1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.a1 = new View(this.c.getPageContext().getPageActivity());
        if (fp5.a()) {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.a1.setLayoutParams(new AbsListView.LayoutParams(-1, this.g1));
        }
        MessageManager.getInstance().registerListener(this.Q1);
        this.a1.setVisibility(4);
        this.l.addFooterView(this.a1);
        this.l.setOnTouchListener(this.c.M2);
        this.a = new x0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new n68(pbFragment, this.d);
        if (this.c.w5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091540);
            this.j = viewStub;
            viewStub.setVisibility(0);
            m68 m68Var = new m68(pbFragment);
            this.i = m68Var;
            m68Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = yi.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07023c);
        }
        this.V0.setLayoutParams(layoutParams);
        this.h.p().setOnTouchListener(new h18(new y0(this)));
        this.s0 = this.d.findViewById(R.id.obfuscated_res_0x7f09266f);
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f09189a);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.K0 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070284);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0908bd);
        this.w0.setOnClickListener(new z0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.C5()));
        V1();
        w0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09189d);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091895);
        this.u0 = linearLayout;
        linearLayout.setOnClickListener(new a(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0908c1);
        this.q0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new b(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09189b);
        this.M1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f091897);
        this.A0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.A0.u();
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
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091899);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0918a0);
        this.E0 = findViewById;
        if (!ry4.l().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        findViewById.setVisibility(i2);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09189e);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09189f);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.U1);
        this.C0.setOnClickListener(new e(this));
        Y1();
        r88 r88Var = new r88(this.C0);
        this.F0 = r88Var;
        r88Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09189c);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091898);
        this.S0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f090fff);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.u = new a58(this.c, j18Var);
        this.w = new e58(this.c, j18Var, this.P);
        s28 s28Var = new s28(this.c, this.l);
        this.E = s28Var;
        s28Var.y0(this.P);
        this.E.A0(this.k0);
        this.E.v0(this.Q);
        this.E.x0(this.c.j2);
        this.E.r0(this.f2);
        f fVar = new f(this);
        this.T = fVar;
        this.E.t0(fVar);
        F1();
        z1();
        d58 d58Var = new d58(this.c);
        this.y = d58Var;
        d58Var.f = 2;
        y1();
        this.z.a(this.l);
        this.w.n(this.l);
        this.v.a(this.l);
        this.u.a(this.l);
        PbListView pbListView = new PbListView(this.c.getPageContext().getPageActivity());
        this.K = pbListView;
        this.M = pbListView.c().findViewById(R.id.pb_more_view);
        this.N = this.K.c().findViewById(R.id.pb_check_more);
        if (!this.K.j().booleanValue()) {
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
        this.K.C();
        this.K.q(R.drawable.pb_foot_more_trans_selector);
        this.K.r(R.drawable.pb_foot_more_trans_selector);
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f0926a5);
        this.c.registerListener(this.Y1);
        this.i1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel M = this.c.M();
        this.i1.Z(M.P(), M.L(), M.M(), M.K(), M.Q());
        e38 e38Var = new e38(this.c.getPageContext(), this.i1, this.d);
        this.j1 = e38Var;
        e38Var.p(new g(this));
        this.j1.s(this.c.o2);
        this.i1.b0(new h(this));
        if (this.c.M() != null && !StringUtils.isNull(this.c.M().o1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.M().o1());
        }
        this.W0 = this.d.findViewById(R.id.obfuscated_res_0x7f0918a2);
        this.X0 = this.d.findViewById(R.id.obfuscated_res_0x7f09040e);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f092053);
        this.Y0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.M() != null && this.c.M().X0()) {
            this.W0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.Y0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = k2;
            this.Y0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f09191f));
        this.Z0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.r(pbFragment.c0);
        this.Z0.g.setVisibility(8);
        this.Z0.q(this.P);
        this.Z0.p(this.c.j2);
        this.c.registerListener(this.V1);
        this.c.registerListener(this.T1);
        PbFragment pbFragment3 = this.c;
        this.L1 = new q88(pbFragment3, pbFragment3.getUniqueId());
        this.N1 = (FallingView) this.d.findViewById(R.id.obfuscated_res_0x7f0909c9);
        T2();
        this.N1.setAnimationListener(new i(this));
        k0();
        M2(false);
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f09188b);
        j0(fp5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && M.a2() && kz7.b().e()) {
            if (this.p == null) {
                this.p = new i38(this.c.getActivity(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f0918c7));
            }
            h38 h38Var = new h38(this.l);
            this.q = h38Var;
            h38Var.d(new j(this));
        }
        this.r = new h48(this.c.R(), (ViewGroup) n1().findViewById(R.id.obfuscated_res_0x7f091934));
        g48 g48Var = new g48(this.l);
        this.s = g48Var;
        g48Var.d(new m(this));
    }

    public void Z1(boolean z2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048677, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            h38 h38Var = this.q;
            if (h38Var != null) {
                h38Var.b();
            }
            g48 g48Var = this.s;
            if (g48Var != null) {
                g48Var.b(z2, i2);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void f4(h08 h08Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048707, this, h08Var, z2) != null) || h08Var == null) {
            return;
        }
        p4(h08Var, z2);
        s0();
    }

    public final void p3(PostData postData, h08 h08Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048756, this, postData, h08Var) == null) {
            this.w.I(postData, h08Var);
        }
    }

    public void y2(f55 f55Var, int i2) {
        FallingView fallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048796, this, f55Var, i2) == null) && (fallingView = this.N1) != null) {
            fallingView.A(f55Var, this.c.getPageContext(), i2, false);
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
        V2(this.c.C5().y());
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
            pbListView.F(str);
        }
    }

    public void U2(PbFragment.h3 h3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, h3Var) == null) {
            this.Z1 = h3Var;
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
        s28 s28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) && (s28Var = this.E) != null) {
            s28Var.j0(z2);
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.y1 = z2;
        }
    }

    public void a3(boolean z2) {
        f58 f58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) && (f58Var = this.t) != null) {
            f58Var.r(z2);
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
            this.e2 = gVar;
            s88 s88Var = this.J;
            if (s88Var != null) {
                s88Var.f(gVar);
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
            e58 e58Var = this.w;
            if (e58Var != null) {
                e58Var.p(postData);
            }
        }
    }

    public void e3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048701, this, onClickListener) == null) {
            this.f2 = onClickListener;
            s28 s28Var = this.E;
            if (s28Var != null) {
                s28Var.r0(onClickListener);
            }
        }
    }

    public boolean f0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048703, this, z2)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.v()) {
                this.m0.r();
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
            f58 f58Var = this.t;
            if (f58Var != null) {
                return f58Var.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void f3(String str) {
        m68 m68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048706, this, str) == null) && (m68Var = this.i) != null) {
            m68Var.b(str);
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
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048725, this, aoVar) == null) && (pbLandscapeListView = this.l) != null) {
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
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048731, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void k4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z2) == null) {
            this.g0 = z2;
        }
    }

    public void l3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048736, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
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
            h28 h28Var = this.w1;
            if (h28Var != null) {
                h28Var.r(onLongClickListener);
            }
        }
    }

    public void s4(h08 h08Var) {
        a58 a58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048772, this, h08Var) == null) && (a58Var = this.u) != null) {
            a58Var.h(h08Var, this.M0);
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
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048789, this, i2) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i2);
        }
    }

    public void x3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, list) == null) {
            this.u1 = list;
            k58 k58Var = this.v1;
            if (k58Var != null) {
                k58Var.q(list);
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
        f58 f58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (f58Var = this.t) != null) {
            f58Var.u(this.l);
        }
    }

    public s28 D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.E;
        }
        return (s28) invokeV.objValue;
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
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.x == null) {
            this.x = new b58(this.c, this.P);
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
            return this.c2;
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
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.K);
            }
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                i2 = pbLandscapeListView.getFirstVisiblePosition();
            } else {
                i2 = 0;
            }
            return L0(i2);
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
        n68 n68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (n68Var = this.h) != null && !this.p1) {
            n68Var.D();
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
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.d2);
        }
        return invokeV.booleanValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            L2();
            r1();
            this.j1.g();
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
        f58 f58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048634, this) == null) && (f58Var = this.t) != null) {
            f58Var.q(this.l, this.V0, this.P0);
        }
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            r88 r88Var = this.F0;
            if (r88Var != null) {
                return r88Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public void P2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048638, this) != null) || (handler = this.W1) == null) {
            return;
        }
        Runnable runnable = this.X1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        q qVar = new q(this);
        this.X1 = qVar;
        this.W1.postDelayed(qVar, 2000L);
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
            f58 f58Var = this.t;
            if (f58Var != null && f58Var.f()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.R1;
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
            r88 r88Var = this.F0;
            if (r88Var == null) {
                return false;
            }
            return r88Var.i();
        }
        return invokeV.booleanValue;
    }

    public final void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.N1.setFallingFeedbackListener(new u0(this));
        }
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            EditorTools editorTools = this.m0;
            if (editorTools != null && editorTools.v()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public h28 V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.w1;
        }
        return (h28) invokeV.objValue;
    }

    public final void V1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048661, this) == null) && (imageView = this.w0) != null) {
            imageView.setImageResource(R.drawable.icon_pure_post_expression24);
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
        s28 s28Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048675, this) == null) && (s28Var = this.E) != null) {
            s28Var.B0();
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
        r88 r88Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || (r88Var = this.F0) == null) {
            return;
        }
        r88Var.o(2);
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

    public e38 d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.j1;
        }
        return (e38) invokeV.objValue;
    }

    public void e0() {
        r88 r88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048698, this) == null) && (r88Var = this.F0) != null) {
            r88Var.m(false);
        }
    }

    public f58 e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.t;
        }
        return (f58) invokeV.objValue;
    }

    public void h4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            this.c.showProgressBar();
        }
    }

    public final int i1() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null || (childAt = pbLandscapeListView.getChildAt(0)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(1048727, this) == null) && this.g2 != null) {
            while (this.g2.size() > 0) {
                TbImageView remove = this.g2.remove(0);
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
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && (pbFragment = this.c) != null && pbFragment.C5() != null) {
            this.c.C5().E();
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
            n68 n68Var = this.h;
            if (n68Var != null && (view2 = n68Var.d) != null) {
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
        r88 r88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048763, this) == null) && (r88Var = this.F0) != null) {
            r88Var.l(false);
        }
    }

    public void r1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048764, this) == null) && (editorTools = this.m0) != null) {
            editorTools.p();
            k58 k58Var = this.v1;
            if (k58Var != null) {
                k58Var.m();
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
        n68 n68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048769, this) == null) && (n68Var = this.h) != null) {
            n68Var.q();
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
            this.K.C();
            this.K.T();
        }
    }

    public void u0() {
        f58 f58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (f58Var = this.t) != null) {
            f58Var.b();
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
            Handler handler = this.W1;
            if (handler != null && (runnable = this.X1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048782, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", s2);
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
            statisticItem.param("obj_locate", s2);
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
                pbListView.A();
                this.K.g();
            }
            t1();
        }
    }

    public void x1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (editorTools = this.m0) != null) {
            editorTools.r();
        }
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            h48 h48Var = this.r;
            if (h48Var != null && h48Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            s0();
        }
    }

    public final void y1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && this.z == null && (pbFragment = this.c) != null) {
            this.z = new z48(pbFragment.getContext());
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048799, this) == null) && this.v == null) {
            this.v = new c58(this.c, this.k0);
        }
    }

    public final void A1(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h08Var) != null) || h08Var == null || h08Var.Q() == null || !h08Var.Q().isInterviewLive() || this.T0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.S0.inflate();
        this.T0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.T0.setCallback(this.c.v5());
        this.T0.setData(this.c, h08Var);
    }

    public void J3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) && this.t0 != null && (textView = this.x0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f0539);
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
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            on adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i2;
            }
            if (i2 < adapter2.getCount() && i2 >= 0 && (adapter2.getItem(i2) instanceof e08)) {
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
            a1 a1Var = this.d1;
            if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                i2 = this.d1.c.getView().getTop() < 0 ? this.d1.c.getView().getHeight() : this.d1.c.getView().getBottom();
            }
            this.K.I(str, i2);
        }
    }

    public final void e4(h08 h08Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048702, this, h08Var) == null) && !this.z1 && h08Var != null && h08Var.Q() != null && !h08Var.Q().isVideoThreadType()) {
            boolean z3 = false;
            if (h08Var.Q().getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (h08Var.Q().getIs_top() == 1) {
                z3 = true;
            }
            e58 e58Var = this.w;
            if (e58Var != null) {
                e58Var.q(h08Var, z2, z3);
            }
            c58 c58Var = this.v;
            if (c58Var != null) {
                c58Var.b(h08Var, z2, z3);
            }
        }
    }

    public void j0(boolean z2) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048723, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i4 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
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
                pbListView.N(i2);
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
            if (!StringUtils.isNull(str) && this.c.C5() != null && this.c.C5().s() != null && this.c.C5().s().i() != null) {
                EditText i2 = this.c.C5().s().i();
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
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && G > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
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
                    measuredHeight = k2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
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
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.W0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
            }
        }
    }

    public void u2(SparseArray<Object> sparseArray, boolean z2) {
        int i2;
        sv4 sv4Var;
        sv4 sv4Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048780, this, sparseArray, z2) == null) {
            wv4 wv4Var = new wv4(this.c.getContext());
            wv4Var.q(this.c.getString(R.string.obfuscated_res_0x7f0f02ee));
            wv4Var.n(new v(this, z2));
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
                    sv4Var2 = new sv4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04ce), wv4Var);
                } else {
                    sv4Var2 = new sv4(10, this.c.getString(R.string.obfuscated_res_0x7f0f04c1), wv4Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sv4Var2.d.setTag(sparseArray2);
                arrayList.add(sv4Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                sv4 sv4Var3 = new sv4(13, this.c.getString(R.string.multi_delete), wv4Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sv4Var3.d.setTag(sparseArray3);
                arrayList.add(sv4Var3);
            }
            if ((!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) && !S1()) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                sv4 sv4Var4 = new sv4(11, this.c.getString(R.string.forbidden_person), wv4Var);
                sv4Var4.d.setTag(sparseArray4);
                arrayList.add(sv4Var4);
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
                    sv4Var = new sv4(12, this.c.getString(R.string.un_mute), wv4Var);
                } else {
                    sv4Var = new sv4(12, this.c.getString(R.string.obfuscated_res_0x7f0f0b9d), wv4Var);
                }
                sv4Var.d.setTag(sparseArray5);
                arrayList.add(sv4Var);
            }
            f68.f(arrayList);
            if (UbsABTestHelper.isPBPlanA()) {
                wv4Var.k(arrayList, false);
            } else {
                wv4Var.k(arrayList, true);
            }
            uv4 uv4Var = new uv4(this.c.getPageContext(), wv4Var);
            this.S = uv4Var;
            uv4Var.k();
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
            n68 n68Var = this.h;
            if (n68Var != null && (view2 = n68Var.d) != null) {
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
            if (view2 == null || view2.getParent() == null || this.K.o()) {
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
            h08 h08Var = this.N0;
            if (h08Var == null || h08Var.l() == null || "0".equals(this.N0.l().getId()) || "me0407".equals(this.N0.l().getName())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r0 < 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i2 = 0;
            if (pbLandscapeListView == null) {
                return 0;
            }
            int lastVisiblePosition = pbLandscapeListView.getLastVisiblePosition();
            if (this.t != null) {
                if (lastVisiblePosition == this.l.getCount() - 1) {
                    lastVisiblePosition--;
                }
            }
            i2 = lastVisiblePosition;
            return L0(i2);
        }
        return invokeV.intValue;
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
                this.E1 = TbadkCoreApplication.getInst().getResources().getString(j48.g());
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
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.K.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048713, this) == null) && this.N0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !h68.k(this.N0.S())) {
            this.F0.f();
            h68.b(this.N0.S());
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048728, this) == null) {
            h28 h28Var = new h28(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f0915fa));
            this.w1 = h28Var;
            h28Var.o(this.P);
            this.w1.p(this.T);
            this.w1.q(this.Q);
            this.w1.o(this.P);
            this.w1.s(this.k0);
        }
    }

    public final void n4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048747, this) == null) && (pbFragment = this.c) != null && pbFragment.C5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.C5().y())));
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.h.k();
            e58 e58Var = this.w;
            if (e58Var != null) {
                e58Var.r();
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                yi.z(pbFragment.getContext(), this.I);
            }
            r1();
            uv4 uv4Var = this.d0;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            t0();
            lv4 lv4Var = this.F;
            if (lv4Var != null) {
                lv4Var.dismiss();
            }
            nv4 nv4Var = this.G;
            if (nv4Var != null) {
                nv4Var.e();
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048758, this) == null) {
            this.h.k();
            e58 e58Var = this.w;
            if (e58Var != null) {
                e58Var.r();
            }
            uv4 uv4Var = this.d0;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
            t0();
            lv4 lv4Var = this.F;
            if (lv4Var != null) {
                lv4Var.dismiss();
            }
            nv4 nv4Var = this.G;
            if (nv4Var != null) {
                nv4Var.e();
            }
        }
    }

    public final void q4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048762, this) != null) || !this.c.w5()) {
            return;
        }
        if (this.c.B5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.A5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048773, this) == null) {
            lv4 lv4Var = this.U;
            if (lv4Var != null) {
                lv4Var.dismiss();
            }
            Dialog dialog = this.V;
            if (dialog != null) {
                ch.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.W;
            if (dialog2 != null) {
                ch.b(dialog2, this.c.getPageContext());
            }
            uv4 uv4Var = this.S;
            if (uv4Var != null) {
                uv4Var.dismiss();
            }
        }
    }

    public final boolean y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048797, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.M().l1().l().getDeletedReasonInfo() == null || 1 != this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String B0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
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

    public final String C0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            if (i2 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0e46);
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
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f1206, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.R());
        tBAlertBuilder.v(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.t(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog y2 = tBAlertBuilder.y();
        aVar.a(new z(this, y2, sparseArray));
        aVar2.a(new a0(this, y2));
    }

    public void Q2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, editorTools) == null) {
            this.m0 = editorTools;
            editorTools.setOnCancelClickListener(new s(this));
            this.m0.setId(R.id.obfuscated_res_0x7f091896);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.m0.getParent() == null) {
                this.d.addView(this.m0, layoutParams);
            }
            this.m0.x(TbadkCoreApplication.getInst().getSkinType());
            this.m0.setActionListener(24, new t(this));
            r1();
            this.c.C5().g(new u(this));
        }
    }

    public void a2(bs8 bs8Var) {
        h08 h08Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048682, this, bs8Var) == null) && bs8Var != null && bs8Var.b != null && (h08Var = this.N0) != null && h08Var.Q() != null && this.N0.Q().getAgreeData() != null) {
            AgreeData agreeData = this.N0.Q().getAgreeData();
            String str = bs8Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = bs8Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = bs8Var.b;
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
        e38 e38Var = this.j1;
        if (e38Var != null) {
            e38Var.g();
        }
        this.c.R5();
        this.D.setVisibility(8);
        this.h.C(false);
        this.c.L6(false);
        if (this.t != null) {
            if (configuration.orientation == 1) {
                m1().setVisibility(0);
            }
            if (configuration.orientation == 2) {
                this.j2 = true;
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setIsLandscape(true);
                    this.l.smoothScrollToPosition(0);
                }
            } else {
                this.j2 = false;
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null) {
                    pbLandscapeListView2.setIsLandscape(false);
                    int i2 = this.h2;
                    if (i2 > 0) {
                        this.l.smoothScrollBy(i2, 0);
                    }
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
                    layoutParams.height = k2;
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

    public void o4(h08 h08Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, h08Var) == null) {
            if (h08Var != null && AntiHelper.o(h08Var.Q())) {
                r88 r88Var = this.F0;
                if (r88Var != null) {
                    r88Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            r88 r88Var2 = this.F0;
            if (r88Var2 != null && r88Var2.h()) {
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
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i2, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void q1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048759, this, z2) == null) && this.t0 != null && this.x0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            h08 h08Var = this.N0;
            if (h08Var != null && h08Var.r0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            h08 h08Var2 = this.N0;
            if (h08Var2 != null && h08Var2.s0()) {
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
            s28 s28Var = this.E;
            if (s28Var != null) {
                s28Var.u0(z2);
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
                pbFragment.K6(z2);
            }
            if (z2) {
                g68.d(this.c.getPageContext(), this.c.M(), this.c.F5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            h08 h08Var = this.N0;
            if (h08Var != null) {
                str = h08Var.m();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || !this.c.w5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09153b);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09153a);
            ig5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09153f);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f09153e);
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
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (pbFragment = this.c) != null && pbFragment.C5() != null && this.m0 != null) {
            k85.a().c(0);
            o85 C5 = this.c.C5();
            C5.M();
            C5.K();
            if (C5.v() != null) {
                WriteImagesInfo v2 = C5.v();
                if (C5.t) {
                    i2 = 1;
                } else {
                    i2 = 9;
                }
                v2.setMaxImagesAllowed(i2);
            }
            C5.d0(SendView.h);
            C5.h(SendView.h);
            t65 n3 = this.m0.n(23);
            t65 n4 = this.m0.n(2);
            t65 n5 = this.m0.n(5);
            if (n4 != null) {
                n4.display();
            }
            if (n5 != null) {
                n5.display();
            }
            if (n3 != null) {
                n3.hide();
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.J1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o0() {
        q88 q88Var;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048748, this) != null) || (q88Var = this.L1) == null) {
            return;
        }
        if (this.l != null && q88Var.a() != null && this.L1.a().getParent() != null) {
            i2 = this.l.getPositionForView(this.L1.a());
        } else {
            i2 = -1;
        }
        boolean z3 = false;
        if (i2 != -1) {
            if (this.L1.a().getTop() + r2 <= this.W0.getBottom()) {
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
            h08 h08Var = this.N0;
            if (h08Var != null && this.K != null && h08Var.z() != null && this.N0.z().b() == 0) {
                this.K.x(this.N0.t());
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
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.A(0L);
            }
            s0();
        }
    }

    public final void z2() {
        n68 n68Var;
        h08 h08Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048800, this) == null) && this.v != null && (n68Var = this.h) != null && n68Var.p() != null && (h08Var = this.N0) != null && h08Var.Q() != null && this.N0.Q().isQuestionThread() && this.v.d() != null && this.v.d().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.v.d().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.v.d().getHeight();
            if (this.v.d().getParent() == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            n68 n68Var2 = this.h;
            if (height > n68Var2.p().getBottom() && z2) {
                z3 = false;
            }
            n68Var2.H(z3, this.N0.Q().getSpan_str());
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
                this.l.setSelectionFromTop(this.E.G() + this.l.getHeaderViewsCount(), k2 - i4);
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
            this.l.setOnLayoutListener(new l(this, g1, pbReplyTitleViewHolder, z2, measuredHeight, i2, i3));
        }
    }

    public void d2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048695, this) == null) {
            i38 i38Var = this.p;
            if (i38Var != null) {
                i38Var.l();
            }
            h48 h48Var = this.r;
            if (h48Var != null) {
                h48Var.o();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            r88 r88Var = this.F0;
            if (r88Var != null) {
                r88Var.k();
            }
            d48 d48Var = this.k1;
            if (d48Var != null) {
                d48Var.a();
            }
            u38 u38Var = this.A1;
            if (u38Var != null) {
                u38Var.c();
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
            wr8.d();
            p0();
            x0();
            if (this.h1 != null) {
                ah.a().removeCallbacks(this.h1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.T0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.Q1);
            this.W1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.a0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            f58 f58Var = this.t;
            if (f58Var != null) {
                f58Var.a();
            }
            s28 s28Var = this.E;
            if (s28Var != null) {
                s28Var.c0();
            }
            k58 k58Var = this.v1;
            if (k58Var != null) {
                k58Var.l();
            }
            PbEmotionBar pbEmotionBar = this.e1;
            if (pbEmotionBar != null) {
                pbEmotionBar.x();
            }
            e58 e58Var = this.w;
            if (e58Var != null) {
                e58Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.Z0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(null);
            }
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l = null;
            }
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
            if (this.o1 && !this.n1 && (postData = this.O0) != null && postData.r() != null) {
                int i3 = 2;
                if (this.c.s0()) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                if (!this.n1) {
                    i3 = 1;
                }
                i78.q("c12601", i3, i2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.O0.r().getUserId(), this.O0.r().getUserName(), this.c.M().K0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        h08 h08Var = this.N0;
        if (h08Var != null && h08Var.l() != null && !xi.isEmpty(this.N0.l().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.N0.l().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.N0.S()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.N0.l().getId()));
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048718, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                i78.r("c10517", this.j0, 2);
            } else if (!this.c.X4()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                o85 C5 = this.c.C5();
                if (C5 != null && (C5.x() || C5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.C5().w(false, null);
                    return;
                }
                if (this.m0 != null) {
                    C1();
                }
                EditorTools editorTools = this.m0;
                if (editorTools != null) {
                    this.J0 = false;
                    if (editorTools.o(2) != null) {
                        wr8.c(this.c.getPageContext(), (View) this.m0.o(2).m, false, t2);
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
            this.c.v6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.M() != null && this.c.M().l1() != null && this.c.M().l1().Q() != null && this.c.M().l1().Q().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.M().G1()).param("fid", this.c.M().l1().m()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.M().b).param("fid", this.c.M().l1().m()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void t4() {
        PbFragment pbFragment;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048777, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isXiuXiuThread()) {
            ThreadData Q = this.c.M().G.Q();
            int i3 = 0;
            if (this.c.M().Q0()) {
                i2 = 1;
            } else if (this.c.M().T0()) {
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

    public final void D1(h08 h08Var, p15 p15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, h08Var, p15Var) == null) && this.P1 != null && h08Var != null && p15Var != null && this.c.getContext() != null) {
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
            this.O1.setLogoListener(new r0(this, p15Var));
            this.O1.setFeedBackListener(new v0(this, p15Var));
        }
    }

    public void S3(nv4.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, cVar, z2) == null) {
            uv4 uv4Var = this.e0;
            if (uv4Var != null) {
                uv4Var.dismiss();
                this.e0 = null;
            }
            wv4 wv4Var = new wv4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            h08 h08Var = this.N0;
            if (h08Var != null && h08Var.Q() != null && !this.N0.Q().isBjh()) {
                arrayList.add(new sv4(0, this.c.getPageContext().getString(R.string.save_to_emotion), wv4Var));
            }
            if (!z2) {
                arrayList.add(new sv4(1, this.c.getPageContext().getString(R.string.save_to_local), wv4Var));
            }
            wv4Var.j(arrayList);
            wv4Var.n(new h0(this, cVar));
            uv4 uv4Var2 = new uv4(this.c.getPageContext(), wv4Var);
            this.e0 = uv4Var2;
            uv4Var2.k();
        }
    }

    public void o2(AbsListView absListView, int i2) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048750, this, absListView, i2) == null) {
            f58 f58Var = this.t;
            if (f58Var != null) {
                f58Var.o(absListView, i2);
            }
            if (!this.j2 && i2 == 0) {
                this.h2 = i1();
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

    public final void D2(AgreeData agreeData, long j2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048590, this, agreeData, j2) == null) && agreeData != null && (textView = this.G0) != null) {
            if (j2 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.G0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.G0.setText(B0(j2));
                this.G0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void D3(int i2, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048591, this, i2, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().l1() != null && this.c.M().l1().o() != null && this.c.M().l1().l() != null && this.c.M().l1().l().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            qq5 qq5Var = new qq5(this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().l1().o().has_forum_rule.intValue());
            qq5Var.i(this.c.M().l1().l().getId(), this.c.M().l1().l().getName());
            qq5Var.h(this.c.M().l1().l().getImage_url());
            qq5Var.j(this.c.M().l1().l().getUser_level());
            O3(sparseArray, i2, qq5Var, this.c.M().l1().X(), true);
        }
    }

    public final void W3(lv4 lv4Var, int i2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048667, this, lv4Var, i2) == null) && (pbFragment = this.c) != null && lv4Var != null) {
            if (this.C1 == null && this.u != null) {
                this.C1 = new oq5(pbFragment.getPageContext(), this.u.c());
            }
            AntiData n5 = this.c.n5();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (n5 != null && n5.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = n5.getDelThreadInfoList();
                for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                    }
                }
            }
            rt4 rt4Var = new rt4();
            rt4Var.j(sparseArray);
            this.C1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.C1.A(rt4Var);
            if (i2 != 1 && i2 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.C1.D(str);
            this.C1.C(new b0(this, lv4Var));
        }
    }

    public void b4(vt4 vt4Var, lv4.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048688, this, vt4Var, eVar) != null) || vt4Var == null) {
            return;
        }
        int a2 = vt4Var.a();
        int h2 = vt4Var.h();
        lv4 lv4Var = this.F;
        if (lv4Var != null) {
            lv4Var.show();
        } else {
            this.F = new lv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0231, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0509, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f0501, new o0(this));
            this.F.setOnCalcelListener(new p0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f090fbc);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f090775);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h2 <= 0) {
            h2 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h2)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean p4(h08 h08Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048757, this, h08Var, z2)) == null) {
            if (h08Var == null) {
                return false;
            }
            if (this.v != null) {
                if (h08Var.Q() != null && h08Var.Q().getIsNoTitle() == 0 && !h08Var.Q().isVideoThreadType() && !this.R1) {
                    if (h08Var.Q() != null) {
                        ThreadData Q = h08Var.Q();
                        Q.parserSpecTitleForFrsAndPb(true, I3(h08Var));
                        Q.setResource(3);
                        Q.setPbTitle("2");
                    }
                    if (h08Var.Q().isBJHArticleThreadType()) {
                        this.w.F(this.l);
                        this.v.h(this.l);
                        this.v.a(this.l);
                        this.w.n(this.l);
                        this.w.K(this.N0);
                        if (J1(h08Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.i(h08Var);
                        }
                    } else {
                        this.w.K(this.N0);
                        if (J1(h08Var)) {
                            this.v.h(this.l);
                        } else {
                            this.v.k(h08Var);
                        }
                    }
                } else if (h08Var.Q().getIsNoTitle() == 1) {
                    if (h08Var.Q() != null) {
                        this.v.h(this.l);
                        this.w.K(this.N0);
                    }
                } else {
                    this.v.h(this.l);
                    this.w.K(this.N0);
                }
            }
            d4(h08Var.Z());
            e4(h08Var);
            this.M0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void E1(h08 h08Var) {
        p15 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, h08Var) != null) || h08Var == null) {
            return;
        }
        if (h08Var.r0()) {
            pbAdFloatViewItemData = h08Var.d0();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            D1(h08Var, pbAdFloatViewItemData);
        } else {
            w1();
        }
    }

    public final boolean J1(h08 h08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, h08Var)) == null) {
            if (h08Var == null || h08Var.Q() == null) {
                return false;
            }
            SpannableStringBuilder span_str = h08Var.Q().getSpan_str();
            if (span_str == null) {
                return true;
            }
            if (!TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e47).equals(span_str.toString())) {
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
                h08 h08Var = this.N0;
                if (h08Var != null && (Z = h08Var.Z()) != null && Z.r() != null) {
                    str = Z.r().getUserId();
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
                this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.K);
                }
                this.f = 2;
            }
            V1();
        }
    }

    public final void E2(h08 h08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, h08Var) == null) && h08Var != null && h08Var.Q() != null) {
            o4(h08Var);
            ImageView imageView = this.B0;
            if (imageView != null && imageView.getContext() != null) {
                if (h08Var.r()) {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String C0 = C0(h08Var.Q().getReply_num());
            TextView textView = this.H0;
            if (textView != null) {
                textView.setText(C0);
            }
            TextView textView2 = this.I0;
            if (textView2 != null) {
                textView2.setText(C0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, h08Var.Q()));
            D2(h08Var.Q().getAgreeData(), h08Var.Q().getAgreeNum());
            if (this.A0 != null && h08Var.Q() != null) {
                this.A0.setThreadData(h08Var.Q());
                int i2 = 1;
                if (h08Var.Q().getAgreeData() != null) {
                    h08Var.Q().getAgreeData().isInThread = true;
                }
                this.A0.setData(h08Var.Q().getAgreeData());
                bs4 bs4Var = new bs4();
                bs4Var.b = 26;
                if (h08Var.Q().isVideoThreadType() && h08Var.Q().getThreadVideoInfo() != null) {
                    i2 = 2;
                }
                bs4Var.c = i2;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.M() != null) {
                    bs4Var.j = this.c.M().getFromForumId();
                    bs4Var.f = this.c.M().k1();
                }
                this.A0.setStatisticData(bs4Var);
            }
        }
    }

    public void G1(h08 h08Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, h08Var) == null) {
            int i2 = 0;
            this.E.h0(h08Var, false);
            this.E.Z();
            s0();
            h28 h28Var = this.w1;
            if (h28Var != null) {
                h28Var.n();
            }
            ArrayList<PostData> H = h08Var.H();
            if (h08Var.z().b() == 0 || H == null || H.size() < h08Var.z().e()) {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                    if (h08Var.z().b() == 0) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.K.m();
                } else {
                    a1 a1Var = this.d1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            bottom = this.d1.c.getView().getHeight();
                        } else {
                            bottom = this.d1.c.getView().getBottom();
                        }
                        i2 = bottom;
                    }
                    if (this.c.a6()) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e5f), i2);
                    } else {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e60), i2);
                    }
                }
            }
            E2(h08Var);
        }
    }

    public void G3(h08 h08Var) {
        PostData postData;
        n68 n68Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, h08Var) == null) && h08Var != null && (postData = this.O0) != null && postData.r() != null && (n68Var = this.h) != null) {
            boolean z3 = !this.n1;
            this.o1 = z3;
            n68Var.I(z3);
            if (this.c.D5() != null) {
                this.c.D5().s(this.o1);
            }
            B2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.s0() && !ListUtils.isEmpty(h08Var.p())) {
                uu4 uu4Var = h08Var.p().get(0);
                if (uu4Var != null) {
                    this.h.M(h08Var, uu4Var.d(), uu4Var.b(), uu4Var.a(), uu4Var.e());
                }
            } else if (h08Var.l() != null) {
                n68 n68Var2 = this.h;
                String name = h08Var.l().getName();
                String id = h08Var.l().getId();
                String image_url = h08Var.l().getImage_url();
                if (h08Var.l().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                n68Var2.M(h08Var, name, id, image_url, z2);
            }
            if (this.o1) {
                this.w.P(h08Var, this.O0, this.h0);
                View view2 = this.Y0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.x1 == null) {
                    this.x1 = new n0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.x1);
                    return;
                }
                return;
            }
            View view3 = this.Y0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.w.P(h08Var, this.O0, this.h0);
            this.x1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public void K3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, view2) != null) || ry4.l().i("show_long_press_collection_tips", false)) {
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
        textView.setText(R.string.obfuscated_res_0x7f0f0452);
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
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new t0(this, i4, i2, i3, view2), 100L);
        }
        ry4.l().v("show_long_press_collection_tips", true);
    }

    public void U3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, onItemClickListener) == null) {
            pv4 pv4Var = this.f0;
            if (pv4Var != null) {
                pv4Var.d();
                this.f0 = null;
            }
            if (this.N0 == null) {
                return;
            }
            ArrayList<yv4> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.N0.N() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new yv4(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.N0.N() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new yv4(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.N0.N() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new yv4(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.N0.N() == 4) {
                z5 = true;
            }
            arrayList.add(new yv4(string4, "", z5, Integer.toString(7)));
            pv4 pv4Var2 = new pv4(this.c.getPageContext());
            pv4Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f0 = pv4Var2;
            pv4Var2.k(arrayList, onItemClickListener);
            pv4Var2.c();
            this.f0.n();
        }
    }

    public void F2(int i2, h08 h08Var, boolean z2, int i3) {
        PostData Z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), h08Var, Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) && i2 > 0 && h08Var != null && (Z = h08Var.Z()) != null && Z.r() != null) {
            MetaData r3 = Z.r();
            r3.setGiftNum(r3.getGiftNum() + i2);
        }
    }

    public void G2(h08 h08Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{h08Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            R3(h08Var, z2, i2, i3);
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
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f04c1, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f037c, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.R());
        tBAlertBuilder.v(i2);
        tBAlertBuilder.m(i3);
        tBAlertBuilder.o(true);
        tBAlertBuilder.t(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog y2 = tBAlertBuilder.y();
        aVar.a(new x(this, y2, sparseArray));
        aVar2.a(new y(this, y2));
    }

    public final boolean I3(h08 h08Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, h08Var)) == null) {
            if (h08Var == null || h08Var.Q() == null) {
                return false;
            }
            if (h08Var.Q().getIsLive() != 1 && h08Var.Q().getThreadType() != 33 && ((h08Var.Q().getTopicData() == null || h08Var.Q().getTopicData().a() == 0) && h08Var.Q().getIs_top() != 1 && h08Var.Q().getIs_good() != 1 && !h08Var.Q().isActInfo() && !h08Var.Q().isInterviewLive() && !h08Var.Q().isVoteThreadType() && h08Var.Q().getYulePostActivityData() == null && xi.isEmpty(h08Var.Q().getCategory()) && !h08Var.Q().isGodThread() && !h08Var.Q().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void e2(TbRichText tbRichText) {
        h08 h08Var;
        PostData postData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048700, this, tbRichText) == null) && (h08Var = this.N0) != null && h08Var.H() != null && !this.N0.H().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i2 = 0; i2 < this.N0.H().size() && (postData = this.N0.H().get(i2)) != null && postData.r() != null && !StringUtils.isNull(postData.r().getUserId()); i2++) {
                if (this.N0.H().get(i2).r().getUserId().equals(tbRichText.getAuthorId())) {
                    h28 h28Var = this.w1;
                    if (h28Var != null && h28Var.l()) {
                        F3(false);
                    }
                    PbEmotionBar pbEmotionBar = this.e1;
                    if (pbEmotionBar != null) {
                        pbEmotionBar.q(true);
                    }
                    postData.r().getName_show();
                    return;
                }
            }
        }
    }

    public void m4(f08 f08Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048742, this, f08Var) != null) || f08Var == null) {
            return;
        }
        this.h.K();
        if (!StringUtils.isNull(f08Var.b)) {
            this.h.G(f08Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f145b);
        int e2 = xg.e(f08Var.a, 0);
        if (e2 != 100) {
            if (e2 != 300) {
                if (e2 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f13d3);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0300);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f118b);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new l0(this, f08Var.c));
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            lv4 lv4Var = new lv4(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            lv4Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(m2, Integer.valueOf(p2));
            lv4Var.setYesButtonTag(sparseArray);
            lv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f15de, this.c);
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new s0(this));
            lv4Var.create(this.c.getPageContext()).show();
        }
    }

    public void w2(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048788, this, view2) == null) && this.A0.getData() != null && this.A0.getData().hasAgree && this.c.getActivity() != null) {
            jz7 jz7Var = new jz7(this.c.getContext());
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07076f);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g3, g2);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i2) - ((int) ((g3 * 1) / 1.45d));
            layoutParams.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            jz7Var.k(g2);
            jz7Var.j(layoutParams);
            jz7Var.i(false);
            jz7Var.n(true, this.c.getActivity().findViewById(16908290), 0, i3, this.N0.S(), this.N0.m());
            jz7Var.l(new o(this));
        }
    }

    public final void O3(SparseArray<Object> sparseArray, int i2, qq5 qq5Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048635, this, new Object[]{sparseArray, Integer.valueOf(i2), qq5Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.D1 == null && this.u != null) {
            this.D1 = new rq5(pbFragment.getPageContext(), this.u.c(), qq5Var, userData);
        }
        this.D1.F(z2);
        AntiData n5 = this.c.n5();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        if (n5 != null && n5.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = n5.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray2.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        rt4 rt4Var = new rt4();
        rt4Var.j(sparseArray2);
        this.D1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.D1.G(rt4Var);
        if (i2 != 1 && i2 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.D1.J(str);
        this.D1.I(new c0(this, sparseArray));
    }

    public void T3(nv4.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048655, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            uv4 uv4Var = this.d0;
            if (uv4Var != null) {
                uv4Var.dismiss();
                this.d0 = null;
            }
            wv4 wv4Var = new wv4(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new sv4(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0462), wv4Var));
            }
            if (z3) {
                arrayList.add(new sv4(1, this.c.getPageContext().getString(R.string.report_text), wv4Var));
            } else if (!z2) {
                arrayList.add(new sv4(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0afc), wv4Var));
            } else {
                arrayList.add(new sv4(1, this.c.getPageContext().getString(R.string.remove_mark), wv4Var));
            }
            wv4Var.j(arrayList);
            wv4Var.n(new f0(this, cVar));
            uv4 uv4Var2 = new uv4(this.c.getPageContext(), wv4Var);
            this.e0 = uv4Var2;
            uv4Var2.k();
        }
    }

    public void Q3(h08 h08Var, int i2, int i3, boolean z2, int i4, boolean z3) {
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
        h08 h08Var2;
        Parcelable e2;
        Parcelable e3;
        int size2;
        int i7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{h08Var, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4), Boolean.valueOf(z3)}) == null) && h08Var != null && this.l != null) {
            this.N0 = h08Var;
            this.P0 = i2;
            if (h08Var.Q() != null) {
                this.f1 = h08Var.Q().getCopyThreadRemindType();
                if (h08Var.Q().getAnchorLevel() != 0) {
                    this.c2 = true;
                }
                this.h0 = O1(h08Var.Q());
            }
            if (h08Var.X() != null) {
                this.d2 = h08Var.X().getUserId();
            }
            A1(h08Var);
            h0();
            this.R0 = false;
            this.M0 = z2;
            r3();
            q08 q08Var = h08Var.h;
            if (q08Var != null && q08Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.x(pbThreadPostView, 1);
                    this.o.setData(h08Var);
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            R3(h08Var, z2, i2, TbadkCoreApplication.getInst().getSkinType());
            G3(h08Var);
            this.w.Q(h08Var, this.O0);
            if (this.A1 == null) {
                this.A1 = new u38(this.c.getPageContext(), this.B1);
            }
            this.A1.a(h08Var.x());
            if (this.c.w5()) {
                if (this.J == null) {
                    s88 s88Var = new s88(this.c.getPageContext());
                    this.J = s88Var;
                    s88Var.n();
                    this.J.f(this.e2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                s88 s88Var2 = this.J;
                if (s88Var2 != null) {
                    s88Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (h08Var.z().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    s88 s88Var3 = new s88(this.c.getPageContext());
                    this.J = s88Var3;
                    s88Var3.n();
                    this.J.f(this.e2);
                }
                this.l.setPullRefresh(this.J);
                O2();
                s88 s88Var4 = this.J;
                if (s88Var4 != null) {
                    s88Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                t1();
            }
            s0();
            this.E.p0(this.M0);
            this.E.m0(false);
            s28 s28Var = this.E;
            if (i2 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            s28Var.n0(z4);
            s28 s28Var2 = this.E;
            if (i2 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            s28Var2.o0(z5);
            s28 s28Var3 = this.E;
            if (z3 && this.a2 && i2 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            s28Var3.k0(z6);
            this.E.h0(h08Var, false);
            this.E.Z();
            s28 s28Var4 = this.E;
            if (h08Var.z().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            s28Var4.b0(z7, h08Var.g());
            this.w.O(h08Var.Z(), h08Var.l0());
            if (h08Var.Q() != null && h08Var.Q().getPraise() != null && this.b != -1) {
                h08Var.Q().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.a1);
            this.l.addFooterView(this.a1);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                t1();
            } else {
                this.R0 = true;
                if (h08Var.z().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new o88(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList<PostData> H = h08Var.H();
            if (h08Var.z().b() != 0 && H != null && H.size() >= h08Var.z().e()) {
                if (z3) {
                    if (this.a2) {
                        x0();
                        if (h08Var.z().b() != 0) {
                            this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.K.C();
                        this.K.Q();
                    }
                } else {
                    this.K.C();
                    this.K.Q();
                }
                this.K.m();
            } else {
                if (ListUtils.getCount(H) != 0 && (ListUtils.getCount(H) != 1 || H.get(0) == null || H.get(0).D() != 1)) {
                    if (h08Var.z().b() == 0) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.K.m();
                } else {
                    a1 a1Var = this.d1;
                    if (a1Var != null && (pbReplyTitleViewHolder = a1Var.c) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.d1.c.getView().getTop() < 0) {
                            i5 = this.d1.c.getView().getHeight();
                        } else {
                            i5 = this.d1.c.getView().getBottom();
                        }
                    } else {
                        i5 = 0;
                    }
                    if (this.c.a6()) {
                        this.K.x(false);
                        if (ListUtils.isEmpty(h08Var.T())) {
                            this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e5f), i5);
                        }
                    } else if (ListUtils.isEmpty(h08Var.T())) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e60), i5);
                    }
                    if (this.c.D5() != null && !this.c.D5().p()) {
                        this.c.D5().x();
                    }
                }
                if (h08Var.z().b() == 0 || H == null) {
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
                                        f58 f58Var = this.t;
                                        if (f58Var != null && f58Var.c() != null) {
                                            if (this.c.getBaseFragmentActivity().isUseStyleImmersiveSticky()) {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d() - yi.u(this.c.getPageContext().getPageActivity()));
                                            } else {
                                                this.l.setSelectionFromTop((this.E.B() + this.l.getHeaderViewsCount()) - 1, this.t.d());
                                            }
                                        } else {
                                            this.l.setSelection(this.E.B() + this.l.getHeaderViewsCount());
                                        }
                                    } else if (ListUtils.isEmpty(h08Var.T())) {
                                        if (this.l.getData() == null && h08Var.H() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - h08Var.H().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i3 > 0) {
                                            i7 = i3 + size2;
                                        } else {
                                            i7 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i7);
                                    } else {
                                        this.l.setSelection(h08Var.H().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.g();
                                    this.K.F(this.c.getString(R.string.obfuscated_res_0x7f0f0e59));
                                    this.K.A();
                                }
                            } else if (i4 == 1 && (e3 = a48.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e3);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.a2 = false;
                    }
                } else if (i4 == 1 && (e2 = a48.b().e()) != null && !(e2 instanceof RecyclerView.SavedState)) {
                    this.l.post(new m0(this, e2, H, h08Var));
                }
            } else {
                if (this.l.getData() == null && h08Var.H() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - h08Var.H().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i3 > 1) {
                    i6 = (i3 + size) - 2;
                } else {
                    i6 = 0;
                }
                pbLandscapeListView3.setSelection(i6);
            }
            if (this.f1 == l2 && N1()) {
                m0();
            }
            if (this.l1) {
                C2();
                this.l1 = false;
                if (i4 == 0) {
                    g3(true);
                }
            }
            if (h08Var.d == 1 || h08Var.e == 1) {
                if (this.r1 == null) {
                    this.r1 = new PbTopTipView(this.c.getContext());
                }
                if (h08Var.e == 1 && "game_guide".equals(this.c.I5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e6b));
                    this.r1.l(this.d, this.Q0);
                } else if (h08Var.d == 1 && "game_news".equals(this.c.I5())) {
                    this.r1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0e6a));
                    this.r1.l(this.d, this.Q0);
                }
            }
            this.l.removeFooterView(this.L1.a());
            if (!ListUtils.isEmpty(h08Var.K()) && h08Var.z().b() == 0) {
                this.l.removeFooterView(this.a1);
                this.L1.d(Math.max(this.t0.getMeasuredHeight(), this.K0 / 2));
                this.l.addFooterView(this.L1.a());
                this.L1.f(h08Var);
            }
            E2(h08Var);
            if (h08Var.j0() && this.c.M().a2() && this.c.E5() != null) {
                this.c.E5().d();
            }
            if (h08Var.g() != 3) {
                E1(h08Var);
            }
            this.x0.setText(TbSingleton.getInstance().getAdVertiComment(h08Var.r0(), h08Var.s0(), f1()));
            if (this.p != null && (h08Var2 = this.N0) != null && h08Var2.l() != null) {
                this.p.m(this.N0.l().getImage_url());
                this.p.n(this.N0.l().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.M() != null) {
                    this.p.o(this.c.M().b);
                }
            }
            if (this.r != null) {
                h08 h08Var3 = this.N0;
                if (h08Var3 != null && h08Var3.l() != null && (pbFragment = this.c) != null && pbFragment.M() != null) {
                    this.r.q(this.c.M().b);
                }
                h08 h08Var4 = this.N0;
                if (h08Var4 != null && h08Var4.Q() != null && !ListUtils.isEmpty(this.N0.Q().getThreadRecommendInfoDataList())) {
                    this.r.p(this.N0.Q().getThreadRecommendInfoDataList().get(0));
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void R3(h08 h08Var, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048647, this, new Object[]{h08Var, Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && h08Var != null && h08Var.Q() != null) {
            if (this.c.s0()) {
                if (h08Var.h() != null) {
                    this.i0 = h08Var.h().d();
                    this.j0 = h08Var.h().b();
                }
                if (this.i0 == null && this.c.M() != null && this.c.M().K0() != null) {
                    this.i0 = this.c.M().K0();
                }
            }
            PostData Z = h08Var.Z();
            p3(Z, h08Var);
            int i4 = 8;
            this.w.L(8);
            int i5 = 1;
            if (h08Var.y0()) {
                this.n1 = true;
                this.h.B(true);
                this.h.a.hideBottomLine();
                if (this.t == null) {
                    this.t = new f58(this.c);
                }
                this.t.v(h08Var, Z, this.l, this.w, this.U0, this.h, this.i0, this.G1);
                this.t.s(this.b2);
                O2();
            } else {
                this.n1 = false;
                this.h.B(false);
                f58 f58Var = this.t;
                if (f58Var != null) {
                    f58Var.p(this.l);
                }
            }
            if (this.c.D5() != null) {
                this.c.D5().w(this.n1);
            }
            if (Z == null) {
                return;
            }
            this.O0 = Z;
            this.w.L(0);
            SparseArray<Object> w2 = this.w.w();
            w2.put(R.id.tag_clip_board, Z);
            w2.put(R.id.tag_is_subpb, Boolean.FALSE);
            this.x.e(h08Var, this.l);
            this.z.e(h08Var, this.I1, new j0(this));
            this.v.j(h08Var);
            this.u.h(h08Var, this.M0);
            this.u.g(h08Var);
            this.w.M(this.Q0, this.N0, Z, this.b2);
            if (this.Z0 != null) {
                if (h08Var.l0()) {
                    this.Z0.getView().setVisibility(8);
                } else {
                    this.Z0.getView().setVisibility(0);
                    u08 u08Var = new u08(u08.i);
                    if (h08Var.Q() != null) {
                        h08Var.Q().getReply_num();
                    }
                    u08Var.c = h08Var.g;
                    h08Var.c();
                    u08Var.d = this.c.a6();
                    u08Var.g = h08Var.f;
                    u08Var.h = h08Var.Q().isQuestionThread();
                    this.Z0.h(u08Var);
                }
            }
            d4(Z);
            e4(h08Var);
            ah.a().post(new k0(this));
            this.y.f(this.l);
            if (Z.S) {
                this.y.g(Z.M());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.y.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            s28 s28Var = this.E;
            if (s28Var != null && s28Var.z() != null) {
                this.E.z().G(Z.S);
            }
            s28 s28Var2 = this.E;
            if (s28Var2 != null) {
                s28Var2.s0(Z.S);
            }
            MaskView maskView = this.M1;
            if (Z.S) {
                i4 = 0;
            }
            maskView.setVisibility(i4);
        }
    }

    public SparseArray<Object> U0(h08 h08Var, boolean z2, int i2) {
        InterceptResult invokeCommon;
        PostData Z;
        boolean z3;
        at4 at4Var;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048656, this, new Object[]{h08Var, Boolean.valueOf(z2), Integer.valueOf(i2)})) == null) {
            StringBuilder sb = null;
            if (h08Var == null || (Z = h08Var.Z()) == null) {
                return null;
            }
            String userId = Z.r().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i2 == 0) {
                sparseArray.put(R.id.tag_del_post_id, Z.M());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(h08Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i2 == 1) {
                if (Z.r() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, Z.r().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, Z.r().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, Z.r().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, Z.M());
                }
                sparseArray.put(R.id.tag_del_post_id, Z.M());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(h08Var.Y()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<uu4> p3 = h08Var.p();
                if (ListUtils.getCount(p3) > 0) {
                    sb = new StringBuilder();
                    for (uu4 uu4Var : p3) {
                        if (uu4Var != null && !StringUtils.isNull(uu4Var.d()) && (at4Var = uu4Var.f) != null && at4Var.a && !at4Var.c && ((i3 = at4Var.b) == 1 || i3 == 2)) {
                            sb.append(xi.cutString(uu4Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0683));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f04b9), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public final void W1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048665, this) == null) && (pbFragment = this.c) != null && pbFragment.M() != null && this.c.M().G != null && this.c.M().G.Q() != null && this.c.M().G.Q().isQuestionThread()) {
            ThreadData Q = this.c.M().G.Q();
            String x1 = this.c.M().x1();
            String y1 = this.c.M().y1();
            int i2 = 5;
            if ("question_answer_invite".equals(x1)) {
                i2 = 1;
            } else if ("3".equals(y1)) {
                i2 = 2;
            } else if ("answer_top".equals(x1)) {
                i2 = 3;
            } else if (this.c.M().Q0()) {
                i2 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", Q.getId()).param("fid", Q.getFid()).param("obj_source", i2));
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && !this.i2) {
            TiebaStatic.log("c10490");
            this.i2 = true;
            lv4 lv4Var = new lv4(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(m2, Integer.valueOf(o2));
            lv4Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            lv4Var.setContentView(inflate);
            lv4Var.setYesButtonTag(sparseArray);
            lv4Var.setPositiveButton(R.string.grade_button_tips, this.c);
            lv4Var.setNegativeButton(R.string.look_again, new q0(this));
            lv4Var.create(this.c.getPageContext()).show();
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
        tq4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0203);
        f58 f58Var = this.t;
        if (f58Var != null) {
            f58Var.h(i2);
        }
        b58 b58Var = this.x;
        if (b58Var != null) {
            b58Var.c(i2);
        }
        a58 a58Var = this.u;
        if (a58Var != null) {
            a58Var.e(i2);
        }
        c58 c58Var = this.v;
        if (c58Var != null) {
            c58Var.g(i2);
        }
        e58 e58Var = this.w;
        if (e58Var != null) {
            e58Var.C(i2);
        }
        d58 d58Var = this.y;
        if (d58Var != null) {
            d58Var.e();
        }
        z48 z48Var = this.z;
        if (z48Var != null) {
            z48Var.c();
        }
        MaskView maskView = this.M1;
        if (maskView != null) {
            maskView.f();
        }
        h48 h48Var = this.r;
        if (h48Var != null) {
            h48Var.n();
        }
        PbListView pbListView = this.K;
        if (pbListView != null) {
            pbListView.e(i2);
        }
        if (this.M != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.M);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        lv4 lv4Var = this.F;
        if (lv4Var != null) {
            lv4Var.autoChangeSkinType(this.c.getPageContext());
        }
        k4(this.g0);
        this.E.Z();
        s88 s88Var = this.J;
        if (s88Var != null) {
            s88Var.H(i2);
        }
        EditorTools editorTools = this.m0;
        if (editorTools != null) {
            editorTools.x(i2);
        }
        o88 o88Var = this.L;
        if (o88Var != null) {
            o88Var.g(i2);
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
            ig5.a(this.c.getPageContext(), this.A);
        }
        e38 e38Var = this.j1;
        if (e38Var != null) {
            e38Var.l(i2);
        }
        n68 n68Var = this.h;
        if (n68Var != null) {
            f58 f58Var2 = this.t;
            if (f58Var2 != null) {
                f58Var2.i(i2);
            } else {
                n68Var.v(i2);
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
        h08 h08Var = this.N0;
        if (h08Var != null && h08Var.r()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
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
            agreeView.u();
            this.A0.N(i2);
            AgreeData data = this.A0.getData();
            if (data != null) {
                D2(data, data.agreeNum);
            }
        }
        h28 h28Var = this.w1;
        if (h28Var != null) {
            h28Var.m(i2);
        }
        PbEmotionBar pbEmotionBar = this.e1;
        if (pbEmotionBar != null) {
            pbEmotionBar.w();
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i2);
        }
        r88 r88Var = this.F0;
        if (r88Var != null) {
            r88Var.j();
        }
        q88 q88Var = this.L1;
        if (q88Var != null) {
            q88Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.O1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.o();
        }
        SkinManager.setBackgroundColor(this.X0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.X0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
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
        e58 e58Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048745, this, absListView, i2, i3, i4) == null) {
            h38 h38Var = this.q;
            if (h38Var != null) {
                h38Var.c(i2, i3);
            }
            g48 g48Var = this.s;
            if (g48Var != null) {
                g48Var.c(i2, i3);
            }
            f58 f58Var = this.t;
            if (f58Var != null) {
                f58Var.n(absListView, i2, i3, i4);
            }
            n68 n68Var = this.h;
            if (n68Var != null && (e58Var = this.w) != null) {
                n68Var.x(e58Var.u());
            }
            z2();
            a1 a1Var = this.d1;
            a1Var.a = i2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                a1Var.b = pbLandscapeListView.getHeaderViewsCount();
            }
            this.d1.c = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.d1));
            E3(d0(absListView, i2));
            int i5 = 0;
            A2(this.d1.c, false);
            o0();
            if (this.K.p() && !this.K.C) {
                a1 a1Var2 = this.d1;
                if (a1Var2 != null && (pbReplyTitleViewHolder = a1Var2.c) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.d1.c.getView().getTop() < 0) {
                        bottom = this.d1.c.getView().getHeight();
                    } else {
                        bottom = this.d1.c.getView().getBottom();
                    }
                    i5 = bottom;
                }
                this.K.f(i5);
                this.K.C = true;
            }
        }
    }

    public void p2(ArrayList<it4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, arrayList) == null) {
            if (this.X == null) {
                this.X = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.X);
            if (this.W == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003a9);
                this.W = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.W.setCancelable(true);
                this.l0 = (ScrollView) this.X.findViewById(R.id.good_scroll);
                this.W.setContentView(this.X);
                WindowManager.LayoutParams attributes = this.W.getWindow().getAttributes();
                attributes.width = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702db);
                this.W.getWindow().setAttributes(attributes);
                this.Z = new d0(this);
                this.Y = (LinearLayout) this.X.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.X.findViewById(R.id.dialog_button_cancel);
                this.b0 = textView;
                textView.setOnClickListener(new e0(this));
                TextView textView2 = (TextView) this.X.findViewById(R.id.dialog_button_ok);
                this.a0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Y.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton l02 = l0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(l02);
            l02.setChecked(true);
            this.Y.addView(l02);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    it4 it4Var = arrayList.get(i2);
                    if (it4Var != null && !TextUtils.isEmpty(it4Var.b()) && it4Var.a() > 0) {
                        CustomBlueCheckRadioButton l03 = l0(String.valueOf(it4Var.a()), it4Var.b());
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
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(m2, Integer.valueOf(n2));
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
            this.U = new lv4(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.U.setMessageId(i4);
            } else {
                this.U.setOnlyMessageShowCenter(false);
                this.U.setMessage(str2);
            }
            this.U.setYesButtonTag(sparseArray);
            this.U.setPositiveButton(R.string.obfuscated_res_0x7f0f0509, this.c);
            this.U.setNegativeButton(R.string.obfuscated_res_0x7f0f0501, new w(this));
            this.U.setCancelable(true);
            this.U.create(this.c.getPageContext());
            if (z3) {
                H3(sparseArray, i5, i4);
            } else if (z2) {
                H3(sparseArray, i5, i4);
            } else if (y3()) {
                qq5 qq5Var = new qq5(this.c.M().l1().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.M().l1().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.M().l1().o().has_forum_rule.intValue());
                qq5Var.i(this.c.M().l1().l().getId(), this.c.M().l1().l().getName());
                qq5Var.h(this.c.M().l1().l().getImage_url());
                qq5Var.j(this.c.M().l1().l().getUser_level());
                O3(sparseArray, i2, qq5Var, this.c.M().l1().X(), false);
            } else {
                W3(this.U, i2);
            }
        }
    }

    public void t2(int i2, String str, int i3, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048775, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(m2, Integer.valueOf(n2));
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
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f12b0));
            } else if (z3) {
                if (xi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0cb8);
                }
                this.c.showToast(str);
            }
        }
    }
}
