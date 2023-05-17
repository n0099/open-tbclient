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
import com.baidu.tbadk.core.view.breathetip.BreatheTipWidget;
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
import com.baidu.tieba.cr9;
import com.baidu.tieba.d25;
import com.baidu.tieba.f25;
import com.baidu.tieba.g29;
import com.baidu.tieba.j06;
import com.baidu.tieba.j19;
import com.baidu.tieba.m06;
import com.baidu.tieba.n09;
import com.baidu.tieba.ny8;
import com.baidu.tieba.o25;
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
import com.baidu.tieba.pw8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.tieba.view.WaterRippleView;
import com.baidu.tieba.y65;
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
/* loaded from: classes6.dex */
public class o19 {
    public static /* synthetic */ Interceptable $ic;
    public static final int c2;
    public static int d2;
    public static int e2;
    public static int f2;
    public static int g2;
    public static int h2;
    public static int i2;
    public static final int j2;
    public static int k2;
    public static cr9.f l2;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public AgreeView A0;
    public String A1;
    public TextView B;
    public ImageView B0;
    public PermissionJudgePolicy B1;
    public TextView C;
    public ImageView C0;
    public boolean C1;
    public ObservedChangeRelativeLayout D;
    public HeadImageView D0;
    public int D1;
    public zz8 E;
    public View E0;
    public int E1;
    public d25 F;
    public i59 F0;
    public boolean F1;
    public f25 G;
    public TextView G0;
    public boolean G1;
    public View H;
    public TextView H0;
    public h59 H1;
    public EditText I;
    public boolean I0;
    public MaskView I1;
    public j59 J;
    public int J0;
    public final PbFallingView J1;
    public PbListView K;
    public s65 K0;
    public RightFloatLayerView K1;
    public e59 L;
    public boolean L0;
    public final FrameLayout L1;
    public View M;
    public lx8 M0;
    public LinearLayout M1;
    public View N;
    public rr9 N0;
    public k39 N1;
    public View O;
    public int O0;
    public CustomMessageListener O1;
    public View.OnClickListener P;
    public int P0;
    public View.OnClickListener P1;
    public SortSwitchButton.f Q;
    public boolean Q0;
    public CustomMessageListener Q1;
    public TbRichTextView.a0 R;
    public ViewStub R0;
    public Handler R1;
    public NoNetworkView.b S;
    public PbInterviewStatusView S0;
    public Runnable S1;
    public m25 T;
    public TextView T0;
    public CustomMessageListener T1;
    public View.OnClickListener U;
    public View U0;
    public PbFragment.g3 U1;
    public d25 V;
    public View V0;
    public boolean V1;
    public Dialog W;
    public View W0;
    public View.OnClickListener W1;
    public Dialog X;
    public PbReplyTitleViewHolder X0;
    public String X1;
    public View Y;
    public View Y0;
    public y65.g Y1;
    public LinearLayout Z;
    public int Z0;
    public View.OnClickListener Z1;
    public final ViewTreeObserver.OnGlobalLayoutListener a;
    public CompoundButton.OnCheckedChangeListener a0;
    public boolean a1;
    public final List<TbImageView> a2;
    public int b;
    public TextView b0;
    public z0 b1;
    public boolean b2;
    public PbFragment c;
    public TextView c0;
    public int c1;
    public RelativeLayout d;
    public String d0;
    public int d1;
    public View e;
    public m25 e0;
    public Runnable e1;
    public int f;
    public m25 f0;
    public PbFakeFloorModel f1;
    public final Handler g;
    public h25 g0;
    public k09 g1;
    public final w39 h;
    public boolean h0;
    public boolean h1;
    public v39 i;
    public boolean i0;
    public int i1;
    public ViewStub j;
    public String j0;
    public boolean j1;
    public ViewStub k;
    public String k0;
    public boolean k1;
    public PbLandscapeListView l;
    public py8 l0;
    public boolean l1;
    public NoNetworkView m;
    public ScrollView m0;
    public int m1;
    public List<CustomBlueCheckRadioButton> n;
    public EditorTools n0;
    public PbTopTipView n1;
    public PbThreadPostView o;
    public boolean o0;
    public PopupWindow o1;
    public o09 p;
    public View p0;
    public TextView p1;
    public n09 q;
    public View q0;
    public List<String> q1;
    public k19 r;
    public EjectionAnimationView r0;
    public p29 r1;
    public j19 s;
    public Button s0;
    public nz8 s1;
    public h29 t;
    public View t0;
    public PbLandscapeListView.c t1;
    public j29 u;
    public View u0;
    public boolean u1;
    public l29 v;
    public LinearLayout v0;
    public boolean v1;
    public i29 w;
    public ImageView w0;
    public y09 w1;
    public k29 x;
    public TextView x0;
    public NavigationBarCoverTip x1;
    public g29 y;
    public WaterRippleView y0;
    public j06 y1;
    public PbContentCollectionController z;
    public ImageView z0;
    public m06 z1;

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? R.id.obfuscated_res_0x7f0919d9 : invokeV.intValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g2(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048708, this, i3)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? R.id.obfuscated_res_0x7f091e20 : invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class b implements AgreeView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        /* loaded from: classes6.dex */
        public class a implements pe5 {
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

            @Override // com.baidu.tieba.pe5
            public void a(List<Bitmap> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.a.r0.setVisibility(0);
                    this.a.a.r0.setBitmaps(list);
                    Rect rect = new Rect();
                    this.a.a.A0.getImgAgree().getGlobalVisibleRect(rect);
                    this.a.a.r0.setAnchorPosition((rect.right + rect.left) / 2, (rect.bottom + rect.top) / 2);
                    this.a.a.r0.k();
                }
            }
        }

        public b(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onLongPress() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.x3();
            re5.g().c(new a(this));
        }

        @Override // com.baidu.tbadk.core.view.AgreeView.i
        public void onRelease() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.K2();
            this.a.r0.l();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements n09.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.p != null) {
                    this.a.a.p.p();
                }
            }
        }

        public i(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.n09.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements j19.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.r != null && this.a.a.c.R() != null) {
                    u25.g(Collections.singletonList(new l19(this.a.a.c.R(), this.a.a.r)));
                }
            }
        }

        public j(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.j19.a
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.c.x6() && this.a.l != null) {
                this.a.l.post(new a(this));
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
        public final /* synthetic */ o19 g;

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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g.Y0 != null && this.a.g.Y0.getLayoutParams() != null) {
                    ViewGroup.LayoutParams layoutParams = this.a.g.Y0.getLayoutParams();
                    layoutParams.height = this.a.g.d1;
                    this.a.g.Y0.setLayoutParams(layoutParams);
                }
            }
        }

        public l(o19 o19Var, int i, PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Integer.valueOf(i), pbReplyTitleViewHolder, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = o19Var;
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
                    int j1 = this.g.j1(this.b);
                    int i3 = this.a;
                    int i4 = j1 - i3;
                    if (this.c && i4 != 0 && i3 <= (i = this.d)) {
                        i4 = j1 - i;
                    }
                    if (this.g.Y0 == null || (layoutParams = this.g.Y0.getLayoutParams()) == null) {
                        return;
                    }
                    if (i4 != 0 && i4 <= this.g.d.getMeasuredHeight() && j1 < this.g.d.getMeasuredHeight()) {
                        if (layoutParams != null) {
                            int i5 = layoutParams.height;
                            if (i5 + i4 > 0 && i5 + i4 <= this.g.d.getMeasuredHeight()) {
                                layoutParams.height += i4;
                                if (this.g.l != null) {
                                    this.g.l.setSelectionFromTop(this.e, this.f);
                                }
                            }
                        }
                        layoutParams.height = this.g.d1;
                    } else {
                        layoutParams.height = this.g.d1;
                    }
                    this.g.Y0.setLayoutParams(layoutParams);
                    sg.a().post(new a(this));
                }
                if (this.g.l != null) {
                    this.g.l.setOnLayoutListener(null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

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

        public o0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                if (this.a.e1 == null) {
                    this.a.e1 = new a(this);
                }
                sg.a().postDelayed(this.a.e1, 150L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements jy8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        @Override // com.baidu.tieba.jy8
        public /* synthetic */ void onStart() {
            iy8.a(this);
        }

        public a(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.jy8
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.r0.setVisibility(8);
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements j06.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d25 a;
        public final /* synthetic */ o19 b;

        public a0(o19 o19Var, d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, d25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = d25Var;
        }

        @Override // com.baidu.tieba.j06.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.l5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements m06.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;
        public final /* synthetic */ o19 b;

        public b0(o19 o19Var, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = sparseArray;
        }

        @Override // com.baidu.tieba.m06.i
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.b.c.k5(this.a, jSONArray);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public c(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.A0 != null && this.a.A0.getData() != null) {
                o19 o19Var = this.a;
                o19Var.E2(o19Var.A0.getData(), this.a.A0.getData().agreeNum);
                if (!this.a.A0.J()) {
                    o19 o19Var2 = this.a;
                    o19Var2.x2(o19Var2.A0);
                }
                if (this.a.M0 != null && this.a.M0.M() != null && this.a.M0.M().isExcellentThread() && BreatheTipWidget.f()) {
                    oc5.a("c15279", this.a.M0.O(), this.a.M0.l(), "1");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public c0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.a.d0 = (String) compoundButton.getTag();
                if (this.a.n != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.a.n) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.a.d0 != null && !str.equals(this.a.d0)) {
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
        public final /* synthetic */ o19 a;

        public d(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    if (this.a.c != null && this.a.c.G1()) {
                        return;
                    }
                    o65.m().w("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public d0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (this.a.X instanceof Dialog)) {
                ug.b(this.a.X, this.a.c.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public e(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
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
                    this.a.c.b5(sparseArray);
                    return;
                }
                this.a.w2(view2);
            } else if (z2) {
                sparseArray.put(R.id.tag_from, 0);
                sparseArray.put(R.id.tag_check_mute_from, 1);
                this.a.c.b5(sparseArray);
            } else if (z3) {
                this.a.r2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements o25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f25.c a;
        public final /* synthetic */ o19 b;

        public e0(o19 o19Var, f25.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.o25.f
        public void M0(o25 o25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o25Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public f(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
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
    public class f0 implements o25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f25.c a;
        public final /* synthetic */ o19 b;

        public f0(o19 o19Var, f25.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.o25.f
        public void M0(o25 o25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o25Var, i, view2) == null) {
                this.b.f0.dismiss();
                this.a.a(null, i, view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public g(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(rr9 rr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, rr9Var) == null) {
                this.a.f1.l0(rr9Var);
                this.a.E.d0();
                this.a.g1.g();
                this.a.n0.s();
                this.a.C3(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g0 implements cr9.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.cr9.f
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
    public class h implements PbFallingView.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public h(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.W3();
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.r
        public void onAnimationStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.J1.setTag(Boolean.FALSE);
                if (this.a.K1 == null) {
                    return;
                }
                this.a.K1.setAutoCompleteShown(false);
                if (this.a.K1.getVisibility() == 0) {
                    this.a.K1.setTag(this.a.J1);
                    this.a.K1.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public h0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if ((view2 instanceof HeadImageView) && this.a.M0 != null && this.a.M0.M() != null && this.a.M0.M().getAuthor() != null && this.a.M0.M().getAuthor().getAlaInfo() != null && this.a.M0.M().getAuthor().getAlaInfo().live_status == 1) {
                    StatisticItem statisticItem = new StatisticItem("c11851");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c13715");
                    statisticItem2.param("fid", this.a.M0.l());
                    statisticItem2.param("fname", this.a.M0.m());
                    if (this.a.M0.M().getAuthor().getAlaInfo().user_info != null) {
                        j = this.a.M0.M().getAuthor().getAlaInfo().user_info.user_id;
                    } else {
                        j = 0;
                    }
                    statisticItem2.param("obj_param1", j);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("tid", this.a.M0.O());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(this.a.M0.M().getAuthor().getAlaInfo()));
                    if (this.a.M0.M().getAuthor().getAlaInfo().mYyExtData != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem2, this.a.M0.M().getAuthor().getAlaInfo().mYyExtData);
                    }
                    TiebaStatic.log(statisticItem2);
                    if (this.a.M0.M().getAuthor().getAlaInfo().isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.a.c.getPageContext(), this.a.M0.M().getAuthor().getAlaInfo(), YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        return;
                    }
                    return;
                }
                if (this.a.j1) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                }
                if (!this.a.j1 && this.a.M0 != null && this.a.M0.M() != null && this.a.M0.M().getAuthor() != null && this.a.M0.M().getAuthor().isBigV()) {
                    TiebaStatic.log(new StatisticItem("c12151").param("obj_locate", 1));
                }
                if (this.a.c.R() != null) {
                    this.a.c.R().c.b.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements g29.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public i0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.g29.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.y.a(this.a.l);
                } else {
                    this.a.y.d(this.a.l);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public j0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            o19 o19Var;
            w39 w39Var;
            LinearLayout linearLayout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.E != null && (w39Var = (o19Var = this.a).h) != null && w39Var.k != null && o19Var.M0 != null && this.a.M0.M() != null && !this.a.M0.M().isVideoThreadType() && !this.a.U1() && this.a.M0.k() != null && !qi.isEmpty(this.a.M0.k().getName())) {
                if ((this.a.E.K() == null || !this.a.E.K().isShown()) && (linearLayout = this.a.h.k) != null) {
                    linearLayout.setVisibility(0);
                    this.a.h.h();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(o19 o19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Integer.valueOf(i)};
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
            this.a = o19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921757) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.a.b1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ o19 b;

        public k0(o19 o19Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ri.F()) {
                    UrlManager.getInstance().dealOneLink(this.b.c.getPageContext(), new String[]{this.a});
                    this.b.c.finish();
                    return;
                }
                this.b.c.showToast(R.string.obfuscated_res_0x7f0f0db6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Parcelable a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ lx8 c;
        public final /* synthetic */ o19 d;

        public l0(o19 o19Var, Parcelable parcelable, ArrayList arrayList, lx8 lx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, parcelable, arrayList, lx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = o19Var;
            this.a = parcelable;
            this.b = arrayList;
            this.c = lx8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.d.l != null) {
                    this.d.l.onRestoreInstanceState(this.a);
                }
                if (this.d.K != null && ListUtils.getCount(this.b) > 1 && this.c.y().b() > 0) {
                    this.d.K.g();
                    this.d.K.F(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6a));
                    this.d.K.A();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public m(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.E0.getVisibility() == 0) {
                    o65.m().w("pb_share_red_dot_shown", true);
                    this.a.E0.setVisibility(8);
                }
                this.a.P.onClick(this.a.C0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements PbLandscapeListView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public m0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbLandscapeListView.c
        public void a(int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) && this.a.c != null && this.a.c.isAdded()) {
                if (i < 0 && f > this.a.m1) {
                    this.a.t0();
                    this.a.h2();
                }
                this.a.B0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements pw8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public n(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.pw8.d
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A0.W();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public n0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                this.a.t0();
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(o19 o19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Integer.valueOf(i)};
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
            this.a = o19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && this.a.E != null) {
                this.a.E.d0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public p(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.A == null) {
                    this.a.F1();
                }
                this.a.k.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(o19 o19Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Integer.valueOf(i)};
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
            this.a = o19Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            this.a.I0 = false;
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public r(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
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
    public class r0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n95 a;
        public final /* synthetic */ o19 b;

        public r0(o19 o19Var, n95 n95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, n95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = n95Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b.M0 != null && this.b.K1 != null) {
                this.b.K1.g(this.a);
                this.b.K1.setAutoCompleteShown(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements te5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public s(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.te5
        public void C(se5 se5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, se5Var) == null) {
                Object obj = se5Var.c;
                if ((obj instanceof ea5) && EmotionGroupType.isSendAsPic(((ea5) obj).getType())) {
                    if (this.a.B1 == null) {
                        this.a.B1 = new PermissionJudgePolicy();
                    }
                    this.a.B1.clearRequestPermissionList();
                    this.a.B1.appendRequestPermission(this.a.c.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.B1.startRequestPermission(this.a.c.getBaseFragmentActivity())) {
                        return;
                    }
                    ea5 ea5Var = (ea5) se5Var.c;
                    this.a.c.H5().f(ea5Var);
                    if (ea5Var.i()) {
                        this.a.c.H5().G(null, null);
                    } else {
                        this.a.c.H5().w(false, null);
                    }
                }
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
        public final /* synthetic */ o19 e;

        public s0(o19 o19Var, int i, int i2, int i3, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = o19Var;
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
                    this.e.o1.showAsDropDown(this.d);
                } else {
                    this.e.o1.showAsDropDown(this.e.u0, this.d.getLeft(), -this.e.u0.getHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public t(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.a.c.L0 != null && this.a.c.L0.e() != null) {
                if (!this.a.c.L0.e().e()) {
                    this.a.c.L0.a(false);
                }
                this.a.c.L0.e().l(false);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && this.a.n0 != null && this.a.n0.getVisibility() == 0 && charSequence != null && charSequence.length() >= (i4 = i3 + i)) {
                String substring = charSequence.toString().substring(i, i4);
                if (TextUtils.isEmpty(substring)) {
                    return;
                }
                if (this.a.r1 == null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(11);
                    layoutParams.addRule(2, this.a.n0.getId());
                    o19 o19Var = this.a;
                    o19Var.r1 = new p29(o19Var.c.getPageContext(), this.a.d, layoutParams);
                    if (!ListUtils.isEmpty(this.a.q1)) {
                        this.a.r1.q(this.a.q1);
                    }
                    this.a.r1.r(this.a.n0);
                }
                this.a.r1.p(substring);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements PbFallingView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public t0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.pb.view.PbFallingView.q
        public void onClick() {
            String i1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.c != null && this.a.c.P() != null && this.a.c.P().h2()) {
                    i1 = this.a.c.getString(R.string.pb_reply_hint_from_smart_frs);
                } else {
                    i1 = this.a.i1();
                }
                if (!StringUtils.isNull(i1) && this.a.M0 != null) {
                    i1 = TbSingleton.getInstance().getAdVertiComment(this.a.M0.o0(), this.a.M0.p0(), i1);
                }
                if (this.a.c != null && this.a.c.H5() != null) {
                    this.a.c.H5().c0(i1);
                }
                if (this.a.x0 != null) {
                    this.a.x0.setText(i1);
                }
                this.a.C3(false);
                this.a.W3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u implements o25.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ o19 b;

        public u(o19 o19Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = z;
        }

        @Override // com.baidu.tieba.o25.f
        public void M0(o25 o25Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, o25Var, i, view2) == null) {
                this.b.T.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view2.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i) {
                    case 10:
                        this.b.r2(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.b.U1 != null) {
                            this.b.U1.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.b.c.Q5(this.a, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    case 13:
                        this.b.p4(true);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n95 a;
        public final /* synthetic */ o19 b;

        public u0(o19 o19Var, n95 n95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, n95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = n95Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921664));
                this.b.K1.setHomePbFloatLastCloseTime();
                this.b.y1();
                this.b.K1.t(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v implements d25.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d25.e
        public void onClick(d25 d25Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                d25Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ o19 b;

        public v0(o19 o19Var, PbFragment pbFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o19Var;
            this.a = pbFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.F1 && this.a != null && this.b.c.P() != null && this.b.c.P().l2()) {
                    this.b.F1 = true;
                    this.a.Z4(false);
                }
                if (this.b.G1) {
                    return;
                }
                this.b.G1 = true;
                if (this.b.R1() && this.b.z != null) {
                    this.b.z.h();
                    this.b.z.g(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ o19 c;

        public w(o19 o19Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o19Var;
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
                    ri.P(this.c.c.R(), R.string.obfuscated_res_0x7f0f0db6);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements ny8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public w0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // com.baidu.tieba.ny8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.T5();
            }
        }

        @Override // com.baidu.tieba.ny8.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.l != null) {
                this.a.l.setSelection(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public x(o19 o19Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, alertDialog};
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
        public final /* synthetic */ vg5 b;
        public final /* synthetic */ o19 c;

        public x0(o19 o19Var, ReplyPrivacyCheckController replyPrivacyCheckController, vg5 vg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, replyPrivacyCheckController, vg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o19Var;
            this.a = replyPrivacyCheckController;
            this.b = vg5Var;
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
                this.c.l4();
                this.b.n0();
                this.c.y0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ SparseArray b;
        public final /* synthetic */ o19 c;

        public y(o19 o19Var, AlertDialog alertDialog, SparseArray sparseArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, alertDialog, sparseArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o19Var;
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
                    ri.P(this.c.c.R(), R.string.obfuscated_res_0x7f0f0db6);
                } else {
                    this.c.c.k5(this.b, null);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o19 a;

        public y0(o19 o19Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o19Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;

        public z(o19 o19Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o19Var, alertDialog};
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
        public PbReplyTitleViewHolder a;
        public BdUniqueId b;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947979538, "Lcom/baidu/tieba/o19;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947979538, "Lcom/baidu/tieba/o19;");
                return;
            }
        }
        c2 = UtilHelper.getLightStatusBarHeight();
        d2 = 3;
        e2 = 0;
        f2 = 3;
        g2 = 4;
        h2 = 5;
        i2 = 6;
        j2 = ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds80);
        k2 = 1;
        l2 = new g0();
    }

    public rr9 M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.l == null) {
                return null;
            }
            int L0 = L0() - this.l.getHeaderViewsCount();
            int i3 = 0;
            if (L0 < 0) {
                L0 = 0;
            }
            if (this.E.A(L0) != null && this.E.A(L0) != rr9.R0) {
                i3 = L0 + 1;
            }
            if (!(this.E.z(i3) instanceof rr9)) {
                return null;
            }
            return (rr9) this.E.z(i3);
        }
        return (rr9) invokeV.objValue;
    }

    public final boolean R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (v3()) {
                for (int firstVisiblePosition = this.l.getFirstVisiblePosition(); firstVisiblePosition <= this.l.getLastVisiblePosition(); firstVisiblePosition++) {
                    View childAt = this.l.getListView2().getChildAt(firstVisiblePosition);
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

    public void S3() {
        rr9 rr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048651, this) != null) || !TbadkCoreApplication.isLogin() || this.M0 == null || !this.k1 || this.j1 || this.i0 || (rr9Var = this.N0) == null || rr9Var.p() == null || this.N0.p().getIsLike() || this.N0.p().hadConcerned()) {
        }
    }

    public final void l0() {
        PbContentCollectionController pbContentCollectionController;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048731, this) == null) {
            if (v3() && this.M0 != null) {
                new StatisticItem(CommonStatisticKey.KEY_PB_PAGE_CONTENT_COLLECTION_SHOW).addParam("tid", this.M0.M().getTid()).addParam("obj_param1", this.M0.M().getThreadRecommendInfoDataList().get(0).businessId).eventStat();
            }
            if (R1() && (pbContentCollectionController = this.z) != null) {
                pbContentCollectionController.h();
                this.z.g(true);
            }
        }
    }

    public o19(PbFragment pbFragment, View.OnClickListener onClickListener, py8 py8Var, SortSwitchButton.f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, onClickListener, py8Var, fVar};
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
        this.g0 = null;
        this.h0 = false;
        this.i0 = false;
        this.j0 = null;
        this.k0 = null;
        this.m0 = null;
        this.o0 = false;
        this.s0 = null;
        this.u0 = null;
        this.x0 = null;
        this.I0 = true;
        this.K0 = null;
        this.L0 = false;
        this.P0 = 3;
        this.Q0 = false;
        this.R0 = null;
        this.Z0 = 0;
        this.a1 = true;
        this.b1 = new z0();
        this.c1 = 0;
        this.h1 = false;
        this.i1 = 0;
        this.j1 = false;
        this.k1 = false;
        this.l1 = false;
        this.m1 = 0;
        this.u1 = false;
        this.v1 = false;
        this.E1 = 0;
        this.O1 = new k(this, 2921757);
        this.P1 = new m(this);
        this.Q1 = new o(this, 2005016);
        this.R1 = new Handler();
        this.T1 = new q(this, 2004009);
        this.V1 = true;
        this.W1 = new h0(this);
        this.X1 = null;
        this.a2 = new ArrayList();
        this.b2 = false;
        this.c = pbFragment;
        this.b1.b = pbFragment.getPageContext().getUniqueId();
        this.P = onClickListener;
        this.Q = fVar;
        this.l0 = py8Var;
        this.m1 = ri.l(this.c.getContext()) / 8;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06c1, (ViewGroup) null);
        this.d = relativeLayout;
        relativeLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.p0 = this.d.findViewById(R.id.obfuscated_res_0x7f090468);
        this.x1 = (NavigationBarCoverTip) this.d.findViewById(R.id.obfuscated_res_0x7f091a41);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f0921c3);
        this.L1 = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091e44);
        this.D = (ObservedChangeRelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0924a5);
        this.m = (NoNetworkView) this.d.findViewById(R.id.view_no_network);
        PbLandscapeListView pbLandscapeListView = (PbLandscapeListView) this.d.findViewById(R.id.obfuscated_res_0x7f091877);
        this.l = pbLandscapeListView;
        pbLandscapeListView.setDividerHeight(0);
        this.T0 = new TextView(this.c.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ri.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f07040f));
        this.l.setOverScrollMode(2);
        this.l.w(this.T0, 0);
        this.l.setTextViewAdded(true);
        this.d1 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds134);
        this.Y0 = new View(this.c.getPageContext().getPageActivity());
        if (az5.a()) {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, 0));
        } else {
            this.Y0.setLayoutParams(new AbsListView.LayoutParams(-1, this.d1));
        }
        MessageManager.getInstance().registerListener(this.O1);
        this.Y0.setVisibility(4);
        this.l.addFooterView(this.Y0);
        this.l.setOnTouchListener(this.c.J2);
        this.a = new v0(this, pbFragment);
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
        this.h = new w39(pbFragment, this.d);
        if (this.c.A5()) {
            ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09166a);
            this.j = viewStub;
            viewStub.setVisibility(0);
            v39 v39Var = new v39(pbFragment);
            this.i = v39Var;
            v39Var.c();
            this.h.a.setVisibility(8);
            layoutParams.height = ri.g(this.c.getActivity(), R.dimen.obfuscated_res_0x7f070353);
        }
        this.T0.setLayoutParams(layoutParams);
        this.h.j().setOnTouchListener(new ny8(new w0(this)));
        this.t0 = this.d.findViewById(R.id.obfuscated_res_0x7f092839);
        this.u0 = this.d.findViewById(R.id.obfuscated_res_0x7f0919dc);
        this.J0 = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070391);
        this.w0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09096a);
        this.w0.setOnClickListener(new x0(this, new ReplyPrivacyCheckController(this.c.getPageContext()), this.c.H5()));
        z0();
        this.x0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0919df);
        LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0919d7);
        this.v0 = linearLayout;
        linearLayout.setOnClickListener(new y0(this));
        EjectionAnimationView ejectionAnimationView = (EjectionAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09096e);
        this.r0 = ejectionAnimationView;
        ejectionAnimationView.setEjectionAnimationViewCallback(new a(this));
        this.z0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0919dd);
        this.I1 = (MaskView) this.d.findViewById(R.id.mask_view);
        this.z0.setOnClickListener(this.P);
        AgreeView agreeView = (AgreeView) this.d.findViewById(R.id.obfuscated_res_0x7f0919d9);
        this.A0 = agreeView;
        agreeView.setAgreeAlone(true);
        this.A0.w();
        this.A0.setAgreeLongClickListener(new b(this));
        this.A0.setAfterClickListener(new c(this));
        this.A0.setUseDynamicLikeRes("/pb");
        if (this.A0.getAgreeNumView() != null) {
            this.A0.getAgreeNumView().setVisibility(8);
        }
        if (this.A0.getMsgData() != null) {
            this.A0.getMsgData().a = BdUniqueId.gen();
        }
        boolean booleanExtra = this.c.getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0919db);
        this.B0 = imageView;
        imageView.setOnClickListener(this.P);
        if (booleanExtra) {
            this.B0.setVisibility(8);
        } else {
            this.B0.setVisibility(0);
        }
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0919e2);
        this.E0 = findViewById;
        if (!o65.m().i("pb_share_red_dot_shown", false) && TbadkCoreApplication.isLogin()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        this.C0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0919e0);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0919e1);
        this.D0 = headImageView;
        headImageView.setIsRound(true);
        this.D0.setOnClickListener(this.P1);
        this.C0.setOnClickListener(new d(this));
        Z1();
        i59 i59Var = new i59(this.C0);
        this.F0 = i59Var;
        i59Var.n(this.D0);
        if (!UbsABTestHelper.isResizeInduceSharingABTest() && !UbsABTestHelper.isResizeInduceSharingABTestA()) {
            this.F0.f();
        }
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0919de);
        this.H0 = textView;
        textView.setVisibility(0);
        this.G0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0919da);
        this.R0 = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09112b);
        this.A0.setVisibility(0);
        this.G0.setVisibility(0);
        this.t = new h29(this.c, py8Var);
        this.v = new l29(this.c, py8Var, this.P);
        zz8 zz8Var = new zz8(this.c, this.l);
        this.E = zz8Var;
        zz8Var.C0(this.P);
        this.E.E0(this.l0);
        this.E.z0(this.R);
        this.E.B0(this.Q);
        this.E.v0(this.Z1);
        e eVar = new e(this);
        this.U = eVar;
        this.E.x0(eVar);
        J1();
        D1();
        k29 k29Var = new k29(this.c);
        this.x = k29Var;
        k29Var.f = 2;
        C1();
        B1();
        this.y.a(this.l);
        this.v.q(this.l);
        this.u.a(this.l);
        this.z.a(this.l);
        this.t.a(this.l);
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
        this.O = this.d.findViewById(R.id.obfuscated_res_0x7f092871);
        this.c.registerListener(this.T1);
        this.f1 = new PbFakeFloorModel(this.c.getPageContext());
        PbModel P = this.c.P();
        this.f1.n0(P.d0(), P.Z(), P.a0(), P.Y(), P.e0());
        k09 k09Var = new k09(this.c.getPageContext(), this.f1, this.d);
        this.g1 = k09Var;
        k09Var.p(new f(this));
        this.g1.s(this.c.m2);
        this.f1.p0(new g(this));
        if (this.c.P() != null && !StringUtils.isNull(this.c.P().B1())) {
            PbFragment pbFragment2 = this.c;
            pbFragment2.showToast(pbFragment2.P().B1());
        }
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f0919e4);
        this.V0 = this.d.findViewById(R.id.obfuscated_res_0x7f090466);
        View findViewById2 = this.d.findViewById(R.id.obfuscated_res_0x7f0921cf);
        this.W0 = findViewById2;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById2.getLayoutParams();
        if (this.c.P() != null && this.c.P().k1()) {
            this.U0.setVisibility(0);
            if (layoutParams2 != null) {
                layoutParams2.height = 0;
                this.W0.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams2 != null) {
            layoutParams2.height = c2;
            this.W0.setLayoutParams(layoutParams2);
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = new PbReplyTitleViewHolder(this.c.getPageContext(), this.d.findViewById(R.id.obfuscated_res_0x7f091a5f));
        this.X0 = pbReplyTitleViewHolder;
        pbReplyTitleViewHolder.s(pbFragment.d0);
        this.X0.g.setVisibility(8);
        this.X0.r(this.P);
        this.X0.q(this.Q);
        this.c.registerListener(this.Q1);
        PbFragment pbFragment3 = this.c;
        this.H1 = new h59(pbFragment3, pbFragment3.getUniqueId());
        this.J1 = (PbFallingView) this.d.findViewById(R.id.obfuscated_res_0x7f090ab3);
        S2();
        this.J1.setAnimationListener(new h(this));
        o0();
        this.q0 = this.d.findViewById(R.id.obfuscated_res_0x7f0919cd);
        n0(az5.a());
        if (UbsABTestHelper.isPbForumGuideTestA() && P.p2() && qw8.b().e()) {
            if (this.p == null) {
                this.p = new o09(this.c.getActivity(), (ViewGroup) p1().findViewById(R.id.obfuscated_res_0x7f091a09));
            }
            n09 n09Var = new n09(this.l);
            this.q = n09Var;
            n09Var.d(new i(this));
        }
        this.r = new k19(this.c.R(), (ViewGroup) p1().findViewById(R.id.obfuscated_res_0x7f091a72));
        j19 j19Var = new j19(this.l);
        this.s = j19Var;
        j19Var.d(new j(this));
        this.M1 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0926ff);
        this.N1 = new k39(this.c.getActivity());
    }

    public void B3(boolean z2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) {
            View view2 = this.p0;
            if (z2) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view2.setVisibility(i3);
        }
    }

    public final boolean M1(lx8 lx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, lx8Var)) == null) {
            return n19.x(lx8Var);
        }
        return invokeL.booleanValue;
    }

    public void Q2(String str) {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, str) == null) && (pbListView = this.K) != null) {
            pbListView.F(str);
        }
    }

    public void T2(PbFragment.g3 g3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, g3Var) == null) {
            this.U1 = g3Var;
        }
    }

    public void U2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z2) == null) {
            this.o0 = z2;
        }
    }

    public void V2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) {
            this.E.m0(z2);
        }
    }

    public void W2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) {
            this.C1 = z2;
        }
    }

    public void X2(boolean z2) {
        zz8 zz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048670, this, z2) == null) && (zz8Var = this.E) != null) {
            zz8Var.n0(z2);
        }
    }

    public void Y2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z2) == null) {
            this.u1 = z2;
        }
    }

    public void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z2) == null) {
            this.E.p0(z2);
        }
    }

    public void a3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048683, this, z2) == null) {
            this.E.u0(z2);
        }
    }

    public final void a4(rr9 rr9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048684, this, rr9Var) == null) && rr9Var != null) {
            this.v1 = !StringUtils.isNull(rr9Var.b0());
            l29 l29Var = this.v;
            if (l29Var != null) {
                l29Var.t(rr9Var);
            }
        }
    }

    public final int b1(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048685, this, z2)) == null) {
            PbInterviewStatusView pbInterviewStatusView = this.S0;
            if (pbInterviewStatusView == null || pbInterviewStatusView.getVisibility() != 0 || !z2) {
                return 0;
            }
            return 0 + ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07026a);
        }
        return invokeZ.intValue;
    }

    public void b3(y65.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, gVar) == null) {
            this.Y1 = gVar;
            j59 j59Var = this.J;
            if (j59Var != null) {
                j59Var.f(gVar);
            }
        }
    }

    public void c3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, onClickListener) == null) {
            this.Z1 = onClickListener;
            zz8 zz8Var = this.E;
            if (zz8Var != null) {
                zz8Var.v0(onClickListener);
            }
        }
    }

    public void d3(String str) {
        v39 v39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048695, this, str) == null) && (v39Var = this.i) != null) {
            v39Var.b(str);
        }
    }

    public void d4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048696, this, str) == null) {
            this.c.showToast(str);
        }
    }

    public void e3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z2) == null) {
            this.h1 = z2;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                this.i1 = pbLandscapeListView.getHeaderViewsCount();
            }
        }
    }

    public void f3(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048704, this, a0Var) == null) {
            this.R = a0Var;
            this.E.z0(a0Var);
            this.s1.q(this.R);
        }
    }

    public void g3(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, bVar) == null) {
            this.S = bVar;
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null) {
                noNetworkView.a(bVar);
            }
        }
    }

    public boolean h0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048711, this, z2)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                this.n0.s();
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void h3(BdListView.p pVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, pVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnSrollToBottomListener(pVar);
        }
    }

    public void i3(AbsListView.OnScrollListener onScrollListener) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048719, this, onScrollListener) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setOnScrollListener(onScrollListener);
        }
    }

    public void i4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z2) == null) {
            this.h0 = z2;
        }
    }

    public void j3(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, onClickListener) == null) {
            this.E.D0(onClickListener);
        }
    }

    public void k2(un unVar) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048728, this, unVar) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.b0 = unVar;
            pbLandscapeListView.W = true;
        }
    }

    public void k3(int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i3) == null) {
            this.D1 = i3;
        }
    }

    public void l3(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, onLongClickListener) == null) {
            this.v.I(onLongClickListener);
            this.E.A0(onLongClickListener);
            nz8 nz8Var = this.s1;
            if (nz8Var != null) {
                nz8Var.r(onLongClickListener);
            }
        }
    }

    public void q4(lx8 lx8Var) {
        h29 h29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048760, this, lx8Var) == null) && (h29Var = this.t) != null) {
            h29Var.h(lx8Var, this.L0);
        }
    }

    public void r3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z2) == null) {
            this.v.K(z2);
        }
    }

    public void t3(int i3) {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048773, this, i3) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setSelection(i3);
        }
    }

    public void u3(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, list) == null) {
            this.q1 = list;
            p29 p29Var = this.r1;
            if (p29Var != null) {
                p29Var.q(list);
            }
        }
    }

    public void w2(View view2) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048784, this, view2) != null) || (sparseArray = (SparseArray) view2.getTag()) == null) {
            return;
        }
        v2(sparseArray, false);
    }

    public void a2(boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048682, this, new Object[]{Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            n09 n09Var = this.q;
            if (n09Var != null) {
                n09Var.b();
            }
            j19 j19Var = this.s;
            if (j19Var != null) {
                j19Var.b(z2, i3);
            }
        }
    }

    @SuppressLint({"CutPasteId"})
    public void c4(lx8 lx8Var, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048692, this, lx8Var, z2) != null) || lx8Var == null) {
            return;
        }
        n4(lx8Var, z2);
        w0();
    }

    public final void m3(rr9 rr9Var, lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048739, this, rr9Var, lx8Var) == null) {
            this.v.J(rr9Var, lx8Var);
        }
    }

    public void z2(hd5 hd5Var, int i3) {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048796, this, hd5Var, i3) == null) && (pbFallingView = this.J1) != null) {
            pbFallingView.A(hd5Var, this.c.getPageContext(), i3, false);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null) {
                pbListView.A();
                this.K.g();
            }
            v1();
        }
    }

    public void A1() {
        k39 k39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (k39Var = this.N1) != null) {
            k39Var.a();
        }
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            w0();
        }
    }

    public final void B1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.z == null && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
            this.z = new PbContentCollectionController(this.c.getActivity());
        }
    }

    public final void C1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.y == null && (pbFragment = this.c) != null) {
            this.y = new g29(pbFragment.getContext());
        }
    }

    public final void C2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.v.F(this.M0, this.N0, this.k1, this.j1);
        }
    }

    public void D0() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setForbidDragListener(true);
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.u == null) {
            this.u = new j29(this.c, this.l0);
        }
    }

    public zz8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.E;
        }
        return (zz8) invokeV.objValue;
    }

    public LinearLayout I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.v0;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void I2() {
        PbInterviewStatusView pbInterviewStatusView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (pbInterviewStatusView = this.S0) != null && pbInterviewStatusView.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.S0.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.S0.setLayoutParams(marginLayoutParams);
        }
    }

    public void I3() {
        w39 w39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && (w39Var = this.h) != null && !this.l1) {
            w39Var.w();
            this.l1 = true;
        }
    }

    public View J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            View view2 = this.Y;
            if (view2 != null) {
                return view2.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048613, this) == null) && this.w == null) {
            this.w = new i29(this.c, this.P);
        }
    }

    public void J2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.f != 2) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setNextPage(this.K);
            }
            this.f = 2;
        }
    }

    public void J3() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (pbLandscapeListView = this.l) != null) {
            pbLandscapeListView.setVisibility(0);
        }
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    public void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            if (this.K0 == null) {
                this.K0 = new s65(this.c.getPageContext());
            }
            this.K0.h(true);
        }
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.I0;
        }
        return invokeV.booleanValue;
    }

    public void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            this.E.l0(this.M0, false);
            this.E.d0();
        }
    }

    public PbFallingView N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.J1;
        }
        return (PbFallingView) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return false;
            }
            return pbLandscapeListView.J();
        }
        return invokeV.booleanValue;
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            M2();
            t1();
            this.g1.g();
            C3(false);
        }
    }

    public int O0() {
        InterceptResult invokeV;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
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
            EditorTools editorTools = this.n0;
            if (editorTools == null || editorTools.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void O2() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048634, this) != null) || (handler = this.R1) == null) {
            return;
        }
        Runnable runnable = this.S1;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        p pVar = new p(this);
        this.S1 = pVar;
        this.R1.postDelayed(pVar, 2000L);
    }

    public Button Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.s0;
        }
        return (Button) invokeV.objValue;
    }

    public final boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), this.X1);
        }
        return invokeV.booleanValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                return pbLandscapeListView.getHeaderViewsCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public TextView S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.v.v();
        }
        return (TextView) invokeV.objValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.J1.setFallingFeedbackListener(new t0(this));
        }
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            i59 i59Var = this.F0;
            if (i59Var != null) {
                return i59Var.g();
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public PbInterviewStatusView U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.S0;
        }
        return (PbInterviewStatusView) invokeV.objValue;
    }

    public void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.O.setVisibility(0);
        }
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.u1;
        }
        return invokeV.booleanValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            i59 i59Var = this.F0;
            if (i59Var == null) {
                return false;
            }
            return i59Var.i();
        }
        return invokeV.booleanValue;
    }

    public void V3() {
        zz8 zz8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && (zz8Var = this.E) != null) {
            zz8Var.F0();
        }
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            return P0(pbLandscapeListView.getLastVisiblePosition());
        }
        return invokeV.intValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            EditorTools editorTools = this.n0;
            if (editorTools != null && editorTools.w()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public BdTypeListView X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.l;
        }
        return (BdTypeListView) invokeV.objValue;
    }

    public void X3() {
        i59 i59Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048671, this) != null) || (i59Var = this.F0) == null) {
            return;
        }
        i59Var.o(2);
    }

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048673, this) == null) {
            F2(this.M0);
        }
    }

    public nz8 Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.s1;
        }
        return (nz8) invokeV.objValue;
    }

    public NoNetworkView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.m;
        }
        return (NoNetworkView) invokeV.objValue;
    }

    public View a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.N;
        }
        return (View) invokeV.objValue;
    }

    public View c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.M;
        }
        return (View) invokeV.objValue;
    }

    public PbListView d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.K;
        }
        return (PbListView) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            try {
                return Integer.parseInt(this.I.getText().toString(), 10);
            } catch (Exception unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }

    public void e4() {
        k39 k39Var;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048700, this) == null) && (k39Var = this.N1) != null && (linearLayout = this.M1) != null) {
            k39Var.c(linearLayout);
        }
    }

    public View f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.U0;
        }
        return (View) invokeV.objValue;
    }

    public void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048705, this) == null) {
            this.c.showProgressBar();
        }
    }

    public void g0() {
        i59 i59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048706, this) == null) && (i59Var = this.F0) != null) {
            i59Var.m(false);
        }
    }

    public PbFakeFloorModel g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.f1;
        }
        return (PbFakeFloorModel) invokeV.objValue;
    }

    public void g4() {
        PbFallingView pbFallingView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048710, this) == null) && (pbFallingView = this.J1) != null) {
            pbFallingView.C();
        }
    }

    public k09 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.g1;
        }
        return (k09) invokeV.objValue;
    }

    public void h4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048715, this) == null) && this.a2 != null) {
            while (this.a2.size() > 0) {
                TbImageView remove = this.a2.remove(0);
                if (remove != null) {
                    remove.R();
                }
            }
        }
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) {
            return this.P0;
        }
        return invokeV.intValue;
    }

    public View m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            this.E.e0(2);
            n2();
            X1();
            r4();
            l0();
        }
    }

    public PbThreadPostView n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.o;
        }
        return (PbThreadPostView) invokeV.objValue;
    }

    public final void n2() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            this.c.H5().E();
        }
    }

    public RelativeLayout o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return this.D;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public RelativeLayout p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void p3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048754, this) == null) && (pbFragment = this.c) != null && pbFragment.getBaseFragmentActivity() != null) {
            ri.z(this.c.getPageContext().getPageActivity(), this.c.getBaseFragmentActivity().getCurrentFocus());
        }
    }

    public void q1() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048757, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(8);
            }
            w39 w39Var = this.h;
            if (w39Var != null && (view2 = w39Var.f) != null) {
                view2.setVisibility(8);
            }
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048759, this) == null) {
            this.K.C();
            this.K.S();
        }
    }

    public void r1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048762, this) != null) || this.u0 == null) {
            return;
        }
        this.t0.setVisibility(8);
        this.u0.setVisibility(8);
        this.I0 = false;
    }

    public void t1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048771, this) == null) && (editorTools = this.n0) != null) {
            editorTools.q();
            p29 p29Var = this.r1;
            if (p29Var != null) {
                p29Var.m();
            }
        }
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048774, this) == null) {
            this.h.f();
            m25 m25Var = this.e0;
            if (m25Var != null) {
                m25Var.dismiss();
            }
            x0();
            d25 d25Var = this.F;
            if (d25Var != null) {
                d25Var.dismiss();
            }
            f25 f25Var = this.G;
            if (f25Var != null) {
                f25Var.e();
            }
        }
    }

    public void u1() {
        w39 w39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048775, this) == null) && (w39Var = this.h) != null) {
            w39Var.k();
        }
    }

    public void v0() {
        i59 i59Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048778, this) == null) && (i59Var = this.F0) != null) {
            i59Var.l(false);
        }
    }

    public void v1() {
        s65 s65Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048779, this) == null) && (s65Var = this.K0) != null) {
            s65Var.h(false);
        }
    }

    public final boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048782, this)) == null) {
            return this.t.b(this.L0);
        }
        return invokeV.booleanValue;
    }

    public void w1() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048783, this) == null) {
            if (this.A == null) {
                F1();
            }
            this.k.setVisibility(8);
            Handler handler = this.R1;
            if (handler != null && (runnable = this.S1) != null) {
                handler.removeCallbacks(runnable);
            }
        }
    }

    public void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048787, this) == null) {
            this.O.setVisibility(8);
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048790, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14693");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", k2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void y1() {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048791, this) == null) && (rightFloatLayerView = this.K1) != null) {
            rightFloatLayerView.c();
        }
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048792, this)) == null) {
            k19 k19Var = this.r;
            if (k19Var != null && k19Var.l()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y3() {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048793, this) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i3 = 0;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setVisibility(0);
            }
            w39 w39Var = this.h;
            if (w39Var != null && (view2 = w39Var.f) != null) {
                if (!TbadkCoreApplication.isLogin()) {
                    i3 = 8;
                }
                view2.setVisibility(i3);
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048794, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c14692");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", k2);
            TiebaStatic.log(statisticItem);
        }
    }

    public void z1() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048795, this) == null) && (editorTools = this.n0) != null) {
            editorTools.s();
        }
    }

    public final void A2() {
        w39 w39Var;
        lx8 lx8Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.u != null && (w39Var = this.h) != null && w39Var.j() != null && (lx8Var = this.M0) != null && lx8Var.M() != null && this.M0.M().isQuestionThread() && this.u.b() != null && this.u.b().getVisibility() == 0) {
            int[] iArr = new int[2];
            this.u.b().getLocationInWindow(iArr);
            boolean z3 = true;
            int height = iArr[1] + this.u.b().getHeight();
            if (this.u.b().getParent() != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            w39 w39Var2 = this.h;
            if (height > w39Var2.j().getBottom() && z2) {
                z3 = false;
            }
            w39Var2.z(z3, this.M0.M().getSpan_str());
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || !this.c.A5()) {
            return;
        }
        ViewStub viewStub = (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f091665);
        this.k = viewStub;
        viewStub.setVisibility(0);
        if (this.A == null) {
            this.A = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091664);
            cp5.a(this.c.getPageContext(), this.A);
        }
        if (this.B == null) {
            this.B = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091669);
        }
        if (this.C == null) {
            this.C = (TextView) this.A.findViewById(R.id.obfuscated_res_0x7f091668);
        }
        this.B.setOnClickListener(this.P);
        this.C.setOnClickListener(this.P);
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.c != null && this.n0 != null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 9).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.n0.j();
                r1();
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
        }
    }

    public int L0() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
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

    public final void M2() {
        PbFragment pbFragment;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null && this.n0 != null) {
            qg5.a().c(0);
            vg5 H5 = this.c.H5();
            H5.M();
            H5.K();
            if (H5.v() != null) {
                WriteImagesInfo v2 = H5.v();
                if (H5.t) {
                    i3 = 1;
                } else {
                    i3 = 9;
                }
                v2.setMaxImagesAllowed(i3);
            }
            H5.d0(SendView.h);
            H5.h(SendView.h);
            ze5 o2 = this.n0.o(23);
            ze5 o3 = this.n0.o(2);
            ze5 o4 = this.n0.o(5);
            if (o3 != null) {
                o3.display();
            }
            if (o4 != null) {
                o4.display();
            }
            if (o2 != null) {
                o2.hide();
            }
            this.n0.invalidate();
        }
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048749, this) == null) {
            this.c.hideProgressBar();
            lx8 lx8Var = this.M0;
            if (lx8Var != null && this.K != null && lx8Var.y() != null && this.M0.y().b() == 0) {
                this.K.x(this.M0.s());
                if (this.M0.s()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("fid", this.M0.l());
                    statisticItem.param("fname", this.M0.m());
                    statisticItem.param("tid", this.M0.O());
                    TiebaStatic.log(statisticItem);
                }
            }
            A0();
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.z(0L);
            }
            w0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
        if (r5.E1 == 1) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s0() {
        h59 h59Var;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048766, this) != null) || (h59Var = this.H1) == null) {
            return;
        }
        if (this.l != null && h59Var.a() != null && this.H1.a().getParent() != null) {
            i3 = this.l.getPositionForView(this.H1.a());
        } else {
            i3 = -1;
        }
        boolean z3 = false;
        if (i3 != -1) {
            if (this.H1.a().getTop() + j2 <= this.U0.getBottom()) {
                this.E1 = 1;
                z2 = true;
            } else {
                this.E1 = 0;
                z2 = false;
            }
        }
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
        if (this.E1 == 1) {
            z3 = true;
        }
        pbReplyTitleViewHolder.u(z3);
        this.H1.e(z2);
    }

    public final boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048781, this)) == null) {
            lx8 lx8Var = this.M0;
            if (lx8Var != null && lx8Var.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.c != null && this.u.b() != null && this.u.b().getVisibility() == 0 && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.M0.M().getThreadRecommendInfoDataList().get(0).businessType == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A3(int i3, SparseArray<Object> sparseArray) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i3, sparseArray) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().y1() != null && this.c.P().y1().n() != null && this.c.P().y1().k() != null && this.c.P().y1().k().getDeletedReasonInfo() != null) {
            if (sparseArray != null) {
                sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
            }
            l06 l06Var = new l06(this.c.P().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.P().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.P().y1().n().has_forum_rule.intValue());
            l06Var.i(this.c.P().y1().k().getId(), this.c.P().y1().k().getName());
            l06Var.h(this.c.P().y1().k().getImage_url());
            l06Var.j(this.c.P().y1().k().getUser_level());
            L3(sparseArray, i3, l06Var, this.c.P().y1().T(), true);
        }
    }

    public final void T3(d25 d25Var, int i3) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048655, this, d25Var, i3) == null) && (pbFragment = this.c) != null && d25Var != null) {
            if (this.y1 == null && this.t != null) {
                this.y1 = new j06(pbFragment.getPageContext(), this.t.c());
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
            h05 h05Var = new h05();
            h05Var.j(sparseArray);
            this.y1.B(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.y1.A(h05Var);
            if (i3 != 1 && i3 != 2) {
                str = "3";
            } else {
                str = "4";
            }
            this.y1.D(str);
            this.y1.C(new a0(this, d25Var));
        }
    }

    public void Y3(l05 l05Var, d25.e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048675, this, l05Var, eVar) != null) || l05Var == null) {
            return;
        }
        int a2 = l05Var.a();
        int h3 = l05Var.h();
        d25 d25Var = this.F;
        if (d25Var != null) {
            d25Var.show();
        } else {
            this.F = new d25(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0257, (ViewGroup) null);
            this.H = inflate;
            this.F.setContentView(inflate);
            this.F.setPositiveButton(R.string.obfuscated_res_0x7f0f0584, eVar);
            this.F.setNegativeButton(R.string.obfuscated_res_0x7f0f057a, new n0(this));
            this.F.setOnCalcelListener(new o0(this));
            this.F.create(this.c.getPageContext()).show();
        }
        EditText editText = (EditText) this.H.findViewById(R.id.obfuscated_res_0x7f0910e3);
        this.I = editText;
        editText.setText("");
        TextView textView = (TextView) this.H.findViewById(R.id.obfuscated_res_0x7f090811);
        if (a2 <= 0) {
            a2 = 1;
        }
        if (h3 <= 0) {
            h3 = 1;
        }
        textView.setText(MessageFormat.format(TbadkCoreApplication.getInst().getResources().getString(R.string.current_page), Integer.valueOf(a2), Integer.valueOf(h3)));
        this.c.getBaseFragmentActivity().ShowSoftKeyPadDelay(this.I, 150);
    }

    public boolean n4(lx8 lx8Var, boolean z2) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048745, this, lx8Var, z2)) == null) {
            if (lx8Var == null) {
                return false;
            }
            if (this.u != null) {
                if (lx8Var.M() != null && lx8Var.M().getIsNoTitle() == 0 && !lx8Var.M().isVideoThreadType()) {
                    if (lx8Var.M() != null) {
                        ThreadData M = lx8Var.M();
                        M.parserSpecTitleForFrsAndPb(true, F3(lx8Var));
                        M.setResource(3);
                        M.setPbTitle("2");
                    }
                    if (lx8Var.M().isBJHArticleThreadType()) {
                        this.v.G(this.l);
                        this.u.h(this.l);
                        this.u.a(this.l);
                        this.v.q(this.l);
                        this.v.L(this.M0);
                        if (M1(lx8Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.i(lx8Var);
                        }
                    } else {
                        this.v.L(this.M0);
                        if (M1(lx8Var)) {
                            this.u.h(this.l);
                        } else {
                            this.u.k(lx8Var);
                        }
                    }
                } else if (lx8Var.M().getIsNoTitle() == 1) {
                    if (lx8Var.M() != null) {
                        this.u.h(this.l);
                        this.v.L(this.M0);
                    }
                } else {
                    this.u.h(this.l);
                    this.v.L(this.M0);
                }
            }
            a4(lx8Var.V());
            b4(lx8Var);
            this.L0 = z2;
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public final void B2(PbReplyTitleViewHolder pbReplyTitleViewHolder, boolean z2) {
        boolean z3;
        int measuredHeight;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, pbReplyTitleViewHolder, z2) == null) && !this.j1 && this.U0 != null && this.h.j() != null) {
            View u2 = G0().u();
            if (u2 != null) {
                int[] iArr = new int[2];
                u2.getLocationInWindow(iArr);
                int i4 = iArr[1];
                if (i4 != 0) {
                    if (this.U0.getVisibility() == 0 && i4 - this.h.j().getBottom() <= this.U0.getHeight()) {
                        this.V0.setVisibility(0);
                        if (i4 > this.h.j().getBottom()) {
                            i3 = -(((this.U0.getHeight() + this.V0.getHeight()) + this.h.j().getBottom()) - u2.getBottom());
                        } else {
                            i3 = -this.U0.getHeight();
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
                        if (layoutParams.topMargin != i3) {
                            layoutParams.topMargin = i3;
                            this.U0.setLayoutParams(layoutParams);
                        }
                    } else {
                        this.V0.setVisibility(4);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
                        if (layoutParams2.topMargin != 0) {
                            layoutParams2.topMargin = 0;
                            this.U0.setLayoutParams(layoutParams2);
                        }
                    }
                }
            }
            int I = this.E.I();
            if (I > 0 && (pbReplyTitleViewHolder == null || pbReplyTitleViewHolder.getView().getParent() == null)) {
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null && I > pbLandscapeListView.getFirstVisiblePosition() - this.l.getHeaderViewsCount()) {
                    this.U0.setVisibility(4);
                    return;
                }
                this.U0.setVisibility(0);
                B3(false);
                this.h.a.hideBottomLine();
                if (this.U0.getParent() != null && ((ViewGroup) this.U0.getParent()).getHeight() <= this.U0.getTop()) {
                    this.U0.getParent().requestLayout();
                }
            } else if (pbReplyTitleViewHolder != null && pbReplyTitleViewHolder.getView() != null && pbReplyTitleViewHolder.g != null) {
                int top = pbReplyTitleViewHolder.getView().getTop();
                if (pbReplyTitleViewHolder.getView().getParent() != null) {
                    if (this.a1) {
                        this.Z0 = top;
                        this.a1 = false;
                    }
                    int i5 = this.Z0;
                    if (top < i5) {
                        i5 = top;
                    }
                    this.Z0 = i5;
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
                    measuredHeight = c2 - pbReplyTitleViewHolder.g.getMeasuredHeight();
                } else {
                    measuredHeight = this.h.j().getMeasuredHeight() - pbReplyTitleViewHolder.g.getMeasuredHeight();
                    this.h.a.hideBottomLine();
                }
                if (pbReplyTitleViewHolder.getView().getParent() == null && top <= this.Z0) {
                    this.U0.setVisibility(0);
                    B3(false);
                } else if (top < measuredHeight) {
                    this.U0.setVisibility(0);
                    B3(false);
                } else {
                    this.U0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
                if (z2) {
                    this.a1 = true;
                }
            } else {
                PbLandscapeListView pbLandscapeListView2 = this.l;
                if (pbLandscapeListView2 != null && pbLandscapeListView2.getFirstVisiblePosition() == 0) {
                    this.U0.setVisibility(4);
                    this.h.a.hideBottomLine();
                }
            }
        }
    }

    public void v2(SparseArray<Object> sparseArray, boolean z2) {
        int i3;
        k25 k25Var;
        k25 k25Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048780, this, sparseArray, z2) == null) {
            o25 o25Var = new o25(this.c.getContext());
            o25Var.t(this.c.getString(R.string.obfuscated_res_0x7f0f0319));
            o25Var.q(new u(this, z2));
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
                    k25Var2 = new k25(10, this.c.getString(R.string.obfuscated_res_0x7f0f0544), o25Var);
                } else {
                    k25Var2 = new k25(10, this.c.getString(R.string.obfuscated_res_0x7f0f0535), o25Var);
                }
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                k25Var2.d.setTag(sparseArray2);
                arrayList.add(k25Var2);
            }
            if ((sparseArray.get(R.id.tag_mul_del_post_type) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_mul_del_post_type)).booleanValue()) {
                k25 k25Var3 = new k25(13, this.c.getString(R.string.multi_delete), o25Var);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                k25Var3.d.setTag(sparseArray3);
                arrayList.add(k25Var3);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                sparseArray4.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
                k25 k25Var4 = new k25(11, this.c.getString(R.string.forbidden_person), o25Var);
                k25Var4.d.setTag(sparseArray4);
                arrayList.add(k25Var4);
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
                    k25Var = new k25(12, this.c.getString(R.string.un_mute), o25Var);
                } else {
                    k25Var = new k25(12, this.c.getString(R.string.obfuscated_res_0x7f0f0c93), o25Var);
                }
                k25Var.d.setTag(sparseArray5);
                arrayList.add(k25Var);
            }
            i39.f(arrayList);
            o25Var.m(arrayList, !UbsABTestHelper.isPBPlanA());
            m25 m25Var = new m25(this.c.getPageContext(), o25Var);
            this.T = m25Var;
            m25Var.l();
        }
    }

    public void C0(int i3, boolean z2, String str, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i3), Boolean.valueOf(z2), str, Boolean.valueOf(z3)}) == null) {
            this.c.hideProgressBar();
            if (z2 && z3) {
                PbFragment pbFragment = this.c;
                pbFragment.showToast(pbFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f13f6));
            } else if (z3) {
                if (qi.isEmpty(str)) {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0db6);
                }
                this.c.showToast(str);
            }
        }
    }

    public void u2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048776, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(e2, Integer.valueOf(f2));
            if (z2) {
                z3(sparseArray);
            } else {
                A3(i3, sparseArray);
            }
        }
    }

    public void C3(boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z2) != null) || this.u0 == null) {
            return;
        }
        if (this.c.H5() != null && this.c.H5().y()) {
            z3 = true;
        } else {
            z3 = false;
        }
        U2(z3);
        if (this.o0) {
            G3(z2);
        } else {
            s1(z2);
        }
    }

    public void G3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) && this.u0 != null && (textView = this.x0) != null) {
            textView.setText(R.string.obfuscated_res_0x7f0f05c6);
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.I0 = true;
        }
    }

    public void I1(lx8 lx8Var) {
        n95 pbAdFloatViewItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048609, this, lx8Var) != null) || lx8Var == null) {
            return;
        }
        if (lx8Var.o0()) {
            pbAdFloatViewItemData = lx8Var.Z();
        } else {
            pbAdFloatViewItemData = TbSingleton.getInstance().getPbAdFloatViewItemData();
        }
        if (pbAdFloatViewItemData != null && !pbAdFloatViewItemData.a()) {
            H1(lx8Var, pbAdFloatViewItemData);
        } else {
            y1();
        }
    }

    public final boolean S1(ThreadData threadData) {
        InterceptResult invokeL;
        String str;
        rr9 V;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null) {
                lx8 lx8Var = this.M0;
                if (lx8Var != null && (V = lx8Var.V()) != null && V.p() != null) {
                    str = V.p().getUserId();
                } else {
                    str = "";
                }
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void d2(Configuration configuration) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048694, this, configuration) != null) || configuration == null) {
            return;
        }
        t0();
        if (configuration.orientation == 2) {
            r1();
            t1();
        } else {
            N2();
        }
        k09 k09Var = this.g1;
        if (k09Var != null) {
            k09Var.g();
        }
        this.c.T5();
        this.D.setVisibility(8);
        this.h.v(false);
        this.c.M6(false);
    }

    public void i2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z2) == null) {
            if (z2) {
                I3();
            } else {
                u1();
            }
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            B2(this.b1.a, false);
        }
    }

    public final int j1(PbReplyTitleViewHolder pbReplyTitleViewHolder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048722, this, pbReplyTitleViewHolder)) == null) {
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

    public void j4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z2) == null) {
            this.h.B(z2);
            if (z2 && this.Q0) {
                this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setNextPage(this.K);
                }
                this.f = 2;
            }
        }
    }

    public void D2() {
        PbLandscapeListView pbLandscapeListView;
        int i3;
        int i4;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || (pbLandscapeListView = this.l) == null) {
            return;
        }
        int headerViewsCount = pbLandscapeListView.getHeaderViewsCount() - this.i1;
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
        this.b1.a = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
        PbReplyTitleViewHolder pbReplyTitleViewHolder = this.b1.a;
        int j1 = j1(pbReplyTitleViewHolder);
        int measuredHeight = this.D.getMeasuredHeight() + ((int) this.D.getY());
        boolean z3 = true;
        if (this.U0.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.D.getY() >= 0.0f) {
            z3 = false;
        }
        if ((z2 && pbReplyTitleViewHolder != null) || i3 >= this.E.I() + this.l.getHeaderViewsCount()) {
            if (pbReplyTitleViewHolder != null) {
                i5 = pbReplyTitleViewHolder.g.getMeasuredHeight();
            }
            if (z3) {
                this.l.setSelectionFromTop(this.E.I() + this.l.getHeaderViewsCount(), c2 - i5);
            } else {
                this.l.setSelectionFromTop(this.E.I() + this.l.getHeaderViewsCount(), this.h.j().getMeasuredHeight() - i5);
            }
        } else {
            this.l.setSelectionFromTop(i3, i4);
        }
        if (this.O0 != 6) {
            return;
        }
        this.l.setOnLayoutListener(new l(this, j1, pbReplyTitleViewHolder, z2, measuredHeight, i3, i4));
    }

    public void e2() {
        NoNetworkView.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            o09 o09Var = this.p;
            if (o09Var != null) {
                o09Var.l();
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && relativeLayout.getHandler() != null) {
                this.d.getHandler().removeCallbacksAndMessages(null);
            }
            i59 i59Var = this.F0;
            if (i59Var != null) {
                i59Var.k();
            }
            y09 y09Var = this.w1;
            if (y09Var != null) {
                y09Var.c();
            }
            PbTopTipView pbTopTipView = this.n1;
            if (pbTopTipView != null) {
                pbTopTipView.g();
            }
            this.c.hideProgressBar();
            NoNetworkView noNetworkView = this.m;
            if (noNetworkView != null && (bVar = this.S) != null) {
                noNetworkView.e(bVar);
            }
            cr9.d();
            t0();
            A0();
            if (this.e1 != null) {
                sg.a().removeCallbacks(this.e1);
            }
            PbInterviewStatusView pbInterviewStatusView = this.S0;
            if (pbInterviewStatusView != null) {
                pbInterviewStatusView.m();
            }
            MessageManager.getInstance().unRegisterListener(this.O1);
            this.R1 = null;
            this.g.removeCallbacksAndMessages(null);
            this.E.e0(3);
            View view2 = this.e;
            if (view2 != null) {
                view2.setBackgroundDrawable(null);
            }
            zz8 zz8Var = this.E;
            if (zz8Var != null) {
                zz8Var.g0();
            }
            p29 p29Var = this.r1;
            if (p29Var != null) {
                p29Var.l();
            }
            l29 l29Var = this.v;
            if (l29Var != null) {
                l29Var.D();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.q(null);
            }
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView != null) {
                pbLandscapeListView.setOnLayoutListener(null);
                this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.a);
                this.l.setListViewDragListener(null);
                this.l.K();
                this.l = null;
            }
            AgreeView agreeView = this.A0;
            if (agreeView != null) {
                agreeView.setAgreeLongClickListener(null);
                this.A0.setAfterClickListener(null);
            }
            z0 z0Var = this.b1;
            if (z0Var != null) {
                z0Var.a = null;
            }
        }
    }

    public void h2() {
        rr9 rr9Var;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048713, this) != null) || this.c == null) {
            return;
        }
        if (!this.C1 && this.D1 != 17) {
            if (this.k1 && !this.j1 && (rr9Var = this.N0) != null && rr9Var.p() != null) {
                int i4 = 2;
                if (this.c.y0()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                if (!this.j1) {
                    i4 = 1;
                }
                r49.q("c12601", i4, i3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.c.getPageContext().getPageActivity(), this.N0.p().getUserId(), this.N0.p().getUserName(), this.c.P().X0(), AddFriendActivityConfig.TYPE_PB_HEAD)));
                return;
            }
            return;
        }
        lx8 lx8Var = this.M0;
        if (lx8Var != null && lx8Var.k() != null && !qi.isEmpty(this.M0.k().getName())) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.c.getContext()).createNormalCfg(this.M0.k().getName(), null)));
            TiebaStatic.log(new StatisticItem("c13853").param("post_id", this.M0.O()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.M0.k().getId()));
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            if (!this.c.checkUpIsLogin()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                r49.r("c10517", this.k0, 2);
            } else if (!this.c.c5()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 8).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            } else {
                vg5 H5 = this.c.H5();
                if (H5 != null && (H5.x() || H5.z())) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 10).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.c.H5().w(false, null);
                    return;
                }
                if (this.n0 != null) {
                    G1();
                }
                EditorTools editorTools = this.n0;
                if (editorTools != null) {
                    this.I0 = false;
                    if (editorTools.p(2) != null) {
                        cr9.c(this.c.getPageContext(), (View) this.n0.p(2).m, false, l2);
                    }
                }
                r1();
            }
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048733, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 1).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
            if (!DialogLoginHelper.checkUpIsLogin(new LoginDialogData(this.c.getActivity(), LoginDialogData.PB_BOTTOM_REPLY_RESULT_PAGE))) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            l4();
            this.c.v6();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && pbFragment.P() != null && this.c.P().y1() != null && this.c.P().y1().M() != null && this.c.P().y1().M().getAuthor() != null) {
                TiebaStatic.log(new StatisticItem("c13701").param("tid", this.c.P().S1()).param("fid", this.c.P().y1().l()).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                TiebaStatic.log(new StatisticItem("c13402").param("tid", this.c.P().b).param("fid", this.c.P().y1().l()).param("obj_locate", 1).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public final void r4() {
        PbFragment pbFragment;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().G != null && this.c.P().G.M() != null && this.c.P().G.M().isXiuXiuThread()) {
            ThreadData M = this.c.P().G.M();
            int i4 = 0;
            if (this.c.P().d1()) {
                i3 = 1;
            } else if (this.c.P().g1()) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            ItemInfo itemInfo = TbSingleton.getInstance().getFrsItemInfoCache().get(M.getForum_name());
            if (itemInfo != null) {
                i4 = itemInfo.id.intValue();
                str = itemInfo.name;
            } else {
                str = "";
            }
            new StatisticItem("c15062").addParam("obj_locate", i3).addParam("fid", M.getFid()).addParam("fname", M.getForum_name()).addParam("post_id", M.getTid()).addParam("obj_id", i4).addParam("obj_name", str).eventStat();
        }
    }

    public void D3(lx8 lx8Var) {
        rr9 rr9Var;
        w39 w39Var;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, lx8Var) == null) && lx8Var != null && (rr9Var = this.N0) != null && rr9Var.p() != null && (w39Var = this.h) != null) {
            boolean z3 = !this.j1;
            this.k1 = z3;
            w39Var.A(z3);
            if (this.c.I5() != null) {
                this.c.I5().s(this.k1);
            }
            C2();
            PbFragment pbFragment = this.c;
            if (pbFragment != null && !pbFragment.y0() && !ListUtils.isEmpty(lx8Var.o())) {
                k15 k15Var = lx8Var.o().get(0);
                if (k15Var != null) {
                    this.h.D(lx8Var, k15Var.d(), k15Var.b(), k15Var.a(), k15Var.e());
                }
            } else if (lx8Var.k() != null) {
                w39 w39Var2 = this.h;
                String name = lx8Var.k().getName();
                String id = lx8Var.k().getId();
                String image_url = lx8Var.k().getImage_url();
                if (lx8Var.k().isLike() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                w39Var2.D(lx8Var, name, id, image_url, z2);
            }
            if (this.k1) {
                this.v.Q(lx8Var, this.N0, this.i0);
                View view2 = this.W0;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
                if (this.t1 == null) {
                    this.t1 = new m0(this);
                }
                PbLandscapeListView pbLandscapeListView = this.l;
                if (pbLandscapeListView != null) {
                    pbLandscapeListView.setListViewDragListener(this.t1);
                    return;
                }
                return;
            }
            View view3 = this.W0;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            this.v.Q(lx8Var, this.N0, this.i0);
            this.t1 = null;
            PbLandscapeListView pbLandscapeListView2 = this.l;
            if (pbLandscapeListView2 != null) {
                pbLandscapeListView2.setListViewDragListener(null);
            }
        }
    }

    public final void F2(lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, lx8Var) == null) && lx8Var != null && lx8Var.M() != null) {
            m4(lx8Var);
            ImageView imageView = this.B0;
            if (imageView != null && imageView.getContext() != null) {
                if (lx8Var.q()) {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
                } else {
                    WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
                }
            }
            String F0 = F0(lx8Var.M().getReply_num());
            TextView textView = this.H0;
            if (textView != null) {
                textView.setText(F0);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, lx8Var.M()));
            E2(lx8Var.M().getAgreeData(), lx8Var.M().getAgreeNum());
            if (this.A0 != null && lx8Var.M() != null) {
                this.A0.setThreadData(lx8Var.M());
                int i3 = 1;
                if (lx8Var.M().getAgreeData() != null) {
                    lx8Var.M().getAgreeData().isInThread = true;
                }
                this.A0.setData(lx8Var.M().getAgreeData());
                py4 py4Var = new py4();
                py4Var.b = 26;
                if (lx8Var.M().isVideoThreadType() && lx8Var.M().getThreadVideoInfo() != null) {
                    i3 = 2;
                }
                py4Var.c = i3;
                PbFragment pbFragment = this.c;
                if (pbFragment != null && pbFragment.P() != null) {
                    py4Var.j = this.c.P().getFromForumId();
                    py4Var.f = this.c.P().x1();
                }
                this.A0.setStatisticData(py4Var);
            }
        }
    }

    public void H3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, view2) != null) || o65.m().i("show_long_press_collection_tips", false)) {
            return;
        }
        Rect rect = new Rect();
        this.u0.getGlobalVisibleRect(rect);
        int i3 = rect.bottom;
        int i4 = rect.top;
        view2.getGlobalVisibleRect(rect);
        int i5 = rect.bottom;
        FrameLayout frameLayout = new FrameLayout(this.c.getContext());
        frameLayout.setBackgroundResource(R.drawable.pic_sign_tip);
        TextView textView = new TextView(this.c.getContext());
        this.p1 = textView;
        textView.setText(R.string.obfuscated_res_0x7f0f04bd);
        this.p1.setGravity(17);
        this.p1.setPadding(ri.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0, ri.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f0701e8), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = ri.g(this.c.getContext(), R.dimen.obfuscated_res_0x7f070253);
        if (this.p1.getParent() == null) {
            frameLayout.addView(this.p1, layoutParams);
        }
        PopupWindow popupWindow = new PopupWindow(this.c.getContext());
        this.o1 = popupWindow;
        popupWindow.setContentView(frameLayout);
        this.o1.setHeight(-2);
        this.o1.setWidth(-2);
        this.o1.setFocusable(true);
        this.o1.setOutsideTouchable(false);
        this.o1.setBackgroundDrawable(new ColorDrawable(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent)));
        GreyUtil.grey(this.o1);
        PbLandscapeListView pbLandscapeListView = this.l;
        if (pbLandscapeListView != null) {
            pbLandscapeListView.postDelayed(new s0(this, i5, i3, i4, view2), 100L);
        }
        o65.m().w("show_long_press_collection_tips", true);
    }

    public void K1(lx8 lx8Var) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, lx8Var) == null) {
            int i3 = 0;
            this.E.l0(lx8Var, false);
            this.E.d0();
            w0();
            nz8 nz8Var = this.s1;
            if (nz8Var != null) {
                nz8Var.n();
            }
            ArrayList<rr9> F = lx8Var.F();
            if (lx8Var.y().b() == 0 || F == null || F.size() < lx8Var.y().e()) {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).D() != 1)) {
                    if (lx8Var.y().b() == 0) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.K.m();
                } else {
                    z0 z0Var = this.b1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.b1.a.getView().getTop() < 0) {
                            bottom = this.b1.a.getView().getHeight();
                        } else {
                            bottom = this.b1.a.getView().getBottom();
                        }
                        i3 = bottom;
                    }
                    if (this.c.c6()) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f70), i3);
                    } else {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f71), i3);
                    }
                }
            }
            F2(lx8Var);
        }
    }

    public void R3(AdapterView.OnItemClickListener onItemClickListener) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onItemClickListener) == null) {
            h25 h25Var = this.g0;
            if (h25Var != null) {
                h25Var.d();
                this.g0 = null;
            }
            if (this.M0 == null) {
                return;
            }
            ArrayList<q25> arrayList = new ArrayList<>();
            String string = this.c.getContext().getString(R.string.all_person);
            boolean z5 = false;
            if (this.M0.J() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(new q25(string, "", z2, Integer.toString(1)));
            String string2 = this.c.getContext().getString(R.string.my_fans);
            if (this.M0.J() == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            arrayList.add(new q25(string2, "", z3, Integer.toString(5)));
            String string3 = this.c.getContext().getString(R.string.my_attentions);
            if (this.M0.J() == 3) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList.add(new q25(string3, "", z4, Integer.toString(6)));
            String string4 = this.c.getContext().getString(R.string.myself_only);
            if (this.M0.J() == 4) {
                z5 = true;
            }
            arrayList.add(new q25(string4, "", z5, Integer.toString(7)));
            h25 h25Var2 = new h25(this.c.getPageContext());
            h25Var2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.g0 = h25Var2;
            h25Var2.k(arrayList, onItemClickListener);
            h25Var2.c();
            this.g0.n();
        }
    }

    public final String E0(long j3) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j3)) == null) {
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

    public final String F0(int i3) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i3)) == null) {
            if (i3 == 0) {
                return this.c.getString(R.string.obfuscated_res_0x7f0f0f55);
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

    public void P2(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, editorTools) == null) {
            this.n0 = editorTools;
            editorTools.setOnCancelClickListener(new r(this));
            this.n0.setId(R.id.obfuscated_res_0x7f0919d8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            if (this.n0.getParent() == null) {
                this.d.addView(this.n0, layoutParams);
            }
            this.n0.y(TbadkCoreApplication.getInst().getSkinType());
            this.n0.setActionListener(24, new s(this));
            t1();
            this.c.H5().g(new t(this));
        }
    }

    public void Z3(boolean z2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048679, this, z2) == null) && this.l != null && (textView = this.T0) != null && this.e != null) {
            if (z2) {
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                    this.l.removeHeaderView(this.T0);
                    this.l.setTextViewAdded(false);
                }
                if (this.T0.getLayoutParams() instanceof AbsListView.LayoutParams) {
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.T0.getLayoutParams();
                    layoutParams.height = c2;
                    this.T0.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            if (textView.getLayoutParams() instanceof AbsListView.LayoutParams) {
                AbsListView.LayoutParams layoutParams2 = (AbsListView.LayoutParams) this.T0.getLayoutParams();
                layoutParams2.height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT) + b1(true);
                this.T0.setLayoutParams(layoutParams2);
            }
            I2();
        }
    }

    public void b2(hr9 hr9Var) {
        lx8 lx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048686, this, hr9Var) == null) && hr9Var != null && hr9Var.b != null && (lx8Var = this.M0) != null && lx8Var.M() != null && this.M0.M().getAgreeData() != null) {
            AgreeData agreeData = this.M0.M().getAgreeData();
            String str = hr9Var.b.nid;
            if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                BaijiahaoData baijiahaoData = agreeData.baijiahaoData;
                if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                    return;
                }
            } else {
                String str2 = hr9Var.b.threadId;
                String str3 = agreeData.threadId;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
            }
            AgreeData agreeData2 = hr9Var.b;
            E2(agreeData2, agreeData2.agreeNum);
        }
    }

    public final void b4(lx8 lx8Var) {
        boolean z2;
        j29 j29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048688, this, lx8Var) == null) && !this.v1 && lx8Var != null && lx8Var.M() != null && !lx8Var.M().isVideoThreadType()) {
            ThreadData M = lx8Var.M();
            boolean z3 = false;
            if (M.getIs_good() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (M.getIs_top() == 1) {
                z3 = true;
            }
            l29 l29Var = this.v;
            if (l29Var != null) {
                l29Var.u(lx8Var, z2, z3);
            }
            if (M.isShowTitle() && (j29Var = this.u) != null && j29Var.d() != null) {
                n19.b(this.u.d(), M.isHeadLinePost, M.isGoodThread(), M.isTopThread());
            }
            if (G0() != null) {
                G0().G0(lx8Var);
            }
        }
    }

    public void f2(TbRichText tbRichText) {
        lx8 lx8Var;
        rr9 rr9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, tbRichText) == null) && (lx8Var = this.M0) != null && lx8Var.F() != null && !this.M0.F().isEmpty() && tbRichText != null && !StringUtils.isNull(tbRichText.getAuthorId())) {
            for (int i3 = 0; i3 < this.M0.F().size() && (rr9Var = this.M0.F().get(i3)) != null && rr9Var.p() != null && !StringUtils.isNull(rr9Var.p().getUserId()); i3++) {
                if (this.M0.F().get(i3).p().getUserId().equals(tbRichText.getAuthorId())) {
                    nz8 nz8Var = this.s1;
                    if (nz8Var != null && nz8Var.l()) {
                        C3(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void m4(lx8 lx8Var) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, lx8Var) == null) {
            if (lx8Var != null && AntiHelper.o(lx8Var.M())) {
                i59 i59Var = this.F0;
                if (i59Var != null) {
                    i59Var.l(false);
                    this.F0.k();
                }
                ViewGroup.LayoutParams layoutParams = this.C0.getLayoutParams();
                layoutParams.height = -2;
                layoutParams.width = -2;
                this.C0.setLayoutParams(layoutParams);
                WebPManager.setPureDrawable(this.C0, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
                return;
            }
            i59 i59Var2 = this.F0;
            if (i59Var2 != null && i59Var2.h()) {
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
            WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_bottom_share26, i3, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void p4(boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z2) == null) {
            zz8 zz8Var = this.E;
            if (zz8Var != null) {
                zz8Var.y0(z2);
                this.E.d0();
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder = this.X0;
            if (pbReplyTitleViewHolder != null) {
                pbReplyTitleViewHolder.p(z2);
            }
            PbReplyTitleViewHolder pbReplyTitleViewHolder2 = this.b1.a;
            if (pbReplyTitleViewHolder2 != null) {
                pbReplyTitleViewHolder2.p(z2);
            }
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                pbFragment.L6(z2);
            }
            if (z2) {
                l39.d(this.c.getPageContext(), this.c.P(), this.c.K5());
            }
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_BATCH_MULTI_DEL_CLICK);
            lx8 lx8Var = this.M0;
            if (lx8Var != null) {
                str = lx8Var.l();
            } else {
                str = "0";
            }
            TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", "1"));
        }
    }

    public void s1(boolean z2) {
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048767, this, z2) == null) && this.u0 != null && this.x0 != null) {
            TbSingleton tbSingleton = TbSingleton.getInstance();
            lx8 lx8Var = this.M0;
            if (lx8Var != null && lx8Var.o0()) {
                z3 = true;
            } else {
                z3 = false;
            }
            lx8 lx8Var2 = this.M0;
            if (lx8Var2 != null && lx8Var2.p0()) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.x0.setText(tbSingleton.getAdVertiComment(z3, z4, i1()));
            if (z2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.u0.startAnimation(alphaAnimation);
            }
            this.t0.setVisibility(0);
            this.u0.setVisibility(0);
            this.I0 = true;
        }
    }

    public final void z3(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048797, this, sparseArray) != null) || this.c == null) {
            return;
        }
        if (sparseArray != null) {
            sparseArray.put(R.id.tag_is_block_thread, Boolean.TRUE);
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f133e, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c3, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.R());
        tBAlertBuilder.w(R.string.musk_my_thread_confirm);
        tBAlertBuilder.m(R.string.musk_my_thread_confirm_subtitle);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new y(this, z2, sparseArray));
        aVar2.a(new z(this, z2));
    }

    public final void E1(lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048593, this, lx8Var) != null) || lx8Var == null || lx8Var.M() == null || !lx8Var.M().isInterviewLive() || this.S0 != null) {
            return;
        }
        PbInterviewStatusView pbInterviewStatusView = (PbInterviewStatusView) this.R0.inflate();
        this.S0 = pbInterviewStatusView;
        pbInterviewStatusView.setOnClickListener(this.P);
        this.S0.setCallback(this.c.z5());
        this.S0.setData(this.c, lx8Var);
    }

    public final int P0(int i3) {
        InterceptResult invokeI;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i3)) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            if (pbLandscapeListView == null) {
                return 0;
            }
            in adapter2 = pbLandscapeListView.getAdapter2();
            if (adapter2 == null) {
                return i3;
            }
            if (i3 < adapter2.getCount() && i3 >= 0 && (adapter2.getItem(i3) instanceof qr9)) {
                i3++;
            }
            int o2 = (adapter2.o() + adapter2.m()) - 1;
            if (i3 > o2) {
                i3 = o2;
            }
            if (this.l.getAdapter2() != null && (this.l.getAdapter2() instanceof in)) {
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

    public void R2(String str) {
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048646, this, str) == null) && this.K != null) {
            int i3 = 0;
            z0 z0Var = this.b1;
            if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                i3 = this.b1.a.getView().getTop() < 0 ? this.b1.a.getView().getHeight() : this.b1.a.getView().getBottom();
            }
            this.K.I(str, i3);
        }
    }

    public void n0(boolean z2) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048741, this, z2) == null) {
            PbLandscapeListView pbLandscapeListView = this.l;
            int i5 = 0;
            if (pbLandscapeListView != null) {
                if (z2) {
                    SkinManager.setBackgroundColor(pbLandscapeListView, R.color.CAM_X0202);
                } else {
                    pbLandscapeListView.setBackgroundResource(0);
                }
            }
            View view2 = this.q0;
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
                pbListView.M(i3);
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

    public void s3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, str) == null) {
            this.x0.performClick();
            if (!StringUtils.isNull(str) && this.c.H5() != null && this.c.H5().s() != null && this.c.H5().s().i() != null) {
                EditText i3 = this.c.H5().s().i();
                i3.setText(str);
                i3.setSelection(str.length());
            }
        }
    }

    public final void E2(AgreeData agreeData, long j3) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048594, this, agreeData, j3) == null) && agreeData != null && (textView = this.G0) != null) {
            if (j3 > 0) {
                if (agreeData.agreeType == 2 && agreeData.hasAgree) {
                    textView.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.G0.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                }
                this.G0.setText(E0(j3));
                this.G0.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void p2(AbsListView absListView, int i3) {
        RightFloatLayerView rightFloatLayerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048753, this, absListView, i3) == null) {
            if (i3 == 0) {
                this.b1.a = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
                B2(this.b1.a, true);
                s0();
                this.E.k0(true);
            }
            this.E.j0();
            if (i3 == 0) {
                RightFloatLayerView rightFloatLayerView2 = this.K1;
                if (rightFloatLayerView2 != null) {
                    rightFloatLayerView2.p();
                }
                m0();
            } else if (i3 == 1) {
                RightFloatLayerView rightFloatLayerView3 = this.K1;
                if (rightFloatLayerView3 != null) {
                    rightFloatLayerView3.o();
                }
            } else if (i3 == 2 && (rightFloatLayerView = this.K1) != null) {
                rightFloatLayerView.q();
            }
        }
    }

    public final void E3(SparseArray<Object> sparseArray, @StringRes int i3, @StringRes int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(1048595, this, sparseArray, i3, i4) != null) || this.c == null) {
            return;
        }
        TBAlertConfig.a aVar = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0535, TBAlertConfig.OperateBtnStyle.MAIN);
        TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c3, TBAlertConfig.OperateBtnStyle.SECONDARY);
        TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.c.R());
        tBAlertBuilder.w(i3);
        tBAlertBuilder.m(i4);
        tBAlertBuilder.o(true);
        tBAlertBuilder.u(aVar2, aVar);
        tBAlertBuilder.j(false);
        AlertDialog z2 = tBAlertBuilder.z();
        aVar.a(new w(this, z2, sparseArray));
        aVar2.a(new x(this, z2));
    }

    public final boolean F3(lx8 lx8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, lx8Var)) == null) {
            if (lx8Var == null || lx8Var.M() == null) {
                return false;
            }
            if (lx8Var.M().getIsLive() != 1 && lx8Var.M().getThreadType() != 33 && ((lx8Var.M().getTopicData() == null || lx8Var.M().getTopicData().a() == 0) && lx8Var.M().getIs_top() != 1 && lx8Var.M().getIs_good() != 1 && !lx8Var.M().isActInfo() && !lx8Var.M().isInterviewLive() && !lx8Var.M().isVoteThreadType() && lx8Var.M().getYulePostActivityData() == null && qi.isEmpty(lx8Var.M().getCategory()) && !lx8Var.M().isGodThread() && !lx8Var.M().isRealGod())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void k4(kx8 kx8Var) {
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048730, this, kx8Var) != null) || kx8Var == null) {
            return;
        }
        this.h.C();
        if (!StringUtils.isNull(kx8Var.b)) {
            this.h.y(kx8Var.b);
        }
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15a4);
        int e3 = pg.e(kx8Var.a, 0);
        if (e3 != 100) {
            if (e3 != 300) {
                if (e3 != 400) {
                    string = "";
                } else {
                    string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1519);
                }
            } else {
                string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f032b);
            }
        } else {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f12c1);
        }
        this.c.showNetRefreshView(this.d, String.format(string2, string), null, TbadkCoreApplication.getInst().getResources().getString(R.string.appeal_restore), true, new k0(this, kx8Var.c));
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, str) == null) {
            if (str.contains("_")) {
                str = str.replace("_", "\n");
            }
            d25 d25Var = new d25(this.c.getPageContext().getPageActivity());
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.title_view);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(3);
            textView.setText(str);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setVisibility(8);
            d25Var.setContentView(inflate);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e2, Integer.valueOf(h2));
            d25Var.setYesButtonTag(sparseArray);
            d25Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1781, this.c);
            d25Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03c3, new q0(this));
            d25Var.create(this.c.getPageContext()).show();
        }
    }

    public void x2(@NonNull View view2) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048788, this, view2) == null) && this.A0.getData() != null && this.A0.getData().hasAgree && this.c.getActivity() != null) {
            pw8 pw8Var = new pw8(this.c.getContext());
            int g3 = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds774);
            int g4 = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708d1);
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int i3 = iArr[0];
            int i4 = iArr[1];
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g4, g3);
            layoutParams.leftMargin = ((view2.getWidth() / 2) + i3) - ((int) ((g4 * 1) / 1.45d));
            layoutParams.topMargin = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            pw8Var.k(g3);
            pw8Var.j(layoutParams);
            pw8Var.i(false);
            if (this.M0 != null && (pbFragment = this.c) != null) {
                pw8Var.n(true, pbFragment.getActivity().findViewById(16908290), 0, i4, this.M0.O(), this.M0.l());
            }
            pw8Var.l(new n(this));
        }
    }

    public void G2(int i3, lx8 lx8Var, boolean z2, int i4) {
        rr9 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i3), lx8Var, Boolean.valueOf(z2), Integer.valueOf(i4)}) == null) && i3 > 0 && lx8Var != null && (V = lx8Var.V()) != null && V.p() != null) {
            MetaData p2 = V.p();
            p2.setGiftNum(p2.getGiftNum() + i3);
        }
    }

    public final void H1(lx8 lx8Var, n95 n95Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, lx8Var, n95Var) == null) && this.L1 != null && lx8Var != null && n95Var != null && this.c.getContext() != null) {
            if (!RightFloatLayerView.k()) {
                y1();
                return;
            }
            if (this.K1 == null) {
                RightFloatLayerView E = RightFloatLayerLottieView.E(n95Var, this.c.getContext());
                this.K1 = E;
                E.setPageContext(this.c.getPageContext());
                this.L1.removeAllViews();
                this.L1.addView(this.K1);
            }
            if ((this.J1.getTag() instanceof Boolean) && !((Boolean) this.J1.getTag()).booleanValue()) {
                this.K1.setAutoCompleteShown(false);
                this.K1.setTag(this.J1);
                this.K1.c();
            }
            if (n95Var.a()) {
                return;
            }
            this.K1.setData(n95Var);
            this.K1.setLogoListener(new r0(this, n95Var));
            this.K1.setFeedBackListener(new u0(this, n95Var));
        }
    }

    public void H2(lx8 lx8Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{lx8Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            O3(lx8Var, z2, i3, i4);
            this.v.C(i4);
        }
    }

    public void r2(int i3, String str, int i4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048763, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2)}) == null) {
            s2(i3, str, i4, z2, null);
        }
    }

    public final void K2() {
        PbFragment pbFragment;
        WaterRippleView waterRippleView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || (pbFragment = this.c) == null || pbFragment.getActivity() == null || (waterRippleView = this.y0) == null) {
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

    public void L2() {
        PbLandscapeListView pbLandscapeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (pbLandscapeListView = this.l) != null) {
            this.y.d(pbLandscapeListView);
            this.u.h(this.l);
            this.v.G(this.l);
            this.w.d(this.l);
            this.t.f(this.l);
        }
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            View view2 = this.Y0;
            if (view2 == null || view2.getParent() == null || this.K.o()) {
                return false;
            }
            int bottom = this.Y0.getBottom();
            Rect rect = new Rect();
            this.Y0.getWindowVisibleDisplayFrame(rect);
            if (bottom <= 0 || bottom > rect.bottom) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            lx8 lx8Var = this.M0;
            if (lx8Var == null || lx8Var.k() == null || "0".equals(this.M0.k().getId())) {
                return true;
            }
            return "me0407".equals(this.M0.k().getName());
        }
        return invokeV.booleanValue;
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            PbFallingView pbFallingView = this.J1;
            if (pbFallingView != null) {
                pbFallingView.setTag(Boolean.TRUE);
            }
            RightFloatLayerView rightFloatLayerView = this.K1;
            if (rightFloatLayerView != null && rightFloatLayerView.getTag() == this.J1) {
                this.K1.setTag(null);
                this.K1.setAutoCompleteShown(true);
                this.K1.d();
            }
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            PbListView pbListView = this.K;
            if (pbListView != null && !TextUtils.isEmpty(pbListView.i())) {
                return this.K.i().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            if (!qi.isEmpty(this.A1)) {
                return this.A1;
            }
            if (this.c != null) {
                this.A1 = TbadkCoreApplication.getInst().getResources().getString(n19.g());
            }
            return this.A1;
        }
        return (String) invokeV.objValue;
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048721, this) == null) && this.M0 != null && UbsABTestHelper.isResizeInduceSharingABTest() && !m39.h(this.M0.O())) {
            this.F0.f();
            m39.b(this.M0.O());
        }
    }

    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            h4();
            this.E.e0(1);
            o09 o09Var = this.p;
            if (o09Var != null) {
                o09Var.k();
            }
            k19 k19Var = this.r;
            if (k19Var != null) {
                k19Var.j();
            }
            RightFloatLayerView rightFloatLayerView = this.K1;
            if (rightFloatLayerView != null && (rightFloatLayerView instanceof RightFloatLayerLottieView)) {
                ((RightFloatLayerLottieView) rightFloatLayerView).G(600);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
        }
    }

    public final void l4() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048735, this) == null) && (pbFragment = this.c) != null && pbFragment.H5() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(!this.c.H5().y())));
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048746, this) == null) {
            nz8 nz8Var = new nz8(this.c, this, (ViewStub) this.d.findViewById(R.id.obfuscated_res_0x7f09172d));
            this.s1 = nz8Var;
            nz8Var.o(this.P);
            this.s1.p(this.U);
            this.s1.q(this.R);
            this.s1.o(this.P);
            this.s1.s(this.l0);
        }
    }

    public final void o4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048750, this) != null) || !this.c.A5()) {
            return;
        }
        if (this.c.F5() == -1) {
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0110, 1);
        }
        if (this.c.E5() == -1) {
            SkinManager.setViewTextColor(this.C, R.color.CAM_X0110, 1);
        }
    }

    public void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048770, this) == null) {
            this.h.f();
            PbFragment pbFragment = this.c;
            if (pbFragment != null) {
                ri.z(pbFragment.getContext(), this.I);
            }
            t1();
            m25 m25Var = this.e0;
            if (m25Var != null) {
                m25Var.dismiss();
            }
            x0();
            d25 d25Var = this.F;
            if (d25Var != null) {
                d25Var.dismiss();
            }
            f25 f25Var = this.G;
            if (f25Var != null) {
                f25Var.e();
            }
        }
    }

    public final boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048785, this)) == null) {
            PbFragment pbFragment = this.c;
            if (pbFragment == null || pbFragment.P().y1().k().getDeletedReasonInfo() == null || 1 != this.c.P().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048786, this) == null) {
            d25 d25Var = this.V;
            if (d25Var != null) {
                d25Var.dismiss();
            }
            Dialog dialog = this.W;
            if (dialog != null) {
                ug.b(dialog, this.c.getPageContext());
            }
            Dialog dialog2 = this.X;
            if (dialog2 != null) {
                ug.b(dialog2, this.c.getPageContext());
            }
            m25 m25Var = this.T;
            if (m25Var != null) {
                m25Var.dismiss();
            }
        }
    }

    public final void L3(SparseArray<Object> sparseArray, int i3, l06 l06Var, UserData userData, boolean z2) {
        PbFragment pbFragment;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048623, this, new Object[]{sparseArray, Integer.valueOf(i3), l06Var, userData, Boolean.valueOf(z2)}) != null) || (pbFragment = this.c) == null) {
            return;
        }
        if (this.z1 == null && this.t != null) {
            this.z1 = new m06(pbFragment.getPageContext(), this.t.c(), l06Var, userData);
        }
        this.z1.F(z2);
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
        h05 h05Var = new h05();
        h05Var.j(sparseArray2);
        this.z1.H(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
        this.z1.G(h05Var);
        if (i3 != 1 && i3 != 2) {
            str = "3";
        } else {
            str = "4";
        }
        this.z1.J(str);
        this.z1.I(new b0(this, sparseArray));
    }

    public void Q3(f25.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{cVar, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5)}) == null) {
            m25 m25Var = this.e0;
            if (m25Var != null) {
                m25Var.dismiss();
                this.e0 = null;
            }
            o25 o25Var = new o25(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            if (!z4 && !z5) {
                arrayList.add(new k25(0, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f04d1), o25Var));
            }
            if (z3) {
                arrayList.add(new k25(1, this.c.getPageContext().getString(R.string.report_text), o25Var));
            } else if (!z2) {
                arrayList.add(new k25(1, this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0bee), o25Var));
            } else {
                arrayList.add(new k25(1, this.c.getPageContext().getString(R.string.remove_mark), o25Var));
            }
            o25Var.l(arrayList);
            o25Var.q(new e0(this, cVar));
            m25 m25Var2 = new m25(this.c.getPageContext(), o25Var);
            this.f0 = m25Var2;
            m25Var2.l();
        }
    }

    public void N3(lx8 lx8Var, int i3, int i4, boolean z2, int i5, boolean z3) {
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
        lx8 lx8Var2;
        Parcelable e3;
        Parcelable e4;
        int size2;
        int i8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048631, this, new Object[]{lx8Var, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2), Integer.valueOf(i5), Boolean.valueOf(z3)}) == null) && lx8Var != null && this.l != null) {
            this.M0 = lx8Var;
            this.O0 = i3;
            if (lx8Var.M() != null) {
                this.c1 = lx8Var.M().getCopyThreadRemindType();
                this.i0 = S1(lx8Var.M());
            }
            if (lx8Var.T() != null) {
                this.X1 = lx8Var.T().getUserId();
            }
            E1(lx8Var);
            j0();
            this.Q0 = false;
            this.L0 = z2;
            o3();
            vx8 vx8Var = lx8Var.h;
            if (vx8Var != null && vx8Var.b()) {
                if (this.o == null) {
                    PbThreadPostView pbThreadPostView = new PbThreadPostView(this.c.getContext());
                    this.o = pbThreadPostView;
                    this.l.w(pbThreadPostView, 1);
                    this.o.setData(lx8Var);
                    this.o.setChildOnClickLinstener(this.P);
                }
            } else {
                PbThreadPostView pbThreadPostView2 = this.o;
                if (pbThreadPostView2 != null && (pbLandscapeListView = this.l) != null) {
                    pbLandscapeListView.removeHeaderView(pbThreadPostView2);
                }
            }
            O3(lx8Var, z2, i3, TbadkCoreApplication.getInst().getSkinType());
            D3(lx8Var);
            this.v.R(lx8Var, this.N0);
            if (this.w1 == null) {
                this.w1 = new y09(this.c.getPageContext(), this.x1);
            }
            this.w1.a(lx8Var.w());
            if (this.c.A5()) {
                if (this.J == null) {
                    j59 j59Var = new j59(this.c.getPageContext());
                    this.J = j59Var;
                    j59Var.n();
                    this.J.f(this.Y1);
                }
                this.l.setPullRefresh(this.J);
                j59 j59Var2 = this.J;
                if (j59Var2 != null) {
                    j59Var2.H(TbadkCoreApplication.getInst().getSkinType());
                }
            } else if (lx8Var.y().c() == 0 && z2) {
                this.l.setPullRefresh(null);
            } else {
                if (this.J == null) {
                    j59 j59Var3 = new j59(this.c.getPageContext());
                    this.J = j59Var3;
                    j59Var3.n();
                    this.J.f(this.Y1);
                }
                this.l.setPullRefresh(this.J);
                j59 j59Var4 = this.J;
                if (j59Var4 != null) {
                    j59Var4.H(TbadkCoreApplication.getInst().getSkinType());
                }
                v1();
            }
            w0();
            this.E.t0(this.L0);
            this.E.q0(false);
            zz8 zz8Var = this.E;
            if (i3 == 5) {
                z4 = true;
            } else {
                z4 = false;
            }
            zz8Var.r0(z4);
            zz8 zz8Var2 = this.E;
            if (i3 == 6) {
                z5 = true;
            } else {
                z5 = false;
            }
            zz8Var2.s0(z5);
            zz8 zz8Var3 = this.E;
            if (z3 && this.V1 && i3 != 2) {
                z6 = true;
            } else {
                z6 = false;
            }
            zz8Var3.o0(z6);
            this.E.l0(lx8Var, false);
            this.E.d0();
            zz8 zz8Var4 = this.E;
            if (lx8Var.y().b() != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            zz8Var4.f0(z7, lx8Var.f());
            this.v.P(lx8Var.V(), lx8Var.h0());
            if (lx8Var.M() != null && lx8Var.M().getPraise() != null && this.b != -1) {
                lx8Var.M().getPraise().setIsLike(this.b);
            }
            this.l.removeFooterView(this.Y0);
            this.l.addFooterView(this.Y0);
            if (TbadkCoreApplication.isLogin()) {
                this.l.setNextPage(this.K);
                this.f = 2;
                v1();
            } else {
                this.Q0 = true;
                if (lx8Var.y().b() == 1) {
                    if (this.L == null) {
                        PbFragment pbFragment2 = this.c;
                        this.L = new e59(pbFragment2, pbFragment2);
                    }
                    this.l.setNextPage(this.L);
                } else {
                    this.l.setNextPage(this.K);
                }
                this.f = 3;
            }
            ArrayList<rr9> F = lx8Var.F();
            if (lx8Var.y().b() != 0 && F != null && F.size() >= lx8Var.y().e()) {
                if (z3) {
                    if (this.V1) {
                        A0();
                        if (lx8Var.y().b() != 0) {
                            this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.K.C();
                        this.K.P();
                    }
                } else {
                    this.K.C();
                    this.K.P();
                }
                this.K.m();
            } else {
                if (ListUtils.getCount(F) != 0 && (ListUtils.getCount(F) != 1 || F.get(0) == null || F.get(0).D() != 1)) {
                    if (lx8Var.y().b() == 0) {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.K.F(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.K.m();
                } else {
                    z0 z0Var = this.b1;
                    if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                        if (this.b1.a.getView().getTop() < 0) {
                            i6 = this.b1.a.getView().getHeight();
                        } else {
                            i6 = this.b1.a.getView().getBottom();
                        }
                    } else {
                        i6 = 0;
                    }
                    if (this.c.c6()) {
                        this.K.x(false);
                        if (ListUtils.isEmpty(lx8Var.P())) {
                            this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f70), i6);
                        }
                    } else if (ListUtils.isEmpty(lx8Var.P())) {
                        this.K.I(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f71), i6);
                    }
                    if (this.c.I5() != null && !this.c.I5().p()) {
                        this.c.I5().x();
                    }
                }
                if (lx8Var.y().b() == 0 || F == null) {
                    J2();
                }
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 == 8) {
                                    if (i4 == 0) {
                                        this.l.setSelection(this.E.D() + this.l.getHeaderViewsCount());
                                    } else if (ListUtils.isEmpty(lx8Var.P())) {
                                        if (this.l.getData() == null && lx8Var.F() == null) {
                                            size2 = 0;
                                        } else {
                                            size2 = (this.l.getData().size() - lx8Var.F().size()) + this.l.getHeaderViewsCount();
                                        }
                                        PbLandscapeListView pbLandscapeListView2 = this.l;
                                        if (i4 > 0) {
                                            i8 = size2 + i4;
                                        } else {
                                            i8 = 0;
                                        }
                                        pbLandscapeListView2.setSelection(i8);
                                    } else {
                                        this.l.setSelection(lx8Var.F().size() + this.l.getHeaderViewsCount());
                                    }
                                    this.K.g();
                                    this.K.F(this.c.getString(R.string.obfuscated_res_0x7f0f0f6a));
                                    this.K.A();
                                }
                            } else if (i5 == 1 && (e4 = e19.b().e()) != null && !(e4 instanceof RecyclerView.SavedState)) {
                                this.l.onRestoreInstanceState(e4);
                            } else {
                                this.l.setSelection(0);
                            }
                        } else {
                            this.l.setSelection(0);
                        }
                    } else {
                        this.V1 = false;
                    }
                } else if (i5 == 1 && (e3 = e19.b().e()) != null && !(e3 instanceof RecyclerView.SavedState)) {
                    this.l.post(new l0(this, e3, F, lx8Var));
                }
            } else {
                if (this.l.getData() == null && lx8Var.F() == null) {
                    size = 0;
                } else {
                    size = (this.l.getData().size() - lx8Var.F().size()) + this.l.getHeaderViewsCount();
                }
                PbLandscapeListView pbLandscapeListView3 = this.l;
                if (i4 > 1) {
                    i7 = (size + i4) - 2;
                } else {
                    i7 = 0;
                }
                pbLandscapeListView3.setSelection(i7);
            }
            if (this.c1 == d2 && Q1()) {
                q0();
            }
            if (this.h1) {
                D2();
                this.h1 = false;
                if (i5 == 0) {
                    e3(true);
                }
            }
            if (lx8Var.d == 1 || lx8Var.e == 1) {
                if (this.n1 == null) {
                    this.n1 = new PbTopTipView(this.c.getContext());
                }
                if (lx8Var.e == 1 && "game_guide".equals(this.c.M5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0f7c));
                    this.n1.l(this.d, this.P0);
                } else if (lx8Var.d == 1 && "game_news".equals(this.c.M5())) {
                    this.n1.setText(this.c.getString(R.string.obfuscated_res_0x7f0f0f7b));
                    this.n1.l(this.d, this.P0);
                }
            }
            this.l.removeFooterView(this.H1.a());
            if (!ListUtils.isEmpty(lx8Var.H()) && lx8Var.y().b() == 0) {
                this.l.removeFooterView(this.Y0);
                this.H1.d(Math.max(this.u0.getMeasuredHeight(), this.J0 / 2));
                this.l.addFooterView(this.H1.a());
                this.H1.f(lx8Var);
            }
            F2(lx8Var);
            if (lx8Var.f0() && this.c.P().p2() && this.c.J5() != null) {
                this.c.J5().d();
            }
            if (lx8Var.f() != 3) {
                I1(lx8Var);
            }
            this.x0.setText(TbSingleton.getInstance().getAdVertiComment(lx8Var.o0(), lx8Var.p0(), i1()));
            if (this.p != null && (lx8Var2 = this.M0) != null && lx8Var2.k() != null) {
                this.p.m(this.M0.k().getImage_url());
                this.p.n(this.M0.k().getName());
                PbFragment pbFragment3 = this.c;
                if (pbFragment3 != null && pbFragment3.P() != null) {
                    this.p.o(this.c.P().b);
                }
            }
            if (this.r != null) {
                lx8 lx8Var3 = this.M0;
                if (lx8Var3 != null && lx8Var3.k() != null && (pbFragment = this.c) != null && pbFragment.P() != null) {
                    this.r.r(this.c.P().b);
                }
                lx8 lx8Var4 = this.M0;
                if (lx8Var4 != null && lx8Var4.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.M0.M().getThreadRecommendInfoDataList().get(0).businessType != 1) {
                    this.r.q(this.M0.M().getThreadRecommendInfoDataList().get(0));
                } else {
                    this.r.q(null);
                }
            }
            if (v3()) {
                this.z.e(this.M0.M());
            } else {
                this.z.d(this.l);
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void O3(lx8 lx8Var, boolean z2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{lx8Var, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && lx8Var != null && lx8Var.M() != null) {
            PbFragment pbFragment = this.c;
            if (pbFragment != null && n19.D(pbFragment)) {
                this.v.G(this.l);
                this.u.h(this.l);
            }
            if (this.c.y0()) {
                if (lx8Var.g() != null) {
                    this.j0 = lx8Var.g().d();
                    this.k0 = lx8Var.g().b();
                }
                if (this.j0 == null && this.c.P() != null && this.c.P().X0() != null) {
                    this.j0 = this.c.P().X0();
                }
            }
            rr9 V = lx8Var.V();
            m3(V, lx8Var);
            int i5 = 8;
            this.v.M(8);
            int i6 = 1;
            if (lx8Var.v0()) {
                this.j1 = true;
                this.h.u(true);
                this.h.a.hideBottomLine();
            } else {
                this.j1 = false;
                this.h.u(false);
            }
            if (this.c.I5() != null) {
                this.c.I5().w(this.j1);
            }
            if (V == null) {
                return;
            }
            this.N0 = V;
            this.v.M(0);
            this.w.e(lx8Var, this.l);
            this.y.e(lx8Var, this.D1, new i0(this));
            this.u.j(lx8Var);
            this.t.h(lx8Var, this.L0);
            this.t.g(lx8Var);
            this.v.N(this.P0, this.M0, V, this.W1);
            if (this.X0 != null) {
                if (lx8Var.h0()) {
                    this.X0.getView().setVisibility(8);
                } else {
                    this.X0.getView().setVisibility(0);
                    zx8 zx8Var = new zx8(zx8.g);
                    zx8Var.b = lx8Var.g;
                    zx8Var.c = this.c.c6();
                    zx8Var.e = lx8Var.f;
                    zx8Var.f = lx8Var.M().isQuestionThread();
                    this.X0.i(zx8Var);
                }
            }
            a4(V);
            b4(lx8Var);
            sg.a().post(new j0(this));
            this.x.f(this.l);
            if (V.S) {
                this.x.g(V.O());
                PbLandscapeListView pbLandscapeListView = this.l;
                this.x.c(this.l, (pbLandscapeListView == null || pbLandscapeListView.getHeaderViewsCount() <= 1) ? 0 : 0);
            }
            zz8 zz8Var = this.E;
            if (zz8Var != null && zz8Var.B() != null) {
                this.E.B().I(V.S);
            }
            zz8 zz8Var2 = this.E;
            if (zz8Var2 != null) {
                zz8Var2.w0(V.S);
            }
            MaskView maskView = this.I1;
            if (V.S) {
                i5 = 0;
            }
            maskView.setVisibility(i5);
        }
    }

    public void P3(f25.c cVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048639, this, cVar, z2) == null) {
            m25 m25Var = this.f0;
            if (m25Var != null) {
                m25Var.dismiss();
                this.f0 = null;
            }
            o25 o25Var = new o25(this.c.getContext());
            ArrayList arrayList = new ArrayList();
            lx8 lx8Var = this.M0;
            if (lx8Var != null && lx8Var.M() != null && !this.M0.M().isBjh()) {
                arrayList.add(new k25(0, this.c.getPageContext().getString(R.string.save_to_emotion), o25Var));
            }
            if (!z2) {
                arrayList.add(new k25(1, this.c.getPageContext().getString(R.string.save_to_local), o25Var));
            }
            o25Var.l(arrayList);
            o25Var.q(new f0(this, cVar));
            m25 m25Var2 = new m25(this.c.getPageContext(), o25Var);
            this.f0 = m25Var2;
            m25Var2.l();
        }
    }

    public final void X1() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && (pbFragment = this.c) != null && pbFragment.P() != null && this.c.P().G != null && this.c.P().G.M() != null && this.c.P().G.M().isQuestionThread()) {
            ThreadData M = this.c.P().G.M();
            String K1 = this.c.P().K1();
            String L1 = this.c.P().L1();
            int i3 = 5;
            if ("question_answer_invite".equals(K1)) {
                i3 = 1;
            } else if ("3".equals(L1)) {
                i3 = 2;
            } else if ("answer_top".equals(K1)) {
                i3 = 3;
            } else if (this.c.P().d1()) {
                i3 = 4;
            }
            TiebaStatic.log(new StatisticItem("c14924").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("tid", M.getId()).param("fid", M.getFid()).param("obj_source", i3));
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048677, this) == null) && UbsABTestHelper.isShareTopRight()) {
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
            relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds138), -2));
            relativeLayout.addView(this.C0);
            relativeLayout.addView(this.D0);
            relativeLayout.addView(this.E0);
            this.h.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, relativeLayout, (View.OnClickListener) null);
            this.h.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT).setClipChildren(false);
        }
    }

    public final void m0() {
        lx8 lx8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048736, this) == null) && this.z != null && (lx8Var = this.M0) != null && lx8Var.M() != null && !ListUtils.isEmpty(this.M0.M().getThreadRecommendInfoDataList()) && this.M0.M().getThreadRecommendInfoDataList().get(0) != null && this.u.b().getVisibility() == 0) {
            if (this.u.b().getParent() == null) {
                this.z.g(false);
                return;
            }
            int[] iArr = new int[2];
            this.z.b().getLocationInWindow(iArr);
            if (iArr[1] + this.z.b().getHeight() > this.h.j().getBottom()) {
                this.z.i();
                this.z.g(true);
                return;
            }
            this.z.g(false);
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048756, this) == null) && !this.b2) {
            TiebaStatic.log("c10490");
            this.b2 = true;
            d25 d25Var = new d25(this.c.getPageContext().getPageActivity());
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(e2, Integer.valueOf(g2));
            d25Var.setTitle(R.string.grade_thread_tips);
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.upgrade_success_dialog_content, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.function_description_view)).setText(R.string.function_upgrade_to_photo_live_tips);
            ((TextView) inflate.findViewById(R.id.title_view)).setText(R.string.grade_thread_tips);
            d25Var.setContentView(inflate);
            d25Var.setYesButtonTag(sparseArray);
            d25Var.setPositiveButton(R.string.grade_button_tips, this.c);
            d25Var.setNegativeButton(R.string.look_again, new p0(this));
            d25Var.create(this.c.getPageContext()).show();
        }
    }

    public final void x3() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048789, this) == null) && (pbFragment = this.c) != null && pbFragment.getActivity() != null) {
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
                int g3 = ri.g(this.c.getActivity(), R.dimen.tbds166);
                int i3 = ((rect2.right + rect2.left) / 2) - g3;
                int i4 = (rect.bottom - ((rect2.bottom + rect2.top) / 2)) - g3;
                int i5 = g3 * 2;
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

    public SparseArray<Object> Y0(lx8 lx8Var, boolean z2, int i3) {
        InterceptResult invokeCommon;
        rr9 V;
        boolean z3;
        pz4 pz4Var;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048672, this, new Object[]{lx8Var, Boolean.valueOf(z2), Integer.valueOf(i3)})) == null) {
            StringBuilder sb = null;
            if (lx8Var == null || (V = lx8Var.V()) == null) {
                return null;
            }
            String userId = V.p().getUserId();
            if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
            } else {
                z3 = false;
            }
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i3 == 0) {
                sparseArray.put(R.id.tag_del_post_id, V.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(lx8Var.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            } else if (i3 == 1) {
                if (V.p() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, V.p().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, V.p().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, V.p().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, V.O());
                }
                sparseArray.put(R.id.tag_del_post_id, V.O());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(lx8Var.U()));
                sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            }
            if (!z3) {
                List<k15> o2 = lx8Var.o();
                if (ListUtils.getCount(o2) > 0) {
                    sb = new StringBuilder();
                    for (k15 k15Var : o2) {
                        if (k15Var != null && !StringUtils.isNull(k15Var.d()) && (pz4Var = k15Var.f) != null && pz4Var.a && !pz4Var.c && ((i4 = pz4Var.b) == 1 || i4 == 2)) {
                            sb.append(qi.cutString(k15Var.d(), 12));
                            sb.append(this.c.getString(R.string.obfuscated_res_0x7f0f0730));
                            sb.append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(this.c.getString(R.string.obfuscated_res_0x7f0f052d), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public void c2(int i3) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048690, this, i3) != null) || this.P0 == i3) {
            return;
        }
        this.P0 = i3;
        c4(this.M0, this.L0);
        H2(this.M0, this.L0, this.O0, i3);
        hx4 layoutMode = this.c.getBaseFragmentActivity().getLayoutMode();
        if (i3 == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        layoutMode.l(z2);
        this.c.getBaseFragmentActivity().getLayoutMode().k(this.d);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.p0, R.color.CAM_X0203);
        i29 i29Var = this.w;
        if (i29Var != null) {
            i29Var.c(i3);
        }
        h29 h29Var = this.t;
        if (h29Var != null) {
            h29Var.e(i3);
        }
        j29 j29Var = this.u;
        if (j29Var != null) {
            j29Var.g(i3);
        }
        l29 l29Var = this.v;
        if (l29Var != null) {
            l29Var.C(i3);
        }
        k29 k29Var = this.x;
        if (k29Var != null) {
            k29Var.e();
        }
        g29 g29Var = this.y;
        if (g29Var != null) {
            g29Var.c();
        }
        MaskView maskView = this.I1;
        if (maskView != null) {
            maskView.f();
        }
        k19 k19Var = this.r;
        if (k19Var != null) {
            k19Var.o();
        }
        PbContentCollectionController pbContentCollectionController = this.z;
        if (pbContentCollectionController != null) {
            pbContentCollectionController.c();
        }
        PbListView pbListView = this.K;
        if (pbListView != null) {
            pbListView.e(i3);
        }
        if (this.M != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.M);
            SkinManager.setBackgroundResource(this.M, R.drawable.pb_foot_more_trans_selector);
        }
        if (this.N != null) {
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.N);
            SkinManager.setBackgroundResource(this.N, R.drawable.pb_foot_more_trans_selector);
        }
        d25 d25Var = this.F;
        if (d25Var != null) {
            d25Var.autoChangeSkinType(this.c.getPageContext());
        }
        i4(this.h0);
        this.E.d0();
        j59 j59Var = this.J;
        if (j59Var != null) {
            j59Var.H(i3);
        }
        EditorTools editorTools = this.n0;
        if (editorTools != null) {
            editorTools.y(i3);
        }
        e59 e59Var = this.L;
        if (e59Var != null) {
            e59Var.g(i3);
        }
        if (!ListUtils.isEmpty(this.n)) {
            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.n) {
                customBlueCheckRadioButton.c();
            }
        }
        o4();
        UtilHelper.setStatusBarBackground(this.e, i3);
        UtilHelper.setStatusBarBackground(this.W0, i3);
        if (this.A != null) {
            cp5.a(this.c.getPageContext(), this.A);
        }
        k09 k09Var = this.g1;
        if (k09Var != null) {
            k09Var.l(i3);
        }
        w39 w39Var = this.h;
        if (w39Var != null) {
            w39Var.p(i3);
        }
        LinearLayout linearLayout = this.v0;
        if (linearLayout != null) {
            linearLayout.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(ri.g(this.c.getContext(), R.dimen.tbds47), SkinManager.getColor(R.color.CAM_X0209)));
        }
        lx8 lx8Var = this.M0;
        if (lx8Var != null && lx8Var.q()) {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.setPureDrawable(this.B0, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.setPureDrawable(this.z0, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        WebPManager.setPureDrawable(this.w0, R.drawable.icon_pure_post_expression24, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
        m4(this.M0);
        if (this.E0.getVisibility() == 0) {
            this.E0.setBackgroundDrawable(SkinManager.createShapeDrawable(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds15), R.color.CAM_X0301, 0, 0, i3));
        }
        SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this.t0, R.color.CAM_X0203);
        SkinManager.setViewTextColor(this.p1, (int) R.color.cp_cont_n);
        SkinManager.setViewTextColor(this.x0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.H0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.H0, ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.G0, (int) R.color.CAM_X0107);
        SkinManager.setBackgroundShapeDrawable(this.G0, ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        AgreeView agreeView = this.A0;
        if (agreeView != null) {
            agreeView.w();
            this.A0.P(i3);
            AgreeData data = this.A0.getData();
            if (data != null) {
                E2(data, data.agreeNum);
            }
        }
        nz8 nz8Var = this.s1;
        if (nz8Var != null) {
            nz8Var.m(i3);
        }
        PbThreadPostView pbThreadPostView = this.o;
        if (pbThreadPostView != null) {
            pbThreadPostView.c(i3);
        }
        i59 i59Var = this.F0;
        if (i59Var != null) {
            i59Var.j();
        }
        h59 h59Var = this.H1;
        if (h59Var != null) {
            h59Var.c();
        }
        RightFloatLayerView rightFloatLayerView = this.K1;
        if (rightFloatLayerView != null) {
            rightFloatLayerView.n();
        }
        SkinManager.setBackgroundColor(this.V0, R.color.CAM_X0207);
        SkinManager.setViewTextColor(this.V0.findViewById(R.id.tv_title), (int) R.color.CAM_X0105);
        LinearLayout linearLayout2 = this.M1;
        if (linearLayout2 != null) {
            p45.d(linearLayout2).f(R.color.CAM_X0201);
        }
        k39 k39Var = this.N1;
        if (k39Var != null) {
            k39Var.b(i3);
        }
    }

    public final boolean f0(AbsListView absListView, int i3) {
        InterceptResult invokeLI;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048701, this, absListView, i3)) == null) {
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

    public void n3(boolean z2, PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048744, this, z2, postWriteCallBackData) == null) {
            this.c.hideProgressBar();
            if (z2) {
                t0();
            } else if (postWriteCallBackData != null && (postWriteCallBackData.isSensitiveError() || postWriteCallBackData.isErrorLinkCountExceedLimit() || postWriteCallBackData.isErrorShowApplyMemberDialog())) {
                u0();
            } else {
                t0();
            }
        }
    }

    public final CustomBlueCheckRadioButton p0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048751, this, str, str2)) == null) {
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, ri.g(pageActivity, R.dimen.obfuscated_res_0x7f07019a));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.a0);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void o2(AbsListView absListView, int i3, int i4, int i5) {
        boolean z2;
        PbReplyTitleViewHolder pbReplyTitleViewHolder;
        int bottom;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048748, this, absListView, i3, i4, i5) == null) {
            n09 n09Var = this.q;
            if (n09Var != null) {
                n09Var.c(i3, i4);
            }
            j19 j19Var = this.s;
            if (j19Var != null) {
                j19Var.c(i3, i4);
            }
            w39 w39Var = this.h;
            if (w39Var != null && this.v != null) {
                w39Var.q(absListView, i3, i4, i5);
            }
            A2();
            this.b1.a = null;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004013, this.b1));
            int i6 = 0;
            if (f0(absListView, i3) && !this.h.o()) {
                z2 = true;
            } else {
                z2 = false;
            }
            B3(z2);
            B2(this.b1.a, false);
            s0();
            if (this.K.p() && !this.K.A) {
                z0 z0Var = this.b1;
                if (z0Var != null && (pbReplyTitleViewHolder = z0Var.a) != null && pbReplyTitleViewHolder.getView() != null) {
                    if (this.b1.a.getView().getTop() < 0) {
                        bottom = this.b1.a.getView().getHeight();
                    } else {
                        bottom = this.b1.a.getView().getBottom();
                    }
                    i6 = bottom;
                }
                this.K.f(i6);
                this.K.A = true;
            }
        }
    }

    public void q2(ArrayList<xz4> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, arrayList) == null) {
            if (this.Y == null) {
                this.Y = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.c.getBaseFragmentActivity().getLayoutMode().k(this.Y);
            if (this.X == null) {
                Dialog dialog = new Dialog(this.c.getPageContext().getPageActivity(), R.style.obfuscated_res_0x7f1003bd);
                this.X = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.X.setCancelable(true);
                this.m0 = (ScrollView) this.Y.findViewById(R.id.good_scroll);
                this.X.setContentView(this.Y);
                WindowManager.LayoutParams attributes = this.X.getWindow().getAttributes();
                attributes.width = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0703e4);
                this.X.getWindow().setAttributes(attributes);
                this.a0 = new c0(this);
                this.Z = (LinearLayout) this.Y.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.Y.findViewById(R.id.dialog_button_cancel);
                this.c0 = textView;
                textView.setOnClickListener(new d0(this));
                TextView textView2 = (TextView) this.Y.findViewById(R.id.dialog_button_ok);
                this.b0 = textView2;
                textView2.setOnClickListener(this.P);
            }
            this.Z.removeAllViews();
            this.n = new ArrayList();
            CustomBlueCheckRadioButton p02 = p0("0", this.c.getPageContext().getString(R.string.thread_good_class));
            this.n.add(p02);
            p02.setChecked(true);
            this.Z.addView(p02);
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    xz4 xz4Var = arrayList.get(i3);
                    if (xz4Var != null && !TextUtils.isEmpty(xz4Var.b()) && xz4Var.a() > 0) {
                        CustomBlueCheckRadioButton p03 = p0(String.valueOf(xz4Var.a()), xz4Var.b());
                        this.n.add(p03);
                        View view2 = new View(this.c.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070198));
                        SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
                        view2.setLayoutParams(layoutParams);
                        this.Z.addView(view2);
                        this.Z.addView(p03);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.m0.getLayoutParams();
                int size = arrayList.size();
                if (size != 0 && size != 1) {
                    if (size != 2) {
                        layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 220.0f);
                    } else {
                        layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 186.0f);
                    }
                } else {
                    layoutParams2.height = ri.d(this.c.getPageContext().getPageActivity(), 120.0f);
                }
                this.m0.setLayoutParams(layoutParams2);
                this.m0.removeAllViews();
                LinearLayout linearLayout = this.Z;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.m0.addView(this.Z);
                }
            }
            ug.j(this.X, this.c.getPageContext());
        }
    }

    public void s2(int i3, String str, int i4, boolean z2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048768, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2}) == null) {
            t2(i3, str, i4, z2, str2, false);
        }
    }

    public void t2(int i3, String str, int i4, boolean z2, String str2, boolean z3) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048772, this, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Boolean.valueOf(z2), str2, Boolean.valueOf(z3)}) == null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i4));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
            sparseArray.put(e2, Integer.valueOf(f2));
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
            this.V = new d25(this.c.getActivity());
            if (StringUtils.isNull(str2)) {
                this.V.setMessageId(i5);
            } else {
                this.V.setOnlyMessageShowCenter(false);
                this.V.setMessage(str2);
            }
            this.V.setYesButtonTag(sparseArray);
            this.V.setPositiveButton(R.string.obfuscated_res_0x7f0f0584, this.c);
            this.V.setNegativeButton(R.string.obfuscated_res_0x7f0f057a, new v(this));
            this.V.setCancelable(true);
            this.V.create(this.c.getPageContext());
            if (z3) {
                E3(sparseArray, i6, i5);
            } else if (z2) {
                E3(sparseArray, i6, i5);
            } else if (w3()) {
                l06 l06Var = new l06(this.c.P().y1().k().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.c.P().y1().k().getDeletedReasonInfo().is_boomgrow.intValue(), this.c.P().y1().n().has_forum_rule.intValue());
                l06Var.i(this.c.P().y1().k().getId(), this.c.P().y1().k().getName());
                l06Var.h(this.c.P().y1().k().getImage_url());
                l06Var.j(this.c.P().y1().k().getUser_level());
                L3(sparseArray, i3, l06Var, this.c.P().y1().T(), false);
            } else {
                T3(this.V, i3);
            }
        }
    }
}
